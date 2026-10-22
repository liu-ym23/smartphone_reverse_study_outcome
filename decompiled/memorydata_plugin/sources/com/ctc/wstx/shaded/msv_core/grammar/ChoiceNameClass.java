package com.ctc.wstx.shaded.msv_core.grammar;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class ChoiceNameClass extends NameClass {
    private static final long serialVersionUID = 1;
    public final NameClass nc1;
    public final NameClass nc2;

    public ChoiceNameClass(NameClass r1, NameClass r2) {
        this.nc1 = r1;
        this.nc2 = r2;
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.NameClass
    public boolean accepts(String r2, String r3) {
        if (this.nc1.accepts(r2, r3) == false) goto L5;
    L8:
        return true;
    L5:
        if (this.nc2.accepts(r2, r3) == true) goto L8;
        return false;
    }

    public String toString() {
        return '(' + this.nc1.toString() + '|' + this.nc2.toString() + ')';
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.NameClass
    public Object visit(h r3) {
        return ((h) ZeusTransformUtils.wrapperContextForParams(r3, h.class, "com.obric.memorydata.plugin")).a(this);
    }
}
