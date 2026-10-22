package com.larus.bmhome.upload.sdk.impl.engine;

import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {
    public final List<c> a;

    /* JADX WARN: Multi-variable type inference failed */
    public a(List<? extends c> r2) {
        Intrinsics.checkNotNullParameter(r2, "engines");
        this.a = r2;
    }

    public final c a(is8.a r4) {
        Intrinsics.checkNotNullParameter(r4, "route");
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Object r1 = r0.next();
        if (((c) r1).a(r4) == false) goto L4;
    L10:
        return (c) r1;
    L8:
        r1 = null;
        goto L10
    }
}
