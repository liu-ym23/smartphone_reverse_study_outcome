package com.obric.aiagent.messenger.stub;

import com.larus.im.bean.message.Message;
import com.larus.im.observer.MessageListState;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class n0 implements nf9.b {
    public final /* synthetic */ String a;
    public final /* synthetic */ Ref.BooleanRef b;
    public final /* synthetic */ Function1<Message, Unit> c;

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

    public final void e(String r1, Message r2, Map<String, String> r3) {
        Intrinsics.checkNotNullParameter(r1, "cid");
        Intrinsics.checkNotNullParameter(r2, "msg");
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

    public n0(String r1, Ref.BooleanRef r2, l0 r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void c(String r5, Message r6, Map<String, String> r7) {
        Intrinsics.checkNotNullParameter(r5, "cid");
        Intrinsics.checkNotNullParameter(r6, "msg");
        if (Intrinsics.areEqual(r6.getMessageId(), this.a) == true) goto L5;
        return;
    L5:
        if ((r6.getLocalIndex() % ((long) 1000)) != 0) goto L12;
        Ref.BooleanRef r8 = this.b;
        if (r8.element == false) goto L9;
        return;
    L9:
        r8.element = true;
        com.larus.im.d.e().unregisterOnGlobalMessageObserver(this);
        this.c.invoke(r6);
        return;
    }
}
