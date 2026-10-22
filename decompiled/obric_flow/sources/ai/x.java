package ai;

import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class x extends w0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Class f307c;

    public x(Class r5) {
        this.f307c = r5;
    }

    @Override // ai.w0
    public final void a(e0 r5, Object r10) {
        LinkedHashMap r11 = r5.f203v;
        Class r12 = this.f307c;
        r11.put(r12, r12.cast(r10));
    }
}
