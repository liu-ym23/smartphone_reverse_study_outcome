package org.apache.poi.ss.formula.constant;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;
import org.apache.poi.util.StringUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class ConstantValueParser {
    private static final Object EMPTY_REPRESENTATION = null;

    static {
    }

    public static void encode(LittleEndianOutput r3, Object[] r4) {
        LittleEndianOutput r5 = (LittleEndianOutput) ZeusTransformUtils.wrapperContextForParams(r3, LittleEndianOutput.class, "com.obric.memorydata.plugin");
        int r0 = r4.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        encodeSingleValue(r5, r4[r1]);
        r1 = r1 + 1;
        goto L3
    }

    private static void encodeSingleValue(LittleEndianOutput r4, Object r5) {
        LittleEndianOutput r6 = (LittleEndianOutput) ZeusTransformUtils.wrapperContextForParams(r4, LittleEndianOutput.class, "com.obric.memorydata.plugin");
        long r2 = 0;
        if (r5 != EMPTY_REPRESENTATION) goto L7;
        r6.writeByte(0);
        r6.writeLong(0);
        return;
    L7:
        if (ZeusTransformUtils.instanceOf(r5, Boolean.class) == false) goto L14;
        Boolean r7 = (Boolean) ZeusTransformUtils.preCheckCast(r5, Boolean.class, "com.obric.memorydata.plugin");
        r6.writeByte(4);
        if (r7.booleanValue() == false) goto L11;
        r2 = 1;
    L11:
        r6.writeLong(r2);
        return;
    L14:
        if (ZeusTransformUtils.instanceOf(r5, Double.class) == false) goto L18;
        Double r8 = (Double) ZeusTransformUtils.preCheckCast(r5, Double.class, "com.obric.memorydata.plugin");
        r6.writeByte(1);
        r6.writeDouble(r8.doubleValue());
        return;
    L18:
        if (ZeusTransformUtils.instanceOf(r5, String.class) == false) goto L22;
        String r9 = (String) ZeusTransformUtils.preCheckCast(r5, String.class, "com.obric.memorydata.plugin");
        r6.writeByte(2);
        StringUtil.writeUnicodeString(r6, r9);
        return;
    L22:
        if (ZeusTransformUtils.instanceOf(r5, ErrorConstant.class) == false) goto L26;
        ErrorConstant r10 = (ErrorConstant) ZeusTransformUtils.preCheckCast(r5, ErrorConstant.class, "com.obric.memorydata.plugin");
        r6.writeByte(16);
        r6.writeLong(r10.getErrorCode());
        return;
    L26:
        throw new IllegalStateException("Unexpected value type (" + r5.getClass().getName() + "'");
    }

    private static int getEncodedSize(Object r3) {
        if (r3 != EMPTY_REPRESENTATION) goto L5;
        return 8;
    L5:
        Class<?> r0 = r3.getClass();
        if (r0 != Boolean.class) goto L8;
    L14:
        return 8;
    L8:
        if (r0 == Double.class) goto L14;
        if (r0 == ErrorConstant.class) goto L14;
        return StringUtil.getEncodedSize((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"));
    }

    public static int getEncodedSize(Object[] r4) {
        int r0 = r4.length;
        int r1 = r4.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        r0 = r0 + getEncodedSize(r4[r2]);
        r2 = r2 + 1;
        goto L3
    L5:
        return r0;
    }

    public static Object[] parse(LittleEndianInput r3, int r4) {
        LittleEndianInput r5 = (LittleEndianInput) ZeusTransformUtils.wrapperContextForParams(r3, LittleEndianInput.class, "com.obric.memorydata.plugin");
        if (r4 < 0) goto L9;
        Object[] r0 = new Object[r4];
        int r1 = 0;
    L5:
        if (r1 >= r4) goto L7;
        r0[r1] = readAConstantValue(r5);
        r1 = r1 + 1;
        goto L5
    L7:
        return r0;
    L9:
        throw new IllegalArgumentException("Invalid number of values to parse: " + r4);
    }

    private static Object readAConstantValue(LittleEndianInput r3) {
        LittleEndianInput r4 = (LittleEndianInput) ZeusTransformUtils.wrapperContextForParams(r3, LittleEndianInput.class, "com.obric.memorydata.plugin");
        byte r0 = r4.readByte();
        if (r0 != 0) goto L5;
        r4.readLong();
        return EMPTY_REPRESENTATION;
    L5:
        if (r0 == 1) goto L21;
        if (r0 == 2) goto L19;
        if (r0 == 4) goto L17;
        if (r0 != 16) goto L15;
        int r1 = r4.readUShort();
        r4.readUShort();
        r4.readInt();
        return ErrorConstant.valueOf(r1);
    L15:
        throw new IllegalArgumentException("Unknown grbit value (" + r0 + ")");
    L17:
        return readBoolean(r4);
    L19:
        return StringUtil.readUnicodeString(r4);
    L21:
        return Double.valueOf(r4.readDouble());
    }

    private static Object readBoolean(LittleEndianInput r3) {
        byte r4 = (byte) ((LittleEndianInput) ZeusTransformUtils.wrapperContextForParams(r3, LittleEndianInput.class, "com.obric.memorydata.plugin")).readLong();
        if (r4 == 0) goto L11;
        if (r4 != 1) goto L9;
        return Boolean.TRUE;
    L9:
        throw new IllegalArgumentException("unexpected boolean encoding (" + r4 + ")");
    L11:
        return Boolean.FALSE;
    }
}
