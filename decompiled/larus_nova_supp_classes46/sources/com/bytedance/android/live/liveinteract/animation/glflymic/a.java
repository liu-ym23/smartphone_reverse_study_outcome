package com.bytedance.android.live.liveinteract.animation.glflymic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    public final float a;
    public final float b;
    public final float c;
    public final float d;
    public final float e;
    public final float f;

    public final float[] a(float r5, float r6) {
        float[] r0 = {0.0f, 0.0f};
        float r7 = (((r5 - this.c) * 2.0f) / this.a) - 1.0f;
        float r2 = 1.0f - (((r6 - this.d) * 2.0f) / this.b);
        r0[0] = r7 * (this.e / 2.0f);
        r0[1] = r2 * (this.f / 2.0f);
        return r0;
    }

    public a(float r1, float r2, float r3) {
        this.a = r1;
        this.b = r2;
        this.c = 0.0f;
        this.d = 0.0f;
        this.e = 375.0f;
        this.f = r3;
    }
}
