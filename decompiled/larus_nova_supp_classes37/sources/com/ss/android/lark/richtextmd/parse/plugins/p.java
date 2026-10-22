package com.ss.android.lark.richtextmd.parse.plugins;

import com.ss.android.lark.coremd.base.parse.t;
import kotlin.jvm.internal.Intrinsics;
import v7b.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class p<T extends s> implements t {
    public final /* synthetic */ a a;

    public p(a r1) {
        this.a = r1;
    }

    public final void a(com.ss.android.lark.coremd.impl.parse.k r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        if (this.a.a.b == true) goto L5;
        r2.g.d(uec.a.a());
        return;
    L5:
        com.ss.android.lark.coremd.impl.parse.n r3 = r2.g.a();
        r3.d(uec.a.a());
        r3.a();
    }
}
