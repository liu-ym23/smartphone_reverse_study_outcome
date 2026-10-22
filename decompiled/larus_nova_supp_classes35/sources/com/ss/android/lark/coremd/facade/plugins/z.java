package com.ss.android.lark.coremd.facade.plugins;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class z implements com.ss.android.lark.coremd.base.parse.g {
    public static final z a = null;

    static {
        a = new z();
    }

    public z() {
    }

    @Override // com.ss.android.lark.coremd.base.parse.g
    public final void a(com.ss.android.lark.coremd.impl.parse.l.a r2) {
        Intrinsics.checkNotNullParameter(r2, "builder");
    }

    @Override // com.ss.android.lark.coremd.base.parse.g
    public final void b(com.ss.android.lark.coremd.impl.parse.g r3) {
        Intrinsics.checkNotNullParameter(r3, "registry");
        r3.a(eab.a.class, new r());
        r3.a(v7b.n.class, new s());
        r3.a(v7b.l.class, new t());
        r3.a(eab.f.class, new u());
        r3.a(v7b.g.class, new v());
        r3.a(eab.g.class, new w());
        r3.a(eab.b.class, new x());
        r3.a(eab.h.class, new y());
    }

    @Override // com.ss.android.lark.coremd.base.parse.g
    public final void c(com.ss.android.lark.coremd.impl.parse.j.a r2) {
        Intrinsics.checkNotNullParameter(r2, "builder");
    }

    @Override // com.ss.android.lark.coremd.base.parse.g
    public final void d(com.ss.android.lark.coremd.impl.parse.c r2) {
        Intrinsics.checkNotNullParameter(r2, "registry");
    }
}
