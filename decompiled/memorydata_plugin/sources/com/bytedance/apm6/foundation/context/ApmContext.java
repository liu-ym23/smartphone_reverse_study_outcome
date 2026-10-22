package com.bytedance.apm6.foundation.context;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.apm.d.e;
import com.bytedance.apm6.service.ServiceManager;
import com.bytedance.apm6.util.ApmBaseContext;
import com.bytedance.apm6.util.constant.CommonKey;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.services.apm.api.IHttpService;
import com.bytedance.services.apm.api.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.json.JSONObject;

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

    public static c doGet(String r3, Map<String, String> r4) {
        Map<String, String> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        return ((IHttpService) ZeusTransformUtils.preCheckCast(ServiceManager.getService(IHttpService.class), IHttpService.class, "com.obric.memorydata.plugin")).doGet(r3, r5);
    }

    public static c doPost(String r3, Map<String, String> r4, byte[] r5) {
        Map<String, String> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        return ((IHttpService) ZeusTransformUtils.preCheckCast(ServiceManager.getService(IHttpService.class), IHttpService.class, "com.obric.memorydata.plugin")).doPost(r3, r5, r6);
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
        HashMap r0 = new HashMap();
        cacheBaseUrlParams = r0;
        r0.put("aid", String.valueOf(getAid()));
        cacheBaseUrlParams.put("os", LocationInfoConst.SYSTEM);
        cacheBaseUrlParams.put("device_platform", "android");
        cacheBaseUrlParams.put("os_api", Build.VERSION.SDK_INT + "");
        cacheBaseUrlParams.put("update_version_code", String.valueOf(getUpdateVersionCode()));
        cacheBaseUrlParams.put("version_code", getAppVersion());
        cacheBaseUrlParams.put("channel", getChannel());
        cacheBaseUrlParams.put("device_model", Build.MODEL);
        cacheBaseUrlParams.put("device_brand", Build.BRAND);
    L5:
        cacheBaseUrlParams.put("device_id", getDeviceId());
        if (isDebugMode() == false) goto L20;
        cacheBaseUrlParams.put(CommonKey.KEY_LOG_LEVEL, "debug");
    L20:
        Map<String, String> r1 = getApmContextAdapter().getParamsExtras();     // Catch: Throwable -> L19
        if (r1 == null) goto L18;
        if (r1.size() <= 0) goto L18;
        Iterator<Map.Entry<String, String>> r2 = r1.entrySet().iterator();     // Catch: Throwable -> L19
    L14:
        if (r2.hasNext() == false) goto L18;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r2.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
        cacheBaseUrlParams.put((String) r3.getKey(), (String) r3.getValue());     // Catch: Throwable -> L19
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
        if (isMainProcess != null) goto L25;
        monitor-enter(ApmContext.class);
    L21:
        th = move-exception;
        throw th;
    L7:
        if (isMainProcess != null) goto L19;
        String r1 = getCurrentProcessName();     // Catch: Throwable -> L21
        boolean r2 = false;
        if (r1 != null) goto L11;
    L14:
        if (r1 != null) goto L16;
    L18:
        boolean r3 = Boolean.valueOf(r2);     // Catch: Throwable -> L21
    L13:
        isMainProcess = r3;     // Catch: Throwable -> L21
        goto L19
    L16:
        if (r1.equals(((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin")).getPackageName()) == false) goto L18;
        r2 = true;
        goto L18
    L11:
        if (r1.contains(ParameterizedMessage.ERROR_MSG_SEPARATOR) == false) goto L14;
        r3 = false;     // Catch: Throwable -> L21
    L19:
        monitor-exit(ApmContext.class);     // Catch: Throwable -> L21
    L25:
        return isMainProcess.booleanValue();
    }

    public static void setApmContextAdapter(ApmContextAdapter r2) {
        ApmContextAdapter r3 = (ApmContextAdapter) ZeusTransformUtils.wrapperContextForParams(r2, ApmContextAdapter.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L7;
        apmContextAdapter = r3;
        ApmBaseContext.setContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        return;
    L7:
        throw new IllegalArgumentException("apmAdapter cannot be null!");
    }

    public static void setConfigTime(long r0) {
        configTime = r0;
    }

    public static void setInitTimeStamp(long r0) {
        initTimeStamp = r0;
    }

    public static void setNtpTimeService(e r2) {
        ntpTimeService = (e) ZeusTransformUtils.wrapperContextForParams(r2, e.class, "com.obric.memorydata.plugin");
    }

    public static void setStartId(long r0) {
        startId = r0;
    }
}
