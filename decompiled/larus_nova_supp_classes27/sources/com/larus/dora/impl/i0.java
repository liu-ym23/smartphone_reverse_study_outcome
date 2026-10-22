package com.larus.dora.impl;

import com.larus.dora.api.DoraEnableScope;
import com.larus.dora.api.IDoraService;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class i0 implements Runnable {
    public final /* synthetic */ DoraServiceImpl a;
    public final /* synthetic */ DoraEnableScope b;

    public /* synthetic */ i0(DoraServiceImpl r1, DoraEnableScope r2, boolean r3) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        DoraServiceImpl r0 = this.a;
        DoraEnableScope r1 = this.b;
        Iterator r2 = r0.s.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        IDoraService.e r3 = (IDoraService.e) r2.next();
        if (r0.s.contains(r3) == false) goto L4;
        r3.a(r1);
        goto L4
    }
}
