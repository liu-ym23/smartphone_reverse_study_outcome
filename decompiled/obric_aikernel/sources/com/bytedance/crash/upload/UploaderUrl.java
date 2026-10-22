package com.bytedance.crash.upload;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.config.NetConfig;
import com.bytedance.crash.config.NpthBuildConfig;
import com.bytedance.crash.diagnose.NpthMonitor;
import com.bytedance.crash.general.GeneralInfoManager;
import com.bytedance.crash.monitor.EventMonitor;
import com.bytedance.crash.util.JSONUtils;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class UploaderUrl {
    public UploaderUrl() {
    }

    public static String appendAlogUrlParams(String r10, int r11, String r12, String r13, long r14) {
        return appendParamToURL(appendParamToURL(appendParamToURL(appendParamToURL(appendParamToURL(appendParamToURL(appendParamToURL(r10, "aid", String.valueOf(r11)), "device_id", r12), "os", "Android"), "update_version_code", String.valueOf(r14)), "channel", "unknown"), "app_version", r13), "sdk_version", NpthBuildConfig.VERSION_NAME);
    }

    public static String appendAlogUrlParams(String r10, String r11, String r12, String r13, long r14) {
        return appendParamToURL(appendParamToURL(appendParamToURL(appendParamToURL(appendParamToURL(appendParamToURL(appendParamToURL(r10, "aid", r11), "device_id", r12), "os", "Android"), "update_version_code", String.valueOf(r14)), "channel", "unknown"), "app_version", r13), "sdk_version", NpthBuildConfig.VERSION_NAME);
    }

    public static String appendParamToURL(String r10, String r11, String r12) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
        return r10;
    L5:
        if (TextUtils.isEmpty(r11) == true) goto L21;
        if (r12 == null) goto L22;
        StringBuilder r13 = new StringBuilder(r10);
        if (r10.contains("?") == true) goto L18;
        r13.append("?");
    L18:
        if (r13.toString().endsWith("?") == true) goto L14;
        r13.append("&");     // Catch: Exception -> L17
    L14:
        r13.append(URLEncoder.encode(r11, "UTF-8"));     // Catch: Exception -> L17
        r13.append("=");     // Catch: Exception -> L17
        r13.append(URLEncoder.encode(r12, "UTF-8"));     // Catch: Exception -> L17
        return r13.toString();
    L23:
        return r10;
    L22:
        return r10;
    L21:
        return r10;
    }

    public static String appendParamsToURL(String r10, Map r11) {
        if (TextUtils.isDigitsOnly(r10) == true) goto L31;
        if (r11 != null) goto L6;
        return r10;
    L6:
        if (r11.isEmpty() == true) goto L33;
        StringBuilder r12 = new StringBuilder(r10);
        if (r10.contains("?") == true) goto L24;
        r12.append("?");
    L24:
        Iterator r13 = r11.entrySet().iterator();     // Catch: Exception -> L23
    L12:
        if (r13.hasNext() == false) goto L22;
        Map.Entry r14 = (Map.Entry) r13.next();     // Catch: Exception -> L23
        if (r14.getValue() == null) goto L12;
        if (r12.toString().endsWith("?") == true) goto L19;
        r12.append("&");     // Catch: Exception -> L23
    L19:
        r12.append(URLEncoder.encode(r14.getKey().toString(), "UTF-8"));     // Catch: Exception -> L23
        r12.append("=");     // Catch: Exception -> L23
        r12.append(URLEncoder.encode(r14.getValue().toString(), "UTF-8"));     // Catch: Exception -> L23
        goto L12
    L22:
        return r12.toString();
    L34:
        return r10;
    L33:
        return r10;
    L31:
        return r10;
    }

    public static String appendUrlParamsByHeader(String r10, JSONObject r11) {
        return appendParamsToURL(r10, getSubMapKeyValuePair(JSONUtils.toMap(r11), new String[]{"aid", "4444", "os", "Android", "update_version_code", "000000", "channel", "unknown", "app_version", "0.0.0", "sdk_version", NpthBuildConfig.VERSION_NAME, "device_id", GeneralInfoManager.getRandomDeviceId()}));
    }

    @NonNull
    public static String appendUrlParamsByMonitor(@NonNull String r10, @NonNull EventMonitor r11) {
        HashMap r12 = new HashMap();
        r12.put("aid", r11.getAppId());
        r12.put("version_code", String.valueOf(r11.getVersionCode()));
        r12.put("update_version_code", String.valueOf(r11.getUpdateVersionCode()));
        r12.put("app_version", String.valueOf(r11.getVersionName()));
        if (TextUtils.isEmpty(r11.getChannel()) == true) goto L5;
        r12.put("channel", r11.getChannel());
    L5:
        r12.put("device_id", r11.getDeviceId(NetConst.NOT_ENCRYPT_VERISON_CODE));
        return appendUrlParamsByHeader(r10, new JSONObject(r12));
    }

    public static Map<String, String> getSubMapKeyValuePair(Map<String, Object> r10, String... r11) {
        HashMap r12 = new HashMap();
        if (r11 != null) goto L5;
    L18:
        NpthMonitor.reportInnerException(new IllegalArgumentException("err keyValuePair:" + Arrays.toString(r11)));
        return r12;
    L5:
        if (r11.length == 0) goto L18;
        if ((r11.length % 2) != 0) goto L18;
        int r13 = 0;
    L11:
        if (r13 >= r11.length) goto L17;
        String r14 = r11[r13];
        Object r15 = r10.get(r14);
        if (r15 == null) goto L15;
        String r16 = String.valueOf(r15);
    L16:
        r12.put(r14, r16);
        r13 = r13 + 2;
        goto L11
    L15:
        r16 = r11[r13 + 1];
        goto L16
    L17:
        return r12;
    }

    static String getUrlByCrashType(CrashType r10) {
        if (r10 != CrashType.NATIVE) goto L7;
        return NetConfig.getNativeCrashUploadUrl();
    L7:
        if (r10 == CrashType.ANR) goto L32;
        if (r10 == CrashType.JAVA) goto L32;
        if (r10 == CrashType.DART) goto L32;
        if (r10 != CrashType.LAUNCH) goto L18;
        return NetConfig.getLaunchCrashUploadUrl();
    L18:
        if (r10 != CrashType.ASAN) goto L22;
        return NetConfig.getAsanReportUploadUrl();
    L22:
        if (r10 != CrashType.COREDUMP) goto L26;
        return NetConfig.getCoreDumpUrl();
    L26:
        if (r10 != CrashType.NATIVE_CUSTOMIZE) goto L30;
        return NetConfig.getExceptionZipUploadUrl();
    L30:
        return NetConfig.getJavaCrashUploadUrl();
    L32:
        return NetConfig.getJavaCrashUploadUrl();
    }

    public static String getUrlByCrashTypeAndHeader(CrashType r10, JSONObject r11) {
        String r12 = getUrlByCrashType(r10);
        if (JSONUtils.isEmpty(r11) == false) goto L5;
        return r12;
    L5:
        return appendUrlParamsByHeader(r12, r11);
    }

    static String urlAppendParam(String r10, String r11) {
        if (TextUtils.isEmpty(new URL(r10).getQuery()) == false) goto L9;
        if (r10.endsWith("?") == true) goto L11;
        r10 = r10 + "?";     // Catch: Throwable -> L13
    L11:
        return r10 + r11;
    L9:
        if (r10.endsWith("&") == true) goto L11;
        r10 = r10 + "&";     // Catch: Throwable -> L13
    L16:
        return r10;
    }
}
