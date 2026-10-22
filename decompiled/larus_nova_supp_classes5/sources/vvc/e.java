package vvc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.commonmark.internal.h;
import org.commonmark.internal.m;
import org.commonmark.node.Block;
import wvc.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class e {
    public final List<wvc.e> a;
    public final List<xvc.a> b;
    public final c c;
    public final List<f> d;

    public static class a {
        public final List<wvc.e> a;
        public final List<xvc.a> b;
        public final List<f> c;
        public Set<Class<? extends Block>> d;
        public c e;

        public a() {
            this.a = new ArrayList();
            this.b = new ArrayList();
            this.c = new ArrayList();
            this.d = h.p;
        }

        public final void a(wvc.b r2) {
            ((ArrayList) this.a).add(r2);
        }

        public final void b(Iterable r3) {
            if (r3 == null) goto L11;
            Iterator r4 = r3.iterator();
        L5:
            if (r4.hasNext() == false) goto L9;
            pvc.a r0 = (pvc.a) r4.next();
            if ((r0 instanceof b) == false) goto L5;
            ((b) r0).a(this);
            goto L5
        L9:
            return;
        L11:
            throw new NullPointerException("extensions must not be null");
        }
    }

    public interface b extends pvc.a {
        void a(a r1);
    }

    public e(a r5) {
        List<wvc.e> r0 = r5.a;
        Set<Class<? extends Block>> r1 = r5.d;
        Set<Class<? extends Block>> r2 = h.p;
        ArrayList r3 = new ArrayList();
        r3.addAll(r0);
        Iterator<Class<? extends Block>> r4 = r1.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        Class<? extends Block> r6 = r4.next();
        r3.add(h.q.get(r6));
        goto L4
    L6:
        this.a = r3;
        d r7 = r5.e;
        if (r7 != null) goto L10;
        r7 = new d();
    L10:
        this.c = r7;
        this.d = r5.c;
        List<xvc.a> r8 = r5.b;
        this.b = r8;
        r7.a(new m(r8, Collections.emptyMap()));
    }

    public final uvc.b a(String r9) {
        if (r9 == null) goto L36;
        h r0 = new h(this.a, this.c, this.b);
        int r1 = 0;
    L4:
        int r2 = r9.length();
        int r3 = r1;
    L6:
        if (r3 >= r2) goto L11;
        char r7 = r9.charAt(r3);
        if (r7 == '\n') goto L12;
        if (r7 == '\r') goto L12;
        r3 = r3 + 1;
    L12:
        if (r3 == (-1)) goto L21;
        r0.i(r9.substring(r1, r3));
        r1 = r3 + 1;
        if (r1 >= r9.length()) goto L4;
        if (r9.charAt(r3) != '\r') goto L4;
        if (r9.charAt(r1) != '\n') goto L4;
        r1 = r3 + 2;
        goto L4
    L21:
        if (r9.length() <= 0) goto L26;
        if (r1 != 0) goto L24;
    L25:
        r0.i(r9.substring(r1));
        goto L26
    L24:
        if (r1 < r9.length()) goto L25;
    L26:
        r0.f(r0.n);
        m r10 = new m(r0.k, r0.m);
        vvc.a r11 = r0.j.a(r10);
        Iterator<d> r4 = r0.o.iterator();
    L28:
        if (r4.hasNext() == false) goto L30;
        r4.next().g(r11);
        goto L28
    L30:
        uvc.b r12 = r0.l.a;
        Iterator r5 = ((ArrayList) this.d).iterator();
    L32:
        if (r5.hasNext() == false) goto L34;
        r12 = ((f) r5.next()).a(r12);
        goto L32
    L34:
        return r12;
    L11:
        r3 = -1;
        goto L12
    L36:
        throw new NullPointerException("input must not be null");
    }
}
