package com.obric.assistant.chat;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class y implements Runnable {
    public /* synthetic */ y() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        Iterator r0 = ((ArrayList) ObricChatService.m).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((a) r0.next()).a();
        goto L4
    }
}
