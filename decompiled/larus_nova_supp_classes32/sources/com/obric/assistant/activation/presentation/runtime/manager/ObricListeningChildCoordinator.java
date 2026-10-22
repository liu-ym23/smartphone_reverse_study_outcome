package com.obric.assistant.activation.presentation.runtime.manager;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.os.SystemClock;
import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.activation.presentation.contract.ObricListeningPresentationState;
import com.obric.assistant.activation.presentation.contract.ObricListeningViewState;
import com.obric.assistant.activation.presentation.contract.ObricListeningVisualMode;
import com.obric.assistant.activation.presentation.contract.feedback.ObricActivationFeedback;
import com.obric.assistant.activation.presentation.contract.gesture.ObricAiKeyGestureAction;
import com.obric.assistant.activation.presentation.contract.gesture.ObricAiKeyGestureState;
import com.obric.assistant.activation.presentation.contract.ipc.IObricMainPresentationBridgeCallback;
import com.obric.assistant.activation.presentation.runtime.precheck.ObricChildListeningPrecheck;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class ObricListeningChildCoordinator {
    public static ObricChildListeningPrecheck.b A;
    public static boolean B;
    public static r C;
    public static final x D = null;
    public static final ObricListeningChildCoordinator a = null;
    public static final Handler b = null;
    public static final CoroutineScope c = null;
    public static Job d;
    public static Context e;
    public static eba.i f;
    public static cba.b g;
    public static Function1<? super ActivationSource, ObricChildListeningPrecheck.b> h;
    public static IObricMainPresentationBridgeCallback i;
    public static IBinder j;
    public static j k;
    public static Function0<Unit> l;
    public static String m;
    public static String n;
    public static a o;
    public static RawOwner p;
    public static boolean q;
    public static long r;
    public static long s;
    public static ActivationSource t;
    public static String u;
    public static a v;
    public static a w;
    public static ObricListeningPresentationState x;
    public static long y;
    public static ObricListeningVisualMode z;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/assistant/activation/presentation/runtime/manager/ObricListeningChildCoordinator$RawOwner;", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Ljava/lang/String;I)V", "NONE", "MAIN", "CHILD", "runtime_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum RawOwner extends Enum<RawOwner> {
        public static final RawOwner CHILD = null;
        public static final RawOwner MAIN = null;
        public static final RawOwner NONE = null;
        public static final /* synthetic */ RawOwner[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<RawOwner> getEntries() {
            return b;
        }

        static {
            RawOwner r0 = new RawOwner("NONE", 0);
            NONE = r0;
            RawOwner r1 = new RawOwner("MAIN", 1);
            MAIN = r1;
            RawOwner r3 = new RawOwner("CHILD", 2);
            CHILD = r3;
            RawOwner[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
        }

        public static RawOwner[] values() {
            return (RawOwner[]) a.clone();
        }

        public static RawOwner valueOf(String r1) {
            return (RawOwner) r27.a.a(RawOwner.class, r1);
        }

        public RawOwner(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
        public final int a;
        public final String b;
        public final long c;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof a) == true) goto L8;
            return false;
        L8:
            a r9 = (a) r8;
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
            return "PendingChildFirstDraw(generation=" + this.a + ", startupAttemptId=" + this.b + ", timestampElapsedRealtimeMs=" + this.c + ')';
        }

        public a(int r2, String r3, long r4) {
            Intrinsics.checkNotNullParameter(r3, "startupAttemptId");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public static final class b {
        public final int a;
        public final ActivationSource b;
        public final int c;
        public final long d;
        public final long e;
        public final String f;

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
            if (this.b == r9.b) goto L15;
            return false;
        L15:
            if (this.c == r9.c) goto L18;
            return false;
        L18:
            if (this.d == r9.d) goto L21;
            return false;
        L21:
            if (this.e == r9.e) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f, r9.f) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            int r0 = ((((this.a * 31) + this.b.hashCode()) * 31) + this.c) * 31;
            long r1 = this.d;
            int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
            long r3 = this.e;
            int r4 = (r2 + ((int) (r3 ^ (r3 >>> 32)))) * 31;
            String r5 = this.f;
            if (r5 != null) goto L5;
            int r6 = 0;
        L7:
            return r4 + r6;
        L5:
            r6 = r5.hashCode();
            goto L7
        }

        public final String toString() {
            return "PreparedInput(showSessionId=" + this.a + ", source=" + this.b + ", invocationType=" + this.c + ", eventTimeMillis=" + this.d + ", activationStartWallClockMillis=" + this.e + ", startupAttemptId=" + this.f + ')';
        }

        public b(int r2, ActivationSource r3, int r4, long r5, long r7, String r9) {
            Intrinsics.checkNotNullParameter(r3, "source");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r7;
            this.f = r9;
        }
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;
        public static final /* synthetic */ int[] c = null;

        static {
            int[] r0 = new int[ActivationSource.values().length];
            r0[ActivationSource.AI_KEY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L27
        L61:
            r0[ActivationSource.POWER_KEY_TERMINAL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L28
        L73:
            r0[ActivationSource.VOICE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L29
        L47:
            r0[ActivationSource.BREATH.ordinal()] = 4;     // Catch: NoSuchFieldError -> L30
        L49:
            r0[ActivationSource.POWER_KEY.ordinal()] = 5;     // Catch: NoSuchFieldError -> L31
        L12:
            a = r0;
            int[] r1 = new int[ObricAiKeyGestureAction.values().length];
            r1[ObricAiKeyGestureAction.SINGLE_PRESS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L32
        L43:
            r1[ObricAiKeyGestureAction.DOUBLE_PRESS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L33
        L51:
            r1[ObricAiKeyGestureAction.PRESS_START.ordinal()] = 3;     // Catch: NoSuchFieldError -> L34
        L59:
            r1[ObricAiKeyGestureAction.SHORT_PRESS.ordinal()] = 4;     // Catch: NoSuchFieldError -> L35
        L65:
            r1[ObricAiKeyGestureAction.LONG_PRESS_START.ordinal()] = 5;     // Catch: NoSuchFieldError -> L36
        L45:
            r1[ObricAiKeyGestureAction.LONG_PRESS_STOP.ordinal()] = 6;     // Catch: NoSuchFieldError -> L37
        L53:
            r1[ObricAiKeyGestureAction.CANCEL.ordinal()] = 7;     // Catch: NoSuchFieldError -> L38
        L69:
            r1[ObricAiKeyGestureAction.TIMEOUT.ordinal()] = 8;     // Catch: NoSuchFieldError -> L39
        L21:
            b = r1;
            int[] r2 = new int[RawOwner.values().length];
            r2[RawOwner.MAIN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L40
        L63:
            r2[RawOwner.CHILD.ordinal()] = 2;     // Catch: NoSuchFieldError -> L41
        L71:
            r2[RawOwner.NONE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L42
        L25:
            c = r2;
        }
    }

    public ObricListeningChildCoordinator() {
    }

    /* JADX WARN: Type inference failed for: r0v11, types: [com.obric.assistant.activation.presentation.runtime.manager.x] */
    static {
        a = new ObricListeningChildCoordinator();
        b = new Handler(Looper.getMainLooper());
        c = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        p = RawOwner.NONE;
        s = -1;
        x = ObricListeningPresentationState.g;
        z = ObricListeningVisualMode.HIDDEN;
        A = ObricChildListeningPrecheck.b.c;
        D = new x();
    }

    public static void b() {
        final a r0 = v;
        if (r0 != null) goto L5;
        return;
    L5:
        IObricMainPresentationBridgeCallback r1 = i;
        if (r1 != null) goto L13;
        FLogger.a.g("ObricListeningChildCoordinator", new h());
        return;
    L13:
        r1.onChildFirstFrameReady(r0.a, r0.b, r0.c);     // Catch: RemoteException -> L11
        v = null;     // Catch: RemoteException -> L11
        FLogger.a.g("ObricListeningChildCoordinator", new i(r0));     // Catch: RemoteException -> L11
        return;
    L11:
        FLogger.a.w("ObricListeningChildCoordinator", "child_first_draw_failed: reason=remote_exception");
        a(r1.asBinder());
    }

    public static void c() {
        ActivationSource r0 = t;
        ActivationSource r1 = ActivationSource.AI_KEY;
        if (r0 == r1) goto L5;
        return;
    L5:
        if (A.a != ObricChildListeningPrecheck.Status.NOT_STARTED) goto L15;
        Function1<? super ActivationSource, ObricChildListeningPrecheck.b> r2 = h;
        if (r2 == null) goto L11;
        ObricChildListeningPrecheck.b r3 = (ObricChildListeningPrecheck.b) r2.invoke(r1);
        if (r3 == null) goto L11;
    L12:
        A = r3;
        FLogger.a.i("ObricListeningChildCoordinator", "child_precheck_started: source=" + t + " result=" + A.a + " reason=" + A.b);
        return;
    L11:
        ObricChildListeningPrecheck.b r4 = ObricChildListeningPrecheck.b.c;
        ObricChildListeningPrecheck.Reason r5 = ObricChildListeningPrecheck.Reason.HOST_STATE_MISSING;
        Intrinsics.checkNotNullParameter(r5, "reason");
        r3 = new ObricChildListeningPrecheck.b(ObricChildListeningPrecheck.Status.BLOCKED, r5);
        goto L12
    }

    public static void d() {
        boolean r0 = q;
        ActivationSource r1 = t;
        if (r1 != ActivationSource.AI_KEY) goto L7;
        String r2 = m;
        if (r2 == null) goto L7;
        n = r2;
        o = w;
    L7:
        cba.b r3 = g;
        if (r3 == null) goto L10;
        r3.i("external");
    L10:
        q(RawOwner.NONE);
        Handler r4 = b;
        r4.removeCallbacks(D);
        r r5 = C;
        if (r5 == null) goto L13;
        r4.removeCallbacks(r5);
    L13:
        C = null;
        if (q == false) goto L22;
        ObricListeningPresentationState r6 = ObricListeningPresentationState.a(x, f(), 0, 0, ObricListeningViewState.d, false, 46);
        x = r6;
        eba.i r7 = f;
        if (r7 == null) goto L21;
        if (r1 == null) goto L20;
        r7.g(r6, r1, s);
        goto L21
    L20:
        throw new IllegalStateException("Required value was null.".toString());
    L21:
        q = false;
        h();
    L22:
        t = null;
        u = null;
        v = null;
        w = null;
        x = ObricListeningPresentationState.g;
        z = ObricListeningVisualMode.HIDDEN;
        A = ObricChildListeningPrecheck.b.c;
        B = false;
        if (r0 == false) goto L26;
        FLogger.a.i("ObricListeningChildCoordinator", "child_activation_finished: source=" + r1);
        return;
    }

    public static long f() {
        long r0 = Math.max(y, x.a);
        if (r0 >= Long.MAX_VALUE) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L10;
        long r1 = r0 + 1;
        y = r1;
        return r1;
    L10:
        throw new IllegalStateException("listening presentation revision exhausted".toString());
    L5:
        r2 = false;
        goto L6
    }

    public static void h() {
        IObricMainPresentationBridgeCallback r0 = i;
        if (r0 != null) goto L9;
        return;
    L9:
        r0.onFallbackStateChanged(q, x);     // Catch: RemoteException -> L7
        return;
    L7:
        FLogger.a.w("ObricListeningChildCoordinator", "notify_fallback_state_failed: reason=remote_exception");
        a(r0.asBinder());
    }

    public static boolean n() {
        eba.i r0 = f;
        if (r0 == null) goto L11;
        ObricListeningPresentationState r1 = x;
        ActivationSource r2 = t;
        if (r2 == null) goto L10;
        if (r0.g(r1, r2, s) != true) goto L11;
        return true;
    L10:
        throw new IllegalStateException("Required value was null.".toString());
    L11:
        return false;
    }

    public static void o() {
        if (B == false) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == true) goto L11;
        return;
    L11:
        if (x.b() == true) goto L14;
        return;
    L14:
        if (n() == true) goto L16;
        FLogger.a.w("ObricListeningChildCoordinator", "visual_mode_render_failed: mode=" + z + " trigger=activation_type_updated");
        x = ObricListeningPresentationState.a(x, f(), 0, 0, ObricListeningViewState.d, false, 46);
        return;
    L16:
        if (x.f == true) goto L21;
        e("activation_type_updated");
        return;
    L21:
        return;
    L5:
        if (x.e.b() == false) goto L8;
        r0 = false;
        goto L9
    }

    public static RawOwner p() {
        sna.h r0 = sna.h.a;
        boolean r1 = sna.h.a().getBoolean("window_mode_enabled", false);
        boolean r2 = ((Boolean) ObricMainProcessStateManager.c.getValue()).booleanValue();
        if (r1 == true) goto L5;
        RawOwner r3 = RawOwner.MAIN;
    L8:
        FLogger.a.i("ObricListeningChildCoordinator", "resolveRawOwner owner=" + r3 + " mainProcessReady=" + r2 + " windowModeEnabled=" + r1);
        return r3;
    L5:
        if (r2 == false) goto L7;
        r3 = RawOwner.MAIN;
        goto L8
    L7:
        r3 = RawOwner.CHILD;
        goto L8
    }

    public static void s() {
        FLogger r0 = FLogger.a;
        r0.i("ObricListeningChildCoordinator", "unlink_callback:");
        j r2 = k;
        if (r2 != null) goto L18;
        r0.i("ObricListeningChildCoordinator", "unlink_callback_ignored: reason=missing_recipient");
        return;
    L18:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L12
        IBinder r3 = j;     // Catch: Throwable -> L12
        if (r3 == null) goto L9;
        Boolean r4 = Boolean.valueOf(r3.unlinkToDeath(r2, 0));     // Catch: Throwable -> L12
    L10:
        Object r5 = Result.constructor-impl(r4);     // Catch: Throwable -> L12
    L15:
        if (Result.exceptionOrNull-impl(r5) == null) goto L20;
        FLogger.a.w("ObricListeningChildCoordinator", "unlink_callback_failed: reason=unlink_exception");
        return;
    L20:
        return;
    L9:
        r4 = null;
    L12:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    }

    public static void a(IBinder r3) {
        if (r3 != null) goto L7;
        FLogger.a.i("ObricListeningChildCoordinator", "clear_main_callback_ignored: reason=missing_expected_binder");
        return;
    L7:
        if (r3 == j) goto L10;
        FLogger.a.i("ObricListeningChildCoordinator", "clear_main_callback_ignored: reason=stale_binder");
        return;
    L10:
        s();
        i = null;
        j = null;
        k = null;
        eba.i r1 = f;
        if (r1 == null) goto L14;
        int r2 = eba.i.F;
        r1.f(null);
    L14:
        if (q == true) goto L16;
        d();
        FLogger.a.i("ObricListeningChildCoordinator", "clear_main_callback_finished");
        return;
    L16:
        if (v != null) goto L18;
        v = w;
    L18:
        FLogger.a.i("ObricListeningChildCoordinator", "clear_main_callback_waiting_for_reconnect");
    }

    public static boolean e(String r14) {
        if (q == true) goto L7;
        FLogger.a.i("ObricListeningChildCoordinator", "child_feedback_skipped: reason=activation_not_owned trigger=" + r14);
        return false;
    L7:
        if (x.b() == true) goto L11;
        FLogger.a.i("ObricListeningChildCoordinator", "child_feedback_skipped: reason=listening_ui_not_visible trigger=" + r14);
        return false;
    L11:
        if (x.f == false) goto L14;
        FLogger.a.i("ObricListeningChildCoordinator", "child_feedback_skipped: reason=already_played trigger=" + r14);
        return false;
    L14:
        ActivationSource r0 = t;
        if (r0 != null) goto L17;
        int r1 = -1;
    L19:
        if (r1 != (-1)) goto L21;
    L55:
        FLogger.a.i("ObricListeningChildCoordinator", "child_feedback_skipped: reason=unsupported_source source=" + t + " trigger=" + r14);
        return false;
    L21:
        if (r1 == 1) goto L34;
        int r5 = 2;
        if (r1 == 2) goto L55;
        if (r1 != 3) goto L27;
    L35:
        ObricActivationFeedback r2 = (ObricActivationFeedback) ServiceManager.get().getServiceForReal(ObricActivationFeedback.class);
        if (r2 != null) goto L57;
        FLogger.a.w("ObricListeningChildCoordinator", "child_feedback_unavailable: trigger=" + r14);
        return false;
    L57:
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L41
        Object r3 = Result.constructor-impl(Boolean.valueOf(r2.a(r5)));     // Catch: Throwable -> L41
    L43:
        Throwable r7 = Result.exceptionOrNull-impl(r3);
        if (r7 == null) goto L46;
        FLogger.a.w("ObricListeningChildCoordinator", "child_feedback_failed: trigger=" + r14, r7);
    L46:
        Boolean r8 = Boolean.FALSE;
        if (Result.isFailure-impl(r3) == false) goto L50;
        r3 = r8;
    L50:
        if (((Boolean) r3).booleanValue() == true) goto L53;
        FLogger.a.w("ObricListeningChildCoordinator", "child_feedback_not_accepted: trigger=" + r14);
        return false;
    L53:
        x = ObricListeningPresentationState.a(x, f(), 0, 0, null, true, 30);
        FLogger.a.i("ObricListeningChildCoordinator", "child_feedback_played: source=" + t + " trigger=" + r14 + " revision=" + x.a);
        return true;
    L41:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L43
    L27:
        if (r1 != 4) goto L29;
        r5 = 3;
        goto L35
    L29:
        if (r1 == 5) goto L34;
        throw new NoWhenBranchMatchedException();
    L34:
        r5 = 1;
        goto L35
    L17:
        r1 = c.a[r0.ordinal()];
        goto L19
    }

    public static void g(RawOwner r4) {
        Function0<Unit> r0 = l;
        FLogger r1 = FLogger.a;
        StringBuilder r2 = new StringBuilder("ai_key_down_ready_to_dispatch: owner=");
        r2.append(r4);
        r2.append(" listenerRegistered=");
        if (r0 == null) goto L5;
        boolean r5 = true;
    L6:
        r2.append(r5);
        r1.i("ObricListeningChildCoordinator", r2.toString());
        if (r0 == null) goto L10;
        r0.invoke();
        return;
    L10:
        return;
    L5:
        r5 = false;
        goto L6
    }

    public static void i(final Function0 r2) {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L5;
        r2.invoke();
        return;
    L5:
        b.post(new m(r2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [com.obric.assistant.activation.presentation.runtime.manager.r, java.lang.Runnable] */
    public static void j(Bundle r21) {
        Intrinsics.checkNotNullParameter(r21, "args");
        com.obric.assistant.common.utils.i.a r3 = com.obric.assistant.common.utils.i.a("ObricListeningChildCoordinator_onShow");
        ObricListeningChildCoordinator r4 = a;     // Catch: Throwable -> L23
        int r5 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L23
        r4.getClass();     // Catch: Throwable -> L23
        b r6 = k(r21, r5);     // Catch: Throwable -> L23
        int r7 = -1;
        if (r6 != null) goto L10;
        FLogger.a.i("ObricListeningChildCoordinator", "on_show_ignored: reason=invalid_input");     // Catch: Throwable -> L23
        r21.putInt("obric_listening_show_owner", -1);     // Catch: Throwable -> L23
        if (r3 == null) goto L45;
        r3.a();
        return;
    L45:
        return;
    L10:
        int r8 = c.a[r6.b.ordinal()];     // Catch: Throwable -> L23
        if (r8 != 1) goto L13;
        r7 = l(r6, r21);     // Catch: Throwable -> L23
    L28:
        r21.putInt("obric_listening_show_owner", r7);     // Catch: Throwable -> L23
        FLogger r0 = FLogger.a;     // Catch: Throwable -> L23
        r0.i("ObricListeningChildCoordinator", "on_show_finished: source=" + r6.b + " showSessionId=" + r6.a + " invocationType=" + r6.c + " owner=" + r7 + " rawOwner=" + p);     // Catch: Throwable -> L23
        if (r7 == 1) goto L34;
        r0.i("ObricListeningChildCoordinator", "framework_show_render_ignored: owner=" + r7 + " reason=main_owner");     // Catch: Throwable -> L23
        if (r3 == null) goto L46;
        r3.a();
        return;
    L46:
        return;
    L34:
        r0.i("ObricListeningChildCoordinator", "framework_show_render_scheduled: owner=child");     // Catch: Throwable -> L23
        r r1 = C;     // Catch: Throwable -> L23
        if (r1 == null) goto L37;
        b.removeCallbacks(r1);     // Catch: Throwable -> L23
    L37:
        ?? r2 = new r();     // Catch: Throwable -> L23
        C = r2;     // Catch: Throwable -> L23
        b.post(r2);     // Catch: Throwable -> L23
        Unit r9 = Unit.INSTANCE;     // Catch: Throwable -> L23
        if (r3 == null) goto L47;
        r3.a();
        return;
    L47:
        return;
    L13:
        if (r8 == 2) goto L26;
        long r10 = SystemClock.uptimeMillis();     // Catch: Throwable -> L23
        long r12 = r;     // Catch: Throwable -> L23
        if (r12 <= 0) goto L17;
        long r13 = RangesKt.coerceAtLeast(r10 - r12, 0);     // Catch: Throwable -> L23
    L18:
        s = r13;     // Catch: Throwable -> L23
        r = r10;     // Catch: Throwable -> L23
        ActivationSource r11 = r6.b;     // Catch: Throwable -> L23
        if (q == false) goto L21;
    L25:
        r(r6.d, r6.e, r11, ObricListeningVisualMode.CLICK_TALK, r6.f);     // Catch: Throwable -> L23
        r7 = 1;
        goto L28
    L21:
        if (p() != RawOwner.CHILD) goto L28;
    L17:
        r13 = -1;
        goto L18
    L26:
        m(r6);     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        if (r3 == null) goto L43;
        r3.a();
    L43:
        throw th;
    }

    public static void m(b r4) {
        if (q == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        if (r0 == true) goto L10;
        FLogger.a.i("ObricListeningChildCoordinator", "power_key_terminal_ignored: reason=no_matching_activation showSessionId=" + r4.a + " source=" + t);
    L10:
        if (r0 == false) goto L13;
        d();
        return;
    L13:
        return;
    L5:
        if (t != ActivationSource.POWER_KEY) goto L7;
        r0 = true;
        goto L8
    }

    public static void q(RawOwner r3) {
        p = r3;
        if (r3 != RawOwner.NONE) goto L5;
        m = null;
    L5:
        FLogger.a.i("ObricListeningChildCoordinator", "rawOwner " + r3);
    }

    public static b k(Bundle r20, int r21) {
        if (r21 >= 35) goto L6;
        FLogger.a.i("ObricListeningChildCoordinator", "parse_input_ignored: reason=unsupported_sdk sdkInt=" + r21);
        return null;
    L6:
        int r8 = r20.getInt("invocation_type", Integer.MIN_VALUE);
        boolean r1 = Intrinsics.areEqual(r20.getString("REQUEST_FROM"), "VOICE_ASSIST");
        String r2 = r20.getString("sessionName");
        int r5 = xaa.a.a;
        if (r8 != 20) goto L9;
    L14:
        boolean r6 = true;
    L15:
        if (r6 == false) goto L18;
        ActivationSource r3 = ActivationSource.AI_KEY;
    L30:
        Intrinsics.checkNotNullParameter(r20, "<this>");
        int r4 = r20.getInt("android.service.voice.SHOW_SESSION_ID");
        if (r4 >= 0) goto L34;
        FLogger.a.w("ObricListeningChildCoordinator", "parse_input_ignored: reason=invalid_show_session_id showSessionId=" + r4 + " source=" + r3);
        return null;
    L34:
        long r9 = SystemClock.uptimeMillis();
        long r11 = System.currentTimeMillis();
        long r15 = r20.getLong("android.intent.extra.TIME", -1);
        Long r7 = Long.valueOf(r15);
        if (r7.longValue() <= 0) goto L37;
        boolean r17 = true;
    L38:
        if (r17 == true) goto L41;
        r7 = null;
    L41:
        if (r7 == null) goto L43;
        long r18 = r7.longValue();
    L44:
        int r10 = c.a[r3.ordinal()];
        if (r10 != 1) goto L47;
    L67:
        Long r12 = Long.valueOf(r15);
        if (r12.longValue() <= 0) goto L70;
        boolean r13 = true;
    L71:
        if (r13 == true) goto L74;
        r12 = null;
    L74:
        if (r12 == null) goto L76;
        r11 = r11 - RangesKt.coerceAtLeast(r9 - r12.longValue(), 0);
    L76:
        String r0 = r20.getString("obric_startup_attempt_id");
        if (r0 != null) goto L79;
    L81:
        String r14 = null;
    L83:
        return new b(r4, r3, r8, r18, r11, r14);
    L79:
        if ((!StringsKt.isBlank(r0)) == false) goto L81;
        r14 = r0;
        goto L83
    L70:
        r13 = false;
        goto L71
    L47:
        if (r10 != 2) goto L49;
        r11 = 0;
        goto L76
    L49:
        if (r10 != 3) goto L51;
    L57:
        Long r16 = Long.valueOf(r20.getLong("WAKEUP_START_TIME", -1));
        if (r16.longValue() <= 0) goto L60;
        boolean r19 = true;
    L61:
        if (r19 == true) goto L64;
        r16 = null;
    L64:
        if (r16 == null) goto L76;
        r11 = r16.longValue();
        goto L76
    L60:
        r19 = false;
        goto L61
    L51:
        if (r10 == 4) goto L57;
        if (r10 == 5) goto L67;
        throw new NoWhenBranchMatchedException();
    L43:
        r18 = r9;
        goto L44
    L37:
        r17 = false;
        goto L38
    L18:
        if (r8 != 6) goto L21;
        r3 = ActivationSource.POWER_KEY;
        goto L30
    L21:
        if (r8 != (-2)) goto L23;
        r3 = ActivationSource.POWER_KEY_TERMINAL;
        goto L30
    L23:
        if (r1 == true) goto L25;
        FLogger.a.i("ObricListeningChildCoordinator", "parse_input_ignored: reason=unsupported_invocation invocationType=" + r8);
        return null;
    L25:
        if (Intrinsics.areEqual(r2, "VOICE") == false) goto L28;
        r3 = ActivationSource.VOICE;
        goto L30
    L28:
        if (Intrinsics.areEqual(r2, "BREATH") == false) goto L84;
        r3 = ActivationSource.BREATH;
        goto L30
    L84:
        FLogger.a.i("ObricListeningChildCoordinator", "parse_input_ignored: reason=unsupported_voice_session sessionName=" + r2 + " invocationType=" + r8);
        return null;
    L9:
        if (r8 == 21) goto L14;
        if (r8 == 22) goto L14;
        r6 = false;
        goto L15
    }

    public static int l(b r11, Bundle r12) {
        if (r11.c == 20) goto L5;
    L17:
        final String r0 = m;
        boolean r3 = false;
        if (r0 != null) goto L27;
        r0 = n;
        if (r11.c == 20) goto L22;
        boolean r5 = true;
    L23:
        if (r5 == true) goto L27;
        r0 = null;
        goto L27
    L22:
        r5 = false;
    L27:
        if (r0 == null) goto L54;
        r12.putString("obric_startup_attempt_id", r0);
        a.getClass();
        final a r6 = w;
        if (r6 != null) goto L31;
    L36:
        r6 = o;
        if (r6 != null) goto L39;
    L41:
        r6 = null;
    L42:
        if (r6 != null) goto L53;
        a r13 = w;
        if (r13 == null) goto L47;
        String r14 = r13.b;
        if (r14 == null) goto L47;
    L51:
        if (r14 == null) goto L54;
        FLogger.a.w("ObricListeningChildCoordinator", "child_first_draw_bundle_ignored: reason=attempt_mismatch evidenceAttemptId=" + r14 + " attemptId=" + r0);
    L47:
        a r15 = o;
        if (r15 == null) goto L50;
        r14 = r15.b;
        goto L51
    L50:
        r14 = null;
    L53:
        r12.putLong("obric_child_first_frame_elapsed_ms", r6.c);
        r12.putInt("obric_child_first_frame_generation", r6.a);
        FLogger.a.g("ObricListeningChildCoordinator", new w(r6, r0));
        goto L54
    L39:
        if (Intrinsics.areEqual(r6.b, r0) == false) goto L41;
    L31:
        if (Intrinsics.areEqual(r6.b, r0) == true) goto L34;
        r6 = null;
    L34:
        if (r6 == null) goto L36;
    L54:
        RawOwner r16 = p;
        RawOwner r1 = RawOwner.CHILD;
        if (r16 != r1) goto L57;
        int r17 = 1;
    L58:
        int r7 = r11.c;
        long r8 = r11.d;
        switch(r7) {
            case 20: goto L67;
            case 21: goto L64;
            case 22: goto L61;
            default: goto L71;
        };
    L61:
        cba.b r9 = g;
        if (r9 == null) goto L71;
        r9.f(r8);
        goto L71
    L64:
        cba.b r10 = g;
        if (r10 == null) goto L71;
        r10.h(r8);
        goto L71
    L67:
        cba.b r18 = g;
        if (r18 == null) goto L71;
        r18.g(r8);
    L71:
        if (p != r1) goto L84;
        cba.b r2 = g;
        if (r2 != null) goto L75;
    L80:
        boolean r4 = false;
    L81:
        if (r4 == false) goto L84;
        q(RawOwner.NONE);
    L97:
        if (r11.c == 20) goto L108;
        cba.b r19 = g;
        if (r19 != null) goto L101;
    L106:
        if (r3 == false) goto L108;
        n = null;
        o = null;
        w = null;
        goto L108
    L101:
        if (r19.d == ObricAiKeyGestureState.IDLE) goto L103;
        boolean r110 = true;
    L104:
        if (r110 == true) goto L106;
        r3 = true;
        goto L106
    L103:
        r110 = false;
    L108:
        return r17;
    L75:
        if (r2.d == ObricAiKeyGestureState.IDLE) goto L77;
        boolean r20 = true;
    L78:
        if (r20 == true) goto L80;
        r4 = true;
        goto L81
    L77:
        r20 = false;
    L84:
        if (p != RawOwner.MAIN) goto L97;
        cba.b r21 = g;
        if (r21 != null) goto L88;
    L93:
        boolean r22 = false;
    L94:
        if (r22 == false) goto L97;
        FLogger.a.i("ObricListeningChildCoordinator", "main_raw_owner_released: reason=recognizer_idle invocationType=" + r11.c + " showSessionId=" + r11.a);
        q(RawOwner.NONE);
        goto L97
    L88:
        if (r21.d == ObricAiKeyGestureState.IDLE) goto L90;
        boolean r23 = true;
    L91:
        if (r23 == true) goto L93;
        r22 = true;
        goto L94
    L90:
        r23 = false;
        goto L91
    L57:
        r17 = -1;
        goto L58
    L5:
        if (p != RawOwner.NONE) goto L17;
        n = null;
        o = null;
        if (q == false) goto L9;
        RawOwner r24 = RawOwner.CHILD;
    L10:
        String r25 = r11.f;
        if (r25 != null) goto L14;
        r25 = UUID.randomUUID().toString();
    L14:
        if (r24 != RawOwner.CHILD) goto L16;
        r(r11.d, r11.e, ActivationSource.AI_KEY, ObricListeningVisualMode.HIDDEN, r25);
    L16:
        m = r25;
        q(r24);
        goto L17
    L9:
        r24 = p();
        goto L10
    }

    public static void t(ActivationSource r17, ObricListeningVisualMode r18) {
        ObricListeningVisualMode r2 = z;
        boolean r4 = false;
        if (r2 != ObricListeningVisualMode.HIDDEN) goto L7;
        if (r18 != ObricListeningVisualMode.CLICK_TALK) goto L7;
    L10:
        boolean r3 = true;
    L13:
        if (r3 == true) goto L16;
        FLogger.a.i("ObricListeningChildCoordinator", "activation_type_update_ignored: currentSource=" + t + " incomingSource=" + r17 + " currentMode=" + r2 + " incomingMode=" + r18);
        return;
    L16:
        ActivationSource r5 = t;
        t = r17;
        z = r18;
        FLogger r7 = FLogger.a;
        r7.i("ObricListeningChildCoordinator", "activation_type_updated: source=" + r5 + "->" + r17 + " mode=" + r2 + "->" + r18);
        ObricListeningPresentationState r0 = x;
        int r6 = r0.d;
        if (r6 == 1) goto L28;
        if (r6 != 1) goto L20;
        r7.i("ObricListeningChildCoordinator", "apply_child_fallback_ignored: reason=main_data_active");
        return;
    L20:
        ObricListeningVisualMode r1 = z;
        if (A.a != ObricChildListeningPrecheck.Status.PASSED) goto L23;
        r4 = true;
    L23:
        ObricListeningViewState r14 = z.a(r1, r4);
        if (Intrinsics.areEqual(r14, x.e) == false) goto L26;
        r7.i("ObricListeningChildCoordinator", "apply_child_fallback_ignored: reason=state_unchanged trigger=activation_type_updated precheck=" + A.a);
        return;
    L26:
        x = ObricListeningPresentationState.a(x, f(), 0, 0, r14, false, 46);
        o();
        h();
        return;
    L28:
        ObricListeningViewState r10 = ObricListeningViewState.a(r0.e, r18, 0.0f, 6);
        if (Intrinsics.areEqual(r10, x.e) == false) goto L31;
        return;
    L31:
        x = ObricListeningPresentationState.a(x, f(), 0, 0, r10, false, 46);
        o();
        h();
        return;
    L7:
        if (r2 == ObricListeningVisualMode.CLICK_TALK) goto L9;
    L11:
        r3 = false;
        goto L13
    L9:
        if (r18 != ObricListeningVisualMode.PRESS_TALK) goto L11;
        goto L10
    }

    public static void r(long r16, long r18, ActivationSource r20, ObricListeningVisualMode r21, String r22) {
        if (q == false) goto L10;
        if (r22 != null) goto L6;
    L8:
        t(r20, r21);
        return;
    L6:
        if (Intrinsics.areEqual(u, r22) == true) goto L8;
        u = r22;
        v = null;
        w = null;
        goto L8
    L10:
        FLogger r3 = FLogger.a;
        r3.i("ObricListeningChildCoordinator", "startChildActivation: source = " + r20 + ", initialMode = " + r21);
        boolean r4 = true;
        q = true;
        t = r20;
        u = r22;
        z = r21;
        A = ObricChildListeningPrecheck.b.c;
        B = false;
        if (r20 == ActivationSource.AI_KEY) goto L18;
        Function1<? super ActivationSource, ObricChildListeningPrecheck.b> r6 = h;
        if (r6 == null) goto L16;
        ObricChildListeningPrecheck.b r7 = (ObricChildListeningPrecheck.b) r6.invoke(r20);
        if (r7 == null) goto L16;
    L17:
        A = r7;
    L16:
        ObricChildListeningPrecheck.Reason r8 = ObricChildListeningPrecheck.Reason.HOST_STATE_MISSING;
        Intrinsics.checkNotNullParameter(r8, "reason");
        r7 = new ObricChildListeningPrecheck.b(ObricChildListeningPrecheck.Status.BLOCKED, r8);
    L18:
        ObricListeningVisualMode r9 = z;
        if (A.a == ObricChildListeningPrecheck.Status.PASSED) goto L22;
        r4 = false;
    L22:
        x = new ObricListeningPresentationState(f(), 0, 1, 0, z.a(r9, r4), false);
        Handler r2 = b;
        x r5 = D;
        r2.removeCallbacks(r5);
        r2.postAtTime(r5, r16 + 180000);
        h();
        r3.i("ObricListeningChildCoordinator", "child_activation_started: source=" + r20 + " initialMode=" + r21 + " visible=" + x.e.b() + " precheck=" + A.a + " reason=" + A.b + " revision=" + x.a + " startTime=" + r18);
    }
}
