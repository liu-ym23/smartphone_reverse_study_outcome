package androidx.collection;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\u001a\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0006\u0010\u0004\u001a\u00020\u0003\u001a\u0016\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b\u001a&\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b\u001a6\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\b\u001aF\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\b\u001aV\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\b\u001a\u0006\u0010\u0011\u001a\u00020\u0001\u001a\u0016\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b\u001a&\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b\u001a6\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\b\u001aF\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\b\u001aV\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"EmptyLongFloatMap", "Landroidx/collection/MutableLongFloatMap;", "emptyLongFloatMap", "Landroidx/collection/LongFloatMap;", "longFloatMapOf", "key1", "", "value1", "", "key2", "value2", "key3", "value3", "key4", "value4", "key5", "value5", "mutableLongFloatMapOf", "collection"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class LongFloatMapKt {
    private static final MutableLongFloatMap EmptyLongFloatMap = null;

    static {
        EmptyLongFloatMap = new MutableLongFloatMap(0);
    }

    public static final LongFloatMap emptyLongFloatMap() {
        return (LongFloatMap) ZeusTransformUtils.preCheckCast(EmptyLongFloatMap, LongFloatMap.class, "com.obric.memorydata.plugin");
    }

    public static final LongFloatMap longFloatMapOf() {
        return (LongFloatMap) ZeusTransformUtils.preCheckCast(EmptyLongFloatMap, LongFloatMap.class, "com.obric.memorydata.plugin");
    }

    public static final LongFloatMap longFloatMapOf(long r4, float r6) {
        MutableLongFloatMap r0 = new MutableLongFloatMap(0, 1, null);
        r0.set(r4, r6);
        return (LongFloatMap) ZeusTransformUtils.preCheckCast(r0, LongFloatMap.class, "com.obric.memorydata.plugin");
    }

    public static final LongFloatMap longFloatMapOf(long r4, float r6, long r7, float r9) {
        MutableLongFloatMap r0 = new MutableLongFloatMap(0, 1, null);
        r0.set(r4, r6);
        r0.set(r7, r9);
        return (LongFloatMap) ZeusTransformUtils.preCheckCast(r0, LongFloatMap.class, "com.obric.memorydata.plugin");
    }

    public static final LongFloatMap longFloatMapOf(long r4, float r6, long r7, float r9, long r10, float r12) {
        MutableLongFloatMap r0 = new MutableLongFloatMap(0, 1, null);
        r0.set(r4, r6);
        r0.set(r7, r9);
        r0.set(r10, r12);
        return (LongFloatMap) ZeusTransformUtils.preCheckCast(r0, LongFloatMap.class, "com.obric.memorydata.plugin");
    }

    public static final LongFloatMap longFloatMapOf(long r4, float r6, long r7, float r9, long r10, float r12, long r13, float r15) {
        MutableLongFloatMap r0 = new MutableLongFloatMap(0, 1, null);
        r0.set(r4, r6);
        r0.set(r7, r9);
        r0.set(r10, r12);
        r0.set(r13, r15);
        return (LongFloatMap) ZeusTransformUtils.preCheckCast(r0, LongFloatMap.class, "com.obric.memorydata.plugin");
    }

    public static final LongFloatMap longFloatMapOf(long r4, float r6, long r7, float r9, long r10, float r12, long r13, float r15, long r16, float r18) {
        MutableLongFloatMap r0 = new MutableLongFloatMap(0, 1, null);
        r0.set(r4, r6);
        r0.set(r7, r9);
        r0.set(r10, r12);
        r0.set(r13, r15);
        r0.set(r16, r18);
        return (LongFloatMap) ZeusTransformUtils.preCheckCast(r0, LongFloatMap.class, "com.obric.memorydata.plugin");
    }

    public static final MutableLongFloatMap mutableLongFloatMapOf() {
        return new MutableLongFloatMap(0, 1, null);
    }

    public static final MutableLongFloatMap mutableLongFloatMapOf(long r4, float r6) {
        MutableLongFloatMap r0 = new MutableLongFloatMap(0, 1, null);
        r0.set(r4, r6);
        return r0;
    }

    public static final MutableLongFloatMap mutableLongFloatMapOf(long r4, float r6, long r7, float r9) {
        MutableLongFloatMap r0 = new MutableLongFloatMap(0, 1, null);
        r0.set(r4, r6);
        r0.set(r7, r9);
        return r0;
    }

    public static final MutableLongFloatMap mutableLongFloatMapOf(long r4, float r6, long r7, float r9, long r10, float r12) {
        MutableLongFloatMap r0 = new MutableLongFloatMap(0, 1, null);
        r0.set(r4, r6);
        r0.set(r7, r9);
        r0.set(r10, r12);
        return r0;
    }

    public static final MutableLongFloatMap mutableLongFloatMapOf(long r4, float r6, long r7, float r9, long r10, float r12, long r13, float r15) {
        MutableLongFloatMap r0 = new MutableLongFloatMap(0, 1, null);
        r0.set(r4, r6);
        r0.set(r7, r9);
        r0.set(r10, r12);
        r0.set(r13, r15);
        return r0;
    }

    public static final MutableLongFloatMap mutableLongFloatMapOf(long r4, float r6, long r7, float r9, long r10, float r12, long r13, float r15, long r16, float r18) {
        MutableLongFloatMap r0 = new MutableLongFloatMap(0, 1, null);
        r0.set(r4, r6);
        r0.set(r7, r9);
        r0.set(r10, r12);
        r0.set(r13, r15);
        r0.set(r16, r18);
        return r0;
    }
}
