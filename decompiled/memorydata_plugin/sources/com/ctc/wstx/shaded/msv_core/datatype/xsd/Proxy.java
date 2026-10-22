package com.ctc.wstx.shaded.msv_core.datatype.xsd;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class Proxy extends XSDatatypeImpl {
    private static final long serialVersionUID = 1;
    public final XSDatatypeImpl baseType;

    public Proxy(String r2, String r3, XSDatatypeImpl r4) {
        super(r2, r3, r4.whiteSpace);
        this.baseType = r4;
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatypeImpl
    public void _checkValid(String r3, com.ctc.wstx.shaded.msv.relaxng_datatype.e r4) {
        com.ctc.wstx.shaded.msv.relaxng_datatype.e r5 = (com.ctc.wstx.shaded.msv.relaxng_datatype.e) ZeusTransformUtils.wrapperContextForParams(r4, com.ctc.wstx.shaded.msv.relaxng_datatype.e.class, "com.obric.memorydata.plugin");
        this.baseType._checkValid(r3, r5);
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatypeImpl
    public Object _createJavaObject(String r3, com.ctc.wstx.shaded.msv.relaxng_datatype.e r4) {
        com.ctc.wstx.shaded.msv.relaxng_datatype.e r5 = (com.ctc.wstx.shaded.msv.relaxng_datatype.e) ZeusTransformUtils.wrapperContextForParams(r4, com.ctc.wstx.shaded.msv.relaxng_datatype.e.class, "com.obric.memorydata.plugin");
        return this.baseType._createJavaObject(r3, r5);
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatypeImpl
    public Object _createValue(String r3, com.ctc.wstx.shaded.msv.relaxng_datatype.e r4) {
        com.ctc.wstx.shaded.msv.relaxng_datatype.e r5 = (com.ctc.wstx.shaded.msv.relaxng_datatype.e) ZeusTransformUtils.wrapperContextForParams(r4, com.ctc.wstx.shaded.msv.relaxng_datatype.e.class, "com.obric.memorydata.plugin");
        return this.baseType._createValue(r3, r5);
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatypeImpl
    public boolean checkFormat(String r3, com.ctc.wstx.shaded.msv.relaxng_datatype.e r4) {
        com.ctc.wstx.shaded.msv.relaxng_datatype.e r5 = (com.ctc.wstx.shaded.msv.relaxng_datatype.e) ZeusTransformUtils.wrapperContextForParams(r4, com.ctc.wstx.shaded.msv.relaxng_datatype.e.class, "com.obric.memorydata.plugin");
        return this.baseType.checkFormat(r3, r5);
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype
    public String convertToLexicalValue(Object r3, com.ctc.wstx.shaded.msv_core.datatype.c r4) {
        com.ctc.wstx.shaded.msv_core.datatype.c r5 = (com.ctc.wstx.shaded.msv_core.datatype.c) ZeusTransformUtils.wrapperContextForParams(r4, com.ctc.wstx.shaded.msv_core.datatype.c.class, "com.obric.memorydata.plugin");
        return this.baseType.convertToLexicalValue(r3, r5);
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype
    public String displayName() {
        return this.baseType.displayName();
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype
    public final XSDatatype getBaseType() {
        return this.baseType;
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatypeImpl
    public ConcreteType getConcreteType() {
        return this.baseType.getConcreteType();
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatypeImpl, com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype
    public DataTypeWithFacet getFacetObject(String r1) {
        return this.baseType.getFacetObject(r1);
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatypeImpl, com.ctc.wstx.shaded.msv.relaxng_datatype.a
    public int getIdType() {
        return this.baseType.getIdType();
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.a
    public Class getJavaObjectType() {
        return this.baseType.getJavaObjectType();
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype
    public int getVariety() {
        return this.baseType.getVariety();
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatypeImpl
    public boolean isContextDependent() {
        return this.baseType.isContextDependent();
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype
    public int isFacetApplicable(String r1) {
        return this.baseType.isFacetApplicable(r1);
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype
    public boolean isFinal(int r1) {
        return this.baseType.isFinal(r1);
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.a
    public String serializeJavaObject(Object r3, com.ctc.wstx.shaded.msv_core.datatype.c r4) {
        com.ctc.wstx.shaded.msv_core.datatype.c r5 = (com.ctc.wstx.shaded.msv_core.datatype.c) ZeusTransformUtils.wrapperContextForParams(r4, com.ctc.wstx.shaded.msv_core.datatype.c.class, "com.obric.memorydata.plugin");
        return this.baseType.serializeJavaObject(r3, r5);
    }
}
