package kotlin.time;

import kotlin.SinceKotlin;
import kotlin.WasExperimental;

/* JADX INFO: loaded from: classes3.dex */
@SinceKotlin(version = "1.9")
@WasExperimental(markerClass = {ExperimentalTime.class})
public interface TimeMark {

    public static final class DefaultImpls {
        public static boolean hasNotPassedNow(TimeMark r10) {
            return Duration.m1417isNegativeimpl(r10.mo1374elapsedNowUwyO8pc());
        }

        public static boolean hasPassedNow(TimeMark r10) {
            return !Duration.m1417isNegativeimpl(r10.mo1374elapsedNowUwyO8pc());
        }

        /* JADX INFO: renamed from: minus-LRDsOJo, reason: not valid java name */
        public static TimeMark m1521minusLRDsOJo(TimeMark r10, long r11) {
            return r10.mo1377plusLRDsOJo(Duration.m1437unaryMinusUwyO8pc(r11));
        }

        /* JADX INFO: renamed from: plus-LRDsOJo, reason: not valid java name */
        public static TimeMark m1522plusLRDsOJo(TimeMark r10, long r11) {
            return new AdjustedTimeMark(r10, r11, null);
        }
    }

    /* JADX INFO: renamed from: elapsedNow-UwyO8pc */
    long mo1374elapsedNowUwyO8pc();

    boolean hasNotPassedNow();

    boolean hasPassedNow();

    /* JADX INFO: renamed from: minus-LRDsOJo */
    TimeMark mo1375minusLRDsOJo(long r10);

    /* JADX INFO: renamed from: plus-LRDsOJo */
    TimeMark mo1377plusLRDsOJo(long r10);
}
