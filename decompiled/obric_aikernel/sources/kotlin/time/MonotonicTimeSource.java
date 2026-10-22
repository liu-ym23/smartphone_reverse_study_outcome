package kotlin.time;

import kotlin.SinceKotlin;

/* JADX INFO: loaded from: classes3.dex */
@SinceKotlin(version = "1.3")
public final class MonotonicTimeSource implements TimeSource.WithComparableMarks {
    public static final MonotonicTimeSource INSTANCE = null;
    private static final long zero = 0;

    static {
        INSTANCE = new MonotonicTimeSource();
        zero = System.nanoTime();
    }

    private MonotonicTimeSource() {
    }

    private final long read() {
        return System.nanoTime() - zero;
    }

    /* JADX INFO: renamed from: adjustReading-6QKq23U, reason: not valid java name */
    public final long m1515adjustReading6QKq23U(long r10, long r11) {
        return TimeSource.Monotonic.ValueTimeMark.m1527constructorimpl(LongSaturatedMathKt.m1513saturatingAddNuflL3o(r10, DurationUnit.NANOSECONDS, r11));
    }

    /* JADX INFO: renamed from: differenceBetween-fRLX17w, reason: not valid java name */
    public final long m1516differenceBetweenfRLX17w(long r10, long r11) {
        return LongSaturatedMathKt.saturatingOriginsDiff(r10, r11, DurationUnit.NANOSECONDS);
    }

    /* JADX INFO: renamed from: elapsedFrom-6eNON_k, reason: not valid java name */
    public final long m1517elapsedFrom6eNON_k(long r10) {
        return LongSaturatedMathKt.saturatingDiff(read(), r10, DurationUnit.NANOSECONDS);
    }

    @Override // kotlin.time.TimeSource.WithComparableMarks, kotlin.time.TimeSource
    public /* bridge */ /* synthetic */ ComparableTimeMark markNow() {
        return TimeSource.Monotonic.ValueTimeMark.m1524boximpl(m1518markNowz9LOYto());
    }

    @Override // kotlin.time.TimeSource
    public /* bridge */ /* synthetic */ TimeMark markNow() {
        return TimeSource.Monotonic.ValueTimeMark.m1524boximpl(m1518markNowz9LOYto());
    }

    /* JADX INFO: renamed from: markNow-z9LOYto, reason: not valid java name */
    public long m1518markNowz9LOYto() {
        return TimeSource.Monotonic.ValueTimeMark.m1527constructorimpl(read());
    }

    public String toString() {
        return "TimeSource(System.nanoTime())";
    }
}
