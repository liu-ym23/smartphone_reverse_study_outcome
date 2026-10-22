package kotlin.reflect.jvm.internal.impl.name;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
public final class StandardClassIdsKt {
    private static final FqName JAVA_LANG_ANNOTATION_PACKAGE = null;
    private static final FqName JAVA_LANG_PACKAGE = null;

    static {
        FqName r10 = new FqName("java.lang");
        JAVA_LANG_PACKAGE = r10;
        FqName r11 = r10.child(Name.identifier("annotation"));
        Intrinsics.checkNotNullExpressionValue(r11, "JAVA_LANG_PACKAGE.child(…identifier(\"annotation\"))");
        JAVA_LANG_ANNOTATION_PACKAGE = r11;
    }

    public static final /* synthetic */ ClassId access$annotationId(String r10) {
        return annotationId(r10);
    }

    public static final /* synthetic */ ClassId access$baseId(String r10) {
        return baseId(r10);
    }

    public static final /* synthetic */ ClassId access$collectionsId(String r10) {
        return collectionsId(r10);
    }

    public static final /* synthetic */ ClassId access$coroutinesId(String r10) {
        return coroutinesId(r10);
    }

    public static final /* synthetic */ Map access$inverseMap(Map r10) {
        return inverseMap(r10);
    }

    public static final /* synthetic */ ClassId access$primitiveArrayId(Name r10) {
        return primitiveArrayId(r10);
    }

    public static final /* synthetic */ ClassId access$rangesId(String r10) {
        return rangesId(r10);
    }

    public static final /* synthetic */ ClassId access$reflectId(String r10) {
        return reflectId(r10);
    }

    public static final /* synthetic */ ClassId access$unsignedId(ClassId r10) {
        return unsignedId(r10);
    }

    private static final ClassId annotationId(String r10) {
        return new ClassId(StandardClassIds.INSTANCE.getBASE_ANNOTATION_PACKAGE(), Name.identifier(r10));
    }

    private static final ClassId baseId(String r10) {
        return new ClassId(StandardClassIds.INSTANCE.getBASE_KOTLIN_PACKAGE(), Name.identifier(r10));
    }

    private static final ClassId collectionsId(String r10) {
        return new ClassId(StandardClassIds.INSTANCE.getBASE_COLLECTIONS_PACKAGE(), Name.identifier(r10));
    }

    private static final ClassId coroutinesId(String r10) {
        return new ClassId(StandardClassIds.INSTANCE.getBASE_COROUTINES_PACKAGE(), Name.identifier(r10));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <K, V> Map<V, K> inverseMap(Map<K, ? extends V> r10) {
        Set<Map.Entry<K, ? extends V>> r11 = r10.entrySet();
        LinkedHashMap r12 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r11, 10)), 16));
        Iterator<T> r13 = r11.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        Map.Entry r14 = (Map.Entry) r13.next();
        Object r15 = r14.getKey();
        Pair r16 = TuplesKt.to(r14.getValue(), r15);
        r12.put(r16.getFirst(), r16.getSecond());
        goto L4
    L6:
        return r12;
    }

    private static final ClassId primitiveArrayId(Name r10) {
        StandardClassIds r11 = StandardClassIds.INSTANCE;
        return new ClassId(r11.getArray().getPackageFqName(), Name.identifier(r10.getIdentifier() + r11.getArray().getShortClassName().getIdentifier()));
    }

    private static final ClassId rangesId(String r10) {
        return new ClassId(StandardClassIds.INSTANCE.getBASE_RANGES_PACKAGE(), Name.identifier(r10));
    }

    private static final ClassId reflectId(String r10) {
        return new ClassId(StandardClassIds.INSTANCE.getBASE_REFLECT_PACKAGE(), Name.identifier(r10));
    }

    private static final ClassId unsignedId(ClassId r10) {
        return new ClassId(StandardClassIds.INSTANCE.getBASE_KOTLIN_PACKAGE(), Name.identifier('U' + r10.getShortClassName().getIdentifier()));
    }
}
