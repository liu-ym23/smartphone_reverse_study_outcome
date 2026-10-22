package cba;

import android.os.SystemClock;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.activation.presentation.contract.gesture.ObricAiKeyGestureAction;
import com.obric.assistant.activation.presentation.contract.gesture.ObricAiKeyGestureState;
import com.obric.assistant.activation.presentation.runtime.gesture.scheduler.ObricAiKeyGestureTimeout;
import dba.c;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b {
    public final c a;
    public final Function0<bba.a> b;
    public final Function1<yaa.a, Unit> c;
    public ObricAiKeyGestureState d;
    public bba.a e;
    public long f;
    public long g;
    public long h;
    public int i;

    public static final class a {
    }

    /* JADX INFO: renamed from: cba.b$b, reason: collision with other inner class name */
    public /* synthetic */ class C0009b {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[ObricAiKeyGestureState.values().length];
            r0[ObricAiKeyGestureState.IDLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L21
        L40:
            r0[ObricAiKeyGestureState.FIRST_UP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L22
        L52:
            r0[ObricAiKeyGestureState.PRESS_START.ordinal()] = 3;     // Catch: NoSuchFieldError -> L23
        L42:
            r0[ObricAiKeyGestureState.LONG_PRESS.ordinal()] = 4;     // Catch: NoSuchFieldError -> L24
        L44:
            r0[ObricAiKeyGestureState.FIRST_DOWN.ordinal()] = 5;     // Catch: NoSuchFieldError -> L25
        L32:
            r0[ObricAiKeyGestureState.SECOND_DOWN.ordinal()] = 6;     // Catch: NoSuchFieldError -> L26
        L13:
            a = r0;
            int[] r1 = new int[ObricAiKeyGestureTimeout.values().length];
            r1[ObricAiKeyGestureTimeout.SINGLE_PRESS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L27
        L48:
            r1[ObricAiKeyGestureTimeout.PRESS_START.ordinal()] = 2;     // Catch: NoSuchFieldError -> L28
        L36:
            r1[ObricAiKeyGestureTimeout.LONG_PRESS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L29
        L46:
            r1[ObricAiKeyGestureTimeout.SECOND_PRESS.ordinal()] = 4;     // Catch: NoSuchFieldError -> L30
        L34:
            r1[ObricAiKeyGestureTimeout.GESTURE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L31
        L19:
            b = r1;
        }
    }

    static {
    }

    public final void f(long r3) {
        e("CANCEL", r3);
        ObricAiKeyGestureState r0 = this.d;
        if (r0 != ObricAiKeyGestureState.FIRST_DOWN) goto L5;
    L6:
        c(this, ObricAiKeyGestureAction.LONG_PRESS_FAILED, r0, r3);
    L8:
        if (r0 == ObricAiKeyGestureState.IDLE) goto L10;
        c(this, ObricAiKeyGestureAction.CANCEL, r0, r3);
    L10:
        i("key_cancel");
        return;
    L5:
        if (r0 != ObricAiKeyGestureState.PRESS_START) goto L8;
        goto L6
    }

    public final void g(long r10) {
        e("DOWN", r10);
        int r0 = C0009b.a[this.d.ordinal()];
        boolean r1 = true;
        if (r0 != 1) goto L5;
        k(r10);
        return;
    L5:
        if (r0 != 2) goto L7;
        bba.a r2 = this.e;
        if (r2 != null) goto L15;
        i("missing_config_second_down");
        return;
    L15:
        long r5 = r10 - this.g;
        if (0 <= r5) goto L18;
    L20:
        r1 = false;
    L21:
        if (r1 == true) goto L23;
        FLogger.a.i("ObricAiKeyGesture", "second_down_rejected: interval=" + r5 + " tap=" + r2.b + " eventTime=" + r10);
        k(r10);
        return;
    L23:
        this.a.b(ObricAiKeyGestureTimeout.SINGLE_PRESS);
        this.h = r10;
        this.d = ObricAiKeyGestureState.SECOND_DOWN;
        j(ObricAiKeyGestureTimeout.SECOND_PRESS, SystemClock.uptimeMillis(), r2.b);
        return;
    L18:
        if (r5 > r2.b) goto L20;
    L7:
        if (r0 != 3) goto L9;
    L11:
        FLogger.a.i("ObricAiKeyGesture", "input_ignored: input=DOWN state=" + this.d + " eventTime=" + r10);
        return;
    L9:
        if (r0 == 4) goto L11;
        FLogger.a.i("ObricAiKeyGesture", "input_invalid: input=DOWN state=" + this.d + " eventTime=" + r10);
        i("invalid_down");
    }

    public final void h(long r17) {
        e("UP", r17);
        int r0 = C0009b.a[this.d.ordinal()];
        boolean r2 = false;
        if (r0 != 3) goto L5;
        d(r17, false);
        return;
    L5:
        if (r0 != 4) goto L7;
        b(ObricAiKeyGestureAction.LONG_PRESS_STOP, this.d, r17, a(r17, this.f));
        i("long_press_stop");
        return;
    L7:
        if (r0 != 5) goto L9;
        bba.a r1 = this.e;
        if (r1 != null) goto L22;
        i("missing_config_first_up");
        return;
    L22:
        ObricAiKeyGestureState r3 = this.d;
        int r8 = a(r17, this.f);
        long r9 = this.f + r1.a;
        if (r17 < r9) goto L25;
        r2 = true;
    L25:
        long r12 = SystemClock.uptimeMillis();
        FLogger.a.i("ObricAiKeyGesture", "first_up_decision: duration=" + r8 + " eventTime=" + r17 + " pressStartEventTime=" + r9 + " reachedPressStart=" + r2 + " handledAt=" + r12 + " handlingDelay=" + (r12 - r17));
        this.a.b(ObricAiKeyGestureTimeout.PRESS_START);
        if (r2 == false) goto L28;
        this.d = ObricAiKeyGestureState.PRESS_START;
        c(this, ObricAiKeyGestureAction.PRESS_START, r3, r9);
        d(r17, true);
        return;
    L28:
        this.g = r17;
        this.i = r8;
        this.d = ObricAiKeyGestureState.FIRST_UP;
        c(this, ObricAiKeyGestureAction.LONG_PRESS_FAILED, r3, r17);
        j(ObricAiKeyGestureTimeout.SINGLE_PRESS, r17, r1.b);
        return;
    L9:
        if (r0 == 6) goto L11;
        FLogger.a.i("ObricAiKeyGesture", "input_invalid: input=UP state=" + this.d + " eventTime=" + r17);
        i("invalid_up");
        return;
    L11:
        bba.a r4 = this.e;
        if (r4 != null) goto L14;
        i("missing_config_second_up");
        return;
    L14:
        ObricAiKeyGestureState r5 = this.d;
        int r10 = a(r17, this.h);
        if (r10 > r4.b) goto L17;
        b(ObricAiKeyGestureAction.DOUBLE_PRESS, r5, r17, r10);
    L18:
        i("second_up");
        return;
    L17:
        FLogger.a.i("ObricAiKeyGesture", "second_up_rejected: duration=" + r10 + " tap=" + r4.b + " eventTime=" + r17);
        goto L18
    }

    public final void i(String r6) {
        ObricAiKeyGestureState r0 = this.d;
        ObricAiKeyGestureState r1 = ObricAiKeyGestureState.IDLE;
        if (r0 == r1) goto L5;
    L6:
        FLogger.a.i("ObricAiKeyGesture", "reset: reason=" + r6 + " state=" + this.d + " firstDown=" + this.f + " firstUp=" + this.g + " secondDown=" + this.h);
    L7:
        this.a.a();
        this.d = r1;
        this.e = null;
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.i = 0;
        return;
    L5:
        if (this.e == null) goto L7;
        goto L6
    }

    public final void k(long r8) {
        i("new_first_down");
        bba.a r0 = (bba.a) this.b.invoke();
        if (r0.a > 0) goto L5;
    L11:
        boolean r1 = false;
    L12:
        if (r1 == false) goto L14;
        bba.a r6 = r0;
    L16:
        if (r6 != null) goto L19;
        FLogger.a.i("ObricAiKeyGesture", "start_rejected: reason=invalid_config config=" + r0);
        return;
    L19:
        this.e = r6;
        this.f = r8;
        this.d = ObricAiKeyGestureState.FIRST_DOWN;
        FLogger.a.i("ObricAiKeyGesture", "start: state=" + this.d + " eventTime=" + r8 + " pressStart=" + r6.a + " tap=" + r6.b + " longAfterPressStart=" + r6.c + " gestureTimeout=" + r6.d);
        c(this, ObricAiKeyGestureAction.DOWN, ObricAiKeyGestureState.IDLE, r8);
        j(ObricAiKeyGestureTimeout.PRESS_START, r8, r6.a);
        j(ObricAiKeyGestureTimeout.GESTURE, r8, r6.d);
        return;
    L14:
        r6 = null;
        goto L16
    L5:
        if (r0.b <= 0) goto L11;
        if (r0.c <= 0) goto L11;
        if (r0.d <= 0) goto L11;
        r1 = true;
        goto L12
    }

    public static int a(long r6, long r8) {
        return (int) RangesKt.coerceIn(r6 - r8, 0, 2147483647L);
    }

    public final void d(long r12, boolean r14) {
        bba.a r0 = this.e;
        if (r0 != null) goto L6;
        i("missing_config_press_started_up");
        return;
    L6:
        long r3 = r0.c + (this.f + r0.a);
        if (r12 < r3) goto L9;
        boolean r1 = true;
    L10:
        if (r14 == false) goto L12;
        String r15 = "first_down_catch_up";
    L13:
        FLogger.a.i("ObricAiKeyGesture", "press_started_up_decision: source=" + r15 + " duration=" + a(r12, this.f) + " eventTime=" + r12 + " longPressStartEventTime=" + r3 + " reachedLongPress=" + r1);
        if (r1 == true) goto L17;
        ObricAiKeyGestureState r7 = this.d;
        this.a.b(ObricAiKeyGestureTimeout.LONG_PRESS);
        b(ObricAiKeyGestureAction.SHORT_PRESS, r7, r12, a(r12, this.f));
        i("short_press");
        return;
    L17:
        ObricAiKeyGestureState r16 = this.d;
        this.a.b(ObricAiKeyGestureTimeout.LONG_PRESS);
        this.d = ObricAiKeyGestureState.LONG_PRESS;
        c(this, ObricAiKeyGestureAction.LONG_PRESS_START, r16, r3);
        b(ObricAiKeyGestureAction.LONG_PRESS_STOP, this.d, r12, a(r12, this.f));
        i("long_press_stop");
        return;
    L12:
        r15 = "press_start_state";
        goto L13
    L9:
        r1 = false;
        goto L10
    }

    public final void e(String r4, long r5) {
        FLogger.a.i("ObricAiKeyGesture", "input: input=" + r4 + " state=" + this.d + " eventTime=" + r5 + " receivedAt=" + SystemClock.uptimeMillis() + " firstDown=" + this.f);
    }

    public b(dba.b r2, Function0 r3, Function1 r4) {
        Intrinsics.checkNotNullParameter(r2, "scheduler");
        Intrinsics.checkNotNullParameter(r3, "configProvider");
        Intrinsics.checkNotNullParameter(r4, "onEvent");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = ObricAiKeyGestureState.IDLE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v1, types: [cba.a] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void j(final ObricAiKeyGestureTimeout r6, long r7, long r9) {
        final long r0 = r7 + r9;
        FLogger.a.i("ObricAiKeyGesture", "schedule: type=" + r6 + " state=" + this.d + " sourceTime=" + r7 + " delay=" + r9 + " timeoutTime=" + r0);
        this.a.c(r6, r0, new cba.a(this, r6, r0));
    }

    public static /* synthetic */ void c(b r8, ObricAiKeyGestureAction r9, ObricAiKeyGestureState r10, long r11) {
        r8.b(r9, r10, r11, a(r11, r8.f));
    }

    public final void b(ObricAiKeyGestureAction r14, ObricAiKeyGestureState r15, long r16, int r18) {
        FLogger.a.i("ObricAiKeyGesture", "emit: action=" + r14 + " stateBefore=" + r15 + " stateAfter=" + this.d + " eventTime=" + r16 + " downTime=" + this.f + " duration=" + r18 + " firstTapDuration=" + this.i);
        this.c.invoke(new yaa.a(r14, r15, r16, this.f, r18, this.i));
    }
}
