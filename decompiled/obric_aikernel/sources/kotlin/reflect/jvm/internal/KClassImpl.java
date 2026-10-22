package kotlin.reflect.jvm.internal;

import com.bytedance.crash.tracker.ActivityLifecycle;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.reflect.KCallable;
import kotlin.reflect.KClass;
import kotlin.reflect.KFunction;
import kotlin.reflect.KProperty;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectKotlinClass;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoBufUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes3.dex */
public final class KClassImpl<T> extends KDeclarationContainerImpl implements KClass<T>, KClassifierImpl, KTypeParameterOwnerImpl {
    private final ReflectProperties.LazyVal<KClassImpl<T>.Data> data;
    private final Class<T> jClass;

    public final class Data extends KDeclarationContainerImpl.Data {
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
        private final ReflectProperties.LazyVal objectInstance$delegate;
        private final ReflectProperties.LazySoftVal qualifiedName$delegate;
        private final ReflectProperties.LazySoftVal sealedSubclasses$delegate;
        private final ReflectProperties.LazySoftVal simpleName$delegate;
        private final ReflectProperties.LazySoftVal supertypes$delegate;
        final /* synthetic */ KClassImpl<T> this$0;
        private final ReflectProperties.LazySoftVal typeParameters$delegate;

        static {
            $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "annotations", "getAnnotations()Ljava/util/List;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "simpleName", "getSimpleName()Ljava/lang/String;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "qualifiedName", "getQualifiedName()Ljava/lang/String;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "constructors", "getConstructors()Ljava/util/Collection;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "nestedClasses", "getNestedClasses()Ljava/util/Collection;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "objectInstance", "getObjectInstance()Ljava/lang/Object;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "typeParameters", "getTypeParameters()Ljava/util/List;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "supertypes", "getSupertypes()Ljava/util/List;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "sealedSubclasses", "getSealedSubclasses()Ljava/util/List;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "declaredNonStaticMembers", "getDeclaredNonStaticMembers()Ljava/util/Collection;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "declaredStaticMembers", "getDeclaredStaticMembers()Ljava/util/Collection;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "inheritedNonStaticMembers", "getInheritedNonStaticMembers()Ljava/util/Collection;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "inheritedStaticMembers", "getInheritedStaticMembers()Ljava/util/Collection;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "allNonStaticMembers", "getAllNonStaticMembers()Ljava/util/Collection;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "allStaticMembers", "getAllStaticMembers()Ljava/util/Collection;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "declaredMembers", "getDeclaredMembers()Ljava/util/Collection;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "allMembers", "getAllMembers()Ljava/util/Collection;"))};
        }

        public Data(final KClassImpl r10) {
            this.this$0 = r10;
            super(r10);
            this.descriptor$delegate = ReflectProperties.lazySoft(new KClassImpl$Data$descriptor$2(r10));
            this.annotations$delegate = ReflectProperties.lazySoft(new KClassImpl$Data$annotations$2(this));
            this.simpleName$delegate = ReflectProperties.lazySoft(new KClassImpl$Data$simpleName$2(r10, this));
            this.qualifiedName$delegate = ReflectProperties.lazySoft(new KClassImpl$Data$qualifiedName$2(r10));
            this.constructors$delegate = ReflectProperties.lazySoft(new KClassImpl$Data$constructors$2(r10));
            this.nestedClasses$delegate = ReflectProperties.lazySoft(new KClassImpl$Data$nestedClasses$2(this));
            this.objectInstance$delegate = ReflectProperties.lazy(new KClassImpl$Data$objectInstance$2(this, r10));
            this.typeParameters$delegate = ReflectProperties.lazySoft(new KClassImpl$Data$typeParameters$2(this, r10));
            this.supertypes$delegate = ReflectProperties.lazySoft(new KClassImpl$Data$supertypes$2(this, r10));
            this.sealedSubclasses$delegate = ReflectProperties.lazySoft(new KClassImpl$Data$sealedSubclasses$2(this));
            this.declaredNonStaticMembers$delegate = ReflectProperties.lazySoft(new KClassImpl$Data$declaredNonStaticMembers$2(r10));
            this.declaredStaticMembers$delegate = ReflectProperties.lazySoft(new KClassImpl$Data$declaredStaticMembers$2(r10));
            this.inheritedNonStaticMembers$delegate = ReflectProperties.lazySoft(new KClassImpl$Data$inheritedNonStaticMembers$2(r10));
            this.inheritedStaticMembers$delegate = ReflectProperties.lazySoft(new KClassImpl$Data$inheritedStaticMembers$2(r10));
            this.allNonStaticMembers$delegate = ReflectProperties.lazySoft(new KClassImpl$Data$allNonStaticMembers$2(this));
            this.allStaticMembers$delegate = ReflectProperties.lazySoft(new KClassImpl$Data$allStaticMembers$2(this));
            this.declaredMembers$delegate = ReflectProperties.lazySoft(new KClassImpl$Data$declaredMembers$2(this));
            this.allMembers$delegate = ReflectProperties.lazySoft(new KClassImpl$Data$allMembers$2(this));
        }

        public static final /* synthetic */ String access$calculateLocalClassName(Data r10, Class r11) {
            return r10.calculateLocalClassName(r11);
        }

        public static final /* synthetic */ Collection access$getDeclaredStaticMembers(Data r10) {
            return r10.getDeclaredStaticMembers();
        }

        public static final /* synthetic */ Collection access$getInheritedNonStaticMembers(Data r10) {
            return r10.getInheritedNonStaticMembers();
        }

        public static final /* synthetic */ Collection access$getInheritedStaticMembers(Data r10) {
            return r10.getInheritedStaticMembers();
        }

        private final String calculateLocalClassName(Class<?> r10) {
            String r11 = r10.getSimpleName();
            Method r12 = r10.getEnclosingMethod();
            if (r12 == null) goto L7;
            Intrinsics.checkNotNullExpressionValue(r11, ActivityLifecycle.NAME);
            String r13 = r12.getName() + Typography.dollar;
        L6:
            return StringsKt.substringAfter$default(r11, r13, null, 2, null);
        L7:
            Constructor<?> r14 = r10.getEnclosingConstructor();
            Intrinsics.checkNotNullExpressionValue(r11, ActivityLifecycle.NAME);
            if (r14 == null) goto L11;
            r13 = r14.getName() + Typography.dollar;
            goto L6
        L11:
            return StringsKt.substringAfter$default(r11, Typography.dollar, null, 2, null);
        }

        private final Collection<KCallableImpl<?>> getDeclaredStaticMembers() {
            T r10 = this.declaredStaticMembers$delegate.getValue(this, $$delegatedProperties[11]);
            Intrinsics.checkNotNullExpressionValue(r10, "<get-declaredStaticMembers>(...)");
            return (Collection) r10;
        }

        private final Collection<KCallableImpl<?>> getInheritedNonStaticMembers() {
            T r10 = this.inheritedNonStaticMembers$delegate.getValue(this, $$delegatedProperties[12]);
            Intrinsics.checkNotNullExpressionValue(r10, "<get-inheritedNonStaticMembers>(...)");
            return (Collection) r10;
        }

        private final Collection<KCallableImpl<?>> getInheritedStaticMembers() {
            T r10 = this.inheritedStaticMembers$delegate.getValue(this, $$delegatedProperties[13]);
            Intrinsics.checkNotNullExpressionValue(r10, "<get-inheritedStaticMembers>(...)");
            return (Collection) r10;
        }

        public final Collection<KCallableImpl<?>> getAllMembers() {
            T r10 = this.allMembers$delegate.getValue(this, $$delegatedProperties[17]);
            Intrinsics.checkNotNullExpressionValue(r10, "<get-allMembers>(...)");
            return (Collection) r10;
        }

        public final Collection<KCallableImpl<?>> getAllNonStaticMembers() {
            T r10 = this.allNonStaticMembers$delegate.getValue(this, $$delegatedProperties[14]);
            Intrinsics.checkNotNullExpressionValue(r10, "<get-allNonStaticMembers>(...)");
            return (Collection) r10;
        }

        public final Collection<KCallableImpl<?>> getAllStaticMembers() {
            T r10 = this.allStaticMembers$delegate.getValue(this, $$delegatedProperties[15]);
            Intrinsics.checkNotNullExpressionValue(r10, "<get-allStaticMembers>(...)");
            return (Collection) r10;
        }

        public final List<Annotation> getAnnotations() {
            T r10 = this.annotations$delegate.getValue(this, $$delegatedProperties[1]);
            Intrinsics.checkNotNullExpressionValue(r10, "<get-annotations>(...)");
            return (List) r10;
        }

        public final Collection<KFunction<T>> getConstructors() {
            T r10 = this.constructors$delegate.getValue(this, $$delegatedProperties[4]);
            Intrinsics.checkNotNullExpressionValue(r10, "<get-constructors>(...)");
            return (Collection) r10;
        }

        public final Collection<KCallableImpl<?>> getDeclaredMembers() {
            T r10 = this.declaredMembers$delegate.getValue(this, $$delegatedProperties[16]);
            Intrinsics.checkNotNullExpressionValue(r10, "<get-declaredMembers>(...)");
            return (Collection) r10;
        }

        public final Collection<KCallableImpl<?>> getDeclaredNonStaticMembers() {
            T r10 = this.declaredNonStaticMembers$delegate.getValue(this, $$delegatedProperties[10]);
            Intrinsics.checkNotNullExpressionValue(r10, "<get-declaredNonStaticMembers>(...)");
            return (Collection) r10;
        }

        public final ClassDescriptor getDescriptor() {
            T r10 = this.descriptor$delegate.getValue(this, $$delegatedProperties[0]);
            Intrinsics.checkNotNullExpressionValue(r10, "<get-descriptor>(...)");
            return (ClassDescriptor) r10;
        }

        public final Collection<KClass<?>> getNestedClasses() {
            T r10 = this.nestedClasses$delegate.getValue(this, $$delegatedProperties[5]);
            Intrinsics.checkNotNullExpressionValue(r10, "<get-nestedClasses>(...)");
            return (Collection) r10;
        }

        public final T getObjectInstance() {
            return this.objectInstance$delegate.getValue(this, $$delegatedProperties[6]);
        }

        public final String getQualifiedName() {
            return (String) this.qualifiedName$delegate.getValue(this, $$delegatedProperties[3]);
        }

        public final List<KClass<? extends T>> getSealedSubclasses() {
            T r10 = this.sealedSubclasses$delegate.getValue(this, $$delegatedProperties[9]);
            Intrinsics.checkNotNullExpressionValue(r10, "<get-sealedSubclasses>(...)");
            return (List) r10;
        }

        public final String getSimpleName() {
            return (String) this.simpleName$delegate.getValue(this, $$delegatedProperties[2]);
        }

        public final List<KType> getSupertypes() {
            T r10 = this.supertypes$delegate.getValue(this, $$delegatedProperties[8]);
            Intrinsics.checkNotNullExpressionValue(r10, "<get-supertypes>(...)");
            return (List) r10;
        }

        public final List<KTypeParameter> getTypeParameters() {
            T r10 = this.typeParameters$delegate.getValue(this, $$delegatedProperties[7]);
            Intrinsics.checkNotNullExpressionValue(r10, "<get-typeParameters>(...)");
            return (List) r10;
        }
    }

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r10 = new int[KotlinClassHeader.Kind.values().length];
            r10[KotlinClassHeader.Kind.FILE_FACADE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L19:
            r10[KotlinClassHeader.Kind.MULTIFILE_CLASS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L27:
            r10[KotlinClassHeader.Kind.MULTIFILE_CLASS_PART.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L21:
            r10[KotlinClassHeader.Kind.SYNTHETIC_CLASS.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L23:
            r10[KotlinClassHeader.Kind.UNKNOWN.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L17:
            r10[KotlinClassHeader.Kind.CLASS.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L9:
            $EnumSwitchMapping$0 = r10;
        }
    }

    public KClassImpl(Class<T> r10) {
        Intrinsics.checkNotNullParameter(r10, "jClass");
        this.jClass = r10;
        ReflectProperties.LazyVal<KClassImpl<T>.Data> r11 = ReflectProperties.lazy(new KClassImpl$data$1(this));
        Intrinsics.checkNotNullExpressionValue(r11, "lazy { Data() }");
        this.data = r11;
    }

    public static final /* synthetic */ ClassId access$getClassId(KClassImpl r10) {
        return r10.getClassId();
    }

    public static final /* synthetic */ Void access$reportUnresolvedClass(KClassImpl r10) {
        return r10.reportUnresolvedClass();
    }

    private final ClassId getClassId() {
        return RuntimeTypeMapper.INSTANCE.mapJvmClassToKotlinClassId(getJClass());
    }

    private final Void reportUnresolvedClass() {
        ReflectKotlinClass r10 = ReflectKotlinClass.Factory.create(getJClass());
        if (r10 == null) goto L7;
        KotlinClassHeader r11 = r10.getClassHeader();
        if (r11 == null) goto L7;
        KotlinClassHeader.Kind r12 = r11.getKind();
    L8:
        if (r12 != null) goto L10;
        int r13 = -1;
    L11:
        switch(r13) {
            case -1: goto L21;
            case 0: goto L13;
            case 1: goto L19;
            case 2: goto L19;
            case 3: goto L19;
            case 4: goto L17;
            case 5: goto L15;
            case 6: goto L21;
            default: goto L13;
        };
    L13:
        throw new NoWhenBranchMatchedException();
    L15:
        throw new KotlinReflectionInternalError("Unknown class: " + getJClass() + " (kind = " + r12 + ')');
    L17:
        throw new UnsupportedOperationException("This class is an internal synthetic class generated by the Kotlin compiler, such as an anonymous class for a lambda, a SAM wrapper, a callable reference, etc. It's not a Kotlin class or interface, so the reflection library has no idea what declarations it has. Please use Java reflection to inspect this class: " + getJClass());
    L19:
        throw new UnsupportedOperationException("Packages and file facades are not yet supported in Kotlin reflection. Meanwhile please use Java reflection to inspect this class: " + getJClass());
    L21:
        throw new KotlinReflectionInternalError("Unresolved class: " + getJClass());
    L10:
        r13 = WhenMappings.$EnumSwitchMapping$0[r12.ordinal()];
    L7:
        r12 = null;
        goto L8
    }

    @Override // kotlin.reflect.KClass
    public boolean equals(Object r10) {
        if ((r10 instanceof KClassImpl) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(JvmClassMappingKt.getJavaObjectType(this), JvmClassMappingKt.getJavaObjectType((KClass) r10)) == false) goto L7;
        return true;
    }

    @Override // kotlin.reflect.KAnnotatedElement
    public List<Annotation> getAnnotations() {
        return this.data.invoke().getAnnotations();
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    public Collection<ConstructorDescriptor> getConstructorDescriptors() {
        ClassDescriptor r10 = getDescriptor();
        if (r10.getKind() == ClassKind.INTERFACE) goto L10;
        if (r10.getKind() == ClassKind.OBJECT) goto L10;
        Collection<ClassConstructorDescriptor> r11 = r10.getConstructors();
        Intrinsics.checkNotNullExpressionValue(r11, "descriptor.constructors");
        return r11;
    L10:
        return CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.KClass
    public Collection<KFunction<T>> getConstructors() {
        return this.data.invoke().getConstructors();
    }

    public final ReflectProperties.LazyVal<KClassImpl<T>.Data> getData() {
        return this.data;
    }

    @Override // kotlin.reflect.jvm.internal.KClassifierImpl
    public ClassDescriptor getDescriptor() {
        return this.data.invoke().getDescriptor();
    }

    @Override // kotlin.reflect.jvm.internal.KClassifierImpl
    public /* bridge */ /* synthetic */ ClassifierDescriptor getDescriptor() {
        return getDescriptor();
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    public Collection<FunctionDescriptor> getFunctions(Name r10) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        MemberScope r11 = getMemberScope$kotlin_reflection();
        NoLookupLocation r12 = NoLookupLocation.FROM_REFLECTION;
        return CollectionsKt.plus(r11.getContributedFunctions(r10, r12), getStaticScope$kotlin_reflection().getContributedFunctions(r10, r12));
    }

    @Override // kotlin.jvm.internal.ClassBasedDeclarationContainer
    public Class<T> getJClass() {
        return this.jClass;
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    public PropertyDescriptor getLocalProperty(int r10) {
        if (Intrinsics.areEqual(getJClass().getSimpleName(), "DefaultImpls") == false) goto L10;
        Class<?> r11 = getJClass().getDeclaringClass();
        if (r11 == null) goto L10;
        if (r11.isInterface() == false) goto L10;
        KClass r12 = JvmClassMappingKt.getKotlinClass(r11);
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KClassImpl<*>");
        return ((KClassImpl) r12).getLocalProperty(r10);
    L10:
        ClassDescriptor r13 = getDescriptor();
        if ((r13 instanceof DeserializedClassDescriptor) == false) goto L13;
        DeserializedClassDescriptor r14 = (DeserializedClassDescriptor) r13;
    L14:
        if (r14 == null) goto L19;
        ProtoBuf.Class r15 = r14.getClassProto();
        GeneratedMessageLite.GeneratedExtension<ProtoBuf.Class, List<ProtoBuf.Property>> r16 = JvmProtoBuf.classLocalVariable;
        Intrinsics.checkNotNullExpressionValue(r16, "classLocalVariable");
        ProtoBuf.Property r17 = (ProtoBuf.Property) ProtoBufUtilKt.getExtensionOrNull(r15, r16, r10);
        if (r17 != null) goto L18;
        return null;
    L18:
        return (PropertyDescriptor) UtilKt.deserializeToDescriptor(getJClass(), r17, r14.getC().getNameResolver(), r14.getC().getTypeTable(), r14.getMetadataVersion(), KClassImpl$getLocalProperty$2$1$1.INSTANCE);
    L19:
        return null;
    L13:
        r14 = null;
        goto L14
    }

    public final MemberScope getMemberScope$kotlin_reflection() {
        return getDescriptor().getDefaultType().getMemberScope();
    }

    @Override // kotlin.reflect.KDeclarationContainer
    public Collection<KCallable<?>> getMembers() {
        return this.data.invoke().getAllMembers();
    }

    @Override // kotlin.reflect.KClass
    public Collection<KClass<?>> getNestedClasses() {
        return this.data.invoke().getNestedClasses();
    }

    @Override // kotlin.reflect.KClass
    public T getObjectInstance() {
        return this.data.invoke().getObjectInstance();
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    public Collection<PropertyDescriptor> getProperties(Name r10) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        MemberScope r11 = getMemberScope$kotlin_reflection();
        NoLookupLocation r12 = NoLookupLocation.FROM_REFLECTION;
        return CollectionsKt.plus(r11.getContributedVariables(r10, r12), getStaticScope$kotlin_reflection().getContributedVariables(r10, r12));
    }

    @Override // kotlin.reflect.KClass
    public String getQualifiedName() {
        return this.data.invoke().getQualifiedName();
    }

    @Override // kotlin.reflect.KClass
    public List<KClass<? extends T>> getSealedSubclasses() {
        return this.data.invoke().getSealedSubclasses();
    }

    @Override // kotlin.reflect.KClass
    public String getSimpleName() {
        return this.data.invoke().getSimpleName();
    }

    public final MemberScope getStaticScope$kotlin_reflection() {
        MemberScope r10 = getDescriptor().getStaticScope();
        Intrinsics.checkNotNullExpressionValue(r10, "descriptor.staticScope");
        return r10;
    }

    @Override // kotlin.reflect.KClass
    public List<KType> getSupertypes() {
        return this.data.invoke().getSupertypes();
    }

    @Override // kotlin.reflect.KClass
    public List<KTypeParameter> getTypeParameters() {
        return this.data.invoke().getTypeParameters();
    }

    @Override // kotlin.reflect.KClass
    public KVisibility getVisibility() {
        DescriptorVisibility r10 = getDescriptor().getVisibility();
        Intrinsics.checkNotNullExpressionValue(r10, "descriptor.visibility");
        return UtilKt.toKVisibility(r10);
    }

    @Override // kotlin.reflect.KClass
    public int hashCode() {
        return JvmClassMappingKt.getJavaObjectType(this).hashCode();
    }

    @Override // kotlin.reflect.KClass
    public boolean isAbstract() {
        if (getDescriptor().getModality() != Modality.ABSTRACT) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // kotlin.reflect.KClass
    public boolean isCompanion() {
        return getDescriptor().isCompanionObject();
    }

    @Override // kotlin.reflect.KClass
    public boolean isData() {
        return getDescriptor().isData();
    }

    @Override // kotlin.reflect.KClass
    public boolean isFinal() {
        if (getDescriptor().getModality() != Modality.FINAL) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // kotlin.reflect.KClass
    public boolean isFun() {
        return getDescriptor().isFun();
    }

    @Override // kotlin.reflect.KClass
    public boolean isInner() {
        return getDescriptor().isInner();
    }

    @Override // kotlin.reflect.KClass
    public boolean isInstance(Object r10) {
        Integer r11 = ReflectClassUtilKt.getFunctionClassArity(getJClass());
        if (r11 != null) goto L5;
        Class r12 = ReflectClassUtilKt.getWrapperByPrimitive(getJClass());
        if (r12 != null) goto L10;
        r12 = getJClass();
    L10:
        return r12.isInstance(r10);
    L5:
        return TypeIntrinsics.isFunctionOfArity(r10, r11.intValue());
    }

    @Override // kotlin.reflect.KClass
    public boolean isOpen() {
        if (getDescriptor().getModality() != Modality.OPEN) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // kotlin.reflect.KClass
    public boolean isSealed() {
        if (getDescriptor().getModality() != Modality.SEALED) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // kotlin.reflect.KClass
    public boolean isValue() {
        return getDescriptor().isValue();
    }

    public String toString() {
        StringBuilder r10 = new StringBuilder();
        r10.append("class ");
        ClassId r11 = getClassId();
        FqName r12 = r11.getPackageFqName();
        Intrinsics.checkNotNullExpressionValue(r12, "classId.packageFqName");
        if (r12.isRoot() == false) goto L5;
        String r13 = "";
    L6:
        String r14 = r11.getRelativeClassName().asString();
        Intrinsics.checkNotNullExpressionValue(r14, "classId.relativeClassName.asString()");
        r10.append(r13 + StringsKt.replace$default(r14, '.', Typography.dollar, false, 4, null));
        return r10.toString();
    L5:
        r13 = r12.asString() + '.';
        goto L6
    }
}
