package ly;

import java.util.LinkedHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class s {
    public static final LinkedHashMap<Long, t> a = null;

    static {
        a = new LinkedHashMap();
    }

    public static void a(long r1) {
        t r2 = a.remove(Long.valueOf(r1));
        if (r2 == null) goto L6;
        r2.a();
        return;
    }
}
