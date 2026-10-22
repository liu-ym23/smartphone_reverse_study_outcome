package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ab;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum EcdsaSignatureEncoding extends Enum<EcdsaSignatureEncoding> implements ab.c {
    private static final /* synthetic */ EcdsaSignatureEncoding[] $VALUES = null;
    public static final EcdsaSignatureEncoding DER = null;
    public static final int DER_VALUE = 2;
    public static final EcdsaSignatureEncoding IEEE_P1363 = null;
    public static final int IEEE_P1363_VALUE = 1;
    public static final EcdsaSignatureEncoding UNKNOWN_ENCODING = null;
    public static final int UNKNOWN_ENCODING_VALUE = 0;
    public static final EcdsaSignatureEncoding UNRECOGNIZED = null;
    private static final ab.d<EcdsaSignatureEncoding> internalValueMap = null;
    private final int value;

    private static final class a implements ab.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final ab.e f4882a = null;

        static {
            f4882a = new a();
        }

        private a() {
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ab.e
        public boolean a(int r1) {
            if (EcdsaSignatureEncoding.forNumber(r1) == null) goto L5;
            return true;
        L5:
            return false;
        }
    }

    static {
        EcdsaSignatureEncoding r0 = new EcdsaSignatureEncoding("UNKNOWN_ENCODING", 0, 0);
        UNKNOWN_ENCODING = r0;
        EcdsaSignatureEncoding r1 = new EcdsaSignatureEncoding("IEEE_P1363", 1, 1);
        IEEE_P1363 = r1;
        EcdsaSignatureEncoding r3 = new EcdsaSignatureEncoding("DER", 2, 2);
        DER = r3;
        EcdsaSignatureEncoding r5 = new EcdsaSignatureEncoding("UNRECOGNIZED", 3, -1);
        UNRECOGNIZED = r5;
        $VALUES = new EcdsaSignatureEncoding[]{r0, r1, r3, r5};
        internalValueMap = new AnonymousClass1();
    }

    private EcdsaSignatureEncoding(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static EcdsaSignatureEncoding forNumber(int r1) {
        if (r1 == 0) goto L14;
        if (r1 == 1) goto L12;
        if (r1 == 2) goto L10;
        return null;
    L10:
        return DER;
    L12:
        return IEEE_P1363;
    L14:
        return UNKNOWN_ENCODING;
    }

    public static ab.d<EcdsaSignatureEncoding> internalGetValueMap() {
        return internalValueMap;
    }

    public static ab.e internalGetVerifier() {
        return a.f4882a;
    }

    @Deprecated
    public static EcdsaSignatureEncoding valueOf(int r0) {
        return forNumber(r0);
    }

    public static EcdsaSignatureEncoding valueOf(String r2) {
        return (EcdsaSignatureEncoding) ZeusTransformUtils.preCheckCast(Enum.valueOf(EcdsaSignatureEncoding.class, r2), EcdsaSignatureEncoding.class, "com.obric.memorydata.plugin");
    }

    public static EcdsaSignatureEncoding[] values() {
        return (EcdsaSignatureEncoding[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), EcdsaSignatureEncoding[].class, "com.obric.memorydata.plugin");
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ab.c
    public final int getNumber() {
        if (this == UNRECOGNIZED) goto L7;
        return this.value;
    L7:
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
