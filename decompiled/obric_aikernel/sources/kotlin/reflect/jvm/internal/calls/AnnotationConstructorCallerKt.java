package kotlin.reflect.jvm.internal.calls;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes3.dex */
public final class AnnotationConstructorCallerKt {
    public static final /* synthetic */ boolean access$createAnnotationInstance$equals(Class r10, List r11, Map r12, Object r13) {
        return createAnnotationInstance$equals(r10, r11, r12, r13);
    }

    public static final /* synthetic */ int access$createAnnotationInstance$lambda$2(Lazy r10) {
        return createAnnotationInstance$lambda$2(r10);
    }

    public static final /* synthetic */ String access$createAnnotationInstance$lambda$3(Lazy r10) {
        return createAnnotationInstance$lambda$3(r10);
    }

    public static final /* synthetic */ Void access$throwIllegalArgumentType(int r10, String r11, Class r12) {
        return throwIllegalArgumentType(r10, r11, r12);
    }

    public static final /* synthetic */ Object access$transformKotlinToJvm(Object r10, Class r11) {
        return transformKotlinToJvm(r10, r11);
    }

    public static final <T> T createAnnotationInstance(final Class<T> r10, final Map<String, ? extends Object> r11, final List<Method> r12) {
        Intrinsics.checkNotNullParameter(r10, "annotationClass");
        Intrinsics.checkNotNullParameter(r11, "values");
        Intrinsics.checkNotNullParameter(r12, "methods");
        final Lazy r13 = LazyKt.lazy(new AnnotationConstructorCallerKt$createAnnotationInstance$hashCode$2(r11));
        final Lazy r14 = LazyKt.lazy(new AnnotationConstructorCallerKt$createAnnotationInstance$toString$2(r10, r11));
        T r15 = (T) Proxy.newProxyInstance(r10.getClassLoader(), new Class[]{r10}, new AnnotationConstructorCallerKt$createAnnotationInstance$result$1(r10, r11, r14, r13, r12));
        Intrinsics.checkNotNull(r15, "null cannot be cast to non-null type T of kotlin.reflect.jvm.internal.calls.AnnotationConstructorCallerKt.createAnnotationInstance");
        return r15;
    }

    public static /* synthetic */ Object createAnnotationInstance$default(Class r10, Map r11, List r12, int r13, Object r14) {
        if ((r13 & 4) == 0) goto L10;
        Set r15 = r11.keySet();
        ArrayList r16 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r15, 10));
        Iterator r17 = r15.iterator();
    L6:
        if (r17.hasNext() == false) goto L8;
        r16.add(r10.getDeclaredMethod((String) r17.next(), new Class[0]));
        goto L6
    L8:
        r12 = r16;
    L10:
        return createAnnotationInstance(r10, r11, r12);
    }

    private static final <T> boolean createAnnotationInstance$equals(Class<T> r10, List<Method> r11, Map<String, ? extends Object> r12, Object r13) {
        Class r14 = null;
        if ((r13 instanceof Annotation) == false) goto L5;
        Annotation r15 = (Annotation) r13;
    L6:
        if (r15 == null) goto L11;
        KClass r16 = JvmClassMappingKt.getAnnotationClass(r15);
        if (r16 == null) goto L11;
        r14 = JvmClassMappingKt.getJavaClass(r16);
    L11:
        if (Intrinsics.areEqual(r14, r10) == false) goto L53;
        if ((r11 instanceof Collection) == true) goto L15;
    L17:
        Iterator<T> r17 = r11.iterator();
    L19:
        if (r17.hasNext() == false) goto L16;
        Method r18 = (Method) r17.next();
        Object r19 = r12.get(r18.getName());
        Object r20 = r18.invoke(r13, new Object[0]);
        if ((r19 instanceof boolean[]) == false) goto L24;
        Intrinsics.checkNotNull(r20, "null cannot be cast to non-null type kotlin.BooleanArray");
        boolean r21 = Arrays.equals((boolean[]) r19, (boolean[]) r20);
    L48:
        if (r21 == true) goto L19;
        boolean r22 = false;
    L50:
        if (r22 == false) goto L53;
        return true;
    L24:
        if ((r19 instanceof char[]) == false) goto L27;
        Intrinsics.checkNotNull(r20, "null cannot be cast to non-null type kotlin.CharArray");
        r21 = Arrays.equals((char[]) r19, (char[]) r20);
        goto L48
    L27:
        if ((r19 instanceof byte[]) == false) goto L30;
        Intrinsics.checkNotNull(r20, "null cannot be cast to non-null type kotlin.ByteArray");
        r21 = Arrays.equals((byte[]) r19, (byte[]) r20);
        goto L48
    L30:
        if ((r19 instanceof short[]) == false) goto L33;
        Intrinsics.checkNotNull(r20, "null cannot be cast to non-null type kotlin.ShortArray");
        r21 = Arrays.equals((short[]) r19, (short[]) r20);
        goto L48
    L33:
        if ((r19 instanceof int[]) == false) goto L36;
        Intrinsics.checkNotNull(r20, "null cannot be cast to non-null type kotlin.IntArray");
        r21 = Arrays.equals((int[]) r19, (int[]) r20);
        goto L48
    L36:
        if ((r19 instanceof float[]) == false) goto L39;
        Intrinsics.checkNotNull(r20, "null cannot be cast to non-null type kotlin.FloatArray");
        r21 = Arrays.equals((float[]) r19, (float[]) r20);
        goto L48
    L39:
        if ((r19 instanceof long[]) == false) goto L42;
        Intrinsics.checkNotNull(r20, "null cannot be cast to non-null type kotlin.LongArray");
        r21 = Arrays.equals((long[]) r19, (long[]) r20);
        goto L48
    L42:
        if ((r19 instanceof double[]) == false) goto L45;
        Intrinsics.checkNotNull(r20, "null cannot be cast to non-null type kotlin.DoubleArray");
        r21 = Arrays.equals((double[]) r19, (double[]) r20);
        goto L48
    L45:
        if ((r19 instanceof Object[]) == false) goto L47;
        Intrinsics.checkNotNull(r20, "null cannot be cast to non-null type kotlin.Array<*>");
        r21 = Arrays.equals((Object[]) r19, (Object[]) r20);
        goto L48
    L47:
        r21 = Intrinsics.areEqual(r19, r20);
    L16:
        r22 = true;
        goto L50
    L15:
        if (r11.isEmpty() == false) goto L17;
    L53:
        return false;
    L5:
        r15 = null;
        goto L6
    }

    private static final int createAnnotationInstance$lambda$2(Lazy<Integer> r10) {
        return r10.getValue().intValue();
    }

    private static final String createAnnotationInstance$lambda$3(Lazy<String> r10) {
        return r10.getValue();
    }

    private static final Void throwIllegalArgumentType(int r10, String r11, Class<?> r12) {
        if (Intrinsics.areEqual(r12, Class.class) == false) goto L7;
        Class r13 = KClass.class;
    L5:
        KClass r14 = Reflection.getOrCreateKotlinClass(r13);
    L13:
        if (Intrinsics.areEqual(r14.getQualifiedName(), Reflection.getOrCreateKotlinClass(Object[].class).getQualifiedName()) == false) goto L15;
        StringBuilder r15 = new StringBuilder();
        r15.append(r14.getQualifiedName());
        r15.append(Typography.less);
        Class<?> r16 = JvmClassMappingKt.getJavaClass(r14).getComponentType();
        Intrinsics.checkNotNullExpressionValue(r16, "kotlinClass.java.componentType");
        r15.append(JvmClassMappingKt.getKotlinClass(r16).getQualifiedName());
        r15.append(Typography.greater);
        String r17 = r15.toString();
    L17:
        throw new IllegalArgumentException("Argument #" + r10 + ' ' + r11 + " is not of the required type " + r17);
    L15:
        r17 = r14.getQualifiedName();
        goto L17
    L7:
        if (r12.isArray() == true) goto L9;
    L11:
        r14 = JvmClassMappingKt.getKotlinClass(r12);
        goto L13
    L9:
        if (Intrinsics.areEqual(r12.getComponentType(), Class.class) == false) goto L11;
        r13 = KClass[].class;
        goto L5
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
        Object[] r12 = (Object[]) r10;
        if ((r12 instanceof Class[]) == false) goto L14;
        return null;
    L14:
        if ((r12 instanceof KClass[]) == false) goto L19;
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type kotlin.Array<kotlin.reflect.KClass<*>>");
        KClass[] r13 = (KClass[]) r10;
        ArrayList r14 = new ArrayList(r13.length);
        int r15 = r13.length;
        int r16 = 0;
    L16:
        if (r16 >= r15) goto L18;
        r14.add(JvmClassMappingKt.getJavaClass(r13[r16]));
        r16 = r16 + 1;
        goto L16
    L18:
        r10 = r14.toArray(new Class[0]);
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        goto L21
    L19:
        r10 = r12;
        goto L21
    }
}
