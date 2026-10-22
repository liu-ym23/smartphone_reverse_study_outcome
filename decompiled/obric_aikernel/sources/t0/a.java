package t0;

import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static HashMap<String, Integer> f12922a;

    static {
        f12922a = new HashMap();
        a();
    }

    private static void a() {
        b("xx", 12334);
    }

    public static void b(String r10, int r11) {
        f12922a.put(r10, Integer.valueOf(r11));
    }

    public static Integer c(String r10) {
        return f12922a.get(r10);
    }
}
