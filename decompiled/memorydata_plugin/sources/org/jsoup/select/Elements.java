package org.jsoup.select;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.h;
import org.jsoup.nodes.j;
import org.jsoup.nodes.n;

/* JADX INFO: loaded from: classes7.dex */
public class Elements extends ArrayList<Element> {
    public Elements() {
    }

    public Elements(int r1) {
        super(r1);
    }

    public Elements(Collection<Element> r3) {
        super((Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin"));
    }

    public Elements(List<Element> r3) {
        super((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    public Elements(Element... r1) {
        super(Arrays.asList(r1));
    }

    private <T extends j> List<T> childNodesOfType(Class<T> r7) {
        ArrayList r0 = new ArrayList();
        Iterator<Element> r6 = iterator();
    L4:
        if (r6.hasNext() == false) goto L12;
        Element r1 = (Element) ZeusTransformUtils.preCheckCast(r6.next(), Element.class, "com.obric.memorydata.plugin");
        int r2 = 0;
    L7:
        if (r2 >= r1.f()) goto L4;
        j r4 = r1.b(r2);
        if (ZeusTransformUtils.instanceOf(r7, r4) == false) goto L11;
        r0.add((j) ZeusTransformUtils.preCheckCast(r7.cast(r4), j.class, "com.obric.memorydata.plugin"));
    L11:
        r2 = r2 + 1;
        goto L7
    L12:
        return r0;
    }

    private Elements siblings(String r5, boolean r6, boolean r7) {
        Elements r0 = new Elements();
        if (r5 == null) goto L5;
        c r8 = f.a(r5);
    L6:
        Iterator<Element> r4 = iterator();
    L8:
        if (r4.hasNext() == false) goto L22;
        Element r1 = (Element) ZeusTransformUtils.preCheckCast(r4.next(), Element.class, "com.obric.memorydata.plugin");
    L10:
        if (r6 == false) goto L12;
        r1 = r1.E();
    L13:
        if (r1 == null) goto L8;
        if (r8 != null) goto L18;
    L16:
        r0.add(r1);
    L20:
        if (r7 == true) goto L10;
    L18:
        if (r1.a(r8) == false) goto L20;
    L12:
        r1 = r1.F();
        goto L13
    L22:
        return r0;
    L5:
        r8 = null;
        goto L6
    }

    public Elements addClass(String r5) {
        Iterator<Element> r0 = iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((Element) ZeusTransformUtils.preCheckCast(r0.next(), Element.class, "com.obric.memorydata.plugin")).q(r5);
        goto L4
    L6:
        return this;
    }

    public Elements after(String r5) {
        Iterator<Element> r0 = iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((Element) ZeusTransformUtils.preCheckCast(r0.next(), Element.class, "com.obric.memorydata.plugin")).n(r5);
        goto L4
    L6:
        return this;
    }

    public Elements append(String r5) {
        Iterator<Element> r0 = iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((Element) ZeusTransformUtils.preCheckCast(r0.next(), Element.class, "com.obric.memorydata.plugin")).k(r5);
        goto L4
    L6:
        return this;
    }

    public String attr(String r4) {
        Iterator<Element> r3 = iterator();
    L4:
        if (r3.hasNext() == false) goto L9;
        Element r0 = (Element) ZeusTransformUtils.preCheckCast(r3.next(), Element.class, "com.obric.memorydata.plugin");
        if (r0.c(r4) == false) goto L4;
        return r0.d(r4);
    L9:
        return "";
    }

    public Elements attr(String r5, String r6) {
        Iterator<Element> r0 = iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((Element) ZeusTransformUtils.preCheckCast(r0.next(), Element.class, "com.obric.memorydata.plugin")).b(r5, r6);
        goto L4
    L6:
        return this;
    }

    public Elements before(String r5) {
        Iterator<Element> r0 = iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((Element) ZeusTransformUtils.preCheckCast(r0.next(), Element.class, "com.obric.memorydata.plugin")).m(r5);
        goto L4
    L6:
        return this;
    }

    @Override // java.util.ArrayList
    public /* bridge */ /* synthetic */ Object clone() {
        return clone();
    }

    @Override // java.util.ArrayList
    public Elements clone() {
        Elements r0 = new Elements(size());
        Iterator<Element> r4 = iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        r0.add(((Element) ZeusTransformUtils.preCheckCast(r4.next(), Element.class, "com.obric.memorydata.plugin")).m());
        goto L4
    L6:
        return r0;
    }

    public List<org.jsoup.nodes.d> comments() {
        return childNodesOfType(org.jsoup.nodes.d.class);
    }

    public List<org.jsoup.nodes.e> dataNodes() {
        return childNodesOfType(org.jsoup.nodes.e.class);
    }

    public List<String> eachAttr(String r5) {
        ArrayList r0 = new ArrayList(size());
        Iterator<Element> r4 = iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        Element r1 = (Element) ZeusTransformUtils.preCheckCast(r4.next(), Element.class, "com.obric.memorydata.plugin");
        if (r1.c(r5) == false) goto L4;
        r0.add(r1.d(r5));
        goto L4
    L8:
        return r0;
    }

    public List<String> eachText() {
        ArrayList r0 = new ArrayList(size());
        Iterator<Element> r4 = iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        Element r1 = (Element) ZeusTransformUtils.preCheckCast(r4.next(), Element.class, "com.obric.memorydata.plugin");
        if (r1.L() == false) goto L4;
        r0.add(r1.H());
        goto L4
    L8:
        return r0;
    }

    public Elements empty() {
        Iterator<Element> r0 = iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((Element) ZeusTransformUtils.preCheckCast(r0.next(), Element.class, "com.obric.memorydata.plugin")).C();
        goto L4
    L6:
        return this;
    }

    public Elements eq(int r5) {
        if (size() <= r5) goto L6;
        return new Elements(new Element[]{(Element) ZeusTransformUtils.preCheckCast(get(r5), Element.class, "com.obric.memorydata.plugin")});
    L6:
        return new Elements();
    }

    public Elements filter(NodeFilter r3) {
        d.a((NodeFilter) ZeusTransformUtils.wrapperContextForParams(r3, NodeFilter.class, "com.obric.memorydata.plugin"), this);
        return this;
    }

    public Element first() {
        if (isEmpty() == false) goto L6;
        return null;
    L6:
        return (Element) ZeusTransformUtils.preCheckCast(get(0), Element.class, "com.obric.memorydata.plugin");
    }

    public List<h> forms() {
        ArrayList r0 = new ArrayList();
        Iterator<Element> r4 = iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        Element r1 = (Element) ZeusTransformUtils.preCheckCast(r4.next(), Element.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r1, h.class) == false) goto L4;
        r0.add((h) ZeusTransformUtils.preCheckCast(r1, h.class, "com.obric.memorydata.plugin"));
        goto L4
    L8:
        return r0;
    }

    public boolean hasAttr(String r4) {
        Iterator<Element> r3 = iterator();
    L4:
        if (r3.hasNext() == false) goto L9;
        if (((Element) ZeusTransformUtils.preCheckCast(r3.next(), Element.class, "com.obric.memorydata.plugin")).c(r4) == false) goto L4;
        return true;
    L9:
        return false;
    }

    public boolean hasClass(String r4) {
        Iterator<Element> r3 = iterator();
    L4:
        if (r3.hasNext() == false) goto L9;
        if (((Element) ZeusTransformUtils.preCheckCast(r3.next(), Element.class, "com.obric.memorydata.plugin")).p(r4) == false) goto L4;
        return true;
    L9:
        return false;
    }

    public boolean hasText() {
        Iterator<Element> r3 = iterator();
    L4:
        if (r3.hasNext() == false) goto L9;
        if (((Element) ZeusTransformUtils.preCheckCast(r3.next(), Element.class, "com.obric.memorydata.plugin")).L() == false) goto L4;
        return true;
    L9:
        return false;
    }

    public String html() {
        StringBuilder r0 = org.jsoup.a.b.a();
        Iterator<Element> r4 = iterator();
    L4:
        if (r4.hasNext() == false) goto L10;
        Element r1 = (Element) ZeusTransformUtils.preCheckCast(r4.next(), Element.class, "com.obric.memorydata.plugin");
        if (r0.length() == 0) goto L8;
        r0.append("\n");
    L8:
        r0.append(r1.R());
        goto L4
    L10:
        return org.jsoup.a.b.a(r0);
    }

    public Elements html(String r5) {
        Iterator<Element> r0 = iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((Element) ZeusTransformUtils.preCheckCast(r0.next(), Element.class, "com.obric.memorydata.plugin")).u(r5);
        goto L4
    L6:
        return this;
    }

    public boolean is(String r4) {
        c r5 = f.a(r4);
        Iterator<Element> r3 = iterator();
    L4:
        if (r3.hasNext() == false) goto L9;
        if (((Element) ZeusTransformUtils.preCheckCast(r3.next(), Element.class, "com.obric.memorydata.plugin")).a(r5) == false) goto L4;
        return true;
    L9:
        return false;
    }

    public Element last() {
        if (isEmpty() == false) goto L6;
        return null;
    L6:
        return (Element) ZeusTransformUtils.preCheckCast(get(size() - 1), Element.class, "com.obric.memorydata.plugin");
    }

    public Elements next() {
        return siblings(null, true, false);
    }

    public Elements next(String r3) {
        return siblings(r3, true, false);
    }

    public Elements nextAll() {
        return siblings(null, true, true);
    }

    public Elements nextAll(String r2) {
        return siblings(r2, true, true);
    }

    public Elements not(String r1) {
        return Selector.a(this, Selector.a(r1, this));
    }

    public String outerHtml() {
        StringBuilder r0 = org.jsoup.a.b.a();
        Iterator<Element> r4 = iterator();
    L4:
        if (r4.hasNext() == false) goto L10;
        Element r1 = (Element) ZeusTransformUtils.preCheckCast(r4.next(), Element.class, "com.obric.memorydata.plugin");
        if (r0.length() == 0) goto L8;
        r0.append("\n");
    L8:
        r0.append(r1.x_());
        goto L4
    L10:
        return org.jsoup.a.b.a(r0);
    }

    public Elements parents() {
        LinkedHashSet r0 = new LinkedHashSet();
        Iterator<Element> r4 = iterator();
    L4:
        if (r4.hasNext() == false) goto L7;
        r0.addAll(((Element) ZeusTransformUtils.preCheckCast(r4.next(), Element.class, "com.obric.memorydata.plugin")).w());
        goto L4
    L7:
        return new Elements(r0);
    }

    public Elements prepend(String r5) {
        Iterator<Element> r0 = iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((Element) ZeusTransformUtils.preCheckCast(r0.next(), Element.class, "com.obric.memorydata.plugin")).l(r5);
        goto L4
    L6:
        return this;
    }

    public Elements prev() {
        return siblings(null, false, false);
    }

    public Elements prev(String r2) {
        return siblings(r2, false, false);
    }

    public Elements prevAll() {
        return siblings(null, false, true);
    }

    public Elements prevAll(String r3) {
        return siblings(r3, false, true);
    }

    public Elements remove() {
        Iterator<Element> r0 = iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((Element) ZeusTransformUtils.preCheckCast(r0.next(), Element.class, "com.obric.memorydata.plugin")).aa();
        goto L4
    L6:
        return this;
    }

    public Elements removeAttr(String r5) {
        Iterator<Element> r0 = iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((Element) ZeusTransformUtils.preCheckCast(r0.next(), Element.class, "com.obric.memorydata.plugin")).v(r5);
        goto L4
    L6:
        return this;
    }

    public Elements removeClass(String r5) {
        Iterator<Element> r0 = iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((Element) ZeusTransformUtils.preCheckCast(r0.next(), Element.class, "com.obric.memorydata.plugin")).r(r5);
        goto L4
    L6:
        return this;
    }

    public Elements select(String r1) {
        return Selector.a(r1, this);
    }

    public Elements tagName(String r5) {
        Iterator<Element> r0 = iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((Element) ZeusTransformUtils.preCheckCast(r0.next(), Element.class, "com.obric.memorydata.plugin")).h(r5);
        goto L4
    L6:
        return this;
    }

    public String text() {
        StringBuilder r0 = org.jsoup.a.b.a();
        Iterator<Element> r4 = iterator();
    L4:
        if (r4.hasNext() == false) goto L10;
        Element r1 = (Element) ZeusTransformUtils.preCheckCast(r4.next(), Element.class, "com.obric.memorydata.plugin");
        if (r0.length() == 0) goto L8;
        r0.append(" ");
    L8:
        r0.append(r1.H());
        goto L4
    L10:
        return org.jsoup.a.b.a(r0);
    }

    public List<n> textNodes() {
        return childNodesOfType(n.class);
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return outerHtml();
    }

    public Elements toggleClass(String r5) {
        Iterator<Element> r0 = iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((Element) ZeusTransformUtils.preCheckCast(r0.next(), Element.class, "com.obric.memorydata.plugin")).s(r5);
        goto L4
    L6:
        return this;
    }

    public Elements traverse(e r3) {
        d.a((e) ZeusTransformUtils.wrapperContextForParams(r3, e.class, "com.obric.memorydata.plugin"), this);
        return this;
    }

    public Elements unwrap() {
        Iterator<Element> r0 = iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((Element) ZeusTransformUtils.preCheckCast(r0.next(), Element.class, "com.obric.memorydata.plugin")).ab();
        goto L4
    L6:
        return this;
    }

    public String val() {
        if (size() > 0) goto L5;
        return "";
    L5:
        return first().P();
    }

    public Elements val(String r5) {
        Iterator<Element> r0 = iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((Element) ZeusTransformUtils.preCheckCast(r0.next(), Element.class, "com.obric.memorydata.plugin")).t(r5);
        goto L4
    L6:
        return this;
    }

    public Elements wrap(String r5) {
        org.jsoup.helper.b.a(r5);
        Iterator<Element> r0 = iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((Element) ZeusTransformUtils.preCheckCast(r0.next(), Element.class, "com.obric.memorydata.plugin")).o(r5);
        goto L4
    L6:
        return this;
    }
}
