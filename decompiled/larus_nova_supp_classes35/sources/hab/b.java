package hab;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.ss.android.lark.biz.im.api.bundle.ChatBundle;
import com.ss.android.lark.chat.api.IChatParser;
import com.ss.android.lark.create.groupchat.impl.service.interceptor.StrangerInterceptor$getP2pChatCreatedByChatterId$2$1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface b {
    void a();

    void b(String r1, StrangerInterceptor$getP2pChatCreatedByChatterId$2$1 r2);

    void c(Fragment r1, Context r2, ChatBundle r3);

    IChatParser getChatParser();

    void openChat(Context r1, ChatBundle r2);
}
