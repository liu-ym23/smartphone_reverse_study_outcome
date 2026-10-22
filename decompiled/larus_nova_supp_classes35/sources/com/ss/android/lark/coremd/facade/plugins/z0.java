package com.ss.android.lark.coremd.facade.plugins;

import kotlin.jvm.internal.Intrinsics;
import v7b.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class z0<T extends v7b.s> implements com.ss.android.lark.coremd.base.parse.t {
    public z0() {
    }

    @Override // com.ss.android.lark.coremd.base.parse.t
    public final void a(com.ss.android.lark.coremd.impl.parse.k r6) {
        Intrinsics.checkNotNullParameter(r6, "it");
        if (com.ss.android.lark.coremd.base.parse.k.b.g(r6.getTheme()).i() == false) goto L17;
        int r0 = r6.g.length();
        v7b.s r1 = r6.d;
        String r2 = ((v7b.n) r1).j;
        String r3 = ((v7b.n) r1).k;
        if (r3 != null) goto L8;
    L11:
        boolean r4 = true;
    L12:
        if (r4 == false) goto L14;
        com.ss.android.lark.coremd.base.parse.s r5 = r6.g;
        Intrinsics.checkNotNull(r2);
        r5.d(r2);
    L15:
        com.ss.android.lark.coremd.base.parse.s.a.c(r6.g, r0, 0, 6);
        com.ss.android.lark.coremd.base.parse.s.a.a(r6.g, r0);
        com.ss.android.lark.coremd.base.parse.s.a.b(r6.g, r0);
        return;
    L14:
        r6.g.d(r3);
        goto L15
    L8:
        if (r3.length() == 0) goto L11;
        r4 = false;
        goto L12
    }
}
