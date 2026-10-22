package org.jsoup.select;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.Iterator;
import org.jsoup.nodes.Element;

/* JADX INFO: loaded from: classes7.dex */
public class Selector {

    public static class SelectorParseException extends IllegalStateException {
        public SelectorParseException(String r1) {
            super(r1);
        }

        public SelectorParseException(String r1, Object... r2) {
            super(String.format(r1, r2));
        }
    }

    public static Elements a(String r6, Iterable<Element> r7) {
        Iterable r8 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r7, Iterable.class, "com.obric.memorydata.plugin");
        org.jsoup.helper.b.a(r6);
        org.jsoup.helper.b.a(r8);
        c r9 = f.a(r6);
        Elements r0 = new Elements();
        IdentityHashMap r2 = new IdentityHashMap();
        Iterator r10 = r8.iterator();
    L4:
        if (r10.hasNext() == false) goto L11;
        Iterator<Element> r3 = a(r9, (Element) ZeusTransformUtils.preCheckCast(r10.next(), Element.class, "com.obric.memorydata.plugin")).iterator();
    L7:
        if (r3.hasNext() == false) goto L4;
        Element r4 = (Element) ZeusTransformUtils.preCheckCast(r3.next(), Element.class, "com.obric.memorydata.plugin");
        if (r2.put(r4, Boolean.TRUE) != null) goto L7;
        r0.add(r4);
        goto L7
    L11:
        return r0;
    }

    public static Elements a(String r0, Element r1) {
        org.jsoup.helper.b.a(r0);
        return a(f.a(r0), r1);
    }

    static Elements a(Collection<Element> r7, Collection<Element> r8) {
        Collection r9 = (Collection) ZeusTransformUtils.wrapperContextForParams(r7, Collection.class, "com.obric.memorydata.plugin");
        Collection r10 = (Collection) ZeusTransformUtils.wrapperContextForParams(r8, Collection.class, "com.obric.memorydata.plugin");
        Elements r0 = new Elements();
        Iterator r11 = r9.iterator();
    L4:
        if (r11.hasNext() == false) goto L13;
        Element r2 = (Element) ZeusTransformUtils.preCheckCast(r11.next(), Element.class, "com.obric.memorydata.plugin");
        boolean r3 = false;
        Iterator r4 = r10.iterator();
    L7:
        if (r4.hasNext() == false) goto L11;
        if (r2.equals((Element) ZeusTransformUtils.preCheckCast(r4.next(), Element.class, "com.obric.memorydata.plugin")) == false) goto L7;
        r3 = true;
    L11:
        if (r3 == true) goto L4;
        r0.add(r2);
        goto L4
    L13:
        return r0;
    }

    public static Elements a(c r0, Element r1) {
        org.jsoup.helper.b.a(r0);
        org.jsoup.helper.b.a(r1);
        return a.a(r0, r1);
    }
}
