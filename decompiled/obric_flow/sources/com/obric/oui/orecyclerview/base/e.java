package com.obric.oui.orecyclerview.base;

/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f13712a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f13713b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f13714c;

    public void a(float r5, float r10) {
        this.f13714c = 10.927279f;
        this.f13712a = r10;
        float r11 = 10.927279f * r10;
        this.f13713b = r11 + (r5 * 1000.0f);
    }

    public d b(float r10) {
        float r11 = r10 / 1000.0f;
        float r5 = ((this.f13713b * r11) + this.f13712a) * ((float) Math.exp((-this.f13714c) * r11));
        float r12 = this.f13713b;
        float r13 = this.f13714c;
        float r14 = (r12 - (((r12 * r11) + this.f13712a) * r13)) * ((float) Math.exp((-r13) * r11));
        if (Math.abs(r5) >= 0.1f) goto L8;
        if ((Math.abs(r14) / 1000.0f) >= 0.01f) goto L8;
        return new d(0.0f, true);
    L8:
        return new d(r5, false);
    }
}
