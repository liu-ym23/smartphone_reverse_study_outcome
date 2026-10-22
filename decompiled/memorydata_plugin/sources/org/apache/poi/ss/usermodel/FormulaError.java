package org.apache.poi.ss.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public final enum FormulaError extends Enum<FormulaError> {
    private static final /* synthetic */ FormulaError[] $VALUES = null;
    public static final FormulaError CIRCULAR_REF = null;
    public static final FormulaError DIV0 = null;
    public static final FormulaError FUNCTION_NOT_IMPLEMENTED = null;
    public static final FormulaError NA = null;
    public static final FormulaError NAME = null;
    public static final FormulaError NULL = null;
    public static final FormulaError NUM = null;
    public static final FormulaError REF = null;
    public static final FormulaError VALUE = null;
    public static final FormulaError _NO_ERROR = null;
    private static final Map<Byte, FormulaError> bmap = null;
    private static final Map<Integer, FormulaError> imap = null;
    private static final Map<String, FormulaError> smap = null;
    private final int longType;
    private final String repr;
    private final byte type;

    static {
        int r2 = 0;
        FormulaError r0 = new FormulaError("_NO_ERROR", 0, -1, "(no error)");
        _NO_ERROR = r0;
        FormulaError r1 = new FormulaError("NULL", 1, 0, "#NULL!");
        NULL = r1;
        FormulaError r3 = new FormulaError("DIV0", 2, 7, "#DIV/0!");
        DIV0 = r3;
        FormulaError r5 = new FormulaError("VALUE", 3, 15, "#VALUE!");
        VALUE = r5;
        FormulaError r8 = new FormulaError("REF", 4, 23, "#REF!");
        REF = r8;
        FormulaError r10 = new FormulaError("NAME", 5, 29, "#NAME?");
        NAME = r10;
        FormulaError r12 = new FormulaError("NUM", 6, 36, "#NUM!");
        NUM = r12;
        FormulaError r11 = new FormulaError("NA", 7, 42, "#N/A");
        NA = r11;
        FormulaError r13 = new FormulaError("CIRCULAR_REF", 8, -60, "~CIRCULAR~REF~");
        CIRCULAR_REF = r13;
        FormulaError r7 = new FormulaError("FUNCTION_NOT_IMPLEMENTED", 9, -30, "~FUNCTION~NOT~IMPLEMENTED~");
        FUNCTION_NOT_IMPLEMENTED = r7;
        $VALUES = new FormulaError[]{r0, r1, r3, r5, r8, r10, r12, r11, r13, r7};
        smap = new HashMap();
        bmap = new HashMap();
        imap = new HashMap();
        FormulaError[] r4 = values();
        int r6 = r4.length;
    L3:
        if (r2 >= r6) goto L5;
        FormulaError r9 = r4[r2];
        bmap.put(Byte.valueOf(r9.getCode()), r9);
        imap.put(Integer.valueOf(r9.getLongCode()), r9);
        smap.put(r9.getString(), r9);
        r2 = r2 + 1;
        goto L3
    }

    private FormulaError(String r1, int r2, int r3, String r4) {
        super(r1, r2);
        this.type = (byte) r3;
        this.longType = r3;
        this.repr = r4;
    }

    public static FormulaError forInt(byte r3) {
        FormulaError r0 = (FormulaError) ZeusTransformUtils.preCheckCast(bmap.get(Byte.valueOf(r3)), FormulaError.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalArgumentException("Unknown error type: " + r3);
    }

    public static FormulaError forInt(int r4) {
        FormulaError r1 = (FormulaError) ZeusTransformUtils.preCheckCast(imap.get(Integer.valueOf(r4)), FormulaError.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L5;
        r1 = (FormulaError) ZeusTransformUtils.preCheckCast(bmap.get(Byte.valueOf((byte) r4)), FormulaError.class, "com.obric.memorydata.plugin");
    L5:
        if (r1 == null) goto L8;
        return r1;
    L8:
        throw new IllegalArgumentException("Unknown error type: " + r4);
    }

    public static FormulaError forString(String r3) {
        FormulaError r0 = (FormulaError) ZeusTransformUtils.preCheckCast(smap.get(r3), FormulaError.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalArgumentException("Unknown error code: " + r3);
    }

    public static boolean isValidCode(int r7) {
        FormulaError[] r0 = values();
        int r1 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L11;
        FormulaError r4 = r0[r3];
        if (r4.getCode() == r7) goto L6;
        if (r4.getLongCode() == r7) goto L9;
        r3 = r3 + 1;
        goto L3
    L9:
        return true;
    L6:
        return true;
    L11:
        return false;
    }

    public static FormulaError valueOf(String r2) {
        return (FormulaError) ZeusTransformUtils.preCheckCast(Enum.valueOf(FormulaError.class, r2), FormulaError.class, "com.obric.memorydata.plugin");
    }

    public static FormulaError[] values() {
        return (FormulaError[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), FormulaError[].class, "com.obric.memorydata.plugin");
    }

    public byte getCode() {
        return this.type;
    }

    public int getLongCode() {
        return this.longType;
    }

    public String getString() {
        return this.repr;
    }
}
