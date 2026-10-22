package androidx.collection;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\u001a\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0006\u0010\u0004\u001a\u00020\u0003\u001a\u0016\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b\u001a&\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b\u001a6\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\b\u001aF\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\b\u001aV\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\b\u001a\u0006\u0010\u0011\u001a\u00020\u0001\u001a\u0016\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b\u001a&\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b\u001a6\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\b\u001aF\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\b\u001aV\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"EmptyIntFloatMap", "Landroidx/collection/MutableIntFloatMap;", "emptyIntFloatMap", "Landroidx/collection/IntFloatMap;", "intFloatMapOf", "key1", "", "value1", "", "key2", "value2", "key3", "value3", "key4", "value4", "key5", "value5", "mutableIntFloatMapOf", "collection"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class IntFloatMapKt {
    private static final MutableIntFloatMap EmptyIntFloatMap = null;

    static {
        EmptyIntFloatMap = new MutableIntFloatMap(0);
    }

    public static final IntFloatMap emptyIntFloatMap() {
        return (IntFloatMap) ZeusTransformUtils.preCheckCast(EmptyIntFloatMap, IntFloatMap.class, "com.obric.memorydata.plugin");
    }

    public static final IntFloatMap intFloatMapOf() {
        return (IntFloatMap) ZeusTransformUtils.preCheckCast(EmptyIntFloatMap, IntFloatMap.class, "com.obric.memorydata.plugin");
    }

    public static final IntFloatMap intFloatMapOf(int r4, float r5) {
        MutableIntFloatMap r0 = new MutableIntFloatMap(0, 1, null);
        r0.set(r4, r5);
        return (IntFloatMap) ZeusTransformUtils.preCheckCast(r0, IntFloatMap.class, "com.obric.memorydata.plugin");
    }

    public static final IntFloatMap intFloatMapOf(int r4, float r5, int r6, float r7) {
        MutableIntFloatMap r0 = new MutableIntFloatMap(0, 1, null);
        r0.set(r4, r5);
        r0.set(r6, r7);
        return (IntFloatMap) ZeusTransformUtils.preCheckCast(r0, IntFloatMap.class, "com.obric.memorydata.plugin");
    }

    public static final IntFloatMap intFloatMapOf(int r4, float r5, int r6, float r7, int r8, float r9) {
        MutableIntFloatMap r0 = new MutableIntFloatMap(0, 1, null);
        r0.set(r4, r5);
        r0.set(r6, r7);
        r0.set(r8, r9);
        return (IntFloatMap) ZeusTransformUtils.preCheckCast(r0, IntFloatMap.class, "com.obric.memorydata.plugin");
    }

    public static final IntFloatMap intFloatMapOf(int r4, float r5, int r6, float r7, int r8, float r9, int r10, float r11) {
        MutableIntFloatMap r0 = new MutableIntFloatMap(0, 1, null);
        r0.set(r4, r5);
        r0.set(r6, r7);
        r0.set(r8, r9);
        r0.set(r10, r11);
        return (IntFloatMap) ZeusTransformUtils.preCheckCast(r0, IntFloatMap.class, "com.obric.memorydata.plugin");
    }

    public static final IntFloatMap intFloatMapOf(int r4, float r5, int r6, float r7, int r8, float r9, int r10, float r11, int r12, float r13) {
        MutableIntFloatMap r0 = new MutableIntFloatMap(0, 1, null);
        r0.set(r4, r5);
        r0.set(r6, r7);
        r0.set(r8, r9);
        r0.set(r10, r11);
        r0.set(r12, r13);
        return (IntFloatMap) ZeusTransformUtils.preCheckCast(r0, IntFloatMap.class, "com.obric.memorydata.plugin");
    }

    public static final MutableIntFloatMap mutableIntFloatMapOf() {
        return new MutableIntFloatMap(0, 1, null);
    }

    public static final MutableIntFloatMap mutableIntFloatMapOf(int r4, float r5) {
        MutableIntFloatMap r0 = new MutableIntFloatMap(0, 1, null);
        r0.set(r4, r5);
        return r0;
    }

    public static final MutableIntFloatMap mutableIntFloatMapOf(int r4, float r5, int r6, float r7) {
        MutableIntFloatMap r0 = new MutableIntFloatMap(0, 1, null);
        r0.set(r4, r5);
        r0.set(r6, r7);
        return r0;
    }

    public static final MutableIntFloatMap mutableIntFloatMapOf(int r4, float r5, int r6, float r7, int r8, float r9) {
        MutableIntFloatMap r0 = new MutableIntFloatMap(0, 1, null);
        r0.set(r4, r5);
        r0.set(r6, r7);
        r0.set(r8, r9);
        return r0;
    }

    public static final MutableIntFloatMap mutableIntFloatMapOf(int r4, float r5, int r6, float r7, int r8, float r9, int r10, float r11) {
        MutableIntFloatMap r0 = new MutableIntFloatMap(0, 1, null);
        r0.set(r4, r5);
        r0.set(r6, r7);
        r0.set(r8, r9);
        r0.set(r10, r11);
        return r0;
    }

    public static final MutableIntFloatMap mutableIntFloatMapOf(int r4, float r5, int r6, float r7, int r8, float r9, int r10, float r11, int r12, float r13) {
        MutableIntFloatMap r0 = new MutableIntFloatMap(0, 1, null);
        r0.set(r4, r5);
        r0.set(r6, r7);
        r0.set(r8, r9);
        r0.set(r10, r11);
        r0.set(r12, r13);
        return r0;
    }
}
