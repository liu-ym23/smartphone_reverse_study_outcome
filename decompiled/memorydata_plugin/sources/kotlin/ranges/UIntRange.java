package kotlin.ranges;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 \u001c2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u00020\u00030\u0004:\u0001\u001cB\u0015\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0003H\u0096\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0096\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0010H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016R\u001d\u0010\b\u001a\u00020\u00038VX\u0097\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0006\u001a\u00020\u00038VX\u0096\u0004ø\u0001\u0000¢\u0006\u0006\u001a\u0004\b\r\u0010\fR\u0017\u0010\u0005\u001a\u00020\u00038VX\u0096\u0004ø\u0001\u0000¢\u0006\u0006\u001a\u0004\b\u000e\u0010\f\u0082\u0002\u0004\n\u0002\b!¨\u0006\u001d"}, d2 = {"Lkotlin/ranges/UIntRange;", "Lkotlin/ranges/UIntProgression;", "Lkotlin/ranges/ClosedRange;", "Lkotlin/UInt;", "Lkotlin/ranges/OpenEndRange;", CommonConsts.APM_INNER_EVENT_COST_START, "endInclusive", "(IILkotlin/jvm/internal/DefaultConstructorMarker;)V", "endExclusive", "getEndExclusive-pVg5ArA$annotations", "()V", "getEndExclusive-pVg5ArA", "()I", "getEndInclusive-pVg5ArA", "getStart-pVg5ArA", "contains", "", EventBody.KEY_VALUE, "contains-WZ4Q5Ns", "(I)Z", "equals", "other", "", "hashCode", "", "isEmpty", "toString", "", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class UIntRange extends UIntProgression implements ClosedRange<UInt>, OpenEndRange<UInt> {
    public static final Companion Companion = null;
    private static final UIntRange EMPTY = null;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lkotlin/ranges/UIntRange$Companion;", "", "()V", "EMPTY", "Lkotlin/ranges/UIntRange;", "getEMPTY", "()Lkotlin/ranges/UIntRange;", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final UIntRange getEMPTY() {
            return UIntRange.access$getEMPTY$cp();
        }
    }

    static {
        DefaultConstructorMarker r1 = null;
        Companion = new Companion(r1);
        EMPTY = new UIntRange(-1, 0, r1);
    }

    private UIntRange(int r3, int r4) {
        super(r3, r4, 1, null);
    }

    public /* synthetic */ UIntRange(int r1, int r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    public static final /* synthetic */ UIntRange access$getEMPTY$cp() {
        return EMPTY;
    }

    @Deprecated(message = "Can throw an exception when it's impossible to represent the value with UInt type, for example, when the range includes MAX_VALUE. It's recommended to use 'endInclusive' property that doesn't throw.")
    /* JADX INFO: renamed from: getEndExclusive-pVg5ArA$annotations, reason: not valid java name */
    public static /* synthetic */ void m2649getEndExclusivepVg5ArA$annotations() {
    }

    @Override // kotlin.ranges.ClosedRange
    public /* synthetic */ boolean contains(Comparable r3) {
        return m2650containsWZ4Q5Ns(((UInt) ZeusTransformUtils.preCheckCast((Comparable) ZeusTransformUtils.wrapperContextForParams(r3, Comparable.class, "com.obric.memorydata.plugin"), UInt.class, "com.obric.memorydata.plugin")).m1568unboximpl());
    }

    /* JADX INFO: renamed from: contains-WZ4Q5Ns, reason: not valid java name */
    public boolean m2650containsWZ4Q5Ns(int r2) {
        if (Integer.compareUnsigned(m2645getFirstpVg5ArA(), r2) <= 0) goto L5;
    L7:
        return false;
    L5:
        if (Integer.compareUnsigned(r2, m2646getLastpVg5ArA()) > 0) goto L7;
        return true;
    }

    @Override // kotlin.ranges.UIntProgression
    public boolean equals(Object r5) {
        if (ZeusTransformUtils.instanceOf(r5, UIntRange.class) == true) goto L5;
    L13:
        return false;
    L5:
        if (isEmpty() == false) goto L9;
        if (((UIntRange) ZeusTransformUtils.preCheckCast(r5, UIntRange.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L9;
    L12:
        return true;
    L9:
        if (m2645getFirstpVg5ArA() != ((UIntRange) ZeusTransformUtils.preCheckCast(r5, UIntRange.class, "com.obric.memorydata.plugin")).m2645getFirstpVg5ArA()) goto L13;
        if (m2646getLastpVg5ArA() != ((UIntRange) ZeusTransformUtils.preCheckCast(r5, UIntRange.class, "com.obric.memorydata.plugin")).m2646getLastpVg5ArA()) goto L13;
        goto L12
    }

    @Override // kotlin.ranges.OpenEndRange
    public /* synthetic */ Comparable getEndExclusive() {
        return UInt.m1510boximpl(m2651getEndExclusivepVg5ArA());
    }

    /* JADX INFO: renamed from: getEndExclusive-pVg5ArA, reason: not valid java name */
    public int m2651getEndExclusivepVg5ArA() {
        if (m2646getLastpVg5ArA() == (-1)) goto L7;
        return UInt.m1516constructorimpl(m2646getLastpVg5ArA() + 1);
    L7:
        throw new IllegalStateException("Cannot return the exclusive upper bound of a range that includes MAX_VALUE.".toString());
    }

    @Override // kotlin.ranges.ClosedRange
    public /* synthetic */ Comparable getEndInclusive() {
        return UInt.m1510boximpl(m2652getEndInclusivepVg5ArA());
    }

    /* JADX INFO: renamed from: getEndInclusive-pVg5ArA, reason: not valid java name */
    public int m2652getEndInclusivepVg5ArA() {
        return m2646getLastpVg5ArA();
    }

    @Override // kotlin.ranges.ClosedRange
    public /* synthetic */ Comparable getStart() {
        return UInt.m1510boximpl(m2653getStartpVg5ArA());
    }

    /* JADX INFO: renamed from: getStart-pVg5ArA, reason: not valid java name */
    public int m2653getStartpVg5ArA() {
        return m2645getFirstpVg5ArA();
    }

    @Override // kotlin.ranges.UIntProgression
    public int hashCode() {
        if (isEmpty() == false) goto L5;
        return -1;
    L5:
        int r0 = m2645getFirstpVg5ArA() * 31;
        return m2646getLastpVg5ArA() + r0;
    }

    @Override // kotlin.ranges.UIntProgression, kotlin.ranges.ClosedRange
    public boolean isEmpty() {
        if (Integer.compareUnsigned(m2645getFirstpVg5ArA(), m2646getLastpVg5ArA()) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // kotlin.ranges.UIntProgression
    public String toString() {
        return UInt.m1562toStringimpl(m2645getFirstpVg5ArA()) + ".." + UInt.m1562toStringimpl(m2646getLastpVg5ArA());
    }
}
