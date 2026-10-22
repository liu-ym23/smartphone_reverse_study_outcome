package kotlin.time;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0015\u0010\b\u001a\u00020\u00042\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0002\u0010\t\u001a'\u0010\n\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a'\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0010\u0010\u000e\u001a%\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\fH\u0000¢\u0006\u0002\u0010\u0014\u001a%\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\fH\u0002¢\u0006\u0002\u0010\u0014\u001a%\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\fH\u0000¢\u0006\u0002\u0010\u0014\u001a\r\u0010\u001b\u001a\u00020\u001c*\u00020\u0001H\u0080\b¨\u0006\u001d"}, d2 = {"checkInfiniteSumDefined", "", "value", "duration", "Lkotlin/time/Duration;", "durationInUnit", "checkInfiniteSumDefined-PjuGub4", "(JJJ)J", "infinityOfSign", "(J)J", "saturatingAdd", "unit", "Lkotlin/time/DurationUnit;", "saturatingAdd-NuflL3o", "(JLkotlin/time/DurationUnit;J)J", "saturatingAddInHalves", "saturatingAddInHalves-NuflL3o", "saturatingDiff", "valueNs", "origin", "(JJLkotlin/time/DurationUnit;)J", "saturatingFiniteDiff", "value1", "value2", "saturatingOriginsDiff", "origin1", "origin2", "isSaturated", "", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nlongSaturatedMath.kt\nKotlin\n*S Kotlin\n*F\n+ 1 longSaturatedMath.kt\nkotlin/time/LongSaturatedMathKt\n*L\n1#1,81:1\n80#1:82\n80#1:83\n80#1:84\n80#1:85\n80#1:86\n80#1:87\n*S KotlinDebug\n*F\n+ 1 longSaturatedMath.kt\nkotlin/time/LongSaturatedMathKt\n*L\n14#1:82\n17#1:83\n36#1:84\n46#1:85\n53#1:86\n57#1:87\n*E\n"})
public final class LongSaturatedMathKt {
    /* JADX INFO: renamed from: checkInfiniteSumDefined-PjuGub4, reason: not valid java name */
    private static final long m1591checkInfiniteSumDefinedPjuGub4(long r5, long r10, long r11) {
        if (Duration.m1495isInfiniteimpl(r10) == true) goto L5;
    L9:
        return r5;
    L5:
        if ((r5 ^ r11) >= 0) goto L9;
        throw new IllegalArgumentException("Summing infinities of different signs");
    }

    private static final long infinityOfSign(long r5) {
        if (r5 >= 0) goto L6;
        return Duration.Companion.m1565getNEG_INFINITEUwyO8pc$kotlin_stdlib();
    L6:
        return Duration.Companion.m1564getINFINITEUwyO8pc();
    }

    public static final boolean isSaturated(long r5) {
        if (((r5 - 1) | 1) != Long.MAX_VALUE) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: saturatingAdd-NuflL3o, reason: not valid java name */
    public static final long m1592saturatingAddNuflL3o(long r10, DurationUnit r11, long r12) {
        Intrinsics.checkNotNullParameter(r11, "unit");
        long r5 = Duration.m1509toLongimpl(r12, r11);
        if (((r10 - 1) | 1) != Long.MAX_VALUE) goto L7;
        return m1591checkInfiniteSumDefinedPjuGub4(r10, r12, r5);
    L7:
        if ((1 | (r5 - 1)) == Long.MAX_VALUE) goto L9;
        long r13 = r10 + r5;
        if (((r10 ^ r13) & (r5 ^ r13)) < 0) goto L13;
        return r13;
    L13:
        if (r10 >= 0) goto L17;
        return Long.MIN_VALUE;
    L17:
        return Long.MAX_VALUE;
    L9:
        return m1593saturatingAddInHalvesNuflL3o(r10, r11, r12);
    }

    /* JADX INFO: renamed from: saturatingAddInHalves-NuflL3o, reason: not valid java name */
    private static final long m1593saturatingAddInHalvesNuflL3o(long r10, DurationUnit r11, long r12) {
        long r5 = Duration.m1466divUwyO8pc(r12, 2);
        long r13 = Duration.m1509toLongimpl(r5, r11);
        if ((1 | (r13 - 1)) != Long.MAX_VALUE) goto L6;
        return r13;
    L6:
        return m1592saturatingAddNuflL3o(m1592saturatingAddNuflL3o(r10, r11, r5), r11, Duration.m1498minusLRDsOJo(r12, r5));
    }

    public static final long saturatingDiff(long r5, long r10, DurationUnit r11) {
        Intrinsics.checkNotNullParameter(r11, "unit");
        if ((1 | (r10 - 1)) != Long.MAX_VALUE) goto L7;
        return Duration.m1516unaryMinusUwyO8pc(infinityOfSign(r10));
    L7:
        return saturatingFiniteDiff(r5, r10, r11);
    }

    private static final long saturatingFiniteDiff(long r10, long r11, DurationUnit r12) {
        long r5 = r10 - r11;
        if (((r5 ^ r10) & (~(r5 ^ r11))) >= 0) goto L11;
        DurationUnit r13 = DurationUnit.MILLISECONDS;
        if (r12.compareTo(r13) >= 0) goto L9;
        long r14 = DurationUnitKt__DurationUnitJvmKt.convertDurationUnit(1, r13, r12);
        long r15 = (r10 / r14) - (r11 / r14);
        long r16 = (r10 % r14) - (r11 % r14);
        Duration.Companion r17 = Duration.Companion;
        return Duration.m1499plusLRDsOJo(DurationKt.toDuration(r15, r13), DurationKt.toDuration(r16, r12));
    L9:
        return Duration.m1516unaryMinusUwyO8pc(infinityOfSign(r5));
    L11:
        return DurationKt.toDuration(r5, r12);
    }

    public static final long saturatingOriginsDiff(long r10, long r11, DurationUnit r12) {
        Intrinsics.checkNotNullParameter(r12, "unit");
        if (((r11 - 1) | 1) != Long.MAX_VALUE) goto L11;
        if (r10 != r11) goto L9;
        return Duration.Companion.m1566getZEROUwyO8pc();
    L9:
        return Duration.m1516unaryMinusUwyO8pc(infinityOfSign(r11));
    L11:
        if ((1 | (r10 - 1)) != Long.MAX_VALUE) goto L15;
        return infinityOfSign(r10);
    L15:
        return saturatingFiniteDiff(r10, r11, r12);
    }
}
