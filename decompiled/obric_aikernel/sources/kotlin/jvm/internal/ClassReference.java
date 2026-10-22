package kotlin.jvm.internal;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.crash.tracker.ActivityLifecycle;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.KotlinNothingValueException;
import kotlin.Pair;
import kotlin.SinceKotlin;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.KotlinReflectionNotSupportedError;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function10;
import kotlin.jvm.functions.Function11;
import kotlin.jvm.functions.Function12;
import kotlin.jvm.functions.Function13;
import kotlin.jvm.functions.Function14;
import kotlin.jvm.functions.Function15;
import kotlin.jvm.functions.Function16;
import kotlin.jvm.functions.Function17;
import kotlin.jvm.functions.Function18;
import kotlin.jvm.functions.Function19;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function20;
import kotlin.jvm.functions.Function21;
import kotlin.jvm.functions.Function22;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.functions.Function9;
import kotlin.reflect.KCallable;
import kotlin.reflect.KClass;
import kotlin.reflect.KFunction;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KVisibility;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension({"SMAP\nClassReference.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ClassReference.kt\nkotlin/jvm/internal/ClassReference\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,205:1\n1559#2:206\n1590#2,4:207\n1253#2,4:211\n1238#2,4:217\n453#3:215\n403#3:216\n*S KotlinDebug\n*F\n+ 1 ClassReference.kt\nkotlin/jvm/internal/ClassReference\n*L\n107#1:206\n107#1:207,4\n155#1:211,4\n163#1:217,4\n163#1:215\n163#1:216\n*E\n"})
public final class ClassReference implements KClass<Object>, ClassBasedDeclarationContainer {
    public static final Companion Companion = null;
    private static final Map<Class<? extends Function<?>>, Integer> FUNCTION_CLASSES = null;
    private static final HashMap<String, String> classFqNames = null;
    private static final HashMap<String, String> primitiveFqNames = null;
    private static final HashMap<String, String> primitiveWrapperFqNames = null;
    private static final Map<String, String> simpleNames = null;
    private final Class<?> jClass;

    @SourceDebugExtension({"SMAP\nClassReference.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ClassReference.kt\nkotlin/jvm/internal/ClassReference$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,205:1\n1#2:206\n*E\n"})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }

        public final String getClassQualifiedName(Class<?> r10) {
            Intrinsics.checkNotNullParameter(r10, "jClass");
            String r11 = null;
            if (r10.isAnonymousClass() == false) goto L6;
            return null;
        L6:
            if (r10.isLocalClass() == false) goto L9;
            return null;
        L9:
            if (r10.isArray() == false) goto L17;
            Class<?> r12 = r10.getComponentType();
            if (r12.isPrimitive() == false) goto L15;
            String r13 = (String) ClassReference.access$getClassFqNames$cp().get(r12.getName());
            if (r13 == null) goto L15;
            r11 = r13 + "Array";
        L15:
            if (r11 != null) goto L21;
            return "kotlin.Array";
        L21:
            return r11;
        L17:
            String r14 = (String) ClassReference.access$getClassFqNames$cp().get(r10.getName());
            if (r14 == null) goto L20;
            return r14;
        L20:
            return r10.getCanonicalName();
        }

        public final String getClassSimpleName(Class<?> r10) {
            Intrinsics.checkNotNullParameter(r10, "jClass");
            String r11 = null;
            if (r10.isAnonymousClass() == false) goto L6;
        L28:
            return r11;
        L6:
            if (r10.isLocalClass() == false) goto L16;
            String r12 = r10.getSimpleName();
            Method r13 = r10.getEnclosingMethod();
            if (r13 == null) goto L11;
            Intrinsics.checkNotNullExpressionValue(r12, ActivityLifecycle.NAME);
            String r14 = StringsKt.substringAfter$default(r12, r13.getName() + Typography.dollar, null, 2, null);
            if (r14 == null) goto L11;
            return r14;
        L11:
            Constructor<?> r15 = r10.getEnclosingConstructor();
            Intrinsics.checkNotNullExpressionValue(r12, ActivityLifecycle.NAME);
            if (r15 == null) goto L31;
            return StringsKt.substringAfter$default(r12, r15.getName() + Typography.dollar, null, 2, null);
        L31:
            return StringsKt.substringAfter$default(r12, Typography.dollar, null, 2, null);
        L16:
            if (r10.isArray() == false) goto L24;
            Class<?> r16 = r10.getComponentType();
            if (r16.isPrimitive() == false) goto L22;
            String r17 = (String) ClassReference.access$getSimpleNames$cp().get(r16.getName());
            if (r17 == null) goto L22;
            r11 = r17 + "Array";
        L22:
            if (r11 != null) goto L28;
            return "Array";
        L24:
            String r18 = (String) ClassReference.access$getSimpleNames$cp().get(r10.getName());
            if (r18 == null) goto L27;
            return r18;
        L27:
            return r10.getSimpleName();
        }

        public final boolean isInstance(Object r10, Class<?> r11) {
            Intrinsics.checkNotNullParameter(r11, "jClass");
            Map r12 = ClassReference.access$getFUNCTION_CLASSES$cp();
            Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.get, V of kotlin.collections.MapsKt__MapsKt.get>");
            Integer r13 = (Integer) r12.get(r11);
            if (r13 == null) goto L7;
            return TypeIntrinsics.isFunctionOfArity(r10, r13.intValue());
        L7:
            if (r11.isPrimitive() == false) goto L10;
            r11 = JvmClassMappingKt.getJavaObjectType(JvmClassMappingKt.getKotlinClass(r11));
        L10:
            return r11.isInstance(r10);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        Companion = new Companion(null);
        int r10 = 0;
        List r11 = CollectionsKt.listOf(new Class[]{Function0.class, Function1.class, Function2.class, Function3.class, Function4.class, Function5.class, Function6.class, Function7.class, Function8.class, Function9.class, Function10.class, Function11.class, Function12.class, Function13.class, Function14.class, Function15.class, Function16.class, Function17.class, Function18.class, Function19.class, Function20.class, Function21.class, Function22.class});
        ArrayList r12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r11, 10));
        Iterator r13 = r11.iterator();
    L4:
        if (r13.hasNext() == false) goto L9;
        Object r14 = r13.next();
        int r15 = r10 + 1;
        if (r10 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        r12.add(TuplesKt.to((Class) r14, Integer.valueOf(r10)));
        r10 = r15;
        goto L4
    L9:
        FUNCTION_CLASSES = MapsKt.toMap(r12);
        HashMap<String, String> r16 = new HashMap();
        r16.put(TypedValues.Custom.S_BOOLEAN, "kotlin.Boolean");
        r16.put("char", "kotlin.Char");
        r16.put("byte", "kotlin.Byte");
        r16.put("short", "kotlin.Short");
        r16.put("int", "kotlin.Int");
        r16.put(TypedValues.Custom.S_FLOAT, "kotlin.Float");
        r16.put("long", "kotlin.Long");
        r16.put("double", "kotlin.Double");
        primitiveFqNames = r16;
        HashMap<String, String> r17 = new HashMap();
        r17.put("java.lang.Boolean", "kotlin.Boolean");
        r17.put("java.lang.Character", "kotlin.Char");
        r17.put("java.lang.Byte", "kotlin.Byte");
        r17.put("java.lang.Short", "kotlin.Short");
        r17.put("java.lang.Integer", "kotlin.Int");
        r17.put("java.lang.Float", "kotlin.Float");
        r17.put("java.lang.Long", "kotlin.Long");
        r17.put("java.lang.Double", "kotlin.Double");
        primitiveWrapperFqNames = r17;
        HashMap<String, String> r18 = new HashMap();
        r18.put("java.lang.Object", "kotlin.Any");
        r18.put("java.lang.String", "kotlin.String");
        r18.put("java.lang.CharSequence", "kotlin.CharSequence");
        r18.put("java.lang.Throwable", "kotlin.Throwable");
        r18.put("java.lang.Cloneable", "kotlin.Cloneable");
        r18.put("java.lang.Number", "kotlin.Number");
        r18.put("java.lang.Comparable", "kotlin.Comparable");
        r18.put("java.lang.Enum", "kotlin.Enum");
        r18.put("java.lang.annotation.Annotation", "kotlin.Annotation");
        r18.put("java.lang.Iterable", "kotlin.collections.Iterable");
        r18.put("java.util.Iterator", "kotlin.collections.Iterator");
        r18.put("java.util.Collection", "kotlin.collections.Collection");
        r18.put("java.util.List", "kotlin.collections.List");
        r18.put("java.util.Set", "kotlin.collections.Set");
        r18.put("java.util.ListIterator", "kotlin.collections.ListIterator");
        r18.put("java.util.Map", "kotlin.collections.Map");
        r18.put("java.util.Map$Entry", "kotlin.collections.Map.Entry");
        r18.put("kotlin.jvm.internal.StringCompanionObject", "kotlin.String.Companion");
        r18.put("kotlin.jvm.internal.EnumCompanionObject", "kotlin.Enum.Companion");
        r18.putAll(r16);
        r18.putAll(r17);
        Collection<String> r19 = r16.values();
        Intrinsics.checkNotNullExpressionValue(r19, "primitiveFqNames.values");
        Iterator<T> r20 = r19.iterator();
    L11:
        if (r20.hasNext() == false) goto L13;
        String r21 = (String) r20.next();
        StringBuilder r22 = new StringBuilder();
        r22.append("kotlin.jvm.internal.");
        Intrinsics.checkNotNullExpressionValue(r21, "kotlinName");
        r22.append(StringsKt.substringAfterLast$default(r21, '.', null, 2, null));
        r22.append("CompanionObject");
        Pair r23 = TuplesKt.to(r22.toString(), r21 + ".Companion");
        r18.put(r23.getFirst(), r23.getSecond());
        goto L11
    L13:
        Iterator<Map.Entry<Class<? extends Function<?>>, Integer>> r24 = FUNCTION_CLASSES.entrySet().iterator();
    L15:
        if (r24.hasNext() == false) goto L17;
        Map.Entry<Class<? extends Function<?>>, Integer> r25 = r24.next();
        Class<? extends Function<?>> r26 = r25.getKey();
        int r27 = r25.getValue().intValue();
        r18.put(r26.getName(), "kotlin.Function" + r27);
        goto L15
    L17:
        classFqNames = r18;
        LinkedHashMap r28 = new LinkedHashMap(MapsKt.mapCapacity(r18.size()));
        Iterator r29 = r18.entrySet().iterator();
    L19:
        if (r29.hasNext() == false) goto L21;
        Map.Entry r30 = (Map.Entry) r29.next();
        r28.put(r30.getKey(), StringsKt.substringAfterLast$default((String) r30.getValue(), '.', null, 2, null));
        goto L19
    L21:
        simpleNames = r28;
    }

    public ClassReference(Class<?> r10) {
        Intrinsics.checkNotNullParameter(r10, "jClass");
        this.jClass = r10;
    }

    public static final /* synthetic */ HashMap access$getClassFqNames$cp() {
        return classFqNames;
    }

    public static final /* synthetic */ Map access$getFUNCTION_CLASSES$cp() {
        return FUNCTION_CLASSES;
    }

    public static final /* synthetic */ Map access$getSimpleNames$cp() {
        return simpleNames;
    }

    private final Void error() {
        throw new KotlinReflectionNotSupportedError();
    }

    @SinceKotlin(version = "1.3")
    public static /* synthetic */ void getSealedSubclasses$annotations() {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getSupertypes$annotations() {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getTypeParameters$annotations() {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getVisibility$annotations() {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void isAbstract$annotations() {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void isCompanion$annotations() {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void isData$annotations() {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void isFinal$annotations() {
    }

    @SinceKotlin(version = "1.4")
    public static /* synthetic */ void isFun$annotations() {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void isInner$annotations() {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void isOpen$annotations() {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void isSealed$annotations() {
    }

    @SinceKotlin(version = "1.5")
    public static /* synthetic */ void isValue$annotations() {
    }

    @Override // kotlin.reflect.KClass
    public boolean equals(Object r10) {
        if ((r10 instanceof ClassReference) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(JvmClassMappingKt.getJavaObjectType(this), JvmClassMappingKt.getJavaObjectType((KClass) r10)) == false) goto L7;
        return true;
    }

    @Override // kotlin.reflect.KAnnotatedElement
    public List<Annotation> getAnnotations() {
        error();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    public Collection<KFunction<Object>> getConstructors() {
        error();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.jvm.internal.ClassBasedDeclarationContainer
    public Class<?> getJClass() {
        return this.jClass;
    }

    @Override // kotlin.reflect.KClass, kotlin.reflect.KDeclarationContainer
    public Collection<KCallable<?>> getMembers() {
        error();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    public Collection<KClass<?>> getNestedClasses() {
        error();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    public Object getObjectInstance() {
        error();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    public String getQualifiedName() {
        return Companion.getClassQualifiedName(getJClass());
    }

    @Override // kotlin.reflect.KClass
    public List<KClass<? extends Object>> getSealedSubclasses() {
        error();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    public String getSimpleName() {
        return Companion.getClassSimpleName(getJClass());
    }

    @Override // kotlin.reflect.KClass
    public List<KType> getSupertypes() {
        error();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    public List<KTypeParameter> getTypeParameters() {
        error();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    public KVisibility getVisibility() {
        error();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    public int hashCode() {
        return JvmClassMappingKt.getJavaObjectType(this).hashCode();
    }

    @Override // kotlin.reflect.KClass
    public boolean isAbstract() {
        error();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    public boolean isCompanion() {
        error();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    public boolean isData() {
        error();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    public boolean isFinal() {
        error();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    public boolean isFun() {
        error();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    public boolean isInner() {
        error();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    @SinceKotlin(version = "1.1")
    public boolean isInstance(Object r10) {
        return Companion.isInstance(r10, getJClass());
    }

    @Override // kotlin.reflect.KClass
    public boolean isOpen() {
        error();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    public boolean isSealed() {
        error();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    public boolean isValue() {
        error();
        throw new KotlinNothingValueException();
    }

    public String toString() {
        return getJClass().toString() + " (Kotlin reflection is not available)";
    }
}
