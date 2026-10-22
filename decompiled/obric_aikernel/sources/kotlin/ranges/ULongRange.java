package kotlin.ranges;

import kotlin.Deprecated;
import kotlin.ExperimentalStdlibApi;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.SinceKotlin;
import kotlin.ULong;
import kotlin.WasExperimental;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
@SinceKotlin(version = "1.5")
@WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
public final class ULongRange extends ULongProgression implements ClosedRange<ULong>, OpenEndRange<ULong> {
    public static final Companion Companion = null;
    private static final ULongRange EMPTY = null;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }

        public final ULongRange getEMPTY() {
            return ULongRange.access$getEMPTY$cp();
        }
    }

    static {
        Companion = new Companion(null);
        EMPTY = new ULongRange(-1, 0, null);
    }

    private ULongRange(long r10, long r11) {
        super(r10, r11, 1, null);
    }

    public /* synthetic */ ULongRange(long r10, long r11, DefaultConstructorMarker r12) {
        this(r10, r11);
    }

    public static final /* synthetic */ ULongRange access$getEMPTY$cp() {
        return EMPTY;
    }

    @Deprecated(message = "Can throw an exception when it's impossible to represent the value with ULong type, for example, when the range includes MAX_VALUE. It's recommended to use 'endInclusive' property that doesn't throw.")
    @SinceKotlin(version = "1.9")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    /* JADX INFO: renamed from: getEndExclusive-s-VKNKU$annotations, reason: not valid java name */
    public static /* synthetic */ void m1278getEndExclusivesVKNKU$annotations() {
    }

    @Override // kotlin.ranges.ClosedRange
    public /* bridge */ /* synthetic */ boolean contains(Comparable r10) {
        return m1279containsVKZWuLQ(((ULong) r10).m258unboximpl());
    }

    /* JADX INFO: renamed from: contains-VKZWuLQ, reason: not valid java name */
    public boolean m1279containsVKZWuLQ(long r10) {
        if (Long.compareUnsigned(m1274getFirstsVKNKU(), r10) <= 0) goto L5;
    L7:
        return false;
    L5:
        if (Long.compareUnsigned(r10, m1275getLastsVKNKU()) > 0) goto L7;
        return true;
    }

    @Override // kotlin.ranges.ULongProgression
    public boolean equals(Object r10) {
        if ((r10 instanceof ULongRange) == true) goto L5;
    L13:
        return false;
    L5:
        if (isEmpty() == true) goto L7;
    L8:
        ULongRange r11 = (ULongRange) r10;
        if (m1274getFirstsVKNKU() != r11.m1274getFirstsVKNKU()) goto L13;
        if (m1275getLastsVKNKU() != r11.m1275getLastsVKNKU()) goto L13;
    L12:
        return true;
    L7:
        if (((ULongRange) r10).isEmpty() == true) goto L12;
        goto L8
    }

    @Override // kotlin.ranges.OpenEndRange
    public /* bridge */ /* synthetic */ Comparable getEndExclusive() {
        return ULong.m200boximpl(m1280getEndExclusivesVKNKU());
    }

    /* JADX INFO: renamed from: getEndExclusive-s-VKNKU, reason: not valid java name */
    public long m1280getEndExclusivesVKNKU() {
        if (m1275getLastsVKNKU() == (-1)) goto L7;
        return ULong.m206constructorimpl(m1275getLastsVKNKU() + ULong.m206constructorimpl(((long) 1) & 4294967295L));
    L7:
        throw new IllegalStateException("Cannot return the exclusive upper bound of a range that includes MAX_VALUE.".toString());
    }

    @Override // kotlin.ranges.ClosedRange
    public /* bridge */ /* synthetic */ Comparable getEndInclusive() {
        return ULong.m200boximpl(m1281getEndInclusivesVKNKU());
    }

    /* JADX INFO: renamed from: getEndInclusive-s-VKNKU, reason: not valid java name */
    public long m1281getEndInclusivesVKNKU() {
        return m1275getLastsVKNKU();
    }

    @Override // kotlin.ranges.ClosedRange
    public /* bridge */ /* synthetic */ Comparable getStart() {
        return ULong.m200boximpl(m1282getStartsVKNKU());
    }

    /* JADX INFO: renamed from: getStart-s-VKNKU, reason: not valid java name */
    public long m1282getStartsVKNKU() {
        return m1274getFirstsVKNKU();
    }

    @Override // kotlin.ranges.ULongProgression
    public int hashCode() {
        if (isEmpty() == false) goto L5;
        return -1;
    L5:
        int r10 = ((int) ULong.m206constructorimpl(m1274getFirstsVKNKU() ^ ULong.m206constructorimpl(m1274getFirstsVKNKU() >>> 32))) * 31;
        return ((int) ULong.m206constructorimpl(m1275getLastsVKNKU() ^ ULong.m206constructorimpl(m1275getLastsVKNKU() >>> 32))) + r10;
    }

    @Override // kotlin.ranges.ULongProgression, kotlin.ranges.ClosedRange
    public boolean isEmpty() {
        if (Long.compareUnsigned(m1274getFirstsVKNKU(), m1275getLastsVKNKU()) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // kotlin.ranges.ULongProgression
    public String toString() {
        return ULong.m252toStringimpl(m1274getFirstsVKNKU()) + ".." + ULong.m252toStringimpl(m1275getLastsVKNKU());
    }
}
