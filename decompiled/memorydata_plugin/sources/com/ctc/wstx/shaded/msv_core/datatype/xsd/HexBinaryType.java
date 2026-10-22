package com.ctc.wstx.shaded.msv_core.datatype.xsd;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class HexBinaryType extends BinaryBaseType {
    private static final long serialVersionUID = 1;
    public static final HexBinaryType theInstance = null;

    static {
        theInstance = new HexBinaryType();
    }

    private HexBinaryType() {
        super("hexBinary");
    }

    public static char encode(int r1) {
        int r2 = r1 & 15;
        if (r2 >= 10) goto L7;
        int r3 = r2 + 48;
    L6:
        return (char) r3;
    L7:
        r3 = (r2 - 10) + 65;
        goto L6
    }

    private static int hexToBin(char r2) {
        if ('0' <= r2) goto L5;
    L8:
        char r0 = 'A';
        if ('A' <= r2) goto L11;
    L14:
        r0 = 'a';
        if ('a' <= r2) goto L17;
        return -1;
    L17:
        if (r2 <= 'f') goto L13;
        return -1;
    L13:
        return (r2 - r0) + 10;
    L11:
        if (r2 > 'F') goto L14;
    L5:
        if (r2 > '9') goto L8;
        return r2 - '0';
    }

    public static byte[] load(String r7) {
        int r0 = r7.length();
        if ((r0 % 2) == 0) goto L5;
        return null;
    L5:
        byte[] r1 = new byte[r0 / 2];
        int r3 = 0;
    L6:
        if (r3 >= r0) goto L13;
        int r4 = hexToBin(r7.charAt(r3));
        int r5 = hexToBin(r7.charAt(r3 + 1));
        if (r4 == (-1)) goto L12;
        if (r5 == (-1)) goto L12;
        r1[r3 / 2] = (byte) ((r4 * 16) + r5);
        r3 = r3 + 2;
    L12:
        return null;
    L13:
        return r1;
    }

    public static String save(byte[] r3) {
        StringBuffer r0 = new StringBuffer(r3.length * 2);
        int r1 = 0;
    L4:
        if (r1 >= r3.length) goto L7;
        r0.append(encode(r3[r1] >> 4));
        r0.append(encode(r3[r1] & 15));
        r1 = r1 + 1;
        goto L4
    L7:
        return r0.toString();
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.BinaryBaseType, com.ctc.wstx.shaded.msv_core.datatype.xsd.ConcreteType, com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatypeImpl
    public /* synthetic */ Object _createJavaObject(String r3, com.ctc.wstx.shaded.msv.relaxng_datatype.e r4) {
        return super._createJavaObject(r3, (com.ctc.wstx.shaded.msv.relaxng_datatype.e) ZeusTransformUtils.wrapperContextForParams(r4, com.ctc.wstx.shaded.msv.relaxng_datatype.e.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatypeImpl
    public Object _createValue(String r2, com.ctc.wstx.shaded.msv.relaxng_datatype.e r3) {
        com.ctc.wstx.shaded.msv.relaxng_datatype.e r1 = (com.ctc.wstx.shaded.msv.relaxng_datatype.e) ZeusTransformUtils.wrapperContextForParams(r3, com.ctc.wstx.shaded.msv.relaxng_datatype.e.class, "com.obric.memorydata.plugin");
        byte[] r4 = load(r2);
        if (r4 != null) goto L7;
        return null;
    L7:
        return new BinaryValueType(r4);
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatypeImpl
    public boolean checkFormat(String r4, com.ctc.wstx.shaded.msv.relaxng_datatype.e r5) {
        com.ctc.wstx.shaded.msv.relaxng_datatype.e r3 = (com.ctc.wstx.shaded.msv.relaxng_datatype.e) ZeusTransformUtils.wrapperContextForParams(r5, com.ctc.wstx.shaded.msv.relaxng_datatype.e.class, "com.obric.memorydata.plugin");
        int r6 = r4.length();
        if ((r6 % 2) == 0) goto L5;
        return false;
    L5:
        int r7 = 0;
    L6:
        if (r7 >= r6) goto L11;
        if (hexToBin(r4.charAt(r7)) == (-1)) goto L9;
        r7 = r7 + 1;
        goto L6
    L9:
        return false;
    L11:
        return true;
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype
    public String convertToLexicalValue(Object r3, com.ctc.wstx.shaded.msv_core.datatype.c r4) {
        com.ctc.wstx.shaded.msv_core.datatype.c r5 = (com.ctc.wstx.shaded.msv_core.datatype.c) ZeusTransformUtils.wrapperContextForParams(r4, com.ctc.wstx.shaded.msv_core.datatype.c.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, BinaryValueType.class) == false) goto L7;
        return serializeJavaObject(((BinaryValueType) ZeusTransformUtils.preCheckCast(r3, BinaryValueType.class, "com.obric.memorydata.plugin")).rawData, r5);
    L7:
        throw new IllegalArgumentException();
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.BinaryBaseType, com.ctc.wstx.shaded.msv_core.datatype.a
    public /* bridge */ /* synthetic */ Class getJavaObjectType() {
        return super.getJavaObjectType();
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.BinaryBaseType, com.ctc.wstx.shaded.msv_core.datatype.xsd.ConcreteType, com.ctc.wstx.shaded.msv_core.datatype.a
    public String serializeJavaObject(Object r3, com.ctc.wstx.shaded.msv_core.datatype.c r4) {
        com.ctc.wstx.shaded.msv_core.datatype.c r5 = (com.ctc.wstx.shaded.msv_core.datatype.c) ZeusTransformUtils.wrapperContextForParams(r4, com.ctc.wstx.shaded.msv_core.datatype.c.class, "com.obric.memorydata.plugin");
        if ((r3 instanceof byte[]) == false) goto L7;
        return save((byte[]) ZeusTransformUtils.preCheckCast((byte[]) ZeusTransformUtils.preCheckCast(r3, byte[].class, "com.obric.memorydata.plugin"), byte[].class, "com.obric.memorydata.plugin"));
    L7:
        throw new IllegalArgumentException();
    }
}
