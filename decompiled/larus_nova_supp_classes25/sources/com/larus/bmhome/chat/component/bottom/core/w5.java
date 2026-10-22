package com.larus.bmhome.chat.component.bottom.core;

import bc8.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class w5 implements Runnable {
    public final /* synthetic */ CoreInputComponent a;

    public /* synthetic */ w5(CoreInputComponent r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        CoreInputComponent r0 = this.a;
        int r1 = CoreInputComponent.d3;
        ac8.g r2 = r0.s5();
        boolean r3 = true;
        if (r2.a == false) goto L11;
        com.larus.bmhome.utils.x1 r4 = r0.H1;
        if (r4 != null) goto L7;
    L9:
        boolean r5 = false;
    L10:
        r0.D = r0.I5(r5);
        goto L11
    L7:
        if (r4.b() != true) goto L9;
        r5 = true;
    L11:
        r0.E5();
        if (r2.c == false) goto L26;
        a r6 = s1a.d.a(r0).getAbility(a.class);
        if (r6 != null) goto L16;
        return;
    L16:
        if (r0.s5().c == true) goto L18;
    L23:
        r3 = false;
    L24:
        r6.nv(r3);
        return;
    L18:
        if (r0.u7().length() <= 0) goto L20;
        boolean r7 = true;
    L21:
        if (r7 == false) goto L23;
    L20:
        r7 = false;
        goto L21
    }
}
