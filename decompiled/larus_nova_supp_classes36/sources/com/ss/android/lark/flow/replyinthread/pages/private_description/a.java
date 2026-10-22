package com.ss.android.lark.flow.replyinthread.pages.private_description;

import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chatbase.BasePageStore;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import m6b.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    public final IMessageListComponent a;
    public final String b;
    public final t c;
    public BasePageStore<MessageInfo, ? extends x4b.a<MessageInfo>> d;
    public b e;
    public final C0060a f;
    public boolean g;

    /* JADX WARN: Type inference failed for: r2v1, types: [com.ss.android.lark.flow.replyinthread.pages.private_description.a$a] */
    public a(IMessageListComponent r2, String r3, t r4) {
        Intrinsics.checkNotNullParameter(r2, "messageListComponent");
        Intrinsics.checkNotNullParameter(r4, "chatterPush");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.f = new C0060a(this);
    }

    public static boolean a(MessageInfo r3, Map r4, Set r5) {
        ChatChatter r0 = r3.getMessageSender();
        boolean r1 = false;
        if (r0 == null) goto L19;
        String r2 = r0.getId();
        if (r2 == null) goto L19;
        Chatter r6 = (Chatter) r4.get(r2);
        if (r6 != null) goto L10;
        return false;
    L10:
        ChatChatter r7 = r3.getMessageSender();
        if (r7 != null) goto L13;
    L15:
        if (r1 == false) goto L18;
        r5.add(r2);
    L18:
        return r5.contains(r2);
    L13:
        if (x3b.a.a.update(r7, r6) != true) goto L15;
        r1 = true;
    L19:
        return false;
    }
}
