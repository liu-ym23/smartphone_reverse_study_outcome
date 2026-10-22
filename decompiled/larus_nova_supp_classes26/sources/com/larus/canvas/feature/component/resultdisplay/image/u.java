package com.larus.canvas.feature.component.resultdisplay.image;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class u implements com.larus.canvas.feature.component.base.d {
    public final List<y> a;
    public final v b;

    public u() {
        this(0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof u) == true) goto L8;
        return false;
    L8:
        u r6 = (u) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public final String toString() {
        return "ImagePagerUIState(pageList=" + this.a + ", saveAction=" + this.b + ')';
    }

    public /* synthetic */ u(int r3) {
        this(CollectionsKt.emptyList(), new v(0));
    }

    public u(List<y> r2, v r3) {
        Intrinsics.checkNotNullParameter(r2, "pageList");
        Intrinsics.checkNotNullParameter(r3, "saveAction");
        this.a = r2;
        this.b = r3;
    }

    public static u a(u r1, List r2, v r3, int r4) {
        if ((r4 & 1) == 0) goto L6;
        r2 = r1.a;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = r1.b;
    L8:
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "pageList");
        Intrinsics.checkNotNullParameter(r3, "saveAction");
        return new u(r2, r3);
    }
}
