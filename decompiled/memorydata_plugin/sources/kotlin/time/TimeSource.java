package kotlin.time;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u0000 \u00042\u00020\u0001:\u0003\u0004\u0005\u0006J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0007"}, d2 = {"Lkotlin/time/TimeSource;", "", "markNow", "Lkotlin/time/TimeMark;", "Companion", "Monotonic", "WithComparableMarks", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface TimeSource {
    public static final Companion Companion = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lkotlin/time/TimeSource$Companion;", "", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;

        static {
            $$INSTANCE = new Companion();
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\tB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u0004H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016\u0082\u0002\u0004\n\u0002\b!¨\u0006\n"}, d2 = {"Lkotlin/time/TimeSource$Monotonic;", "Lkotlin/time/TimeSource$WithComparableMarks;", "()V", "markNow", "Lkotlin/time/TimeSource$Monotonic$ValueTimeMark;", "markNow-z9LOYto", "()J", "toString", "", "ValueTimeMark", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Monotonic implements WithComparableMarks {
        public static final Monotonic INSTANCE = null;

        @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0014\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0087@\u0018\u00002\u00020\u0001B\u0015\b\u0000\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0000H\u0086\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\f\u001a\u00020\rH\u0016ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u0006J\u001a\u0010\u000f\u001a\u00020\u00102\b\u0010\t\u001a\u0004\u0018\u00010\u0011HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0018\u0010\u0016J\u0010\u0010\u0019\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u001b\u0010\u001c\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0001H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ\u0018\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\rH\u0096\u0002¢\u0006\u0004\b \u0010!J\u0018\u0010\u001c\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0000H\u0086\u0002¢\u0006\u0004\b\"\u0010!J\u0018\u0010#\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\rH\u0096\u0002¢\u0006\u0004\b$\u0010!J\u0010\u0010%\u001a\u00020&HÖ\u0001¢\u0006\u0004\b'\u0010(R\u0012\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004X\u0080\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00060\u0003j\u0002`\u0004\u0082\u0002\u0004\n\u0002\b!¨\u0006)"}, d2 = {"Lkotlin/time/TimeSource$Monotonic$ValueTimeMark;", "Lkotlin/time/ComparableTimeMark;", "reading", "", "Lkotlin/time/ValueTimeMarkReading;", "constructor-impl", "(J)J", "compareTo", "", "other", "compareTo-6eNON_k", "(JJ)I", "elapsedNow", "Lkotlin/time/Duration;", "elapsedNow-UwyO8pc", "equals", "", "", "equals-impl", "(JLjava/lang/Object;)Z", "hasNotPassedNow", "hasNotPassedNow-impl", "(J)Z", "hasPassedNow", "hasPassedNow-impl", "hashCode", "hashCode-impl", "(J)I", "minus", "minus-UwyO8pc", "(JLkotlin/time/ComparableTimeMark;)J", "duration", "minus-LRDsOJo", "(JJ)J", "minus-6eNON_k", "plus", "plus-LRDsOJo", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
        @JvmInline
        public static final class ValueTimeMark implements ComparableTimeMark {
            private final long reading;

            private /* synthetic */ ValueTimeMark(long r1) {
                this.reading = r1;
            }

            /* JADX INFO: renamed from: box-impl, reason: not valid java name */
            public static final /* synthetic */ ValueTimeMark m2887boximpl(long r1) {
                return new ValueTimeMark(r1);
            }

            /* JADX INFO: renamed from: compareTo-6eNON_k, reason: not valid java name */
            public static final int m2888compareTo6eNON_k(long r0, long r2) {
                return Duration.m2746compareToLRDsOJo(m2897minus6eNON_k(r0, r2), Duration.Companion.m2850getZEROUwyO8pc());
            }

            /* JADX INFO: renamed from: compareTo-impl, reason: not valid java name */
            public static int m2889compareToimpl(long r2, ComparableTimeMark r4) {
                ComparableTimeMark r5 = (ComparableTimeMark) ZeusTransformUtils.wrapperContextForParams(r4, ComparableTimeMark.class, "com.obric.memorydata.plugin");
                Intrinsics.checkNotNullParameter(r5, "other");
                return m2887boximpl(r2).compareTo2(r5);
            }

            /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
            public static long m2890constructorimpl(long r0) {
                return r0;
            }

            /* JADX INFO: renamed from: elapsedNow-UwyO8pc, reason: not valid java name */
            public static long m2891elapsedNowUwyO8pc(long r1) {
                return MonotonicTimeSource.INSTANCE.m2880elapsedFrom6eNON_k(r1);
            }

            /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
            public static boolean m2892equalsimpl(long r3, Object r5) {
                if (ZeusTransformUtils.instanceOf(r5, ValueTimeMark.class) == true) goto L6;
                return false;
            L6:
                if (r3 == ((ValueTimeMark) ZeusTransformUtils.preCheckCast(r5, ValueTimeMark.class, "com.obric.memorydata.plugin")).m2904unboximpl()) goto L8;
                return false;
            L8:
                return true;
            }

            /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
            public static final boolean m2893equalsimpl0(long r0, long r2) {
                if (r0 != r2) goto L5;
                return true;
            L5:
                return false;
            }

            /* JADX INFO: renamed from: hasNotPassedNow-impl, reason: not valid java name */
            public static boolean m2894hasNotPassedNowimpl(long r0) {
                return Duration.m2780isNegativeimpl(m2891elapsedNowUwyO8pc(r0));
            }

            /* JADX INFO: renamed from: hasPassedNow-impl, reason: not valid java name */
            public static boolean m2895hasPassedNowimpl(long r0) {
                return !Duration.m2780isNegativeimpl(m2891elapsedNowUwyO8pc(r0));
            }

            /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
            public static int m2896hashCodeimpl(long r0) {
                return Long.hashCode(r0);
            }

            /* JADX INFO: renamed from: minus-6eNON_k, reason: not valid java name */
            public static final long m2897minus6eNON_k(long r1, long r3) {
                return MonotonicTimeSource.INSTANCE.m2879differenceBetweenfRLX17w(r1, r3);
            }

            /* JADX INFO: renamed from: minus-LRDsOJo, reason: not valid java name */
            public static long m2898minusLRDsOJo(long r1, long r3) {
                return MonotonicTimeSource.INSTANCE.m2878adjustReading6QKq23U(r1, Duration.m2800unaryMinusUwyO8pc(r3));
            }

            /* JADX INFO: renamed from: minus-UwyO8pc, reason: not valid java name */
            public static long m2899minusUwyO8pc(long r3, ComparableTimeMark r5) {
                ComparableTimeMark r6 = (ComparableTimeMark) ZeusTransformUtils.wrapperContextForParams(r5, ComparableTimeMark.class, "com.obric.memorydata.plugin");
                Intrinsics.checkNotNullParameter(r6, "other");
                if (ZeusTransformUtils.instanceOf(r6, ValueTimeMark.class) == false) goto L7;
                return m2897minus6eNON_k(r3, ((ValueTimeMark) ZeusTransformUtils.preCheckCast(r6, ValueTimeMark.class, "com.obric.memorydata.plugin")).m2904unboximpl());
            L7:
                throw new IllegalArgumentException("Subtracting or comparing time marks from different time sources is not possible: " + m2901toStringimpl(r3) + " and " + r6);
            }

            /* JADX INFO: renamed from: plus-LRDsOJo, reason: not valid java name */
            public static long m2900plusLRDsOJo(long r1, long r3) {
                return MonotonicTimeSource.INSTANCE.m2878adjustReading6QKq23U(r1, r3);
            }

            /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
            public static String m2901toStringimpl(long r2) {
                return "ValueTimeMark(reading=" + r2 + ')';
            }

            @Override // java.lang.Comparable
            public /* synthetic */ int compareTo(ComparableTimeMark r3) {
                return compareTo2((ComparableTimeMark) ZeusTransformUtils.preCheckCast(r3, ComparableTimeMark.class, "com.obric.memorydata.plugin"));
            }

            @Override // kotlin.time.ComparableTimeMark
            /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
            public int compareTo2(ComparableTimeMark r3) {
                ComparableTimeMark r4 = (ComparableTimeMark) ZeusTransformUtils.wrapperContextForParams(r3, ComparableTimeMark.class, "com.obric.memorydata.plugin");
                return ComparableTimeMark.DefaultImpls.compareTo((ComparableTimeMark) ZeusTransformUtils.preCheckCast(this, ComparableTimeMark.class, "com.obric.memorydata.plugin"), r4);
            }

            @Override // kotlin.time.TimeMark
            /* JADX INFO: renamed from: elapsedNow-UwyO8pc */
            public long mo2737elapsedNowUwyO8pc() {
                return m2891elapsedNowUwyO8pc(this.reading);
            }

            @Override // kotlin.time.ComparableTimeMark
            public boolean equals(Object r3) {
                return m2892equalsimpl(this.reading, r3);
            }

            @Override // kotlin.time.TimeMark
            public boolean hasNotPassedNow() {
                return m2894hasNotPassedNowimpl(this.reading);
            }

            @Override // kotlin.time.TimeMark
            public boolean hasPassedNow() {
                return m2895hasPassedNowimpl(this.reading);
            }

            @Override // kotlin.time.ComparableTimeMark
            public int hashCode() {
                return m2896hashCodeimpl(this.reading);
            }

            /* JADX INFO: renamed from: minus-LRDsOJo, reason: not valid java name */
            public long m2902minusLRDsOJo(long r3) {
                return m2898minusLRDsOJo(this.reading, r3);
            }

            @Override // kotlin.time.ComparableTimeMark, kotlin.time.TimeMark
            /* JADX INFO: renamed from: minus-LRDsOJo */
            public /* synthetic */ ComparableTimeMark mo2738minusLRDsOJo(long r1) {
                return m2887boximpl(m2902minusLRDsOJo(r1));
            }

            @Override // kotlin.time.TimeMark
            /* JADX INFO: renamed from: minus-LRDsOJo */
            public /* synthetic */ TimeMark mo2738minusLRDsOJo(long r1) {
                return m2887boximpl(m2902minusLRDsOJo(r1));
            }

            @Override // kotlin.time.ComparableTimeMark
            /* JADX INFO: renamed from: minus-UwyO8pc */
            public long mo2739minusUwyO8pc(ComparableTimeMark r3) {
                ComparableTimeMark r4 = (ComparableTimeMark) ZeusTransformUtils.wrapperContextForParams(r3, ComparableTimeMark.class, "com.obric.memorydata.plugin");
                Intrinsics.checkNotNullParameter(r4, "other");
                return m2899minusUwyO8pc(this.reading, r4);
            }

            /* JADX INFO: renamed from: plus-LRDsOJo, reason: not valid java name */
            public long m2903plusLRDsOJo(long r3) {
                return m2900plusLRDsOJo(this.reading, r3);
            }

            @Override // kotlin.time.ComparableTimeMark, kotlin.time.TimeMark
            /* JADX INFO: renamed from: plus-LRDsOJo */
            public /* synthetic */ ComparableTimeMark mo2740plusLRDsOJo(long r1) {
                return m2887boximpl(m2903plusLRDsOJo(r1));
            }

            @Override // kotlin.time.TimeMark
            /* JADX INFO: renamed from: plus-LRDsOJo */
            public /* synthetic */ TimeMark mo2740plusLRDsOJo(long r1) {
                return m2887boximpl(m2903plusLRDsOJo(r1));
            }

            public String toString() {
                return m2901toStringimpl(this.reading);
            }

            /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
            public final /* synthetic */ long m2904unboximpl() {
                return this.reading;
            }
        }

        static {
            INSTANCE = new Monotonic();
        }

        private Monotonic() {
        }

        @Override // kotlin.time.TimeSource.WithComparableMarks, kotlin.time.TimeSource
        public /* synthetic */ ComparableTimeMark markNow() {
            return ValueTimeMark.m2887boximpl(m2886markNowz9LOYto());
        }

        @Override // kotlin.time.TimeSource
        public /* synthetic */ TimeMark markNow() {
            return ValueTimeMark.m2887boximpl(m2886markNowz9LOYto());
        }

        /* JADX INFO: renamed from: markNow-z9LOYto, reason: not valid java name */
        public long m2886markNowz9LOYto() {
            return MonotonicTimeSource.INSTANCE.m2881markNowz9LOYto();
        }

        public String toString() {
            return MonotonicTimeSource.INSTANCE.toString();
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lkotlin/time/TimeSource$WithComparableMarks;", "Lkotlin/time/TimeSource;", "markNow", "Lkotlin/time/ComparableTimeMark;", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface WithComparableMarks extends TimeSource {
        @Override // kotlin.time.TimeSource
        ComparableTimeMark markNow();
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    TimeMark markNow();
}
