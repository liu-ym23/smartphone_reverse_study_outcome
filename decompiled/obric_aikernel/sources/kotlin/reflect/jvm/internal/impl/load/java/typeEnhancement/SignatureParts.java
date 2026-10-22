package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.load.java.AbstractAnnotationTypeQualifierResolver;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType;
import kotlin.reflect.jvm.internal.impl.load.java.JavaTypeQualifiersByElementType;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.PossiblyExternalAnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaAnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaTypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancementKt;
import kotlin.reflect.jvm.internal.impl.types.checker.SimpleClassicTypeSystemContext;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemInferenceExtensionContext;

/* JADX INFO: loaded from: classes3.dex */
final class SignatureParts extends AbstractSignatureParts<AnnotationDescriptor> {
    private final AnnotationQualifierApplicabilityType containerApplicabilityType;
    private final LazyJavaResolverContext containerContext;
    private final boolean isCovariant;
    private final boolean skipRawTypeArguments;
    private final Annotated typeContainer;

    public SignatureParts(Annotated r10, boolean r11, LazyJavaResolverContext r12, AnnotationQualifierApplicabilityType r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r12, "containerContext");
        Intrinsics.checkNotNullParameter(r13, "containerApplicabilityType");
        this.typeContainer = r10;
        this.isCovariant = r11;
        this.containerContext = r12;
        this.containerApplicabilityType = r13;
        this.skipRawTypeArguments = r14;
    }

    public /* synthetic */ SignatureParts(Annotated r10, boolean r11, LazyJavaResolverContext r12, AnnotationQualifierApplicabilityType r13, boolean r14, int r15, DefaultConstructorMarker r16) {
        if ((r15 & 16) == 0) goto L5;
        r14 = false;
    L5:
        this(r10, r11, r12, r13, r14);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    public /* bridge */ /* synthetic */ AbstractAnnotationTypeQualifierResolver<AnnotationDescriptor> getAnnotationTypeQualifierResolver() {
        return getAnnotationTypeQualifierResolver2();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    /* JADX INFO: renamed from: getAnnotationTypeQualifierResolver, reason: avoid collision after fix types in other method */
    public AbstractAnnotationTypeQualifierResolver<AnnotationDescriptor> getAnnotationTypeQualifierResolver2() {
        return this.containerContext.getComponents().getAnnotationTypeQualifierResolver();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    public Iterable<AnnotationDescriptor> getAnnotations(KotlinTypeMarker r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return ((KotlinType) r10).getAnnotations();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    public Iterable<AnnotationDescriptor> getContainerAnnotations() {
        Annotated r10 = this.typeContainer;
        if (r10 == null) goto L8;
        Annotations r11 = r10.getAnnotations();
        if (r11 == null) goto L8;
        return r11;
    L8:
        return CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    public AnnotationQualifierApplicabilityType getContainerApplicabilityType() {
        return this.containerApplicabilityType;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    public JavaTypeQualifiersByElementType getContainerDefaultTypeQualifiers() {
        return this.containerContext.getDefaultTypeQualifiers();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    public boolean getContainerIsVarargParameter() {
        Annotated r10 = this.typeContainer;
        if ((r10 instanceof ValueParameterDescriptor) == true) goto L5;
    L7:
        return false;
    L5:
        if (((ValueParameterDescriptor) r10).getVarargElementType() == null) goto L7;
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    public boolean getEnableImprovementsInStrictMode() {
        return this.containerContext.getComponents().getSettings().getTypeEnhancementImprovementsInStrictMode();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    public KotlinType getEnhancedForWarnings(KotlinTypeMarker r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return TypeWithEnhancementKt.getEnhancement((KotlinType) r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    public /* bridge */ /* synthetic */ KotlinTypeMarker getEnhancedForWarnings(KotlinTypeMarker r10) {
        return getEnhancedForWarnings(r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    public /* bridge */ /* synthetic */ boolean getForceWarning(AnnotationDescriptor r10) {
        return getForceWarning2(r10);
    }

    /* JADX INFO: renamed from: getForceWarning, reason: avoid collision after fix types in other method */
    public boolean getForceWarning2(AnnotationDescriptor r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if ((r10 instanceof PossiblyExternalAnnotationDescriptor) == false) goto L7;
        if (((PossiblyExternalAnnotationDescriptor) r10).isIdeExternalAnnotation() == false) goto L7;
    L14:
        return true;
    L7:
        if ((r10 instanceof LazyJavaAnnotationDescriptor) == true) goto L9;
    L15:
        return false;
    L9:
        if (getEnableImprovementsInStrictMode() == true) goto L15;
        if (((LazyJavaAnnotationDescriptor) r10).isFreshlySupportedTypeUseAnnotation() == true) goto L14;
        if (getContainerApplicabilityType() != AnnotationQualifierApplicabilityType.TYPE_PARAMETER_BOUNDS) goto L15;
        goto L14
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    public FqNameUnsafe getFqNameUnsafe(KotlinTypeMarker r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        ClassDescriptor r11 = TypeUtils.getClassDescriptor((KotlinType) r10);
        if (r11 != null) goto L7;
        return null;
    L7:
        return DescriptorUtils.getFqName(r11);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    public boolean getSkipRawTypeArguments() {
        return this.skipRawTypeArguments;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    public /* bridge */ /* synthetic */ TypeSystemContext getTypeSystem() {
        return getTypeSystem();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    public TypeSystemInferenceExtensionContext getTypeSystem() {
        return SimpleClassicTypeSystemContext.INSTANCE;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    public boolean isArrayOrPrimitiveArray(KotlinTypeMarker r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return KotlinBuiltIns.isArrayOrPrimitiveArray((KotlinType) r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    public boolean isCovariant() {
        return this.isCovariant;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    public boolean isEqual(KotlinTypeMarker r10, KotlinTypeMarker r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "other");
        return this.containerContext.getComponents().getKotlinTypeChecker().equalTypes((KotlinType) r10, (KotlinType) r11);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    public boolean isFromJava(TypeParameterMarker r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10 instanceof LazyJavaTypeParameterDescriptor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    public boolean isNotNullTypeParameterCompat(KotlinTypeMarker r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return ((KotlinType) r10).unwrap() instanceof NotNullTypeParameterImpl;
    }
}
