package com.larus.bmhome.chat.component.list;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class w implements Runnable {
    public final /* synthetic */ ChatListComponent a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;

    public /* synthetic */ w(ChatListComponent r1, String r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ChatListComponent r0 = this.a;
        String r1 = this.b;
        String r2 = this.c;
        int r3 = ChatListComponent.W3;
        r0.h7(r1);
        r0.h7(r2);
    }
}
