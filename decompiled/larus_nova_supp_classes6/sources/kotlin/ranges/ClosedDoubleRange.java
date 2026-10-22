package kotlin.ranges;

import com.obric.eventkit.eventstaskmanager.ITaskManager;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0002\u0010\u0005J\u0011\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0002H\u0096\u0002J\u0013\u0010\u000e\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\fH\u0016J\u0018\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0002H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u000e\u0010\u0006\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\t¨\u0006\u0019"}, d2 = {"Lkotlin/ranges/ClosedDoubleRange;", "Lkotlin/ranges/ClosedFloatingPointRange;", "", "start", "endInclusive", "(DD)V", "_endInclusive", "_start", "getEndInclusive", "()Ljava/lang/Double;", "getStart", "contains", "", "value", "equals", "other", "", "hashCode", "", "isEmpty", "lessThanOrEquals", "a", "b", "toString", "", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
final class ClosedDoubleRange implements ClosedFloatingPointRange<Double> {
    private final double _endInclusive;
    private final double _start;

    public boolean lessThanOrEquals(double r2, double r4) {
        if (r2 > r4) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: getEndInclusive, reason: collision with other method in class */
    public Double m743getEndInclusive() {
        return Double.valueOf(this._endInclusive);
    }

    /* JADX INFO: renamed from: getStart, reason: collision with other method in class */
    public Double m744getStart() {
        return Double.valueOf(this._start);
    }

    @Override // kotlin.ranges.ClosedFloatingPointRange
    public boolean isEmpty() {
        if (this._start <= this._endInclusive) goto L5;
        return true;
    L5:
        return false;
    }

    public String toString() {
        return this._start + ".." + this._endInclusive;
    }

    public int hashCode() {
        if (isEmpty() == false) goto L5;
        return -1;
    L5:
        long r0 = Double.doubleToLongBits(this._start);
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        long r3 = Double.doubleToLongBits(this._endInclusive);
        return ((int) (r3 ^ (r3 >>> 32))) + r1;
    }

    public /* bridge */ /* synthetic */ Comparable getEndInclusive() {
        return m743getEndInclusive();
    }

    public /* bridge */ /* synthetic */ Comparable getStart() {
        return m744getStart();
    }

    public boolean contains(double r4) {
        if (r4 >= this._start) goto L5;
    L7:
        return false;
    L5:
        if (r4 > this._endInclusive) goto L7;
        return true;
    }

    public boolean equals(Object r8) {
        if ((r8 instanceof ClosedDoubleRange) == true) goto L5;
        return false;
    L5:
        if (isEmpty() == true) goto L7;
    L8:
        ClosedDoubleRange r9 = (ClosedDoubleRange) r8;
        if (this._start != r9._start) goto L11;
        boolean r0 = true;
    L12:
        if (r0 == true) goto L14;
        return false;
    L14:
        if (this._endInclusive != r9._endInclusive) goto L16;
        boolean r10 = true;
    L17:
        if (r10 == false) goto L22;
    L18:
        return true;
    L22:
        return false;
    L16:
        r10 = false;
        goto L17
    L11:
        r0 = false;
        goto L12
    L7:
        if (((ClosedDoubleRange) r8).isEmpty() == true) goto L18;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.ranges.ClosedFloatingPointRange
    public /* bridge */ /* synthetic */ boolean contains(Comparable r3) {
        return contains(((Number) r3).doubleValue());
    }

    public ClosedDoubleRange(double r1, double r3) {
        this._start = r1;
        this._endInclusive = r3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.ranges.ClosedFloatingPointRange
    public /* bridge */ /* synthetic */ boolean lessThanOrEquals(Comparable r3, Comparable r4) {
        return lessThanOrEquals(((Number) r3).doubleValue(), ((Number) r4).doubleValue());
    }
}
