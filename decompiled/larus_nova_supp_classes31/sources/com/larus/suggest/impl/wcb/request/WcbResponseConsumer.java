package com.larus.suggest.impl.wcb.request;

import android.os.SystemClock;
import com.larus.bmhome.chat.bean.NexPulseResponseData;
import com.larus.suggest.impl.wcb.policy.c0;
import com.larus.suggest.impl.wcb.policy.s;
import com.larus.suggest.impl.wcb.policy.t;
import com.larus.suggest.impl.wcb.policy.u;
import com.larus.suggest.impl.wcb.policy.z;
import com.larus.suggest.impl.wcb.render.h;
import com.larus.suggest.impl.wcb.render.i;
import com.larus.suggest.impl.wcb.render.m;
import com.larus.suggest.impl.wcb.render.n;
import com.larus.suggest.impl.wcb.render.o;
import com.larus.suggest.impl.wcb.render.p;
import com.larus.suggest.impl.wcb.render.q;
import com.larus.utils.logger.FLogger;
import hx9.l;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class WcbResponseConsumer {
    public final l a;
    public final kx9.a b;
    public final a c;
    public final m d;

    public WcbResponseConsumer(hx9.a r2, kx9.a r3, a r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "monitor");
        Intrinsics.checkNotNullParameter(r4, "inputStateTracker");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = new m(r2);
    }

    public final Object f(jx9.a r5, com.larus.suggest.impl.wcb.render.l r6, q r7, Function0<Boolean> r8, Continuation<? super n.b> r9) {
        if ((r9 instanceof WcbResponseConsumer$submitRenderPlan$1) == false) goto L7;
        WcbResponseConsumer$submitRenderPlan$1 r0 = (WcbResponseConsumer$submitRenderPlan$1) r9;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r10 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r8 = (Function0) r0.L$1;
        r5 = (jx9.a) r0.L$0;
        ResultKt.throwOnFailure(r10);
    L17:
        n r11 = (n) r10;
        if (((Boolean) r8.invoke()).booleanValue() == true) goto L21;
        return null;
    L21:
        if ((r11 instanceof n.b) == false) goto L24;
        return (n.b) r11;
    L24:
        if ((r11 instanceof n.a) == false) goto L28;
        kx9.a.d(this.b, r5, ((n.a) r11).a, true, 4);
        return null;
    L28:
        throw new NoWhenBranchMatchedException();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r10);
        r0.L$0 = r5;
        r0.L$1 = r8;
        r0.label = 1;
        r10 = r7.a(r6, r0);
        if (r10 != r2) goto L17;
        return r2;
    L7:
        r0 = new WcbResponseConsumer$submitRenderPlan$1(this, r9);
        goto L8
    }

    public final Object e(f r8, NexPulseResponseData r9, jx9.a r10, q r11, Function0 r12, ContinuationImpl r13) {
        m r0 = this.d;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r8, "snapshot");
        z r1 = r8.f.a;
        if (r1.e().b(r8, r9, r0.a) == false) goto L9;
        p r2 = r8.f.e;
        if (r2 == null) goto L9;
        if (r9 == null) goto L9;
        com.larus.suggest.impl.wcb.render.l.c r3 = new com.larus.suggest.impl.wcb.render.l.c(r2, r1.g().b(r8, r9));
    L11:
        if (r3 == null) goto L13;
        Object r14 = f(r10, r3, r11, r12, r13);
        if (r14 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L18;
        return r14;
    L18:
        return Unit.INSTANCE;
    L13:
        return Unit.INSTANCE;
    L9:
        r3 = null;
        goto L11
    }

    public final Object a(f r18, NexPulseResponseData r19, jx9.a r20, q r21, p r22, Function0<Boolean> r23, Continuation<? super Boolean> r24) {
        if ((r24 instanceof WcbResponseConsumer$acceptDisplay$1) == false) goto L7;
        WcbResponseConsumer$acceptDisplay$1 r3 = (WcbResponseConsumer$acceptDisplay$1) r24;
        int r4 = r3.label;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.label = r4 - Integer.MIN_VALUE;
    L8:
        Object r2 = r3.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r3.label;
        if (r6 == 0) goto L17;
        if (r6 == 1) goto L16;
        if (r6 != 2) goto L15;
        ResultKt.throwOnFailure(r2);
    L37:
        return Boxing.boxBoolean(false);
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        Function0 r1 = (Function0) r3.L$5;
        p r7 = (p) r3.L$4;
        q r9 = (q) r3.L$3;
        jx9.a r10 = (jx9.a) r3.L$2;
        NexPulseResponseData r11 = (NexPulseResponseData) r3.L$1;
        f r12 = (f) r3.L$0;
        ResultKt.throwOnFailure(r2);
        Function0 r13 = r1;
        q r14 = r9;
        NexPulseResponseData r15 = r11;
    L21:
        s r8 = (s) r2;
        if (((Boolean) r13.invoke()).booleanValue() == true) goto L26;
        return Boxing.boxBoolean(false);
    L26:
        if (r12.f.a.h().l(r12) == false) goto L30;
        FLogger.a.w("WcbLog", "intercept wcb result, reason=wcb consumed in conversation");
        return Boxing.boxBoolean(false);
    L30:
        if ((r8 instanceof s.b) == false) goto L39;
        FLogger r16 = FLogger.a;
        StringBuilder r17 = new StringBuilder("display.evaluate wcb cause ");
        s.b r25 = (s.b) r8;
        r17.append(r25.a);
        r16.i("WcbLog", r17.toString());
        kx9.a.d(this.b, r10, r25.a, true, 4);
        if (r7 != null) goto L37;
        r3.L$0 = null;
        r3.L$1 = null;
        r3.L$2 = null;
        r3.L$3 = null;
        r3.L$4 = null;
        r3.L$5 = null;
        r3.label = 2;
        if (e(r12, r15, r10, r14, r13, r3) != r5) goto L37;
        return r5;
    L39:
        return Boxing.boxBoolean(true);
    L17:
        ResultKt.throwOnFailure(r2);
        t r26 = r18.f.a.getDisplay();
        l r27 = this.a;
        r3.L$0 = r18;
        r15 = r19;
        r3.L$1 = r15;
        r10 = r20;
        r3.L$2 = r10;
        r14 = r21;
        r3.L$3 = r14;
        r3.L$4 = r22;
        r13 = r23;
        r3.L$5 = r13;
        r3.label = 1;
        r2 = r26.a(r18, r27, r3);
        if (r2 != r5) goto L20;
        return r5;
    L20:
        r7 = r22;
        r12 = r18;
    L7:
        r3 = new WcbResponseConsumer$acceptDisplay$1(this, r24);
        goto L8
    }

    public final Object b(f r9, NexPulseResponseData r10, jx9.a r11, q r12, p r13, Function0<Boolean> r14, Continuation<? super Boolean> r15) {
        if ((r15 instanceof WcbResponseConsumer$acceptInteraction$1) == false) goto L7;
        WcbResponseConsumer$acceptInteraction$1 r0 = (WcbResponseConsumer$acceptInteraction$1) r15;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        WcbResponseConsumer$acceptInteraction$1 r7 = r0;
        Object r16 = r7.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r7.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r16);
    L24:
        return Boxing.boxBoolean(false);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r16);
        u r17 = r9.f.a.d().a(r9, this.a, this.c);
        if ((r17 instanceof u.b) == false) goto L17;
        FLogger r4 = FLogger.a;
        StringBuilder r5 = new StringBuilder("[pipeline] interaction intercept wcb cause ");
        u.b r18 = (u.b) r17;
        r5.append(r18.a);
        r4.w("WcbLog", r5.toString());
        kx9.a.d(this.b, r11, r18.a, true, 4);
        if (r13 != null) goto L24;
        r7.label = 1;
        if (e(r9, r10, r11, r12, r14, r7) != r2) goto L24;
        return r2;
    L17:
        return Boxing.boxBoolean(true);
    L7:
        r0 = new WcbResponseConsumer$acceptInteraction$1(this, r15);
        goto L8
    }

    public final Object c(f r22, jx9.a r23, g r24, q r25, p r26, d r27, Continuation r28) {
        if ((r28 instanceof WcbResponseConsumer$consume$1) == false) goto L7;
        WcbResponseConsumer$consume$1 r1 = (WcbResponseConsumer$consume$1) r28;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        WcbResponseConsumer$consume$1 r11 = r1;
        Object r0 = r11.result;
        Object r12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r11.label;
        if (r3 == 0) goto L20;
        if (r3 == 1) goto L19;
        if (r3 == 2) goto L18;
        if (r3 == 3) goto L17;
        if (r3 != 4) goto L16;
        ResultKt.throwOnFailure(r0);
    L47:
        return r0;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        NexPulseResponseData r4 = (NexPulseResponseData) r11.L$5;
        Function0<Boolean> r5 = (Function0) r11.L$4;
        p r6 = (p) r11.L$3;
        q r7 = (q) r11.L$2;
        jx9.a r8 = (jx9.a) r11.L$1;
        f r9 = (f) r11.L$0;
        ResultKt.throwOnFailure(r0);
        Function0<Boolean> r10 = r5;
        p r13 = r6;
        f r14 = r9;
        q r15 = r7;
        NexPulseResponseData r16 = r4;
    L42:
        if (((Boolean) r0).booleanValue() == true) goto L44;
        return null;
    L44:
        r11.L$0 = null;
        r11.L$1 = null;
        r11.L$2 = null;
        r11.L$3 = null;
        r11.L$4 = null;
        r11.L$5 = null;
        r11.label = 4;
        r0 = d(r14, r16, r8, r15, r13, r10, r11);
        if (r0 != r12) goto L47;
        return r12;
    L18:
        NexPulseResponseData r17 = (NexPulseResponseData) r11.L$5;
        Function0<Boolean> r18 = (Function0) r11.L$4;
        p r19 = (p) r11.L$3;
        q r20 = (q) r11.L$2;
        jx9.a r21 = (jx9.a) r11.L$1;
        f r29 = (f) r11.L$0;
        ResultKt.throwOnFailure(r0);
        Function0<Boolean> r30 = r18;
        p r31 = r19;
        q r32 = r20;
        jx9.a r33 = r21;
        f r34 = r29;
    L35:
        if (((Boolean) r0).booleanValue() == true) goto L37;
        return null;
    L37:
        r11.L$0 = r34;
        r11.L$1 = r33;
        r11.L$2 = r32;
        r11.L$3 = r31;
        r11.L$4 = r30;
        r11.L$5 = r17;
        r11.label = 3;
        f r35 = r34;
        jx9.a r110 = r33;
        q r111 = r32;
        p r112 = r31;
        Function0<Boolean> r113 = r30;
        Object r36 = b(r34, r17, r33, r32, r31, r30, r11);
        if (r36 != r12) goto L40;
        return r12;
    L40:
        r14 = r35;
        r16 = r17;
        r0 = r36;
        r8 = r110;
        r10 = r113;
        r13 = r112;
        r15 = r111;
        goto L42
    L19:
        Function0<Boolean> r37 = (Function0) r11.L$4;
        p r38 = (p) r11.L$3;
        q r39 = (q) r11.L$2;
        jx9.a r40 = (jx9.a) r11.L$1;
        f r41 = (f) r11.L$0;
        ResultKt.throwOnFailure(r0);
        Function0<Boolean> r42 = r37;
        p r43 = r38;
        q r44 = r39;
        jx9.a r45 = r40;
        Object r46 = r0;
        f r47 = r41;
    L27:
        NexPulseResponseData r48 = (NexPulseResponseData) r46;
        if (r48 != null) goto L30;
        return null;
    L30:
        r11.L$0 = r47;
        r11.L$1 = r45;
        r11.L$2 = r44;
        r11.L$3 = r43;
        r11.L$4 = r42;
        r11.L$5 = r48;
        r11.label = 2;
        Function0<Boolean> r114 = r42;
        p r115 = r43;
        q r116 = r44;
        Object r49 = a(r47, r48, r45, r44, r43, r114, r11);
        if (r49 != r12) goto L33;
        return r12;
    L33:
        r34 = r47;
        r33 = r45;
        r0 = r49;
        r17 = r48;
        r30 = r114;
        r31 = r115;
        r32 = r116;
        goto L35
    L20:
        ResultKt.throwOnFailure(r0);
        FLogger.a.i("WcbLog", "[pipeline] result.consume chat=" + r22.d + " exec=" + r22.e + " source=" + r24.b + " result=" + r24.a.getClass().getSimpleName());
        if (((Boolean) r27.invoke()).booleanValue() == true) goto L23;
        return null;
    L23:
        r11.L$0 = r22;
        r11.L$1 = r23;
        r11.L$2 = r25;
        r11.L$3 = r26;
        r11.L$4 = r27;
        r11.label = 1;
        Object r50 = g(r22, r23, r24, r25, r26, r27, r11);
        if (r50 != r12) goto L26;
        return r12;
    L26:
        r45 = r23;
        r43 = r26;
        r42 = r27;
        r46 = r50;
        r47 = r22;
        r44 = r25;
    L7:
        r1 = new WcbResponseConsumer$consume$1(this, r28);
        goto L8
    }

    public final Object d(f r9, NexPulseResponseData r10, jx9.a r11, q r12, p r13, Function0<Boolean> r14, Continuation<? super p> r15) {
        if ((r15 instanceof WcbResponseConsumer$render$1) == false) goto L7;
        WcbResponseConsumer$render$1 r0 = (WcbResponseConsumer$render$1) r15;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        WcbResponseConsumer$render$1 r6 = r0;
        Object r16 = r6.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r6.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r16);
    L35:
        n.b r17 = (n.b) r16;
        if (r17 != null) goto L38;
        return null;
    L38:
        return new p(r17.a);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r16);
        m r18 = this.d;
        r18.getClass();
        Intrinsics.checkNotNullParameter(r9, "snapshot");
        Intrinsics.checkNotNullParameter(r10, "response");
        z r4 = r9.f.a;
        h r19 = r4.e().a(r18.a);
        i r5 = r4.g().a(r9, r10, r19);
        if (r5 != null) goto L17;
        FLogger.a.i("WcbLog", "ignore wcb cause presentation unavailable, nexPulseType=" + r10.getNexPulseType());
        com.larus.suggest.impl.wcb.render.l r7 = null;
    L30:
        if (r7 != null) goto L32;
        return null;
    L32:
        FLogger.a.i("WcbLog", "[pipeline] plan.create ".concat(r7.getClass().getName()));
        r6.label = 1;
        r16 = f(r11, r7, r12, r14, r6);
        if (r16 != r2) goto L35;
        return r2;
    L17:
        if (r13 == null) goto L19;
        o r20 = new o.c(r13);
    L21:
        if (Intrinsics.areEqual(r20, o.a.a) == false) goto L24;
        com.larus.suggest.impl.wcb.render.l r21 = new com.larus.suggest.impl.wcb.render.l.a(r5, null);
    L29:
        r7 = r21;
        goto L30
    L24:
        if ((r20 instanceof o.c) == false) goto L27;
        r21 = new com.larus.suggest.impl.wcb.render.l.c(((o.c) r20).a, r5);
        goto L29
    L27:
        if ((r20 instanceof o.b) == false) goto L40;
        FLogger.a.i("WcbLog", "ignore wcb cause " + ((o.b) r20).a);
        r21 = null;
        goto L29
    L40:
        throw new NoWhenBranchMatchedException();
    L19:
        r20 = r4.i().a(r9, r10, r19);
    L7:
        r0 = new WcbResponseConsumer$render$1(this, r15);
        goto L8
    }

    public final Object g(f r15, jx9.a r16, g r17, q r18, p r19, d r20, Continuation r21) {
        if ((r21 instanceof WcbResponseConsumer$validateResponse$1) == false) goto L7;
        WcbResponseConsumer$validateResponse$1 r2 = (WcbResponseConsumer$validateResponse$1) r21;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        WcbResponseConsumer$validateResponse$1 r9 = r2;
        Object r1 = r9.result;
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r9.label;
        if (r4 == 0) goto L14;
        if (r4 != 1) goto L13;
        ResultKt.throwOnFailure(r1);
    L34:
        return null;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r1);
        if (r17.b != WcbTransportSource.NETWORK) goto L17;
        boolean r5 = true;
    L19:
        if (r15.f.a.h().l(r15) == false) goto L24;
        FLogger.a.w("WcbLog", "intercept wcb result, reason=wcb consumed in conversation");
        if (r5 == false) goto L23;
        this.c.c = false;
    L23:
        return null;
    L24:
        NexPulseResponseData r13 = r17.a.getResponse();
        r16.f = SystemClock.elapsedRealtime();
        r16.i = r13;
        if (r5 == false) goto L27;
        this.c.c = false;
    L27:
        c0 r0 = r15.f.a.a().a(r17.a, r15, this.a, r15.f.a.h().f(r15));
        if (r0 == null) goto L35;
        kx9.a r6 = this.b;
        String r7 = r0.b;
        long r8 = r0.a;
        boolean r11 = r0.c;
        r6.getClass();
        kx9.a.c(r16, r7, r8, r11);
        if (r19 != null) goto L34;
        r9.label = 1;
        if (e(r15, r13, r16, r18, r20, r9) != r10) goto L34;
        return r10;
    L35:
        return r13;
    L17:
        r5 = false;
    L7:
        r2 = new WcbResponseConsumer$validateResponse$1(this, r21);
        goto L8
    }
}
