package aa;

import pe.d0;

/* JADX INFO: loaded from: classes.dex */
public final class i extends d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f179a;

    public i() {
        this.f179a = -1.0f;
    }

    @Override // pe.d0
    public final void b(float r10, float r11, m r12) {
        r12.e(r11 * r10, 180.0f, 90.0f);
        float r8 = (r11 * 2.0f) * r10;
        r12.a(0.0f, 0.0f, r8, r8, 180.0f, 90.0f);
    }
}
