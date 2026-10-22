package com.ctc.wstx.shaded.msv_core.datatype.xsd;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class BooleanType extends BuiltinAtomicType {
    private static final long serialVersionUID = 1;
    public static final BooleanType theInstance = null;

    static {
        theInstance = new BooleanType();
    }

    private BooleanType() {
        super(TypedValues.Custom.S_BOOLEAN);
    }

    public static Boolean load(String r1) {
        if (r1.equals("true") == false) goto L7;
        return Boolean.TRUE;
    L7:
        if (r1.equals("1") == false) goto L11;
        return Boolean.TRUE;
    L11:
        if (r1.equals("0") == false) goto L15;
        return Boolean.FALSE;
    L15:
        if (r1.equals("false") == true) goto L17;
        return null;
    L17:
        return Boolean.FALSE;
    }

    public static String save(Boolean r1) {
        if (r1.booleanValue() != true) goto L6;
        return "true";
    L6:
        return "false";
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatypeImpl
    public Object _createValue(String r2, com.ctc.wstx.shaded.msv.relaxng_datatype.e r3) {
        com.ctc.wstx.shaded.msv.relaxng_datatype.e r1 = (com.ctc.wstx.shaded.msv.relaxng_datatype.e) ZeusTransformUtils.wrapperContextForParams(r3, com.ctc.wstx.shaded.msv.relaxng_datatype.e.class, "com.obric.memorydata.plugin");
        return load(r2);
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatypeImpl
    public boolean checkFormat(String r2, com.ctc.wstx.shaded.msv.relaxng_datatype.e r3) {
        com.ctc.wstx.shaded.msv.relaxng_datatype.e r1 = (com.ctc.wstx.shaded.msv.relaxng_datatype.e) ZeusTransformUtils.wrapperContextForParams(r3, com.ctc.wstx.shaded.msv.relaxng_datatype.e.class, "com.obric.memorydata.plugin");
        if ("true".equals(r2) == false) goto L5;
    L12:
        return true;
    L5:
        if ("false".equals(r2) == true) goto L12;
        if ("0".equals(r2) == true) goto L12;
        if ("1".equals(r2) == true) goto L12;
        return false;
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype
    public String convertToLexicalValue(Object r2, com.ctc.wstx.shaded.msv_core.datatype.c r3) {
        com.ctc.wstx.shaded.msv_core.datatype.c r1 = (com.ctc.wstx.shaded.msv_core.datatype.c) ZeusTransformUtils.wrapperContextForParams(r3, com.ctc.wstx.shaded.msv_core.datatype.c.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r2, Boolean.class) == false) goto L7;
        return save((Boolean) ZeusTransformUtils.preCheckCast(r2, Boolean.class, "com.obric.memorydata.plugin"));
    L7:
        throw new IllegalArgumentException();
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype
    public final XSDatatype getBaseType() {
        return SimpleURType.theInstance;
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.a
    public Class getJavaObjectType() {
        return Boolean.class;
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype
    public int isFacetApplicable(String r1) {
        if (r1.equals(XSDatatype.FACET_PATTERN) == false) goto L5;
        return 0;
    L5:
        if (r1.equals(XSDatatype.FACET_ENUMERATION) == false) goto L7;
        return 0;
    L7:
        if (r1.equals(XSDatatype.FACET_WHITESPACE) == true) goto L14;
        return -2;
    L14:
        return 0;
    }
}
