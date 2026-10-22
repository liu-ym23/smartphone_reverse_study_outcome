package com.larus.bmhome.utils;

import com.larus.bmhome.social.page.datasource.event.c;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import xc8.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class j3 {
    public static final c<b> h = null;
    public final s0 a;
    public c<b> b;
    public Function1<? super c<b>, Unit> c;
    public float d;
    public float e;
    public c<b> f;
    public long g;

    public static final class a {
    }

    public j3() {
        throw null;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof j3) == true) goto L8;
        return false;
    L8:
        j3 r6 = (j3) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Float.compare(this.d, r6.d) == 0) goto L21;
        return false;
    L21:
        if (Float.compare(this.e, r6.e) == 0) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        return (((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + Float.floatToIntBits(this.d)) * 31) + Float.floatToIntBits(this.e);
    }

    public final String toString() {
        return "RecoverTask(toppingStrategy=" + this.a + ", updateEvent=" + this.b + ", recoverAction=" + this.c + ", startY=" + this.d + ", endY=" + this.e + ')';
    }

    static {
        h = new c(CollectionsKt.emptyList(), 0, CollectionsKt.emptyList());
    }

    public final void a() {
        c<b> r0 = this.b;
        this.c.invoke(r0);
        this.c = new i3();
        this.b = h;
    }

    public j3(d2 r4) {
        c<b> r0 = h;
        Function1<? super c<b>, Unit> r1 = new h3();
        Intrinsics.checkNotNullParameter(r4, "toppingStrategy");
        Intrinsics.checkNotNullParameter(r0, "updateEvent");
        Intrinsics.checkNotNullParameter(r1, "recoverAction");
        this.a = r4;
        this.b = r0;
        this.c = r1;
        this.d = 0.0f;
        this.e = 0.0f;
        this.f = r0;
    }
}
