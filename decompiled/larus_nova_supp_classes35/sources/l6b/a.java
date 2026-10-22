package l6b;

import com.bytedance.lark.pb.im.v1.CreateDraftRequest;
import com.bytedance.lark.pb.im.v1.CreateOrDeleteChatLastDraftIdRequest;
import com.bytedance.lark.pb.im.v1.DeleteDraftRequest;
import com.bytedance.lark.pb.im.v1.FetchChatInputDraftRequest;
import com.bytedance.lark.pb.im.v1.FetchMessageReplyDraftRequest;
import com.bytedance.lark.pb.im.v1.GetAllDraftsResponse;
import com.bytedance.lark.pb.im.v1.GetDraftsRequest;
import com.bytedance.lark.pb.im.v1.PutChatOrThreadDraftsUpdateRequest;
import com.ss.android.lark.chat.service.impl.k;
import com.ss.android.lark.chat.service.impl.l;
import com.ss.android.lark.chat.service.impl.m;
import com.ss.android.lark.chat.service.impl.n;
import com.ss.android.lark.chat.service.impl.q;
import com.ss.android.lark.dto.draft.Draft;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface a {
    Draft a(FetchMessageReplyDraftRequest.Builder r1, q r2);

    void b(DeleteDraftRequest.Builder r1);

    void c(PutChatOrThreadDraftsUpdateRequest.Builder r1);

    String d(CreateDraftRequest.Builder r1, l r2, m r3);

    Draft e(FetchChatInputDraftRequest.Builder r1, n r2);

    Map<String, List<Draft>> f(Function1<? super GetAllDraftsResponse, ? extends Map<String, ? extends List<? extends Draft>>> r1);

    Map g(GetDraftsRequest.Builder r1, k r2);

    void h(CreateOrDeleteChatLastDraftIdRequest.Builder r1);
}
