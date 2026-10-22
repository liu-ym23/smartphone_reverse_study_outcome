package com.bytedance.apm6.foundation.context;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.apm6.service.ServiceManager;
import com.bytedance.apm6.util.ApmBaseContext;
import com.bytedance.apm6.util.constant.CommonKey;
import com.bytedance.services.apm.api.IHttpService;
import d0.e;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;
import t4.c;

/* JADX INFO: loaded from: classes.dex */
public class ApmContext extends ApmBaseContext {
    private static ApmContextAdapter apmContextAdapter = null;
    private static String appVersion = null;
    private static Map<String, String> cacheBaseUrlParams = null;
    private static String channel = null;
    private static long configTime = -1;
    private static long initTimeStamp = 0;
    private static Boolean isMainProcess = null;
    private static int manifestVersionCode = -1;
    private static e ntpTimeService = null;
    private static String processName = null;
    private static String releaseBuild = null;
    private static JSONObject stableHeaderExtra = null;
    private static long startId = -1;
    private static int updateVersionCode = -1;
    private static int versionCode = -1;
    private static String versionName;

    static {
    }

    public ApmContext() {
    }

    public static c doGet(String r10, Map<String, String> r11) {
        return ((IHttpService) ServiceManager.getService(IHttpService.class)).doGet(r10, r11);
    }

    public static c doPost(String r10, Map<String, String> r11, byte[] r12) {
        return ((IHttpService) ServiceManager.getService(IHttpService.class)).doPost(r10, r12, r11);
    }

    public static int getAid() {
        return apmContextAdapter.getAid();
    }

    public static ApmContextAdapter getApmContextAdapter() {
        return apmContextAdapter;
    }

    public static String getAppVersion() {
        if (TextUtils.isEmpty(appVersion) == false) goto L15;
        monitor-enter(ApmContext.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (TextUtils.isEmpty(appVersion) == false) goto L9;
        appVersion = apmContextAdapter.getAppVersion();     // Catch: Throwable -> L11
    L9:
        monitor-exit(ApmContext.class);     // Catch: Throwable -> L11
    L15:
        return appVersion;
    }

    public static String getChannel() {
        if (channel != null) goto L15;
        monitor-enter(ApmContext.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (channel != null) goto L9;
        channel = apmContextAdapter.getChannel();     // Catch: Throwable -> L11
    L9:
        monitor-exit(ApmContext.class);     // Catch: Throwable -> L11
    L15:
        return channel;
    }

    public static long getConfigTime() {
        return configTime;
    }

    public static String getCurrentProcessName() {
        if (processName != null) goto L15;
        monitor-enter(ApmContext.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (processName != null) goto L9;
        processName = apmContextAdapter.getProcessName();     // Catch: Throwable -> L11
    L9:
        monitor-exit(ApmContext.class);     // Catch: Throwable -> L11
    L15:
        return processName;
    }

    public static String getDeviceId() {
        return apmContextAdapter.getDeviceId();
    }

    public static long getInitTimeStamp() {
        if (initTimeStamp > 0) goto L6;
        initTimeStamp = System.currentTimeMillis();
    L6:
        return initTimeStamp;
    }

    public static String getManifestVersionCode() {
        if (manifestVersionCode != (-1)) goto L15;
        monitor-enter(ApmContext.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (manifestVersionCode != (-1)) goto L9;
        manifestVersionCode = apmContextAdapter.getManifestVersionCode();     // Catch: Throwable -> L11
    L9:
        monitor-exit(ApmContext.class);     // Catch: Throwable -> L11
    L15:
        return String.valueOf(manifestVersionCode);
    }

    public static e getNtpTimeService() {
        return ntpTimeService;
    }

    public static String getReleaseBuild() {
        if (TextUtils.isEmpty(releaseBuild) == false) goto L15;
        monitor-enter(ApmContext.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (TextUtils.isEmpty(releaseBuild) == false) goto L9;
        releaseBuild = apmContextAdapter.getReleaseBuild();     // Catch: Throwable -> L11
    L9:
        monitor-exit(ApmContext.class);     // Catch: Throwable -> L11
    L15:
        return releaseBuild;
    }

    public static String getSessionId() {
        return apmContextAdapter.getSessionId();
    }

    public static JSONObject getStableHeaderExtras() {
        if (stableHeaderExtra != null) goto L15;
        monitor-enter(ApmContext.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (stableHeaderExtra != null) goto L9;
        stableHeaderExtra = apmContextAdapter.getStableHeaderExtras();     // Catch: Throwable -> L11
    L9:
        monitor-exit(ApmContext.class);     // Catch: Throwable -> L11
    L15:
        return stableHeaderExtra;
    }

    public static long getStartId() {
        if (startId >= 0) goto L6;
        startId = System.currentTimeMillis();
    L6:
        return startId;
    }

    public static int getUpdateVersionCode() {
        if (updateVersionCode != (-1)) goto L15;
        monitor-enter(ApmContext.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (updateVersionCode != (-1)) goto L9;
        updateVersionCode = apmContextAdapter.getUpdateVersionCode();     // Catch: Throwable -> L11
    L9:
        monitor-exit(ApmContext.class);     // Catch: Throwable -> L11
    L15:
        return updateVersionCode;
    }

    public static Map<String, String> getUrlParams() {
        if (cacheBaseUrlParams != null) goto L5;
        HashMap r10 = new HashMap();
        cacheBaseUrlParams = r10;
        r10.put("aid", String.valueOf(getAid()));
        cacheBaseUrlParams.put("os", "Android");
        cacheBaseUrlParams.put("device_platform", "android");
        cacheBaseUrlParams.put("os_api", Build.VERSION.SDK_INT + "");
        cacheBaseUrlParams.put("update_version_code", String.valueOf(getUpdateVersionCode()));
        cacheBaseUrlParams.put("version_code", getAppVersion());
        cacheBaseUrlParams.put("channel", getChannel());
        cacheBaseUrlParams.put("device_model", Build.MODEL);
        cacheBaseUrlParams.put("device_brand", Build.BRAND);
    L5:
        cacheBaseUrlParams.put("device_id", getDeviceId());
        if (ApmBaseContext.isDebugMode() == false) goto L20;
        cacheBaseUrlParams.put(CommonKey.KEY_LOG_LEVEL, "debug");
    L20:
        Map<String, String> r11 = getApmContextAdapter().getParamsExtras();     // Catch: Throwable -> L19
        if (r11 == null) goto L18;
        if (r11.size() <= 0) goto L18;
        Iterator<Map.Entry<String, String>> r12 = r11.entrySet().iterator();     // Catch: Throwable -> L19
    L14:
        if (r12.hasNext() == false) goto L18;
        Map.Entry<String, String> r13 = r12.next();     // Catch: Throwable -> L19
        cacheBaseUrlParams.put(r13.getKey(), r13.getValue());     // Catch: Throwable -> L19
    L18:
        return cacheBaseUrlParams;
    }

    public static long getUserID() {
        return apmContextAdapter.getUid();
    }

    public static int getVersionCode() {
        if (versionCode != (-1)) goto L15;
        monitor-enter(ApmContext.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (versionCode != (-1)) goto L9;
        versionCode = apmContextAdapter.getVersionCode();     // Catch: Throwable -> L11
    L9:
        monitor-exit(ApmContext.class);     // Catch: Throwable -> L11
    L15:
        return versionCode;
    }

    public static String getVersionName() {
        if (TextUtils.isEmpty(versionName) == false) goto L15;
        monitor-enter(ApmContext.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (TextUtils.isEmpty(versionName) == false) goto L9;
        versionName = apmContextAdapter.getVersionName();     // Catch: Throwable -> L11
    L9:
        monitor-exit(ApmContext.class);     // Catch: Throwable -> L11
    L15:
        return versionName;
    }

    public static boolean isMainProcess() {
        if (isMainProcess != null) goto L26;
        monitor-enter(ApmContext.class);
    L22:
        th = move-exception;
        throw th;
    L7:
        if (isMainProcess != null) goto L20;
        String r10 = getCurrentProcessName();     // Catch: Throwable -> L22
        if (r10 != null) goto L11;
    L14:
        if (r10 != null) goto L16;
    L18:
        boolean r11 = false;
    L19:
        Boolean r12 = Boolean.valueOf(r11);     // Catch: Throwable -> L22
    L13:
        isMainProcess = r12;     // Catch: Throwable -> L22
        goto L20
    L16:
        if (r10.equals(ApmBaseContext.getContext().getPackageName()) == false) goto L18;
        r11 = true;
        goto L19
    L11:
        if (r10.contains(":") == false) goto L14;
        r12 = Boolean.FALSE;     // Catch: Throwable -> L22
    L20:
        monitor-exit(ApmContext.class);     // Catch: Throwable -> L22
    L26:
        return isMainProcess.booleanValue();
    }

    public static void setApmContextAdapter(ApmContextAdapter r10) {
        if (r10 == null) goto L6;
        apmContextAdapter = r10;
        ApmBaseContext.setContext(r10.getContext());
        return;
    L6:
        throw new IllegalArgumentException("apmAdapter cannot be null!");
    }

    public static void setConfigTime(long r10) {
        configTime = r10;
    }

    public static void setInitTimeStamp(long r10) {
        initTimeStamp = r10;
    }

    public static void setNtpTimeService(e r10) {
        ntpTimeService = r10;
    }

    public static void setStartId(long r10) {
        startId = r10;
    }
}
