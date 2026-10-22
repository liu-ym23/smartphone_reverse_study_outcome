package androidx.core.util;

import android.util.SparseLongArray;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.IntIterator;
import kotlin.collections.LongIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u001a\u0015\u0010\u0005\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0001H\u0087\n\u001a\u0015\u0010\b\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0001H\u0087\b\u001a\u0015\u0010\t\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0087\b\u001aE\u0010\f\u001a\u00020\r*\u00020\u000226\u0010\u000e\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\r0\u000fH\u0087\b\u001a\u001d\u0010\u0012\u001a\u00020\u000b*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u000bH\u0087\b\u001a#\u0010\u0014\u001a\u00020\u000b*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0015H\u0087\b\u001a\r\u0010\u0016\u001a\u00020\u0006*\u00020\u0002H\u0087\b\u001a\r\u0010\u0017\u001a\u00020\u0006*\u00020\u0002H\u0087\b\u001a\f\u0010\u0018\u001a\u00020\u0019*\u00020\u0002H\u0007\u001a\u0015\u0010\u001a\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0002H\u0087\u0002\u001a\u0014\u0010\u001c\u001a\u00020\r*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0002H\u0007\u001a\u001c\u0010\u001d\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000bH\u0007\u001a\u001d\u0010\u001e\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000bH\u0087\n\u001a\f\u0010\u001f\u001a\u00020 *\u00020\u0002H\u0007\"\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00028Ç\u0002¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006!"}, d2 = {"size", "", "Landroid/util/SparseLongArray;", "getSize", "(Landroid/util/SparseLongArray;)I", "contains", "", "key", "containsKey", "containsValue", EventBody.KEY_VALUE, "", "forEach", "", "action", "Lkotlin/Function2;", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "getOrDefault", "defaultValue", "getOrElse", "Lkotlin/Function0;", "isEmpty", "isNotEmpty", "keyIterator", "Lkotlin/collections/IntIterator;", "plus", "other", "putAll", "remove", "set", "valueIterator", "Lkotlin/collections/LongIterator;", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SparseLongArrayKt {
    public static final boolean contains(SparseLongArray r0, int r1) {
        if (r0.indexOfKey(r1) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean containsKey(SparseLongArray r0, int r1) {
        if (r0.indexOfKey(r1) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean containsValue(SparseLongArray r0, long r1) {
        if (r0.indexOfValue(r1) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final void forEach(SparseLongArray r5, Function2<? super Integer, ? super Long, Unit> r6) {
        Function2 r7 = (Function2) ZeusTransformUtils.wrapperContextForParams(r6, Function2.class, "com.obric.memorydata.plugin");
        int r0 = r5.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r7.invoke(Integer.valueOf(r5.keyAt(r1)), Long.valueOf(r5.valueAt(r1)));
        r1 = r1 + 1;
        goto L3
    }

    public static final long getOrDefault(SparseLongArray r0, int r1, long r2) {
        return r0.get(r1, r2);
    }

    public static final long getOrElse(SparseLongArray r2, int r3, Function0<Long> r4) {
        Function0 r5 = (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin");
        int r6 = r2.indexOfKey(r3);
        if (r6 < 0) goto L6;
        return r2.valueAt(r6);
    L6:
        return ((Number) ZeusTransformUtils.preCheckCast(r5.invoke(), Number.class, "com.obric.memorydata.plugin")).longValue();
    }

    public static final int getSize(SparseLongArray r0) {
        return r0.size();
    }

    public static final boolean isEmpty(SparseLongArray r0) {
        if (r0.size() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean isNotEmpty(SparseLongArray r0) {
        if (r0.size() == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final IntIterator keyIterator(final SparseLongArray r2) {
        return (IntIterator) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r2), IntIterator.class, "com.obric.memorydata.plugin");
    }

    public static final SparseLongArray plus(SparseLongArray r3, SparseLongArray r4) {
        SparseLongArray r0 = new SparseLongArray(r3.size() + r4.size());
        putAll(r0, r3);
        putAll(r0, r4);
        return r0;
    }

    public static final void putAll(SparseLongArray r5, SparseLongArray r6) {
        int r0 = r6.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r5.put(r6.keyAt(r1), r6.valueAt(r1));
        r1 = r1 + 1;
        goto L3
    }

    public static final boolean remove(SparseLongArray r2, int r3, long r4) {
        int r5 = r2.indexOfKey(r3);
        if (r5 >= 0) goto L5;
        return false;
    L5:
        if (r4 != r2.valueAt(r5)) goto L10;
        r2.removeAt(r5);
        return true;
    L10:
        return false;
    }

    public static final void set(SparseLongArray r0, int r1, long r2) {
        r0.put(r1, r2);
    }

    public static final LongIterator valueIterator(final SparseLongArray r2) {
        return (LongIterator) ZeusTransformUtils.preCheckCast(new C09251(r2), LongIterator.class, "com.obric.memorydata.plugin");
    }
}
