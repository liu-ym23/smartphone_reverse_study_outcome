package n;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class c extends g<Object, Object> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ d f9359d;

    public c(d r8) {
        this.f9359d = r8;
    }

    @Override // n.g
    public final void a() {
        this.f9359d.clear();
    }

    @Override // n.g
    public final Object b(int r8, int r10) {
        return this.f9359d.f9367b[r8];
    }

    @Override // n.g
    public final Map<Object, Object> c() {
        throw new UnsupportedOperationException("not a map");
    }

    @Override // n.g
    public final int d() {
        return this.f9359d.f9368m;
    }

    @Override // n.g
    public final int e(Object r8) {
        return this.f9359d.indexOf(r8);
    }

    @Override // n.g
    public final int f(Object r8) {
        return this.f9359d.indexOf(r8);
    }

    @Override // n.g
    public final void g(Object r8, Object r10) {
        this.f9359d.add(r8);
    }

    @Override // n.g
    public final void h(int r8) {
        this.f9359d.e(r8);
    }

    @Override // n.g
    public final Object i(int r8, Object r10) {
        throw new UnsupportedOperationException("not a map");
    }
}
