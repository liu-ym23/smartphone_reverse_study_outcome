package a2b;

import com.bytedance.lark.pb.im.v1.CreateAddChatChatterApplyRequest;
import com.bytedance.lark.pb.im.v1.CreateChatLastReadPositionRequest;
import com.bytedance.lark.pb.im.v1.GetChatChatterKickRequest;
import com.bytedance.lark.pb.im.v1.HideChatTranslatedNameRequest;
import com.bytedance.lark.pb.im.v1.MGetChatsRequest;
import com.bytedance.lark.pb.im.v1.SubscribeChatEventRequest;
import com.bytedance.lark.pb.im.v1.TranslateChatNameRequest;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.chat.api.service.impl.a0;
import com.ss.android.lark.chat.api.service.impl.b0;
import com.ss.android.lark.chat.api.service.impl.e0;
import com.ss.android.lark.chat.api.service.impl.r;
import com.ss.android.lark.chat.api.service.impl.t;
import com.ss.android.lark.chat.api.service.impl.v;
import com.ss.android.lark.chat.api.service.impl.w;
import com.ss.android.lark.chat.api.service.impl.x;
import com.ss.android.lark.chat.name.ChatNameRenderer$doHideTranslate$1;
import com.ss.android.lark.chat.name.ChatNameRenderer$doTranslate$1;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface a {
    Map a(MGetChatsRequest.Builder r1, a0 r2);

    com.ss.android.lark.chat.entity.chat.b b(GetChatChatterKickRequest.Builder r1, t r2);

    void c(CreateAddChatChatterApplyRequest.Builder r1, x r2, IGetDataCallback r3);

    void d(HideChatTranslatedNameRequest.Builder r1, r r2, ChatNameRenderer$doHideTranslate$1 r3);

    void e(SubscribeChatEventRequest.Builder r1, b0 r2, IGetDataCallback r3);

    Map f(MGetChatsRequest.Builder r1, v r2);

    void g(TranslateChatNameRequest.Builder r1, e0 r2, ChatNameRenderer$doTranslate$1 r3);

    void h(CreateChatLastReadPositionRequest.Builder r1, w r2);
}
