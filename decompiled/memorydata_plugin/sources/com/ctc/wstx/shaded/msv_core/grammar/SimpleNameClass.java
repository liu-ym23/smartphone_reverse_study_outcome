package com.ctc.wstx.shaded.msv_core.grammar;

import com.ctc.wstx.shaded.msv_core.util.StringPair;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class SimpleNameClass extends NameClass {
    private static final long serialVersionUID = 1;
    public final String localName;
    public final String namespaceURI;

    public SimpleNameClass(StringPair r2) {
        this(r2.namespaceURI, r2.localName);
    }

    public SimpleNameClass(String r1, String r2) {
        this.namespaceURI = r1;
        this.localName = r2;
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.NameClass
    public boolean accepts(String r3, String r4) {
        if (this.namespaceURI.equals(r3) == true) goto L6;
        if ("*" == r3) goto L6;
    L9:
        return false;
    L6:
        if (this.localName.equals(r4) == true) goto L10;
        if ("*" != r4) goto L9;
    L10:
        return true;
    }

    public String toString() {
        this.namespaceURI.length();
        return this.localName;
    }

    public StringPair toStringPair() {
        return new StringPair(this.namespaceURI, this.localName);
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.NameClass
    public Object visit(h r3) {
        return ((h) ZeusTransformUtils.wrapperContextForParams(r3, h.class, "com.obric.memorydata.plugin")).a(this);
    }
}
