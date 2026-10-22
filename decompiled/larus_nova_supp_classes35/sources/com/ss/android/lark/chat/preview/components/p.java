package com.ss.android.lark.chat.preview.components;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class p implements com.ss.android.lark.coremd.base.parse.g {
    public final /* synthetic */ n a;
    public final /* synthetic */ Context b;

    @Override // com.ss.android.lark.coremd.base.parse.g
    public final void a(com.ss.android.lark.coremd.impl.parse.l.a r2) {
        Intrinsics.checkNotNullParameter(r2, "builder");
    }

    @Override // com.ss.android.lark.coremd.base.parse.g
    public final void b(com.ss.android.lark.coremd.impl.parse.g r5) {
        Intrinsics.checkNotNullParameter(r5, "registry");
        r5.a(v7b.n.class, new o(this.a, this.b));
    }

    @Override // com.ss.android.lark.coremd.base.parse.g
    public final void c(com.ss.android.lark.coremd.impl.parse.j.a r2) {
        Intrinsics.checkNotNullParameter(r2, "builder");
    }

    @Override // com.ss.android.lark.coremd.base.parse.g
    public final void d(com.ss.android.lark.coremd.impl.parse.c r2) {
        Intrinsics.checkNotNullParameter(r2, "registry");
    }

    public p(n r1, Context r2) {
        this.a = r1;
        this.b = r2;
    }
}
