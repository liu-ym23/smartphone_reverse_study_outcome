package androidx.collection;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0087@\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\u0011\b\u0000\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\u0005\u0010\tJ\u0010\u0010\u000f\u001a\u00020\u0003H\u0086\n¢\u0006\u0004\b\u0010\u0010\u000bJ\u0010\u0010\u0011\u001a\u00020\u0003H\u0086\n¢\u0006\u0004\b\u0012\u0010\u000bJ\u001a\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001e\u0010\u001fR\u0012\u0010\u0002\u001a\u00020\u00038Æ\u0002¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0007\u001a\u00020\b8\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\f\u0010\rR\u0012\u0010\u0004\u001a\u00020\u00038Æ\u0002¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000b\u0088\u0001\u0007\u0092\u0001\u00020\b¨\u0006 "}, d2 = {"Landroidx/collection/FloatFloatPair;", "", "first", "", "second", "constructor-impl", "(FF)J", "packedValue", "", "(J)J", "getFirst-impl", "(J)F", "getPackedValue$annotations", "()V", "getSecond-impl", "component1", "component1-impl", "component2", "component2-impl", "equals", "", "other", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(J)I", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
public final class FloatFloatPair {
    public final long packedValue;

    private /* synthetic */ FloatFloatPair(long r1) {
        this.packedValue = r1;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ FloatFloatPair m9boximpl(long r1) {
        return new FloatFloatPair(r1);
    }

    /* JADX INFO: renamed from: component1-impl, reason: not valid java name */
    public static final float m10component1impl(long r1) {
        return Float.intBitsToFloat((int) (r1 >> 32));
    }

    /* JADX INFO: renamed from: component2-impl, reason: not valid java name */
    public static final float m11component2impl(long r2) {
        return Float.intBitsToFloat((int) (r2 & 4294967295L));
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m12constructorimpl(float r4, float r5) {
        long r0 = Float.floatToRawIntBits(r4);
        return m13constructorimpl((((long) Float.floatToRawIntBits(r5)) & 4294967295L) | (r0 << 32));
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m13constructorimpl(long r0) {
        return r0;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m14equalsimpl(long r3, Object r5) {
        if (ZeusTransformUtils.instanceOf(r5, FloatFloatPair.class) == true) goto L6;
        return false;
    L6:
        if (r3 == ((FloatFloatPair) ZeusTransformUtils.preCheckCast(r5, FloatFloatPair.class, "com.obric.memorydata.plugin")).m20unboximpl()) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m15equalsimpl0(long r0, long r2) {
        if (r0 != r2) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: getFirst-impl, reason: not valid java name */
    public static final float m16getFirstimpl(long r1) {
        return Float.intBitsToFloat((int) (r1 >> 32));
    }

    public static /* synthetic */ void getPackedValue$annotations() {
    }

    /* JADX INFO: renamed from: getSecond-impl, reason: not valid java name */
    public static final float m17getSecondimpl(long r2) {
        return Float.intBitsToFloat((int) (r2 & 4294967295L));
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m18hashCodeimpl(long r0) {
        return Long.hashCode(r0);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m19toStringimpl(long r3) {
        return '(' + Float.intBitsToFloat((int) (r3 >> 32)) + ", " + Float.intBitsToFloat((int) (r3 & 4294967295L)) + ')';
    }

    public boolean equals(Object r3) {
        return m14equalsimpl(this.packedValue, r3);
    }

    public int hashCode() {
        return m18hashCodeimpl(this.packedValue);
    }

    public String toString() {
        return m19toStringimpl(this.packedValue);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m20unboximpl() {
        return this.packedValue;
    }
}
