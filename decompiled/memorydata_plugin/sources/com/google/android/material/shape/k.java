package com.google.android.material.shape;

/* JADX INFO: loaded from: classes2.dex */
public class k extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    float f4048a;

    public k() {
        this.f4048a = -1.0f;
    }

    @Override // com.google.android.material.shape.d
    public void a(n r8, float r9, float r10, float r11) {
        r8.a(0.0f, r11 * r10, 180.0f, 180.0f - r9);
        float r4 = (r11 * 2.0f) * r10;
        r8.a(0.0f, 0.0f, r4, r4, 180.0f, r9);
    }
}
