package com.larus.dora.impl.ota.g2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class g2 implements Function1 {
    public final /* synthetic */ c5 a;

    public /* synthetic */ g2(c5 r1) {
        this.a = r1;
    }

    public final Object invoke(Object r22) {
        c5 r1 = this.a;
        f r2 = (f) r22;
        Intrinsics.checkNotNullParameter(r2, "it");
        List r11 = r2.k();
        ArrayList r15 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r11, 10));
        Iterator r12 = r11.iterator();
    L4:
        if (r12.hasNext() == false) goto L10;
        c5 r13 = (c5) r12.next();
        if (r13.b() != r1.b()) goto L8;
        r13 = c5.a(r13, 0);
    L8:
        r15.add(r13);
        goto L4
    L10:
        return f.a(r2, null, null, null, null, null, null, null, null, r15, null, null, null, null, null, null, null, null, 261631);
    }
}
