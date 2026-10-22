package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.ab;
import com.google.crypto.tink.shaded.protobuf.at;
import com.google.crypto.tink.shaded.protobuf.be;
import com.google.crypto.tink.shaded.protobuf.k;
import com.google.crypto.tink.shaded.protobuf.q;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class KeyData extends GeneratedMessageLite<KeyData, a> implements com.google.crypto.tink.proto.a {
    private static final KeyData DEFAULT_INSTANCE = null;
    public static final int KEY_MATERIAL_TYPE_FIELD_NUMBER = 3;
    private static volatile be<KeyData> PARSER = null;
    public static final int TYPE_URL_FIELD_NUMBER = 1;
    public static final int VALUE_FIELD_NUMBER = 2;
    private int keyMaterialType_;
    private String typeUrl_;
    private ByteString value_;

    /* JADX INFO: renamed from: com.google.crypto.tink.proto.KeyData$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f4892a = null;

        static {
            int[] r0 = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f4892a = r0;
            r0[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L18:
            f4892a[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L22:
            f4892a[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L30:
            f4892a[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L20:
            f4892a[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L24:
            f4892a[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L26:
            f4892a[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;     // Catch: NoSuchFieldError -> L17
            return;
        }
    }

    public static final enum KeyMaterialType extends Enum<KeyMaterialType> implements ab.c {
        private static final /* synthetic */ KeyMaterialType[] $VALUES = null;
        public static final KeyMaterialType ASYMMETRIC_PRIVATE = null;
        public static final int ASYMMETRIC_PRIVATE_VALUE = 2;
        public static final KeyMaterialType ASYMMETRIC_PUBLIC = null;
        public static final int ASYMMETRIC_PUBLIC_VALUE = 3;
        public static final KeyMaterialType REMOTE = null;
        public static final int REMOTE_VALUE = 4;
        public static final KeyMaterialType SYMMETRIC = null;
        public static final int SYMMETRIC_VALUE = 1;
        public static final KeyMaterialType UNKNOWN_KEYMATERIAL = null;
        public static final int UNKNOWN_KEYMATERIAL_VALUE = 0;
        public static final KeyMaterialType UNRECOGNIZED = null;
        private static final ab.d<KeyMaterialType> internalValueMap = null;
        private final int value;

        private static final class a implements ab.e {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            static final ab.e f4893a = null;

            static {
                f4893a = new a();
            }

            private a() {
            }

            @Override // com.google.crypto.tink.shaded.protobuf.ab.e
            public boolean a(int r1) {
                if (KeyMaterialType.forNumber(r1) == null) goto L5;
                return true;
            L5:
                return false;
            }
        }

        static {
            KeyMaterialType r0 = new KeyMaterialType("UNKNOWN_KEYMATERIAL", 0, 0);
            UNKNOWN_KEYMATERIAL = r0;
            KeyMaterialType r1 = new KeyMaterialType("SYMMETRIC", 1, 1);
            SYMMETRIC = r1;
            KeyMaterialType r3 = new KeyMaterialType("ASYMMETRIC_PRIVATE", 2, 2);
            ASYMMETRIC_PRIVATE = r3;
            KeyMaterialType r5 = new KeyMaterialType("ASYMMETRIC_PUBLIC", 3, 3);
            ASYMMETRIC_PUBLIC = r5;
            KeyMaterialType r7 = new KeyMaterialType("REMOTE", 4, 4);
            REMOTE = r7;
            KeyMaterialType r9 = new KeyMaterialType("UNRECOGNIZED", 5, -1);
            UNRECOGNIZED = r9;
            $VALUES = new KeyMaterialType[]{r0, r1, r3, r5, r7, r9};
            internalValueMap = new AnonymousClass1();
        }

        private KeyMaterialType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }

        public static KeyMaterialType forNumber(int r1) {
            if (r1 == 0) goto L22;
            if (r1 == 1) goto L20;
            if (r1 == 2) goto L18;
            if (r1 == 3) goto L16;
            if (r1 == 4) goto L14;
            return null;
        L14:
            return REMOTE;
        L16:
            return ASYMMETRIC_PUBLIC;
        L18:
            return ASYMMETRIC_PRIVATE;
        L20:
            return SYMMETRIC;
        L22:
            return UNKNOWN_KEYMATERIAL;
        }

        public static ab.d<KeyMaterialType> internalGetValueMap() {
            return internalValueMap;
        }

        public static ab.e internalGetVerifier() {
            return a.f4893a;
        }

        @Deprecated
        public static KeyMaterialType valueOf(int r0) {
            return forNumber(r0);
        }

        public static KeyMaterialType valueOf(String r2) {
            return (KeyMaterialType) ZeusTransformUtils.preCheckCast(Enum.valueOf(KeyMaterialType.class, r2), KeyMaterialType.class, "com.obric.memorydata.plugin");
        }

        public static KeyMaterialType[] values() {
            return (KeyMaterialType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), KeyMaterialType[].class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ab.c
        public final int getNumber() {
            if (this == UNRECOGNIZED) goto L7;
            return this.value;
        L7:
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
    }

    public static final class a extends GeneratedMessageLite.a<KeyData, a> implements com.google.crypto.tink.proto.a {
        private a() {
            super(KeyData.a());
        }

        /* synthetic */ a(AnonymousClass1 r1) {
            this();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.a, com.google.crypto.tink.shaded.protobuf.a.AbstractC0207a
        public /* synthetic */ com.google.crypto.tink.shaded.protobuf.a.AbstractC0207a a() {
            return super.f();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.a, com.google.crypto.tink.shaded.protobuf.a.AbstractC0207a
        public /* synthetic */ com.google.crypto.tink.shaded.protobuf.a.AbstractC0207a a(com.google.crypto.tink.shaded.protobuf.a r3) {
            return super.a((GeneratedMessageLite) ZeusTransformUtils.preCheckCast(r3, GeneratedMessageLite.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.a, com.google.crypto.tink.shaded.protobuf.a.AbstractC0207a
        public /* synthetic */ com.google.crypto.tink.shaded.protobuf.a.AbstractC0207a a(k r1, q r2) {
            return super.c(r1, r2);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.a, com.google.crypto.tink.shaded.protobuf.a.AbstractC0207a
        public /* synthetic */ com.google.crypto.tink.shaded.protobuf.a.AbstractC0207a a(byte[] r1, int r2, int r3) {
            return super.b(r1, r2, r3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.a.AbstractC0207a, com.google.crypto.tink.shaded.protobuf.at.a
        public /* synthetic */ at.a a(at r3) {
            return super.b((at) ZeusTransformUtils.wrapperContextForParams(r3, at.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.a.AbstractC0207a, com.google.crypto.tink.shaded.protobuf.at.a
        public /* synthetic */ at.a a(byte[] r1) {
            return super.b(r1);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.a, com.google.crypto.tink.shaded.protobuf.a.AbstractC0207a, com.google.crypto.tink.shaded.protobuf.at.a
        public /* synthetic */ at.a b(k r1, q r2) {
            return super.c(r1, r2);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.a, com.google.crypto.tink.shaded.protobuf.at.a
        public /* synthetic */ at b() {
            return super.g();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.a, com.google.crypto.tink.shaded.protobuf.at.a
        public /* synthetic */ at c() {
            return super.h();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.a, com.google.crypto.tink.shaded.protobuf.a.AbstractC0207a
        public /* synthetic */ Object clone() {
            return super.f();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.a, com.google.crypto.tink.shaded.protobuf.au
        public /* synthetic */ at getDefaultInstanceForType() {
            return super.i();
        }
    }

    static {
        KeyData r0 = new KeyData();
        DEFAULT_INSTANCE = r0;
        GeneratedMessageLite.registerDefaultInstance(KeyData.class, r0);
    }

    private KeyData() {
        this.typeUrl_ = "";
        this.value_ = ByteString.EMPTY;
    }

    static /* synthetic */ KeyData a() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke r1, Object r2, Object r3) {
        AnonymousClass1 r4 = null;
        switch(AnonymousClass1.f4892a[r1.ordinal()]) {
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
        be<KeyData> r0 = PARSER;
        if (r0 == null) goto L12;
    L21:
        return r0;
    L12:
        monitor-enter(KeyData.class);
        r0 = PARSER;     // Catch: Throwable -> L18
        if (r0 != null) goto L16;
        r0 = new GeneratedMessageLite.b(DEFAULT_INSTANCE);     // Catch: Throwable -> L18
        PARSER = r0;     // Catch: Throwable -> L18
    L16:
        monitor-exit(KeyData.class);     // Catch: Throwable -> L18
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
        return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\f", new Object[]{"typeUrl_", "value_", "keyMaterialType_"});
    L27:
        return new a(r4);
    L29:
        return new KeyData();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite, com.google.crypto.tink.shaded.protobuf.au
    public /* bridge */ /* synthetic */ at getDefaultInstanceForType() {
        return super.getDefaultInstanceForType();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite, com.google.crypto.tink.shaded.protobuf.at
    public /* bridge */ /* synthetic */ at.a newBuilderForType() {
        return super.newBuilderForType();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite, com.google.crypto.tink.shaded.protobuf.at
    public /* bridge */ /* synthetic */ at.a toBuilder() {
        return super.toBuilder();
    }
}
