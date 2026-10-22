package com.obric.memorydata.middleware.impl.app;

import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.util.Log;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.bytedance.lego.init.InitScheduler;
import com.bytedance.lego.init.model.InitPeriod;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.app.f;
import com.obric.memorydata.middleware.api.app.g;
import com.obric.memorydata.middleware.api.app.h;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0006\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0002\u001a \u0018\u0000 52\u00020\u0001:\u000256B=\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\b¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010$\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\u0012H\u0017J\b\u0010&\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\u0006H\u0002J\u0010\u0010'\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\tH\u0002J\u0010\u0010)\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\tH\u0002J\u0010\u0010*\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\tH\u0002J\u0010\u0010,\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\tH\u0002J\b\u0010-\u001a\u00020\nH\u0002J\b\u0010.\u001a\u00020\u0006H\u0003J\u0010\u0010/\u001a\u00020\u00062\u0006\u00100\u001a\u000201H\u0002J\b\u00102\u001a\u00020\u0006H\u0002J\b\u00103\u001a\u00020\u0006H\u0002J\b\u00104\u001a\u00020\u0006H\u0002R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010\u001f\u001a\u00020 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u001e\u001a\u0004\b!\u0010\"¨\u00067"}, d2 = {"Lcom/obric/memorydata/middleware/impl/app/UserAgreeTaskController;", "Lcom/obric/memorydata/middleware/api/app/TaskController;", "prerequisite", "Lcom/obric/memorydata/middleware/api/app/TaskControllerPrerequisite;", "databaseInitializer", "Lkotlin/Function0;", "", "loginProcessRestarter", "Lkotlin/Function1;", "", "", "<init>", "(Lcom/obric/memorydata/middleware/api/app/TaskControllerPrerequisite;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", CommonConsts.APM_INNER_EVENT_COST_INIT, "gateState", "Lcom/obric/memorydata/middleware/impl/app/UserAgreeTaskController$GateState;", "queue", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/bytedance/lego/init/model/InitPeriod;", "mainHandler", "Landroid/os/Handler;", "processRestartRequested", "Ljava/util/concurrent/atomic/AtomicBoolean;", "prerequisiteTimeoutRunnable", "Ljava/lang/Runnable;", "privacyListener", "com/obric/memorydata/middleware/impl/app/UserAgreeTaskController$privacyListener$2$1", "getPrivacyListener", "()Lcom/obric/memorydata/middleware/impl/app/UserAgreeTaskController$privacyListener$2$1;", "privacyListener$delegate", "Lkotlin/Lazy;", "loginStateDispatchedListener", "com/obric/memorydata/middleware/impl/app/UserAgreeTaskController$loginStateDispatchedListener$2$1", "getLoginStateDispatchedListener", "()Lcom/obric/memorydata/middleware/impl/app/UserAgreeTaskController$loginStateDispatchedListener$2$1;", "loginStateDispatchedListener$delegate", "onPeriod", "initPeriod", "isPrerequisiteGateOpen", "killProcessAfterUserStateChanged", InfoRequestQPSOptTraceLogger.REASON, "requestDirectProcessRestart", "restartProcessAfterLoginWithPageRestore", "userId", "scheduleRestartWatchdog", "isPrerequisiteReady", "preparePrerequisiteIfNeeded", "handlePrerequisiteResult", "result", "Lcom/obric/memorydata/middleware/api/app/TaskControllerPrerequisiteResult;", "schedulePrerequisiteTimeout", "cancelPrerequisiteTimeout", "reInit", "Companion", "GateState", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class UserAgreeTaskController implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f11682a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final g f11683b;
    private final Function0<Unit> c;
    private final Function1<String, Boolean> d;
    private boolean e;
    private GateState f;
    private final CopyOnWriteArrayList<InitPeriod> g;
    private final Handler h;
    private final AtomicBoolean i;
    private Runnable j;
    private final Lazy k;
    private final Lazy l;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/memorydata/middleware/impl/app/UserAgreeTaskController$GateState;", "", "<init>", "(Ljava/lang/String;I)V", "IDLE", "BLOCKING", "TIMED_OUT", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final enum GateState extends Enum<GateState> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ GateState[] $VALUES = null;
        public static final GateState BLOCKING = null;
        public static final GateState IDLE = null;
        public static final GateState TIMED_OUT = null;

        private static final /* synthetic */ GateState[] $values() {
            return new GateState[]{IDLE, BLOCKING, TIMED_OUT};
        }

        static {
            IDLE = new GateState("IDLE", 0);
            BLOCKING = new GateState("BLOCKING", 1);
            TIMED_OUT = new GateState("TIMED_OUT", 2);
            GateState[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
        }

        private GateState(String r1, int r2) {
            super(r1, r2);
        }

        public static EnumEntries<GateState> getEntries() {
            return $ENTRIES;
        }

        public static GateState valueOf(String r2) {
            return (GateState) ZeusTransformUtils.preCheckCast(Enum.valueOf(GateState.class, r2), GateState.class, "com.obric.memorydata.plugin");
        }

        public static GateState[] values() {
            return (GateState[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), GateState[].class, "com.obric.memorydata.plugin");
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/obric/memorydata/middleware/impl/app/UserAgreeTaskController$Companion;", "", "<init>", "()V", "TAG", "", "PREREQUISITE_TIMEOUT_MS", "", "PROCESS_RESTART_WATCHDOG_MS", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f11684a = null;

        static {
            int[] r0 = new int[GateState.values().length];
            r0[GateState.IDLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[GateState.TIMED_OUT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[GateState.BLOCKING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f11684a = r0;
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"com/obric/memorydata/middleware/impl/app/UserAgreeTaskController$loginStateDispatchedListener$2$1", "Lcom/obric/memorydata/middleware/api/app/LoginStateDispatchedListener;", "onLoginDispatched", "", "userId", "", "onLogoutDispatched", "lastUserId", "onEnterpriseAccountChangedDispatched", "isEnterprise", "", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c implements com.obric.memorydata.middleware.api.app.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ UserAgreeTaskController f11685a;

        c(UserAgreeTaskController r1) {
            this.f11685a = r1;
        }

        @Override // com.obric.memorydata.middleware.api.app.c
        public void a(String r2) {
            Intrinsics.checkNotNullParameter(r2, "userId");
            UserAgreeTaskController.a(this.f11685a, r2);
        }

        @Override // com.obric.memorydata.middleware.api.app.c
        public void a(boolean r1) {
            UserAgreeTaskController r0 = this.f11685a;
            if (r1 == false) goto L5;
            String r2 = "enter_enterprise";
        L6:
            UserAgreeTaskController.b(r0, r2);
            return;
        L5:
            r2 = "exit_enterprise";
            goto L6
        }

        @Override // com.obric.memorydata.middleware.api.app.c
        public void b(String r2) {
            Intrinsics.checkNotNullParameter(r2, "lastUserId");
            UserAgreeTaskController.b(this.f11685a, "logout");
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, d2 = {"com/obric/memorydata/middleware/impl/app/UserAgreeTaskController$privacyListener$2$1", "Lcom/obric/memorydata/middleware/api/app/AgreePrivacyListener;", "onAgree", "", "onDisagree", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class d implements com.obric.memorydata.middleware.api.app.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ UserAgreeTaskController f11686a;

        d(UserAgreeTaskController r1) {
            this.f11686a = r1;
        }

        @Override // com.obric.memorydata.middleware.api.app.a
        public void a() {
            UserAgreeTaskController.a(this.f11686a);
        }

        @Override // com.obric.memorydata.middleware.api.app.a
        public void b() {
        }
    }

    static {
        f11682a = new a(null);
    }

    public UserAgreeTaskController() {
        this(null, null, null, 7, null);
    }

    public UserAgreeTaskController(g r3, Function0<Unit> r4, Function1<? super String, Boolean> r5) {
        g r6 = (g) ZeusTransformUtils.wrapperContextForParams(r3, g.class, "com.obric.memorydata.plugin");
        Function0<Unit> r7 = (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin");
        Function1<String, Boolean> r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
        this.f11683b = r6;
        this.c = r7;
        this.d = r8;
        this.f = GateState.IDLE;
        this.g = new CopyOnWriteArrayList();
        this.h = new Handler(Looper.getMainLooper());
        this.i = new AtomicBoolean(false);
        this.k = LazyKt.lazy(new $$Lambda$UserAgreeTaskController$ww_7eoeRIZNTcJtbQyTyV4oJZG8(this));
        this.l = LazyKt.lazy(new $$Lambda$UserAgreeTaskController$ZFyeWgblsf1RVXCKearGz5O45V0(this));
    }

    public /* synthetic */ UserAgreeTaskController(g r2, Function0 r3, Function1 r4, int r5, DefaultConstructorMarker r6) {
        g r7 = (g) ZeusTransformUtils.wrapperContextForParams(r2, g.class, "com.obric.memorydata.plugin");
        Function0 r8 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        Function1 r9 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        if ((r5 & 1) == 0) goto L6;
        r7 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r8 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r9 = null;
    L11:
        this(r7, r8, r9);
    }

    private final d a() {
        return (d) ZeusTransformUtils.preCheckCast(this.k.getValue(), d.class, "com.obric.memorydata.plugin");
    }

    private final void a(h r3) {
        if (r3.a() == false) goto L9;
        h();
        if (r3.b() == false) goto L7;
        Log.i("UserAgreeTaskController", "task controller prerequisite prepared with migrated data, restart process");
        Process.killProcess(Process.myPid());
        return;
    L7:
        Log.i("UserAgreeTaskController", "task controller prerequisite prepared without migrated data, continue initialization");
        this.f = GateState.IDLE;
        i();
        return;
    L9:
        if (this.f == GateState.TIMED_OUT) goto L14;
        Log.w("UserAgreeTaskController", "task controller prerequisite is still not ready, wait timeout");
        return;
    }

    public static final /* synthetic */ void a(UserAgreeTaskController r0) {
        r0.i();
    }

    private static final void a(UserAgreeTaskController r0, h r1) {
        r0.a(r1);
    }

    public static final /* synthetic */ void a(UserAgreeTaskController r0, String r1) {
        r0.c(r1);
    }

    private final void a(String r2) {
        Log.i("UserAgreeTaskController", "user state changed, restart process, reason=" + r2);
        Process.killProcess(Process.myPid());
    }

    private final c b() {
        return (c) ZeusTransformUtils.preCheckCast(this.l.getValue(), c.class, "com.obric.memorydata.plugin");
    }

    private static final d b(UserAgreeTaskController r1) {
        return new d(r1);
    }

    private static final Unit b(final UserAgreeTaskController r2, final h r3) {
        Intrinsics.checkNotNullParameter(r3, "result");
        r2.h.post(new $$Lambda$UserAgreeTaskController$QRTXom1mgWLR_e7RLeNflA74(r2, r3));
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ void b(UserAgreeTaskController r0, String r1) {
        r0.b(r1);
    }

    private final void b(String r4) {
        if (this.i.compareAndSet(false, true) == true) goto L6;
        Log.i("UserAgreeTaskController", "skip duplicate process restart request, reason=" + r4);
        return;
    L6:
        this.i.set(false);
        a(r4);
    }

    private static final c c(UserAgreeTaskController r1) {
        return new c(r1);
    }

    private static final void c(UserAgreeTaskController r3, String r4) {
        if (r3.i.compareAndSet(true, false) == false) goto L5;
        Log.w("UserAgreeTaskController", "process restart not effective, rollback latch and retry, reason=" + r4);
    L5:
        r3.a(r4 + "_watchdog");
    }

    private final void c(String r5) {
        boolean r2 = true;
        if (this.i.compareAndSet(false, true) == true) goto L6;
        Log.i("UserAgreeTaskController", "skip duplicate process restart request, reason=login");
        return;
    L6:
        Function1<String, Boolean> r0 = this.d;
        if (r0 != null) goto L9;
    L11:
        r2 = false;
    L13:
        if (r2 == false) goto L15;
        d("login");
        return;
    L15:
        this.i.set(false);
        a("login");
        return;
    L9:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r0.invoke(r5), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() != true) goto L11;
        goto L11
    }

    private final boolean c() {
        GateState r0 = this.f;
        int r1 = b.f11684a[r0.ordinal()];
        if (r1 == 1) goto L12;
        if (r1 != 2) goto L7;
        return true;
    L7:
        if (r1 != 3) goto L10;
        return false;
    L10:
        throw new NoWhenBranchMatchedException();
    L12:
        return e();
    }

    private final void d() {
        Function0<Unit> r0 = this.c;
        if (r0 == null) goto L5;
        r0.invoke();
    L5:
        UserSettings.INSTANCE.registerAgreePrivacyListener((com.obric.memorydata.middleware.api.app.a) ZeusTransformUtils.preCheckCast(a(), com.obric.memorydata.middleware.api.app.a.class, "com.obric.memorydata.plugin"));
        if (this.f11683b == null) goto L9;
        UserSettings.INSTANCE.setLoginStateDispatchedListener((com.obric.memorydata.middleware.api.app.c) ZeusTransformUtils.preCheckCast(b(), com.obric.memorydata.middleware.api.app.c.class, "com.obric.memorydata.plugin"));
        return;
    }

    private static final void d(UserAgreeTaskController r2) {
        if (r2.f != GateState.BLOCKING) goto L6;
        r2.j = null;
        r2.f = GateState.TIMED_OUT;
        Log.w("UserAgreeTaskController", "task controller prerequisite timed out, release pending periods");
        r2.i();
        return;
    }

    private final void d(final String r3) {
        this.h.postDelayed(new $$Lambda$UserAgreeTaskController$d7qK1DismY4SwIcF1o6Gn4bgtd0(this, r3), 5000);
    }

    private final boolean e() {
        g r1 = this.f11683b;
        if (r1 != null) goto L18;
        return true;
    L18:
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L8
        UserAgreeTaskController r4 = (UserAgreeTaskController) ZeusTransformUtils.preCheckCast(this, UserAgreeTaskController.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L8
        Object r5 = Result.m1421constructorimpl(Boolean.valueOf(r1.a()));     // Catch: Throwable -> L8
    L10:
        Throwable r3 = Result.m1424exceptionOrNullimpl(r5);
        if (r3 == null) goto L14;
        Log.e("UserAgreeTaskController", "check task controller prerequisite failed", r3);
    L14:
        if (Result.m1427isFailureimpl(r5) == false) goto L17;
        r5 = false;
    L17:
        return ((Boolean) ZeusTransformUtils.preCheckCast(r5, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    L8:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r5 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    private final void f() {
        g r0 = this.f11683b;
        if (r0 != null) goto L6;
        return;
    L6:
        if (this.f == GateState.IDLE) goto L8;
        return;
    L8:
        h();
        this.f = GateState.BLOCKING;
        g();
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L11
        final UserAgreeTaskController r3 = (UserAgreeTaskController) ZeusTransformUtils.preCheckCast(this, UserAgreeTaskController.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        r0.a(new $$Lambda$UserAgreeTaskController$qTN0KQnAeyGLHwOaOA3rKWTUK6k(r3));     // Catch: Throwable -> L11
        Object r4 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L13:
        Throwable r5 = Result.m1424exceptionOrNullimpl(r4);
        if (r5 == null) goto L19;
        Log.e("UserAgreeTaskController", "prepare task controller prerequisite failed", r5);
        return;
    L19:
        return;
    L11:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r4 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L13
    }

    private final void g() {
        Runnable r0 = new $$Lambda$UserAgreeTaskController$eKk206a9pwfbzISCnuWVb2Lzzjo(this);
        this.j = r0;
        this.h.postDelayed(r0, 30000);
    }

    private final void h() {
        Runnable r0 = this.j;
        if (r0 == null) goto L5;
        this.h.removeCallbacks(r0);
    L5:
        this.j = null;
    }

    private final void i() {
        Log.d("UserAgreeTaskController", "reInit");
        List r0 = CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(this.g, Iterable.class, "com.obric.memorydata.plugin"));
        this.g.clear();
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        InitPeriod r2 = (InitPeriod) ZeusTransformUtils.preCheckCast(r1.next(), InitPeriod.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNull(r2);
        a(r2);
        goto L4
    }

    /* JADX INFO: renamed from: lambda$QRTXo-m1m-gWLR_e7RLeN-flA74, reason: not valid java name */
    public static /* synthetic */ void m1016lambda$QRTXom1mgWLR_e7RLeNflA74(UserAgreeTaskController r0, h r1) {
        a(r0, r1);
    }

    public static /* synthetic */ c lambda$ZFyeWgblsf1RVXCKearGz5O45V0(UserAgreeTaskController r0) {
        return c(r0);
    }

    public static /* synthetic */ void lambda$d7qK1DismY4SwIcF1o6Gn4bgtd0(UserAgreeTaskController r0, String r1) {
        c(r0, r1);
    }

    public static /* synthetic */ void lambda$eKk206a9pwfbzISCnuWVb2Lzzjo(UserAgreeTaskController r0) {
        d(r0);
    }

    public static /* synthetic */ Unit lambda$qTN0KQnAeyGLHwOaOA3rKWTUK6k(UserAgreeTaskController r0, h r1) {
        return b(r0, r1);
    }

    public static /* synthetic */ d lambda$ww_7eoeRIZNTcJtbQyTyV4oJZG8(UserAgreeTaskController r0) {
        return b(r0);
    }

    @Override // com.obric.memorydata.middleware.api.app.f
    public void a(InitPeriod r4) {
        Intrinsics.checkNotNullParameter(r4, "initPeriod");
        if (this.e == true) goto L5;
        this.e = true;
        d();
    L5:
        boolean r0 = UserSettings.INSTANCE.hasAgreePrivacy();
        if (r0 == true) goto L8;
    L10:
        this.g.addIfAbsent(r4);
        if (r0 == true) goto L13;
        Log.w("UserAgreeTaskController", "wait user agree privacy");
        return;
    L13:
        Log.w("UserAgreeTaskController", "wait task controller prerequisite");
        f();
        return;
    L8:
        if (c() == false) goto L10;
        Log.d("UserAgreeTaskController", "user agreed privacy start");
        InitScheduler.onPeriodStart(r4);
        InitScheduler.onPeriodEnd(r4);
        Log.d("UserAgreeTaskController", "user agreed privacy end");
    }
}
