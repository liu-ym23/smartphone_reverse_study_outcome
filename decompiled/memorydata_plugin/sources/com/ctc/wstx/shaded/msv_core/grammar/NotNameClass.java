package com.ctc.wstx.shaded.msv_core.grammar;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class NotNameClass extends NameClass {
    private static final long serialVersionUID = 1;
    public final NameClass child;

    public NotNameClass(NameClass r1) {
        this.child = r1;
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.NameClass
    public boolean accepts(String r1, String r2) {
        return !this.child.accepts(r1, r2);
    }

    public String toString() {
        return "~" + this.child.toString();
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.NameClass
    public Object visit(h r3) {
        return ((h) ZeusTransformUtils.wrapperContextForParams(r3, h.class, "com.obric.memorydata.plugin")).a(this);
    }
}
