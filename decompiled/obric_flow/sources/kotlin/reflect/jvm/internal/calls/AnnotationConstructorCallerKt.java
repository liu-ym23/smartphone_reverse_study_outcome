package kotlin.reflect.jvm.internal.calls;

import androidx.exifinterface.media.ExifInterface;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00004\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u001aI\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00010\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00020\u00062\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0000¢\u0006\u0002\u0010\u000b\u001a$\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00072\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0002\u001a\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0002*\u0004\u0018\u00010\u00022\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0002¨\u0006\u0014²\u0006\u0014\u0010\u0015\u001a\u00020\u000f\"\b\b\u0000\u0010\u0001*\u00020\u0002X\u008a\u0084\u0002²\u0006\u0014\u0010\u0016\u001a\u00020\u0007\"\b\b\u0000\u0010\u0001*\u00020\u0002X\u008a\u0084\u0002"}, d2 = {"createAnnotationInstance", ExifInterface.GPS_DIRECTION_TRUE, "", "annotationClass", "Ljava/lang/Class;", "values", "", "", "methods", "", "Ljava/lang/reflect/Method;", "(Ljava/lang/Class;Ljava/util/Map;Ljava/util/List;)Ljava/lang/Object;", "throwIllegalArgumentType", "", "index", "", "name", "expectedJvmType", "transformKotlinToJvm", "expectedType", "kotlin-reflection", "hashCode", "toString"}, k = 2, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAnnotationConstructorCaller.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AnnotationConstructorCaller.kt\nkotlin/reflect/jvm/internal/calls/AnnotationConstructorCallerKt\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 5 ArrayIntrinsics.kt\nkotlin/ArrayIntrinsicsKt\n*L\n1#1,181:1\n11335#2:182\n11670#2,3:183\n37#3,2:186\n18#3:195\n1549#4:188\n1620#4,3:189\n1726#4,3:192\n26#5:196\n*S KotlinDebug\n*F\n+ 1 AnnotationConstructorCaller.kt\nkotlin/reflect/jvm/internal/calls/AnnotationConstructorCallerKt\n*L\n75#1:182\n75#1:183,3\n75#1:186,2\n173#1:195\n102#1:188\n102#1:189,3\n106#1:192,3\n173#1:196\n*E\n"})
public final class AnnotationConstructorCallerKt {
    public static final /* synthetic */ Void access$throwIllegalArgumentType(int r5, String r10, Class r11) {
        return throwIllegalArgumentType(r5, r10, r11);
    }

    public static final /* synthetic */ Object access$transformKotlinToJvm(Object r5, Class r10) {
        return transformKotlinToJvm(r5, r10);
    }

    public static /* synthetic */ Object accessor$AnnotationConstructorCallerKt$lambda0(Class r5, Map r10, Lazy r11, Lazy r12, List r13, Object r14, Method r15, Object[] r16) {
        return createAnnotationInstance$lambda$4(r5, r10, r11, r12, r13, r14, r15, r16);
    }

    public static final <T> T createAnnotationInstance(final Class<T> r10, final Map<String, ? extends Object> r11, final List<Method> r12) {
        Intrinsics.checkNotNullParameter(r10, "annotationClass");
        Intrinsics.checkNotNullParameter(r11, "values");
        Intrinsics.checkNotNullParameter(r12, "methods");
        final Lazy r5 = LazyKt.lazy(new AnnotationConstructorCallerKt$createAnnotationInstance$hashCode$2(r11));
        final Lazy r13 = LazyKt.lazy(new AnnotationConstructorCallerKt$createAnnotationInstance$toString$2(r10, r11));
        T r14 = (T) Proxy.newProxyInstance(r10.getClassLoader(), new Class[]{r10}, new AnnotationConstructorCallerKt$$Lambda$0(r10, r11, r13, r5, r12));
        Intrinsics.checkNotNull(r14, "null cannot be cast to non-null type T of kotlin.reflect.jvm.internal.calls.AnnotationConstructorCallerKt.createAnnotationInstance");
        return r14;
    }

    public static /* synthetic */ Object createAnnotationInstance$default(Class r5, Map r10, List r11, int r12, Object r13) {
        if ((r12 & 4) == 0) goto L10;
        Set r14 = r10.keySet();
        ArrayList r15 = new ArrayList(CollectionsKt.h(r14));
        Iterator r16 = r14.iterator();
    L6:
        if (r16.hasNext() == false) goto L8;
        r15.add(r5.getDeclaredMethod((String) r16.next(), null));
        goto L6
    L8:
        r11 = r15;
    L10:
        return createAnnotationInstance(r5, r10, r11);
    }

    private static final <T> boolean createAnnotationInstance$equals(Class<T> r5, List<Method> r10, Map<String, ? extends Object> r11, Object r12) {
        if ((r12 instanceof Annotation) == false) goto L5;
        Annotation r13 = (Annotation) r12;
    L6:
        if (r13 == null) goto L10;
        KClass r14 = JvmClassMappingKt.getAnnotationClass(r13);
        if (r14 == null) goto L10;
        Class r15 = JvmClassMappingKt.getJavaClass(r14);
    L12:
        if (Intrinsics.areEqual(r15, r5) == true) goto L14;
        return false;
    L14:
        if (r10 != null) goto L16;
    L18:
        Iterator<T> r16 = r10.iterator();
    L20:
        if (r16.hasNext() == false) goto L17;
        Method r17 = (Method) r16.next();
        Object r18 = r11.get(r17.getName());
        Object r19 = r17.invoke(r12, null);
        if ((r18 instanceof boolean[]) == false) goto L25;
        Intrinsics.checkNotNull(r19, "null cannot be cast to non-null type kotlin.BooleanArray");
        boolean r20 = Arrays.equals((boolean[]) r18, (boolean[]) r19);
    L49:
        if (r20 == true) goto L20;
        boolean r21 = false;
    L51:
        if (r21 == true) goto L53;
        return false;
    L53:
        return true;
    L25:
        if ((r18 instanceof char[]) == false) goto L28;
        Intrinsics.checkNotNull(r19, "null cannot be cast to non-null type kotlin.CharArray");
        r20 = Arrays.equals((char[]) r18, (char[]) r19);
        goto L49
    L28:
        if ((r18 instanceof byte[]) == false) goto L31;
        Intrinsics.checkNotNull(r19, "null cannot be cast to non-null type kotlin.ByteArray");
        r20 = Arrays.equals((byte[]) r18, (byte[]) r19);
        goto L49
    L31:
        if ((r18 instanceof short[]) == false) goto L34;
        Intrinsics.checkNotNull(r19, "null cannot be cast to non-null type kotlin.ShortArray");
        r20 = Arrays.equals((short[]) r18, (short[]) r19);
        goto L49
    L34:
        if ((r18 instanceof int[]) == false) goto L37;
        Intrinsics.checkNotNull(r19, "null cannot be cast to non-null type kotlin.IntArray");
        r20 = Arrays.equals((int[]) r18, (int[]) r19);
        goto L49
    L37:
        if ((r18 instanceof float[]) == false) goto L40;
        Intrinsics.checkNotNull(r19, "null cannot be cast to non-null type kotlin.FloatArray");
        r20 = Arrays.equals((float[]) r18, (float[]) r19);
        goto L49
    L40:
        if ((r18 instanceof long[]) == false) goto L43;
        Intrinsics.checkNotNull(r19, "null cannot be cast to non-null type kotlin.LongArray");
        r20 = Arrays.equals((long[]) r18, (long[]) r19);
        goto L49
    L43:
        if ((r18 instanceof double[]) == false) goto L46;
        Intrinsics.checkNotNull(r19, "null cannot be cast to non-null type kotlin.DoubleArray");
        r20 = Arrays.equals((double[]) r18, (double[]) r19);
        goto L49
    L46:
        if ((r18 instanceof Object[]) == false) goto L48;
        Intrinsics.checkNotNull(r19, "null cannot be cast to non-null type kotlin.Array<*>");
        r20 = Arrays.equals((Object[]) r18, (Object[]) r19);
        goto L49
    L48:
        r20 = Intrinsics.areEqual(r18, r19);
    L17:
        r21 = true;
        goto L51
    L16:
        if (r10.isEmpty() == false) goto L18;
    L10:
        r15 = null;
        goto L12
    L5:
        r13 = null;
        goto L6
    }

    private static final int createAnnotationInstance$lambda$2(Lazy<Integer> r5) {
        return r5.getValue().intValue();
    }

    private static final String createAnnotationInstance$lambda$3(Lazy<String> r5) {
        return r5.getValue();
    }

    private static final Object createAnnotationInstance$lambda$4(Class r5, Map r10, Lazy r11, Lazy r12, List r13, Object r14, Method r15, Object[] r16) {
        Intrinsics.checkNotNullParameter(r5, "$annotationClass");
        Intrinsics.checkNotNullParameter(r10, "$values");
        Intrinsics.checkNotNullParameter(r11, "$toString$delegate");
        Intrinsics.checkNotNullParameter(r12, "$hashCode$delegate");
        Intrinsics.checkNotNullParameter(r13, "$methods");
        String r17 = r15.getName();
        if (r17 == null) goto L23;
        int r18 = r17.hashCode();
        if (r18 == (-1776922004)) goto L19;
        if (r18 == 147696667) goto L15;
        if (r18 != 1444986633) goto L23;
        if (r17.equals("annotationType") == false) goto L23;
        return r5;
    L15:
        if (r17.equals("hashCode") == false) goto L23;
        return Integer.valueOf(createAnnotationInstance$lambda$2(r12));
    L19:
        if (r17.equals("toString") == false) goto L23;
        return createAnnotationInstance$lambda$3(r11);
    L23:
        if (Intrinsics.areEqual(r17, "equals") == false) goto L29;
        if (r16 == null) goto L29;
        if (r16.length != 1) goto L29;
        return Boolean.valueOf(createAnnotationInstance$equals(r5, r13, r10, ArraysKt.single(r16)));
    L29:
        if (r10.containsKey(r17) == true) goto L31;
        StringBuilder r19 = new StringBuilder("Method is not supported: ");
        r19.append(r15);
        r19.append(" (args: ");
        if (r16 != null) goto L35;
        r16 = new Object[0];
    L35:
        r19.append(ArraysKt.toList(r16));
        r19.append(')');
        throw new KotlinReflectionInternalError(r19.toString());
    L31:
        return r10.get(r17);
    }

    private static final Void throwIllegalArgumentType(int r5, String r10, Class<?> r11) {
        if (Intrinsics.areEqual(r11, Class.class) == false) goto L6;
        KClass r12 = Reflection.getOrCreateKotlinClass(KClass.class);
    L12:
        if (Intrinsics.areEqual(r12.getQualifiedName(), Reflection.getOrCreateKotlinClass(Object[].class).getQualifiedName()) == false) goto L14;
        String r13 = r12.getQualifiedName() + Typography.less + JvmClassMappingKt.getKotlinClass(JvmClassMappingKt.getJavaClass(r12).getComponentType()).getQualifiedName() + Typography.greater;
    L16:
        throw new IllegalArgumentException("Argument #" + r5 + ' ' + r10 + " is not of the required type " + r13);
    L14:
        r13 = r12.getQualifiedName();
        goto L16
    L6:
        if (r11.isArray() == true) goto L8;
    L10:
        r12 = JvmClassMappingKt.getKotlinClass(r11);
        goto L12
    L8:
        if (Intrinsics.areEqual(r11.getComponentType(), Class.class) == false) goto L10;
        r12 = Reflection.getOrCreateKotlinClass(KClass[].class);
        goto L12
    }

    private static final Object transformKotlinToJvm(Object r10, Class<?> r11) {
        if ((r10 instanceof Class) == false) goto L6;
        return null;
    L6:
        if ((r10 instanceof KClass) == false) goto L9;
        r10 = JvmClassMappingKt.getJavaClass((KClass) r10);
    L21:
        if (r11.isInstance(r10) == true) goto L23;
        return null;
    L23:
        return r10;
    L9:
        if ((r10 instanceof Object[]) == false) goto L21;
        Object[] r5 = (Object[]) r10;
        if ((r5 instanceof Class[]) == false) goto L14;
        return null;
    L14:
        if ((r5 instanceof KClass[]) == false) goto L19;
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type kotlin.Array<kotlin.reflect.KClass<*>>");
        KClass[] r12 = (KClass[]) r10;
        ArrayList r13 = new ArrayList(r12.length);
        int r14 = r12.length;
        int r15 = 0;
    L16:
        if (r15 >= r14) goto L18;
        r13.add(JvmClassMappingKt.getJavaClass(r12[r15]));
        r15 = r15 + 1;
        goto L16
    L18:
        r10 = r13.toArray(new Class[0]);
        goto L21
    L19:
        r10 = r5;
        goto L21
    }
}
