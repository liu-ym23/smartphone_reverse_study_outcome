package com.larus.bmhome.view.actionbar.segment;

import com.larus.platform.model.comment.api.CommentHttpApi;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class BotCommentRemoteHttpApi {
    public static final BotCommentRemoteHttpApi a = null;

    static {
        a = new BotCommentRemoteHttpApi();
    }

    public BotCommentRemoteHttpApi() {
    }

    public final Object a(String r4, String r5, String r6, Continuation<? super com.larus.network.http.a<CommentHttpApi.GetCommentListData>> r7) {
        return BuildersKt.withContext(Dispatchers.getIO(), new BotCommentRemoteHttpApi$loadCommentList$2(r4, r5, r6, null), r7);
    }
}
