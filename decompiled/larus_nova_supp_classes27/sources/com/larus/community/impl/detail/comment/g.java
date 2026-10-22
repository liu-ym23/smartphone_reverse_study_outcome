package com.larus.community.impl.detail.comment;

import com.larus.platform.model.comment.CommentContent;
import com.larus.platform.model.comment.api.CommentHttpApi;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import rq9.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class g implements h {
    public final String a;

    public final int b() {
        return 19;
    }

    public final Map<String, String> f() {
        Pair[] r0 = new Pair[2];
        String r1 = this.a;
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        r0[0] = TuplesKt.to("commented_entity_id", r1);
        r0[1] = TuplesKt.to("comment_biz_type", "2");
        return MapsKt.mapOf(r0);
    }

    public g(String r1) {
        this.a = r1;
    }

    public final Object c(Continuation<? super com.larus.network.http.a<rq9.b>> r4) {
        CreationDetailCommentRemoteHttpApi r0 = CreationDetailCommentRemoteHttpApi.a;
        CreationDetailCommentRemoteHttpApi.b = this.a;
        return BuildersKt.withContext(Dispatchers.getIO(), new CreationDetailCommentRemoteHttpApi$getCommentReportReasons$2(null), r4);
    }

    public final Object d(String r5, Continuation<? super com.larus.network.http.a<? extends Object>> r6) {
        CreationDetailCommentRemoteHttpApi r0 = CreationDetailCommentRemoteHttpApi.a;
        String r1 = this.a;
        if (r1 != null) goto L6;
        r1 = "";
    L6:
        return BuildersKt.withContext(Dispatchers.getIO(), new CreationDetailCommentRemoteHttpApi$deleteComment$2(r1, r5, null), r6);
    }

    public final Object e(String r4, boolean r5, Continuation<? super com.larus.network.http.a<? extends Object>> r6) {
        CreationDetailCommentRemoteHttpApi r0 = CreationDetailCommentRemoteHttpApi.a;
        return BuildersKt.withContext(Dispatchers.getIO(), new CreationDetailCommentRemoteHttpApi$likeComment$2(r4, r5, null), r6);
    }

    public final Object g(String r3, String r4, Continuation<? super com.larus.network.http.a<CommentHttpApi.GetCommentListData>> r5) {
        CreationDetailCommentRemoteHttpApi r0 = CreationDetailCommentRemoteHttpApi.a;
        String r1 = this.a;
        if (r1 != null) goto L6;
        r1 = "";
    L6:
        return r0.a(r1, r4, r3, r5);
    }

    public final Object h(String r5, String r6, Continuation<? super com.larus.network.http.a<CommentHttpApi.GetCommentListData>> r7) {
        CreationDetailCommentRemoteHttpApi r0 = CreationDetailCommentRemoteHttpApi.a;
        String r1 = this.a;
        if (r1 != null) goto L6;
        r1 = "";
    L6:
        return BuildersKt.withContext(Dispatchers.getIO(), new CreationDetailCommentRemoteHttpApi$loadReplyCommentList$2(r1, r5, r6, null), r7);
    }

    public final Object a(String r10, CommentContent r11, String r12, String r13, Continuation<? super com.larus.network.http.a<CommentHttpApi.PostCommentResponse>> r14) {
        CreationDetailCommentRemoteHttpApi r0 = CreationDetailCommentRemoteHttpApi.a;
        String r1 = this.a;
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        String r2 = r1;
        return BuildersKt.withContext(Dispatchers.getIO(), new CreationDetailCommentRemoteHttpApi$postComment$2(r2, r10, r12, r13, r11, null), r14);
    }
}
