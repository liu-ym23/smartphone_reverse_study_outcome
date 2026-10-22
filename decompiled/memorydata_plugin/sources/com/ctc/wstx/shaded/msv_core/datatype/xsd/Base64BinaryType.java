package com.ctc.wstx.shaded.msv_core.datatype.xsd;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import okio.Utf8;

/* JADX INFO: loaded from: classes2.dex */
public class Base64BinaryType extends BinaryBaseType {
    private static final byte PADDING = 127;
    private static final byte[] decodeMap = null;
    private static final char[] encodeMap = null;
    private static final long serialVersionUID = 1;
    public static final Base64BinaryType theInstance = null;

    static {
        theInstance = new Base64BinaryType();
        decodeMap = initDecodeMap();
        encodeMap = initEncodeMap();
    }

    private Base64BinaryType() {
        super("base64Binary");
    }

    private static int calcLength(char[] r9) {
        int r0 = r9.length;
        int r1 = 0;
        int r2 = 0;
        int r3 = 0;
    L4:
        if (r2 >= r0) goto L15;
        if (r9[r2] == '=') goto L15;
        if (r9[r2] >= 256) goto L10;
        if (decodeMap[r9[r2]] == (-1)) goto L14;
        r3 = r3 + 1;
    L14:
        r2 = r2 + 1;
        goto L4
    L10:
        return -1;
    L15:
        if (r2 >= r0) goto L27;
        if (r9[r2] != '=') goto L20;
        r1 = r1 + 1;
    L25:
        r2 = r2 + 1;
        goto L15
    L20:
        if (r9[r2] >= 256) goto L21;
        if (decodeMap[r9[r2]] == (-1)) goto L25;
        return -1;
    L21:
        return -1;
    L27:
        if (r1 <= 2) goto L29;
        return -1;
    L29:
        int r4 = r3 + r1;
        if ((r4 % 4) == 0) goto L33;
        return -1;
    L33:
        return ((r4 / 4) * 3) - r1;
    }

    public static char encode(int r1) {
        return encodeMap[r1 & 63];
    }

    private static byte[] initDecodeMap() {
        byte[] r1 = new byte[256];
        int r2 = 0;
    L3:
        if (r2 >= 256) goto L5;
        r1[r2] = -1;
        r2 = r2 + 1;
        goto L3
    L5:
        int r0 = 65;
    L7:
        if (r0 > 90) goto L9;
        r1[r0] = (byte) (r0 - 65);
        r0 = r0 + 1;
        goto L7
    L9:
        int r3 = 97;
    L11:
        if (r3 > 122) goto L13;
        r1[r3] = (byte) ((r3 - 97) + 26);
        r3 = r3 + 1;
        goto L11
    L13:
        int r4 = 48;
    L15:
        if (r4 > 57) goto L17;
        r1[r4] = (byte) ((r4 - 48) + 52);
        r4 = r4 + 1;
        goto L15
    L17:
        r1[43] = 62;
        r1[47] = Utf8.REPLACEMENT_BYTE;
        r1[61] = 127;
        return r1;
    }

    private static char[] initEncodeMap() {
        char[] r0 = new char[64];
        int r1 = 0;
    L3:
        int r2 = 26;
        if (r1 >= 26) goto L6;
        r0[r1] = (char) (r1 + 65);
        r1 = r1 + 1;
    L6:
        int r3 = 52;
        if (r2 >= 52) goto L10;
        r0[r2] = (char) ((r2 - 26) + 97);
        r2 = r2 + 1;
    L10:
        if (r3 >= 62) goto L12;
        r0[r3] = (char) ((r3 - 52) + 48);
        r3 = r3 + 1;
        goto L10
    L12:
        r0[62] = '+';
        r0[63] = '/';
        return r0;
    }

    public static byte[] load(String r13) {
        char[] r14 = r13.toCharArray();
        int r0 = calcLength(r14);
        if (r0 != (-1)) goto L6;
        return null;
    L6:
        byte[] r1 = new byte[r0];
        int r2 = r14.length;
        byte[] r4 = new byte[4];
        int r6 = 0;
        int r7 = 0;
        int r8 = 0;
    L7:
        if (r6 >= r2) goto L21;
        byte r9 = decodeMap[r14[r6]];
        if (r9 == (-1)) goto L11;
        r4[r7] = r9;
        r7 = r7 + 1;
    L11:
        if (r7 != 4) goto L20;
        int r10 = r8 + 1;
        r1[r8] = (byte) ((r4[0] << 2) | (r4[1] >> 4));
        if (r4[2] == 127) goto L16;
        r1[r10] = (byte) ((r4[1] << 4) | (r4[2] >> 2));
        r10 = r10 + 1;
    L16:
        if (r4[3] == 127) goto L18;
        r1[r10] = (byte) (r4[3] | (r4[2] << 6));
        r8 = r10 + 1;
    L19:
        r7 = 0;
        goto L20
    L18:
        r8 = r10;
    L20:
        r6 = r6 + 1;
        goto L7
    L21:
        if (r7 != 0) goto L24;
        return r1;
    L24:
        throw new IllegalStateException();
    }

    public static String save(byte[] r6) {
        StringBuffer r0 = new StringBuffer((r6.length * 4) / 3);
        int r1 = 0;
    L4:
        if (r1 >= r6.length) goto L14;
        int r2 = r6.length - r1;
        if (r2 == 1) goto L10;
        if (r2 == 2) goto L9;
        r0.append(encode(r6[r1] >> 2));
        int r3 = r1 + 1;
        r0.append(encode(((r6[r1] & 3) << 4) | ((r6[r3] >> 4) & 15)));
        int r4 = (r6[r3] & 15) << 2;
        int r5 = r1 + 2;
        r0.append(encode(r4 | ((r6[r5] >> 6) & 3)));
        r0.append(encode(r6[r5] & Utf8.REPLACEMENT_BYTE));
    L12:
        r1 = r1 + 3;
        goto L4
    L9:
        r0.append(encode(r6[r1] >> 2));
        int r7 = r1 + 1;
        r0.append(encode(((r6[r1] & 3) << 4) | ((r6[r7] >> 4) & 15)));
        r0.append(encode((r6[r7] & 15) << 2));
        String r8 = "=";
    L11:
        r0.append(r8);
        goto L12
    L10:
        r0.append(encode(r6[r1] >> 2));
        r0.append(encode((r6[r1] & 3) << 4));
        r8 = "==";
        goto L11
    L14:
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
    public boolean checkFormat(String r2, com.ctc.wstx.shaded.msv.relaxng_datatype.e r3) {
        com.ctc.wstx.shaded.msv.relaxng_datatype.e r1 = (com.ctc.wstx.shaded.msv.relaxng_datatype.e) ZeusTransformUtils.wrapperContextForParams(r3, com.ctc.wstx.shaded.msv.relaxng_datatype.e.class, "com.obric.memorydata.plugin");
        if (calcLength(r2.toCharArray()) == (-1)) goto L5;
        return true;
    L5:
        return false;
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
