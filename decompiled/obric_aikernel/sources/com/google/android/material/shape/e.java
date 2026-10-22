package com.google.android.material.shape;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public class e extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    float f3638a;

    public e() {
        this.f3638a = -1.0f;
    }

    @Override // com.google.android.material.shape.d
    public void a(@NonNull n r10, float r11, float r12, float r13) {
        r10.o(0.0f, r13 * r12, 180.0f, 180.0f - r11);
        double r14 = r13;
        double r15 = r12;
        r10.m((float) ((Math.sin(Math.toRadians(r11)) * r14) * r15), (float) ((Math.sin(Math.toRadians(90.0f - r11)) * r14) * r15));
    }
}
