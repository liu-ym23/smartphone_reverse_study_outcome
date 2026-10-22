package com.obric.widget.host.runtime;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.m0;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/obric/widget/host/runtime/PrefetchedWidgetPayload;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.widget.host.runtime.WidgetPayloadPrefetchCoordinator$awaitIfReady$payload$1", f = "WidgetPayloadPrefetchCoordinator.kt", i = {}, l = {118}, m = "invokeSuspend", n = {}, s = {})
public final class WidgetPayloadPrefetchCoordinator$awaitIfReady$payload$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super PrefetchedWidgetPayload>, Object> {
    final /* synthetic */ m0 $deferred;
    int label;

    public WidgetPayloadPrefetchCoordinator$awaitIfReady$payload$1(m0 r5, Continuation<? super WidgetPayloadPrefetchCoordinator$awaitIfReady$payload$1> r10) {
        this.$deferred = r5;
        super(2, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
        return new WidgetPayloadPrefetchCoordinator$awaitIfReady$payload$1(this.$deferred, r10);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo2invoke(CoroutineScope r5, Continuation<? super PrefetchedWidgetPayload> r10) {
        return invoke2(r5, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = this.label;
        if (r11 == 0) goto L8;
        if (r11 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L11:
        return r5;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        m0 r12 = this.$deferred;
        this.label = 1;
        r5 = r12.d(this);
        if (r5 != r10) goto L11;
        return r10;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r5, Continuation<? super PrefetchedWidgetPayload> r10) {
        return ((WidgetPayloadPrefetchCoordinator$awaitIfReady$payload$1) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
    }
}
