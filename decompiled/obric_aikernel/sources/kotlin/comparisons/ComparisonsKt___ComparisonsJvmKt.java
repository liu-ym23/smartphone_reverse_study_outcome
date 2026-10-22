package kotlin.comparisons;

import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
class ComparisonsKt___ComparisonsJvmKt extends ComparisonsKt__ComparisonsKt {
    public ComparisonsKt___ComparisonsJvmKt() {
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final byte maxOf(byte r10, byte r11) {
        return (byte) Math.max(r10, r11);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final byte maxOf(byte r10, byte r11, byte r12) {
        return (byte) Math.max(r10, Math.max(r11, r12));
    }

    @SinceKotlin(version = "1.4")
    public static final byte maxOf(byte r10, byte... r11) {
        Intrinsics.checkNotNullParameter(r11, "other");
        int r12 = r11.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        r10 = (byte) Math.max(r10, r11[r13]);
        r13 = r13 + 1;
        goto L3
    L5:
        return r10;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final double maxOf(double r10, double r11) {
        return Math.max(r10, r11);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final double maxOf(double r10, double r11, double r12) {
        return Math.max(r10, Math.max(r11, r12));
    }

    @SinceKotlin(version = "1.4")
    public static final double maxOf(double r10, double... r11) {
        Intrinsics.checkNotNullParameter(r11, "other");
        int r12 = r11.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        r10 = Math.max(r10, r11[r13]);
        r13 = r13 + 1;
        goto L3
    L5:
        return r10;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final float maxOf(float r10, float r11) {
        return Math.max(r10, r11);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final float maxOf(float r10, float r11, float r12) {
        return Math.max(r10, Math.max(r11, r12));
    }

    @SinceKotlin(version = "1.4")
    public static final float maxOf(float r10, float... r11) {
        Intrinsics.checkNotNullParameter(r11, "other");
        int r12 = r11.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        r10 = Math.max(r10, r11[r13]);
        r13 = r13 + 1;
        goto L3
    L5:
        return r10;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final int maxOf(int r10, int r11) {
        return Math.max(r10, r11);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final int maxOf(int r10, int r11, int r12) {
        return Math.max(r10, Math.max(r11, r12));
    }

    @SinceKotlin(version = "1.4")
    public static final int maxOf(int r10, int... r11) {
        Intrinsics.checkNotNullParameter(r11, "other");
        int r12 = r11.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        r10 = Math.max(r10, r11[r13]);
        r13 = r13 + 1;
        goto L3
    L5:
        return r10;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final long maxOf(long r10, long r11) {
        return Math.max(r10, r11);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final long maxOf(long r10, long r11, long r12) {
        return Math.max(r10, Math.max(r11, r12));
    }

    @SinceKotlin(version = "1.4")
    public static final long maxOf(long r10, long... r11) {
        Intrinsics.checkNotNullParameter(r11, "other");
        int r12 = r11.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        r10 = Math.max(r10, r11[r13]);
        r13 = r13 + 1;
        goto L3
    L5:
        return r10;
    }

    @SinceKotlin(version = "1.1")
    public static <T extends Comparable<? super T>> T maxOf(T r10, T r11) {
        Intrinsics.checkNotNullParameter(r10, "a");
        Intrinsics.checkNotNullParameter(r11, "b");
        if (r10.compareTo(r11) < 0) goto L6;
        return r10;
    L6:
        return r11;
    }

    @SinceKotlin(version = "1.1")
    public static final <T extends Comparable<? super T>> T maxOf(T r10, T r11, T r12) {
        Intrinsics.checkNotNullParameter(r10, "a");
        Intrinsics.checkNotNullParameter(r11, "b");
        Intrinsics.checkNotNullParameter(r12, "c");
        return (T) ComparisonsKt.maxOf(r10, ComparisonsKt.maxOf(r11, r12));
    }

    @SinceKotlin(version = "1.4")
    public static final <T extends Comparable<? super T>> T maxOf(T r10, T... r11) {
        Intrinsics.checkNotNullParameter(r10, "a");
        Intrinsics.checkNotNullParameter(r11, "other");
        int r12 = r11.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        T r14 = r10;
        r10 = (T) ComparisonsKt.maxOf(r14, r11[r13]);
        r13 = r13 + 1;
        goto L3
    L5:
        return r10;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final short maxOf(short r10, short r11) {
        return (short) Math.max(r10, r11);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final short maxOf(short r10, short r11, short r12) {
        return (short) Math.max(r10, Math.max(r11, r12));
    }

    @SinceKotlin(version = "1.4")
    public static final short maxOf(short r10, short... r11) {
        Intrinsics.checkNotNullParameter(r11, "other");
        int r12 = r11.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        r10 = (short) Math.max(r10, r11[r13]);
        r13 = r13 + 1;
        goto L3
    L5:
        return r10;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final byte minOf(byte r10, byte r11) {
        return (byte) Math.min(r10, r11);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final byte minOf(byte r10, byte r11, byte r12) {
        return (byte) Math.min(r10, Math.min(r11, r12));
    }

    @SinceKotlin(version = "1.4")
    public static final byte minOf(byte r10, byte... r11) {
        Intrinsics.checkNotNullParameter(r11, "other");
        int r12 = r11.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        r10 = (byte) Math.min(r10, r11[r13]);
        r13 = r13 + 1;
        goto L3
    L5:
        return r10;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final double minOf(double r10, double r11) {
        return Math.min(r10, r11);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final double minOf(double r10, double r11, double r12) {
        return Math.min(r10, Math.min(r11, r12));
    }

    @SinceKotlin(version = "1.4")
    public static final double minOf(double r10, double... r11) {
        Intrinsics.checkNotNullParameter(r11, "other");
        int r12 = r11.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        r10 = Math.min(r10, r11[r13]);
        r13 = r13 + 1;
        goto L3
    L5:
        return r10;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final float minOf(float r10, float r11) {
        return Math.min(r10, r11);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final float minOf(float r10, float r11, float r12) {
        return Math.min(r10, Math.min(r11, r12));
    }

    @SinceKotlin(version = "1.4")
    public static final float minOf(float r10, float... r11) {
        Intrinsics.checkNotNullParameter(r11, "other");
        int r12 = r11.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        r10 = Math.min(r10, r11[r13]);
        r13 = r13 + 1;
        goto L3
    L5:
        return r10;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final int minOf(int r10, int r11) {
        return Math.min(r10, r11);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final int minOf(int r10, int r11, int r12) {
        return Math.min(r10, Math.min(r11, r12));
    }

    @SinceKotlin(version = "1.4")
    public static final int minOf(int r10, int... r11) {
        Intrinsics.checkNotNullParameter(r11, "other");
        int r12 = r11.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        r10 = Math.min(r10, r11[r13]);
        r13 = r13 + 1;
        goto L3
    L5:
        return r10;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final long minOf(long r10, long r11) {
        return Math.min(r10, r11);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final long minOf(long r10, long r11, long r12) {
        return Math.min(r10, Math.min(r11, r12));
    }

    @SinceKotlin(version = "1.4")
    public static final long minOf(long r10, long... r11) {
        Intrinsics.checkNotNullParameter(r11, "other");
        int r12 = r11.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        r10 = Math.min(r10, r11[r13]);
        r13 = r13 + 1;
        goto L3
    L5:
        return r10;
    }

    @SinceKotlin(version = "1.1")
    public static final <T extends Comparable<? super T>> T minOf(T r10, T r11) {
        Intrinsics.checkNotNullParameter(r10, "a");
        Intrinsics.checkNotNullParameter(r11, "b");
        if (r10.compareTo(r11) > 0) goto L6;
        return r10;
    L6:
        return r11;
    }

    @SinceKotlin(version = "1.1")
    public static final <T extends Comparable<? super T>> T minOf(T r10, T r11, T r12) {
        Intrinsics.checkNotNullParameter(r10, "a");
        Intrinsics.checkNotNullParameter(r11, "b");
        Intrinsics.checkNotNullParameter(r12, "c");
        return (T) minOf(r10, minOf(r11, r12));
    }

    @SinceKotlin(version = "1.4")
    public static final <T extends Comparable<? super T>> T minOf(T r10, T... r11) {
        Intrinsics.checkNotNullParameter(r10, "a");
        Intrinsics.checkNotNullParameter(r11, "other");
        int r12 = r11.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        T r14 = r10;
        r10 = (T) minOf(r14, r11[r13]);
        r13 = r13 + 1;
        goto L3
    L5:
        return r10;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final short minOf(short r10, short r11) {
        return (short) Math.min(r10, r11);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final short minOf(short r10, short r11, short r12) {
        return (short) Math.min(r10, Math.min(r11, r12));
    }

    @SinceKotlin(version = "1.4")
    public static final short minOf(short r10, short... r11) {
        Intrinsics.checkNotNullParameter(r11, "other");
        int r12 = r11.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        r10 = (short) Math.min(r10, r11[r13]);
        r13 = r13 + 1;
        goto L3
    L5:
        return r10;
    }
}
