package com.larus.bmhome.chat.component.list;

import com.larus.bmhome.view.ChatMessageList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class l1 implements Runnable {
    public final /* synthetic */ ChatMessageList a;
    public final /* synthetic */ ChatListComponent b;
    public final /* synthetic */ String c;

    public /* synthetic */ l1(ChatMessageList r1, ChatListComponent r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ChatMessageList r0 = this.a;
        ChatListComponent r1 = this.b;
        String r2 = this.c;
        int r3 = ChatListComponent.W3;
        if (r0.getScrollState() != 0) goto L6;
        r1.X3(r2 + "_idle_fallback");
        return;
    }
}
