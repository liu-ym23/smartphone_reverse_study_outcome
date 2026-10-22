package com.ss.android.lark.chatbase;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final /* synthetic */ class g implements Runnable {
    public final /* synthetic */ BasePageStore a;
    public final /* synthetic */ Collection b;

    public /* synthetic */ g(BasePageStore r1, Collection r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        BasePageStore r0 = this.a;
        Collection r1 = this.b;
        r0.getClass();
        ArrayList r2 = new ArrayList();
        Iterator r3 = r1.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        r2.add(new s3b.b((f5b.b) r3.next()));
        goto L4
    L6:
        r0.m(r2);
    }
}
