package com.obric.memorydata.middleware.impl.a;

import android.os.SystemClock;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.bdtracker.Tracker;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.store.IStore;
import com.obric.memorydata.middleware.api.store.IStoreManager;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010\n\u001a\u00020\tJ\b\u0010\u000b\u001a\u00020\tH\u0016J\u000e\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/memorydata/middleware/impl/mtbf/MtbfReporter;", "Lcom/obric/memorydata/middleware/api/bdtracker/DailyReportCallback;", "<init>", "()V", "TAG", "", "KEY_CHECK_TIME", "KEY_USE_TOTAL_TIME", "onProcessStart", "", "checkPoint", "onDailyReport", "reportFailure", "type", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a implements com.obric.memorydata.middleware.api.bdtracker.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f11674a = null;

    static {
        f11674a = new a();
    }

    private a() {
    }

    @Override // com.obric.memorydata.middleware.api.bdtracker.a
    public void a() {
        c();
        IStore r12 = IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null);
        long r4 = r12.getLong("mtbf_use_total_time_ms", 0);
        if (r4 > 0) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MtbfReporter", "skip daily report: totalMs=" + r4, false, 4, null);
        return;
    L6:
        JSONObject r1 = new JSONObject();
        r1.put("duration", r4 / 1000);
        Tracker.INSTANCE.reportEvent("mtbf_device_total_runtime", r1);
        r12.remove(new String[]{"mtbf_use_total_time_ms"});
    }

    public final void a(String r8) {
        Intrinsics.checkNotNullParameter(r8, "type");
        IStore r1 = IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null);
        c();
        r1.remove(new String[]{"mtbf_last_check_elapsed"});
        JSONObject r7 = new JSONObject();
        r7.put("type", r8);
        Tracker.INSTANCE.reportEvent("mtbf_failure", r7);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MtbfReporter", "report mtbf_failure type=" + r8, false, 4, null);
    }

    public final void b() {
        IStore r0 = IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null);
        Tracker.INSTANCE.registerDailyReportCallback((com.obric.memorydata.middleware.api.bdtracker.a) ZeusTransformUtils.preCheckCast(this, com.obric.memorydata.middleware.api.bdtracker.a.class, "com.obric.memorydata.plugin"));
        long r3 = SystemClock.elapsedRealtime();
        long r7 = r0.getLong("mtbf_last_check_elapsed", 0);
        if (r7 != 0) goto L7;
        r0.save("mtbf_last_check_elapsed", r3);
        RunLog.INSTANCE.debug("MtbfReporter", "init check_time with nowElapsed=" + r3);
        return;
    L7:
        if (r7 <= r3) goto L10;
        r0.save("mtbf_last_check_elapsed", r3);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MtbfReporter", "device reboot detected, reset check_time to " + r3, false, 4, null);
        return;
    }

    public final void c() {
        IStore r12 = IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null);
        long r0 = SystemClock.elapsedRealtime();
        long r5 = r12.getLong("mtbf_last_check_elapsed", 0);
        long r8 = r12.getLong("mtbf_use_total_time_ms", 0);
        if (r5 != 0) goto L7;
        r12.save("mtbf_last_check_elapsed", r0);
        RunLog r13 = RunLog.INSTANCE;
        StringBuilder r2 = new StringBuilder();
        String r3 = "missing check_time, set to nowElapsed=";
    L5:
        r13.debug("MtbfReporter", r2.append(r3).append(r0).toString());
        return;
    L7:
        long r6 = r0 - r5;
        if (r6 <= 0) goto L10;
        long r9 = r8 + r6;
        r12.save("mtbf_use_total_time_ms", r9);
        RunLog.INSTANCE.debug("MtbfReporter", "checkpoint delta=" + r6 + ", totalMs=" + r9);
    L10:
        r12.save("mtbf_last_check_elapsed", r0);
        r13 = RunLog.INSTANCE;
        r2 = new StringBuilder();
        r3 = "update check_time to nowElapsed=";
        goto L5
    }
}
