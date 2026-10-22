package kotlin.ranges;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0002\u0010\u0005J\u0011\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0002H\u0096\u0002J\u0013\u0010\u000e\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\fH\u0016J\u0018\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0002H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u000e\u0010\u0006\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\t¨\u0006\u0019"}, d2 = {"Lkotlin/ranges/ClosedFloatRange;", "Lkotlin/ranges/ClosedFloatingPointRange;", "", CommonConsts.APM_INNER_EVENT_COST_START, "endInclusive", "(FF)V", "_endInclusive", "_start", "getEndInclusive", "()Ljava/lang/Float;", "getStart", "contains", "", EventBody.KEY_VALUE, "equals", "other", "", "hashCode", "", "isEmpty", "lessThanOrEquals", "a", "b", "toString", "", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
final class ClosedFloatRange implements ClosedFloatingPointRange<Float> {
    private final float _endInclusive;
    private final float _start;

    public ClosedFloatRange(float r1, float r2) {
        this._start = r1;
        this._endInclusive = r2;
    }

    public boolean contains(float r2) {
        if (r2 >= this._start) goto L5;
    L7:
        return false;
    L5:
        if (r2 > this._endInclusive) goto L7;
        return true;
    }

    @Override // kotlin.ranges.ClosedFloatingPointRange, kotlin.ranges.ClosedRange
    public /* synthetic */ boolean contains(Comparable r3) {
        return contains(((Number) ZeusTransformUtils.preCheckCast((Comparable) ZeusTransformUtils.wrapperContextForParams(r3, Comparable.class, "com.obric.memorydata.plugin"), Number.class, "com.obric.memorydata.plugin")).floatValue());
    }

    public boolean equals(Object r7) {
        if (ZeusTransformUtils.instanceOf(r7, ClosedFloatRange.class) == false) goto L20;
        if (isEmpty() == false) goto L9;
        if (((ClosedFloatRange) ZeusTransformUtils.preCheckCast(r7, ClosedFloatRange.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L9;
        return true;
    L9:
        if (this._start != ((ClosedFloatRange) ZeusTransformUtils.preCheckCast(r7, ClosedFloatRange.class, "com.obric.memorydata.plugin"))._start) goto L11;
        boolean r1 = true;
    L12:
        if (r1 == false) goto L20;
        if (this._endInclusive != ((ClosedFloatRange) ZeusTransformUtils.preCheckCast(r7, ClosedFloatRange.class, "com.obric.memorydata.plugin"))._endInclusive) goto L16;
        boolean r6 = true;
    L17:
        if (r6 == false) goto L20;
        return true;
    L16:
        r6 = false;
        goto L17
    L11:
        r1 = false;
    L20:
        return false;
    }

    @Override // kotlin.ranges.ClosedRange
    public /* synthetic */ Comparable getEndInclusive() {
        return (Comparable) ZeusTransformUtils.preCheckCast(getEndInclusive(), Comparable.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.ranges.ClosedRange
    public Float getEndInclusive() {
        return Float.valueOf(this._endInclusive);
    }

    @Override // kotlin.ranges.ClosedRange
    public /* synthetic */ Comparable getStart() {
        return (Comparable) ZeusTransformUtils.preCheckCast(getStart(), Comparable.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.ranges.ClosedRange
    public Float getStart() {
        return Float.valueOf(this._start);
    }

    public int hashCode() {
        if (isEmpty() == false) goto L5;
        return -1;
    L5:
        int r0 = Float.hashCode(this._start) * 31;
        return Float.hashCode(this._endInclusive) + r0;
    }

    @Override // kotlin.ranges.ClosedFloatingPointRange, kotlin.ranges.ClosedRange
    public boolean isEmpty() {
        if (this._start <= this._endInclusive) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean lessThanOrEquals(float r1, float r2) {
        if (r1 > r2) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // kotlin.ranges.ClosedFloatingPointRange
    public /* synthetic */ boolean lessThanOrEquals(Comparable r3, Comparable r4) {
        Comparable r5 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r3, Comparable.class, "com.obric.memorydata.plugin");
        Comparable r6 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r4, Comparable.class, "com.obric.memorydata.plugin");
        return lessThanOrEquals(((Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.memorydata.plugin")).floatValue(), ((Number) ZeusTransformUtils.preCheckCast(r6, Number.class, "com.obric.memorydata.plugin")).floatValue());
    }

    public String toString() {
        return this._start + ".." + this._endInclusive;
    }
}
