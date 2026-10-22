package com.obric.memorydata.memory.tracker;

import android.content.Context;
import android.provider.Settings;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.memory.ui.settings.l;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.store.IStore;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.obric.memorydata.recommend.RecommendApi;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\u000b\u001a\u00020\tJ\u0018\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005H\u0002J\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/obric/memorydata/memory/tracker/MemorySwitchReporter;", "", "<init>", "()V", "TAG", "", "LAST_REPORT_TIMESTAMP_KEY", "reportLock", "reportOnSwitchChanged", "", "reportOnScreenOn", "clearReportTimestampForDebug", "report", "force", "", "trigger", "isSettingEnabled", "key", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f10542a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Object f10543b = null;

    static {
        f10542a = new f();
        f10543b = new Object();
    }

    private f() {
    }

    private final void a(boolean r21, String r22) {
        Object r1 = f10543b;
        monitor-enter(r1);
        IStore r2 = StoreManager.INSTANCE.getPersonalStore();     // Catch: Throwable -> L38
        if (r2 != null) goto L10;
        if (r21 == true) goto L10;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemorySwitchReporter", "skip passive report because personal store is unavailable", null, 4, null);     // Catch: Throwable -> L38
        monitor-exit(r1);
        return;
    L10:
        long r3 = System.currentTimeMillis();     // Catch: Throwable -> L38
        long r5 = 0;
        if (r2 == null) goto L13;
        r5 = r2.getLong("memory_switch_last_report_timestamp_ms", 0);     // Catch: Throwable -> L38
    L13:
        if (r21 == false) goto L15;
        MemorySwitchReportGate.a r7 = null;
    L16:
        boolean r8 = false;
        if (r7 != null) goto L19;
    L21:
        if (r8 == false) goto L25;
        RunLog.INSTANCE.debug("MemorySwitchReporter", "skip report: trigger=" + r22 + ", reason=" + r7.b() + ", last=" + r5 + ", now=" + r3);     // Catch: Throwable -> L38
        monitor-exit(r1);
        return;
    L25:
        l r6 = l.f11479a.a();     // Catch: Throwable -> L38
        boolean r9 = ((Boolean) ZeusTransformUtils.preCheckCast(r6.a().c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();     // Catch: Throwable -> L38
        boolean r10 = ((Boolean) ZeusTransformUtils.preCheckCast(RecommendApi.INSTANCE.screenObservationEnabled().c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();     // Catch: Throwable -> L38
        boolean r11 = ((Boolean) ZeusTransformUtils.preCheckCast(r6.d().c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();     // Catch: Throwable -> L38
        f r12 = f10542a;     // Catch: Throwable -> L38
        boolean r13 = r12.a(ObricMemoryConstants.SETTINGS_KEY_SHORTCUT_KEY_ENABLED);     // Catch: Throwable -> L38
        boolean r14 = r12.a(ObricMemoryConstants.SETTINGS_KEY_SHORTCUT_GESTURE_ENABLED);     // Catch: Throwable -> L38
        IRunLog r15 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L38
        StringBuilder r0 = new StringBuilder().append("report: trigger=").append(r22).append(", reason=");     // Catch: Throwable -> L38
        if (r7 == null) goto L29;
        Object r16 = r7.b();     // Catch: Throwable -> L38
        if (r16 == null) goto L29;
    L30:
        IRunLog.a.a(r15, "MemorySwitchReporter", r0.append(r16).append(", autoMemory=").append(r9).append(", screenObservation=").append(r10).append(", auditoryMemory=").append(r11).append(", keyShortcut=").append(r13).append(", gestureShortcut=").append(r14).toString(), false, 4, null);     // Catch: Throwable -> L38
        MemoryEventTracker.f10515a.a(r9, r10, r11, r13, r14);     // Catch: Throwable -> L38
        if (r2 != null) goto L35;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemorySwitchReporter", "report completed without timestamp because personal store is unavailable", null, 4, null);     // Catch: Throwable -> L38
        monitor-exit(r1);
        return;
    L35:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemorySwitchReporter", "persist report timestamp: success=" + r2.syncSave("memory_switch_last_report_timestamp_ms", r3) + ", timestamp=" + r3, false, 4, null);     // Catch: Throwable -> L38
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L38
        monitor-exit(r1);
        return;
    L29:
        r16 = "forced";
        goto L30
    L19:
        if (r7.a() == true) goto L21;
        r8 = true;
        goto L21
    L15:
        r7 = MemorySwitchReportGate.a(MemorySwitchReportGate.f10526a, r5, r3, null, 4, null);     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        throw th;
    }

    private final boolean a(String r3) {
        if (Settings.System.getInt(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver(), r3, 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final void a() {
        a(true, "switch_changed");
    }

    public final void b() {
        a(false, "screen_on");
    }
}
