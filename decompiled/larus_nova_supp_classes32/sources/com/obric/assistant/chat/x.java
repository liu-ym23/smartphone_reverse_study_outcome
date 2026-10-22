package com.obric.assistant.chat;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class x implements Runnable {
    public final /* synthetic */ boolean a;

    public /* synthetic */ x(boolean r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean r0 = this.a;
        Iterator r1 = ((ArrayList) ObricChatService.m).iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        ((a) r1.next()).b(r0);
        goto L4
    }
}
