package com.google.android.material.shape;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public final class g extends f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f3639a;

    public g(float r10) {
        this.f3639a = r10 - 0.001f;
    }

    @Override // com.google.android.material.shape.f
    boolean b() {
        return true;
    }

    @Override // com.google.android.material.shape.f
    public void d(float r10, float r11, float r12, @NonNull n r13) {
        float r14 = (float) ((((double) this.f3639a) * Math.sqrt(2.0d)) / 2.0d);
        float r15 = (float) Math.sqrt(Math.pow(this.f3639a, 2.0d) - Math.pow(r14, 2.0d));
        r13.n(r11 - r14, ((float) (-((((double) this.f3639a) * Math.sqrt(2.0d)) - ((double) this.f3639a)))) + r15);
        r13.m(r11, (float) (-((((double) this.f3639a) * Math.sqrt(2.0d)) - ((double) this.f3639a))));
        r13.m(r11 + r14, ((float) (-((((double) this.f3639a) * Math.sqrt(2.0d)) - ((double) this.f3639a)))) + r15);
    }
}
