package com.larus.community.impl.detail.loading;

import com.larus.community.impl.api.CreationRecommendApi;
import com.larus.network.bean.BizResponse;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/community/impl/api/CreationDetailResponse;", "Lcom/larus/community/impl/api/CreationRecommendApi;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.community.impl.detail.loading.CreationDetailLoadingViewModel$requestCreationDetail$result$1", f = "CreationDetailLoadingViewModel.kt", i = {}, l = {50}, m = "invokeSuspend", n = {}, s = {})
public final class CreationDetailLoadingViewModel$requestCreationDetail$result$1 extends SuspendLambda implements Function2<CreationRecommendApi, Continuation<? super BizResponse<com.larus.community.impl.api.e>>, Object> {
    final /* synthetic */ CreationLoadingState $previousState;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ CreationDetailLoadingViewModel this$0;

    public CreationDetailLoadingViewModel$requestCreationDetail$result$1(CreationLoadingState r1, CreationDetailLoadingViewModel r2, Continuation<? super CreationDetailLoadingViewModel$requestCreationDetail$result$1> r3) {
        this.$previousState = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        CreationDetailLoadingViewModel$requestCreationDetail$result$1 r0 = new CreationDetailLoadingViewModel$requestCreationDetail$result$1(this.$previousState, this.this$0, r5);
        r0.L$0 = r4;
        return r0;
    }

    public final Object invoke(CreationRecommendApi r1, Continuation<? super BizResponse<com.larus.community.impl.api.e>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CreationRecommendApi) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L16:
        return r6;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        CreationRecommendApi r7 = (CreationRecommendApi) this.L$0;
        String r3 = this.$previousState.getCreationId();
        if (r3 != null) goto L13;
        r3 = CreationDetailLoadingViewModel.access$getCreationId$p(this.this$0);
        if (r3 != null) goto L13;
        r3 = "";
    L13:
        com.larus.community.impl.api.d r2 = new com.larus.community.impl.api.d(CollectionsKt.listOf(r3), 2);
        this.label = 1;
        r6 = r7.getCreationDetail(r2, this);
        if (r6 != r0) goto L16;
        return r0;
    }
}
