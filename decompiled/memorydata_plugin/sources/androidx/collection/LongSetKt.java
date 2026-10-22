package androidx.collection;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0016\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\u001a\u0006\u0010\u0006\u001a\u00020\u0007\u001a\u0011\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0080\b\u001a\u0006\u0010\f\u001a\u00020\u0007\u001a\u000e\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000b\u001a\u0016\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000b\u001a\u001e\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000b\u001a\u0012\u0010\f\u001a\u00020\u00072\n\u0010\u0010\u001a\u00020\u0001\"\u00020\u000b\u001a\u0006\u0010\u0011\u001a\u00020\u0005\u001a\u000e\u0010\u0011\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000b\u001a\u0016\u0010\u0011\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000b\u001a\u001e\u0010\u0011\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000b\u001a\u0012\u0010\u0011\u001a\u00020\u00052\n\u0010\u0010\u001a\u00020\u0001\"\u00020\u000b\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"EmptyLongArray", "", "getEmptyLongArray", "()[J", "EmptyLongSet", "Landroidx/collection/MutableLongSet;", "emptyLongSet", "Landroidx/collection/LongSet;", "hash", "", "k", "", "longSetOf", "element1", "element2", "element3", "elements", "mutableLongSetOf", "collection"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class LongSetKt {
    private static final long[] EmptyLongArray = null;
    private static final MutableLongSet EmptyLongSet = null;

    static {
        EmptyLongSet = new MutableLongSet(0);
        EmptyLongArray = new long[0];
    }

    public static final LongSet emptyLongSet() {
        return (LongSet) ZeusTransformUtils.preCheckCast(EmptyLongSet, LongSet.class, "com.obric.memorydata.plugin");
    }

    public static final long[] getEmptyLongArray() {
        return EmptyLongArray;
    }

    public static final int hash(long r0) {
        int r1 = Long.hashCode(r0) * ScatterMapKt.MurmurHashC1;
        return r1 ^ (r1 << 16);
    }

    public static final LongSet longSetOf() {
        return (LongSet) ZeusTransformUtils.preCheckCast(EmptyLongSet, LongSet.class, "com.obric.memorydata.plugin");
    }

    public static final LongSet longSetOf(long r1) {
        return (LongSet) ZeusTransformUtils.preCheckCast(mutableLongSetOf(r1), LongSet.class, "com.obric.memorydata.plugin");
    }

    public static final LongSet longSetOf(long r0, long r2) {
        return (LongSet) ZeusTransformUtils.preCheckCast(mutableLongSetOf(r0, r2), LongSet.class, "com.obric.memorydata.plugin");
    }

    public static final LongSet longSetOf(long r0, long r2, long r4) {
        return (LongSet) ZeusTransformUtils.preCheckCast(mutableLongSetOf(r0, r2, r4), LongSet.class, "com.obric.memorydata.plugin");
    }

    public static final LongSet longSetOf(long... r2) {
        Intrinsics.checkNotNullParameter(r2, "elements");
        MutableLongSet r0 = new MutableLongSet(r2.length);
        r0.plusAssign(r2);
        return (LongSet) ZeusTransformUtils.preCheckCast(r0, LongSet.class, "com.obric.memorydata.plugin");
    }

    public static final MutableLongSet mutableLongSetOf() {
        return new MutableLongSet(0, 1, null);
    }

    public static final MutableLongSet mutableLongSetOf(long r2) {
        MutableLongSet r0 = new MutableLongSet(1);
        r0.plusAssign(r2);
        return r0;
    }

    public static final MutableLongSet mutableLongSetOf(long r2, long r4) {
        MutableLongSet r0 = new MutableLongSet(2);
        r0.plusAssign(r2);
        r0.plusAssign(r4);
        return r0;
    }

    public static final MutableLongSet mutableLongSetOf(long r2, long r4, long r6) {
        MutableLongSet r0 = new MutableLongSet(3);
        r0.plusAssign(r2);
        r0.plusAssign(r4);
        r0.plusAssign(r6);
        return r0;
    }

    public static final MutableLongSet mutableLongSetOf(long... r2) {
        Intrinsics.checkNotNullParameter(r2, "elements");
        MutableLongSet r0 = new MutableLongSet(r2.length);
        r0.plusAssign(r2);
        return r0;
    }
}
