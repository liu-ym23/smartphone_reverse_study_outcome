package com.larus.dora.impl;

import com.larus.dora.api.DoraEnableScope;
import com.larus.dora.api.DoraResourceState;
import com.larus.dora.api.IDoraService$g;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class j0 implements Runnable {
    public final /* synthetic */ DoraServiceImpl a;
    public final /* synthetic */ DoraEnableScope b;
    public final /* synthetic */ DoraResourceState c;

    public /* synthetic */ j0(DoraServiceImpl r1, DoraEnableScope r2, DoraResourceState r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        DoraServiceImpl r0 = this.a;
        DoraEnableScope r1 = this.b;
        DoraResourceState r2 = this.c;
        Iterator r3 = r0.u.iterator();
    L4:
        if (r3.hasNext() == false) goto L8;
        IDoraService$g r4 = (IDoraService$g) r3.next();
        if (r0.u.contains(r4) == false) goto L4;
        r4.a(r1, r2);
        goto L4
    }
}
