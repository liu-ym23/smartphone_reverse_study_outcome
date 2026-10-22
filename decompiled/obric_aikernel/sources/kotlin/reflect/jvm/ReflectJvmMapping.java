package kotlin.reflect.jvm;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KCallable;
import kotlin.reflect.KClass;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KFunction;
import kotlin.reflect.KMutableProperty;
import kotlin.reflect.KProperty;
import kotlin.reflect.KProperty1;
import kotlin.reflect.KType;
import kotlin.reflect.TypesJVMKt;
import kotlin.reflect.full.KClasses;
import kotlin.reflect.jvm.internal.KCallableImpl;
import kotlin.reflect.jvm.internal.KPackageImpl;
import kotlin.reflect.jvm.internal.KPropertyImpl;
import kotlin.reflect.jvm.internal.KTypeImpl;
import kotlin.reflect.jvm.internal.UtilKt;
import kotlin.reflect.jvm.internal.calls.Caller;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectKotlinClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;

/* JADX INFO: loaded from: classes3.dex */
@JvmName(name = "ReflectJvmMapping")
public final class ReflectJvmMapping {

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r10 = new int[KotlinClassHeader.Kind.values().length];
            r10[KotlinClassHeader.Kind.FILE_FACADE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r10[KotlinClassHeader.Kind.MULTIFILE_CLASS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r10[KotlinClassHeader.Kind.MULTIFILE_CLASS_PART.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r10;
        }
    }

    public static final <T> Constructor<T> getJavaConstructor(KFunction<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        KCallableImpl<?> r11 = UtilKt.asKCallableImpl(r10);
        if (r11 == null) goto L7;
        Caller<?> r12 = r11.getCaller();
        if (r12 == null) goto L7;
        Member r13 = r12.mo1315getMember();
    L9:
        if ((r13 instanceof Constructor) == true) goto L11;
        return null;
    L11:
        return (Constructor) r13;
    L7:
        r13 = null;
        goto L9
    }

    public static /* synthetic */ void getJavaConstructor$annotations(KFunction r10) {
    }

    public static final Field getJavaField(KProperty<?> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        KPropertyImpl<?> r11 = UtilKt.asKPropertyImpl(r10);
        if (r11 != null) goto L7;
        return null;
    L7:
        return r11.getJavaField();
    }

    public static final Method getJavaGetter(KProperty<?> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return getJavaMethod(r10.getGetter());
    }

    public static final Method getJavaMethod(KFunction<?> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        KCallableImpl<?> r11 = UtilKt.asKCallableImpl(r10);
        if (r11 == null) goto L7;
        Caller<?> r12 = r11.getCaller();
        if (r12 == null) goto L7;
        Member r13 = r12.mo1315getMember();
    L9:
        if ((r13 instanceof Method) == true) goto L11;
        return null;
    L11:
        return (Method) r13;
    L7:
        r13 = null;
        goto L9
    }

    public static final Method getJavaSetter(KMutableProperty<?> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return getJavaMethod(r10.getSetter());
    }

    public static final Type getJavaType(KType r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Type r11 = ((KTypeImpl) r10).getJavaType();
        if (r11 == null) goto L5;
        return r11;
    L5:
        return TypesJVMKt.getJavaType(r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final KDeclarationContainer getKPackage(Member r10) {
        ReflectKotlinClass.Factory r11 = ReflectKotlinClass.Factory;
        Class<?> r12 = r10.getDeclaringClass();
        Intrinsics.checkNotNullExpressionValue(r12, "declaringClass");
        ReflectKotlinClass r13 = r11.create(r12);
        String r14 = null;
        Object[] r15 = 0;
        if (r13 == null) goto L7;
        KotlinClassHeader r16 = r13.getClassHeader();
        if (r16 == null) goto L7;
        KotlinClassHeader.Kind r17 = r16.getKind();
    L8:
        if (r17 != null) goto L10;
        int r18 = -1;
    L11:
        int r19 = 2;
        if (r18 == 1) goto L17;
        if (r18 == 2) goto L17;
        if (r18 == 3) goto L17;
        return null;
    L17:
        Class<?> r20 = r10.getDeclaringClass();
        Intrinsics.checkNotNullExpressionValue(r20, "declaringClass");
        return new KPackageImpl(r20, r14, r19, r15 == true ? 1 : 0);
    L10:
        r18 = WhenMappings.$EnumSwitchMapping$0[r17.ordinal()];
    L7:
        r17 = null;
        goto L8
    }

    public static final <T> KFunction<T> getKotlinFunction(Constructor<T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Class<T> r11 = r10.getDeclaringClass();
        Intrinsics.checkNotNullExpressionValue(r11, "declaringClass");
        Iterator<T> r12 = JvmClassMappingKt.getKotlinClass(r11).getConstructors().iterator();
    L4:
        if (r12.hasNext() == false) goto L8;
        T r13 = r12.next();
        if (Intrinsics.areEqual(getJavaConstructor((KFunction) r13), r10) == false) goto L4;
    L10:
        return (KFunction) r13;
    L8:
        r13 = null;
        goto L10
    }

    public static final KFunction<?> getKotlinFunction(Method r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Object r11 = null;
        if (Modifier.isStatic(r10.getModifiers()) == false) goto L41;
        KDeclarationContainer r12 = getKPackage(r10);
        if (r12 == null) goto L20;
        Collection<KCallable<?>> r13 = r12.getMembers();
        ArrayList r14 = new ArrayList();
        Iterator<T> r15 = r13.iterator();
    L8:
        if (r15.hasNext() == false) goto L12;
        Object r16 = r15.next();
        if ((r16 instanceof KFunction) == false) goto L8;
        r14.add(r16);
        goto L8
    L12:
        Iterator r17 = r14.iterator();
    L14:
        if (r17.hasNext() == false) goto L19;
        Object r18 = r17.next();
        if (Intrinsics.areEqual(getJavaMethod((KFunction) r18), r10) == false) goto L14;
        r11 = r18;
    L19:
        return (KFunction) r11;
    L20:
        Class<?> r19 = r10.getDeclaringClass();
        Intrinsics.checkNotNullExpressionValue(r19, "declaringClass");
        KClass<?> r20 = KClasses.getCompanionObject(JvmClassMappingKt.getKotlinClass(r19));
        if (r20 == null) goto L41;
        Iterator<T> r21 = KClasses.getFunctions(r20).iterator();
    L24:
        if (r21.hasNext() == false) goto L37;
        Object r22 = r21.next();
        Method r23 = getJavaMethod((KFunction) r22);
        if (r23 != null) goto L28;
    L34:
        boolean r24 = false;
    L35:
        if (r24 == false) goto L24;
    L38:
        KFunction<?> r25 = (KFunction) r22;
        if (r25 == null) goto L41;
        return r25;
    L28:
        if (Intrinsics.areEqual(r23.getName(), r10.getName()) == false) goto L34;
        if (Arrays.equals(r23.getParameterTypes(), r10.getParameterTypes()) == false) goto L34;
        if (Intrinsics.areEqual(r23.getReturnType(), r10.getReturnType()) == false) goto L34;
        r24 = true;
        goto L35
    L37:
        r22 = null;
    L41:
        Class<?> r26 = r10.getDeclaringClass();
        Intrinsics.checkNotNullExpressionValue(r26, "declaringClass");
        Iterator<T> r27 = KClasses.getFunctions(JvmClassMappingKt.getKotlinClass(r26)).iterator();
    L43:
        if (r27.hasNext() == false) goto L48;
        Object r28 = r27.next();
        if (Intrinsics.areEqual(getJavaMethod((KFunction) r28), r10) == false) goto L43;
        r11 = r28;
    L48:
        return (KFunction) r11;
    }

    public static final KProperty<?> getKotlinProperty(Field r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Object r11 = null;
        if (r10.isSynthetic() == false) goto L5;
        return null;
    L5:
        KDeclarationContainer r12 = getKPackage(r10);
        if (r12 == null) goto L21;
        Collection<KCallable<?>> r13 = r12.getMembers();
        ArrayList r14 = new ArrayList();
        Iterator<T> r15 = r13.iterator();
    L9:
        if (r15.hasNext() == false) goto L13;
        Object r16 = r15.next();
        if ((r16 instanceof KProperty) == false) goto L9;
        r14.add(r16);
        goto L9
    L13:
        Iterator r17 = r14.iterator();
    L15:
        if (r17.hasNext() == false) goto L20;
        Object r18 = r17.next();
        if (Intrinsics.areEqual(getJavaField((KProperty) r18), r10) == false) goto L15;
        r11 = r18;
    L20:
        return (KProperty) r11;
    L21:
        Class<?> r19 = r10.getDeclaringClass();
        Intrinsics.checkNotNullExpressionValue(r19, "declaringClass");
        Iterator r20 = KClasses.getMemberProperties(JvmClassMappingKt.getKotlinClass(r19)).iterator();
    L23:
        if (r20.hasNext() == false) goto L28;
        Object r21 = r20.next();
        if (Intrinsics.areEqual(getJavaField((KProperty1) r21), r10) == false) goto L23;
        r11 = r21;
    L28:
        return (KProperty) r11;
    }
}
