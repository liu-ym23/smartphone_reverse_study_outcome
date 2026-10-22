package com.ctc.wstx.shaded.msv_core.grammar.xmlschema;

import com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype;
import com.ctc.wstx.shaded.msv_core.reader.datatype.xsd.XSDatatypeExp;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class SimpleTypeExp extends XMLSchemaTypeExp {
    private static final long serialVersionUID = 1;
    protected XSDatatypeExp type;

    SimpleTypeExp(String r1) {
        super(r1);
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.xmlschema.XMLSchemaTypeExp
    public int getBlock() {
        return 0;
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.xmlschema.RedefinableExp
    public RedefinableExp getClone() {
        SimpleTypeExp r0 = new SimpleTypeExp(this.name);
        r0.redefine(this);
        return r0;
    }

    public XSDatatype getDatatype() {
        return this.type.getCreatedType();
    }

    public XSDatatypeExp getType() {
        return this.type;
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.xmlschema.RedefinableExp
    public void redefine(RedefinableExp r3) {
        super.redefine(r3);
        SimpleTypeExp r4 = (SimpleTypeExp) ZeusTransformUtils.preCheckCast(r3, SimpleTypeExp.class, "com.obric.memorydata.plugin");
        if (this.type != null) goto L6;
        this.type = r4.getType().getClone();
        return;
    L6:
        if (r4.getType() == null) goto L10;
        this.type.redefine(r4.getType());
        return;
    L10:
        throw new InternalError();
    }

    public void set(XSDatatypeExp r1) {
        this.type = r1;
        this.exp = r1;
    }
}
