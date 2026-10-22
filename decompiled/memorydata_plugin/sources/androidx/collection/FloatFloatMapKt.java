package androidx.collection;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000b\u001a\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0006\u0010\u0004\u001a\u00020\u0003\u001a\u0016\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006\u001a&\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006\u001a6\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006\u001aF\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006\u001aV\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006\u001a\u0006\u0010\u0010\u001a\u00020\u0001\u001a\u0016\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006\u001a&\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006\u001a6\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006\u001aF\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006\u001aV\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"EmptyFloatFloatMap", "Landroidx/collection/MutableFloatFloatMap;", "emptyFloatFloatMap", "Landroidx/collection/FloatFloatMap;", "floatFloatMapOf", "key1", "", "value1", "key2", "value2", "key3", "value3", "key4", "value4", "key5", "value5", "mutableFloatFloatMapOf", "collection"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class FloatFloatMapKt {
    private static final MutableFloatFloatMap EmptyFloatFloatMap = null;

    static {
        EmptyFloatFloatMap = new MutableFloatFloatMap(0);
    }

    public static final FloatFloatMap emptyFloatFloatMap() {
        return (FloatFloatMap) ZeusTransformUtils.preCheckCast(EmptyFloatFloatMap, FloatFloatMap.class, "com.obric.memorydata.plugin");
    }

    public static final FloatFloatMap floatFloatMapOf() {
        return (FloatFloatMap) ZeusTransformUtils.preCheckCast(EmptyFloatFloatMap, FloatFloatMap.class, "com.obric.memorydata.plugin");
    }

    public static final FloatFloatMap floatFloatMapOf(float r4, float r5) {
        MutableFloatFloatMap r0 = new MutableFloatFloatMap(0, 1, null);
        r0.set(r4, r5);
        return (FloatFloatMap) ZeusTransformUtils.preCheckCast(r0, FloatFloatMap.class, "com.obric.memorydata.plugin");
    }

    public static final FloatFloatMap floatFloatMapOf(float r4, float r5, float r6, float r7) {
        MutableFloatFloatMap r0 = new MutableFloatFloatMap(0, 1, null);
        r0.set(r4, r5);
        r0.set(r6, r7);
        return (FloatFloatMap) ZeusTransformUtils.preCheckCast(r0, FloatFloatMap.class, "com.obric.memorydata.plugin");
    }

    public static final FloatFloatMap floatFloatMapOf(float r4, float r5, float r6, float r7, float r8, float r9) {
        MutableFloatFloatMap r0 = new MutableFloatFloatMap(0, 1, null);
        r0.set(r4, r5);
        r0.set(r6, r7);
        r0.set(r8, r9);
        return (FloatFloatMap) ZeusTransformUtils.preCheckCast(r0, FloatFloatMap.class, "com.obric.memorydata.plugin");
    }

    public static final FloatFloatMap floatFloatMapOf(float r4, float r5, float r6, float r7, float r8, float r9, float r10, float r11) {
        MutableFloatFloatMap r0 = new MutableFloatFloatMap(0, 1, null);
        r0.set(r4, r5);
        r0.set(r6, r7);
        r0.set(r8, r9);
        r0.set(r10, r11);
        return (FloatFloatMap) ZeusTransformUtils.preCheckCast(r0, FloatFloatMap.class, "com.obric.memorydata.plugin");
    }

    public static final FloatFloatMap floatFloatMapOf(float r4, float r5, float r6, float r7, float r8, float r9, float r10, float r11, float r12, float r13) {
        MutableFloatFloatMap r0 = new MutableFloatFloatMap(0, 1, null);
        r0.set(r4, r5);
        r0.set(r6, r7);
        r0.set(r8, r9);
        r0.set(r10, r11);
        r0.set(r12, r13);
        return (FloatFloatMap) ZeusTransformUtils.preCheckCast(r0, FloatFloatMap.class, "com.obric.memorydata.plugin");
    }

    public static final MutableFloatFloatMap mutableFloatFloatMapOf() {
        return new MutableFloatFloatMap(0, 1, null);
    }

    public static final MutableFloatFloatMap mutableFloatFloatMapOf(float r4, float r5) {
        MutableFloatFloatMap r0 = new MutableFloatFloatMap(0, 1, null);
        r0.set(r4, r5);
        return r0;
    }

    public static final MutableFloatFloatMap mutableFloatFloatMapOf(float r4, float r5, float r6, float r7) {
        MutableFloatFloatMap r0 = new MutableFloatFloatMap(0, 1, null);
        r0.set(r4, r5);
        r0.set(r6, r7);
        return r0;
    }

    public static final MutableFloatFloatMap mutableFloatFloatMapOf(float r4, float r5, float r6, float r7, float r8, float r9) {
        MutableFloatFloatMap r0 = new MutableFloatFloatMap(0, 1, null);
        r0.set(r4, r5);
        r0.set(r6, r7);
        r0.set(r8, r9);
        return r0;
    }

    public static final MutableFloatFloatMap mutableFloatFloatMapOf(float r4, float r5, float r6, float r7, float r8, float r9, float r10, float r11) {
        MutableFloatFloatMap r0 = new MutableFloatFloatMap(0, 1, null);
        r0.set(r4, r5);
        r0.set(r6, r7);
        r0.set(r8, r9);
        r0.set(r10, r11);
        return r0;
    }

    public static final MutableFloatFloatMap mutableFloatFloatMapOf(float r4, float r5, float r6, float r7, float r8, float r9, float r10, float r11, float r12, float r13) {
        MutableFloatFloatMap r0 = new MutableFloatFloatMap(0, 1, null);
        r0.set(r4, r5);
        r0.set(r6, r7);
        r0.set(r8, r9);
        r0.set(r10, r11);
        r0.set(r12, r13);
        return r0;
    }
}
