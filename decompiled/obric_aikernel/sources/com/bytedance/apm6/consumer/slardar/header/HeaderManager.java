package com.bytedance.apm6.consumer.slardar.header;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.apm6.consumer.slardar.Constants;
import com.bytedance.apm6.consumer.slardar.SlardarProperties;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.foundation.context.ApmContextAdapter;
import com.bytedance.apm6.util.ApmBaseContext;
import com.bytedance.apm6.util.JsonUtils;
import com.bytedance.apm6.util.RomUtils;
import com.bytedance.apm6.util.log.Logger;
import com.bytedance.apm6.util.timetask.AsyncTask;
import com.bytedance.apm6.util.timetask.AsyncTaskManager;
import com.bytedance.apm6.util.timetask.AsyncTaskManagerType;
import d0.e;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class HeaderManager {
    private static volatile HeaderManager sInstance;
    private HeaderInfo currentHeaderInfo;
    private Map<String, HeaderInfo> headers;
    private long nptOffset;
    private long nptTime;
    private AsyncTask ntpAsyncTask;

    public HeaderManager() {
        this.headers = new ConcurrentHashMap();
        this.nptOffset = -1;
        this.nptTime = -1;
    }

    static /* synthetic */ long access$002(HeaderManager r10, long r11) {
        r10.nptTime = r11;
        return r11;
    }

    static /* synthetic */ long access$102(HeaderManager r10, long r11) {
        r10.nptOffset = r11;
        return r11;
    }

    static /* synthetic */ AsyncTask access$200(HeaderManager r10) {
        return r10.ntpAsyncTask;
    }

    static /* synthetic */ AsyncTask access$202(HeaderManager r10, AsyncTask r11) {
        r10.ntpAsyncTask = r11;
        return r11;
    }

    public static HeaderManager getInstance() {
        if (sInstance != null) goto L15;
        monitor-enter(HeaderManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new HeaderManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(HeaderManager.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private void saveHeaderInfo(HeaderInfo r10) {
        String r11 = String.valueOf(HeaderUtils.getUniqueHeaderId());
        this.headers.put(r11, r10);
        this.currentHeaderInfo = r10;
        HeaderStoreManager.getInstance().saveHeaderInfo(r11, r10);
    }

    private void updateHeaderInfo(HeaderInfo r10) {
        if (r10 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r10.getDeviceId()) == false) goto L7;
        r10.setDeviceId(ApmContext.getDeviceId());
    L7:
        ApmContextAdapter r11 = ApmContext.getApmContextAdapter();
        if (r11 == null) goto L10;
        r10.setDynamicExtra(r11.getDynamicHeaderExtras());
    L10:
        long r12 = this.nptTime;
        if (r12 == (-1)) goto L13;
        r10.setNtpTime(r12);
        r10.setNtpOffset(this.nptOffset);
    L26:
        if (ApmBaseContext.isDebugMode() == false) goto L28;
        Logger.d(Constants.TAG, "nptTime:" + this.nptTime + " nptOffset:" + this.nptOffset);
    L28:
        r10.setUid(ApmContext.getUserID());
        r10.setConfigTime(ApmContext.getConfigTime());
        HeaderInfo r13 = this.currentHeaderInfo;
        if (r13 == null) goto L34;
        r10.setCurrentUpdateVersionCode(r13.getUpdateVersionCode());
        return;
    L34:
        return;
    L13:
        final e r14 = ApmContext.getNtpTimeService();
        if (r14 == null) goto L26;
        if (this.ntpAsyncTask != null) goto L26;
        monitor-enter(HeaderManager.class);
        this.ntpAsyncTask = new AnonymousClass1(this, r14);     // Catch: Throwable -> L22
        AsyncTaskManager.getInstance(AsyncTaskManagerType.LIGHT_WEIGHT).sendTask(this.ntpAsyncTask);     // Catch: Throwable -> L22
        monitor-exit(HeaderManager.class);     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        throw th;
    }

    public HeaderInfo getHeaderInfo(String r10) {
        if (this.headers.containsKey(r10) == false) goto L5;
        HeaderInfo r11 = this.headers.get(r10);
    L8:
        updateHeaderInfo(r11);
        return r11;
    L5:
        HeaderInfo r12 = HeaderStoreManager.getInstance().getHeaderInfo(r10);
        if (r12 == null) goto L11;
        this.headers.put(r10, r12);
        r11 = r12;
        goto L8
    L11:
        return this.currentHeaderInfo;
    }

    public void init() {
        HeaderInfo r10 = new HeaderInfo();
        r10.setOs("Android");
        r10.setDevicePlatform("android");
        r10.setOsVersion(Build.VERSION.RELEASE);
        r10.setApiVersion(Build.VERSION.SDK_INT);
        r10.setDeviceModel(Build.MODEL);
        r10.setDeviceBrand(Build.BRAND);
        r10.setDeviceManufacturer(Build.MANUFACTURER);
        r10.setProcessName(ApmContext.getCurrentProcessName());
        r10.setSid(ApmContext.getStartId());
        r10.setRomVersion(RomUtils.getRomInfo());
        r10.setVerifyInfo(SlardarProperties.getReleaseBuild());
        r10.setPhoneStartTime(ApmContext.getInitTimeStamp());
        r10.setChannel(ApmContext.getChannel());
        r10.setAid(ApmContext.getAid());
        r10.setUid(ApmContext.getUserID());
        r10.setUpdateVersionCode(String.valueOf(ApmContext.getUpdateVersionCode()));
        r10.setVersionName(ApmContext.getVersionName());
        r10.setVersionCode(String.valueOf(ApmContext.getVersionCode()));
        r10.setAppVersion(ApmContext.getAppVersion());
        r10.setReleaseBuild(ApmContext.getReleaseBuild());
        r10.setPackageName(ApmBaseContext.getContext().getPackageName());
        r10.setCurrentUpdateVersionCode(r10.getUpdateVersionCode());
        r10.setManifestVersionCode(ApmContext.getManifestVersionCode());
        r10.setConfigTime(ApmContext.getConfigTime());
        JSONObject r11 = new JSONObject();
        JsonUtils.copyJson2(r11, ApmContext.getStableHeaderExtras());     // Catch: Exception -> L19
        if (r11.has("version_code") == false) goto L7;
        r11.remove("version_code");     // Catch: Exception -> L19
    L7:
        if (r11.has("app_version") == false) goto L10;
        r11.remove("app_version");     // Catch: Exception -> L19
    L10:
        if (r11.has("uid") == false) goto L13;
        r11.remove("uid");     // Catch: Exception -> L19
    L13:
        if (r11.has("update_version_code") == false) goto L16;
        r11.remove("update_version_code");     // Catch: Exception -> L19
    L16:
        if (r11.has("manifest_version_code") == false) goto L21;
        r11.remove("manifest_version_code");     // Catch: Exception -> L19
    L21:
        r10.setStableExtra(r11);
        r10.setMonitorVersion("5.0.21.45-rc.0");
        if (ApmContext.isMainProcess() == false) goto L24;
        HeaderStoreManager.getInstance().deleteExpireFile();
    L24:
        saveHeaderInfo(r10);
        return;
    L19:
        e = move-exception;
        Logger.e("APM", "header json exception" + e.toString());
        goto L21
    }
}
