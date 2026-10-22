package kotlin.reflect.jvm.internal.impl.name;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class StandardClassIdsKt {
    public static final /* synthetic */ ClassId access$annotationId(String r0) {
        return annotationId(r0);
    }

    public static final /* synthetic */ ClassId access$baseId(String r0) {
        return baseId(r0);
    }

    public static final /* synthetic */ ClassId access$collectionsId(String r0) {
        return collectionsId(r0);
    }

    public static final /* synthetic */ ClassId access$coroutinesId(String r0) {
        return coroutinesId(r0);
    }

    public static final /* synthetic */ ClassId access$enumsId(String r0) {
        return enumsId(r0);
    }

    public static final /* synthetic */ Map access$inverseMap(Map r0) {
        return inverseMap(r0);
    }

    public static final /* synthetic */ ClassId access$primitiveArrayId(Name r0) {
        return primitiveArrayId(r0);
    }

    public static final /* synthetic */ ClassId access$rangesId(String r0) {
        return rangesId(r0);
    }

    public static final /* synthetic */ ClassId access$reflectId(String r0) {
        return reflectId(r0);
    }

    public static final /* synthetic */ ClassId access$unsignedId(ClassId r0) {
        return unsignedId(r0);
    }

    private static final ClassId annotationId(String r2) {
        return new ClassId(StandardClassIds.INSTANCE.getBASE_ANNOTATION_PACKAGE(), Name.identifier(r2));
    }

    private static final ClassId baseId(String r2) {
        return new ClassId(StandardClassIds.INSTANCE.getBASE_KOTLIN_PACKAGE(), Name.identifier(r2));
    }

    private static final ClassId collectionsId(String r2) {
        return new ClassId(StandardClassIds.INSTANCE.getBASE_COLLECTIONS_PACKAGE(), Name.identifier(r2));
    }

    private static final ClassId coroutinesId(String r2) {
        return new ClassId(StandardClassIds.INSTANCE.getBASE_COROUTINES_PACKAGE(), Name.identifier(r2));
    }

    private static final ClassId enumsId(String r2) {
        return new ClassId(StandardClassIds.INSTANCE.getBASE_ENUMS_PACKAGE(), Name.identifier(r2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <K, V> Map<V, K> inverseMap(Map<K, ? extends V> r3) {
        Set<Map.Entry<K, ? extends V>> r4 = r3.entrySet();
        LinkedHashMap r1 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r4, 10)), 16));
        Iterator<T> r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        Map.Entry r0 = (Map.Entry) r5.next();
        Object r2 = r0.getKey();
        Pair r6 = TuplesKt.to(r0.getValue(), r2);
        r1.put(r6.getFirst(), r6.getSecond());
        goto L4
    L6:
        return r1;
    }

    private static final ClassId primitiveArrayId(Name r4) {
        StandardClassIds r1 = StandardClassIds.INSTANCE;
        return new ClassId(r1.getArray().getPackageFqName(), Name.identifier(r4.getIdentifier() + r1.getArray().getShortClassName().getIdentifier()));
    }

    private static final ClassId rangesId(String r2) {
        return new ClassId(StandardClassIds.INSTANCE.getBASE_RANGES_PACKAGE(), Name.identifier(r2));
    }

    private static final ClassId reflectId(String r2) {
        return new ClassId(StandardClassIds.INSTANCE.getBASE_REFLECT_PACKAGE(), Name.identifier(r2));
    }

    private static final ClassId unsignedId(ClassId r4) {
        return new ClassId(StandardClassIds.INSTANCE.getBASE_KOTLIN_PACKAGE(), Name.identifier("U" + r4.getShortClassName().getIdentifier()));
    }
}
