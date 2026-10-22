package com.ss.android.lark.coremd.facade.plugins;

import kotlin.jvm.internal.Intrinsics;
import v7b.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class h0<T extends v7b.s> implements com.ss.android.lark.coremd.base.parse.t {
    public h0() {
    }

    @Override // com.ss.android.lark.coremd.base.parse.t
    public final void a(com.ss.android.lark.coremd.impl.parse.k r5) {
        Intrinsics.checkNotNullParameter(r5, "it");
        int r0 = r5.g.length();
        r5.g.a();
        int r1 = r5.g.length();
        if (r0 != r1) goto L5;
        r0 = Math.max(r0 - 1, 0);
    L5:
        com.ss.android.lark.coremd.base.parse.s.a.c(r5.g, r0, r1, 4);
        com.ss.android.lark.coremd.base.parse.s.a.b(r5.g, r0);
    }
}
