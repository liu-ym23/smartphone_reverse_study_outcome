package com.bytedance.crash.upload;

import android.text.TextUtils;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.config.NetConfig;
import com.bytedance.crash.config.NpthBuildConfig;
import com.bytedance.crash.diagnose.NpthMonitor;
import com.bytedance.crash.general.GeneralInfoManager;
import com.bytedance.crash.monitor.EventMonitor;
import com.bytedance.crash.util.JSONUtils;
import com.bytedance.rpc.internal.RpcUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class UploaderUrl {
    public UploaderUrl() {
    }

    public static String appendAlogUrlParams(String r1, int r2, String r3, String r4, long r5) {
        return appendParamToURL(appendParamToURL(appendParamToURL(appendParamToURL(appendParamToURL(appendParamToURL(appendParamToURL(r1, "aid", String.valueOf(r2)), "device_id", r3), "os", LocationInfoConst.SYSTEM), "update_version_code", String.valueOf(r5)), "channel", "unknown"), "app_version", r4), "sdk_version", NpthBuildConfig.VERSION_NAME);
    }

    public static String appendAlogUrlParams(String r1, String r2, String r3, String r4, long r5) {
        return appendParamToURL(appendParamToURL(appendParamToURL(appendParamToURL(appendParamToURL(appendParamToURL(appendParamToURL(r1, "aid", r2), "device_id", r3), "os", LocationInfoConst.SYSTEM), "update_version_code", String.valueOf(r5)), "channel", "unknown"), "app_version", r4), "sdk_version", NpthBuildConfig.VERSION_NAME);
    }

    public static String appendParamToURL(String r4, String r5, String r6) {
        if (TextUtils.isEmpty(r4) == false) goto L5;
        return r4;
    L5:
        if (TextUtils.isEmpty(r5) == true) goto L21;
        if (r6 == null) goto L22;
        StringBuilder r1 = new StringBuilder(r4);
        if (r4.contains("?") == true) goto L18;
        r1.append("?");
    L18:
        if (r1.toString().endsWith("?") == true) goto L14;
        r1.append("&");     // Catch: Exception -> L17
    L14:
        r1.append(URLEncoder.encode(r5, RpcUtils.CHARSET_UTF8));     // Catch: Exception -> L17
        r1.append("=");     // Catch: Exception -> L17
        r1.append(URLEncoder.encode(r6, RpcUtils.CHARSET_UTF8));     // Catch: Exception -> L17
        return r1.toString();
    L23:
        return r4;
    L22:
        return r4;
    L21:
        return r4;
    }

    public static String appendParamsToURL(String r6, Map r7) {
        Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.memorydata.plugin");
        if (TextUtils.isDigitsOnly(r6) == true) goto L31;
        if (r8 != null) goto L6;
        return r6;
    L6:
        if (r8.isEmpty() == true) goto L33;
        StringBuilder r1 = new StringBuilder(r6);
        if (r6.contains("?") == true) goto L24;
        r1.append("?");
    L24:
        Iterator r9 = r8.entrySet().iterator();     // Catch: Exception -> L23
    L12:
        if (r9.hasNext() == false) goto L22;
        Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r9.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L23
        if (r4.getValue() == null) goto L12;
        if (r1.toString().endsWith("?") == true) goto L19;
        r1.append("&");     // Catch: Exception -> L23
    L19:
        r1.append(URLEncoder.encode(r4.getKey().toString(), RpcUtils.CHARSET_UTF8));     // Catch: Exception -> L23
        r1.append("=");     // Catch: Exception -> L23
        r1.append(URLEncoder.encode(r4.getValue().toString(), RpcUtils.CHARSET_UTF8));     // Catch: Exception -> L23
        goto L12
    L22:
        return r1.toString();
    L34:
        return r6;
    L33:
        return r6;
    L31:
        return r6;
    }

    public static String appendUrlParamsByHeader(String r3, JSONObject r4) {
        return appendParamsToURL(r3, getSubMapKeyValuePair(JSONUtils.toMap(r4), new String[]{"aid", "4444", "os", LocationInfoConst.SYSTEM, "update_version_code", "000000", "channel", "unknown", "app_version", "0.0.0", "sdk_version", NpthBuildConfig.VERSION_NAME, "device_id", GeneralInfoManager.getRandomDeviceId()}));
    }

    public static String appendUrlParamsByMonitor(String r3, EventMonitor r4) {
        HashMap r0 = new HashMap();
        r0.put("aid", r4.getAppId());
        r0.put("version_code", String.valueOf(r4.getVersionCode()));
        r0.put("update_version_code", String.valueOf(r4.getUpdateVersionCode()));
        r0.put("app_version", String.valueOf(r4.getVersionName()));
        if (TextUtils.isEmpty(r4.getChannel()) == true) goto L5;
        r0.put("channel", r4.getChannel());
    L5:
        r0.put("device_id", r4.getDeviceId("0"));
        return appendUrlParamsByHeader(r3, new JSONObject(r0));
    }

    public static Map<String, String> getSubMapKeyValuePair(Map<String, Object> r4, String... r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        HashMap r0 = new HashMap();
        if (r5 != null) goto L5;
    L18:
        NpthMonitor.reportInnerException(new IllegalArgumentException("err keyValuePair:" + Arrays.toString(r5)));
        return r0;
    L5:
        if (r5.length == 0) goto L18;
        if ((r5.length % 2) != 0) goto L18;
        int r1 = 0;
    L11:
        if (r1 >= r5.length) goto L17;
        String r2 = r5[r1];
        Object r3 = r6.get(r2);
        if (r3 == null) goto L15;
        String r7 = String.valueOf(r3);
    L16:
        r0.put(r2, r7);
        r1 = r1 + 2;
        goto L11
    L15:
        r7 = r5[r1 + 1];
        goto L16
    L17:
        return r0;
    }

    static String getUrlByCrashType(CrashType r1) {
        if (r1 != CrashType.NATIVE) goto L7;
        return NetConfig.getNativeCrashUploadUrl();
    L7:
        if (r1 == CrashType.ANR) goto L32;
        if (r1 == CrashType.JAVA) goto L32;
        if (r1 == CrashType.DART) goto L32;
        if (r1 != CrashType.LAUNCH) goto L18;
        return NetConfig.getLaunchCrashUploadUrl();
    L18:
        if (r1 != CrashType.ASAN) goto L22;
        return NetConfig.getAsanReportUploadUrl();
    L22:
        if (r1 != CrashType.COREDUMP) goto L26;
        return NetConfig.getCoreDumpUrl();
    L26:
        if (r1 != CrashType.NATIVE_CUSTOMIZE) goto L30;
        return NetConfig.getExceptionZipUploadUrl();
    L30:
        return NetConfig.getJavaCrashUploadUrl();
    L32:
        return NetConfig.getJavaCrashUploadUrl();
    }

    public static String getUrlByCrashTypeAndHeader(CrashType r1, JSONObject r2) {
        String r3 = getUrlByCrashType(r1);
        if (JSONUtils.isEmpty(r2) == false) goto L5;
        return r3;
    L5:
        return appendUrlParamsByHeader(r3, r2);
    }

    static String urlAppendParam(String r3, String r4) {
        if (TextUtils.isEmpty(new URL(r3).getQuery()) == false) goto L10;
        if (r3.endsWith("?") == true) goto L12;
        StringBuilder r0 = new StringBuilder().append(r3).append("?");     // Catch: Throwable -> L14
    L8:
        r3 = r0.toString();     // Catch: Throwable -> L14
    L12:
        return r3 + r4;
    L10:
        if (r3.endsWith("&") == true) goto L12;
        r0 = new StringBuilder().append(r3).append("&");     // Catch: Throwable -> L14
    L17:
        return r3;
    }
}
