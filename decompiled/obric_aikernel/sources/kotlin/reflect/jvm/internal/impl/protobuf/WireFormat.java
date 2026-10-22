package kotlin.reflect.jvm.internal.impl.protobuf;

/* JADX INFO: loaded from: classes3.dex */
public final class WireFormat {
    static final int MESSAGE_SET_ITEM_END_TAG = 0;
    static final int MESSAGE_SET_ITEM_TAG = 0;
    static final int MESSAGE_SET_MESSAGE_TAG = 0;
    static final int MESSAGE_SET_TYPE_ID_TAG = 0;

    /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.protobuf.WireFormat$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

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

        static {
            FieldType r10 = new FieldType("DOUBLE", 0, JavaType.DOUBLE, 1);
            DOUBLE = r10;
            FieldType r11 = new FieldType("FLOAT", 1, JavaType.FLOAT, 5);
            FLOAT = r11;
            JavaType r12 = JavaType.LONG;
            final int r13 = 2;
            FieldType r14 = new FieldType("INT64", 2, r12, 0);
            INT64 = r14;
            final int r15 = 3;
            FieldType r16 = new FieldType("UINT64", 3, r12, 0);
            UINT64 = r16;
            JavaType r17 = JavaType.INT;
            FieldType r18 = new FieldType("INT32", 4, r17, 0);
            INT32 = r18;
            FieldType r19 = new FieldType("FIXED64", 5, r12, 1);
            FIXED64 = r19;
            FieldType r110 = new FieldType("FIXED32", 6, r17, 5);
            FIXED32 = r110;
            FieldType r111 = new FieldType("BOOL", 7, JavaType.BOOLEAN, 0);
            BOOL = r111;
            final JavaType r112 = JavaType.STRING;
            final String r20 = "STRING";
            final int r21 = 8;
            FieldType r22 = new AnonymousClass1(r20, r21, r112, r13);
            STRING = r22;
            final JavaType r113 = JavaType.MESSAGE;
            final String r23 = "GROUP";
            final int r24 = 9;
            FieldType r25 = new AnonymousClass2(r23, r24, r113, r15);
            GROUP = r25;
            final String r26 = "MESSAGE";
            final int r114 = 10;
            final int r27 = 2;
            FieldType r28 = new AnonymousClass3(r26, r114, r113, r27);
            MESSAGE = r28;
            final JavaType r115 = JavaType.BYTE_STRING;
            final String r116 = "BYTES";
            final int r29 = 11;
            FieldType r30 = new AnonymousClass4(r116, r29, r115, r27);
            BYTES = r30;
            FieldType r31 = new FieldType("UINT32", 12, r17, 0);
            UINT32 = r31;
            FieldType r117 = new FieldType("ENUM", 13, JavaType.ENUM, 0);
            ENUM = r117;
            FieldType r32 = new FieldType("SFIXED32", 14, r17, 5);
            SFIXED32 = r32;
            FieldType r33 = new FieldType("SFIXED64", 15, r12, 1);
            SFIXED64 = r33;
            FieldType r34 = new FieldType("SINT32", 16, r17, 0);
            SINT32 = r34;
            FieldType r35 = new FieldType("SINT64", 17, r12, 0);
            SINT64 = r35;
            $VALUES = new FieldType[]{r10, r11, r14, r16, r18, r19, r110, r111, r22, r25, r28, r30, r31, r117, r32, r33, r34, r35};
        }

        private FieldType(String r10, int r11, JavaType r12, int r13) {
            super(r10, r11);
            this.javaType = r12;
            this.wireType = r13;
        }

        /* synthetic */ FieldType(String r10, int r11, JavaType r12, int r13, AnonymousClass1 r14) {
            this(r10, r11, r12, r13);
        }

        public static FieldType valueOf(String r10) {
            return (FieldType) Enum.valueOf(FieldType.class, r10);
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

        public boolean isPackable() {
            return true;
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
            JavaType r10 = new JavaType("INT", 0, 0);
            INT = r10;
            JavaType r11 = new JavaType("LONG", 1, 0L);
            LONG = r11;
            JavaType r12 = new JavaType("FLOAT", 2, Float.valueOf(0.0f));
            FLOAT = r12;
            JavaType r13 = new JavaType("DOUBLE", 3, Double.valueOf(0.0d));
            DOUBLE = r13;
            JavaType r14 = new JavaType("BOOLEAN", 4, Boolean.FALSE);
            BOOLEAN = r14;
            JavaType r15 = new JavaType("STRING", 5, "");
            STRING = r15;
            JavaType r16 = new JavaType("BYTE_STRING", 6, ByteString.EMPTY);
            BYTE_STRING = r16;
            JavaType r17 = new JavaType("ENUM", 7, null);
            ENUM = r17;
            JavaType r18 = new JavaType("MESSAGE", 8, null);
            MESSAGE = r18;
            $VALUES = new JavaType[]{r10, r11, r12, r13, r14, r15, r16, r17, r18};
        }

        private JavaType(String r10, int r11, Object r12) {
            super(r10, r11);
            this.defaultDefault = r12;
        }

        public static JavaType valueOf(String r10) {
            return (JavaType) Enum.valueOf(JavaType.class, r10);
        }

        public static JavaType[] values() {
            return (JavaType[]) $VALUES.clone();
        }
    }

    static {
        MESSAGE_SET_ITEM_TAG = makeTag(1, 3);
        MESSAGE_SET_ITEM_END_TAG = makeTag(1, 4);
        MESSAGE_SET_TYPE_ID_TAG = makeTag(2, 0);
        MESSAGE_SET_MESSAGE_TAG = makeTag(3, 2);
    }

    public static int getTagFieldNumber(int r10) {
        return r10 >>> 3;
    }

    static int getTagWireType(int r10) {
        return r10 & 7;
    }

    static int makeTag(int r10, int r11) {
        return (r10 << 3) | r11;
    }
}
