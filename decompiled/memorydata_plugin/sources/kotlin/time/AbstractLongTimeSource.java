package kotlin.time;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.crash.dumper.Scraps;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b'\u0018\u00002\u00020\u0001:\u0001\u0011B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\r\u001a\u00020\bH\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\bH$R\u0014\u0010\u0002\u001a\u00020\u0003X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006\u0012"}, d2 = {"Lkotlin/time/AbstractLongTimeSource;", "Lkotlin/time/TimeSource$WithComparableMarks;", Scraps.INNER_UNIT, "Lkotlin/time/DurationUnit;", "(Lkotlin/time/DurationUnit;)V", "getUnit", "()Lkotlin/time/DurationUnit;", "zero", "", "getZero", "()J", "zero$delegate", "Lkotlin/Lazy;", "adjustedRead", "markNow", "Lkotlin/time/ComparableTimeMark;", "read", "LongTimeMark", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class AbstractLongTimeSource implements TimeSource.WithComparableMarks {
    private final DurationUnit unit;
    private final Lazy zero$delegate;

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010\n\u001a\u00020\u0007H\u0016ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u001b\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0001H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0007H\u0096\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u001a\u001a\u00020\u001bH\u0016R\u0013\u0010\u0006\u001a\u00020\u0007X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b!¨\u0006\u001c"}, d2 = {"Lkotlin/time/AbstractLongTimeSource$LongTimeMark;", "Lkotlin/time/ComparableTimeMark;", "startedAt", "", "timeSource", "Lkotlin/time/AbstractLongTimeSource;", TypedValues.CycleType.S_WAVE_OFFSET, "Lkotlin/time/Duration;", "(JLkotlin/time/AbstractLongTimeSource;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "elapsedNow", "elapsedNow-UwyO8pc", "()J", "equals", "", "other", "", "hashCode", "", "minus", "minus-UwyO8pc", "(Lkotlin/time/ComparableTimeMark;)J", "plus", "duration", "plus-LRDsOJo", "(J)Lkotlin/time/ComparableTimeMark;", "toString", "", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private static final class LongTimeMark implements ComparableTimeMark {
        private final long offset;
        private final long startedAt;
        private final AbstractLongTimeSource timeSource;

        private LongTimeMark(long r2, AbstractLongTimeSource r4, long r5) {
            Intrinsics.checkNotNullParameter(r4, "timeSource");
            this.startedAt = r2;
            this.timeSource = r4;
            this.offset = r5;
        }

        public /* synthetic */ LongTimeMark(long r1, AbstractLongTimeSource r3, long r4, DefaultConstructorMarker r6) {
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
        /* JADX INFO: renamed from: elapsedNow-UwyO8pc */
        public long mo2737elapsedNowUwyO8pc() {
            return Duration.m2782minusLRDsOJo(LongSaturatedMathKt.saturatingOriginsDiff(AbstractLongTimeSource.access$adjustedRead(this.timeSource), this.startedAt, this.timeSource.getUnit()), this.offset);
        }

        @Override // kotlin.time.ComparableTimeMark
        public boolean equals(Object r4) {
            if (ZeusTransformUtils.instanceOf(r4, LongTimeMark.class) == true) goto L5;
        L9:
            return false;
        L5:
            if (Intrinsics.areEqual(this.timeSource, ((LongTimeMark) ZeusTransformUtils.preCheckCast(r4, LongTimeMark.class, "com.obric.memorydata.plugin")).timeSource) == false) goto L9;
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
            return (Duration.m2775hashCodeimpl(this.offset) * 37) + Long.hashCode(this.startedAt);
        }

        @Override // kotlin.time.ComparableTimeMark, kotlin.time.TimeMark
        /* JADX INFO: renamed from: minus-LRDsOJo */
        public ComparableTimeMark mo2738minusLRDsOJo(long r1) {
            return ComparableTimeMark.DefaultImpls.m2742minusLRDsOJo(this, r1);
        }

        @Override // kotlin.time.TimeMark
        /* JADX INFO: renamed from: minus-LRDsOJo */
        public /* synthetic */ TimeMark mo2738minusLRDsOJo(long r1) {
            return (TimeMark) ZeusTransformUtils.preCheckCast(mo2738minusLRDsOJo(r1), TimeMark.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.time.ComparableTimeMark
        /* JADX INFO: renamed from: minus-UwyO8pc */
        public long mo2739minusUwyO8pc(ComparableTimeMark r8) {
            ComparableTimeMark r9 = (ComparableTimeMark) ZeusTransformUtils.wrapperContextForParams(r8, ComparableTimeMark.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r9, "other");
            if (ZeusTransformUtils.instanceOf(r9, LongTimeMark.class) == false) goto L9;
            if (Intrinsics.areEqual(this.timeSource, ((LongTimeMark) ZeusTransformUtils.preCheckCast(r9, LongTimeMark.class, "com.obric.memorydata.plugin")).timeSource) == false) goto L9;
            return Duration.m2783plusLRDsOJo(LongSaturatedMathKt.saturatingOriginsDiff(this.startedAt, ((LongTimeMark) ZeusTransformUtils.preCheckCast(r9, LongTimeMark.class, "com.obric.memorydata.plugin")).startedAt, this.timeSource.getUnit()), Duration.m2782minusLRDsOJo(this.offset, ((LongTimeMark) ZeusTransformUtils.preCheckCast(r9, LongTimeMark.class, "com.obric.memorydata.plugin")).offset));
        L9:
            throw new IllegalArgumentException("Subtracting or comparing time marks from different time sources is not possible: " + this + " and " + r9);
        }

        @Override // kotlin.time.ComparableTimeMark, kotlin.time.TimeMark
        /* JADX INFO: renamed from: plus-LRDsOJo */
        public ComparableTimeMark mo2740plusLRDsOJo(long r13) {
            DurationUnit r0 = this.timeSource.getUnit();
            if (Duration.m2779isInfiniteimpl(r13) == false) goto L7;
            LongTimeMark r14 = new LongTimeMark(LongSaturatedMathKt.m2876saturatingAddNuflL3o(this.startedAt, r0, r13), this.timeSource, Duration.Companion.m2850getZEROUwyO8pc(), null);
        L6:
            return (ComparableTimeMark) ZeusTransformUtils.preCheckCast(r14, ComparableTimeMark.class, "com.obric.memorydata.plugin");
        L7:
            long r3 = Duration.m2799truncateToUwyO8pc$kotlin_stdlib(r13, r0);
            long r15 = Duration.m2783plusLRDsOJo(Duration.m2782minusLRDsOJo(r13, r3), this.offset);
            long r4 = LongSaturatedMathKt.m2876saturatingAddNuflL3o(this.startedAt, r0, r3);
            long r5 = Duration.m2799truncateToUwyO8pc$kotlin_stdlib(r15, r0);
            long r6 = LongSaturatedMathKt.m2876saturatingAddNuflL3o(r4, r0, r5);
            long r16 = Duration.m2782minusLRDsOJo(r15, r5);
            long r7 = Duration.m2767getInWholeNanosecondsimpl(r16);
            if (r6 != 0) goto L10;
        L14:
            long r8 = r6;
            if ((1 | (r8 - 1)) != Long.MAX_VALUE) goto L17;
            boolean r1 = true;
        L18:
            if (r1 == false) goto L20;
            r16 = Duration.Companion.m2850getZEROUwyO8pc();
        L20:
            AbstractLongTimeSource r9 = this.timeSource;
            r14 = new LongTimeMark(r8, r9, r16, null);
            goto L6
        L17:
            r1 = false;
            goto L18
        L10:
            if (r7 == 0) goto L14;
            if ((r6 ^ r7) >= 0) goto L14;
            long r10 = DurationKt.toDuration(MathKt.getSign(r7), r0);
            r6 = LongSaturatedMathKt.m2876saturatingAddNuflL3o(r6, r0, r10);
            r16 = Duration.m2782minusLRDsOJo(r16, r10);
            goto L14
        }

        @Override // kotlin.time.TimeMark
        /* JADX INFO: renamed from: plus-LRDsOJo */
        public /* synthetic */ TimeMark mo2740plusLRDsOJo(long r1) {
            return (TimeMark) ZeusTransformUtils.preCheckCast(mo2740plusLRDsOJo(r1), TimeMark.class, "com.obric.memorydata.plugin");
        }

        public String toString() {
            return "LongTimeMark(" + this.startedAt + DurationUnitKt.shortName(this.timeSource.getUnit()) + " + " + Duration.m2796toStringimpl(this.offset) + ", " + this.timeSource + ')';
        }
    }

    public AbstractLongTimeSource(DurationUnit r3) {
        Intrinsics.checkNotNullParameter(r3, Scraps.INNER_UNIT);
        this.unit = r3;
        this.zero$delegate = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(new AbstractLongTimeSource$zero$2(this), Function0.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ long access$adjustedRead(AbstractLongTimeSource r2) {
        return r2.adjustedRead();
    }

    private final long adjustedRead() {
        return read() - getZero();
    }

    private final long getZero() {
        return ((Number) ZeusTransformUtils.preCheckCast(this.zero$delegate.getValue(), Number.class, "com.obric.memorydata.plugin")).longValue();
    }

    public final DurationUnit getUnit() {
        return this.unit;
    }

    @Override // kotlin.time.TimeSource.WithComparableMarks, kotlin.time.TimeSource
    public ComparableTimeMark markNow() {
        return (ComparableTimeMark) ZeusTransformUtils.preCheckCast(new LongTimeMark(adjustedRead(), this, Duration.Companion.m2850getZEROUwyO8pc(), null), ComparableTimeMark.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.time.TimeSource
    public /* synthetic */ TimeMark markNow() {
        return (TimeMark) ZeusTransformUtils.preCheckCast(markNow(), TimeMark.class, "com.obric.memorydata.plugin");
    }

    public abstract long read();
}
