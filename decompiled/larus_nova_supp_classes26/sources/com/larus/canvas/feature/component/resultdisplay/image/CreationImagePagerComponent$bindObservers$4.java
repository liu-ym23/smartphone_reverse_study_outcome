package com.larus.canvas.feature.component.resultdisplay.image;

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
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.canvas.feature.component.resultdisplay.image.CreationImagePagerComponent$bindObservers$4", f = "CreationImagePagerComponent.kt", i = {}, l = {229}, m = "invokeSuspend", n = {}, s = {})
final class CreationImagePagerComponent$bindObservers$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ CreationImagePagerComponent this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ CreationImagePagerComponent a;

        public a(CreationImagePagerComponent r1) {
            this.a = r1;
        }

        public final Object emit(Object r1, Continuation r2) {
            Pair r3 = (Pair) r1;
            CreationImagePagerComponent r4 = this.a;
            int r5 = CreationImagePagerComponent.B;
            ((com.larus.canvas.feature.component.resultdisplay.image.widget.q) r4.w.getValue()).a();
            return Unit.INSTANCE;
        }
    }

    public CreationImagePagerComponent$bindObservers$4(CreationImagePagerComponent r1, Continuation<? super CreationImagePagerComponent$bindObservers$4> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new CreationImagePagerComponent$bindObservers$4(this.this$0, r3);
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
    L12:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        StateFlowImpl r6 = ((com.larus.canvas.feature.component.resultdisplay.image.widget.u) this.this$0.A.getValue()).b;
        a r2 = new a(this.this$0);
        this.label = 1;
        if (r6.collect(r2, this) != r0) goto L12;
        return r0;
    }
}
