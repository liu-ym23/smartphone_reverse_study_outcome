package gu;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f17227a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f17228b;

    public c(int r5, Integer r10) {
        this.f17227a = r5;
        this.f17228b = r10;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c) == true) goto L8;
        return false;
    L8:
        c r10 = (c) r5;
        int r11 = r10.f17227a;
        if (this.f17227a == r11) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(null, null) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f17228b, r10.f17228b) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r5 = Integer.hashCode(this.f17227a) * 961;
        return this.f17228b.hashCode() + r5;
    }

    public final String toString() {
        return "CustomLayout(layoutId=" + this.f17227a + ", previewId=null, addBottom=" + this.f17228b + ")";
    }
}
