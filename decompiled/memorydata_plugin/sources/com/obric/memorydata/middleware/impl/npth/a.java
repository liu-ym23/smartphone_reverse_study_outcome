package com.obric.memorydata.middleware.impl.npth;

import com.bytedance.crash.entity.EventBody;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.bdtracker.Tracker;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.store.IStoreManager;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.obric.memorydata.utils.handler.GlobalHandlerUtil;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000?\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005*\u0001\u000b\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\u0006\u0010\u001a\u001a\u00020\u0014J\b\u0010\u001b\u001a\u00020\u0014H\u0002J\u0010\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\fR\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001e"}, d2 = {"Lcom/obric/memorydata/middleware/impl/npth/CrashTeaEventReporter;", "", "<init>", "()V", "TAG", "", "PENDING_EVENTS_KEY", "privacyListenerLock", "privacyListenerRegistered", "", "privacyListener", "com/obric/memorydata/middleware/impl/npth/CrashTeaEventReporter$privacyListener$1", "Lcom/obric/memorydata/middleware/impl/npth/CrashTeaEventReporter$privacyListener$1;", "delegate", "Lcom/obric/memorydata/middleware/impl/npth/PendingCrashTeaEventReporter;", "getDelegate", "()Lcom/obric/memorydata/middleware/impl/npth/PendingCrashTeaEventReporter;", "delegate$delegate", "Lkotlin/Lazy;", "reportFatal", "", "eventName", TrackerImpl.PARAMS, "Lorg/json/JSONObject;", "crashTimeMs", "", "replayPending", "registerPrivacyListenerOnce", "logFailure", "code", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f11788a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Object f11789b = null;
    private static boolean c;
    private static final C0637a d = null;
    private static final Lazy e = null;

    /* JADX INFO: renamed from: com.obric.memorydata.middleware.impl.npth.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, d2 = {"com/obric/memorydata/middleware/impl/npth/CrashTeaEventReporter$privacyListener$1", "Lcom/obric/memorydata/middleware/api/app/AgreePrivacyListener;", "onAgree", "", "onDisagree", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class C0637a implements com.obric.memorydata.middleware.api.app.a {
        C0637a() {
        }

        private static final void c() {
            a.a(a.f11788a).a();
        }

        /* JADX INFO: renamed from: lambda$240aX__94eiseLan2zt-lMXJT-A, reason: not valid java name */
        public static /* synthetic */ void m1030lambda$240aX__94eiseLan2ztlMXJTA() {
            c();
        }

        @Override // com.obric.memorydata.middleware.api.app.a
        public void a() {
            GlobalHandlerUtil.Companion.getInstance().sendMsg($$Lambda$a$a$240aX__94eiseLan2ztlMXJTA.INSTANCE);     // Catch: Throwable -> L4
            return;
        L4:
            a.a(a.f11788a, "privacy_replay_schedule_failed");
        }

        @Override // com.obric.memorydata.middleware.api.app.a
        public void b() {
        }
    }

    static {
        f11788a = new a();
        f11789b = new Object();
        d = new C0637a();
        e = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, $$Lambda$a$oViZSdCSMXVuAAlEVlKP2qzzvjo.INSTANCE);
    }

    private a() {
    }

    public static final /* synthetic */ f a(a r0) {
        return r0.b();
    }

    private static final Unit a(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "eventName");
        Intrinsics.checkNotNullParameter(r3, "paramsJson");
        Tracker.INSTANCE.reportDevEvent(r2, new JSONObject(r3));
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ void a(a r0, String r1) {
        r0.a(r1);
    }

    private final void a(String r7) {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CrashTeaEventReporter", "[code=" + r7 + "] crash Tea event queue operation failed", null, 4, null);     // Catch: Throwable -> L4
        return;
    }

    private final f b() {
        return (f) ZeusTransformUtils.preCheckCast(e.getValue(), f.class, "com.obric.memorydata.plugin");
    }

    private static final boolean b(String r5) {
        Intrinsics.checkNotNullParameter(r5, EventBody.KEY_VALUE);
        return IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).syncSave("pending_crash_tea_events_v1", r5);
    }

    private final void c() {
        Object r0 = f11789b;
        monitor-enter(r0);
        boolean r2 = true;
        if (c == false) goto L7;
        r2 = false;
    L8:
        monitor-exit(r0);
        if (r2 == true) goto L27;
        return;
    L27:
        UserSettings.INSTANCE.registerAgreePrivacyListener((com.obric.memorydata.middleware.api.app.a) ZeusTransformUtils.preCheckCast(d, com.obric.memorydata.middleware.api.app.a.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L13
        return;
    L14:
        monitor-enter(f11789b);
        c = false;     // Catch: Throwable -> L19
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L19
        a("privacy_listener_register_failed");
        return;
    L19:
        th = move-exception;
        throw th;
    L7:
        c = true;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        throw th;
    }

    private static final String d() {
        return IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).getString("pending_crash_tea_events_v1", "");
    }

    private static final f e() {
        c r1 = new c($$Lambda$a$48dwwfOor3k4_d1RnG47yUyEm64.INSTANCE, $$Lambda$a$vpu67NwnhwVFWNZpTIB00wARTQ.INSTANCE);
        $$Lambda$a$gchyEWHStNxAPnhQ5VuC42z3JLM r2 = $$Lambda$a$gchyEWHStNxAPnhQ5VuC42z3JLM.INSTANCE;
        Function1 r5 = (Function1) ZeusTransformUtils.preCheckCast(new CrashTeaEventReporter$delegate$2$2(f11788a), Function1.class, "com.obric.memorydata.plugin");
        return new f(r1, r2, null, null, r5, 12, null);
    }

    public static /* synthetic */ String lambda$48dwwfOor3k4_d1RnG47yUyEm64() {
        return d();
    }

    public static /* synthetic */ Unit lambda$gchyEWHStNxAPnhQ5VuC42z3JLM(String r0, String r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ f lambda$oViZSdCSMXVuAAlEVlKP2qzzvjo() {
        return e();
    }

    /* JADX INFO: renamed from: lambda$vpu67NwnhwVFWNZpTIB0-0wARTQ, reason: not valid java name */
    public static /* synthetic */ boolean m1029lambda$vpu67NwnhwVFWNZpTIB00wARTQ(String r0) {
        return b(r0);
    }

    public final void a() {
        c();     // Catch: Throwable -> L6
        if (UserSettings.INSTANCE.hasAgreePrivacy() == false) goto L10;
        b().a();     // Catch: Throwable -> L6
        return;
    L10:
        return;
    L6:
        a("replay_boundary_failed");
    }

    public final void a(String r4, JSONObject r5, long r6) {
        Intrinsics.checkNotNullParameter(r4, "eventName");
        Intrinsics.checkNotNullParameter(r5, TrackerImpl.PARAMS);
        f r0 = b();     // Catch: Throwable -> L5
        String r1 = r5.toString();     // Catch: Throwable -> L5
        Intrinsics.checkNotNullExpressionValue(r1, "toString(...)");     // Catch: Throwable -> L5
        r0.a(r4, r1, r6);     // Catch: Throwable -> L5
        return;
    L5:
        a("fatal_report_boundary_failed");
        Tracker.INSTANCE.reportDevEvent(r4, r5);     // Catch: Throwable -> L8
        return;
    L8:
        a("fatal_direct_fallback_failed");
    }
}
