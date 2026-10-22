package androidx.collection;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u0006\u0010\u0003\u001a\u00020\u0001\u001a\u000e\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0016\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005\u001a\u001e\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005\u001a\u0012\u0010\u0003\u001a\u00020\u00012\n\u0010\b\u001a\u00020\t\"\u00020\u0005\u001a\t\u0010\n\u001a\u00020\u000bH\u0086\b\u001a\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005\u001a\u001e\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005\u001a\u0015\u0010\n\u001a\u00020\u000b2\n\u0010\b\u001a\u00020\t\"\u00020\u0005H\u0086\b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"EmptyFloatList", "Landroidx/collection/FloatList;", "emptyFloatList", "floatListOf", "element1", "", "element2", "element3", "elements", "", "mutableFloatListOf", "Landroidx/collection/MutableFloatList;", "collection"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class FloatListKt {
    private static final FloatList EmptyFloatList = null;

    static {
        EmptyFloatList = (FloatList) ZeusTransformUtils.preCheckCast(new MutableFloatList(0), FloatList.class, "com.obric.memorydata.plugin");
    }

    public static final FloatList emptyFloatList() {
        return EmptyFloatList;
    }

    public static final FloatList floatListOf() {
        return EmptyFloatList;
    }

    public static final FloatList floatListOf(float r2) {
        return (FloatList) ZeusTransformUtils.preCheckCast(mutableFloatListOf(r2), FloatList.class, "com.obric.memorydata.plugin");
    }

    public static final FloatList floatListOf(float r1, float r2) {
        return (FloatList) ZeusTransformUtils.preCheckCast(mutableFloatListOf(r1, r2), FloatList.class, "com.obric.memorydata.plugin");
    }

    public static final FloatList floatListOf(float r0, float r1, float r2) {
        return (FloatList) ZeusTransformUtils.preCheckCast(mutableFloatListOf(r0, r1, r2), FloatList.class, "com.obric.memorydata.plugin");
    }

    public static final FloatList floatListOf(float... r2) {
        Intrinsics.checkNotNullParameter(r2, "elements");
        MutableFloatList r0 = new MutableFloatList(r2.length);
        r0.plusAssign(r2);
        return (FloatList) ZeusTransformUtils.preCheckCast(r0, FloatList.class, "com.obric.memorydata.plugin");
    }

    public static final MutableFloatList mutableFloatListOf() {
        return new MutableFloatList(0, 1, null);
    }

    public static final MutableFloatList mutableFloatListOf(float r2) {
        MutableFloatList r0 = new MutableFloatList(1);
        r0.add(r2);
        return r0;
    }

    public static final MutableFloatList mutableFloatListOf(float r2, float r3) {
        MutableFloatList r0 = new MutableFloatList(2);
        r0.add(r2);
        r0.add(r3);
        return r0;
    }

    public static final MutableFloatList mutableFloatListOf(float r2, float r3, float r4) {
        MutableFloatList r0 = new MutableFloatList(3);
        r0.add(r2);
        r0.add(r3);
        r0.add(r4);
        return r0;
    }

    public static final MutableFloatList mutableFloatListOf(float... r2) {
        Intrinsics.checkNotNullParameter(r2, "elements");
        MutableFloatList r0 = new MutableFloatList(r2.length);
        r0.plusAssign(r2);
        return r0;
    }
}
