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
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionTypeKind;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.FqNamesUtilKt;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.name.SpecialNames;
import kotlin.reflect.jvm.internal.impl.name.StandardClassIds;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
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

        public final ClassId component1() {
            return this.javaClass;
        }

        public final ClassId component2() {
            return this.kotlinReadOnly;
        }

        public final ClassId component3() {
            return this.kotlinMutable;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof PlatformMutabilityMapping) == true) goto L8;
            return false;
        L8:
            PlatformMutabilityMapping r6 = (PlatformMutabilityMapping) r5;
            if (Intrinsics.areEqual(this.javaClass, r6.javaClass) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.kotlinReadOnly, r6.kotlinReadOnly) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.kotlinMutable, r6.kotlinMutable) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.javaClass.hashCode() * 31) + this.kotlinReadOnly.hashCode()) * 31) + this.kotlinMutable.hashCode();
        }

        public String toString() {
            return "PlatformMutabilityMapping(javaClass=" + this.javaClass + ", kotlinReadOnly=" + this.kotlinReadOnly + ", kotlinMutable=" + this.kotlinMutable + ')';
        }

        public final ClassId getJavaClass() {
            return this.javaClass;
        }

        public PlatformMutabilityMapping(ClassId r2, ClassId r3, ClassId r4) {
            Intrinsics.checkNotNullParameter(r2, "javaClass");
            Intrinsics.checkNotNullParameter(r3, "kotlinReadOnly");
            Intrinsics.checkNotNullParameter(r4, "kotlinMutable");
            this.javaClass = r2;
            this.kotlinReadOnly = r3;
            this.kotlinMutable = r4;
        }
    }

    private JavaToKotlinClassMap() {
    }

    static {
        JavaToKotlinClassMap r0 = new JavaToKotlinClassMap();
        INSTANCE = r0;
        StringBuilder r1 = new StringBuilder();
        FunctionTypeKind.Function r2 = FunctionTypeKind.Function.INSTANCE;
        r1.append(r2.getPackageFqName());
        r1.append('.');
        r1.append(r2.getClassNamePrefix());
        NUMBERED_FUNCTION_PREFIX = r1.toString();
        StringBuilder r3 = new StringBuilder();
        FunctionTypeKind.KFunction r4 = FunctionTypeKind.KFunction.INSTANCE;
        r3.append(r4.getPackageFqName());
        r3.append('.');
        r3.append(r4.getClassNamePrefix());
        NUMBERED_K_FUNCTION_PREFIX = r3.toString();
        StringBuilder r5 = new StringBuilder();
        FunctionTypeKind.SuspendFunction r6 = FunctionTypeKind.SuspendFunction.INSTANCE;
        r5.append(r6.getPackageFqName());
        r5.append('.');
        r5.append(r6.getClassNamePrefix());
        NUMBERED_SUSPEND_FUNCTION_PREFIX = r5.toString();
        StringBuilder r7 = new StringBuilder();
        FunctionTypeKind.KSuspendFunction r8 = FunctionTypeKind.KSuspendFunction.INSTANCE;
        r7.append(r8.getPackageFqName());
        r7.append('.');
        r7.append(r8.getClassNamePrefix());
        NUMBERED_K_SUSPEND_FUNCTION_PREFIX = r7.toString();
        ClassId.Companion r9 = ClassId.Companion;
        ClassId r10 = r9.topLevel(new FqName("kotlin.jvm.functions.FunctionN"));
        FUNCTION_N_CLASS_ID = r10;
        FUNCTION_N_FQ_NAME = r10.asSingleFqName();
        StandardClassIds r11 = StandardClassIds.INSTANCE;
        K_FUNCTION_CLASS_ID = r11.getKFunction();
        K_CLASS_CLASS_ID = r11.getKClass();
        CLASS_CLASS_ID = r0.classId(Class.class);
        javaToKotlin = new HashMap();
        kotlinToJava = new HashMap();
        mutableToReadOnly = new HashMap();
        readOnlyToMutable = new HashMap();
        mutableToReadOnlyClassId = new HashMap();
        readOnlyToMutableClassId = new HashMap();
        ClassId r12 = r9.topLevel(StandardNames.FqNames.iterable);
        int r13 = 0;
        ClassId r14 = new ClassId(r12.getPackageFqName(), FqNamesUtilKt.tail(StandardNames.FqNames.mutableIterable, r12.getPackageFqName()), false);
        ClassId r15 = r9.topLevel(StandardNames.FqNames.iterator);
        ClassId r16 = new ClassId(r15.getPackageFqName(), FqNamesUtilKt.tail(StandardNames.FqNames.mutableIterator, r15.getPackageFqName()), false);
        ClassId r17 = r9.topLevel(StandardNames.FqNames.collection);
        ClassId r18 = new ClassId(r17.getPackageFqName(), FqNamesUtilKt.tail(StandardNames.FqNames.mutableCollection, r17.getPackageFqName()), false);
        ClassId r19 = r9.topLevel(StandardNames.FqNames.list);
        ClassId r20 = new ClassId(r19.getPackageFqName(), FqNamesUtilKt.tail(StandardNames.FqNames.mutableList, r19.getPackageFqName()), false);
        ClassId r21 = r9.topLevel(StandardNames.FqNames.set);
        ClassId r22 = new ClassId(r21.getPackageFqName(), FqNamesUtilKt.tail(StandardNames.FqNames.mutableSet, r21.getPackageFqName()), false);
        ClassId r23 = r9.topLevel(StandardNames.FqNames.listIterator);
        ClassId r24 = new ClassId(r23.getPackageFqName(), FqNamesUtilKt.tail(StandardNames.FqNames.mutableListIterator, r23.getPackageFqName()), false);
        FqName r25 = StandardNames.FqNames.map;
        ClassId r26 = r9.topLevel(r25);
        ClassId r27 = new ClassId(r26.getPackageFqName(), FqNamesUtilKt.tail(StandardNames.FqNames.mutableMap, r26.getPackageFqName()), false);
        ClassId r28 = r9.topLevel(r25).createNestedClassId(StandardNames.FqNames.mapEntry.shortName());
        List<PlatformMutabilityMapping> r29 = CollectionsKt.listOf(new PlatformMutabilityMapping[]{new PlatformMutabilityMapping(r0.classId(Iterable.class), r12, r14), new PlatformMutabilityMapping(r0.classId(Iterator.class), r15, r16), new PlatformMutabilityMapping(r0.classId(Collection.class), r17, r18), new PlatformMutabilityMapping(r0.classId(List.class), r19, r20), new PlatformMutabilityMapping(r0.classId(Set.class), r21, r22), new PlatformMutabilityMapping(r0.classId(ListIterator.class), r23, r24), new PlatformMutabilityMapping(r0.classId(Map.class), r26, r27), new PlatformMutabilityMapping(r0.classId(Map.Entry.class), r28, new ClassId(r28.getPackageFqName(), FqNamesUtilKt.tail(StandardNames.FqNames.mutableMapEntry, r28.getPackageFqName()), false))});
        mutabilityMappings = r29;
        r0.addTopLevel(Object.class, StandardNames.FqNames.any);
        r0.addTopLevel(String.class, StandardNames.FqNames.string);
        r0.addTopLevel(CharSequence.class, StandardNames.FqNames.charSequence);
        r0.addTopLevel(Throwable.class, StandardNames.FqNames.throwable);
        r0.addTopLevel(Cloneable.class, StandardNames.FqNames.cloneable);
        r0.addTopLevel(Number.class, StandardNames.FqNames.number);
        r0.addTopLevel(Comparable.class, StandardNames.FqNames.comparable);
        r0.addTopLevel(Enum.class, StandardNames.FqNames._enum);
        r0.addTopLevel(Annotation.class, StandardNames.FqNames.annotation);
        Iterator<PlatformMutabilityMapping> r30 = r29.iterator();
    L4:
        if (r30.hasNext() == false) goto L6;
        INSTANCE.addMapping(r30.next());
        goto L4
    L6:
        JvmPrimitiveType[] r31 = JvmPrimitiveType.values();
        int r32 = r31.length;
        int r33 = 0;
    L7:
        if (r33 >= r32) goto L9;
        JvmPrimitiveType r34 = r31[r33];
        JavaToKotlinClassMap r35 = INSTANCE;
        ClassId.Companion r36 = ClassId.Companion;
        r35.add(r36.topLevel(r34.getWrapperFqName()), r36.topLevel(StandardNames.getPrimitiveFqName(r34.getPrimitiveType())));
        r33 = r33 + 1;
        goto L7
    L9:
        Iterator<ClassId> r37 = CompanionObjectMapping.INSTANCE.allClassesWithIntrinsicCompanions().iterator();
    L11:
        if (r37.hasNext() == false) goto L13;
        ClassId r38 = r37.next();
        INSTANCE.add(ClassId.Companion.topLevel(new FqName("kotlin.jvm.internal." + r38.getShortClassName().asString() + "CompanionObject")), r38.createNestedClassId(SpecialNames.DEFAULT_NAME_FOR_COMPANION_OBJECT));
        goto L11
    L13:
        int r39 = 0;
    L15:
        if (r39 >= 23) goto L18;
        JavaToKotlinClassMap r40 = INSTANCE;
        r40.add(ClassId.Companion.topLevel(new FqName("kotlin.jvm.functions.Function" + r39)), StandardNames.getFunctionClassId(r39));
        r40.addKotlinToJava(new FqName(NUMBERED_K_FUNCTION_PREFIX + r39), K_FUNCTION_CLASS_ID);
        r39 = r39 + 1;
    L18:
        if (r13 >= 22) goto L20;
        FunctionTypeKind.KSuspendFunction r41 = FunctionTypeKind.KSuspendFunction.INSTANCE;
        String r42 = r41.getPackageFqName() + '.' + r41.getClassNamePrefix();
        INSTANCE.addKotlinToJava(new FqName(r42 + r13), K_FUNCTION_CLASS_ID);
        r13 = r13 + 1;
        goto L18
    L20:
        JavaToKotlinClassMap r43 = INSTANCE;
        r43.addKotlinToJava(StandardNames.FqNames.nothing.toSafe(), r43.classId(Void.class));
    }

    public final FqName getFUNCTION_N_FQ_NAME() {
        return FUNCTION_N_FQ_NAME;
    }

    public final List<PlatformMutabilityMapping> getMutabilityMappings() {
        return mutabilityMappings;
    }

    private final void addMapping(PlatformMutabilityMapping r4) {
        ClassId r0 = r4.component1();
        ClassId r1 = r4.component2();
        ClassId r5 = r4.component3();
        add(r0, r1);
        addKotlinToJava(r5.asSingleFqName(), r0);
        mutableToReadOnlyClassId.put(r5, r1);
        readOnlyToMutableClassId.put(r1, r5);
        FqName r2 = r1.asSingleFqName();
        FqName r3 = r5.asSingleFqName();
        mutableToReadOnly.put(r5.asSingleFqName().toUnsafe(), r2);
        readOnlyToMutable.put(r2.toUnsafe(), r3);
    }

    private final ClassId classId(Class<?> r3) {
        if (r3.isPrimitive() == true) goto L5;
        r3.isArray();
    L5:
        Class<?> r0 = r3.getDeclaringClass();
        if (r0 != null) goto L9;
        return ClassId.Companion.topLevel(new FqName(r3.getCanonicalName()));
    L9:
        return classId(r0).createNestedClassId(Name.identifier(r3.getSimpleName()));
    }

    public final boolean isMutable(FqNameUnsafe r2) {
        return mutableToReadOnly.containsKey(r2);
    }

    public final boolean isReadOnly(FqNameUnsafe r2) {
        return readOnlyToMutable.containsKey(r2);
    }

    public final ClassId mapJavaToKotlin(FqName r2) {
        Intrinsics.checkNotNullParameter(r2, "fqName");
        return javaToKotlin.get(r2.toUnsafe());
    }

    public final ClassId mapKotlinToJava(FqNameUnsafe r2) {
        Intrinsics.checkNotNullParameter(r2, "kotlinFqName");
        if (isKotlinFunctionWithBigArity(r2, NUMBERED_FUNCTION_PREFIX) == false) goto L6;
        return FUNCTION_N_CLASS_ID;
    L6:
        if (isKotlinFunctionWithBigArity(r2, NUMBERED_SUSPEND_FUNCTION_PREFIX) == false) goto L9;
        return FUNCTION_N_CLASS_ID;
    L9:
        if (isKotlinFunctionWithBigArity(r2, NUMBERED_K_FUNCTION_PREFIX) == false) goto L12;
        return K_FUNCTION_CLASS_ID;
    L12:
        if (isKotlinFunctionWithBigArity(r2, NUMBERED_K_SUSPEND_FUNCTION_PREFIX) == false) goto L15;
        return K_FUNCTION_CLASS_ID;
    L15:
        return kotlinToJava.get(r2);
    }

    public final FqName mutableToReadOnly(FqNameUnsafe r2) {
        return mutableToReadOnly.get(r2);
    }

    public final FqName readOnlyToMutable(FqNameUnsafe r2) {
        return readOnlyToMutable.get(r2);
    }

    private final void add(ClassId r1, ClassId r2) {
        addJavaToKotlin(r1, r2);
        addKotlinToJava(r2.asSingleFqName(), r1);
    }

    private final void addJavaToKotlin(ClassId r2, ClassId r3) {
        javaToKotlin.put(r2.asSingleFqName().toUnsafe(), r3);
    }

    private final void addKotlinToJava(FqName r2, ClassId r3) {
        kotlinToJava.put(r2.toUnsafe(), r3);
    }

    private final void addTopLevel(Class<?> r2, FqName r3) {
        add(classId(r2), ClassId.Companion.topLevel(r3));
    }

    private final boolean isKotlinFunctionWithBigArity(FqNameUnsafe r5, String r6) {
        String r7 = r5.asString();
        if (StringsKt.startsWith$default(r7, r6, false, 2, null) == true) goto L5;
        return false;
    L5:
        String r8 = r7.substring(r6.length());
        if (StringsKt.startsWith$default(r8, '0', false, 2, null) == true) goto L13;
        Integer r9 = StringsKt.toIntOrNull(r8);
        if (r9 != null) goto L10;
        return false;
    L10:
        if (r9.intValue() < 23) goto L15;
        return true;
    L15:
        return false;
    L13:
        return false;
    }

    private final void addTopLevel(Class<?> r1, FqNameUnsafe r2) {
        addTopLevel(r1, r2.toSafe());
    }
}
