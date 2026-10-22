package com.google.android.material.shape;

/* JADX INFO: loaded from: classes2.dex */
public final class g extends f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f4044a;

    public g(float r2) {
        this.f4044a = r2 - 0.001f;
    }

    @Override // com.google.android.material.shape.f
    public void a(float r9, float r10, float r11, n r12) {
        float r13 = (float) ((((double) this.f4044a) * Math.sqrt(2.0d)) / 2.0d);
        float r14 = (float) Math.sqrt(Math.pow(this.f4044a, 2.0d) - Math.pow(r13, 2.0d));
        r12.a(r10 - r13, ((float) (-((((double) this.f4044a) * Math.sqrt(2.0d)) - ((double) this.f4044a)))) + r14);
        r12.b(r10, (float) (-((((double) this.f4044a) * Math.sqrt(2.0d)) - ((double) this.f4044a))));
        r12.b(r10 + r13, ((float) (-((((double) this.f4044a) * Math.sqrt(2.0d)) - ((double) this.f4044a)))) + r14);
    }

    @Override // com.google.android.material.shape.f
    boolean g() {
        return true;
    }
}
