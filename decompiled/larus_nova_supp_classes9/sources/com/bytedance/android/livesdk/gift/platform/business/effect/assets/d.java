package com.bytedance.android.livesdk.gift.platform.business.effect.assets;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d {
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;

    public d() {
        this(0);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof d) == false) goto L16;
        d r4 = (d) r3;
        if (this.a == r4.a) goto L8;
        return false;
    L8:
        if (this.b == r4.b) goto L10;
        return false;
    L10:
        if (this.c == r4.c) goto L12;
        return false;
    L12:
        if (this.d == r4.d) goto L14;
        return false;
    L14:
        if (this.e == r4.e) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        return (((((((this.a * 31) + this.b) * 31) + this.c) * 31) + this.d) * 31) + this.e;
    }

    public final String toString() {
        return "DownloadTypeCount(downloadType1=" + this.a + ", downloadType2=" + this.b + ", downloadType3=" + this.c + ", downloadType4=" + this.d + ", unknow=" + this.e + ")";
    }

    public d(int r1) {
        this.a = 0;
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.e = 0;
    }

    public final void a(int r3) {
        if (r3 != 1) goto L5;
        this.a++;
        return;
    L5:
        if (r3 != 2) goto L7;
        this.b++;
        return;
    L7:
        if (r3 != 3) goto L9;
        this.c++;
        return;
    L9:
        if (r3 == 4) goto L11;
        this.e++;
        return;
    L11:
        this.d++;
    }
}
