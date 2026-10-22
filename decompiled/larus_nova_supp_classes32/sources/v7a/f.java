package v7a;

import android.graphics.Bitmap;
import android.graphics.Rect;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class f {
    public final String a;
    public final int b;
    public final int c;
    public final int d;
    public final Bitmap.Config e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final Map<String, String> i;
    public final Integer j;
    public final boolean k;
    public final List<b> l;
    public final Object m;
    public final boolean n;
    public final boolean o;
    public final boolean p;
    public final boolean q;
    public final boolean r;
    public final boolean s;
    public final float t;
    public final Rect u;
    public final boolean v;

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = ((((r2 * 31) + this.b) * 31) + this.c) * 31;
        Bitmap.Config r4 = this.e;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (((((((((r3 + r5) * 31) + (this.f ? 1 : 0)) * 31) + (this.g ? 1 : 0)) * 31) + (this.h ? 1 : 0)) * 31) + (this.k ? 1 : 0)) * 31;
        List<b> r7 = this.l;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        Rect r10 = this.u;
        if (r10 == null) goto L18;
        r1 = r10.hashCode();
    L18:
        return r9 + r1;
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public f(g r3) {
        this.h = true;
        this.j = null;
        this.o = false;
        this.p = false;
        this.q = false;
        this.r = false;
        this.s = false;
        this.t = 0.0f;
        this.v = true;
        this.a = r3.a;
        this.b = r3.b;
        this.k = r3.j;
        this.j = r3.h;
        this.c = r3.c;
        this.d = r3.d;
        this.e = r3.e;
        this.g = r3.f;
        this.i = r3.g;
        this.l = r3.i;
        this.f = r3.m;
        this.h = r3.l;
        this.m = r3.n;
        this.n = r3.k;
        this.o = r3.o;
        this.v = r3.p;
        this.p = r3.q;
        this.q = r3.r;
        this.r = r3.s;
        this.s = r3.t;
        this.t = r3.u;
        this.u = r3.v;
    }

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if (r4 != null) goto L8;
    L39:
        return false;
    L8:
        if (f.class != r4.getClass()) goto L39;
        f r5 = (f) r4;
        if (this.b == r5.b) goto L14;
        return false;
    L14:
        if (this.c == r5.c) goto L17;
        return false;
    L17:
        if (this.f == r5.f) goto L20;
        return false;
    L20:
        if (this.g == r5.g) goto L23;
        return false;
    L23:
        if (this.h == r5.h) goto L26;
        return false;
    L26:
        if (this.k == r5.k) goto L29;
        return false;
    L29:
        if (Objects.equals(this.a, r5.a) == true) goto L32;
        return false;
    L32:
        if (this.e == r5.e) goto L35;
        return false;
    L35:
        if (Objects.equals(this.u, r5.u) == true) goto L38;
        return false;
    L38:
        return Objects.equals(this.l, r5.l);
    }
}
