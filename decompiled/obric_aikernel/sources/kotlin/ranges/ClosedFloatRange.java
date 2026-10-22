package kotlin.ranges;

/* JADX INFO: loaded from: classes3.dex */
final class ClosedFloatRange implements ClosedFloatingPointRange<Float> {
    private final float _endInclusive;
    private final float _start;

    public ClosedFloatRange(float r10, float r11) {
        this._start = r10;
        this._endInclusive = r11;
    }

    public boolean contains(float r10) {
        if (r10 >= this._start) goto L5;
    L7:
        return false;
    L5:
        if (r10 > this._endInclusive) goto L7;
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.ranges.ClosedFloatingPointRange, kotlin.ranges.ClosedRange
    public /* bridge */ /* synthetic */ boolean contains(Comparable r10) {
        return contains(((Number) r10).floatValue());
    }

    public boolean equals(Object r10) {
        if ((r10 instanceof ClosedFloatRange) == false) goto L20;
        if (isEmpty() == true) goto L7;
    L8:
        ClosedFloatRange r11 = (ClosedFloatRange) r10;
        if (this._start != r11._start) goto L11;
        boolean r12 = true;
    L12:
        if (r12 == false) goto L20;
        if (this._endInclusive != r11._endInclusive) goto L16;
        boolean r13 = true;
    L17:
        if (r13 == false) goto L20;
        return true;
    L16:
        r13 = false;
        goto L17
    L11:
        r12 = false;
        goto L12
    L7:
        if (((ClosedFloatRange) r10).isEmpty() == false) goto L8;
        return true;
    L20:
        return false;
    }

    @Override // kotlin.ranges.ClosedRange
    public /* bridge */ /* synthetic */ Comparable getEndInclusive() {
        return getEndInclusive();
    }

    @Override // kotlin.ranges.ClosedRange
    public Float getEndInclusive() {
        return Float.valueOf(this._endInclusive);
    }

    @Override // kotlin.ranges.ClosedRange
    public /* bridge */ /* synthetic */ Comparable getStart() {
        return getStart();
    }

    @Override // kotlin.ranges.ClosedRange
    public Float getStart() {
        return Float.valueOf(this._start);
    }

    public int hashCode() {
        if (isEmpty() == false) goto L5;
        return -1;
    L5:
        int r10 = Float.hashCode(this._start) * 31;
        return Float.hashCode(this._endInclusive) + r10;
    }

    @Override // kotlin.ranges.ClosedFloatingPointRange, kotlin.ranges.ClosedRange
    public boolean isEmpty() {
        if (this._start <= this._endInclusive) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean lessThanOrEquals(float r10, float r11) {
        if (r10 > r11) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.ranges.ClosedFloatingPointRange
    public /* bridge */ /* synthetic */ boolean lessThanOrEquals(Comparable r10, Comparable r11) {
        return lessThanOrEquals(((Number) r10).floatValue(), ((Number) r11).floatValue());
    }

    public String toString() {
        return this._start + ".." + this._endInclusive;
    }
}
