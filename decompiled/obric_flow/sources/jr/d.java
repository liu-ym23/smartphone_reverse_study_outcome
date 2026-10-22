package jr;

import android.view.View;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends g {
    public float[] g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public lr.b f18434h;

    @Override // jr.g
    public final void d(lr.b r5) {
        this.f18434h = r5;
    }

    @Override // jr.g
    public final void e(View r5, float r10) {
        float r11 = a(r10);
        float[] r12 = this.g;
        r12[0] = r11;
        f4.a.n(this.f18434h, r5, r12);
    }
}
