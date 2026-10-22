package com.google.common.hash;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;
import java.nio.ByteOrder;
import java.security.AccessController;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes2.dex */
final class LittleEndianByteArray {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f4714a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final a f4715b = null;

    /* JADX INFO: renamed from: com.google.common.hash.LittleEndianByteArray$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static abstract enum JavaLittleEndianBytes extends Enum<JavaLittleEndianBytes> implements a {
        private static final /* synthetic */ JavaLittleEndianBytes[] $VALUES = null;
        public static final JavaLittleEndianBytes INSTANCE = null;

        private static /* synthetic */ JavaLittleEndianBytes[] $values() {
            return new JavaLittleEndianBytes[]{INSTANCE};
        }

        static {
            final String r1 = "INSTANCE";
            final int r2 = 0;
            INSTANCE = new AnonymousClass1(r1, r2);
            $VALUES = $values();
        }

        private JavaLittleEndianBytes(String r1, int r2) {
            super(r1, r2);
        }

        /* synthetic */ JavaLittleEndianBytes(String r1, int r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        public static JavaLittleEndianBytes valueOf(String r2) {
            return (JavaLittleEndianBytes) ZeusTransformUtils.preCheckCast(Enum.valueOf(JavaLittleEndianBytes.class, r2), JavaLittleEndianBytes.class, "com.obric.memorydata.plugin");
        }

        public static JavaLittleEndianBytes[] values() {
            return (JavaLittleEndianBytes[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), JavaLittleEndianBytes[].class, "com.obric.memorydata.plugin");
        }
    }

    private static abstract enum UnsafeByteArray extends Enum<UnsafeByteArray> implements a {
        private static final /* synthetic */ UnsafeByteArray[] $VALUES = null;
        private static final int BYTE_ARRAY_BASE_OFFSET = 0;
        public static final UnsafeByteArray UNSAFE_BIG_ENDIAN = null;
        public static final UnsafeByteArray UNSAFE_LITTLE_ENDIAN = null;
        private static final Unsafe theUnsafe = null;

        private static /* synthetic */ UnsafeByteArray[] $values() {
            return new UnsafeByteArray[]{UNSAFE_LITTLE_ENDIAN, UNSAFE_BIG_ENDIAN};
        }

        static {
            final String r2 = "UNSAFE_LITTLE_ENDIAN";
            final int r3 = 0;
            UNSAFE_LITTLE_ENDIAN = new AnonymousClass1(r2, r3);
            final String r4 = "UNSAFE_BIG_ENDIAN";
            final int r5 = 1;
            UNSAFE_BIG_ENDIAN = new AnonymousClass2(r4, r5);
            $VALUES = $values();
            Unsafe r1 = getUnsafe();
            theUnsafe = r1;
            BYTE_ARRAY_BASE_OFFSET = r1.arrayBaseOffset(byte[].class);
            if (r1.arrayIndexScale(byte[].class) != 1) goto L6;
            return;
        L6:
            throw new AssertionError();
        }

        private UnsafeByteArray(String r1, int r2) {
            super(r1, r2);
        }

        /* synthetic */ UnsafeByteArray(String r1, int r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        static /* synthetic */ int access$100() {
            return BYTE_ARRAY_BASE_OFFSET;
        }

        static /* synthetic */ Unsafe access$200() {
            return theUnsafe;
        }

        private static Unsafe getUnsafe() {
            return Unsafe.getUnsafe();
        L4:
            return (Unsafe) ZeusTransformUtils.preCheckCast(AccessController.doPrivileged($$Lambda$LittleEndianByteArray$UnsafeByteArray$iJIsI_lNv4qMjciPs5a1NnagFuA.INSTANCE), Unsafe.class, "com.obric.memorydata.plugin");
        L6:
            e = move-exception;
            throw new RuntimeException("Could not initialize intrinsics", e.getCause());
        }

        static /* synthetic */ Unsafe lambda$getUnsafe$0() {
            Field[] r1 = Unsafe.class.getDeclaredFields();
            int r2 = r1.length;
            int r3 = 0;
        L3:
            if (r3 >= r2) goto L10;
            Field r4 = r1[r3];
            r4.setAccessible(true);
            Object r5 = r4.get(null);
            if (ZeusTransformUtils.instanceOf(Unsafe.class, r5) == true) goto L7;
            r3 = r3 + 1;
            goto L3
        L7:
            return (Unsafe) ZeusTransformUtils.preCheckCast(Unsafe.class.cast(r5), Unsafe.class, "com.obric.memorydata.plugin");
        L10:
            throw new NoSuchFieldError("the Unsafe");
        }

        public static UnsafeByteArray valueOf(String r2) {
            return (UnsafeByteArray) ZeusTransformUtils.preCheckCast(Enum.valueOf(UnsafeByteArray.class, r2), UnsafeByteArray.class, "com.obric.memorydata.plugin");
        }

        public static UnsafeByteArray[] values() {
            return (UnsafeByteArray[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), UnsafeByteArray[].class, "com.obric.memorydata.plugin");
        }
    }

    private interface a {
    }

    static {
        a r0 = JavaLittleEndianBytes.INSTANCE;
        String r1 = System.getProperty("os.arch");     // Catch: Throwable -> L13
        if ("amd64".equals(r1) == true) goto L8;
        if ("aarch64".equals(r1) == true) goto L8;
    L14:
    L8:
        if (ByteOrder.nativeOrder().equals(ByteOrder.LITTLE_ENDIAN) == false) goto L10;
        r0 = UnsafeByteArray.UNSAFE_LITTLE_ENDIAN;     // Catch: Throwable -> L13
        goto L14
    L10:
        r0 = UnsafeByteArray.UNSAFE_BIG_ENDIAN;     // Catch: Throwable -> L13
    L11:
        f4715b = r0;
    }

    private LittleEndianByteArray() {
    }
}
