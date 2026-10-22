package com.ss.android.lark.coremd.facade.plugins;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class l implements com.ss.android.lark.coremd.base.parse.g {
    public l() {
    }

    @Override // com.ss.android.lark.coremd.base.parse.g
    public final void a(com.ss.android.lark.coremd.impl.parse.l.a r3) {
        Intrinsics.checkNotNullParameter(r3, "builder");
        r3.a(v7b.b0.class, new f());
        r3.a(v7b.v.class, new g());
        r3.a(v7b.a0.class, new h(this));
        r3.a(v7b.f.class, new i(this));
        r3.a(v7b.e0.class, new j(this));
        r3.a(v7b.z.class, new k(this));
    }

    @Override // com.ss.android.lark.coremd.base.parse.g
    public final void b(com.ss.android.lark.coremd.impl.parse.g r2) {
        Intrinsics.checkNotNullParameter(r2, "registry");
    }

    @Override // com.ss.android.lark.coremd.base.parse.g
    public final void c(com.ss.android.lark.coremd.impl.parse.j.a r3) {
        Intrinsics.checkNotNullParameter(r3, "builder");
        r3.a(v7b.a0.class, new b(this));
        r3.a(v7b.f.class, new c(this));
        r3.a(v7b.e0.class, new d(this));
        r3.a(v7b.z.class, new e(this));
    }

    @Override // com.ss.android.lark.coremd.base.parse.g
    public final void d(com.ss.android.lark.coremd.impl.parse.c r2) {
        Intrinsics.checkNotNullParameter(r2, "registry");
    }

    public static final x9b.h e(l r2, v7b.s r3) {
        r2.getClass();
        x9b.h r4 = new x9b.h();
        if ((r3 instanceof v7b.a0) == false) goto L6;
        r4.a = true;
        return r4;
    L6:
        if ((r3 instanceof v7b.f) == false) goto L9;
        r4.b = true;
        return r4;
    L9:
        if ((r3 instanceof v7b.e0) == false) goto L12;
        r4.c = true;
        return r4;
    L12:
        if ((r3 instanceof v7b.z) == false) goto L14;
        r4.d = true;
        return r4;
    L14:
        return null;
    }

    public static final void f(l r2, com.ss.android.lark.coremd.impl.parse.k r3) {
        r2.getClass();
        int r4 = r3.g.length();
        r3.f.c(r3.d);
        if (com.ss.android.lark.coremd.base.parse.k.b.h(r3.getTheme()) == false) goto L6;
        com.ss.android.lark.coremd.base.parse.s.a.c(r3.g, r4, 0, 6);
        return;
    }
}
