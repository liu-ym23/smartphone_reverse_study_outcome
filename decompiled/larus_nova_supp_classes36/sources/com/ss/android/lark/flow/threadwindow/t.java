package com.ss.android.lark.flow.threadwindow;

import com.bytedance.lark.pb.im.v1.PushMessageReactions;
import com.ss.android.lark.biz.im.api.ThreadTopic;
import com.ss.android.lark.biz.im.api.g1;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public interface t {
    void onPushChat(Chat r1);

    void onPushChatRemoveChatters(Chat r1, Map<String, ? extends Chatter> r2);

    void onPushChatRemoveMe(Chat r1);

    void onPushRootMessage(MessageInfo r1);

    void onPushRootThread(g1 r1);

    void onPushThreadReactions(PushMessageReactions r1);

    void onPushThreadReply(g1 r1);

    void onPushThreadTopic(ThreadTopic r1);

    void onThreadRepliesUpdate(n5b.a r1);
}
