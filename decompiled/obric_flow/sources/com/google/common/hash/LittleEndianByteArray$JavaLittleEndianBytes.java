package com.google.common.hash;

/* JADX INFO: loaded from: classes2.dex */
abstract enum LittleEndianByteArray$JavaLittleEndianBytes extends Enum<LittleEndianByteArray$JavaLittleEndianBytes> {
    public static final LittleEndianByteArray$JavaLittleEndianBytes INSTANCE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LittleEndianByteArray$JavaLittleEndianBytes[] f9261a = null;

    static {
        final String r5 = "INSTANCE";
        final int r10 = 0;
        LittleEndianByteArray$JavaLittleEndianBytes r11 = new AnonymousClass1(r5, r10);
        INSTANCE = r11;
        f9261a = new LittleEndianByteArray$JavaLittleEndianBytes[]{r11};
    }

    public LittleEndianByteArray$JavaLittleEndianBytes(String r5, int r10, p r11) {
        super(r5, r10);
    }

    public static LittleEndianByteArray$JavaLittleEndianBytes valueOf(String r5) {
        return (LittleEndianByteArray$JavaLittleEndianBytes) Enum.valueOf(LittleEndianByteArray$JavaLittleEndianBytes.class, r5);
    }

    public static LittleEndianByteArray$JavaLittleEndianBytes[] values() {
        return (LittleEndianByteArray$JavaLittleEndianBytes[]) f9261a.clone();
    }

    public abstract /* synthetic */ long getLongLittleEndian(byte[] r5, int r10);

    public abstract /* synthetic */ void putLongLittleEndian(byte[] r5, int r10, long r11);
}
