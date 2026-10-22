package aqb;

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
import kotlin.jvm.internal.Intrinsics;
import m6b.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class a implements o {
    public a() {
    }

    public void a(g1 r2) {
        Intrinsics.checkNotNullParameter(r2, "pushMessageDTO");
    }

    public void b(PushMessageReadStates r2) {
        Intrinsics.checkNotNullParameter(r2, "readStates");
    }

    public void c(MessageInfo r1) {
    }

    public void e(DoubaoTyping r2) {
        Intrinsics.checkNotNullParameter(r2, "doubaoTyping");
    }

    public void f(PushMessageReactions r2) {
        Intrinsics.checkNotNullParameter(r2, "reactions");
    }

    public void g(Chat r2, Map<String, ? extends Chatter> r3) {
        Intrinsics.checkNotNullParameter(r2, "chat");
        Intrinsics.checkNotNullParameter(r3, "chatterMap");
    }

    public void h(Chat r2, Map<String, ? extends Chatter> r3) {
        Intrinsics.checkNotNullParameter(r2, "chat");
        Intrinsics.checkNotNullParameter(r3, "chatterMap");
    }

    public void i(Chat r2, Map<String, ? extends Chatter> r3) {
        Intrinsics.checkNotNullParameter(r2, "chat");
        Intrinsics.checkNotNullParameter(r3, "chatterMap");
    }

    public void onPushChat(Chat r2) {
        Intrinsics.checkNotNullParameter(r2, "chat");
    }

    public void onPushChatRemoveMe(Chat r2) {
        Intrinsics.checkNotNullParameter(r2, "chat");
    }

    public void onPushThreadTopic(ThreadTopic r2) {
        Intrinsics.checkNotNullParameter(r2, "threadTopic");
    }

    public void d(PushDoubaoSmartReply r2) {
        Intrinsics.checkNotNullParameter(r2, "push");
    }
}
