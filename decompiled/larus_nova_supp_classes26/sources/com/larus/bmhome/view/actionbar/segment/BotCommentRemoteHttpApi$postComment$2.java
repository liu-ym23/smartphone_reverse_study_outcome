package com.larus.bmhome.view.actionbar.segment;

import android.text.TextUtils;
import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import com.larus.network.http.HttpExtKt;
import com.larus.platform.model.comment.CommentContent;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/http/Async;", "Lcom/larus/platform/model/comment/api/CommentHttpApi$PostCommentResponse;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.view.actionbar.segment.BotCommentRemoteHttpApi$postComment$2", f = "BotDataMediatorImpl.kt", i = {}, l = {130}, m = "invokeSuspend", n = {}, s = {})
final class BotCommentRemoteHttpApi$postComment$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.larus.network.http.a<? extends CommentHttpApi.PostCommentResponse>>, Object> {
    final /* synthetic */ String $clientCommentId;
    final /* synthetic */ CommentContent $content;
    final /* synthetic */ String $entityId;
    final /* synthetic */ String $parentId;
    final /* synthetic */ String $replyToId;
    int label;

    public BotCommentRemoteHttpApi$postComment$2(String r1, String r2, String r3, String r4, CommentContent r5, Continuation<? super BotCommentRemoteHttpApi$postComment$2> r6) {
        this.$entityId = r1;
        this.$clientCommentId = r2;
        this.$parentId = r3;
        this.$replyToId = r4;
        this.$content = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new BotCommentRemoteHttpApi$postComment$2(this.$entityId, this.$clientCommentId, this.$parentId, this.$replyToId, this.$content, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super com.larus.network.http.a<CommentHttpApi.PostCommentResponse>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r14);
    L41:
        return (com.larus.network.http.a) r14;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r14);
        JSONObject r4 = new JSONObject();
        String r5 = this.$entityId;
        String r6 = this.$clientCommentId;
        String r7 = this.$parentId;
        String r8 = this.$replyToId;
        CommentContent r9 = this.$content;
        r4.put("entity_id", r5);
        r4.put("client_comment_id", r6);
        JSONObject r10 = new JSONObject();
        r10.put("content", r9.a());
        r10.put("content_type", r9.b());
        Unit r11 = Unit.INSTANCE;
        r4.put("content", r10);
        boolean r12 = false;
        if (r7 != null) goto L11;
    L14:
        boolean r13 = true;
    L15:
        if (r13 == true) goto L17;
        r4.put("parent_id", r7);
    L17:
        if (r8 != null) goto L19;
    L22:
        boolean r15 = true;
    L24:
        if (r15 == true) goto L26;
        r4.put("reply_to_id", r8);
    L26:
        if (r7 != null) goto L28;
    L29:
        r12 = true;
    L31:
        if (r12 == false) goto L34;
        r4.put("entity_id", r5);
        r4.put("level", 1);
    L37:
        this.label = 1;
        r14 = HttpExtKt.k("Social", CommentHttpApi.PostCommentResponse.class, "/alice/bot/comment_post", r4, null, null, false, null, null, null, this, 1008);
        if (r14 != r0) goto L41;
        return r0;
    L34:
        if (TextUtils.equals(r7, r8) == false) goto L36;
        r4.put("reply_to_id", TriggerSendLoading.NO_LOADING);
    L36:
        r4.put("level", 2);
        goto L37
    L28:
        if (r7.length() != 0) goto L31;
    L19:
        if (r8.length() == 0) goto L22;
        r15 = false;
        goto L24
    L11:
        if (r7.length() == 0) goto L14;
        r13 = false;
        goto L15
    }
}
