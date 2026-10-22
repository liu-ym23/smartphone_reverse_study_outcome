package com.obric.aikernel.res.update;

import com.obric.aikernel.res.metadata.config.UpdateTaskConfig;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.res.update.MetadataRequest$parseDistributeResponse$dists$1", f = "MetadataRequest.kt", i = {}, l = {120}, m = "invokeSuspend", n = {}, s = {})
final class MetadataRequest$parseDistributeResponse$dists$1 extends SuspendLambda implements Function1<Continuation<? super List<? extends UpdateTaskConfig>>, Object> {
    final /* synthetic */ com.google.gson.k $data;
    int label;
    final /* synthetic */ MetadataRequest this$0;

    MetadataRequest$parseDistributeResponse$dists$1(MetadataRequest r10, com.google.gson.k r11, Continuation<? super MetadataRequest$parseDistributeResponse$dists$1> r12) {
        this.this$0 = r10;
        this.$data = r11;
        super(1, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> r10) {
        return new MetadataRequest$parseDistributeResponse$dists$1(this.this$0, this.$data, r10);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<? super List<? extends UpdateTaskConfig>> r10) {
        return invoke2(r10);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<? super List<? extends UpdateTaskConfig>> r10) {
        return ((MetadataRequest$parseDistributeResponse$dists$1) create(r10)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r12 = this.label;
        if (r12 == 0) goto L8;
        if (r12 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L11:
        return r10;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        MetadataRequest r13 = this.this$0;
        com.google.gson.k r14 = this.$data;
        this.label = 1;
        r10 = MetadataRequest.d(r13, r14, this);
        if (r10 != r11) goto L11;
        return r11;
    }
}
