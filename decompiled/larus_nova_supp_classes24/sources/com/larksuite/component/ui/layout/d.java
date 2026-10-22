package com.larksuite.component.ui.layout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class d {
    public int a;
    public int b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof d) == true) goto L8;
        return false;
    L8:
        d r6 = (d) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.a * 31) + this.b;
    }

    public final String toString() {
        return "OnMeasureData(widthMeasureSpec=" + this.a + ", heightMeasureSpec=" + this.b + ')';
    }

    public d() {
        this.a = 0;
        this.b = 0;
    }
}
