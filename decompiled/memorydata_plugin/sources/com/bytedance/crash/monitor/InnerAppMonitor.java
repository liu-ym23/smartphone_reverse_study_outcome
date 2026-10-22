package com.bytedance.crash.monitor;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.bytedance.crash.Global;
import com.bytedance.crash.ICommonParams;
import com.bytedance.crash.diagnose.NpthMonitor;
import com.bytedance.crash.entity.Header;
import com.bytedance.crash.runtime.DefaultWorkThread;
import com.bytedance.crash.util.NpthLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
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

        InitParamsUpdateTask(InnerAppMonitor r1) {
            this.this$0 = r1;
        }

        private long getDelay() {
            int r0 = this.mCount + 1;
            this.mCount = r0;
            if (r0 <= 120) goto L7;
            return -1;
        L7:
            if (r0 >= 30) goto L10;
            return 2000;
        L10:
            if (r0 >= 60) goto L14;
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
            long r3 = getDelay();
            if (r3 < 0) goto L33;
            DefaultWorkThread.postDelayed(this, r3);
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

        void waitUpdateTask(long r1) {
            monitor-enter(this);
            wait(r1);     // Catch: Throwable -> L9
        L12:
            monitor-exit(this);     // Catch: Throwable -> L6
            return;
        L6:
            th = move-exception;
            throw th;
        }
    }

    InnerAppMonitor(ICommonParams r3) {
        ICommonParams r4 = (ICommonParams) ZeusTransformUtils.wrapperContextForParams(r3, ICommonParams.class, "com.obric.memorydata.plugin");
        this.mCommonParamLock = new updateLock();
        this.mDeviceIdLock = new updateLock();
        this.mUserIdLock = new updateLock();
        this.mGetUserIdCount = 3;
        this.getUserIdTask = new AnonymousClass1(this);
        this.mICommonParams = r4;
        DefaultWorkThread.post(new InitParamsUpdateTask(this));
        DefaultWorkThread.postDelayed(this.getUserIdTask, 3000);
    }

    static /* synthetic */ int access$000(InnerAppMonitor r0) {
        return r0.mGetUserIdCount;
    }

    static /* synthetic */ int access$010(InnerAppMonitor r2) {
        int r0 = r2.mGetUserIdCount;
        r2.mGetUserIdCount = r0 - 1;
        return r0;
    }

    static /* synthetic */ Runnable access$100(InnerAppMonitor r0) {
        return r0.getUserIdTask;
    }

    static /* synthetic */ String access$200(InnerAppMonitor r0) {
        return r0.oldVersionName;
    }

    static /* synthetic */ updateLock access$300(InnerAppMonitor r0) {
        return r0.mCommonParamLock;
    }

    static /* synthetic */ updateLock access$400(InnerAppMonitor r0) {
        return r0.mDeviceIdLock;
    }

    static /* synthetic */ updateLock access$500(InnerAppMonitor r0) {
        return r0.mUserIdLock;
    }

    private long parseLong(Object r3) {
        if (r3 != null) goto L8;
        return 0;
    L8:
        return Long.parseLong(String.valueOf(r3));
    L7:
        return 0;
    }

    void doUpdateAppStartTime(Map<String, Object> r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        if (this.isUpdatedStartTime == false) goto L6;
        return;
    L6:
        Object r7 = r6.get("app_start_time");     // Catch: Throwable -> L13
        if (r7 != null) goto L9;
        return;
    L9:
        long r0 = parseLong(r7);     // Catch: Throwable -> L13
        if (r0 <= 0) goto L16;
        this.isUpdatedStartTime = true;     // Catch: Throwable -> L13
        Global.setAppStartTime(Long.valueOf(r0));     // Catch: Throwable -> L13
        return;
    L16:
        return;
    }

    void doUpdateCommonParams() {
        Map<String, Object> r2 = this.mICommonParams.getCommonParams();     // Catch: Throwable -> L59
        if (this.mAppId != null) goto L8;
        Object r3 = r2.get("aid");     // Catch: Throwable -> L59
        if (r3 == null) goto L8;
        setAppId(String.valueOf(r3));     // Catch: Throwable -> L59
    L8:
        doUpdateAppStartTime(r2);     // Catch: Throwable -> L59
        if (this.mChannel != null) goto L15;
        Object r4 = r2.get("channel");     // Catch: Throwable -> L59
        if (ZeusTransformUtils.instanceOf(r4, String.class) == false) goto L15;
        setChannel((String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L59
    L15:
        if (this.mVersionName != null) goto L17;
    L20:
        Object r5 = r2.get("app_version");     // Catch: Throwable -> L59
        Object r7 = r2.get("version_code");     // Catch: Throwable -> L59
        Object r8 = r2.get("version_name");     // Catch: Throwable -> L59
        if (ZeusTransformUtils.instanceOf(r8, String.class) == false) goto L23;
        this.oldVersionName = (String) ZeusTransformUtils.preCheckCast(r8, String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L59
    L23:
        String r9 = this.oldVersionName;     // Catch: Throwable -> L59
        if (r9 == null) goto L27;
        r5 = r9;
    L27:
        if (ZeusTransformUtils.instanceOf(r5, String.class) == true) goto L30;
        return;
    L30:
        if (r7 != null) goto L32;
        PackageInfo r10 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(Global.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getPackageManager().getPackageInfo(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(Global.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getPackageName(), 128);     // Catch: Throwable -> L59
        Object r11 = Integer.valueOf(r10.versionCode);     // Catch: Throwable -> L59
    L33:
        long r12 = parseLong(r2.get("manifest_version_code"));     // Catch: Throwable -> L59
        long r13 = parseLong(r2.get("update_version_code"));     // Catch: Throwable -> L59
        if (r13 != 0) goto L46;
        if (r10 != null) goto L39;
        r10 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(Global.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getPackageManager().getPackageInfo(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(Global.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getPackageName(), 128);     // Catch: Throwable -> L62
    L39:
        if (r10.applicationInfo.metaData == null) goto L41;
        Object r14 = r10.applicationInfo.metaData.get("UPDATE_VERSION_CODE");     // Catch: Throwable -> L62
    L42:
        if (r14 != null) goto L44;
        r14 = Long.valueOf(parseLong(r2.get("version_code")));     // Catch: Throwable -> L62
    L44:
        r13 = parseLong(r14);     // Catch: Throwable -> L62
        goto L46
    L41:
        r14 = null;
    L46:
        if (ZeusTransformUtils.instanceOf(r11, Long.class) == false) goto L48;
    L65:
        long r15 = parseLong(r11);     // Catch: Throwable -> L56
        if (r12 > 0) goto L54;
        r12 = r15;
    L54:
        long r6 = r13;
        long r16 = r12;
        setVersion(r15, r6, r16, (String) ZeusTransformUtils.preCheckCast(r5, String.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L56
    L71:
        return;
    L56:
        th = move-exception;
        NpthMonitor.reportInnerException(th);     // Catch: Throwable -> L59
        return;
    L48:
        if (ZeusTransformUtils.instanceOf(r11, Integer.class) == true) goto L65;
        if (ZeusTransformUtils.instanceOf(r11, String.class) == true) goto L65;
        return;
    L32:
        r11 = r7;
        r10 = null;
        goto L33
    L17:
        if (this.mVersionCode == 0) goto L20;
        if (this.oldVersionName == null) goto L20;
        return;
    L59:
        th = move-exception;
        NpthLog.e(th);
    }

    void doUpdateDeviceId() {
        String r0 = this.mICommonParams.getDeviceId();     // Catch: Throwable -> L6
        NpthLog.i("ConfigManager", "doUpdateDeviceId:" + r0);     // Catch: Throwable -> L6
        if (r0 == null) goto L11;
        setDeviceId(r0);     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        NpthMonitor.reportInnerException(th);
    }

    void doUpdateUserId() {
        long r0 = this.mICommonParams.getUserId();     // Catch: Throwable -> L6
        if (r0 == 0) goto L11;
        setUserId(r0);     // Catch: Throwable -> L6
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
        ICommonParams r1 = this.mICommonParams;
        HashMap r2 = null;
        if (r1 == null) goto L23;
        Map<String, Object> r3 = r1.getCommonParams();
        if (r3 == null) goto L12;
        r2 = new HashMap(r3);
        if (r2.containsKey("version_name") == true) goto L25;
    L11:
        r2.remove("release_build");
        goto L12
    L25:
        if (r2.containsKey("app_version") == true) goto L11;
        r2.put("app_version", r2.get("version_name"));     // Catch: Throwable -> L24
        r2.put("app_version_from_name", "1");     // Catch: Throwable -> L24
    L12:
        String r0 = this.mICommonParams.getSessionId();
        long r4 = this.mICommonParams.getUserId();
        if (r0 == null) goto L15;
    L16:
        if (r2 != null) goto L18;
        r2 = new HashMap();
    L18:
        if (r0 == null) goto L21;
        r2.put("session_id", r0);
    L21:
        if (r4 <= 0) goto L23;
        r2.put(Header.KEY_USER_ID, Long.valueOf(r4));
        goto L23
    L15:
        if (r4 > 0) goto L16;
    L23:
        return r2;
    }

    @Override // com.bytedance.crash.monitor.CrashListener, com.bytedance.crash.monitor.EventMonitor
    public String getDeviceId(String r2) {
        if (TextUtils.isEmpty(this.mDeviceId) == false) goto L6;
        updateDeviceId();
    L6:
        return super.getDeviceId(r2);
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
        ICommonParams r0 = this.mICommonParams;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getSessionId();
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

    public void setAppId(String r1) {
        this.mAppId = r1;
        this.mCacheManager.setAppId(r1);
    }

    public void setVersion(long r9, long r11, long r13, String r15) {
        this.mUpdateVersionCode = r11;
        this.mVersionCode = r9;
        this.mVersionName = r15;
        this.mManifestVersionCode = r13;
        this.mCacheManager.setVersion(r9, r11, r13, r15);
        Global.setAppVersion(r9, r11, r13, r15);
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
