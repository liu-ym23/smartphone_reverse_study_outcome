package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import com.bytedance.common.wschannel.WsConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
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
public final class LazyJavaAnnotationDescriptor implements AnnotationDescriptor, PossiblyExternalAnnotationDescriptor {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = null;
    private final NotNullLazyValue allValueArguments$delegate;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final LazyJavaResolverContext f10210c;
    private final NullableLazyValue fqName$delegate;
    private final boolean isFreshlySupportedTypeUseAnnotation;
    private final boolean isIdeExternalAnnotation;
    private final JavaAnnotation javaAnnotation;
    private final JavaSourceElement source;
    private final NotNullLazyValue type$delegate;

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(LazyJavaAnnotationDescriptor.class), "fqName", "getFqName()Lorg/jetbrains/kotlin/name/FqName;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(LazyJavaAnnotationDescriptor.class), WsConstants.KEY_CONNECTION_TYPE, "getType()Lorg/jetbrains/kotlin/types/SimpleType;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(LazyJavaAnnotationDescriptor.class), "allValueArguments", "getAllValueArguments()Ljava/util/Map;"))};
    }

    public LazyJavaAnnotationDescriptor(LazyJavaResolverContext r10, JavaAnnotation r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r10, "c");
        Intrinsics.checkNotNullParameter(r11, "javaAnnotation");
        this.f10210c = r10;
        this.javaAnnotation = r11;
        this.fqName$delegate = r10.getStorageManager().createNullableLazyValue(new LazyJavaAnnotationDescriptor$fqName$2(this));
        this.type$delegate = r10.getStorageManager().createLazyValue(new LazyJavaAnnotationDescriptor$type$2(this));
        this.source = r10.getComponents().getSourceElementFactory().source(r11);
        this.allValueArguments$delegate = r10.getStorageManager().createLazyValue(new LazyJavaAnnotationDescriptor$allValueArguments$2(this));
        this.isIdeExternalAnnotation = r11.isIdeExternalAnnotation();
        if (r11.isFreshlySupportedTypeUseAnnotation() == true) goto L7;
        if (r12 == true) goto L7;
        boolean r13 = false;
    L8:
        this.isFreshlySupportedTypeUseAnnotation = r13;
        return;
    L7:
        r13 = true;
        goto L8
    }

    public /* synthetic */ LazyJavaAnnotationDescriptor(LazyJavaResolverContext r10, JavaAnnotation r11, boolean r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 4) == 0) goto L5;
        r12 = false;
    L5:
        this(r10, r11, r12);
    }

    public static final /* synthetic */ ClassDescriptor access$createTypeForMissingDependencies(LazyJavaAnnotationDescriptor r10, FqName r11) {
        return r10.createTypeForMissingDependencies(r11);
    }

    public static final /* synthetic */ LazyJavaResolverContext access$getC$p(LazyJavaAnnotationDescriptor r10) {
        return r10.f10210c;
    }

    public static final /* synthetic */ JavaAnnotation access$getJavaAnnotation$p(LazyJavaAnnotationDescriptor r10) {
        return r10.javaAnnotation;
    }

    public static final /* synthetic */ ConstantValue access$resolveAnnotationArgument(LazyJavaAnnotationDescriptor r10, JavaAnnotationArgument r11) {
        return r10.resolveAnnotationArgument(r11);
    }

    private final ClassDescriptor createTypeForMissingDependencies(FqName r10) {
        ModuleDescriptor r11 = this.f10210c.getModule();
        ClassId r12 = ClassId.topLevel(r10);
        Intrinsics.checkNotNullExpressionValue(r12, "topLevel(fqName)");
        return FindClassInModuleKt.findNonGenericClassAcrossDependencies(r11, r12, this.f10210c.getComponents().getDeserializedDescriptorResolver().getComponents().getNotFoundClasses());
    }

    private final ConstantValue<?> resolveAnnotationArgument(JavaAnnotationArgument r10) {
        if ((r10 instanceof JavaLiteralAnnotationArgument) == false) goto L6;
        return ConstantValueFactory.INSTANCE.createConstantValue(((JavaLiteralAnnotationArgument) r10).getValue());
    L6:
        if ((r10 instanceof JavaEnumValueAnnotationArgument) == false) goto L9;
        JavaEnumValueAnnotationArgument r11 = (JavaEnumValueAnnotationArgument) r10;
        return resolveFromEnumValue(r11.getEnumClassId(), r11.getEntryName());
    L9:
        if ((r10 instanceof JavaArrayAnnotationArgument) == false) goto L15;
        JavaArrayAnnotationArgument r12 = (JavaArrayAnnotationArgument) r10;
        Name r13 = r12.getName();
        if (r13 != null) goto L13;
        r13 = JvmAnnotationNames.DEFAULT_ANNOTATION_MEMBER_NAME;
    L13:
        Intrinsics.checkNotNullExpressionValue(r13, "argument.name ?: DEFAULT_ANNOTATION_MEMBER_NAME");
        return resolveFromArray(r13, r12.getElements());
    L15:
        if ((r10 instanceof JavaAnnotationAsAnnotationArgument) == false) goto L18;
        return resolveFromAnnotation(((JavaAnnotationAsAnnotationArgument) r10).getAnnotation());
    L18:
        if ((r10 instanceof JavaClassObjectAnnotationArgument) == true) goto L26;
        return null;
    L26:
        return resolveFromJavaClassObjectType(((JavaClassObjectAnnotationArgument) r10).getReferencedType());
    }

    private final ConstantValue<?> resolveFromAnnotation(JavaAnnotation r10) {
        return new AnnotationValue(new LazyJavaAnnotationDescriptor(this.f10210c, r10, false, 4, null));
    }

    private final ConstantValue<?> resolveFromArray(Name r10, List<? extends JavaAnnotationArgument> r11) {
        SimpleType r12 = getType();
        Intrinsics.checkNotNullExpressionValue(r12, WsConstants.KEY_CONNECTION_TYPE);
        if (KotlinTypeKt.isError(r12) == false) goto L6;
        return null;
    L6:
        ClassDescriptor r13 = DescriptorUtilsKt.getAnnotationClass(this);
        Intrinsics.checkNotNull(r13);
        ValueParameterDescriptor r14 = DescriptorResolverUtils.getAnnotationParameterByName(r10, r13);
        if (r14 == null) goto L10;
        KotlinType r15 = r14.getType();
        if (r15 == null) goto L10;
    L11:
        Intrinsics.checkNotNullExpressionValue(r15, "DescriptorResolverUtils.…GUMENT)\n                )");
        ArrayList r16 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r11, 10));
        Iterator<T> r17 = r11.iterator();
    L13:
        if (r17.hasNext() == false) goto L19;
        ConstantValue<?> r18 = resolveAnnotationArgument((JavaAnnotationArgument) r17.next());
        if (r18 != null) goto L17;
        r18 = new NullValue();
    L17:
        r16.add(r18);
        goto L13
    L19:
        return ConstantValueFactory.INSTANCE.createArrayValue(r16, r15);
    L10:
        r15 = this.f10210c.getComponents().getModule().getBuiltIns().getArrayType(Variance.INVARIANT, ErrorUtils.createErrorType(ErrorTypeKind.UNKNOWN_ARRAY_ELEMENT_TYPE_OF_ANNOTATION_ARGUMENT, new String[0]));
        goto L11
    }

    private final ConstantValue<?> resolveFromEnumValue(ClassId r10, Name r11) {
        if (r10 == null) goto L7;
        if (r11 != null) goto L6;
        return null;
    L6:
        return new EnumValue(r10, r11);
    L7:
        return null;
    }

    private final ConstantValue<?> resolveFromJavaClassObjectType(JavaType r10) {
        return KClassValue.Companion.create(this.f10210c.getTypeResolver().transformJavaType(r10, JavaTypeAttributesKt.toAttributes$default(TypeUsage.COMMON, false, false, null, 7, null)));
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
    public JavaSourceElement getSource() {
        return this.source;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor
    public /* bridge */ /* synthetic */ KotlinType getType() {
        return getType();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor
    public SimpleType getType() {
        return (SimpleType) StorageKt.getValue(this.type$delegate, this, $$delegatedProperties[1]);
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
}
