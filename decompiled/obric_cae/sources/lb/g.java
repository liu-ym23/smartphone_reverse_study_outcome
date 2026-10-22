package lb;

import android.graphics.Path;

/* JADX INFO: loaded from: classes2.dex */
public final class g extends d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f9203b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f9204c;

    public /* synthetic */ g() {
        this(0.375f);
    }

    @Override // lb.d
    public final Path a(float r8, float r10, float r11, float r12, float r13) {
        float r14 = Math.min(r11 - r8, r12 - r10);
        if (r13 == 0.0f) goto L10;
        if (r13 >= (this.f9204c * r14)) goto L10;
        float r15 = Math.min(r14 / 2.0f, r13 * this.f9203b);
        float r16 = r10 + r15;
        float r17 = r12 - r15;
        float r18 = r11 - r15;
        float r19 = r15 + r8;
        Path r20 = new Path();
        r20.moveTo(r11, r16);
        r20.lineTo(r11, r17);
        r20.quadTo(r11, r12, r18, r12);
        r20.lineTo(r19, r12);
        r20.quadTo(r8, r12, r8, r17);
        r20.lineTo(r8, r16);
        r20.quadTo(r8, r10, r19, r10);
        r20.lineTo(r18, r10);
        r20.quadTo(r11, r10, r11, r16);
        r20.close();
        return r20;
    L10:
        return d.b(r8, r10, r11, r12, r13);
    }

    @Override // lb.d
    public final boolean c(float r8, float r10) {
        if (r8 >= (this.f9204c * r10)) goto L5;
        return true;
    L5:
        return false;
    }

    public g(float r8) {
        this.f9204c = r8;
        this.f9203b = 1.175f;
    }
}
