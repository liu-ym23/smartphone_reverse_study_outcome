package com.google.crypto.tink.shaded.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class WireFormat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final int f4931a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final int f4932b = 0;
    static final int c = 0;
    static final int d = 0;

    /* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.WireFormat$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f4933a = null;

        static {
            int[] r0 = new int[FieldType.values().length];
            f4933a = r0;
            r0[FieldType.DOUBLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L22
        L62:
            f4933a[FieldType.FLOAT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L23
        L46:
            f4933a[FieldType.INT64.ordinal()] = 3;     // Catch: NoSuchFieldError -> L24
        L58:
            f4933a[FieldType.UINT64.ordinal()] = 4;     // Catch: NoSuchFieldError -> L25
        L64:
            f4933a[FieldType.INT32.ordinal()] = 5;     // Catch: NoSuchFieldError -> L26
        L48:
            f4933a[FieldType.FIXED64.ordinal()] = 6;     // Catch: NoSuchFieldError -> L27
        L52:
            f4933a[FieldType.FIXED32.ordinal()] = 7;     // Catch: NoSuchFieldError -> L28
        L74:
            f4933a[FieldType.BOOL.ordinal()] = 8;     // Catch: NoSuchFieldError -> L29
        L42:
            f4933a[FieldType.BYTES.ordinal()] = 9;     // Catch: NoSuchFieldError -> L30
        L68:
            f4933a[FieldType.UINT32.ordinal()] = 10;     // Catch: NoSuchFieldError -> L31
        L70:
            f4933a[FieldType.SFIXED32.ordinal()] = 11;     // Catch: NoSuchFieldError -> L32
        L54:
            f4933a[FieldType.SFIXED64.ordinal()] = 12;     // Catch: NoSuchFieldError -> L33
        L60:
            f4933a[FieldType.SINT32.ordinal()] = 13;     // Catch: NoSuchFieldError -> L34
        L44:
            f4933a[FieldType.SINT64.ordinal()] = 14;     // Catch: NoSuchFieldError -> L35
        L50:
            f4933a[FieldType.STRING.ordinal()] = 15;     // Catch: NoSuchFieldError -> L36
        L72:
            f4933a[FieldType.GROUP.ordinal()] = 16;     // Catch: NoSuchFieldError -> L37
        L40:
            f4933a[FieldType.MESSAGE.ordinal()] = 17;     // Catch: NoSuchFieldError -> L38
        L66:
            f4933a[FieldType.ENUM.ordinal()] = 18;     // Catch: NoSuchFieldError -> L39
            return;
        }
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
            FieldType r0 = new FieldType("DOUBLE", 0, JavaType.DOUBLE, 1);
            DOUBLE = r0;
            FieldType r1 = new FieldType("FLOAT", 1, JavaType.FLOAT, 5);
            FLOAT = r1;
            final int r8 = 2;
            FieldType r2 = new FieldType("INT64", 2, JavaType.LONG, 0);
            INT64 = r2;
            final int r10 = 3;
            FieldType r5 = new FieldType("UINT64", 3, JavaType.LONG, 0);
            UINT64 = r5;
            FieldType r7 = new FieldType("INT32", 4, JavaType.INT, 0);
            INT32 = r7;
            FieldType r9 = new FieldType("FIXED64", 5, JavaType.LONG, 1);
            FIXED64 = r9;
            FieldType r11 = new FieldType("FIXED32", 6, JavaType.INT, 5);
            FIXED32 = r11;
            FieldType r13 = new FieldType("BOOL", 7, JavaType.BOOLEAN, 0);
            BOOL = r13;
            final JavaType r15 = JavaType.STRING;
            final String r12 = "STRING";
            final int r4 = 8;
            FieldType r14 = new AnonymousClass1(r12, r4, r15, r8);
            STRING = r14;
            final JavaType r16 = JavaType.MESSAGE;
            final String r6 = "GROUP";
            final int r17 = 9;
            FieldType r18 = new AnonymousClass2(r6, r17, r16, r10);
            GROUP = r18;
            final JavaType r19 = JavaType.MESSAGE;
            final String r20 = "MESSAGE";
            final int r110 = 10;
            FieldType r21 = new AnonymousClass3(r20, r110, r19, r8);
            MESSAGE = r21;
            final JavaType r111 = JavaType.BYTE_STRING;
            final String r112 = "BYTES";
            final int r3 = 11;
            FieldType r22 = new AnonymousClass4(r112, r3, r111, r8);
            BYTES = r22;
            FieldType r113 = new FieldType("UINT32", 12, JavaType.INT, 0);
            UINT32 = r113;
            FieldType r23 = new FieldType("ENUM", 13, JavaType.ENUM, 0);
            ENUM = r23;
            FieldType r24 = new FieldType("SFIXED32", 14, JavaType.INT, 5);
            SFIXED32 = r24;
            FieldType r25 = new FieldType("SFIXED64", 15, JavaType.LONG, 1);
            SFIXED64 = r25;
            FieldType r26 = new FieldType("SINT32", 16, JavaType.INT, 0);
            SINT32 = r26;
            FieldType r27 = new FieldType("SINT64", 17, JavaType.LONG, 0);
            SINT64 = r27;
            $VALUES = new FieldType[]{r0, r1, r2, r5, r7, r9, r11, r13, r14, r18, r21, r22, r113, r23, r24, r25, r26, r27};
        }

        private FieldType(String r1, int r2, JavaType r3, int r4) {
            super(r1, r2);
            this.javaType = r3;
            this.wireType = r4;
        }

        /* synthetic */ FieldType(String r1, int r2, JavaType r3, int r4, AnonymousClass1 r5) {
            this(r1, r2, r3, r4);
        }

        public static FieldType valueOf(String r2) {
            return (FieldType) ZeusTransformUtils.preCheckCast(Enum.valueOf(FieldType.class, r2), FieldType.class, "com.obric.memorydata.plugin");
        }

        public static FieldType[] values() {
            return (FieldType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), FieldType[].class, "com.obric.memorydata.plugin");
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
            JavaType r0 = new JavaType("INT", 0, 0);
            INT = r0;
            JavaType r2 = new JavaType("LONG", 1, 0L);
            LONG = r2;
            JavaType r3 = new JavaType("FLOAT", 2, Float.valueOf(0.0f));
            FLOAT = r3;
            JavaType r4 = new JavaType("DOUBLE", 3, Double.valueOf(0.0d));
            DOUBLE = r4;
            JavaType r6 = new JavaType("BOOLEAN", 4, false);
            BOOLEAN = r6;
            JavaType r8 = new JavaType("STRING", 5, "");
            STRING = r8;
            JavaType r10 = new JavaType("BYTE_STRING", 6, ByteString.EMPTY);
            BYTE_STRING = r10;
            JavaType r13 = new JavaType("ENUM", 7, null);
            ENUM = r13;
            JavaType r14 = new JavaType("MESSAGE", 8, null);
            MESSAGE = r14;
            $VALUES = new JavaType[]{r0, r2, r3, r4, r6, r8, r10, r13, r14};
        }

        private JavaType(String r1, int r2, Object r3) {
            super(r1, r2);
            this.defaultDefault = r3;
        }

        public static JavaType valueOf(String r2) {
            return (JavaType) ZeusTransformUtils.preCheckCast(Enum.valueOf(JavaType.class, r2), JavaType.class, "com.obric.memorydata.plugin");
        }

        public static JavaType[] values() {
            return (JavaType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), JavaType[].class, "com.obric.memorydata.plugin");
        }

        Object getDefaultDefault() {
            return this.defaultDefault;
        }
    }

    static abstract enum Utf8Validation extends Enum<Utf8Validation> {
        private static final /* synthetic */ Utf8Validation[] $VALUES = null;
        public static final Utf8Validation LAZY = null;
        public static final Utf8Validation LOOSE = null;
        public static final Utf8Validation STRICT = null;

        static {
            final String r1 = "LOOSE";
            final int r2 = 0;
            Utf8Validation r0 = new AnonymousClass1(r1, r2);
            LOOSE = r0;
            final String r3 = "STRICT";
            final int r4 = 1;
            Utf8Validation r5 = new AnonymousClass2(r3, r4);
            STRICT = r5;
            final String r6 = "LAZY";
            final int r7 = 2;
            Utf8Validation r8 = new AnonymousClass3(r6, r7);
            LAZY = r8;
            $VALUES = new Utf8Validation[]{r0, r5, r8};
        }

        private Utf8Validation(String r1, int r2) {
            super(r1, r2);
        }

        /* synthetic */ Utf8Validation(String r1, int r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        public static Utf8Validation valueOf(String r2) {
            return (Utf8Validation) ZeusTransformUtils.preCheckCast(Enum.valueOf(Utf8Validation.class, r2), Utf8Validation.class, "com.obric.memorydata.plugin");
        }

        public static Utf8Validation[] values() {
            return (Utf8Validation[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Utf8Validation[].class, "com.obric.memorydata.plugin");
        }

        abstract Object readString(k r1);
    }

    static {
        f4931a = a(1, 3);
        f4932b = a(1, 4);
        c = a(2, 0);
        d = a(3, 2);
    }

    public static int a(int r0) {
        return r0 & 7;
    }

    static int a(int r0, int r1) {
        return (r0 << 3) | r1;
    }

    public static int b(int r0) {
        return r0 >>> 3;
    }
}
