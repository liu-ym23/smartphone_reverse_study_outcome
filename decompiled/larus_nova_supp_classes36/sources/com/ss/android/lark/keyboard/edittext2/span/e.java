package com.ss.android.lark.keyboard.edittext2.span;

import com.ss.android.lark.utils.UIHelper;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e {
    public final int a;
    public final int b;
    public final int c;

    public e() {
        this(0, 0, 7);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof e) == true) goto L8;
        return false;
    L8:
        e r6 = (e) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.a * 31) + this.b) * 31) + this.c;
    }

    public final String toString() {
        return "IconTitleStyle(iconSize=" + this.a + ", iconColor=" + this.b + ", textColor=" + this.c + ')';
    }

    public e(int r3, int r4, int r5) {
        if ((r5 & 1) == 0) goto L6;
        r3 = UIHelper.dp2px(14.0f);
    L6:
        if ((r5 & 2) == 0) goto L9;
        r4 = UIHelper.getColor(2131106616);
    L9:
        if ((r5 & 4) == 0) goto L11;
        int r6 = UIHelper.getColor(2131106616);
    L12:
        this.a = r3;
        this.b = r4;
        this.c = r6;
        return;
    L11:
        r6 = 0;
        goto L12
    }
}
