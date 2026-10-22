package org.commonmark.internal;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.commonmark.node.Block;
import org.commonmark.node.BlockQuote;
import org.commonmark.node.FencedCodeBlock;
import org.commonmark.node.Heading;
import org.commonmark.node.HtmlBlock;
import org.commonmark.node.IndentedCodeBlock;
import org.commonmark.node.LinkReferenceDefinition;
import org.commonmark.node.ListBlock;
import org.commonmark.node.Paragraph;
import org.commonmark.node.ThematicBreak;
import uvc.b;
import vvc.c;
import wvc.d;
import wvc.e;
import wvc.f;
import wvc.g;
import xvc.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class h implements g {
    public static final Set<Class<? extends Block>> p = null;
    public static final Map<Class<? extends Block>, e> q = null;
    public CharSequence a;
    public int b;
    public int c;
    public boolean d;
    public int e;
    public int f;
    public int g;
    public boolean h;
    public final List<e> i;
    public final c j;
    public final List<a> k;
    public final g l;
    public final Map<String, LinkReferenceDefinition> m;
    public final List<d> n;
    public final Set<d> o;

    static {
        p = new LinkedHashSet(Arrays.asList(new Class[]{BlockQuote.class, Heading.class, FencedCodeBlock.class, HtmlBlock.class, ThematicBreak.class, ListBlock.class, IndentedCodeBlock.class}));
        HashMap r0 = new HashMap();
        r0.put(BlockQuote.class, new c$a());
        r0.put(Heading.class, new j$a());
        r0.put(FencedCodeBlock.class, new i$a());
        r0.put(HtmlBlock.class, new k$a());
        r0.put(ThematicBreak.class, new s$a());
        r0.put(ListBlock.class, new o$a());
        r0.put(IndentedCodeBlock.class, new l$a());
        q = Collections.unmodifiableMap(r0);
    }

    public final void c() {
        if (this.d == false) goto L8;
        int r0 = this.b + 1;
        CharSequence r1 = this.a;
        CharSequence r2 = r1.subSequence(r0, r1.length());
        int r3 = 4 - (this.c % 4);
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
    L9:
        h().d(r6);
        return;
    L8:
        CharSequence r7 = this.a;
        r6 = r7.subSequence(this.b, r7.length());
        goto L9
    }

    public final void d() {
        if (this.a.charAt(this.b) != '\t') goto L5;
        this.b++;
        int r0 = this.c;
        this.c = r0 + (4 - (r0 % 4));
        return;
    L5:
        this.b++;
        this.c++;
    }

    public final void g() {
        int r0 = this.b;
        int r1 = this.c;
        this.h = true;
        int r2 = this.a.length();
    L3:
        if (r0 >= r2) goto L11;
        char r3 = this.a.charAt(r0);
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
        this.h = false;
    L11:
        this.e = r0;
        this.f = r1;
        this.g = r1 - this.c;
    }

    public final d h() {
        List<d> r0 = this.n;
        return (d) ListProtector.get(r0, ((ArrayList) r0).size() - 1);
    }

    public final void a(d r3) {
    L3:
        if (h().e(r3.a()) == true) goto L5;
        e(h());
        goto L3
    L5:
        h().a().b(r3.a());
        ((ArrayList) this.n).add(r3);
        this.o.add(r3);
    }

    public final void b(q r5) {
        LinkReferenceDefinitionParser r0 = r5.b;
        r0.a();
        Iterator r1 = ((ArrayList) r0.c).iterator();
    L4:
        if (r1.hasNext() == false) goto L14;
        LinkReferenceDefinition r2 = (LinkReferenceDefinition) r1.next();
        Paragraph r3 = r5.a;
        r3.getClass();
        r2.g();
        b r4 = r3.d;
        r2.d = r4;
        if (r4 == null) goto L8;
        r4.e = r2;
    L8:
        r2.e = r3;
        r3.d = r2;
        b r6 = r3.a;
        r2.a = r6;
        if (r2.d != null) goto L11;
        r6.b = r2;
    L11:
        String r7 = r2.h;
        if (this.m.containsKey(r7) == true) goto L4;
        this.m.put(r7, r2);
        goto L4
    }

    public final void e(d r3) {
        if (h() != r3) goto L6;
        List<d> r0 = this.n;
        ListProtector.remove(r0, ((ArrayList) r0).size() - 1);
    L6:
        if ((r3 instanceof q) == false) goto L8;
        b((q) r3);
    L8:
        r3.c();
    }

    public final void f(List<d> r3) {
        ArrayList r4 = (ArrayList) r3;
        int r0 = r4.size();
    L3:
        r0 = r0 - 1;
        if (r0 < 0) goto L6;
        e((d) ListProtector.get(r4, r0));
        goto L3
    }

    public final void i(CharSequence r12) {
        String r13 = (String) r12;
        int r0 = r13.length();
        StringBuilder r4 = null;
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L12;
        char r5 = r13.charAt(r3);
        if (r5 == 0) goto L8;
        if (r4 == null) goto L11;
        r4.append(r5);
    L11:
        r3 = r3 + 1;
        goto L3
    L8:
        if (r4 != null) goto L10;
        r4 = new StringBuilder(r0);
        r4.append(r13, 0, r3);
    L10:
        r4.append(65533);
        goto L11
    L12:
        if (r4 == null) goto L14;
        r13 = r4.toString();
    L14:
        this.a = r13;
        this.b = 0;
        this.c = 0;
        this.d = false;
        ArrayList r14 = (ArrayList) this.n;
        Iterator r15 = r14.subList(1, r14.size()).iterator();
        int r1 = 1;
    L16:
        if (r15.hasNext() == false) goto L30;
        d r6 = (d) r15.next();
        g();
        b r7 = r6.f(this);
        if ((r7 instanceof b) == false) goto L30;
        b r8 = r7;
        if (r8.c == true) goto L21;
        int r9 = r8.a;
        if (r9 == (-1)) goto L26;
        k(r9);
    L29:
        r1 = r1 + 1;
        goto L16
    L26:
        int r10 = r8.b;
        if (r10 == (-1)) goto L29;
        j(r10);
        goto L29
    L21:
        e(r6);
        return;
    L30:
        ArrayList r11 = (ArrayList) this.n;
        ArrayList r16 = new ArrayList(r11.subList(r1, r11.size()));
        d r2 = (d) ListProtector.get(this.n, r1 - 1);
        boolean r17 = r16.isEmpty();
        if ((r2.a() instanceof Paragraph) == false) goto L33;
    L36:
        boolean r18 = true;
    L37:
        if (r18 == false) goto L72;
        g();
        if (this.h == true) goto L71;
        if (this.g < 4) goto L43;
    L45:
        a r19 = new a(r2);
        Iterator<e> r20 = this.i.iterator();
    L47:
        if (r20.hasNext() == false) goto L51;
        f r21 = r20.next().a(this, r19);
        if ((r21 instanceof d) == false) goto L47;
        d r22 = (d) r21;
    L52:
        if (r22 == null) goto L53;
        if (r17 == true) goto L56;
        f(r16);
        r17 = true;
    L56:
        int r23 = r22.b;
        if (r23 == (-1)) goto L59;
        k(r23);
    L63:
        if (r22.d == false) goto L68;
        d r24 = h();
        List<d> r25 = this.n;
        ListProtector.remove(r25, ((ArrayList) r25).size() - 1);
        this.o.remove(r24);
        if ((r24 instanceof q) == false) goto L67;
        b((q) r24);
    L67:
        r24.a().g();
    L68:
        d[] r26 = r22.a;
        int r27 = r26.length;
        int r28 = 0;
    L69:
        if (r28 >= r27) goto L37;
        r2 = r26[r28];
        a(r2);
        r18 = r2.isContainer();
        r28 = r28 + 1;
        goto L69
    L59:
        int r29 = r22.c;
        if (r29 == (-1)) goto L63;
        j(r29);
        goto L63
    L53:
        k(this.e);
        goto L72
    L51:
        r22 = null;
        goto L52
    L43:
        if (Character.isLetter(Character.codePointAt(this.a, this.e)) == false) goto L45;
    L71:
        k(this.e);
    L72:
        if (r17 == false) goto L74;
    L78:
        if (r17 == true) goto L81;
        f(r16);
    L81:
        if (r2.isContainer() == true) goto L84;
        c();
        return;
    L84:
        if (this.h == true) goto L110;
        a(new q(0));
        c();
        return;
    L110:
        return;
    L74:
        if (this.h == true) goto L78;
        if (h().b() == false) goto L78;
        c();
        return;
    L33:
        if (r2.isContainer() == true) goto L36;
        r18 = false;
        goto L37
    }

    public final void j(int r4) {
        int r0 = this.f;
        if (r4 < r0) goto L5;
        this.b = this.e;
        this.c = r0;
    L5:
        int r1 = this.a.length();
    L6:
        int r2 = this.c;
        if (r2 >= r4) goto L11;
        if (this.b == r1) goto L11;
        d();
    L11:
        if (r2 <= r4) goto L13;
        this.b--;
        this.c = r4;
        this.d = true;
        return;
    L13:
        this.d = false;
    }

    public final void k(int r3) {
        int r0 = this.e;
        if (r3 < r0) goto L5;
        this.b = r0;
        this.c = this.f;
    L5:
        int r1 = this.a.length();
    L6:
        int r2 = this.b;
        if (r2 >= r3) goto L10;
        if (r2 == r1) goto L10;
        d();
    L10:
        this.d = false;
    }

    public h(List r3, c r4, List r5) {
        this.b = 0;
        this.c = 0;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.m = new LinkedHashMap();
        ArrayList r0 = new ArrayList();
        this.n = r0;
        LinkedHashSet r1 = new LinkedHashSet();
        this.o = r1;
        this.i = r3;
        this.j = r4;
        this.k = r5;
        g r6 = new g();
        this.l = r6;
        r0.add(r6);
        r1.add(r6);
    }
}
