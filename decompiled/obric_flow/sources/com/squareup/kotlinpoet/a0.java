package com.squareup.kotlinpoet;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f15075a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ym.d f15076b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f15077c;
    public final Lazy d;

    public a0(boolean r5, List r10, ym.d r11) {
        this.f15075a = r5;
        this.f15076b = r11;
        this.f15077c = f0.i(r10);
        this.d = LazyKt.lazy(new TypeName$cachedString$2(this));
    }

    public static a0 b(a0 r5, boolean r10, List r11, int r12) {
        if ((r12 & 1) == 0) goto L6;
        r10 = r5.f15075a;
    L6:
        if ((r12 & 2) == 0) goto L8;
        r11 = CollectionsKt.toList(r5.f15077c);
    L8:
        r5.getClass();
        Intrinsics.checkNotNullParameter(r11, "annotations");
        return r5.a((Map) r5.f15076b.f23297a, r10, r11);
    }

    public abstract a0 a(Map r5, boolean r10, List r11);

    public abstract f c(f r5);

    public final void d(f r5) {
        Intrinsics.checkNotNullParameter(r5, "out");
        Iterator r10 = this.f15077c.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        ((b) r10.next()).a(r5, true, false);
        r5.b(" ", false);
        goto L4
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(getClass(), r5.getClass()) == true) goto L12;
        return false;
    L12:
        return Intrinsics.areEqual(toString(), r5.toString());
    }

    public final int hashCode() {
        return toString().hashCode();
    }

    public final String toString() {
        return (String) this.d.getValue();
    }
}
