package f1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class b implements g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Map<String, g> f8786c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f8787a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<String> f8788b;

    static {
        f8786c = new ConcurrentHashMap();
    }

    public b() {
        ArrayList r10 = new ArrayList();
        this.f8788b = r10;
        r10.add("logger@" + hashCode());
    }

    private String A(Object r10) {
        if (r10 != null) goto L6;
        return "";
    L6:
        return r10.toString();
    }

    public static g x(String r10) {
        return f8786c.get(r10);
    }

    @Override // f1.g
    public void e(String r10) {
        this.f8787a = r10;
        f8786c.put(r10, this);
        i("Current logger bind to appId {}", new Object[]{r10});
    }

    protected String w(String r10, Object... r11) {
        StringBuilder r12 = new StringBuilder();     // Catch: Throwable -> L28
        if (r11 != null) goto L5;
    L25:
        r12.append(r10);     // Catch: Throwable -> L28
    L26:
        return r12.toString();
    L5:
        if (r11.length == 0) goto L25;
        if (r10.contains("{}") == false) goto L25;
        int r13 = r10.length();     // Catch: Throwable -> L28
        int r14 = 0;
        int r15 = 0;
    L10:
        if (r14 >= r13) goto L26;
        char r16 = r10.charAt(r14);     // Catch: Throwable -> L28
        if (r14 >= (r13 - 1)) goto L14;
        char r17 = r10.charAt(r14 + 1);     // Catch: Throwable -> L28
    L16:
        if (r16 == '{') goto L18;
    L23:
        r12.append(r16);     // Catch: Throwable -> L28
    L24:
        r14 = r14 + 1;     // Catch: Throwable -> L28
        goto L10
    L18:
        if (r17 != '}') goto L23;
        if (r15 >= r11.length) goto L22;
        r12.append(A(r11[r15]));     // Catch: Throwable -> L28
        r15 = r15 + 1;     // Catch: Throwable -> L28
    L22:
        r14 = r14 + 1;     // Catch: Throwable -> L28
        goto L24
    L14:
        r17 = ' ';
    L28:
        return r10;
    }

    protected List<String> y(List<String> r10) {
        if (r10 == null) goto L8;
        if (r10.size() <= 0) goto L8;
        ArrayList r11 = new ArrayList();
        r11.addAll(this.f8788b);
        r11.addAll(r10);
        return r11;
    L8:
        return this.f8788b;
    }

    protected void z(int r10, int r11, List<String> r12, Throwable r13, String r14, Object... r15) {
        if (l.f() == false) goto L5;
        return;
    L5:
        i r16 = i.b().a(this.f8787a).c(r10).d(r11).g(Thread.currentThread().getName()).h(r13).f(y(r12)).e(w(r14, r15)).b();
        l.a(r16);
        h r17 = l.b(this.f8787a);
        if (r17 == null) goto L9;
        r17.a(r16);
        return;
    }
}
