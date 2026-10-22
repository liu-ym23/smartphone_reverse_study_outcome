package vc0;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    public final Object a;
    public final Object b;

    public a(Object r2) {
        Intrinsics.checkNotNullParameter(r2, "obj");
        this.b = r2;
        if ((r2 instanceof xh6.c) == false) goto L5;
        r2 = ((xh6.c) r2).getReal();
    L5:
        this.a = r2;
    }
}
