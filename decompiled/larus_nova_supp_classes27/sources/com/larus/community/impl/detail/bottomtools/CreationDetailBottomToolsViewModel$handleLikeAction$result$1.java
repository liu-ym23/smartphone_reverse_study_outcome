package com.larus.community.impl.detail.bottomtools;

import com.larus.community.impl.api.CreationRecommendApi;
import com.larus.network.bean.BizResponse;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/bean/BizResponse;", "", "Lcom/larus/community/impl/api/CreationRecommendApi;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.community.impl.detail.bottomtools.CreationDetailBottomToolsViewModel$handleLikeAction$result$1", f = "CreationDetailBottomToolsViewModel.kt", i = {}, l = {89}, m = "invokeSuspend", n = {}, s = {})
public final class CreationDetailBottomToolsViewModel$handleLikeAction$result$1 extends SuspendLambda implements Function2<CreationRecommendApi, Continuation<? super BizResponse<Object>>, Object> {
    final /* synthetic */ CreationLikeState $previousState;
    private /* synthetic */ Object L$0;
    int label;

    public CreationDetailBottomToolsViewModel$handleLikeAction$result$1(CreationLikeState r1, Continuation<? super CreationDetailBottomToolsViewModel$handleLikeAction$result$1> r2) {
        this.$previousState = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        CreationDetailBottomToolsViewModel$handleLikeAction$result$1 r0 = new CreationDetailBottomToolsViewModel$handleLikeAction$result$1(this.$previousState, r4);
        r0.L$0 = r3;
        return r0;
    }

    public final Object invoke(CreationRecommendApi r1, Continuation<? super BizResponse<Object>> r2) {
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
    L15:
        return r6;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        CreationRecommendApi r7 = (CreationRecommendApi) this.L$0;
        String r3 = this.$previousState.getCreationId();
        if (this.$previousState.getLiked() == true) goto L11;
        int r4 = 1;
    L12:
        com.larus.community.impl.api.f r2 = new com.larus.community.impl.api.f(r3, Boxing.boxInt(r4));
        this.label = 1;
        r6 = r7.handleCreationLikeAction(r2, this);
        if (r6 != r0) goto L15;
        return r0;
    L11:
        r4 = 2;
        goto L12
    }
}
