package com.larus.dora.impl.ota.g2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class r2 implements Function1 {
    public final /* synthetic */ s$p a;
    public final /* synthetic */ c5 b;

    public /* synthetic */ r2(s$p r1, c5 r2) {
        this.a = r1;
        this.b = r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object invoke(Object r23) {
        s$p r1 = this.a;
        c5 r2 = this.b;
        f r3 = (f) r23;
        Intrinsics.checkNotNullParameter(r3, "it");
        if (r1.d() == false) goto L5;
        ArrayList r12 = CollectionsKt.minus(r3.k(), r2);
    L13:
        return f.a(r3, null, null, null, null, null, null, null, null, r12, null, null, null, null, null, null, null, null, 261631);
    L5:
        List r4 = r3.k();
        r12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));
        Iterator r5 = r4.iterator();
    L7:
        if (r5.hasNext() == false) goto L13;
        c5 r13 = (c5) r5.next();
        if (r13.b() != r1.a()) goto L11;
        r13 = c5.a(r13, r1.c() + 1800000);
    L11:
        r12.add(r13);
        goto L7
    }
}
