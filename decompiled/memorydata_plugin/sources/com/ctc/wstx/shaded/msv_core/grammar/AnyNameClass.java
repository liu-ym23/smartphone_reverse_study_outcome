package com.ctc.wstx.shaded.msv_core.grammar;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class AnyNameClass extends NameClass {
    private static final long serialVersionUID = 1;
    public static final NameClass theInstance = null;

    static {
        theInstance = new AnyNameClass();
    }

    public AnyNameClass() {
    }

    private Object readResolve() {
        return theInstance;
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.NameClass
    public boolean accepts(String r1, String r2) {
        return true;
    }

    public String toString() {
        return "*:*";
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.NameClass
    public Object visit(h r3) {
        return ((h) ZeusTransformUtils.wrapperContextForParams(r3, h.class, "com.obric.memorydata.plugin")).a(this);
    }
}
