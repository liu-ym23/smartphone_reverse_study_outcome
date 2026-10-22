package com.ctc.wstx.shaded.msv_core.grammar.dtd;

import com.ctc.wstx.shaded.msv_core.grammar.NameClass;
import com.ctc.wstx.shaded.msv_core.grammar.SimpleNameClass;
import com.ctc.wstx.shaded.msv_core.grammar.h;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class LocalNameClass extends NameClass {
    private static final long serialVersionUID = 1;
    public final String localName;

    public LocalNameClass(String r1) {
        this.localName = r1;
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.NameClass
    public boolean accepts(String r1, String r2) {
        if (this.localName.equals(r2) == false) goto L5;
    L8:
        return true;
    L5:
        if ("*".equals(r2) == true) goto L8;
        return false;
    }

    public String toString() {
        return this.localName;
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.NameClass
    public Object visit(h r3) {
        h r4 = (h) ZeusTransformUtils.wrapperContextForParams(r3, h.class, "com.obric.memorydata.plugin");
        return new SimpleNameClass("", this.localName).visit(r4);
    }
}
