package aa;

import pe.d0;

/* JADX INFO: loaded from: classes.dex */
public final class d extends d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f138a;

    public d() {
        this.f138a = -1.0f;
    }

    @Override // pe.d0
    public final void b(float r8, float r10, m r11) {
        r11.e(r10 * r8, 180.0f, 90.0f);
        double r12 = r10;
        double r13 = r8;
        r11.d((float) ((Math.sin(Math.toRadians(90.0f)) * r12) * r13), (float) ((Math.sin(Math.toRadians(0.0f)) * r12) * r13));
    }
}
