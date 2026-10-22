package com.ctc.wstx.shaded.msv_core.grammar.relax;

import com.ctc.wstx.shaded.msv.relaxng_datatype.e;
import com.ctc.wstx.shaded.msv_core.datatype.xsd.BuiltinAtomicType;
import com.ctc.wstx.shaded.msv_core.datatype.xsd.SimpleURType;
import com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class EmptyStringType extends BuiltinAtomicType {
    private static final long serialVersionUID = 1;
    public static final EmptyStringType theInstance = null;

    static {
        theInstance = new EmptyStringType();
    }

    private EmptyStringType() {
        super("emptyString");
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatypeImpl
    public Object _createValue(String r2, e r3) {
        e r1 = (e) ZeusTransformUtils.wrapperContextForParams(r3, e.class, "com.obric.memorydata.plugin");
        if (r2.equals("") == false) goto L5;
        return r2;
    L5:
        return null;
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatypeImpl
    public boolean checkFormat(String r2, e r3) {
        e r1 = (e) ZeusTransformUtils.wrapperContextForParams(r3, e.class, "com.obric.memorydata.plugin");
        return r2.equals("");
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype
    public String convertToLexicalValue(Object r2, com.ctc.wstx.shaded.msv_core.datatype.c r3) {
        com.ctc.wstx.shaded.msv_core.datatype.c r1 = (com.ctc.wstx.shaded.msv_core.datatype.c) ZeusTransformUtils.wrapperContextForParams(r3, com.ctc.wstx.shaded.msv_core.datatype.c.class, "com.obric.memorydata.plugin");
        if (r2.equals("") == false) goto L6;
        return "";
    L6:
        throw new IllegalArgumentException();
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype
    public final XSDatatype getBaseType() {
        return SimpleURType.theInstance;
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.a
    public Class getJavaObjectType() {
        return String.class;
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype
    public int isFacetApplicable(String r1) {
        return -2;
    }
}
