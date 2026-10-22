package com.bytedance.crash.monitor;

import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.Global;
import com.bytedance.crash.ICommonParams;
import com.bytedance.crash.diagnose.NpthMonitor;
import com.bytedance.crash.entity.Header;
import com.bytedance.crash.runtime.DefaultWorkThread;
import com.bytedance.crash.util.NpthLog;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class InnerAppMonitor extends AppMonitor {
    private Runnable getUserIdTask;
    private boolean isUpdatedStartTime;
    private final updateLock mCommonParamLock;
    private final updateLock mDeviceIdLock;
    private int mGetUserIdCount;
    private final ICommonParams mICommonParams;
    private final updateLock mUserIdLock;
    private String oldVersionName;

    class InitParamsUpdateTask implements Runnable {
        private static final int MAX_COUNT = 120;
        private static final int MINUTES = 60000;
        private static final int SECONDS = 1000;
        private int mCount;
        final /* synthetic */ InnerAppMonitor this$0;

        InitParamsUpdateTask(InnerAppMonitor r10) {
            this.this$0 = r10;
        }

        private long getDelay() {
            int r10 = this.mCount + 1;
            this.mCount = r10;
            if (r10 <= 120) goto L7;
            return -1;
        L7:
            if (r10 >= 30) goto L10;
            return 2000;
        L10:
            if (r10 >= 60) goto L14;
            return 5000;
        L14:
            return 600000;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.this$0.mDeviceId != null) goto L6;
            this.this$0.doUpdateDeviceId();
        L6:
            if (this.this$0.mAppId != null) goto L8;
        L15:
            this.this$0.doUpdateCommonParams();
        L17:
            if (this.this$0.mDeviceId != null) goto L19;
        L28:
            long r10 = getDelay();
            if (r10 < 0) goto L33;
            DefaultWorkThread.postDelayed(this, r10);
            return;
        L33:
            return;
        L19:
            if (this.this$0.mAppId == null) goto L28;
            if (this.this$0.mChannel == null) goto L28;
            if (InnerAppMonitor.access$200(this.this$0) == null) goto L28;
            if (this.this$0.mVersionName == null) goto L28;
            if (this.this$0.mVersionCode == 0) goto L28;
            return;
        L8:
            if (this.this$0.mChannel == null) goto L15;
            if (this.this$0.mVersionName == null) goto L15;
            if (this.this$0.mVersionCode == 0) goto L15;
            if (InnerAppMonitor.access$200(this.this$0) != null) goto L17;
            goto L15
        }
    }

    static class updateLock {
        updateLock() {
        }

        void notifyWaitTask() {
            monitor-enter(this);
            notifyAll();     // Catch: Throwable -> L6
            monitor-exit(this);     // Catch: Throwable -> L6
            return;
        L6:
            th = move-exception;
            throw th;
        }

        void waitUpdateTask(long r10) {
            monitor-enter(this);
            wait(r10);     // Catch: Throwable -> L9
        L12:
            monitor-exit(this);     // Catch: Throwable -> L6
            return;
        L6:
            th = move-exception;
            throw th;
        }
    }

    InnerAppMonitor(@NonNull ICommonParams r10) {
        this.mCommonParamLock = new updateLock();
        this.mDeviceIdLock = new updateLock();
        this.mUserIdLock = new updateLock();
        this.mGetUserIdCount = 3;
        this.getUserIdTask = new AnonymousClass1(this);
        this.mICommonParams = r10;
        DefaultWorkThread.post(new InitParamsUpdateTask(this));
        DefaultWorkThread.postDelayed(this.getUserIdTask, WsConstants.EXIT_DELAY_TIME);
    }

    static /* synthetic */ int access$000(InnerAppMonitor r10) {
        return r10.mGetUserIdCount;
    }

    static /* synthetic */ int access$010(InnerAppMonitor r10) {
        int r11 = r10.mGetUserIdCount;
        r10.mGetUserIdCount = r11 - 1;
        return r11;
    }

    static /* synthetic */ Runnable access$100(InnerAppMonitor r10) {
        return r10.getUserIdTask;
    }

    static /* synthetic */ String access$200(InnerAppMonitor r10) {
        return r10.oldVersionName;
    }

    static /* synthetic */ updateLock access$300(InnerAppMonitor r10) {
        return r10.mCommonParamLock;
    }

    static /* synthetic */ updateLock access$400(InnerAppMonitor r10) {
        return r10.mDeviceIdLock;
    }

    static /* synthetic */ updateLock access$500(InnerAppMonitor r10) {
        return r10.mUserIdLock;
    }

    private long parseLong(Object r10) {
        if (r10 != null) goto L8;
        return 0;
    L8:
        return Long.parseLong(String.valueOf(r10));
    L7:
        return 0;
    }

    void doUpdateAppStartTime(Map<String, Object> r10) {
        if (this.isUpdatedStartTime == false) goto L5;
        return;
    L5:
        Object r11 = r10.get("app_start_time");     // Catch: Throwable -> L12
        if (r11 != null) goto L8;
        return;
    L8:
        long r12 = parseLong(r11);     // Catch: Throwable -> L12
        if (r12 <= 0) goto L15;
        this.isUpdatedStartTime = true;     // Catch: Throwable -> L12
        Global.setAppStartTime(Long.valueOf(r12));     // Catch: Throwable -> L12
        return;
    L15:
        return;
    }

    void doUpdateCommonParams() {
        Map<String, Object> r10 = this.mICommonParams.getCommonParams();     // Catch: Throwable -> L57
        if (this.mAppId != null) goto L8;
        Object r11 = r10.get("aid");     // Catch: Throwable -> L57
        if (r11 == null) goto L8;
        setAppId(String.valueOf(r11));     // Catch: Throwable -> L57
    L8:
        doUpdateAppStartTime(r10);     // Catch: Throwable -> L57
        if (this.mChannel != null) goto L14;
        Object r12 = r10.get("channel");     // Catch: Throwable -> L57
        if ((r12 instanceof String) == false) goto L14;
        setChannel((String) r12);     // Catch: Throwable -> L57
    L14:
        if (this.mVersionName != null) goto L16;
    L19:
        Object r13 = r10.get("app_version");     // Catch: Throwable -> L57
        Object r14 = r10.get("version_code");     // Catch: Throwable -> L57
        Object r15 = r10.get("version_name");     // Catch: Throwable -> L57
        if ((r15 instanceof String) == false) goto L22;
        this.oldVersionName = (String) r15;     // Catch: Throwable -> L57
    L22:
        String r16 = this.oldVersionName;     // Catch: Throwable -> L57
        if (r16 == null) goto L26;
        r13 = r16;
    L26:
        if ((r13 instanceof String) == true) goto L28;
        return;
    L28:
        Object r17 = null;
        if (r14 != null) goto L31;
        PackageInfo r18 = Global.getContext().getPackageManager().getPackageInfo(Global.getContext().getPackageName(), 128);     // Catch: Throwable -> L57
        Object r19 = Integer.valueOf(r18.versionCode);     // Catch: Throwable -> L57
    L32:
        long r110 = parseLong(r10.get("manifest_version_code"));     // Catch: Throwable -> L57
        long r111 = parseLong(r10.get("update_version_code"));     // Catch: Throwable -> L57
        if (r111 != 0) goto L44;
        if (r18 == null) goto L63;
    L37:
        Bundle r20 = r18.applicationInfo.metaData;     // Catch: Throwable -> L60
        if (r20 == null) goto L40;
        r17 = r20.get("UPDATE_VERSION_CODE");     // Catch: Throwable -> L60
    L40:
        if (r17 != null) goto L42;
        r17 = Long.valueOf(parseLong(r10.get("version_code")));     // Catch: Throwable -> L60
    L42:
        r111 = parseLong(r17);     // Catch: Throwable -> L60
        goto L44
    L63:
        r18 = Global.getContext().getPackageManager().getPackageInfo(Global.getContext().getPackageName(), 128);     // Catch: Throwable -> L60
    L44:
        if ((r19 instanceof Long) == false) goto L46;
    L61:
        long r21 = parseLong(r19);     // Catch: Throwable -> L54
        if (r110 > 0) goto L52;
        r110 = r21;
    L52:
        setVersion(r21, r111, r110, (String) r13);     // Catch: Throwable -> L54
    L69:
        return;
    L54:
        th = move-exception;
        NpthMonitor.reportInnerException(th);     // Catch: Throwable -> L57
        return;
    L46:
        if ((r19 instanceof Integer) == true) goto L61;
        if ((r19 instanceof String) == true) goto L61;
        return;
    L31:
        r19 = r14;
        r18 = null;
        goto L32
    L16:
        if (this.mVersionCode == 0) goto L19;
        if (this.oldVersionName == null) goto L19;
        return;
    L57:
        th = move-exception;
        NpthLog.e(th);
    }

    void doUpdateDeviceId() {
        String r10 = this.mICommonParams.getDeviceId();     // Catch: Throwable -> L6
        NpthLog.i("ConfigManager", "doUpdateDeviceId:" + r10);     // Catch: Throwable -> L6
        if (r10 == null) goto L11;
        setDeviceId(r10);     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        NpthMonitor.reportInnerException(th);
    }

    void doUpdateUserId() {
        long r10 = this.mICommonParams.getUserId();     // Catch: Throwable -> L6
        if (r10 == 0) goto L11;
        setUserId(r10);     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        NpthMonitor.reportInnerException(th);
    }

    @Override // com.bytedance.crash.monitor.CrashListener, com.bytedance.crash.monitor.EventMonitor
    public String getAppId() {
        if (this.mAppId != null) goto L6;
        updateCommonParams();
    L6:
        return super.getAppId();
    }

    @Override // com.bytedance.crash.monitor.CrashListener, com.bytedance.crash.monitor.EventMonitor
    public String getChannel() {
        if (this.mChannel != null) goto L6;
        updateCommonParams();
    L6:
        return super.getChannel();
    }

    @Override // com.bytedance.crash.monitor.AppMonitor, com.bytedance.crash.monitor.EventMonitor
    public Map<String, Object> getCommParams() {
        ICommonParams r10 = this.mICommonParams;
        HashMap r11 = null;
        if (r10 == null) goto L23;
        Map<String, Object> r12 = r10.getCommonParams();
        if (r12 == null) goto L12;
        r11 = new HashMap(r12);
        if (r11.containsKey("version_name") == true) goto L25;
    L11:
        r11.remove("release_build");
        goto L12
    L25:
        if (r11.containsKey("app_version") == true) goto L11;
        r11.put("app_version", r11.get("version_name"));     // Catch: Throwable -> L24
        r11.put("app_version_from_name", NetConst.ENCRYPT_VERISON_CODE);     // Catch: Throwable -> L24
    L12:
        String r13 = this.mICommonParams.getSessionId();
        long r14 = this.mICommonParams.getUserId();
        if (r13 == null) goto L15;
    L16:
        if (r11 != null) goto L18;
        r11 = new HashMap();
    L18:
        if (r13 == null) goto L21;
        r11.put("session_id", r13);
    L21:
        if (r14 <= 0) goto L23;
        r11.put(Header.KEY_USER_ID, Long.valueOf(r14));
        goto L23
    L15:
        if (r14 > 0) goto L16;
    L23:
        return r11;
    }

    @Override // com.bytedance.crash.monitor.CrashListener, com.bytedance.crash.monitor.EventMonitor
    @NonNull
    public String getDeviceId(String r10) {
        if (TextUtils.isEmpty(this.mDeviceId) == false) goto L6;
        updateDeviceId();
    L6:
        return super.getDeviceId(r10);
    }

    public ICommonParams getICommonParams() {
        return this.mICommonParams;
    }

    @Override // com.bytedance.crash.monitor.CrashListener, com.bytedance.crash.monitor.EventMonitor
    public long getManifestVersionCode() {
        if (this.mVersionName != null) goto L5;
    L6:
        updateCommonParams();
    L8:
        return super.getManifestVersionCode();
    L5:
        if (this.mVersionCode != 0) goto L8;
        goto L6
    }

    public String getSessionId() {
        ICommonParams r10 = this.mICommonParams;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.getSessionId();
    }

    @Override // com.bytedance.crash.monitor.CrashListener, com.bytedance.crash.monitor.EventMonitor
    public long getUpdateVersionCode() {
        if (this.mVersionName != null) goto L5;
    L6:
        updateCommonParams();
    L8:
        return super.getUpdateVersionCode();
    L5:
        if (this.mVersionCode != 0) goto L8;
        goto L6
    }

    @Override // com.bytedance.crash.monitor.CrashListener, com.bytedance.crash.monitor.EventMonitor
    public long getUserId() {
        if (this.mUserId != 0) goto L6;
        updateUserId();
    L6:
        return super.getUserId();
    }

    @Override // com.bytedance.crash.monitor.CrashListener, com.bytedance.crash.monitor.EventMonitor
    @NonNull
    public AppVersionModel getVersion() {
        if (this.mVersionName != null) goto L5;
    L6:
        updateCommonParams();
    L8:
        return super.getVersion();
    L5:
        if (this.mVersionCode != 0) goto L8;
        goto L6
    }

    @Override // com.bytedance.crash.monitor.CrashListener, com.bytedance.crash.monitor.EventMonitor
    public long getVersionCode() {
        if (this.mVersionName != null) goto L5;
    L6:
        updateCommonParams();
    L8:
        return super.getVersionCode();
    L5:
        if (this.mVersionCode != 0) goto L8;
        goto L6
    }

    @Override // com.bytedance.crash.monitor.CrashListener, com.bytedance.crash.monitor.EventMonitor
    public String getVersionName() {
        if (this.mVersionName != null) goto L5;
    L6:
        updateCommonParams();
    L8:
        return super.getVersionName();
    L5:
        if (this.mVersionCode != 0) goto L8;
        goto L6
    }

    protected void setAppId(String r10) {
        this.mAppId = r10;
        this.mCacheManager.setAppId(r10);
    }

    protected void setVersion(long r10, long r11, long r13, @NonNull String r15) {
        this.mUpdateVersionCode = r11;
        this.mVersionCode = r10;
        this.mVersionName = r15;
        this.mManifestVersionCode = r13;
        this.mCacheManager.setVersion(r10, r11, r13, r15);
        Global.setAppVersion(r10, r11, r13, r15);
    }

    void updateCommonParams() {
        if (DefaultWorkThread.getThread() != Thread.currentThread()) goto L5;
        doUpdateCommonParams();
        return;
    L5:
        DefaultWorkThread.post(new AnonymousClass2(this));
        this.mCommonParamLock.waitUpdateTask(200);
    }

    void updateDeviceId() {
        if (DefaultWorkThread.getThread() != Thread.currentThread()) goto L5;
        doUpdateDeviceId();
        return;
    L5:
        DefaultWorkThread.post(new AnonymousClass3(this));
        this.mDeviceIdLock.waitUpdateTask(100);
    }

    void updateUserId() {
        if (DefaultWorkThread.getThread() != Thread.currentThread()) goto L5;
        doUpdateUserId();
        return;
    L5:
        DefaultWorkThread.post(new AnonymousClass4(this));
        this.mUserIdLock.waitUpdateTask(200);
    }
}
