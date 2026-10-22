package qs;

import ai.j0;
import android.graphics.Insets;

/* JADX INFO: loaded from: classes3.dex */
public final class b {
    public static final b e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f21565a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f21566b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f21567c;
    public final int d;

    static {
        e = new b(0, 0, 0, 0);
    }

    public b(int r5, int r10, int r11, int r12) {
        this.f21565a = r5;
        this.f21566b = r10;
        this.f21567c = r11;
        this.d = r12;
    }

    public static b a(int r5, int r10, int r11, int r12) {
        if (r5 != 0) goto L9;
        if (r10 != 0) goto L9;
        if (r11 != 0) goto L9;
        if (r12 != 0) goto L9;
        return e;
    L9:
        return new b(r5, r10, r11, r12);
    }

    public static b b(Insets r5) {
        return a(r5.left, r5.top, r5.right, r5.bottom);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L23:
        return false;
    L8:
        if (b.class != r5.getClass()) goto L23;
        b r10 = (b) r5;
        if (this.d == r10.d) goto L14;
        return false;
    L14:
        if (this.f21565a == r10.f21565a) goto L17;
        return false;
    L17:
        if (this.f21567c == r10.f21567c) goto L20;
        return false;
    L20:
        if (this.f21566b == r10.f21566b) goto L22;
        return false;
    L22:
        return true;
    }

    public final int hashCode() {
        return (((((this.f21565a * 31) + this.f21566b) * 31) + this.f21567c) * 31) + this.d;
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("Insets{left=");
        r5.append(this.f21565a);
        r5.append(", top=");
        r5.append(this.f21566b);
        r5.append(", right=");
        r5.append(this.f21567c);
        r5.append(", bottom=");
        return j0.n(r5, this.d, '}');
    }
}
