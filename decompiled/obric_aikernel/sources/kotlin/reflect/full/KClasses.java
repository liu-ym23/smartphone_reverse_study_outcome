package kotlin.reflect.full;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.SinceKotlin;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KCallable;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KFunction;
import kotlin.reflect.KParameter;
import kotlin.reflect.KProperty0;
import kotlin.reflect.KProperty1;
import kotlin.reflect.KProperty2;
import kotlin.reflect.KType;
import kotlin.reflect.jvm.internal.KCallableImpl;
import kotlin.reflect.jvm.internal.KClassImpl;
import kotlin.reflect.jvm.internal.KFunctionImpl;
import kotlin.reflect.jvm.internal.KTypeImpl;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.utils.DFS;

/* JADX INFO: loaded from: classes3.dex */
@JvmName(name = "KClasses")
public final class KClasses {
    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.1")
    public static final <T> T cast(KClass<T> r10, Object r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.isInstance(r11) == false) goto L7;
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type T of kotlin.reflect.full.KClasses.cast");
        return r11;
    L7:
        throw new TypeCastException("Value cannot be cast to " + r10.getQualifiedName());
    }

    @SinceKotlin(version = "1.1")
    public static final <T> T createInstance(KClass<T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Iterator<T> r11 = r10.getConstructors().iterator();
        T r12 = null;
        boolean r13 = false;
        T r14 = null;
    L4:
        if (r11.hasNext() == false) goto L20;
        T r15 = r11.next();
        List<KParameter> r16 = ((KFunction) r15).getParameters();
        if ((r16 instanceof Collection) == true) goto L8;
    L10:
        Iterator<T> r17 = r16.iterator();
    L12:
        if (r17.hasNext() == false) goto L9;
        if (((KParameter) r17.next()).isOptional() == true) goto L12;
        boolean r18 = false;
    L16:
        if (r18 == false) goto L4;
        if (r13 == true) goto L23;
        r13 = true;
        r14 = r15;
    L23:
        KFunction r19 = (KFunction) r12;
        if (r19 == null) goto L28;
        return (T) r19.callBy(MapsKt.emptyMap());
    L28:
        throw new IllegalArgumentException("Class should have a single no-arg constructor: " + r10);
    L9:
        r18 = true;
        goto L16
    L8:
        if (r16.isEmpty() == false) goto L10;
    L20:
        if (r13 == false) goto L23;
        r12 = r14;
        goto L23
    }

    public static final Collection<KClass<?>> getAllSuperclasses(KClass<?> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Collection<KType> r11 = getAllSupertypes(r10);
        ArrayList r12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r11, 10));
        Iterator<T> r13 = r11.iterator();
    L4:
        if (r13.hasNext() == false) goto L13;
        KType r14 = (KType) r13.next();
        KClassifier r15 = r14.getClassifier();
        if ((r15 instanceof KClass) == false) goto L8;
        KClass r16 = (KClass) r15;
    L9:
        if (r16 == null) goto L12;
        r12.add(r16);
        goto L4
    L12:
        throw new KotlinReflectionInternalError("Supertype not a class: " + r14);
    L8:
        r16 = null;
        goto L9
    L13:
        return r12;
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getAllSuperclasses$annotations(KClass r10) {
    }

    public static final Collection<KType> getAllSupertypes(KClass<?> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Object r11 = DFS.dfs(r10.getSupertypes(), KClasses$allSupertypes$1.INSTANCE, new DFS.VisitedWithSet(), new KClasses$allSupertypes$2());
        Intrinsics.checkNotNullExpressionValue(r11, "dfs(\n        supertypes,…        }\n        }\n    )");
        return (Collection) r11;
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getAllSupertypes$annotations(KClass r10) {
    }

    public static final KClass<?> getCompanionObject(KClass<?> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Iterator<T> r11 = r10.getNestedClasses().iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        Object r12 = r11.next();
        KClass r13 = (KClass) r12;
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KClassImpl<*>");
        if (((KClassImpl) r13).getDescriptor().isCompanionObject() == false) goto L4;
    L10:
        return (KClass) r12;
    L8:
        r12 = null;
        goto L10
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getCompanionObject$annotations(KClass r10) {
    }

    public static final Object getCompanionObjectInstance(KClass<?> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        KClass<?> r11 = getCompanionObject(r10);
        if (r11 != null) goto L7;
        return null;
    L7:
        return r11.getObjectInstance();
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getCompanionObjectInstance$annotations(KClass r10) {
    }

    public static final Collection<KFunction<?>> getDeclaredFunctions(KClass<?> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Collection<KCallableImpl<?>> r11 = ((KClassImpl.Data) ((KClassImpl) r10).getData().invoke()).getDeclaredMembers();
        ArrayList r12 = new ArrayList();
        Iterator<T> r13 = r11.iterator();
    L4:
        if (r13.hasNext() == false) goto L8;
        Object r14 = r13.next();
        if ((r14 instanceof KFunction) == false) goto L4;
        r12.add(r14);
        goto L4
    L8:
        return r12;
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getDeclaredFunctions$annotations(KClass r10) {
    }

    public static final Collection<KFunction<?>> getDeclaredMemberExtensionFunctions(KClass<?> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Collection<KCallableImpl<?>> r11 = ((KClassImpl.Data) ((KClassImpl) r10).getData().invoke()).getDeclaredNonStaticMembers();
        ArrayList r12 = new ArrayList();
        Iterator<T> r13 = r11.iterator();
    L4:
        if (r13.hasNext() == false) goto L13;
        Object r14 = r13.next();
        KCallableImpl r15 = (KCallableImpl) r14;
        if (isExtension(r15) == true) goto L8;
    L10:
        boolean r16 = false;
    L11:
        if (r16 == false) goto L4;
        r12.add(r14);
        goto L4
    L8:
        if ((r15 instanceof KFunction) == false) goto L10;
        r16 = true;
        goto L11
    L13:
        return r12;
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getDeclaredMemberExtensionFunctions$annotations(KClass r10) {
    }

    public static final <T> Collection<KProperty2<T, ?, ?>> getDeclaredMemberExtensionProperties(KClass<T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Collection<KCallableImpl<?>> r11 = ((KClassImpl) r10).getData().invoke().getDeclaredNonStaticMembers();
        ArrayList r12 = new ArrayList();
        Iterator<T> r13 = r11.iterator();
    L4:
        if (r13.hasNext() == false) goto L13;
        T r14 = r13.next();
        KCallableImpl r15 = (KCallableImpl) r14;
        if (isExtension(r15) == true) goto L8;
    L10:
        boolean r16 = false;
    L11:
        if (r16 == false) goto L4;
        r12.add(r14);
        goto L4
    L8:
        if ((r15 instanceof KProperty2) == false) goto L10;
        r16 = true;
        goto L11
    L13:
        return r12;
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getDeclaredMemberExtensionProperties$annotations(KClass r10) {
    }

    public static final Collection<KFunction<?>> getDeclaredMemberFunctions(KClass<?> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Collection<KCallableImpl<?>> r11 = ((KClassImpl.Data) ((KClassImpl) r10).getData().invoke()).getDeclaredNonStaticMembers();
        ArrayList r12 = new ArrayList();
        Iterator<T> r13 = r11.iterator();
    L4:
        if (r13.hasNext() == false) goto L13;
        Object r14 = r13.next();
        KCallableImpl r15 = (KCallableImpl) r14;
        if (isNotExtension(r15) == true) goto L8;
    L10:
        boolean r16 = false;
    L11:
        if (r16 == false) goto L4;
        r12.add(r14);
        goto L4
    L8:
        if ((r15 instanceof KFunction) == false) goto L10;
        r16 = true;
        goto L11
    L13:
        return r12;
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getDeclaredMemberFunctions$annotations(KClass r10) {
    }

    public static final <T> Collection<KProperty1<T, ?>> getDeclaredMemberProperties(KClass<T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Collection<KCallableImpl<?>> r11 = ((KClassImpl) r10).getData().invoke().getDeclaredNonStaticMembers();
        ArrayList r12 = new ArrayList();
        Iterator<T> r13 = r11.iterator();
    L4:
        if (r13.hasNext() == false) goto L13;
        T r14 = r13.next();
        KCallableImpl r15 = (KCallableImpl) r14;
        if (isNotExtension(r15) == true) goto L8;
    L10:
        boolean r16 = false;
    L11:
        if (r16 == false) goto L4;
        r12.add(r14);
        goto L4
    L8:
        if ((r15 instanceof KProperty1) == false) goto L10;
        r16 = true;
        goto L11
    L13:
        return r12;
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getDeclaredMemberProperties$annotations(KClass r10) {
    }

    public static final Collection<KCallable<?>> getDeclaredMembers(KClass<?> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return ((KClassImpl.Data) ((KClassImpl) r10).getData().invoke()).getDeclaredMembers();
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getDeclaredMembers$annotations(KClass r10) {
    }

    public static final KType getDefaultType(final KClass<?> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        SimpleType r11 = ((KClassImpl) r10).getDescriptor().getDefaultType();
        Intrinsics.checkNotNullExpressionValue(r11, "this as KClassImpl<*>).descriptor.defaultType");
        return new KTypeImpl(r11, new KClasses$defaultType$1(r10));
    }

    @Deprecated(message = "This function creates a type which rarely makes sense for generic classes. For example, such type can only be used in signatures of members of that class. Use starProjectedType or createType() for clearer semantics.")
    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getDefaultType$annotations(KClass r10) {
    }

    public static final Collection<KFunction<?>> getFunctions(KClass<?> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Collection<KCallable<?>> r11 = r10.getMembers();
        ArrayList r12 = new ArrayList();
        Iterator<T> r13 = r11.iterator();
    L4:
        if (r13.hasNext() == false) goto L8;
        Object r14 = r13.next();
        if ((r14 instanceof KFunction) == false) goto L4;
        r12.add(r14);
        goto L4
    L8:
        return r12;
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getFunctions$annotations(KClass r10) {
    }

    public static final Collection<KFunction<?>> getMemberExtensionFunctions(KClass<?> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Collection<KCallableImpl<?>> r11 = ((KClassImpl.Data) ((KClassImpl) r10).getData().invoke()).getAllNonStaticMembers();
        ArrayList r12 = new ArrayList();
        Iterator<T> r13 = r11.iterator();
    L4:
        if (r13.hasNext() == false) goto L13;
        Object r14 = r13.next();
        KCallableImpl r15 = (KCallableImpl) r14;
        if (isExtension(r15) == true) goto L8;
    L10:
        boolean r16 = false;
    L11:
        if (r16 == false) goto L4;
        r12.add(r14);
        goto L4
    L8:
        if ((r15 instanceof KFunction) == false) goto L10;
        r16 = true;
        goto L11
    L13:
        return r12;
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getMemberExtensionFunctions$annotations(KClass r10) {
    }

    public static final <T> Collection<KProperty2<T, ?, ?>> getMemberExtensionProperties(KClass<T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Collection<KCallableImpl<?>> r11 = ((KClassImpl) r10).getData().invoke().getAllNonStaticMembers();
        ArrayList r12 = new ArrayList();
        Iterator<T> r13 = r11.iterator();
    L4:
        if (r13.hasNext() == false) goto L13;
        T r14 = r13.next();
        KCallableImpl r15 = (KCallableImpl) r14;
        if (isExtension(r15) == true) goto L8;
    L10:
        boolean r16 = false;
    L11:
        if (r16 == false) goto L4;
        r12.add(r14);
        goto L4
    L8:
        if ((r15 instanceof KProperty2) == false) goto L10;
        r16 = true;
        goto L11
    L13:
        return r12;
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getMemberExtensionProperties$annotations(KClass r10) {
    }

    public static final Collection<KFunction<?>> getMemberFunctions(KClass<?> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Collection<KCallableImpl<?>> r11 = ((KClassImpl.Data) ((KClassImpl) r10).getData().invoke()).getAllNonStaticMembers();
        ArrayList r12 = new ArrayList();
        Iterator<T> r13 = r11.iterator();
    L4:
        if (r13.hasNext() == false) goto L13;
        Object r14 = r13.next();
        KCallableImpl r15 = (KCallableImpl) r14;
        if (isNotExtension(r15) == true) goto L8;
    L10:
        boolean r16 = false;
    L11:
        if (r16 == false) goto L4;
        r12.add(r14);
        goto L4
    L8:
        if ((r15 instanceof KFunction) == false) goto L10;
        r16 = true;
        goto L11
    L13:
        return r12;
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getMemberFunctions$annotations(KClass r10) {
    }

    public static final <T> Collection<KProperty1<T, ?>> getMemberProperties(KClass<T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Collection<KCallableImpl<?>> r11 = ((KClassImpl) r10).getData().invoke().getAllNonStaticMembers();
        ArrayList r12 = new ArrayList();
        Iterator<T> r13 = r11.iterator();
    L4:
        if (r13.hasNext() == false) goto L13;
        T r14 = r13.next();
        KCallableImpl r15 = (KCallableImpl) r14;
        if (isNotExtension(r15) == true) goto L8;
    L10:
        boolean r16 = false;
    L11:
        if (r16 == false) goto L4;
        r12.add(r14);
        goto L4
    L8:
        if ((r15 instanceof KProperty1) == false) goto L10;
        r16 = true;
        goto L11
    L13:
        return r12;
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getMemberProperties$annotations(KClass r10) {
    }

    public static final <T> KFunction<T> getPrimaryConstructor(KClass<T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Iterator<T> r11 = ((KClassImpl) r10).getConstructors().iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        T r12 = r11.next();
        KFunction r13 = (KFunction) r12;
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KFunctionImpl");
        FunctionDescriptor r14 = ((KFunctionImpl) r13).getDescriptor();
        Intrinsics.checkNotNull(r14, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ConstructorDescriptor");
        if (((ConstructorDescriptor) r14).isPrimary() == false) goto L4;
    L10:
        return (KFunction) r12;
    L8:
        r12 = null;
        goto L10
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getPrimaryConstructor$annotations(KClass r10) {
    }

    public static final Collection<KFunction<?>> getStaticFunctions(KClass<?> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Collection<KCallableImpl<?>> r11 = ((KClassImpl.Data) ((KClassImpl) r10).getData().invoke()).getAllStaticMembers();
        ArrayList r12 = new ArrayList();
        Iterator<T> r13 = r11.iterator();
    L4:
        if (r13.hasNext() == false) goto L8;
        Object r14 = r13.next();
        if ((r14 instanceof KFunction) == false) goto L4;
        r12.add(r14);
        goto L4
    L8:
        return r12;
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getStaticFunctions$annotations(KClass r10) {
    }

    public static final Collection<KProperty0<?>> getStaticProperties(KClass<?> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Collection<KCallableImpl<?>> r11 = ((KClassImpl.Data) ((KClassImpl) r10).getData().invoke()).getAllStaticMembers();
        ArrayList r12 = new ArrayList();
        Iterator<T> r13 = r11.iterator();
    L4:
        if (r13.hasNext() == false) goto L13;
        Object r14 = r13.next();
        KCallableImpl r15 = (KCallableImpl) r14;
        if (isNotExtension(r15) == true) goto L8;
    L10:
        boolean r16 = false;
    L11:
        if (r16 == false) goto L4;
        r12.add(r14);
        goto L4
    L8:
        if ((r15 instanceof KProperty0) == false) goto L10;
        r16 = true;
        goto L11
    L13:
        return r12;
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getStaticProperties$annotations(KClass r10) {
    }

    public static final List<KClass<?>> getSuperclasses(KClass<?> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        List<KType> r11 = r10.getSupertypes();
        ArrayList r12 = new ArrayList();
        Iterator<T> r13 = r11.iterator();
    L4:
        if (r13.hasNext() == false) goto L11;
        KClassifier r14 = ((KType) r13.next()).getClassifier();
        if ((r14 instanceof KClass) == false) goto L8;
        KClass r15 = (KClass) r14;
    L9:
        if (r15 == null) goto L4;
        r12.add(r15);
        goto L4
    L8:
        r15 = null;
        goto L9
    L11:
        return r12;
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getSuperclasses$annotations(KClass r10) {
    }

    private static final boolean isExtension(KCallableImpl<?> r10) {
        if (r10.getDescriptor().getExtensionReceiverParameter() == null) goto L5;
        return true;
    L5:
        return false;
    }

    private static final boolean isNotExtension(KCallableImpl<?> r10) {
        return !isExtension(r10);
    }

    @SinceKotlin(version = "1.1")
    public static final boolean isSubclassOf(KClass<?> r10, final KClass<?> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "base");
        if (Intrinsics.areEqual(r10, r11) == true) goto L8;
        List r12 = CollectionsKt.listOf(r10);
        final AnonymousClass1 r13 = AnonymousClass1.INSTANCE;
        Boolean r14 = DFS.ifAny(r12, new KClasses$sam$org_jetbrains_kotlin_utils_DFS_Neighbors$0(r13), new AnonymousClass2(r11));
        Intrinsics.checkNotNullExpressionValue(r14, "base: KClass<*>): Boolea…erclasses) { it == base }");
        if (r14.booleanValue() == true) goto L8;
        return false;
    L8:
        return true;
    }

    @SinceKotlin(version = "1.1")
    public static final boolean isSuperclassOf(KClass<?> r10, KClass<?> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "derived");
        return isSubclassOf(r11, r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.1")
    public static final <T> T safeCast(KClass<T> r10, Object r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.isInstance(r11) == false) goto L5;
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type T of kotlin.reflect.full.KClasses.safeCast");
        return r11;
    L5:
        return null;
    }
}
