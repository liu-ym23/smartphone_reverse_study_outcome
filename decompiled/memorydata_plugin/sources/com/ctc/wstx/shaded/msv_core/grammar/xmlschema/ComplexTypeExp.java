package com.ctc.wstx.shaded.msv_core.grammar.xmlschema;

import com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype;
import com.ctc.wstx.shaded.msv_core.grammar.Expression;
import com.ctc.wstx.shaded.msv_core.grammar.ReferenceExp;
import com.ctc.wstx.shaded.msv_core.reader.datatype.xsd.XSDatatypeExp;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class ComplexTypeExp extends XMLSchemaTypeExp {
    private static final long serialVersionUID = 1;
    public final ReferenceExp attWildcard;
    public int block;
    public final ReferenceExp body;
    public ComplexTypeExp complexBaseType;
    public int derivationMethod;
    public int finalValue;
    public final XMLSchemaSchema parent;
    public XSDatatypeExp simpleBaseType;
    public a wildcard;

    public ComplexTypeExp(XMLSchemaSchema r3, String r4) {
        super(r4);
        this.body = new ReferenceExp(null);
        this.attWildcard = new ReferenceExp(null, Expression.epsilon);
        this.derivationMethod = -1;
        this.finalValue = 0;
        this.block = 0;
        this.parent = r3;
        setAbstract(false);
    }

    public a getAttributeWildcard() {
        return this.wildcard;
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.xmlschema.XMLSchemaTypeExp
    public int getBlock() {
        return this.block;
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.xmlschema.RedefinableExp
    public RedefinableExp getClone() {
        ComplexTypeExp r0 = new ComplexTypeExp(this.parent, this.name);
        r0.redefine(this);
        return r0;
    }

    public final String getTargetNamespace() {
        return this.parent.targetNamespace;
    }

    public boolean isAbstract() {
        if (this.exp != Expression.nullSet) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.ReferenceExp
    public boolean isDefined() {
        return this.body.isDefined();
    }

    public boolean isDerivedTypeOf(XSDatatype r3, int r4) {
        XSDatatype r5 = (XSDatatype) ZeusTransformUtils.wrapperContextForParams(r3, XSDatatype.class, "com.obric.memorydata.plugin");
    L3:
        ComplexTypeExp r0 = this.complexBaseType;
        boolean r1 = false;
        if (r0 == null) goto L5;
        if ((this.derivationMethod & r4) != 0) goto L15;
        ComplexTypeExp this = r0;
        goto L3
    L15:
        return false;
    L5:
        XSDatatypeExp r2 = this.simpleBaseType;
        if (r2 == null) goto L12;
        XSDatatype r6 = r2.getCreatedType();
        if ((r4 & 1) != 0) goto L11;
        r1 = true;
    L11:
        return r6.isDerivedTypeOf(r5, r1);
    L12:
        return false;
    }

    public boolean isDerivedTypeOf(ComplexTypeExp r3, int r4) {
    L3:
        if (this == null) goto L11;
        if (this == r3) goto L5;
        if ((this.derivationMethod & r4) != 0) goto L9;
        ComplexTypeExp this = this.complexBaseType;
        goto L3
    L9:
        return false;
    L5:
        return true;
    L11:
        return false;
    }

    public boolean isDerivedTypeOf(XMLSchemaTypeExp r4, int r5) {
        if (ZeusTransformUtils.instanceOf(r4, ComplexTypeExp.class) == false) goto L7;
        return isDerivedTypeOf((ComplexTypeExp) ZeusTransformUtils.preCheckCast(r4, ComplexTypeExp.class, "com.obric.memorydata.plugin"), r5);
    L7:
        return isDerivedTypeOf(((SimpleTypeExp) ZeusTransformUtils.preCheckCast(r4, SimpleTypeExp.class, "com.obric.memorydata.plugin")).getDatatype(), r5);
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.xmlschema.RedefinableExp
    public void redefine(RedefinableExp r3) {
        super.redefine(r3);
        ComplexTypeExp r4 = (ComplexTypeExp) ZeusTransformUtils.preCheckCast(r3, ComplexTypeExp.class, "com.obric.memorydata.plugin");
        ReferenceExp r0 = this.body;
        r0.exp = r4.body.exp;
        ReferenceExp r1 = this.attWildcard;
        r1.exp = r4.attWildcard.exp;
        this.complexBaseType = r4.complexBaseType;
        this.simpleBaseType = r4.simpleBaseType;
        this.derivationMethod = r4.derivationMethod;
        this.finalValue = r4.finalValue;
        this.block = r4.block;
        a r2 = r4.wildcard;
        if (r2 != null) goto L5;
        a r5 = null;
    L6:
        this.wildcard = r5;
        if (this.parent != r4.parent) goto L10;
        return;
    L10:
        throw new IllegalArgumentException();
    L5:
        r5 = r2.a();
        goto L6
    }

    public void setAbstract(boolean r3) {
        if (r3 == false) goto L4;
        Expression r4 = Expression.nullSet;
    L5:
        this.exp = r4;
        return;
    L4:
        r4 = this.parent.pool.createSequence(this.body, this.attWildcard);
        goto L5
    }

    public void setAttributeWildcard(a r1) {
        this.wildcard = r1;
    }
}
