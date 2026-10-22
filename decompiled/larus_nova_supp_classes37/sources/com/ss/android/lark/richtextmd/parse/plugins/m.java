package com.ss.android.lark.richtextmd.parse.plugins;

import com.ss.android.lark.coremd.base.parse.t;
import kotlin.jvm.internal.Intrinsics;
import v7b.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class m<T extends s> implements t {
    public final /* synthetic */ a a;

    public m(a r1) {
        this.a = r1;
    }

    public final void a(com.ss.android.lark.coremd.impl.parse.k r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        if (this.a.a.b == true) goto L5;
        r2.g.d(r2.d.k);
        return;
    L5:
        com.ss.android.lark.coremd.impl.parse.n r0 = r2.g.a();
        r0.d(r2.d.k);
        r0.a();
    }
}
