package com.obric.oui.orecyclerview.base;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f13709a;

    public c() {
        this.f13709a = 0.998f;
    }

    public final float a() {
        if (Math.abs(0.0f) >= 0.099999994f) goto L6;
        return 0.0f;
    L6:
        return b(((float) Math.log(0.099999994f / Math.abs(0.0f))) / ((float) Math.log(this.f13709a)));
    }

    public final float b(float r10) {
        double r5 = this.f13709a;
        return (((((float) Math.pow(r5, r10)) - 1.0f) * ((1.0f / ((float) Math.log(r5))) * 0.0f)) * 1.1111112f) + 0.0f;
    }

    public final b c(float r5) {
        float r10 = 0.0f * ((float) Math.pow(this.f13709a, r5));
        float r11 = b(r5);
        if (Math.abs(r10) >= 0.099999994f) goto L5;
        boolean r12 = true;
    L7:
        return new b(r11, r10, r12);
    L5:
        r12 = false;
        goto L7
    }
}
