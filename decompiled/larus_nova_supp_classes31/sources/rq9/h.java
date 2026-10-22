package rq9;

import com.larus.platform.model.comment.CommentContent;
import com.larus.platform.model.comment.api.CommentHttpApi$GetCommentListData;
import com.larus.platform.model.comment.api.CommentHttpApi$PostCommentResponse;
import java.util.Map;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public interface h {
    Object a(String r1, CommentContent r2, String r3, String r4, Continuation<? super com.larus.network.http.a<CommentHttpApi$PostCommentResponse>> r5);

    int b();

    Object c(Continuation<? super com.larus.network.http.a<b>> r1);

    Object d(String r1, Continuation<? super com.larus.network.http.a<? extends Object>> r2);

    Object e(String r1, boolean r2, Continuation<? super com.larus.network.http.a<? extends Object>> r3);

    Map<String, String> f();

    Object g(String r1, String r2, Continuation<? super com.larus.network.http.a<CommentHttpApi$GetCommentListData>> r3);

    Object h(String r1, String r2, Continuation<? super com.larus.network.http.a<CommentHttpApi$GetCommentListData>> r3);
}
