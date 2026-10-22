package kotlin.reflect.jvm.internal.impl.name;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nStandardClassIds.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StandardClassIds.kt\norg/jetbrains/kotlin/name/StandardClassIds\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,265:1\n1271#2,2:266\n1285#2,4:268\n1271#2,2:272\n1285#2,4:274\n*S KotlinDebug\n*F\n+ 1 StandardClassIds.kt\norg/jetbrains/kotlin/name/StandardClassIds\n*L\n80#1:266,2\n80#1:268,4\n84#1:272,2\n84#1:274,4\n*E\n"})
public final class StandardClassIds {
    private static final ClassId Annotation = null;
    private static final ClassId AnnotationRetention = null;
    private static final ClassId AnnotationTarget = null;
    private static final ClassId Any = null;
    private static final ClassId Array = null;
    private static final FqName BASE_ANNOTATION_PACKAGE = null;
    private static final FqName BASE_COLLECTIONS_PACKAGE = null;
    private static final FqName BASE_COROUTINES_PACKAGE = null;
    private static final FqName BASE_ENUMS_PACKAGE = null;
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
    private static final ClassId CharIterator = null;
    private static final ClassId CharRange = null;
    private static final ClassId CharSequence = null;
    private static final ClassId Cloneable = null;
    private static final ClassId Collection = null;
    private static final ClassId Comparable = null;
    private static final ClassId Continuation = null;
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
        FqName r5 = new FqName("kotlin");
        BASE_KOTLIN_PACKAGE = r5;
        FqName r10 = r5.child(Name.identifier("reflect"));
        BASE_REFLECT_PACKAGE = r10;
        FqName r11 = r5.child(Name.identifier("collections"));
        BASE_COLLECTIONS_PACKAGE = r11;
        FqName r12 = r5.child(Name.identifier("ranges"));
        BASE_RANGES_PACKAGE = r12;
        FqName r13 = r5.child(Name.identifier("jvm"));
        BASE_JVM_PACKAGE = r13;
        BASE_JVM_INTERNAL_PACKAGE = r13.child(Name.identifier("internal"));
        FqName r14 = r5.child(Name.identifier("annotation"));
        BASE_ANNOTATION_PACKAGE = r14;
        FqName r15 = r5.child(Name.identifier("internal"));
        BASE_INTERNAL_PACKAGE = r15;
        BASE_INTERNAL_IR_PACKAGE = r15.child(Name.identifier("ir"));
        FqName r16 = r5.child(Name.identifier("coroutines"));
        BASE_COROUTINES_PACKAGE = r16;
        BASE_ENUMS_PACKAGE = r5.child(Name.identifier("enums"));
        builtInsPackages = SetsKt.setOf(new FqName[]{r5, r11, r12, r14, r10, r15, r16});
        Nothing = StandardClassIdsKt.access$baseId("Nothing");
        Unit = StandardClassIdsKt.access$baseId("Unit");
        Any = StandardClassIdsKt.access$baseId("Any");
        Enum = StandardClassIdsKt.access$baseId("Enum");
        Annotation = StandardClassIdsKt.access$baseId("Annotation");
        Array = StandardClassIdsKt.access$baseId("Array");
        ClassId r17 = StandardClassIdsKt.access$baseId("Boolean");
        Boolean = r17;
        ClassId r18 = StandardClassIdsKt.access$baseId("Char");
        Char = r18;
        ClassId r19 = StandardClassIdsKt.access$baseId("Byte");
        Byte = r19;
        ClassId r20 = StandardClassIdsKt.access$baseId("Short");
        Short = r20;
        ClassId r21 = StandardClassIdsKt.access$baseId("Int");
        Int = r21;
        ClassId r22 = StandardClassIdsKt.access$baseId("Long");
        Long = r22;
        ClassId r23 = StandardClassIdsKt.access$baseId("Float");
        Float = r23;
        ClassId r24 = StandardClassIdsKt.access$baseId("Double");
        Double = r24;
        UByte = StandardClassIdsKt.access$unsignedId(r19);
        UShort = StandardClassIdsKt.access$unsignedId(r20);
        UInt = StandardClassIdsKt.access$unsignedId(r21);
        ULong = StandardClassIdsKt.access$unsignedId(r22);
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
        Comparable = StandardClassIdsKt.access$baseId("Comparable");
        Number = StandardClassIdsKt.access$baseId("Number");
        Function = StandardClassIdsKt.access$baseId("Function");
        Set<ClassId> r25 = SetsKt.setOf(new ClassId[]{r17, r18, r19, r20, r21, r22, r23, r24});
        primitiveTypes = r25;
        Set<ClassId> r26 = r25;
        LinkedHashMap r27 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.h(r26)), 16));
        Iterator<T> r28 = r26.iterator();
    L4:
        if (r28.hasNext() == false) goto L6;
        Object r29 = r28.next();
        r27.put(r29, StandardClassIdsKt.access$primitiveArrayId(((ClassId) r29).getShortClassName()));
        goto L4
    L6:
        primitiveArrayTypeByElementType = r27;
        elementTypeByPrimitiveArrayType = StandardClassIdsKt.access$inverseMap(r27);
        Set<ClassId> r30 = SetsKt.setOf(new ClassId[]{UByte, UShort, UInt, ULong});
        unsignedTypes = r30;
        Set<ClassId> r31 = r30;
        LinkedHashMap r32 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.h(r31)), 16));
        Iterator<T> r33 = r31.iterator();
    L8:
        if (r33.hasNext() == false) goto L10;
        Object r34 = r33.next();
        r32.put(r34, StandardClassIdsKt.access$primitiveArrayId(((ClassId) r34).getShortClassName()));
        goto L8
    L10:
        unsignedArrayTypeByElementType = r32;
        elementTypeByUnsignedArrayType = StandardClassIdsKt.access$inverseMap(r32);
        constantAllowedTypes = SetsKt.plus(SetsKt.plus(primitiveTypes, unsignedTypes), String);
        Continuation = StandardClassIdsKt.access$coroutinesId("Continuation");
        Iterator = StandardClassIdsKt.access$collectionsId("Iterator");
        Iterable = StandardClassIdsKt.access$collectionsId("Iterable");
        Collection = StandardClassIdsKt.access$collectionsId("Collection");
        List = StandardClassIdsKt.access$collectionsId("List");
        ListIterator = StandardClassIdsKt.access$collectionsId("ListIterator");
        Set = StandardClassIdsKt.access$collectionsId("Set");
        ClassId r35 = StandardClassIdsKt.access$collectionsId("Map");
        Map = r35;
        MutableIterator = StandardClassIdsKt.access$collectionsId("MutableIterator");
        CharIterator = StandardClassIdsKt.access$collectionsId("CharIterator");
        MutableIterable = StandardClassIdsKt.access$collectionsId("MutableIterable");
        MutableCollection = StandardClassIdsKt.access$collectionsId("MutableCollection");
        MutableList = StandardClassIdsKt.access$collectionsId("MutableList");
        MutableListIterator = StandardClassIdsKt.access$collectionsId("MutableListIterator");
        MutableSet = StandardClassIdsKt.access$collectionsId("MutableSet");
        ClassId r36 = StandardClassIdsKt.access$collectionsId("MutableMap");
        MutableMap = r36;
        MapEntry = r35.createNestedClassId(Name.identifier("Entry"));
        MutableMapEntry = r36.createNestedClassId(Name.identifier("MutableEntry"));
        Result = StandardClassIdsKt.access$baseId("Result");
        IntRange = StandardClassIdsKt.access$rangesId("IntRange");
        LongRange = StandardClassIdsKt.access$rangesId("LongRange");
        CharRange = StandardClassIdsKt.access$rangesId("CharRange");
        AnnotationRetention = StandardClassIdsKt.access$annotationId("AnnotationRetention");
        AnnotationTarget = StandardClassIdsKt.access$annotationId("AnnotationTarget");
        EnumEntries = StandardClassIdsKt.access$enumsId("EnumEntries");
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
