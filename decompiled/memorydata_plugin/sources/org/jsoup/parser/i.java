package org.jsoup.parser;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.j;
import org.jsoup.nodes.m;

/* JADX INFO: loaded from: classes7.dex */
abstract class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Token.g f18299a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Token.f f18300b;
    private boolean c;
    protected e j;
    a k;
    h l;
    protected Document m;
    protected ArrayList<Element> n;
    protected String o;
    protected Token p;
    protected d q;
    protected Map<String, f> r;

    i() {
        this.f18299a = new Token.g();
        this.f18300b = new Token.f();
    }

    private void a(j r5, Token r6, boolean r7) {
        if (this.c == false) goto L10;
        if (r6 == null) goto L11;
        int r0 = r6.c();
        if (r0 != (-1)) goto L8;
        return;
    L8:
        m.a r1 = new m.a(r0, this.k.a(r0), this.k.b(r0));
        int r8 = r6.d();
        new m(r1, new m.a(r8, this.k.a(r8), this.k.b(r8))).b(r5, r7);
        return;
    L11:
        return;
    }

    public void D() {
        h r0 = this.l;
        Token.TokenType r1 = Token.TokenType.EOF;
    L3:
        Token r2 = r0.a();
        a(r2);
        r2.b();
        if (r2.f18276a != r1) goto L3;
    }

    public Element E() {
        int r0 = this.n.size();
        if (r0 <= 0) goto L6;
        return (Element) ZeusTransformUtils.preCheckCast(this.n.get(r0 - 1), Element.class, "com.obric.memorydata.plugin");
    L6:
        return this.m;
    }

    abstract List<j> a(String r1, Element r2, String r3, e r4);

    abstract d a();

    public f a(String r4, d r5) {
        f r0 = (f) ZeusTransformUtils.preCheckCast(this.r.get(r4), f.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L6;
        f r1 = f.a(r4, r5);
        this.r.put(r4, r1);
        return r1;
    L6:
        return r0;
    }

    public void a(Reader r2, String r3, e r4) {
        org.jsoup.helper.b.a(r2, "input");
        org.jsoup.helper.b.a(r3, "baseUri");
        org.jsoup.helper.b.a(r4);
        Document r0 = new Document(r3);
        this.m = r0;
        r0.a(r4);
        this.j = r4;
        this.q = r4.e();
        this.k = new a(r2);
        this.c = r4.d();
        a r5 = this.k;
        if (r4.b() == false) goto L5;
    L8:
        boolean r1 = true;
    L9:
        r5.a(r1);
        this.p = null;
        this.l = new h(this.k, r4.c());
        this.n = new ArrayList(32);
        this.r = new HashMap();
        this.o = r3;
        return;
    L5:
        if (this.c == true) goto L8;
        r1 = false;
        goto L9
    }

    public void a(String r3, Object... r4) {
        ParseErrorList r0 = this.j.c();
        if (r0.canAddError() == false) goto L6;
        r0.add(new c(this.k, r3, r4));
        return;
    }

    public void a(j r2, Token r3) {
        a(r2, r3, true);
    }

    public boolean a(String r3, org.jsoup.nodes.b r4) {
        Token.g r0 = this.f18299a;
        if (this.p == r0) goto L5;
        r0.q();
        r0.a(r3, r4);
        return a(r0);
    L5:
        return a(new Token.g().a(r3, r4));
    }

    public abstract boolean a(Token r1);

    Document b(Reader r1, String r2, e r3) {
        a(r1, r2, r3);
        D();
        this.k.a();
        this.k = null;
        this.l = null;
        this.n = null;
        this.r = null;
        return this.m;
    }

    public void b(j r2, Token r3) {
        a(r2, r3, false);
    }

    public boolean n(String r1) {
        return false;
    }

    public boolean o(String r3) {
        Token.g r0 = this.f18299a;
        if (this.p != r0) goto L7;
        Token.h r4 = new Token.g().b(r3);
    L6:
        return a(r4);
    L7:
        r4 = r0.q().b(r3);
        goto L6
    }

    public boolean p(String r3) {
        Token r0 = this.p;
        Token.f r1 = this.f18300b;
        if (r0 != r1) goto L7;
        Token.h r4 = new Token.f().b(r3);
    L6:
        return a(r4);
    L7:
        r4 = r1.q().b(r3);
        goto L6
    }

    public boolean q(String r3) {
        if (this.n.size() != 0) goto L5;
        return false;
    L5:
        Element r2 = E();
        if (r2 != null) goto L8;
        return false;
    L8:
        if (r2.r().equals(r3) == false) goto L12;
        return true;
    L12:
        return false;
    }
}
