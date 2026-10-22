package androidx.collection;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\n\u001a\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0006\u0010\u0004\u001a\u00020\u0003\u001a\u0016\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b\u001a&\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b\u001a6\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\b\u001aF\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\b\u001aV\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\b\u001a\u0006\u0010\u0011\u001a\u00020\u0001\u001a\u0016\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b\u001a&\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b\u001a6\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\b\u001aF\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\b\u001aV\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"EmptyLongIntMap", "Landroidx/collection/MutableLongIntMap;", "emptyLongIntMap", "Landroidx/collection/LongIntMap;", "longIntMapOf", "key1", "", "value1", "", "key2", "value2", "key3", "value3", "key4", "value4", "key5", "value5", "mutableLongIntMapOf", "collection"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class LongIntMapKt {
    private static final MutableLongIntMap EmptyLongIntMap = null;

    static {
        EmptyLongIntMap = new MutableLongIntMap(0);
    }

    public static final LongIntMap emptyLongIntMap() {
        return (LongIntMap) ZeusTransformUtils.preCheckCast(EmptyLongIntMap, LongIntMap.class, "com.obric.memorydata.plugin");
    }

    public static final LongIntMap longIntMapOf() {
        return (LongIntMap) ZeusTransformUtils.preCheckCast(EmptyLongIntMap, LongIntMap.class, "com.obric.memorydata.plugin");
    }

    public static final LongIntMap longIntMapOf(long r4, int r6) {
        MutableLongIntMap r0 = new MutableLongIntMap(0, 1, null);
        r0.set(r4, r6);
        return (LongIntMap) ZeusTransformUtils.preCheckCast(r0, LongIntMap.class, "com.obric.memorydata.plugin");
    }

    public static final LongIntMap longIntMapOf(long r4, int r6, long r7, int r9) {
        MutableLongIntMap r0 = new MutableLongIntMap(0, 1, null);
        r0.set(r4, r6);
        r0.set(r7, r9);
        return (LongIntMap) ZeusTransformUtils.preCheckCast(r0, LongIntMap.class, "com.obric.memorydata.plugin");
    }

    public static final LongIntMap longIntMapOf(long r4, int r6, long r7, int r9, long r10, int r12) {
        MutableLongIntMap r0 = new MutableLongIntMap(0, 1, null);
        r0.set(r4, r6);
        r0.set(r7, r9);
        r0.set(r10, r12);
        return (LongIntMap) ZeusTransformUtils.preCheckCast(r0, LongIntMap.class, "com.obric.memorydata.plugin");
    }

    public static final LongIntMap longIntMapOf(long r4, int r6, long r7, int r9, long r10, int r12, long r13, int r15) {
        MutableLongIntMap r0 = new MutableLongIntMap(0, 1, null);
        r0.set(r4, r6);
        r0.set(r7, r9);
        r0.set(r10, r12);
        r0.set(r13, r15);
        return (LongIntMap) ZeusTransformUtils.preCheckCast(r0, LongIntMap.class, "com.obric.memorydata.plugin");
    }

    public static final LongIntMap longIntMapOf(long r4, int r6, long r7, int r9, long r10, int r12, long r13, int r15, long r16, int r18) {
        MutableLongIntMap r0 = new MutableLongIntMap(0, 1, null);
        r0.set(r4, r6);
        r0.set(r7, r9);
        r0.set(r10, r12);
        r0.set(r13, r15);
        r0.set(r16, r18);
        return (LongIntMap) ZeusTransformUtils.preCheckCast(r0, LongIntMap.class, "com.obric.memorydata.plugin");
    }

    public static final MutableLongIntMap mutableLongIntMapOf() {
        return new MutableLongIntMap(0, 1, null);
    }

    public static final MutableLongIntMap mutableLongIntMapOf(long r4, int r6) {
        MutableLongIntMap r0 = new MutableLongIntMap(0, 1, null);
        r0.set(r4, r6);
        return r0;
    }

    public static final MutableLongIntMap mutableLongIntMapOf(long r4, int r6, long r7, int r9) {
        MutableLongIntMap r0 = new MutableLongIntMap(0, 1, null);
        r0.set(r4, r6);
        r0.set(r7, r9);
        return r0;
    }

    public static final MutableLongIntMap mutableLongIntMapOf(long r4, int r6, long r7, int r9, long r10, int r12) {
        MutableLongIntMap r0 = new MutableLongIntMap(0, 1, null);
        r0.set(r4, r6);
        r0.set(r7, r9);
        r0.set(r10, r12);
        return r0;
    }

    public static final MutableLongIntMap mutableLongIntMapOf(long r4, int r6, long r7, int r9, long r10, int r12, long r13, int r15) {
        MutableLongIntMap r0 = new MutableLongIntMap(0, 1, null);
        r0.set(r4, r6);
        r0.set(r7, r9);
        r0.set(r10, r12);
        r0.set(r13, r15);
        return r0;
    }

    public static final MutableLongIntMap mutableLongIntMapOf(long r4, int r6, long r7, int r9, long r10, int r12, long r13, int r15, long r16, int r18) {
        MutableLongIntMap r0 = new MutableLongIntMap(0, 1, null);
        r0.set(r4, r6);
        r0.set(r7, r9);
        r0.set(r10, r12);
        r0.set(r13, r15);
        r0.set(r16, r18);
        return r0;
    }
}
