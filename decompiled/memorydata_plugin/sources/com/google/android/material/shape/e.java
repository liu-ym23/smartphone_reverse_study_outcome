package com.google.android.material.shape;

/* JADX INFO: loaded from: classes2.dex */
public class e extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    float f4043a;

    public e() {
        this.f4043a = -1.0f;
    }

    @Override // com.google.android.material.shape.d
    public void a(n r5, float r6, float r7, float r8) {
        r5.a(0.0f, r8 * r7, 180.0f, 180.0f - r6);
        double r2 = r8;
        double r9 = r7;
        r5.b((float) ((Math.sin(Math.toRadians(r6)) * r2) * r9), (float) ((Math.sin(Math.toRadians(90.0f - r6)) * r2) * r9));
    }
}
