package kotlin.reflect.jvm.internal.impl.name;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nStandardClassIds.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StandardClassIds.kt\norg/jetbrains/kotlin/name/StandardClassIdsKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,265:1\n1179#2,2:266\n1253#2,4:268\n*S KotlinDebug\n*F\n+ 1 StandardClassIds.kt\norg/jetbrains/kotlin/name/StandardClassIdsKt\n*L\n264#1:266,2\n264#1:268,4\n*E\n"})
public final class StandardClassIdsKt {
    private static final FqName JAVA_LANG_ANNOTATION_PACKAGE = null;
    private static final FqName JAVA_LANG_PACKAGE = null;

    static {
        FqName r5 = new FqName("java.lang");
        JAVA_LANG_PACKAGE = r5;
        JAVA_LANG_ANNOTATION_PACKAGE = r5.child(Name.identifier("annotation"));
    }

    public static final /* synthetic */ ClassId access$annotationId(String r5) {
        return annotationId(r5);
    }

    public static final /* synthetic */ ClassId access$baseId(String r5) {
        return baseId(r5);
    }

    public static final /* synthetic */ ClassId access$collectionsId(String r5) {
        return collectionsId(r5);
    }

    public static final /* synthetic */ ClassId access$coroutinesId(String r5) {
        return coroutinesId(r5);
    }

    public static final /* synthetic */ ClassId access$enumsId(String r5) {
        return enumsId(r5);
    }

    public static final /* synthetic */ Map access$inverseMap(Map r5) {
        return inverseMap(r5);
    }

    public static final /* synthetic */ ClassId access$primitiveArrayId(Name r5) {
        return primitiveArrayId(r5);
    }

    public static final /* synthetic */ ClassId access$rangesId(String r5) {
        return rangesId(r5);
    }

    public static final /* synthetic */ ClassId access$reflectId(String r5) {
        return reflectId(r5);
    }

    public static final /* synthetic */ ClassId access$unsignedId(ClassId r5) {
        return unsignedId(r5);
    }

    private static final ClassId annotationId(String r5) {
        return new ClassId(StandardClassIds.INSTANCE.getBASE_ANNOTATION_PACKAGE(), Name.identifier(r5));
    }

    private static final ClassId baseId(String r5) {
        return new ClassId(StandardClassIds.INSTANCE.getBASE_KOTLIN_PACKAGE(), Name.identifier(r5));
    }

    private static final ClassId collectionsId(String r5) {
        return new ClassId(StandardClassIds.INSTANCE.getBASE_COLLECTIONS_PACKAGE(), Name.identifier(r5));
    }

    private static final ClassId coroutinesId(String r5) {
        return new ClassId(StandardClassIds.INSTANCE.getBASE_COROUTINES_PACKAGE(), Name.identifier(r5));
    }

    private static final ClassId enumsId(String r5) {
        return new ClassId(StandardClassIds.INSTANCE.getBASE_ENUMS_PACKAGE(), Name.identifier(r5));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <K, V> Map<V, K> inverseMap(Map<K, ? extends V> r5) {
        Set<Map.Entry<K, ? extends V>> r10 = r5.entrySet();
        LinkedHashMap r11 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.h(r10)), 16));
        Iterator<T> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        Map.Entry r13 = (Map.Entry) r12.next();
        Object r14 = r13.getKey();
        Pair r15 = TuplesKt.to(r13.getValue(), r14);
        r11.put(r15.getFirst(), r15.getSecond());
        goto L4
    L6:
        return r11;
    }

    private static final ClassId primitiveArrayId(Name r5) {
        StandardClassIds r10 = StandardClassIds.INSTANCE;
        return new ClassId(r10.getArray().getPackageFqName(), Name.identifier(r5.getIdentifier() + r10.getArray().getShortClassName().getIdentifier()));
    }

    private static final ClassId rangesId(String r5) {
        return new ClassId(StandardClassIds.INSTANCE.getBASE_RANGES_PACKAGE(), Name.identifier(r5));
    }

    private static final ClassId reflectId(String r5) {
        return new ClassId(StandardClassIds.INSTANCE.getBASE_REFLECT_PACKAGE(), Name.identifier(r5));
    }

    private static final ClassId unsignedId(ClassId r5) {
        return new ClassId(StandardClassIds.INSTANCE.getBASE_KOTLIN_PACKAGE(), Name.identifier("U" + r5.getShortClassName().getIdentifier()));
    }
}
