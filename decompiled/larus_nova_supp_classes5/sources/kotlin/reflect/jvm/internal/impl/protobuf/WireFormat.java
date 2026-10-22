package kotlin.reflect.jvm.internal.impl.protobuf;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class WireFormat {
    static final int MESSAGE_SET_ITEM_END_TAG = 0;
    static final int MESSAGE_SET_ITEM_TAG = 0;
    static final int MESSAGE_SET_MESSAGE_TAG = 0;
    static final int MESSAGE_SET_TYPE_ID_TAG = 0;

    public static enum FieldType extends Enum<FieldType> {
        private static final /* synthetic */ FieldType[] $VALUES = null;
        public static final FieldType BOOL = null;
        public static final FieldType BYTES = null;
        public static final FieldType DOUBLE = null;
        public static final FieldType ENUM = null;
        public static final FieldType FIXED32 = null;
        public static final FieldType FIXED64 = null;
        public static final FieldType FLOAT = null;
        public static final FieldType GROUP = null;
        public static final FieldType INT32 = null;
        public static final FieldType INT64 = null;
        public static final FieldType MESSAGE = null;
        public static final FieldType SFIXED32 = null;
        public static final FieldType SFIXED64 = null;
        public static final FieldType SINT32 = null;
        public static final FieldType SINT64 = null;
        public static final FieldType STRING = null;
        public static final FieldType UINT32 = null;
        public static final FieldType UINT64 = null;
        private final JavaType javaType;
        private final int wireType;

        public boolean isPackable() {
            return true;
        }

        static {
            FieldType r0 = new FieldType("DOUBLE", 0, JavaType.DOUBLE, 1);
            DOUBLE = r0;
            FieldType r1 = new FieldType("FLOAT", 1, JavaType.FLOAT, 5);
            FLOAT = r1;
            JavaType r5 = JavaType.LONG;
            final int r8 = 2;
            FieldType r2 = new FieldType("INT64", 2, r5, 0);
            INT64 = r2;
            final int r10 = 3;
            FieldType r7 = new FieldType("UINT64", 3, r5, 0);
            UINT64 = r7;
            JavaType r11 = JavaType.INT;
            FieldType r9 = new FieldType("INT32", 4, r11, 0);
            INT32 = r9;
            FieldType r12 = new FieldType("FIXED64", 5, r5, 1);
            FIXED64 = r12;
            FieldType r14 = new FieldType("FIXED32", 6, r11, 5);
            FIXED32 = r14;
            FieldType r15 = new FieldType("BOOL", 7, JavaType.BOOLEAN, 0);
            BOOL = r15;
            final JavaType r13 = JavaType.STRING;
            final String r6 = "STRING";
            final int r3 = 8;
            FieldType r4 = new AnonymousClass1(r6, r3, r13, r8);
            STRING = r4;
            final JavaType r16 = JavaType.MESSAGE;
            final String r17 = "GROUP";
            final int r18 = 9;
            FieldType r19 = new AnonymousClass2(r17, r18, r16, r10);
            GROUP = r19;
            final String r20 = "MESSAGE";
            final int r110 = 10;
            final int r21 = 2;
            FieldType r22 = new AnonymousClass3(r20, r110, r16, r21);
            MESSAGE = r22;
            final JavaType r111 = JavaType.BYTE_STRING;
            final String r112 = "BYTES";
            final int r23 = 11;
            FieldType r24 = new AnonymousClass4(r112, r23, r111, r21);
            BYTES = r24;
            FieldType r25 = new FieldType("UINT32", 12, r11, 0);
            UINT32 = r25;
            FieldType r113 = new FieldType("ENUM", 13, JavaType.ENUM, 0);
            ENUM = r113;
            FieldType r26 = new FieldType("SFIXED32", 14, r11, 5);
            SFIXED32 = r26;
            FieldType r27 = new FieldType("SFIXED64", 15, r5, 1);
            SFIXED64 = r27;
            FieldType r28 = new FieldType("SINT32", 16, r11, 0);
            SINT32 = r28;
            FieldType r29 = new FieldType("SINT64", 17, r5, 0);
            SINT64 = r29;
            $VALUES = new FieldType[]{r0, r1, r2, r7, r9, r12, r14, r15, r4, r19, r22, r24, r25, r113, r26, r27, r28, r29};
        }

        public static FieldType[] values() {
            return (FieldType[]) $VALUES.clone();
        }

        public JavaType getJavaType() {
            return this.javaType;
        }

        public int getWireType() {
            return this.wireType;
        }

        public static FieldType valueOf(String r1) {
            return (FieldType) a.a(FieldType.class, r1);
        }

        private FieldType(String r1, int r2, JavaType r3, int r4) {
            super(r1, r2);
            this.javaType = r3;
            this.wireType = r4;
        }

        public /* synthetic */ FieldType(String r1, int r2, JavaType r3, int r4, 1 r5) {
            this(r1, r2, r3, r4);
        }
    }

    public static final enum JavaType extends Enum<JavaType> {
        private static final /* synthetic */ JavaType[] $VALUES = null;
        public static final JavaType BOOLEAN = null;
        public static final JavaType BYTE_STRING = null;
        public static final JavaType DOUBLE = null;
        public static final JavaType ENUM = null;
        public static final JavaType FLOAT = null;
        public static final JavaType INT = null;
        public static final JavaType LONG = null;
        public static final JavaType MESSAGE = null;
        public static final JavaType STRING = null;
        private final Object defaultDefault;

        static {
            JavaType r0 = new JavaType("INT", 0, 0);
            INT = r0;
            JavaType r2 = new JavaType("LONG", 1, 0L);
            LONG = r2;
            JavaType r3 = new JavaType("FLOAT", 2, Float.valueOf(0.0f));
            FLOAT = r3;
            JavaType r4 = new JavaType("DOUBLE", 3, Double.valueOf(0.0d));
            DOUBLE = r4;
            JavaType r6 = new JavaType("BOOLEAN", 4, Boolean.FALSE);
            BOOLEAN = r6;
            JavaType r8 = new JavaType("STRING", 5, "");
            STRING = r8;
            JavaType r10 = new JavaType("BYTE_STRING", 6, ByteString.EMPTY);
            BYTE_STRING = r10;
            JavaType r12 = new JavaType("ENUM", 7, null);
            ENUM = r12;
            JavaType r14 = new JavaType("MESSAGE", 8, null);
            MESSAGE = r14;
            $VALUES = new JavaType[]{r0, r2, r3, r4, r6, r8, r10, r12, r14};
        }

        public static JavaType[] values() {
            return (JavaType[]) $VALUES.clone();
        }

        public static JavaType valueOf(String r1) {
            return (JavaType) a.a(JavaType.class, r1);
        }

        private JavaType(String r1, int r2, Object r3) {
            super(r1, r2);
            this.defaultDefault = r3;
        }
    }

    static {
        MESSAGE_SET_ITEM_TAG = makeTag(1, 3);
        MESSAGE_SET_ITEM_END_TAG = makeTag(1, 4);
        MESSAGE_SET_TYPE_ID_TAG = makeTag(2, 0);
        MESSAGE_SET_MESSAGE_TAG = makeTag(3, 2);
    }

    public static int getTagFieldNumber(int r0) {
        return r0 >>> 3;
    }

    public static int getTagWireType(int r0) {
        return r0 & 7;
    }

    public static int makeTag(int r0, int r1) {
        return (r0 << 3) | r1;
    }
}
