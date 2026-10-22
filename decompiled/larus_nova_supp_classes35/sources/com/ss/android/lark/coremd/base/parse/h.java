package com.ss.android.lark.coremd.base.parse;

import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public abstract class h implements g {
    public h() {
    }

    public abstract List<g> e();

    @Override // com.ss.android.lark.coremd.base.parse.g
    public final void a(com.ss.android.lark.coremd.impl.parse.l.a r3) {
        Intrinsics.checkNotNullParameter(r3, "builder");
        Iterator<T> r0 = e().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((g) r0.next()).a(r3);
        goto L4
    }

    @Override // com.ss.android.lark.coremd.base.parse.g
    public final void b(com.ss.android.lark.coremd.impl.parse.g r3) {
        Intrinsics.checkNotNullParameter(r3, "registry");
        Iterator<T> r0 = e().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((g) r0.next()).b(r3);
        goto L4
    }

    @Override // com.ss.android.lark.coremd.base.parse.g
    public final void c(com.ss.android.lark.coremd.impl.parse.j.a r3) {
        Intrinsics.checkNotNullParameter(r3, "builder");
        Iterator<T> r0 = e().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((g) r0.next()).c(r3);
        goto L4
    }

    @Override // com.ss.android.lark.coremd.base.parse.g
    public final void d(com.ss.android.lark.coremd.impl.parse.c r3) {
        Intrinsics.checkNotNullParameter(r3, "registry");
        Iterator<T> r0 = e().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((g) r0.next()).d(r3);
        goto L4
    }
}
