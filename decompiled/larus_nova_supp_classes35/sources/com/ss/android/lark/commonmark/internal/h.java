package com.ss.android.lark.commonmark.internal;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.commonmark.parser.IncludeSourceSpans;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import v7b.d0;
import v7b.v;
import v7b.x;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class h implements y7b.g {
    public static final Set<Class<? extends v7b.a>> s = null;
    public static final Map<Class<? extends v7b.a>, y7b.e> t = null;
    public w7b.f a;
    public int b;
    public int c;
    public int d;
    public boolean e;
    public int f;
    public int g;
    public int h;
    public boolean i;
    public final List<y7b.e> j;
    public final w7b.b k;
    public final List<x7b.b> l;
    public final List<z7b.a> m;
    public final IncludeSourceSpans n;
    public final g o;
    public final o p;
    public final List<b> q;
    public final List<y7b.d> r;

    public static class a {
        public final y7b.d a;

        public a(y7b.d r1) {
            this.a = r1;
        }
    }

    public static class b {
        public final y7b.d a;
        public int b;

        public b(y7b.d r1, int r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
        int r10 = 0;
        Object[] r9 = {v7b.b.class, v7b.i.class, v7b.g.class, v7b.j.class, d0.class, v7b.p.class, v7b.m.class};
        ArrayList r1 = new ArrayList(7);
    L3:
        if (r10 >= 7) goto L5;
        Object r2 = r9[r10];
        Objects.requireNonNull(r2);
        r1.add(r2);
        r10 = r10 + 1;
        goto L3
    L5:
        s = new LinkedHashSet(Collections.unmodifiableList(r1));
        HashMap r0 = new HashMap();
        r0.put(v7b.b.class, new c.a());
        r0.put(v7b.i.class, new j.a());
        r0.put(v7b.g.class, new i.a());
        r0.put(v7b.j.class, new k.a());
        r0.put(d0.class, new t.a());
        r0.put(v7b.p.class, new p.a());
        r0.put(v7b.m.class, new l.a());
        t = Collections.unmodifiableMap(r0);
    }

    public final void c() {
        if (this.e == false) goto L8;
        int r0 = this.c + 1;
        CharSequence r1 = this.a.a;
        CharSequence r2 = r1.subSequence(r0, r1.length());
        int r3 = 4 - (this.d % 4);
        StringBuilder r4 = new StringBuilder(r2.length() + r3);
        int r5 = 0;
    L5:
        if (r5 >= r3) goto L7;
        r4.append(' ');
        r5 = r5 + 1;
        goto L5
    L7:
        r4.append(r2);
        CharSequence r6 = r4.toString();
    L13:
        if (this.n != IncludeSourceSpans.BLOCKS_AND_INLINES) goto L15;
        x r7 = new x(this.b, this.c, r6.length());
    L16:
        h().e(new w7b.f(r6, r7));
        d();
        return;
    L15:
        r7 = null;
        goto L16
    L8:
        int r8 = this.c;
        if (r8 != 0) goto L11;
        r6 = this.a.a;
        goto L13
    L11:
        CharSequence r9 = this.a.a;
        r6 = r9.subSequence(r8, r9.length());
        goto L13
    }

    public final void d() {
        if (this.n == IncludeSourceSpans.NONE) goto L11;
        int r0 = 1;
    L6:
        if (r0 >= ((ArrayList) this.q).size()) goto L15;
        b r1 = (b) ListProtector.get(this.q, r0);
        int r2 = r1.b;
        int r3 = this.a.a.length() - r2;
        if (r3 == 0) goto L10;
        r1.a.f(new x(this.b, r2, r3));
    L10:
        r0 = r0 + 1;
        goto L6
    L15:
        return;
    }

    public final void e() {
        char r0 = this.a.a.charAt(this.c);
        this.c++;
        if (r0 != '\t') goto L5;
        int r1 = this.d;
        this.d = r1 + (4 - (r1 % 4));
        return;
    L5:
        this.d++;
    }

    public final void g() {
        int r0 = this.c;
        int r1 = this.d;
        this.i = true;
        int r2 = this.a.a.length();
    L3:
        if (r0 >= r2) goto L11;
        char r3 = this.a.a.charAt(r0);
        if (r3 != '\t') goto L7;
        r0 = r0 + 1;
        r1 = r1 + (4 - (r1 % 4));
        goto L3
    L7:
        if (r3 != ' ') goto L8;
        r0 = r0 + 1;
        r1 = r1 + 1;
        goto L3
    L8:
        this.i = false;
    L11:
        this.f = r0;
        this.g = r1;
        this.h = r1 - this.d;
    }

    public final y7b.d h() {
        List<b> r0 = this.q;
        return ((b) ListProtector.get(r0, ((ArrayList) r0).size() - 1)).a;
    }

    public final void a(b r3) {
    L3:
        if (h().g(r3.a.a()) == true) goto L5;
        f(1);
        goto L3
    L5:
        h().a().e(r3.a.a());
        ((ArrayList) this.q).add(r3);
    }

    public final void b(r r6) {
        LinkReferenceDefinitionParser r0 = r6.b;
        r0.a();
        Iterator r1 = ((ArrayList) r0.c).iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        v7b.o r2 = (v7b.o) r1.next();
        r6.a.l(r2);
        o r3 = this.p;
        r3.getClass();
        String r4 = u7b.a.a(r2.j);
        if (r3.a.containsKey(r4) == true) goto L4;
        r3.a.put(r4, r2);
        goto L4
    }

    public final void f(int r4) {
        int r0 = 0;
    L3:
        if (r0 >= r4) goto L8;
        List<b> r1 = this.q;
        y7b.d r2 = ((b) ListProtector.remove(r1, ((ArrayList) r1).size() - 1)).a;
        if ((r2 instanceof r) == false) goto L7;
        b((r) r2);
    L7:
        r2.c();
        ((ArrayList) this.r).add(r2);
        r0 = r0 + 1;
        goto L3
    }

    public final void i(String r13) {
        this.b++;
        this.c = 0;
        this.d = 0;
        this.e = false;
        if (r13.indexOf(0) == (-1)) goto L7;
        r13 = r13.replace(0, 65533);
    L7:
        if (this.n == IncludeSourceSpans.NONE) goto L9;
        x r6 = new x(this.b, 0, r13.length());
    L10:
        this.a = new w7b.f(r13, r6);
        int r14 = 1;
        int r2 = 1;
    L12:
        if (r14 >= ((ArrayList) this.q).size()) goto L26;
        b r4 = (b) ListProtector.get(this.q, r14);
        y7b.d r7 = r4.a;
        g();
        y7b.c r8 = r7.h(this);
        if ((r8 instanceof com.ss.android.lark.commonmark.internal.b) == false) goto L26;
        com.ss.android.lark.commonmark.internal.b r9 = (com.ss.android.lark.commonmark.internal.b) r8;
        r4.b = this.c;
        if (r9.c == true) goto L17;
        int r5 = r9.a;
        if (r5 == (-1)) goto L22;
        k(r5);
    L25:
        r2 = r2 + 1;
        r14 = r14 + 1;
        goto L12
    L22:
        int r10 = r9.b;
        if (r10 == (-1)) goto L25;
        j(r10);
        goto L25
    L17:
        d();
        f(((ArrayList) this.q).size() - r14);
        return;
    L26:
        int r15 = ((ArrayList) this.q).size() - r2;
        y7b.d r3 = ((b) ListProtector.get(this.q, r2 - 1)).a;
        int r11 = this.c;
        if ((r3.a() instanceof v) == false) goto L29;
    L32:
        boolean r12 = true;
    L33:
        boolean r16 = false;
    L34:
        if (r12 == false) goto L75;
        r11 = this.c;
        g();
        if (this.i == true) goto L74;
        if (this.h < 4) goto L40;
    L42:
        a r17 = new a(r3);
        Iterator<y7b.e> r18 = this.j.iterator();
    L44:
        if (r18.hasNext() == false) goto L48;
        d r19 = r18.next().a(this, r17);
        if ((r19 instanceof d) == false) goto L44;
    L49:
        if (r19 == null) goto L50;
        int r20 = this.c;
        if (r15 <= 0) goto L54;
        f(r15);
        r15 = 0;
    L54:
        int r21 = r19.b;
        if (r21 == (-1)) goto L57;
        k(r21);
    L61:
        if (r19.d == false) goto L66;
        List<b> r22 = this.q;
        y7b.d r23 = ((b) ListProtector.remove(r22, ((ArrayList) r22).size() - 1)).a;
        if ((r23 instanceof r) == false) goto L65;
        b((r) r23);
    L65:
        r23.c();
        r23.a().p();
        List<x> r24 = r23.a().j();
    L67:
        y7b.d[] r25 = r19.a;
        int r110 = r25.length;
        int r111 = 0;
    L68:
        if (r111 >= r110) goto L73;
        r3 = r25[r111];
        a(new b(r3, r20));
        if (r24 == null) goto L72;
        r3.a().n(r24);
    L72:
        r12 = r3.isContainer();
        r111 = r111 + 1;
        goto L68
    L73:
        r16 = true;
        goto L34
    L66:
        r24 = null;
        goto L67
    L57:
        int r26 = r19.c;
        if (r26 == (-1)) goto L61;
        j(r26);
        goto L61
    L50:
        k(this.f);
        goto L75
    L48:
        r19 = null;
        goto L49
    L40:
        if (Character.isLetter(Character.codePointAt(this.a.a, this.f)) == false) goto L42;
    L74:
        k(this.f);
    L75:
        if (r16 == false) goto L77;
    L81:
        if (r15 <= 0) goto L84;
        f(r15);
    L84:
        if (r3.isContainer() == true) goto L87;
        c();
        return;
    L87:
        if (this.i == true) goto L89;
        a(new b(new r(), r11));
        c();
        return;
    L89:
        d();
        return;
    L77:
        if (this.i == true) goto L81;
        if (h().b() == false) goto L81;
        List<b> r112 = this.q;
        ((b) ListProtector.get(r112, ((ArrayList) r112).size() - 1)).b = r11;
        c();
        return;
    L29:
        if (r3.isContainer() == true) goto L32;
        r12 = false;
        goto L33
    L9:
        r6 = null;
        goto L10
    }

    public final void j(int r4) {
        int r0 = this.g;
        if (r4 < r0) goto L5;
        this.c = this.f;
        this.d = r0;
    L5:
        int r1 = this.a.a.length();
    L6:
        int r2 = this.d;
        if (r2 >= r4) goto L11;
        if (this.c == r1) goto L11;
        e();
    L11:
        if (r2 <= r4) goto L13;
        this.c--;
        this.d = r4;
        this.e = true;
        return;
    L13:
        this.e = false;
    }

    public final void k(int r3) {
        int r0 = this.f;
        if (r3 < r0) goto L5;
        this.c = r0;
        this.d = this.g;
    L5:
        int r1 = this.a.a.length();
    L6:
        int r2 = this.c;
        if (r2 >= r3) goto L10;
        if (r2 == r1) goto L10;
        e();
    L10:
        this.e = false;
    }

    public h(List r4, w7b.c r5, List r6, List r7, IncludeSourceSpans r8) {
        this.b = -1;
        this.c = 0;
        this.d = 0;
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.p = new o();
        ArrayList r1 = new ArrayList();
        this.q = r1;
        this.r = new ArrayList();
        this.j = r4;
        this.k = r5;
        this.l = r6;
        this.m = r7;
        this.n = r8;
        g r9 = new g();
        this.o = r9;
        r1.add(new b(r9, 0));
    }
}
