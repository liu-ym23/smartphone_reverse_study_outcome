package cc2;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e {
    public final Map<Class<?>, f<?>> a;

    public e() {
        this.a = new LinkedHashMap();
    }

    public final <T extends o> f<T> b(Class<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "clazz");
        Object r3 = ((LinkedHashMap) this.a).get(r2);
        if ((r3 instanceof f) == true) goto L6;
        r3 = null;
    L6:
        return (f) r3;
    }

    public final <T extends o> void a(Class<T> r3, T r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r3, "clazz");
        Intrinsics.checkNotNullParameter(r4, "factor");
        this.a.put(r3, new f(r4, r5));
    }
}
