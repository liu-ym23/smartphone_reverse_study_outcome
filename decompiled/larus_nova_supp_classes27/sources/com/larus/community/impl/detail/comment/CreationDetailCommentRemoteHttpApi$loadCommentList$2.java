package com.larus.community.impl.detail.comment;

import com.larus.network.http.HttpExtKt;
import com.larus.platform.model.comment.api.CommentHttpApi;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/http/Async;", "Lcom/larus/platform/model/comment/api/CommentHttpApi$GetCommentListData;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.community.impl.detail.comment.CreationDetailCommentRemoteHttpApi$loadCommentList$2", f = "CreationDetailDataMediator.kt", i = {}, l = {109}, m = "invokeSuspend", n = {}, s = {})
public final class CreationDetailCommentRemoteHttpApi$loadCommentList$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.larus.network.http.a<? extends CommentHttpApi.GetCommentListData>>, Object> {
    final /* synthetic */ String $anchorCommentId;
    final /* synthetic */ String $entityId;
    final /* synthetic */ String $preOffsetToken;
    int label;

    public CreationDetailCommentRemoteHttpApi$loadCommentList$2(String r1, String r2, String r3, Continuation<? super CreationDetailCommentRemoteHttpApi$loadCommentList$2> r4) {
        this.$entityId = r1;
        this.$preOffsetToken = r2;
        this.$anchorCommentId = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new CreationDetailCommentRemoteHttpApi$loadCommentList$2(this.$entityId, this.$preOffsetToken, this.$anchorCommentId, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super com.larus.network.http.a<CommentHttpApi.GetCommentListData>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r14);
    L27:
        return (com.larus.network.http.a) r14;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r14);
        JSONObject r4 = new JSONObject();
        String r5 = this.$entityId;
        String r6 = this.$preOffsetToken;
        String r7 = this.$anchorCommentId;
        r4.put("entity_id", r5);
        boolean r8 = false;
        if (r6 != null) goto L11;
    L14:
        boolean r9 = true;
    L15:
        if (r9 == true) goto L17;
        r4.put("pre_offset_token", r6);
    L17:
        if (r7 != null) goto L19;
    L20:
        r8 = true;
    L21:
        if (r8 == true) goto L23;
        r4.put("anchor_comment_id", r7);
    L23:
        Unit r10 = Unit.INSTANCE;
        this.label = 1;
        r14 = HttpExtKt.k("Social", CommentHttpApi.GetCommentListData.class, "/creativity/community/comment/list", r4, null, null, false, null, null, null, this, 1008);
        if (r14 != r0) goto L27;
        return r0;
    L19:
        if (r7.length() != 0) goto L21;
    L11:
        if (r6.length() == 0) goto L14;
        r9 = false;
        goto L15
    }
}
