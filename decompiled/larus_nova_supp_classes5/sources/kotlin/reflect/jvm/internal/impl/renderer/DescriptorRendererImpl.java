package kotlin.reflect.jvm.internal.impl.renderer;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.FunctionTypesKt;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FieldDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PossiblyInnerType;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterUtilsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUseSiteTarget;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.name.SpecialNames;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.constants.AnnotationValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ArrayValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.AbbreviatedType;
import kotlin.reflect.jvm.internal.impl.types.DefinitelyNotNullType;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.SpecialTypesKt;
import kotlin.reflect.jvm.internal.impl.types.StubTypeForBuilderInference;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.WrappedType;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorType;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.reflect.jvm.internal.impl.util.capitalizeDecapitalize.CapitalizeDecapitalizeKt;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class DescriptorRendererImpl extends DescriptorRenderer implements DescriptorRendererOptions {
    private final Lazy functionTypeAnnotationsRenderer$delegate;
    private final DescriptorRendererOptionsImpl options;

    public final class RenderDeclarationDescriptorVisitor implements DeclarationDescriptorVisitor<Unit, StringBuilder> {
        final /* synthetic */ DescriptorRendererImpl this$0;

        public RenderDeclarationDescriptorVisitor(DescriptorRendererImpl r1) {
            this.this$0 = r1;
        }

        /* JADX INFO: renamed from: visitClassDescriptor, reason: avoid collision after fix types in other method */
        public void visitClassDescriptor2(ClassDescriptor r2, StringBuilder r3) {
            Intrinsics.checkNotNullParameter(r2, "descriptor");
            Intrinsics.checkNotNullParameter(r3, "builder");
            DescriptorRendererImpl.access$renderClass(this.this$0, r2, r3);
        }

        /* JADX INFO: renamed from: visitConstructorDescriptor, reason: avoid collision after fix types in other method */
        public void visitConstructorDescriptor2(ConstructorDescriptor r2, StringBuilder r3) {
            Intrinsics.checkNotNullParameter(r2, "constructorDescriptor");
            Intrinsics.checkNotNullParameter(r3, "builder");
            DescriptorRendererImpl.access$renderConstructor(this.this$0, r2, r3);
        }

        /* JADX INFO: renamed from: visitFunctionDescriptor, reason: avoid collision after fix types in other method */
        public void visitFunctionDescriptor2(FunctionDescriptor r2, StringBuilder r3) {
            Intrinsics.checkNotNullParameter(r2, "descriptor");
            Intrinsics.checkNotNullParameter(r3, "builder");
            DescriptorRendererImpl.access$renderFunction(this.this$0, r2, r3);
        }

        /* JADX INFO: renamed from: visitModuleDeclaration, reason: avoid collision after fix types in other method */
        public void visitModuleDeclaration2(ModuleDescriptor r3, StringBuilder r4) {
            Intrinsics.checkNotNullParameter(r3, "descriptor");
            Intrinsics.checkNotNullParameter(r4, "builder");
            DescriptorRendererImpl.access$renderName(this.this$0, r3, r4, true);
        }

        /* JADX INFO: renamed from: visitPackageFragmentDescriptor, reason: avoid collision after fix types in other method */
        public void visitPackageFragmentDescriptor2(PackageFragmentDescriptor r2, StringBuilder r3) {
            Intrinsics.checkNotNullParameter(r2, "descriptor");
            Intrinsics.checkNotNullParameter(r3, "builder");
            DescriptorRendererImpl.access$renderPackageFragment(this.this$0, r2, r3);
        }

        /* JADX INFO: renamed from: visitPackageViewDescriptor, reason: avoid collision after fix types in other method */
        public void visitPackageViewDescriptor2(PackageViewDescriptor r2, StringBuilder r3) {
            Intrinsics.checkNotNullParameter(r2, "descriptor");
            Intrinsics.checkNotNullParameter(r3, "builder");
            DescriptorRendererImpl.access$renderPackageView(this.this$0, r2, r3);
        }

        /* JADX INFO: renamed from: visitPropertyDescriptor, reason: avoid collision after fix types in other method */
        public void visitPropertyDescriptor2(PropertyDescriptor r2, StringBuilder r3) {
            Intrinsics.checkNotNullParameter(r2, "descriptor");
            Intrinsics.checkNotNullParameter(r3, "builder");
            DescriptorRendererImpl.access$renderProperty(this.this$0, r2, r3);
        }

        /* JADX INFO: renamed from: visitPropertyGetterDescriptor, reason: avoid collision after fix types in other method */
        public void visitPropertyGetterDescriptor2(PropertyGetterDescriptor r2, StringBuilder r3) {
            Intrinsics.checkNotNullParameter(r2, "descriptor");
            Intrinsics.checkNotNullParameter(r3, "builder");
            visitPropertyAccessorDescriptor(r2, r3, "getter");
        }

        /* JADX INFO: renamed from: visitPropertySetterDescriptor, reason: avoid collision after fix types in other method */
        public void visitPropertySetterDescriptor2(PropertySetterDescriptor r2, StringBuilder r3) {
            Intrinsics.checkNotNullParameter(r2, "descriptor");
            Intrinsics.checkNotNullParameter(r3, "builder");
            visitPropertyAccessorDescriptor(r2, r3, "setter");
        }

        /* JADX INFO: renamed from: visitReceiverParameterDescriptor, reason: avoid collision after fix types in other method */
        public void visitReceiverParameterDescriptor2(ReceiverParameterDescriptor r2, StringBuilder r3) {
            Intrinsics.checkNotNullParameter(r2, "descriptor");
            Intrinsics.checkNotNullParameter(r3, "builder");
            r3.append(r2.getName());
        }

        /* JADX INFO: renamed from: visitTypeAliasDescriptor, reason: avoid collision after fix types in other method */
        public void visitTypeAliasDescriptor2(TypeAliasDescriptor r2, StringBuilder r3) {
            Intrinsics.checkNotNullParameter(r2, "descriptor");
            Intrinsics.checkNotNullParameter(r3, "builder");
            DescriptorRendererImpl.access$renderTypeAlias(this.this$0, r2, r3);
        }

        /* JADX INFO: renamed from: visitTypeParameterDescriptor, reason: avoid collision after fix types in other method */
        public void visitTypeParameterDescriptor2(TypeParameterDescriptor r3, StringBuilder r4) {
            Intrinsics.checkNotNullParameter(r3, "descriptor");
            Intrinsics.checkNotNullParameter(r4, "builder");
            DescriptorRendererImpl.access$renderTypeParameter(this.this$0, r3, r4, true);
        }

        /* JADX INFO: renamed from: visitValueParameterDescriptor, reason: avoid collision after fix types in other method */
        public void visitValueParameterDescriptor2(ValueParameterDescriptor r3, StringBuilder r4) {
            Intrinsics.checkNotNullParameter(r3, "descriptor");
            Intrinsics.checkNotNullParameter(r4, "builder");
            DescriptorRendererImpl.access$renderValueParameter(this.this$0, r3, true, r4, true);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ Unit visitClassDescriptor(ClassDescriptor r1, StringBuilder r2) {
            visitClassDescriptor2(r1, r2);
            return Unit.INSTANCE;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ Unit visitConstructorDescriptor(ConstructorDescriptor r1, StringBuilder r2) {
            visitConstructorDescriptor2(r1, r2);
            return Unit.INSTANCE;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ Unit visitFunctionDescriptor(FunctionDescriptor r1, StringBuilder r2) {
            visitFunctionDescriptor2(r1, r2);
            return Unit.INSTANCE;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ Unit visitModuleDeclaration(ModuleDescriptor r1, StringBuilder r2) {
            visitModuleDeclaration2(r1, r2);
            return Unit.INSTANCE;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ Unit visitPackageFragmentDescriptor(PackageFragmentDescriptor r1, StringBuilder r2) {
            visitPackageFragmentDescriptor2(r1, r2);
            return Unit.INSTANCE;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ Unit visitPackageViewDescriptor(PackageViewDescriptor r1, StringBuilder r2) {
            visitPackageViewDescriptor2(r1, r2);
            return Unit.INSTANCE;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ Unit visitPropertyDescriptor(PropertyDescriptor r1, StringBuilder r2) {
            visitPropertyDescriptor2(r1, r2);
            return Unit.INSTANCE;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ Unit visitPropertyGetterDescriptor(PropertyGetterDescriptor r1, StringBuilder r2) {
            visitPropertyGetterDescriptor2(r1, r2);
            return Unit.INSTANCE;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ Unit visitPropertySetterDescriptor(PropertySetterDescriptor r1, StringBuilder r2) {
            visitPropertySetterDescriptor2(r1, r2);
            return Unit.INSTANCE;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ Unit visitReceiverParameterDescriptor(ReceiverParameterDescriptor r1, StringBuilder r2) {
            visitReceiverParameterDescriptor2(r1, r2);
            return Unit.INSTANCE;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ Unit visitTypeAliasDescriptor(TypeAliasDescriptor r1, StringBuilder r2) {
            visitTypeAliasDescriptor2(r1, r2);
            return Unit.INSTANCE;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ Unit visitTypeParameterDescriptor(TypeParameterDescriptor r1, StringBuilder r2) {
            visitTypeParameterDescriptor2(r1, r2);
            return Unit.INSTANCE;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ Unit visitValueParameterDescriptor(ValueParameterDescriptor r1, StringBuilder r2) {
            visitValueParameterDescriptor2(r1, r2);
            return Unit.INSTANCE;
        }

        private final void visitPropertyAccessorDescriptor(PropertyAccessorDescriptor r3, StringBuilder r4, String r5) {
            int r0 = WhenMappings.$EnumSwitchMapping$0[this.this$0.getPropertyAccessorRenderingPolicy().ordinal()];
            if (r0 != 1) goto L5;
            DescriptorRendererImpl.access$renderAccessorModifiers(this.this$0, r3, r4);
            r4.append(r5 + " for ");
            DescriptorRendererImpl.access$renderProperty(this.this$0, r3.getCorrespondingProperty(), r4);
            return;
        L5:
            if (r0 != 2) goto L7;
            visitFunctionDescriptor2(r3, r4);
            return;
        L7:
            if (r0 != 3) goto L10;
            return;
        L10:
            throw new NoWhenBranchMatchedException();
        }
    }

    public static /* synthetic */ DescriptorRendererImpl accessor$DescriptorRendererImpl$lambda0(DescriptorRendererImpl r0) {
        return functionTypeAnnotationsRenderer_delegate$lambda$1(r0);
    }

    public static /* synthetic */ Object accessor$DescriptorRendererImpl$lambda1(KotlinType r0) {
        return renderTypeConstructor$lambda$6(r0);
    }

    public static /* synthetic */ CharSequence accessor$DescriptorRendererImpl$lambda2(DescriptorRendererImpl r0, TypeProjection r1) {
        return appendTypeProjections$lambda$8(r0, r1);
    }

    public static /* synthetic */ CharSequence accessor$DescriptorRendererImpl$lambda3(ValueParameterDescriptor r0) {
        return renderConstructor$lambda$24(r0);
    }

    public static /* synthetic */ CharSequence accessor$DescriptorRendererImpl$lambda4(DescriptorRendererImpl r0, KotlinType r1) {
        return renderSuperTypes$lambda$34(r0, r1);
    }

    public static /* synthetic */ Unit accessor$DescriptorRendererImpl$lambda5(DescriptorRendererOptions r0) {
        return functionTypeAnnotationsRenderer_delegate$lambda$1$lambda$0(r0);
    }

    private static final CharSequence renderConstructor$lambda$24(ValueParameterDescriptor r0) {
        return "";
    }

    public boolean getActualPropertiesInPrimaryConstructor() {
        return this.options.getActualPropertiesInPrimaryConstructor();
    }

    public boolean getAlwaysRenderModifiers() {
        return this.options.getAlwaysRenderModifiers();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public AnnotationArgumentsRenderingPolicy getAnnotationArgumentsRenderingPolicy() {
        return this.options.getAnnotationArgumentsRenderingPolicy();
    }

    public Function1<AnnotationDescriptor, Boolean> getAnnotationFilter() {
        return this.options.getAnnotationFilter();
    }

    public boolean getBoldOnlyForNamesInHtml() {
        return this.options.getBoldOnlyForNamesInHtml();
    }

    public boolean getClassWithPrimaryConstructor() {
        return this.options.getClassWithPrimaryConstructor();
    }

    public ClassifierNamePolicy getClassifierNamePolicy() {
        return this.options.getClassifierNamePolicy();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public boolean getDebugMode() {
        return this.options.getDebugMode();
    }

    public Function1<ValueParameterDescriptor, String> getDefaultParameterValueRenderer() {
        return this.options.getDefaultParameterValueRenderer();
    }

    public boolean getEachAnnotationOnNewLine() {
        return this.options.getEachAnnotationOnNewLine();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public boolean getEnhancedTypes() {
        return this.options.getEnhancedTypes();
    }

    public Set<FqName> getExcludedAnnotationClasses() {
        return this.options.getExcludedAnnotationClasses();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public Set<FqName> getExcludedTypeAnnotationClasses() {
        return this.options.getExcludedTypeAnnotationClasses();
    }

    public boolean getIncludeAdditionalModifiers() {
        return this.options.getIncludeAdditionalModifiers();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public boolean getIncludeAnnotationArguments() {
        return this.options.getIncludeAnnotationArguments();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public boolean getIncludeEmptyAnnotationArguments() {
        return this.options.getIncludeEmptyAnnotationArguments();
    }

    public boolean getIncludePropertyConstant() {
        return this.options.getIncludePropertyConstant();
    }

    public boolean getInformativeErrorType() {
        return this.options.getInformativeErrorType();
    }

    public Set<DescriptorRendererModifier> getModifiers() {
        return this.options.getModifiers();
    }

    public boolean getNormalizedVisibilities() {
        return this.options.getNormalizedVisibilities();
    }

    public OverrideRenderingPolicy getOverrideRenderingPolicy() {
        return this.options.getOverrideRenderingPolicy();
    }

    public ParameterNameRenderingPolicy getParameterNameRenderingPolicy() {
        return this.options.getParameterNameRenderingPolicy();
    }

    public boolean getParameterNamesInFunctionalTypes() {
        return this.options.getParameterNamesInFunctionalTypes();
    }

    public boolean getPresentableUnresolvedTypes() {
        return this.options.getPresentableUnresolvedTypes();
    }

    public PropertyAccessorRenderingPolicy getPropertyAccessorRenderingPolicy() {
        return this.options.getPropertyAccessorRenderingPolicy();
    }

    public boolean getReceiverAfterName() {
        return this.options.getReceiverAfterName();
    }

    public boolean getRenderCompanionObjectName() {
        return this.options.getRenderCompanionObjectName();
    }

    public boolean getRenderConstructorDelegation() {
        return this.options.getRenderConstructorDelegation();
    }

    public boolean getRenderConstructorKeyword() {
        return this.options.getRenderConstructorKeyword();
    }

    public boolean getRenderDefaultAnnotationArguments() {
        return this.options.getRenderDefaultAnnotationArguments();
    }

    public boolean getRenderDefaultModality() {
        return this.options.getRenderDefaultModality();
    }

    public boolean getRenderDefaultVisibility() {
        return this.options.getRenderDefaultVisibility();
    }

    public boolean getRenderPrimaryConstructorParametersAsProperties() {
        return this.options.getRenderPrimaryConstructorParametersAsProperties();
    }

    public boolean getRenderTypeExpansions() {
        return this.options.getRenderTypeExpansions();
    }

    public boolean getRenderUnabbreviatedType() {
        return this.options.getRenderUnabbreviatedType();
    }

    public boolean getSecondaryConstructorsAsPrimary() {
        return this.options.getSecondaryConstructorsAsPrimary();
    }

    public boolean getStartFromDeclarationKeyword() {
        return this.options.getStartFromDeclarationKeyword();
    }

    public boolean getStartFromName() {
        return this.options.getStartFromName();
    }

    public RenderingFormat getTextFormat() {
        return this.options.getTextFormat();
    }

    public Function1<KotlinType, KotlinType> getTypeNormalizer() {
        return this.options.getTypeNormalizer();
    }

    public boolean getUninferredTypeParameterAsName() {
        return this.options.getUninferredTypeParameterAsName();
    }

    public boolean getUnitReturnType() {
        return this.options.getUnitReturnType();
    }

    public DescriptorRenderer.ValueParametersHandler getValueParametersHandler() {
        return this.options.getValueParametersHandler();
    }

    public boolean getVerbose() {
        return this.options.getVerbose();
    }

    public boolean getWithDefinedIn() {
        return this.options.getWithDefinedIn();
    }

    public boolean getWithSourceFileForTopLevel() {
        return this.options.getWithSourceFileForTopLevel();
    }

    public boolean getWithoutReturnType() {
        return this.options.getWithoutReturnType();
    }

    public boolean getWithoutSuperTypes() {
        return this.options.getWithoutSuperTypes();
    }

    public boolean getWithoutTypeParameters() {
        return this.options.getWithoutTypeParameters();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setAnnotationArgumentsRenderingPolicy(AnnotationArgumentsRenderingPolicy r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.options.setAnnotationArgumentsRenderingPolicy(r2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setClassifierNamePolicy(ClassifierNamePolicy r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.options.setClassifierNamePolicy(r2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setDebugMode(boolean r2) {
        this.options.setDebugMode(r2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setExcludedTypeAnnotationClasses(Set<FqName> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.options.setExcludedTypeAnnotationClasses(r2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setModifiers(Set<? extends DescriptorRendererModifier> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.options.setModifiers(r2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setParameterNameRenderingPolicy(ParameterNameRenderingPolicy r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.options.setParameterNameRenderingPolicy(r2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setReceiverAfterName(boolean r2) {
        this.options.setReceiverAfterName(r2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setRenderCompanionObjectName(boolean r2) {
        this.options.setRenderCompanionObjectName(r2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setStartFromName(boolean r2) {
        this.options.setStartFromName(r2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setTextFormat(RenderingFormat r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.options.setTextFormat(r2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setVerbose(boolean r2) {
        this.options.setVerbose(r2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setWithDefinedIn(boolean r2) {
        this.options.setWithDefinedIn(r2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setWithoutSuperTypes(boolean r2) {
        this.options.setWithoutSuperTypes(r2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setWithoutTypeParameters(boolean r2) {
        this.options.setWithoutTypeParameters(r2);
    }

    private final DescriptorRendererImpl getFunctionTypeAnnotationsRenderer() {
        return (DescriptorRendererImpl) this.functionTypeAnnotationsRenderer$delegate.getValue();
    }

    private final String gt() {
        return escape(">");
    }

    private final String lt() {
        return escape("<");
    }

    private final String arrow() {
        RenderingFormat r0 = getTextFormat();
        int r1 = WhenMappings.$EnumSwitchMapping$0[r0.ordinal()];
        if (r1 == 1) goto L10;
        if (r1 != 2) goto L8;
        return "&rarr;";
    L8:
        throw new NoWhenBranchMatchedException();
    L10:
        return escape("->");
    }

    public final DescriptorRendererOptionsImpl getOptions() {
        return this.options;
    }

    public DescriptorRendererImpl(DescriptorRendererOptionsImpl r2) {
        Intrinsics.checkNotNullParameter(r2, "options");
        this.options = r2;
        r2.isLocked();
        this.functionTypeAnnotationsRenderer$delegate = LazyKt.lazy(new DescriptorRendererImpl$$Lambda$0(this));
    }

    private final String escape(String r2) {
        return getTextFormat().escape(r2);
    }

    private static final DescriptorRendererImpl functionTypeAnnotationsRenderer_delegate$lambda$1(DescriptorRendererImpl r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        DescriptorRenderer r2 = r1.withOptions(DescriptorRendererImpl$.Lambda.5.INSTANCE);
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type org.jetbrains.kotlin.renderer.DescriptorRendererImpl");
        return (DescriptorRendererImpl) r2;
    }

    private static final Unit functionTypeAnnotationsRenderer_delegate$lambda$1$lambda$0(DescriptorRendererOptions r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$withOptions");
        r4.setExcludedTypeAnnotationClasses(SetsKt.plus(r4.getExcludedTypeAnnotationClasses(), CollectionsKt.listOf(new FqName[]{StandardNames.FqNames.extensionFunctionType, StandardNames.FqNames.contextFunctionTypeParams})));
        return Unit.INSTANCE;
    }

    private final boolean hasModifiersOrAnnotations(KotlinType r2) {
        if (FunctionTypesKt.isSuspendFunctionType(r2) == false) goto L5;
    L8:
        return true;
    L5:
        if (r2.getAnnotations().isEmpty() == false) goto L8;
        return false;
    }

    private final Modality implicitModalityWithoutExtensions(MemberDescriptor r4) {
        if ((r4 instanceof ClassDescriptor) == true) goto L5;
        DeclarationDescriptor r0 = r4.getContainingDeclaration();
        if ((r0 instanceof ClassDescriptor) == false) goto L12;
        ClassDescriptor r1 = (ClassDescriptor) r0;
    L13:
        if (r1 != null) goto L17;
        return Modality.FINAL;
    L17:
        if ((r4 instanceof CallableMemberDescriptor) == false) goto L19;
        CallableMemberDescriptor r5 = (CallableMemberDescriptor) r4;
        if ((!r5.getOverriddenDescriptors().isEmpty()) == false) goto L27;
        if (r1.getModality() == Modality.FINAL) goto L27;
        return Modality.OPEN;
    L27:
        if (r1.getKind() != ClassKind.INTERFACE) goto L35;
        if (Intrinsics.areEqual(r5.getVisibility(), DescriptorVisibilities.PRIVATE) == true) goto L35;
        Modality r6 = r5.getModality();
        Modality r2 = Modality.ABSTRACT;
        if (r6 != r2) goto L37;
        return r2;
    L37:
        return Modality.OPEN;
    L35:
        return Modality.FINAL;
    L19:
        return Modality.FINAL;
    L12:
        r1 = null;
        goto L13
    L5:
        if (((ClassDescriptor) r4).getKind() != ClassKind.INTERFACE) goto L8;
        return Modality.ABSTRACT;
    L8:
        return Modality.FINAL;
    }

    private final boolean isParameterName(AnnotationDescriptor r2) {
        return Intrinsics.areEqual(r2.getFqName(), StandardNames.FqNames.parameterName);
    }

    private final boolean overridesSomething(CallableMemberDescriptor r1) {
        return !r1.getOverriddenDescriptors().isEmpty();
    }

    private final List<String> renderAndSortAnnotationArguments(AnnotationDescriptor r8) {
        Map r0 = r8.getAllValueArguments();
        List r2 = null;
        if (getRenderDefaultAnnotationArguments() == false) goto L5;
        ClassDescriptor r9 = DescriptorUtilsKt.getAnnotationClass(r8);
    L7:
        if (r9 == null) goto L23;
        ClassConstructorDescriptor r10 = r9.getUnsubstitutedPrimaryConstructor();
        if (r10 == null) goto L23;
        List<ValueParameterDescriptor> r11 = r10.getValueParameters();
        if (r11 == null) goto L23;
        ArrayList r3 = new ArrayList();
        Iterator<T> r12 = r11.iterator();
    L14:
        if (r12.hasNext() == false) goto L18;
        Object r4 = r12.next();
        if (((ValueParameterDescriptor) r4).declaresDefaultValue() == false) goto L14;
        r3.add(r4);
        goto L14
    L18:
        ArrayList r13 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
        Iterator r5 = r3.iterator();
    L20:
        if (r5.hasNext() == false) goto L22;
        r13.add(((ValueParameterDescriptor) r5.next()).getName());
        goto L20
    L22:
        r2 = r13;
    L23:
        if (r2 != null) goto L25;
        r2 = CollectionsKt.emptyList();
    L25:
        ArrayList r6 = new ArrayList();
        Iterator r14 = r2.iterator();
    L27:
        if (r14.hasNext() == false) goto L31;
        Object r7 = r14.next();
        if ((!r0.containsKey((Name) r7)) == false) goto L27;
        r6.add(r7);
        goto L27
    L31:
        ArrayList r15 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
        Iterator r16 = r6.iterator();
    L33:
        if (r16.hasNext() == false) goto L35;
        r15.add(((Name) r16.next()).asString() + " = ...");
        goto L33
    L35:
        Set r1 = r0.entrySet();
        ArrayList r17 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator r18 = r1.iterator();
    L37:
        if (r18.hasNext() == false) goto L44;
        Map.Entry r19 = (Map.Entry) r18.next();
        Name r20 = (Name) r19.getKey();
        ConstantValue<?> r21 = (ConstantValue) r19.getValue();
        StringBuilder r22 = new StringBuilder();
        r22.append(r20.asString());
        r22.append(" = ");
        if (r2.contains(r20) == true) goto L41;
        String r23 = renderConstant(r21);
    L42:
        r22.append(r23);
        r17.add(r22.toString());
        goto L37
    L41:
        r23 = "...";
        goto L42
    L44:
        return CollectionsKt.sorted(CollectionsKt.plus(r15, r17));
    L5:
        r9 = null;
        goto L7
    }

    private final String renderConstant(ConstantValue<?> r10) {
        Function1<ConstantValue<?>, String> r0 = this.options.getPropertyConstantRenderer();
        if (r0 == null) goto L7;
        return (String) r0.invoke(r10);
    L7:
        if ((r10 instanceof ArrayValue) == false) goto L16;
        Iterable r11 = (Iterable) ((ArrayValue) r10).getValue();
        ArrayList r1 = new ArrayList();
        Iterator r12 = r11.iterator();
    L10:
        if (r12.hasNext() == false) goto L39;
        String r2 = renderConstant((ConstantValue) r12.next());
        if (r2 == null) goto L10;
        r1.add(r2);
        goto L10
    L39:
        return CollectionsKt.joinToString$default(r1, ", ", "{", "}", 0, null, null, 56, null);
    L16:
        if ((r10 instanceof AnnotationValue) == false) goto L19;
        return StringsKt.removePrefix(DescriptorRenderer.renderAnnotation$default(this, (AnnotationDescriptor) ((AnnotationValue) r10).getValue(), null, 2, null), "@");
    L19:
        if ((r10 instanceof KClassValue) == false) goto L32;
        KClassValue.Value.LocalClass r13 = (KClassValue.Value) ((KClassValue) r10).getValue();
        if ((r13 instanceof KClassValue.Value.LocalClass) == false) goto L24;
        return r13.getType() + "::class";
    L24:
        if ((r13 instanceof KClassValue.Value.NormalClass) == false) goto L30;
        KClassValue.Value.NormalClass r14 = (KClassValue.Value.NormalClass) r13;
        String r3 = r14.getClassId().asSingleFqName().asString();
        int r4 = 0;
    L26:
        if (r4 >= r14.getArrayDimensions()) goto L42;
        r3 = "kotlin.Array<" + r3 + '>';
        r4 = r4 + 1;
        goto L26
    L42:
        return r3 + "::class";
    L30:
        throw new NoWhenBranchMatchedException();
    L32:
        return r10.toString();
    }

    private final String renderError(String r3) {
        int r0 = WhenMappings.$EnumSwitchMapping$0[getTextFormat().ordinal()];
        if (r0 != 1) goto L5;
        return r3;
    L5:
        if (r0 != 2) goto L8;
        return "<font color=red><b>" + r3 + "</b></font>";
    L8:
        throw new NoWhenBranchMatchedException();
    }

    private final String renderForReceiver(KotlinType r3) {
        String r0 = renderType(r3);
        if (shouldRenderAsPrettyFunctionType(r3) == false) goto L7;
        if (TypeUtils.isNullableType(r3) == true) goto L7;
    L9:
        return "(" + r0 + ')';
    L7:
        if ((r3 instanceof DefinitelyNotNullType) == true) goto L9;
        return r0;
    }

    private final String renderKeyword(String r3) {
        int r0 = WhenMappings.$EnumSwitchMapping$0[getTextFormat().ordinal()];
        if (r0 != 1) goto L5;
        return r3;
    L5:
        if (r0 != 2) goto L11;
        if (getBoldOnlyForNamesInHtml() == false) goto L13;
        return r3;
    L13:
        return "<b>" + r3 + "</b>";
    L11:
        throw new NoWhenBranchMatchedException();
    }

    private final void renderSpaceIfNeeded(StringBuilder r3) {
        int r0 = r3.length();
        if (r0 != 0) goto L5;
    L6:
        r3.append(' ');
        return;
    L5:
        if (r3.charAt(r0 - 1) != ' ') goto L6;
    }

    private static final Object renderTypeConstructor$lambda$6(KotlinType r1) {
        Intrinsics.checkNotNullParameter(r1, "it");
        if ((r1 instanceof StubTypeForBuilderInference) == true) goto L5;
        return r1;
    L5:
        return ((StubTypeForBuilderInference) r1).getOriginalTypeVariable();
    }

    private final boolean shouldRenderAsPrettyFunctionType(KotlinType r4) {
        if (FunctionTypesKt.isBuiltinFunctionalType(r4) == false) goto L21;
        List<TypeProjection> r5 = r4.getArguments();
        if ((r5 instanceof Collection) == true) goto L7;
    L9:
        Iterator<T> r6 = r5.iterator();
    L11:
        if (r6.hasNext() == false) goto L8;
        if (((TypeProjection) r6.next()).isStarProjection() == false) goto L11;
        boolean r7 = false;
    L15:
        if (r7 == false) goto L22;
        return true;
    L22:
        return false;
    L8:
        r7 = true;
        goto L15
    L7:
        if (r5.isEmpty() == false) goto L9;
    L21:
        return false;
    }

    private final boolean shouldRenderParameterNames(boolean r5) {
        ParameterNameRenderingPolicy r0 = getParameterNameRenderingPolicy();
        int r1 = WhenMappings.$EnumSwitchMapping$1[r0.ordinal()];
        if (r1 != 1) goto L5;
        return true;
    L5:
        if (r1 != 2) goto L7;
        if (r5 == false) goto L14;
    L8:
        return false;
    L14:
        return true;
    L7:
        if (r1 == 3) goto L8;
        throw new NoWhenBranchMatchedException();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer
    public String render(DeclarationDescriptor r3) {
        Intrinsics.checkNotNullParameter(r3, "declarationDescriptor");
        StringBuilder r0 = new StringBuilder();
        r3.accept(new RenderDeclarationDescriptorVisitor(this), r0);
        if (getWithDefinedIn() == false) goto L6;
        appendDefinedIn(r0, r3);
    L6:
        return r0.toString();
    }

    public String renderClassifierName(ClassifierDescriptor r2) {
        Intrinsics.checkNotNullParameter(r2, "klass");
        if (ErrorUtils.isError(r2) == false) goto L6;
        return r2.getTypeConstructor().toString();
    L6:
        return getClassifierNamePolicy().renderClassifier(r2, this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer
    public String renderFqName(FqNameUnsafe r2) {
        Intrinsics.checkNotNullParameter(r2, "fqName");
        return renderFqName(r2.pathSegments());
    }

    public String renderMessage(String r3) {
        Intrinsics.checkNotNullParameter(r3, "message");
        int r0 = WhenMappings.$EnumSwitchMapping$0[getTextFormat().ordinal()];
        if (r0 != 1) goto L5;
        return r3;
    L5:
        if (r0 != 2) goto L8;
        return "<i>" + r3 + "</i>";
    L8:
        throw new NoWhenBranchMatchedException();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer
    public String renderType(KotlinType r3) {
        Intrinsics.checkNotNullParameter(r3, EffectConfiguration.KEY_TYPE);
        StringBuilder r0 = new StringBuilder();
        renderNormalizedType(r0, (KotlinType) getTypeNormalizer().invoke(r3));
        return r0.toString();
    }

    public String renderTypeArguments(List<? extends TypeProjection> r3) {
        Intrinsics.checkNotNullParameter(r3, "typeArguments");
        if (r3.isEmpty() == false) goto L5;
        return "";
    L5:
        StringBuilder r0 = new StringBuilder();
        r0.append(lt());
        appendTypeProjections(r0, r3);
        r0.append(gt());
        return r0.toString();
    }

    public String renderTypeConstructor(TypeConstructor r4) {
        Intrinsics.checkNotNullParameter(r4, "typeConstructor");
        ClassifierDescriptor r0 = r4.getDeclarationDescriptor();
        if ((r0 instanceof TypeParameterDescriptor) == true) goto L17;
        if ((r0 instanceof ClassDescriptor) == true) goto L17;
        if ((r0 instanceof TypeAliasDescriptor) == true) goto L17;
        if (r0 != null) goto L15;
        if ((r4 instanceof IntersectionTypeConstructor) == false) goto L19;
        return ((IntersectionTypeConstructor) r4).makeDebugNameForIntersectionType(DescriptorRendererImpl$.Lambda.1.INSTANCE);
    L19:
        return r4.toString();
    L15:
        throw new IllegalStateException(("Unexpected classifier: " + r0.getClass()).toString());
    L17:
        return renderClassifierName(r0);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer
    public String renderTypeProjection(TypeProjection r2) {
        Intrinsics.checkNotNullParameter(r2, "typeProjection");
        StringBuilder r0 = new StringBuilder();
        appendTypeProjections(r0, CollectionsKt.listOf(r2));
        return r0.toString();
    }

    private final String renderFqName(List<Name> r1) {
        return escape(RenderingUtilsKt.renderFqName(r1));
    }

    private final void appendDefinedIn(StringBuilder r5, DeclarationDescriptor r6) {
        if ((r6 instanceof PackageFragmentDescriptor) == false) goto L5;
        return;
    L5:
        if ((r6 instanceof PackageViewDescriptor) == true) goto L32;
        DeclarationDescriptor r0 = r6.getContainingDeclaration();
        if (r0 != null) goto L10;
        return;
    L10:
        if ((r0 instanceof ModuleDescriptor) == true) goto L27;
        r5.append(" ");
        r5.append(renderMessage("defined in"));
        r5.append(" ");
        FqNameUnsafe r2 = DescriptorUtils.getFqName(r0);
        if (r2.isRoot() == false) goto L14;
        String r3 = "root package";
    L15:
        r5.append(r3);
        if (getWithSourceFileForTopLevel() == true) goto L18;
        return;
    L18:
        if ((r0 instanceof PackageFragmentDescriptor) == true) goto L20;
        return;
    L20:
        if ((r6 instanceof DeclarationDescriptorWithSource) == false) goto L30;
        String r7 = ((DeclarationDescriptorWithSource) r6).getSource().getContainingFile().getName();
        if (r7 == null) goto L31;
        r5.append(" ");
        r5.append(renderMessage("in file"));
        r5.append(" ");
        r5.append(r7);
        return;
    L31:
        return;
    L30:
        return;
    L14:
        r3 = renderFqName(r2);
        goto L15
    L27:
        return;
    }

    private final void appendTypeProjections(StringBuilder r11, List<? extends TypeProjection> r12) {
        CollectionsKt.joinTo$default(r12, r11, ", ", null, null, 0, null, new DescriptorRendererImpl$.Lambda.2(this), 60, null);
    }

    private static final CharSequence appendTypeProjections$lambda$8(DescriptorRendererImpl r2, TypeProjection r3) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        Intrinsics.checkNotNullParameter(r3, "it");
        if (r3.isStarProjection() == false) goto L5;
        return "*";
    L5:
        String r4 = r2.renderType(r3.getType());
        if (r3.getProjectionKind() != Variance.INVARIANT) goto L9;
        return r4;
    L9:
        return r3.getProjectionKind() + ' ' + r4;
    }

    private final void renderAbbreviatedTypeExpansion(StringBuilder r3, AbbreviatedType r4) {
        RenderingFormat r0 = getTextFormat();
        RenderingFormat r1 = RenderingFormat.HTML;
        if (r0 != r1) goto L5;
        r3.append("<font color=\"808080\"><i>");
    L5:
        r3.append(" /* = ");
        renderNormalizedTypeAsIs(r3, r4.getExpandedType());
        r3.append(" */");
        if (getTextFormat() != r1) goto L9;
        r3.append("</i></font>");
        return;
    }

    private final void renderAccessorModifiers(PropertyAccessorDescriptor r1, StringBuilder r2) {
        renderMemberModifiers(r1, r2);
    }

    private final void renderAdditionalModifiers(FunctionDescriptor r6, StringBuilder r7) {
        boolean r1 = false;
        if (r6.isOperator() == false) goto L17;
        Collection<? extends FunctionDescriptor> r0 = r6.getOverriddenDescriptors();
        if (r0.isEmpty() == false) goto L7;
    L6:
        boolean r2 = true;
    L13:
        if (r2 == false) goto L15;
    L16:
        boolean r3 = true;
    L19:
        if (r6.isInfix() == false) goto L33;
        Collection<? extends FunctionDescriptor> r4 = r6.getOverriddenDescriptors();
        if (r4.isEmpty() == false) goto L23;
    L22:
        boolean r5 = true;
    L29:
        if (r5 == false) goto L31;
    L32:
        r1 = true;
        goto L33
    L31:
        if (getAlwaysRenderModifiers() == false) goto L33;
    L23:
        Iterator<T> r8 = r4.iterator();
    L25:
        if (r8.hasNext() == false) goto L22;
        if (((FunctionDescriptor) r8.next()).isInfix() == false) goto L25;
        r5 = false;
    L33:
        renderModifier(r7, r6.isTailrec(), "tailrec");
        renderSuspendModifier(r6, r7);
        renderModifier(r7, r6.isInline(), "inline");
        renderModifier(r7, r1, "infix");
        renderModifier(r7, r3, "operator");
        return;
    L15:
        if (getAlwaysRenderModifiers() == false) goto L17;
    L7:
        Iterator<T> r9 = r0.iterator();
    L9:
        if (r9.hasNext() == false) goto L6;
        if (((FunctionDescriptor) r9.next()).isOperator() == false) goto L9;
        r2 = false;
    L17:
        r3 = false;
        goto L19
    }

    private final void renderCapturedTypeParametersIfRequired(ClassifierDescriptorWithTypeParameters r4, StringBuilder r5) {
        List<TypeParameterDescriptor> r0 = r4.getDeclaredTypeParameters();
        List<TypeParameterDescriptor> r1 = r4.getTypeConstructor().getParameters();
        if (getVerbose() == true) goto L5;
        return;
    L5:
        if (r4.isInner() == true) goto L7;
        return;
    L7:
        if (r1.size() <= r0.size()) goto L12;
        r5.append(" /*captured type parameters: ");
        renderTypeParameterList(r5, r1.subList(r0.size(), r1.size()));
        r5.append("*/");
        return;
    }

    private final void renderClass(ClassDescriptor r11, StringBuilder r12) {
        if (r11.getKind() != ClassKind.ENUM_ENTRY) goto L5;
        boolean r0 = true;
    L7:
        if (getStartFromName() == true) goto L52;
        renderAnnotations$default(this, r12, r11, null, 2, null);
        renderContextReceivers(r11.getContextReceivers(), r12);
        if (r0 == true) goto L12;
        renderVisibility(r11.getVisibility(), r12);
    L12:
        if (r11.getKind() != ClassKind.INTERFACE) goto L16;
        if (r11.getModality() != Modality.ABSTRACT) goto L16;
    L20:
        renderMemberModifiers(r11, r12);
        if (getModifiers().contains(DescriptorRendererModifier.INNER) == true) goto L23;
    L25:
        boolean r1 = false;
    L26:
        renderModifier(r12, r1, "inner");
        if (getModifiers().contains(DescriptorRendererModifier.DATA) == true) goto L29;
    L31:
        boolean r2 = false;
    L32:
        renderModifier(r12, r2, "data");
        if (getModifiers().contains(DescriptorRendererModifier.INLINE) == true) goto L35;
    L37:
        boolean r3 = false;
    L38:
        renderModifier(r12, r3, "inline");
        if (getModifiers().contains(DescriptorRendererModifier.VALUE) == true) goto L41;
    L43:
        boolean r4 = false;
    L44:
        renderModifier(r12, r4, "value");
        if (getModifiers().contains(DescriptorRendererModifier.FUN) == true) goto L47;
    L49:
        boolean r5 = false;
    L50:
        renderModifier(r12, r5, "fun");
        renderClassKindPrefix(r11, r12);
        goto L52
    L47:
        if (r11.isFun() == false) goto L49;
        r5 = true;
        goto L50
    L41:
        if (r11.isValue() == false) goto L43;
        r4 = true;
        goto L44
    L35:
        if (r11.isInline() == false) goto L37;
        r3 = true;
        goto L38
    L29:
        if (r11.isData() == false) goto L31;
        r2 = true;
        goto L32
    L23:
        if (r11.isInner() == false) goto L25;
        r1 = true;
    L16:
        if (r11.getKind().isSingleton() == true) goto L18;
    L19:
        renderModality(r11.getModality(), r12, implicitModalityWithoutExtensions(r11));
        goto L20
    L18:
        if (r11.getModality() == Modality.FINAL) goto L20;
    L52:
        if (DescriptorUtils.isCompanionObject(r11) == false) goto L54;
        renderCompanionObjectName(r11, r12);
    L58:
        if (r0 == false) goto L60;
        return;
    L60:
        List<TypeParameterDescriptor> r6 = r11.getDeclaredTypeParameters();
        renderTypeParameters(r6, r12, false);
        renderCapturedTypeParametersIfRequired(r11, r12);
        if (r11.getKind().isSingleton() == false) goto L63;
    L67:
        renderSuperTypes(r11, r12);
        renderWhereSuffix(r6, r12);
        return;
    L63:
        if (getClassWithPrimaryConstructor() == false) goto L67;
        ClassConstructorDescriptor r7 = r11.getUnsubstitutedPrimaryConstructor();
        if (r7 == null) goto L67;
        r12.append(" ");
        renderAnnotations$default(this, r12, r7, null, 2, null);
        renderVisibility(r7.getVisibility(), r12);
        r12.append(renderKeyword("constructor"));
        renderValueParameters(r7.getValueParameters(), r7.hasSynthesizedParameterNames(), r12);
        goto L67
    L54:
        if (getStartFromName() == true) goto L56;
        renderSpaceIfNeeded(r12);
    L56:
        renderName(r11, r12, true);
        goto L58
    L5:
        r0 = false;
        goto L7
    }

    private final void renderClassKindPrefix(ClassDescriptor r2, StringBuilder r3) {
        r3.append(renderKeyword(DescriptorRenderer.Companion.getClassifierKindPrefix(r2)));
    }

    private final void renderCompanionObjectName(DeclarationDescriptor r3, StringBuilder r4) {
        if (getRenderCompanionObjectName() == false) goto L11;
        if (getStartFromName() == false) goto L7;
        r4.append("companion object");
    L7:
        renderSpaceIfNeeded(r4);
        DeclarationDescriptor r0 = r3.getContainingDeclaration();
        if (r0 == null) goto L11;
        r4.append("of ");
        r4.append(renderName(r0.getName(), false));
    L11:
        if (getVerbose() == true) goto L15;
        if (Intrinsics.areEqual(r3.getName(), SpecialNames.DEFAULT_NAME_FOR_COMPANION_OBJECT) == false) goto L15;
        return;
    L15:
        if (getStartFromName() == true) goto L17;
        renderSpaceIfNeeded(r4);
    L17:
        r4.append(renderName(r3.getName(), true));
    }

    private final void renderConstructor(ConstructorDescriptor r13, StringBuilder r14) {
        renderAnnotations$default(this, r14, r13, null, 2, null);
        if (this.options.getRenderDefaultVisibility() == true) goto L7;
        if (r13.getConstructedClass().getModality() != Modality.SEALED) goto L7;
    L9:
        boolean r0 = false;
    L10:
        renderMemberKind(r13, r14);
        if (getRenderConstructorKeyword() == false) goto L13;
    L17:
        boolean r1 = true;
    L18:
        if (r1 == false) goto L20;
        r14.append(renderKeyword("constructor"));
    L20:
        ClassifierDescriptorWithTypeParameters r3 = r13.getContainingDeclaration();
        if (getSecondaryConstructorsAsPrimary() == false) goto L25;
        if (r1 == false) goto L24;
        r14.append(" ");
    L24:
        renderName(r3, r14, true);
        renderTypeParameters(r13.getTypeParameters(), r14, false);
    L25:
        renderValueParameters(r13.getValueParameters(), r13.hasSynthesizedParameterNames(), r14);
        if (getRenderConstructorDelegation() == false) goto L48;
        if (r13.isPrimary() == true) goto L48;
        if ((r3 instanceof ClassDescriptor) == false) goto L48;
        ClassConstructorDescriptor r2 = ((ClassDescriptor) r3).getUnsubstitutedPrimaryConstructor();
        if (r2 == null) goto L48;
        List<ValueParameterDescriptor> r4 = r2.getValueParameters();
        ArrayList r5 = new ArrayList();
        Iterator<T> r6 = r4.iterator();
    L35:
        if (r6.hasNext() == false) goto L45;
        Object r7 = r6.next();
        ValueParameterDescriptor r8 = (ValueParameterDescriptor) r7;
        if (r8.declaresDefaultValue() == false) goto L39;
    L41:
        boolean r9 = false;
    L42:
        if (r9 == false) goto L35;
        r5.add(r7);
        goto L35
    L39:
        if (r8.getVarargElementType() != null) goto L41;
        r9 = true;
        goto L42
    L45:
        if ((!r5.isEmpty()) == false) goto L48;
        r14.append(" : ");
        r14.append(renderKeyword("this"));
        r14.append(CollectionsKt.joinToString$default(r5, ", ", "(", ")", 0, null, DescriptorRendererImpl$.Lambda.3.INSTANCE, 24, null));
    L48:
        if (getSecondaryConstructorsAsPrimary() == false) goto L56;
        renderWhereSuffix(r13.getTypeParameters(), r14);
        return;
    L56:
        return;
    L13:
        if (r13.isPrimary() == false) goto L17;
        if (r0 == true) goto L17;
        r1 = false;
    L7:
        if (renderVisibility(r13.getVisibility(), r14) == false) goto L9;
        r0 = true;
        goto L10
    }

    private final void renderContextReceivers(List<? extends ReceiverParameterDescriptor> r6, StringBuilder r7) {
        if ((!r6.isEmpty()) == false) goto L12;
        r7.append("context(");
        Iterator<T> r0 = r6.iterator();
        int r1 = 0;
    L6:
        if (r0.hasNext() == false) goto L16;
        int r2 = r1 + 1;
        ReceiverParameterDescriptor r3 = (ReceiverParameterDescriptor) r0.next();
        renderAnnotations(r7, r3, AnnotationUseSiteTarget.RECEIVER);
        r7.append(renderForReceiver(r3.getType()));
        if (r1 != CollectionsKt.getLastIndex(r6)) goto L10;
        r7.append(") ");
    L11:
        r1 = r2;
        goto L6
    L10:
        r7.append(", ");
        goto L11
    L16:
        return;
    }

    private final void renderDefaultType(StringBuilder r8, KotlinType r9) {
        renderAnnotations$default(this, r8, r9, null, 2, null);
        SimpleType r1 = null;
        if ((r9 instanceof DefinitelyNotNullType) == false) goto L5;
        DefinitelyNotNullType r0 = (DefinitelyNotNullType) r9;
    L6:
        if (r0 == null) goto L9;
        r1 = r0.getOriginal();
    L9:
        if (KotlinTypeKt.isError(r9) == false) goto L23;
        if (TypeUtilsKt.isUnresolvedType(r9) == false) goto L16;
        if (getPresentableUnresolvedTypes() == false) goto L16;
        r8.append(renderError(ErrorUtils.INSTANCE.unresolvedTypeAsItIs(r9)));
    L30:
        if (r9.isMarkedNullable() == false) goto L33;
        r8.append("?");
    L33:
        if (SpecialTypesKt.isDefinitelyNotNullType(r9) == false) goto L36;
        r8.append(" & Any");
        return;
    L36:
        return;
    L16:
        if ((r9 instanceof ErrorType) == true) goto L18;
    L20:
        r8.append(r9.getConstructor().toString());
    L21:
        r8.append(renderTypeArguments(r9.getArguments()));
        goto L30
    L18:
        if (getInformativeErrorType() == true) goto L20;
        r8.append(((ErrorType) r9).getDebugMessage());
        goto L21
    L23:
        if ((r9 instanceof StubTypeForBuilderInference) == false) goto L26;
        r8.append(((StubTypeForBuilderInference) r9).getOriginalTypeVariable().toString());
        goto L30
    L26:
        if ((r1 instanceof StubTypeForBuilderInference) == false) goto L28;
        r8.append(((StubTypeForBuilderInference) r1).getOriginalTypeVariable().toString());
        goto L30
    L28:
        renderTypeConstructorAndArguments$default(this, r8, r9, null, 2, null);
        Unit r2 = Unit.INSTANCE;
        goto L30
    L5:
        r0 = null;
        goto L6
    }

    private final void renderFunction(FunctionDescriptor r9, StringBuilder r10) {
        if (getStartFromName() == false) goto L5;
    L22:
        renderName(r9, r10, true);
        renderValueParameters(r9.getValueParameters(), r9.hasSynthesizedParameterNames(), r10);
        renderReceiverAfterName(r9, r10);
        KotlinType r0 = r9.getReturnType();
        if (getWithoutReturnType() == false) goto L25;
    L34:
        renderWhereSuffix(r9.getTypeParameters(), r10);
        return;
    L25:
        if (getUnitReturnType() == true) goto L29;
        if (r0 == null) goto L29;
        if (KotlinBuiltIns.isUnit(r0) == true) goto L34;
    L29:
        r10.append(": ");
        if (r0 != null) goto L32;
        String r1 = "[NULL]";
    L33:
        r10.append(r1);
        goto L34
    L32:
        r1 = renderType(r0);
        goto L33
    L5:
        if (getStartFromDeclarationKeyword() == true) goto L21;
        renderAnnotations$default(this, r10, r9, null, 2, null);
        renderContextReceivers(r9.getContextReceiverParameters(), r10);
        renderVisibility(r9.getVisibility(), r10);
        renderModalityForCallable(r9, r10);
        if (getIncludeAdditionalModifiers() == false) goto L9;
        renderMemberModifiers(r9, r10);
    L9:
        renderOverride(r9, r10);
        if (getIncludeAdditionalModifiers() == false) goto L12;
        renderAdditionalModifiers(r9, r10);
    L13:
        renderMemberKind(r9, r10);
        if (getVerbose() == false) goto L21;
        if (r9.isHiddenToOvercomeSignatureClash() == false) goto L19;
        r10.append("/*isHiddenToOvercomeSignatureClash*/ ");
    L19:
        if (r9.isHiddenForResolutionEverywhereBesideSupercalls() == false) goto L21;
        r10.append("/*isHiddenForResolutionEverywhereBesideSupercalls*/ ");
        goto L21
    L12:
        renderSuspendModifier(r9, r10);
    L21:
        r10.append(renderKeyword("fun"));
        r10.append(" ");
        renderTypeParameters(r9.getTypeParameters(), r10, true);
        renderReceiver(r9, r10);
        goto L22
    }

    private final void renderFunctionType(StringBuilder r12, KotlinType r13) {
        int r0 = r12.length();
        renderAnnotations$default(getFunctionTypeAnnotationsRenderer(), r12, r13, null, 2, null);
        if (r12.length() == r0) goto L5;
        boolean r1 = true;
    L6:
        KotlinType r4 = FunctionTypesKt.getReceiverTypeFromFunctionType(r13);
        List r5 = FunctionTypesKt.getContextReceiverTypesFromFunctionType(r13);
        if ((!r5.isEmpty()) == false) goto L13;
        r12.append("context(");
        Iterator r6 = r5.subList(0, CollectionsKt.getLastIndex(r5)).iterator();
    L10:
        if (r6.hasNext() == false) goto L12;
        renderNormalizedType(r12, (KotlinType) r6.next());
        r12.append(", ");
        goto L10
    L12:
        renderNormalizedType(r12, (KotlinType) CollectionsKt.last(r5));
        r12.append(") ");
    L13:
        boolean r7 = FunctionTypesKt.isSuspendFunctionType(r13);
        boolean r8 = r13.isMarkedNullable();
        if (r8 == true) goto L19;
        if (r1 == false) goto L18;
        if (r4 != null) goto L19;
    L18:
        boolean r9 = false;
    L21:
        if (r9 == false) goto L29;
        if (r7 == false) goto L24;
        r12.insert(r0, '(');
        goto L29
    L24:
        if (r1 == false) goto L28;
        CharsKt.isWhitespace(StringsKt.last(r12));
        if (r12.charAt(StringsKt.getLastIndex(r12) - 1) == ')') goto L28;
        r12.insert(StringsKt.getLastIndex(r12), "()");
    L28:
        r12.append("(");
    L29:
        renderModifier(r12, r7, "suspend");
        if (r4 != null) goto L32;
    L48:
        r12.append("(");
        if (FunctionTypesKt.isBuiltinExtensionFunctionalType(r13) == true) goto L51;
    L53:
        Iterator r2 = FunctionTypesKt.getValueParameterTypesFromFunctionType(r13).iterator();
        int r3 = 0;
    L55:
        if (r2.hasNext() == false) goto L66;
        int r10 = r3 + 1;
        TypeProjection r11 = (TypeProjection) r2.next();
        if (r3 <= 0) goto L60;
        r12.append(", ");
    L60:
        if (getParameterNamesInFunctionalTypes() == false) goto L62;
        Name r14 = FunctionTypesKt.extractParameterNameFromFunctionTypeArgument(r11.getType());
    L63:
        if (r14 == null) goto L65;
        r12.append(renderName(r14, false));
        r12.append(": ");
    L65:
        r12.append(renderTypeProjection(r11));
        r3 = r10;
        goto L55
    L62:
        r14 = null;
    L66:
        r12.append(") ");
        r12.append(arrow());
        r12.append(" ");
        renderNormalizedType(r12, FunctionTypesKt.getReturnTypeFromFunctionType(r13));
        if (r9 == false) goto L69;
        r12.append(")");
    L69:
        if (r8 == false) goto L76;
        r12.append("?");
        return;
    L76:
        return;
    L51:
        if (r13.getArguments().size() > 1) goto L53;
        r12.append("???");
        goto L66
    L32:
        if (shouldRenderAsPrettyFunctionType(r4) == false) goto L36;
        if (r4.isMarkedNullable() == true) goto L36;
    L41:
        boolean r15 = true;
    L42:
        if (r15 == false) goto L44;
        r12.append("(");
    L44:
        renderNormalizedType(r12, r4);
        if (r15 == false) goto L47;
        r12.append(")");
    L47:
        r12.append(".");
    L36:
        if (hasModifiersOrAnnotations(r4) == true) goto L41;
        if ((r4 instanceof DefinitelyNotNullType) == true) goto L41;
        r15 = false;
    L19:
        r9 = true;
        goto L21
    L5:
        r1 = false;
        goto L6
    }

    private final void renderInitializer(VariableDescriptor r2, StringBuilder r3) {
        if (getIncludePropertyConstant() == false) goto L10;
        ConstantValue<?> r4 = r2.mo377getCompileTimeInitializer();
        if (r4 == null) goto L11;
        String r5 = renderConstant(r4);
        if (r5 == null) goto L12;
        r3.append(" = ");
        r3.append(escape(r5));
        return;
    L12:
        return;
    L11:
        return;
    }

    private final void renderMemberKind(CallableMemberDescriptor r3, StringBuilder r4) {
        if (getModifiers().contains(DescriptorRendererModifier.MEMBER_KIND) == true) goto L6;
        return;
    L6:
        if (getVerbose() == true) goto L8;
        return;
    L8:
        if (r3.getKind() == CallableMemberDescriptor.Kind.DECLARATION) goto L12;
        r4.append("/*");
        r4.append(CapitalizeDecapitalizeKt.toLowerCaseAsciiOnly(r3.getKind().name()));
        r4.append("*/ ");
        return;
    }

    private final void renderMemberModifiers(MemberDescriptor r5, StringBuilder r6) {
        renderModifier(r6, r5.isExternal(), "external");
        boolean r1 = true;
        if (getModifiers().contains(DescriptorRendererModifier.EXPECT) == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        renderModifier(r6, r0, "expect");
        if (getModifiers().contains(DescriptorRendererModifier.ACTUAL) == true) goto L11;
    L13:
        r1 = false;
    L14:
        renderModifier(r6, r1, "actual");
        return;
    L11:
        if (r5.isActual() == false) goto L13;
    L5:
        if (r5.isExpect() == false) goto L7;
        r0 = true;
        goto L8
    }

    private final void renderModalityForCallable(CallableMemberDescriptor r3, StringBuilder r4) {
        if (DescriptorUtils.isTopLevelDeclaration(r3) == false) goto L7;
        if (r3.getModality() != Modality.FINAL) goto L7;
        return;
    L7:
        if (getOverrideRenderingPolicy() == OverrideRenderingPolicy.RENDER_OVERRIDE) goto L9;
    L13:
        renderModality(r3.getModality(), r4, implicitModalityWithoutExtensions(r3));
        return;
    L9:
        if (r3.getModality() != Modality.OPEN) goto L13;
        if (overridesSomething(r3) == false) goto L13;
    }

    private final void renderNormalizedType(StringBuilder r3, KotlinType r4) {
        UnwrappedType r0 = r4.unwrap();
        if ((r0 instanceof AbbreviatedType) == false) goto L5;
        AbbreviatedType r1 = (AbbreviatedType) r0;
    L6:
        if (r1 != null) goto L8;
        renderNormalizedTypeAsIs(r3, r4);
        return;
    L8:
        if (getRenderTypeExpansions() == false) goto L10;
        renderNormalizedTypeAsIs(r3, r1.getExpandedType());
        return;
    L10:
        renderNormalizedTypeAsIs(r3, r1.getAbbreviation());
        if (getRenderUnabbreviatedType() == false) goto L17;
        renderAbbreviatedTypeExpansion(r3, r1);
        return;
    L17:
        return;
    L5:
        r1 = null;
        goto L6
    }

    private final void renderNormalizedTypeAsIs(StringBuilder r2, KotlinType r3) {
        if ((r3 instanceof WrappedType) == true) goto L5;
    L10:
        FlexibleType r4 = r3.unwrap();
        if ((r4 instanceof FlexibleType) == false) goto L14;
        r2.append(r4.render(this, this));
        return;
    L14:
        if ((r4 instanceof SimpleType) == false) goto L18;
        renderSimpleType(r2, (SimpleType) r4);
        return;
    L18:
        throw new NoWhenBranchMatchedException();
    L5:
        if (getDebugMode() == false) goto L10;
        if (((WrappedType) r3).isComputed() == true) goto L10;
        r2.append("<Not computed yet>");
    }

    private final void renderOverride(CallableMemberDescriptor r3, StringBuilder r4) {
        if (getModifiers().contains(DescriptorRendererModifier.OVERRIDE) == true) goto L6;
        return;
    L6:
        if (overridesSomething(r3) == true) goto L8;
        return;
    L8:
        if (getOverrideRenderingPolicy() == OverrideRenderingPolicy.RENDER_OPEN) goto L14;
        renderModifier(r4, true, "override");
        if (getVerbose() == false) goto L15;
        r4.append("/*");
        r4.append(r3.getOverriddenDescriptors().size());
        r4.append("*/ ");
        return;
    L15:
        return;
    }

    private final void renderPackageFragment(PackageFragmentDescriptor r3, StringBuilder r4) {
        renderPackageHeader(r3.getFqName(), "package-fragment", r4);
        if (getDebugMode() == false) goto L6;
        r4.append(" in ");
        renderName(r3.getContainingDeclaration(), r4, false);
        return;
    }

    private final void renderPackageView(PackageViewDescriptor r3, StringBuilder r4) {
        renderPackageHeader(r3.getFqName(), "package", r4);
        if (getDebugMode() == false) goto L6;
        r4.append(" in context of ");
        renderName(r3.getModule(), r4, false);
        return;
    }

    private final void renderPossiblyInnerType(StringBuilder r3, PossiblyInnerType r4) {
        PossiblyInnerType r0 = r4.getOuterType();
        if (r0 == null) goto L5;
        renderPossiblyInnerType(r3, r0);
        r3.append('.');
        r3.append(renderName(r4.getClassifierDescriptor().getName(), false));
    L6:
        r3.append(renderTypeArguments(r4.getArguments()));
        return;
    L5:
        r3.append(renderTypeConstructor(r4.getClassifierDescriptor().getTypeConstructor()));
        goto L6
    }

    private final void renderProperty(PropertyDescriptor r10, StringBuilder r11) {
        if (getStartFromName() == false) goto L5;
    L19:
        renderName(r10, r11, true);
        r11.append(": ");
        r11.append(renderType(r10.getType()));
        renderReceiverAfterName(r10, r11);
        renderInitializer(r10, r11);
        renderWhereSuffix(r10.getTypeParameters(), r11);
        return;
    L5:
        if (getStartFromDeclarationKeyword() == true) goto L18;
        renderPropertyAnnotations(r10, r11);
        renderContextReceivers(r10.getContextReceiverParameters(), r11);
        renderVisibility(r10.getVisibility(), r11);
        boolean r2 = false;
        if (getModifiers().contains(DescriptorRendererModifier.CONST) == true) goto L9;
    L11:
        boolean r0 = false;
    L12:
        renderModifier(r11, r0, "const");
        renderMemberModifiers(r10, r11);
        renderModalityForCallable(r10, r11);
        renderOverride(r10, r11);
        if (getModifiers().contains(DescriptorRendererModifier.LATEINIT) == true) goto L15;
    L17:
        renderModifier(r11, r2, "lateinit");
        renderMemberKind(r10, r11);
        goto L18
    L15:
        if (r10.isLateInit() == false) goto L17;
        r2 = true;
        goto L17
    L9:
        if (r10.isConst() == false) goto L11;
        r0 = true;
    L18:
        renderValVarPrefix$default(this, r10, r11, false, 4, null);
        renderTypeParameters(r10.getTypeParameters(), r11, true);
        renderReceiver(r10, r11);
        goto L19
    }

    private final void renderPropertyAnnotations(PropertyDescriptor r8, StringBuilder r9) {
        if (getModifiers().contains(DescriptorRendererModifier.ANNOTATIONS) == true) goto L5;
        return;
    L5:
        renderAnnotations$default(this, r9, r8, null, 2, null);
        FieldDescriptor r0 = r8.getBackingField();
        if (r0 == null) goto L8;
        renderAnnotations(r9, r0, AnnotationUseSiteTarget.FIELD);
    L8:
        FieldDescriptor r1 = r8.getDelegateField();
        if (r1 == null) goto L12;
        renderAnnotations(r9, r1, AnnotationUseSiteTarget.PROPERTY_DELEGATE_FIELD);
    L12:
        if (getPropertyAccessorRenderingPolicy() != PropertyAccessorRenderingPolicy.NONE) goto L20;
        PropertyGetterDescriptor r2 = r8.getGetter();
        if (r2 == null) goto L16;
        renderAnnotations(r9, r2, AnnotationUseSiteTarget.PROPERTY_GETTER);
    L16:
        PropertySetterDescriptor r10 = r8.getSetter();
        if (r10 == null) goto L21;
        renderAnnotations(r9, r10, AnnotationUseSiteTarget.PROPERTY_SETTER);
        ValueParameterDescriptor r11 = (ValueParameterDescriptor) CollectionsKt.single(r10.getValueParameters());
        Intrinsics.checkNotNull(r11);
        renderAnnotations(r9, r11, AnnotationUseSiteTarget.SETTER_PARAMETER);
        return;
    L21:
        return;
    }

    private final void renderReceiver(CallableDescriptor r2, StringBuilder r3) {
        ReceiverParameterDescriptor r4 = r2.getExtensionReceiverParameter();
        if (r4 == null) goto L6;
        renderAnnotations(r3, r4, AnnotationUseSiteTarget.RECEIVER);
        r3.append(renderForReceiver(r4.getType()));
        r3.append(".");
        return;
    }

    private final void renderReceiverAfterName(CallableDescriptor r2, StringBuilder r3) {
        if (getReceiverAfterName() == true) goto L5;
        return;
    L5:
        ReceiverParameterDescriptor r4 = r2.getExtensionReceiverParameter();
        if (r4 == null) goto L9;
        r3.append(" on ");
        r3.append(renderType(r4.getType()));
        return;
    }

    private final void renderSimpleType(StringBuilder r3, SimpleType r4) {
        if (Intrinsics.areEqual(r4, TypeUtils.CANNOT_INFER_FUNCTION_PARAM_TYPE) == false) goto L5;
    L23:
        r3.append("???");
        return;
    L5:
        if (TypeUtils.isDontCarePlaceholder(r4) == true) goto L23;
        if (ErrorUtils.isUninferredTypeVariable(r4) == false) goto L15;
        if (getUninferredTypeParameterAsName() == false) goto L12;
        TypeConstructor r5 = r4.getConstructor();
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type org.jetbrains.kotlin.types.error.ErrorTypeConstructor");
        r3.append(renderError(((ErrorTypeConstructor) r5).getParam(0)));
        return;
    L12:
        r3.append("???");
        return;
    L15:
        if (KotlinTypeKt.isError(r4) == false) goto L19;
        renderDefaultType(r3, r4);
        return;
    L19:
        if (shouldRenderAsPrettyFunctionType(r4) == false) goto L21;
        renderFunctionType(r3, r4);
        return;
    L21:
        renderDefaultType(r3, r4);
    }

    private final void renderSuperTypes(ClassDescriptor r12, StringBuilder r13) {
        if (getWithoutSuperTypes() == false) goto L6;
        return;
    L6:
        if (KotlinBuiltIns.isNothing(r12.getDefaultType()) == false) goto L8;
        return;
    L8:
        Collection<KotlinType> r14 = r12.getTypeConstructor().getSupertypes();
        if (r14.isEmpty() == false) goto L11;
        return;
    L11:
        if (r14.size() == 1) goto L13;
    L15:
        renderSpaceIfNeeded(r13);
        r13.append(": ");
        CollectionsKt.joinTo$default(r14, r13, ", ", null, null, 0, null, new DescriptorRendererImpl$.Lambda.4(this), 60, null);
        return;
    L13:
        if (KotlinBuiltIns.isAnyOrNullableAny(r14.iterator().next()) == false) goto L15;
    }

    private static final CharSequence renderSuperTypes$lambda$34(DescriptorRendererImpl r1, KotlinType r2) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        Intrinsics.checkNotNull(r2);
        return r1.renderType(r2);
    }

    private final void renderSuspendModifier(FunctionDescriptor r2, StringBuilder r3) {
        renderModifier(r3, r2.isSuspend(), "suspend");
    }

    private final void renderTypeAlias(TypeAliasDescriptor r7, StringBuilder r8) {
        renderAnnotations$default(this, r8, r7, null, 2, null);
        renderVisibility(r7.getVisibility(), r8);
        renderMemberModifiers(r7, r8);
        r8.append(renderKeyword("typealias"));
        r8.append(" ");
        renderName(r7, r8, true);
        renderTypeParameters(r7.getDeclaredTypeParameters(), r8, false);
        renderCapturedTypeParametersIfRequired(r7, r8);
        r8.append(" = ");
        r8.append(renderType(r7.getUnderlyingType()));
    }

    private final void renderTypeParameterList(StringBuilder r3, List<? extends TypeParameterDescriptor> r4) {
        Iterator<? extends TypeParameterDescriptor> r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L8;
        renderTypeParameter(r5.next(), r3, false);
        if (r5.hasNext() == false) goto L4;
        r3.append(", ");
        goto L4
    }

    private final boolean renderVisibility(DescriptorVisibility r3, StringBuilder r4) {
        if (getModifiers().contains(DescriptorRendererModifier.VISIBILITY) == true) goto L6;
        return false;
    L6:
        if (getNormalizedVisibilities() == false) goto L9;
        r3 = r3.normalize();
    L9:
        if (getRenderDefaultVisibility() == false) goto L11;
    L13:
        r4.append(renderKeyword(r3.getInternalDisplayName()));
        r4.append(" ");
        return true;
    L11:
        if (Intrinsics.areEqual(r3, DescriptorVisibilities.DEFAULT_VISIBILITY) == false) goto L13;
        return false;
    }

    private final void renderWhereSuffix(List<? extends TypeParameterDescriptor> r12, StringBuilder r13) {
        if (getWithoutTypeParameters() == false) goto L5;
        return;
    L5:
        ArrayList r1 = new ArrayList(0);
        Iterator<? extends TypeParameterDescriptor> r14 = r12.iterator();
    L7:
        if (r14.hasNext() == false) goto L13;
        TypeParameterDescriptor r2 = r14.next();
        Iterator r3 = CollectionsKt.drop(r2.getUpperBounds(), 1).iterator();
    L10:
        if (r3.hasNext() == false) goto L7;
        KotlinType r4 = (KotlinType) r3.next();
        StringBuilder r5 = new StringBuilder();
        r5.append(renderName(r2.getName(), false));
        r5.append(" : ");
        Intrinsics.checkNotNull(r4);
        r5.append(renderType(r4));
        r1.add(r5.toString());
        goto L10
    L13:
        if ((!r1.isEmpty()) == false) goto L18;
        r13.append(" ");
        r13.append(renderKeyword("where"));
        r13.append(" ");
        CollectionsKt.joinTo$default(r1, r13, ", ", null, null, 0, null, null, 124, null);
        return;
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer
    public String renderAnnotation(AnnotationDescriptor r12, AnnotationUseSiteTarget r13) {
        Intrinsics.checkNotNullParameter(r12, "annotation");
        StringBuilder r0 = new StringBuilder();
        r0.append('@');
        if (r13 == null) goto L5;
        r0.append(r13.getRenderName() + ':');
    L5:
        KotlinType r14 = r12.getType();
        r0.append(renderType(r14));
        if (getIncludeAnnotationArguments() == false) goto L13;
        List<String> r15 = renderAndSortAnnotationArguments(r12);
        if (getIncludeEmptyAnnotationArguments() == false) goto L10;
    L11:
        CollectionsKt.joinTo$default(r15, r0, ", ", "(", ")", 0, null, null, 112, null);
        goto L13
    L10:
        if ((!r15.isEmpty()) == true) goto L11;
    L13:
        if (getVerbose() == false) goto L20;
        if (KotlinTypeKt.isError(r14) == false) goto L17;
    L18:
        r0.append(" /* annotation class not found */");
        goto L20
    L17:
        if ((r14.getConstructor().getDeclarationDescriptor() instanceof NotFoundClasses.MockClassDescriptor) == true) goto L18;
    L20:
        return r0.toString();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer
    public String renderName(Name r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, DBDefinition.NAME);
        String r5 = escape(RenderingUtilsKt.render(r3));
        if (getBoldOnlyForNamesInHtml() == true) goto L5;
        return r5;
    L5:
        if (getTextFormat() != RenderingFormat.HTML) goto L10;
        if (r4 == true) goto L8;
        return r5;
    L8:
        return "<b>" + r5 + "</b>";
    L10:
        return r5;
    }

    public static final /* synthetic */ void access$renderAccessorModifiers(DescriptorRendererImpl r0, PropertyAccessorDescriptor r1, StringBuilder r2) {
        r0.renderAccessorModifiers(r1, r2);
    }

    public static final /* synthetic */ void access$renderClass(DescriptorRendererImpl r0, ClassDescriptor r1, StringBuilder r2) {
        r0.renderClass(r1, r2);
    }

    public static final /* synthetic */ void access$renderConstructor(DescriptorRendererImpl r0, ConstructorDescriptor r1, StringBuilder r2) {
        r0.renderConstructor(r1, r2);
    }

    public static final /* synthetic */ void access$renderFunction(DescriptorRendererImpl r0, FunctionDescriptor r1, StringBuilder r2) {
        r0.renderFunction(r1, r2);
    }

    public static final /* synthetic */ void access$renderPackageFragment(DescriptorRendererImpl r0, PackageFragmentDescriptor r1, StringBuilder r2) {
        r0.renderPackageFragment(r1, r2);
    }

    public static final /* synthetic */ void access$renderPackageView(DescriptorRendererImpl r0, PackageViewDescriptor r1, StringBuilder r2) {
        r0.renderPackageView(r1, r2);
    }

    public static final /* synthetic */ void access$renderProperty(DescriptorRendererImpl r0, PropertyDescriptor r1, StringBuilder r2) {
        r0.renderProperty(r1, r2);
    }

    public static final /* synthetic */ void access$renderTypeAlias(DescriptorRendererImpl r0, TypeAliasDescriptor r1, StringBuilder r2) {
        r0.renderTypeAlias(r1, r2);
    }

    private final void renderAnnotations(StringBuilder r6, Annotated r7, AnnotationUseSiteTarget r8) {
        if (getModifiers().contains(DescriptorRendererModifier.ANNOTATIONS) == true) goto L6;
        return;
    L6:
        if ((r7 instanceof KotlinType) == false) goto L8;
        Set<FqName> r0 = getExcludedTypeAnnotationClasses();
    L9:
        Function1<AnnotationDescriptor, Boolean> r1 = getAnnotationFilter();
        Iterator<AnnotationDescriptor> r9 = r7.getAnnotations().iterator();
    L11:
        if (r9.hasNext() == false) goto L23;
        AnnotationDescriptor r2 = r9.next();
        if (CollectionsKt.contains(r0, r2.getFqName()) == true) goto L11;
        if (isParameterName(r2) == true) goto L11;
        if (r1 == null) goto L19;
        if (((Boolean) r1.invoke(r2)).booleanValue() == false) goto L11;
    L19:
        r6.append(renderAnnotation(r2, r8));
        if (getEachAnnotationOnNewLine() == true) goto L21;
        r6.append(" ");
        goto L11
    L21:
        r6.append('\n');
        goto L11
    L23:
        return;
    L8:
        r0 = getExcludedAnnotationClasses();
        goto L9
    }

    private final void renderModality(Modality r2, StringBuilder r3, Modality r4) {
        if (getRenderDefaultModality() == true) goto L6;
        if (r2 != r4) goto L6;
        return;
    L6:
        renderModifier(r3, getModifiers().contains(DescriptorRendererModifier.MODALITY), CapitalizeDecapitalizeKt.toLowerCaseAsciiOnly(r2.name()));
    }

    private final void renderModifier(StringBuilder r1, boolean r2, String r3) {
        if (r2 == false) goto L5;
        r1.append(renderKeyword(r3));
        r1.append(" ");
        return;
    }

    private final void renderName(DeclarationDescriptor r1, StringBuilder r2, boolean r3) {
        r2.append(renderName(r1.getName(), r3));
    }

    private final void renderPackageHeader(FqName r1, String r2, StringBuilder r3) {
        r3.append(renderKeyword(r2));
        String r4 = renderFqName(r1.toUnsafe());
        if (r4.length() <= 0) goto L5;
        boolean r5 = true;
    L6:
        if (r5 == false) goto L9;
        r3.append(" ");
        r3.append(r4);
        return;
    L9:
        return;
    L5:
        r5 = false;
        goto L6
    }

    private final void renderTypeConstructorAndArguments(StringBuilder r2, KotlinType r3, TypeConstructor r4) {
        PossiblyInnerType r0 = TypeParameterUtilsKt.buildPossiblyInnerType(r3);
        if (r0 != null) goto L6;
        r2.append(renderTypeConstructor(r4));
        r2.append(renderTypeArguments(r3.getArguments()));
        return;
    L6:
        renderPossiblyInnerType(r2, r0);
    }

    private final void renderTypeParameter(TypeParameterDescriptor r11, StringBuilder r12, boolean r13) {
        if (r13 == false) goto L5;
        r12.append(lt());
    L5:
        if (getVerbose() == false) goto L7;
        r12.append("/*");
        r12.append(r11.getIndex());
        r12.append("*/ ");
    L7:
        renderModifier(r12, r11.isReified(), "reified");
        String r0 = r11.getVariance().getLabel();
        boolean r3 = true;
        if (r0.length() <= 0) goto L10;
        boolean r1 = true;
    L11:
        renderModifier(r12, r1, r0);
        renderAnnotations$default(this, r12, r11, null, 2, null);
        renderName(r11, r12, r13);
        int r2 = r11.getUpperBounds().size();
        if (r2 <= 1) goto L14;
        if (r13 == true) goto L14;
    L15:
        KotlinType r14 = r11.getUpperBounds().iterator().next();
        if (KotlinBuiltIns.isDefaultBound(r14) == true) goto L29;
        r12.append(" : ");
        Intrinsics.checkNotNull(r14);
        r12.append(renderType(r14));
    L29:
        if (r13 == false) goto L37;
        r12.append(gt());
        return;
    L37:
        return;
    L14:
        if (r2 == 1) goto L15;
        if (r13 == false) goto L29;
        Iterator<KotlinType> r15 = r11.getUpperBounds().iterator();
    L21:
        if (r15.hasNext() == false) goto L29;
        KotlinType r4 = r15.next();
        if (KotlinBuiltIns.isDefaultBound(r4) == true) goto L21;
        if (r3 == false) goto L27;
        r12.append(" : ");
    L28:
        Intrinsics.checkNotNull(r4);
        r12.append(renderType(r4));
        r3 = false;
        goto L21
    L27:
        r12.append(" & ");
        goto L28
    L10:
        r1 = false;
        goto L11
    }

    private final void renderTypeParameters(List<? extends TypeParameterDescriptor> r2, StringBuilder r3, boolean r4) {
        if (getWithoutTypeParameters() == false) goto L6;
        return;
    L6:
        if ((!r2.isEmpty()) == false) goto L11;
        r3.append(lt());
        renderTypeParameterList(r3, r2);
        r3.append(gt());
        if (r4 == false) goto L12;
        r3.append(" ");
        return;
    L12:
        return;
    }

    private final void renderValVarPrefix(VariableDescriptor r1, StringBuilder r2, boolean r3) {
        if (r3 == true) goto L6;
        if ((r1 instanceof ValueParameterDescriptor) == false) goto L6;
        return;
    L6:
        if (r1.isVar() == false) goto L8;
        String r4 = "var";
    L9:
        r2.append(renderKeyword(r4));
        r2.append(" ");
        return;
    L8:
        r4 = "val";
        goto L9
    }

    private final void renderValueParameters(Collection<? extends ValueParameterDescriptor> r7, boolean r8, StringBuilder r9) {
        boolean r10 = shouldRenderParameterNames(r8);
        int r0 = r7.size();
        getValueParametersHandler().appendBeforeValueParameters(r0, r9);
        Iterator<T> r11 = r7.iterator();
        int r2 = 0;
    L4:
        if (r11.hasNext() == false) goto L6;
        ValueParameterDescriptor r4 = (ValueParameterDescriptor) r11.next();
        getValueParametersHandler().appendBeforeValueParameter(r4, r2, r0, r9);
        renderValueParameter(r4, r10, r9, false);
        getValueParametersHandler().appendAfterValueParameter(r4, r2, r0, r9);
        r2 = r2 + 1;
        goto L4
    L6:
        getValueParametersHandler().appendAfterValueParameters(r0, r9);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer
    public String renderFlexibleType(String r8, String r9, KotlinBuiltIns r10) {
        Intrinsics.checkNotNullParameter(r8, "lowerRendered");
        Intrinsics.checkNotNullParameter(r9, "upperRendered");
        Intrinsics.checkNotNullParameter(r10, "builtIns");
        if (RenderingUtilsKt.typeStringsDifferOnlyInNullability(r8, r9) == true) goto L5;
        String r0 = StringsKt.substringBefore$default(getClassifierNamePolicy().renderClassifier(r10.getCollection(), this), "Collection", null, 2, null);
        String r4 = RenderingUtilsKt.replacePrefixesInTypeRepresentations(r8, r0 + "Mutable", r9, r0, r0 + "(Mutable)");
        if (r4 == null) goto L13;
        return r4;
    L13:
        String r1 = RenderingUtilsKt.replacePrefixesInTypeRepresentations(r8, r0 + "MutableMap.MutableEntry", r9, r0 + "Map.Entry", r0 + "(Mutable)Map.(Mutable)Entry");
        if (r1 == null) goto L16;
        return r1;
    L16:
        String r11 = StringsKt.substringBefore$default(getClassifierNamePolicy().renderClassifier(r10.getArray(), this), "Array", null, 2, null);
        String r12 = RenderingUtilsKt.replacePrefixesInTypeRepresentations(r8, r11 + escape("Array<"), r9, r11 + escape("Array<out "), r11 + escape("Array<(out) "));
        if (r12 == null) goto L20;
        return r12;
    L20:
        return "(" + r8 + DownloadConstants.VULNERABILITY_PATH + r9 + ')';
    L5:
        if (StringsKt.startsWith$default(r9, "(", false, 2, null) == false) goto L9;
        return "(" + r8 + ")!";
    L9:
        return r8 + '!';
    }

    public static final /* synthetic */ void access$renderName(DescriptorRendererImpl r0, DeclarationDescriptor r1, StringBuilder r2, boolean r3) {
        r0.renderName(r1, r2, r3);
    }

    public static final /* synthetic */ void access$renderTypeParameter(DescriptorRendererImpl r0, TypeParameterDescriptor r1, StringBuilder r2, boolean r3) {
        r0.renderTypeParameter(r1, r2, r3);
    }

    private final void renderValueParameter(ValueParameterDescriptor r10, boolean r11, StringBuilder r12, boolean r13) {
        if (r13 == false) goto L5;
        r12.append(renderKeyword("value-parameter"));
        r12.append(" ");
    L5:
        if (getVerbose() == false) goto L7;
        r12.append("/*");
        r12.append(r10.getIndex());
        r12.append("*/ ");
    L7:
        renderAnnotations$default(this, r12, r10, null, 2, null);
        renderModifier(r12, r10.isCrossinline(), "crossinline");
        renderModifier(r12, r10.isNoinline(), "noinline");
        boolean r1 = true;
        if (getRenderPrimaryConstructorParametersAsProperties() == false) goto L20;
        CallableDescriptor r0 = r10.getContainingDeclaration();
        if ((r0 instanceof ClassConstructorDescriptor) == false) goto L12;
        ClassConstructorDescriptor r2 = (ClassConstructorDescriptor) r0;
    L13:
        if (r2 != null) goto L15;
    L17:
        boolean r3 = false;
    L18:
        if (r3 == false) goto L20;
        boolean r8 = true;
    L21:
        if (r8 == false) goto L23;
        renderModifier(r12, getActualPropertiesInPrimaryConstructor(), "actual");
    L23:
        renderVariable(r10, r11, r12, r13, r8);
        if (getDefaultParameterValueRenderer() != null) goto L26;
    L31:
        r1 = false;
    L32:
        if (r1 == false) goto L35;
        StringBuilder r14 = new StringBuilder(" = ");
        Function1<ValueParameterDescriptor, String> r15 = getDefaultParameterValueRenderer();
        Intrinsics.checkNotNull(r15);
        r14.append((String) r15.invoke(r10));
        r12.append(r14.toString());
        return;
    L35:
        return;
    L26:
        if (getDebugMode() == false) goto L28;
        boolean r16 = r10.declaresDefaultValue();
    L29:
        if (r16 == false) goto L31;
    L28:
        r16 = DescriptorUtilsKt.declaresOrInheritsDefaultValue(r10);
        goto L29
    L15:
        if (r2.isPrimary() != true) goto L17;
        r3 = true;
        goto L18
    L12:
        r2 = null;
    L20:
        r8 = false;
        goto L21
    }

    public static final /* synthetic */ void access$renderValueParameter(DescriptorRendererImpl r0, ValueParameterDescriptor r1, boolean r2, StringBuilder r3, boolean r4) {
        r0.renderValueParameter(r1, r2, r3, r4);
    }

    private final void renderVariable(VariableDescriptor r6, boolean r7, StringBuilder r8, boolean r9, boolean r10) {
        KotlinType r0 = r6.getType();
        KotlinType r2 = null;
        if ((r6 instanceof ValueParameterDescriptor) == false) goto L5;
        ValueParameterDescriptor r1 = (ValueParameterDescriptor) r6;
    L6:
        if (r1 == null) goto L8;
        r2 = r1.getVarargElementType();
    L8:
        if (r2 != null) goto L10;
        KotlinType r3 = r0;
    L11:
        if (r2 == null) goto L13;
        boolean r4 = true;
    L14:
        renderModifier(r8, r4, "vararg");
        if (r10 == true) goto L19;
        if (r9 == true) goto L18;
    L20:
        if (r7 == false) goto L22;
        renderName(r6, r8, r9);
        r8.append(": ");
    L22:
        r8.append(renderType(r3));
        renderInitializer(r6, r8);
        if (getVerbose() == false) goto L27;
        if (r2 == null) goto L28;
        r8.append(" /*");
        r8.append(renderType(r0));
        r8.append("*/");
        return;
    L28:
        return;
    L27:
        return;
    L18:
        if (getStartFromName() == true) goto L20;
    L19:
        renderValVarPrefix(r6, r8, r10);
        goto L20
    L13:
        r4 = false;
        goto L14
    L10:
        r3 = r2;
        goto L11
    L5:
        r1 = null;
        goto L6
    }

    public static /* synthetic */ void renderAnnotations$default(DescriptorRendererImpl r0, StringBuilder r1, Annotated r2, AnnotationUseSiteTarget r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L5;
        r3 = null;
    L5:
        r0.renderAnnotations(r1, r2, r3);
    }

    public static /* synthetic */ void renderTypeConstructorAndArguments$default(DescriptorRendererImpl r0, StringBuilder r1, KotlinType r2, TypeConstructor r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L5;
        r3 = r2.getConstructor();
    L5:
        r0.renderTypeConstructorAndArguments(r1, r2, r3);
    }

    public static /* synthetic */ void renderValVarPrefix$default(DescriptorRendererImpl r0, VariableDescriptor r1, StringBuilder r2, boolean r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = false;
    L5:
        r0.renderValVarPrefix(r1, r2, r3);
    }
}
