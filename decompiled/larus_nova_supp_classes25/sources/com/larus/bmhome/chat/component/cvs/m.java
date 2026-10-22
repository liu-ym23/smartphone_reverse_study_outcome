package com.larus.bmhome.chat.component.cvs;

import com.larus.bmhome.social.userchat.model.ChatConversationRequestModel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class m implements Runnable {
    public final /* synthetic */ ChatConversationRequestModel a;
    public final /* synthetic */ ChatConversationVM b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;

    public /* synthetic */ m(ChatConversationRequestModel r1, ChatConversationVM r2, String r3, String r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ChatConversationVM.Yo(this.a, this.b, this.c, this.d);
    }
}
