package androidx.collection;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\n\u001a\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0006\u0010\u0004\u001a\u00020\u0003\u001a\u0016\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b\u001a&\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b\u001a6\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\b\u001aF\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\b\u001aV\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\b\u001a\u0006\u0010\u0011\u001a\u00020\u0001\u001a\u0016\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b\u001a&\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b\u001a6\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\b\u001aF\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\b\u001aV\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"EmptyFloatLongMap", "Landroidx/collection/MutableFloatLongMap;", "emptyFloatLongMap", "Landroidx/collection/FloatLongMap;", "floatLongMapOf", "key1", "", "value1", "", "key2", "value2", "key3", "value3", "key4", "value4", "key5", "value5", "mutableFloatLongMapOf", "collection"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class FloatLongMapKt {
    private static final MutableFloatLongMap EmptyFloatLongMap = null;

    static {
        EmptyFloatLongMap = new MutableFloatLongMap(0);
    }

    public static final FloatLongMap emptyFloatLongMap() {
        return (FloatLongMap) ZeusTransformUtils.preCheckCast(EmptyFloatLongMap, FloatLongMap.class, "com.obric.memorydata.plugin");
    }

    public static final FloatLongMap floatLongMapOf() {
        return (FloatLongMap) ZeusTransformUtils.preCheckCast(EmptyFloatLongMap, FloatLongMap.class, "com.obric.memorydata.plugin");
    }

    public static final FloatLongMap floatLongMapOf(float r4, long r5) {
        MutableFloatLongMap r0 = new MutableFloatLongMap(0, 1, null);
        r0.set(r4, r5);
        return (FloatLongMap) ZeusTransformUtils.preCheckCast(r0, FloatLongMap.class, "com.obric.memorydata.plugin");
    }

    public static final FloatLongMap floatLongMapOf(float r4, long r5, float r7, long r8) {
        MutableFloatLongMap r0 = new MutableFloatLongMap(0, 1, null);
        r0.set(r4, r5);
        r0.set(r7, r8);
        return (FloatLongMap) ZeusTransformUtils.preCheckCast(r0, FloatLongMap.class, "com.obric.memorydata.plugin");
    }

    public static final FloatLongMap floatLongMapOf(float r4, long r5, float r7, long r8, float r10, long r11) {
        MutableFloatLongMap r0 = new MutableFloatLongMap(0, 1, null);
        r0.set(r4, r5);
        r0.set(r7, r8);
        r0.set(r10, r11);
        return (FloatLongMap) ZeusTransformUtils.preCheckCast(r0, FloatLongMap.class, "com.obric.memorydata.plugin");
    }

    public static final FloatLongMap floatLongMapOf(float r4, long r5, float r7, long r8, float r10, long r11, float r13, long r14) {
        MutableFloatLongMap r0 = new MutableFloatLongMap(0, 1, null);
        r0.set(r4, r5);
        r0.set(r7, r8);
        r0.set(r10, r11);
        r0.set(r13, r14);
        return (FloatLongMap) ZeusTransformUtils.preCheckCast(r0, FloatLongMap.class, "com.obric.memorydata.plugin");
    }

    public static final FloatLongMap floatLongMapOf(float r4, long r5, float r7, long r8, float r10, long r11, float r13, long r14, float r16, long r17) {
        MutableFloatLongMap r0 = new MutableFloatLongMap(0, 1, null);
        r0.set(r4, r5);
        r0.set(r7, r8);
        r0.set(r10, r11);
        r0.set(r13, r14);
        r0.set(r16, r17);
        return (FloatLongMap) ZeusTransformUtils.preCheckCast(r0, FloatLongMap.class, "com.obric.memorydata.plugin");
    }

    public static final MutableFloatLongMap mutableFloatLongMapOf() {
        return new MutableFloatLongMap(0, 1, null);
    }

    public static final MutableFloatLongMap mutableFloatLongMapOf(float r4, long r5) {
        MutableFloatLongMap r0 = new MutableFloatLongMap(0, 1, null);
        r0.set(r4, r5);
        return r0;
    }

    public static final MutableFloatLongMap mutableFloatLongMapOf(float r4, long r5, float r7, long r8) {
        MutableFloatLongMap r0 = new MutableFloatLongMap(0, 1, null);
        r0.set(r4, r5);
        r0.set(r7, r8);
        return r0;
    }

    public static final MutableFloatLongMap mutableFloatLongMapOf(float r4, long r5, float r7, long r8, float r10, long r11) {
        MutableFloatLongMap r0 = new MutableFloatLongMap(0, 1, null);
        r0.set(r4, r5);
        r0.set(r7, r8);
        r0.set(r10, r11);
        return r0;
    }

    public static final MutableFloatLongMap mutableFloatLongMapOf(float r4, long r5, float r7, long r8, float r10, long r11, float r13, long r14) {
        MutableFloatLongMap r0 = new MutableFloatLongMap(0, 1, null);
        r0.set(r4, r5);
        r0.set(r7, r8);
        r0.set(r10, r11);
        r0.set(r13, r14);
        return r0;
    }

    public static final MutableFloatLongMap mutableFloatLongMapOf(float r4, long r5, float r7, long r8, float r10, long r11, float r13, long r14, float r16, long r17) {
        MutableFloatLongMap r0 = new MutableFloatLongMap(0, 1, null);
        r0.set(r4, r5);
        r0.set(r7, r8);
        r0.set(r10, r11);
        r0.set(r13, r14);
        r0.set(r16, r17);
        return r0;
    }
}
