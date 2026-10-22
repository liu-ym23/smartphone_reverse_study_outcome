package com.squareup.kotlinpoet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class e0 extends a0 {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final List f15133i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final c f15134j = null;
    public final String e;
    public final List f;
    public final KModifier g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f15135h;

    static {
        f15133i = CollectionsKt.listOf(g.f15152b);
        f15134j = new c("java.lang", new String[]{"Object"});
    }

    public /* synthetic */ e0(String r10, List r11, KModifier r12, int r13) {
        if ((r13 & 4) == 0) goto L5;
        r12 = null;
    L5:
        this(r10, r11, r12, false, false, CollectionsKt.emptyList(), MapsKt.emptyMap());
    }

    @Override // com.squareup.kotlinpoet.a0
    public final a0 a(Map r12, boolean r13, List r14) {
        Intrinsics.checkNotNullParameter(r14, "annotations");
        Intrinsics.checkNotNullParameter(r12, "tags");
        Intrinsics.checkNotNullParameter(r14, "annotations");
        List r5 = this.f;
        Intrinsics.checkNotNullParameter(r5, "bounds");
        Intrinsics.checkNotNullParameter(r12, "tags");
        if (r5.size() != 1) goto L5;
        List r10 = r5;
    L12:
        String r11 = this.e;
        boolean r15 = this.f15135h;
        return new e0(r11, r10, this.g, r15, r13, r14, r12);
    L5:
        ArrayList r16 = new ArrayList();
        Iterator r17 = r5.iterator();
    L7:
        if (r17.hasNext() == false) goto L11;
        Object r18 = r17.next();
        if (Intrinsics.areEqual((a0) r18, g.f15152b) == true) goto L7;
        r16.add(r18);
        goto L7
    L11:
        r10 = r16;
        goto L12
    }

    @Override // com.squareup.kotlinpoet.a0
    public final f c(f r5) {
        Intrinsics.checkNotNullParameter(r5, "out");
        r5.b(this.e, false);
        return r5;
    }

    public e0(String r5, List r10, KModifier r11, boolean r12, boolean r13, List r14, Map r15) {
        super(r13, r14, new ym.d(r15));
        this.e = r5;
        this.f = r10;
        this.g = r11;
        this.f15135h = r12;
    }
}
