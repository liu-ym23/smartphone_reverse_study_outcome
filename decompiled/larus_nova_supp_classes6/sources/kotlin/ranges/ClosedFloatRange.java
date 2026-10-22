package kotlin.ranges;

import com.obric.eventkit.eventstaskmanager.ITaskManager;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0002\u0010\u0005J\u0011\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0002H\u0096\u0002J\u0013\u0010\u000e\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\fH\u0016J\u0018\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0002H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u000e\u0010\u0006\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\t¨\u0006\u0019"}, d2 = {"Lkotlin/ranges/ClosedFloatRange;", "Lkotlin/ranges/ClosedFloatingPointRange;", "", "start", "endInclusive", "(FF)V", "_endInclusive", "_start", "getEndInclusive", "()Ljava/lang/Float;", "getStart", "contains", "", "value", "equals", "other", "", "hashCode", "", "isEmpty", "lessThanOrEquals", "a", "b", "toString", "", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
final class ClosedFloatRange implements ClosedFloatingPointRange<Float> {
    private final float _endInclusive;
    private final float _start;

    public boolean lessThanOrEquals(float r1, float r2) {
        if (r1 > r2) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: getEndInclusive, reason: collision with other method in class */
    public Float m745getEndInclusive() {
        return Float.valueOf(this._endInclusive);
    }

    /* JADX INFO: renamed from: getStart, reason: collision with other method in class */
    public Float m746getStart() {
        return Float.valueOf(this._start);
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
        if (isEmpty() == false) goto L6;
        return -1;
    L6:
        return (Float.floatToIntBits(this._start) * 31) + Float.floatToIntBits(this._endInclusive);
    }

    public /* bridge */ /* synthetic */ Comparable getEndInclusive() {
        return m745getEndInclusive();
    }

    public /* bridge */ /* synthetic */ Comparable getStart() {
        return m746getStart();
    }

    public boolean contains(float r2) {
        if (r2 >= this._start) goto L5;
    L7:
        return false;
    L5:
        if (r2 > this._endInclusive) goto L7;
        return true;
    }

    public boolean equals(Object r5) {
        if ((r5 instanceof ClosedFloatRange) == true) goto L5;
        return false;
    L5:
        if (isEmpty() == true) goto L7;
    L8:
        ClosedFloatRange r6 = (ClosedFloatRange) r5;
        if (this._start != r6._start) goto L11;
        boolean r0 = true;
    L12:
        if (r0 == true) goto L14;
        return false;
    L14:
        if (this._endInclusive != r6._endInclusive) goto L16;
        boolean r7 = true;
    L17:
        if (r7 == false) goto L22;
    L18:
        return true;
    L22:
        return false;
    L16:
        r7 = false;
        goto L17
    L11:
        r0 = false;
        goto L12
    L7:
        if (((ClosedFloatRange) r5).isEmpty() == true) goto L18;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.ranges.ClosedFloatingPointRange
    public /* bridge */ /* synthetic */ boolean contains(Comparable r1) {
        return contains(((Number) r1).floatValue());
    }

    public ClosedFloatRange(float r1, float r2) {
        this._start = r1;
        this._endInclusive = r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.ranges.ClosedFloatingPointRange
    public /* bridge */ /* synthetic */ boolean lessThanOrEquals(Comparable r1, Comparable r2) {
        return lessThanOrEquals(((Number) r1).floatValue(), ((Number) r2).floatValue());
    }
}
