package com.obric.oui.indicator;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s f13502a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f13503b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f13504c;

    /* JADX WARN: Multi-variable type inference failed */
    public p(s r5, View r10, g r11) {
        Intrinsics.checkNotNullParameter(r5, "binding");
        Intrinsics.checkNotNullParameter(r10, "view");
        Intrinsics.checkNotNullParameter(r11, "indicator");
        this.f13502a = r5;
        this.f13503b = r10;
        this.f13504c = (View) r11;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof p) == true) goto L8;
        return false;
    L8:
        p r10 = (p) r5;
        s r11 = r10.f13502a;
        if (Intrinsics.areEqual(this.f13502a, r11) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f13503b, r10.f13503b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f13504c, r10.f13504c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r5 = this.f13502a.hashCode() * 31;
        int r10 = (this.f13503b.hashCode() + r5) * 31;
        return this.f13504c.hashCode() + r10;
    }

    public final String toString() {
        return "RenderSlot(binding=" + this.f13502a + ", view=" + this.f13503b + ", indicator=" + this.f13504c + ')';
    }
}
