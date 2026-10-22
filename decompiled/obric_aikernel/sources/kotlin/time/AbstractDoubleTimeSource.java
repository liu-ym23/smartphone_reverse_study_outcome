package kotlin.time;

import com.bytedance.crash.dumper.Scraps;
import kotlin.Deprecated;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated(message = "Using AbstractDoubleTimeSource is no longer recommended, use AbstractLongTimeSource instead.")
@SinceKotlin(version = "1.3")
@ExperimentalTime
public abstract class AbstractDoubleTimeSource implements TimeSource.WithComparableMarks {
    private final DurationUnit unit;

    private static final class DoubleTimeMark implements ComparableTimeMark {
        private final long offset;
        private final double startedAt;
        private final AbstractDoubleTimeSource timeSource;

        private DoubleTimeMark(double r10, AbstractDoubleTimeSource r11, long r12) {
            Intrinsics.checkNotNullParameter(r11, "timeSource");
            this.startedAt = r10;
            this.timeSource = r11;
            this.offset = r12;
        }

        public /* synthetic */ DoubleTimeMark(double r10, AbstractDoubleTimeSource r11, long r12, DefaultConstructorMarker r13) {
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
        /* JADX INFO: renamed from: elapsedNow-UwyO8pc, reason: not valid java name */
        public long mo1374elapsedNowUwyO8pc() {
            return Duration.m1419minusLRDsOJo(DurationKt.toDuration(this.timeSource.read() - this.startedAt, this.timeSource.getUnit()), this.offset);
        }

        @Override // kotlin.time.ComparableTimeMark
        public boolean equals(Object r10) {
            if ((r10 instanceof DoubleTimeMark) == true) goto L5;
        L9:
            return false;
        L5:
            if (Intrinsics.areEqual(this.timeSource, ((DoubleTimeMark) r10).timeSource) == false) goto L9;
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
            return Duration.m1412hashCodeimpl(Duration.m1420plusLRDsOJo(DurationKt.toDuration(this.startedAt, this.timeSource.getUnit()), this.offset));
        }

        @Override // kotlin.time.ComparableTimeMark, kotlin.time.TimeMark
        /* JADX INFO: renamed from: minus-LRDsOJo, reason: not valid java name */
        public ComparableTimeMark mo1375minusLRDsOJo(long r10) {
            return ComparableTimeMark.DefaultImpls.m1379minusLRDsOJo(this, r10);
        }

        @Override // kotlin.time.TimeMark
        /* JADX INFO: renamed from: minus-LRDsOJo */
        public /* bridge */ /* synthetic */ TimeMark mo1375minusLRDsOJo(long r10) {
            return mo1375minusLRDsOJo(r10);
        }

        @Override // kotlin.time.ComparableTimeMark
        /* JADX INFO: renamed from: minus-UwyO8pc, reason: not valid java name */
        public long mo1376minusUwyO8pc(ComparableTimeMark r10) {
            Intrinsics.checkNotNullParameter(r10, "other");
            if ((r10 instanceof DoubleTimeMark) == false) goto L18;
            DoubleTimeMark r11 = (DoubleTimeMark) r10;
            if (Intrinsics.areEqual(this.timeSource, r11.timeSource) == false) goto L18;
            if (Duration.m1389equalsimpl0(this.offset, r11.offset) == true) goto L9;
        L12:
            long r12 = Duration.m1419minusLRDsOJo(this.offset, r11.offset);
            long r13 = DurationKt.toDuration(this.startedAt - r11.startedAt, this.timeSource.getUnit());
            if (Duration.m1389equalsimpl0(r13, Duration.m1437unaryMinusUwyO8pc(r12)) == false) goto L16;
            return Duration.Companion.m1487getZEROUwyO8pc();
        L16:
            return Duration.m1420plusLRDsOJo(r13, r12);
        L9:
            if (Duration.m1416isInfiniteimpl(this.offset) == false) goto L12;
            return Duration.Companion.m1487getZEROUwyO8pc();
        L18:
            throw new IllegalArgumentException("Subtracting or comparing time marks from different time sources is not possible: " + this + " and " + r10);
        }

        @Override // kotlin.time.ComparableTimeMark, kotlin.time.TimeMark
        /* JADX INFO: renamed from: plus-LRDsOJo, reason: not valid java name */
        public ComparableTimeMark mo1377plusLRDsOJo(long r10) {
            return new DoubleTimeMark(this.startedAt, this.timeSource, Duration.m1420plusLRDsOJo(this.offset, r10), null);
        }

        @Override // kotlin.time.TimeMark
        /* JADX INFO: renamed from: plus-LRDsOJo */
        public /* bridge */ /* synthetic */ TimeMark mo1377plusLRDsOJo(long r10) {
            return mo1377plusLRDsOJo(r10);
        }

        public String toString() {
            return "DoubleTimeMark(" + this.startedAt + DurationUnitKt__DurationUnitKt.shortName(this.timeSource.getUnit()) + " + " + Duration.m1433toStringimpl(this.offset) + ", " + this.timeSource + ')';
        }
    }

    public AbstractDoubleTimeSource(DurationUnit r10) {
        Intrinsics.checkNotNullParameter(r10, Scraps.INNER_UNIT);
        this.unit = r10;
    }

    protected final DurationUnit getUnit() {
        return this.unit;
    }

    @Override // kotlin.time.TimeSource.WithComparableMarks, kotlin.time.TimeSource
    public ComparableTimeMark markNow() {
        return new DoubleTimeMark(read(), this, Duration.Companion.m1487getZEROUwyO8pc(), null);
    }

    @Override // kotlin.time.TimeSource
    public /* bridge */ /* synthetic */ TimeMark markNow() {
        return markNow();
    }

    protected abstract double read();
}
