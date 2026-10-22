package va1;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b {
    public va1.a a;

    public static final class a {
        public static final b a = null;

        static {
            a = new b();
        }
    }

    public b() {
    }

    public final <T> T a(Class<T> r5) {
        va1.a r0 = this.a;
        if (r0 != null) goto L5;
        c r1 = c.a.a;
        r1.getClass();
        String r2 = r5.getName();
        T r3 = (T) ((ConcurrentHashMap) r1.a).get(r2);
        if (r3 == null) goto L9;
        return r3;
    L9:
        if (r1.b.contains(r2) == true) goto L13;
        r1.b.add(r5.getName());
        return null;
    L13:
        return r3;
    L5:
        return (T) r0.getRealService(r5);
    }
}
