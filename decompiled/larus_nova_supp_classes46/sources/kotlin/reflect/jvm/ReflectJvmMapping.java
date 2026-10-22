package kotlin.reflect.jvm;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KCallable;
import kotlin.reflect.KClass;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KFunction;
import kotlin.reflect.KMutableProperty;
import kotlin.reflect.KProperty;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000Z\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a\u000e\u0010 \u001a\u0004\u0018\u00010!*\u00020\"H\u0002\u001a$\u0010&\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000e*\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030(0'2\u0006\u0010)\u001a\u00020\u0006H\u0002\u001a$\u0010*\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0002*\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030(0'2\u0006\u0010+\u001a\u00020\u0001H\u0002\"\u001b\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u0006\u0012\u0002\b\u00030\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u0006\u0012\u0002\b\u00030\u00028F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\"\u001b\u0010\t\u001a\u0004\u0018\u00010\u0006*\u0006\u0012\u0002\b\u00030\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f\"\u001b\u0010\r\u001a\u0004\u0018\u00010\u0006*\u0006\u0012\u0002\b\u00030\u000e8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\"/\u0010\u0011\u001a\n\u0012\u0004\u0012\u0002H\u0013\u0018\u00010\u0012\"\u0004\b\u0000\u0010\u0013*\b\u0012\u0004\u0012\u0002H\u00130\u000e8F¢\u0006\f\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0015\u0010\u0018\u001a\u00020\u0019*\u00020\u001a8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c\"\u001b\u0010\u001d\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0002*\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f\"\u001b\u0010#\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000e*\u00020\u00068F¢\u0006\u0006\u001a\u0004\b$\u0010%\"-\u0010#\u001a\n\u0012\u0004\u0012\u0002H\u0013\u0018\u00010\u000e\"\b\b\u0000\u0010\u0013*\u00020,*\b\u0012\u0004\u0012\u0002H\u00130\u00128F¢\u0006\u0006\u001a\u0004\b$\u0010-¨\u0006."}, d2 = {"javaField", "Ljava/lang/reflect/Field;", "Lkotlin/reflect/KProperty;", "getJavaField", "(Lkotlin/reflect/KProperty;)Ljava/lang/reflect/Field;", "javaGetter", "Ljava/lang/reflect/Method;", "getJavaGetter", "(Lkotlin/reflect/KProperty;)Ljava/lang/reflect/Method;", "javaSetter", "Lkotlin/reflect/KMutableProperty;", "getJavaSetter", "(Lkotlin/reflect/KMutableProperty;)Ljava/lang/reflect/Method;", "javaMethod", "Lkotlin/reflect/KFunction;", "getJavaMethod", "(Lkotlin/reflect/KFunction;)Ljava/lang/reflect/Method;", "javaConstructor", "Ljava/lang/reflect/Constructor;", "T", "getJavaConstructor$annotations", "(Lkotlin/reflect/KFunction;)V", "getJavaConstructor", "(Lkotlin/reflect/KFunction;)Ljava/lang/reflect/Constructor;", "javaType", "Ljava/lang/reflect/Type;", "Lkotlin/reflect/KType;", "getJavaType", "(Lkotlin/reflect/KType;)Ljava/lang/reflect/Type;", "kotlinProperty", "getKotlinProperty", "(Ljava/lang/reflect/Field;)Lkotlin/reflect/KProperty;", "getKPackage", "Lkotlin/reflect/KDeclarationContainer;", "Ljava/lang/reflect/Member;", "kotlinFunction", "getKotlinFunction", "(Ljava/lang/reflect/Method;)Lkotlin/reflect/KFunction;", "findKFunction", "", "Lkotlin/reflect/KCallable;", "method", "findKProperty", "field", "", "(Ljava/lang/reflect/Constructor;)Lkotlin/reflect/KFunction;", "kotlin-reflection"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ReflectJvmMapping {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[KotlinClassHeader.Kind.values().length];
            r0[KotlinClassHeader.Kind.FILE_FACADE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[KotlinClassHeader.Kind.MULTIFILE_CLASS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[KotlinClassHeader.Kind.MULTIFILE_CLASS_PART.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r0;
        }
    }

    public static /* synthetic */ void getJavaConstructor$annotations(KFunction r0) {
    }

    public static final <T> Constructor<T> getJavaConstructor(KFunction<? extends T> r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        KCallableImpl r3 = UtilKt.asKCallableImpl(r2);
        if (r3 == null) goto L7;
        Caller r4 = r3.getCaller();
        if (r4 == null) goto L7;
        Member r5 = r4.getMember();
    L9:
        if ((r5 instanceof Constructor) == true) goto L11;
        return null;
    L11:
        return (Constructor) r5;
    L7:
        r5 = null;
        goto L9
    }

    public static final Field getJavaField(KProperty<?> r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        KPropertyImpl r2 = UtilKt.asKPropertyImpl(r1);
        if (r2 != null) goto L7;
        return null;
    L7:
        return r2.getJavaField();
    }

    public static final Method getJavaGetter(KProperty<?> r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return getJavaMethod(r1.getGetter());
    }

    public static final Method getJavaMethod(KFunction<?> r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        KCallableImpl r3 = UtilKt.asKCallableImpl(r2);
        if (r3 == null) goto L7;
        Caller r4 = r3.getCaller();
        if (r4 == null) goto L7;
        Member r5 = r4.getMember();
    L9:
        if ((r5 instanceof Method) == true) goto L11;
        return null;
    L11:
        return (Method) r5;
    L7:
        r5 = null;
        goto L9
    }

    public static final Method getJavaSetter(KMutableProperty<?> r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return getJavaMethod(r1.getSetter());
    }

    public static final Type getJavaType(KType r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Type r0 = ((KTypeImpl) r1).getJavaType();
        if (r0 == null) goto L5;
        return r0;
    L5:
        return TypesJVMKt.getJavaType(r1);
    }

    private static final KDeclarationContainer getKPackage(Member r3) {
        ReflectKotlinClass r0 = ReflectKotlinClass.Factory.create(r3.getDeclaringClass());
        if (r0 == null) goto L7;
        KotlinClassHeader r1 = r0.getClassHeader();
        if (r1 == null) goto L7;
        KotlinClassHeader.Kind r2 = r1.getKind();
    L8:
        if (r2 != null) goto L10;
        int r4 = -1;
    L12:
        if (r4 == 1) goto L19;
        if (r4 == 2) goto L19;
        if (r4 == 3) goto L19;
        return null;
    L19:
        return new KPackageImpl(r3.getDeclaringClass());
    L10:
        r4 = WhenMappings.$EnumSwitchMapping$0[r2.ordinal()];
    L7:
        r2 = null;
        goto L8
    }

    public static final KFunction<?> getKotlinFunction(Method r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (Modifier.isStatic(r5.getModifiers()) == false) goto L16;
        KDeclarationContainer r0 = getKPackage(r5);
        if (r0 != null) goto L7;
        KClass r1 = KClasses.getCompanionObject(JvmClassMappingKt.getKotlinClass(r5.getDeclaringClass()));
        if (r1 == null) goto L16;
        Class r2 = JvmClassMappingKt.getJavaClass(r1);
        String r3 = r5.getName();
        Class<?>[] r4 = r5.getParameterTypes();
        Method r6 = UtilKt.getDeclaredMethodOrNull(r2, r3, (Class[]) Arrays.copyOf(r4, r4.length));
        if (r6 == null) goto L16;
        KFunction<?> r7 = findKFunction(KClasses.getFunctions(r1), r6);
        if (r7 == null) goto L16;
        return r7;
    L7:
        return findKFunction(r0.getMembers(), r5);
    L16:
        return findKFunction(KClasses.getFunctions(JvmClassMappingKt.getKotlinClass(r5.getDeclaringClass())), r5);
    }

    public static final KProperty<?> getKotlinProperty(Field r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        if (r3.isSynthetic() == false) goto L7;
        return null;
    L7:
        if (Modifier.isStatic(r3.getModifiers()) == false) goto L20;
        KDeclarationContainer r0 = getKPackage(r3);
        if (r0 != null) goto L11;
        KClass r1 = KClasses.getCompanionObject(JvmClassMappingKt.getKotlinClass(r3.getDeclaringClass()));
        if (r1 == null) goto L20;
        Field r2 = UtilKt.getDeclaredFieldOrNull(r3.getDeclaringClass(), r3.getName());
        if (r2 == null) goto L20;
        KProperty<?> r4 = findKProperty(KClasses.getMemberProperties(r1), r2);
        if (r4 == null) goto L20;
        return r4;
    L11:
        return findKProperty(r0.getMembers(), r3);
    L20:
        return findKProperty(KClasses.getMemberProperties(JvmClassMappingKt.getKotlinClass(r3.getDeclaringClass())), r3);
    }

    public static final <T> KFunction<T> getKotlinFunction(Constructor<T> r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Iterator<T> r0 = JvmClassMappingKt.getKotlinClass(r3.getDeclaringClass()).getConstructors().iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        T r1 = r0.next();
        if (Intrinsics.areEqual(getJavaConstructor((KFunction) r1), r3) == false) goto L4;
    L10:
        return (KFunction) r1;
    L8:
        r1 = null;
        goto L10
    }

    private static final KFunction<?> findKFunction(Collection<? extends KCallable<?>> r4, Method r5) {
        Iterator<? extends KCallable<?>> r0 = r4.iterator();
    L4:
        if (r0.hasNext() == false) goto L12;
        KFunction<?> r1 = (KCallable) r0.next();
        if ((r1 instanceof KFunction) == false) goto L4;
        KFunction<?> r2 = r1;
        if (Intrinsics.areEqual(r2.getName(), r5.getName()) == false) goto L4;
        if (Intrinsics.areEqual(getJavaMethod(r2), r5) == false) goto L4;
        return r2;
    L12:
        Iterator<? extends KCallable<?>> r6 = r4.iterator();
    L14:
        if (r6.hasNext() == false) goto L22;
        KFunction<?> r3 = (KCallable) r6.next();
        if ((r3 instanceof KFunction) == false) goto L14;
        KFunction<?> r7 = r3;
        if (Intrinsics.areEqual(r7.getName(), r5.getName()) == true) goto L14;
        if (Intrinsics.areEqual(getJavaMethod(r7), r5) == false) goto L14;
        return r7;
    L22:
        return null;
    }

    private static final KProperty<?> findKProperty(Collection<? extends KCallable<?>> r4, Field r5) {
        Iterator<? extends KCallable<?>> r0 = r4.iterator();
    L4:
        if (r0.hasNext() == false) goto L12;
        KProperty<?> r1 = (KCallable) r0.next();
        if ((r1 instanceof KProperty) == false) goto L4;
        KProperty<?> r2 = r1;
        if (Intrinsics.areEqual(r2.getName(), r5.getName()) == false) goto L4;
        if (Intrinsics.areEqual(getJavaField(r2), r5) == false) goto L4;
        return r2;
    L12:
        Iterator<? extends KCallable<?>> r6 = r4.iterator();
    L14:
        if (r6.hasNext() == false) goto L22;
        KProperty<?> r3 = (KCallable) r6.next();
        if ((r3 instanceof KProperty) == false) goto L14;
        KProperty<?> r7 = r3;
        if (Intrinsics.areEqual(r7.getName(), r5.getName()) == true) goto L14;
        if (Intrinsics.areEqual(getJavaField(r7), r5) == false) goto L14;
        return r7;
    L22:
        return null;
    }
}
