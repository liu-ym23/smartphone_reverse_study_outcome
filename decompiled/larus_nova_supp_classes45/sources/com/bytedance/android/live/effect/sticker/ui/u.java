package com.bytedance.android.live.effect.sticker.ui;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class u {
    public final int a;
    public final int b;
    public final int c;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof u) == false) goto L12;
        u r4 = (u) r3;
        if (this.a == r4.a) goto L8;
        return false;
    L8:
        if (this.b == r4.b) goto L10;
        return false;
    L10:
        if (this.c == r4.c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        return (((this.a * 31) + this.b) * 31) + this.c;
    }

    public final String toString() {
        return "TabIconData(unselectedDrawableRes=" + this.a + ", selectedDrawableRes=" + this.b + ", descriptionRes=" + this.c + ")";
    }

    public u() {
        this.a = 2131250507;
        this.b = 2131250506;
        this.c = 2131916354;
    }
}
