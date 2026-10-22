package kotlin.reflect.jvm;

import androidx.exifinterface.media.ExifInterface;
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
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
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
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010%\u001a\u0004\u0018\u00010&*\u00020'H\u0002\"/\u0010\u0000\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00038F¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u001b\u0010\b\u001a\u0004\u0018\u00010\t*\u0006\u0012\u0002\b\u00030\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f\"\u001b\u0010\r\u001a\u0004\u0018\u00010\u000e*\u0006\u0012\u0002\b\u00030\n8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\"\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u000e*\u0006\u0012\u0002\b\u00030\u00038F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013\"\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u000e*\u0006\u0012\u0002\b\u00030\u00158F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017\"\u0015\u0010\u0018\u001a\u00020\u0019*\u00020\u001a8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c\"-\u0010\u001d\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0003\"\b\b\u0000\u0010\u0002*\u00020\u001e*\b\u0012\u0004\u0012\u0002H\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\u001f\u0010 \"\u001b\u0010\u001d\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0003*\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010!\"\u001b\u0010\"\u001a\b\u0012\u0002\b\u0003\u0018\u00010\n*\u00020\t8F¢\u0006\u0006\u001a\u0004\b#\u0010$¨\u0006("}, d2 = {"javaConstructor", "Ljava/lang/reflect/Constructor;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/reflect/KFunction;", "getJavaConstructor$annotations", "(Lkotlin/reflect/KFunction;)V", "getJavaConstructor", "(Lkotlin/reflect/KFunction;)Ljava/lang/reflect/Constructor;", "javaField", "Ljava/lang/reflect/Field;", "Lkotlin/reflect/KProperty;", "getJavaField", "(Lkotlin/reflect/KProperty;)Ljava/lang/reflect/Field;", "javaGetter", "Ljava/lang/reflect/Method;", "getJavaGetter", "(Lkotlin/reflect/KProperty;)Ljava/lang/reflect/Method;", "javaMethod", "getJavaMethod", "(Lkotlin/reflect/KFunction;)Ljava/lang/reflect/Method;", "javaSetter", "Lkotlin/reflect/KMutableProperty;", "getJavaSetter", "(Lkotlin/reflect/KMutableProperty;)Ljava/lang/reflect/Method;", "javaType", "Ljava/lang/reflect/Type;", "Lkotlin/reflect/KType;", "getJavaType", "(Lkotlin/reflect/KType;)Ljava/lang/reflect/Type;", "kotlinFunction", "", "getKotlinFunction", "(Ljava/lang/reflect/Constructor;)Lkotlin/reflect/KFunction;", "(Ljava/lang/reflect/Method;)Lkotlin/reflect/KFunction;", "kotlinProperty", "getKotlinProperty", "(Ljava/lang/reflect/Field;)Lkotlin/reflect/KProperty;", "getKPackage", "Lkotlin/reflect/KDeclarationContainer;", "Ljava/lang/reflect/Member;", "kotlin-reflection"}, k = 2, mv = {1, 8, 0}, xi = 48)
@JvmName(name = "ReflectJvmMapping")
@SourceDebugExtension({"SMAP\nReflectJvmMapping.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReflectJvmMapping.kt\nkotlin/reflect/jvm/ReflectJvmMapping\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,148:1\n800#2,11:149\n288#2,2:160\n288#2,2:162\n800#2,11:164\n288#2,2:175\n288#2,2:177\n288#2,2:180\n288#2,2:182\n1#3:179\n*S KotlinDebug\n*F\n+ 1 ReflectJvmMapping.kt\nkotlin/reflect/jvm/ReflectJvmMapping\n*L\n99#1:149,11\n99#1:160,2\n102#1:162,2\n122#1:164,11\n122#1:175,2\n128#1:177,2\n136#1:180,2\n146#1:182,2\n*E\n"})
public final class ReflectJvmMapping {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r5 = new int[KotlinClassHeader.Kind.values().length];
            r5[KotlinClassHeader.Kind.FILE_FACADE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r5[KotlinClassHeader.Kind.MULTIFILE_CLASS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r5[KotlinClassHeader.Kind.MULTIFILE_CLASS_PART.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r5;
        }
    }

    public static final <T> Constructor<T> getJavaConstructor(KFunction<? extends T> r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        KCallableImpl<?> r10 = UtilKt.asKCallableImpl(r5);
        if (r10 == null) goto L7;
        Caller<?> r11 = r10.getCaller();
        if (r11 == null) goto L7;
        Member r12 = r11.mo1394getMember();
    L9:
        if ((r12 instanceof Constructor) == true) goto L11;
        return null;
    L11:
        return (Constructor) r12;
    L7:
        r12 = null;
        goto L9
    }

    public static /* synthetic */ void getJavaConstructor$annotations(KFunction r5) {
    }

    public static final Field getJavaField(KProperty<?> r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        KPropertyImpl<?> r10 = UtilKt.asKPropertyImpl(r5);
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.getJavaField();
    }

    public static final Method getJavaGetter(KProperty<?> r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return getJavaMethod(r5.getGetter());
    }

    public static final Method getJavaMethod(KFunction<?> r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        KCallableImpl<?> r10 = UtilKt.asKCallableImpl(r5);
        if (r10 == null) goto L7;
        Caller<?> r11 = r10.getCaller();
        if (r11 == null) goto L7;
        Member r12 = r11.mo1394getMember();
    L9:
        if ((r12 instanceof Method) == true) goto L11;
        return null;
    L11:
        return (Method) r12;
    L7:
        r12 = null;
        goto L9
    }

    public static final Method getJavaSetter(KMutableProperty<?> r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return getJavaMethod(r5.getSetter());
    }

    public static final Type getJavaType(KType r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Type r10 = ((KTypeImpl) r5).getJavaType();
        if (r10 == null) goto L5;
        return r10;
    L5:
        return TypesJVMKt.getJavaType(r5);
    }

    private static final KDeclarationContainer getKPackage(Member r5) {
        ReflectKotlinClass r10 = ReflectKotlinClass.Factory.create(r5.getDeclaringClass());
        if (r10 == null) goto L7;
        KotlinClassHeader r11 = r10.getClassHeader();
        if (r11 == null) goto L7;
        KotlinClassHeader.Kind r12 = r11.getKind();
    L8:
        if (r12 != null) goto L10;
        int r13 = -1;
    L12:
        if (r13 == 1) goto L19;
        if (r13 == 2) goto L19;
        if (r13 == 3) goto L19;
        return null;
    L19:
        return new KPackageImpl(r5.getDeclaringClass());
    L10:
        r13 = WhenMappings.$EnumSwitchMapping$0[r12.ordinal()];
    L7:
        r12 = null;
        goto L8
    }

    public static final KFunction<?> getKotlinFunction(Method r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Object r5 = null;
        if (Modifier.isStatic(r10.getModifiers()) == false) goto L38;
        KDeclarationContainer r11 = getKPackage(r10);
        if (r11 == null) goto L20;
        Collection<KCallable<?>> r12 = r11.getMembers();
        ArrayList r13 = new ArrayList();
        Iterator<T> r14 = r12.iterator();
    L8:
        if (r14.hasNext() == false) goto L12;
        Object r15 = r14.next();
        if ((r15 instanceof KFunction) == false) goto L8;
        r13.add(r15);
        goto L8
    L12:
        Iterator r16 = r13.iterator();
    L14:
        if (r16.hasNext() == false) goto L19;
        Object r17 = r16.next();
        if (Intrinsics.areEqual(getJavaMethod((KFunction) r17), r10) == false) goto L14;
        r5 = r17;
    L19:
        return (KFunction) r5;
    L20:
        KClass<?> r18 = KClasses.getCompanionObject(JvmClassMappingKt.getKotlinClass(r10.getDeclaringClass()));
        if (r18 == null) goto L38;
        Iterator<T> r19 = KClasses.getFunctions(r18).iterator();
    L24:
        if (r19.hasNext() == false) goto L34;
        Object r20 = r19.next();
        Method r21 = getJavaMethod((KFunction) r20);
        if (r21 == null) goto L24;
        if (Intrinsics.areEqual(r21.getName(), r10.getName()) == false) goto L24;
        if (Arrays.equals(r21.getParameterTypes(), r10.getParameterTypes()) == false) goto L24;
        if (Intrinsics.areEqual(r21.getReturnType(), r10.getReturnType()) == false) goto L24;
    L35:
        KFunction<?> r22 = (KFunction) r20;
        if (r22 == null) goto L38;
        return r22;
    L34:
        r20 = null;
    L38:
        Iterator<T> r23 = KClasses.getFunctions(JvmClassMappingKt.getKotlinClass(r10.getDeclaringClass())).iterator();
    L40:
        if (r23.hasNext() == false) goto L45;
        Object r24 = r23.next();
        if (Intrinsics.areEqual(getJavaMethod((KFunction) r24), r10) == false) goto L40;
        r5 = r24;
    L45:
        return (KFunction) r5;
    }

    public static final KProperty<?> getKotlinProperty(Field r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Object r10 = null;
        if (r5.isSynthetic() == false) goto L5;
        return null;
    L5:
        KDeclarationContainer r11 = getKPackage(r5);
        if (r11 == null) goto L21;
        Collection<KCallable<?>> r12 = r11.getMembers();
        ArrayList r13 = new ArrayList();
        Iterator<T> r14 = r12.iterator();
    L9:
        if (r14.hasNext() == false) goto L13;
        Object r15 = r14.next();
        if ((r15 instanceof KProperty) == false) goto L9;
        r13.add(r15);
        goto L9
    L13:
        Iterator r16 = r13.iterator();
    L15:
        if (r16.hasNext() == false) goto L20;
        Object r17 = r16.next();
        if (Intrinsics.areEqual(getJavaField((KProperty) r17), r5) == false) goto L15;
        r10 = r17;
    L20:
        return (KProperty) r10;
    L21:
        Iterator r18 = KClasses.getMemberProperties(JvmClassMappingKt.getKotlinClass(r5.getDeclaringClass())).iterator();
    L23:
        if (r18.hasNext() == false) goto L28;
        Object r19 = r18.next();
        if (Intrinsics.areEqual(getJavaField((KProperty1) r19), r5) == false) goto L23;
        r10 = r19;
    L28:
        return (KProperty) r10;
    }

    public static final <T> KFunction<T> getKotlinFunction(Constructor<T> r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Iterator<T> r10 = JvmClassMappingKt.getKotlinClass(r5.getDeclaringClass()).getConstructors().iterator();
    L4:
        if (r10.hasNext() == false) goto L8;
        T r11 = r10.next();
        if (Intrinsics.areEqual(getJavaConstructor((KFunction) r11), r5) == false) goto L4;
    L10:
        return (KFunction) r11;
    L8:
        r11 = null;
        goto L10
    }
}
