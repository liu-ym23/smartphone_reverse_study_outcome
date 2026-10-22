package kotlin.collections;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.util.f;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010&\n\u0000\u001a0\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00030\u0001\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0002*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00020\u0005H\u0007\u001aZ\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\b0\u0007\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\t\"\u0004\b\u0002\u0010\b*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\t0\u00072\u001e\u0010\n\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\t0\f\u0012\u0004\u0012\u0002H\b0\u000bH\u0081\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\r"}, d2 = {"eachCount", "", "K", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/collections/Grouping;", "mapValuesInPlace", "", "R", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, f.f1488a, "Lkotlin/Function1;", "", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/collections/GroupingKt")
class GroupingKt__GroupingJVMKt {
    public GroupingKt__GroupingJVMKt() {
    }

    public static final <T, K> Map<K, Integer> eachCount(Grouping<T, ? extends K> r7) {
        Grouping r8 = (Grouping) ZeusTransformUtils.wrapperContextForParams(r7, Grouping.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "<this>");
        Map r0 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        Iterator<T> r2 = r8.sourceIterator();
    L4:
        if (r2.hasNext() == false) goto L14;
        Object r3 = r8.keyOf(r2.next());
        Object r4 = r0.get(r3);
        if (r4 == null) goto L8;
    L10:
        boolean r6 = false;
    L11:
        if (r6 == false) goto L13;
        r4 = new Ref.IntRef();
    L13:
        Ref.IntRef r5 = (Ref.IntRef) ZeusTransformUtils.preCheckCast(r4, Ref.IntRef.class, "com.obric.memorydata.plugin");
        r5.element++;
        r0.put(r3, r5);
        goto L4
    L8:
        if (r0.containsKey(r3) == true) goto L10;
        r6 = true;
        goto L11
    L14:
        Iterator<T> r9 = ((Iterable) ZeusTransformUtils.preCheckCast(r0.entrySet(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L16:
        if (r9.hasNext() == false) goto L19;
        Map.Entry r10 = (Map.Entry) ZeusTransformUtils.preCheckCast(r9.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type kotlin.collections.MutableMap.MutableEntry<K of kotlin.collections.GroupingKt__GroupingJVMKt.mapValuesInPlace$lambda$4, R of kotlin.collections.GroupingKt__GroupingJVMKt.mapValuesInPlace$lambda$4>");
        TypeIntrinsics.asMutableMapEntry(r10).setValue(Integer.valueOf(((Ref.IntRef) ZeusTransformUtils.preCheckCast(r10.getValue(), Ref.IntRef.class, "com.obric.memorydata.plugin")).element));
        goto L16
    L19:
        return TypeIntrinsics.asMutableMap(r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <K, V, R> Map<K, R> mapValuesInPlace(Map<K, V> r4, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        Function1 r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r7, f.f1488a);
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(r6.entrySet(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r0.hasNext() == false) goto L7;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r0.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type kotlin.collections.MutableMap.MutableEntry<K of kotlin.collections.GroupingKt__GroupingJVMKt.mapValuesInPlace$lambda$4, R of kotlin.collections.GroupingKt__GroupingJVMKt.mapValuesInPlace$lambda$4>");
        TypeIntrinsics.asMutableMapEntry(r2).setValue(r7.invoke(r2));
        goto L4
    L7:
        return TypeIntrinsics.asMutableMap(r6);
    }
}
