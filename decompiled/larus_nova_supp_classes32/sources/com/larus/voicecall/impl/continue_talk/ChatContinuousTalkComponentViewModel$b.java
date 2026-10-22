package com.larus.voicecall.impl.continue_talk;

import com.larus.im.bean.message.Message;
import com.larus.im.observer.MessageListState;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import nf9.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class ChatContinuousTalkComponentViewModel$b implements b {
    public final /* synthetic */ ChatContinuousTalkComponentViewModel a;

    public final void a(String r2, Message r3) {
        Intrinsics.checkNotNullParameter(r2, "cid");
        Intrinsics.checkNotNullParameter(r3, "msg");
    }

    public final void b(String r2, MessageListState r3, List<Message> r4) {
        Intrinsics.checkNotNullParameter(r2, "cid");
        Intrinsics.checkNotNullParameter(r3, "state");
        Intrinsics.checkNotNullParameter(r4, "msgList");
    }

    public final void d(String r2, Message r3) {
        Intrinsics.checkNotNullParameter(r2, "cid");
        Intrinsics.checkNotNullParameter(r3, "msg");
    }

    public final void f(String r2, Message r3) {
        Intrinsics.checkNotNullParameter(r2, "cid");
        Intrinsics.checkNotNullParameter(r3, "msg");
    }

    public final void onMessageListReplaced(String r2, List<Message> r3, List<Message> r4) {
        Intrinsics.checkNotNullParameter(r2, "cid");
        Intrinsics.checkNotNullParameter(r3, "oldMsgList");
        Intrinsics.checkNotNullParameter(r4, "newMsgList");
    }

    public ChatContinuousTalkComponentViewModel$b(ChatContinuousTalkComponentViewModel r1) {
        this.a = r1;
    }

    public final void c(String r1, Message r2, Map<String, String> r3) {
        Intrinsics.checkNotNullParameter(r1, "cid");
        Intrinsics.checkNotNullParameter(r2, "msg");
        ChatContinuousTalkComponentViewModel.access$onMessageReceived(this.a, r1, r2);
    }

    public final void e(String r1, Message r2, Map<String, String> r3) {
        Intrinsics.checkNotNullParameter(r1, "cid");
        Intrinsics.checkNotNullParameter(r2, "msg");
        ChatContinuousTalkComponentViewModel.access$onMessageReceived(this.a, r1, r2);
    }
}
