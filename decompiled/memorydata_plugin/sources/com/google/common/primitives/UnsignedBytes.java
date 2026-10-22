package com.google.common.primitives;

import com.bytedance.bdlocation.exception.BDLocationException;
import com.google.common.base.n;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.Comparator;
import java.util.Objects;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes2.dex */
public final class UnsignedBytes {

    static class LexicographicalComparatorHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final String f4763a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final Comparator<byte[]> f4764b = null;

        static final enum PureJavaComparator extends Enum<PureJavaComparator> implements Comparator<byte[]> {
            private static final /* synthetic */ PureJavaComparator[] $VALUES = null;
            public static final PureJavaComparator INSTANCE = null;

            private static /* synthetic */ PureJavaComparator[] $values() {
                return new PureJavaComparator[]{INSTANCE};
            }

            static {
                INSTANCE = new PureJavaComparator("INSTANCE", 0);
                $VALUES = $values();
            }

            private PureJavaComparator(String r1, int r2) {
                super(r1, r2);
            }

            public static PureJavaComparator valueOf(String r2) {
                return (PureJavaComparator) ZeusTransformUtils.preCheckCast(Enum.valueOf(PureJavaComparator.class, r2), PureJavaComparator.class, "com.obric.memorydata.plugin");
            }

            public static PureJavaComparator[] values() {
                return (PureJavaComparator[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), PureJavaComparator[].class, "com.obric.memorydata.plugin");
            }

            @Override // java.util.Comparator
            public /* synthetic */ int compare(byte[] r3, byte[] r4) {
                return compare2((byte[]) ZeusTransformUtils.preCheckCast(r3, byte[].class, "com.obric.memorydata.plugin"), (byte[]) ZeusTransformUtils.preCheckCast(r4, byte[].class, "com.obric.memorydata.plugin"));
            }

            /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
            public int compare2(byte[] r4, byte[] r5) {
                int r3 = Math.min(r4.length, r5.length);
                int r0 = 0;
            L3:
                if (r0 >= r3) goto L9;
                int r1 = UnsignedBytes.a(r4[r0], r5[r0]);
                if (r1 != 0) goto L6;
                r0 = r0 + 1;
                goto L3
            L6:
                return r1;
            L9:
                return r4.length - r5.length;
            }

            @Override // java.lang.Enum
            public String toString() {
                return "UnsignedBytes.lexicographicalComparator() (pure Java version)";
            }
        }

        static final enum UnsafeComparator extends Enum<UnsafeComparator> implements Comparator<byte[]> {
            private static final /* synthetic */ UnsafeComparator[] $VALUES = null;
            static final boolean BIG_ENDIAN = false;
            static final int BYTE_ARRAY_BASE_OFFSET = 0;
            public static final UnsafeComparator INSTANCE = null;
            static final Unsafe theUnsafe = null;

            private static /* synthetic */ UnsafeComparator[] $values() {
                return new UnsafeComparator[]{INSTANCE};
            }

            static {
                INSTANCE = new UnsafeComparator("INSTANCE", 0);
                $VALUES = $values();
                BIG_ENDIAN = ByteOrder.nativeOrder().equals(ByteOrder.BIG_ENDIAN);
                Unsafe r1 = getUnsafe();
                theUnsafe = r1;
                int r2 = r1.arrayBaseOffset(byte[].class);
                BYTE_ARRAY_BASE_OFFSET = r2;
                if (BDLocationException.ERROR_RESTRICTED_MODE_ON.equals(System.getProperty("sun.arch.data.model")) == false) goto L10;
                if ((r2 % 8) != 0) goto L10;
                if (r1.arrayIndexScale(byte[].class) != 1) goto L10;
                return;
            L10:
                throw new Error();
            }

            private UnsafeComparator(String r1, int r2) {
                super(r1, r2);
            }

            private static Unsafe getUnsafe() {
                return Unsafe.getUnsafe();
            L4:
                return (Unsafe) ZeusTransformUtils.preCheckCast(AccessController.doPrivileged(new AnonymousClass1()), Unsafe.class, "com.obric.memorydata.plugin");
            L6:
                e = move-exception;
                throw new RuntimeException("Could not initialize intrinsics", e.getCause());
            }

            public static UnsafeComparator valueOf(String r2) {
                return (UnsafeComparator) ZeusTransformUtils.preCheckCast(Enum.valueOf(UnsafeComparator.class, r2), UnsafeComparator.class, "com.obric.memorydata.plugin");
            }

            public static UnsafeComparator[] values() {
                return (UnsafeComparator[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), UnsafeComparator[].class, "com.obric.memorydata.plugin");
            }

            @Override // java.util.Comparator
            public /* synthetic */ int compare(byte[] r3, byte[] r4) {
                return compare2((byte[]) ZeusTransformUtils.preCheckCast(r3, byte[].class, "com.obric.memorydata.plugin"), (byte[]) ZeusTransformUtils.preCheckCast(r4, byte[].class, "com.obric.memorydata.plugin"));
            }

            /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
            public int compare2(byte[] r11, byte[] r12) {
                int r10 = Math.min(r11.length, r12.length);
                int r0 = r10 & (-8);
                int r1 = 0;
            L3:
                if (r1 >= r0) goto L13;
                Unsafe r2 = theUnsafe;
                int r3 = BYTE_ARRAY_BASE_OFFSET;
                long r6 = r1;
                long r4 = r2.getLong(r11, ((long) r3) + r6);
                long r5 = r2.getLong(r12, ((long) r3) + r6);
                if (r4 != r5) goto L7;
                r1 = r1 + 8;
                goto L3
            L7:
                if (BIG_ENDIAN == true) goto L9;
                int r13 = Long.numberOfTrailingZeros(r4 ^ r5) & (-8);
                return ((int) ((r4 >>> r13) & 255)) - ((int) (255 & (r5 >>> r13)));
            L9:
                return UnsignedLongs.a(r4, r5);
            L13:
                if (r1 >= r10) goto L19;
                int r7 = UnsignedBytes.a(r11[r1], r12[r1]);
                if (r7 != 0) goto L16;
                r1 = r1 + 1;
                goto L13
            L16:
                return r7;
            L19:
                return r11.length - r12.length;
            }

            @Override // java.lang.Enum
            public String toString() {
                return "UnsignedBytes.lexicographicalComparator() (sun.misc.Unsafe version)";
            }
        }

        static {
            f4763a = LexicographicalComparatorHolder.class.getName() + "$UnsafeComparator";
            f4764b = a();
        }

        LexicographicalComparatorHolder() {
        }

        static Comparator<byte[]> a() {
            return (Comparator) ZeusTransformUtils.preCheckCast(((Object[]) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(ZeusTransformUtils.forName(f4763a, "com.obric.memorydata.plugin").getEnumConstants()), Object[].class, "com.obric.memorydata.plugin"))[0], Comparator.class, "com.obric.memorydata.plugin");
        L6:
            return UnsignedBytes.a();
        }
    }

    public static byte a(long r4) {
        if ((r4 >> 8) != 0) goto L5;
        boolean r0 = true;
    L6:
        n.a(r0, "out of range: %s", r4);
        return (byte) r4;
    L5:
        r0 = false;
        goto L6
    }

    public static int a(byte r0) {
        return r0 & 255;
    }

    public static int a(byte r0, byte r1) {
        return a(r0) - a(r1);
    }

    static Comparator<byte[]> a() {
        return LexicographicalComparatorHolder.PureJavaComparator.INSTANCE;
    }
}
