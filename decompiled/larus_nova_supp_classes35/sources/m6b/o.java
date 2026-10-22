package m6b;

import com.bytedance.lark.pb.im.v1.DoubaoTyping;
import com.bytedance.lark.pb.im.v1.PushDoubaoSmartReply;
import com.bytedance.lark.pb.im.v1.PushMessageReactions;
import com.bytedance.lark.pb.im.v1.PushMessageReadStates;
import com.ss.android.lark.biz.im.api.ThreadTopic;
import com.ss.android.lark.biz.im.api.g1;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface o {
    void a(g1 r1);

    void b(PushMessageReadStates r1);

    void c(MessageInfo r1);

    void d(PushDoubaoSmartReply r1);

    void e(DoubaoTyping r1);

    void f(PushMessageReactions r1);

    void g(Chat r1, Map<String, ? extends Chatter> r2);

    void h(Chat r1, Map<String, ? extends Chatter> r2);

    void i(Chat r1, Map<String, ? extends Chatter> r2);

    void onPushChat(Chat r1);

    void onPushChatRemoveMe(Chat r1);

    void onPushThreadTopic(ThreadTopic r1);
}
