package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ab;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum HpkeAead extends Enum<HpkeAead> implements ab.c {
    private static final /* synthetic */ HpkeAead[] $VALUES = null;
    public static final HpkeAead AEAD_UNKNOWN = null;
    public static final int AEAD_UNKNOWN_VALUE = 0;
    public static final HpkeAead AES_128_GCM = null;
    public static final int AES_128_GCM_VALUE = 1;
    public static final HpkeAead AES_256_GCM = null;
    public static final int AES_256_GCM_VALUE = 2;
    public static final HpkeAead CHACHA20_POLY1305 = null;
    public static final int CHACHA20_POLY1305_VALUE = 3;
    public static final HpkeAead UNRECOGNIZED = null;
    private static final ab.d<HpkeAead> internalValueMap = null;
    private final int value;

    private static final class a implements ab.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final ab.e f4885a = null;

        static {
            f4885a = new a();
        }

        private a() {
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ab.e
        public boolean a(int r1) {
            if (HpkeAead.forNumber(r1) == null) goto L5;
            return true;
        L5:
            return false;
        }
    }

    static {
        HpkeAead r0 = new HpkeAead("AEAD_UNKNOWN", 0, 0);
        AEAD_UNKNOWN = r0;
        HpkeAead r1 = new HpkeAead("AES_128_GCM", 1, 1);
        AES_128_GCM = r1;
        HpkeAead r3 = new HpkeAead("AES_256_GCM", 2, 2);
        AES_256_GCM = r3;
        HpkeAead r5 = new HpkeAead("CHACHA20_POLY1305", 3, 3);
        CHACHA20_POLY1305 = r5;
        HpkeAead r7 = new HpkeAead("UNRECOGNIZED", 4, -1);
        UNRECOGNIZED = r7;
        $VALUES = new HpkeAead[]{r0, r1, r3, r5, r7};
        internalValueMap = new AnonymousClass1();
    }

    private HpkeAead(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static HpkeAead forNumber(int r1) {
        if (r1 == 0) goto L18;
        if (r1 == 1) goto L16;
        if (r1 == 2) goto L14;
        if (r1 == 3) goto L12;
        return null;
    L12:
        return CHACHA20_POLY1305;
    L14:
        return AES_256_GCM;
    L16:
        return AES_128_GCM;
    L18:
        return AEAD_UNKNOWN;
    }

    public static ab.d<HpkeAead> internalGetValueMap() {
        return internalValueMap;
    }

    public static ab.e internalGetVerifier() {
        return a.f4885a;
    }

    @Deprecated
    public static HpkeAead valueOf(int r0) {
        return forNumber(r0);
    }

    public static HpkeAead valueOf(String r2) {
        return (HpkeAead) ZeusTransformUtils.preCheckCast(Enum.valueOf(HpkeAead.class, r2), HpkeAead.class, "com.obric.memorydata.plugin");
    }

    public static HpkeAead[] values() {
        return (HpkeAead[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), HpkeAead[].class, "com.obric.memorydata.plugin");
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ab.c
    public final int getNumber() {
        if (this == UNRECOGNIZED) goto L7;
        return this.value;
    L7:
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
