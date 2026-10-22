package com.larus.community.impl.detail.comment;

import com.larus.platform.model.comment.api.CommentHttpApi;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class CreationDetailCommentRemoteHttpApi {
    public static final CreationDetailCommentRemoteHttpApi a = null;
    public static String b;

    static {
        a = new CreationDetailCommentRemoteHttpApi();
    }

    public CreationDetailCommentRemoteHttpApi() {
    }

    public final Object a(String r4, String r5, String r6, Continuation<? super com.larus.network.http.a<CommentHttpApi.GetCommentListData>> r7) {
        return BuildersKt.withContext(Dispatchers.getIO(), new CreationDetailCommentRemoteHttpApi$loadCommentList$2(r4, r5, r6, null), r7);
    }
}
