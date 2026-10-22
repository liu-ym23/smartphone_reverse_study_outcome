package com.obric.flow.cardlistpage.ui.component.popupdialog;

import com.obric.flow.cardlistpage.mvi.MviLogLevel;

/* JADX INFO: loaded from: classes3.dex */
public final class g implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f11730a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f11731b;

    public g(int r5, boolean r10) {
        this.f11730a = r5;
        this.f11731b = r10;
    }

    @Override // com.obric.flow.cardlistpage.mvi.f
    public final String a() {
        return toString();
    }

    @Override // com.obric.flow.cardlistpage.mvi.f
    public final MviLogLevel b() {
        return MviLogLevel.INFO;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof g) == true) goto L8;
        return false;
    L8:
        g r10 = (g) r5;
        int r11 = r10.f11730a;
        if (this.f11730a == r11) goto L12;
        return false;
    L12:
        if (this.f11731b == r10.f11731b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r5 = Integer.hashCode(this.f11730a) * 31;
        return Boolean.hashCode(this.f11731b) + r5;
    }

    public final String toString() {
        return "OnConfigClick(appWidgetId=" + this.f11730a + ", isCustomClock=" + this.f11731b + ")";
    }
}
