package androidx.collection;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\n\u001a\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0006\u0010\u0004\u001a\u00020\u0003\u001a\u0016\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b\u001a&\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b\u001a6\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\b\u001aF\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\b\u001aV\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\b\u001a\u0006\u0010\u0011\u001a\u00020\u0001\u001a\u0016\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b\u001a&\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b\u001a6\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\b\u001aF\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\b\u001aV\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"EmptyFloatIntMap", "Landroidx/collection/MutableFloatIntMap;", "emptyFloatIntMap", "Landroidx/collection/FloatIntMap;", "floatIntMapOf", "key1", "", "value1", "", "key2", "value2", "key3", "value3", "key4", "value4", "key5", "value5", "mutableFloatIntMapOf", "collection"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class FloatIntMapKt {
    private static final MutableFloatIntMap EmptyFloatIntMap = null;

    static {
        EmptyFloatIntMap = new MutableFloatIntMap(0);
    }

    public static final FloatIntMap emptyFloatIntMap() {
        return (FloatIntMap) ZeusTransformUtils.preCheckCast(EmptyFloatIntMap, FloatIntMap.class, "com.obric.memorydata.plugin");
    }

    public static final FloatIntMap floatIntMapOf() {
        return (FloatIntMap) ZeusTransformUtils.preCheckCast(EmptyFloatIntMap, FloatIntMap.class, "com.obric.memorydata.plugin");
    }

    public static final FloatIntMap floatIntMapOf(float r4, int r5) {
        MutableFloatIntMap r0 = new MutableFloatIntMap(0, 1, null);
        r0.set(r4, r5);
        return (FloatIntMap) ZeusTransformUtils.preCheckCast(r0, FloatIntMap.class, "com.obric.memorydata.plugin");
    }

    public static final FloatIntMap floatIntMapOf(float r4, int r5, float r6, int r7) {
        MutableFloatIntMap r0 = new MutableFloatIntMap(0, 1, null);
        r0.set(r4, r5);
        r0.set(r6, r7);
        return (FloatIntMap) ZeusTransformUtils.preCheckCast(r0, FloatIntMap.class, "com.obric.memorydata.plugin");
    }

    public static final FloatIntMap floatIntMapOf(float r4, int r5, float r6, int r7, float r8, int r9) {
        MutableFloatIntMap r0 = new MutableFloatIntMap(0, 1, null);
        r0.set(r4, r5);
        r0.set(r6, r7);
        r0.set(r8, r9);
        return (FloatIntMap) ZeusTransformUtils.preCheckCast(r0, FloatIntMap.class, "com.obric.memorydata.plugin");
    }

    public static final FloatIntMap floatIntMapOf(float r4, int r5, float r6, int r7, float r8, int r9, float r10, int r11) {
        MutableFloatIntMap r0 = new MutableFloatIntMap(0, 1, null);
        r0.set(r4, r5);
        r0.set(r6, r7);
        r0.set(r8, r9);
        r0.set(r10, r11);
        return (FloatIntMap) ZeusTransformUtils.preCheckCast(r0, FloatIntMap.class, "com.obric.memorydata.plugin");
    }

    public static final FloatIntMap floatIntMapOf(float r4, int r5, float r6, int r7, float r8, int r9, float r10, int r11, float r12, int r13) {
        MutableFloatIntMap r0 = new MutableFloatIntMap(0, 1, null);
        r0.set(r4, r5);
        r0.set(r6, r7);
        r0.set(r8, r9);
        r0.set(r10, r11);
        r0.set(r12, r13);
        return (FloatIntMap) ZeusTransformUtils.preCheckCast(r0, FloatIntMap.class, "com.obric.memorydata.plugin");
    }

    public static final MutableFloatIntMap mutableFloatIntMapOf() {
        return new MutableFloatIntMap(0, 1, null);
    }

    public static final MutableFloatIntMap mutableFloatIntMapOf(float r4, int r5) {
        MutableFloatIntMap r0 = new MutableFloatIntMap(0, 1, null);
        r0.set(r4, r5);
        return r0;
    }

    public static final MutableFloatIntMap mutableFloatIntMapOf(float r4, int r5, float r6, int r7) {
        MutableFloatIntMap r0 = new MutableFloatIntMap(0, 1, null);
        r0.set(r4, r5);
        r0.set(r6, r7);
        return r0;
    }

    public static final MutableFloatIntMap mutableFloatIntMapOf(float r4, int r5, float r6, int r7, float r8, int r9) {
        MutableFloatIntMap r0 = new MutableFloatIntMap(0, 1, null);
        r0.set(r4, r5);
        r0.set(r6, r7);
        r0.set(r8, r9);
        return r0;
    }

    public static final MutableFloatIntMap mutableFloatIntMapOf(float r4, int r5, float r6, int r7, float r8, int r9, float r10, int r11) {
        MutableFloatIntMap r0 = new MutableFloatIntMap(0, 1, null);
        r0.set(r4, r5);
        r0.set(r6, r7);
        r0.set(r8, r9);
        r0.set(r10, r11);
        return r0;
    }

    public static final MutableFloatIntMap mutableFloatIntMapOf(float r4, int r5, float r6, int r7, float r8, int r9, float r10, int r11, float r12, int r13) {
        MutableFloatIntMap r0 = new MutableFloatIntMap(0, 1, null);
        r0.set(r4, r5);
        r0.set(r6, r7);
        r0.set(r8, r9);
        r0.set(r10, r11);
        r0.set(r12, r13);
        return r0;
    }
}
