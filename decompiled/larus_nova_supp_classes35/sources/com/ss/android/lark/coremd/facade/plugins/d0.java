package com.ss.android.lark.coremd.facade.plugins;

import kotlin.jvm.internal.Intrinsics;
import v7b.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d0<T extends v7b.s> implements com.ss.android.lark.coremd.base.parse.t {
    public d0() {
    }

    @Override // com.ss.android.lark.coremd.base.parse.t
    public final void a(com.ss.android.lark.coremd.impl.parse.k r5) {
        Intrinsics.checkNotNullParameter(r5, "it");
        if (com.ss.android.lark.coremd.base.parse.k.b.d(r5.getTheme()).h() == false) goto L7;
        r5.g.a();
        int r0 = r5.g.length();
        r5.g.g(" \n");
        r5.g.d(((v7b.g) r5.d).n);
        r5.g.a().g(" ");
        com.ss.android.lark.coremd.base.parse.s.a.c(r5.g, r0, 0, 6);
        com.ss.android.lark.coremd.base.parse.s.a.b(r5.g, r0);
        return;
    }
}
