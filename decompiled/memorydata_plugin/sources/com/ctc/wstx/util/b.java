package com.ctc.wstx.util;

import java.util.Iterator;
import javax.xml.namespace.NamespaceContext;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b implements NamespaceContext {
    public abstract String a(String r1);

    public abstract String b(String r1);

    public abstract Iterator<String> c(String r1);

    @Override // javax.xml.namespace.NamespaceContext
    public final String getNamespaceURI(String r2) {
        if (r2 == null) goto L16;
        if (r2.length() <= 0) goto L14;
        if (r2.equals("xml") == false) goto L10;
        return "http://www.w3.org/XML/1998/namespace";
    L10:
        if (r2.equals("xmlns") == false) goto L14;
        return "http://www.w3.org/2000/xmlns/";
    L14:
        return a(r2);
    L16:
        throw new IllegalArgumentException(com.ctc.wstx.b.a.n);
    }

    @Override // javax.xml.namespace.NamespaceContext
    public final String getPrefix(String r2) {
        if (r2 == null) goto L16;
        if (r2.length() == 0) goto L16;
        if (r2.equals("http://www.w3.org/XML/1998/namespace") == false) goto L10;
        return "xml";
    L10:
        if (r2.equals("http://www.w3.org/2000/xmlns/") == false) goto L14;
        return "xmlns";
    L14:
        return b(r2);
    L16:
        throw new IllegalArgumentException("Illegal to pass null/empty prefix as argument.");
    }

    @Override // javax.xml.namespace.NamespaceContext
    public final Iterator<String> getPrefixes(String r2) {
        if (r2 == null) goto L16;
        if (r2.length() == 0) goto L16;
        if (r2.equals("http://www.w3.org/XML/1998/namespace") == false) goto L11;
        String r1 = "xml";
    L9:
        return c.a(r1);
    L11:
        if (r2.equals("http://www.w3.org/2000/xmlns/") == false) goto L14;
        r1 = "xmlns";
        goto L9
    L14:
        return c(r2);
    L16:
        throw new IllegalArgumentException("Illegal to pass null/empty prefix as argument.");
    }
}
