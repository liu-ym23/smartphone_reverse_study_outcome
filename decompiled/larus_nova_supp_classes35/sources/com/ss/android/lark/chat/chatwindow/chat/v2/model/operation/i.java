package com.ss.android.lark.chat.chatwindow.chat.v2.model.operation;

import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class i implements Function1<f5b.b, f5b.b> {
    public final Chatter a;
    public final String b;

    public final Object invoke(Object r6) {
        f5b.b r7 = (f5b.b) r6;
        String r1 = null;
        if ((r7 instanceof MessageInfo) == false) goto L5;
        MessageInfo r0 = (MessageInfo) r7;
    L6:
        if (r0 != null) goto L8;
    L17:
        if (r7 == null) goto L19;
        ChatChatter r2 = r7.getMessageSender();
    L20:
        if (r2 == null) goto L33;
        if (r7 == null) goto L26;
        ChatChatter r3 = r7.getMessageSender();
        if (r3 == null) goto L26;
        r1 = r3.getId();
    L26:
        if (Intrinsics.areEqual(r1, this.a.getId()) == false) goto L33;
        ChatChatter r4 = r7.getMessageSender();
        Chatter r5 = this.a;
        if ((r5 instanceof ChatChatter) == true) goto L30;
    L32:
        Intrinsics.checkNotNull(r4);
        r4.setChatter(this.a);
        goto L33
    L30:
        if (Intrinsics.areEqual(((ChatChatter) r5).getChatId(), this.b) == false) goto L32;
        r7.setMessageSender((ChatChatter) this.a);
    L33:
        return r7;
    L19:
        r2 = null;
        goto L20
    L8:
        if ((this.a instanceof ChatChatter) == false) goto L17;
        List<MessageInfo> r8 = r0.getLatestRepliesInThread();
        if (r8 == null) goto L17;
        Iterator<T> r9 = r8.iterator();
    L13:
        if (r9.hasNext() == false) goto L17;
        MessageInfo r10 = (MessageInfo) r9.next();
        if (Intrinsics.areEqual(r10.getMessageSender().getId(), ((ChatChatter) this.a).getId()) == false) goto L13;
        r10.setMessageSender((ChatChatter) this.a);
        goto L13
    L5:
        r0 = null;
        goto L6
    }

    public i(Chatter r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "chatter");
        Intrinsics.checkNotNullParameter(r3, "currentChatId");
        this.a = r2;
        this.b = r3;
    }
}
