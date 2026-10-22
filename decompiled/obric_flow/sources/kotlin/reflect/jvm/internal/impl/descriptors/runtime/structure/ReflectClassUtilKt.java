package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import androidx.constraintlayout.motion.widget.a;
import androidx.exifinterface.media.ExifInterface;
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
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nreflectClassUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 reflectClassUtil.kt\norg/jetbrains/kotlin/descriptors/runtime/structure/ReflectClassUtilKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,99:1\n1549#2:100\n1620#2,3:101\n1549#2:104\n1620#2,3:105\n1559#2:108\n1590#2,4:109\n*S KotlinDebug\n*F\n+ 1 reflectClassUtil.kt\norg/jetbrains/kotlin/descriptors/runtime/structure/ReflectClassUtilKt\n*L\n34#1:100\n34#1:101,3\n35#1:104\n35#1:105,3\n50#1:108\n50#1:109,4\n*E\n"})
public final class ReflectClassUtilKt {
    private static final Map<Class<? extends Function<?>>, Integer> FUNCTION_CLASSES = null;
    private static final List<KClass<? extends Object>> PRIMITIVE_CLASSES = null;
    private static final Map<Class<? extends Object>, Class<? extends Object>> PRIMITIVE_TO_WRAPPER = null;
    private static final Map<Class<? extends Object>, Class<? extends Object>> WRAPPER_TO_PRIMITIVE = null;

    static {
        int r10 = 0;
        List<KClass<? extends Object>> r5 = CollectionsKt.listOf(new KClass[]{Reflection.getOrCreateKotlinClass(Boolean.TYPE), Reflection.getOrCreateKotlinClass(Byte.TYPE), Reflection.getOrCreateKotlinClass(Character.TYPE), Reflection.getOrCreateKotlinClass(Double.TYPE), Reflection.getOrCreateKotlinClass(Float.TYPE), Reflection.getOrCreateKotlinClass(Integer.TYPE), Reflection.getOrCreateKotlinClass(Long.TYPE), Reflection.getOrCreateKotlinClass(Short.TYPE)});
        PRIMITIVE_CLASSES = r5;
        ArrayList r11 = new ArrayList(CollectionsKt.h(r5));
        Iterator<T> r12 = r5.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        KClass r13 = (KClass) r12.next();
        r11.add(TuplesKt.to(JvmClassMappingKt.getJavaObjectType(r13), JvmClassMappingKt.getJavaPrimitiveType(r13)));
        goto L4
    L6:
        WRAPPER_TO_PRIMITIVE = MapsKt.toMap(r11);
        List<KClass<? extends Object>> r14 = PRIMITIVE_CLASSES;
        ArrayList r15 = new ArrayList(CollectionsKt.h(r14));
        Iterator<T> r16 = r14.iterator();
    L8:
        if (r16.hasNext() == false) goto L10;
        KClass r17 = (KClass) r16.next();
        r15.add(TuplesKt.to(JvmClassMappingKt.getJavaPrimitiveType(r17), JvmClassMappingKt.getJavaObjectType(r17)));
        goto L8
    L10:
        PRIMITIVE_TO_WRAPPER = MapsKt.toMap(r15);
        List r18 = CollectionsKt.listOf(new Class[]{Function0.class, Function1.class, Function2.class, Function3.class, Function4.class, Function5.class, Function6.class, Function7.class, Function8.class, Function9.class, Function10.class, Function11.class, Function12.class, Function13.class, Function14.class, Function15.class, Function16.class, Function17.class, Function18.class, Function19.class, Function20.class, Function21.class, Function22.class});
        ArrayList r19 = new ArrayList(CollectionsKt.h(r18));
        Iterator r20 = r18.iterator();
    L12:
        if (r20.hasNext() == false) goto L17;
        Object r21 = r20.next();
        int r22 = r10 + 1;
        if (r10 >= 0) goto L16;
        CollectionsKt.throwIndexOverflow();
    L16:
        r19.add(TuplesKt.to((Class) r21, Integer.valueOf(r10)));
        r10 = r22;
        goto L12
    L17:
        FUNCTION_CLASSES = MapsKt.toMap(r19);
    }

    public static final ClassId getClassId(Class<?> r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (r5.isPrimitive() == true) goto L25;
        if (r5.isArray() == true) goto L23;
        if (r5.getEnclosingMethod() == null) goto L9;
    L20:
        FqName r10 = new FqName(r5.getName());
        return new ClassId(r10.parent(), FqName.topLevel(r10.shortName()), true);
    L9:
        if (r5.getEnclosingConstructor() != null) goto L20;
        if (r5.getSimpleName().length() == 0) goto L20;
        Class<?> r11 = r5.getDeclaringClass();
        if (r11 == null) goto L27;
        ClassId r12 = getClassId(r11);
        if (r12 == null) goto L27;
        ClassId r13 = r12.createNestedClassId(Name.identifier(r5.getSimpleName()));
        if (r13 == null) goto L27;
        return r13;
    L27:
        return ClassId.topLevel(new FqName(r5.getName()));
    L23:
        throw new IllegalArgumentException(a.l(r5, "Can't compute ClassId for array type: "));
    L25:
        throw new IllegalArgumentException(a.l(r5, "Can't compute ClassId for primitive type: "));
    }

    public static final String getDesc(Class<?> r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (r5.isPrimitive() == false) goto L37;
        String r10 = r5.getName();
        switch(r10.hashCode()) {
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
        if (r10.equals("short") == false) goto L35;
        return ExifInterface.LATITUDE_SOUTH;
    L11:
        if (r10.equals("float") == false) goto L35;
        return "F";
    L14:
        if (r10.equals("boolean") == false) goto L35;
        return "Z";
    L17:
        if (r10.equals("void") == false) goto L35;
        return ExifInterface.GPS_MEASUREMENT_INTERRUPTED;
    L20:
        if (r10.equals("long") == false) goto L35;
        return "J";
    L23:
        if (r10.equals("char") == false) goto L35;
        return "C";
    L26:
        if (r10.equals("byte") == false) goto L35;
        return "B";
    L29:
        if (r10.equals("int") == false) goto L35;
        return "I";
    L32:
        if (r10.equals("double") == false) goto L35;
        return "D";
    L35:
        throw new IllegalArgumentException(a.l(r5, "Unsupported primitive type: "));
    L37:
        if (r5.isArray() == false) goto L40;
        return StringsKt.E(r5.getName(), '.', '/');
    L40:
        return "L" + StringsKt.E(r5.getName(), '.', '/') + ';';
    }

    public static final Integer getFunctionClassArity(Class<?> r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return FUNCTION_CLASSES.get(r5);
    }

    public static final List<Type> getParameterizedTypeArguments(Type r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if ((r5 instanceof ParameterizedType) == false) goto L5;
        ParameterizedType r10 = (ParameterizedType) r5;
        if (r10.getOwnerType() != null) goto L11;
        return ArraysKt.toList(r10.getActualTypeArguments());
    L11:
        return SequencesKt.toList(SequencesKt.flatMap(SequencesKt.generateSequence(r5, ReflectClassUtilKt$parameterizedTypeArguments$1.INSTANCE), ReflectClassUtilKt$parameterizedTypeArguments$2.INSTANCE));
    L5:
        return CollectionsKt.emptyList();
    }

    public static final Class<?> getPrimitiveByWrapper(Class<?> r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return WRAPPER_TO_PRIMITIVE.get(r5);
    }

    public static final ClassLoader getSafeClassLoader(Class<?> r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        ClassLoader r10 = r5.getClassLoader();
        if (r10 == null) goto L5;
        return r10;
    L5:
        return ClassLoader.getSystemClassLoader();
    }

    public static final Class<?> getWrapperByPrimitive(Class<?> r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return PRIMITIVE_TO_WRAPPER.get(r5);
    }

    public static final boolean isEnumClassOrSpecializedEnumEntryClass(Class<?> r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return Enum.class.isAssignableFrom(r5);
    }
}
