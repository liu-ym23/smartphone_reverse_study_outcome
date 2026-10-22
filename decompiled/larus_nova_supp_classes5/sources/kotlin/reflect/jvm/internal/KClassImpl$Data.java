package kotlin.reflect.jvm.internal;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KFunction;
import kotlin.reflect.KProperty;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.jvm.internal.impl.builtins.CompanionObjectMapping;
import kotlin.reflect.jvm.internal.impl.builtins.CompanionObjectMappingUtilsKt;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.RuntimeModuleData;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0018\b\u0086\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\u0019\u001a\u00020\u00122\n\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u001bH\u0002R\u001b\u0010\u0005\u001a\u00020\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR!\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0011\u001a\u0004\u0018\u00010\u00128FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\n\u001a\u0004\b\u0013\u0010\u0014R\u001d\u0010\u0016\u001a\u0004\u0018\u00010\u00128FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\n\u001a\u0004\b\u0017\u0010\u0014R-\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001e0\u001d8FX\u0086\u0084\u0002¢\u0006\u0012\n\u0004\b#\u0010\n\u0012\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R%\u0010$\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030%0\u001d8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\n\u001a\u0004\b&\u0010\"R#\u0010(\u001a\u0004\u0018\u00018\u00008FX\u0086\u0084\u0002¢\u0006\u0012\n\u0004\b,\u0010-\u0012\u0004\b)\u0010 \u001a\u0004\b*\u0010+R!\u0010.\u001a\b\u0012\u0004\u0012\u00020/0\f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b1\u0010\n\u001a\u0004\b0\u0010\u000fR!\u00102\u001a\b\u0012\u0004\u0012\u0002030\f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b5\u0010\n\u001a\u0004\b4\u0010\u000fR)\u00106\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000%0\f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b8\u0010\n\u001a\u0004\b7\u0010\u000fR%\u00109\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030:0\u001d8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b<\u0010\n\u001a\u0004\b;\u0010\"R%\u0010=\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030:0\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b?\u0010\n\u001a\u0004\b>\u0010\"R%\u0010@\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030:0\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bB\u0010\n\u001a\u0004\bA\u0010\"R%\u0010C\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030:0\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bE\u0010\n\u001a\u0004\bD\u0010\"R%\u0010F\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030:0\u001d8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bH\u0010\n\u001a\u0004\bG\u0010\"R%\u0010I\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030:0\u001d8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bK\u0010\n\u001a\u0004\bJ\u0010\"R%\u0010L\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030:0\u001d8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bN\u0010\n\u001a\u0004\bM\u0010\"R%\u0010O\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030:0\u001d8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bQ\u0010\n\u001a\u0004\bP\u0010\"¨\u0006R"}, d2 = {"Lkotlin/reflect/jvm/internal/KClassImpl$Data;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$Data;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "<init>", "(Lkotlin/reflect/jvm/internal/KClassImpl;)V", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", "descriptor$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "annotations$delegate", "simpleName", "", "getSimpleName", "()Ljava/lang/String;", "simpleName$delegate", "qualifiedName", "getQualifiedName", "qualifiedName$delegate", "calculateLocalClassName", "jClass", "Ljava/lang/Class;", "constructors", "", "Lkotlin/reflect/KFunction;", "getConstructors$annotations", "()V", "getConstructors", "()Ljava/util/Collection;", "constructors$delegate", "nestedClasses", "Lkotlin/reflect/KClass;", "getNestedClasses", "nestedClasses$delegate", "objectInstance", "getObjectInstance$annotations", "getObjectInstance", "()Ljava/lang/Object;", "objectInstance$delegate", "Lkotlin/Lazy;", "typeParameters", "Lkotlin/reflect/KTypeParameter;", "getTypeParameters", "typeParameters$delegate", "supertypes", "Lkotlin/reflect/KType;", "getSupertypes", "supertypes$delegate", "sealedSubclasses", "getSealedSubclasses", "sealedSubclasses$delegate", "declaredNonStaticMembers", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "getDeclaredNonStaticMembers", "declaredNonStaticMembers$delegate", "declaredStaticMembers", "getDeclaredStaticMembers", "declaredStaticMembers$delegate", "inheritedNonStaticMembers", "getInheritedNonStaticMembers", "inheritedNonStaticMembers$delegate", "inheritedStaticMembers", "getInheritedStaticMembers", "inheritedStaticMembers$delegate", "allNonStaticMembers", "getAllNonStaticMembers", "allNonStaticMembers$delegate", "allStaticMembers", "getAllStaticMembers", "allStaticMembers$delegate", "declaredMembers", "getDeclaredMembers", "declaredMembers$delegate", "allMembers", "getAllMembers", "allMembers$delegate", "kotlin-reflection"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class KClassImpl$Data extends KDeclarationContainerImpl$Data {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = null;
    private final ReflectProperties.LazySoftVal allMembers$delegate;
    private final ReflectProperties.LazySoftVal allNonStaticMembers$delegate;
    private final ReflectProperties.LazySoftVal allStaticMembers$delegate;
    private final ReflectProperties.LazySoftVal annotations$delegate;
    private final ReflectProperties.LazySoftVal constructors$delegate;
    private final ReflectProperties.LazySoftVal declaredMembers$delegate;
    private final ReflectProperties.LazySoftVal declaredNonStaticMembers$delegate;
    private final ReflectProperties.LazySoftVal declaredStaticMembers$delegate;
    private final ReflectProperties.LazySoftVal descriptor$delegate;
    private final ReflectProperties.LazySoftVal inheritedNonStaticMembers$delegate;
    private final ReflectProperties.LazySoftVal inheritedStaticMembers$delegate;
    private final ReflectProperties.LazySoftVal nestedClasses$delegate;
    private final Lazy objectInstance$delegate;
    private final ReflectProperties.LazySoftVal qualifiedName$delegate;
    private final ReflectProperties.LazySoftVal sealedSubclasses$delegate;
    private final ReflectProperties.LazySoftVal simpleName$delegate;
    private final ReflectProperties.LazySoftVal supertypes$delegate;
    final /* synthetic */ KClassImpl<T> this$0;
    private final ReflectProperties.LazySoftVal typeParameters$delegate;

    public static /* synthetic */ ClassDescriptor accessor$KClassImpl$Data$lambda0(KClassImpl r0) {
        return descriptor_delegate$lambda$0(r0);
    }

    public static /* synthetic */ List accessor$KClassImpl$Data$lambda1(KClassImpl$Data r0) {
        return annotations_delegate$lambda$1(r0);
    }

    public static /* synthetic */ Collection accessor$KClassImpl$Data$lambda10(KClassImpl r0) {
        return declaredNonStaticMembers_delegate$lambda$22(r0);
    }

    public static /* synthetic */ Collection accessor$KClassImpl$Data$lambda11(KClassImpl r0) {
        return declaredStaticMembers_delegate$lambda$23(r0);
    }

    public static /* synthetic */ Collection accessor$KClassImpl$Data$lambda12(KClassImpl r0) {
        return inheritedNonStaticMembers_delegate$lambda$24(r0);
    }

    public static /* synthetic */ Collection accessor$KClassImpl$Data$lambda13(KClassImpl r0) {
        return inheritedStaticMembers_delegate$lambda$25(r0);
    }

    public static /* synthetic */ List accessor$KClassImpl$Data$lambda14(KClassImpl$Data r0) {
        return allNonStaticMembers_delegate$lambda$26(r0);
    }

    public static /* synthetic */ List accessor$KClassImpl$Data$lambda15(KClassImpl$Data r0) {
        return allStaticMembers_delegate$lambda$27(r0);
    }

    public static /* synthetic */ List accessor$KClassImpl$Data$lambda16(KClassImpl$Data r0) {
        return declaredMembers_delegate$lambda$28(r0);
    }

    public static /* synthetic */ List accessor$KClassImpl$Data$lambda17(KClassImpl$Data r0) {
        return allMembers_delegate$lambda$29(r0);
    }

    public static /* synthetic */ Type accessor$KClassImpl$Data$lambda18(KotlinType r0, KClassImpl$Data r1, KClassImpl r2) {
        return supertypes_delegate$lambda$18$lambda$15$lambda$14(r0, r1, r2);
    }

    public static /* synthetic */ Type accessor$KClassImpl$Data$lambda19() {
        return supertypes_delegate$lambda$18$lambda$17();
    }

    public static /* synthetic */ String accessor$KClassImpl$Data$lambda2(KClassImpl r0, KClassImpl$Data r1) {
        return simpleName_delegate$lambda$2(r0, r1);
    }

    public static /* synthetic */ String accessor$KClassImpl$Data$lambda3(KClassImpl r0) {
        return qualifiedName_delegate$lambda$3(r0);
    }

    public static /* synthetic */ List accessor$KClassImpl$Data$lambda4(KClassImpl r0) {
        return constructors_delegate$lambda$7(r0);
    }

    public static /* synthetic */ List accessor$KClassImpl$Data$lambda5(KClassImpl$Data r0) {
        return nestedClasses_delegate$lambda$10(r0);
    }

    public static /* synthetic */ Object accessor$KClassImpl$Data$lambda6(KClassImpl$Data r0, KClassImpl r1) {
        return objectInstance_delegate$lambda$11(r0, r1);
    }

    public static /* synthetic */ List accessor$KClassImpl$Data$lambda7(KClassImpl$Data r0, KClassImpl r1) {
        return typeParameters_delegate$lambda$13(r0, r1);
    }

    public static /* synthetic */ List accessor$KClassImpl$Data$lambda8(KClassImpl$Data r0, KClassImpl r1) {
        return supertypes_delegate$lambda$18(r0, r1);
    }

    public static /* synthetic */ List accessor$KClassImpl$Data$lambda9(KClassImpl$Data r0) {
        return sealedSubclasses_delegate$lambda$21(r0);
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(KClassImpl$Data.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(KClassImpl$Data.class), "annotations", "getAnnotations()Ljava/util/List;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(KClassImpl$Data.class), "simpleName", "getSimpleName()Ljava/lang/String;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(KClassImpl$Data.class), "qualifiedName", "getQualifiedName()Ljava/lang/String;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(KClassImpl$Data.class), "constructors", "getConstructors()Ljava/util/Collection;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(KClassImpl$Data.class), "nestedClasses", "getNestedClasses()Ljava/util/Collection;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(KClassImpl$Data.class), "typeParameters", "getTypeParameters()Ljava/util/List;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(KClassImpl$Data.class), "supertypes", "getSupertypes()Ljava/util/List;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(KClassImpl$Data.class), "sealedSubclasses", "getSealedSubclasses()Ljava/util/List;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(KClassImpl$Data.class), "declaredNonStaticMembers", "getDeclaredNonStaticMembers()Ljava/util/Collection;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(KClassImpl$Data.class), "declaredStaticMembers", "getDeclaredStaticMembers()Ljava/util/Collection;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(KClassImpl$Data.class), "inheritedNonStaticMembers", "getInheritedNonStaticMembers()Ljava/util/Collection;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(KClassImpl$Data.class), "inheritedStaticMembers", "getInheritedStaticMembers()Ljava/util/Collection;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(KClassImpl$Data.class), "allNonStaticMembers", "getAllNonStaticMembers()Ljava/util/Collection;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(KClassImpl$Data.class), "allStaticMembers", "getAllStaticMembers()Ljava/util/Collection;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(KClassImpl$Data.class), "declaredMembers", "getDeclaredMembers()Ljava/util/Collection;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(KClassImpl$Data.class), "allMembers", "getAllMembers()Ljava/util/Collection;"))};
    }

    private final Collection<KCallableImpl<?>> getDeclaredStaticMembers() {
        return (Collection) this.declaredStaticMembers$delegate.getValue(this, $$delegatedProperties[10]);
    }

    private final Collection<KCallableImpl<?>> getInheritedNonStaticMembers() {
        return (Collection) this.inheritedNonStaticMembers$delegate.getValue(this, $$delegatedProperties[11]);
    }

    private final Collection<KCallableImpl<?>> getInheritedStaticMembers() {
        return (Collection) this.inheritedStaticMembers$delegate.getValue(this, $$delegatedProperties[12]);
    }

    public final Collection<KCallableImpl<?>> getAllMembers() {
        return (Collection) this.allMembers$delegate.getValue(this, $$delegatedProperties[16]);
    }

    public final Collection<KCallableImpl<?>> getAllNonStaticMembers() {
        return (Collection) this.allNonStaticMembers$delegate.getValue(this, $$delegatedProperties[13]);
    }

    public final Collection<KCallableImpl<?>> getAllStaticMembers() {
        return (Collection) this.allStaticMembers$delegate.getValue(this, $$delegatedProperties[14]);
    }

    public final List<Annotation> getAnnotations() {
        return (List) this.annotations$delegate.getValue(this, $$delegatedProperties[1]);
    }

    public final Collection<KFunction<T>> getConstructors() {
        return (Collection) this.constructors$delegate.getValue(this, $$delegatedProperties[4]);
    }

    public final Collection<KCallableImpl<?>> getDeclaredMembers() {
        return (Collection) this.declaredMembers$delegate.getValue(this, $$delegatedProperties[15]);
    }

    public final Collection<KCallableImpl<?>> getDeclaredNonStaticMembers() {
        return (Collection) this.declaredNonStaticMembers$delegate.getValue(this, $$delegatedProperties[9]);
    }

    public final ClassDescriptor getDescriptor() {
        return (ClassDescriptor) this.descriptor$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final Collection<KClass<?>> getNestedClasses() {
        return (Collection) this.nestedClasses$delegate.getValue(this, $$delegatedProperties[5]);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [T, java.lang.Object] */
    public final T getObjectInstance() {
        return this.objectInstance$delegate.getValue();
    }

    public final String getQualifiedName() {
        return (String) this.qualifiedName$delegate.getValue(this, $$delegatedProperties[3]);
    }

    public final List<KClass<? extends T>> getSealedSubclasses() {
        return (List) this.sealedSubclasses$delegate.getValue(this, $$delegatedProperties[8]);
    }

    public final String getSimpleName() {
        return (String) this.simpleName$delegate.getValue(this, $$delegatedProperties[2]);
    }

    public final List<KType> getSupertypes() {
        return (List) this.supertypes$delegate.getValue(this, $$delegatedProperties[7]);
    }

    public final List<KTypeParameter> getTypeParameters() {
        return (List) this.typeParameters$delegate.getValue(this, $$delegatedProperties[6]);
    }

    private static final Type supertypes_delegate$lambda$18$lambda$17() {
        return Object.class;
    }

    public KClassImpl$Data(final KClassImpl r3) {
        this.this$0 = r3;
        super(r3);
        this.descriptor$delegate = ReflectProperties.lazySoft(new KClassImpl$Data$$Lambda$0(r3));
        this.annotations$delegate = ReflectProperties.lazySoft(new KClassImpl$Data$$Lambda$1(this));
        this.simpleName$delegate = ReflectProperties.lazySoft(new KClassImpl$Data$$Lambda$2(r3, this));
        this.qualifiedName$delegate = ReflectProperties.lazySoft(new KClassImpl$Data$$Lambda$3(r3));
        this.constructors$delegate = ReflectProperties.lazySoft(new KClassImpl$Data$$Lambda$4(r3));
        this.nestedClasses$delegate = ReflectProperties.lazySoft(new KClassImpl$Data$$Lambda$5(this));
        this.objectInstance$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new KClassImpl$Data$$Lambda$6(this, r3));
        this.typeParameters$delegate = ReflectProperties.lazySoft(new KClassImpl$Data$$Lambda$7(this, r3));
        this.supertypes$delegate = ReflectProperties.lazySoft(new KClassImpl$Data$$Lambda$8(this, r3));
        this.sealedSubclasses$delegate = ReflectProperties.lazySoft(new KClassImpl$Data$$Lambda$9(this));
        this.declaredNonStaticMembers$delegate = ReflectProperties.lazySoft(new KClassImpl$Data$$Lambda$10(r3));
        this.declaredStaticMembers$delegate = ReflectProperties.lazySoft(new KClassImpl$Data$$Lambda$11(r3));
        this.inheritedNonStaticMembers$delegate = ReflectProperties.lazySoft(new KClassImpl$Data$$Lambda$12(r3));
        this.inheritedStaticMembers$delegate = ReflectProperties.lazySoft(new KClassImpl$Data$$Lambda$13(r3));
        this.allNonStaticMembers$delegate = ReflectProperties.lazySoft(new KClassImpl$Data$$Lambda$14(this));
        this.allStaticMembers$delegate = ReflectProperties.lazySoft(new KClassImpl$Data$$Lambda$15(this));
        this.declaredMembers$delegate = ReflectProperties.lazySoft(new KClassImpl$Data$$Lambda$16(this));
        this.allMembers$delegate = ReflectProperties.lazySoft(new KClassImpl$Data$$Lambda$17(this));
    }

    private static final List allMembers_delegate$lambda$29(KClassImpl$Data r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        return CollectionsKt.plus(r1.getAllNonStaticMembers(), r1.getAllStaticMembers());
    }

    private static final List allNonStaticMembers_delegate$lambda$26(KClassImpl$Data r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        return CollectionsKt.plus(r1.getDeclaredNonStaticMembers(), r1.getInheritedNonStaticMembers());
    }

    private static final List allStaticMembers_delegate$lambda$27(KClassImpl$Data r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        return CollectionsKt.plus(r1.getDeclaredStaticMembers(), r1.getInheritedStaticMembers());
    }

    private static final List annotations_delegate$lambda$1(KClassImpl$Data r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        return UtilKt.computeAnnotations(r1.getDescriptor());
    }

    private final String calculateLocalClassName(Class<?> r6) {
        String r0 = r6.getSimpleName();
        Method r1 = r6.getEnclosingMethod();
        if (r1 == null) goto L6;
        Intrinsics.checkNotNull(r0);
        return StringsKt.substringAfter$default(r0, r1.getName() + '$', null, 2, null);
    L6:
        Constructor<?> r7 = r6.getEnclosingConstructor();
        if (r7 == null) goto L10;
        Intrinsics.checkNotNull(r0);
        return StringsKt.substringAfter$default(r0, r7.getName() + '$', null, 2, null);
    L10:
        Intrinsics.checkNotNull(r0);
        return StringsKt.substringAfter$default(r0, '$', null, 2, null);
    }

    private static final List constructors_delegate$lambda$7(KClassImpl r4) {
        Intrinsics.checkNotNullParameter(r4, "this$0");
        Collection r0 = r4.getConstructorDescriptors();
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r1.add(new KFunctionImpl(r4, (ConstructorDescriptor) r2.next()));
        goto L4
    L6:
        return r1;
    }

    private static final List declaredMembers_delegate$lambda$28(KClassImpl$Data r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        return CollectionsKt.plus(r1.getDeclaredNonStaticMembers(), r1.getDeclaredStaticMembers());
    }

    private static final Collection declaredNonStaticMembers_delegate$lambda$22(KClassImpl r2) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        return r2.getMembers(r2.getMemberScope$kotlin_reflection(), KDeclarationContainerImpl.MemberBelonginess.DECLARED);
    }

    private static final Collection declaredStaticMembers_delegate$lambda$23(KClassImpl r2) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        return r2.getMembers(r2.getStaticScope$kotlin_reflection(), KDeclarationContainerImpl.MemberBelonginess.DECLARED);
    }

    private static final ClassDescriptor descriptor_delegate$lambda$0(KClassImpl r5) {
        Intrinsics.checkNotNullParameter(r5, "this$0");
        ClassId r0 = KClassImpl.access$getClassId(r5);
        RuntimeModuleData r1 = ((KClassImpl$Data) r5.getData().getValue()).getModuleData();
        ModuleDescriptor r2 = r1.getModule();
        if (r0.isLocal() == true) goto L5;
    L7:
        ClassDescriptor r3 = FindClassInModuleKt.findClassAcrossModuleDependencies(r2, r0);
    L8:
        if (r3 == null) goto L10;
        return r3;
    L10:
        return KClassImpl.access$createSyntheticClassOrFail(r5, r0, r1);
    L5:
        if (r5.getJClass().isAnnotationPresent(Metadata.class) == false) goto L7;
        r3 = r1.getDeserialization().deserializeClass(r0);
        goto L8
    }

    private static final Collection inheritedNonStaticMembers_delegate$lambda$24(KClassImpl r2) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        return r2.getMembers(r2.getMemberScope$kotlin_reflection(), KDeclarationContainerImpl.MemberBelonginess.INHERITED);
    }

    private static final Collection inheritedStaticMembers_delegate$lambda$25(KClassImpl r2) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        return r2.getMembers(r2.getStaticScope$kotlin_reflection(), KDeclarationContainerImpl.MemberBelonginess.INHERITED);
    }

    private static final List nestedClasses_delegate$lambda$10(KClassImpl$Data r4) {
        Intrinsics.checkNotNullParameter(r4, "this$0");
        Collection r5 = ResolutionScope.DefaultImpls.getContributedDescriptors$default(r4.getDescriptor().getUnsubstitutedInnerClassesScope(), null, null, 3, null);
        ArrayList r0 = new ArrayList();
        Iterator r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L8;
        Object r2 = r6.next();
        if (DescriptorUtils.isEnumEntry((DeclarationDescriptor) r2) == true) goto L4;
        r0.add(r2);
        goto L4
    L8:
        ArrayList r7 = new ArrayList();
        Iterator r1 = r0.iterator();
    L10:
        if (r1.hasNext() == false) goto L23;
        DeclarationDescriptor r3 = (DeclarationDescriptor) r1.next();
        if ((r3 instanceof ClassDescriptor) == false) goto L14;
        ClassDescriptor r8 = (ClassDescriptor) r3;
    L15:
        if (r8 == null) goto L17;
        Class<?> r9 = UtilKt.toJavaClass(r8);
    L18:
        if (r9 == null) goto L20;
        KClassImpl r10 = new KClassImpl(r9);
    L21:
        if (r10 == null) goto L10;
        r7.add(r10);
        goto L10
    L20:
        r10 = null;
        goto L21
    L17:
        r9 = null;
        goto L18
    L14:
        r8 = null;
        goto L15
    L23:
        return r7;
    }

    private static final String qualifiedName_delegate$lambda$3(KClassImpl r2) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        if (r2.getJClass().isAnonymousClass() == false) goto L5;
        return null;
    L5:
        ClassId r3 = KClassImpl.access$getClassId(r2);
        if (r3.isLocal() == false) goto L9;
        return null;
    L9:
        return r3.asSingleFqName().asString();
    }

    private static final List sealedSubclasses_delegate$lambda$21(KClassImpl$Data r3) {
        Intrinsics.checkNotNullParameter(r3, "this$0");
        Collection<ClassDescriptor> r4 = r3.getDescriptor().getSealedSubclasses();
        ArrayList r0 = new ArrayList();
        Iterator<T> r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L11;
        ClassDescriptor r1 = (ClassDescriptor) r5.next();
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        Class<?> r2 = UtilKt.toJavaClass(r1);
        if (r2 == null) goto L8;
        KClassImpl r6 = new KClassImpl(r2);
    L9:
        if (r6 == null) goto L4;
        r0.add(r6);
        goto L4
    L8:
        r6 = null;
        goto L9
    L11:
        return r0;
    }

    private static final Object objectInstance_delegate$lambda$11(KClassImpl$Data r3, KClassImpl r4) {
        Intrinsics.checkNotNullParameter(r3, "this$0");
        Intrinsics.checkNotNullParameter(r4, "this$1");
        ClassDescriptor r5 = r3.getDescriptor();
        if (r5.getKind() == ClassKind.OBJECT) goto L6;
        return null;
    L6:
        if (r5.isCompanionObject() == true) goto L8;
    L10:
        Field r6 = r4.getJClass().getDeclaredField("INSTANCE");
    L11:
        Object r7 = r6.get(null);
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type T of kotlin.reflect.jvm.internal.KClassImpl.Data.objectInstance_delegate$lambda$11");
        return r7;
    L8:
        if (CompanionObjectMappingUtilsKt.isMappedIntrinsicCompanionObject(CompanionObjectMapping.INSTANCE, r5) == true) goto L10;
        r6 = r4.getJClass().getEnclosingClass().getDeclaredField(r5.getName().asString());
        goto L11
    }

    private static final String simpleName_delegate$lambda$2(KClassImpl r2, KClassImpl$Data r3) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        Intrinsics.checkNotNullParameter(r3, "this$1");
        if (r2.getJClass().isAnonymousClass() == false) goto L6;
        return null;
    L6:
        ClassId r0 = KClassImpl.access$getClassId(r2);
        if (r0.isLocal() == false) goto L10;
        return r3.calculateLocalClassName(r2.getJClass());
    L10:
        return r0.getShortClassName().asString();
    }

    private static final List supertypes_delegate$lambda$18(KClassImpl$Data r5, KClassImpl r6) {
        Intrinsics.checkNotNullParameter(r5, "this$0");
        Intrinsics.checkNotNullParameter(r6, "this$1");
        Collection<KotlinType> r0 = r5.getDescriptor().getTypeConstructor().getSupertypes();
        ArrayList r1 = new ArrayList(r0.size());
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L7;
        KotlinType r3 = (KotlinType) r2.next();
        Intrinsics.checkNotNull(r3);
        r1.add(new KTypeImpl(r3, new KClassImpl$Data$.Lambda.18(r3, r5, r6)));
        goto L4
    L7:
        if (KotlinBuiltIns.isSpecialClassWithNoSupertypes(r5.getDescriptor()) == true) goto L26;
        boolean r4 = true;
        if (r1.isEmpty() == true) goto L23;
        Iterator r7 = r1.iterator();
    L13:
        if (r7.hasNext() == false) goto L23;
        ClassKind r8 = DescriptorUtils.getClassDescriptorForType(((KTypeImpl) r7.next()).getType()).getKind();
        if (r8 != ClassKind.INTERFACE) goto L17;
    L20:
        boolean r9 = true;
    L21:
        if (r9 == true) goto L13;
        r4 = false;
        goto L23
    L17:
        if (r8 == ClassKind.ANNOTATION_CLASS) goto L20;
        r9 = false;
    L23:
        if (r4 == false) goto L26;
        r1.add(new KTypeImpl(DescriptorUtilsKt.getBuiltIns(r5.getDescriptor()).getAnyType(), KClassImpl$Data$.Lambda.19.INSTANCE));
    L26:
        return kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.compact(r1);
    }

    private static final List typeParameters_delegate$lambda$13(KClassImpl$Data r3, KClassImpl r4) {
        Intrinsics.checkNotNullParameter(r3, "this$0");
        Intrinsics.checkNotNullParameter(r4, "this$1");
        List<TypeParameterDescriptor> r5 = r3.getDescriptor().getDeclaredTypeParameters();
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator<T> r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        TypeParameterDescriptor r1 = (TypeParameterDescriptor) r6.next();
        Intrinsics.checkNotNull(r1);
        r0.add(new KTypeParameterImpl(r4, r1));
        goto L4
    L6:
        return r0;
    }

    private static final Type supertypes_delegate$lambda$18$lambda$15$lambda$14(KotlinType r2, KClassImpl$Data r3, KClassImpl r4) {
        Intrinsics.checkNotNullParameter(r3, "this$0");
        Intrinsics.checkNotNullParameter(r4, "this$1");
        ClassifierDescriptor r5 = r2.getConstructor().getDeclarationDescriptor();
        if ((r5 instanceof ClassDescriptor) == false) goto L18;
        Class<?> r0 = UtilKt.toJavaClass((ClassDescriptor) r5);
        if (r0 == null) goto L16;
        if (Intrinsics.areEqual(r4.getJClass().getSuperclass(), r0) == false) goto L9;
        Type r6 = r4.getJClass().getGenericSuperclass();
        Intrinsics.checkNotNull(r6);
        return r6;
    L9:
        int r1 = ArraysKt.indexOf(r4.getJClass().getInterfaces(), r0);
        if (r1 < 0) goto L14;
        Type r7 = r4.getJClass().getGenericInterfaces()[r1];
        Intrinsics.checkNotNull(r7);
        return r7;
    L14:
        throw new KotlinReflectionInternalError("No superclass of " + r3 + " in Java reflection for " + r5);
    L16:
        throw new KotlinReflectionInternalError("Unsupported superclass of " + r3 + ": " + r5);
    L18:
        throw new KotlinReflectionInternalError("Supertype not a class: " + r5);
    }
}
