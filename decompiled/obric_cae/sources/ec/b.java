package ec;

import android.view.Window;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements vb.b.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ float f7218a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ float f7219b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Window f7220c;

    public b(float r8, float r10, Window r11) {
        this.f7218a = r8;
        this.f7219b = r10;
        this.f7220c = r11;
    }

    @Override // vb.b.j
    public final void a(vb.b<?> r8, float r10, float r11) {
        float r12 = (r10 - 0.0f) / (this.f7218a - 0.0f);
        float r13 = this.f7219b;
        a.a(this.f7220c, r12, r13, 0.0f);
    }
}
