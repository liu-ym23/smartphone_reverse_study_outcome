package com.google.common.hash;

/* JADX INFO: loaded from: classes2.dex */
abstract enum Hashing$ChecksumType extends Enum<Hashing$ChecksumType> implements o {
    public static final Hashing$ChecksumType ADLER_32 = null;
    public static final Hashing$ChecksumType CRC_32 = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Hashing$ChecksumType[] f9260a = null;
    public final k hashFunction;

    static {
        final int r5 = 0;
        final String r10 = "Hashing.crc32()";
        final String r11 = "CRC_32";
        Hashing$ChecksumType r12 = new AnonymousClass1(r11, r5, r10);
        CRC_32 = r12;
        final int r13 = 1;
        final String r14 = "Hashing.adler32()";
        final String r15 = "ADLER_32";
        Hashing$ChecksumType r16 = new AnonymousClass2(r15, r13, r14);
        ADLER_32 = r16;
        f9260a = new Hashing$ChecksumType[]{r12, r16};
    }

    public /* synthetic */ Hashing$ChecksumType(String r5, int r10, String r11, m r12) {
        this(r5, r10, r11);
    }

    public static Hashing$ChecksumType valueOf(String r5) {
        return (Hashing$ChecksumType) Enum.valueOf(Hashing$ChecksumType.class, r5);
    }

    public static Hashing$ChecksumType[] values() {
        return (Hashing$ChecksumType[]) f9260a.clone();
    }

    @Override // java.util.function.Supplier
    public abstract /* synthetic */ Object get();

    public Hashing$ChecksumType(String r5, int r10, String r11) {
        super(r5, r10);
        this.hashFunction = new ChecksumHashFunction(this, 32, r11);
    }
}
