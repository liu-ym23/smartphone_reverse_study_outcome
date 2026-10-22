package com.obric.aiagent.ipc.control;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.tom_roush.pdfbox.pdmodel.a.d.f;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.al;
import kotlinx.coroutines.bx;
import kotlinx.coroutines.i;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000o\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001#\b\u0000\u0018\u0000 72\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u00017B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001bJ\u0010\u0010\u001f\u001a\u00020\u00182\u0006\u0010 \u001a\u00020!H\u0002J\n\u0010%\u001a\u0004\u0018\u00010\u0003H\u0016J\u0016\u0010&\u001a\u00020'2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00030\u000fH\u0016J\b\u0010)\u001a\u00020'H\u0016J\u0010\u0010*\u001a\u00020'2\u0006\u0010+\u001a\u00020\u0011H\u0016J\b\u0010,\u001a\u00020\u001dH\u0016J\b\u0010-\u001a\u00020\u001dH\u0002J\b\u0010.\u001a\u00020\u001dH\u0002J\u0010\u0010/\u001a\u00020\u001d2\u0006\u00100\u001a\u00020\u0003H\u0002J\b\u00101\u001a\u00020'H\u0002J\u0010\u00102\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020!H\u0002J\u0010\u00103\u001a\u00020\u001d2\u0006\u00104\u001a\u00020\u0018H\u0002J\n\u00105\u001a\u0004\u0018\u000106H\u0002R\u000e\u0010\u0006\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0004\n\u0002\u0010$¨\u00068"}, d2 = {"Lcom/obric/aiagent/ipc/control/BinderControl;", "Lcom/obric/aiagent/ipc/control/IPCControl;", "Landroid/content/Intent;", "Landroid/os/IBinder;", "context", "Landroid/content/Context;", MemorySourceLinkType.INTENT, "<init>", "(Landroid/content/Context;Landroid/content/Intent;)V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "pendingJob", "Lkotlinx/coroutines/Job;", "instance", "callback", "Lcom/obric/aiagent/ipc/control/IPCControl$Callback;", "isBindSucceed", "", "forceRebinding", "foreground", "isConnectionRegistered", "deathRecipient", "Landroid/os/IBinder$DeathRecipient;", "failRebindDelay", "", "diedRebindDelay", "config", "Lcom/obric/aiagent/ipc/control/BinderControlConfig;", "updateConfig", "", "newConfig", "increaseRebindDelay", InfoRequestQPSOptTraceLogger.REASON, "", "serviceConnection", "com/obric/aiagent/ipc/control/BinderControl$serviceConnection$1", "Lcom/obric/aiagent/ipc/control/BinderControl$serviceConnection$1;", "get", "create", "Lcom/obric/aiagent/ipc/control/IPCControl$CreateResult;", f.c, "forceRebind", "appStateChange", "isForeground", "destroy", "safeUnbind", "clearDeathRecipient", "onBinderDied", "deadBinder", "executeBind", "scheduleRebind", "waitForService", "waitTime", "bindInfo", "", "Companion", "ipc-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a extends c<Intent, IBinder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0236a f5925a = null;
    private final Intent c;
    private al d;
    private bx e;
    private volatile IBinder f;
    private volatile c.a<IBinder> g;
    private boolean h;
    private boolean i;
    private volatile boolean j;
    private volatile IBinder.DeathRecipient k;
    private long l;
    private long m;
    private com.obric.aiagent.ipc.control.b n;
    private final b o;

    /* JADX INFO: renamed from: com.obric.aiagent.ipc.control.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/obric/aiagent/ipc/control/BinderControl$Companion;", "", "<init>", "()V", "MIN_DIED_REBIND_DELAY", "", "MIN_FAIL_REBIND_DELAY", "REBIND_REASON_TIME_OUT", "", "REBIND_REASON_DIED", "REBIND_REASON_OTHER_FAIL", "ipc-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class C0236a {
        private C0236a() {
        }

        public /* synthetic */ C0236a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\t"}, d2 = {"com/obric/aiagent/ipc/control/BinderControl$serviceConnection$1", "Landroid/content/ServiceConnection;", "onServiceConnected", "", ActivityLifecycle.NAME, "Landroid/content/ComponentName;", "service", "Landroid/os/IBinder;", "onServiceDisconnected", "ipc-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f5926a;

        /* JADX INFO: renamed from: com.obric.aiagent.ipc.control.a$b$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/obric/aiagent/ipc/control/BinderControl$serviceConnection$1$onServiceConnected$1$1$dr$1", "Landroid/os/IBinder$DeathRecipient;", "binderDied", "", "ipc-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class C0237a implements IBinder.DeathRecipient {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ a f5927a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ IBinder f5928b;

            C0237a(a r3, IBinder r4) {
                IBinder r5 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r4, IBinder.class, "com.obric.memorydata.plugin");
                this.f5927a = r3;
                this.f5928b = r5;
            }

            @Override // android.os.IBinder.DeathRecipient
            public void binderDied() {
                a r0 = this.f5927a;
                IBinder r5 = this.f5928b;
                monitor-enter(r0);
                com.obric.aiagent.ipc.utils.c.f5945a.a("IPCControl", "binderDied: " + a.c(r0) + ", this=" + r0);     // Catch: Throwable -> L7
                a.a(r0, r5);     // Catch: Throwable -> L7
                Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L7
                monitor-exit(r0);
                return;
            L7:
                th = move-exception;
                throw th;
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName r6, IBinder r7) {
            IBinder r8 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r7, IBinder.class, "com.obric.memorydata.plugin");
            a r9 = this.f5926a;
            monitor-enter(r9);
        L31:
            th = move-exception;
            throw th;
        L5:
            if (a.f(r9) == true) goto L9;
            com.obric.aiagent.ipc.utils.c.f5945a.a("IPCControl", "onServiceConnected: ignore, not bound");     // Catch: Throwable -> L31
            monitor-exit(r9);
            return;
        L9:
            if (r8 != null) goto L13;
            com.obric.aiagent.ipc.utils.c.f5945a.a("IPCControl", "onServiceConnected: service is null");     // Catch: Throwable -> L31
            monitor-exit(r9);
            return;
        L13:
            com.obric.aiagent.ipc.utils.c.f5945a.a("IPCControl", "onServiceConnected: " + a.c(r9) + ", this=" + r9);     // Catch: Throwable -> L31
            bx r0 = a.g(r9);     // Catch: Throwable -> L31
            if (r0 == null) goto L16;
            bx.a.a(r0, null, 1, null);     // Catch: Throwable -> L31
        L16:
            a.a(r9, null);     // Catch: Throwable -> L31
            a.h(r9);     // Catch: Throwable -> L31
            Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L19
            b r5 = (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
            C0237a r10 = new C0237a(r9, r8);     // Catch: Throwable -> L19
            r8.linkToDeath((IBinder.DeathRecipient) ZeusTransformUtils.preCheckCast(r10, IBinder.DeathRecipient.class, "com.obric.memorydata.plugin"), 0);     // Catch: Throwable -> L19
            a.a(r9, (IBinder.DeathRecipient) ZeusTransformUtils.preCheckCast(r10, IBinder.DeathRecipient.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L19
            a.b(r9, r8);     // Catch: Throwable -> L19
            a.a(r9, false);     // Catch: Throwable -> L19
            a.b(r9, true);     // Catch: Throwable -> L19
            com.obric.aiagent.ipc.utils.c.f5945a.a("IPCControl", "onReady: " + a.c(r9) + ",callback = " + a.d(r9) + ", instance = " + a.a(r9));     // Catch: Throwable -> L19
            Object r11 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L19
        L21:
            Throwable r12 = Result.m1424exceptionOrNullimpl(r11);     // Catch: Throwable -> L31
            if (r12 == null) goto L26;
            com.obric.aiagent.ipc.utils.c.f5945a.a("IPCControl", "onReady fail " + ExceptionsKt.stackTraceToString(r12), r12);     // Catch: Throwable -> L31
            a.e(r9);     // Catch: Throwable -> L31
            a.b(r9, null);     // Catch: Throwable -> L31
            a.b(r9, 3);     // Catch: Throwable -> L31
            monitor-exit(r9);
            return;
        L26:
            c.a r13 = a.d(r9);     // Catch: Throwable -> L31
            if (r13 == null) goto L29;
            r13.a(r8);     // Catch: Throwable -> L31
            Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L31
        L29:
            monitor-exit(r9);
            return;
        L19:
            th = move-exception;
            Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L31
            r11 = Result.m1421constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L31
            goto L21
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName r6) {
            a r7 = this.f5926a;
            monitor-enter(r7);
        L24:
            th = move-exception;
            throw th;
        L5:
            if (a.f(r7) == true) goto L9;
            com.obric.aiagent.ipc.utils.c.f5945a.a("IPCControl", "onServiceDisconnected: ignore, not bound");     // Catch: Throwable -> L24
            monitor-exit(r7);
            return;
        L9:
            com.obric.aiagent.ipc.utils.c.f5945a.a("IPCControl", "onServiceDisconnected: " + a.c(r7) + ", this=" + r7);     // Catch: Throwable -> L24
            bx r0 = a.g(r7);     // Catch: Throwable -> L24
            if (r0 == null) goto L12;
            bx.a.a(r0, null, 1, null);     // Catch: Throwable -> L24
        L12:
            a.a(r7, null);     // Catch: Throwable -> L24
            a.h(r7);     // Catch: Throwable -> L24
            a.b(r7, null);     // Catch: Throwable -> L24
            a.e(r7);     // Catch: Throwable -> L24
            a.a(r7, false);     // Catch: Throwable -> L24
            c.a r1 = a.d(r7);     // Catch: Throwable -> L24
            if (r1 == null) goto L16;
            r1.a();     // Catch: Throwable -> L24
        L16:
            if (a.d(r7) != null) goto L18;
        L20:
            com.obric.aiagent.ipc.utils.c.f5945a.a("IPCControl", "onServiceDisconnected: callback replaced, not rebind, this=" + this + ", callback=" + a.d(r7) + ",currentCallback=" + r1);     // Catch: Throwable -> L24
        L21:
            Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L24
            monitor-exit(r7);
            return;
        L18:
            if (a.d(r7) != r1) goto L20;
            a.b(r7, 2);     // Catch: Throwable -> L24
            goto L21
        }
    }

    static {
        f5925a = new C0236a(null);
    }

    private final long a(int r8) {
        if (r8 != 2) goto L5;
        long r0 = Math.min(this.n.b(), this.m * ((long) 3));
        this.m = r0;
    L6:
        com.obric.aiagent.ipc.utils.c.f5945a.a("IPCControl", "increaseRebindDelay: reason = " + r8 + ", nextDelay = " + r0);
        return r0;
    L5:
        r0 = Math.min(this.n.c(), this.l * ((long) 3));
        this.l = r0;
        goto L6
    }

    public static final /* synthetic */ long a(a r0, int r1) {
        return r0.a(r1);
    }

    public static final /* synthetic */ IBinder a(a r0) {
        return r0.f;
    }

    private final void a() {
        if (this.j == true) goto L6;
        com.obric.aiagent.ipc.utils.c.f5945a.a("IPCControl", "safeUnbind: ignore, not bound");
        return;
    L6:
        com.obric.aiagent.ipc.utils.c.f5945a.a("IPCControl", "safeUnbind: " + d());
        this.j = false;
        b();
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L9
        ZeusTransformUtils.unbindService(r0, (ServiceConnection) ZeusTransformUtils.preCheckCast(this.o, ServiceConnection.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        Object r4 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L9
    L11:
        Throwable r5 = Result.m1424exceptionOrNullimpl(r4);
        if (r5 == null) goto L17;
        com.obric.aiagent.ipc.utils.c.f5945a.a("IPCControl", "safeUnbind error", r5);
        return;
    L17:
        return;
    L9:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r4 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    private final void a(long r10) {
        bx r0 = this.e;
        if (r0 == null) goto L5;
        bx.a.a(r0, null, 1, null);
    L5:
        this.e = i.a(this.d, null, null, (Function2) ZeusTransformUtils.preCheckCast(new BinderControl$waitForService$1(r10, this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    private final void a(IBinder r5) {
        IBinder r6 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r5, IBinder.class, "com.obric.memorydata.plugin");
        if (this.j == true) goto L6;
        com.obric.aiagent.ipc.utils.c.f5945a.a("IPCControl", "onBinderDied: ignore, not bound");
        return;
    L6:
        com.obric.aiagent.ipc.utils.c.f5945a.a("IPCControl", "onBinderDied: " + d() + ", this=" + this);
        b();
        this.f = null;
        a();
        c.a<IBinder> r7 = this.g;
        if (r7 == null) goto L10;
        r7.a();
    L10:
        if (this.g != null) goto L12;
    L14:
        com.obric.aiagent.ipc.utils.c.f5945a.a("IPCControl", "onBinderDied: callback replaced, not rebind, this=" + this + ", callback=" + this.g + ",currentCallback=" + r7);
        return;
    L12:
        if (this.g != r7) goto L14;
        b(2);
    }

    public static final /* synthetic */ void a(a r2, IBinder.DeathRecipient r3) {
        r2.k = (IBinder.DeathRecipient) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.DeathRecipient.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ void a(a r2, IBinder r3) {
        r2.a((IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ void a(a r2, bx r3) {
        r2.e = (bx) ZeusTransformUtils.wrapperContextForParams(r3, bx.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ void a(a r0, boolean r1) {
        r0.i = r1;
    }

    public static final /* synthetic */ c.C0238c b(a r0) {
        return r0.c();
    }

    private final void b() {
        IBinder.DeathRecipient r0 = this.k;
        if (r0 == null) goto L15;
        IBinder r1 = this.f;
        if (r1 != null) goto L13;
    L11:
        this.k = null;
        return;
    L13:
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L8
        Object r3 = Result.m1421constructorimpl(Boolean.valueOf(r1.unlinkToDeath(r0, 0)));     // Catch: Throwable -> L8
    L10:
        Result.m1420boximpl(r3);
    L8:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r3 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    private final void b(int r12) {
        if (r12 != 2) goto L5;
        long r0 = this.m;
    L6:
        long r3 = r0;
        com.obric.aiagent.ipc.utils.c.f5945a.a("IPCControl", "scheduleRebind: reason = " + r12 + ", delay = " + r3);
        bx r1 = this.e;
        if (r1 == null) goto L9;
        bx.a.a(r1, null, 1, null);
    L9:
        this.e = i.a(this.d, null, null, (Function2) ZeusTransformUtils.preCheckCast(new BinderControl$scheduleRebind$1(r3, this, r12, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        return;
    L5:
        r0 = this.l;
        goto L6
    }

    public static final /* synthetic */ void b(a r0, int r1) {
        r0.b(r1);
    }

    public static final /* synthetic */ void b(a r2, IBinder r3) {
        r2.f = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ void b(a r0, boolean r1) {
        r0.h = r1;
    }

    private final c.C0238c c() {
        a();
        com.obric.aiagent.ipc.utils.c.f5945a.a("IPCControl", "executeBind started");
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L5
        Object r1 = Result.m1421constructorimpl(Boolean.valueOf(ZeusTransformUtils.bindService(r0, this.c, (ServiceConnection) ZeusTransformUtils.preCheckCast(this.o, ServiceConnection.class, "com.obric.memorydata.plugin"), 65, "com.obric.memorydata.plugin")));     // Catch: Throwable -> L5
    L7:
        Throwable r4 = Result.m1424exceptionOrNullimpl(r1);
        if (r4 == null) goto L10;
        com.obric.aiagent.ipc.utils.c.f5945a.a("IPCControl", "executeBind error: " + r4.getMessage(), r4);
    L10:
        Object r5 = false;
        if (Result.m1427isFailureimpl(r1) == true) goto L14;
        r5 = r1;
    L14:
        Pair r2 = TuplesKt.to(r5, Result.m1424exceptionOrNullimpl(r1));
        boolean r6 = ((Boolean) ZeusTransformUtils.preCheckCast(r2.component1(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        Throwable r7 = (Throwable) ZeusTransformUtils.preCheckCast(r2.component2(), Throwable.class, "com.obric.memorydata.plugin");
        if (r6 == false) goto L18;
        this.j = true;
        com.obric.aiagent.ipc.utils.c.f5945a.a("IPCControl", "bindService success");
        a(this.n.a());
        return new c.C0238c(true, null, 2, null);
    L18:
        this.j = false;
        if (this.h == true) goto L29;
        com.obric.aiagent.ipc.utils.c.f5945a.a("IPCControl", "bindService failed");
        if (ZeusTransformUtils.instanceOf(r7, SecurityException.class) == false) goto L24;
        com.obric.aiagent.ipc.utils.c.f5945a.a("IPCControl", "createBinder exception", r7);
        this.i = false;
        return new c.C0238c(false, ((SecurityException) ZeusTransformUtils.preCheckCast(r7, SecurityException.class, "com.obric.memorydata.plugin")).getMessage());
    L24:
        this.i = false;
        Intent r8 = c.f5931b.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), this.c);
        if (r8 == null) goto L27;
        this.c.setAction(r8.getAction());
        this.c.setPackage(r8.getPackage());
        this.c.setComponent(r8.getComponent());
        goto L29
    L27:
        return new c.C0238c(false, "No Service for " + d());
    L29:
        b(3);
        return new c.C0238c(true, null, 2, null);
    L5:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r1 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public static final /* synthetic */ String c(a r0) {
        return r0.d();
    }

    public static final /* synthetic */ c.a d(a r0) {
        return r0.g;
    }

    private final String d() {
        return this.c.getAction();
    }

    public static final /* synthetic */ void e(a r0) {
        r0.a();
    }

    public static final /* synthetic */ boolean f(a r0) {
        return r0.j;
    }

    public static final /* synthetic */ bx g(a r0) {
        return r0.e;
    }

    public static final /* synthetic */ void h(a r0) {
        r0.b();
    }
}
