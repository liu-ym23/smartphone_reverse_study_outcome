package kotlin.time;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.crash.dumper.Scraps;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Deprecated(message = "Using AbstractDoubleTimeSource is no longer recommended, use AbstractLongTimeSource instead.")
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\b'\u0018\u00002\u00020\u0001:\u0001\u000bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH$R\u0014\u0010\u0002\u001a\u00020\u0003X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, d2 = {"Lkotlin/time/AbstractDoubleTimeSource;", "Lkotlin/time/TimeSource$WithComparableMarks;", Scraps.INNER_UNIT, "Lkotlin/time/DurationUnit;", "(Lkotlin/time/DurationUnit;)V", "getUnit", "()Lkotlin/time/DurationUnit;", "markNow", "Lkotlin/time/ComparableTimeMark;", "read", "", "DoubleTimeMark", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class AbstractDoubleTimeSource implements TimeSource.WithComparableMarks {
    private final DurationUnit unit;

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010\n\u001a\u00020\u0007H\u0016ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u001b\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0001H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0007H\u0096\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u001a\u001a\u00020\u001bH\u0016R\u0013\u0010\u0006\u001a\u00020\u0007X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b!¨\u0006\u001c"}, d2 = {"Lkotlin/time/AbstractDoubleTimeSource$DoubleTimeMark;", "Lkotlin/time/ComparableTimeMark;", "startedAt", "", "timeSource", "Lkotlin/time/AbstractDoubleTimeSource;", TypedValues.CycleType.S_WAVE_OFFSET, "Lkotlin/time/Duration;", "(DLkotlin/time/AbstractDoubleTimeSource;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "elapsedNow", "elapsedNow-UwyO8pc", "()J", "equals", "", "other", "", "hashCode", "", "minus", "minus-UwyO8pc", "(Lkotlin/time/ComparableTimeMark;)J", "plus", "duration", "plus-LRDsOJo", "(J)Lkotlin/time/ComparableTimeMark;", "toString", "", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private static final class DoubleTimeMark implements ComparableTimeMark {
        private final long offset;
        private final double startedAt;
        private final AbstractDoubleTimeSource timeSource;

        private DoubleTimeMark(double r2, AbstractDoubleTimeSource r4, long r5) {
            Intrinsics.checkNotNullParameter(r4, "timeSource");
            this.startedAt = r2;
            this.timeSource = r4;
            this.offset = r5;
        }

        public /* synthetic */ DoubleTimeMark(double r1, AbstractDoubleTimeSource r3, long r4, DefaultConstructorMarker r6) {
            this(r1, r3, r4);
        }

        @Override // java.lang.Comparable
        public /* synthetic */ int compareTo(ComparableTimeMark r3) {
            return compareTo2((ComparableTimeMark) ZeusTransformUtils.preCheckCast(r3, ComparableTimeMark.class, "com.obric.memorydata.plugin"));
        }

        @Override // kotlin.time.ComparableTimeMark
        /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
        public int compareTo2(ComparableTimeMark r3) {
            return ComparableTimeMark.DefaultImpls.compareTo(this, (ComparableTimeMark) ZeusTransformUtils.wrapperContextForParams(r3, ComparableTimeMark.class, "com.obric.memorydata.plugin"));
        }

        @Override // kotlin.time.TimeMark
        /* JADX INFO: renamed from: elapsedNow-UwyO8pc, reason: not valid java name */
        public long mo2737elapsedNowUwyO8pc() {
            return Duration.m2782minusLRDsOJo(DurationKt.toDuration(this.timeSource.read() - this.startedAt, this.timeSource.getUnit()), this.offset);
        }

        @Override // kotlin.time.ComparableTimeMark
        public boolean equals(Object r4) {
            if (ZeusTransformUtils.instanceOf(r4, DoubleTimeMark.class) == true) goto L5;
        L9:
            return false;
        L5:
            if (Intrinsics.areEqual(this.timeSource, ((DoubleTimeMark) ZeusTransformUtils.preCheckCast(r4, DoubleTimeMark.class, "com.obric.memorydata.plugin")).timeSource) == false) goto L9;
            if (Duration.m2752equalsimpl0(mo2739minusUwyO8pc((ComparableTimeMark) ZeusTransformUtils.preCheckCast(r4, ComparableTimeMark.class, "com.obric.memorydata.plugin")), Duration.Companion.m2850getZEROUwyO8pc()) == false) goto L9;
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
            return Duration.m2775hashCodeimpl(Duration.m2783plusLRDsOJo(DurationKt.toDuration(this.startedAt, this.timeSource.getUnit()), this.offset));
        }

        @Override // kotlin.time.ComparableTimeMark, kotlin.time.TimeMark
        /* JADX INFO: renamed from: minus-LRDsOJo, reason: not valid java name */
        public ComparableTimeMark mo2738minusLRDsOJo(long r1) {
            return ComparableTimeMark.DefaultImpls.m2742minusLRDsOJo(this, r1);
        }

        @Override // kotlin.time.TimeMark
        /* JADX INFO: renamed from: minus-LRDsOJo */
        public /* synthetic */ TimeMark mo2738minusLRDsOJo(long r1) {
            return (TimeMark) ZeusTransformUtils.preCheckCast(mo2738minusLRDsOJo(r1), TimeMark.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.time.ComparableTimeMark
        /* JADX INFO: renamed from: minus-UwyO8pc, reason: not valid java name */
        public long mo2739minusUwyO8pc(ComparableTimeMark r8) {
            ComparableTimeMark r9 = (ComparableTimeMark) ZeusTransformUtils.wrapperContextForParams(r8, ComparableTimeMark.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r9, "other");
            if (ZeusTransformUtils.instanceOf(r9, DoubleTimeMark.class) == false) goto L18;
            if (Intrinsics.areEqual(this.timeSource, ((DoubleTimeMark) ZeusTransformUtils.preCheckCast(r9, DoubleTimeMark.class, "com.obric.memorydata.plugin")).timeSource) == false) goto L18;
            if (Duration.m2752equalsimpl0(this.offset, ((DoubleTimeMark) ZeusTransformUtils.preCheckCast(r9, DoubleTimeMark.class, "com.obric.memorydata.plugin")).offset) == true) goto L9;
        L12:
            long r3 = Duration.m2782minusLRDsOJo(this.offset, ((DoubleTimeMark) ZeusTransformUtils.preCheckCast(r9, DoubleTimeMark.class, "com.obric.memorydata.plugin")).offset);
            long r7 = DurationKt.toDuration(this.startedAt - ((DoubleTimeMark) ZeusTransformUtils.preCheckCast(r9, DoubleTimeMark.class, "com.obric.memorydata.plugin")).startedAt, this.timeSource.getUnit());
            if (Duration.m2752equalsimpl0(r7, Duration.m2800unaryMinusUwyO8pc(r3)) == false) goto L16;
            return Duration.Companion.m2850getZEROUwyO8pc();
        L16:
            return Duration.m2783plusLRDsOJo(r7, r3);
        L9:
            if (Duration.m2779isInfiniteimpl(this.offset) == false) goto L12;
            return Duration.Companion.m2850getZEROUwyO8pc();
        L18:
            throw new IllegalArgumentException("Subtracting or comparing time marks from different time sources is not possible: " + this + " and " + r9);
        }

        @Override // kotlin.time.ComparableTimeMark, kotlin.time.TimeMark
        /* JADX INFO: renamed from: plus-LRDsOJo, reason: not valid java name */
        public ComparableTimeMark mo2740plusLRDsOJo(long r9) {
            return (ComparableTimeMark) ZeusTransformUtils.preCheckCast(new DoubleTimeMark(this.startedAt, this.timeSource, Duration.m2783plusLRDsOJo(this.offset, r9), null), ComparableTimeMark.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.time.TimeMark
        /* JADX INFO: renamed from: plus-LRDsOJo */
        public /* synthetic */ TimeMark mo2740plusLRDsOJo(long r1) {
            return (TimeMark) ZeusTransformUtils.preCheckCast(mo2740plusLRDsOJo(r1), TimeMark.class, "com.obric.memorydata.plugin");
        }

        public String toString() {
            return "DoubleTimeMark(" + this.startedAt + DurationUnitKt.shortName(this.timeSource.getUnit()) + " + " + Duration.m2796toStringimpl(this.offset) + ", " + this.timeSource + ')';
        }
    }

    public AbstractDoubleTimeSource(DurationUnit r2) {
        Intrinsics.checkNotNullParameter(r2, Scraps.INNER_UNIT);
        this.unit = r2;
    }

    public final DurationUnit getUnit() {
        return this.unit;
    }

    @Override // kotlin.time.TimeSource.WithComparableMarks, kotlin.time.TimeSource
    public ComparableTimeMark markNow() {
        return (ComparableTimeMark) ZeusTransformUtils.preCheckCast(new DoubleTimeMark(read(), this, Duration.Companion.m2850getZEROUwyO8pc(), null), ComparableTimeMark.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.time.TimeSource
    public /* synthetic */ TimeMark markNow() {
        return (TimeMark) ZeusTransformUtils.preCheckCast(markNow(), TimeMark.class, "com.obric.memorydata.plugin");
    }

    public abstract double read();
}
