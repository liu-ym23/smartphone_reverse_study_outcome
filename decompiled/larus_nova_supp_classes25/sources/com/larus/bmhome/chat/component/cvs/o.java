package com.larus.bmhome.chat.component.cvs;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class o implements Runnable {
    public final /* synthetic */ ChatConversationVM a;

    public /* synthetic */ o(ChatConversationVM r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ChatConversationVM.cp(this.a);
    }
}
