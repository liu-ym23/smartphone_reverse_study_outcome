package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import ai.j0;
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
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.builtins.CompanionObjectMapping;
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
@SourceDebugExtension({"SMAP\nJavaToKotlinClassMap.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JavaToKotlinClassMap.kt\norg/jetbrains/kotlin/builtins/jvm/JavaToKotlinClassMap\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,219:1\n49#1,2:221\n49#1,2:223\n49#1,2:225\n49#1,2:227\n49#1,2:229\n49#1,2:231\n49#1,2:233\n49#1,2:235\n1#2:220\n*S KotlinDebug\n*F\n+ 1 JavaToKotlinClassMap.kt\norg/jetbrains/kotlin/builtins/jvm/JavaToKotlinClassMap\n*L\n54#1:221,2\n55#1:223,2\n56#1:225,2\n57#1:227,2\n58#1:229,2\n59#1:231,2\n60#1:233,2\n61#1:235,2\n*E\n"})
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

        public PlatformMutabilityMapping(ClassId r5, ClassId r10, ClassId r11) {
            Intrinsics.checkNotNullParameter(r5, "javaClass");
            Intrinsics.checkNotNullParameter(r10, "kotlinReadOnly");
            Intrinsics.checkNotNullParameter(r11, "kotlinMutable");
            this.javaClass = r5;
            this.kotlinReadOnly = r10;
            this.kotlinMutable = r11;
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

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof PlatformMutabilityMapping) == true) goto L8;
            return false;
        L8:
            PlatformMutabilityMapping r10 = (PlatformMutabilityMapping) r5;
            if (Intrinsics.areEqual(this.javaClass, r10.javaClass) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.kotlinReadOnly, r10.kotlinReadOnly) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.kotlinMutable, r10.kotlinMutable) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final ClassId getJavaClass() {
            return this.javaClass;
        }

        public int hashCode() {
            int r5 = this.javaClass.hashCode() * 31;
            int r10 = (this.kotlinReadOnly.hashCode() + r5) * 31;
            return this.kotlinMutable.hashCode() + r10;
        }

        public String toString() {
            return "PlatformMutabilityMapping(javaClass=" + this.javaClass + ", kotlinReadOnly=" + this.kotlinReadOnly + ", kotlinMutable=" + this.kotlinMutable + ')';
        }
    }

    static {
        JavaToKotlinClassMap r5 = new JavaToKotlinClassMap();
        INSTANCE = r5;
        StringBuilder r10 = new StringBuilder();
        FunctionClassKind r11 = FunctionClassKind.Function;
        r10.append(r11.getPackageFqName().toString());
        r10.append('.');
        r10.append(r11.getClassNamePrefix());
        NUMBERED_FUNCTION_PREFIX = r10.toString();
        StringBuilder r12 = new StringBuilder();
        FunctionClassKind r13 = FunctionClassKind.KFunction;
        r12.append(r13.getPackageFqName().toString());
        r12.append('.');
        r12.append(r13.getClassNamePrefix());
        NUMBERED_K_FUNCTION_PREFIX = r12.toString();
        StringBuilder r14 = new StringBuilder();
        FunctionClassKind r15 = FunctionClassKind.SuspendFunction;
        r14.append(r15.getPackageFqName().toString());
        r14.append('.');
        r14.append(r15.getClassNamePrefix());
        NUMBERED_SUSPEND_FUNCTION_PREFIX = r14.toString();
        StringBuilder r16 = new StringBuilder();
        FunctionClassKind r17 = FunctionClassKind.KSuspendFunction;
        r16.append(r17.getPackageFqName().toString());
        r16.append('.');
        r16.append(r17.getClassNamePrefix());
        NUMBERED_K_SUSPEND_FUNCTION_PREFIX = r16.toString();
        ClassId r18 = ClassId.topLevel(new FqName("kotlin.jvm.functions.FunctionN"));
        FUNCTION_N_CLASS_ID = r18;
        FUNCTION_N_FQ_NAME = r18.asSingleFqName();
        StandardClassIds r19 = StandardClassIds.INSTANCE;
        K_FUNCTION_CLASS_ID = r19.getKFunction();
        K_CLASS_CLASS_ID = r19.getKClass();
        CLASS_CLASS_ID = r5.classId(Class.class);
        javaToKotlin = new HashMap();
        kotlinToJava = new HashMap();
        mutableToReadOnly = new HashMap();
        readOnlyToMutable = new HashMap();
        mutableToReadOnlyClassId = new HashMap();
        readOnlyToMutableClassId = new HashMap();
        ClassId r20 = ClassId.topLevel(StandardNames.FqNames.iterable);
        FqName r21 = StandardNames.FqNames.mutableIterable;
        int r22 = 0;
        PlatformMutabilityMapping r23 = new PlatformMutabilityMapping(r5.classId(Iterable.class), r20, new ClassId(r20.getPackageFqName(), FqNamesUtilKt.tail(r21, r20.getPackageFqName()), false));
        ClassId r24 = ClassId.topLevel(StandardNames.FqNames.iterator);
        PlatformMutabilityMapping r25 = new PlatformMutabilityMapping(r5.classId(Iterator.class), r24, new ClassId(r24.getPackageFqName(), FqNamesUtilKt.tail(StandardNames.FqNames.mutableIterator, r24.getPackageFqName()), false));
        ClassId r26 = ClassId.topLevel(StandardNames.FqNames.collection);
        PlatformMutabilityMapping r27 = new PlatformMutabilityMapping(r5.classId(Collection.class), r26, new ClassId(r26.getPackageFqName(), FqNamesUtilKt.tail(StandardNames.FqNames.mutableCollection, r26.getPackageFqName()), false));
        ClassId r28 = ClassId.topLevel(StandardNames.FqNames.list);
        PlatformMutabilityMapping r110 = new PlatformMutabilityMapping(r5.classId(List.class), r28, new ClassId(r28.getPackageFqName(), FqNamesUtilKt.tail(StandardNames.FqNames.mutableList, r28.getPackageFqName()), false));
        ClassId r29 = ClassId.topLevel(StandardNames.FqNames.set);
        PlatformMutabilityMapping r111 = new PlatformMutabilityMapping(r5.classId(Set.class), r29, new ClassId(r29.getPackageFqName(), FqNamesUtilKt.tail(StandardNames.FqNames.mutableSet, r29.getPackageFqName()), false));
        ClassId r30 = ClassId.topLevel(StandardNames.FqNames.listIterator);
        PlatformMutabilityMapping r112 = new PlatformMutabilityMapping(r5.classId(ListIterator.class), r30, new ClassId(r30.getPackageFqName(), FqNamesUtilKt.tail(StandardNames.FqNames.mutableListIterator, r30.getPackageFqName()), false));
        FqName r31 = StandardNames.FqNames.map;
        ClassId r32 = ClassId.topLevel(r31);
        PlatformMutabilityMapping r113 = new PlatformMutabilityMapping(r5.classId(Map.class), r32, new ClassId(r32.getPackageFqName(), FqNamesUtilKt.tail(StandardNames.FqNames.mutableMap, r32.getPackageFqName()), false));
        ClassId r33 = ClassId.topLevel(r31).createNestedClassId(StandardNames.FqNames.mapEntry.shortName());
        List<PlatformMutabilityMapping> r34 = CollectionsKt.listOf(new PlatformMutabilityMapping[]{r23, r25, r27, r110, r111, r112, r113, new PlatformMutabilityMapping(r5.classId(Map.Entry.class), r33, new ClassId(r33.getPackageFqName(), FqNamesUtilKt.tail(StandardNames.FqNames.mutableMapEntry, r33.getPackageFqName()), false))});
        mutabilityMappings = r34;
        r5.addTopLevel(Object.class, StandardNames.FqNames.any);
        r5.addTopLevel(String.class, StandardNames.FqNames.string);
        r5.addTopLevel(CharSequence.class, StandardNames.FqNames.charSequence);
        r5.addTopLevel(Throwable.class, StandardNames.FqNames.throwable);
        r5.addTopLevel(Cloneable.class, StandardNames.FqNames.cloneable);
        r5.addTopLevel(Number.class, StandardNames.FqNames.number);
        r5.addTopLevel(Comparable.class, StandardNames.FqNames.comparable);
        r5.addTopLevel(Enum.class, StandardNames.FqNames._enum);
        r5.addTopLevel(Annotation.class, StandardNames.FqNames.annotation);
        Iterator<PlatformMutabilityMapping> r35 = r34.iterator();
    L4:
        if (r35.hasNext() == false) goto L6;
        INSTANCE.addMapping(r35.next());
        goto L4
    L6:
        JvmPrimitiveType[] r36 = JvmPrimitiveType.values();
        int r37 = r36.length;
        int r38 = 0;
    L7:
        if (r38 >= r37) goto L9;
        JvmPrimitiveType r39 = r36[r38];
        INSTANCE.add(ClassId.topLevel(r39.getWrapperFqName()), ClassId.topLevel(StandardNames.getPrimitiveFqName(r39.getPrimitiveType())));
        r38 = r38 + 1;
        goto L7
    L9:
        Iterator<ClassId> r40 = CompanionObjectMapping.INSTANCE.allClassesWithIntrinsicCompanions().iterator();
    L11:
        if (r40.hasNext() == false) goto L13;
        ClassId r41 = r40.next();
        INSTANCE.add(ClassId.topLevel(new FqName("kotlin.jvm.internal." + r41.getShortClassName().asString() + "CompanionObject")), r41.createNestedClassId(SpecialNames.DEFAULT_NAME_FOR_COMPANION_OBJECT));
        goto L11
    L13:
        int r42 = 0;
    L15:
        if (r42 >= 23) goto L18;
        JavaToKotlinClassMap r43 = INSTANCE;
        r43.add(ClassId.topLevel(new FqName(j0.g(r42, "kotlin.jvm.functions.Function"))), StandardNames.getFunctionClassId(r42));
        r43.addKotlinToJava(new FqName(NUMBERED_K_FUNCTION_PREFIX + r42), K_FUNCTION_CLASS_ID);
        r42 = r42 + 1;
    L18:
        if (r22 >= 22) goto L20;
        FunctionClassKind r44 = FunctionClassKind.KSuspendFunction;
        String r45 = r44.getPackageFqName().toString() + '.' + r44.getClassNamePrefix();
        INSTANCE.addKotlinToJava(new FqName(r45 + r22), K_FUNCTION_CLASS_ID);
        r22 = r22 + 1;
        goto L18
    L20:
        JavaToKotlinClassMap r46 = INSTANCE;
        r46.addKotlinToJava(StandardNames.FqNames.nothing.toSafe(), r46.classId(Void.class));
    }

    private JavaToKotlinClassMap() {
    }

    private final void add(ClassId r5, ClassId r10) {
        addJavaToKotlin(r5, r10);
        addKotlinToJava(r10.asSingleFqName(), r5);
    }

    private final void addJavaToKotlin(ClassId r5, ClassId r10) {
        javaToKotlin.put(r5.asSingleFqName().toUnsafe(), r10);
    }

    private final void addKotlinToJava(FqName r5, ClassId r10) {
        kotlinToJava.put(r5.toUnsafe(), r10);
    }

    private final void addMapping(PlatformMutabilityMapping r5) {
        ClassId r10 = r5.component1();
        ClassId r11 = r5.component2();
        ClassId r12 = r5.component3();
        add(r10, r11);
        addKotlinToJava(r12.asSingleFqName(), r10);
        mutableToReadOnlyClassId.put(r12, r11);
        readOnlyToMutableClassId.put(r11, r12);
        FqName r13 = r11.asSingleFqName();
        FqName r14 = r12.asSingleFqName();
        mutableToReadOnly.put(r12.asSingleFqName().toUnsafe(), r13);
        readOnlyToMutable.put(r13.toUnsafe(), r14);
    }

    private final void addTopLevel(Class<?> r5, FqNameUnsafe r10) {
        addTopLevel(r5, r10.toSafe());
    }

    private final ClassId classId(Class<?> r5) {
        if (r5.isPrimitive() == true) goto L5;
        r5.isArray();
    L5:
        Class<?> r10 = r5.getDeclaringClass();
        if (r10 != null) goto L9;
        return ClassId.topLevel(new FqName(r5.getCanonicalName()));
    L9:
        return classId(r10).createNestedClassId(Name.identifier(r5.getSimpleName()));
    }

    private final boolean isKotlinFunctionWithBigArity(FqNameUnsafe r5, String r10) {
        String r11 = StringsKt.Q(r5.asString(), r10);
        if (r11.length() > 0) goto L5;
        return false;
    L5:
        if (StringsKt.O(r11, '0') == true) goto L13;
        Integer r12 = StringsKt.toIntOrNull(r11);
        if (r12 != null) goto L9;
        return false;
    L9:
        if (r12.intValue() < 23) goto L15;
        return true;
    L15:
        return false;
    L13:
        return false;
    }

    public final FqName getFUNCTION_N_FQ_NAME() {
        return FUNCTION_N_FQ_NAME;
    }

    public final List<PlatformMutabilityMapping> getMutabilityMappings() {
        return mutabilityMappings;
    }

    public final boolean isMutable(FqNameUnsafe r5) {
        return mutableToReadOnly.containsKey(r5);
    }

    public final boolean isReadOnly(FqNameUnsafe r5) {
        return readOnlyToMutable.containsKey(r5);
    }

    public final ClassId mapJavaToKotlin(FqName r5) {
        Intrinsics.checkNotNullParameter(r5, "fqName");
        return javaToKotlin.get(r5.toUnsafe());
    }

    public final ClassId mapKotlinToJava(FqNameUnsafe r5) {
        Intrinsics.checkNotNullParameter(r5, "kotlinFqName");
        if (isKotlinFunctionWithBigArity(r5, NUMBERED_FUNCTION_PREFIX) == false) goto L6;
        return FUNCTION_N_CLASS_ID;
    L6:
        if (isKotlinFunctionWithBigArity(r5, NUMBERED_SUSPEND_FUNCTION_PREFIX) == false) goto L9;
        return FUNCTION_N_CLASS_ID;
    L9:
        if (isKotlinFunctionWithBigArity(r5, NUMBERED_K_FUNCTION_PREFIX) == false) goto L12;
        return K_FUNCTION_CLASS_ID;
    L12:
        if (isKotlinFunctionWithBigArity(r5, NUMBERED_K_SUSPEND_FUNCTION_PREFIX) == false) goto L15;
        return K_FUNCTION_CLASS_ID;
    L15:
        return kotlinToJava.get(r5);
    }

    public final FqName mutableToReadOnly(FqNameUnsafe r5) {
        return mutableToReadOnly.get(r5);
    }

    public final FqName readOnlyToMutable(FqNameUnsafe r5) {
        return readOnlyToMutable.get(r5);
    }

    private final void addTopLevel(Class<?> r5, FqName r10) {
        add(classId(r5), ClassId.topLevel(r10));
    }
}
