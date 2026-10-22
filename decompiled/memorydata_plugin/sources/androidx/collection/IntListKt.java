package androidx.collection;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u0006\u0010\u0003\u001a\u00020\u0001\u001a\u000e\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0016\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005\u001a\u001e\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005\u001a\u0012\u0010\u0003\u001a\u00020\u00012\n\u0010\b\u001a\u00020\t\"\u00020\u0005\u001a\t\u0010\n\u001a\u00020\u000bH\u0086\b\u001a\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005\u001a\u001e\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005\u001a\u0015\u0010\n\u001a\u00020\u000b2\n\u0010\b\u001a\u00020\t\"\u00020\u0005H\u0086\b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"EmptyIntList", "Landroidx/collection/IntList;", "emptyIntList", "intListOf", "element1", "", "element2", "element3", "elements", "", "mutableIntListOf", "Landroidx/collection/MutableIntList;", "collection"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class IntListKt {
    private static final IntList EmptyIntList = null;

    static {
        EmptyIntList = (IntList) ZeusTransformUtils.preCheckCast(new MutableIntList(0), IntList.class, "com.obric.memorydata.plugin");
    }

    public static final IntList emptyIntList() {
        return EmptyIntList;
    }

    public static final IntList intListOf() {
        return EmptyIntList;
    }

    public static final IntList intListOf(int r2) {
        return (IntList) ZeusTransformUtils.preCheckCast(mutableIntListOf(r2), IntList.class, "com.obric.memorydata.plugin");
    }

    public static final IntList intListOf(int r1, int r2) {
        return (IntList) ZeusTransformUtils.preCheckCast(mutableIntListOf(r1, r2), IntList.class, "com.obric.memorydata.plugin");
    }

    public static final IntList intListOf(int r0, int r1, int r2) {
        return (IntList) ZeusTransformUtils.preCheckCast(mutableIntListOf(r0, r1, r2), IntList.class, "com.obric.memorydata.plugin");
    }

    public static final IntList intListOf(int... r2) {
        Intrinsics.checkNotNullParameter(r2, "elements");
        MutableIntList r0 = new MutableIntList(r2.length);
        r0.plusAssign(r2);
        return (IntList) ZeusTransformUtils.preCheckCast(r0, IntList.class, "com.obric.memorydata.plugin");
    }

    public static final MutableIntList mutableIntListOf() {
        return new MutableIntList(0, 1, null);
    }

    public static final MutableIntList mutableIntListOf(int r2) {
        MutableIntList r0 = new MutableIntList(1);
        r0.add(r2);
        return r0;
    }

    public static final MutableIntList mutableIntListOf(int r2, int r3) {
        MutableIntList r0 = new MutableIntList(2);
        r0.add(r2);
        r0.add(r3);
        return r0;
    }

    public static final MutableIntList mutableIntListOf(int r2, int r3, int r4) {
        MutableIntList r0 = new MutableIntList(3);
        r0.add(r2);
        r0.add(r3);
        r0.add(r4);
        return r0;
    }

    public static final MutableIntList mutableIntListOf(int... r2) {
        Intrinsics.checkNotNullParameter(r2, "elements");
        MutableIntList r0 = new MutableIntList(r2.length);
        r0.plusAssign(r2);
        return r0;
    }
}
