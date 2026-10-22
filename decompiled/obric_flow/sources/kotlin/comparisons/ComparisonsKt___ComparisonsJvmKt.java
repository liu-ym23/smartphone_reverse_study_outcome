package kotlin.comparisons;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000F\n\u0002\b\u0002\n\u0002\u0010\u000f\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0005\n\u0002\u0010\u0012\n\u0002\u0010\u0006\n\u0002\u0010\u0013\n\u0002\u0010\u0007\n\u0002\u0010\u0014\n\u0002\u0010\b\n\u0002\u0010\u0015\n\u0002\u0010\t\n\u0002\u0010\u0016\n\u0002\u0010\n\n\u0002\u0010\u0017\n\u0002\b\u0002\u001a-\u0010\u0000\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010\u0003\u001a\u0002H\u00012\u0006\u0010\u0004\u001a\u0002H\u0001H\u0007¢\u0006\u0002\u0010\u0005\u001a5\u0010\u0000\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010\u0003\u001a\u0002H\u00012\u0006\u0010\u0004\u001a\u0002H\u00012\u0006\u0010\u0006\u001a\u0002H\u0001H\u0007¢\u0006\u0002\u0010\u0007\u001a9\u0010\u0000\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010\u0003\u001a\u0002H\u00012\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00010\t\"\u0002H\u0001H\u0007¢\u0006\u0002\u0010\n\u001a\u0019\u0010\u0000\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u000bH\u0087\b\u001a!\u0010\u0000\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u000bH\u0087\b\u001a\u001c\u0010\u0000\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u000b2\n\u0010\b\u001a\u00020\f\"\u00020\u000bH\u0007\u001a\u0019\u0010\u0000\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\rH\u0087\b\u001a!\u0010\u0000\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\rH\u0087\b\u001a\u001c\u0010\u0000\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r2\n\u0010\b\u001a\u00020\u000e\"\u00020\rH\u0007\u001a\u0019\u0010\u0000\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u000fH\u0087\b\u001a!\u0010\u0000\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u000fH\u0087\b\u001a\u001c\u0010\u0000\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u000f2\n\u0010\b\u001a\u00020\u0010\"\u00020\u000fH\u0007\u001a\u0019\u0010\u0000\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u0011H\u0087\b\u001a!\u0010\u0000\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u0011H\u0087\b\u001a\u001c\u0010\u0000\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00112\n\u0010\b\u001a\u00020\u0012\"\u00020\u0011H\u0007\u001a\u0019\u0010\u0000\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u0013H\u0087\b\u001a!\u0010\u0000\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u0013H\u0087\b\u001a\u001c\u0010\u0000\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00132\n\u0010\b\u001a\u00020\u0014\"\u00020\u0013H\u0007\u001a\u0019\u0010\u0000\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u0015H\u0087\b\u001a!\u0010\u0000\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u0015H\u0087\b\u001a\u001c\u0010\u0000\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00152\n\u0010\b\u001a\u00020\u0016\"\u00020\u0015H\u0007\u001a-\u0010\u0017\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010\u0003\u001a\u0002H\u00012\u0006\u0010\u0004\u001a\u0002H\u0001H\u0007¢\u0006\u0002\u0010\u0005\u001a5\u0010\u0017\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010\u0003\u001a\u0002H\u00012\u0006\u0010\u0004\u001a\u0002H\u00012\u0006\u0010\u0006\u001a\u0002H\u0001H\u0007¢\u0006\u0002\u0010\u0007\u001a9\u0010\u0017\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010\u0003\u001a\u0002H\u00012\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00010\t\"\u0002H\u0001H\u0007¢\u0006\u0002\u0010\n\u001a\u0019\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u000bH\u0087\b\u001a!\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u000bH\u0087\b\u001a\u001c\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u000b2\n\u0010\b\u001a\u00020\f\"\u00020\u000bH\u0007\u001a\u0019\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\rH\u0087\b\u001a!\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\rH\u0087\b\u001a\u001c\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r2\n\u0010\b\u001a\u00020\u000e\"\u00020\rH\u0007\u001a\u0019\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u000fH\u0087\b\u001a!\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u000fH\u0087\b\u001a\u001c\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u000f2\n\u0010\b\u001a\u00020\u0010\"\u00020\u000fH\u0007\u001a\u0019\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u0011H\u0087\b\u001a!\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u0011H\u0087\b\u001a\u001c\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00112\n\u0010\b\u001a\u00020\u0012\"\u00020\u0011H\u0007\u001a\u0019\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u0013H\u0087\b\u001a!\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u0013H\u0087\b\u001a\u001c\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00132\n\u0010\b\u001a\u00020\u0014\"\u00020\u0013H\u0007\u001a\u0019\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u0015H\u0087\b\u001a!\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u0015H\u0087\b\u001a\u001c\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00152\n\u0010\b\u001a\u00020\u0016\"\u00020\u0015H\u0007¨\u0006\u0018"}, d2 = {"maxOf", ExifInterface.GPS_DIRECTION_TRUE, "", "a", "b", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)Ljava/lang/Comparable;", "c", "(Ljava/lang/Comparable;Ljava/lang/Comparable;Ljava/lang/Comparable;)Ljava/lang/Comparable;", "other", "", "(Ljava/lang/Comparable;[Ljava/lang/Comparable;)Ljava/lang/Comparable;", "", "", "", "", "", "", "", "", "", "", "", "", "minOf", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/comparisons/ComparisonsKt")
class ComparisonsKt___ComparisonsJvmKt extends ComparisonsKt__ComparisonsKt {
    public ComparisonsKt___ComparisonsJvmKt() {
    }

    @SinceKotlin(version = "1.1")
    public static <T extends Comparable<? super T>> T maxOf(T r5, T r10) {
        Intrinsics.checkNotNullParameter(r5, "a");
        Intrinsics.checkNotNullParameter(r10, "b");
        if (r5.compareTo(r10) < 0) goto L6;
        return r5;
    L6:
        return r10;
    }

    @SinceKotlin(version = "1.1")
    public static final <T extends Comparable<? super T>> T minOf(T r5, T r10) {
        Intrinsics.checkNotNullParameter(r5, "a");
        Intrinsics.checkNotNullParameter(r10, "b");
        if (r5.compareTo(r10) > 0) goto L6;
        return r5;
    L6:
        return r10;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final byte maxOf(byte r5, byte r10) {
        return (byte) Math.max(r5, r10);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final byte minOf(byte r5, byte r10) {
        return (byte) Math.min(r5, r10);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final short maxOf(short r5, short r10) {
        return (short) Math.max(r5, r10);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final short minOf(short r5, short r10) {
        return (short) Math.min(r5, r10);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final int maxOf(int r5, int r10) {
        return Math.max(r5, r10);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final int minOf(int r5, int r10) {
        return Math.min(r5, r10);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final long maxOf(long r5, long r10) {
        return Math.max(r5, r10);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final long minOf(long r5, long r10) {
        return Math.min(r5, r10);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final float maxOf(float r5, float r10) {
        return Math.max(r5, r10);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final float minOf(float r5, float r10) {
        return Math.min(r5, r10);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final double maxOf(double r5, double r10) {
        return Math.max(r5, r10);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final double minOf(double r5, double r10) {
        return Math.min(r5, r10);
    }

    @SinceKotlin(version = "1.1")
    public static final <T extends Comparable<? super T>> T maxOf(T r5, T r10, T r11) {
        Intrinsics.checkNotNullParameter(r5, "a");
        Intrinsics.checkNotNullParameter(r10, "b");
        Intrinsics.checkNotNullParameter(r11, "c");
        return (T) maxOf(r5, maxOf(r10, r11));
    }

    @SinceKotlin(version = "1.1")
    public static final <T extends Comparable<? super T>> T minOf(T r5, T r10, T r11) {
        Intrinsics.checkNotNullParameter(r5, "a");
        Intrinsics.checkNotNullParameter(r10, "b");
        Intrinsics.checkNotNullParameter(r11, "c");
        return (T) minOf(r5, minOf(r10, r11));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final byte maxOf(byte r5, byte r10, byte r11) {
        return (byte) Math.max(r5, Math.max(r10, r11));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final byte minOf(byte r5, byte r10, byte r11) {
        return (byte) Math.min(r5, Math.min(r10, r11));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final short maxOf(short r5, short r10, short r11) {
        return (short) Math.max(r5, Math.max(r10, r11));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final short minOf(short r5, short r10, short r11) {
        return (short) Math.min(r5, Math.min(r10, r11));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final int maxOf(int r5, int r10, int r11) {
        return Math.max(r5, Math.max(r10, r11));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final int minOf(int r5, int r10, int r11) {
        return Math.min(r5, Math.min(r10, r11));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final long maxOf(long r5, long r10, long r11) {
        return Math.max(r5, Math.max(r10, r11));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final long minOf(long r5, long r10, long r11) {
        return Math.min(r5, Math.min(r10, r11));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final float maxOf(float r5, float r10, float r11) {
        return Math.max(r5, Math.max(r10, r11));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final float minOf(float r5, float r10, float r11) {
        return Math.min(r5, Math.min(r10, r11));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final double maxOf(double r5, double r10, double r11) {
        return Math.max(r5, Math.max(r10, r11));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final double minOf(double r5, double r10, double r11) {
        return Math.min(r5, Math.min(r10, r11));
    }

    @SinceKotlin(version = "1.4")
    public static final <T extends Comparable<? super T>> T maxOf(T r5, T... r10) {
        Intrinsics.checkNotNullParameter(r5, "a");
        Intrinsics.checkNotNullParameter(r10, "other");
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        T r13 = r5;
        r5 = (T) maxOf(r13, r10[r12]);
        r12 = r12 + 1;
        goto L3
    L5:
        return r5;
    }

    @SinceKotlin(version = "1.4")
    public static final <T extends Comparable<? super T>> T minOf(T r5, T... r10) {
        Intrinsics.checkNotNullParameter(r5, "a");
        Intrinsics.checkNotNullParameter(r10, "other");
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        T r13 = r5;
        r5 = (T) minOf(r13, r10[r12]);
        r12 = r12 + 1;
        goto L3
    L5:
        return r5;
    }

    @SinceKotlin(version = "1.4")
    public static final byte maxOf(byte r5, byte... r10) {
        Intrinsics.checkNotNullParameter(r10, "other");
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        r5 = (byte) Math.max(r5, r10[r12]);
        r12 = r12 + 1;
        goto L3
    L5:
        return r5;
    }

    @SinceKotlin(version = "1.4")
    public static final byte minOf(byte r5, byte... r10) {
        Intrinsics.checkNotNullParameter(r10, "other");
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        r5 = (byte) Math.min(r5, r10[r12]);
        r12 = r12 + 1;
        goto L3
    L5:
        return r5;
    }

    @SinceKotlin(version = "1.4")
    public static final short maxOf(short r5, short... r10) {
        Intrinsics.checkNotNullParameter(r10, "other");
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        r5 = (short) Math.max(r5, r10[r12]);
        r12 = r12 + 1;
        goto L3
    L5:
        return r5;
    }

    @SinceKotlin(version = "1.4")
    public static final short minOf(short r5, short... r10) {
        Intrinsics.checkNotNullParameter(r10, "other");
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        r5 = (short) Math.min(r5, r10[r12]);
        r12 = r12 + 1;
        goto L3
    L5:
        return r5;
    }

    @SinceKotlin(version = "1.4")
    public static final int maxOf(int r5, int... r10) {
        Intrinsics.checkNotNullParameter(r10, "other");
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        r5 = Math.max(r5, r10[r12]);
        r12 = r12 + 1;
        goto L3
    L5:
        return r5;
    }

    @SinceKotlin(version = "1.4")
    public static final int minOf(int r5, int... r10) {
        Intrinsics.checkNotNullParameter(r10, "other");
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        r5 = Math.min(r5, r10[r12]);
        r12 = r12 + 1;
        goto L3
    L5:
        return r5;
    }

    @SinceKotlin(version = "1.4")
    public static final long maxOf(long r5, long... r10) {
        Intrinsics.checkNotNullParameter(r10, "other");
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        r5 = Math.max(r5, r10[r12]);
        r12 = r12 + 1;
        goto L3
    L5:
        return r5;
    }

    @SinceKotlin(version = "1.4")
    public static final long minOf(long r5, long... r10) {
        Intrinsics.checkNotNullParameter(r10, "other");
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        r5 = Math.min(r5, r10[r12]);
        r12 = r12 + 1;
        goto L3
    L5:
        return r5;
    }

    @SinceKotlin(version = "1.4")
    public static final float maxOf(float r5, float... r10) {
        Intrinsics.checkNotNullParameter(r10, "other");
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        r5 = Math.max(r5, r10[r12]);
        r12 = r12 + 1;
        goto L3
    L5:
        return r5;
    }

    @SinceKotlin(version = "1.4")
    public static final float minOf(float r5, float... r10) {
        Intrinsics.checkNotNullParameter(r10, "other");
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        r5 = Math.min(r5, r10[r12]);
        r12 = r12 + 1;
        goto L3
    L5:
        return r5;
    }

    @SinceKotlin(version = "1.4")
    public static final double maxOf(double r5, double... r10) {
        Intrinsics.checkNotNullParameter(r10, "other");
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        r5 = Math.max(r5, r10[r12]);
        r12 = r12 + 1;
        goto L3
    L5:
        return r5;
    }

    @SinceKotlin(version = "1.4")
    public static final double minOf(double r5, double... r10) {
        Intrinsics.checkNotNullParameter(r10, "other");
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        r5 = Math.min(r5, r10[r12]);
        r12 = r12 + 1;
        goto L3
    L5:
        return r5;
    }
}
