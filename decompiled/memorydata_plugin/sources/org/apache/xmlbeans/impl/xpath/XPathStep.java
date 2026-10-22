package org.apache.xmlbeans.impl.xpath;

import javax.xml.namespace.QName;

/* JADX INFO: loaded from: classes7.dex */
class XPathStep {
    final boolean _attr;
    XPathStep _backtrack;
    final boolean _deep;
    int _flags;
    boolean _hasBacktrack;
    final QName _name;
    XPathStep _next;
    XPathStep _prev;

    XPathStep(boolean r1, boolean r2, QName r3) {
        this._name = r3;
        this._deep = r1;
        this._attr = r2;
        if (r1 == true) goto L7;
        if (r2 == false) goto L7;
        int r4 = 0;
    L8:
        if (r2 == false) goto L10;
        r4 = r4 | 4;
    L10:
        this._flags = r4;
        return;
    L7:
        r4 = 2;
        goto L8
    }

    boolean isWild() {
        if (this._name.getLocalPart().length() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    boolean match(QName r7) {
        String r0 = this._name.getLocalPart();
        String r1 = r7.getLocalPart();
        int r2 = r0.length();
        if (r2 != 0) goto L12;
        String r6 = this._name.getNamespaceURI();
        if (r6.isEmpty() == false) goto L7;
        return true;
    L7:
        if (r6.equals(r7.getNamespaceURI()) == false) goto L10;
        return true;
    L10:
        return false;
    L12:
        if (r2 == r1.length()) goto L14;
        return false;
    L14:
        String r8 = this._name.getNamespaceURI();
        String r9 = r7.getNamespaceURI();
        if (r8.length() == r9.length()) goto L18;
        return false;
    L18:
        if (r0.equals(r1) == false) goto L23;
        if (r8.equals(r9) == false) goto L23;
        return true;
    L23:
        return false;
    }
}
