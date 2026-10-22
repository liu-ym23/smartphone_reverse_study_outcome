package kotlin.time;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes3.dex */
@SinceKotlin(version = "1.9")
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b'\u0018\u00002\u00020\u0001:\u0001\u0011B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\r\u001a\u00020\bH\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\bH$R\u0014\u0010\u0002\u001a\u00020\u0003X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006\u0012"}, d2 = {"Lkotlin/time/AbstractLongTimeSource;", "Lkotlin/time/TimeSource$WithComparableMarks;", "unit", "Lkotlin/time/DurationUnit;", "(Lkotlin/time/DurationUnit;)V", "getUnit", "()Lkotlin/time/DurationUnit;", "zero", "", "getZero", "()J", "zero$delegate", "Lkotlin/Lazy;", "adjustedRead", "markNow", "Lkotlin/time/ComparableTimeMark;", "read", "LongTimeMark", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
@WasExperimental(markerClass = {ExperimentalTime.class})
public abstract class AbstractLongTimeSource implements TimeSource.WithComparableMarks {
    private final DurationUnit unit;
    private final Lazy zero$delegate;

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010\n\u001a\u00020\u0007H\u0016ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u001b\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0001H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0007H\u0096\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u001a\u001a\u00020\u001bH\u0016R\u0013\u0010\u0006\u001a\u00020\u0007X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b!¨\u0006\u001c"}, d2 = {"Lkotlin/time/AbstractLongTimeSource$LongTimeMark;", "Lkotlin/time/ComparableTimeMark;", "startedAt", "", "timeSource", "Lkotlin/time/AbstractLongTimeSource;", "offset", "Lkotlin/time/Duration;", "(JLkotlin/time/AbstractLongTimeSource;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "elapsedNow", "elapsedNow-UwyO8pc", "()J", "equals", "", "other", "", "hashCode", "", "minus", "minus-UwyO8pc", "(Lkotlin/time/ComparableTimeMark;)J", "plus", "duration", "plus-LRDsOJo", "(J)Lkotlin/time/ComparableTimeMark;", "toString", "", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nTimeSources.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TimeSources.kt\nkotlin/time/AbstractLongTimeSource$LongTimeMark\n+ 2 longSaturatedMath.kt\nkotlin/time/LongSaturatedMathKt\n*L\n1#1,199:1\n80#2:200\n*S KotlinDebug\n*F\n+ 1 TimeSources.kt\nkotlin/time/AbstractLongTimeSource$LongTimeMark\n*L\n67#1:200\n*E\n"})
    public static final class LongTimeMark implements ComparableTimeMark {
        private final long offset;
        private final long startedAt;
        private final AbstractLongTimeSource timeSource;

        public /* synthetic */ LongTimeMark(long r5, AbstractLongTimeSource r10, long r11, DefaultConstructorMarker r12) {
            this(r5, r10, r11);
        }

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(ComparableTimeMark r5) {
            return compareTo2(r5);
        }

        @Override // kotlin.time.TimeMark
        /* JADX INFO: renamed from: elapsedNow-UwyO8pc */
        public long mo1453elapsedNowUwyO8pc() {
            return Duration.m1498minusLRDsOJo(LongSaturatedMathKt.saturatingOriginsDiff(AbstractLongTimeSource.access$adjustedRead(this.timeSource), this.startedAt, this.timeSource.getUnit()), this.offset);
        }

        @Override // kotlin.time.ComparableTimeMark
        public boolean equals(Object r5) {
            if ((r5 instanceof LongTimeMark) == true) goto L5;
        L9:
            return false;
        L5:
            if (Intrinsics.areEqual(this.timeSource, ((LongTimeMark) r5).timeSource) == false) goto L9;
            if (Duration.m1468equalsimpl0(mo1455minusUwyO8pc((ComparableTimeMark) r5), Duration.Companion.m1566getZEROUwyO8pc()) == false) goto L9;
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
            int r5 = Duration.m1491hashCodeimpl(this.offset) * 37;
            return Long.hashCode(this.startedAt) + r5;
        }

        @Override // kotlin.time.ComparableTimeMark, kotlin.time.TimeMark
        /* JADX INFO: renamed from: minus-LRDsOJo */
        public ComparableTimeMark mo1454minusLRDsOJo(long r5) {
            return ComparableTimeMark.DefaultImpls.m1458minusLRDsOJo(this, r5);
        }

        @Override // kotlin.time.ComparableTimeMark
        /* JADX INFO: renamed from: minus-UwyO8pc */
        public long mo1455minusUwyO8pc(ComparableTimeMark r10) {
            Intrinsics.checkNotNullParameter(r10, "other");
            if ((r10 instanceof LongTimeMark) == false) goto L9;
            LongTimeMark r5 = (LongTimeMark) r10;
            if (Intrinsics.areEqual(this.timeSource, r5.timeSource) == false) goto L9;
            return Duration.m1499plusLRDsOJo(LongSaturatedMathKt.saturatingOriginsDiff(this.startedAt, r5.startedAt, this.timeSource.getUnit()), Duration.m1498minusLRDsOJo(this.offset, r5.offset));
        L9:
            throw new IllegalArgumentException("Subtracting or comparing time marks from different time sources is not possible: " + this + " and " + r10);
        }

        @Override // kotlin.time.TimeMark
        /* JADX INFO: renamed from: plus-LRDsOJo */
        public /* bridge */ /* synthetic */ TimeMark mo1456plusLRDsOJo(long r5) {
            return mo1456plusLRDsOJo(r5);
        }

        public String toString() {
            return "LongTimeMark(" + this.startedAt + DurationUnitKt__DurationUnitKt.shortName(this.timeSource.getUnit()) + " + " + Duration.m1512toStringimpl(this.offset) + ", " + this.timeSource + ')';
        }

        private LongTimeMark(long r5, AbstractLongTimeSource r10, long r11) {
            Intrinsics.checkNotNullParameter(r10, "timeSource");
            this.startedAt = r5;
            this.timeSource = r10;
            this.offset = r11;
        }

        @Override // kotlin.time.ComparableTimeMark
        /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
        public int compareTo2(ComparableTimeMark r5) {
            return ComparableTimeMark.DefaultImpls.compareTo(this, r5);
        }

        @Override // kotlin.time.TimeMark
        /* JADX INFO: renamed from: minus-LRDsOJo */
        public /* bridge */ /* synthetic */ TimeMark mo1454minusLRDsOJo(long r5) {
            return mo1454minusLRDsOJo(r5);
        }

        @Override // kotlin.time.ComparableTimeMark, kotlin.time.TimeMark
        /* JADX INFO: renamed from: plus-LRDsOJo */
        public ComparableTimeMark mo1456plusLRDsOJo(long r11) {
            DurationUnit r5 = this.timeSource.getUnit();
            if (Duration.m1495isInfiniteimpl(r11) == true) goto L5;
            long r10 = Duration.m1515truncateToUwyO8pc$kotlin_stdlib(r11, r5);
            long r12 = Duration.m1499plusLRDsOJo(Duration.m1498minusLRDsOJo(r11, r10), this.offset);
            long r13 = LongSaturatedMathKt.m1592saturatingAddNuflL3o(this.startedAt, r5, r10);
            long r14 = Duration.m1515truncateToUwyO8pc$kotlin_stdlib(r12, r5);
            long r15 = LongSaturatedMathKt.m1592saturatingAddNuflL3o(r13, r5, r14);
            long r16 = Duration.m1498minusLRDsOJo(r12, r14);
            long r17 = Duration.m1483getInWholeNanosecondsimpl(r16);
            if (r15 == 0) goto L14;
            if (r17 == 0) goto L14;
            if ((r15 ^ r17) >= 0) goto L14;
            long r18 = DurationKt.toDuration(MathKt.getSign(r17), r5);
            r15 = LongSaturatedMathKt.m1592saturatingAddNuflL3o(r15, r5, r18);
            r16 = Duration.m1498minusLRDsOJo(r16, r18);
        L14:
            if ((1 | (r15 - 1)) != Long.MAX_VALUE) goto L16;
            r16 = Duration.Companion.m1566getZEROUwyO8pc();
        L16:
            AbstractLongTimeSource r19 = this.timeSource;
            return new LongTimeMark(r15, r19, r16, null);
        L5:
            return new LongTimeMark(LongSaturatedMathKt.m1592saturatingAddNuflL3o(this.startedAt, r5, r11), this.timeSource, Duration.Companion.m1566getZEROUwyO8pc(), null);
        }
    }

    public AbstractLongTimeSource(DurationUnit r5) {
        Intrinsics.checkNotNullParameter(r5, "unit");
        this.unit = r5;
        this.zero$delegate = LazyKt.lazy(new AbstractLongTimeSource$zero$2(this));
    }

    public static final /* synthetic */ long access$adjustedRead(AbstractLongTimeSource r5) {
        return r5.adjustedRead();
    }

    private final long adjustedRead() {
        return read() - getZero();
    }

    private final long getZero() {
        return ((Number) this.zero$delegate.getValue()).longValue();
    }

    public final DurationUnit getUnit() {
        return this.unit;
    }

    @Override // kotlin.time.TimeSource
    public /* bridge */ /* synthetic */ TimeMark markNow() {
        return markNow();
    }

    public abstract long read();

    @Override // kotlin.time.TimeSource.WithComparableMarks, kotlin.time.TimeSource
    public ComparableTimeMark markNow() {
        return new LongTimeMark(adjustedRead(), this, Duration.Companion.m1566getZEROUwyO8pc(), null);
    }
}
