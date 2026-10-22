package com.google.common.hash;

import java.security.AccessController;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes2.dex */
abstract enum LittleEndianByteArray$UnsafeByteArray extends Enum<LittleEndianByteArray$UnsafeByteArray> {
    public static final LittleEndianByteArray$UnsafeByteArray UNSAFE_BIG_ENDIAN = null;
    public static final LittleEndianByteArray$UnsafeByteArray UNSAFE_LITTLE_ENDIAN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Unsafe f9262a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f9263b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ LittleEndianByteArray$UnsafeByteArray[] f9264c = null;

    static {
        final String r5 = "UNSAFE_LITTLE_ENDIAN";
        final int r10 = 0;
        LittleEndianByteArray$UnsafeByteArray r11 = new AnonymousClass1(r5, r10);
        UNSAFE_LITTLE_ENDIAN = r11;
        final String r12 = "UNSAFE_BIG_ENDIAN";
        final int r13 = 1;
        LittleEndianByteArray$UnsafeByteArray r14 = new AnonymousClass2(r12, r13);
        UNSAFE_BIG_ENDIAN = r14;
        f9264c = new LittleEndianByteArray$UnsafeByteArray[]{r11, r14};
        Unsafe r15 = a();
        f9262a = r15;
        f9263b = r15.arrayBaseOffset(byte[].class);
        if (r15.arrayIndexScale(byte[].class) != 1) goto L6;
        return;
    L6:
        throw new AssertionError();
    }

    public LittleEndianByteArray$UnsafeByteArray(String r5, int r10, p r11) {
        super(r5, r10);
    }

    public static Unsafe a() {
        return Unsafe.getUnsafe();
    L4:
        return (Unsafe) AccessController.doPrivileged(new q());
    L6:
        e = move-exception;
        throw new RuntimeException("Could not initialize intrinsics", e.getCause());
    }

    public static /* synthetic */ int access$100() {
        return f9263b;
    }

    public static /* synthetic */ Unsafe access$200() {
        return f9262a;
    }

    public static LittleEndianByteArray$UnsafeByteArray valueOf(String r5) {
        return (LittleEndianByteArray$UnsafeByteArray) Enum.valueOf(LittleEndianByteArray$UnsafeByteArray.class, r5);
    }

    public static LittleEndianByteArray$UnsafeByteArray[] values() {
        return (LittleEndianByteArray$UnsafeByteArray[]) f9264c.clone();
    }

    public abstract /* synthetic */ long getLongLittleEndian(byte[] r5, int r10);

    public abstract /* synthetic */ void putLongLittleEndian(byte[] r5, int r10, long r11);
}
