package com.ctc.wstx.shaded.msv_core.grammar.xmlschema;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class AttributeGroupExp extends RedefinableExp {
    private static final long serialVersionUID = 1;
    public a wildcard;

    public AttributeGroupExp(String r1) {
        super(r1);
    }

    public a getAttributeWildcard() {
        return this.wildcard;
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.xmlschema.RedefinableExp
    public RedefinableExp getClone() {
        AttributeGroupExp r0 = new AttributeGroupExp(this.name);
        r0.redefine(this);
        return r0;
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.xmlschema.RedefinableExp
    public void redefine(RedefinableExp r3) {
        super.redefine(r3);
        a r4 = ((AttributeGroupExp) ZeusTransformUtils.preCheckCast(r3, AttributeGroupExp.class, "com.obric.memorydata.plugin")).wildcard;
        if (r4 != null) goto L5;
        a r5 = null;
    L6:
        this.wildcard = r5;
        return;
    L5:
        r5 = r4.a();
        goto L6
    }

    public void setAttributeWildcard(a r1) {
        this.wildcard = r1;
    }
}
