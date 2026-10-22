package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmClassMappingKt;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class ReflectClassUtilKt {
    private static final Map<Class<? extends Function<?>>, Integer> FUNCTION_CLASSES = null;
    private static final List<KClass<? extends Object>> PRIMITIVE_CLASSES = null;
    private static final Map<Class<? extends Object>, Class<? extends Object>> PRIMITIVE_TO_WRAPPER = null;
    private static final Map<Class<? extends Object>, Class<? extends Object>> WRAPPER_TO_PRIMITIVE = null;

    public static /* synthetic */ ParameterizedType accessor$ReflectClassUtilKt$lambda0(ParameterizedType r0) {
        return _get_parameterizedTypeArguments_$lambda$3(r0);
    }

    public static /* synthetic */ Sequence accessor$ReflectClassUtilKt$lambda1(ParameterizedType r0) {
        return _get_parameterizedTypeArguments_$lambda$4(r0);
    }

    static {
        int r3 = 0;
        List<KClass<? extends Object>> r1 = CollectionsKt.listOf(new KClass[]{Reflection.getOrCreateKotlinClass(Boolean.TYPE), Reflection.getOrCreateKotlinClass(Byte.TYPE), Reflection.getOrCreateKotlinClass(Character.TYPE), Reflection.getOrCreateKotlinClass(Double.TYPE), Reflection.getOrCreateKotlinClass(Float.TYPE), Reflection.getOrCreateKotlinClass(Integer.TYPE), Reflection.getOrCreateKotlinClass(Long.TYPE), Reflection.getOrCreateKotlinClass(Short.TYPE)});
        PRIMITIVE_CLASSES = r1;
        List<KClass<? extends Object>> r2 = r1;
        ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator<T> r5 = r2.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        KClass r12 = (KClass) r5.next();
        r4.add(TuplesKt.to(JvmClassMappingKt.getJavaObjectType(r12), JvmClassMappingKt.getJavaPrimitiveType(r12)));
        goto L4
    L6:
        WRAPPER_TO_PRIMITIVE = MapsKt.toMap(r4);
        List<KClass<? extends Object>> r6 = PRIMITIVE_CLASSES;
        ArrayList r7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
        Iterator<T> r8 = r6.iterator();
    L8:
        if (r8.hasNext() == false) goto L10;
        KClass r13 = (KClass) r8.next();
        r7.add(TuplesKt.to(JvmClassMappingKt.getJavaPrimitiveType(r13), JvmClassMappingKt.getJavaObjectType(r13)));
        goto L8
    L10:
        PRIMITIVE_TO_WRAPPER = MapsKt.toMap(r7);
        List r0 = CollectionsKt.listOf(new Class[]{Function0.class, Function1.class, Function2.class, Function3.class, Function4.class, Function5.class, Function6.class, Function7.class, Function8.class, Function9.class, Function10.class, Function11.class, Function12.class, Function13.class, Function14.class, Function15.class, Function16.class, Function17.class, Function18.class, Function19.class, Function20.class, Function21.class, Function22.class});
        ArrayList r9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator r10 = r0.iterator();
    L12:
        if (r10.hasNext() == false) goto L17;
        Object r11 = r10.next();
        int r14 = r3 + 1;
        if (r3 >= 0) goto L16;
        CollectionsKt.throwIndexOverflow();
    L16:
        r9.add(TuplesKt.to((Class) r11, Integer.valueOf(r3)));
        r3 = r14;
        goto L12
    L17:
        FUNCTION_CLASSES = MapsKt.toMap(r9);
    }

    private static final ParameterizedType _get_parameterizedTypeArguments_$lambda$3(ParameterizedType r1) {
        Intrinsics.checkNotNullParameter(r1, "it");
        Type r2 = r1.getOwnerType();
        if ((r2 instanceof ParameterizedType) == true) goto L7;
        return null;
    L7:
        return (ParameterizedType) r2;
    }

    private static final Sequence _get_parameterizedTypeArguments_$lambda$4(ParameterizedType r1) {
        Intrinsics.checkNotNullParameter(r1, "it");
        return ArraysKt.asSequence(r1.getActualTypeArguments());
    }

    public static final ClassId getClassId(Class<?> r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        if (r3.isPrimitive() == true) goto L28;
        if (r3.isArray() == true) goto L26;
        if (r3.getEnclosingMethod() == null) goto L9;
    L23:
        FqName r0 = new FqName(r3.getName());
        return new ClassId(r0.parent(), FqName.topLevel(r0.shortName()), true);
    L9:
        if (r3.getEnclosingConstructor() != null) goto L23;
        if (r3.getSimpleName().length() != 0) goto L13;
        boolean r1 = true;
    L14:
        if (r1 == true) goto L23;
        Class<?> r2 = r3.getDeclaringClass();
        if (r2 == null) goto L30;
        ClassId r4 = getClassId(r2);
        if (r4 == null) goto L30;
        ClassId r5 = r4.createNestedClassId(Name.identifier(r3.getSimpleName()));
        if (r5 == null) goto L30;
        return r5;
    L30:
        return ClassId.Companion.topLevel(new FqName(r3.getName()));
    L13:
        r1 = false;
        goto L14
    L26:
        throw new IllegalArgumentException("Can't compute ClassId for array type: " + r3);
    L28:
        throw new IllegalArgumentException("Can't compute ClassId for primitive type: " + r3);
    }

    public static final String getDesc(Class<?> r8) {
        Intrinsics.checkNotNullParameter(r8, "<this>");
        if (r8.isPrimitive() == false) goto L37;
        String r0 = r8.getName();
        switch(r0.hashCode()) {
            case -1325958191: goto L32;
            case 104431: goto L29;
            case 3039496: goto L26;
            case 3052374: goto L23;
            case 3327612: goto L20;
            case 3625364: goto L17;
            case 64711720: goto L14;
            case 97526364: goto L11;
            case 109413500: goto L8;
            default: goto L35;
        };
    L8:
        if (r0.equals("short") == false) goto L35;
        return "S";
    L11:
        if (r0.equals("float") == false) goto L35;
        return "F";
    L14:
        if (r0.equals("boolean") == false) goto L35;
        return "Z";
    L17:
        if (r0.equals("void") == false) goto L35;
        return "V";
    L20:
        if (r0.equals("long") == false) goto L35;
        return "J";
    L23:
        if (r0.equals("char") == false) goto L35;
        return "C";
    L26:
        if (r0.equals("byte") == false) goto L35;
        return "B";
    L29:
        if (r0.equals("int") == false) goto L35;
        return "I";
    L32:
        if (r0.equals("double") == false) goto L35;
        return "D";
    L35:
        throw new IllegalArgumentException("Unsupported primitive type: " + r8);
    L37:
        if (r8.isArray() == false) goto L40;
        return StringsKt.replace$default(r8.getName(), '.', '/', false, 4, null);
    L40:
        return "L" + StringsKt.replace$default(r8.getName(), '.', '/', false, 4, null) + ';';
    }

    public static final Integer getFunctionClassArity(Class<?> r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return FUNCTION_CLASSES.get(r1);
    }

    public static final List<Type> getParameterizedTypeArguments(Type r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if ((r2 instanceof ParameterizedType) == false) goto L5;
        ParameterizedType r0 = (ParameterizedType) r2;
        if (r0.getOwnerType() != null) goto L11;
        return ArraysKt.toList(r0.getActualTypeArguments());
    L11:
        return SequencesKt.toList(SequencesKt.flatMap(SequencesKt.generateSequence(r2, ReflectClassUtilKt$.Lambda.0.INSTANCE), ReflectClassUtilKt$.Lambda.1.INSTANCE));
    L5:
        return CollectionsKt.emptyList();
    }

    public static final Class<?> getPrimitiveByWrapper(Class<?> r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return WRAPPER_TO_PRIMITIVE.get(r1);
    }

    public static final ClassLoader getSafeClassLoader(Class<?> r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        ClassLoader r2 = r1.getClassLoader();
        if (r2 == null) goto L5;
        return r2;
    L5:
        return ClassLoader.getSystemClassLoader();
    }

    public static final Class<?> getWrapperByPrimitive(Class<?> r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return PRIMITIVE_TO_WRAPPER.get(r1);
    }

    public static final boolean isEnumClassOrSpecializedEnumEntryClass(Class<?> r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return Enum.class.isAssignableFrom(r1);
    }
}
