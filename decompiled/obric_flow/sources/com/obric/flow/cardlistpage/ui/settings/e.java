package com.obric.flow.cardlistpage.ui.settings;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class e extends f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f11827a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f11828b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f11829c;
    public final Function0 d;

    public e(int r5, int r10, int r11, Function0 r12) {
        Intrinsics.checkNotNullParameter(r12, "onClick");
        super(r12);
        this.f11827a = r5;
        this.f11828b = r10;
        this.f11829c = r11;
        this.d = r12;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof e) == true) goto L8;
        return false;
    L8:
        e r10 = (e) r5;
        int r11 = r10.f11827a;
        if (this.f11827a == r11) goto L12;
        return false;
    L12:
        if (this.f11828b == r10.f11828b) goto L15;
        return false;
    L15:
        if (this.f11829c == r10.f11829c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r10.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r5 = Integer.hashCode(this.f11827a) * 31;
        int r10 = androidx.room.jarjarred.org.antlr.runtime.a.c(this.f11828b, r5, 31);
        int r11 = androidx.room.jarjarred.org.antlr.runtime.a.c(this.f11829c, r10, 31);
        return this.d.hashCode() + r11;
    }

    public final String toString() {
        return "Feature(iconResId=" + this.f11827a + ", titleResId=" + this.f11828b + ", subtitleResId=" + this.f11829c + ", onClick=" + this.d + ")";
    }
}
