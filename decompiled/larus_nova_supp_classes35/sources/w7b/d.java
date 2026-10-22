package w7b;

import com.ss.android.lark.commonmark.internal.h;
import com.ss.android.lark.commonmark.internal.m;
import com.ss.android.lark.commonmark.internal.n;
import com.ss.android.lark.commonmark.internal.o;
import com.ss.android.lark.commonmark.parser.IncludeSourceSpans;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import v7b.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d {
    public final List<y7b.e> a;
    public final List<x7b.b> b;
    public final List<z7b.a> c;
    public final c d;
    public final List<e> e;
    public final IncludeSourceSpans f;

    public static class a {
        public final List<y7b.e> a;
        public final List<x7b.b> b;
        public final List<z7b.a> c;
        public final List<e> d;
        public final Set<Class<? extends v7b.a>> e;
        public IncludeSourceSpans f;

        public a() {
            this.a = new ArrayList();
            this.b = new ArrayList();
            this.c = new ArrayList();
            this.d = new ArrayList();
            this.e = h.s;
            this.f = IncludeSourceSpans.NONE;
        }

        public final void a(e r2) {
            Objects.requireNonNull(r2, "postProcessor must not be null");
            ((ArrayList) this.d).add(r2);
        }
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [w7b.c] */
    public d(a r5) {
        List<y7b.e> r0 = r5.a;
        Set<Class<? extends v7b.a>> r1 = r5.e;
        Set<Class<? extends v7b.a>> r2 = h.s;
        ArrayList r3 = new ArrayList();
        r3.addAll(r0);
        Iterator<Class<? extends v7b.a>> r4 = r1.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        Class<? extends v7b.a> r6 = r4.next();
        r3.add(h.t.get(r6));
        goto L4
    L6:
        this.a = r3;
        this.d = new c();
        this.e = r5.d;
        List<x7b.b> r7 = r5.b;
        this.b = r7;
        List<z7b.a> r8 = r5.c;
        this.c = r8;
        this.f = r5.f;
        new n(new m(r7, r8, new o()));
    }

    public final s a(String r9) {
        Objects.requireNonNull(r9, "input must not be null");
        h r0 = new h(this.a, this.d, this.b, this.c, this.f);
        int r1 = 0;
    L3:
        int r2 = r9.length();
        int r3 = r1;
    L5:
        if (r3 >= r2) goto L10;
        char r7 = r9.charAt(r3);
        if (r7 == '\n') goto L11;
        if (r7 == '\r') goto L11;
        r3 = r3 + 1;
    L11:
        if (r3 == (-1)) goto L20;
        r0.i(r9.substring(r1, r3));
        r1 = r3 + 1;
        if (r1 >= r9.length()) goto L3;
        if (r9.charAt(r3) != '\r') goto L3;
        if (r9.charAt(r1) != '\n') goto L3;
        r1 = r3 + 2;
        goto L3
    L20:
        if (r9.isEmpty() == true) goto L25;
        if (r1 != 0) goto L23;
    L24:
        r0.i(r9.substring(r1));
        goto L25
    L23:
        if (r1 < r9.length()) goto L24;
    L25:
        r0.f(((ArrayList) r0.q).size());
        m r10 = new m(r0.l, r0.m, r0.p);
        ((c) r0.k).getClass();
        n r4 = new n(r10);
        Iterator r11 = ((ArrayList) r0.r).iterator();
    L27:
        if (r11.hasNext() == false) goto L29;
        ((y7b.d) r11.next()).d(r4);
        goto L27
    L29:
        s r12 = r0.o.a;
        Iterator r5 = ((ArrayList) this.e).iterator();
    L31:
        if (r5.hasNext() == false) goto L33;
        r12 = ((e) r5.next()).a(r12);
        goto L31
    L33:
        return r12;
    L10:
        r3 = -1;
        goto L11
    }
}
