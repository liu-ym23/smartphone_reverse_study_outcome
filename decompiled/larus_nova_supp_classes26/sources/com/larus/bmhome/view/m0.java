package com.larus.bmhome.view;

import kotlin.Lazy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class m0 implements Runnable {
    public final /* synthetic */ ChatMessageList a;

    public /* synthetic */ m0(ChatMessageList r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ChatMessageList r0 = this.a;
        Lazy r1 = ChatMessageList.V0;
        r0.x(r0, false);
    }
}
