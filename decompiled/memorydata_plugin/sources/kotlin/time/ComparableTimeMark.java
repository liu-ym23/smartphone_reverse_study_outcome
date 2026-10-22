package kotlin.time;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bg\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002J\u0011\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0000H\u0096\u0002J\u0013\u0010\u0006\u001a\u00020\u00072\b\u0010\u0005\u001a\u0004\u0018\u00010\bH¦\u0002J\b\u0010\t\u001a\u00020\u0004H&J\u001b\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0000H¦\u0002ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\n\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000bH\u0096\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000bH¦\u0002¢\u0006\u0004\b\u0012\u0010\u0010\u0082\u0002\u0004\n\u0002\b!¨\u0006\u0013"}, d2 = {"Lkotlin/time/ComparableTimeMark;", "Lkotlin/time/TimeMark;", "", "compareTo", "", "other", "equals", "", "", "hashCode", "minus", "Lkotlin/time/Duration;", "minus-UwyO8pc", "(Lkotlin/time/ComparableTimeMark;)J", "duration", "minus-LRDsOJo", "(J)Lkotlin/time/ComparableTimeMark;", "plus", "plus-LRDsOJo", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface ComparableTimeMark extends Comparable<ComparableTimeMark>, TimeMark {

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        public static int compareTo(ComparableTimeMark r2, ComparableTimeMark r3) {
            ComparableTimeMark r4 = (ComparableTimeMark) ZeusTransformUtils.wrapperContextForParams(r2, ComparableTimeMark.class, "com.obric.memorydata.plugin");
            ComparableTimeMark r5 = (ComparableTimeMark) ZeusTransformUtils.wrapperContextForParams(r3, ComparableTimeMark.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "other");
            return Duration.m2746compareToLRDsOJo(r4.mo2739minusUwyO8pc(r5), Duration.Companion.m2850getZEROUwyO8pc());
        }

        public static boolean hasNotPassedNow(ComparableTimeMark r2) {
            return TimeMark.DefaultImpls.hasNotPassedNow((TimeMark) ZeusTransformUtils.preCheckCast((ComparableTimeMark) ZeusTransformUtils.wrapperContextForParams(r2, ComparableTimeMark.class, "com.obric.memorydata.plugin"), TimeMark.class, "com.obric.memorydata.plugin"));
        }

        public static boolean hasPassedNow(ComparableTimeMark r2) {
            return TimeMark.DefaultImpls.hasPassedNow((TimeMark) ZeusTransformUtils.preCheckCast((ComparableTimeMark) ZeusTransformUtils.wrapperContextForParams(r2, ComparableTimeMark.class, "com.obric.memorydata.plugin"), TimeMark.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: minus-LRDsOJo, reason: not valid java name */
        public static ComparableTimeMark m2742minusLRDsOJo(ComparableTimeMark r2, long r3) {
            return ((ComparableTimeMark) ZeusTransformUtils.wrapperContextForParams(r2, ComparableTimeMark.class, "com.obric.memorydata.plugin")).mo2740plusLRDsOJo(Duration.m2800unaryMinusUwyO8pc(r3));
        }
    }

    int compareTo(ComparableTimeMark r1);

    boolean equals(Object r1);

    int hashCode();

    /* JADX INFO: renamed from: minus-LRDsOJo */
    ComparableTimeMark mo2738minusLRDsOJo(long r1);

    /* JADX INFO: renamed from: minus-UwyO8pc */
    long mo2739minusUwyO8pc(ComparableTimeMark r1);

    /* JADX INFO: renamed from: plus-LRDsOJo */
    ComparableTimeMark mo2740plusLRDsOJo(long r1);
}
