package com.ctc.wstx.shaded.msv_core.datatype.xsd;

import com.ctc.wstx.shaded.msv.relaxng_datatype.DatatypeException;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public abstract class DataTypeWithFacet extends XSDatatypeImpl {
    private static final long serialVersionUID = 1;
    public final XSDatatypeImpl baseType;
    protected final ConcreteType concreteType;
    public final String facetName;
    public final boolean isFacetFixed;
    private final boolean needValueCheckFlag;

    DataTypeWithFacet(String r8, String r9, XSDatatypeImpl r10, String r11, boolean r12) {
        this(r8, r9, r10, r11, r12, r10.whiteSpace);
    }

    DataTypeWithFacet(String r1, String r2, XSDatatypeImpl r3, String r4, boolean r5, WhiteSpaceProcessor r6) {
        super(r1, r2, r6);
        this.baseType = r3;
        this.facetName = r4;
        this.isFacetFixed = r5;
        this.concreteType = r3.getConcreteType();
        this.needValueCheckFlag = r3.needValueCheck();
        int r0 = r3.isFacetApplicable(r4);
        if (r0 == (-2)) goto L10;
        if (r0 == (-1)) goto L8;
        return;
    L8:
        throw new DatatypeException(localize(XSDatatypeImpl.ERR_OVERRIDING_FIXED_FACET, r4));
    L10:
        throw new DatatypeException(localize(XSDatatypeImpl.ERR_NOT_APPLICABLE_FACET, r4));
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatypeImpl
    public final void _checkValid(String r3, com.ctc.wstx.shaded.msv.relaxng_datatype.e r4) {
        com.ctc.wstx.shaded.msv.relaxng_datatype.e r5 = (com.ctc.wstx.shaded.msv.relaxng_datatype.e) ZeusTransformUtils.wrapperContextForParams(r4, com.ctc.wstx.shaded.msv.relaxng_datatype.e.class, "com.obric.memorydata.plugin");
        this.baseType._checkValid(r3, r5);
        diagnoseByFacet(r3, r5);
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatypeImpl
    public final Object _createJavaObject(String r3, com.ctc.wstx.shaded.msv.relaxng_datatype.e r4) {
        com.ctc.wstx.shaded.msv.relaxng_datatype.e r5 = (com.ctc.wstx.shaded.msv.relaxng_datatype.e) ZeusTransformUtils.wrapperContextForParams(r4, com.ctc.wstx.shaded.msv.relaxng_datatype.e.class, "com.obric.memorydata.plugin");
        if (isValid(r3, r5) == true) goto L5;
        return null;
    L5:
        return this.baseType.createJavaObject(r3, r5);
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype
    public final String convertToLexicalValue(Object r3, com.ctc.wstx.shaded.msv_core.datatype.c r4) {
        com.ctc.wstx.shaded.msv_core.datatype.c r5 = (com.ctc.wstx.shaded.msv_core.datatype.c) ZeusTransformUtils.wrapperContextForParams(r4, com.ctc.wstx.shaded.msv_core.datatype.c.class, "com.obric.memorydata.plugin");
        return this.concreteType.convertToLexicalValue(r3, r5);
    }

    public abstract void diagnoseByFacet(String r1, com.ctc.wstx.shaded.msv.relaxng_datatype.e r2);

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype
    public final String displayName() {
        if (getName() == null) goto L7;
        return getName();
    L7:
        return this.concreteType.getName() + "-derived";
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype
    public final XSDatatype getBaseType() {
        return this.baseType;
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatypeImpl
    public final ConcreteType getConcreteType() {
        return this.concreteType;
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatypeImpl, com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype
    public final DataTypeWithFacet getFacetObject(String r2) {
        if (this.facetName.equals(r2) == false) goto L6;
        return this;
    L6:
        return this.baseType.getFacetObject(r2);
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatypeImpl, com.ctc.wstx.shaded.msv.relaxng_datatype.a
    public int getIdType() {
        return this.concreteType.getIdType();
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.a
    public final Class getJavaObjectType() {
        return this.concreteType.getJavaObjectType();
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype
    public final int getVariety() {
        return this.concreteType.getVariety();
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatypeImpl
    public boolean isContextDependent() {
        return this.concreteType.isContextDependent();
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype
    public final int isFacetApplicable(String r2) {
        if (this.facetName.equals(r2) == false) goto L11;
        if (this.isFacetFixed == false) goto L8;
        return -1;
    L8:
        return 0;
    L11:
        return this.baseType.isFacetApplicable(r2);
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype
    public final boolean isFinal(int r1) {
        return this.baseType.isFinal(r1);
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatypeImpl
    public boolean needValueCheck() {
        return this.needValueCheckFlag;
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.a
    public String serializeJavaObject(Object r3, com.ctc.wstx.shaded.msv_core.datatype.c r4) {
        com.ctc.wstx.shaded.msv_core.datatype.c r5 = (com.ctc.wstx.shaded.msv_core.datatype.c) ZeusTransformUtils.wrapperContextForParams(r4, com.ctc.wstx.shaded.msv_core.datatype.c.class, "com.obric.memorydata.plugin");
        return this.baseType.serializeJavaObject(r3, r5);
    }
}
