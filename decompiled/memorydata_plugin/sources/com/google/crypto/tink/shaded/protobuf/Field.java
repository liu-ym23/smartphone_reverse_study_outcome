package com.google.crypto.tink.shaded.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class Field extends GeneratedMessageLite<Field, a> implements v {
    public static final int CARDINALITY_FIELD_NUMBER = 2;
    private static final Field DEFAULT_INSTANCE = null;
    public static final int DEFAULT_VALUE_FIELD_NUMBER = 11;
    public static final int JSON_NAME_FIELD_NUMBER = 10;
    public static final int KIND_FIELD_NUMBER = 1;
    public static final int NAME_FIELD_NUMBER = 4;
    public static final int NUMBER_FIELD_NUMBER = 3;
    public static final int ONEOF_INDEX_FIELD_NUMBER = 7;
    public static final int OPTIONS_FIELD_NUMBER = 9;
    public static final int PACKED_FIELD_NUMBER = 8;
    private static volatile be<Field> PARSER = null;
    public static final int TYPE_URL_FIELD_NUMBER = 6;
    private int cardinality_;
    private String defaultValue_;
    private String jsonName_;
    private int kind_;
    private String name_;
    private int number_;
    private int oneofIndex_;
    private ab.i<bc> options_;
    private boolean packed_;
    private String typeUrl_;

    /* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.Field$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f4906a = null;

        static {
            int[] r0 = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f4906a = r0;
            r0[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L18:
            f4906a[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L22:
            f4906a[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L30:
            f4906a[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L20:
            f4906a[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L24:
            f4906a[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L26:
            f4906a[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;     // Catch: NoSuchFieldError -> L17
            return;
        }
    }

    public static final enum Cardinality extends Enum<Cardinality> implements ab.c {
        private static final /* synthetic */ Cardinality[] $VALUES = null;
        public static final Cardinality CARDINALITY_OPTIONAL = null;
        public static final int CARDINALITY_OPTIONAL_VALUE = 1;
        public static final Cardinality CARDINALITY_REPEATED = null;
        public static final int CARDINALITY_REPEATED_VALUE = 3;
        public static final Cardinality CARDINALITY_REQUIRED = null;
        public static final int CARDINALITY_REQUIRED_VALUE = 2;
        public static final Cardinality CARDINALITY_UNKNOWN = null;
        public static final int CARDINALITY_UNKNOWN_VALUE = 0;
        public static final Cardinality UNRECOGNIZED = null;
        private static final ab.d<Cardinality> internalValueMap = null;
        private final int value;

        private static final class a implements ab.e {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            static final ab.e f4907a = null;

            static {
                f4907a = new a();
            }

            private a() {
            }

            @Override // com.google.crypto.tink.shaded.protobuf.ab.e
            public boolean a(int r1) {
                if (Cardinality.forNumber(r1) == null) goto L5;
                return true;
            L5:
                return false;
            }
        }

        static {
            Cardinality r0 = new Cardinality("CARDINALITY_UNKNOWN", 0, 0);
            CARDINALITY_UNKNOWN = r0;
            Cardinality r1 = new Cardinality("CARDINALITY_OPTIONAL", 1, 1);
            CARDINALITY_OPTIONAL = r1;
            Cardinality r3 = new Cardinality("CARDINALITY_REQUIRED", 2, 2);
            CARDINALITY_REQUIRED = r3;
            Cardinality r5 = new Cardinality("CARDINALITY_REPEATED", 3, 3);
            CARDINALITY_REPEATED = r5;
            Cardinality r7 = new Cardinality("UNRECOGNIZED", 4, -1);
            UNRECOGNIZED = r7;
            $VALUES = new Cardinality[]{r0, r1, r3, r5, r7};
            internalValueMap = new AnonymousClass1();
        }

        private Cardinality(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }

        public static Cardinality forNumber(int r1) {
            if (r1 == 0) goto L18;
            if (r1 == 1) goto L16;
            if (r1 == 2) goto L14;
            if (r1 == 3) goto L12;
            return null;
        L12:
            return CARDINALITY_REPEATED;
        L14:
            return CARDINALITY_REQUIRED;
        L16:
            return CARDINALITY_OPTIONAL;
        L18:
            return CARDINALITY_UNKNOWN;
        }

        public static ab.d<Cardinality> internalGetValueMap() {
            return internalValueMap;
        }

        public static ab.e internalGetVerifier() {
            return a.f4907a;
        }

        @Deprecated
        public static Cardinality valueOf(int r0) {
            return forNumber(r0);
        }

        public static Cardinality valueOf(String r2) {
            return (Cardinality) ZeusTransformUtils.preCheckCast(Enum.valueOf(Cardinality.class, r2), Cardinality.class, "com.obric.memorydata.plugin");
        }

        public static Cardinality[] values() {
            return (Cardinality[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Cardinality[].class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ab.c
        public final int getNumber() {
            if (this == UNRECOGNIZED) goto L7;
            return this.value;
        L7:
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
    }

    public static final enum Kind extends Enum<Kind> implements ab.c {
        private static final /* synthetic */ Kind[] $VALUES = null;
        public static final Kind TYPE_BOOL = null;
        public static final int TYPE_BOOL_VALUE = 8;
        public static final Kind TYPE_BYTES = null;
        public static final int TYPE_BYTES_VALUE = 12;
        public static final Kind TYPE_DOUBLE = null;
        public static final int TYPE_DOUBLE_VALUE = 1;
        public static final Kind TYPE_ENUM = null;
        public static final int TYPE_ENUM_VALUE = 14;
        public static final Kind TYPE_FIXED32 = null;
        public static final int TYPE_FIXED32_VALUE = 7;
        public static final Kind TYPE_FIXED64 = null;
        public static final int TYPE_FIXED64_VALUE = 6;
        public static final Kind TYPE_FLOAT = null;
        public static final int TYPE_FLOAT_VALUE = 2;
        public static final Kind TYPE_GROUP = null;
        public static final int TYPE_GROUP_VALUE = 10;
        public static final Kind TYPE_INT32 = null;
        public static final int TYPE_INT32_VALUE = 5;
        public static final Kind TYPE_INT64 = null;
        public static final int TYPE_INT64_VALUE = 3;
        public static final Kind TYPE_MESSAGE = null;
        public static final int TYPE_MESSAGE_VALUE = 11;
        public static final Kind TYPE_SFIXED32 = null;
        public static final int TYPE_SFIXED32_VALUE = 15;
        public static final Kind TYPE_SFIXED64 = null;
        public static final int TYPE_SFIXED64_VALUE = 16;
        public static final Kind TYPE_SINT32 = null;
        public static final int TYPE_SINT32_VALUE = 17;
        public static final Kind TYPE_SINT64 = null;
        public static final int TYPE_SINT64_VALUE = 18;
        public static final Kind TYPE_STRING = null;
        public static final int TYPE_STRING_VALUE = 9;
        public static final Kind TYPE_UINT32 = null;
        public static final int TYPE_UINT32_VALUE = 13;
        public static final Kind TYPE_UINT64 = null;
        public static final int TYPE_UINT64_VALUE = 4;
        public static final Kind TYPE_UNKNOWN = null;
        public static final int TYPE_UNKNOWN_VALUE = 0;
        public static final Kind UNRECOGNIZED = null;
        private static final ab.d<Kind> internalValueMap = null;
        private final int value;

        private static final class a implements ab.e {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            static final ab.e f4908a = null;

            static {
                f4908a = new a();
            }

            private a() {
            }

            @Override // com.google.crypto.tink.shaded.protobuf.ab.e
            public boolean a(int r1) {
                if (Kind.forNumber(r1) == null) goto L5;
                return true;
            L5:
                return false;
            }
        }

        static {
            Kind r0 = new Kind("TYPE_UNKNOWN", 0, 0);
            TYPE_UNKNOWN = r0;
            Kind r1 = new Kind("TYPE_DOUBLE", 1, 1);
            TYPE_DOUBLE = r1;
            Kind r3 = new Kind("TYPE_FLOAT", 2, 2);
            TYPE_FLOAT = r3;
            Kind r5 = new Kind("TYPE_INT64", 3, 3);
            TYPE_INT64 = r5;
            Kind r7 = new Kind("TYPE_UINT64", 4, 4);
            TYPE_UINT64 = r7;
            Kind r9 = new Kind("TYPE_INT32", 5, 5);
            TYPE_INT32 = r9;
            Kind r11 = new Kind("TYPE_FIXED64", 6, 6);
            TYPE_FIXED64 = r11;
            Kind r13 = new Kind("TYPE_FIXED32", 7, 7);
            TYPE_FIXED32 = r13;
            Kind r15 = new Kind("TYPE_BOOL", 8, 8);
            TYPE_BOOL = r15;
            Kind r14 = new Kind("TYPE_STRING", 9, 9);
            TYPE_STRING = r14;
            Kind r12 = new Kind("TYPE_GROUP", 10, 10);
            TYPE_GROUP = r12;
            Kind r10 = new Kind("TYPE_MESSAGE", 11, 11);
            TYPE_MESSAGE = r10;
            Kind r8 = new Kind("TYPE_BYTES", 12, 12);
            TYPE_BYTES = r8;
            Kind r6 = new Kind("TYPE_UINT32", 13, 13);
            TYPE_UINT32 = r6;
            Kind r4 = new Kind("TYPE_ENUM", 14, 14);
            TYPE_ENUM = r4;
            Kind r2 = new Kind("TYPE_SFIXED32", 15, 15);
            TYPE_SFIXED32 = r2;
            Kind r16 = new Kind("TYPE_SFIXED64", 16, 16);
            TYPE_SFIXED64 = r16;
            Kind r17 = new Kind("TYPE_SINT32", 17, 17);
            TYPE_SINT32 = r17;
            Kind r18 = new Kind("TYPE_SINT64", 18, 18);
            TYPE_SINT64 = r18;
            Kind r19 = new Kind("UNRECOGNIZED", 19, -1);
            UNRECOGNIZED = r19;
            $VALUES = new Kind[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4, r2, r16, r17, r18, r19};
            internalValueMap = new AnonymousClass1();
        }

        private Kind(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }

        public static Kind forNumber(int r0) {
            switch(r0) {
                case 0: goto L42;
                case 1: goto L40;
                case 2: goto L38;
                case 3: goto L36;
                case 4: goto L34;
                case 5: goto L32;
                case 6: goto L30;
                case 7: goto L28;
                case 8: goto L26;
                case 9: goto L24;
                case 10: goto L22;
                case 11: goto L20;
                case 12: goto L18;
                case 13: goto L16;
                case 14: goto L14;
                case 15: goto L12;
                case 16: goto L10;
                case 17: goto L8;
                case 18: goto L6;
                default: goto L3;
            };
        L3:
            return null;
        L6:
            return TYPE_SINT64;
        L8:
            return TYPE_SINT32;
        L10:
            return TYPE_SFIXED64;
        L12:
            return TYPE_SFIXED32;
        L14:
            return TYPE_ENUM;
        L16:
            return TYPE_UINT32;
        L18:
            return TYPE_BYTES;
        L20:
            return TYPE_MESSAGE;
        L22:
            return TYPE_GROUP;
        L24:
            return TYPE_STRING;
        L26:
            return TYPE_BOOL;
        L28:
            return TYPE_FIXED32;
        L30:
            return TYPE_FIXED64;
        L32:
            return TYPE_INT32;
        L34:
            return TYPE_UINT64;
        L36:
            return TYPE_INT64;
        L38:
            return TYPE_FLOAT;
        L40:
            return TYPE_DOUBLE;
        L42:
            return TYPE_UNKNOWN;
        }

        public static ab.d<Kind> internalGetValueMap() {
            return internalValueMap;
        }

        public static ab.e internalGetVerifier() {
            return a.f4908a;
        }

        @Deprecated
        public static Kind valueOf(int r0) {
            return forNumber(r0);
        }

        public static Kind valueOf(String r2) {
            return (Kind) ZeusTransformUtils.preCheckCast(Enum.valueOf(Kind.class, r2), Kind.class, "com.obric.memorydata.plugin");
        }

        public static Kind[] values() {
            return (Kind[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Kind[].class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ab.c
        public final int getNumber() {
            if (this == UNRECOGNIZED) goto L7;
            return this.value;
        L7:
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
    }

    public static final class a extends GeneratedMessageLite.a<Field, a> implements v {
        private a() {
            super(Field.a());
        }

        /* synthetic */ a(AnonymousClass1 r1) {
            this();
        }
    }

    static {
        Field r0 = new Field();
        DEFAULT_INSTANCE = r0;
        GeneratedMessageLite.registerDefaultInstance(Field.class, r0);
    }

    private Field() {
        this.name_ = "";
        this.typeUrl_ = "";
        this.options_ = emptyProtobufList();
        this.jsonName_ = "";
        this.defaultValue_ = "";
    }

    static /* synthetic */ Field a() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke r1, Object r2, Object r3) {
        AnonymousClass1 r4 = null;
        switch(AnonymousClass1.f4906a[r1.ordinal()]) {
            case 1: goto L29;
            case 2: goto L27;
            case 3: goto L25;
            case 4: goto L23;
            case 5: goto L9;
            case 6: goto L8;
            case 7: goto L6;
            default: goto L5;
        };
    L6:
        return null;
    L9:
        be<Field> r0 = PARSER;
        if (r0 == null) goto L12;
    L21:
        return r0;
    L12:
        monitor-enter(Field.class);
        r0 = PARSER;     // Catch: Throwable -> L18
        if (r0 != null) goto L16;
        r0 = new GeneratedMessageLite.b(DEFAULT_INSTANCE);     // Catch: Throwable -> L18
        PARSER = r0;     // Catch: Throwable -> L18
    L16:
        monitor-exit(Field.class);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    L5:
        throw new UnsupportedOperationException();
    L8:
        return (byte) 1;
    L23:
        return DEFAULT_INSTANCE;
    L25:
        return newMessageInfo(DEFAULT_INSTANCE, "\u0000\n\u0000\u0000\u0001\u000b\n\u0000\u0001\u0000\u0001\f\u0002\f\u0003\u0004\u0004Ȉ\u0006Ȉ\u0007\u0004\b\u0007\t\u001b\nȈ\u000bȈ", new Object[]{"kind_", "cardinality_", "number_", "name_", "typeUrl_", "oneofIndex_", "packed_", "options_", bc.class, "jsonName_", "defaultValue_"});
    L27:
        return new a(r4);
    L29:
        return new Field();
    }
}
