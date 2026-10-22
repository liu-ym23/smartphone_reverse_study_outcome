package kotlin.ranges;

/* JADX INFO: loaded from: classes3.dex */
final class OpenEndDoubleRange implements OpenEndRange<Double> {
    private final double _endExclusive;
    private final double _start;

    public OpenEndDoubleRange(double r10, double r11) {
        this._start = r10;
        this._endExclusive = r11;
    }

    private final boolean lessThanOrEquals(double r10, double r11) {
        if (r10 > r11) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean contains(double r10) {
        if (r10 >= this._start) goto L5;
    L7:
        return false;
    L5:
        if (r10 >= this._endExclusive) goto L7;
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.ranges.OpenEndRange
    public /* bridge */ /* synthetic */ boolean contains(Comparable r10) {
        return contains(((Number) r10).doubleValue());
    }

    public boolean equals(Object r10) {
        if ((r10 instanceof OpenEndDoubleRange) == false) goto L20;
        if (isEmpty() == true) goto L7;
    L8:
        OpenEndDoubleRange r11 = (OpenEndDoubleRange) r10;
        if (this._start != r11._start) goto L11;
        boolean r12 = true;
    L12:
        if (r12 == false) goto L20;
        if (this._endExclusive != r11._endExclusive) goto L16;
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
        if (((OpenEndDoubleRange) r10).isEmpty() == false) goto L8;
        return true;
    L20:
        return false;
    }

    @Override // kotlin.ranges.OpenEndRange
    public /* bridge */ /* synthetic */ Comparable getEndExclusive() {
        return getEndExclusive();
    }

    @Override // kotlin.ranges.OpenEndRange
    public Double getEndExclusive() {
        return Double.valueOf(this._endExclusive);
    }

    @Override // kotlin.ranges.OpenEndRange
    public /* bridge */ /* synthetic */ Comparable getStart() {
        return getStart();
    }

    @Override // kotlin.ranges.OpenEndRange
    public Double getStart() {
        return Double.valueOf(this._start);
    }

    public int hashCode() {
        if (isEmpty() == false) goto L5;
        return -1;
    L5:
        int r10 = Double.hashCode(this._start) * 31;
        return Double.hashCode(this._endExclusive) + r10;
    }

    @Override // kotlin.ranges.OpenEndRange
    public boolean isEmpty() {
        if (this._start < this._endExclusive) goto L5;
        return true;
    L5:
        return false;
    }

    public String toString() {
        return this._start + "..<" + this._endExclusive;
    }
}
