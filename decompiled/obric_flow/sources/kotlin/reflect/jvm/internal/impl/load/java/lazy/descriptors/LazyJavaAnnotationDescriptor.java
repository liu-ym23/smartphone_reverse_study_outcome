package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames;
import kotlin.reflect.jvm.internal.impl.load.java.components.DescriptorResolverUtils;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.PossiblyExternalAnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributesKt;
import kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationAsAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassObjectAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaEnumValueAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaLiteralAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.resolve.constants.AnnotationValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValueFactory;
import kotlin.reflect.jvm.internal.impl.resolve.constants.EnumValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.NullValue;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeUsage;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nLazyJavaAnnotationDescriptor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LazyJavaAnnotationDescriptor.kt\norg/jetbrains/kotlin/load/java/lazy/descriptors/LazyJavaAnnotationDescriptor\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,124:1\n1549#2:125\n1620#2,3:126\n*S KotlinDebug\n*F\n+ 1 LazyJavaAnnotationDescriptor.kt\norg/jetbrains/kotlin/load/java/lazy/descriptors/LazyJavaAnnotationDescriptor\n*L\n94#1:125\n94#1:126,3\n*E\n"})
public final class LazyJavaAnnotationDescriptor implements AnnotationDescriptor, PossiblyExternalAnnotationDescriptor {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = null;
    private final NotNullLazyValue allValueArguments$delegate;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final LazyJavaResolverContext f18746c;
    private final NullableLazyValue fqName$delegate;
    private final boolean isFreshlySupportedTypeUseAnnotation;
    private final boolean isIdeExternalAnnotation;
    private final JavaAnnotation javaAnnotation;
    private final JavaSourceElement source;
    private final NotNullLazyValue type$delegate;

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(LazyJavaAnnotationDescriptor.class), "fqName", "getFqName()Lorg/jetbrains/kotlin/name/FqName;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(LazyJavaAnnotationDescriptor.class), "type", "getType()Lorg/jetbrains/kotlin/types/SimpleType;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(LazyJavaAnnotationDescriptor.class), "allValueArguments", "getAllValueArguments()Ljava/util/Map;"))};
    }

    public LazyJavaAnnotationDescriptor(LazyJavaResolverContext r5, JavaAnnotation r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r5, "c");
        Intrinsics.checkNotNullParameter(r10, "javaAnnotation");
        this.f18746c = r5;
        this.javaAnnotation = r10;
        this.fqName$delegate = r5.getStorageManager().createNullableLazyValue(new LazyJavaAnnotationDescriptor$fqName$2(this));
        this.type$delegate = r5.getStorageManager().createLazyValue(new LazyJavaAnnotationDescriptor$type$2(this));
        this.source = r5.getComponents().getSourceElementFactory().source(r10);
        this.allValueArguments$delegate = r5.getStorageManager().createLazyValue(new LazyJavaAnnotationDescriptor$allValueArguments$2(this));
        this.isIdeExternalAnnotation = r10.isIdeExternalAnnotation();
        if (r10.isFreshlySupportedTypeUseAnnotation() == true) goto L7;
        if (r11 == true) goto L7;
        boolean r12 = false;
    L8:
        this.isFreshlySupportedTypeUseAnnotation = r12;
        return;
    L7:
        r12 = true;
        goto L8
    }

    public static final /* synthetic */ ClassDescriptor access$createTypeForMissingDependencies(LazyJavaAnnotationDescriptor r5, FqName r10) {
        return r5.createTypeForMissingDependencies(r10);
    }

    public static final /* synthetic */ LazyJavaResolverContext access$getC$p(LazyJavaAnnotationDescriptor r5) {
        return r5.f18746c;
    }

    public static final /* synthetic */ JavaAnnotation access$getJavaAnnotation$p(LazyJavaAnnotationDescriptor r5) {
        return r5.javaAnnotation;
    }

    public static final /* synthetic */ ConstantValue access$resolveAnnotationArgument(LazyJavaAnnotationDescriptor r5, JavaAnnotationArgument r10) {
        return r5.resolveAnnotationArgument(r10);
    }

    private final ClassDescriptor createTypeForMissingDependencies(FqName r5) {
        return FindClassInModuleKt.findNonGenericClassAcrossDependencies(this.f18746c.getModule(), ClassId.topLevel(r5), this.f18746c.getComponents().getDeserializedDescriptorResolver().getComponents().getNotFoundClasses());
    }

    private final ConstantValue<?> resolveAnnotationArgument(JavaAnnotationArgument r5) {
        if ((r5 instanceof JavaLiteralAnnotationArgument) == false) goto L6;
        return ConstantValueFactory.createConstantValue$default(ConstantValueFactory.INSTANCE, ((JavaLiteralAnnotationArgument) r5).getValue(), null, 2, null);
    L6:
        if ((r5 instanceof JavaEnumValueAnnotationArgument) == false) goto L9;
        JavaEnumValueAnnotationArgument r10 = (JavaEnumValueAnnotationArgument) r5;
        return resolveFromEnumValue(r10.getEnumClassId(), r10.getEntryName());
    L9:
        if ((r5 instanceof JavaArrayAnnotationArgument) == false) goto L15;
        JavaArrayAnnotationArgument r11 = (JavaArrayAnnotationArgument) r5;
        Name r12 = r11.getName();
        if (r12 != null) goto L23;
        r12 = JvmAnnotationNames.DEFAULT_ANNOTATION_MEMBER_NAME;
    L23:
        return resolveFromArray(r12, r11.getElements());
    L15:
        if ((r5 instanceof JavaAnnotationAsAnnotationArgument) == false) goto L18;
        return resolveFromAnnotation(((JavaAnnotationAsAnnotationArgument) r5).getAnnotation());
    L18:
        if ((r5 instanceof JavaClassObjectAnnotationArgument) == true) goto L20;
        return null;
    L20:
        return resolveFromJavaClassObjectType(((JavaClassObjectAnnotationArgument) r5).getReferencedType());
    }

    private final ConstantValue<?> resolveFromAnnotation(JavaAnnotation r10) {
        boolean r5 = false;
        return new AnnotationValue(new LazyJavaAnnotationDescriptor(this.f18746c, r10, r5, 4, null));
    }

    private final ConstantValue<?> resolveFromArray(Name r5, List<? extends JavaAnnotationArgument> r10) {
        if (KotlinTypeKt.isError(getType()) == false) goto L6;
        return null;
    L6:
        ClassDescriptor r11 = DescriptorUtilsKt.getAnnotationClass(this);
        Intrinsics.checkNotNull(r11);
        ValueParameterDescriptor r12 = DescriptorResolverUtils.getAnnotationParameterByName(r5, r11);
        if (r12 == null) goto L10;
        KotlinType r13 = r12.getType();
        if (r13 == null) goto L10;
    L11:
        ArrayList r14 = new ArrayList(CollectionsKt.h(r10));
        Iterator<T> r15 = r10.iterator();
    L13:
        if (r15.hasNext() == false) goto L19;
        ConstantValue<?> r16 = resolveAnnotationArgument((JavaAnnotationArgument) r15.next());
        if (r16 != null) goto L17;
        r16 = new NullValue();
    L17:
        r14.add(r16);
        goto L13
    L19:
        return ConstantValueFactory.INSTANCE.createArrayValue(r14, r13);
    L10:
        r13 = this.f18746c.getComponents().getModule().getBuiltIns().getArrayType(Variance.INVARIANT, ErrorUtils.createErrorType(ErrorTypeKind.UNKNOWN_ARRAY_ELEMENT_TYPE_OF_ANNOTATION_ARGUMENT, new String[0]));
        goto L11
    }

    private final ConstantValue<?> resolveFromEnumValue(ClassId r5, Name r10) {
        if (r5 == null) goto L7;
        if (r10 != null) goto L6;
        return null;
    L6:
        return new EnumValue(r5, r10);
    L7:
        return null;
    }

    private final ConstantValue<?> resolveFromJavaClassObjectType(JavaType r10) {
        return KClassValue.Companion.create(this.f18746c.getTypeResolver().transformJavaType(r10, JavaTypeAttributesKt.toAttributes$default(TypeUsage.COMMON, false, false, null, 7, null)));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor
    public Map<Name, ConstantValue<?>> getAllValueArguments() {
        return (Map) StorageKt.getValue(this.allValueArguments$delegate, this, $$delegatedProperties[2]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor
    public FqName getFqName() {
        return (FqName) StorageKt.getValue(this.fqName$delegate, this, $$delegatedProperties[0]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor
    public /* bridge */ /* synthetic */ SourceElement getSource() {
        return getSource();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor
    public /* bridge */ /* synthetic */ KotlinType getType() {
        return getType();
    }

    public final boolean isFreshlySupportedTypeUseAnnotation() {
        return this.isFreshlySupportedTypeUseAnnotation;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.descriptors.PossiblyExternalAnnotationDescriptor
    public boolean isIdeExternalAnnotation() {
        return this.isIdeExternalAnnotation;
    }

    public String toString() {
        return DescriptorRenderer.renderAnnotation$default(DescriptorRenderer.FQ_NAMES_IN_TYPES, this, null, 2, null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor
    public JavaSourceElement getSource() {
        return this.source;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor
    public SimpleType getType() {
        return (SimpleType) StorageKt.getValue(this.type$delegate, this, $$delegatedProperties[1]);
    }

    public /* synthetic */ LazyJavaAnnotationDescriptor(LazyJavaResolverContext r5, JavaAnnotation r10, boolean r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 4) == 0) goto L5;
        r11 = false;
    L5:
        this(r5, r10, r11);
    }
}
