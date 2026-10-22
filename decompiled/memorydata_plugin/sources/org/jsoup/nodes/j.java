package org.jsoup.nodes;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.jsoup.SerializationException;
import org.jsoup.select.NodeFilter;

/* JADX INFO: loaded from: classes7.dex */
public abstract class j implements Cloneable {
    static final List<j> c = null;
    j d;
    int e;

    private static class a implements org.jsoup.select.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Appendable f18265a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Document.OutputSettings f18266b;

        a(Appendable r3, Document.OutputSettings r4) {
            this.f18265a = (Appendable) ZeusTransformUtils.wrapperContextForParams(r3, Appendable.class, "com.obric.memorydata.plugin");
            this.f18266b = r4;
            r4.b();
        }

        @Override // org.jsoup.select.e
        public void a(j r3, int r4) {
            if (r3.a().equals("#text") == false) goto L10;
            return;
        L10:
            r3.b(this.f18265a, r4, this.f18266b);     // Catch: IOException -> L6
            return;
        L6:
            e = move-exception;
            throw new SerializationException(e);
        }

        @Override // org.jsoup.select.e
        public void head(j r2, int r3) {
            r2.a(this.f18265a, r3, this.f18266b);     // Catch: IOException -> L4
            return;
        L4:
            e = move-exception;
            throw new SerializationException(e);
        }
    }

    static {
        c = Collections.emptyList();
    }

    public j() {
    }

    private Element a(Element r2) {
    L3:
        if (r2.x() <= 0) goto L5;
        r2 = (Element) ZeusTransformUtils.preCheckCast(r2.z().get(0), Element.class, "com.obric.memorydata.plugin");
        goto L3
    L5:
        return r2;
    }

    private void a(int r5) {
        int r0 = f();
        if (r0 != 0) goto L5;
        return;
    L5:
        List<j> r4 = n();
    L6:
        if (r5 >= r0) goto L8;
        ((j) ZeusTransformUtils.preCheckCast(r4.get(r5), j.class, "com.obric.memorydata.plugin")).c(r5);
        r5 = r5 + 1;
        goto L6
    }

    private void a(int r5, String r6) {
        org.jsoup.helper.b.a(r6);
        org.jsoup.helper.b.a(this.d);
        if (ZeusTransformUtils.instanceOf(U(), Element.class) == false) goto L5;
        Element r0 = (Element) ZeusTransformUtils.preCheckCast(U(), Element.class, "com.obric.memorydata.plugin");
    L6:
        List<j> r7 = k.b(this).a(r6, r0, g());
        this.d.a(r5, (j[]) ZeusTransformUtils.preCheckCast(r7.toArray(new j[0]), j[].class, "com.obric.memorydata.plugin"));
        return;
    L5:
        r0 = null;
        goto L6
    }

    static boolean a(j r0, String r1) {
        if (r0 != null) goto L4;
    L6:
        return false;
    L4:
        if (r0.r().equals(r1) == false) goto L6;
        return true;
    }

    void A() {
    }

    final boolean A(String r1) {
        return r().equals(r1);
    }

    public j T() {
    L2:
        j r0 = this.d;
        if (r0 == null) goto L5;
        j this = r0;
        goto L2
    L5:
        return this;
    }

    public j U() {
        return this.d;
    }

    public boolean V() {
        if (this.d == null) goto L5;
        return true;
    L5:
        return false;
    }

    public List<j> W() {
        if (f() == 0) goto L5;
        List<j> r2 = n();
        ArrayList r0 = new ArrayList(r2.size());
        r0.addAll(r2);
        return Collections.unmodifiableList(r0);
    L5:
        return c;
    }

    public j[] X() {
        return (j[]) ZeusTransformUtils.preCheckCast(n().toArray(new j[0]), j[].class, "com.obric.memorydata.plugin");
    }

    public final j Y() {
        return this.d;
    }

    public Document Z() {
        j r2 = T();
        if (ZeusTransformUtils.instanceOf(r2, Document.class) == true) goto L7;
        return null;
    L7:
        return (Document) ZeusTransformUtils.preCheckCast(r2, Document.class, "com.obric.memorydata.plugin");
    }

    public <T extends Appendable> T a(T r3) {
        T r4 = (T) ZeusTransformUtils.wrapperContextForParams(r3, Appendable.class, "com.obric.memorydata.plugin");
        b(r4);
        return r4;
    }

    public abstract String a();

    public String a(String r2) {
        org.jsoup.helper.b.a(r2);
        if (o() == true) goto L5;
        return "";
    L5:
        if (p().h(r2) == true) goto L8;
        return "";
    L8:
        return org.jsoup.a.b.a(g(), p().c(r2));
    }

    public j a(String r2, String r3) {
        String r4 = k.b(this).e().b(r2);
        p().c(r4, r3);
        return this;
    }

    public void a(int r9, j... r10) {
        org.jsoup.helper.b.a(r10);
        if (r10.length != 0) goto L5;
        return;
    L5:
        List<j> r0 = n();
        int r1 = 0;
        j r2 = r10[0].U();
        if (r2 != null) goto L8;
    L31:
        org.jsoup.helper.b.a(r10);
        int r3 = r10.length;
    L32:
        if (r1 >= r3) goto L34;
        l(r10[r1]);
        r1 = r1 + 1;
        goto L32
    L34:
        r0.addAll(r9, Arrays.asList(r10));
        a(r9);
        return;
    L8:
        if (r2.f() != r10.length) goto L31;
        List<j> r4 = r2.n();
        int r5 = r10.length;
    L10:
        int r6 = r5 - 1;
        boolean r7 = true;
        if (r5 <= 0) goto L16;
        if (r10[r6] != r4.get(r6)) goto L14;
        r5 = r6;
        goto L10
    L14:
        boolean r8 = false;
    L17:
        if (r8 == false) goto L31;
        if (f() == 0) goto L22;
        r7 = false;
    L22:
        r2.e();
        r0.addAll(r9, Arrays.asList(r10));
        int r11 = r10.length;
    L23:
        int r12 = r11 - 1;
        if (r11 <= 0) goto L26;
        r10[r12].d = this;
        r11 = r12;
        goto L23
    L26:
        if (r7 == true) goto L28;
    L29:
        a(r9);
        return;
    L28:
        if (r10[0].e != 0) goto L29;
        return;
    L16:
        r8 = true;
        goto L17
    }

    abstract void a(Appendable r1, int r2, Document.OutputSettings r3);

    public void a(j r3, j r4) {
        if (r3.d != this) goto L5;
        boolean r0 = true;
    L6:
        org.jsoup.helper.b.a(r0);
        org.jsoup.helper.b.a(r4);
        if (r3 != r4) goto L9;
        return;
    L9:
        j r1 = r4.d;
        if (r1 == null) goto L12;
        r1.i(r4);
    L12:
        int r2 = r3.e;
        n().set(r2, r4);
        r4.d = this;
        r4.c(r2);
        r3.d = null;
        return;
    L5:
        r0 = false;
        goto L6
    }

    public void a(j... r6) {
        List<j> r0 = n();
        int r1 = r6.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        j r3 = r6[r2];
        l(r3);
        r0.add(r3);
        r3.c(r0.size() - 1);
        r2 = r2 + 1;
        goto L3
    }

    public void aa() {
        org.jsoup.helper.b.a(this.d);
        this.d.i(this);
    }

    public j ab() {
        org.jsoup.helper.b.a(this.d);
        j r0 = ag();
        this.d.a(this.e, X());
        aa();
        return r0;
    }

    public List<j> ac() {
        j r0 = this.d;
        if (r0 == null) goto L5;
        List<j> r1 = r0.n();
        ArrayList r2 = new ArrayList(r1.size() - 1);
        Iterator<j> r3 = r1.iterator();
    L8:
        if (r3.hasNext() == false) goto L12;
        j r4 = (j) ZeusTransformUtils.preCheckCast(r3.next(), j.class, "com.obric.memorydata.plugin");
        if (r4 == this) goto L8;
        r2.add(r4);
        goto L8
    L12:
        return r2;
    L5:
        return Collections.emptyList();
    }

    public j ad() {
        j r0 = this.d;
        if (r0 != null) goto L5;
        return null;
    L5:
        List<j> r1 = r0.n();
        int r3 = this.e + 1;
        if (r1.size() > r3) goto L8;
        return null;
    L8:
        return (j) ZeusTransformUtils.preCheckCast(r1.get(r3), j.class, "com.obric.memorydata.plugin");
    }

    public j ae() {
        j r0 = this.d;
        if (r0 != null) goto L6;
        return null;
    L6:
        if (this.e > 0) goto L8;
        return null;
    L8:
        return (j) ZeusTransformUtils.preCheckCast(r0.n().get(this.e - 1), j.class, "com.obric.memorydata.plugin");
    }

    public int af() {
        return this.e;
    }

    public j ag() {
        if (f() != 0) goto L7;
        return null;
    L7:
        return (j) ZeusTransformUtils.preCheckCast(n().get(0), j.class, "com.obric.memorydata.plugin");
    }

    public m ah() {
        return m.a(this, true);
    }

    public j b(int r2) {
        return (j) ZeusTransformUtils.preCheckCast(n().get(r2), j.class, "com.obric.memorydata.plugin");
    }

    public j b(String r2) {
        org.jsoup.helper.b.a(r2);
        if (o() == false) goto L5;
        p().f(r2);
    L5:
        return this;
    }

    public j b(NodeFilter r3) {
        NodeFilter r4 = (NodeFilter) ZeusTransformUtils.wrapperContextForParams(r3, NodeFilter.class, "com.obric.memorydata.plugin");
        org.jsoup.helper.b.a(r4);
        org.jsoup.select.d.a(r4, this);
        return this;
    }

    public j b(org.jsoup.select.e r3) {
        org.jsoup.select.e r4 = (org.jsoup.select.e) ZeusTransformUtils.wrapperContextForParams(r3, org.jsoup.select.e.class, "com.obric.memorydata.plugin");
        org.jsoup.helper.b.a(r4);
        org.jsoup.select.d.a(r4, this);
        return this;
    }

    public void b(Appendable r3) {
        org.jsoup.select.d.a(new a((Appendable) ZeusTransformUtils.wrapperContextForParams(r3, Appendable.class, "com.obric.memorydata.plugin"), k.a(this)), this);
    }

    abstract void b(Appendable r1, int r2, Document.OutputSettings r3);

    public void c(int r1) {
        this.e = r1;
    }

    public void c(Appendable r2, int r3, Document.OutputSettings r4) {
        ((Appendable) ZeusTransformUtils.wrapperContextForParams(r2, Appendable.class, "com.obric.memorydata.plugin")).append('\n').append(org.jsoup.a.b.a(r3 * r4.g(), r4.h()));
    }

    public boolean c(String r3) {
        org.jsoup.helper.b.a(r3);
        if (o() == true) goto L7;
        return false;
    L7:
        if (r3.startsWith("abs:") == false) goto L15;
        String r0 = r3.substring(4);
        if (p().h(r0) == false) goto L15;
        if (a(r0).isEmpty() == true) goto L15;
        return true;
    L15:
        return p().h(r3);
    }

    public /* synthetic */ Object clone() {
        return d();
    }

    public String d(String r4) {
        org.jsoup.helper.b.a(r4);
        if (o() == true) goto L5;
        return "";
    L5:
        String r0 = p().c(r4);
        if (r0.length() <= 0) goto L9;
        return r0;
    L9:
        if (r4.startsWith("abs:") == true) goto L11;
        return "";
    L11:
        return a(r4.substring(4));
    }

    public j d() {
        j r8 = f(null);
        LinkedList r1 = new LinkedList();
        r1.add(r8);
    L4:
        if (r1.isEmpty() == true) goto L8;
        j r2 = (j) ZeusTransformUtils.preCheckCast(r1.remove(), j.class, "com.obric.memorydata.plugin");
        int r4 = r2.f();
        int r5 = 0;
    L6:
        if (r5 >= r4) goto L4;
        List<j> r6 = r2.n();
        j r7 = ((j) ZeusTransformUtils.preCheckCast(r6.get(r5), j.class, "com.obric.memorydata.plugin")).f(r2);
        r6.set(r5, r7);
        r1.add(r7);
        r5 = r5 + 1;
        goto L6
    L8:
        return r8;
    }

    public abstract j e();

    public boolean equals(Object r1) {
        if (this != r1) goto L4;
        return true;
    L4:
        return false;
    }

    public abstract int f();

    public j f(j r4) {
        j r0 = (j) ZeusTransformUtils.preCheckCast(super.clone(), j.class, "com.obric.memorydata.plugin");     // Catch: CloneNotSupportedException -> L15
        r0.d = r4;
        if (r4 != null) goto L6;
        int r1 = 0;
    L7:
        r0.e = r1;
        if (r4 == null) goto L10;
    L14:
        return r0;
    L10:
        if (ZeusTransformUtils.instanceOf(this, Document.class) == true) goto L14;
        Document r3 = Z();
        if (r3 == null) goto L14;
        Document r5 = r3.i();
        r0.d = r5;
        r5.n().add(r0);
        goto L14
    L6:
        r1 = this.e;
    L15:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public abstract String g();

    public j g(j r5) {
        org.jsoup.helper.b.a(r5);
        org.jsoup.helper.b.a(this.d);
        this.d.a(this.e + 1, new j[]{r5});
        return this;
    }

    public abstract void g(String r1);

    public j h(j r5) {
        org.jsoup.helper.b.a(r5);
        org.jsoup.helper.b.a(this.d);
        this.d.a(this.e, new j[]{r5});
        return this;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public void i(j r3) {
        if (r3.d != this) goto L5;
        boolean r0 = true;
    L6:
        org.jsoup.helper.b.a(r0);
        int r1 = r3.e;
        n().remove(r1);
        a(r1);
        r3.d = null;
        return;
    L5:
        r0 = false;
        goto L6
    }

    public void j(j r2) {
        org.jsoup.helper.b.a(r2);
        org.jsoup.helper.b.a(this.d);
        this.d.a(this, r2);
    }

    public void k(j r2) {
        org.jsoup.helper.b.a(r2);
        j r0 = this.d;
        if (r0 == null) goto L5;
        r0.i(this);
    L5:
        this.d = r2;
    }

    public void l(j r1) {
        r1.k(this);
    }

    public abstract List<j> n();

    public abstract boolean o();

    public abstract b p();

    public String r() {
        return a();
    }

    public String toString() {
        return x_();
    }

    public j w(String r7) {
        org.jsoup.helper.b.a(r7);
        j r1 = this.d;
        if (r1 == null) goto L8;
        if (ZeusTransformUtils.instanceOf(r1, Element.class) == false) goto L8;
        Object r2 = ZeusTransformUtils.preCheckCast(this.d, Element.class, "com.obric.memorydata.plugin");
    L10:
        Element r3 = (Element) r2;
    L12:
        List<j> r8 = k.b(this).a(r7, r3, g());
        int r4 = 0;
        j r5 = (j) ZeusTransformUtils.preCheckCast(r8.get(0), j.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r5, Element.class) == true) goto L15;
        return this;
    L15:
        Element r6 = (Element) ZeusTransformUtils.preCheckCast(r5, Element.class, "com.obric.memorydata.plugin");
        Element r9 = a(r6);
        j r10 = this.d;
        if (r10 == null) goto L18;
        r10.a(this, r6);
    L18:
        r9.a(new j[]{this});
        if (r8.size() > 0) goto L21;
    L30:
        return this;
    L21:
        if (r4 >= r8.size()) goto L30;
        j r11 = (j) ZeusTransformUtils.preCheckCast(r8.get(r4), j.class, "com.obric.memorydata.plugin");
        if (r6 == r11) goto L29;
        j r12 = r11.d;
        if (r12 == null) goto L28;
        r12.i(r11);
    L28:
        r6.c(r11);
    L29:
        r4 = r4 + 1;
    L8:
        if (ZeusTransformUtils.instanceOf(this, Element.class) == false) goto L11;
        r2 = ZeusTransformUtils.preCheckCast(this, Element.class, "com.obric.memorydata.plugin");
        goto L10
    L11:
        r3 = null;
        goto L12
    }

    public j x(String r2) {
        a(this.e + 1, r2);
        return this;
    }

    public String x_() {
        StringBuilder r0 = org.jsoup.a.b.a();
        b(r0);
        return org.jsoup.a.b.a(r0);
    }

    public j y(String r2) {
        a(this.e, r2);
        return this;
    }

    public void z(String r1) {
        org.jsoup.helper.b.a(r1);
        g(r1);
    }
}
