package com.bytedance.android.bcm.impl.paramcheck;

import com.bytedance.android.bcm.impl.model.f;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public final List<f> a;
    public final String b;

    public a() {
        this(null);
    }

    public a(Object r1) {
        this.a = CollectionsKt.emptyList();
        this.b = null;
    }

    public final f a(String r10) {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Object r1 = r0.next();
        if (Intrinsics.areEqual(((f) r1).a(), r10) == false) goto L4;
    L10:
        return (f) r1;
    L8:
        r1 = null;
        goto L10
    }
}
