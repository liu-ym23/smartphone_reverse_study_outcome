package rgc;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class b {
    public static final Map<Class, a> a = null;

    static {
        a = new ConcurrentHashMap();
    }

    public static <T extends a> T a(Class<T> r1) {
        return (T) ((ConcurrentHashMap) a).get(r1);
    }

    public static <T extends a> void b(Class<T> r1, a r2) {
        if (r2 == null) goto L5;
        ((ConcurrentHashMap) a).put(r1, r2);
        return;
    }
}
