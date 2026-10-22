package ec;

import android.view.Window;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements vb.b.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ float f7223a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Window f7224b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ float f7225c;

    public d(float r8, Window r10, float r11) {
        this.f7223a = r8;
        this.f7224b = r10;
        this.f7225c = r11;
    }

    @Override // vb.b.j
    public final void a(vb.b<?> r8, float r10, float r11) {
        float r12 = this.f7223a;
        float r13 = (r10 - r12) / (0.0f - r12);
        float r14 = this.f7225c;
        a.a(this.f7224b, r13, 0.0f, r14);
    }
}
