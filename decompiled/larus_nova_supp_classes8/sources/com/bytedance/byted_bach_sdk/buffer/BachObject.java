package com.bytedance.byted_bach_sdk.buffer;

import java.util.HashMap;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class BachObject {
    public BachObjectType infoType;
    public HashMap<String, BachObject> mapResult;
    public AlgorithmResultUnion valueResult;
    public BachObject[] vectorResult;

    public static final enum BachObjectType extends Enum<BachObjectType> {
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
        public static final BachObjectType INFO_TYPE_VEC = null;
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
            $VALUES = new BachObjectType[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8};
        }

        public static BachObjectType[] values() {
            return (BachObjectType[]) $VALUES.clone();
        }

        public static BachObjectType valueOf(String r1) {
            return (BachObjectType) a.a(BachObjectType.class, r1);
        }

        private BachObjectType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public BachObject() {
        this.infoType = BachObjectType.INFO_TYPE_NONE;
    }
}
