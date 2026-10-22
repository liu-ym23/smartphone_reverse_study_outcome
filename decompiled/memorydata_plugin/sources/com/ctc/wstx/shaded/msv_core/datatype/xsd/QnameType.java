package com.ctc.wstx.shaded.msv_core.datatype.xsd;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.logging.log4j.message.ParameterizedMessage;

/* JADX INFO: loaded from: classes2.dex */
public class QnameType extends BuiltinAtomicType implements c {
    private static final long serialVersionUID = 1;
    public static final QnameType theInstance = null;

    static {
        theInstance = new QnameType();
    }

    private QnameType() {
        super("QName");
    }

    private String serialize(String r2, String r3, com.ctc.wstx.shaded.msv_core.datatype.c r4) {
        String r1 = ((com.ctc.wstx.shaded.msv_core.datatype.c) ZeusTransformUtils.wrapperContextForParams(r4, com.ctc.wstx.shaded.msv_core.datatype.c.class, "com.obric.memorydata.plugin")).a(r2);
        if (r1 != null) goto L6;
        return r3;
    L6:
        return r1 + ParameterizedMessage.ERROR_MSG_SEPARATOR + r3;
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.ConcreteType, com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatypeImpl
    public Object _createJavaObject(String r3, com.ctc.wstx.shaded.msv.relaxng_datatype.e r4) {
        QnameValueType r2 = (QnameValueType) ZeusTransformUtils.preCheckCast(createValue(r3, (com.ctc.wstx.shaded.msv.relaxng_datatype.e) ZeusTransformUtils.wrapperContextForParams(r4, com.ctc.wstx.shaded.msv.relaxng_datatype.e.class, "com.obric.memorydata.plugin")), QnameValueType.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L7;
        return null;
    L7:
        return new String[]{r2.namespaceURI, r2.localPart};
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatypeImpl
    public Object _createValue(String r3, com.ctc.wstx.shaded.msv.relaxng_datatype.e r4) {
        com.ctc.wstx.shaded.msv.relaxng_datatype.e r2 = (com.ctc.wstx.shaded.msv.relaxng_datatype.e) ZeusTransformUtils.wrapperContextForParams(r4, com.ctc.wstx.shaded.msv.relaxng_datatype.e.class, "com.obric.memorydata.plugin");
        int r0 = r3.indexOf(58);
        if (r0 > 0) goto L10;
        if (f.b(r3) == true) goto L7;
        return null;
    L7:
        String r5 = "";
    L8:
        String r6 = r2.a_(r5);
        if (r6 != null) goto L20;
        return null;
    L20:
        return new QnameValueType(r6, r3);
    L10:
        if (r3.lastIndexOf(58) == r0) goto L12;
        return null;
    L12:
        r5 = r3.substring(0, r0);
        r3 = r3.substring(r0 + 1);
        if (f.b(r5) == true) goto L15;
    L21:
        return null;
    L15:
        if (f.b(r3) == true) goto L8;
        goto L8
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatypeImpl
    public boolean checkFormat(String r5, com.ctc.wstx.shaded.msv.relaxng_datatype.e r6) {
        com.ctc.wstx.shaded.msv.relaxng_datatype.e r4 = (com.ctc.wstx.shaded.msv.relaxng_datatype.e) ZeusTransformUtils.wrapperContextForParams(r6, com.ctc.wstx.shaded.msv.relaxng_datatype.e.class, "com.obric.memorydata.plugin");
        int r0 = r5.indexOf(58);
        if (r0 > 0) goto L7;
        return f.b(r5);
    L7:
        if (r5.lastIndexOf(58) == r0) goto L9;
        return false;
    L9:
        String r7 = r5.substring(0, r0);
        if (f.b(r7) == true) goto L12;
        return false;
    L12:
        if (f.b(r5.substring(r0 + 1)) == true) goto L14;
        return false;
    L14:
        if (r4.a_(r7) != null) goto L16;
        return false;
    L16:
        return true;
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype
    public String convertToLexicalValue(Object r3, com.ctc.wstx.shaded.msv_core.datatype.c r4) {
        com.ctc.wstx.shaded.msv_core.datatype.c r5 = (com.ctc.wstx.shaded.msv_core.datatype.c) ZeusTransformUtils.wrapperContextForParams(r4, com.ctc.wstx.shaded.msv_core.datatype.c.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, QnameValueType.class) == false) goto L7;
        QnameValueType r6 = (QnameValueType) ZeusTransformUtils.preCheckCast(r3, QnameValueType.class, "com.obric.memorydata.plugin");
        return serialize(r6.namespaceURI, r6.localPart, r5);
    L7:
        throw new UnsupportedOperationException();
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.c
    public final int countLength(Object r2) {
        QnameValueType r1 = (QnameValueType) ZeusTransformUtils.preCheckCast(r2, QnameValueType.class, "com.obric.memorydata.plugin");
        return e.a(r1.namespaceURI) + e.a(r1.localPart);
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype
    public final XSDatatype getBaseType() {
        return SimpleURType.theInstance;
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.a
    public Class getJavaObjectType() {
        return String[].class;
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatypeImpl
    public boolean isContextDependent() {
        return true;
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
        if (r1.equals(XSDatatype.FACET_LENGTH) == false) goto L11;
        return 0;
    L11:
        if (r1.equals(XSDatatype.FACET_MAXLENGTH) == false) goto L13;
        return 0;
    L13:
        if (r1.equals(XSDatatype.FACET_MINLENGTH) == true) goto L23;
        return -2;
    L23:
        return 0;
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.ConcreteType, com.ctc.wstx.shaded.msv_core.datatype.a
    public String serializeJavaObject(Object r3, com.ctc.wstx.shaded.msv_core.datatype.c r4) {
        com.ctc.wstx.shaded.msv_core.datatype.c r5 = (com.ctc.wstx.shaded.msv_core.datatype.c) ZeusTransformUtils.wrapperContextForParams(r4, com.ctc.wstx.shaded.msv_core.datatype.c.class, "com.obric.memorydata.plugin");
        if ((r3 instanceof String[]) == false) goto L11;
        String[] r6 = (String[]) ZeusTransformUtils.preCheckCast((String[]) ZeusTransformUtils.preCheckCast(r3, String[].class, "com.obric.memorydata.plugin"), String[].class, "com.obric.memorydata.plugin");
        if (r6.length != 2) goto L9;
        return serialize(r6[0], r6[1], r5);
    L9:
        throw new IllegalArgumentException();
    L11:
        throw new IllegalArgumentException();
    }
}
