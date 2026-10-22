package com.squareup.kotlinpoet;

import androidx.room.jarjarred.org.antlr.v4.runtime.tree.xpath.XPath;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class g0 extends a0 {
    public final List e;
    public final List f;

    public /* synthetic */ g0(List r10, List r11) {
        this(r10, r11, false, CollectionsKt.emptyList(), MapsKt.emptyMap());
    }

    @Override // com.squareup.kotlinpoet.a0
    public final a0 a(Map r10, boolean r11, List r12) {
        Intrinsics.checkNotNullParameter(r12, "annotations");
        Intrinsics.checkNotNullParameter(r10, "tags");
        return new g0(this.e, this.f, r11, r12, r10);
    }

    @Override // com.squareup.kotlinpoet.a0
    public final f c(f r5) {
        Intrinsics.checkNotNullParameter(r5, "out");
        List r10 = this.f;
        if (r10.size() != 1) goto L5;
        r5.e("in·%T", new Object[]{r10.get(0)});
    L9:
        return r5;
    L5:
        List r11 = b0.f15099y.e;
        List r12 = this.e;
        if (Intrinsics.areEqual(r12, r11) == false) goto L8;
        r5.b(XPath.WILDCARD, false);
        goto L9
    L8:
        r5.e("out·%T", new Object[]{r12.get(0)});
        goto L9
    }

    public g0(List r5, List r10, boolean r11, List r12, Map r13) {
        super(r11, r12, new ym.d(r13));
        List r14 = f0.i(r5);
        this.e = r14;
        this.f = f0.i(r10);
        if (r14.size() != 1) goto L6;
        return;
    L6:
        throw new IllegalArgumentException(("unexpected out types: " + r5).toString());
    }
}
