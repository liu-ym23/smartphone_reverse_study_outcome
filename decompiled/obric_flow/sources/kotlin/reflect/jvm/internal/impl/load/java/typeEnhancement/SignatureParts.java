package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
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
@SourceDebugExtension({"SMAP\nsignatureEnhancement.kt\nKotlin\n*S Kotlin\n*F\n+ 1 signatureEnhancement.kt\norg/jetbrains/kotlin/load/java/typeEnhancement/SignatureParts\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,282:1\n1#2:283\n*E\n"})
final class SignatureParts extends AbstractSignatureParts<AnnotationDescriptor> {
    private final AnnotationQualifierApplicabilityType containerApplicabilityType;
    private final LazyJavaResolverContext containerContext;
    private final boolean isCovariant;
    private final boolean skipRawTypeArguments;
    private final Annotated typeContainer;

    public /* synthetic */ SignatureParts(Annotated r10, boolean r11, LazyJavaResolverContext r12, AnnotationQualifierApplicabilityType r13, boolean r14, int r15, DefaultConstructorMarker r16) {
        if ((r15 & 16) == 0) goto L5;
        r14 = false;
    L5:
        this(r10, r11, r12, r13, r14);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    public /* bridge */ /* synthetic */ boolean forceWarning(AnnotationDescriptor r5, KotlinTypeMarker r10) {
        return forceWarning2(r5, r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    public /* bridge */ /* synthetic */ AbstractAnnotationTypeQualifierResolver<AnnotationDescriptor> getAnnotationTypeQualifierResolver() {
        return getAnnotationTypeQualifierResolver2();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    public Iterable<AnnotationDescriptor> getAnnotations(KotlinTypeMarker r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return ((KotlinType) r5).getAnnotations();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    public Iterable<AnnotationDescriptor> getContainerAnnotations() {
        Annotated r5 = this.typeContainer;
        if (r5 == null) goto L8;
        Annotations r10 = r5.getAnnotations();
        if (r10 == null) goto L8;
        return r10;
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
        Annotated r5 = this.typeContainer;
        if ((r5 instanceof ValueParameterDescriptor) == true) goto L5;
    L7:
        return false;
    L5:
        if (((ValueParameterDescriptor) r5).getVarargElementType() == null) goto L7;
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    public boolean getEnableImprovementsInStrictMode() {
        return this.containerContext.getComponents().getSettings().getTypeEnhancementImprovementsInStrictMode();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    public /* bridge */ /* synthetic */ KotlinTypeMarker getEnhancedForWarnings(KotlinTypeMarker r5) {
        return getEnhancedForWarnings(r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    public FqNameUnsafe getFqNameUnsafe(KotlinTypeMarker r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        ClassDescriptor r10 = TypeUtils.getClassDescriptor((KotlinType) r5);
        if (r10 != null) goto L7;
        return null;
    L7:
        return DescriptorUtils.getFqName(r10);
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
    public boolean isArrayOrPrimitiveArray(KotlinTypeMarker r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return KotlinBuiltIns.isArrayOrPrimitiveArray((KotlinType) r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    public boolean isCovariant() {
        return this.isCovariant;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    public boolean isEqual(KotlinTypeMarker r5, KotlinTypeMarker r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "other");
        return this.containerContext.getComponents().getKotlinTypeChecker().equalTypes((KotlinType) r5, (KotlinType) r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    public boolean isFromJava(TypeParameterMarker r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return r5 instanceof LazyJavaTypeParameterDescriptor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    public boolean isNotNullTypeParameterCompat(KotlinTypeMarker r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return ((KotlinType) r5).unwrap() instanceof NotNullTypeParameterImpl;
    }

    public SignatureParts(Annotated r5, boolean r10, LazyJavaResolverContext r11, AnnotationQualifierApplicabilityType r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r11, "containerContext");
        Intrinsics.checkNotNullParameter(r12, "containerApplicabilityType");
        this.typeContainer = r5;
        this.isCovariant = r10;
        this.containerContext = r11;
        this.containerApplicabilityType = r12;
        this.skipRawTypeArguments = r13;
    }

    /* JADX INFO: renamed from: forceWarning, reason: avoid collision after fix types in other method */
    public boolean forceWarning2(AnnotationDescriptor r5, KotlinTypeMarker r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if ((r5 instanceof PossiblyExternalAnnotationDescriptor) == false) goto L7;
        if (((PossiblyExternalAnnotationDescriptor) r5).isIdeExternalAnnotation() == false) goto L7;
    L21:
        return true;
    L7:
        if ((r5 instanceof LazyJavaAnnotationDescriptor) == true) goto L9;
    L14:
        if (r10 != null) goto L16;
    L22:
        return false;
    L16:
        if (KotlinBuiltIns.isPrimitiveArray((KotlinType) r10) == false) goto L22;
        if (getAnnotationTypeQualifierResolver2().isTypeUseAnnotation(r5) == false) goto L22;
        if (this.containerContext.getComponents().getSettings().getEnhancePrimitiveArrays() == true) goto L22;
    L9:
        if (getEnableImprovementsInStrictMode() == true) goto L14;
        if (((LazyJavaAnnotationDescriptor) r5).isFreshlySupportedTypeUseAnnotation() == true) goto L21;
        if (getContainerApplicabilityType() == AnnotationQualifierApplicabilityType.TYPE_PARAMETER_BOUNDS) goto L21;
        goto L14
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    /* JADX INFO: renamed from: getAnnotationTypeQualifierResolver, reason: avoid collision after fix types in other method */
    public AbstractAnnotationTypeQualifierResolver<AnnotationDescriptor> getAnnotationTypeQualifierResolver2() {
        return this.containerContext.getComponents().getAnnotationTypeQualifierResolver();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    public KotlinType getEnhancedForWarnings(KotlinTypeMarker r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return TypeWithEnhancementKt.getEnhancement((KotlinType) r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    public TypeSystemInferenceExtensionContext getTypeSystem() {
        return SimpleClassicTypeSystemContext.INSTANCE;
    }
}
