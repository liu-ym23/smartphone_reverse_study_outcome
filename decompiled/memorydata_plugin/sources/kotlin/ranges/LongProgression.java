package kotlin.ranges;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.LongIterator;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0016\u0018\u0000 \u00182\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0018B\u001f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0002\u0010\u0006J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u000eH\u0016J\t\u0010\u0014\u001a\u00020\u0015H\u0096\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0016R\u0011\u0010\u0007\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0019"}, d2 = {"Lkotlin/ranges/LongProgression;", "", "", CommonConsts.APM_INNER_EVENT_COST_START, "endInclusive", "step", "(JJJ)V", "first", "getFirst", "()J", "last", "getLast", "getStep", "equals", "", "other", "", "hashCode", "", "isEmpty", "iterator", "Lkotlin/collections/LongIterator;", "toString", "", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public class LongProgression implements Iterable<Long>, KMappedMarker {
    public static final Companion Companion = null;
    private final long first;
    private final long last;
    private final long step;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006¨\u0006\t"}, d2 = {"Lkotlin/ranges/LongProgression$Companion;", "", "()V", "fromClosedRange", "Lkotlin/ranges/LongProgression;", "rangeStart", "", "rangeEnd", "step", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final LongProgression fromClosedRange(long r8, long r10, long r12) {
            return new LongProgression(r8, r10, r12);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public LongProgression(long r3, long r5, long r7) {
        if (r7 == 0) goto L11;
        if (r7 == Long.MIN_VALUE) goto L9;
        this.first = r3;
        this.last = ProgressionUtilKt.getProgressionLastElement(r3, r5, r7);
        this.step = r7;
        return;
    L9:
        throw new IllegalArgumentException("Step must be greater than Long.MIN_VALUE to avoid overflow on negation.");
    L11:
        throw new IllegalArgumentException("Step must be non-zero.");
    }

    public boolean equals(Object r8) {
        if (ZeusTransformUtils.instanceOf(r8, LongProgression.class) == true) goto L5;
    L15:
        return false;
    L5:
        if (isEmpty() == false) goto L9;
        if (((LongProgression) ZeusTransformUtils.preCheckCast(r8, LongProgression.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L9;
    L14:
        return true;
    L9:
        if (this.first != ((LongProgression) ZeusTransformUtils.preCheckCast(r8, LongProgression.class, "com.obric.memorydata.plugin")).first) goto L15;
        if (this.last != ((LongProgression) ZeusTransformUtils.preCheckCast(r8, LongProgression.class, "com.obric.memorydata.plugin")).last) goto L15;
        if (this.step != ((LongProgression) ZeusTransformUtils.preCheckCast(r8, LongProgression.class, "com.obric.memorydata.plugin")).step) goto L15;
        goto L14
    }

    public final long getFirst() {
        return this.first;
    }

    public final long getLast() {
        return this.last;
    }

    public final long getStep() {
        return this.step;
    }

    public int hashCode() {
        if (isEmpty() == false) goto L5;
        return -1;
    L5:
        long r0 = 31;
        long r2 = this.first;
        long r5 = this.last;
        long r1 = r0 * (((r2 ^ (r2 >>> 32)) * r0) + (r5 ^ (r5 >>> 32)));
        long r3 = this.step;
        return (int) (r1 + (r3 ^ (r3 >>> 32)));
    }

    public boolean isEmpty() {
        long r0 = this.step;
        long r3 = this.first;
        long r5 = this.last;
        if (r0 <= 0) goto L6;
        if (r3 <= r5) goto L9;
        return true;
    L9:
        return false;
    L6:
        if (r3 >= r5) goto L9;
        return true;
    }

    @Override // java.lang.Iterable
    public /* synthetic */ Iterator<Long> iterator() {
        return (Iterator) ZeusTransformUtils.preCheckCast(iterator2(), Iterator.class, "com.obric.memorydata.plugin");
    }

    @Override // java.lang.Iterable
    /* JADX INFO: renamed from: iterator, reason: avoid collision after fix types in other method */
    public Iterator<Long> iterator2() {
        return (LongIterator) ZeusTransformUtils.preCheckCast(new LongProgressionIterator(this.first, this.last, this.step), LongIterator.class, "com.obric.memorydata.plugin");
    }

    public String toString() {
        if (this.step <= 0) goto L5;
        StringBuilder r0 = new StringBuilder().append(this.first).append("..").append(this.last).append(" step ");
        long r1 = this.step;
    L7:
        return r0.append(r1).toString();
    L5:
        r0 = new StringBuilder().append(this.first).append(" downTo ").append(this.last).append(" step ");
        r1 = -this.step;
        goto L7
    }
}
