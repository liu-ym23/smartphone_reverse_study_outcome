package a0;

import android.graphics.Insets;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final b f3e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f4a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f5b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f6c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f7d;

    public static class a {
        public static Insets a(int r8, int r10, int r11, int r12) {
            return Insets.of(r8, r10, r11, r12);
        }
    }

    static {
        f3e = new b(0, 0, 0, 0);
    }

    public b(int r8, int r10, int r11, int r12) {
        this.f4a = r8;
        this.f5b = r10;
        this.f6c = r11;
        this.f7d = r12;
    }

    public static b a(b r8, b r10) {
        return b(Math.max(r8.f4a, r10.f4a), Math.max(r8.f5b, r10.f5b), Math.max(r8.f6c, r10.f6c), Math.max(r8.f7d, r10.f7d));
    }

    public static b b(int r8, int r10, int r11, int r12) {
        if (r8 != 0) goto L9;
        if (r10 != 0) goto L9;
        if (r11 != 0) goto L9;
        if (r12 != 0) goto L9;
        return f3e;
    L9:
        return new b(r8, r10, r11, r12);
    }

    public static b c(Insets r8) {
        return b(r8.left, r8.top, r8.right, r8.bottom);
    }

    public final Insets d() {
        int r8 = this.f6c;
        int r10 = this.f7d;
        return a.a(this.f4a, this.f5b, r8, r10);
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if (r8 != null) goto L8;
    L23:
        return false;
    L8:
        if (b.class != r8.getClass()) goto L23;
        b r10 = (b) r8;
        if (this.f7d == r10.f7d) goto L14;
        return false;
    L14:
        if (this.f4a == r10.f4a) goto L17;
        return false;
    L17:
        if (this.f6c == r10.f6c) goto L20;
        return false;
    L20:
        if (this.f5b == r10.f5b) goto L22;
        return false;
    L22:
        return true;
    }

    public final int hashCode() {
        return (((((this.f4a * 31) + this.f5b) * 31) + this.f6c) * 31) + this.f7d;
    }

    public final String toString() {
        StringBuilder r8 = new StringBuilder("Insets{left=");
        r8.append(this.f4a);
        r8.append(", top=");
        r8.append(this.f5b);
        r8.append(", right=");
        r8.append(this.f6c);
        r8.append(", bottom=");
        return android.aimedia.a.f(r8, this.f7d, '}');
    }
}
