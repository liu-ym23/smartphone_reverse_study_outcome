package com.ctc.wstx.shaded.msv_core.grammar;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class NamespaceNameClass extends NameClass {
    private static final long serialVersionUID = 1;
    public final String namespaceURI;

    public NamespaceNameClass(String r1) {
        this.namespaceURI = r1;
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.NameClass
    public boolean accepts(String r1, String r2) {
        if ("*" != r1) goto L7;
        return true;
    L7:
        return this.namespaceURI.equals(r1);
    }

    public String toString() {
        return this.namespaceURI + ":*";
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.NameClass
    public Object visit(h r3) {
        return ((h) ZeusTransformUtils.wrapperContextForParams(r3, h.class, "com.obric.memorydata.plugin")).a(this);
    }
}
