package com.obric.oui.view;

import android.graphics.Insets;
import android.graphics.Rect;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes5.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f14818a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f14819b;
    public final int c;
    public final int d;
    public final int e;

    static {
        f14818a = new b(0, 0, 0, 0);
    }

    private b(int r1, int r2, int r3, int r4) {
        this.f14819b = r1;
        this.c = r2;
        this.d = r3;
        this.e = r4;
    }

    public static b a(int r1, int r2, int r3, int r4) {
        if (r1 != 0) goto L9;
        if (r2 != 0) goto L9;
        if (r3 != 0) goto L9;
        if (r4 != 0) goto L9;
        return f14818a;
    L9:
        return new b(r1, r2, r3, r4);
    }

    public static b a(Insets r3) {
        return a(r3.left, r3.top, r3.right, r3.bottom);
    }

    public static b a(Rect r3) {
        return a(r3.left, r3.top, r3.right, r3.bottom);
    }

    public static b a(b r4, b r5) {
        return a(Math.max(r4.f14819b, r5.f14819b), Math.max(r4.c, r5.c), Math.max(r4.d, r5.d), Math.max(r4.e, r5.e));
    }

    public Insets a() {
        return Insets.of(this.f14819b, this.c, this.d, this.e);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L23:
        return false;
    L8:
        if (getClass() != r5.getClass()) goto L23;
        b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin");
        if (this.e == r6.e) goto L14;
        return false;
    L14:
        if (this.f14819b == r6.f14819b) goto L17;
        return false;
    L17:
        if (this.d == r6.d) goto L20;
        return false;
    L20:
        if (this.c == r6.c) goto L22;
        return false;
    L22:
        return true;
    }

    public int hashCode() {
        return (((((this.f14819b * 31) + this.c) * 31) + this.d) * 31) + this.e;
    }

    public String toString() {
        return "Insets{left=" + this.f14819b + ", top=" + this.c + ", right=" + this.d + ", bottom=" + this.e + '}';
    }
}
