package com.google.android.material.shape;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public class k extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    float f3643a;

    public k() {
        this.f3643a = -1.0f;
    }

    @Override // com.google.android.material.shape.d
    public void a(@NonNull n r10, float r11, float r12, float r13) {
        r10.o(0.0f, r13 * r12, 180.0f, 180.0f - r11);
        float r14 = (r13 * 2.0f) * r12;
        r10.a(0.0f, 0.0f, r14, r14, 180.0f, r11);
    }
}
