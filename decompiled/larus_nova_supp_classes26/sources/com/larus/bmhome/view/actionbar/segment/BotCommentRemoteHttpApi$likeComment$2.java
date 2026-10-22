package com.larus.bmhome.view.actionbar.segment;

import com.larus.network.http.HttpExtKt;
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
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/http/Async;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.view.actionbar.segment.BotCommentRemoteHttpApi$likeComment$2", f = "BotDataMediatorImpl.kt", i = {}, l = {202}, m = "invokeSuspend", n = {}, s = {})
final class BotCommentRemoteHttpApi$likeComment$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.larus.network.http.a<? extends Object>>, Object> {
    final /* synthetic */ String $commentId;
    final /* synthetic */ boolean $like;
    int label;

    public BotCommentRemoteHttpApi$likeComment$2(String r1, boolean r2, Continuation<? super BotCommentRemoteHttpApi$likeComment$2> r3) {
        this.$commentId = r1;
        this.$like = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new BotCommentRemoteHttpApi$likeComment$2(this.$commentId, this.$like, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super com.larus.network.http.a<? extends Object>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r14);
    L16:
        return (com.larus.network.http.a) r14;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r14);
        JSONObject r4 = new JSONObject();
        String r5 = this.$commentId;
        boolean r6 = this.$like;
        r4.put("comment_id", r5);
        if (r6 == false) goto L11;
        int r7 = 1;
    L12:
        r4.put("operate_type", r7);
        Unit r8 = Unit.INSTANCE;
        this.label = 1;
        r14 = HttpExtKt.k("Social", Object.class, "/alice/bot/like_comment_action", r4, null, null, false, null, null, null, this, 1008);
        if (r14 != r0) goto L16;
        return r0;
    L11:
        r7 = 2;
        goto L12
    }
}
