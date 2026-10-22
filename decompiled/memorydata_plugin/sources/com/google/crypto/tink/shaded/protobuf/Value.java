package com.google.crypto.tink.shaded.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class Value extends GeneratedMessageLite<Value, a> implements by {
    public static final int BOOL_VALUE_FIELD_NUMBER = 4;
    private static final Value DEFAULT_INSTANCE = null;
    public static final int LIST_VALUE_FIELD_NUMBER = 6;
    public static final int NULL_VALUE_FIELD_NUMBER = 1;
    public static final int NUMBER_VALUE_FIELD_NUMBER = 2;
    private static volatile be<Value> PARSER = null;
    public static final int STRING_VALUE_FIELD_NUMBER = 3;
    public static final int STRUCT_VALUE_FIELD_NUMBER = 5;
    private int kindCase_;
    private Object kind_;

    /* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.Value$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f4930a = null;

        static {
            int[] r0 = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f4930a = r0;
            r0[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L18:
            f4930a[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L22:
            f4930a[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L30:
            f4930a[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L20:
            f4930a[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L24:
            f4930a[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L26:
            f4930a[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;     // Catch: NoSuchFieldError -> L17
            return;
        }
    }

    public static final enum KindCase extends Enum<KindCase> {
        private static final /* synthetic */ KindCase[] $VALUES = null;
        public static final KindCase BOOL_VALUE = null;
        public static final KindCase KIND_NOT_SET = null;
        public static final KindCase LIST_VALUE = null;
        public static final KindCase NULL_VALUE = null;
        public static final KindCase NUMBER_VALUE = null;
        public static final KindCase STRING_VALUE = null;
        public static final KindCase STRUCT_VALUE = null;
        private final int value;

        static {
            KindCase r0 = new KindCase("NULL_VALUE", 0, 1);
            NULL_VALUE = r0;
            KindCase r1 = new KindCase("NUMBER_VALUE", 1, 2);
            NUMBER_VALUE = r1;
            KindCase r4 = new KindCase("STRING_VALUE", 2, 3);
            STRING_VALUE = r4;
            KindCase r6 = new KindCase("BOOL_VALUE", 3, 4);
            BOOL_VALUE = r6;
            KindCase r8 = new KindCase("STRUCT_VALUE", 4, 5);
            STRUCT_VALUE = r8;
            KindCase r10 = new KindCase("LIST_VALUE", 5, 6);
            LIST_VALUE = r10;
            KindCase r12 = new KindCase("KIND_NOT_SET", 6, 0);
            KIND_NOT_SET = r12;
            $VALUES = new KindCase[]{r0, r1, r4, r6, r8, r10, r12};
        }

        private KindCase(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }

        public static KindCase forNumber(int r0) {
            switch(r0) {
                case 0: goto L18;
                case 1: goto L16;
                case 2: goto L14;
                case 3: goto L12;
                case 4: goto L10;
                case 5: goto L8;
                case 6: goto L6;
                default: goto L3;
            };
        L3:
            return null;
        L6:
            return LIST_VALUE;
        L8:
            return STRUCT_VALUE;
        L10:
            return BOOL_VALUE;
        L12:
            return STRING_VALUE;
        L14:
            return NUMBER_VALUE;
        L16:
            return NULL_VALUE;
        L18:
            return KIND_NOT_SET;
        }

        @Deprecated
        public static KindCase valueOf(int r0) {
            return forNumber(r0);
        }

        public static KindCase valueOf(String r2) {
            return (KindCase) ZeusTransformUtils.preCheckCast(Enum.valueOf(KindCase.class, r2), KindCase.class, "com.obric.memorydata.plugin");
        }

        public static KindCase[] values() {
            return (KindCase[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), KindCase[].class, "com.obric.memorydata.plugin");
        }

        public int getNumber() {
            return this.value;
        }
    }

    public static final class a extends GeneratedMessageLite.a<Value, a> implements by {
        private a() {
            super(Value.b());
        }

        /* synthetic */ a(AnonymousClass1 r1) {
            this();
        }
    }

    static {
        Value r0 = new Value();
        DEFAULT_INSTANCE = r0;
        GeneratedMessageLite.registerDefaultInstance(Value.class, r0);
    }

    private Value() {
        this.kindCase_ = 0;
    }

    public static Value a() {
        return DEFAULT_INSTANCE;
    }

    static /* synthetic */ Value b() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke r1, Object r2, Object r3) {
        AnonymousClass1 r4 = null;
        switch(AnonymousClass1.f4930a[r1.ordinal()]) {
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
        be<Value> r0 = PARSER;
        if (r0 == null) goto L12;
    L21:
        return r0;
    L12:
        monitor-enter(Value.class);
        r0 = PARSER;     // Catch: Throwable -> L18
        if (r0 != null) goto L16;
        r0 = new GeneratedMessageLite.b(DEFAULT_INSTANCE);     // Catch: Throwable -> L18
        PARSER = r0;     // Catch: Throwable -> L18
    L16:
        monitor-exit(Value.class);     // Catch: Throwable -> L18
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
        return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0006\u0001\u0000\u0001\u0006\u0006\u0000\u0000\u0000\u0001?\u0000\u00023\u0000\u0003Ȼ\u0000\u0004:\u0000\u0005<\u0000\u0006<\u0000", new Object[]{"kind_", "kindCase_", bp.class, aj.class});
    L27:
        return new a(r4);
    L29:
        return new Value();
    }
}
