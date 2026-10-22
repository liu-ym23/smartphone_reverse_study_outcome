package com.larus.bmhome.chat.component.list;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class t0 implements Runnable {
    public final /* synthetic */ ChatListComponent a;

    public /* synthetic */ t0(ChatListComponent r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ChatListComponent r0 = this.a;
        int r1 = ChatListComponent.W3;
        r0.b7("post_update_fast_button_before");
        r0.U1();
    }
}
