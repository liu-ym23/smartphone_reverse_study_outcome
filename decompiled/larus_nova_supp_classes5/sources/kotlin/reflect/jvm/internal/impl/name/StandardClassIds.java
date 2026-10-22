package kotlin.reflect.jvm.internal.impl.name;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class StandardClassIds {
    private static final ClassId Annotation = null;
    private static final ClassId AnnotationRetention = null;
    private static final ClassId AnnotationTarget = null;
    private static final ClassId Any = null;
    private static final ClassId Array = null;
    private static final FqName BASE_ANNOTATION_PACKAGE = null;
    private static final FqName BASE_COLLECTIONS_PACKAGE = null;
    private static final FqName BASE_CONCURRENT_PACKAGE = null;
    private static final FqName BASE_CONTRACTS_PACKAGE = null;
    private static final FqName BASE_COROUTINES_PACKAGE = null;
    private static final FqName BASE_ENUMS_PACKAGE = null;
    private static final FqName BASE_INTERNAL_IR_PACKAGE = null;
    private static final FqName BASE_INTERNAL_PACKAGE = null;
    private static final FqName BASE_JVM_FUNCTIONS_PACKAGE = null;
    private static final FqName BASE_JVM_INTERNAL_PACKAGE = null;
    private static final FqName BASE_JVM_PACKAGE = null;
    private static final FqName BASE_KOTLIN_PACKAGE = null;
    private static final FqName BASE_RANGES_PACKAGE = null;
    private static final FqName BASE_REFLECT_PACKAGE = null;
    private static final FqName BASE_TEST_PACKAGE = null;
    private static final ClassId Boolean = null;
    private static final ClassId Byte = null;
    private static final ClassId Char = null;
    private static final ClassId CharIterator = null;
    private static final ClassId CharRange = null;
    private static final ClassId CharSequence = null;
    private static final ClassId Cloneable = null;
    private static final ClassId Collection = null;
    private static final ClassId Comparable = null;
    private static final ClassId Continuation = null;
    private static final ClassId DeprecationLevel = null;
    private static final ClassId Double = null;
    private static final ClassId Enum = null;
    private static final ClassId EnumEntries = null;
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
    private static final ClassId KType = null;
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
    private static final Set<ClassId> allBuiltinTypes = null;
    private static final Set<FqName> builtInsPackages = null;
    private static final Set<FqName> builtInsPackagesWithDefaultNamedImport = null;
    private static final Set<ClassId> constantAllowedTypes = null;
    private static final Map<ClassId, ClassId> elementTypeByPrimitiveArrayType = null;
    private static final Map<ClassId, ClassId> elementTypeByUnsignedArrayType = null;
    private static final Map<ClassId, ClassId> primitiveArrayTypeByElementType = null;
    private static final Set<ClassId> primitiveTypes = null;
    private static final Map<ClassId, ClassId> unsignedArrayTypeByElementType = null;
    private static final Set<ClassId> unsignedTypes = null;

    private StandardClassIds() {
    }

    static {
        INSTANCE = new StandardClassIds();
        FqName r0 = new FqName("kotlin");
        BASE_KOTLIN_PACKAGE = r0;
        FqName r1 = r0.child(Name.identifier("reflect"));
        BASE_REFLECT_PACKAGE = r1;
        FqName r2 = r0.child(Name.identifier("collections"));
        BASE_COLLECTIONS_PACKAGE = r2;
        FqName r3 = r0.child(Name.identifier("ranges"));
        BASE_RANGES_PACKAGE = r3;
        FqName r4 = r0.child(Name.identifier("jvm"));
        BASE_JVM_PACKAGE = r4;
        BASE_JVM_INTERNAL_PACKAGE = r4.child(Name.identifier("internal"));
        BASE_JVM_FUNCTIONS_PACKAGE = r4.child(Name.identifier("functions"));
        FqName r5 = r0.child(Name.identifier("annotation"));
        BASE_ANNOTATION_PACKAGE = r5;
        FqName r6 = r0.child(Name.identifier("internal"));
        BASE_INTERNAL_PACKAGE = r6;
        BASE_INTERNAL_IR_PACKAGE = r6.child(Name.identifier("ir"));
        FqName r7 = r0.child(Name.identifier("coroutines"));
        BASE_COROUTINES_PACKAGE = r7;
        BASE_ENUMS_PACKAGE = r0.child(Name.identifier("enums"));
        BASE_CONTRACTS_PACKAGE = r0.child(Name.identifier("contracts"));
        BASE_CONCURRENT_PACKAGE = r0.child(Name.identifier("concurrent"));
        BASE_TEST_PACKAGE = r0.child(Name.identifier("test"));
        builtInsPackagesWithDefaultNamedImport = SetsKt.setOf(new FqName[]{r0, r2, r3, r5});
        builtInsPackages = SetsKt.setOf(new FqName[]{r0, r2, r3, r5, r1, r6, r7});
        Nothing = StandardClassIdsKt.access$baseId("Nothing");
        Unit = StandardClassIdsKt.access$baseId("Unit");
        Any = StandardClassIdsKt.access$baseId("Any");
        Enum = StandardClassIdsKt.access$baseId("Enum");
        Annotation = StandardClassIdsKt.access$baseId("Annotation");
        Array = StandardClassIdsKt.access$baseId("Array");
        ClassId r8 = StandardClassIdsKt.access$baseId("Boolean");
        Boolean = r8;
        ClassId r9 = StandardClassIdsKt.access$baseId("Char");
        Char = r9;
        ClassId r10 = StandardClassIdsKt.access$baseId("Byte");
        Byte = r10;
        ClassId r11 = StandardClassIdsKt.access$baseId("Short");
        Short = r11;
        ClassId r12 = StandardClassIdsKt.access$baseId("Int");
        Int = r12;
        ClassId r13 = StandardClassIdsKt.access$baseId("Long");
        Long = r13;
        ClassId r14 = StandardClassIdsKt.access$baseId("Float");
        Float = r14;
        ClassId r15 = StandardClassIdsKt.access$baseId("Double");
        Double = r15;
        UByte = StandardClassIdsKt.access$unsignedId(r10);
        UShort = StandardClassIdsKt.access$unsignedId(r11);
        UInt = StandardClassIdsKt.access$unsignedId(r12);
        ULong = StandardClassIdsKt.access$unsignedId(r13);
        CharSequence = StandardClassIdsKt.access$baseId("CharSequence");
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
        KType = StandardClassIdsKt.access$reflectId("KType");
        Comparable = StandardClassIdsKt.access$baseId("Comparable");
        Number = StandardClassIdsKt.access$baseId("Number");
        Function = StandardClassIdsKt.access$baseId("Function");
        Set<ClassId> r16 = SetsKt.setOf(new ClassId[]{r8, r9, r10, r11, r12, r13, r14, r15});
        primitiveTypes = r16;
        Set<ClassId> r17 = r16;
        LinkedHashMap r18 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r17, 10)), 16));
        Iterator<T> r19 = r17.iterator();
    L4:
        if (r19.hasNext() == false) goto L6;
        Object r20 = r19.next();
        r18.put(r20, StandardClassIdsKt.access$primitiveArrayId(((ClassId) r20).getShortClassName()));
        goto L4
    L6:
        primitiveArrayTypeByElementType = r18;
        elementTypeByPrimitiveArrayType = StandardClassIdsKt.access$inverseMap(r18);
        Set<ClassId> r21 = SetsKt.setOf(new ClassId[]{UByte, UShort, UInt, ULong});
        unsignedTypes = r21;
        Set<ClassId> r22 = r21;
        LinkedHashMap r23 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r22, 10)), 16));
        Iterator<T> r24 = r22.iterator();
    L8:
        if (r24.hasNext() == false) goto L10;
        Object r25 = r24.next();
        r23.put(r25, StandardClassIdsKt.access$primitiveArrayId(((ClassId) r25).getShortClassName()));
        goto L8
    L10:
        unsignedArrayTypeByElementType = r23;
        elementTypeByUnsignedArrayType = StandardClassIdsKt.access$inverseMap(r23);
        Set<ClassId> r26 = primitiveTypes;
        Set<ClassId> r27 = unsignedTypes;
        Set r28 = SetsKt.plus(r26, r27);
        ClassId r29 = String;
        constantAllowedTypes = SetsKt.plus(r28, r29);
        Continuation = StandardClassIdsKt.access$coroutinesId("Continuation");
        Iterator = StandardClassIdsKt.access$collectionsId("Iterator");
        Iterable = StandardClassIdsKt.access$collectionsId("Iterable");
        Collection = StandardClassIdsKt.access$collectionsId("Collection");
        List = StandardClassIdsKt.access$collectionsId("List");
        ListIterator = StandardClassIdsKt.access$collectionsId("ListIterator");
        Set = StandardClassIdsKt.access$collectionsId("Set");
        ClassId r30 = StandardClassIdsKt.access$collectionsId("Map");
        Map = r30;
        MutableIterator = StandardClassIdsKt.access$collectionsId("MutableIterator");
        CharIterator = StandardClassIdsKt.access$collectionsId("CharIterator");
        MutableIterable = StandardClassIdsKt.access$collectionsId("MutableIterable");
        MutableCollection = StandardClassIdsKt.access$collectionsId("MutableCollection");
        MutableList = StandardClassIdsKt.access$collectionsId("MutableList");
        MutableListIterator = StandardClassIdsKt.access$collectionsId("MutableListIterator");
        MutableSet = StandardClassIdsKt.access$collectionsId("MutableSet");
        ClassId r31 = StandardClassIdsKt.access$collectionsId("MutableMap");
        MutableMap = r31;
        MapEntry = r30.createNestedClassId(Name.identifier("Entry"));
        MutableMapEntry = r31.createNestedClassId(Name.identifier("MutableEntry"));
        Result = StandardClassIdsKt.access$baseId("Result");
        IntRange = StandardClassIdsKt.access$rangesId("IntRange");
        LongRange = StandardClassIdsKt.access$rangesId("LongRange");
        CharRange = StandardClassIdsKt.access$rangesId("CharRange");
        AnnotationRetention = StandardClassIdsKt.access$annotationId("AnnotationRetention");
        AnnotationTarget = StandardClassIdsKt.access$annotationId("AnnotationTarget");
        DeprecationLevel = StandardClassIdsKt.access$baseId("DeprecationLevel");
        EnumEntries = StandardClassIdsKt.access$enumsId("EnumEntries");
        allBuiltinTypes = SetsKt.plus(SetsKt.plus(SetsKt.plus(SetsKt.plus(SetsKt.plus(r26, r27), r29), Unit), Any), Enum);
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

    public final FqName getBASE_ENUMS_PACKAGE() {
        return BASE_ENUMS_PACKAGE;
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

    public final ClassId getEnumEntries() {
        return EnumEntries;
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
