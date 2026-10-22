package rb;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap f21717a;

    public b() {
        this.f21717a = new ConcurrentHashMap();
    }

    public final Object a(Class r5) {
        Intrinsics.checkNotNullParameter(r5, "clazz");
        a r10 = (a) this.f21717a.get(r5);
        if (r10 == null) goto L12;
        Object r11 = r10.a();
        if (r11 == null) goto L12;
        if (r5.isAssignableFrom(r11.getClass()) == true) goto L10;
        r11 = null;
    L10:
        if (r11 == null) goto L12;
        return r11;
    L12:
        return null;
    }

    public final void b(Class r5, a r10) {
        Intrinsics.checkNotNullParameter(r5, "clazz");
        Intrinsics.checkNotNullParameter(r10, "provider");
        ConcurrentHashMap r11 = this.f21717a;
        a r12 = (a) r11.get(r5);
        if (r12 == null) goto L8;
        if (r12 != r10) goto L6;
        r12 = null;
    L6:
        if (r12 == null) goto L8;
        r12.release();
    L8:
        r11.put(r5, r10);
    }

    public final void c(Class r5) {
        Intrinsics.checkNotNullParameter(r5, "clazz");
        ConcurrentHashMap r10 = this.f21717a;
        a r11 = (a) r10.get(r5);
        if (r11 == null) goto L5;
        r11.release();
    L5:
        r10.remove(r5);
    }
}
