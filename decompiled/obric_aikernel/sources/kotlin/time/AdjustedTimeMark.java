package kotlin.time;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
final class AdjustedTimeMark implements TimeMark {
    private final long adjustment;
    private final TimeMark mark;

    private AdjustedTimeMark(TimeMark r10, long r11) {
        Intrinsics.checkNotNullParameter(r10, "mark");
        this.mark = r10;
        this.adjustment = r11;
    }

    public /* synthetic */ AdjustedTimeMark(TimeMark r10, long r11, DefaultConstructorMarker r12) {
        this(r10, r11);
    }

    @Override // kotlin.time.TimeMark
    /* JADX INFO: renamed from: elapsedNow-UwyO8pc */
    public long mo1374elapsedNowUwyO8pc() {
        return Duration.m1419minusLRDsOJo(this.mark.mo1374elapsedNowUwyO8pc(), this.adjustment);
    }

    /* JADX INFO: renamed from: getAdjustment-UwyO8pc, reason: not valid java name */
    public final long m1378getAdjustmentUwyO8pc() {
        return this.adjustment;
    }

    public final TimeMark getMark() {
        return this.mark;
    }

    @Override // kotlin.time.TimeMark
    public boolean hasNotPassedNow() {
        return TimeMark.DefaultImpls.hasNotPassedNow(this);
    }

    @Override // kotlin.time.TimeMark
    public boolean hasPassedNow() {
        return TimeMark.DefaultImpls.hasPassedNow(this);
    }

    @Override // kotlin.time.TimeMark
    /* JADX INFO: renamed from: minus-LRDsOJo */
    public TimeMark mo1375minusLRDsOJo(long r10) {
        return TimeMark.DefaultImpls.m1521minusLRDsOJo(this, r10);
    }

    @Override // kotlin.time.TimeMark
    /* JADX INFO: renamed from: plus-LRDsOJo */
    public TimeMark mo1377plusLRDsOJo(long r10) {
        return new AdjustedTimeMark(this.mark, Duration.m1420plusLRDsOJo(this.adjustment, r10), null);
    }
}
