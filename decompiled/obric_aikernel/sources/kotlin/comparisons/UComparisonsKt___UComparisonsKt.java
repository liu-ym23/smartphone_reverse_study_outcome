package kotlin.comparisons;

import kotlin.ExperimentalUnsignedTypes;
import kotlin.SinceKotlin;
import kotlin.UByteArray;
import kotlin.UIntArray;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.WasExperimental;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
class UComparisonsKt___UComparisonsKt {
    public UComparisonsKt___UComparisonsKt() {
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* JADX INFO: renamed from: maxOf-5PvTz6A, reason: not valid java name */
    public static final short m1223maxOf5PvTz6A(short r10, short r11) {
        if (Intrinsics.compare(r10 & UShort.MAX_VALUE, 65535 & r11) < 0) goto L6;
        return r10;
    L6:
        return r11;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* JADX INFO: renamed from: maxOf-J1ME1BU, reason: not valid java name */
    public static int m1224maxOfJ1ME1BU(int r10, int r11) {
        if (Integer.compareUnsigned(r10, r11) < 0) goto L6;
        return r10;
    L6:
        return r11;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* JADX INFO: renamed from: maxOf-Kr8caGY, reason: not valid java name */
    public static final byte m1225maxOfKr8caGY(byte r10, byte r11) {
        if (Intrinsics.compare(r10 & 255, r11 & 255) < 0) goto L6;
        return r10;
    L6:
        return r11;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: maxOf-Md2H83M, reason: not valid java name */
    public static final int m1226maxOfMd2H83M(int r10, int... r11) {
        Intrinsics.checkNotNullParameter(r11, "other");
        int r12 = UIntArray.m188getSizeimpl(r11);
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        r10 = UComparisonsKt.m1219maxOfJ1ME1BU(r10, UIntArray.m187getpVg5ArA(r11, r13));
        r13 = r13 + 1;
        goto L3
    L5:
        return r10;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: maxOf-R03FKyM, reason: not valid java name */
    public static final long m1227maxOfR03FKyM(long r10, long... r11) {
        Intrinsics.checkNotNullParameter(r11, "other");
        int r12 = ULongArray.m267getSizeimpl(r11);
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        r10 = UComparisonsKt.m1220maxOfeb3DHEI(r10, ULongArray.m266getsVKNKU(r11, r13));
        r13 = r13 + 1;
        goto L3
    L5:
        return r10;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @InlineOnly
    /* JADX INFO: renamed from: maxOf-VKSA0NQ, reason: not valid java name */
    private static final short m1228maxOfVKSA0NQ(short r10, short r11, short r12) {
        return m1223maxOf5PvTz6A(r10, m1223maxOf5PvTz6A(r11, r12));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @InlineOnly
    /* JADX INFO: renamed from: maxOf-WZ9TVnA, reason: not valid java name */
    private static final int m1229maxOfWZ9TVnA(int r10, int r11, int r12) {
        return UComparisonsKt.m1219maxOfJ1ME1BU(r10, UComparisonsKt.m1219maxOfJ1ME1BU(r11, r12));
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: maxOf-Wr6uiD8, reason: not valid java name */
    public static final byte m1230maxOfWr6uiD8(byte r10, byte... r11) {
        Intrinsics.checkNotNullParameter(r11, "other");
        int r12 = UByteArray.m109getSizeimpl(r11);
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        r10 = m1225maxOfKr8caGY(r10, UByteArray.m108getw2LRezQ(r11, r13));
        r13 = r13 + 1;
        goto L3
    L5:
        return r10;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @InlineOnly
    /* JADX INFO: renamed from: maxOf-b33U2AM, reason: not valid java name */
    private static final byte m1231maxOfb33U2AM(byte r10, byte r11, byte r12) {
        return m1225maxOfKr8caGY(r10, m1225maxOfKr8caGY(r11, r12));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* JADX INFO: renamed from: maxOf-eb3DHEI, reason: not valid java name */
    public static long m1232maxOfeb3DHEI(long r10, long r11) {
        if (Long.compareUnsigned(r10, r11) < 0) goto L6;
        return r10;
    L6:
        return r11;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @InlineOnly
    /* JADX INFO: renamed from: maxOf-sambcqE, reason: not valid java name */
    private static final long m1233maxOfsambcqE(long r10, long r11, long r12) {
        return UComparisonsKt.m1220maxOfeb3DHEI(r10, UComparisonsKt.m1220maxOfeb3DHEI(r11, r12));
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: maxOf-t1qELG4, reason: not valid java name */
    public static final short m1234maxOft1qELG4(short r10, short... r11) {
        Intrinsics.checkNotNullParameter(r11, "other");
        int r12 = UShortArray.m372getSizeimpl(r11);
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        r10 = m1223maxOf5PvTz6A(r10, UShortArray.m371getMh2AYeg(r11, r13));
        r13 = r13 + 1;
        goto L3
    L5:
        return r10;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* JADX INFO: renamed from: minOf-5PvTz6A, reason: not valid java name */
    public static final short m1235minOf5PvTz6A(short r10, short r11) {
        if (Intrinsics.compare(r10 & UShort.MAX_VALUE, 65535 & r11) > 0) goto L6;
        return r10;
    L6:
        return r11;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* JADX INFO: renamed from: minOf-J1ME1BU, reason: not valid java name */
    public static int m1236minOfJ1ME1BU(int r10, int r11) {
        if (Integer.compareUnsigned(r10, r11) > 0) goto L6;
        return r10;
    L6:
        return r11;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* JADX INFO: renamed from: minOf-Kr8caGY, reason: not valid java name */
    public static final byte m1237minOfKr8caGY(byte r10, byte r11) {
        if (Intrinsics.compare(r10 & 255, r11 & 255) > 0) goto L6;
        return r10;
    L6:
        return r11;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: minOf-Md2H83M, reason: not valid java name */
    public static final int m1238minOfMd2H83M(int r10, int... r11) {
        Intrinsics.checkNotNullParameter(r11, "other");
        int r12 = UIntArray.m188getSizeimpl(r11);
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        r10 = UComparisonsKt.m1221minOfJ1ME1BU(r10, UIntArray.m187getpVg5ArA(r11, r13));
        r13 = r13 + 1;
        goto L3
    L5:
        return r10;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: minOf-R03FKyM, reason: not valid java name */
    public static final long m1239minOfR03FKyM(long r10, long... r11) {
        Intrinsics.checkNotNullParameter(r11, "other");
        int r12 = ULongArray.m267getSizeimpl(r11);
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        r10 = UComparisonsKt.m1222minOfeb3DHEI(r10, ULongArray.m266getsVKNKU(r11, r13));
        r13 = r13 + 1;
        goto L3
    L5:
        return r10;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @InlineOnly
    /* JADX INFO: renamed from: minOf-VKSA0NQ, reason: not valid java name */
    private static final short m1240minOfVKSA0NQ(short r10, short r11, short r12) {
        return m1235minOf5PvTz6A(r10, m1235minOf5PvTz6A(r11, r12));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @InlineOnly
    /* JADX INFO: renamed from: minOf-WZ9TVnA, reason: not valid java name */
    private static final int m1241minOfWZ9TVnA(int r10, int r11, int r12) {
        return UComparisonsKt.m1221minOfJ1ME1BU(r10, UComparisonsKt.m1221minOfJ1ME1BU(r11, r12));
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: minOf-Wr6uiD8, reason: not valid java name */
    public static final byte m1242minOfWr6uiD8(byte r10, byte... r11) {
        Intrinsics.checkNotNullParameter(r11, "other");
        int r12 = UByteArray.m109getSizeimpl(r11);
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        r10 = m1237minOfKr8caGY(r10, UByteArray.m108getw2LRezQ(r11, r13));
        r13 = r13 + 1;
        goto L3
    L5:
        return r10;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @InlineOnly
    /* JADX INFO: renamed from: minOf-b33U2AM, reason: not valid java name */
    private static final byte m1243minOfb33U2AM(byte r10, byte r11, byte r12) {
        return m1237minOfKr8caGY(r10, m1237minOfKr8caGY(r11, r12));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* JADX INFO: renamed from: minOf-eb3DHEI, reason: not valid java name */
    public static long m1244minOfeb3DHEI(long r10, long r11) {
        if (Long.compareUnsigned(r10, r11) > 0) goto L6;
        return r10;
    L6:
        return r11;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @InlineOnly
    /* JADX INFO: renamed from: minOf-sambcqE, reason: not valid java name */
    private static final long m1245minOfsambcqE(long r10, long r11, long r12) {
        return UComparisonsKt.m1222minOfeb3DHEI(r10, UComparisonsKt.m1222minOfeb3DHEI(r11, r12));
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: minOf-t1qELG4, reason: not valid java name */
    public static final short m1246minOft1qELG4(short r10, short... r11) {
        Intrinsics.checkNotNullParameter(r11, "other");
        int r12 = UShortArray.m372getSizeimpl(r11);
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        r10 = m1235minOf5PvTz6A(r10, UShortArray.m371getMh2AYeg(r11, r13));
        r13 = r13 + 1;
        goto L3
    L5:
        return r10;
    }
}
