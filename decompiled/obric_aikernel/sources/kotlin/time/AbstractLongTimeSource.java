package kotlin.time;

import com.bytedance.crash.dumper.Scraps;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes3.dex */
@SinceKotlin(version = "1.9")
@WasExperimental(markerClass = {ExperimentalTime.class})
public abstract class AbstractLongTimeSource implements TimeSource.WithComparableMarks {
    private final DurationUnit unit;
    private final Lazy zero$delegate;

    @SourceDebugExtension({"SMAP\nTimeSources.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TimeSources.kt\nkotlin/time/AbstractLongTimeSource$LongTimeMark\n+ 2 longSaturatedMath.kt\nkotlin/time/LongSaturatedMathKt\n*L\n1#1,199:1\n80#2:200\n*S KotlinDebug\n*F\n+ 1 TimeSources.kt\nkotlin/time/AbstractLongTimeSource$LongTimeMark\n*L\n67#1:200\n*E\n"})
    private static final class LongTimeMark implements ComparableTimeMark {
        private final long offset;
        private final long startedAt;
        private final AbstractLongTimeSource timeSource;

        private LongTimeMark(long r10, AbstractLongTimeSource r11, long r12) {
            Intrinsics.checkNotNullParameter(r11, "timeSource");
            this.startedAt = r10;
            this.timeSource = r11;
            this.offset = r12;
        }

        public /* synthetic */ LongTimeMark(long r10, AbstractLongTimeSource r11, long r12, DefaultConstructorMarker r13) {
            this(r10, r11, r12);
        }

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(ComparableTimeMark r10) {
            return compareTo2(r10);
        }

        @Override // kotlin.time.ComparableTimeMark
        /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
        public int compareTo2(ComparableTimeMark r10) {
            return ComparableTimeMark.DefaultImpls.compareTo(this, r10);
        }

        @Override // kotlin.time.TimeMark
        /* JADX INFO: renamed from: elapsedNow-UwyO8pc */
        public long mo1374elapsedNowUwyO8pc() {
            return Duration.m1419minusLRDsOJo(LongSaturatedMathKt.saturatingOriginsDiff(AbstractLongTimeSource.access$adjustedRead(this.timeSource), this.startedAt, this.timeSource.getUnit()), this.offset);
        }

        @Override // kotlin.time.ComparableTimeMark
        public boolean equals(Object r10) {
            if ((r10 instanceof LongTimeMark) == true) goto L5;
        L9:
            return false;
        L5:
            if (Intrinsics.areEqual(this.timeSource, ((LongTimeMark) r10).timeSource) == false) goto L9;
            if (Duration.m1389equalsimpl0(mo1376minusUwyO8pc((ComparableTimeMark) r10), Duration.Companion.m1487getZEROUwyO8pc()) == false) goto L9;
            return true;
        }

        @Override // kotlin.time.TimeMark
        public boolean hasNotPassedNow() {
            return ComparableTimeMark.DefaultImpls.hasNotPassedNow(this);
        }

        @Override // kotlin.time.TimeMark
        public boolean hasPassedNow() {
            return ComparableTimeMark.DefaultImpls.hasPassedNow(this);
        }

        @Override // kotlin.time.ComparableTimeMark
        public int hashCode() {
            return (Duration.m1412hashCodeimpl(this.offset) * 37) + Long.hashCode(this.startedAt);
        }

        @Override // kotlin.time.ComparableTimeMark, kotlin.time.TimeMark
        /* JADX INFO: renamed from: minus-LRDsOJo */
        public ComparableTimeMark mo1375minusLRDsOJo(long r10) {
            return ComparableTimeMark.DefaultImpls.m1379minusLRDsOJo(this, r10);
        }

        @Override // kotlin.time.TimeMark
        /* JADX INFO: renamed from: minus-LRDsOJo */
        public /* bridge */ /* synthetic */ TimeMark mo1375minusLRDsOJo(long r10) {
            return mo1375minusLRDsOJo(r10);
        }

        @Override // kotlin.time.ComparableTimeMark
        /* JADX INFO: renamed from: minus-UwyO8pc */
        public long mo1376minusUwyO8pc(ComparableTimeMark r10) {
            Intrinsics.checkNotNullParameter(r10, "other");
            if ((r10 instanceof LongTimeMark) == false) goto L9;
            LongTimeMark r11 = (LongTimeMark) r10;
            if (Intrinsics.areEqual(this.timeSource, r11.timeSource) == false) goto L9;
            return Duration.m1420plusLRDsOJo(LongSaturatedMathKt.saturatingOriginsDiff(this.startedAt, r11.startedAt, this.timeSource.getUnit()), Duration.m1419minusLRDsOJo(this.offset, r11.offset));
        L9:
            throw new IllegalArgumentException("Subtracting or comparing time marks from different time sources is not possible: " + this + " and " + r10);
        }

        @Override // kotlin.time.ComparableTimeMark, kotlin.time.TimeMark
        /* JADX INFO: renamed from: plus-LRDsOJo */
        public ComparableTimeMark mo1377plusLRDsOJo(long r11) {
            DurationUnit r10 = this.timeSource.getUnit();
            if (Duration.m1416isInfiniteimpl(r11) == true) goto L5;
            long r12 = Duration.m1436truncateToUwyO8pc$kotlin_stdlib(r11, r10);
            long r13 = Duration.m1420plusLRDsOJo(Duration.m1419minusLRDsOJo(r11, r12), this.offset);
            long r14 = LongSaturatedMathKt.m1513saturatingAddNuflL3o(this.startedAt, r10, r12);
            long r15 = Duration.m1436truncateToUwyO8pc$kotlin_stdlib(r13, r10);
            long r16 = LongSaturatedMathKt.m1513saturatingAddNuflL3o(r14, r10, r15);
            long r17 = Duration.m1419minusLRDsOJo(r13, r15);
            long r18 = Duration.m1404getInWholeNanosecondsimpl(r17);
            if (r16 == 0) goto L14;
            if (r18 == 0) goto L14;
            if ((r16 ^ r18) >= 0) goto L14;
            long r19 = DurationKt.toDuration(MathKt.getSign(r18), r10);
            r16 = LongSaturatedMathKt.m1513saturatingAddNuflL3o(r16, r10, r19);
            r17 = Duration.m1419minusLRDsOJo(r17, r19);
        L14:
            if ((1 | (r16 - 1)) != Long.MAX_VALUE) goto L16;
            boolean r20 = true;
        L17:
            if (r20 == false) goto L19;
            r17 = Duration.Companion.m1487getZEROUwyO8pc();
        L19:
            AbstractLongTimeSource r21 = this.timeSource;
            return new LongTimeMark(r16, r21, r17, null);
        L16:
            r20 = false;
            goto L17
        L5:
            return new LongTimeMark(LongSaturatedMathKt.m1513saturatingAddNuflL3o(this.startedAt, r10, r11), this.timeSource, Duration.Companion.m1487getZEROUwyO8pc(), null);
        }

        @Override // kotlin.time.TimeMark
        /* JADX INFO: renamed from: plus-LRDsOJo */
        public /* bridge */ /* synthetic */ TimeMark mo1377plusLRDsOJo(long r10) {
            return mo1377plusLRDsOJo(r10);
        }

        public String toString() {
            return "LongTimeMark(" + this.startedAt + DurationUnitKt__DurationUnitKt.shortName(this.timeSource.getUnit()) + " + " + Duration.m1433toStringimpl(this.offset) + ", " + this.timeSource + ')';
        }
    }

    public AbstractLongTimeSource(DurationUnit r10) {
        Intrinsics.checkNotNullParameter(r10, Scraps.INNER_UNIT);
        this.unit = r10;
        this.zero$delegate = LazyKt.lazy(new AbstractLongTimeSource$zero$2(this));
    }

    public static final /* synthetic */ long access$adjustedRead(AbstractLongTimeSource r10) {
        return r10.adjustedRead();
    }

    private final long adjustedRead() {
        return read() - getZero();
    }

    private final long getZero() {
        return ((Number) this.zero$delegate.getValue()).longValue();
    }

    protected final DurationUnit getUnit() {
        return this.unit;
    }

    @Override // kotlin.time.TimeSource.WithComparableMarks, kotlin.time.TimeSource
    public ComparableTimeMark markNow() {
        return new LongTimeMark(adjustedRead(), this, Duration.Companion.m1487getZEROUwyO8pc(), null);
    }

    @Override // kotlin.time.TimeSource
    public /* bridge */ /* synthetic */ TimeMark markNow() {
        return markNow();
    }

    protected abstract long read();
}
