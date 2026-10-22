package com.larus.doc.impl;

import android.os.Bundle;
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
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/doc/impl/chat/data/GetSubConversationRespV2;", "Lcom/larus/doc/impl/DocumentApi;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.doc.impl.DocServiceImpl$integrateFloatChatFragment$2$resp$1", f = "DocServiceImpl.kt", i = {}, l = {336}, m = "invokeSuspend", n = {}, s = {})
public final class DocServiceImpl$integrateFloatChatFragment$2$resp$1 extends SuspendLambda implements Function2<DocumentApi, Continuation<? super BizResponse<h39.h>>, Object> {
    final /* synthetic */ Bundle $bundle;
    final /* synthetic */ String $docId;
    final /* synthetic */ int $resourceType;
    private /* synthetic */ Object L$0;
    int label;

    public DocServiceImpl$integrateFloatChatFragment$2$resp$1(String r1, int r2, Bundle r3, Continuation<? super DocServiceImpl$integrateFloatChatFragment$2$resp$1> r4) {
        this.$docId = r1;
        this.$resourceType = r2;
        this.$bundle = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        DocServiceImpl$integrateFloatChatFragment$2$resp$1 r0 = new DocServiceImpl$integrateFloatChatFragment$2$resp$1(this.$docId, this.$resourceType, this.$bundle, r6);
        r0.L$0 = r5;
        return r0;
    }

    public final Object invoke(DocumentApi r1, Continuation<? super BizResponse<h39.h>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((DocumentApi) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r12);
    L15:
        return r12;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r12);
        DocumentApi r13 = (DocumentApi) this.L$0;
        String r4 = this.$docId;
        int r5 = this.$resourceType;
        if (Intrinsics.areEqual(this.$bundle.getString("argPreviousPage", null), "ai_space_list") == false) goto L11;
        Integer r9 = null;
    L12:
        h39.g r2 = new h39.g(r4, r5, r9, true, Intrinsics.areEqual(this.$bundle.getString("argPreviousPage", null), "ai_space_list"));
        this.label = 1;
        r12 = r13.getSubConversationV2(r2, this);
        if (r12 != r0) goto L15;
        return r0;
    L11:
        r9 = Boxing.boxInt(1);
        goto L12
    }
}
