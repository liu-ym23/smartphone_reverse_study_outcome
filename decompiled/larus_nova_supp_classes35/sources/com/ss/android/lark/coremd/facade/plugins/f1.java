package com.ss.android.lark.coremd.facade.plugins;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class f1 implements com.ss.android.lark.coremd.base.parse.g {
    public f1() {
    }

    @Override // com.ss.android.lark.coremd.base.parse.g
    public final void a(com.ss.android.lark.coremd.impl.parse.l.a r3) {
        Intrinsics.checkNotNullParameter(r3, "builder");
        r3.a(v7b.c.class, new c1(this));
        r3.a(v7b.u.class, new d1(this));
        r3.a(v7b.q.class, new e1());
    }

    @Override // com.ss.android.lark.coremd.base.parse.g
    public final void b(com.ss.android.lark.coremd.impl.parse.g r2) {
        Intrinsics.checkNotNullParameter(r2, "registry");
    }

    @Override // com.ss.android.lark.coremd.base.parse.g
    public final void c(com.ss.android.lark.coremd.impl.parse.j.a r3) {
        Intrinsics.checkNotNullParameter(r3, "builder");
        r3.a(v7b.q.class, new b1(this));
    }

    @Override // com.ss.android.lark.coremd.base.parse.g
    public final void d(com.ss.android.lark.coremd.impl.parse.c r2) {
        Intrinsics.checkNotNullParameter(r2, "registry");
    }

    public final int f(v7b.s r2) {
        v7b.s r3 = ((v7b.a) r2).d;
    L3:
        v7b.a r4 = (v7b.a) r3;
        if ((r4 instanceof v7b.u) == true) goto L14;
        if ((r4 instanceof v7b.c) == true) goto L14;
        if ((r4 instanceof v7b.i) == true) goto L11;
        return -1;
    L11:
        return ((v7b.i) r4).j;
    L14:
        r3 = ((v7b.p) r4).d;
        goto L3
    }

    public static final void e(f1 r2, com.ss.android.lark.coremd.impl.parse.k r3) {
        r2.getClass();
        if (com.ss.android.lark.coremd.base.parse.k.b.c(r3.getTheme()).l() == false) goto L7;
        r3.g.a();
        int r4 = r3.g.length();
        r3.f.c(r3.d);
        com.ss.android.lark.coremd.base.parse.s.a.c(r3.g, r4, 0, 6);
        return;
    }
}
