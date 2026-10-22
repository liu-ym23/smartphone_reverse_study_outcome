package s0;

import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes.dex */
public abstract class d implements Interpolator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float[] f11944a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f11945b;

    public d(float[] r8) {
        this.f11944a = r8;
        this.f11945b = 1.0f / (r8.length - 1);
    }

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float r8) {
        if (r8 < 1.0f) goto L6;
        return 1.0f;
    L6:
        if (r8 > 0.0f) goto L8;
        return 0.0f;
    L8:
        float[] r10 = this.f11944a;
        int r11 = Math.min((int) ((r10.length - 1) * r8), r10.length - 2);
        float r12 = this.f11945b;
        float r13 = (r8 - (r11 * r12)) / r12;
        float r14 = r10[r11];
        return defpackage.a.a(r10[r11 + 1], r14, r13, r14);
    }
}
