package com.google.protobuf;

/* JADX INFO: loaded from: classes2.dex */
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
    static /* synthetic */ class AnonymousClass1 {
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
            JavaType r10 = JavaType.LONG;
            final int r11 = 2;
            INT64 = new FieldType("INT64", 2, r10, 0);
            final int r12 = 3;
            UINT64 = new FieldType("UINT64", 3, r10, 0);
            JavaType r13 = JavaType.INT;
            INT32 = new FieldType("INT32", 4, r13, 0);
            FIXED64 = new FieldType("FIXED64", 5, r10, 1);
            FIXED32 = new FieldType("FIXED32", 6, r13, 5);
            BOOL = new FieldType("BOOL", 7, JavaType.BOOLEAN, 0);
            final JavaType r14 = JavaType.STRING;
            final String r15 = "STRING";
            final int r16 = 8;
            STRING = new AnonymousClass1(r15, r16, r14, r11);
            final JavaType r17 = JavaType.MESSAGE;
            final String r18 = "GROUP";
            final int r19 = 9;
            GROUP = new AnonymousClass2(r18, r19, r17, r12);
            final String r20 = "MESSAGE";
            final int r21 = 10;
            MESSAGE = new AnonymousClass3(r20, r21, r17, r11);
            final JavaType r22 = JavaType.BYTE_STRING;
            final String r23 = "BYTES";
            final int r24 = 11;
            BYTES = new AnonymousClass4(r23, r24, r22, r11);
            UINT32 = new FieldType("UINT32", 12, r13, 0);
            ENUM = new FieldType("ENUM", 13, JavaType.ENUM, 0);
            SFIXED32 = new FieldType("SFIXED32", 14, r13, 5);
            SFIXED64 = new FieldType("SFIXED64", 15, r10, 1);
            SINT32 = new FieldType("SINT32", 16, r13, 0);
            SINT64 = new FieldType("SINT64", 17, r10, 0);
            $VALUES = $values();
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
            return (FieldType) java.lang.Enum.valueOf(FieldType.class, r10);
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

        private JavaType(String r10, int r11, Object r12) {
            super(r10, r11);
            this.defaultDefault = r12;
        }

        public static JavaType valueOf(String r10) {
            return (JavaType) java.lang.Enum.valueOf(JavaType.class, r10);
        }

        public static JavaType[] values() {
            return (JavaType[]) $VALUES.clone();
        }

        Object getDefaultDefault() {
            return this.defaultDefault;
        }
    }

    static abstract enum Utf8Validation extends java.lang.Enum<Utf8Validation> {
        private static final /* synthetic */ Utf8Validation[] $VALUES = null;
        public static final Utf8Validation LAZY = null;
        public static final Utf8Validation LOOSE = null;
        public static final Utf8Validation STRICT = null;

        private static /* synthetic */ Utf8Validation[] $values() {
            return new Utf8Validation[]{LOOSE, STRICT, LAZY};
        }

        static {
            final String r10 = "LOOSE";
            final int r11 = 0;
            LOOSE = new AnonymousClass1(r10, r11);
            final String r12 = "STRICT";
            final int r13 = 1;
            STRICT = new AnonymousClass2(r12, r13);
            final String r14 = "LAZY";
            final int r15 = 2;
            LAZY = new AnonymousClass3(r14, r15);
            $VALUES = $values();
        }

        private Utf8Validation(String r10, int r11) {
            super(r10, r11);
        }

        /* synthetic */ Utf8Validation(String r10, int r11, AnonymousClass1 r12) {
            this(r10, r11);
        }

        public static Utf8Validation valueOf(String r10) {
            return (Utf8Validation) java.lang.Enum.valueOf(Utf8Validation.class, r10);
        }

        public static Utf8Validation[] values() {
            return (Utf8Validation[]) $VALUES.clone();
        }

        abstract Object readString(CodedInputStream r10);
    }

    static {
        MESSAGE_SET_ITEM_TAG = makeTag(1, 3);
        MESSAGE_SET_ITEM_END_TAG = makeTag(1, 4);
        MESSAGE_SET_TYPE_ID_TAG = makeTag(2, 0);
        MESSAGE_SET_MESSAGE_TAG = makeTag(3, 2);
    }

    private WireFormat() {
    }

    public static int getTagFieldNumber(int r10) {
        return r10 >>> 3;
    }

    public static int getTagWireType(int r10) {
        return r10 & 7;
    }

    static int makeTag(int r10, int r11) {
        return (r10 << 3) | r11;
    }

    static Object readPrimitiveField(CodedInputStream r10, FieldType r11, Utf8Validation r12) {
        switch(r11.ordinal()) {
            case 0: goto L41;
            case 1: goto L39;
            case 2: goto L37;
            case 3: goto L35;
            case 4: goto L33;
            case 5: goto L31;
            case 6: goto L29;
            case 7: goto L27;
            case 8: goto L25;
            case 9: goto L23;
            case 10: goto L21;
            case 11: goto L19;
            case 12: goto L17;
            case 13: goto L15;
            case 14: goto L13;
            case 15: goto L11;
            case 16: goto L9;
            case 17: goto L7;
            default: goto L5;
        };
    L5:
        throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
    L7:
        return Long.valueOf(r10.readSInt64());
    L9:
        return Integer.valueOf(r10.readSInt32());
    L11:
        return Long.valueOf(r10.readSFixed64());
    L13:
        return Integer.valueOf(r10.readSFixed32());
    L15:
        throw new IllegalArgumentException("readPrimitiveField() cannot handle enums.");
    L17:
        return Integer.valueOf(r10.readUInt32());
    L19:
        return r10.readBytes();
    L21:
        throw new IllegalArgumentException("readPrimitiveField() cannot handle embedded messages.");
    L23:
        throw new IllegalArgumentException("readPrimitiveField() cannot handle nested groups.");
    L25:
        return r12.readString(r10);
    L27:
        return Boolean.valueOf(r10.readBool());
    L29:
        return Integer.valueOf(r10.readFixed32());
    L31:
        return Long.valueOf(r10.readFixed64());
    L33:
        return Integer.valueOf(r10.readInt32());
    L35:
        return Long.valueOf(r10.readUInt64());
    L37:
        return Long.valueOf(r10.readInt64());
    L39:
        return Float.valueOf(r10.readFloat());
    L41:
        return Double.valueOf(r10.readDouble());
    }
}
