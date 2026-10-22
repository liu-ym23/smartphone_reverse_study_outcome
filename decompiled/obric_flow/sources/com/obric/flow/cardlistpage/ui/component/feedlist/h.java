package com.obric.flow.cardlistpage.ui.component.feedlist;

/* JADX INFO: loaded from: classes3.dex */
public final class h extends o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f11584a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f11585b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f11586c;
    public final int d;

    public h(int r5, int r10, int r11, int r12) {
        this.f11584a = r5;
        this.f11585b = r10;
        this.f11586c = r11;
        this.d = r12;
    }

    @Override // com.obric.flow.cardlistpage.mvi.e
    public final String a() {
        return androidx.constraintlayout.motion.widget.a.s(new StringBuilder("AddWidgetFromPicker(widgetId="), this.f11584a, ")");
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof h) == true) goto L8;
        return false;
    L8:
        h r10 = (h) r5;
        int r11 = r10.f11584a;
        if (this.f11584a == r11) goto L12;
        return false;
    L12:
        if (this.f11585b == r10.f11585b) goto L15;
        return false;
    L15:
        if (this.f11586c == r10.f11586c) goto L18;
        return false;
    L18:
        if (this.d == r10.d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r5 = Integer.hashCode(this.f11584a) * 31;
        int r10 = androidx.room.jarjarred.org.antlr.runtime.a.c(this.f11585b, r5, 31);
        int r11 = androidx.room.jarjarred.org.antlr.runtime.a.c(this.f11586c, r10, 31);
        return Integer.hashCode(this.d) + r11;
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("AddWidgetFromPicker(widgetId=");
        r5.append(this.f11584a);
        r5.append(", cellWidth=");
        r5.append(this.f11585b);
        r5.append(", cellHeight=");
        r5.append(this.f11586c);
        r5.append(", spacingY=");
        return androidx.constraintlayout.motion.widget.a.s(r5, this.d, ")");
    }
}
