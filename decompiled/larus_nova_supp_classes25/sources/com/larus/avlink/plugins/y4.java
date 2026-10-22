package com.larus.avlink.plugins;

import com.larus.im.bean.message.Message;
import com.larus.im.observer.MessageListState;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public class y4 implements nf9.b {
    public y4() {
    }

    public final void a(String r2, Message r3) {
        Intrinsics.checkNotNullParameter(r2, "cid");
        Intrinsics.checkNotNullParameter(r3, "msg");
    }

    public void b(String r2, MessageListState r3, List<Message> r4) {
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
}
