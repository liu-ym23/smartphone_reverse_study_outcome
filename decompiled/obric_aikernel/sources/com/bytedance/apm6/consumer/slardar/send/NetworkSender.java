package com.bytedance.apm6.consumer.slardar.send;

import a0.a;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import c4.d;
import com.bytedance.apm.doctor.DoctorManager;
import com.bytedance.apm6.consumer.slardar.Constants;
import com.bytedance.apm6.consumer.slardar.SlardarResponseService;
import com.bytedance.apm6.consumer.slardar.send.downgrade.DowngradeController;
import com.bytedance.apm6.consumer.slardar.send.downgrade.DowngradeInfo;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.service.ServiceManager;
import com.bytedance.apm6.service.encrypt.EncryptService;
import com.bytedance.apm6.service.http.HttpRequest;
import com.bytedance.apm6.util.ApmBaseContext;
import com.bytedance.apm6.util.IOUtils;
import com.bytedance.apm6.util.JsonUtils;
import com.bytedance.apm6.util.ListUtils;
import com.bytedance.apm6.util.UrlUtils;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.apm6.util.constant.ReportConsts;
import com.bytedance.apm6.util.log.Logger;
import com.bytedance.crypto.utils.CryptoConst;
import com.bytedance.services.slardar.config.IConfigManager;
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
import t4.c;
import t4.e;
import t4.j;
import t4.k;

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
    private k zstdDict;
    private j zstdService;

    static {
        map = new HashMap();
    }

    private NetworkSender(UploadLogInfo r10) {
        this.lastChannelUrl = null;
        this.callstackDepth = 0;
        this.urls = r10.getUrls();
    }

    private byte[] compress(byte[] r10) {
        ByteArrayOutputStream r11 = new ByteArrayOutputStream(8192);
        GZIPOutputStream r12 = null;
        GZIPOutputStream r13 = new GZIPOutputStream(r11);     // Catch: Throwable -> L9 IOException -> L12
        r13.write(r10);     // Catch: Throwable -> L7 IOException -> L15
        IOUtils.closeQuietly(r13);
        return r11.toByteArray();
    L7:
        th = th;
        r12 = r13;
    L10:
        IOUtils.closeQuietly(r12);
        throw th;
    L13:
        IOUtils.closeQuietly(r13);
        return null;
    L12:
        r13 = null;
    L9:
        th = th;
        goto L10
    }

    private HttpRequest createRequest(String r10, byte[] r11, boolean r12) {
        HashMap r13 = new HashMap();
        HashMap r14 = new HashMap(ApmContext.getUrlParams());
        r13.put(NetConst.KEY_ACCEPT_ENCODING, NetConst.GZIP);
        byte[] r15 = null;
        if (r11.length > 128) goto L5;
    L38:
        if (r15 == null) goto L41;
        r11 = r15;
    L41:
        r13.put(NetConst.KEY_CONTENT_TYPE, NetConst.CONTENT_TYPE);
        if (LogReportController.getInstance().isEncrypt() == false) goto L55;
        byte[] r16 = encrypt(r11);
        if (r16 == null) goto L55;
        r14.put("tt_data", "a");
        String r17 = UrlUtils.addParamsToURL(r10, r14);
        r13.put(NetConst.KEY_CONTENT_TYPE, "application/octet-stream;tt-data=a");
        if (ApmBaseContext.isDebugMode() == false) goto L48;
        Logger.d(Constants.TAG, "before encrypt url:" + r17);
    L48:
        LinkedList r18 = new LinkedList();
        String r19 = tryEncryptRequest(r17, r18);
        if (TextUtils.isEmpty(r19) == true) goto L52;
        r17 = r19;
    L52:
        if (ApmBaseContext.isDebugMode() == false) goto L54;
        Logger.d(Constants.TAG, "after encrypt url:" + r17);
    L54:
        r13.putAll(ListUtils.listToMap(r18));
        r11 = r16;
    L56:
        r13.put(NetConst.KEY_REQUSET_VERISON_CODE, NetConst.ENCRYPT_VERISON_CODE);
        return new HttpRequest(r17, r13, r11);
    L55:
        r17 = UrlUtils.addParamsToURL(r10, r14);
        goto L56
    L5:
        if (r12 == false) goto L7;
    L34:
        if (r15 != null) goto L38;
        r15 = compress(r11);
        if (r15 == null) goto L38;
        r13.put(NetConst.KEY_CONTENT_ENCODING, NetConst.GZIP);
        goto L38
    L7:
        if (this.zstdService != null) goto L10;
        this.zstdService = (j) ServiceManager.getService(j.class);
    L10:
        if (compressType != 1) goto L18;
        j r110 = this.zstdService;
        if (r110 == null) goto L18;
        byte[] r111 = r110.a(r11, 15);
        if (r111 == null) goto L16;
        r13.put(NetConst.KEY_CONTENT_ENCODING, NetConst.TYPE_ZSTD);
        r13.put(HEADER_LEVEL, String.valueOf(15));
    L16:
        r15 = r111;
    L18:
        if (compressType != 2) goto L34;
        if (this.zstdService == null) goto L34;
        if (this.zstdDict != null) goto L24;
        this.zstdDict = (k) ServiceManager.getService(k.class);
    L24:
        k r112 = this.zstdDict;
        if (r112 == null) goto L29;
        Pair<byte[], String> r113 = r112.a();
        byte[] r20 = (byte[]) r113.first;
        String r114 = (String) r113.second;
        if (r20 == null) goto L30;
        r15 = this.zstdService.b(r11, r20, 15);
    L30:
        if (r15 == null) goto L34;
        r13.put(NetConst.KEY_CONTENT_ENCODING, NetConst.TYPE_ZSTD_DICT);
        r13.put(HEADER_LEVEL, String.valueOf(15));
        if (TextUtils.isEmpty(r114) == true) goto L34;
        r13.put("slardar-zstd-version", r114);
        r14.put("slardar-zstd-version", r114);
        goto L34
    L29:
        r114 = null;
        goto L30
    }

    private String decodeData(byte[] r10, String r11) {
        if (TextUtils.isEmpty(r11) == false) goto L12;
        return "";
    L12:
        SecretKeySpec r12 = new SecretKeySpec(r11.getBytes(), CryptoConst.ALGORITHM_AES);     // Catch: Throwable -> L7
        Cipher r13 = Cipher.getInstance("AES/ECB/NoPadding");     // Catch: Throwable -> L7
        r13.init(2, r12);     // Catch: Throwable -> L7
        return new String(r13.doFinal(Base64.decode(r10, 0))).replaceAll("\\$+$", "");
    L7:
        th = move-exception;
        if (ApmBaseContext.isDebugMode() == false) goto L11;
        Logger.e(Constants.TAG, "decodeData", th);
    L11:
        return "";
    }

    private byte[] encrypt(byte[] r10) {
        e r11 = (e) ServiceManager.getService(e.class);
        if (r11 != null) goto L5;
        return null;
    L5:
        return r11.encrypt(r10);
    }

    private JSONObject getData(c r10) {
        JSONObject r11 = new JSONObject(new String(r10.b()));     // Catch: Exception -> L26
        Map<String, String> r12 = r10.a();     // Catch: Exception -> L26
        if (r12 != null) goto L6;
    L11:
        String r13 = null;
    L12:
        boolean r14 = true;
        String r15 = r11.optString("data");     // Catch: Throwable -> L24
        if (r15.isEmpty() == false) goto L16;
    L19:
        handleResponse(r11);     // Catch: Throwable -> L24
        if (r14 == true) goto L23;
        JSONObject r16 = new JSONObject();     // Catch: Throwable -> L24
        r16.put("message", "success");     // Catch: Throwable -> L24
        return r16;
    L23:
        return r11;
    L16:
        if (TextUtils.isEmpty(r13) == true) goto L18;
        String r17 = decodeData(r15.getBytes(), r13);     // Catch: Throwable -> L24
        JSONObject r18 = new JSONObject(r17);     // Catch: Throwable -> L24
        r14 = true ^ TextUtils.isEmpty(r17);     // Catch: Throwable -> L24
        r11 = r18;
        goto L19
    L18:
        r11 = new JSONObject(new String(r15.getBytes()));     // Catch: Throwable -> L24
    L24:
        JSONObject r19 = new JSONObject();     // Catch: Exception -> L26
        r19.put("message", "success");     // Catch: Exception -> L26
        return r19;
    L6:
        if (r12.isEmpty() == true) goto L11;
        r13 = r12.get(CommonConsts.KEY_DECODE);     // Catch: Exception -> L26
        if (TextUtils.isEmpty(r13) == false) goto L12;
        r13 = r12.get(CommonConsts.KEY_DECODE_RAN);     // Catch: Exception -> L26
    L26:
        return null;
    }

    public static NetworkSender getInstance(UploadLogInfo r10) {
        if (map.containsKey(r10) == true) goto L5;
        map.put(r10, new NetworkSender(r10));
    L5:
        return map.get(r10);
    }

    private String getReportUrl() {
        List<String> r10 = this.urls;
        if (TextUtils.isEmpty(this.redirectHost) == true) goto L13;
        if (r10 != null) goto L7;
    L11:
        return null;
    L7:
        if (r10.size() <= 0) goto L11;
        return ReportConsts.HTTPS + this.redirectHost + new URL(r10.get(0)).getPath();
    L13:
        if (TextUtils.isEmpty(this.lastChannelUrl) == true) goto L17;
        return this.lastChannelUrl;
    L17:
        if (this.moreChannelSwitch == false) goto L19;
        this.channelPosition++;
    L19:
        int r11 = r10.size();
        int r12 = this.channelPosition;
        if (r11 <= r12) goto L23;
        if (r12 < 0) goto L23;
        String r13 = r10.get(r12);
    L25:
        return r13;
    L23:
        this.channelPosition = 0;
        r13 = r10.get(0);
        goto L25
    }

    private void handleResponse(JSONObject r10) {
        if (JsonUtils.isEmpty(r10) == false) goto L5;
        return;
    L5:
        JSONObject r11 = r10.optJSONObject("configs");
        if (JsonUtils.isEmpty(r11) == false) goto L8;
        return;
    L8:
        SlardarResponseService r12 = (SlardarResponseService) ServiceManager.getService(SlardarResponseService.class);
        if (r12 == null) goto L12;
        r12.onResponse(r11);
        return;
    }

    public static void restart() {
        map.clear();
    }

    public static void setCompressType(int r10) {
        if (r10 != 2) goto L8;
        long r11 = ApmBaseContext.getContext().getSharedPreferences("dict_interval", 0).getLong(FORCE_ZSTD_TIMESTAMP, 0);
        if ((System.currentTimeMillis() - r11) > 3600000) goto L8;
        compressType = 1;
        return;
    L8:
        compressType = r10;
    }

    private String tryEncryptRequest(String r10, List<Pair<String, String>> r11) {
        EncryptService r12 = (EncryptService) ServiceManager.getService(EncryptService.class);
        if (r12 != null) goto L5;
        return null;
    L5:
        return r12.tryEncryptRequest(r10, r11);
    }

    private void updateZstdHost(String r10) {
        if (this.zstdDict != null) goto L6;
        this.zstdDict = (k) ServiceManager.getService(k.class);
    L6:
        if (this.zstdDict == null) goto L12;
        URL r11 = new URL(r10);     // Catch: MalformedURLException -> L9
        this.zstdDict.b(r11.getHost());     // Catch: MalformedURLException -> L9
        return;
    L13:
        return;
    }

    byte[] appendSettingsParams(byte[] r10) {
        JSONObject r11 = new JSONObject(new String(r10));
        IConfigManager r12 = (IConfigManager) d.a(IConfigManager.class);
        if (r12 == null) goto L10;
        JSONObject r13 = r12.retrieveSettingsParams();
        JSONObject r14 = new JSONObject();
        String r15 = String.valueOf(ApmContext.getAid());
        if (TextUtils.isEmpty(r15) == true) goto L10;
        if (r15.equals(NetConst.NOT_ENCRYPT_VERISON_CODE) == true) goto L10;
        r14.put(r15, r13);
        r11.put("settings_params", r14);
    L10:
        return r11.toString().getBytes();
    }

    boolean sendLog(byte[] r21) {
        if (r21 != null) goto L5;
    L112:
        return true;
    L5:
        if (r21.length == 0) goto L112;
        String r10 = getReportUrl();     // Catch: Throwable -> L109
        updateZstdHost(r10);     // Catch: Throwable -> L109
        byte[] r11 = appendSettingsParams(r21);     // Catch: JSONException -> L11 Throwable -> L109
    L14:
        HttpRequest r12 = createRequest(r10, r11, false);     // Catch: Throwable -> L109
        if (ApmBaseContext.isDebugMode() == false) goto L18;
        DoctorManager.getInstance().b("APM_SEND_DATA", "url:" + r12.url + " header:" + r12.headerMap);     // Catch: Throwable -> L109
        Logger.d(Constants.TAG, "sendLog createRequest: origin Bytes=" + r11.length + " compressed Bytes=" + r12.data.length + " url=" + r12.url + " headers=" + r12.headerMap);     // Catch: Throwable -> L109
    L18:
        c r13 = ApmContext.doPost(r12.url, r12.headerMap, r12.data);     // Catch: Throwable -> L109
        if (ApmBaseContext.isDebugMode() == false) goto L25;
        String r14 = Constants.TAG;     // Catch: Throwable -> L109
        StringBuilder r15 = new StringBuilder();     // Catch: Throwable -> L109
        r15.append("http result:");     // Catch: Throwable -> L109
        if (r13 != null) goto L23;
        Object r16 = -1;     // Catch: Throwable -> L109
    L24:
        r15.append(r16);     // Catch: Throwable -> L109
        Logger.d(r14, r15.toString());     // Catch: Throwable -> L109
        goto L25
    L23:
        r16 = r13.c() + " header:" + r13.a();     // Catch: Throwable -> L109
    L25:
        this.redirectHost = null;     // Catch: Throwable -> L109
        this.lastChannelUrl = null;     // Catch: Throwable -> L109
        if (r13 != null) goto L28;
    L102:
        this.moreChannelSwitch = true;     // Catch: Throwable -> L109
        Boolean r17 = this.preNetworkError;     // Catch: Throwable -> L109
        if (r17 != null) goto L105;
    L107:
        this.preNetworkError = Boolean.TRUE;     // Catch: Throwable -> L109
        return false;
    L105:
        if (r17.booleanValue() == false) goto L107;
        LogReportController.getInstance().shortBackOff();     // Catch: Throwable -> L109
        goto L107
    L28:
        if (r13.c() <= 0) goto L102;
        this.moreChannelSwitch = false;     // Catch: Throwable -> L109
        if (500 <= r13.c()) goto L33;
    L41:
        JSONObject r18 = getData(r13);     // Catch: Throwable -> L109
        if (r18 != null) goto L44;
    L100:
        this.preNetworkError = Boolean.TRUE;     // Catch: Throwable -> L109
        return false;
    L44:
        if (r13.c() != 200) goto L100;
        String r19 = r18.optString("message");     // Catch: Throwable -> L109
        String r110 = r18.optString(RESPONSE_REDIRECT);     // Catch: Throwable -> L109
        long r111 = r18.optLong(RESPONSE_DELAY);     // Catch: Throwable -> L109
        if (r18.optLong(RESPONSE_SERVER_CODE, 0) == SERVER_CODE_ZSTD_DICT_FIND_FAILED) goto L49;
    L56:
        JSONObject r20 = r18.optJSONObject("settings_info");     // Catch: Throwable -> L109
        if (r20 == null) goto L64;
        IConfigManager r112 = (IConfigManager) d.a(IConfigManager.class);     // Catch: Throwable -> L109
        if (r112 == null) goto L64;
        JSONObject r22 = r20.optJSONObject(String.valueOf(ApmContext.getAid()));     // Catch: Throwable -> L109
        if (r22 == null) goto L64;
        r112.updateWithSpecificAidResult(r22);     // Catch: Throwable -> L109
    L64:
        if ("success".equals(r19) == false) goto L66;
        LogReportController.getInstance().restore();     // Catch: Throwable -> L109
        this.lastChannelUrl = r10;     // Catch: Throwable -> L109
        this.preNetworkError = Boolean.FALSE;     // Catch: Throwable -> L109
        boolean r23 = true;
        boolean r24 = false;
    L114:
    L85:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L109
    L87:
        JSONObject r25 = r18.optJSONObject(RESPONSE_DOWNGRADE_RULE);     // Catch: Throwable -> L109
        if (r25 == null) goto L90;
        DowngradeController.getInstance().setDowngradeInfo(DowngradeInfo.parse(r25), true);     // Catch: Throwable -> L109
    L90:
        this.redirectHost = r110;     // Catch: Throwable -> L109
        if (r111 <= 0) goto L93;
        LogReportController.getInstance().delayReport(r111);     // Catch: Throwable -> L109
    L93:
        if (r24 == false) goto L98;
        LogReportController.getInstance().dropData();     // Catch: Throwable -> L109
        if (r13.a() == null) goto L97;
        DropDataMonitor.getInstance().setServerLogId(r13.a().get(TT_LOG_ID));     // Catch: Throwable -> L109
    L97:
        DropDataMonitor.getInstance().setServerTimeStamp(System.currentTimeMillis());     // Catch: Throwable -> L109
    L99:
        return r23;
    L98:
        LogReportController.getInstance().recoveryFromDropData();     // Catch: Throwable -> L109
        goto L99
    L71:
        if (ApmBaseContext.isDebugMode() == false) goto L87;
        JSONObject r26 = new JSONObject();     // Catch: Throwable -> L85
        r26.put("RESPONSE_DATA_URL", r12.url);     // Catch: Throwable -> L85
        if (r13.a() == null) goto L83;
        JSONObject r27 = new JSONObject();     // Catch: Throwable -> L85
        Iterator<Map.Entry<String, String>> r113 = r13.a().entrySet().iterator();     // Catch: Throwable -> L85
    L76:
        if (r113.hasNext() == false) goto L82;
        Map.Entry<String, String> r114 = r113.next();     // Catch: Throwable -> L85
        if (r114.getKey() == null) goto L76;
        r27.put(r114.getKey(), r114.getValue());     // Catch: Throwable -> L113
        goto L76
    L82:
        r26.put("RESPONSE_DATA_HEADERS", r27);     // Catch: Throwable -> L85
    L83:
        r26.put("RESPONSE_DATA_BODY_TEXT", r18);     // Catch: Throwable -> L85
        a.g(r11, r26);     // Catch: Throwable -> L85
    L66:
        this.preNetworkError = Boolean.TRUE;     // Catch: Throwable -> L109
        r24 = RESPONSE_MESSAGE_DROP_DATA.equals(r19);     // Catch: Throwable -> L109
        if (ApmBaseContext.isDebugMode() == false) goto L69;
        Logger.d(Constants.TAG, "responseMessage:" + r19);     // Catch: Throwable -> L109
    L69:
        r23 = false;
        goto L114
    L49:
        if (compressType != 2) goto L56;
        if (this.zstdService == null) goto L56;
        if (this.callstackDepth != 0) goto L56;
        compressType = 1;     // Catch: Throwable -> L109
        ApmBaseContext.getContext().getSharedPreferences("dict_interval", 0).edit().putLong("dict_interval", 0).putLong(FORCE_ZSTD_TIMESTAMP, System.currentTimeMillis()).commit();     // Catch: Throwable -> L109
        this.callstackDepth++;     // Catch: Throwable -> L109
        boolean r28 = sendLog(r11);     // Catch: Throwable -> L109
        this.callstackDepth--;     // Catch: Throwable -> L109
        return r28;
    L33:
        if (r13.c() > 600) goto L41;
        Boolean r29 = this.preNetworkError;     // Catch: Throwable -> L109
        if (r29 != null) goto L37;
    L39:
        this.preNetworkError = Boolean.TRUE;     // Catch: Throwable -> L109
        return false;
    L37:
        if (r29.booleanValue() == false) goto L39;
        LogReportController.getInstance().longBackOff();     // Catch: Throwable -> L109
        goto L39
    L11:
        e = move-exception;
        t4.a.d(e, "NetworkSender->sendLog(byte[] bytes)");     // Catch: Throwable -> L109
        Logger.e(Constants.TAG, " appendSettingsParams wrong ");     // Catch: Throwable -> L109
        r11 = r21;
    L109:
        th = move-exception;
        Logger.e(Constants.TAG, "sendLog failed.", th);
        return false;
    }
}
