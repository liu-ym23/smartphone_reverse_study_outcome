package com.ss.android.lark.richtextmd.parse.plugins;

import com.ss.android.lark.coremd.base.parse.t;
import kotlin.jvm.internal.Intrinsics;
import v7b.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class c<T extends s> implements t {
    public final /* synthetic */ a a;

    public c(a r1) {
        this.a = r1;
    }

    public final void a(com.ss.android.lark.coremd.impl.parse.k r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        if (this.a.a.b == true) goto L5;
        r3.g.d(" ");
    L6:
        r3.f.c(r3.d);
        return;
    L5:
        r3.g.a();
        goto L6
    }
}
