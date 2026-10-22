package b5;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static a f524b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<String, b> f525a;

    public a() {
        this.f525a = new ConcurrentHashMap();
    }

    public static synchronized a c() {
        monitor-enter(a.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (f524b != null) goto L7;
        f524b = new a();     // Catch: Throwable -> L10
    L7:
        a r10 = f524b;     // Catch: Throwable -> L10
        monitor-exit(a.class);
        return r10;
    }

    public void a(String r10, String r11, int r12, int r13, int r14, List<String> r15, String r16) {
        b r17 = this.f525a.get(r10);
        if (r17 == null) goto L6;
        r17.e(new c(r12, r13, r14, r15, r16));
        r17.d();
        this.f525a.remove(r10);
        return;
    }

    public c b(String r10, int r11, Map<String, String> r12) {
        b r13 = new b(r10, r11, r12);
        this.f525a.put(r13.f(), r13);
        r13.b();
        r13.a();
        this.f525a.remove(r13.f());
        return r13.c();
    }
}
