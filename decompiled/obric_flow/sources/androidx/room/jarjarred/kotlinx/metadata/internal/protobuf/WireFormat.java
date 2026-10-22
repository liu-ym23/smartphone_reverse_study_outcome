package androidx.room.jarjarred.kotlinx.metadata.internal.protobuf;

/* JADX INFO: loaded from: classes.dex */
public final class WireFormat {
    static final int MESSAGE_SET_ITEM = 1;
    static final int MESSAGE_SET_ITEM_END_TAG = 0;
    static final int MESSAGE_SET_ITEM_TAG = 0;
    static final int MESSAGE_SET_MESSAGE = 3;
    static final int MESSAGE_SET_MESSAGE_TAG = 0;
    static final int MESSAGE_SET_TYPE_ID = 2;
    static final int MESSAGE_SET_TYPE_ID_TAG = 0;
    static final int TAG_TYPE_BITS = 3;
    static final int TAG_TYPE_MASK = 7;
    public static final int WIRETYPE_END_GROUP = 4;
    public static final int WIRETYPE_FIXED32 = 5;
    public static final int WIRETYPE_FIXED64 = 1;
    public static final int WIRETYPE_LENGTH_DELIMITED = 2;
    public static final int WIRETYPE_START_GROUP = 3;
    public static final int WIRETYPE_VARINT = 0;

    /* JADX INFO: renamed from: androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.WireFormat$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
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
            FieldType r5 = new FieldType("DOUBLE", 0, JavaType.DOUBLE, 1);
            DOUBLE = r5;
            FieldType r10 = new FieldType("FLOAT", 1, JavaType.FLOAT, 5);
            FLOAT = r10;
            JavaType r11 = JavaType.LONG;
            final int r12 = 2;
            FieldType r13 = new FieldType("INT64", 2, r11, 0);
            INT64 = r13;
            final int r14 = 3;
            FieldType r15 = new FieldType("UINT64", 3, r11, 0);
            UINT64 = r15;
            JavaType r16 = JavaType.INT;
            FieldType r17 = new FieldType("INT32", 4, r16, 0);
            INT32 = r17;
            FieldType r18 = new FieldType("FIXED64", 5, r11, 1);
            FIXED64 = r18;
            FieldType r19 = new FieldType("FIXED32", 6, r16, 5);
            FIXED32 = r19;
            FieldType r110 = new FieldType("BOOL", 7, JavaType.BOOLEAN, 0);
            BOOL = r110;
            final int r20 = 8;
            final JavaType r111 = JavaType.STRING;
            final String r21 = "STRING";
            FieldType r22 = new AnonymousClass1(r21, r20, r111, r12);
            STRING = r22;
            final JavaType r112 = JavaType.MESSAGE;
            final String r23 = "GROUP";
            final int r24 = 9;
            FieldType r25 = new AnonymousClass2(r23, r24, r112, r14);
            GROUP = r25;
            final String r26 = "MESSAGE";
            final int r113 = 10;
            final int r27 = 2;
            FieldType r28 = new AnonymousClass3(r26, r113, r112, r27);
            MESSAGE = r28;
            final int r114 = 11;
            final JavaType r115 = JavaType.BYTE_STRING;
            final String r29 = "BYTES";
            FieldType r30 = new AnonymousClass4(r29, r114, r115, r27);
            BYTES = r30;
            FieldType r31 = new FieldType("UINT32", 12, r16, 0);
            UINT32 = r31;
            FieldType r32 = new FieldType("ENUM", 13, JavaType.ENUM, 0);
            ENUM = r32;
            FieldType r33 = new FieldType("SFIXED32", 14, r16, 5);
            SFIXED32 = r33;
            FieldType r34 = new FieldType("SFIXED64", 15, r11, 1);
            SFIXED64 = r34;
            FieldType r35 = new FieldType("SINT32", 16, r16, 0);
            SINT32 = r35;
            FieldType r116 = new FieldType("SINT64", 17, r11, 0);
            SINT64 = r116;
            $VALUES = new FieldType[]{r5, r10, r13, r15, r17, r18, r19, r110, r22, r25, r28, r30, r31, r32, r33, r34, r35, r116};
        }

        public /* synthetic */ FieldType(String r5, int r10, JavaType r11, int r12, AnonymousClass1 r13) {
            this(r5, r10, r11, r12);
        }

        public static FieldType valueOf(String r5) {
            return (FieldType) Enum.valueOf(FieldType.class, r5);
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

        private FieldType(String r5, int r10, JavaType r11, int r12) {
            super(r5, r10);
            this.javaType = r11;
            this.wireType = r12;
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
            JavaType r5 = new JavaType("INT", 0, 0);
            INT = r5;
            JavaType r10 = new JavaType("LONG", 1, 0L);
            LONG = r10;
            JavaType r11 = new JavaType("FLOAT", 2, Float.valueOf(0.0f));
            FLOAT = r11;
            JavaType r12 = new JavaType("DOUBLE", 3, Double.valueOf(0.0d));
            DOUBLE = r12;
            JavaType r13 = new JavaType("BOOLEAN", 4, Boolean.FALSE);
            BOOLEAN = r13;
            JavaType r14 = new JavaType("STRING", 5, "");
            STRING = r14;
            JavaType r15 = new JavaType("BYTE_STRING", 6, ByteString.EMPTY);
            BYTE_STRING = r15;
            JavaType r16 = new JavaType("ENUM", 7, null);
            ENUM = r16;
            JavaType r17 = new JavaType("MESSAGE", 8, null);
            MESSAGE = r17;
            $VALUES = new JavaType[]{r5, r10, r11, r12, r13, r14, r15, r16, r17};
        }

        private JavaType(String r5, int r10, Object r11) {
            super(r5, r10);
            this.defaultDefault = r11;
        }

        public static JavaType valueOf(String r5) {
            return (JavaType) Enum.valueOf(JavaType.class, r5);
        }

        public static JavaType[] values() {
            return (JavaType[]) $VALUES.clone();
        }

        public Object getDefaultDefault() {
            return this.defaultDefault;
        }
    }

    static {
        MESSAGE_SET_ITEM_TAG = makeTag(1, 3);
        MESSAGE_SET_ITEM_END_TAG = makeTag(1, 4);
        MESSAGE_SET_TYPE_ID_TAG = makeTag(2, 0);
        MESSAGE_SET_MESSAGE_TAG = makeTag(3, 2);
    }

    private WireFormat() {
    }

    public static int getTagFieldNumber(int r5) {
        return r5 >>> 3;
    }

    public static int getTagWireType(int r5) {
        return r5 & 7;
    }

    public static int makeTag(int r5, int r10) {
        return (r5 << 3) | r10;
    }
}
