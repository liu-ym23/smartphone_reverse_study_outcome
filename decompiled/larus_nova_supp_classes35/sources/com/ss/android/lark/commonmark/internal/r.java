package com.ss.android.lark.commonmark.internal;

import java.util.ArrayList;
import java.util.List;
import v7b.v;
import v7b.x;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class r extends y7b.a {
    public final v a;
    public final LinkReferenceDefinitionParser b;

    @Override // y7b.a, y7b.d
    public final void c() {
        List<w7b.f> r0 = this.b.b;
        ArrayList r1 = new ArrayList();
        r1.addAll(r0);
        if (r1.isEmpty() == false) goto L5;
        this.a.p();
        return;
    L5:
        this.a.n(this.b.d);
    }

    public r() {
        this.a = new v();
        this.b = new LinkReferenceDefinitionParser();
    }

    @Override // y7b.d
    public final v7b.a a() {
        return this.a;
    }

    @Override // y7b.a, y7b.d
    public final void d(n r4) {
        List<w7b.f> r0 = this.b.b;
        w7b.g r1 = new w7b.g();
        ((ArrayList) r1.a).addAll(r0);
        if (((ArrayList) r1.a).isEmpty() == true) goto L6;
        r4.e(r1, this.a);
        return;
    }

    @Override // y7b.a, y7b.d
    public final void e(w7b.f r9) {
        LinkReferenceDefinitionParser r0 = this.b;
        ((ArrayList) r0.b).add(r9);
        if (r0.a == LinkReferenceDefinitionParser.State.PARAGRAPH) goto L103;
        ArrayList r1 = new ArrayList();
        r1.add(r9);
        x7b.e r10 = new x7b.e(r1);
    L7:
        if (r10.d() == false) goto L104;
        int r2 = LinkReferenceDefinitionParser.a.a[r0.a.ordinal()];
        boolean r3 = false;
        if (r2 != 1) goto L11;
        r0.a();
        r10.m();
        if (r10.h('[') == false) goto L85;
        r0.a = LinkReferenceDefinitionParser.State.LABEL;
        r0.e = new StringBuilder();
        if (r10.d() == true) goto L84;
        r0.e.append('\n');
    L84:
        r3 = true;
    L85:
        if (r3 == true) goto L7;
        r0.a = LinkReferenceDefinitionParser.State.PARAGRAPH;
        r0.a();
        return;
    L11:
        if (r2 != 2) goto L13;
        x7b.d r4 = r10.k();
        if (u7b.c.c(r10) == false) goto L85;
        r0.e.append(r10.c(r4, r10.k()).a());
        if (r10.d() == true) goto L67;
        r0.e.append('\n');
        goto L84
    L67:
        if (r10.h(']') == false) goto L85;
        if (r10.h(':') == false) goto L85;
        if (r0.e.length() > 999) goto L85;
        if (u7b.a.a(r0.e.toString()).isEmpty() == true) goto L85;
        r0.a = LinkReferenceDefinitionParser.State.DESTINATION;
        r10.m();
        goto L84
    L13:
        if (r2 != 3) goto L15;
        r10.m();
        x7b.d r5 = r10.k();
        if (u7b.c.b(r10) == false) goto L85;
        String r6 = r10.c(r5, r10.k()).a();
        if (r6.startsWith("<") == false) goto L54;
        r6 = r6.substring(1, r6.length() - 1);
    L54:
        r0.f = r6;
        int r7 = r10.m();
        if (r10.d() == true) goto L57;
        r0.i = true;
        ((ArrayList) r0.b).clear();
    L59:
        r0.a = LinkReferenceDefinitionParser.State.START_TITLE;
        goto L84
    L57:
        if (r7 != 0) goto L59;
    L15:
        if (r2 != 4) goto L17;
        r10.m();
        if (r10.d() == true) goto L33;
        r0.a = LinkReferenceDefinitionParser.State.START_DEFINITION;
        goto L84
    L33:
        r0.g = 0;
        char r8 = r10.j();
        if (r8 != '\"') goto L36;
    L41:
        r0.g = r8;
    L43:
        if (r0.g == 0) goto L47;
        r0.a = LinkReferenceDefinitionParser.State.TITLE;
        r0.h = new StringBuilder();
        r10.g();
        if (r10.d() == true) goto L84;
        r0.h.append('\n');
        goto L84
    L47:
        r0.a = LinkReferenceDefinitionParser.State.START_DEFINITION;
        goto L84
    L36:
        if (r8 == '\'') goto L41;
        if (r8 != '(') goto L43;
        r0.g = ')';
        goto L43
    L17:
        if (r2 != 5) goto L29;
        x7b.d r11 = r10.k();
        if (u7b.c.d(r10, r0.g) == true) goto L21;
        r0.h = null;
        goto L85
    L21:
        r0.h.append(r10.c(r11, r10.k()).a());
        if (r10.d() == true) goto L24;
        r0.h.append('\n');
        goto L84
    L24:
        r10.g();
        r10.m();
        if (r10.d() == false) goto L27;
        r0.h = null;
        goto L85
    L27:
        r0.i = true;
        ((ArrayList) r0.b).clear();
        r0.a = LinkReferenceDefinitionParser.State.START_DEFINITION;
        goto L84
    L29:
        throw new IllegalStateException("Unknown parsing state: " + r0.a);
    L104:
        return;
    }

    @Override // y7b.a, y7b.d
    public final void f(x r2) {
        ((ArrayList) this.b.d).add(r2);
    }

    @Override // y7b.d
    public final y7b.c h(y7b.g r2) {
        h r3 = (h) r2;
        if (r3.i == false) goto L5;
        return null;
    L5:
        return y7b.c.a(r3.c);
    }
}
