package com.google.android.material.shape;

/* JADX INFO: loaded from: classes2.dex */
public final class i extends f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final f f4045a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f4046b;

    public i(f r1, float r2) {
        this.f4045a = r1;
        this.f4046b = r2;
    }

    @Override // com.google.android.material.shape.f
    public void a(float r2, float r3, float r4, n r5) {
        this.f4045a.a(r2, r3 - this.f4046b, r4, r5);
    }

    @Override // com.google.android.material.shape.f
    boolean g() {
        return this.f4045a.g();
    }
}
