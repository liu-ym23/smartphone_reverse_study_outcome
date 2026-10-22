package com.ctc.wstx.shaded.msv_core.datatype.xsd;

import com.ctc.wstx.shaded.msv_core.datatype.xsd.datetime.IDateTimeValueType;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Calendar;

/* JADX INFO: loaded from: classes2.dex */
abstract class DateTimeBaseType extends BuiltinAtomicType implements a {
    private static final long serialVersionUID = 1465669066779112677L;

    public DateTimeBaseType(String r1) {
        super(r1);
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.ConcreteType, com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatypeImpl
    public final Object _createJavaObject(String r3, com.ctc.wstx.shaded.msv.relaxng_datatype.e r4) {
        com.ctc.wstx.shaded.msv.relaxng_datatype.e r5 = (com.ctc.wstx.shaded.msv.relaxng_datatype.e) ZeusTransformUtils.wrapperContextForParams(r4, com.ctc.wstx.shaded.msv.relaxng_datatype.e.class, "com.obric.memorydata.plugin");
        return com.ctc.wstx.shaded.msv_core.datatype.xsd.datetime.d.a(getFormat(), r3);
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatypeImpl
    public final Object _createValue(String r3, com.ctc.wstx.shaded.msv.relaxng_datatype.e r4) {
        com.ctc.wstx.shaded.msv.relaxng_datatype.e r5 = (com.ctc.wstx.shaded.msv.relaxng_datatype.e) ZeusTransformUtils.wrapperContextForParams(r4, com.ctc.wstx.shaded.msv.relaxng_datatype.e.class, "com.obric.memorydata.plugin");
        return com.ctc.wstx.shaded.msv_core.datatype.xsd.datetime.f.a(getFormat(), r3);
    L5:
        return null;
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatypeImpl
    public final boolean checkFormat(String r3, com.ctc.wstx.shaded.msv.relaxng_datatype.e r4) {
        com.ctc.wstx.shaded.msv.relaxng_datatype.e r5 = (com.ctc.wstx.shaded.msv.relaxng_datatype.e) ZeusTransformUtils.wrapperContextForParams(r4, com.ctc.wstx.shaded.msv.relaxng_datatype.e.class, "com.obric.memorydata.plugin");
        com.ctc.wstx.shaded.msv_core.datatype.xsd.datetime.d.a(getFormat(), r3);     // Catch: IllegalArgumentException -> L6
        return true;
    L6:
        return false;
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.a
    public int compare(Object r2, Object r3) {
        return ((IDateTimeValueType) ZeusTransformUtils.preCheckCast(r2, IDateTimeValueType.class, "com.obric.memorydata.plugin")).compare((IDateTimeValueType) ZeusTransformUtils.preCheckCast(r3, IDateTimeValueType.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype
    public final String convertToLexicalValue(Object r3, com.ctc.wstx.shaded.msv_core.datatype.c r4) {
        com.ctc.wstx.shaded.msv_core.datatype.c r5 = (com.ctc.wstx.shaded.msv_core.datatype.c) ZeusTransformUtils.wrapperContextForParams(r4, com.ctc.wstx.shaded.msv_core.datatype.c.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, IDateTimeValueType.class) == false) goto L7;
        return com.ctc.wstx.shaded.msv_core.datatype.xsd.datetime.e.a(getFormat(), (IDateTimeValueType) ZeusTransformUtils.preCheckCast(r3, IDateTimeValueType.class, "com.obric.memorydata.plugin"));
    L7:
        throw new IllegalArgumentException();
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype
    public final XSDatatype getBaseType() {
        return SimpleURType.theInstance;
    }

    public abstract String getFormat();

    @Override // com.ctc.wstx.shaded.msv_core.datatype.a
    public Class getJavaObjectType() {
        return Calendar.class;
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

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.ConcreteType, com.ctc.wstx.shaded.msv_core.datatype.a
    public final String serializeJavaObject(Object r3, com.ctc.wstx.shaded.msv_core.datatype.c r4) {
        com.ctc.wstx.shaded.msv_core.datatype.c r5 = (com.ctc.wstx.shaded.msv_core.datatype.c) ZeusTransformUtils.wrapperContextForParams(r4, com.ctc.wstx.shaded.msv_core.datatype.c.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, Calendar.class) == false) goto L7;
        return com.ctc.wstx.shaded.msv_core.datatype.xsd.datetime.c.a(getFormat(), (Calendar) ZeusTransformUtils.preCheckCast(r3, Calendar.class, "com.obric.memorydata.plugin"));
    L7:
        throw new IllegalArgumentException();
    }
}
