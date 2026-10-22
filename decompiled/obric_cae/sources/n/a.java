package n;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class a extends g<Object, Object> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ b f9357d;

    public a(b r8) {
        this.f9357d = r8;
    }

    @Override // n.g
    public final void a() {
        this.f9357d.clear();
    }

    @Override // n.g
    public final Object b(int r8, int r10) {
        return this.f9357d.f9400b[(r8 << 1) + r10];
    }

    @Override // n.g
    public final Map<Object, Object> c() {
        return this.f9357d;
    }

    @Override // n.g
    public final int d() {
        return this.f9357d.f9401m;
    }

    @Override // n.g
    public final int e(Object r8) {
        return this.f9357d.f(r8);
    }

    @Override // n.g
    public final int f(Object r8) {
        return this.f9357d.h(r8);
    }

    @Override // n.g
    public final void g(Object r8, Object r10) {
        this.f9357d.put(r8, r10);
    }

    @Override // n.g
    public final void h(int r8) {
        this.f9357d.j(r8);
    }

    @Override // n.g
    public final Object i(int r8, Object r10) {
        int r11 = (r8 << 1) + 1;
        Object[] r12 = this.f9357d.f9400b;
        Object r13 = r12[r11];
        r12[r11] = r10;
        return r13;
    }
}
