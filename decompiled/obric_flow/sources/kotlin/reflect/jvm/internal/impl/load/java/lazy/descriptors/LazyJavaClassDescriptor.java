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
import kotlin.jvm.internal.SourceDebugExtension;
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
@SourceDebugExtension({"SMAP\nLazyJavaClassDescriptor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LazyJavaClassDescriptor.kt\norg/jetbrains/kotlin/load/java/lazy/descriptors/LazyJavaClassDescriptor\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,322:1\n1747#2,3:323\n1747#2,3:326\n1603#2,9:329\n1855#2:338\n1856#2:340\n1612#2:341\n1045#2:342\n1#3:339\n*S KotlinDebug\n*F\n+ 1 LazyJavaClassDescriptor.kt\norg/jetbrains/kotlin/load/java/lazy/descriptors/LazyJavaClassDescriptor\n*L\n185#1:323,3\n188#1:326,3\n200#1:329,9\n200#1:338\n200#1:340\n200#1:341\n202#1:342\n200#1:339\n*E\n"})
public final class LazyJavaClassDescriptor extends ClassDescriptorBase implements JavaClassDescriptor {
    public static final Companion Companion = null;
    private static final Set<String> PUBLIC_METHOD_NAMES_IN_OBJECT = null;
    private final ClassDescriptor additionalSupertypeClassDescriptor;
    private final Annotations annotations;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final LazyJavaResolverContext f18747c;
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
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        private Companion() {
        }
    }

    @SourceDebugExtension({"SMAP\nLazyJavaClassDescriptor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LazyJavaClassDescriptor.kt\norg/jetbrains/kotlin/load/java/lazy/descriptors/LazyJavaClassDescriptor$LazyJavaClassTypeConstructor\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,322:1\n1549#2:323\n1620#2,3:324\n1549#2:327\n1620#2,3:328\n1549#2:331\n1620#2,3:332\n*S KotlinDebug\n*F\n+ 1 LazyJavaClassDescriptor.kt\norg/jetbrains/kotlin/load/java/lazy/descriptors/LazyJavaClassDescriptor$LazyJavaClassTypeConstructor\n*L\n254#1:323\n254#1:324,3\n280#1:327\n280#1:328,3\n285#1:331\n285#1:332,3\n*E\n"})
    public final class LazyJavaClassTypeConstructor extends AbstractClassTypeConstructor {
        private final NotNullLazyValue<List<TypeParameterDescriptor>> parameters;
        final /* synthetic */ LazyJavaClassDescriptor this$0;

        public LazyJavaClassTypeConstructor(final LazyJavaClassDescriptor r5) {
            this.this$0 = r5;
            super(LazyJavaClassDescriptor.access$getC$p(r5).getStorageManager());
            this.parameters = LazyJavaClassDescriptor.access$getC$p(r5).getStorageManager().createLazyValue(new LazyJavaClassDescriptor$LazyJavaClassTypeConstructor$parameters$1(r5));
        }

        private final KotlinType getPurelyImplementedSupertype() {
            FqName r5 = getPurelyImplementsFqNameFromAnnotation();
            if (r5 != null) goto L5;
        L9:
            r5 = null;
        L10:
            if (r5 != null) goto L14;
            FqName r10 = FakePureImplementationsProvider.INSTANCE.getPurelyImplementedInterface(DescriptorUtilsKt.getFqNameSafe(this.this$0));
            if (r10 != null) goto L15;
            return null;
        L15:
            ClassDescriptor r11 = DescriptorUtilsKt.resolveTopLevelClass(LazyJavaClassDescriptor.access$getC$p(this.this$0).getModule(), r10, NoLookupLocation.FROM_JAVA_LOADER);
            if (r11 != null) goto L18;
            return null;
        L18:
            int r12 = r11.getTypeConstructor().getParameters().size();
            List<TypeParameterDescriptor> r13 = this.this$0.getTypeConstructor().getParameters();
            int r14 = r13.size();
            if (r14 != r12) goto L25;
            ArrayList r15 = new ArrayList(CollectionsKt.h(r13));
            Iterator<T> r16 = r13.iterator();
        L22:
            if (r16.hasNext() == false) goto L34;
            r15.add(new TypeProjectionImpl(Variance.INVARIANT, ((TypeParameterDescriptor) r16.next()).getDefaultType()));
        L34:
            return KotlinTypeFactory.simpleNotNullType(TypeAttributes.Companion.getEmpty(), r11, r15);
        L25:
            if (r14 != 1) goto L35;
            if (r12 <= 1) goto L35;
            if (r5 != null) goto L35;
            TypeProjectionImpl r17 = new TypeProjectionImpl(Variance.INVARIANT, ((TypeParameterDescriptor) CollectionsKt.single(r13)).getDefaultType());
            IntRange r18 = new IntRange(1, r12);
            ArrayList r19 = new ArrayList(CollectionsKt.h(r18));
            Iterator<Integer> r20 = r18.iterator();
        L30:
            if (r20.hasNext() == false) goto L32;
            ((IntIterator) r20).nextInt();
            r19.add(r17);
            goto L30
        L32:
            r15 = r19;
        L35:
            return null;
        L14:
            r10 = r5;
            goto L15
        L5:
            if (r5.isRoot() == true) goto L9;
            if (r5.startsWith(StandardNames.BUILT_INS_PACKAGE_NAME) == false) goto L9;
            goto L9
        }

        private final FqName getPurelyImplementsFqNameFromAnnotation() {
            AnnotationDescriptor r5 = this.this$0.getAnnotations().mo1397findAnnotation(JvmAnnotationNames.PURELY_IMPLEMENTS_ANNOTATION);
            if (r5 != null) goto L5;
            return null;
        L5:
            Object r10 = CollectionsKt.singleOrNull(r5.getAllValueArguments().values());
            if ((r10 instanceof StringValue) == false) goto L8;
            StringValue r11 = (StringValue) r10;
        L9:
            if (r11 == null) goto L18;
            String r12 = r11.getValue();
            if (r12 != null) goto L14;
            return null;
        L14:
            if (FqNamesUtilKt.isValidJavaFqName(r12) == true) goto L17;
            return null;
        L17:
            return new FqName(r12);
        L18:
            return null;
        L8:
            r11 = null;
            goto L9
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor
        public Collection<KotlinType> computeSupertypes() {
            Collection<JavaClassifierType> r5 = this.this$0.getJClass().getSupertypes();
            ArrayList r10 = new ArrayList(r5.size());
            ArrayList r11 = new ArrayList(0);
            KotlinType r12 = getPurelyImplementedSupertype();
            Iterator<JavaClassifierType> r13 = r5.iterator();
        L3:
            Object r14 = null;
            if (r13.hasNext() == false) goto L17;
            JavaClassifierType r15 = r13.next();
            KotlinType r16 = LazyJavaClassDescriptor.access$getC$p(this.this$0).getTypeResolver().transformJavaType(r15, JavaTypeAttributesKt.toAttributes$default(TypeUsage.SUPERTYPE, false, false, null, 7, null));
            KotlinType r17 = LazyJavaClassDescriptor.access$getC$p(this.this$0).getComponents().getSignatureEnhancement().enhanceSuperType(r16, LazyJavaClassDescriptor.access$getC$p(this.this$0));
            if ((r17.getConstructor().mo1402getDeclarationDescriptor() instanceof NotFoundClasses.MockClassDescriptor) == false) goto L8;
            r11.add(r15);
        L8:
            TypeConstructor r18 = r17.getConstructor();
            if (r12 == null) goto L12;
            r14 = r12.getConstructor();
        L12:
            if (Intrinsics.areEqual(r18, r14) == true) goto L3;
            if (KotlinBuiltIns.isAnyOrNullableAny(r17) == true) goto L3;
            r10.add(r17);
            goto L3
        L17:
            ClassDescriptor r19 = LazyJavaClassDescriptor.access$getAdditionalSupertypeClassDescriptor$p(this.this$0);
            if (r19 == null) goto L20;
            r14 = MappingUtilKt.createMappedTypeParametersSubstitution(r19, this.this$0).buildSubstitutor().substitute(r19.getDefaultType(), Variance.INVARIANT);
        L20:
            kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull(r10, r14);
            kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull(r10, r12);
            if (r11.isEmpty() == true) goto L28;
            ErrorReporter r20 = LazyJavaClassDescriptor.access$getC$p(this.this$0).getComponents().getErrorReporter();
            ClassDescriptor r21 = mo1402getDeclarationDescriptor();
            ArrayList r22 = new ArrayList(CollectionsKt.h(r11));
            Iterator r23 = r11.iterator();
        L24:
            if (r23.hasNext() == false) goto L26;
            JavaType r24 = (JavaType) r23.next();
            Intrinsics.checkNotNull(r24, "null cannot be cast to non-null type org.jetbrains.kotlin.load.java.structure.JavaClassifierType");
            r22.add(((JavaClassifierType) r24).getPresentableText());
            goto L24
        L26:
            r20.reportIncompleteHierarchy(r21, r22);
        L28:
            if (r10.isEmpty() == true) goto L31;
            return CollectionsKt.toList(r10);
        L31:
            return CollectionsKt.listOf(LazyJavaClassDescriptor.access$getC$p(this.this$0).getModule().getBuiltIns().getAnyType());
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractClassTypeConstructor, kotlin.reflect.jvm.internal.impl.types.ClassifierBasedTypeConstructor, kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        /* JADX INFO: renamed from: getDeclarationDescriptor */
        public /* bridge */ /* synthetic */ ClassifierDescriptor mo1402getDeclarationDescriptor() {
            return mo1402getDeclarationDescriptor();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        public List<TypeParameterDescriptor> getParameters() {
            return this.parameters.invoke();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor
        public SupertypeLoopChecker getSupertypeLoopChecker() {
            return LazyJavaClassDescriptor.access$getC$p(this.this$0).getComponents().getSupertypeLoopChecker();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        public boolean isDenotable() {
            return true;
        }

        public String toString() {
            return this.this$0.getName().asString();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractClassTypeConstructor, kotlin.reflect.jvm.internal.impl.types.ClassifierBasedTypeConstructor, kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        /* JADX INFO: renamed from: getDeclarationDescriptor */
        public ClassDescriptor mo1402getDeclarationDescriptor() {
            return this.this$0;
        }
    }

    static {
        Companion = new Companion(null);
        PUBLIC_METHOD_NAMES_IN_OBJECT = SetsKt.setOf(new String[]{"equals", "hashCode", "getClass", "wait", "notify", "notifyAll", "toString"});
    }

    public /* synthetic */ LazyJavaClassDescriptor(LazyJavaResolverContext r5, DeclarationDescriptor r10, JavaClass r11, ClassDescriptor r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 8) == 0) goto L5;
        r12 = null;
    L5:
        this(r5, r10, r11, r12);
    }

    public static final /* synthetic */ ClassDescriptor access$getAdditionalSupertypeClassDescriptor$p(LazyJavaClassDescriptor r5) {
        return r5.additionalSupertypeClassDescriptor;
    }

    public static final /* synthetic */ LazyJavaResolverContext access$getC$p(LazyJavaClassDescriptor r5) {
        return r5.f18747c;
    }

    public static final /* synthetic */ LazyJavaClassMemberScope access$getUnsubstitutedMemberScope$p(LazyJavaClassDescriptor r5) {
        return r5.unsubstitutedMemberScope;
    }

    public final LazyJavaClassDescriptor copy$descriptors_jvm(JavaResolverCache r5, ClassDescriptor r10) {
        Intrinsics.checkNotNullParameter(r5, "javaResolverCache");
        LazyJavaResolverContext r11 = this.f18747c;
        return new LazyJavaClassDescriptor(ContextKt.replaceComponents(r11, r11.getComponents().replace(r5)), getContainingDeclaration(), this.jClass, r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
    public Annotations getAnnotations() {
        return this.annotations;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    /* JADX INFO: renamed from: getCompanionObjectDescriptor */
    public ClassDescriptor mo1395getCompanionObjectDescriptor() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public /* bridge */ /* synthetic */ Collection getConstructors() {
        return getConstructors();
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
        JavaTypeAttributes r5 = JavaTypeAttributesKt.toAttributes$default(TypeUsage.COMMON, false, false, null, 7, null);
        Collection<JavaClassifierType> r10 = this.jClass.getPermittedTypes();
        ArrayList r11 = new ArrayList();
        Iterator<T> r12 = r10.iterator();
    L6:
        if (r12.hasNext() == false) goto L21;
        JavaClassifierType r13 = (JavaClassifierType) r12.next();
        ClassifierDescriptor r14 = this.f18747c.getTypeResolver().transformJavaType(r13, r5).getConstructor().mo1402getDeclarationDescriptor();
        if ((r14 instanceof ClassDescriptor) == false) goto L10;
        ClassDescriptor r15 = (ClassDescriptor) r14;
    L11:
        if (r15 == null) goto L6;
        r11.add(r15);
        goto L6
    L10:
        r15 = null;
        goto L11
    L21:
        return CollectionsKt.sortedWith(r11, new LazyJavaClassDescriptor$getSealedSubclasses$$inlined$sortedBy$1());
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
    public /* bridge */ /* synthetic */ MemberScope getUnsubstitutedMemberScope() {
        return getUnsubstitutedMemberScope();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    /* JADX INFO: renamed from: getUnsubstitutedPrimaryConstructor */
    public ClassConstructorDescriptor mo1396getUnsubstitutedPrimaryConstructor() {
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
        return JavaDescriptorVisibilities.PACKAGE_VISIBILITY;
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

    public LazyJavaClassDescriptor(LazyJavaResolverContext r13, DeclarationDescriptor r14, JavaClass r15, ClassDescriptor r16) {
        Intrinsics.checkNotNullParameter(r13, "outerContext");
        Intrinsics.checkNotNullParameter(r14, "containingDeclaration");
        Intrinsics.checkNotNullParameter(r15, "jClass");
        super(r13.getStorageManager(), r14, r15.getName(), r13.getComponents().getSourceElementFactory().source(r15), false);
        this.outerContext = r13;
        this.jClass = r15;
        this.additionalSupertypeClassDescriptor = r16;
        LazyJavaResolverContext r10 = ContextKt.childForClassOrPackage$default(r13, this, r15, 0, 4, null);
        this.f18747c = r10;
        r10.getComponents().getJavaResolverCache().recordClass(r15, this);
        r15.getLightClassOriginKind();
        this.moduleAnnotations$delegate = LazyKt.lazy(new LazyJavaClassDescriptor$moduleAnnotations$2(this));
        if (r15.isAnnotationType() == false) goto L6;
        ClassKind r5 = ClassKind.ANNOTATION_CLASS;
    L12:
        this.kind = r5;
        if (r15.isAnnotationType() == false) goto L15;
    L27:
        Modality r11 = Modality.FINAL;
    L28:
        this.modality = r11;
        this.visibility = r15.getVisibility();
        if (r15.getOuterClass() != null) goto L31;
    L33:
        boolean r12 = false;
    L34:
        this.isInner = r12;
        this.typeConstructor = new LazyJavaClassTypeConstructor(this);
        if (r16 == null) goto L37;
        boolean r17 = true;
    L38:
        LazyJavaClassMemberScope r18 = new LazyJavaClassMemberScope(r10, this, r15, r17, null, 16, null);
        this.unsubstitutedMemberScope = r18;
        this.scopeHolder = ScopesHolderForClass.Companion.create(this, r10.getStorageManager(), r10.getComponents().getKotlinTypeChecker().getKotlinTypeRefiner(), new LazyJavaClassDescriptor$scopeHolder$1(this));
        this.innerClassesScope = new InnerClassesScopeWrapper(r18);
        this.staticScope = new LazyJavaStaticClassScope(r10, r15, this);
        this.annotations = LazyJavaAnnotationsKt.resolveAnnotations(r10, r15);
        this.declaredParameters = r10.getStorageManager().createLazyValue(new LazyJavaClassDescriptor$declaredParameters$1(this));
        return;
    L37:
        r17 = false;
        goto L38
    L31:
        if (r15.isStatic() == true) goto L33;
        r12 = true;
        goto L34
    L15:
        if (r15.isEnum() == true) goto L27;
        Modality.Companion r19 = Modality.Companion;
        boolean r20 = r15.isSealed();
        if (r15.isSealed() == false) goto L20;
    L25:
        boolean r21 = true;
    L26:
        r11 = r19.convertFromFlags(r20, r21, !r15.isFinal());
        goto L28
    L20:
        if (r15.isAbstract() == true) goto L25;
        if (r15.isInterface() == true) goto L25;
        r21 = false;
        goto L26
    L6:
        if (r15.isInterface() == false) goto L9;
        r5 = ClassKind.INTERFACE;
        goto L12
    L9:
        if (r15.isEnum() == false) goto L11;
        r5 = ClassKind.ENUM_CLASS;
        goto L12
    L11:
        r5 = ClassKind.CLASS;
        goto L12
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public List<ClassConstructorDescriptor> getConstructors() {
        return this.unsubstitutedMemberScope.getConstructors$descriptors_jvm().invoke();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleAwareClassDescriptor
    public /* bridge */ /* synthetic */ MemberScope getUnsubstitutedMemberScope(KotlinTypeRefiner r5) {
        return getUnsubstitutedMemberScope(r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleAwareClassDescriptor
    public LazyJavaClassMemberScope getUnsubstitutedMemberScope(KotlinTypeRefiner r5) {
        Intrinsics.checkNotNullParameter(r5, "kotlinTypeRefiner");
        return (LazyJavaClassMemberScope) this.scopeHolder.getScope(r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public LazyJavaClassMemberScope getUnsubstitutedMemberScope() {
        MemberScope r5 = super.getUnsubstitutedMemberScope();
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type org.jetbrains.kotlin.load.java.lazy.descriptors.LazyJavaClassMemberScope");
        return (LazyJavaClassMemberScope) r5;
    }
}
