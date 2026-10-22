package kotlin.reflect.jvm.internal.impl.name;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
public final class StandardClassIds {
    private static final ClassId Annotation = null;
    private static final ClassId AnnotationRetention = null;
    private static final ClassId AnnotationTarget = null;
    private static final ClassId Any = null;
    private static final ClassId Array = null;
    private static final FqName BASE_ANNOTATION_PACKAGE = null;
    private static final FqName BASE_COLLECTIONS_PACKAGE = null;
    private static final FqName BASE_COROUTINES_PACKAGE = null;
    private static final FqName BASE_INTERNAL_IR_PACKAGE = null;
    private static final FqName BASE_INTERNAL_PACKAGE = null;
    private static final FqName BASE_JVM_INTERNAL_PACKAGE = null;
    private static final FqName BASE_JVM_PACKAGE = null;
    private static final FqName BASE_KOTLIN_PACKAGE = null;
    private static final FqName BASE_RANGES_PACKAGE = null;
    private static final FqName BASE_REFLECT_PACKAGE = null;
    private static final ClassId Boolean = null;
    private static final ClassId Byte = null;
    private static final ClassId Char = null;
    private static final ClassId CharRange = null;
    private static final ClassId Cloneable = null;
    private static final ClassId Collection = null;
    private static final ClassId Comparable = null;
    private static final ClassId Continuation = null;
    private static final ClassId Double = null;
    private static final ClassId Enum = null;
    private static final ClassId Float = null;
    private static final ClassId Function = null;
    public static final StandardClassIds INSTANCE = null;
    private static final ClassId Int = null;
    private static final ClassId IntRange = null;
    private static final ClassId Iterable = null;
    private static final ClassId Iterator = null;
    private static final ClassId KCallable = null;
    private static final ClassId KClass = null;
    private static final ClassId KFunction = null;
    private static final ClassId KMutableProperty = null;
    private static final ClassId KMutableProperty0 = null;
    private static final ClassId KMutableProperty1 = null;
    private static final ClassId KMutableProperty2 = null;
    private static final ClassId KProperty = null;
    private static final ClassId KProperty0 = null;
    private static final ClassId KProperty1 = null;
    private static final ClassId KProperty2 = null;
    private static final ClassId List = null;
    private static final ClassId ListIterator = null;
    private static final ClassId Long = null;
    private static final ClassId LongRange = null;
    private static final ClassId Map = null;
    private static final ClassId MapEntry = null;
    private static final ClassId MutableCollection = null;
    private static final ClassId MutableIterable = null;
    private static final ClassId MutableIterator = null;
    private static final ClassId MutableList = null;
    private static final ClassId MutableListIterator = null;
    private static final ClassId MutableMap = null;
    private static final ClassId MutableMapEntry = null;
    private static final ClassId MutableSet = null;
    private static final ClassId Nothing = null;
    private static final ClassId Number = null;
    private static final ClassId Result = null;
    private static final ClassId Set = null;
    private static final ClassId Short = null;
    private static final ClassId String = null;
    private static final ClassId Throwable = null;
    private static final ClassId UByte = null;
    private static final ClassId UInt = null;
    private static final ClassId ULong = null;
    private static final ClassId UShort = null;
    private static final ClassId Unit = null;
    private static final Set<FqName> builtInsPackages = null;
    private static final Set<ClassId> constantAllowedTypes = null;
    private static final Map<ClassId, ClassId> elementTypeByPrimitiveArrayType = null;
    private static final Map<ClassId, ClassId> elementTypeByUnsignedArrayType = null;
    private static final Map<ClassId, ClassId> primitiveArrayTypeByElementType = null;
    private static final Set<ClassId> primitiveTypes = null;
    private static final Map<ClassId, ClassId> unsignedArrayTypeByElementType = null;
    private static final Set<ClassId> unsignedTypes = null;

    static {
        INSTANCE = new StandardClassIds();
        FqName r10 = new FqName("kotlin");
        BASE_KOTLIN_PACKAGE = r10;
        FqName r11 = r10.child(Name.identifier("reflect"));
        Intrinsics.checkNotNullExpressionValue(r11, "BASE_KOTLIN_PACKAGE.chil…me.identifier(\"reflect\"))");
        BASE_REFLECT_PACKAGE = r11;
        FqName r12 = r10.child(Name.identifier("collections"));
        Intrinsics.checkNotNullExpressionValue(r12, "BASE_KOTLIN_PACKAGE.chil…dentifier(\"collections\"))");
        BASE_COLLECTIONS_PACKAGE = r12;
        FqName r13 = r10.child(Name.identifier("ranges"));
        Intrinsics.checkNotNullExpressionValue(r13, "BASE_KOTLIN_PACKAGE.chil…ame.identifier(\"ranges\"))");
        BASE_RANGES_PACKAGE = r13;
        FqName r14 = r10.child(Name.identifier("jvm"));
        Intrinsics.checkNotNullExpressionValue(r14, "BASE_KOTLIN_PACKAGE.child(Name.identifier(\"jvm\"))");
        BASE_JVM_PACKAGE = r14;
        FqName r15 = r14.child(Name.identifier("internal"));
        Intrinsics.checkNotNullExpressionValue(r15, "BASE_JVM_PACKAGE.child(N…e.identifier(\"internal\"))");
        BASE_JVM_INTERNAL_PACKAGE = r15;
        FqName r16 = r10.child(Name.identifier("annotation"));
        Intrinsics.checkNotNullExpressionValue(r16, "BASE_KOTLIN_PACKAGE.chil…identifier(\"annotation\"))");
        BASE_ANNOTATION_PACKAGE = r16;
        FqName r17 = r10.child(Name.identifier("internal"));
        Intrinsics.checkNotNullExpressionValue(r17, "BASE_KOTLIN_PACKAGE.chil…e.identifier(\"internal\"))");
        BASE_INTERNAL_PACKAGE = r17;
        FqName r18 = r17.child(Name.identifier("ir"));
        Intrinsics.checkNotNullExpressionValue(r18, "BASE_INTERNAL_PACKAGE.child(Name.identifier(\"ir\"))");
        BASE_INTERNAL_IR_PACKAGE = r18;
        FqName r19 = r10.child(Name.identifier("coroutines"));
        Intrinsics.checkNotNullExpressionValue(r19, "BASE_KOTLIN_PACKAGE.chil…identifier(\"coroutines\"))");
        BASE_COROUTINES_PACKAGE = r19;
        builtInsPackages = SetsKt.setOf(new FqName[]{r10, r12, r13, r16, r11, r17, r19});
        Nothing = StandardClassIdsKt.access$baseId("Nothing");
        Unit = StandardClassIdsKt.access$baseId("Unit");
        Any = StandardClassIdsKt.access$baseId("Any");
        Enum = StandardClassIdsKt.access$baseId("Enum");
        Annotation = StandardClassIdsKt.access$baseId("Annotation");
        Array = StandardClassIdsKt.access$baseId("Array");
        ClassId r20 = StandardClassIdsKt.access$baseId("Boolean");
        Boolean = r20;
        ClassId r21 = StandardClassIdsKt.access$baseId("Char");
        Char = r21;
        ClassId r110 = StandardClassIdsKt.access$baseId("Byte");
        Byte = r110;
        ClassId r111 = StandardClassIdsKt.access$baseId("Short");
        Short = r111;
        ClassId r112 = StandardClassIdsKt.access$baseId("Int");
        Int = r112;
        ClassId r113 = StandardClassIdsKt.access$baseId("Long");
        Long = r113;
        ClassId r114 = StandardClassIdsKt.access$baseId("Float");
        Float = r114;
        ClassId r115 = StandardClassIdsKt.access$baseId("Double");
        Double = r115;
        UByte = StandardClassIdsKt.access$unsignedId(r110);
        UShort = StandardClassIdsKt.access$unsignedId(r111);
        UInt = StandardClassIdsKt.access$unsignedId(r112);
        ULong = StandardClassIdsKt.access$unsignedId(r113);
        String = StandardClassIdsKt.access$baseId("String");
        Throwable = StandardClassIdsKt.access$baseId("Throwable");
        Cloneable = StandardClassIdsKt.access$baseId("Cloneable");
        KProperty = StandardClassIdsKt.access$reflectId("KProperty");
        KMutableProperty = StandardClassIdsKt.access$reflectId("KMutableProperty");
        KProperty0 = StandardClassIdsKt.access$reflectId("KProperty0");
        KMutableProperty0 = StandardClassIdsKt.access$reflectId("KMutableProperty0");
        KProperty1 = StandardClassIdsKt.access$reflectId("KProperty1");
        KMutableProperty1 = StandardClassIdsKt.access$reflectId("KMutableProperty1");
        KProperty2 = StandardClassIdsKt.access$reflectId("KProperty2");
        KMutableProperty2 = StandardClassIdsKt.access$reflectId("KMutableProperty2");
        KFunction = StandardClassIdsKt.access$reflectId("KFunction");
        KClass = StandardClassIdsKt.access$reflectId("KClass");
        KCallable = StandardClassIdsKt.access$reflectId("KCallable");
        Comparable = StandardClassIdsKt.access$baseId("Comparable");
        Number = StandardClassIdsKt.access$baseId("Number");
        Function = StandardClassIdsKt.access$baseId("Function");
        Set<ClassId> r22 = SetsKt.setOf(new ClassId[]{r20, r21, r110, r111, r112, r113, r114, r115});
        primitiveTypes = r22;
        LinkedHashMap r23 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r22, 10)), 16));
        Iterator<T> r24 = r22.iterator();
    L4:
        if (r24.hasNext() == false) goto L6;
        Object r25 = r24.next();
        Name r116 = ((ClassId) r25).getShortClassName();
        Intrinsics.checkNotNullExpressionValue(r116, "id.shortClassName");
        r23.put(r25, StandardClassIdsKt.access$primitiveArrayId(r116));
        goto L4
    L6:
        primitiveArrayTypeByElementType = r23;
        elementTypeByPrimitiveArrayType = StandardClassIdsKt.access$inverseMap(r23);
        Set<ClassId> r26 = SetsKt.setOf(new ClassId[]{UByte, UShort, UInt, ULong});
        unsignedTypes = r26;
        LinkedHashMap r27 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r26, 10)), 16));
        Iterator<T> r28 = r26.iterator();
    L8:
        if (r28.hasNext() == false) goto L10;
        Object r29 = r28.next();
        Name r30 = ((ClassId) r29).getShortClassName();
        Intrinsics.checkNotNullExpressionValue(r30, "id.shortClassName");
        r27.put(r29, StandardClassIdsKt.access$primitiveArrayId(r30));
        goto L8
    L10:
        unsignedArrayTypeByElementType = r27;
        elementTypeByUnsignedArrayType = StandardClassIdsKt.access$inverseMap(r27);
        constantAllowedTypes = SetsKt.plus(SetsKt.plus(primitiveTypes, unsignedTypes), String);
        Continuation = StandardClassIdsKt.access$coroutinesId("Continuation");
        Iterator = StandardClassIdsKt.access$collectionsId("Iterator");
        Iterable = StandardClassIdsKt.access$collectionsId("Iterable");
        Collection = StandardClassIdsKt.access$collectionsId("Collection");
        List = StandardClassIdsKt.access$collectionsId("List");
        ListIterator = StandardClassIdsKt.access$collectionsId("ListIterator");
        Set = StandardClassIdsKt.access$collectionsId("Set");
        ClassId r31 = StandardClassIdsKt.access$collectionsId("Map");
        Map = r31;
        MutableIterator = StandardClassIdsKt.access$collectionsId("MutableIterator");
        MutableIterable = StandardClassIdsKt.access$collectionsId("MutableIterable");
        MutableCollection = StandardClassIdsKt.access$collectionsId("MutableCollection");
        MutableList = StandardClassIdsKt.access$collectionsId("MutableList");
        MutableListIterator = StandardClassIdsKt.access$collectionsId("MutableListIterator");
        MutableSet = StandardClassIdsKt.access$collectionsId("MutableSet");
        ClassId r32 = StandardClassIdsKt.access$collectionsId("MutableMap");
        MutableMap = r32;
        ClassId r33 = r31.createNestedClassId(Name.identifier("Entry"));
        Intrinsics.checkNotNullExpressionValue(r33, "Map.createNestedClassId(Name.identifier(\"Entry\"))");
        MapEntry = r33;
        ClassId r34 = r32.createNestedClassId(Name.identifier("MutableEntry"));
        Intrinsics.checkNotNullExpressionValue(r34, "MutableMap.createNestedC…entifier(\"MutableEntry\"))");
        MutableMapEntry = r34;
        Result = StandardClassIdsKt.access$baseId("Result");
        IntRange = StandardClassIdsKt.access$rangesId("IntRange");
        LongRange = StandardClassIdsKt.access$rangesId("LongRange");
        CharRange = StandardClassIdsKt.access$rangesId("CharRange");
        AnnotationRetention = StandardClassIdsKt.access$annotationId("AnnotationRetention");
        AnnotationTarget = StandardClassIdsKt.access$annotationId("AnnotationTarget");
    }

    private StandardClassIds() {
    }

    public final ClassId getArray() {
        return Array;
    }

    public final FqName getBASE_ANNOTATION_PACKAGE() {
        return BASE_ANNOTATION_PACKAGE;
    }

    public final FqName getBASE_COLLECTIONS_PACKAGE() {
        return BASE_COLLECTIONS_PACKAGE;
    }

    public final FqName getBASE_COROUTINES_PACKAGE() {
        return BASE_COROUTINES_PACKAGE;
    }

    public final FqName getBASE_KOTLIN_PACKAGE() {
        return BASE_KOTLIN_PACKAGE;
    }

    public final FqName getBASE_RANGES_PACKAGE() {
        return BASE_RANGES_PACKAGE;
    }

    public final FqName getBASE_REFLECT_PACKAGE() {
        return BASE_REFLECT_PACKAGE;
    }

    public final ClassId getKClass() {
        return KClass;
    }

    public final ClassId getKFunction() {
        return KFunction;
    }

    public final ClassId getMutableList() {
        return MutableList;
    }

    public final ClassId getMutableMap() {
        return MutableMap;
    }

    public final ClassId getMutableSet() {
        return MutableSet;
    }
}
