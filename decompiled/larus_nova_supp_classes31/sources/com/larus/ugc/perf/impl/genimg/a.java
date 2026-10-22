package com.larus.ugc.perf.impl.genimg;

import com.larus.im.bean.message.Message;
import com.larus.im.observer.MessageListState;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a implements nf9.b {
    public a() {
    }

    public final void a(String r2, Message r3) {
        Intrinsics.checkNotNullParameter(r2, "cid");
        Intrinsics.checkNotNullParameter(r3, "msg");
    }

    public final void c(String r1, Message r2, Map<String, String> r3) {
        Intrinsics.checkNotNullParameter(r1, "cid");
        Intrinsics.checkNotNullParameter(r2, "msg");
    }

    public final void d(String r2, Message r3) {
        Intrinsics.checkNotNullParameter(r2, "cid");
        Intrinsics.checkNotNullParameter(r3, "msg");
    }

    public final void e(String r1, Message r2, Map<String, String> r3) {
        Intrinsics.checkNotNullParameter(r1, "cid");
        Intrinsics.checkNotNullParameter(r2, "msg");
    }

    public final void onMessageListReplaced(String r2, List<Message> r3, List<Message> r4) {
        Intrinsics.checkNotNullParameter(r2, "cid");
        Intrinsics.checkNotNullParameter(r3, "oldMsgList");
        Intrinsics.checkNotNullParameter(r4, "newMsgList");
    }

    public final void f(String r3, Message r4) {
        Intrinsics.checkNotNullParameter(r3, "cid");
        Intrinsics.checkNotNullParameter(r4, "msg");
        if (com.larus.bmhome.chat.bean.d.k(r4) == false) goto L8;
        b r5 = b.d;
        r5.getClass();
        com.larus.ugc.perf.impl.e r6 = com.larus.ugc.perf.impl.d.a.a(r4);
        if (r6 == null) goto L9;
        r5.m(r6, 300);
        return;
    L9:
        return;
    }

    public final void b(String r3, MessageListState r4, List<Message> r5) {
        Intrinsics.checkNotNullParameter(r3, "cid");
        Intrinsics.checkNotNullParameter(r4, "state");
        Intrinsics.checkNotNullParameter(r5, "msgList");
        if (r4 != MessageListState.DELETE) goto L12;
        Iterator<T> r6 = r5.iterator();
    L6:
        if (r6.hasNext() == false) goto L20;
        Message r7 = (Message) r6.next();
        if (com.larus.bmhome.chat.bean.d.k(r7) == false) goto L6;
        b r8 = b.d;
        r8.getClass();
        com.larus.ugc.perf.impl.e r9 = com.larus.ugc.perf.impl.d.a.a(r7);
        if (r9 == null) goto L6;
        r8.m(r9, 200);
        goto L6
    L20:
        return;
    }
}
