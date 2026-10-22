package androidx.collection;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u0006\u0010\u0006\u001a\u00020\u0007\u001a\u0006\u0010\b\u001a\u00020\u0007\u001a\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n\u001a\u0016\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n\u001a\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n\u001a\u0012\u0010\b\u001a\u00020\u00072\n\u0010\r\u001a\u00020\u0001\"\u00020\n\u001a\u0011\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\nH\u0080\b\u001a\u0006\u0010\u0011\u001a\u00020\u0005\u001a\u000e\u0010\u0011\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n\u001a\u0016\u0010\u0011\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n\u001a\u001e\u0010\u0011\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n\u001a\u0012\u0010\u0011\u001a\u00020\u00052\n\u0010\r\u001a\u00020\u0001\"\u00020\n\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"EmptyFloatArray", "", "getEmptyFloatArray", "()[F", "EmptyFloatSet", "Landroidx/collection/MutableFloatSet;", "emptyFloatSet", "Landroidx/collection/FloatSet;", "floatSetOf", "element1", "", "element2", "element3", "elements", "hash", "", "k", "mutableFloatSetOf", "collection"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class FloatSetKt {
    private static final float[] EmptyFloatArray = null;
    private static final MutableFloatSet EmptyFloatSet = null;

    static {
        EmptyFloatSet = new MutableFloatSet(0);
        EmptyFloatArray = new float[0];
    }

    public static final FloatSet emptyFloatSet() {
        return (FloatSet) ZeusTransformUtils.preCheckCast(EmptyFloatSet, FloatSet.class, "com.obric.memorydata.plugin");
    }

    public static final FloatSet floatSetOf() {
        return (FloatSet) ZeusTransformUtils.preCheckCast(EmptyFloatSet, FloatSet.class, "com.obric.memorydata.plugin");
    }

    public static final FloatSet floatSetOf(float r2) {
        return (FloatSet) ZeusTransformUtils.preCheckCast(mutableFloatSetOf(r2), FloatSet.class, "com.obric.memorydata.plugin");
    }

    public static final FloatSet floatSetOf(float r1, float r2) {
        return (FloatSet) ZeusTransformUtils.preCheckCast(mutableFloatSetOf(r1, r2), FloatSet.class, "com.obric.memorydata.plugin");
    }

    public static final FloatSet floatSetOf(float r0, float r1, float r2) {
        return (FloatSet) ZeusTransformUtils.preCheckCast(mutableFloatSetOf(r0, r1, r2), FloatSet.class, "com.obric.memorydata.plugin");
    }

    public static final FloatSet floatSetOf(float... r2) {
        Intrinsics.checkNotNullParameter(r2, "elements");
        MutableFloatSet r0 = new MutableFloatSet(r2.length);
        r0.plusAssign(r2);
        return (FloatSet) ZeusTransformUtils.preCheckCast(r0, FloatSet.class, "com.obric.memorydata.plugin");
    }

    public static final float[] getEmptyFloatArray() {
        return EmptyFloatArray;
    }

    public static final int hash(float r1) {
        int r2 = Float.hashCode(r1) * ScatterMapKt.MurmurHashC1;
        return r2 ^ (r2 << 16);
    }

    public static final MutableFloatSet mutableFloatSetOf() {
        return new MutableFloatSet(0, 1, null);
    }

    public static final MutableFloatSet mutableFloatSetOf(float r2) {
        MutableFloatSet r0 = new MutableFloatSet(1);
        r0.plusAssign(r2);
        return r0;
    }

    public static final MutableFloatSet mutableFloatSetOf(float r2, float r3) {
        MutableFloatSet r0 = new MutableFloatSet(2);
        r0.plusAssign(r2);
        r0.plusAssign(r3);
        return r0;
    }

    public static final MutableFloatSet mutableFloatSetOf(float r2, float r3, float r4) {
        MutableFloatSet r0 = new MutableFloatSet(3);
        r0.plusAssign(r2);
        r0.plusAssign(r3);
        r0.plusAssign(r4);
        return r0;
    }

    public static final MutableFloatSet mutableFloatSetOf(float... r2) {
        Intrinsics.checkNotNullParameter(r2, "elements");
        MutableFloatSet r0 = new MutableFloatSet(r2.length);
        r0.plusAssign(r2);
        return r0;
    }
}
