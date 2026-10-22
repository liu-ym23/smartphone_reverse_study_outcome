package com.larus.canvas.core.impl.sse;

import com.larus.im.internal.delegate.c0;
import com.larus.im.internal.delegate.j0;
import com.larus.im.internal.delegate.o0;
import cy8.u;
import cy8.v;
import cy8.w;
import gd9.e;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.IntRange;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.flow.FlowCollector;
import okio.BufferedSource;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/larus/canvas/core/api/model/CanvasSSEEvent;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.canvas.core.impl.sse.CanvasStreamPullHandler$start$1", f = "CanvasStreamPullHandler.kt", i = {1, 1, 1, 1, 3, 3, 3, 3, 3, 6, 6, 6, 6}, l = {40, 46, 49, 53, 62, 67, 74, 77}, m = "invokeSuspend", n = {"$this$flow", "merger", "sequenceId", "retryLeft", "$this$flow", "merger", "sequenceId", "logId", "retryLeft", "$this$flow", "merger", "sequenceId", "retryLeft"}, s = {"L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "L$2", "L$3", "I$0", "L$0", "L$1", "L$2", "I$0"})
final class CanvasStreamPullHandler$start$1 extends SuspendLambda implements Function2<FlowCollector<? super u>, Continuation<? super Unit>, Object> {
    final /* synthetic */ w $params;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ m this$0;

    public CanvasStreamPullHandler$start$1(w r1, m r2, Continuation<? super CanvasStreamPullHandler$start$1> r3) {
        this.$params = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        CanvasStreamPullHandler$start$1 r0 = new CanvasStreamPullHandler$start$1(this.$params, this.this$0, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((FlowCollector) r1, (Continuation) r2);
    }

    public final Object invoke(FlowCollector<? super u> r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:104:0x02e2 -> B:105:0x02eb). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r41) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        String r8 = " retryLeft=";
        switch(this.label) {
            case 0: goto L14;
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            case 7: goto L7;
            case 8: goto L6;
            default: goto L5;
        };
    L6:
        ResultKt.throwOnFailure(r41);
    L110:
        return Unit.INSTANCE;
    L7:
        int r2 = this.I$0;
        Ref.ObjectRef r11 = (Ref.ObjectRef) this.L$2;
        a r12 = (a) this.L$1;
        FlowCollector r13 = (FlowCollector) this.L$0;
        ResultKt.throwOnFailure(r41);
        CanvasStreamPullHandler$start$1 r14 = this;
        FlowCollector r15 = r13;
        Ref.ObjectRef r16 = r11;
        int r17 = r2;
        Object r3 = r0;
    L15:
        v r1 = r14.$params.d;
        Long r5 = (Long) r16.element;
        if (r5 != null) goto L18;
        r5 = r1.i;
    L18:
        String r42 = r8;
        int r35 = r17;
        a r36 = r12;
        Ref.ObjectRef r37 = r16;
        Object r38 = r3;
        FlowCollector r18 = r15;
        v r19 = new v(r1.a, r1.b, r1.c, r1.d, r1.e, r1.f, r1.g, r1.h, r5, r1.j, r1.k, r1.l, r1.m, r1.n);
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L21
        k.a.getClass();     // Catch: Throwable -> L21
        Object r6 = Result.constructor-impl(k.e(r19));     // Catch: Throwable -> L21
    L24:
        if (Result.isFailure-impl(r6) == false) goto L26;
        r6 = null;
    L26:
        String r7 = (String) r6;
        w r9 = r14.$params;
        m r10 = r14.this$0;
        o0 r20 = o0.a;     // Catch: Throwable -> L33
        j0 r21 = o0.l();     // Catch: Throwable -> L33
        String r22 = r9.c;     // Catch: Throwable -> L33
        if (r7 != null) goto L30;
        Object r23 = r19;
    L31:
        Map<String, String> r24 = r9.f;     // Catch: Throwable -> L33
        int r25 = m.c;     // Catch: Throwable -> L33
        r10.getClass();     // Catch: Throwable -> L33
        Map r26 = MapsKt.createMapBuilder();     // Catch: Throwable -> L33
        r26.put("Content-Type", "application/json; encoding=utf-8");     // Catch: Throwable -> L33
        r26.putAll(r9.e);     // Catch: Throwable -> L33
        Object r27 = Result.constructor-impl(r21.e(r22, r23, r24, MapsKt.build(r26), m.b(r10, r9)));     // Catch: Throwable -> L33
    L35:
        Throwable r28 = Result.exceptionOrNull-impl(r27);
        if (r28 == null) goto L39;
        c0.b.e("SSE_KMP", "streamPull threw type=" + Reflection.getOrCreateKotlinClass(r28.getClass()).getSimpleName() + " msg=" + r28.getMessage());
    L39:
        if (Result.isFailure-impl(r27) == false) goto L41;
        r27 = null;
    L41:
        e r29 = (e) r27;
        if (r29 == null) goto L46;
        Map r30 = r29.c;
        if (r30 == null) goto L46;
        String r31 = (String) r30.get("x-tt-logid");
    L47:
        if (r31 != null) goto L49;
        r31 = "";
    L49:
        String r110 = r31;
        IntRange r32 = new IntRange(400, 599);
        if (r29 == null) goto L52;
        Integer r33 = Boxing.boxInt(r29.b);
    L54:
        if (r33 != null) goto L56;
    L58:
        boolean r34 = false;
    L59:
        if (r34 == true) goto L61;
        Object r39 = r38;
        if (r29 != null) goto L75;
    L113:
        CanvasStreamPullHandler$start$1 r40 = r14;
        r12 = r36;
        r16 = r37;
        int r43 = -1;
        int r44 = r35 - 1;
        if (r35 <= 0) goto L125;
        c0 r45 = c0.b;
        StringBuilder r46 = new StringBuilder("retry sessionId=");
        r46.append(r40.$params.a);
        r46.append(" status=");
        if (r29 == null) goto L118;
        Integer r47 = Boxing.boxInt(r29.b);
    L119:
        r46.append(r47);
        r8 = r42;
        r46.append(r8);
        r46.append(r44);
        r45.w("SSE_KMP", r46.toString());
        r40.L$0 = r18;
        r40.L$1 = r12;
        r40.L$2 = r16;
        r40.I$0 = r44;
        r40.label = 2;
        if (DelayKt.delay(2000, r40) == r39) goto L121;
        r17 = r44;
        r3 = r39;
        r15 = r18;
        r14 = r40;
        goto L15
    L121:
        return r39;
    L118:
        r47 = null;
        goto L119
    L125:
        if (r29 == null) goto L127;
        r43 = r29.b;
    L127:
        if (r29 == null) goto L129;
        String r48 = r29.e;
    L130:
        u.d r49 = new u.d(r43, r48, null);
        r40.L$0 = null;
        r40.L$1 = null;
        r40.L$2 = null;
        r40.label = 3;
        if (r18.emit(r49, r40) != r39) goto L134;
        return r39;
    L134:
        return Unit.INSTANCE;
    L129:
        r48 = null;
        goto L130
    L75:
        if (r29.c() == false) goto L113;
        BufferedSource r111 = r29.f;
        if (r111 == null) goto L113;
        m r50 = r14.this$0;
        Intrinsics.checkNotNull(r111);
        CanvasStreamPullHandler$start$1$streamResult$1 r51 = new CanvasStreamPullHandler$start$1$streamResult$1(r37, r18, null);
        r14.L$0 = r18;
        r14.L$1 = r36;
        r14.L$2 = r37;
        r14.L$3 = r110;
        r14.I$0 = r35;
        r14.label = 4;
        CanvasStreamPullHandler$start$1 r52 = r14;
        Object r53 = m.a(r50, r111, r36, r110, r51, r52);
        if (r53 != r39) goto L82;
        return r39;
    L82:
        r8 = r42;
        FlowCollector r112 = r18;
        int r54 = r35;
        a r113 = r36;
        Ref.ObjectRef r114 = r37;
    L83:
        m$b r55 = (m$b) r53;
        if (Intrinsics.areEqual(r55, m$b.a.a) == false) goto L91;
        u.c r56 = new u.c(r113.c(r110));
        r52.L$0 = null;
        r52.L$1 = null;
        r52.L$2 = null;
        r52.L$3 = null;
        r52.label = 5;
        if (r112.emit(r56, r52) != r39) goto L89;
        return r39;
    L89:
        return Unit.INSTANCE;
    L91:
        if ((r55 instanceof m$b.b) == false) goto L98;
        m$b.b r57 = (m$b.b) r55;
        u.d r58 = new u.d(r57.a, r57.b, r113.c(r110));
        r52.L$0 = null;
        r52.L$1 = null;
        r52.L$2 = null;
        r52.L$3 = null;
        r52.label = 6;
        if (r112.emit(r58, r52) != r39) goto L96;
        return r39;
    L96:
        return Unit.INSTANCE;
    L98:
        if ((r55 instanceof m$b.c) == false) goto L112;
        int r59 = r54 - 1;
        if (r54 <= 0) goto L106;
        c0.b.w("SSE_KMP", "retry-after-stream-fail sessionId=" + r52.$params.a + " msg=" + ((m$b.c) r55).a + r8 + r59);
        r52.L$0 = r112;
        r52.L$1 = r113;
        r52.L$2 = r114;
        r52.L$3 = null;
        r52.I$0 = r59;
        r52.label = 7;
        if (DelayKt.delay(2000, r52) != r39) goto L104;
        return r39;
    L104:
        r3 = r39;
        r17 = r59;
        r15 = r112;
        r14 = r52;
        a r310 = r113;
        r16 = r114;
        r12 = r310;
        goto L15
    L106:
        u.d r60 = new u.d(-1, ((m$b.c) r55).a, r113.c(r110));
        r52.L$0 = null;
        r52.L$1 = null;
        r52.L$2 = null;
        r52.L$3 = null;
        r52.label = 8;
        if (r112.emit(r60, r52) != r39) goto L110;
        return r39;
    L112:
        throw new NoWhenBranchMatchedException();
    L61:
        if (r29 == null) goto L63;
        int r61 = r29.b;
    L64:
        if (r29 == null) goto L66;
        String r62 = r29.e;
    L67:
        u.d r63 = new u.d(r61, r62, null);
        r14.L$0 = null;
        r14.L$1 = null;
        r14.L$2 = null;
        r14.label = 1;
        if (r18.emit(r63, r14) != r38) goto L71;
        return r38;
    L71:
        return Unit.INSTANCE;
    L66:
        r62 = null;
        goto L67
    L63:
        r61 = -1;
        goto L64
    L56:
        if (r32.contains(r33.intValue()) == false) goto L58;
        r34 = true;
        goto L59
    L52:
        r33 = null;
    L46:
        r31 = null;
        goto L47
    L30:
        r23 = r7;
    L33:
        th = move-exception;
        Result.Companion r64 = Result.Companion;
        r27 = Result.constructor-impl(ResultKt.createFailure(th));
    L21:
        th = move-exception;
        Result.Companion r65 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L24
    L8:
        ResultKt.throwOnFailure(r41);
        goto L96
    L9:
        ResultKt.throwOnFailure(r41);
        goto L89
    L10:
        r54 = this.I$0;
        r110 = (String) this.L$3;
        r114 = (Ref.ObjectRef) this.L$2;
        r113 = (a) this.L$1;
        r112 = (FlowCollector) this.L$0;
        ResultKt.throwOnFailure(r41);
        r52 = this;
        r39 = r0;
        r53 = r41;
        goto L83
    L11:
        ResultKt.throwOnFailure(r41);
        goto L134
    L12:
        int r66 = this.I$0;
        Ref.ObjectRef r115 = (Ref.ObjectRef) this.L$2;
        r12 = (a) this.L$1;
        FlowCollector r116 = (FlowCollector) this.L$0;
        ResultKt.throwOnFailure(r41);
        r3 = r0;
        r16 = r115;
        r17 = r66;
        r15 = r116;
        r14 = this;
        goto L15
    L13:
        ResultKt.throwOnFailure(r41);
        goto L71
    L14:
        ResultKt.throwOnFailure(r41);
        FlowCollector r67 = (FlowCollector) this.L$0;
        r17 = this.$params.h;
        r12 = new a(0);
        r16 = new Ref.ObjectRef();
        r16.element = this.$params.i;
        r14 = this;
        r15 = r67;
        r3 = r0;
        goto L15
    L5:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
