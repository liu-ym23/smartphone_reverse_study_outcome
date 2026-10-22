package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.MappingUtilKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.ScopesHolderForClass;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueClassRepresentation;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorBase;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.FakePureImplementationsProvider;
import kotlin.reflect.jvm.internal.impl.load.java.JavaDescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames;
import kotlin.reflect.jvm.internal.impl.load.java.UtilsKt;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaResolverCache;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.ContextKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotationsKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributes;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributesKt;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNamesUtilKt;
import kotlin.reflect.jvm.internal.impl.resolve.constants.StringValue;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.InnerClassesScopeWrapper;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.types.AbstractClassTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeUsage;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* JADX INFO: loaded from: classes3.dex */
public final class LazyJavaClassDescriptor extends ClassDescriptorBase implements JavaClassDescriptor {
    public static final Companion Companion = null;
    private static final Set<String> PUBLIC_METHOD_NAMES_IN_OBJECT = null;
    private final ClassDescriptor additionalSupertypeClassDescriptor;
    private final Annotations annotations;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final LazyJavaResolverContext f10211c;
    private final NotNullLazyValue<List<TypeParameterDescriptor>> declaredParameters;
    private final InnerClassesScopeWrapper innerClassesScope;
    private final boolean isInner;
    private final JavaClass jClass;
    private final ClassKind kind;
    private final Modality modality;
    private final Lazy moduleAnnotations$delegate;
    private final LazyJavaResolverContext outerContext;
    private final ScopesHolderForClass<LazyJavaClassMemberScope> scopeHolder;
    private final LazyJavaStaticClassScope staticScope;
    private final LazyJavaClassTypeConstructor typeConstructor;
    private final LazyJavaClassMemberScope unsubstitutedMemberScope;
    private final Visibility visibility;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }
    }

    private final class LazyJavaClassTypeConstructor extends AbstractClassTypeConstructor {
        private final NotNullLazyValue<List<TypeParameterDescriptor>> parameters;
        final /* synthetic */ LazyJavaClassDescriptor this$0;

        public LazyJavaClassTypeConstructor(final LazyJavaClassDescriptor r10) {
            this.this$0 = r10;
            super(LazyJavaClassDescriptor.access$getC$p(r10).getStorageManager());
            this.parameters = LazyJavaClassDescriptor.access$getC$p(r10).getStorageManager().createLazyValue(new LazyJavaClassDescriptor$LazyJavaClassTypeConstructor$parameters$1(r10));
        }

        private final KotlinType getPurelyImplementedSupertype() {
            FqName r10 = getPurelyImplementsFqNameFromAnnotation();
            if (r10 != null) goto L5;
        L12:
            r10 = null;
        L13:
            if (r10 != null) goto L17;
            FqName r11 = FakePureImplementationsProvider.INSTANCE.getPurelyImplementedInterface(DescriptorUtilsKt.getFqNameSafe(this.this$0));
            if (r11 != null) goto L18;
            return null;
        L18:
            ClassDescriptor r12 = DescriptorUtilsKt.resolveTopLevelClass(LazyJavaClassDescriptor.access$getC$p(this.this$0).getModule(), r11, NoLookupLocation.FROM_JAVA_LOADER);
            if (r12 != null) goto L21;
            return null;
        L21:
            int r13 = r12.getTypeConstructor().getParameters().size();
            List<TypeParameterDescriptor> r14 = this.this$0.getTypeConstructor().getParameters();
            Intrinsics.checkNotNullExpressionValue(r14, "getTypeConstructor().parameters");
            int r15 = r14.size();
            if (r15 != r13) goto L27;
            ArrayList r16 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10));
            Iterator<T> r17 = r14.iterator();
        L25:
            if (r17.hasNext() == false) goto L36;
            r16.add(new TypeProjectionImpl(Variance.INVARIANT, ((TypeParameterDescriptor) r17.next()).getDefaultType()));
        L36:
            return KotlinTypeFactory.simpleNotNullType(TypeAttributes.Companion.getEmpty(), r12, r16);
        L27:
            if (r15 != 1) goto L37;
            if (r13 <= 1) goto L37;
            if (r10 != null) goto L37;
            TypeProjectionImpl r18 = new TypeProjectionImpl(Variance.INVARIANT, ((TypeParameterDescriptor) CollectionsKt.single(r14)).getDefaultType());
            IntRange r19 = new IntRange(1, r13);
            ArrayList r20 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r19, 10));
            Iterator<Integer> r21 = r19.iterator();
        L32:
            if (r21.hasNext() == false) goto L34;
            ((IntIterator) r21).nextInt();
            r20.add(r18);
            goto L32
        L34:
            r16 = r20;
        L37:
            return null;
        L17:
            r11 = r10;
            goto L18
        L5:
            if (r10.isRoot() == false) goto L7;
        L9:
            boolean r22 = false;
        L10:
            if (r22 == false) goto L12;
        L7:
            if (r10.startsWith(StandardNames.BUILT_INS_PACKAGE_NAME) == false) goto L9;
            r22 = true;
            goto L10
        }

        private final FqName getPurelyImplementsFqNameFromAnnotation() {
            Annotations r10 = this.this$0.getAnnotations();
            FqName r11 = JvmAnnotationNames.PURELY_IMPLEMENTS_ANNOTATION;
            Intrinsics.checkNotNullExpressionValue(r11, "PURELY_IMPLEMENTS_ANNOTATION");
            AnnotationDescriptor r12 = r10.mo1318findAnnotation(r11);
            if (r12 != null) goto L5;
            return null;
        L5:
            Object r13 = CollectionsKt.singleOrNull(r12.getAllValueArguments().values());
            if ((r13 instanceof StringValue) == false) goto L8;
            StringValue r14 = (StringValue) r13;
        L9:
            if (r14 == null) goto L18;
            String r15 = r14.getValue();
            if (r15 != null) goto L14;
            return null;
        L14:
            if (FqNamesUtilKt.isValidJavaFqName(r15) == true) goto L17;
            return null;
        L17:
            return new FqName(r15);
        L18:
            return null;
        L8:
            r14 = null;
            goto L9
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor
        protected Collection<KotlinType> computeSupertypes() {
            Collection<JavaClassifierType> r10 = this.this$0.getJClass().getSupertypes();
            ArrayList r11 = new ArrayList(r10.size());
            ArrayList r12 = new ArrayList(0);
            KotlinType r13 = getPurelyImplementedSupertype();
            Iterator<JavaClassifierType> r14 = r10.iterator();
        L3:
            Object r15 = null;
            if (r14.hasNext() == false) goto L17;
            JavaClassifierType r16 = r14.next();
            KotlinType r17 = LazyJavaClassDescriptor.access$getC$p(this.this$0).getComponents().getSignatureEnhancement().enhanceSuperType(LazyJavaClassDescriptor.access$getC$p(this.this$0).getTypeResolver().transformJavaType(r16, JavaTypeAttributesKt.toAttributes$default(TypeUsage.SUPERTYPE, false, false, null, 7, null)), LazyJavaClassDescriptor.access$getC$p(this.this$0));
            if ((r17.getConstructor().mo1323getDeclarationDescriptor() instanceof NotFoundClasses.MockClassDescriptor) == false) goto L8;
            r12.add(r16);
        L8:
            TypeConstructor r18 = r17.getConstructor();
            if (r13 == null) goto L12;
            r15 = r13.getConstructor();
        L12:
            if (Intrinsics.areEqual(r18, r15) == true) goto L3;
            if (KotlinBuiltIns.isAnyOrNullableAny(r17) == true) goto L3;
            r11.add(r17);
            goto L3
        L17:
            ClassDescriptor r19 = LazyJavaClassDescriptor.access$getAdditionalSupertypeClassDescriptor$p(this.this$0);
            if (r19 == null) goto L20;
            r15 = MappingUtilKt.createMappedTypeParametersSubstitution(r19, this.this$0).buildSubstitutor().substitute(r19.getDefaultType(), Variance.INVARIANT);
        L20:
            kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull(r11, r15);
            kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull(r11, r13);
            if ((!r12.isEmpty()) == false) goto L28;
            ErrorReporter r20 = LazyJavaClassDescriptor.access$getC$p(this.this$0).getComponents().getErrorReporter();
            ClassDescriptor r21 = mo1323getDeclarationDescriptor();
            ArrayList r22 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10));
            Iterator r23 = r12.iterator();
        L24:
            if (r23.hasNext() == false) goto L26;
            JavaType r24 = (JavaType) r23.next();
            Intrinsics.checkNotNull(r24, "null cannot be cast to non-null type org.jetbrains.kotlin.load.java.structure.JavaClassifierType");
            r22.add(((JavaClassifierType) r24).getPresentableText());
            goto L24
        L26:
            r20.reportIncompleteHierarchy(r21, r22);
        L28:
            if ((!r11.isEmpty()) == false) goto L31;
            return CollectionsKt.toList(r11);
        L31:
            return CollectionsKt.listOf(LazyJavaClassDescriptor.access$getC$p(this.this$0).getModule().getBuiltIns().getAnyType());
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractClassTypeConstructor, kotlin.reflect.jvm.internal.impl.types.ClassifierBasedTypeConstructor, kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        /* JADX INFO: renamed from: getDeclarationDescriptor */
        public ClassDescriptor mo1323getDeclarationDescriptor() {
            return this.this$0;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractClassTypeConstructor, kotlin.reflect.jvm.internal.impl.types.ClassifierBasedTypeConstructor, kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        /* JADX INFO: renamed from: getDeclarationDescriptor */
        public /* bridge */ /* synthetic */ ClassifierDescriptor mo1323getDeclarationDescriptor() {
            return mo1323getDeclarationDescriptor();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        public List<TypeParameterDescriptor> getParameters() {
            return this.parameters.invoke();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor
        protected SupertypeLoopChecker getSupertypeLoopChecker() {
            return LazyJavaClassDescriptor.access$getC$p(this.this$0).getComponents().getSupertypeLoopChecker();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        public boolean isDenotable() {
            return true;
        }

        public String toString() {
            String r10 = this.this$0.getName().asString();
            Intrinsics.checkNotNullExpressionValue(r10, "name.asString()");
            return r10;
        }
    }

    static {
        Companion = new Companion(null);
        PUBLIC_METHOD_NAMES_IN_OBJECT = SetsKt.setOf(new String[]{"equals", "hashCode", "getClass", "wait", "notify", "notifyAll", "toString"});
    }

    public LazyJavaClassDescriptor(LazyJavaResolverContext r13, DeclarationDescriptor r14, JavaClass r15, ClassDescriptor r16) {
        Intrinsics.checkNotNullParameter(r13, "outerContext");
        Intrinsics.checkNotNullParameter(r14, "containingDeclaration");
        Intrinsics.checkNotNullParameter(r15, "jClass");
        super(r13.getStorageManager(), r14, r15.getName(), r13.getComponents().getSourceElementFactory().source(r15), false);
        this.outerContext = r13;
        this.jClass = r15;
        this.additionalSupertypeClassDescriptor = r16;
        LazyJavaResolverContext r10 = ContextKt.childForClassOrPackage$default(r13, this, r15, 0, 4, null);
        this.f10211c = r10;
        r10.getComponents().getJavaResolverCache().recordClass(r15, this);
        r15.getLightClassOriginKind();
        this.moduleAnnotations$delegate = LazyKt.lazy(new LazyJavaClassDescriptor$moduleAnnotations$2(this));
        if (r15.isAnnotationType() == false) goto L6;
        ClassKind r11 = ClassKind.ANNOTATION_CLASS;
    L12:
        this.kind = r11;
        if (r15.isAnnotationType() == false) goto L15;
    L27:
        Modality r12 = Modality.FINAL;
    L28:
        this.modality = r12;
        this.visibility = r15.getVisibility();
        if (r15.getOuterClass() != null) goto L31;
    L33:
        boolean r17 = false;
    L34:
        this.isInner = r17;
        this.typeConstructor = new LazyJavaClassTypeConstructor(this);
        if (r16 == null) goto L37;
        boolean r18 = true;
    L38:
        LazyJavaClassMemberScope r19 = new LazyJavaClassMemberScope(r10, this, r15, r18, null, 16, null);
        this.unsubstitutedMemberScope = r19;
        this.scopeHolder = ScopesHolderForClass.Companion.create(this, r10.getStorageManager(), r10.getComponents().getKotlinTypeChecker().getKotlinTypeRefiner(), new LazyJavaClassDescriptor$scopeHolder$1(this));
        this.innerClassesScope = new InnerClassesScopeWrapper(r19);
        this.staticScope = new LazyJavaStaticClassScope(r10, r15, this);
        this.annotations = LazyJavaAnnotationsKt.resolveAnnotations(r10, r15);
        this.declaredParameters = r10.getStorageManager().createLazyValue(new LazyJavaClassDescriptor$declaredParameters$1(this));
        return;
    L37:
        r18 = false;
        goto L38
    L31:
        if (r15.isStatic() == true) goto L33;
        r17 = true;
        goto L34
    L15:
        if (r15.isEnum() == true) goto L27;
        Modality.Companion r20 = Modality.Companion;
        boolean r21 = r15.isSealed();
        if (r15.isSealed() == false) goto L20;
    L25:
        boolean r22 = true;
    L26:
        r12 = r20.convertFromFlags(r21, r22, !r15.isFinal());
        goto L28
    L20:
        if (r15.isAbstract() == true) goto L25;
        if (r15.isInterface() == true) goto L25;
        r22 = false;
        goto L26
    L6:
        if (r15.isInterface() == false) goto L9;
        r11 = ClassKind.INTERFACE;
        goto L12
    L9:
        if (r15.isEnum() == false) goto L11;
        r11 = ClassKind.ENUM_CLASS;
        goto L12
    L11:
        r11 = ClassKind.CLASS;
        goto L12
    }

    public /* synthetic */ LazyJavaClassDescriptor(LazyJavaResolverContext r10, DeclarationDescriptor r11, JavaClass r12, ClassDescriptor r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 8) == 0) goto L5;
        r13 = null;
    L5:
        this(r10, r11, r12, r13);
    }

    public static final /* synthetic */ ClassDescriptor access$getAdditionalSupertypeClassDescriptor$p(LazyJavaClassDescriptor r10) {
        return r10.additionalSupertypeClassDescriptor;
    }

    public static final /* synthetic */ LazyJavaResolverContext access$getC$p(LazyJavaClassDescriptor r10) {
        return r10.f10211c;
    }

    public static final /* synthetic */ LazyJavaClassMemberScope access$getUnsubstitutedMemberScope$p(LazyJavaClassDescriptor r10) {
        return r10.unsubstitutedMemberScope;
    }

    public final LazyJavaClassDescriptor copy$descriptors_jvm(JavaResolverCache r10, ClassDescriptor r11) {
        Intrinsics.checkNotNullParameter(r10, "javaResolverCache");
        LazyJavaResolverContext r12 = this.f10211c;
        LazyJavaResolverContext r13 = ContextKt.replaceComponents(r12, r12.getComponents().replace(r10));
        DeclarationDescriptor r14 = getContainingDeclaration();
        Intrinsics.checkNotNullExpressionValue(r14, "containingDeclaration");
        return new LazyJavaClassDescriptor(r13, r14, this.jClass, r11);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
    public Annotations getAnnotations() {
        return this.annotations;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    /* JADX INFO: renamed from: getCompanionObjectDescriptor */
    public ClassDescriptor mo1316getCompanionObjectDescriptor() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public /* bridge */ /* synthetic */ Collection getConstructors() {
        return getConstructors();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public List<ClassConstructorDescriptor> getConstructors() {
        return this.unsubstitutedMemberScope.getConstructors$descriptors_jvm().invoke();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters
    public List<TypeParameterDescriptor> getDeclaredTypeParameters() {
        return this.declaredParameters.invoke();
    }

    public final JavaClass getJClass() {
        return this.jClass;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public ClassKind getKind() {
        return this.kind;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public Modality getModality() {
        return this.modality;
    }

    public final List<JavaAnnotation> getModuleAnnotations() {
        return (List) this.moduleAnnotations$delegate.getValue();
    }

    public final LazyJavaResolverContext getOuterContext() {
        return this.outerContext;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public Collection<ClassDescriptor> getSealedSubclasses() {
        if (this.modality != Modality.SEALED) goto L15;
        JavaTypeAttributes r10 = JavaTypeAttributesKt.toAttributes$default(TypeUsage.COMMON, false, false, null, 7, null);
        Collection<JavaClassifierType> r11 = this.jClass.getPermittedTypes();
        ArrayList r12 = new ArrayList();
        Iterator<T> r13 = r11.iterator();
    L6:
        if (r13.hasNext() == false) goto L21;
        JavaClassifierType r14 = (JavaClassifierType) r13.next();
        ClassifierDescriptor r15 = this.f10211c.getTypeResolver().transformJavaType(r14, r10).getConstructor().mo1323getDeclarationDescriptor();
        if ((r15 instanceof ClassDescriptor) == false) goto L10;
        ClassDescriptor r16 = (ClassDescriptor) r15;
    L11:
        if (r16 == null) goto L6;
        r12.add(r16);
        goto L6
    L10:
        r16 = null;
        goto L11
    L21:
        return CollectionsKt.sortedWith(r12, new LazyJavaClassDescriptor$getSealedSubclasses$$inlined$sortedBy$1());
    L15:
        return CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public MemberScope getStaticScope() {
        return this.staticScope;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor
    public TypeConstructor getTypeConstructor() {
        return this.typeConstructor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public MemberScope getUnsubstitutedInnerClassesScope() {
        return this.innerClassesScope;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public LazyJavaClassMemberScope getUnsubstitutedMemberScope() {
        MemberScope r10 = super.getUnsubstitutedMemberScope();
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type org.jetbrains.kotlin.load.java.lazy.descriptors.LazyJavaClassMemberScope");
        return (LazyJavaClassMemberScope) r10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleAwareClassDescriptor
    protected LazyJavaClassMemberScope getUnsubstitutedMemberScope(KotlinTypeRefiner r10) {
        Intrinsics.checkNotNullParameter(r10, "kotlinTypeRefiner");
        return (LazyJavaClassMemberScope) this.scopeHolder.getScope(r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public /* bridge */ /* synthetic */ MemberScope getUnsubstitutedMemberScope() {
        return getUnsubstitutedMemberScope();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleAwareClassDescriptor
    public /* bridge */ /* synthetic */ MemberScope getUnsubstitutedMemberScope(KotlinTypeRefiner r10) {
        return getUnsubstitutedMemberScope(r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    /* JADX INFO: renamed from: getUnsubstitutedPrimaryConstructor */
    public ClassConstructorDescriptor mo1317getUnsubstitutedPrimaryConstructor() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public ValueClassRepresentation<SimpleType> getValueClassRepresentation() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public DescriptorVisibility getVisibility() {
        if (Intrinsics.areEqual(this.visibility, DescriptorVisibilities.PRIVATE) == false) goto L8;
        if (this.jClass.getOuterClass() != null) goto L8;
        DescriptorVisibility r10 = JavaDescriptorVisibilities.PACKAGE_VISIBILITY;
        Intrinsics.checkNotNullExpressionValue(r10, "{\n            JavaDescri…KAGE_VISIBILITY\n        }");
        return r10;
    L8:
        return UtilsKt.toDescriptorVisibility(this.visibility);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isActual() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public boolean isCompanionObject() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public boolean isData() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isExpect() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public boolean isFun() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public boolean isInline() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters
    public boolean isInner() {
        return this.isInner;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public boolean isValue() {
        return false;
    }

    public String toString() {
        return "Lazy Java class " + DescriptorUtilsKt.getFqNameUnsafe(this);
    }
}
