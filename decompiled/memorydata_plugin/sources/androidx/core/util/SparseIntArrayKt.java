package androidx.core.util;

import android.util.SparseIntArray;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0015\u0010\u0005\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0001H\u0086\n\u001a\u0015\u0010\b\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0001H\u0086\b\u001a\u0015\u0010\t\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\n\u001a\u00020\u0001H\u0086\b\u001aE\u0010\u000b\u001a\u00020\f*\u00020\u000226\u0010\r\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\f0\u000eH\u0086\b\u001a\u001d\u0010\u0011\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0001H\u0086\b\u001a#\u0010\u0013\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\u0014H\u0086\b\u001a\r\u0010\u0015\u001a\u00020\u0006*\u00020\u0002H\u0086\b\u001a\r\u0010\u0016\u001a\u00020\u0006*\u00020\u0002H\u0086\b\u001a\n\u0010\u0017\u001a\u00020\u0018*\u00020\u0002\u001a\u0015\u0010\u0019\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0002H\u0086\u0002\u001a\u0012\u0010\u001b\u001a\u00020\f*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0002\u001a\u001a\u0010\u001c\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u0001\u001a\u001d\u0010\u001d\u001a\u00020\f*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u0001H\u0086\n\u001a\n\u0010\u001e\u001a\u00020\u0018*\u00020\u0002\"\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u001f"}, d2 = {"size", "", "Landroid/util/SparseIntArray;", "getSize", "(Landroid/util/SparseIntArray;)I", "contains", "", "key", "containsKey", "containsValue", EventBody.KEY_VALUE, "forEach", "", "action", "Lkotlin/Function2;", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "getOrDefault", "defaultValue", "getOrElse", "Lkotlin/Function0;", "isEmpty", "isNotEmpty", "keyIterator", "Lkotlin/collections/IntIterator;", "plus", "other", "putAll", "remove", "set", "valueIterator", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SparseIntArrayKt {
    public static final boolean contains(SparseIntArray r0, int r1) {
        if (r0.indexOfKey(r1) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean containsKey(SparseIntArray r0, int r1) {
        if (r0.indexOfKey(r1) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean containsValue(SparseIntArray r0, int r1) {
        if (r0.indexOfValue(r1) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final void forEach(SparseIntArray r4, Function2<? super Integer, ? super Integer, Unit> r5) {
        Function2 r6 = (Function2) ZeusTransformUtils.wrapperContextForParams(r5, Function2.class, "com.obric.memorydata.plugin");
        int r0 = r4.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r6.invoke(Integer.valueOf(r4.keyAt(r1)), Integer.valueOf(r4.valueAt(r1)));
        r1 = r1 + 1;
        goto L3
    }

    public static final int getOrDefault(SparseIntArray r0, int r1, int r2) {
        return r0.get(r1, r2);
    }

    public static final int getOrElse(SparseIntArray r2, int r3, Function0<Integer> r4) {
        Function0 r5 = (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin");
        int r6 = r2.indexOfKey(r3);
        if (r6 < 0) goto L6;
        return r2.valueAt(r6);
    L6:
        return ((Number) ZeusTransformUtils.preCheckCast(r5.invoke(), Number.class, "com.obric.memorydata.plugin")).intValue();
    }

    public static final int getSize(SparseIntArray r0) {
        return r0.size();
    }

    public static final boolean isEmpty(SparseIntArray r0) {
        if (r0.size() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean isNotEmpty(SparseIntArray r0) {
        if (r0.size() == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final IntIterator keyIterator(final SparseIntArray r2) {
        return (IntIterator) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r2), IntIterator.class, "com.obric.memorydata.plugin");
    }

    public static final SparseIntArray plus(SparseIntArray r3, SparseIntArray r4) {
        SparseIntArray r0 = new SparseIntArray(r3.size() + r4.size());
        putAll(r0, r3);
        putAll(r0, r4);
        return r0;
    }

    public static final void putAll(SparseIntArray r4, SparseIntArray r5) {
        int r0 = r5.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r4.put(r5.keyAt(r1), r5.valueAt(r1));
        r1 = r1 + 1;
        goto L3
    }

    public static final boolean remove(SparseIntArray r1, int r2, int r3) {
        int r4 = r1.indexOfKey(r2);
        if (r4 >= 0) goto L5;
        return false;
    L5:
        if (r3 != r1.valueAt(r4)) goto L10;
        r1.removeAt(r4);
        return true;
    L10:
        return false;
    }

    public static final void set(SparseIntArray r0, int r1, int r2) {
        r0.put(r1, r2);
    }

    public static final IntIterator valueIterator(final SparseIntArray r2) {
        return (IntIterator) ZeusTransformUtils.preCheckCast(new C09241(r2), IntIterator.class, "com.obric.memorydata.plugin");
    }
}
