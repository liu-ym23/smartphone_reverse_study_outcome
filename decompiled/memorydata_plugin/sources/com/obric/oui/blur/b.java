package com.obric.oui.blur;

/* JADX INFO: loaded from: classes5.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f13344a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f13345b;
    private float c;
    private int d;
    private float e;

    public b() {
        this(0.0f, 0, 1.0f, 0, 1.0f);
    }

    public b(float r1, int r2, float r3, int r4, float r5) {
        this.f13344a = r1;
        this.f13345b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    public static b a(b r7) {
        if (r7 != null) goto L6;
        return null;
    L6:
        return new b(r7.f13344a, r7.f13345b, r7.c, r7.d, r7.e);
    }

    public float a() {
        return this.f13344a;
    }

    public int b() {
        return this.f13345b;
    }

    public float c() {
        return this.c;
    }

    public int d() {
        return this.d;
    }

    public float e() {
        return this.e;
    }

    public b f() {
        return a(this);
    }
}
