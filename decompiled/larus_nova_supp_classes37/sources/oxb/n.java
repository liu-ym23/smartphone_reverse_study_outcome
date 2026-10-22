package oxb;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class n {
    public final Map<String, j> a;

    public n() {
        this.a = new ConcurrentHashMap();
    }

    public final <T extends j> T a(Class<T> r2) {
        Map<String, j> r0 = this.a;
        ConcurrentHashMap r1 = (ConcurrentHashMap) r0;
        return (T) r1.get(r2.getCanonicalName());
    }

    public final void b(Class<? extends j> r7) {
        Class<?>[] r1 = r7.getInterfaces();     // Catch: IllegalAccessException -> L16 InstantiationException -> L18
        if (r1 != null) goto L6;
    L14:
        com.ss.android.lark.officesdk.utils.di.j.e("ServiceManager", "no IWebService interface exists");     // Catch: IllegalAccessException -> L16 InstantiationException -> L18
        return;
    L6:
        if (r1.length == 0) goto L14;
        j r8 = r7.newInstance();     // Catch: IllegalAccessException -> L16 InstantiationException -> L18
        int r2 = r1.length;     // Catch: IllegalAccessException -> L16 InstantiationException -> L18
        int r3 = 0;
    L9:
        if (r3 >= r2) goto L26;
        Class<?> r4 = r1[r3];     // Catch: IllegalAccessException -> L16 InstantiationException -> L18
        if (j.class.isAssignableFrom(r4) == false) goto L13;
        Map<String, j> r5 = this.a;     // Catch: IllegalAccessException -> L16 InstantiationException -> L18
        ConcurrentHashMap r6 = (ConcurrentHashMap) r5;     // Catch: IllegalAccessException -> L16 InstantiationException -> L18
        r6.put(r4.getCanonicalName(), r8);     // Catch: IllegalAccessException -> L16 InstantiationException -> L18
    L13:
        r3 = r3 + 1;     // Catch: IllegalAccessException -> L16 InstantiationException -> L18
        goto L9
    L26:
        return;
    L16:
        e = move-exception;
        com.ss.android.lark.officesdk.utils.di.j.c("ServiceManager", "illegal access", e);
        return;
    L18:
        e = move-exception;
        com.ss.android.lark.officesdk.utils.di.j.c("ServiceManager", "instantiation error", e);
    }
}
