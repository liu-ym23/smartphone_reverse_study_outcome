package com.obric.assistant.window;

import com.larus.im.bean.message.Message;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public class a implements nf9.b {
    public a() {
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
