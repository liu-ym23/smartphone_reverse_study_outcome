package androidx.collection;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u0006\u0010\u0003\u001a\u00020\u0001\u001a\u000e\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0016\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005\u001a\u001e\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005\u001a\u0012\u0010\u0003\u001a\u00020\u00012\n\u0010\b\u001a\u00020\t\"\u00020\u0005\u001a\t\u0010\n\u001a\u00020\u000bH\u0086\b\u001a\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005\u001a\u001e\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005\u001a\u0015\u0010\n\u001a\u00020\u000b2\n\u0010\b\u001a\u00020\t\"\u00020\u0005H\u0086\b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"EmptyLongList", "Landroidx/collection/LongList;", "emptyLongList", "longListOf", "element1", "", "element2", "element3", "elements", "", "mutableLongListOf", "Landroidx/collection/MutableLongList;", "collection"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class LongListKt {
    private static final LongList EmptyLongList = null;

    static {
        EmptyLongList = (LongList) ZeusTransformUtils.preCheckCast(new MutableLongList(0), LongList.class, "com.obric.memorydata.plugin");
    }

    public static final LongList emptyLongList() {
        return EmptyLongList;
    }

    public static final LongList longListOf() {
        return EmptyLongList;
    }

    public static final LongList longListOf(long r1) {
        return (LongList) ZeusTransformUtils.preCheckCast(mutableLongListOf(r1), LongList.class, "com.obric.memorydata.plugin");
    }

    public static final LongList longListOf(long r0, long r2) {
        return (LongList) ZeusTransformUtils.preCheckCast(mutableLongListOf(r0, r2), LongList.class, "com.obric.memorydata.plugin");
    }

    public static final LongList longListOf(long r0, long r2, long r4) {
        return (LongList) ZeusTransformUtils.preCheckCast(mutableLongListOf(r0, r2, r4), LongList.class, "com.obric.memorydata.plugin");
    }

    public static final LongList longListOf(long... r2) {
        Intrinsics.checkNotNullParameter(r2, "elements");
        MutableLongList r0 = new MutableLongList(r2.length);
        r0.plusAssign(r2);
        return (LongList) ZeusTransformUtils.preCheckCast(r0, LongList.class, "com.obric.memorydata.plugin");
    }

    public static final MutableLongList mutableLongListOf() {
        return new MutableLongList(0, 1, null);
    }

    public static final MutableLongList mutableLongListOf(long r2) {
        MutableLongList r0 = new MutableLongList(1);
        r0.add(r2);
        return r0;
    }

    public static final MutableLongList mutableLongListOf(long r2, long r4) {
        MutableLongList r0 = new MutableLongList(2);
        r0.add(r2);
        r0.add(r4);
        return r0;
    }

    public static final MutableLongList mutableLongListOf(long r2, long r4, long r6) {
        MutableLongList r0 = new MutableLongList(3);
        r0.add(r2);
        r0.add(r4);
        r0.add(r6);
        return r0;
    }

    public static final MutableLongList mutableLongListOf(long... r2) {
        Intrinsics.checkNotNullParameter(r2, "elements");
        MutableLongList r0 = new MutableLongList(r2.length);
        r0.plusAssign(r2);
        return r0;
    }
}
