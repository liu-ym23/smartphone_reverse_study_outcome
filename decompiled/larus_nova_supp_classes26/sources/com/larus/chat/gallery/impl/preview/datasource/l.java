package com.larus.chat.gallery.impl.preview.datasource;

import com.larus.chat.gallery.impl.preview.data.SourceType;
import com.larus.gallery.api.GalleryType;
import com.larus.gallery.api.IGalleryDataSource;
import com.larus.gallery.api.b0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class l implements IGalleryDataSource<xy8.d> {
    public final SourceType a;
    public final List<xy8.d> b;

    public final boolean b() {
        return false;
    }

    public final boolean h() {
        return false;
    }

    public final int k() {
        return 0;
    }

    public final Object c(Continuation<? super b0<? extends List<xy8.d>>> r3) {
        return new b0.b(this.b, false, false);
    }

    public l(List<com.larus.chat.gallery.api.o> r3, SourceType r4) {
        Intrinsics.checkNotNullParameter(r3, "items");
        Intrinsics.checkNotNullParameter(r4, "sourceType");
        this.a = r4;
        List<com.larus.chat.gallery.api.o> r5 = r3;
        ArrayList r6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator<T> r7 = r5.iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        r6.add(m.a((com.larus.chat.gallery.api.o) r7.next(), this.a));
        goto L4
    L6:
        this.b = r6;
    }

    public final Object d(Object r1, Continuation r2) {
        xy8.d r3 = (xy8.d) r1;
        return IGalleryDataSource.DefaultImpls.a();
    }

    public final Object e(List<xy8.d> r1, Continuation<? super List<Pair<xy8.d, com.larus.gallery.api.k>>> r2) {
        return IGalleryDataSource.DefaultImpls.c(this, r1, r2);
    }

    public final Object f(Object r1, Continuation r2) {
        return (xy8.d) r1;
    }

    public final Object g(Object r1, Continuation r2) {
        xy8.d r3 = (xy8.d) r1;
        return IGalleryDataSource.DefaultImpls.b();
    }

    public final Object i(Object r27, Continuation r28) {
        xy8.d r0 = (xy8.d) r27;
        GalleryType r2 = r0.e;
        xy8.b r1 = r0.c;
        if (r1 == null) goto L5;
        com.larus.gallery.api.m r13 = new com.larus.gallery.api.m(r1.a, r1.b, Boxing.boxInt(r1.i), Boxing.boxInt(r1.j), null, null, null, 496);
    L6:
        xy8.g r3 = r0.d;
        if (r3 == null) goto L9;
        String r5 = r3.a;
        String r4 = r3.b;
        String r6 = r3.f;
        String r7 = r3.p;
        double r8 = r3.l;
        String r9 = r3.d;
        com.larus.gallery.api.q r10 = new com.larus.gallery.api.q(r5, new nr9.g(r5, null, r4, null, Boxing.boxDouble(r8), null, new nr9.f(r9, r9, null, Boxing.boxInt(r3.k), Boxing.boxInt(r3.j), null, 36), r6, null, r7, 298), 0, null, null, 60);
    L11:
        return new com.larus.gallery.api.k(r2, r13, r10, null, null, 24);
    L9:
        r10 = null;
        goto L11
    L5:
        r13 = null;
        goto L6
    }

    public final boolean j(Object r1, Object r2) {
        return Intrinsics.areEqual((xy8.d) r1, (xy8.d) r2);
    }
}
