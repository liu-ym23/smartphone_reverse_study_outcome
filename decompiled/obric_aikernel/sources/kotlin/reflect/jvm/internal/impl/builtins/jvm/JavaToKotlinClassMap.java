package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.CompanionObjectMapping;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassKind;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.FqNamesUtilKt;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.name.SpecialNames;
import kotlin.reflect.jvm.internal.impl.name.StandardClassIds;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class JavaToKotlinClassMap {
    private static final ClassId CLASS_CLASS_ID = null;
    private static final ClassId FUNCTION_N_CLASS_ID = null;
    private static final FqName FUNCTION_N_FQ_NAME = null;
    public static final JavaToKotlinClassMap INSTANCE = null;
    private static final ClassId K_CLASS_CLASS_ID = null;
    private static final ClassId K_FUNCTION_CLASS_ID = null;
    private static final String NUMBERED_FUNCTION_PREFIX = null;
    private static final String NUMBERED_K_FUNCTION_PREFIX = null;
    private static final String NUMBERED_K_SUSPEND_FUNCTION_PREFIX = null;
    private static final String NUMBERED_SUSPEND_FUNCTION_PREFIX = null;
    private static final HashMap<FqNameUnsafe, ClassId> javaToKotlin = null;
    private static final HashMap<FqNameUnsafe, ClassId> kotlinToJava = null;
    private static final List<PlatformMutabilityMapping> mutabilityMappings = null;
    private static final HashMap<FqNameUnsafe, FqName> mutableToReadOnly = null;
    private static final HashMap<ClassId, ClassId> mutableToReadOnlyClassId = null;
    private static final HashMap<FqNameUnsafe, FqName> readOnlyToMutable = null;
    private static final HashMap<ClassId, ClassId> readOnlyToMutableClassId = null;

    public static final class PlatformMutabilityMapping {
        private final ClassId javaClass;
        private final ClassId kotlinMutable;
        private final ClassId kotlinReadOnly;

        public PlatformMutabilityMapping(ClassId r10, ClassId r11, ClassId r12) {
            Intrinsics.checkNotNullParameter(r10, "javaClass");
            Intrinsics.checkNotNullParameter(r11, "kotlinReadOnly");
            Intrinsics.checkNotNullParameter(r12, "kotlinMutable");
            this.javaClass = r10;
            this.kotlinReadOnly = r11;
            this.kotlinMutable = r12;
        }

        public final ClassId component1() {
            return this.javaClass;
        }

        public final ClassId component2() {
            return this.kotlinReadOnly;
        }

        public final ClassId component3() {
            return this.kotlinMutable;
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof PlatformMutabilityMapping) == true) goto L8;
            return false;
        L8:
            PlatformMutabilityMapping r11 = (PlatformMutabilityMapping) r10;
            if (Intrinsics.areEqual(this.javaClass, r11.javaClass) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.kotlinReadOnly, r11.kotlinReadOnly) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.kotlinMutable, r11.kotlinMutable) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final ClassId getJavaClass() {
            return this.javaClass;
        }

        public int hashCode() {
            return (((this.javaClass.hashCode() * 31) + this.kotlinReadOnly.hashCode()) * 31) + this.kotlinMutable.hashCode();
        }

        public String toString() {
            return "PlatformMutabilityMapping(javaClass=" + this.javaClass + ", kotlinReadOnly=" + this.kotlinReadOnly + ", kotlinMutable=" + this.kotlinMutable + ')';
        }
    }

    static {
        JavaToKotlinClassMap r10 = new JavaToKotlinClassMap();
        INSTANCE = r10;
        StringBuilder r11 = new StringBuilder();
        FunctionClassKind r12 = FunctionClassKind.Function;
        r11.append(r12.getPackageFqName().toString());
        r11.append('.');
        r11.append(r12.getClassNamePrefix());
        NUMBERED_FUNCTION_PREFIX = r11.toString();
        StringBuilder r13 = new StringBuilder();
        FunctionClassKind r14 = FunctionClassKind.KFunction;
        r13.append(r14.getPackageFqName().toString());
        r13.append('.');
        r13.append(r14.getClassNamePrefix());
        NUMBERED_K_FUNCTION_PREFIX = r13.toString();
        StringBuilder r15 = new StringBuilder();
        FunctionClassKind r16 = FunctionClassKind.SuspendFunction;
        r15.append(r16.getPackageFqName().toString());
        r15.append('.');
        r15.append(r16.getClassNamePrefix());
        NUMBERED_SUSPEND_FUNCTION_PREFIX = r15.toString();
        StringBuilder r17 = new StringBuilder();
        FunctionClassKind r18 = FunctionClassKind.KSuspendFunction;
        r17.append(r18.getPackageFqName().toString());
        r17.append('.');
        r17.append(r18.getClassNamePrefix());
        NUMBERED_K_SUSPEND_FUNCTION_PREFIX = r17.toString();
        ClassId r19 = ClassId.topLevel(new FqName("kotlin.jvm.functions.FunctionN"));
        Intrinsics.checkNotNullExpressionValue(r19, "topLevel(FqName(\"kotlin.jvm.functions.FunctionN\"))");
        FUNCTION_N_CLASS_ID = r19;
        FqName r20 = r19.asSingleFqName();
        Intrinsics.checkNotNullExpressionValue(r20, "FUNCTION_N_CLASS_ID.asSingleFqName()");
        FUNCTION_N_FQ_NAME = r20;
        StandardClassIds r21 = StandardClassIds.INSTANCE;
        K_FUNCTION_CLASS_ID = r21.getKFunction();
        K_CLASS_CLASS_ID = r21.getKClass();
        CLASS_CLASS_ID = r10.classId(Class.class);
        javaToKotlin = new HashMap();
        kotlinToJava = new HashMap();
        mutableToReadOnly = new HashMap();
        readOnlyToMutable = new HashMap();
        mutableToReadOnlyClassId = new HashMap();
        readOnlyToMutableClassId = new HashMap();
        ClassId r22 = ClassId.topLevel(StandardNames.FqNames.iterable);
        Intrinsics.checkNotNullExpressionValue(r22, "topLevel(FqNames.iterable)");
        FqName r23 = StandardNames.FqNames.mutableIterable;
        FqName r24 = r22.getPackageFqName();
        FqName r25 = r22.getPackageFqName();
        Intrinsics.checkNotNullExpressionValue(r25, "kotlinReadOnly.packageFqName");
        FqName r26 = FqNamesUtilKt.tail(r23, r25);
        int r27 = 0;
        ClassId r28 = new ClassId(r24, r26, false);
        ClassId r29 = ClassId.topLevel(StandardNames.FqNames.iterator);
        Intrinsics.checkNotNullExpressionValue(r29, "topLevel(FqNames.iterator)");
        FqName r30 = StandardNames.FqNames.mutableIterator;
        FqName r31 = r29.getPackageFqName();
        FqName r32 = r29.getPackageFqName();
        Intrinsics.checkNotNullExpressionValue(r32, "kotlinReadOnly.packageFqName");
        ClassId r33 = new ClassId(r31, FqNamesUtilKt.tail(r30, r32), false);
        ClassId r34 = ClassId.topLevel(StandardNames.FqNames.collection);
        Intrinsics.checkNotNullExpressionValue(r34, "topLevel(FqNames.collection)");
        FqName r35 = StandardNames.FqNames.mutableCollection;
        FqName r36 = r34.getPackageFqName();
        FqName r37 = r34.getPackageFqName();
        Intrinsics.checkNotNullExpressionValue(r37, "kotlinReadOnly.packageFqName");
        ClassId r38 = new ClassId(r36, FqNamesUtilKt.tail(r35, r37), false);
        ClassId r39 = ClassId.topLevel(StandardNames.FqNames.list);
        Intrinsics.checkNotNullExpressionValue(r39, "topLevel(FqNames.list)");
        FqName r40 = StandardNames.FqNames.mutableList;
        FqName r41 = r39.getPackageFqName();
        FqName r42 = r39.getPackageFqName();
        Intrinsics.checkNotNullExpressionValue(r42, "kotlinReadOnly.packageFqName");
        ClassId r43 = new ClassId(r41, FqNamesUtilKt.tail(r40, r42), false);
        ClassId r44 = ClassId.topLevel(StandardNames.FqNames.set);
        Intrinsics.checkNotNullExpressionValue(r44, "topLevel(FqNames.set)");
        FqName r45 = StandardNames.FqNames.mutableSet;
        FqName r46 = r44.getPackageFqName();
        FqName r47 = r44.getPackageFqName();
        Intrinsics.checkNotNullExpressionValue(r47, "kotlinReadOnly.packageFqName");
        ClassId r48 = new ClassId(r46, FqNamesUtilKt.tail(r45, r47), false);
        ClassId r49 = ClassId.topLevel(StandardNames.FqNames.listIterator);
        Intrinsics.checkNotNullExpressionValue(r49, "topLevel(FqNames.listIterator)");
        FqName r50 = StandardNames.FqNames.mutableListIterator;
        FqName r51 = r49.getPackageFqName();
        FqName r52 = r49.getPackageFqName();
        Intrinsics.checkNotNullExpressionValue(r52, "kotlinReadOnly.packageFqName");
        ClassId r53 = new ClassId(r51, FqNamesUtilKt.tail(r50, r52), false);
        FqName r54 = StandardNames.FqNames.map;
        ClassId r55 = ClassId.topLevel(r54);
        Intrinsics.checkNotNullExpressionValue(r55, "topLevel(FqNames.map)");
        FqName r56 = StandardNames.FqNames.mutableMap;
        FqName r57 = r55.getPackageFqName();
        FqName r110 = r55.getPackageFqName();
        Intrinsics.checkNotNullExpressionValue(r110, "kotlinReadOnly.packageFqName");
        ClassId r58 = new ClassId(r57, FqNamesUtilKt.tail(r56, r110), false);
        ClassId r59 = ClassId.topLevel(r54).createNestedClassId(StandardNames.FqNames.mapEntry.shortName());
        Intrinsics.checkNotNullExpressionValue(r59, "topLevel(FqNames.map).cr…mes.mapEntry.shortName())");
        FqName r60 = StandardNames.FqNames.mutableMapEntry;
        FqName r61 = r59.getPackageFqName();
        FqName r62 = r59.getPackageFqName();
        Intrinsics.checkNotNullExpressionValue(r62, "kotlinReadOnly.packageFqName");
        List<PlatformMutabilityMapping> r63 = CollectionsKt.listOf(new PlatformMutabilityMapping[]{new PlatformMutabilityMapping(r10.classId(Iterable.class), r22, r28), new PlatformMutabilityMapping(r10.classId(Iterator.class), r29, r33), new PlatformMutabilityMapping(r10.classId(Collection.class), r34, r38), new PlatformMutabilityMapping(r10.classId(List.class), r39, r43), new PlatformMutabilityMapping(r10.classId(Set.class), r44, r48), new PlatformMutabilityMapping(r10.classId(ListIterator.class), r49, r53), new PlatformMutabilityMapping(r10.classId(Map.class), r55, r58), new PlatformMutabilityMapping(r10.classId(Map.Entry.class), r59, new ClassId(r61, FqNamesUtilKt.tail(r60, r62), false))});
        mutabilityMappings = r63;
        r10.addTopLevel(Object.class, StandardNames.FqNames.any);
        r10.addTopLevel(String.class, StandardNames.FqNames.string);
        r10.addTopLevel(CharSequence.class, StandardNames.FqNames.charSequence);
        r10.addTopLevel(Throwable.class, StandardNames.FqNames.throwable);
        r10.addTopLevel(Cloneable.class, StandardNames.FqNames.cloneable);
        r10.addTopLevel(Number.class, StandardNames.FqNames.number);
        r10.addTopLevel(Comparable.class, StandardNames.FqNames.comparable);
        r10.addTopLevel(Enum.class, StandardNames.FqNames._enum);
        r10.addTopLevel(Annotation.class, StandardNames.FqNames.annotation);
        Iterator<PlatformMutabilityMapping> r64 = r63.iterator();
    L4:
        if (r64.hasNext() == false) goto L6;
        INSTANCE.addMapping(r64.next());
        goto L4
    L6:
        JvmPrimitiveType[] r65 = JvmPrimitiveType.values();
        int r66 = r65.length;
        int r67 = 0;
    L7:
        if (r67 >= r66) goto L9;
        JvmPrimitiveType r68 = r65[r67];
        JavaToKotlinClassMap r69 = INSTANCE;
        ClassId r70 = ClassId.topLevel(r68.getWrapperFqName());
        Intrinsics.checkNotNullExpressionValue(r70, "topLevel(jvmType.wrapperFqName)");
        PrimitiveType r71 = r68.getPrimitiveType();
        Intrinsics.checkNotNullExpressionValue(r71, "jvmType.primitiveType");
        ClassId r72 = ClassId.topLevel(StandardNames.getPrimitiveFqName(r71));
        Intrinsics.checkNotNullExpressionValue(r72, "topLevel(StandardNames.g…e(jvmType.primitiveType))");
        r69.add(r70, r72);
        r67 = r67 + 1;
        goto L7
    L9:
        Iterator<ClassId> r73 = CompanionObjectMapping.INSTANCE.allClassesWithIntrinsicCompanions().iterator();
    L11:
        if (r73.hasNext() == false) goto L13;
        ClassId r74 = r73.next();
        JavaToKotlinClassMap r75 = INSTANCE;
        ClassId r76 = ClassId.topLevel(new FqName("kotlin.jvm.internal." + r74.getShortClassName().asString() + "CompanionObject"));
        Intrinsics.checkNotNullExpressionValue(r76, "topLevel(FqName(\"kotlin.…g() + \"CompanionObject\"))");
        ClassId r77 = r74.createNestedClassId(SpecialNames.DEFAULT_NAME_FOR_COMPANION_OBJECT);
        Intrinsics.checkNotNullExpressionValue(r77, "classId.createNestedClas…AME_FOR_COMPANION_OBJECT)");
        r75.add(r76, r77);
        goto L11
    L13:
        int r78 = 0;
    L15:
        if (r78 >= 23) goto L18;
        JavaToKotlinClassMap r79 = INSTANCE;
        ClassId r80 = ClassId.topLevel(new FqName("kotlin.jvm.functions.Function" + r78));
        Intrinsics.checkNotNullExpressionValue(r80, "topLevel(FqName(\"kotlin.…m.functions.Function$i\"))");
        r79.add(r80, StandardNames.getFunctionClassId(r78));
        r79.addKotlinToJava(new FqName(NUMBERED_K_FUNCTION_PREFIX + r78), K_FUNCTION_CLASS_ID);
        r78 = r78 + 1;
    L18:
        if (r27 >= 22) goto L20;
        FunctionClassKind r81 = FunctionClassKind.KSuspendFunction;
        String r82 = r81.getPackageFqName().toString() + '.' + r81.getClassNamePrefix();
        INSTANCE.addKotlinToJava(new FqName(r82 + r27), K_FUNCTION_CLASS_ID);
        r27 = r27 + 1;
        goto L18
    L20:
        JavaToKotlinClassMap r83 = INSTANCE;
        FqName r84 = StandardNames.FqNames.nothing.toSafe();
        Intrinsics.checkNotNullExpressionValue(r84, "nothing.toSafe()");
        r83.addKotlinToJava(r84, r83.classId(Void.class));
    }

    private JavaToKotlinClassMap() {
    }

    private final void add(ClassId r10, ClassId r11) {
        addJavaToKotlin(r10, r11);
        FqName r12 = r11.asSingleFqName();
        Intrinsics.checkNotNullExpressionValue(r12, "kotlinClassId.asSingleFqName()");
        addKotlinToJava(r12, r10);
    }

    private final void addJavaToKotlin(ClassId r10, ClassId r11) {
        HashMap<FqNameUnsafe, ClassId> r12 = javaToKotlin;
        FqNameUnsafe r13 = r10.asSingleFqName().toUnsafe();
        Intrinsics.checkNotNullExpressionValue(r13, "javaClassId.asSingleFqName().toUnsafe()");
        r12.put(r13, r11);
    }

    private final void addKotlinToJava(FqName r10, ClassId r11) {
        HashMap<FqNameUnsafe, ClassId> r12 = kotlinToJava;
        FqNameUnsafe r13 = r10.toUnsafe();
        Intrinsics.checkNotNullExpressionValue(r13, "kotlinFqNameUnsafe.toUnsafe()");
        r12.put(r13, r11);
    }

    private final void addMapping(PlatformMutabilityMapping r10) {
        ClassId r11 = r10.component1();
        ClassId r12 = r10.component2();
        ClassId r13 = r10.component3();
        add(r11, r12);
        FqName r14 = r13.asSingleFqName();
        Intrinsics.checkNotNullExpressionValue(r14, "mutableClassId.asSingleFqName()");
        addKotlinToJava(r14, r11);
        mutableToReadOnlyClassId.put(r13, r12);
        readOnlyToMutableClassId.put(r12, r13);
        FqName r15 = r12.asSingleFqName();
        Intrinsics.checkNotNullExpressionValue(r15, "readOnlyClassId.asSingleFqName()");
        FqName r16 = r13.asSingleFqName();
        Intrinsics.checkNotNullExpressionValue(r16, "mutableClassId.asSingleFqName()");
        HashMap<FqNameUnsafe, FqName> r17 = mutableToReadOnly;
        FqNameUnsafe r18 = r13.asSingleFqName().toUnsafe();
        Intrinsics.checkNotNullExpressionValue(r18, "mutableClassId.asSingleFqName().toUnsafe()");
        r17.put(r18, r15);
        HashMap<FqNameUnsafe, FqName> r19 = readOnlyToMutable;
        FqNameUnsafe r20 = r15.toUnsafe();
        Intrinsics.checkNotNullExpressionValue(r20, "readOnlyFqName.toUnsafe()");
        r19.put(r20, r16);
    }

    private final void addTopLevel(Class<?> r10, FqName r11) {
        ClassId r12 = classId(r10);
        ClassId r13 = ClassId.topLevel(r11);
        Intrinsics.checkNotNullExpressionValue(r13, "topLevel(kotlinFqName)");
        add(r12, r13);
    }

    private final void addTopLevel(Class<?> r10, FqNameUnsafe r11) {
        FqName r12 = r11.toSafe();
        Intrinsics.checkNotNullExpressionValue(r12, "kotlinFqName.toSafe()");
        addTopLevel(r10, r12);
    }

    private final ClassId classId(Class<?> r10) {
        if (r10.isPrimitive() == true) goto L5;
        r10.isArray();
    L5:
        Class<?> r11 = r10.getDeclaringClass();
        if (r11 != null) goto L8;
        ClassId r12 = ClassId.topLevel(new FqName(r10.getCanonicalName()));
        String r13 = "topLevel(FqName(clazz.canonicalName))";
    L9:
        Intrinsics.checkNotNullExpressionValue(r12, r13);
        return r12;
    L8:
        r12 = classId(r11).createNestedClassId(Name.identifier(r10.getSimpleName()));
        r13 = "classId(outer).createNes…tifier(clazz.simpleName))";
        goto L9
    }

    private final boolean isKotlinFunctionWithBigArity(FqNameUnsafe r10, String r11) {
        String r12 = r10.asString();
        Intrinsics.checkNotNullExpressionValue(r12, "kotlinFqName.asString()");
        String r13 = StringsKt.substringAfter(r12, r11, "");
        if (r13.length() <= 0) goto L5;
        boolean r14 = true;
    L6:
        if (r14 == true) goto L8;
    L16:
        return false;
    L8:
        if (StringsKt.startsWith$default(r13, '0', false, 2, null) == true) goto L16;
        Integer r15 = StringsKt.toIntOrNull(r13);
        if (r15 == null) goto L15;
        if (r15.intValue() < 23) goto L15;
        return true;
    L15:
        return false;
    L5:
        r14 = false;
        goto L6
    }

    public final FqName getFUNCTION_N_FQ_NAME() {
        return FUNCTION_N_FQ_NAME;
    }

    public final List<PlatformMutabilityMapping> getMutabilityMappings() {
        return mutabilityMappings;
    }

    public final boolean isMutable(FqNameUnsafe r10) {
        return mutableToReadOnly.containsKey(r10);
    }

    public final boolean isReadOnly(FqNameUnsafe r10) {
        return readOnlyToMutable.containsKey(r10);
    }

    public final ClassId mapJavaToKotlin(FqName r10) {
        Intrinsics.checkNotNullParameter(r10, "fqName");
        return javaToKotlin.get(r10.toUnsafe());
    }

    public final ClassId mapKotlinToJava(FqNameUnsafe r10) {
        Intrinsics.checkNotNullParameter(r10, "kotlinFqName");
        if (isKotlinFunctionWithBigArity(r10, NUMBERED_FUNCTION_PREFIX) == false) goto L6;
    L16:
        return FUNCTION_N_CLASS_ID;
    L6:
        if (isKotlinFunctionWithBigArity(r10, NUMBERED_SUSPEND_FUNCTION_PREFIX) == true) goto L16;
        if (isKotlinFunctionWithBigArity(r10, NUMBERED_K_FUNCTION_PREFIX) == false) goto L12;
    L17:
        return K_FUNCTION_CLASS_ID;
    L12:
        if (isKotlinFunctionWithBigArity(r10, NUMBERED_K_SUSPEND_FUNCTION_PREFIX) == true) goto L17;
        return kotlinToJava.get(r10);
    }

    public final FqName mutableToReadOnly(FqNameUnsafe r10) {
        return mutableToReadOnly.get(r10);
    }

    public final FqName readOnlyToMutable(FqNameUnsafe r10) {
        return readOnlyToMutable.get(r10);
    }
}
