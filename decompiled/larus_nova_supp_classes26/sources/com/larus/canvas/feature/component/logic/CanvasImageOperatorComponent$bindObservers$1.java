package com.larus.canvas.feature.component.logic;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.canvas.feature.component.logic.CanvasImageOperatorComponent$bindObservers$1", f = "CanvasImageOperatorComponent.kt", i = {}, l = {240}, m = "invokeSuspend", n = {}, s = {})
final class CanvasImageOperatorComponent$bindObservers$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ CanvasImageOperatorComponent this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ CanvasImageOperatorComponent a;

        public a(CanvasImageOperatorComponent r1) {
            this.a = r1;
        }

        public final Object emit(Object r2, Continuation r3) {
            Pair r4 = (Pair) r2;
            if (this.a.q == ((Number) r4.getFirst()).intValue()) goto L14;
            CanvasImageOperatorComponent r5 = this.a;
            r5.q = ((Number) r4.getFirst()).intValue();
            final CanvasImageOperatorComponent r6 = this.a;
            ky8.h r7 = (ky8.h) r4.getSecond();
            r6.getClass();
            if ((r7 instanceof ky8.k) == false) goto L11;
            com.larus.canvas.feature.component.title.k r8 = (com.larus.canvas.feature.component.title.k) r6.l.getValue();
            if (r8 == null) goto L9;
            r8.N50(new e(r6));
        L9:
            r6.U2();
        L23:
            return Unit.INSTANCE;
        L11:
            if ((r7 instanceof ky8.f) == false) goto L23;
            ky8.f r9 = (ky8.f) r7;
            r6.X2(r9, r9.g);
            goto L23
        L14:
            if ((r4.getSecond() instanceof ky8.k) == false) goto L20;
            final CanvasImageOperatorComponent r10 = this.a;
            com.larus.canvas.feature.component.title.k r11 = (com.larus.canvas.feature.component.title.k) r10.l.getValue();
            if (r11 == null) goto L18;
            r11.N50(new e(r10));
        L18:
            r10.U2();
            goto L23
        L20:
            if ((r4.getSecond() instanceof ky8.f) == false) goto L23;
            Object r12 = r4.getSecond();
            Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type com.larus.canvas.feature.component.logic.bean.GenImageTaskItem");
            ky8.f r13 = (ky8.f) r12;
            this.a.X2(r13, r13.g);
            goto L23
        }
    }

    public CanvasImageOperatorComponent$bindObservers$1(CanvasImageOperatorComponent r1, Continuation<? super CanvasImageOperatorComponent$bindObservers$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new CanvasImageOperatorComponent$bindObservers$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L6;
        ResultKt.throwOnFailure(r5);
    L16:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        CanvasImageOperatorComponent r6 = this.this$0;
        int r2 = CanvasImageOperatorComponent.s;
        n2 r7 = r6.L2();
        if (r7 == null) goto L18;
        kotlinx.coroutines.flow.b1 r8 = r7.tx();
        if (r8 == null) goto L18;
        a r3 = new a(this.this$0);
        this.label = 1;
        if (r8.collect(r3, this) != r0) goto L16;
        return r0;
    L18:
        return Unit.INSTANCE;
    }
}
