package androidx.lifecycle;

import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
class ReflectiveGenericLifecycleObserver implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f2113a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b.a f2114b;

    public ReflectiveGenericLifecycleObserver(Object r8) {
        this.f2113a = r8;
        this.f2114b = b.f2126c.b(r8.getClass());
    }

    @Override // androidx.lifecycle.k
    public final void onStateChanged(m r8, h.a r10) {
        HashMap r11 = this.f2114b.f2129a;
        List r12 = (List) r11.get(r10);
        Object r13 = this.f2113a;
        b.a.a(r12, r8, r10, r13);
        b.a.a((List) r11.get(h.a.ON_ANY), r8, r10, r13);
    }
}
