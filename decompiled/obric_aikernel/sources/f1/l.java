package f1;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final CopyOnWriteArraySet<h> f8834a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<String, h> f8835b = null;

    static {
        f8834a = new CopyOnWriteArraySet();
        f8835b = new ConcurrentHashMap();
    }

    public static void a(i r10) {
        if (r10 != null) goto L5;
        return;
    L5:
        if (f8834a.isEmpty() == false) goto L7;
        return;
    L7:
        Iterator<h> r11 = d();
    L9:
        if (r11.hasNext() == false) goto L11;
        r11.next().a(r10);
        goto L9
    }

    public static h b(String r10) {
        if (e(r10) == true) goto L5;
        return null;
    L5:
        return f8835b.get(r10);
    }

    public static Iterator<h> c() {
        return f8835b.values().iterator();
    }

    public static Iterator<h> d() {
        return f8834a.iterator();
    }

    private static boolean e(String r10) {
        if (r10 != null) goto L4;
    L6:
        return false;
    L4:
        if (r10.length() <= 0) goto L6;
        return true;
    }

    public static boolean f() {
        if (f8834a.isEmpty() == true) goto L5;
    L7:
        return false;
    L5:
        if (f8835b.isEmpty() == false) goto L7;
        return true;
    }

    public static void g(String r10, h r11) {
        f8835b.put(r10, r11);
    }
}
