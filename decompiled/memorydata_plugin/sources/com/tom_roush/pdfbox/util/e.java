package com.tom_roush.pdfbox.util;

/* JADX INFO: loaded from: classes6.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f16303a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f16304b;

    public e(float r1, float r2) {
        this.f16303a = r1;
        this.f16304b = r2;
    }

    public float a() {
        return this.f16303a;
    }

    public e a(float r3) {
        return new e(this.f16303a * r3, this.f16304b * r3);
    }

    public float b() {
        return this.f16304b;
    }

    public String toString() {
        return "(" + this.f16303a + ", " + this.f16304b + ")";
    }
}
