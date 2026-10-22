package com.squareup.kotlinpoet;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class u extends a0 {
    public final u e;
    public final c f;
    public final List g;

    public /* synthetic */ u(u r10, c r11, List r12) {
        this(r10, r11, r12, false, CollectionsKt.emptyList(), MapsKt.emptyMap());
    }

    @Override // com.squareup.kotlinpoet.a0
    public final a0 a(Map r10, boolean r11, List r12) {
        Intrinsics.checkNotNullParameter(r12, "annotations");
        Intrinsics.checkNotNullParameter(r10, "tags");
        return new u(this.e, this.f, this.g, r11, r12, r10);
    }

    @Override // com.squareup.kotlinpoet.a0
    public final f c(f r10) {
        Intrinsics.checkNotNullParameter(r10, "out");
        c r5 = this.f;
        u r11 = this.e;
        if (r11 == null) goto L5;
        r11.d(r10);
        r11.c(r10);
        r10.b("." + r5.e(), false);
    L6:
        List r12 = this.g;
        if (r12.isEmpty() == true) goto L22;
        r10.b("<", false);
        Iterator r13 = r12.iterator();
        int r14 = 0;
    L10:
        if (r13.hasNext() == false) goto L21;
        Object r15 = r13.next();
        int r16 = r14 + 1;
        if (r14 >= 0) goto L14;
        CollectionsKt.throwIndexOverflow();
    L14:
        a0 r17 = (a0) r15;
        if (r14 <= 0) goto L17;
        r10.b(",·", false);
    L17:
        r17.d(r10);
        r17.c(r10);
        Intrinsics.checkNotNullParameter(r10, "out");
        if (r17.f15075a == false) goto L20;
        r10.b("?", false);
    L20:
        r14 = r16;
        goto L10
    L21:
        r10.b(">", false);
    L22:
        return r10;
    L5:
        r5.d(r10);
        r5.c(r10);
        goto L6
    }

    public u(u r5, c r10, List r11, boolean r12, List r13, Map r14) {
        Intrinsics.checkNotNullParameter(r10, "rawType");
        Intrinsics.checkNotNullParameter(r11, "typeArguments");
        Intrinsics.checkNotNullParameter(r13, "annotations");
        Intrinsics.checkNotNullParameter(r14, "tags");
        super(r12, r13, new ym.d(r14));
        this.e = r5;
        this.f = r10;
        this.g = f0.i(r11);
        if (r11.isEmpty() == false) goto L8;
        if (r5 == null) goto L7;
        return;
    L7:
        throw new IllegalArgumentException(("no type arguments: " + r10).toString());
    }
}
