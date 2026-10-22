package i1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f9367a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private JSONArray f9368b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<a> f9369c;

    public b() {
        this.f9369c = new ArrayList();
    }

    public void a(int r10, int r11, Set<String> r12, Map<String, List<Set<String>>> r13, Map<String, List<Map<String, Object>>> r14) {
        if (r11 != 1) goto L5;
        a r15 = new f(r10, r12, r13, r14);
    L18:
        a r16 = r15;
    L19:
        if (r16 == null) goto L22;
        this.f9369c.add(r16);
        return;
    L22:
        return;
    L5:
        if (r11 != 2) goto L7;
        r15 = new d(r10, r12, r13, r14);
        goto L18
    L7:
        if (r11 != 3) goto L9;
        r15 = new e(r10, r12, r13, r14);
        goto L18
    L9:
        if (r11 != 4) goto L11;
        r15 = new g(r10, r12, r13, r14);
        goto L18
    L11:
        if (r11 == 5) goto L13;
        r16 = null;
        goto L19
    L13:
        r15 = new h(r10, r12, r13, r14);
        goto L18
    }

    public JSONArray b() {
        return this.f9368b;
    }

    public int c() {
        return this.f9367a;
    }

    public boolean d(i r10, String r11, String r12) {
        Iterator<a> r13 = this.f9369c.iterator();
    L4:
        if (r13.hasNext() == false) goto L9;
        a r14 = r13.next();
        if (r14.b(r11, r12) == false) goto L4;
        return r14.d(r10);
    L9:
        return false;
    }

    public void e(JSONArray r10) {
        this.f9368b = r10;
    }

    public void f(int r10) {
        this.f9367a = r10;
    }
}
