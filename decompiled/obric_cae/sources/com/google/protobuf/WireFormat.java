package com.google.protobuf;

/* JADX INFO: loaded from: classes.dex */
public final class WireFormat {
    static final int FIXED32_SIZE = 4;
    static final int FIXED64_SIZE = 8;
    static final int MAX_VARINT32_SIZE = 5;
    static final int MAX_VARINT64_SIZE = 10;
    static final int MAX_VARINT_SIZE = 10;
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

    /* JADX INFO: renamed from: com.google.protobuf.WireFormat$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static enum FieldType extends java.lang.Enum<FieldType> {
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

        private static /* synthetic */ FieldType[] $values() {
            return new FieldType[]{DOUBLE, FLOAT, INT64, UINT64, INT32, FIXED64, FIXED32, BOOL, STRING, GROUP, MESSAGE, BYTES, UINT32, ENUM, SFIXED32, SFIXED64, SINT32, SINT64};
        }

        static {
            DOUBLE = new FieldType("DOUBLE", 0, JavaType.DOUBLE, 1);
            FLOAT = new FieldType("FLOAT", 1, JavaType.FLOAT, 5);
            JavaType r8 = JavaType.LONG;
            final int r10 = 2;
            INT64 = new FieldType("INT64", 2, r8, 0);
            final int r11 = 3;
            UINT64 = new FieldType("UINT64", 3, r8, 0);
            JavaType r12 = JavaType.INT;
            INT32 = new FieldType("INT32", 4, r12, 0);
            FIXED64 = new FieldType("FIXED64", 5, r8, 1);
            FIXED32 = new FieldType("FIXED32", 6, r12, 5);
            BOOL = new FieldType("BOOL", 7, JavaType.BOOLEAN, 0);
            final int r13 = 8;
            final JavaType r14 = JavaType.STRING;
            final String r15 = "STRING";
            STRING = new AnonymousClass1(r15, r13, r14, r10);
            final JavaType r16 = JavaType.MESSAGE;
            final String r17 = "GROUP";
            final int r18 = 9;
            GROUP = new AnonymousClass2(r17, r18, r16, r11);
            final String r19 = "MESSAGE";
            final int r20 = 10;
            MESSAGE = new AnonymousClass3(r19, r20, r16, r10);
            final int r21 = 11;
            final JavaType r22 = JavaType.BYTE_STRING;
            final String r23 = "BYTES";
            BYTES = new AnonymousClass4(r23, r21, r22, r10);
            UINT32 = new FieldType("UINT32", 12, r12, 0);
            ENUM = new FieldType("ENUM", 13, JavaType.ENUM, 0);
            SFIXED32 = new FieldType("SFIXED32", 14, r12, 5);
            SFIXED64 = new FieldType("SFIXED64", 15, r8, 1);
            SINT32 = new FieldType("SINT32", 16, r12, 0);
            SINT64 = new FieldType("SINT64", 17, r8, 0);
            $VALUES = $values();
        }

        private FieldType(String r8, int r10, JavaType r11, int r12) {
            super(r8, r10);
            this.javaType = r11;
            this.wireType = r12;
        }

        public static FieldType valueOf(String r8) {
            return (FieldType) java.lang.Enum.valueOf(FieldType.class, r8);
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

        public /* synthetic */ FieldType(String r8, int r10, JavaType r11, int r12, AnonymousClass1 r13) {
            this(r8, r10, r11, r12);
        }
    }

    public static final enum JavaType extends java.lang.Enum<JavaType> {
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

        private static /* synthetic */ JavaType[] $values() {
            return new JavaType[]{INT, LONG, FLOAT, DOUBLE, BOOLEAN, STRING, BYTE_STRING, ENUM, MESSAGE};
        }

        static {
            INT = new JavaType("INT", 0, 0);
            LONG = new JavaType("LONG", 1, 0L);
            FLOAT = new JavaType("FLOAT", 2, Float.valueOf(0.0f));
            DOUBLE = new JavaType("DOUBLE", 3, Double.valueOf(0.0d));
            BOOLEAN = new JavaType("BOOLEAN", 4, Boolean.FALSE);
            STRING = new JavaType("STRING", 5, "");
            BYTE_STRING = new JavaType("BYTE_STRING", 6, ByteString.EMPTY);
            ENUM = new JavaType("ENUM", 7, null);
            MESSAGE = new JavaType("MESSAGE", 8, null);
            $VALUES = $values();
        }

        private JavaType(String r8, int r10, Object r11) {
            super(r8, r10);
            this.defaultDefault = r11;
        }

        public static JavaType valueOf(String r8) {
            return (JavaType) java.lang.Enum.valueOf(JavaType.class, r8);
        }

        public static JavaType[] values() {
            return (JavaType[]) $VALUES.clone();
        }

        public Object getDefaultDefault() {
            return this.defaultDefault;
        }
    }

    public static final enum Utf8Validation extends java.lang.Enum<Utf8Validation> {
        private static final /* synthetic */ Utf8Validation[] $VALUES = null;
        public static final Utf8Validation LAZY = null;
        public static final Utf8Validation LOOSE = null;
        public static final Utf8Validation STRICT = null;

        private static /* synthetic */ Utf8Validation[] $values() {
            return new Utf8Validation[]{LOOSE, STRICT, LAZY};
        }

        static {
            LOOSE = new Utf8Validation("LOOSE", 0);
            STRICT = new Utf8Validation("STRICT", 1);
            LAZY = new Utf8Validation("LAZY", 2);
            $VALUES = $values();
        }

        private Utf8Validation(String r8, int r10) {
            super(r8, r10);
        }

        public static Utf8Validation valueOf(String r8) {
            return (Utf8Validation) java.lang.Enum.valueOf(Utf8Validation.class, r8);
        }

        public static Utf8Validation[] values() {
            return (Utf8Validation[]) $VALUES.clone();
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

    public static int getTagFieldNumber(int r8) {
        return r8 >>> 3;
    }

    public static int getTagWireType(int r8) {
        return r8 & 7;
    }

    public static int makeTag(int r8, int r10) {
        return (r8 << 3) | r10;
    }
}
