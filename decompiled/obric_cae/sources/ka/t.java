package ka;

import ha.c0;
import ha.d0;

/* JADX INFO: loaded from: classes.dex */
public final class t implements d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Class f9086a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Class f9087b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ c0 f9088m;

    public t(Class r8, Class r10, c0 r11) {
        this.f9086a = r8;
        this.f9087b = r10;
        this.f9088m = r11;
    }

    @Override // ha.d0
    public final <T> c0<T> a(ha.j r8, oa.a<T> r10) {
        Class<? super T> r11 = r10.getRawType();
        if (r11 == this.f9086a) goto L9;
        if (r11 == this.f9087b) goto L9;
        return null;
    L9:
        return this.f9088m;
    }

    public final String toString() {
        return "Factory[type=" + this.f9087b.getName() + "+" + this.f9086a.getName() + ",adapter=" + this.f9088m + "]";
    }
}
