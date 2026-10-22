package com.bytedance.bdinstall;

import android.text.TextUtils;
import k74.c;
import l74.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class u0 implements a1$c {
    public final /* synthetic */ v0$a a;

    public u0(v0$a r1) {
        this.a = r1;
    }

    @Override // com.bytedance.bdinstall.a1$c
    public final void b(String r3, String r4) {
        t.a("install_info onUpdate " + r3);
        n0 r5 = n0.b(r3);
        if (r5 != null) goto L5;
    L15:
        t.a("install_info onUpdate invalid value " + r5);
        return;
    L5:
        if (TextUtils.isEmpty(r5.a) == true) goto L15;
        if (TextUtils.isEmpty(r5.b) == true) goto L15;
        v0$a r6 = this.a;
        if (r6 == null) goto L17;
        w0 r7 = (w0) r6;
        r7.getClass();
        t.a("install info changed : " + r5);
        r7.c.p(r5);
        c r8 = r7.b;
        if (r8 == null) goto L18;
        r8.a(new b(r5));
        return;
    L18:
        return;
    }
}
