package com.larus.business.multitask_management.impl.component;

import com.larus.multitask_management.api.data.quick_access.NodeType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.business.multitask_management.impl.component.PinnedServicesFeature$pinListener$1$onUnpinned$1", f = "PinnedServicesFeature.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class PinnedServicesFeature$pinListener$1$onUnpinned$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ NodeType $nodeType;
    final /* synthetic */ String $referenceId;
    int label;
    final /* synthetic */ PinnedServicesFeature this$0;

    public PinnedServicesFeature$pinListener$1$onUnpinned$1(PinnedServicesFeature r1, NodeType r2, String r3, Continuation<? super PinnedServicesFeature$pinListener$1$onUnpinned$1> r4) {
        this.this$0 = r1;
        this.$nodeType = r2;
        this.$referenceId = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new PinnedServicesFeature$pinListener$1$onUnpinned$1(this.this$0, this.$nodeType, this.$referenceId, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r3);
        PinnedServicesFeature.F2(this.this$0, this.$nodeType, this.$referenceId);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
