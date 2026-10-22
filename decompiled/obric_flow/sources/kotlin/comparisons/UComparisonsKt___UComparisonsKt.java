package kotlin.comparisons;

import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.UIntArray;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.WasExperimental;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0004\u0010\u0005\u001a(\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001H\u0087\b¢\u0006\u0004\b\u0007\u0010\b\u001a#\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\n\u0010\t\u001a\u00020\n\"\u00020\u0001H\u0007¢\u0006\u0004\b\u000b\u0010\f\u001a\u001f\u0010\u0000\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\rH\u0007¢\u0006\u0004\b\u000e\u0010\u000f\u001a(\u0010\u0000\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\rH\u0087\b¢\u0006\u0004\b\u0010\u0010\u0011\u001a#\u0010\u0000\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\r2\n\u0010\t\u001a\u00020\u0012\"\u00020\rH\u0007¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u001f\u0010\u0000\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u0015H\u0007¢\u0006\u0004\b\u0016\u0010\u0017\u001a(\u0010\u0000\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u0015H\u0087\b¢\u0006\u0004\b\u0018\u0010\u0019\u001a#\u0010\u0000\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00152\n\u0010\t\u001a\u00020\u001a\"\u00020\u0015H\u0007¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u001f\u0010\u0000\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u001d2\u0006\u0010\u0003\u001a\u00020\u001dH\u0007¢\u0006\u0004\b\u001e\u0010\u001f\u001a(\u0010\u0000\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u001d2\u0006\u0010\u0003\u001a\u00020\u001d2\u0006\u0010\u0006\u001a\u00020\u001dH\u0087\b¢\u0006\u0004\b \u0010!\u001a#\u0010\u0000\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u001d2\n\u0010\t\u001a\u00020\"\"\u00020\u001dH\u0007¢\u0006\u0004\b#\u0010$\u001a\u001f\u0010%\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0007¢\u0006\u0004\b&\u0010\u0005\u001a(\u0010%\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001H\u0087\b¢\u0006\u0004\b'\u0010\b\u001a#\u0010%\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\n\u0010\t\u001a\u00020\n\"\u00020\u0001H\u0007¢\u0006\u0004\b(\u0010\f\u001a\u001f\u0010%\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\rH\u0007¢\u0006\u0004\b)\u0010\u000f\u001a(\u0010%\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\rH\u0087\b¢\u0006\u0004\b*\u0010\u0011\u001a#\u0010%\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\r2\n\u0010\t\u001a\u00020\u0012\"\u00020\rH\u0007¢\u0006\u0004\b+\u0010\u0014\u001a\u001f\u0010%\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u0015H\u0007¢\u0006\u0004\b,\u0010\u0017\u001a(\u0010%\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u0015H\u0087\b¢\u0006\u0004\b-\u0010\u0019\u001a#\u0010%\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00152\n\u0010\t\u001a\u00020\u001a\"\u00020\u0015H\u0007¢\u0006\u0004\b.\u0010\u001c\u001a\u001f\u0010%\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u001d2\u0006\u0010\u0003\u001a\u00020\u001dH\u0007¢\u0006\u0004\b/\u0010\u001f\u001a(\u0010%\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u001d2\u0006\u0010\u0003\u001a\u00020\u001d2\u0006\u0010\u0006\u001a\u00020\u001dH\u0087\b¢\u0006\u0004\b0\u0010!\u001a#\u0010%\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u001d2\n\u0010\t\u001a\u00020\"\"\u00020\u001dH\u0007¢\u0006\u0004\b1\u0010$¨\u00062"}, d2 = {"maxOf", "Lkotlin/UByte;", "a", "b", "maxOf-Kr8caGY", "(BB)B", "c", "maxOf-b33U2AM", "(BBB)B", "other", "Lkotlin/UByteArray;", "maxOf-Wr6uiD8", "(B[B)B", "Lkotlin/UInt;", "maxOf-J1ME1BU", "(II)I", "maxOf-WZ9TVnA", "(III)I", "Lkotlin/UIntArray;", "maxOf-Md2H83M", "(I[I)I", "Lkotlin/ULong;", "maxOf-eb3DHEI", "(JJ)J", "maxOf-sambcqE", "(JJJ)J", "Lkotlin/ULongArray;", "maxOf-R03FKyM", "(J[J)J", "Lkotlin/UShort;", "maxOf-5PvTz6A", "(SS)S", "maxOf-VKSA0NQ", "(SSS)S", "Lkotlin/UShortArray;", "maxOf-t1qELG4", "(S[S)S", "minOf", "minOf-Kr8caGY", "minOf-b33U2AM", "minOf-Wr6uiD8", "minOf-J1ME1BU", "minOf-WZ9TVnA", "minOf-Md2H83M", "minOf-eb3DHEI", "minOf-sambcqE", "minOf-R03FKyM", "minOf-5PvTz6A", "minOf-VKSA0NQ", "minOf-t1qELG4", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/comparisons/UComparisonsKt")
class UComparisonsKt___UComparisonsKt {
    public UComparisonsKt___UComparisonsKt() {
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* JADX INFO: renamed from: maxOf-5PvTz6A, reason: not valid java name */
    public static final short m1304maxOf5PvTz6A(short r5, short r10) {
        if (Intrinsics.compare(r5 & UShort.MAX_VALUE, 65535 & r10) < 0) goto L6;
        return r5;
    L6:
        return r10;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* JADX INFO: renamed from: maxOf-J1ME1BU, reason: not valid java name */
    public static int m1305maxOfJ1ME1BU(int r5, int r10) {
        if (Integer.compareUnsigned(r5, r10) < 0) goto L6;
        return r5;
    L6:
        return r10;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* JADX INFO: renamed from: maxOf-Kr8caGY, reason: not valid java name */
    public static final byte m1306maxOfKr8caGY(byte r5, byte r10) {
        if (Intrinsics.compare(r5 & UByte.MAX_VALUE, r10 & UByte.MAX_VALUE) < 0) goto L6;
        return r5;
    L6:
        return r10;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: maxOf-Md2H83M, reason: not valid java name */
    public static final int m1307maxOfMd2H83M(int r5, int... r10) {
        Intrinsics.checkNotNullParameter(r10, "other");
        int r11 = UIntArray.m280getSizeimpl(r10);
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        r5 = m1305maxOfJ1ME1BU(r5, UIntArray.m279getpVg5ArA(r10, r12));
        r12 = r12 + 1;
        goto L3
    L5:
        return r5;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: maxOf-R03FKyM, reason: not valid java name */
    public static final long m1308maxOfR03FKyM(long r5, long... r10) {
        Intrinsics.checkNotNullParameter(r10, "other");
        int r11 = ULongArray.m359getSizeimpl(r10);
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        r5 = m1313maxOfeb3DHEI(r5, ULongArray.m358getsVKNKU(r10, r12));
        r12 = r12 + 1;
        goto L3
    L5:
        return r5;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @InlineOnly
    /* JADX INFO: renamed from: maxOf-VKSA0NQ, reason: not valid java name */
    private static final short m1309maxOfVKSA0NQ(short r5, short r10, short r11) {
        return m1304maxOf5PvTz6A(r5, m1304maxOf5PvTz6A(r10, r11));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @InlineOnly
    /* JADX INFO: renamed from: maxOf-WZ9TVnA, reason: not valid java name */
    private static final int m1310maxOfWZ9TVnA(int r5, int r10, int r11) {
        return m1305maxOfJ1ME1BU(r5, m1305maxOfJ1ME1BU(r10, r11));
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: maxOf-Wr6uiD8, reason: not valid java name */
    public static final byte m1311maxOfWr6uiD8(byte r5, byte... r10) {
        Intrinsics.checkNotNullParameter(r10, "other");
        int r11 = UByteArray.m201getSizeimpl(r10);
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        r5 = m1306maxOfKr8caGY(r5, UByteArray.m200getw2LRezQ(r10, r12));
        r12 = r12 + 1;
        goto L3
    L5:
        return r5;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @InlineOnly
    /* JADX INFO: renamed from: maxOf-b33U2AM, reason: not valid java name */
    private static final byte m1312maxOfb33U2AM(byte r5, byte r10, byte r11) {
        return m1306maxOfKr8caGY(r5, m1306maxOfKr8caGY(r10, r11));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* JADX INFO: renamed from: maxOf-eb3DHEI, reason: not valid java name */
    public static long m1313maxOfeb3DHEI(long r5, long r10) {
        if (Long.compareUnsigned(r5, r10) < 0) goto L6;
        return r5;
    L6:
        return r10;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @InlineOnly
    /* JADX INFO: renamed from: maxOf-sambcqE, reason: not valid java name */
    private static final long m1314maxOfsambcqE(long r5, long r10, long r11) {
        return m1313maxOfeb3DHEI(r5, m1313maxOfeb3DHEI(r10, r11));
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: maxOf-t1qELG4, reason: not valid java name */
    public static final short m1315maxOft1qELG4(short r5, short... r10) {
        Intrinsics.checkNotNullParameter(r10, "other");
        int r11 = UShortArray.m464getSizeimpl(r10);
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        r5 = m1304maxOf5PvTz6A(r5, UShortArray.m463getMh2AYeg(r10, r12));
        r12 = r12 + 1;
        goto L3
    L5:
        return r5;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* JADX INFO: renamed from: minOf-5PvTz6A, reason: not valid java name */
    public static final short m1316minOf5PvTz6A(short r5, short r10) {
        if (Intrinsics.compare(r5 & UShort.MAX_VALUE, 65535 & r10) > 0) goto L6;
        return r5;
    L6:
        return r10;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* JADX INFO: renamed from: minOf-J1ME1BU, reason: not valid java name */
    public static int m1317minOfJ1ME1BU(int r5, int r10) {
        if (Integer.compareUnsigned(r5, r10) > 0) goto L6;
        return r5;
    L6:
        return r10;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* JADX INFO: renamed from: minOf-Kr8caGY, reason: not valid java name */
    public static final byte m1318minOfKr8caGY(byte r5, byte r10) {
        if (Intrinsics.compare(r5 & UByte.MAX_VALUE, r10 & UByte.MAX_VALUE) > 0) goto L6;
        return r5;
    L6:
        return r10;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: minOf-Md2H83M, reason: not valid java name */
    public static final int m1319minOfMd2H83M(int r5, int... r10) {
        Intrinsics.checkNotNullParameter(r10, "other");
        int r11 = UIntArray.m280getSizeimpl(r10);
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        r5 = m1317minOfJ1ME1BU(r5, UIntArray.m279getpVg5ArA(r10, r12));
        r12 = r12 + 1;
        goto L3
    L5:
        return r5;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: minOf-R03FKyM, reason: not valid java name */
    public static final long m1320minOfR03FKyM(long r5, long... r10) {
        Intrinsics.checkNotNullParameter(r10, "other");
        int r11 = ULongArray.m359getSizeimpl(r10);
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        r5 = m1325minOfeb3DHEI(r5, ULongArray.m358getsVKNKU(r10, r12));
        r12 = r12 + 1;
        goto L3
    L5:
        return r5;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @InlineOnly
    /* JADX INFO: renamed from: minOf-VKSA0NQ, reason: not valid java name */
    private static final short m1321minOfVKSA0NQ(short r5, short r10, short r11) {
        return m1316minOf5PvTz6A(r5, m1316minOf5PvTz6A(r10, r11));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @InlineOnly
    /* JADX INFO: renamed from: minOf-WZ9TVnA, reason: not valid java name */
    private static final int m1322minOfWZ9TVnA(int r5, int r10, int r11) {
        return m1317minOfJ1ME1BU(r5, m1317minOfJ1ME1BU(r10, r11));
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: minOf-Wr6uiD8, reason: not valid java name */
    public static final byte m1323minOfWr6uiD8(byte r5, byte... r10) {
        Intrinsics.checkNotNullParameter(r10, "other");
        int r11 = UByteArray.m201getSizeimpl(r10);
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        r5 = m1318minOfKr8caGY(r5, UByteArray.m200getw2LRezQ(r10, r12));
        r12 = r12 + 1;
        goto L3
    L5:
        return r5;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @InlineOnly
    /* JADX INFO: renamed from: minOf-b33U2AM, reason: not valid java name */
    private static final byte m1324minOfb33U2AM(byte r5, byte r10, byte r11) {
        return m1318minOfKr8caGY(r5, m1318minOfKr8caGY(r10, r11));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* JADX INFO: renamed from: minOf-eb3DHEI, reason: not valid java name */
    public static long m1325minOfeb3DHEI(long r5, long r10) {
        if (Long.compareUnsigned(r5, r10) > 0) goto L6;
        return r5;
    L6:
        return r10;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @InlineOnly
    /* JADX INFO: renamed from: minOf-sambcqE, reason: not valid java name */
    private static final long m1326minOfsambcqE(long r5, long r10, long r11) {
        return m1325minOfeb3DHEI(r5, m1325minOfeb3DHEI(r10, r11));
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: minOf-t1qELG4, reason: not valid java name */
    public static final short m1327minOft1qELG4(short r5, short... r10) {
        Intrinsics.checkNotNullParameter(r10, "other");
        int r11 = UShortArray.m464getSizeimpl(r10);
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        r5 = m1316minOf5PvTz6A(r5, UShortArray.m463getMh2AYeg(r10, r12));
        r12 = r12 + 1;
        goto L3
    L5:
        return r5;
    }
}
