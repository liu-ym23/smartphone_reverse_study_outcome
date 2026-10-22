package com.ctc.wstx.shaded.msv_core.datatype.xsd;

import com.ctc.wstx.shaded.msv_core.datatype.xsd.datetime.BigTimeDurationValueType;
import com.ctc.wstx.shaded.msv_core.datatype.xsd.datetime.ITimeDurationValueType;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class DurationType extends BuiltinAtomicType implements a {
    private static final long serialVersionUID = 1;
    public static final DurationType theInstance = null;

    static {
        theInstance = new DurationType();
    }

    private DurationType() {
        super("duration");
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatypeImpl
    public Object _createValue(String r2, com.ctc.wstx.shaded.msv.relaxng_datatype.e r3) {
        com.ctc.wstx.shaded.msv.relaxng_datatype.e r1 = (com.ctc.wstx.shaded.msv.relaxng_datatype.e) ZeusTransformUtils.wrapperContextForParams(r3, com.ctc.wstx.shaded.msv.relaxng_datatype.e.class, "com.obric.memorydata.plugin");
        return new BigTimeDurationValueType(r2);
    L5:
        return null;
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatypeImpl
    public boolean checkFormat(String r2, com.ctc.wstx.shaded.msv.relaxng_datatype.e r3) {
        com.ctc.wstx.shaded.msv.relaxng_datatype.e r1 = (com.ctc.wstx.shaded.msv.relaxng_datatype.e) ZeusTransformUtils.wrapperContextForParams(r3, com.ctc.wstx.shaded.msv.relaxng_datatype.e.class, "com.obric.memorydata.plugin");
        new BigTimeDurationValueType(r2);     // Catch: IllegalArgumentException -> L6
        return true;
    L6:
        return false;
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.a
    public int compare(Object r2, Object r3) {
        return ((ITimeDurationValueType) ZeusTransformUtils.preCheckCast(r2, ITimeDurationValueType.class, "com.obric.memorydata.plugin")).compare((ITimeDurationValueType) ZeusTransformUtils.preCheckCast(r3, ITimeDurationValueType.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype
    public String convertToLexicalValue(Object r2, com.ctc.wstx.shaded.msv_core.datatype.c r3) {
        com.ctc.wstx.shaded.msv_core.datatype.c r1 = (com.ctc.wstx.shaded.msv_core.datatype.c) ZeusTransformUtils.wrapperContextForParams(r3, com.ctc.wstx.shaded.msv_core.datatype.c.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r2, ITimeDurationValueType.class) == false) goto L7;
        return r2.toString();
    L7:
        throw new IllegalArgumentException();
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype
    public final XSDatatype getBaseType() {
        return SimpleURType.theInstance;
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.a
    public Class getJavaObjectType() {
        return ITimeDurationValueType.class;
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype
    public final int isFacetApplicable(String r1) {
        if (r1.equals(XSDatatype.FACET_PATTERN) == false) goto L5;
        return 0;
    L5:
        if (r1.equals(XSDatatype.FACET_ENUMERATION) == false) goto L7;
        return 0;
    L7:
        if (r1.equals(XSDatatype.FACET_WHITESPACE) == false) goto L9;
        return 0;
    L9:
        if (r1.equals(XSDatatype.FACET_MAXINCLUSIVE) == false) goto L11;
        return 0;
    L11:
        if (r1.equals(XSDatatype.FACET_MAXEXCLUSIVE) == false) goto L13;
        return 0;
    L13:
        if (r1.equals(XSDatatype.FACET_MININCLUSIVE) == false) goto L15;
        return 0;
    L15:
        if (r1.equals(XSDatatype.FACET_MINEXCLUSIVE) == true) goto L26;
        return -2;
    L26:
        return 0;
    }
}
