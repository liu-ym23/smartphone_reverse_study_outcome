package com.ss.android.lark.richtextmd.parse.plugins;

import com.ss.android.lark.coremd.base.parse.t;
import kotlin.jvm.internal.Intrinsics;
import v7b.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class d<T extends s> implements t {
    public final /* synthetic */ a a;

    public d(a r1) {
        this.a = r1;
    }

    public final void a(com.ss.android.lark.coremd.impl.parse.k r4) {
        Intrinsics.checkNotNullParameter(r4, "it");
        if (this.a.a.b == true) goto L5;
        r4.g.d(" ");
        return;
    L5:
        int r0 = r4.g.length();
        r4.g.b();
        com.ss.android.lark.coremd.base.parse.s.a.c(r4.g, r0, 0, 6);
    }
}
