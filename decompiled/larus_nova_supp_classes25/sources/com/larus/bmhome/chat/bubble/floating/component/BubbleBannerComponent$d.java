package com.larus.bmhome.chat.bubble.floating.component;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class BubbleBannerComponent$d {
    public final boolean a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;

    public /* synthetic */ BubbleBannerComponent$d() {
        this(false, -1, 0, -1, 0, 0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof BubbleBannerComponent$d) == true) goto L8;
        return false;
    L8:
        BubbleBannerComponent$d r6 = (BubbleBannerComponent$d) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        if (this.a == false) goto L5;
        int r0 = 1231;
    L7:
        return (((((((((r0 * 31) + this.b) * 31) + this.c) * 31) + this.d) * 31) + this.e) * 31) + this.f;
    L5:
        r0 = 1237;
        goto L7
    }

    public final String toString() {
        return "HostLayoutSnapshot(canHostBanner=" + this.a + ", bottomAnchorId=" + this.b + ", bottomAnchorTop=" + this.c + ", widthAnchorId=" + this.d + ", widthAnchorLeft=" + this.e + ", widthAnchorWidth=" + this.f + ')';
    }

    public BubbleBannerComponent$d(boolean r1, int r2, int r3, int r4, int r5, int r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
