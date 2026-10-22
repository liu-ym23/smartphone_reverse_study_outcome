package com.larus.canvas.feature.component.logic;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
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
@DebugMetadata(c = "com.larus.canvas.feature.component.logic.GenImageUIActionReceiverComponent$bindObservers$3", f = "GenImageUIActionReceiverComponent.kt", i = {}, l = {243}, m = "invokeSuspend", n = {}, s = {})
final class GenImageUIActionReceiverComponent$bindObservers$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ GenImageUIActionReceiverComponent this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ GenImageUIActionReceiverComponent a;

        public a(GenImageUIActionReceiverComponent r1) {
            this.a = r1;
        }

        public final Object emit(Object r2, Continuation r3) {
            GenImageUIActionReceiverComponent r4 = this.a;
            int r0 = GenImageUIActionReceiverComponent.y;
            r4.getClass();
            if (Intrinsics.areEqual((fy8.c) r2, fy8.c.b.a) == false) goto L6;
            r4.G3(false);
        L6:
            return Unit.INSTANCE;
        }
    }

    public GenImageUIActionReceiverComponent$bindObservers$3(GenImageUIActionReceiverComponent r1, Continuation<? super GenImageUIActionReceiverComponent$bindObservers$3> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new GenImageUIActionReceiverComponent$bindObservers$3(this.this$0, r3);
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
        fy8.b r6 = (fy8.b) this.this$0.q.getValue();
        if (r6 == null) goto L18;
        kotlinx.coroutines.flow.a1 r7 = r6.U4();
        if (r7 == null) goto L18;
        a r2 = new a(this.this$0);
        this.label = 1;
        if (r7.collect(r2, this) != r0) goto L16;
        return r0;
    L18:
        return Unit.INSTANCE;
    }
}
