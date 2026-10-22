package com.larus.community.impl.publish.viewmodel;

import com.larus.community.impl.api.CreationRecommendApi;
import com.larus.network.bean.BizResponse;
import com.larus.platform.api.creation.PublisherCreation;
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
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/community/impl/api/CreationPublishResponse;", "Lcom/larus/community/impl/api/CreationRecommendApi;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.community.impl.publish.viewmodel.CreationPublishViewModel$publish$1$result$1", f = "CreationPublishViewModel.kt", i = {}, l = {100}, m = "invokeSuspend", n = {}, s = {})
public final class CreationPublishViewModel$publish$1$result$1 extends SuspendLambda implements Function2<CreationRecommendApi, Continuation<? super BizResponse<com.larus.community.impl.api.i>>, Object> {
    final /* synthetic */ String $caption;
    final /* synthetic */ PublisherCreation $finalPublishCreation;
    final /* synthetic */ boolean $isPublic;
    private /* synthetic */ Object L$0;
    int label;

    public CreationPublishViewModel$publish$1$result$1(PublisherCreation r1, boolean r2, String r3, Continuation<? super CreationPublishViewModel$publish$1$result$1> r4) {
        this.$finalPublishCreation = r1;
        this.$isPublic = r2;
        this.$caption = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        CreationPublishViewModel$publish$1$result$1 r0 = new CreationPublishViewModel$publish$1$result$1(this.$finalPublishCreation, this.$isPublic, this.$caption, r6);
        r0.L$0 = r5;
        return r0;
    }

    public final Object invoke(CreationRecommendApi r1, Continuation<? super BizResponse<com.larus.community.impl.api.i>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CreationRecommendApi) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L16:
        return r10;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        CreationRecommendApi r11 = (CreationRecommendApi) this.L$0;
        PublisherCreation r3 = this.$finalPublishCreation;
        if (r3 == null) goto L12;
        String r4 = r3.getCreationId();
        if (r4 == null) goto L12;
    L13:
        com.larus.community.impl.api.g r2 = new com.larus.community.impl.api.g(r4, new com.larus.community.impl.api.h(Boxing.boxBoolean(this.$isPublic), this.$caption, null, 4));
        this.label = 1;
        r10 = r11.publishCreation(r2, this);
        if (r10 != r0) goto L16;
        return r0;
    L12:
        r4 = "";
        goto L13
    }
}
