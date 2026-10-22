package com.larus.bmhome.view.actionbar.edit.component;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.view.actionbar.edit.component.CollaboratedMultiFeatureSelectorWidget$observeModelChange$2", f = "CollaboratedMultiFeatureSelectorWidget.kt", i = {}, l = {158}, m = "invokeSuspend", n = {}, s = {})
final class CollaboratedMultiFeatureSelectorWidget$observeModelChange$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ CollaboratedMultiFeatureSelectorWidget this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ CollaboratedMultiFeatureSelectorWidget a;

        public a(CollaboratedMultiFeatureSelectorWidget r1) {
            this.a = r1;
        }

        public final Object emit(Object r3, Continuation r4) {
            com.larus.bmhome.view.actionbar.edit.p r5 = (com.larus.bmhome.view.actionbar.edit.p) r3;
            if (r5 != null) goto L6;
            return Unit.INSTANCE;
        L6:
            if (CollaboratedMultiFeatureSelectorWidget.o6(this.a, r5.a) == false) goto L17;
            xs8.d r6 = CollaboratedMultiFeatureSelectorWidget.n6(this.a);
            if (r6 == null) goto L11;
            r6.F(Boxing.boxLong(r5.b));
        L11:
            this.a.y7();
            this.a.w7();
            this.a.o7();
            this.a.H6();
            Function0<Unit> r7 = this.a.k;
            if (r7 == null) goto L15;
            r7.invoke();
        L15:
            return Unit.INSTANCE;
        L17:
            return Unit.INSTANCE;
        }
    }

    public CollaboratedMultiFeatureSelectorWidget$observeModelChange$2(CollaboratedMultiFeatureSelectorWidget r1, Continuation<? super CollaboratedMultiFeatureSelectorWidget$observeModelChange$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new CollaboratedMultiFeatureSelectorWidget$observeModelChange$2(this.this$0, r3);
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
        CollaboratedMultiFeatureSelectorWidget r6 = this.this$0;
        t1 r2 = CollaboratedMultiFeatureSelectorWidget.o;
        com.larus.bmhome.view.actionbar.edit.c r7 = r6.getViewModel();
        if (r7 == null) goto L18;
        kotlinx.coroutines.flow.i1<com.larus.bmhome.view.actionbar.edit.p> r8 = r7.getSelectVideoModelFlow();
        if (r8 == null) goto L18;
        a r3 = new a(this.this$0);
        this.label = 1;
        if (r8.collect(r3, this) != r0) goto L16;
        return r0;
    L18:
        return Unit.INSTANCE;
    }
}
