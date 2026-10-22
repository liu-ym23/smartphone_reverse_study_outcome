package androidx.collection;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u001a\u0006\u0010\u0006\u001a\u00020\u0007\u001a\u0011\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0080\b\u001a\u0006\u0010\u000b\u001a\u00020\u0007\u001a\u000e\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\t\u001a\u0016\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t\u001a\u001e\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t\u001a\u0012\u0010\u000b\u001a\u00020\u00072\n\u0010\u000f\u001a\u00020\u0001\"\u00020\t\u001a\u0006\u0010\u0010\u001a\u00020\u0005\u001a\u000e\u0010\u0010\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\t\u001a\u0016\u0010\u0010\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t\u001a\u001e\u0010\u0010\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t\u001a\u0012\u0010\u0010\u001a\u00020\u00052\n\u0010\u000f\u001a\u00020\u0001\"\u00020\t\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"EmptyIntArray", "", "getEmptyIntArray", "()[I", "EmptyIntSet", "Landroidx/collection/MutableIntSet;", "emptyIntSet", "Landroidx/collection/IntSet;", "hash", "", "k", "intSetOf", "element1", "element2", "element3", "elements", "mutableIntSetOf", "collection"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class IntSetKt {
    private static final int[] EmptyIntArray = null;
    private static final MutableIntSet EmptyIntSet = null;

    static {
        EmptyIntSet = new MutableIntSet(0);
        EmptyIntArray = new int[0];
    }

    public static final IntSet emptyIntSet() {
        return (IntSet) ZeusTransformUtils.preCheckCast(EmptyIntSet, IntSet.class, "com.obric.memorydata.plugin");
    }

    public static final int[] getEmptyIntArray() {
        return EmptyIntArray;
    }

    public static final int hash(int r1) {
        int r2 = Integer.hashCode(r1) * ScatterMapKt.MurmurHashC1;
        return r2 ^ (r2 << 16);
    }

    public static final IntSet intSetOf() {
        return (IntSet) ZeusTransformUtils.preCheckCast(EmptyIntSet, IntSet.class, "com.obric.memorydata.plugin");
    }

    public static final IntSet intSetOf(int r2) {
        return (IntSet) ZeusTransformUtils.preCheckCast(mutableIntSetOf(r2), IntSet.class, "com.obric.memorydata.plugin");
    }

    public static final IntSet intSetOf(int r1, int r2) {
        return (IntSet) ZeusTransformUtils.preCheckCast(mutableIntSetOf(r1, r2), IntSet.class, "com.obric.memorydata.plugin");
    }

    public static final IntSet intSetOf(int r0, int r1, int r2) {
        return (IntSet) ZeusTransformUtils.preCheckCast(mutableIntSetOf(r0, r1, r2), IntSet.class, "com.obric.memorydata.plugin");
    }

    public static final IntSet intSetOf(int... r2) {
        Intrinsics.checkNotNullParameter(r2, "elements");
        MutableIntSet r0 = new MutableIntSet(r2.length);
        r0.plusAssign(r2);
        return (IntSet) ZeusTransformUtils.preCheckCast(r0, IntSet.class, "com.obric.memorydata.plugin");
    }

    public static final MutableIntSet mutableIntSetOf() {
        return new MutableIntSet(0, 1, null);
    }

    public static final MutableIntSet mutableIntSetOf(int r2) {
        MutableIntSet r0 = new MutableIntSet(1);
        r0.plusAssign(r2);
        return r0;
    }

    public static final MutableIntSet mutableIntSetOf(int r2, int r3) {
        MutableIntSet r0 = new MutableIntSet(2);
        r0.plusAssign(r2);
        r0.plusAssign(r3);
        return r0;
    }

    public static final MutableIntSet mutableIntSetOf(int r2, int r3, int r4) {
        MutableIntSet r0 = new MutableIntSet(3);
        r0.plusAssign(r2);
        r0.plusAssign(r3);
        r0.plusAssign(r4);
        return r0;
    }

    public static final MutableIntSet mutableIntSetOf(int... r2) {
        Intrinsics.checkNotNullParameter(r2, "elements");
        MutableIntSet r0 = new MutableIntSet(r2.length);
        r0.plusAssign(r2);
        return r0;
    }
}
