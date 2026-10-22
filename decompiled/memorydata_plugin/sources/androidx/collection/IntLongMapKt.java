package androidx.collection;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\n\u001a\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0006\u0010\u0004\u001a\u00020\u0003\u001a\u0016\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b\u001a&\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b\u001a6\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\b\u001aF\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\b\u001aV\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\b\u001a\u0006\u0010\u0011\u001a\u00020\u0001\u001a\u0016\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b\u001a&\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b\u001a6\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\b\u001aF\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\b\u001aV\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"EmptyIntLongMap", "Landroidx/collection/MutableIntLongMap;", "emptyIntLongMap", "Landroidx/collection/IntLongMap;", "intLongMapOf", "key1", "", "value1", "", "key2", "value2", "key3", "value3", "key4", "value4", "key5", "value5", "mutableIntLongMapOf", "collection"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class IntLongMapKt {
    private static final MutableIntLongMap EmptyIntLongMap = null;

    static {
        EmptyIntLongMap = new MutableIntLongMap(0);
    }

    public static final IntLongMap emptyIntLongMap() {
        return (IntLongMap) ZeusTransformUtils.preCheckCast(EmptyIntLongMap, IntLongMap.class, "com.obric.memorydata.plugin");
    }

    public static final IntLongMap intLongMapOf() {
        return (IntLongMap) ZeusTransformUtils.preCheckCast(EmptyIntLongMap, IntLongMap.class, "com.obric.memorydata.plugin");
    }

    public static final IntLongMap intLongMapOf(int r4, long r5) {
        MutableIntLongMap r0 = new MutableIntLongMap(0, 1, null);
        r0.set(r4, r5);
        return (IntLongMap) ZeusTransformUtils.preCheckCast(r0, IntLongMap.class, "com.obric.memorydata.plugin");
    }

    public static final IntLongMap intLongMapOf(int r4, long r5, int r7, long r8) {
        MutableIntLongMap r0 = new MutableIntLongMap(0, 1, null);
        r0.set(r4, r5);
        r0.set(r7, r8);
        return (IntLongMap) ZeusTransformUtils.preCheckCast(r0, IntLongMap.class, "com.obric.memorydata.plugin");
    }

    public static final IntLongMap intLongMapOf(int r4, long r5, int r7, long r8, int r10, long r11) {
        MutableIntLongMap r0 = new MutableIntLongMap(0, 1, null);
        r0.set(r4, r5);
        r0.set(r7, r8);
        r0.set(r10, r11);
        return (IntLongMap) ZeusTransformUtils.preCheckCast(r0, IntLongMap.class, "com.obric.memorydata.plugin");
    }

    public static final IntLongMap intLongMapOf(int r4, long r5, int r7, long r8, int r10, long r11, int r13, long r14) {
        MutableIntLongMap r0 = new MutableIntLongMap(0, 1, null);
        r0.set(r4, r5);
        r0.set(r7, r8);
        r0.set(r10, r11);
        r0.set(r13, r14);
        return (IntLongMap) ZeusTransformUtils.preCheckCast(r0, IntLongMap.class, "com.obric.memorydata.plugin");
    }

    public static final IntLongMap intLongMapOf(int r4, long r5, int r7, long r8, int r10, long r11, int r13, long r14, int r16, long r17) {
        MutableIntLongMap r0 = new MutableIntLongMap(0, 1, null);
        r0.set(r4, r5);
        r0.set(r7, r8);
        r0.set(r10, r11);
        r0.set(r13, r14);
        r0.set(r16, r17);
        return (IntLongMap) ZeusTransformUtils.preCheckCast(r0, IntLongMap.class, "com.obric.memorydata.plugin");
    }

    public static final MutableIntLongMap mutableIntLongMapOf() {
        return new MutableIntLongMap(0, 1, null);
    }

    public static final MutableIntLongMap mutableIntLongMapOf(int r4, long r5) {
        MutableIntLongMap r0 = new MutableIntLongMap(0, 1, null);
        r0.set(r4, r5);
        return r0;
    }

    public static final MutableIntLongMap mutableIntLongMapOf(int r4, long r5, int r7, long r8) {
        MutableIntLongMap r0 = new MutableIntLongMap(0, 1, null);
        r0.set(r4, r5);
        r0.set(r7, r8);
        return r0;
    }

    public static final MutableIntLongMap mutableIntLongMapOf(int r4, long r5, int r7, long r8, int r10, long r11) {
        MutableIntLongMap r0 = new MutableIntLongMap(0, 1, null);
        r0.set(r4, r5);
        r0.set(r7, r8);
        r0.set(r10, r11);
        return r0;
    }

    public static final MutableIntLongMap mutableIntLongMapOf(int r4, long r5, int r7, long r8, int r10, long r11, int r13, long r14) {
        MutableIntLongMap r0 = new MutableIntLongMap(0, 1, null);
        r0.set(r4, r5);
        r0.set(r7, r8);
        r0.set(r10, r11);
        r0.set(r13, r14);
        return r0;
    }

    public static final MutableIntLongMap mutableIntLongMapOf(int r4, long r5, int r7, long r8, int r10, long r11, int r13, long r14, int r16, long r17) {
        MutableIntLongMap r0 = new MutableIntLongMap(0, 1, null);
        r0.set(r4, r5);
        r0.set(r7, r8);
        r0.set(r10, r11);
        r0.set(r13, r14);
        r0.set(r16, r17);
        return r0;
    }
}
