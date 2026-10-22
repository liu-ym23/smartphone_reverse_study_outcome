package org.apache.xmlbeans.impl.xpath.xmlbeans;

import java.util.ConcurrentModificationException;
import org.apache.xmlbeans.impl.store.Cur;
import org.apache.xmlbeans.impl.store.Locale;
import org.apache.xmlbeans.impl.xpath.XPath;
import org.apache.xmlbeans.impl.xpath.XPathEngine;
import org.apache.xmlbeans.impl.xpath.XPathExecutionContext;

/* JADX INFO: loaded from: classes7.dex */
class XmlbeansXPathEngine extends XPathExecutionContext implements XPathEngine {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private Cur _cur;
    private final long _version;

    static {
    }

    XmlbeansXPathEngine(XPath r3, Cur r4) {
        this._version = r4.getLocale().version();
        Cur r0 = r4.weakCur(this);
        this._cur = r0;
        r0.push();
        init(r3);
        int r5 = start();
        if ((r5 & 1) == 0) goto L5;
        r4.addToSelection();
    L5:
        doAttrs(r5, r4);
        if ((r5 & 2) != 0) goto L8;
    L9:
        release();
        return;
    L8:
        if (Locale.toFirstChildElement(this._cur) == false) goto L9;
    }

    private void advance(Cur r3) {
        if (this._cur.isFinish() == false) goto L9;
        if (this._cur.isAtEndOfLastPush() == false) goto L7;
        release();
        return;
    L7:
        end();
        this._cur.next();
        return;
    L9:
        if (this._cur.isElem() == false) goto L18;
        int r0 = element(this._cur.getName());
        if ((r0 & 1) == 0) goto L13;
        r3.addToSelection(this._cur);
    L13:
        doAttrs(r0, r3);
        if ((r0 & 2) != 0) goto L16;
    L17:
        end();
        this._cur.skip();
        return;
    L16:
        if (Locale.toFirstChildElement(this._cur) == false) goto L17;
        return;
    L18:
        this._cur.next();
        if (this._cur.isContainerOrFinish() == false) goto L18;
    }

    private void doAttrs(int r1, Cur r2) {
        if ((r1 & 4) != 0) goto L5;
        return;
    L5:
        if (this._cur.toFirstAttr() == true) goto L7;
        return;
    L7:
        if (attr(this._cur.getName()) == false) goto L10;
        r2.addToSelection(this._cur);
    L10:
        if (this._cur.toNextAttr() == true) goto L7;
        this._cur.toParent();
    }

    @Override // org.apache.xmlbeans.impl.xpath.XPathEngine
    public boolean next(Cur r6) {
        Cur r0 = this._cur;
        if (r0 != null) goto L5;
    L9:
        int r1 = r6.selectionCount();
    L11:
        if (this._cur == null) goto L16;
        advance(r6);
        if (r1 == r6.selectionCount()) goto L11;
        return true;
    L16:
        return false;
    L5:
        if (this._version == r0.getLocale().version()) goto L9;
        throw new ConcurrentModificationException("Document changed during select");
    }

    @Override // org.apache.xmlbeans.impl.xpath.XPathEngine
    public void release() {
        Cur r0 = this._cur;
        if (r0 == null) goto L6;
        r0.release();
        this._cur = null;
        return;
    }
}
