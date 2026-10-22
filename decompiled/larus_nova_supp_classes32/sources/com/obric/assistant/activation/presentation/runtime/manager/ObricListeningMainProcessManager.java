package com.obric.assistant.activation.presentation.runtime.manager;

import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.view.SurfaceControl;
import com.larus.utils.logger.FLogger;
import com.lynx.jsbridge.LynxResourceModule;
import com.miui.easygo.constant.EasyGoDbTable;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.activation.presentation.contract.ObricListeningPresentationState;
import com.obric.assistant.activation.presentation.contract.ObricListeningViewState;
import com.obric.assistant.activation.presentation.contract.ipc.IObricInteractorPresentationBridgeService;
import com.obric.assistant.spi.startup.AssistantStartupTelemetry;
import com.obric.assistant.spi.startup.IAssistantStartupTelemetry;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class ObricListeningMainProcessManager {
    public static final ObricListeningMainProcessManager a = null;
    public static final Handler b = null;
    public static final Channel<a> c = null;
    public static final CoroutineScope d = null;
    public static IObricInteractorPresentationBridgeService e;
    public static volatile boolean f;
    public static volatile ObricListeningPresentationState g;
    public static boolean h;
    public static Function0<Unit> i;
    public static xaa.b j;
    public static SurfaceControl k;
    public static int l;
    public static int m;
    public static int n;
    public static aba.a o;
    public static boolean p;
    public static long q;
    public static long r;
    public static final AtomicLong s = null;
    public static final AtomicReference<c> t = null;
    public static b u;
    public static String v;
    public static final ObricListeningMainProcessManager$callback$1 w = null;

    /* JADX INFO: renamed from: com.obric.assistant.activation.presentation.runtime.manager.ObricListeningMainProcessManager$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.activation.presentation.runtime.manager.ObricListeningMainProcessManager$1", f = "ObricListeningMainProcessManager.kt", i = {}, l = {85}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;

        public AnonymousClass1(Continuation<? super AnonymousClass1> r2) {
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return new AnonymousClass1(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0034 -> B:13:0x0039). Please report as a decompilation issue!!! */
        public final Object invokeSuspend(Object r12) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ChannelIterator r2 = (ChannelIterator) this.L$0;
            ResultKt.throwOnFailure(r12);
            ChannelIterator r3 = r2;
            Object r4 = r0;
            AnonymousClass1 r5 = this;
        L14:
            if (((Boolean) r12).booleanValue() == false) goto L28;
            final a r13 = (a) r3.next();
            ObricListeningMainProcessManager.a.getClass();
            r13.d.invoke(r13.b);     // Catch: Exception -> L18 CancellationException -> L20 RemoteException -> L22
        L26:
            AnonymousClass1 r14 = r5;
            r0 = r4;
            ChannelIterator r6 = r3;
        L9:
            r14.L$0 = r6;
            r14.label = 1;
            Object r7 = r6.hasNext(r14);
            if (r7 != r0) goto L12;
            return r0;
        L12:
            Object r10 = r0;
            r5 = r14;
            r12 = r7;
            r3 = r6;
            r4 = r10;
            goto L14
        L22:
            e = move-exception;
            FLogger.a.w("ObricListeningMainPM", "child bridge command failed, name=" + r13.a + ", binder=" + r13.b.asBinder().hashCode() + ", detach=" + r13.c, e);
            if (r13.c == false) goto L26;
            ObricListeningMainProcessManager.k(new l0(r13));
        L20:
            e = move-exception;
            throw e;
        L18:
            e = move-exception;
            FLogger.a.w("ObricListeningMainPM", "child bridge command crashed, name=" + r13.a + ", binder=" + r13.b.asBinder().hashCode(), e);
            goto L26
        L28:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r12);
            r6 = ObricListeningMainProcessManager.c.iterator();
            r14 = this;
            goto L9
        }
    }

    public static final class a {
        public final String a;
        public final IObricInteractorPresentationBridgeService b;
        public final boolean c;
        public final Function1<IObricInteractorPresentationBridgeService, Unit> d;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
            if (this.c == false) goto L5;
            int r1 = 1231;
        L7:
            return ((r0 + r1) * 31) + this.d.hashCode();
        L5:
            r1 = 1237;
            goto L7
        }

        public final String toString() {
            return "BridgeCommand(name=" + this.a + ", target=" + this.b + ", detachOnFailure=" + this.c + ", action=" + this.d + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(String r2, IObricInteractorPresentationBridgeService r3, boolean r4, Function1<? super IObricInteractorPresentationBridgeService, Unit> r5) {
            Intrinsics.checkNotNullParameter(r2, EasyGoDbTable.Server.NAME);
            Intrinsics.checkNotNullParameter(r3, "target");
            Intrinsics.checkNotNullParameter(r5, "action");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    public static final class b {
        public final int a;
        public final String b;
        public final long c;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof b) == true) goto L8;
            return false;
        L8:
            b r9 = (b) r8;
            if (this.a == r9.a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
            return false;
        L15:
            if (this.c == r9.c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r0 = ((this.a * 31) + this.b.hashCode()) * 31;
            long r1 = this.c;
            return r0 + ((int) (r1 ^ (r1 >>> 32)));
        }

        public final String toString() {
            return "PendingChildFirstFrame(generation=" + this.a + ", startupAttemptId=" + this.b + ", timestampElapsedRealtimeMs=" + this.c + ')';
        }

        public b(int r2, String r3, long r4) {
            Intrinsics.checkNotNullParameter(r3, "startupAttemptId");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public static final class c {
        public final long a;
        public final boolean b;
        public final ObricListeningPresentationState c;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof c) == true) goto L8;
            return false;
        L8:
            c r9 = (c) r8;
            if (this.a == r9.a) goto L12;
            return false;
        L12:
            if (this.b == r9.b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r9.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            long r0 = this.a;
            int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
            if (this.b == false) goto L5;
            int r2 = 1231;
        L7:
            return ((r1 + r2) * 31) + this.c.hashCode();
        L5:
            r2 = 1237;
            goto L7
        }

        public final String toString() {
            return "PendingFallbackSnapshot(sequence=" + this.a + ", owned=" + this.b + ", state=" + this.c + ')';
        }

        public c(long r2, boolean r4, ObricListeningPresentationState r5) {
            Intrinsics.checkNotNullParameter(r5, "state");
            this.a = r2;
            this.b = r4;
            this.c = r5;
        }
    }

    public ObricListeningMainProcessManager() {
    }

    static {
        a = new ObricListeningMainProcessManager();
        b = new Handler(Looper.getMainLooper());
        c = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
        CoroutineScope r3 = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        d = r3;
        g = ObricListeningPresentationState.g;
        l = -1;
        m = -1;
        s = new AtomicLong(0);
        t = new AtomicReference();
        BuildersKt.launch$default(r3, null, null, new AnonymousClass1(null), 3, null);
        w = new ObricListeningMainProcessManager$callback$1();
    }

    public static aba.b d() {
        if (f == true) goto L7;
        return aba.b.f;
    L7:
        if (k == null) goto L9;
        boolean r0 = true;
    L11:
        if (r0 == false) goto L13;
        int r4 = l;
    L14:
        if (r0 == false) goto L16;
        int r5 = m;
    L17:
        if (r0 == false) goto L19;
        int r6 = n;
    L21:
        if (g.c == 1) goto L23;
    L25:
        boolean r7 = false;
    L27:
        return new aba.b(r4, r5, r6, r7, k);
    L23:
        if (g.b() == false) goto L25;
        r7 = true;
        goto L27
    L19:
        r6 = 0;
        goto L21
    L16:
        r5 = -1;
        goto L17
    L13:
        r4 = -1;
        goto L14
    L9:
        r0 = false;
        goto L11
    }

    public static void e() {
        int r0 = l;
        SurfaceControl r1 = k;
        if (r1 == null) goto L5;
        boolean r3 = true;
    L6:
        l(r1);
        k = null;
        l = -1;
        m = -1;
        n = 0;
        if (r3 == false) goto L10;
        FLogger.a.i("ObricListeningMainPM", "release local child Surface copy, generation=" + r0);
        return;
    L10:
        return;
    L5:
        r3 = false;
        goto L6
    }

    public static void h() {
        if (f == true) goto L7;
        FLogger.a.i("ObricListeningMainPM", "ignore listening terminal without child owner");
        return;
    L7:
        if (p == false) goto L10;
        FLogger.a.i("ObricListeningMainPM", "ignore duplicate listening terminal");
        return;
    L10:
        p = true;
        final ObricListeningPresentationState r0 = ObricListeningPresentationState.a(g, g.a + 1, 0, 1, ObricListeningViewState.d, false, 38);
        FLogger.a.i("ObricListeningMainPM", "begin listening terminal, terminalRevision=" + r0.a);
        g(new j1(r0));
    }

    public static void i() {
        aba.a r0 = o;
        if (r0 == null) goto L6;
        r0.onChildListeningSurfaceChanged(d());
        return;
    }

    public static String m() {
        StringBuilder r0 = new StringBuilder("owned=");
        r0.append(f);
        r0.append(", mode=");
        r0.append(g.e.a);
        r0.append(", revision=");
        r0.append(g.a);
        r0.append(", heartbeatSequence=");
        r0.append(g.b);
        r0.append(", childFeedbackPlayed=");
        r0.append(g.f);
        r0.append(", hasSurface=");
        boolean r2 = false;
        if (k == null) goto L5;
        boolean r1 = true;
    L6:
        r0.append(r1);
        r0.append(", hasPendingFallback=");
        if (t.get() == null) goto L9;
        r2 = true;
    L9:
        r0.append(r2);
        return r0.toString();
    L5:
        r1 = false;
        goto L6
    }

    public static void f() {
        String r0 = m();
        if (f == false) goto L5;
    L8:
        boolean r1 = true;
    L9:
        ObricListeningPresentationState r3 = ObricListeningPresentationState.g;
        xaa.b r4 = j;
        if (r4 == null) goto L12;
        r4.a(r3);
    L12:
        f = false;
        g = r3;
        h = false;
        q = 0;
        r = 0;
        p = false;
        u = null;
        v = null;
        e();
        i();
        if (r1 == false) goto L16;
        FLogger.a.i("ObricListeningMainPM", "local child presentation cleared, previous={" + r0 + '}');
        return;
    L16:
        return;
    L5:
        if (k != null) goto L8;
        r1 = false;
        goto L9
    }

    public static void g(final Function0 r7) {
        final aba.b r0 = d();
        aba.a r1 = o;
        if (r0.d == true) goto L5;
    L23:
        FLogger r2 = FLogger.a;
        StringBuilder r4 = new StringBuilder("skip Surface pre-removal, expectsRelativeLayer=");
        r4.append(r0.d);
        r4.append(", hasSurface=");
        boolean r5 = false;
        if (r0.e == null) goto L26;
        boolean r3 = true;
    L27:
        r4.append(r3);
        r4.append(", hasListener=");
        if (r1 == null) goto L30;
        r5 = true;
    L30:
        r4.append(r5);
        r2.i("ObricListeningMainPM", r4.toString());
        r7.invoke();
        return;
    L26:
        r3 = false;
        goto L27
    L5:
        if (r0.e == null) goto L23;
        if (r1 == null) goto L23;
        final Ref.BooleanRef r6 = new Ref.BooleanRef();
        Runnable r8 = new u0(r6, r0, r7);
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L11
        Object r10 = Result.constructor-impl(Boolean.valueOf(r1.prepareForChildListeningSurfaceRemoval(r0, r8)));     // Catch: Throwable -> L11
    L13:
        Throwable r11 = Result.exceptionOrNull-impl(r10);
        if (r11 == null) goto L16;
        FLogger.a.w("ObricListeningMainPM", "Surface pre-removal callback failed, generation=" + r0.a, r11);
    L16:
        Boolean r12 = Boolean.FALSE;
        if (Result.isFailure-impl(r10) == false) goto L19;
        r10 = r12;
    L19:
        boolean r13 = ((Boolean) r10).booleanValue();
        FLogger.a.i("ObricListeningMainPM", "Surface pre-removal requested, generation=" + r0.a + ", accepted=" + r13);
        if (r13 == true) goto L34;
        r8.run();
        return;
    L34:
        return;
    L11:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    }

    public static void j(ObricListeningMainProcessManager r1) {
        if (f == false) goto L5;
        ObricListeningPresentationState r0 = g;
    L6:
        r1.getClass();
        xaa.b r2 = j;
        if (r2 == null) goto L10;
        r2.a(r0);
        return;
    L10:
        return;
    L5:
        r0 = ObricListeningPresentationState.g;
        goto L6
    }

    public static void k(final Function0 r2) {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L5;
        r2.invoke();
        return;
    L5:
        b.post(new m1(r2));
    }

    public static void l(SurfaceControl r3) {
        if (r3 == null) goto L13;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        r3.release();     // Catch: Throwable -> L5
        Object r4 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r5 = Result.exceptionOrNull-impl(r4);
        if (r5 == null) goto L14;
        FLogger.a.w("ObricListeningMainPM", "release child Surface copy failed", r5);
        return;
    L14:
        return;
    L5:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public static void p(final ObricListeningViewState r3) {
        Intrinsics.checkNotNullParameter(r3, LynxResourceModule.DATA_KEY);
        float r0 = r3.c;
        if (Float.isInfinite(r0) == false) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == true) goto L11;
        FLogger.a.w("ObricListeningMainPM", "drop non-finite listening amplitude, mode=" + r3.a + ", amplitude=" + r3.c);
        return;
    L11:
        k(new o0(r3));
        return;
    L5:
        if (Float.isNaN(r0) == true) goto L7;
        r1 = true;
        goto L8
    }

    public static void a(final b r14, boolean r15) {
        if (f == true) goto L6;
        final String r0 = "child_not_owned";
    L10:
        if (r0 != null) goto L12;
        AssistantStartupTelemetry r1 = AssistantStartupTelemetry.a;
        final String r3 = r1.h();
        final String r5 = r1.i("window_content_ready");
        final boolean r13 = Intrinsics.areEqual(r5, r14.b);
        if (r15 == false) goto L19;
    L22:
        boolean r8 = true;
    L24:
        if (Intrinsics.areEqual(r3, r14.b) == false) goto L26;
        if (r13 == true) goto L35;
        if (r8 == true) goto L35;
        u = r14;
        FLogger.a.g("ObricListeningMainPM", new d0(r14, r5));
        return;
    L35:
        u = null;
        if (Intrinsics.areEqual(v, r14.b) == false) goto L38;
        v = null;
    L38:
        final boolean r4 = r1.k(r14.b, r14.c, "child_first_frame");
        Map r9 = MapsKt.createMapBuilder();
        if (r4 == true) goto L41;
        if (r13 == true) goto L41;
    L42:
        if (r13 == false) goto L44;
        r9.put("window_ready_source", "child_first_frame");
    L44:
        Map r11 = MapsKt.build(r9);
        if ((!r11.isEmpty()) == false) goto L47;
        IAssistantStartupTelemetry.a.e(r1, r14.b, null, null, r11, 14);
    L47:
        final boolean r6 = r1.d(r14.b, "first_frame_ready", r14.c);
        if (r13 == false) goto L50;
        Boolean r7 = Boolean.valueOf(r1.d(r14.b, "window_content_ready", r14.c));
    L51:
        final Boolean r10 = r7;
        FLogger.a.g("ObricListeningMainPM", new e0(r14, r13, r4, r6, r10));
        return;
    L50:
        r7 = null;
    L41:
        r9.put("child_surface_generation", String.valueOf(r14.a));
        goto L42
    L26:
        if (Intrinsics.areEqual(v, r14.b) == false) goto L29;
        v = null;
        u = null;
        FLogger.a.g("ObricListeningMainPM", new b0(r14));
        return;
    L29:
        u = r14;
        FLogger.a.g("ObricListeningMainPM", new c0(r14, r3, r5));
        return;
    L19:
        if (Intrinsics.areEqual(v, r14.b) == true) goto L22;
        r8 = false;
        goto L24
    L12:
        if (u != r14) goto L14;
        u = null;
    L14:
        FLogger.a.g("ObricListeningMainPM", new o1(r0, r14));
        return;
    L6:
        if (r14.a == l) goto L8;
        r0 = "stale_generation";
        goto L10
    L8:
        r0 = null;
        goto L10
    }

    public static boolean c(String r7, final Function0 r8) {
        c r0 = t.get();
        if (r0 != null) goto L6;
        return false;
    L6:
        if (r0.b == false) goto L11;
        if (r0.c.isValid() == true) goto L11;
        return false;
    L11:
        if (r0.b == true) goto L14;
        FLogger.a.i("ObricListeningMainPM", "drop " + r7 + " while child terminal pending, pendingSequence=" + r0.a);
        return true;
    L14:
        FLogger.a.i("ObricListeningMainPM", "defer " + r7 + " until fallback applied, pendingSequence=" + r0.a);
        b.post(new n1(r8));
        return true;
    }

    public static final void b(ObricListeningMainProcessManager r6, boolean r7, ObricListeningPresentationState r8) {
        r6.getClass();
        if (r8 != null) goto L6;
        r8 = ObricListeningPresentationState.g;
    L6:
        if (r7 == false) goto L11;
        if (r8.isValid() == true) goto L11;
        FLogger.a.w("ObricListeningMainPM", "drop invalid owned fallback state, revision=" + r8.a + ", renderer=" + r8.c + ", dataSource=" + r8.d + ", mode=" + r8.e.a);
        return;
    L11:
        if (f == false) goto L16;
        if (r8.a >= g.a) goto L16;
        FLogger.a.i("ObricListeningMainPM", "ignore stale fallback state, incomingRevision=" + r8.a + ", currentRevision=" + g.a);
        return;
    L16:
        if (f == r7) goto L18;
        boolean r1 = true;
    L19:
        if (r1 == false) goto L24;
        h = false;
        p = false;
        u = null;
        ObricListeningPresentationState r2 = ObricListeningPresentationState.g;
        xaa.b r3 = j;
        if (r3 == null) goto L23;
        r3.a(r2);
    L23:
        e();
    L24:
        f = r7;
        if (r7 == true) goto L28;
        r8 = ObricListeningPresentationState.g;
    L28:
        g = r8;
        if (r1 == false) goto L31;
        q = 0;
        r = 0;
    L31:
        FLogger.a.i("ObricListeningMainPM", "fallback state applied, owned=" + r7 + ", ownershipChanged=" + r1 + ", " + m());
        j(r6);
        i();
        return;
    L18:
        r1 = false;
        goto L19
    }

    public static void n(String r2, IObricInteractorPresentationBridgeService r3, boolean r4, Function1 r5) {
        Object r6 = c.trySend-JP2dKIU(new a(r2, r3, r4, r5));
        kotlinx.coroutines.channels.g.c r7 = kotlinx.coroutines.channels.g.b;
        if ((r6 instanceof kotlinx.coroutines.channels.g.c) == false) goto L9;
        FLogger r8 = FLogger.a;
        String r9 = "enqueue child bridge command failed, name=" + r2 + ", binder=" + r3.asBinder().hashCode();
        Throwable r10 = kotlinx.coroutines.channels.g.a(r6);
        if (r10 != null) goto L7;
        r10 = new IllegalStateException("child bridge command queue rejected ".concat(r2));
    L7:
        r8.w("ObricListeningMainPM", r9, r10);
        return;
    }

    public static /* synthetic */ void o(ObricListeningMainProcessManager r0, String r1, IObricInteractorPresentationBridgeService r2, Function1 r3) {
        r0.getClass();
        n(r1, r2, true, r3);
    }
}
