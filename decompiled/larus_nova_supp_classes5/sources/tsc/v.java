package tsc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class v extends s {
    public final boolean a;
    public final Map<String, a0> b;

    public static class a {
        public Map<String, a0> a;
        public boolean b;
        public boolean c;

        public a() {
            this.a = Collections.emptyMap();
        }
    }

    public final a0 b(String r2) {
        return this.b.get(r2);
    }

    public v(boolean r1, Map<String, a0> r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // tsc.s
    public final void a(lsc.p r7, r r8) {
        if (this.a == true) goto L5;
        int r0 = -1;
    L6:
        t r2 = new t(this, r7);
        if (((ArrayList) r8.f).size() <= 0) goto L16;
        if (r0 <= (-1)) goto L15;
        Iterator r3 = ((ArrayList) r8.f).iterator();
    L11:
        if (r3.hasNext() == false) goto L15;
        m.b r4 = (m.b) r3.next();
        if (r4.isClosed() == true) goto L11;
        r4.d = r0;
    L15:
        ArrayList r5 = new ArrayList(r8.f);
        Collections.reverse(r5);
        r2.a(r5);
        ((ArrayList) r8.f).clear();
    L17:
        u r6 = new u(this, r7);
        m.a r9 = r8.g;
    L18:
        m.a r10 = r9.f;
        if (r10 == null) goto L21;
        r9 = r10;
        goto L18
    L21:
        if (r0 <= (-1)) goto L23;
        r9.c(r0);
    L23:
        List<l.a> r11 = r9.children();
        if (r11.size() <= 0) goto L26;
        r6.a(r11);
    L27:
        r8.g = new m.a("", 0, Collections.emptyMap(), null);
        ((ArrayList) r8.f).clear();
        r8.g = new m.a("", 0, Collections.emptyMap(), null);
        return;
    L26:
        r6.a(Collections.emptyList());
        goto L27
    L16:
        r2.a(Collections.emptyList());
        goto L17
    L5:
        r0 = r7.length();
        goto L6
    }
}
