package com.ctc.wstx.shaded.msv_core.datatype.xsd;

import com.ctc.wstx.shaded.msv.relaxng_datatype.DatatypeException;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class UnionType extends ConcreteType {
    private static final long serialVersionUID = 1;
    public final XSDatatypeImpl[] memberTypes;

    public UnionType(String r3, String r4, XSDatatype[] r5) {
        super(r3, r4);
        if (r5.length == 0) goto L14;
        int r6 = r5.length;
        XSDatatypeImpl[] r7 = new XSDatatypeImpl[r6];
        int r1 = 0;
        System.arraycopy(r5, 0, r7, 0, r5.length);
    L5:
        if (r1 >= r6) goto L11;
        if (r7[r1].isFinal(4) == true) goto L10;
        r1 = r1 + 1;
        goto L5
    L10:
        throw new DatatypeException(localize(XSDatatypeImpl.ERR_INVALID_MEMBER_TYPE, r7[r1].displayName()));
    L11:
        this.memberTypes = r7;
        return;
    L14:
        throw new DatatypeException(localize(XSDatatypeImpl.ERR_EMPTY_UNION));
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.ConcreteType, com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatypeImpl
    public void _checkValid(String r3, com.ctc.wstx.shaded.msv.relaxng_datatype.e r4) {
        if (checkFormat(r3, (com.ctc.wstx.shaded.msv.relaxng_datatype.e) ZeusTransformUtils.wrapperContextForParams(r4, com.ctc.wstx.shaded.msv.relaxng_datatype.e.class, "com.obric.memorydata.plugin")) == false) goto L6;
        return;
    L6:
        throw new DatatypeException();
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatypeImpl
    public Object _createValue(String r4, com.ctc.wstx.shaded.msv.relaxng_datatype.e r5) {
        com.ctc.wstx.shaded.msv.relaxng_datatype.e r6 = (com.ctc.wstx.shaded.msv.relaxng_datatype.e) ZeusTransformUtils.wrapperContextForParams(r5, com.ctc.wstx.shaded.msv.relaxng_datatype.e.class, "com.obric.memorydata.plugin");
        int r0 = 0;
    L3:
        XSDatatypeImpl[] r1 = this.memberTypes;
        if (r0 >= r1.length) goto L9;
        Object r2 = r1[r0]._createValue(r4, r6);
        if (r2 != null) goto L7;
        r0 = r0 + 1;
        goto L3
    L7:
        return r2;
    L9:
        return null;
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatypeImpl
    public final boolean checkFormat(String r5, com.ctc.wstx.shaded.msv.relaxng_datatype.e r6) {
        com.ctc.wstx.shaded.msv.relaxng_datatype.e r7 = (com.ctc.wstx.shaded.msv.relaxng_datatype.e) ZeusTransformUtils.wrapperContextForParams(r6, com.ctc.wstx.shaded.msv.relaxng_datatype.e.class, "com.obric.memorydata.plugin");
        int r1 = 0;
    L3:
        XSDatatypeImpl[] r2 = this.memberTypes;
        if (r1 >= r2.length) goto L10;
        if (r2[r1].checkFormat(r5, r7) == true) goto L7;
        r1 = r1 + 1;
        goto L3
    L7:
        return true;
    L10:
        return false;
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype
    public String convertToLexicalValue(Object r4, com.ctc.wstx.shaded.msv_core.datatype.c r5) {
        com.ctc.wstx.shaded.msv_core.datatype.c r6 = (com.ctc.wstx.shaded.msv_core.datatype.c) ZeusTransformUtils.wrapperContextForParams(r5, com.ctc.wstx.shaded.msv_core.datatype.c.class, "com.obric.memorydata.plugin");
        int r0 = 0;
    L3:
        XSDatatypeImpl[] r1 = this.memberTypes;
        if (r0 >= r1.length) goto L9;
        return r1[r0].convertToLexicalValue(r4, r6);
    L7:
        r0 = r0 + 1;
        goto L3
    L9:
        throw new IllegalArgumentException();
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype
    public final String displayName() {
        String r0 = getName();
        if (r0 == null) goto L5;
        return r0;
    L5:
        return "union";
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype
    public final XSDatatype getBaseType() {
        return SimpleURType.theInstance;
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.a
    public Class getJavaObjectType() {
        return Object.class;
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype
    public final int getVariety() {
        return 3;
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatypeImpl
    public boolean isContextDependent() {
        int r1 = 0;
    L3:
        XSDatatypeImpl[] r2 = this.memberTypes;
        if (r1 >= r2.length) goto L10;
        if (r2[r1].isContextDependent() == true) goto L7;
        r1 = r1 + 1;
        goto L3
    L7:
        return true;
    L10:
        return false;
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype
    public final int isFacetApplicable(String r1) {
        if (r1.equals(XSDatatype.FACET_PATTERN) == false) goto L5;
        return 0;
    L5:
        if (r1.equals(XSDatatype.FACET_ENUMERATION) == true) goto L11;
        return -2;
    L11:
        return 0;
    }
}
