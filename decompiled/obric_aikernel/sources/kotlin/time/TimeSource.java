package kotlin.time;

import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@SinceKotlin(version = "1.9")
@WasExperimental(markerClass = {ExperimentalTime.class})
public interface TimeSource {
    public static final Companion Companion = null;

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;

        static {
            $$INSTANCE = new Companion();
        }

        private Companion() {
        }
    }

    public static final class Monotonic implements WithComparableMarks {
        public static final Monotonic INSTANCE = null;

        @SinceKotlin(version = "1.9")
        @JvmInline
        @WasExperimental(markerClass = {ExperimentalTime.class})
        public static final class ValueTimeMark implements ComparableTimeMark {
            private final long reading;

            private /* synthetic */ ValueTimeMark(long r10) {
                this.reading = r10;
            }

            /* JADX INFO: renamed from: box-impl, reason: not valid java name */
            public static final /* synthetic */ ValueTimeMark m1524boximpl(long r10) {
                return new ValueTimeMark(r10);
            }

            /* JADX INFO: renamed from: compareTo-6eNON_k, reason: not valid java name */
            public static final int m1525compareTo6eNON_k(long r10, long r11) {
                return Duration.m1383compareToLRDsOJo(m1534minus6eNON_k(r10, r11), Duration.Companion.m1487getZEROUwyO8pc());
            }

            /* JADX INFO: renamed from: compareTo-impl, reason: not valid java name */
            public static int m1526compareToimpl(long r10, ComparableTimeMark r11) {
                Intrinsics.checkNotNullParameter(r11, "other");
                return m1524boximpl(r10).compareTo2(r11);
            }

            /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
            public static long m1527constructorimpl(long r10) {
                return r10;
            }

            /* JADX INFO: renamed from: elapsedNow-UwyO8pc, reason: not valid java name */
            public static long m1528elapsedNowUwyO8pc(long r10) {
                return MonotonicTimeSource.INSTANCE.m1517elapsedFrom6eNON_k(r10);
            }

            /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
            public static boolean m1529equalsimpl(long r10, Object r11) {
                if ((r11 instanceof ValueTimeMark) == true) goto L6;
                return false;
            L6:
                if (r10 == ((ValueTimeMark) r11).m1541unboximpl()) goto L8;
                return false;
            L8:
                return true;
            }

            /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
            public static final boolean m1530equalsimpl0(long r10, long r11) {
                if (r10 != r11) goto L5;
                return true;
            L5:
                return false;
            }

            /* JADX INFO: renamed from: hasNotPassedNow-impl, reason: not valid java name */
            public static boolean m1531hasNotPassedNowimpl(long r10) {
                return Duration.m1417isNegativeimpl(m1528elapsedNowUwyO8pc(r10));
            }

            /* JADX INFO: renamed from: hasPassedNow-impl, reason: not valid java name */
            public static boolean m1532hasPassedNowimpl(long r10) {
                return !Duration.m1417isNegativeimpl(m1528elapsedNowUwyO8pc(r10));
            }

            /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
            public static int m1533hashCodeimpl(long r10) {
                return Long.hashCode(r10);
            }

            /* JADX INFO: renamed from: minus-6eNON_k, reason: not valid java name */
            public static final long m1534minus6eNON_k(long r10, long r11) {
                return MonotonicTimeSource.INSTANCE.m1516differenceBetweenfRLX17w(r10, r11);
            }

            /* JADX INFO: renamed from: minus-LRDsOJo, reason: not valid java name */
            public static long m1535minusLRDsOJo(long r10, long r11) {
                return MonotonicTimeSource.INSTANCE.m1515adjustReading6QKq23U(r10, Duration.m1437unaryMinusUwyO8pc(r11));
            }

            /* JADX INFO: renamed from: minus-UwyO8pc, reason: not valid java name */
            public static long m1536minusUwyO8pc(long r10, ComparableTimeMark r11) {
                Intrinsics.checkNotNullParameter(r11, "other");
                if ((r11 instanceof ValueTimeMark) == false) goto L7;
                return m1534minus6eNON_k(r10, ((ValueTimeMark) r11).m1541unboximpl());
            L7:
                throw new IllegalArgumentException("Subtracting or comparing time marks from different time sources is not possible: " + m1538toStringimpl(r10) + " and " + r11);
            }

            /* JADX INFO: renamed from: plus-LRDsOJo, reason: not valid java name */
            public static long m1537plusLRDsOJo(long r10, long r11) {
                return MonotonicTimeSource.INSTANCE.m1515adjustReading6QKq23U(r10, r11);
            }

            /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
            public static String m1538toStringimpl(long r10) {
                return "ValueTimeMark(reading=" + r10 + ')';
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
                return m1528elapsedNowUwyO8pc(this.reading);
            }

            @Override // kotlin.time.ComparableTimeMark
            public boolean equals(Object r10) {
                return m1529equalsimpl(this.reading, r10);
            }

            @Override // kotlin.time.TimeMark
            public boolean hasNotPassedNow() {
                return m1531hasNotPassedNowimpl(this.reading);
            }

            @Override // kotlin.time.TimeMark
            public boolean hasPassedNow() {
                return m1532hasPassedNowimpl(this.reading);
            }

            @Override // kotlin.time.ComparableTimeMark
            public int hashCode() {
                return m1533hashCodeimpl(this.reading);
            }

            /* JADX INFO: renamed from: minus-LRDsOJo, reason: not valid java name */
            public long m1539minusLRDsOJo(long r10) {
                return m1535minusLRDsOJo(this.reading, r10);
            }

            @Override // kotlin.time.ComparableTimeMark, kotlin.time.TimeMark
            /* JADX INFO: renamed from: minus-LRDsOJo */
            public /* bridge */ /* synthetic */ ComparableTimeMark mo1375minusLRDsOJo(long r10) {
                return m1524boximpl(m1539minusLRDsOJo(r10));
            }

            @Override // kotlin.time.TimeMark
            /* JADX INFO: renamed from: minus-LRDsOJo */
            public /* bridge */ /* synthetic */ TimeMark mo1375minusLRDsOJo(long r10) {
                return m1524boximpl(m1539minusLRDsOJo(r10));
            }

            @Override // kotlin.time.ComparableTimeMark
            /* JADX INFO: renamed from: minus-UwyO8pc */
            public long mo1376minusUwyO8pc(ComparableTimeMark r10) {
                Intrinsics.checkNotNullParameter(r10, "other");
                return m1536minusUwyO8pc(this.reading, r10);
            }

            /* JADX INFO: renamed from: plus-LRDsOJo, reason: not valid java name */
            public long m1540plusLRDsOJo(long r10) {
                return m1537plusLRDsOJo(this.reading, r10);
            }

            @Override // kotlin.time.ComparableTimeMark, kotlin.time.TimeMark
            /* JADX INFO: renamed from: plus-LRDsOJo */
            public /* bridge */ /* synthetic */ ComparableTimeMark mo1377plusLRDsOJo(long r10) {
                return m1524boximpl(m1540plusLRDsOJo(r10));
            }

            @Override // kotlin.time.TimeMark
            /* JADX INFO: renamed from: plus-LRDsOJo */
            public /* bridge */ /* synthetic */ TimeMark mo1377plusLRDsOJo(long r10) {
                return m1524boximpl(m1540plusLRDsOJo(r10));
            }

            public String toString() {
                return m1538toStringimpl(this.reading);
            }

            /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
            public final /* synthetic */ long m1541unboximpl() {
                return this.reading;
            }
        }

        static {
            INSTANCE = new Monotonic();
        }

        private Monotonic() {
        }

        @Override // kotlin.time.TimeSource.WithComparableMarks, kotlin.time.TimeSource
        public /* bridge */ /* synthetic */ ComparableTimeMark markNow() {
            return ValueTimeMark.m1524boximpl(m1523markNowz9LOYto());
        }

        @Override // kotlin.time.TimeSource
        public /* bridge */ /* synthetic */ TimeMark markNow() {
            return ValueTimeMark.m1524boximpl(m1523markNowz9LOYto());
        }

        /* JADX INFO: renamed from: markNow-z9LOYto, reason: not valid java name */
        public long m1523markNowz9LOYto() {
            return MonotonicTimeSource.INSTANCE.m1518markNowz9LOYto();
        }

        public String toString() {
            return MonotonicTimeSource.INSTANCE.toString();
        }
    }

    @SinceKotlin(version = "1.9")
    @WasExperimental(markerClass = {ExperimentalTime.class})
    public interface WithComparableMarks extends TimeSource {
        @Override // kotlin.time.TimeSource
        ComparableTimeMark markNow();
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    TimeMark markNow();
}
