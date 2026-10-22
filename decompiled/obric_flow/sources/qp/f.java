package qp;

import android.graphics.Path;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends um.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f21558c;
    public final float d;

    public /* synthetic */ f() {
        this(0.375f);
    }

    @Override // um.a
    public final Path l(float r5, float r10, float r11, float r12, float r13) {
        float r14 = Math.min(r11 - r5, r12 - r10);
        if (r13 == 0.0f) goto L10;
        if (r13 >= (this.d * r14)) goto L10;
        float r15 = Math.min(r14 / 2.0f, r13 * this.f21558c);
        float r16 = r10 + r15;
        float r17 = r12 - r15;
        float r18 = r11 - r15;
        float r19 = r15 + r5;
        Path r20 = new Path();
        r20.moveTo(r11, r16);
        r20.lineTo(r11, r17);
        r20.quadTo(r11, r12, r18, r12);
        r20.lineTo(r19, r12);
        r20.quadTo(r5, r12, r5, r17);
        r20.lineTo(r5, r16);
        r20.quadTo(r5, r10, r19, r10);
        r20.lineTo(r18, r10);
        r20.quadTo(r11, r10, r11, r16);
        r20.close();
        return r20;
    L10:
        return um.a.m(r5, r10, r11, r12, r13);
    }

    @Override // um.a
    public final boolean n(float r5, float r10) {
        if (r5 >= (this.d * r10)) goto L5;
        return true;
    L5:
        return false;
    }

    public f(float r5) {
        super(8);
        this.d = r5;
        this.f21558c = 1.175f;
    }
}
