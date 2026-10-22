package kotlin.ranges;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.internal.UProgressionUtilKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010(\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0017\u0018\u0000 \u00192\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0019B\u001f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0096\u0002J\b\u0010\u0013\u001a\u00020\u0006H\u0016J\b\u0010\u0014\u001a\u00020\u0010H\u0016J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u0016H\u0086\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u0016\u0010\b\u001a\u00020\u0002ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0016\u0010\f\u001a\u00020\u0002ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n\u0082\u0002\u0004\n\u0002\b!¨\u0006\u001a"}, d2 = {"Lkotlin/ranges/UIntProgression;", "", "Lkotlin/UInt;", CommonConsts.APM_INNER_EVENT_COST_START, "endInclusive", "step", "", "(IIILkotlin/jvm/internal/DefaultConstructorMarker;)V", "first", "getFirst-pVg5ArA", "()I", "I", "last", "getLast-pVg5ArA", "getStep", "equals", "", "other", "", "hashCode", "isEmpty", "iterator", "", "toString", "", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public class UIntProgression implements Iterable<UInt>, KMappedMarker {
    public static final Companion Companion = null;
    private final int first;
    private final int last;
    private final int step;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J%\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lkotlin/ranges/UIntProgression$Companion;", "", "()V", "fromClosedRange", "Lkotlin/ranges/UIntProgression;", "rangeStart", "Lkotlin/UInt;", "rangeEnd", "step", "", "fromClosedRange-Nkh28Cs", "(III)Lkotlin/ranges/UIntProgression;", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        /* JADX INFO: renamed from: fromClosedRange-Nkh28Cs, reason: not valid java name */
        public final UIntProgression m2647fromClosedRangeNkh28Cs(int r2, int r3, int r4) {
            return new UIntProgression(r2, r3, r4, null);
        }
    }

    static {
        Companion = new Companion(null);
    }

    private UIntProgression(int r2, int r3, int r4) {
        if (r4 == 0) goto L11;
        if (r4 == Integer.MIN_VALUE) goto L9;
        this.first = r2;
        this.last = UProgressionUtilKt.m2631getProgressionLastElementNkh28Cs(r2, r3, r4);
        this.step = r4;
        return;
    L9:
        throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
    L11:
        throw new IllegalArgumentException("Step must be non-zero.");
    }

    public /* synthetic */ UIntProgression(int r1, int r2, int r3, DefaultConstructorMarker r4) {
        this(r1, r2, r3);
    }

    public boolean equals(Object r5) {
        if (ZeusTransformUtils.instanceOf(r5, UIntProgression.class) == true) goto L5;
    L15:
        return false;
    L5:
        if (isEmpty() == false) goto L9;
        if (((UIntProgression) ZeusTransformUtils.preCheckCast(r5, UIntProgression.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L9;
    L14:
        return true;
    L9:
        if (this.first != ((UIntProgression) ZeusTransformUtils.preCheckCast(r5, UIntProgression.class, "com.obric.memorydata.plugin")).first) goto L15;
        if (this.last != ((UIntProgression) ZeusTransformUtils.preCheckCast(r5, UIntProgression.class, "com.obric.memorydata.plugin")).last) goto L15;
        if (this.step != ((UIntProgression) ZeusTransformUtils.preCheckCast(r5, UIntProgression.class, "com.obric.memorydata.plugin")).step) goto L15;
        goto L14
    }

    /* JADX INFO: renamed from: getFirst-pVg5ArA, reason: not valid java name */
    public final int m2645getFirstpVg5ArA() {
        return this.first;
    }

    /* JADX INFO: renamed from: getLast-pVg5ArA, reason: not valid java name */
    public final int m2646getLastpVg5ArA() {
        return this.last;
    }

    public final int getStep() {
        return this.step;
    }

    public int hashCode() {
        if (isEmpty() == false) goto L5;
        return -1;
    L5:
        int r0 = ((this.first * 31) + this.last) * 31;
        return this.step + r0;
    }

    public boolean isEmpty() {
        if (this.step <= 0) goto L8;
        if (Integer.compareUnsigned(this.first, this.last) <= 0) goto L11;
        return true;
    L11:
        return false;
    L8:
        if (Integer.compareUnsigned(this.first, this.last) >= 0) goto L11;
        return true;
    }

    @Override // java.lang.Iterable
    public final Iterator<UInt> iterator() {
        return (Iterator) ZeusTransformUtils.preCheckCast(new UIntProgressionIterator(this.first, this.last, this.step, null), Iterator.class, "com.obric.memorydata.plugin");
    }

    public String toString() {
        if (this.step <= 0) goto L5;
        StringBuilder r0 = new StringBuilder().append(UInt.m1562toStringimpl(this.first)).append("..").append(UInt.m1562toStringimpl(this.last)).append(" step ");
        int r3 = this.step;
    L7:
        return r0.append(r3).toString();
    L5:
        r0 = new StringBuilder().append(UInt.m1562toStringimpl(this.first)).append(" downTo ").append(UInt.m1562toStringimpl(this.last)).append(" step ");
        r3 = -this.step;
        goto L7
    }
}
