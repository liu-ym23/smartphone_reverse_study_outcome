package com.obric.oui.constraintlayout.motion.widget;

/* JADX INFO: loaded from: classes3.dex */
public final class u extends r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f12897a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f12898b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f12899c;
    public final /* synthetic */ MotionLayout d;

    public u(MotionLayout r5) {
        this.d = r5;
        this.f12897a = 0.0f;
        this.f12898b = 0.0f;
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.r
    public final float a() {
        return this.d.f12681t;
    }

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float r10) {
        float r5 = this.f12897a;
        MotionLayout r11 = this.d;
        if (r5 <= 0.0f) goto L9;
        float r12 = this.f12899c;
        if ((r5 / r12) >= r10) goto L7;
        r10 = r5 / r12;
    L7:
        r11.f12681t = r5 - (r12 * r10);
        return ((r5 * r10) - (((r12 * r10) * r10) / 2.0f)) + this.f12898b;
    L9:
        float r13 = this.f12899c;
        if (((-r5) / r13) >= r10) goto L12;
        r10 = (-r5) / r13;
    L12:
        r11.f12681t = (r13 * r10) + r5;
        float r14 = ((r13 * r10) * r10) / 2.0f;
        return (r14 + (r5 * r10)) + this.f12898b;
    }
}
