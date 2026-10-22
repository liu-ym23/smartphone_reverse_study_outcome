package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.crash.tracker.ActivityLifecycle;
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
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class ReflectClassUtilKt {
    private static final Map<Class<? extends Function<?>>, Integer> FUNCTION_CLASSES = null;
    private static final List<KClass<? extends Object>> PRIMITIVE_CLASSES = null;
    private static final Map<Class<? extends Object>, Class<? extends Object>> PRIMITIVE_TO_WRAPPER = null;
    private static final Map<Class<? extends Object>, Class<? extends Object>> WRAPPER_TO_PRIMITIVE = null;

    static {
        int r10 = 0;
        List<KClass<? extends Object>> r11 = CollectionsKt.listOf(new KClass[]{Reflection.getOrCreateKotlinClass(Boolean.TYPE), Reflection.getOrCreateKotlinClass(Byte.TYPE), Reflection.getOrCreateKotlinClass(Character.TYPE), Reflection.getOrCreateKotlinClass(Double.TYPE), Reflection.getOrCreateKotlinClass(Float.TYPE), Reflection.getOrCreateKotlinClass(Integer.TYPE), Reflection.getOrCreateKotlinClass(Long.TYPE), Reflection.getOrCreateKotlinClass(Short.TYPE)});
        PRIMITIVE_CLASSES = r11;
        ArrayList r12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r11, 10));
        Iterator<T> r13 = r11.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        KClass r14 = (KClass) r13.next();
        r12.add(TuplesKt.to(JvmClassMappingKt.getJavaObjectType(r14), JvmClassMappingKt.getJavaPrimitiveType(r14)));
        goto L4
    L6:
        WRAPPER_TO_PRIMITIVE = MapsKt.toMap(r12);
        List<KClass<? extends Object>> r15 = PRIMITIVE_CLASSES;
        ArrayList r16 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r15, 10));
        Iterator<T> r17 = r15.iterator();
    L8:
        if (r17.hasNext() == false) goto L10;
        KClass r18 = (KClass) r17.next();
        r16.add(TuplesKt.to(JvmClassMappingKt.getJavaPrimitiveType(r18), JvmClassMappingKt.getJavaObjectType(r18)));
        goto L8
    L10:
        PRIMITIVE_TO_WRAPPER = MapsKt.toMap(r16);
        List r19 = CollectionsKt.listOf(new Class[]{Function0.class, Function1.class, Function2.class, Function3.class, Function4.class, Function5.class, Function6.class, Function7.class, Function8.class, Function9.class, Function10.class, Function11.class, Function12.class, Function13.class, Function14.class, Function15.class, Function16.class, Function17.class, Function18.class, Function19.class, Function20.class, Function21.class, Function22.class});
        ArrayList r20 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r19, 10));
        Iterator r21 = r19.iterator();
    L12:
        if (r21.hasNext() == false) goto L17;
        Object r22 = r21.next();
        int r23 = r10 + 1;
        if (r10 >= 0) goto L16;
        CollectionsKt.throwIndexOverflow();
    L16:
        r20.add(TuplesKt.to((Class) r22, Integer.valueOf(r10)));
        r10 = r23;
        goto L12
    L17:
        FUNCTION_CLASSES = MapsKt.toMap(r20);
    }

    public static final ClassId getClassId(Class<?> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.isPrimitive() == true) goto L29;
        if (r10.isArray() == true) goto L27;
        if (r10.getEnclosingMethod() == null) goto L9;
    L24:
        FqName r11 = new FqName(r10.getName());
        return new ClassId(r11.parent(), FqName.topLevel(r11.shortName()), true);
    L9:
        if (r10.getEnclosingConstructor() != null) goto L24;
        String r12 = r10.getSimpleName();
        Intrinsics.checkNotNullExpressionValue(r12, "simpleName");
        if (r12.length() != 0) goto L13;
        boolean r13 = true;
    L14:
        if (r13 == true) goto L24;
        Class<?> r14 = r10.getDeclaringClass();
        if (r14 == null) goto L22;
        ClassId r15 = getClassId(r14);
        if (r15 == null) goto L22;
        ClassId r16 = r15.createNestedClassId(Name.identifier(r10.getSimpleName()));
        if (r16 == null) goto L22;
    L23:
        Intrinsics.checkNotNullExpressionValue(r16, "declaringClass?.classId?…Id.topLevel(FqName(name))");
        return r16;
    L22:
        r16 = ClassId.topLevel(new FqName(r10.getName()));
        goto L23
    L13:
        r13 = false;
        goto L14
    L27:
        throw new IllegalArgumentException("Can't compute ClassId for array type: " + r10);
    L29:
        throw new IllegalArgumentException("Can't compute ClassId for primitive type: " + r10);
    }

    public static final String getDesc(Class<?> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.isPrimitive() == false) goto L37;
        String r11 = r10.getName();
        switch(r11.hashCode()) {
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
        if (r11.equals("short") == false) goto L35;
        return "S";
    L11:
        if (r11.equals(TypedValues.Custom.S_FLOAT) == false) goto L35;
        return "F";
    L14:
        if (r11.equals(TypedValues.Custom.S_BOOLEAN) == false) goto L35;
        return "Z";
    L17:
        if (r11.equals("void") == false) goto L35;
        return "V";
    L20:
        if (r11.equals("long") == false) goto L35;
        return "J";
    L23:
        if (r11.equals("char") == false) goto L35;
        return "C";
    L26:
        if (r11.equals("byte") == false) goto L35;
        return "B";
    L29:
        if (r11.equals("int") == false) goto L35;
        return "I";
    L32:
        if (r11.equals("double") == false) goto L35;
        return "D";
    L35:
        throw new IllegalArgumentException("Unsupported primitive type: " + r10);
    L37:
        if (r10.isArray() == false) goto L39;
        String r12 = r10.getName();
        Intrinsics.checkNotNullExpressionValue(r12, ActivityLifecycle.NAME);
        return StringsKt.replace$default(r12, '.', '/', false, 4, null);
    L39:
        StringBuilder r13 = new StringBuilder();
        r13.append('L');
        String r14 = r10.getName();
        Intrinsics.checkNotNullExpressionValue(r14, ActivityLifecycle.NAME);
        r13.append(StringsKt.replace$default(r14, '.', '/', false, 4, null));
        r13.append(';');
        return r13.toString();
    }

    public static final Integer getFunctionClassArity(Class<?> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return FUNCTION_CLASSES.get(r10);
    }

    public static final List<Type> getParameterizedTypeArguments(Type r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if ((r10 instanceof ParameterizedType) == false) goto L5;
        ParameterizedType r11 = (ParameterizedType) r10;
        if (r11.getOwnerType() != null) goto L11;
        Type[] r12 = r11.getActualTypeArguments();
        Intrinsics.checkNotNullExpressionValue(r12, "actualTypeArguments");
        return ArraysKt.toList(r12);
    L11:
        return SequencesKt.toList(SequencesKt.flatMap(SequencesKt.generateSequence(r10, ReflectClassUtilKt$parameterizedTypeArguments$1.INSTANCE), ReflectClassUtilKt$parameterizedTypeArguments$2.INSTANCE));
    L5:
        return CollectionsKt.emptyList();
    }

    public static final Class<?> getPrimitiveByWrapper(Class<?> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return WRAPPER_TO_PRIMITIVE.get(r10);
    }

    public static final ClassLoader getSafeClassLoader(Class<?> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        ClassLoader r11 = r10.getClassLoader();
        if (r11 != null) goto L6;
        ClassLoader r12 = ClassLoader.getSystemClassLoader();
        Intrinsics.checkNotNullExpressionValue(r12, "getSystemClassLoader()");
        return r12;
    L6:
        return r11;
    }

    public static final Class<?> getWrapperByPrimitive(Class<?> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return PRIMITIVE_TO_WRAPPER.get(r10);
    }

    public static final boolean isEnumClassOrSpecializedEnumEntryClass(Class<?> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return Enum.class.isAssignableFrom(r10);
    }
}
