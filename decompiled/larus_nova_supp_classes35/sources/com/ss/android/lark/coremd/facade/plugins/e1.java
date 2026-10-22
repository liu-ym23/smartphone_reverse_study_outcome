package com.ss.android.lark.coremd.facade.plugins;

import kotlin.jvm.internal.Intrinsics;
import v7b.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class e1<T extends v7b.s> implements com.ss.android.lark.coremd.base.parse.t {
    public e1() {
    }

    @Override // com.ss.android.lark.coremd.base.parse.t
    public final void a(com.ss.android.lark.coremd.impl.parse.k r5) {
        Intrinsics.checkNotNullParameter(r5, "it");
        if (com.ss.android.lark.coremd.base.parse.k.b.c(r5.getTheme()).l() == false) goto L14;
        r5.g.a();
        int r0 = r5.g.length();
        v7b.s r1 = r5.d;
        if (((v7b.q) r1).f != null) goto L8;
        boolean r2 = true;
    L9:
        if (r2 == false) goto L11;
        r5.g.d("\u200b");
    L12:
        com.ss.android.lark.coremd.base.parse.s.a.c(r5.g, r0, 0, 6);
        r5.g.a();
        return;
    L11:
        r5.f.c(r1);
        goto L12
    L8:
        r2 = false;
        goto L9
    }
}
