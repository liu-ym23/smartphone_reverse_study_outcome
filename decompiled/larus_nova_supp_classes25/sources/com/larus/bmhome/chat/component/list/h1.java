package com.larus.bmhome.chat.component.list;

import androidx.collection.LruCache;
import com.larus.bmhome.chat.stop.a;
import com.larus.bmhome.chat.trace.ChatControlTrace;
import com.larus.im.bean.message.Message;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class h1 implements Function0 {
    public final /* synthetic */ ChatListComponent a;

    public /* synthetic */ h1(ChatListComponent r1) {
        this.a = r1;
    }

    public final Object invoke() {
        ChatListComponent r0 = this.a;
        a r1 = r0.h1;
        if (r1 == null) goto L15;
        Message r2 = r1.a;
        if (r2 == null) goto L15;
        ChatControlTrace r3 = ChatControlTrace.b;
        String r8 = r0.getBotId();
        boolean r4 = r0.pl();
        r3.getClass();
        ChatControlTrace.i0 = System.currentTimeMillis();
        String r7 = r2.getSectionId();
        String r9 = r2.getConversationId();
        LruCache r5 = ChatControlTrace.o;
        String r6 = r2.getConversationId();
        if (r6 != null) goto L9;
        r6 = "";
    L9:
        wc9.e r10 = (wc9.e) r5.get(r6);
        if (r10 == null) goto L12;
        String r11 = ic8.n.f(r10);
    L13:
        tx9.n3.a("stop", "chat", "input", null, r7, r8, r9, r11, ve8.c.b(r4), 1544);
        goto L15
    L12:
        r11 = null;
    L15:
        return Unit.INSTANCE;
    }
}
