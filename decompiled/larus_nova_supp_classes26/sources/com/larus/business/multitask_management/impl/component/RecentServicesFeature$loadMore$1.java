package com.larus.business.multitask_management.impl.component;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.business.multitask_management.impl.component.RecentServicesFeature$loadMore$1", f = "RecentServicesFeature.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class RecentServicesFeature$loadMore$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ RecentServicesFeature this$0;

    public RecentServicesFeature$loadMore$1(RecentServicesFeature r1, Continuation<? super RecentServicesFeature$loadMore$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new RecentServicesFeature$loadMore$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L20;
        ResultKt.throwOnFailure(r6);
        if (((i) this.this$0.j.getValue()).b > ((i) this.this$0.j.getValue()).a.size()) goto L14;
        StateFlowImpl r7 = this.this$0.j;
        i r0 = (i) r7.getValue();
        int r1 = ((i) this.this$0.j.getValue()).b;
        int r2 = this.this$0.o;
        if (r2 > 0) goto L10;
    L13:
        r7.setValue(i.a(r0, null, r1, 5));
        goto L14
    L10:
        if ((Integer.MAX_VALUE - r1) <= r2) goto L12;
        r1 = r1 + r2;
        goto L13
    L12:
        r1 = Integer.MAX_VALUE;
    L14:
        RecentServicesFeature r8 = this.this$0;
        if (r8.k == false) goto L18;
        RecentServicesFeature.L2(r8);
    L18:
        return Unit.INSTANCE;
    L20:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
