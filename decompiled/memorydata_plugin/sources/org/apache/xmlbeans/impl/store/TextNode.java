package org.apache.xmlbeans.impl.store;

import org.w3c.dom.Text;

/* JADX INFO: loaded from: classes7.dex */
class TextNode extends CharNode implements Text {
    TextNode(Locale r1) {
        super(r1);
    }

    @Override // org.w3c.dom.Text
    public String getWholeText() {
        return DomImpl._text_getWholeText(this);
    }

    @Override // org.w3c.dom.Text
    public boolean isElementContentWhitespace() {
        return DomImpl._text_isElementContentWhitespace(this);
    }

    @Override // org.apache.xmlbeans.impl.store.DomImpl.Dom
    public int nodeType() {
        return 3;
    }

    @Override // org.w3c.dom.Text
    public Text replaceWholeText(String r1) {
        return DomImpl._text_replaceWholeText(this, r1);
    }

    @Override // org.w3c.dom.Text
    public Text splitText(int r1) {
        return DomImpl._text_splitText(this, r1);
    }
}
