package kotlin.time;

import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@SinceKotlin(version = "1.9")
@WasExperimental(markerClass = {ExperimentalTime.class})
public interface ComparableTimeMark extends TimeMark, Comparable<ComparableTimeMark> {

    public static final class DefaultImpls {
        public static int compareTo(ComparableTimeMark r10, ComparableTimeMark r11) {
            Intrinsics.checkNotNullParameter(r11, "other");
            return Duration.m1383compareToLRDsOJo(r10.mo1376minusUwyO8pc(r11), Duration.Companion.m1487getZEROUwyO8pc());
        }

        public static boolean hasNotPassedNow(ComparableTimeMark r10) {
            return TimeMark.DefaultImpls.hasNotPassedNow(r10);
        }

        public static boolean hasPassedNow(ComparableTimeMark r10) {
            return TimeMark.DefaultImpls.hasPassedNow(r10);
        }

        /* JADX INFO: renamed from: minus-LRDsOJo, reason: not valid java name */
        public static ComparableTimeMark m1379minusLRDsOJo(ComparableTimeMark r10, long r11) {
            return r10.mo1377plusLRDsOJo(Duration.m1437unaryMinusUwyO8pc(r11));
        }
    }

    int compareTo(ComparableTimeMark r10);

    boolean equals(Object r10);

    int hashCode();

    @Override // kotlin.time.TimeMark
    /* JADX INFO: renamed from: minus-LRDsOJo */
    ComparableTimeMark mo1375minusLRDsOJo(long r10);

    /* JADX INFO: renamed from: minus-UwyO8pc */
    long mo1376minusUwyO8pc(ComparableTimeMark r10);

    @Override // kotlin.time.TimeMark
    /* JADX INFO: renamed from: plus-LRDsOJo */
    ComparableTimeMark mo1377plusLRDsOJo(long r10);
}
