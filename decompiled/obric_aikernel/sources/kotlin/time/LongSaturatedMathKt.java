package kotlin.time;

import com.bytedance.crash.dumper.Scraps;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nlongSaturatedMath.kt\nKotlin\n*S Kotlin\n*F\n+ 1 longSaturatedMath.kt\nkotlin/time/LongSaturatedMathKt\n*L\n1#1,81:1\n80#1:82\n80#1:83\n80#1:84\n80#1:85\n80#1:86\n80#1:87\n*S KotlinDebug\n*F\n+ 1 longSaturatedMath.kt\nkotlin/time/LongSaturatedMathKt\n*L\n14#1:82\n17#1:83\n36#1:84\n46#1:85\n53#1:86\n57#1:87\n*E\n"})
public final class LongSaturatedMathKt {
    /* JADX INFO: renamed from: checkInfiniteSumDefined-PjuGub4, reason: not valid java name */
    private static final long m1512checkInfiniteSumDefinedPjuGub4(long r10, long r11, long r12) {
        if (Duration.m1416isInfiniteimpl(r11) == true) goto L5;
    L9:
        return r10;
    L5:
        if ((r10 ^ r12) >= 0) goto L9;
        throw new IllegalArgumentException("Summing infinities of different signs");
    }

    private static final long infinityOfSign(long r10) {
        if (r10 >= 0) goto L6;
        return Duration.Companion.m1486getNEG_INFINITEUwyO8pc$kotlin_stdlib();
    L6:
        return Duration.Companion.m1485getINFINITEUwyO8pc();
    }

    public static final boolean isSaturated(long r10) {
        if (((r10 - 1) | 1) != Long.MAX_VALUE) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: saturatingAdd-NuflL3o, reason: not valid java name */
    public static final long m1513saturatingAddNuflL3o(long r11, DurationUnit r13, long r14) {
        Intrinsics.checkNotNullParameter(r13, Scraps.INNER_UNIT);
        long r10 = Duration.m1430toLongimpl(r14, r13);
        boolean r12 = true;
        if (((r11 - 1) | 1) != Long.MAX_VALUE) goto L5;
        boolean r15 = true;
    L6:
        if (r15 == false) goto L10;
        return m1512checkInfiniteSumDefinedPjuGub4(r11, r14, r10);
    L10:
        if ((1 | (r10 - 1)) == Long.MAX_VALUE) goto L13;
        r12 = false;
    L13:
        if (r12 == true) goto L15;
        long r16 = r11 + r10;
        if (((r11 ^ r16) & (r10 ^ r16)) < 0) goto L19;
        return r16;
    L19:
        if (r11 >= 0) goto L23;
        return Long.MIN_VALUE;
    L23:
        return Long.MAX_VALUE;
    L15:
        return m1514saturatingAddInHalvesNuflL3o(r11, r13, r14);
    L5:
        r15 = false;
        goto L6
    }

    /* JADX INFO: renamed from: saturatingAddInHalves-NuflL3o, reason: not valid java name */
    private static final long m1514saturatingAddInHalvesNuflL3o(long r10, DurationUnit r11, long r12) {
        long r13 = Duration.m1387divUwyO8pc(r12, 2);
        long r14 = Duration.m1430toLongimpl(r13, r11);
        if ((1 | (r14 - 1)) != Long.MAX_VALUE) goto L5;
        boolean r15 = true;
    L6:
        if (r15 == false) goto L9;
        return r14;
    L9:
        return m1513saturatingAddNuflL3o(m1513saturatingAddNuflL3o(r10, r11, r13), r11, Duration.m1419minusLRDsOJo(r12, r13));
    L5:
        r15 = false;
        goto L6
    }

    public static final long saturatingDiff(long r10, long r11, DurationUnit r12) {
        Intrinsics.checkNotNullParameter(r12, Scraps.INNER_UNIT);
        if ((1 | (r11 - 1)) != Long.MAX_VALUE) goto L5;
        boolean r13 = true;
    L6:
        if (r13 == false) goto L10;
        return Duration.m1437unaryMinusUwyO8pc(infinityOfSign(r11));
    L10:
        return saturatingFiniteDiff(r10, r11, r12);
    L5:
        r13 = false;
        goto L6
    }

    private static final long saturatingFiniteDiff(long r10, long r11, DurationUnit r12) {
        long r13 = r10 - r11;
        if (((r13 ^ r10) & (~(r13 ^ r11))) >= 0) goto L11;
        DurationUnit r14 = DurationUnit.MILLISECONDS;
        if (r12.compareTo(r14) >= 0) goto L9;
        long r15 = DurationUnitKt__DurationUnitJvmKt.convertDurationUnit(1, r14, r12);
        long r16 = (r10 / r15) - (r11 / r15);
        long r17 = (r10 % r15) - (r11 % r15);
        Duration.Companion r18 = Duration.Companion;
        return Duration.m1420plusLRDsOJo(DurationKt.toDuration(r16, r14), DurationKt.toDuration(r17, r12));
    L9:
        return Duration.m1437unaryMinusUwyO8pc(infinityOfSign(r13));
    L11:
        return DurationKt.toDuration(r13, r12);
    }

    public static final long saturatingOriginsDiff(long r10, long r11, DurationUnit r13) {
        Intrinsics.checkNotNullParameter(r13, Scraps.INNER_UNIT);
        boolean r12 = true;
        if (((r11 - 1) | 1) != Long.MAX_VALUE) goto L5;
        boolean r14 = true;
    L6:
        if (r14 == false) goto L14;
        if (r10 != r11) goto L12;
        return Duration.Companion.m1487getZEROUwyO8pc();
    L12:
        return Duration.m1437unaryMinusUwyO8pc(infinityOfSign(r11));
    L14:
        if ((1 | (r10 - 1)) == Long.MAX_VALUE) goto L17;
        r12 = false;
    L17:
        if (r12 == false) goto L21;
        return infinityOfSign(r10);
    L21:
        return saturatingFiniteDiff(r10, r11, r13);
    L5:
        r14 = false;
        goto L6
    }
}
