package com.ctc.wstx.shaded.msv_core.datatype.xsd;

import com.ctc.wstx.shaded.msv.relaxng_datatype.DatatypeException;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.StringTokenizer;

/* JADX INFO: loaded from: classes2.dex */
public final class ListType extends ConcreteType implements c {
    private static final long serialVersionUID = 1;
    public final XSDatatypeImpl itemType;

    public ListType(String r1, String r2, XSDatatypeImpl r3) {
        super(r1, r2);
        if (r3.isFinal(2) == true) goto L7;
        this.itemType = r3;
        return;
    L7:
        throw new DatatypeException(localize(XSDatatypeImpl.ERR_INVALID_ITEMTYPE));
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.ConcreteType, com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatypeImpl
    public void _checkValid(String r3, com.ctc.wstx.shaded.msv.relaxng_datatype.e r4) {
        com.ctc.wstx.shaded.msv.relaxng_datatype.e r5 = (com.ctc.wstx.shaded.msv.relaxng_datatype.e) ZeusTransformUtils.wrapperContextForParams(r4, com.ctc.wstx.shaded.msv.relaxng_datatype.e.class, "com.obric.memorydata.plugin");
        StringTokenizer r0 = new StringTokenizer(r3);
    L4:
        if (r0.hasMoreTokens() == false) goto L6;
        String r6 = r0.nextToken();
        this.itemType.checkValid(r6, r5);
        goto L4
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatypeImpl
    public Object _createValue(String r6, com.ctc.wstx.shaded.msv.relaxng_datatype.e r7) {
        com.ctc.wstx.shaded.msv.relaxng_datatype.e r8 = (com.ctc.wstx.shaded.msv.relaxng_datatype.e) ZeusTransformUtils.wrapperContextForParams(r7, com.ctc.wstx.shaded.msv.relaxng_datatype.e.class, "com.obric.memorydata.plugin");
        StringTokenizer r0 = new StringTokenizer(r6);
        Object[] r9 = new Object[r0.countTokens()];
        int r1 = 0;
    L4:
        if (r0.hasMoreTokens() == false) goto L11;
        int r2 = r1 + 1;
        Object r3 = this.itemType._createValue(r0.nextToken(), r8);
        r9[r1] = r3;
        if (r3 == null) goto L7;
        r1 = r2;
        goto L4
    L7:
        return null;
    L11:
        return new ListValueType(r9);
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatypeImpl
    public final boolean checkFormat(String r3, com.ctc.wstx.shaded.msv.relaxng_datatype.e r4) {
        com.ctc.wstx.shaded.msv.relaxng_datatype.e r5 = (com.ctc.wstx.shaded.msv.relaxng_datatype.e) ZeusTransformUtils.wrapperContextForParams(r4, com.ctc.wstx.shaded.msv.relaxng_datatype.e.class, "com.obric.memorydata.plugin");
        StringTokenizer r0 = new StringTokenizer(r3);
    L4:
        if (r0.hasMoreTokens() == false) goto L9;
        if (this.itemType.isValid(r0.nextToken(), r5) == true) goto L4;
        return false;
    L9:
        return true;
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype
    public String convertToLexicalValue(Object r5, com.ctc.wstx.shaded.msv_core.datatype.c r6) {
        com.ctc.wstx.shaded.msv_core.datatype.c r7 = (com.ctc.wstx.shaded.msv_core.datatype.c) ZeusTransformUtils.wrapperContextForParams(r6, com.ctc.wstx.shaded.msv_core.datatype.c.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r5, ListValueType.class) == false) goto L13;
        ListValueType r8 = (ListValueType) ZeusTransformUtils.preCheckCast(r5, ListValueType.class, "com.obric.memorydata.plugin");
        StringBuffer r0 = new StringBuffer();
        int r1 = 0;
    L6:
        if (r1 >= r8.values.length) goto L11;
        if (r1 == 0) goto L9;
        r0.append(' ');
    L9:
        r0.append(this.itemType.convertToLexicalValue(r8.values[r1], r7));
        r1 = r1 + 1;
        goto L6
    L11:
        return r0.toString();
    L13:
        throw new IllegalArgumentException();
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.c
    public final int countLength(Object r2) {
        return ((ListValueType) ZeusTransformUtils.preCheckCast(r2, ListValueType.class, "com.obric.memorydata.plugin")).values.length;
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype
    public final String displayName() {
        String r0 = getName();
        if (r0 == null) goto L6;
        return r0;
    L6:
        return this.itemType.displayName() + "-list";
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype
    public final XSDatatype getBaseType() {
        return SimpleURType.theInstance;
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatypeImpl, com.ctc.wstx.shaded.msv.relaxng_datatype.a
    public int getIdType() {
        int r2 = this.itemType.getIdType();
        if (r2 != 0) goto L5;
    L13:
        return 0;
    L5:
        if (r2 == 1) goto L13;
        if (r2 == 2) goto L12;
        if (r2 != 3) goto L11;
        return 3;
    L11:
        throw new Error();
    L12:
        return 3;
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.a
    public Class getJavaObjectType() {
        return Object[].class;
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype
    public final int getVariety() {
        return 2;
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatypeImpl
    public boolean isContextDependent() {
        return this.itemType.isContextDependent();
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype
    public final int isFacetApplicable(String r1) {
        if (r1.equals(XSDatatype.FACET_LENGTH) == false) goto L5;
        return 0;
    L5:
        if (r1.equals(XSDatatype.FACET_MINLENGTH) == false) goto L7;
        return 0;
    L7:
        if (r1.equals(XSDatatype.FACET_MAXLENGTH) == false) goto L9;
        return 0;
    L9:
        if (r1.equals(XSDatatype.FACET_ENUMERATION) == false) goto L11;
        return 0;
    L11:
        if (r1.equals(XSDatatype.FACET_PATTERN) == true) goto L20;
        return -2;
    L20:
        return 0;
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.ConcreteType, com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype
    public final boolean isFinal(int r2) {
        if (r2 != 2) goto L7;
        return true;
    L7:
        return this.itemType.isFinal(r2);
    }
}
