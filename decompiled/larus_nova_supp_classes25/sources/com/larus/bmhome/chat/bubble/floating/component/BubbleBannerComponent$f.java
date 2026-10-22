package com.larus.bmhome.chat.bubble.floating.component;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class BubbleBannerComponent$f {
    public final int a;

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof BubbleBannerComponent$f) == true) goto L9;
        return false;
    L9:
        if (this.a == ((BubbleBannerComponent$f) r4).a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.a;
    }

    public final String toString() {
        return "SwipeDismissConfig(touchSlop=" + this.a + ')';
    }

    public BubbleBannerComponent$f(int r1) {
        this.a = r1;
    }
}
