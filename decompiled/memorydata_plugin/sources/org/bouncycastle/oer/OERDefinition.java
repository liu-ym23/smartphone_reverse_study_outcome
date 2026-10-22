package org.bouncycastle.oer;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class OERDefinition {
    static final BigInteger[][] sIntRange = null;
    static final BigInteger[] uIntMax = null;

    public static final enum BaseType extends Enum<BaseType> {
        private static final /* synthetic */ BaseType[] $VALUES = null;
        public static final BaseType BIT_STRING = null;
        public static final BaseType BMPString = null;
        public static final BaseType BOOLEAN = null;
        public static final BaseType CHOICE = null;
        public static final BaseType ENUM = null;
        public static final BaseType ENUM_ITEM = null;
        public static final BaseType EXTENSION = null;
        public static final BaseType IA5String = null;
        public static final BaseType INT = null;
        public static final BaseType IS0646String = null;
        public static final BaseType NULL = null;
        public static final BaseType NumericString = null;
        public static final BaseType OCTET_STRING = null;
        public static final BaseType OPAQUE = null;
        public static final BaseType PrintableString = null;
        public static final BaseType SEQ = null;
        public static final BaseType SEQ_OF = null;
        public static final BaseType Supplier = null;
        public static final BaseType Switch = null;
        public static final BaseType UTF8_STRING = null;
        public static final BaseType UniversalString = null;
        public static final BaseType VisibleString = null;

        static {
            BaseType r0 = new BaseType("SEQ", 0);
            SEQ = r0;
            BaseType r1 = new BaseType("SEQ_OF", 1);
            SEQ_OF = r1;
            BaseType r3 = new BaseType("CHOICE", 2);
            CHOICE = r3;
            BaseType r5 = new BaseType("ENUM", 3);
            ENUM = r5;
            BaseType r7 = new BaseType("INT", 4);
            INT = r7;
            BaseType r9 = new BaseType("OCTET_STRING", 5);
            OCTET_STRING = r9;
            BaseType r11 = new BaseType("OPAQUE", 6);
            OPAQUE = r11;
            BaseType r13 = new BaseType("UTF8_STRING", 7);
            UTF8_STRING = r13;
            BaseType r15 = new BaseType("BIT_STRING", 8);
            BIT_STRING = r15;
            BaseType r14 = new BaseType("NULL", 9);
            NULL = r14;
            BaseType r12 = new BaseType("EXTENSION", 10);
            EXTENSION = r12;
            BaseType r10 = new BaseType("ENUM_ITEM", 11);
            ENUM_ITEM = r10;
            BaseType r8 = new BaseType("BOOLEAN", 12);
            BOOLEAN = r8;
            BaseType r6 = new BaseType("IS0646String", 13);
            IS0646String = r6;
            BaseType r4 = new BaseType("PrintableString", 14);
            PrintableString = r4;
            BaseType r2 = new BaseType("NumericString", 15);
            NumericString = r2;
            BaseType r16 = new BaseType("BMPString", 16);
            BMPString = r16;
            BaseType r17 = new BaseType("UniversalString", 17);
            UniversalString = r17;
            BaseType r18 = new BaseType("IA5String", 18);
            IA5String = r18;
            BaseType r19 = new BaseType("VisibleString", 19);
            VisibleString = r19;
            BaseType r20 = new BaseType("Switch", 20);
            Switch = r20;
            BaseType r21 = new BaseType("Supplier", 21);
            Supplier = r21;
            $VALUES = new BaseType[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4, r2, r16, r17, r18, r19, r20, r21};
        }

        private BaseType(String r1, int r2) {
            super(r1, r2);
        }

        public static BaseType valueOf(String r2) {
            return (BaseType) ZeusTransformUtils.preCheckCast(Enum.valueOf(BaseType.class, r2), BaseType.class, "com.obric.memorydata.plugin");
        }

        public static BaseType[] values() {
            return (BaseType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), BaseType[].class, "com.obric.memorydata.plugin");
        }
    }

    private static class ExtensionList extends ArrayList<Object> {
        protected final int block;

        public ExtensionList(int r3, List<Object> r4) {
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
            this.block = r3;
            addAll(r5);
        }
    }

    private static class OptionalList extends ArrayList<Object> {
        public OptionalList(List<Object> r3) {
            addAll((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        uIntMax = new BigInteger[]{new BigInteger("256"), new BigInteger("65536"), new BigInteger("4294967296"), new BigInteger("18446744073709551616")};
        sIntRange = new BigInteger[][]{new BigInteger[]{new BigInteger("-128"), new BigInteger("127")}, new BigInteger[]{new BigInteger("-32768"), new BigInteger("32767")}, new BigInteger[]{new BigInteger("-2147483648"), new BigInteger("2147483647")}, new BigInteger[]{new BigInteger("-9223372036854775808"), new BigInteger("9223372036854775807")}};
    }
}
