package com.ss.android.lark.chat.chatwindow.chat.menu.reaction;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a implements Runnable {
    public a(String r1, ReactionEventDispatcher.b r2, String r3) {
    }

    @Override // java.lang.Runnable
    public final void run() {
        Iterator<T> r0 = ReactionEventDispatcher.a.keySet().iterator();     // Catch: Throwable -> L7
    L4:
        if (r0.hasNext() == false) goto L16;
        ((ReactionEventDispatcher.a) r0.next()).a();     // Catch: Throwable -> L7
        goto L4
    L16:
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }
}
