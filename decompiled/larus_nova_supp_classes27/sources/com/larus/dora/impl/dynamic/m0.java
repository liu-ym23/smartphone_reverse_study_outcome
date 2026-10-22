package com.larus.dora.impl.dynamic;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class m0 implements Runnable {
    public final /* synthetic */ DoraDynamicFragment a;

    public m0(DoraDynamicFragment r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        DoraDynamicPagerAdapter r0 = this.a.i;     // Catch: Throwable -> L10
        if (r0 == null) goto L13;
        DoraDynamicListFragment r1 = r0.y2(1);     // Catch: Throwable -> L10
        if (r1 == null) goto L17;
        DslCardAdapter r2 = r1.g;     // Catch: Throwable -> L10
        if (r2 == null) goto L18;
        r2.y2(DslCardAdapter.a.InterfaceC0061a.d.a);     // Catch: Throwable -> L10
        return;
    L18:
        return;
    L17:
        return;
    L13:
        return;
    L10:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L19;
        throw th;
    }
}
