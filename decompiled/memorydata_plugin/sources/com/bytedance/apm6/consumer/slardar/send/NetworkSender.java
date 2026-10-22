package com.bytedance.apm6.consumer.slardar.send;

import android.app.Application;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.bytedance.apm.doctor.DoctorManager;
import com.bytedance.apm.doctor.a;
import com.bytedance.apm6.consumer.slardar.Constants;
import com.bytedance.apm6.consumer.slardar.SlardarResponseService;
import com.bytedance.apm6.consumer.slardar.send.downgrade.DowngradeController;
import com.bytedance.apm6.consumer.slardar.send.downgrade.DowngradeInfo;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.service.ServiceManager;
import com.bytedance.apm6.service.encrypt.EncryptService;
import com.bytedance.apm6.service.http.HttpRequest;
import com.bytedance.apm6.util.IOUtils;
import com.bytedance.apm6.util.JsonUtils;
import com.bytedance.apm6.util.ListUtils;
import com.bytedance.apm6.util.UrlUtils;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.apm6.util.constant.ReportConsts;
import com.bytedance.apm6.util.log.Logger;
import com.bytedance.crypto.utils.CryptoConst;
import com.bytedance.news.common.service.manager.d;
import com.bytedance.services.apm.api.c;
import com.bytedance.services.apm.api.e;
import com.bytedance.services.apm.api.i;
import com.bytedance.services.apm.api.j;
import com.bytedance.services.slardar.config.IConfigManager;
import com.obric.aiproactive.impl.livecard.ProactiveLiveCardDisplayTool;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPOutputStream;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class NetworkSender {
    private static final String FORCE_ZSTD_TIMESTAMP = "force_zstd_timestamp";
    private static final String HEADER_LEVEL = "Content-Encoding-Level";
    private static final int LEVEL = 15;
    private static final int MIN_COMPRESS_LEN = 128;
    private static final String RESPONSE_DELAY = "delay";
    private static final String RESPONSE_DOWNGRADE_RULE = "downgrade_rule";
    private static final String RESPONSE_MESSAGE = "message";
    private static final String RESPONSE_MESSAGE_DROP_DATA = "drop data";
    private static final String RESPONSE_MESSAGE_SUCCESS = "success";
    private static final String RESPONSE_REDIRECT = "redirect";
    private static final String RESPONSE_SERVER_CODE = "server_code";
    private static final long SERVER_CODE_ZSTD_DICT_FIND_FAILED = 10001;
    private static final String TT_LOG_ID = "x-tt-logid";
    private static volatile int compressType;
    private static HashMap<UploadLogInfo, NetworkSender> map;
    private int callstackDepth;
    private int channelPosition;
    private String lastChannelUrl;
    private volatile boolean moreChannelSwitch;
    private Boolean preNetworkError;
    private String redirectHost;
    private List<String> urls;
    private j zstdDict;
    private i zstdService;

    static {
        map = new HashMap();
    }

    private NetworkSender(UploadLogInfo r3) {
        UploadLogInfo r4 = (UploadLogInfo) ZeusTransformUtils.wrapperContextForParams(r3, UploadLogInfo.class, "com.obric.memorydata.plugin");
        this.lastChannelUrl = null;
        this.callstackDepth = 0;
        this.urls = r4.getUrls();
    }

    private byte[] compress(byte[] r3) {
        ByteArrayOutputStream r2 = new ByteArrayOutputStream(8192);
        GZIPOutputStream r0 = null;
        GZIPOutputStream r1 = new GZIPOutputStream(r2);     // Catch: Throwable -> L9 IOException -> L12
        r1.write(r3);     // Catch: Throwable -> L7 IOException -> L15
        IOUtils.closeQuietly(r1);
        return r2.toByteArray();
    L7:
        th = th;
        r0 = r1;
    L10:
        IOUtils.closeQuietly(r0);
        throw th;
    L13:
        IOUtils.closeQuietly(r1);
        return null;
    L12:
        r1 = null;
    L9:
        th = th;
        goto L10
    }

    private HttpRequest createRequest(String r11, byte[] r12, boolean r13) {
        HashMap r0 = new HashMap();
        HashMap r1 = new HashMap(ApmContext.getUrlParams());
        r0.put(NetConst.KEY_ACCEPT_ENCODING, NetConst.GZIP);
        byte[] r4 = null;
        if (r12.length > 128) goto L5;
    L38:
        if (r4 == null) goto L41;
        r12 = r4;
    L41:
        r0.put(NetConst.KEY_CONTENT_TYPE, "application/json; charset=utf-8");
        if (LogReportController.getInstance().isEncrypt() == false) goto L55;
        byte[] r2 = encrypt(r12);
        if (r2 == null) goto L55;
        r1.put("tt_data", "a");
        String r14 = UrlUtils.addParamsToURL(r11, r1);
        r0.put(NetConst.KEY_CONTENT_TYPE, "application/octet-stream;tt-data=a");
        if (ApmContext.isDebugMode() == false) goto L48;
        Logger.d(Constants.TAG, "before encrypt url:" + r14);
    L48:
        LinkedList r15 = new LinkedList();
        String r10 = tryEncryptRequest(r14, r15);
        if (TextUtils.isEmpty(r10) == true) goto L52;
        r14 = r10;
    L52:
        if (ApmContext.isDebugMode() == false) goto L54;
        Logger.d(Constants.TAG, "after encrypt url:" + r14);
    L54:
        r0.putAll(ListUtils.listToMap(r15));
        r12 = r2;
    L56:
        r0.put(NetConst.KEY_REQUSET_VERISON_CODE, "1");
        return new HttpRequest(r14, r0, r12);
    L55:
        r14 = UrlUtils.addParamsToURL(r11, r1);
        goto L56
    L5:
        if (r13 == false) goto L7;
    L34:
        if (r4 != null) goto L38;
        r4 = compress(r12);
        if (r4 == null) goto L38;
        r0.put(NetConst.KEY_CONTENT_ENCODING, NetConst.GZIP);
        goto L38
    L7:
        if (this.zstdService != null) goto L10;
        this.zstdService = (i) ZeusTransformUtils.preCheckCast(ServiceManager.getService(i.class), i.class, "com.obric.memorydata.plugin");
    L10:
        if (compressType != 1) goto L18;
        i r16 = this.zstdService;
        if (r16 == null) goto L18;
        byte[] r17 = r16.a(r12, 15);
        if (r17 == null) goto L16;
        r0.put(NetConst.KEY_CONTENT_ENCODING, NetConst.TYPE_ZSTD);
        r0.put(HEADER_LEVEL, String.valueOf(15));
    L16:
        r4 = r17;
    L18:
        if (compressType != 2) goto L34;
        if (this.zstdService == null) goto L34;
        if (this.zstdDict != null) goto L24;
        this.zstdDict = (j) ZeusTransformUtils.preCheckCast(ServiceManager.getService(j.class), j.class, "com.obric.memorydata.plugin");
    L24:
        j r18 = this.zstdDict;
        if (r18 == null) goto L29;
        Pair<byte[], String> r19 = r18.a();
        byte[] r6 = (byte[]) ZeusTransformUtils.preCheckCast(r19.first, byte[].class, "com.obric.memorydata.plugin");
        String r110 = (String) ZeusTransformUtils.preCheckCast(r19.second, String.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L30;
        r4 = this.zstdService.a(r12, r6, 15);
    L30:
        if (r4 == null) goto L34;
        r0.put(NetConst.KEY_CONTENT_ENCODING, NetConst.TYPE_ZSTD_DICT);
        r0.put(HEADER_LEVEL, String.valueOf(15));
        if (TextUtils.isEmpty(r110) == true) goto L34;
        r0.put("slardar-zstd-version", r110);
        r1.put("slardar-zstd-version", r110);
        goto L34
    L29:
        r110 = null;
        goto L30
    }

    private String decodeData(byte[] r3, String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L12;
        return "";
    L12:
        SecretKeySpec r2 = new SecretKeySpec(r4.getBytes(), CryptoConst.ALGORITHM_AES);     // Catch: Throwable -> L7
        Cipher r5 = Cipher.getInstance("AES/ECB/NoPadding");     // Catch: Throwable -> L7
        r5.init(2, r2);     // Catch: Throwable -> L7
        return new String(r5.doFinal(Base64.decode(r3, 0))).replaceAll("\\$+$", "");
    L7:
        th = move-exception;
        if (ApmContext.isDebugMode() == false) goto L11;
        Logger.e(Constants.TAG, "decodeData", th);
    L11:
        return "";
    }

    private byte[] encrypt(byte[] r3) {
        e r2 = (e) ZeusTransformUtils.preCheckCast(ServiceManager.getService(e.class), e.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L5;
        return null;
    L5:
        return r2.a(r3);
    }

    private JSONObject getData(c r8) {
        JSONObject r4 = new JSONObject(new String(r8.b()));     // Catch: Exception -> L26
        Map<String, String> r9 = r8.c();     // Catch: Exception -> L26
        if (r9 != null) goto L6;
    L11:
        String r5 = null;
    L12:
        boolean r10 = true;
        String r1 = r4.optString("data");     // Catch: Throwable -> L24
        if (r1.isEmpty() == false) goto L16;
    L19:
        handleResponse(r4);     // Catch: Throwable -> L24
        if (r10 == true) goto L23;
        JSONObject r7 = new JSONObject();     // Catch: Throwable -> L24
        r7.put("message", "success");     // Catch: Throwable -> L24
        return r7;
    L23:
        return r4;
    L16:
        if (TextUtils.isEmpty(r5) == true) goto L18;
        String r2 = decodeData(r1.getBytes(), r5);     // Catch: Throwable -> L24
        r4 = new JSONObject(r2);     // Catch: Throwable -> L24
        r10 = true ^ TextUtils.isEmpty(r2);     // Catch: Throwable -> L24
        goto L19
    L18:
        r4 = new JSONObject(new String(r1.getBytes()));     // Catch: Throwable -> L24
    L24:
        JSONObject r11 = new JSONObject();     // Catch: Exception -> L26
        r11.put("message", "success");     // Catch: Exception -> L26
        return r11;
    L6:
        if (r9.isEmpty() == true) goto L11;
        r5 = (String) ZeusTransformUtils.preCheckCast(r9.get(CommonConsts.KEY_DECODE), String.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L26
        if (TextUtils.isEmpty(r5) == false) goto L12;
        r5 = (String) ZeusTransformUtils.preCheckCast(r9.get(CommonConsts.KEY_DECODE_RAN), String.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L26
    L26:
        return null;
    }

    public static NetworkSender getInstance(UploadLogInfo r4) {
        UploadLogInfo r5 = (UploadLogInfo) ZeusTransformUtils.wrapperContextForParams(r4, UploadLogInfo.class, "com.obric.memorydata.plugin");
        if (map.containsKey(r5) == true) goto L5;
        map.put(r5, new NetworkSender(r5));
    L5:
        return (NetworkSender) ZeusTransformUtils.preCheckCast(map.get(r5), NetworkSender.class, "com.obric.memorydata.plugin");
    }

    private String getReportUrl() {
        List<String> r0 = this.urls;
        if (TextUtils.isEmpty(this.redirectHost) == true) goto L13;
        if (r0 != null) goto L7;
    L11:
        return null;
    L7:
        if (r0.size() <= 0) goto L11;
        return ReportConsts.HTTPS + this.redirectHost + new URL((String) ZeusTransformUtils.preCheckCast(r0.get(0), String.class, "com.obric.memorydata.plugin")).getPath();
    L13:
        if (TextUtils.isEmpty(this.lastChannelUrl) == true) goto L17;
        return this.lastChannelUrl;
    L17:
        if (this.moreChannelSwitch == false) goto L19;
        this.channelPosition++;
    L19:
        int r1 = r0.size();
        int r4 = this.channelPosition;
        if (r1 <= r4) goto L23;
        if (r4 < 0) goto L23;
        String r5 = r0.get(r4);
    L25:
        return (String) ZeusTransformUtils.preCheckCast(r5, String.class, "com.obric.memorydata.plugin");
    L23:
        this.channelPosition = 0;
        r5 = r0.get(0);
        goto L25
    }

    private void handleResponse(JSONObject r3) {
        if (JsonUtils.isEmpty(r3) == false) goto L5;
        return;
    L5:
        JSONObject r2 = r3.optJSONObject("configs");
        if (JsonUtils.isEmpty(r2) == false) goto L8;
        return;
    L8:
        SlardarResponseService r4 = (SlardarResponseService) ZeusTransformUtils.preCheckCast(ServiceManager.getService(SlardarResponseService.class), SlardarResponseService.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L12;
        r4.onResponse(r2);
        return;
    }

    public static void restart() {
        map.clear();
    }

    public static void setCompressType(int r4) {
        if (r4 != 2) goto L8;
        long r0 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ApmContext.getContext(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin")).getSharedPreferences("dict_interval", 0).getLong(FORCE_ZSTD_TIMESTAMP, 0);
        if ((System.currentTimeMillis() - r0) > ProactiveLiveCardDisplayTool.DEFAULT_AUTO_DISMISS_DURATION_MS) goto L8;
        compressType = 1;
        return;
    L8:
        compressType = r4;
    }

    private String tryEncryptRequest(String r3, List<Pair<String, String>> r4) {
        List<Pair<String, String>> r2 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        EncryptService r5 = (EncryptService) ZeusTransformUtils.preCheckCast(ServiceManager.getService(EncryptService.class), EncryptService.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L5;
        return null;
    L5:
        return r5.tryEncryptRequest(r3, r2);
    }

    private void updateZstdHost(String r4) {
        if (this.zstdDict != null) goto L6;
        this.zstdDict = (j) ZeusTransformUtils.preCheckCast(ServiceManager.getService(j.class), j.class, "com.obric.memorydata.plugin");
    L6:
        if (this.zstdDict == null) goto L12;
        URL r0 = new URL(r4);     // Catch: MalformedURLException -> L9
        this.zstdDict.a(r0.getHost());     // Catch: MalformedURLException -> L9
        return;
    L13:
        return;
    }

    byte[] appendSettingsParams(byte[] r4) {
        JSONObject r3 = new JSONObject(new String(r4));
        IConfigManager r5 = (IConfigManager) ZeusTransformUtils.preCheckCast(d.a(IConfigManager.class), IConfigManager.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L10;
        JSONObject r6 = r5.retrieveSettingsParams();
        JSONObject r0 = new JSONObject();
        String r1 = String.valueOf(ApmContext.getAid());
        if (TextUtils.isEmpty(r1) == true) goto L10;
        if (r1.equals("0") == true) goto L10;
        r0.put(r1, r6);
        r3.put("settings_params", r0);
    L10:
        return r3.toString().getBytes();
    }

    boolean sendLog(byte[] r22) {
        if (r22 == null) goto L115;
        if (r22.length == 0) goto L115;
        String r7 = getReportUrl();     // Catch: Throwable -> L111
        updateZstdHost(r7);     // Catch: Throwable -> L111
        byte[] r0 = appendSettingsParams(r22);     // Catch: JSONException -> L11 Throwable -> L111
    L14:
        HttpRequest r2 = createRequest(r7, r0, false);     // Catch: Throwable -> L111
        if (ApmContext.isDebugMode() == false) goto L18;
        DoctorManager.getInstance().a("APM_SEND_DATA", "url:" + r2.url + " header:" + r2.headerMap);     // Catch: Throwable -> L111
        Logger.d(Constants.TAG, "sendLog createRequest: origin Bytes=" + r0.length + " compressed Bytes=" + r2.data.length + " url=" + r2.url + " headers=" + r2.headerMap);     // Catch: Throwable -> L111
    L18:
        c r8 = ApmContext.doPost(r2.url, r2.headerMap, r2.data);     // Catch: Throwable -> L111
        if (ApmContext.isDebugMode() == false) goto L25;
        String r10 = Constants.TAG;     // Catch: Throwable -> L111
        StringBuilder r11 = new StringBuilder().append("http result:");     // Catch: Throwable -> L111
        if (r8 != null) goto L23;
        Object r9 = -1;     // Catch: Throwable -> L111
    L24:
        Logger.d(r10, r11.append(r9).toString());     // Catch: Throwable -> L111
        goto L25
    L23:
        r9 = r8.a() + " header:" + r8.c();     // Catch: Throwable -> L111
    L25:
        this.redirectHost = null;     // Catch: Throwable -> L111
        this.lastChannelUrl = null;     // Catch: Throwable -> L111
        if (r8 != null) goto L28;
    L103:
        this.moreChannelSwitch = true;     // Catch: Throwable -> L111
        Boolean r1 = this.preNetworkError;     // Catch: Throwable -> L111
        if (r1 != null) goto L106;
    L108:
        this.preNetworkError = true;     // Catch: Throwable -> L111
        return false;
    L106:
        if (r1.booleanValue() == false) goto L108;
        LogReportController.getInstance().shortBackOff();     // Catch: Throwable -> L111
        goto L108
    L28:
        if (r8.a() <= 0) goto L103;
        this.moreChannelSwitch = false;     // Catch: Throwable -> L111
        if (500 <= r8.a()) goto L33;
    L41:
        JSONObject r12 = getData(r8);     // Catch: Throwable -> L111
        if (r12 != null) goto L44;
    L101:
        this.preNetworkError = true;     // Catch: Throwable -> L111
        return false;
    L44:
        if (r8.a() != 200) goto L101;
        String r13 = r12.optString("message");     // Catch: Throwable -> L111
        String r14 = r12.optString(RESPONSE_REDIRECT);     // Catch: Throwable -> L111
        long r15 = r12.optLong(RESPONSE_DELAY);     // Catch: Throwable -> L111
        if (r12.optLong(RESPONSE_SERVER_CODE, 0) == SERVER_CODE_ZSTD_DICT_FIND_FAILED) goto L50;
    L57:
        JSONObject r3 = r12.optJSONObject("settings_info");     // Catch: Throwable -> L111
        if (r3 == null) goto L65;
        IConfigManager r16 = (IConfigManager) ZeusTransformUtils.preCheckCast(d.a(IConfigManager.class), IConfigManager.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L111
        if (r16 == null) goto L65;
        JSONObject r4 = r3.optJSONObject(String.valueOf(ApmContext.getAid()));     // Catch: Throwable -> L111
        if (r4 == null) goto L65;
        r16.updateWithSpecificAidResult(r4);     // Catch: Throwable -> L111
    L65:
        if ("success".equals(r13) == false) goto L67;
        LogReportController.getInstance().restore();     // Catch: Throwable -> L111
        this.lastChannelUrl = r7;     // Catch: Throwable -> L111
        this.preNetworkError = false;     // Catch: Throwable -> L111
        boolean r6 = true;
        boolean r5 = false;
    L119:
    L86:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L111
    L88:
        JSONObject r17 = r12.optJSONObject(RESPONSE_DOWNGRADE_RULE);     // Catch: Throwable -> L111
        if (r17 == null) goto L91;
        DowngradeController.getInstance().setDowngradeInfo(DowngradeInfo.parse(r17), true);     // Catch: Throwable -> L111
    L91:
        this.redirectHost = r14;     // Catch: Throwable -> L111
        if (r15 <= 0) goto L94;
        LogReportController.getInstance().delayReport(r15);     // Catch: Throwable -> L111
    L94:
        if (r5 == false) goto L99;
        LogReportController.getInstance().dropData();     // Catch: Throwable -> L111
        if (r8.c() == null) goto L98;
        DropDataMonitor.getInstance().setServerLogId((String) ZeusTransformUtils.preCheckCast(r8.c().get(TT_LOG_ID), String.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L111
    L98:
        DropDataMonitor.getInstance().setServerTimeStamp(System.currentTimeMillis());     // Catch: Throwable -> L111
    L100:
        return r6;
    L99:
        LogReportController.getInstance().recoveryFromDropData();     // Catch: Throwable -> L111
        goto L100
    L72:
        if (ApmContext.isDebugMode() == false) goto L88;
        JSONObject r18 = new JSONObject();     // Catch: Throwable -> L86
        r18.put("RESPONSE_DATA_URL", r2.url);     // Catch: Throwable -> L86
        if (r8.c() == null) goto L84;
        JSONObject r19 = new JSONObject();     // Catch: Throwable -> L86
        Iterator<Map.Entry<String, String>> r110 = r8.c().entrySet().iterator();     // Catch: Throwable -> L86
    L77:
        if (r110.hasNext() == false) goto L83;
        Map.Entry r20 = (Map.Entry) ZeusTransformUtils.preCheckCast(r110.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L86
        if (r20.getKey() == null) goto L77;
        r19.put((String) ZeusTransformUtils.preCheckCast(r20.getKey(), String.class, "com.obric.memorydata.plugin"), r20.getValue());     // Catch: Throwable -> L116
        goto L77
    L83:
        r18.put("RESPONSE_DATA_HEADERS", r19);     // Catch: Throwable -> L86
    L84:
        r18.put("RESPONSE_DATA_BODY_TEXT", r12);     // Catch: Throwable -> L86
        a.a(r0, r18);     // Catch: Throwable -> L86
    L67:
        this.preNetworkError = true;     // Catch: Throwable -> L111
        r5 = RESPONSE_MESSAGE_DROP_DATA.equals(r13);     // Catch: Throwable -> L111
        if (ApmContext.isDebugMode() == false) goto L70;
        Logger.d(Constants.TAG, "responseMessage:" + r13);     // Catch: Throwable -> L111
    L70:
        r6 = false;
        goto L119
    L50:
        if (compressType != 2) goto L57;
        if (this.zstdService == null) goto L57;
        if (this.callstackDepth != 0) goto L57;
        compressType = 1;     // Catch: Throwable -> L111
        ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ApmContext.getContext(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin")).getSharedPreferences("dict_interval", 0).edit().putLong("dict_interval", 0).putLong(FORCE_ZSTD_TIMESTAMP, System.currentTimeMillis()).commit();     // Catch: Throwable -> L111
        this.callstackDepth++;     // Catch: Throwable -> L111
        boolean r21 = sendLog(r0);     // Catch: Throwable -> L111
        this.callstackDepth--;     // Catch: Throwable -> L111
        return r21;
    L33:
        if (r8.a() > 600) goto L41;
        Boolean r23 = this.preNetworkError;     // Catch: Throwable -> L111
        if (r23 != null) goto L37;
    L39:
        this.preNetworkError = true;     // Catch: Throwable -> L111
        return false;
    L37:
        if (r23.booleanValue() == false) goto L39;
        LogReportController.getInstance().longBackOff();     // Catch: Throwable -> L111
        goto L39
    L11:
        e = move-exception;
        com.bytedance.services.apm.api.a.a(e, "NetworkSender->sendLog(byte[] bytes)");     // Catch: Throwable -> L111
        Logger.e(Constants.TAG, " appendSettingsParams wrong ");     // Catch: Throwable -> L111
        r0 = r22;
    L111:
        th = move-exception;
        Logger.e(Constants.TAG, "sendLog failed.", th);
        return false;
    L115:
        return true;
    }
}
