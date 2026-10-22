package com.bytedance.byted_bach_sdk.buffer;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class BachObject {
    public BachObjectType infoType;
    public HashMap<String, BachObject> mapResult;
    public BachTensorResult tensorResult;
    public AlgorithmResultUnion valueResult;
    public BachObject[] vectorResult;

    static final enum BachObjectType extends Enum<BachObjectType> {
        private static final /* synthetic */ BachObjectType[] $VALUES = null;
        public static final BachObjectType INFO_TYPE_BITMAP = null;
        public static final BachObjectType INFO_TYPE_BOOL = null;
        public static final BachObjectType INFO_TYPE_BYTEARRAY = null;
        public static final BachObjectType INFO_TYPE_HASHMAP = null;
        public static final BachObjectType INFO_TYPE_INT = null;
        public static final BachObjectType INFO_TYPE_MATXF = null;
        public static final BachObjectType INFO_TYPE_NONE = null;
        public static final BachObjectType INFO_TYPE_REAL = null;
        public static final BachObjectType INFO_TYPE_STRING = null;
        public static final BachObjectType INFO_TYPE_TENSOR = null;
        public static final BachObjectType INFO_TYPE_VEC = null;
        public static final BachObjectType INFO_TYPE_VECXD = null;
        public static final BachObjectType INFO_TYPE_VECXF = null;
        public static final BachObjectType INFO_TYPE_VECXI = null;
        public static final BachObjectType INFO_TYPE_VECXS = null;

        static {
            BachObjectType r0 = new BachObjectType("INFO_TYPE_NONE", 0);
            INFO_TYPE_NONE = r0;
            BachObjectType r1 = new BachObjectType("INFO_TYPE_INT", 1);
            INFO_TYPE_INT = r1;
            BachObjectType r3 = new BachObjectType("INFO_TYPE_REAL", 2);
            INFO_TYPE_REAL = r3;
            BachObjectType r5 = new BachObjectType("INFO_TYPE_STRING", 3);
            INFO_TYPE_STRING = r5;
            BachObjectType r7 = new BachObjectType("INFO_TYPE_VECXI", 4);
            INFO_TYPE_VECXI = r7;
            BachObjectType r9 = new BachObjectType("INFO_TYPE_VECXF", 5);
            INFO_TYPE_VECXF = r9;
            BachObjectType r11 = new BachObjectType("INFO_TYPE_VECXS", 6);
            INFO_TYPE_VECXS = r11;
            BachObjectType r13 = new BachObjectType("INFO_TYPE_MATXF", 7);
            INFO_TYPE_MATXF = r13;
            BachObjectType r15 = new BachObjectType("INFO_TYPE_BITMAP", 8);
            INFO_TYPE_BITMAP = r15;
            BachObjectType r14 = new BachObjectType("INFO_TYPE_HASHMAP", 9);
            INFO_TYPE_HASHMAP = r14;
            BachObjectType r12 = new BachObjectType("INFO_TYPE_VEC", 10);
            INFO_TYPE_VEC = r12;
            BachObjectType r10 = new BachObjectType("INFO_TYPE_BYTEARRAY", 11);
            INFO_TYPE_BYTEARRAY = r10;
            BachObjectType r8 = new BachObjectType("INFO_TYPE_BOOL", 12);
            INFO_TYPE_BOOL = r8;
            BachObjectType r6 = new BachObjectType("INFO_TYPE_TENSOR", 13);
            INFO_TYPE_TENSOR = r6;
            BachObjectType r4 = new BachObjectType("INFO_TYPE_VECXD", 14);
            INFO_TYPE_VECXD = r4;
            $VALUES = new BachObjectType[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4};
        }

        private BachObjectType(String r1, int r2) {
            super(r1, r2);
        }

        public static BachObjectType valueOf(String r2) {
            return (BachObjectType) ZeusTransformUtils.preCheckCast(Enum.valueOf(BachObjectType.class, r2), BachObjectType.class, "com.obric.memorydata.plugin");
        }

        public static BachObjectType[] values() {
            return (BachObjectType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), BachObjectType[].class, "com.obric.memorydata.plugin");
        }
    }

    public BachObject() {
        this.infoType = BachObjectType.INFO_TYPE_NONE;
    }

    public boolean asBool() {
        if (this.infoType != BachObjectType.INFO_TYPE_BOOL) goto L12;
        AlgorithmResultUnion r6 = this.valueResult;
        if (r6 == null) goto L10;
        if (r6.boolVal == false) goto L10;
        return true;
    L10:
        return false;
    L12:
        if (this.infoType != BachObjectType.INFO_TYPE_INT) goto L21;
        AlgorithmResultUnion r7 = this.valueResult;
        if (r7 == null) goto L19;
        if (r7.int64Val == 0) goto L19;
        return true;
    L19:
        return false;
    L21:
        if (this.infoType != BachObjectType.INFO_TYPE_REAL) goto L29;
        AlgorithmResultUnion r8 = this.valueResult;
        if (r8 == null) goto L28;
        if (Math.abs(r8.doubleVal) <= 1.0E-12d) goto L28;
        return true;
    L28:
        return false;
    L29:
        return false;
    }

    public double asDouble() {
        if (this.infoType != BachObjectType.INFO_TYPE_REAL) goto L9;
        AlgorithmResultUnion r4 = this.valueResult;
        if (r4 != null) goto L7;
        return 0.0d;
    L7:
        return r4.doubleVal;
    L9:
        if (this.infoType != BachObjectType.INFO_TYPE_BOOL) goto L17;
        AlgorithmResultUnion r5 = this.valueResult;
        if (r5 != null) goto L13;
        return 0.0d;
    L13:
        if (r5.boolVal == false) goto L35;
        return 1.0d;
    L35:
        return 0.0d;
    L17:
        if (this.infoType != BachObjectType.INFO_TYPE_INT) goto L23;
        AlgorithmResultUnion r6 = this.valueResult;
        if (r6 != null) goto L21;
        return 0.0d;
    L21:
        return r6.int64Val;
    L23:
        if (this.infoType != BachObjectType.INFO_TYPE_STRING) goto L30;
        AlgorithmResultUnion r7 = this.valueResult;
        if (r7 == null) goto L30;
        return Double.parseDouble(r7.stringVal);
    L28:
        e = move-exception;
        e.printStackTrace();
    L30:
        return 0.0d;
    }

    public float asFloat() {
        return (float) asDouble();
    }

    public int asInt() {
        return (int) asLong();
    }

    public long asLong() {
        if (this.infoType != BachObjectType.INFO_TYPE_BOOL) goto L11;
        AlgorithmResultUnion r4 = this.valueResult;
        if (r4 != null) goto L7;
        return 0;
    L7:
        if (r4.boolVal == false) goto L34;
        return 1;
    L34:
        return 0;
    L11:
        if (this.infoType != BachObjectType.INFO_TYPE_INT) goto L17;
        AlgorithmResultUnion r5 = this.valueResult;
        if (r5 != null) goto L15;
        return 0;
    L15:
        return r5.int64Val;
    L17:
        if (this.infoType != BachObjectType.INFO_TYPE_REAL) goto L23;
        AlgorithmResultUnion r6 = this.valueResult;
        if (r6 != null) goto L21;
        return 0;
    L21:
        return (long) r6.doubleVal;
    L23:
        if (this.infoType != BachObjectType.INFO_TYPE_STRING) goto L30;
        AlgorithmResultUnion r7 = this.valueResult;
        if (r7 == null) goto L30;
        return Long.parseLong(r7.stringVal);
    L28:
        e = move-exception;
        e.printStackTrace();
    L30:
        return 0;
    }

    public String asString() {
        if (this.infoType != BachObjectType.INFO_TYPE_STRING) goto L9;
        AlgorithmResultUnion r3 = this.valueResult;
        if (r3 != null) goto L7;
        return null;
    L7:
        return r3.stringVal;
    L9:
        if (this.infoType != BachObjectType.INFO_TYPE_BOOL) goto L19;
        AlgorithmResultUnion r4 = this.valueResult;
        if (r4 != null) goto L13;
    L15:
        int r5 = 0;
    L17:
        return String.valueOf(r5);
    L13:
        if (r4.boolVal == false) goto L15;
        r5 = 1;
        goto L17
    L19:
        if (this.infoType != BachObjectType.INFO_TYPE_INT) goto L27;
        AlgorithmResultUnion r6 = this.valueResult;
        if (r6 == null) goto L23;
        long r0 = r6.int64Val;
    L25:
        return String.valueOf(r0);
    L23:
        r0 = 0;
        goto L25
    L27:
        if (this.infoType != BachObjectType.INFO_TYPE_REAL) goto L34;
        AlgorithmResultUnion r7 = this.valueResult;
        if (r7 == null) goto L31;
        double r1 = r7.doubleVal;
    L33:
        return String.valueOf(r1);
    L31:
        r1 = 0.0d;
        goto L33
    L34:
        return null;
    }
}
