package com.larus.chat.job.impl.page;

import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class a implements Runnable {
    public final /* synthetic */ ChatJobFragment a;

    public /* synthetic */ a(ChatJobFragment r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ChatJobFragment r0 = this.a;
        Iterator<T> r1 = r0.k.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        ((cz8.j) r1.next()).b(r0);
        goto L4
    }
}
