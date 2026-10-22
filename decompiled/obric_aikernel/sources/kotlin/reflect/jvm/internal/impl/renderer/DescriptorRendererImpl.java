package kotlin.reflect.jvm.internal.impl.renderer;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.crash.tracker.ActivityLifecycle;
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
import kotlin.reflect.jvm.internal.impl.types.WrappedType;
import kotlin.reflect.jvm.internal.impl.types.checker.NewTypeVariableConstructor;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorType;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.reflect.jvm.internal.impl.util.capitalizeDecapitalize.CapitalizeDecapitalizeKt;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes3.dex */
public final class DescriptorRendererImpl extends DescriptorRenderer implements DescriptorRendererOptions {
    private final Lazy functionTypeAnnotationsRenderer$delegate;
    private final DescriptorRendererOptionsImpl options;

    private final class RenderDeclarationDescriptorVisitor implements DeclarationDescriptorVisitor<Unit, StringBuilder> {
        final /* synthetic */ DescriptorRendererImpl this$0;

        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

            static {
                int[] r10 = new int[PropertyAccessorRenderingPolicy.values().length];
                r10[PropertyAccessorRenderingPolicy.PRETTY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
            L11:
                r10[PropertyAccessorRenderingPolicy.DEBUG.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
            L15:
                r10[PropertyAccessorRenderingPolicy.NONE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
            L6:
                $EnumSwitchMapping$0 = r10;
            }
        }

        public RenderDeclarationDescriptorVisitor(DescriptorRendererImpl r10) {
            this.this$0 = r10;
        }

        private final void visitPropertyAccessorDescriptor(PropertyAccessorDescriptor r10, StringBuilder r11, String r12) {
            int r13 = WhenMappings.$EnumSwitchMapping$0[this.this$0.getPropertyAccessorRenderingPolicy().ordinal()];
            if (r13 != 1) goto L5;
            DescriptorRendererImpl.access$renderAccessorModifiers(this.this$0, r10, r11);
            r11.append(r12 + " for ");
            DescriptorRendererImpl r14 = this.this$0;
            PropertyDescriptor r15 = r10.getCorrespondingProperty();
            Intrinsics.checkNotNullExpressionValue(r15, "descriptor.correspondingProperty");
            DescriptorRendererImpl.access$renderProperty(r14, r15, r11);
            return;
        L5:
            if (r13 != 2) goto L11;
            visitFunctionDescriptor2(r10, r11);
            return;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ Unit visitClassDescriptor(ClassDescriptor r10, StringBuilder r11) {
            visitClassDescriptor2(r10, r11);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: visitClassDescriptor, reason: avoid collision after fix types in other method */
        public void visitClassDescriptor2(ClassDescriptor r10, StringBuilder r11) {
            Intrinsics.checkNotNullParameter(r10, "descriptor");
            Intrinsics.checkNotNullParameter(r11, "builder");
            DescriptorRendererImpl.access$renderClass(this.this$0, r10, r11);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ Unit visitConstructorDescriptor(ConstructorDescriptor r10, StringBuilder r11) {
            visitConstructorDescriptor2(r10, r11);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: visitConstructorDescriptor, reason: avoid collision after fix types in other method */
        public void visitConstructorDescriptor2(ConstructorDescriptor r10, StringBuilder r11) {
            Intrinsics.checkNotNullParameter(r10, "constructorDescriptor");
            Intrinsics.checkNotNullParameter(r11, "builder");
            DescriptorRendererImpl.access$renderConstructor(this.this$0, r10, r11);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ Unit visitFunctionDescriptor(FunctionDescriptor r10, StringBuilder r11) {
            visitFunctionDescriptor2(r10, r11);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: visitFunctionDescriptor, reason: avoid collision after fix types in other method */
        public void visitFunctionDescriptor2(FunctionDescriptor r10, StringBuilder r11) {
            Intrinsics.checkNotNullParameter(r10, "descriptor");
            Intrinsics.checkNotNullParameter(r11, "builder");
            DescriptorRendererImpl.access$renderFunction(this.this$0, r10, r11);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ Unit visitModuleDeclaration(ModuleDescriptor r10, StringBuilder r11) {
            visitModuleDeclaration2(r10, r11);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: visitModuleDeclaration, reason: avoid collision after fix types in other method */
        public void visitModuleDeclaration2(ModuleDescriptor r10, StringBuilder r11) {
            Intrinsics.checkNotNullParameter(r10, "descriptor");
            Intrinsics.checkNotNullParameter(r11, "builder");
            DescriptorRendererImpl.access$renderName(this.this$0, r10, r11, true);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ Unit visitPackageFragmentDescriptor(PackageFragmentDescriptor r10, StringBuilder r11) {
            visitPackageFragmentDescriptor2(r10, r11);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: visitPackageFragmentDescriptor, reason: avoid collision after fix types in other method */
        public void visitPackageFragmentDescriptor2(PackageFragmentDescriptor r10, StringBuilder r11) {
            Intrinsics.checkNotNullParameter(r10, "descriptor");
            Intrinsics.checkNotNullParameter(r11, "builder");
            DescriptorRendererImpl.access$renderPackageFragment(this.this$0, r10, r11);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ Unit visitPackageViewDescriptor(PackageViewDescriptor r10, StringBuilder r11) {
            visitPackageViewDescriptor2(r10, r11);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: visitPackageViewDescriptor, reason: avoid collision after fix types in other method */
        public void visitPackageViewDescriptor2(PackageViewDescriptor r10, StringBuilder r11) {
            Intrinsics.checkNotNullParameter(r10, "descriptor");
            Intrinsics.checkNotNullParameter(r11, "builder");
            DescriptorRendererImpl.access$renderPackageView(this.this$0, r10, r11);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ Unit visitPropertyDescriptor(PropertyDescriptor r10, StringBuilder r11) {
            visitPropertyDescriptor2(r10, r11);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: visitPropertyDescriptor, reason: avoid collision after fix types in other method */
        public void visitPropertyDescriptor2(PropertyDescriptor r10, StringBuilder r11) {
            Intrinsics.checkNotNullParameter(r10, "descriptor");
            Intrinsics.checkNotNullParameter(r11, "builder");
            DescriptorRendererImpl.access$renderProperty(this.this$0, r10, r11);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ Unit visitPropertyGetterDescriptor(PropertyGetterDescriptor r10, StringBuilder r11) {
            visitPropertyGetterDescriptor2(r10, r11);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: visitPropertyGetterDescriptor, reason: avoid collision after fix types in other method */
        public void visitPropertyGetterDescriptor2(PropertyGetterDescriptor r10, StringBuilder r11) {
            Intrinsics.checkNotNullParameter(r10, "descriptor");
            Intrinsics.checkNotNullParameter(r11, "builder");
            visitPropertyAccessorDescriptor(r10, r11, "getter");
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ Unit visitPropertySetterDescriptor(PropertySetterDescriptor r10, StringBuilder r11) {
            visitPropertySetterDescriptor2(r10, r11);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: visitPropertySetterDescriptor, reason: avoid collision after fix types in other method */
        public void visitPropertySetterDescriptor2(PropertySetterDescriptor r10, StringBuilder r11) {
            Intrinsics.checkNotNullParameter(r10, "descriptor");
            Intrinsics.checkNotNullParameter(r11, "builder");
            visitPropertyAccessorDescriptor(r10, r11, "setter");
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ Unit visitReceiverParameterDescriptor(ReceiverParameterDescriptor r10, StringBuilder r11) {
            visitReceiverParameterDescriptor2(r10, r11);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: visitReceiverParameterDescriptor, reason: avoid collision after fix types in other method */
        public void visitReceiverParameterDescriptor2(ReceiverParameterDescriptor r10, StringBuilder r11) {
            Intrinsics.checkNotNullParameter(r10, "descriptor");
            Intrinsics.checkNotNullParameter(r11, "builder");
            r11.append(r10.getName());
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ Unit visitTypeAliasDescriptor(TypeAliasDescriptor r10, StringBuilder r11) {
            visitTypeAliasDescriptor2(r10, r11);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: visitTypeAliasDescriptor, reason: avoid collision after fix types in other method */
        public void visitTypeAliasDescriptor2(TypeAliasDescriptor r10, StringBuilder r11) {
            Intrinsics.checkNotNullParameter(r10, "descriptor");
            Intrinsics.checkNotNullParameter(r11, "builder");
            DescriptorRendererImpl.access$renderTypeAlias(this.this$0, r10, r11);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ Unit visitTypeParameterDescriptor(TypeParameterDescriptor r10, StringBuilder r11) {
            visitTypeParameterDescriptor2(r10, r11);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: visitTypeParameterDescriptor, reason: avoid collision after fix types in other method */
        public void visitTypeParameterDescriptor2(TypeParameterDescriptor r10, StringBuilder r11) {
            Intrinsics.checkNotNullParameter(r10, "descriptor");
            Intrinsics.checkNotNullParameter(r11, "builder");
            DescriptorRendererImpl.access$renderTypeParameter(this.this$0, r10, r11, true);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ Unit visitValueParameterDescriptor(ValueParameterDescriptor r10, StringBuilder r11) {
            visitValueParameterDescriptor2(r10, r11);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: visitValueParameterDescriptor, reason: avoid collision after fix types in other method */
        public void visitValueParameterDescriptor2(ValueParameterDescriptor r10, StringBuilder r11) {
            Intrinsics.checkNotNullParameter(r10, "descriptor");
            Intrinsics.checkNotNullParameter(r11, "builder");
            DescriptorRendererImpl.access$renderValueParameter(this.this$0, r10, true, r11, true);
        }
    }

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1 = null;

        static {
            int[] r10 = new int[RenderingFormat.values().length];
            r10[RenderingFormat.PLAIN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L17:
            r10[RenderingFormat.HTML.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L6:
            $EnumSwitchMapping$0 = r10;
            int[] r11 = new int[ParameterNameRenderingPolicy.values().length];
            r11[ParameterNameRenderingPolicy.ALL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L25:
            r11[ParameterNameRenderingPolicy.ONLY_NON_SYNTHESIZED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L21:
            r11[ParameterNameRenderingPolicy.NONE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L10:
            $EnumSwitchMapping$1 = r11;
        }
    }

    public DescriptorRendererImpl(DescriptorRendererOptionsImpl r10) {
        Intrinsics.checkNotNullParameter(r10, "options");
        this.options = r10;
        r10.isLocked();
        this.functionTypeAnnotationsRenderer$delegate = LazyKt.lazy(new DescriptorRendererImpl$functionTypeAnnotationsRenderer$2(this));
    }

    public static final /* synthetic */ void access$renderAccessorModifiers(DescriptorRendererImpl r10, PropertyAccessorDescriptor r11, StringBuilder r12) {
        r10.renderAccessorModifiers(r11, r12);
    }

    public static final /* synthetic */ void access$renderClass(DescriptorRendererImpl r10, ClassDescriptor r11, StringBuilder r12) {
        r10.renderClass(r11, r12);
    }

    public static final /* synthetic */ String access$renderConstant(DescriptorRendererImpl r10, ConstantValue r11) {
        return r10.renderConstant(r11);
    }

    public static final /* synthetic */ void access$renderConstructor(DescriptorRendererImpl r10, ConstructorDescriptor r11, StringBuilder r12) {
        r10.renderConstructor(r11, r12);
    }

    public static final /* synthetic */ void access$renderFunction(DescriptorRendererImpl r10, FunctionDescriptor r11, StringBuilder r12) {
        r10.renderFunction(r11, r12);
    }

    public static final /* synthetic */ void access$renderName(DescriptorRendererImpl r10, DeclarationDescriptor r11, StringBuilder r12, boolean r13) {
        r10.renderName(r11, r12, r13);
    }

    public static final /* synthetic */ void access$renderPackageFragment(DescriptorRendererImpl r10, PackageFragmentDescriptor r11, StringBuilder r12) {
        r10.renderPackageFragment(r11, r12);
    }

    public static final /* synthetic */ void access$renderPackageView(DescriptorRendererImpl r10, PackageViewDescriptor r11, StringBuilder r12) {
        r10.renderPackageView(r11, r12);
    }

    public static final /* synthetic */ void access$renderProperty(DescriptorRendererImpl r10, PropertyDescriptor r11, StringBuilder r12) {
        r10.renderProperty(r11, r12);
    }

    public static final /* synthetic */ void access$renderTypeAlias(DescriptorRendererImpl r10, TypeAliasDescriptor r11, StringBuilder r12) {
        r10.renderTypeAlias(r11, r12);
    }

    public static final /* synthetic */ void access$renderTypeParameter(DescriptorRendererImpl r10, TypeParameterDescriptor r11, StringBuilder r12, boolean r13) {
        r10.renderTypeParameter(r11, r12, r13);
    }

    public static final /* synthetic */ void access$renderValueParameter(DescriptorRendererImpl r10, ValueParameterDescriptor r11, boolean r12, StringBuilder r13, boolean r14) {
        r10.renderValueParameter(r11, r12, r13, r14);
    }

    private final void appendDefinedIn(StringBuilder r10, DeclarationDescriptor r11) {
        if ((r11 instanceof PackageFragmentDescriptor) == false) goto L5;
        return;
    L5:
        if ((r11 instanceof PackageViewDescriptor) == true) goto L32;
        DeclarationDescriptor r12 = r11.getContainingDeclaration();
        if (r12 != null) goto L10;
        return;
    L10:
        if ((r12 instanceof ModuleDescriptor) == true) goto L27;
        r10.append(" ");
        r10.append(renderMessage("defined in"));
        r10.append(" ");
        FqNameUnsafe r13 = DescriptorUtils.getFqName(r12);
        Intrinsics.checkNotNullExpressionValue(r13, "getFqName(containingDeclaration)");
        if (r13.isRoot() == false) goto L14;
        String r14 = "root package";
    L15:
        r10.append(r14);
        if (getWithSourceFileForTopLevel() == true) goto L18;
        return;
    L18:
        if ((r12 instanceof PackageFragmentDescriptor) == true) goto L20;
        return;
    L20:
        if ((r11 instanceof DeclarationDescriptorWithSource) == false) goto L30;
        String r15 = ((DeclarationDescriptorWithSource) r11).getSource().getContainingFile().getName();
        if (r15 == null) goto L31;
        r10.append(" ");
        r10.append(renderMessage("in file"));
        r10.append(" ");
        r10.append(r15);
        return;
    L31:
        return;
    L30:
        return;
    L14:
        r14 = renderFqName(r13);
        goto L15
    L27:
        return;
    }

    private final void appendTypeProjections(StringBuilder r11, List<? extends TypeProjection> r12) {
        CollectionsKt.joinTo$default(r12, r11, ", ", null, null, 0, null, new AnonymousClass1(this), 60, null);
    }

    private final String arrow() {
        RenderingFormat r10 = getTextFormat();
        int r11 = WhenMappings.$EnumSwitchMapping$0[r10.ordinal()];
        if (r11 == 1) goto L10;
        if (r11 != 2) goto L8;
        return "&rarr;";
    L8:
        throw new NoWhenBranchMatchedException();
    L10:
        return escape("->");
    }

    private final boolean differsOnlyInNullability(String r10, String r11) {
        if (Intrinsics.areEqual(r10, StringsKt.replace$default(r11, "?", "", false, 4, null)) == false) goto L5;
    L10:
        return true;
    L5:
        if (StringsKt.endsWith$default(r11, "?", false, 2, null) == false) goto L9;
        if (Intrinsics.areEqual(r10 + '?', r11) == true) goto L10;
    L9:
        if (Intrinsics.areEqual('(' + r10 + ")?", r11) == true) goto L10;
        return false;
    }

    private final String escape(String r10) {
        return getTextFormat().escape(r10);
    }

    private final DescriptorRendererImpl getFunctionTypeAnnotationsRenderer() {
        return (DescriptorRendererImpl) this.functionTypeAnnotationsRenderer$delegate.getValue();
    }

    private final String gt() {
        return escape(">");
    }

    private final boolean hasModifiersOrAnnotations(KotlinType r10) {
        if (FunctionTypesKt.isSuspendFunctionType(r10) == false) goto L5;
    L8:
        return true;
    L5:
        if (r10.getAnnotations().isEmpty() == false) goto L8;
        return false;
    }

    private final Modality implicitModalityWithoutExtensions(MemberDescriptor r10) {
        if ((r10 instanceof ClassDescriptor) == true) goto L5;
        DeclarationDescriptor r11 = r10.getContainingDeclaration();
        if ((r11 instanceof ClassDescriptor) == false) goto L12;
        ClassDescriptor r12 = (ClassDescriptor) r11;
    L13:
        if (r12 != null) goto L17;
        return Modality.FINAL;
    L17:
        if ((r10 instanceof CallableMemberDescriptor) == false) goto L19;
        CallableMemberDescriptor r13 = (CallableMemberDescriptor) r10;
        Collection<? extends CallableMemberDescriptor> r14 = r13.getOverriddenDescriptors();
        Intrinsics.checkNotNullExpressionValue(r14, "this.overriddenDescriptors");
        if ((!r14.isEmpty()) == false) goto L27;
        if (r12.getModality() == Modality.FINAL) goto L27;
        return Modality.OPEN;
    L27:
        if (r12.getKind() != ClassKind.INTERFACE) goto L35;
        if (Intrinsics.areEqual(r13.getVisibility(), DescriptorVisibilities.PRIVATE) == true) goto L35;
        Modality r15 = r13.getModality();
        Modality r16 = Modality.ABSTRACT;
        if (r15 != r16) goto L37;
        return r16;
    L37:
        return Modality.OPEN;
    L35:
        return Modality.FINAL;
    L19:
        return Modality.FINAL;
    L12:
        r12 = null;
        goto L13
    L5:
        if (((ClassDescriptor) r10).getKind() != ClassKind.INTERFACE) goto L8;
        return Modality.ABSTRACT;
    L8:
        return Modality.FINAL;
    }

    private final boolean isParameterName(AnnotationDescriptor r10) {
        return Intrinsics.areEqual(r10.getFqName(), StandardNames.FqNames.parameterName);
    }

    private final String lt() {
        return escape("<");
    }

    private final boolean overridesSomething(CallableMemberDescriptor r10) {
        return !r10.getOverriddenDescriptors().isEmpty();
    }

    private final void renderAbbreviatedTypeExpansion(StringBuilder r10, AbbreviatedType r11) {
        RenderingFormat r12 = getTextFormat();
        RenderingFormat r13 = RenderingFormat.HTML;
        if (r12 != r13) goto L5;
        r10.append("<font color=\"808080\"><i>");
    L5:
        r10.append(" /* = ");
        renderNormalizedTypeAsIs(r10, r11.getExpandedType());
        r10.append(" */");
        if (getTextFormat() != r13) goto L9;
        r10.append("</i></font>");
        return;
    }

    private final void renderAccessorModifiers(PropertyAccessorDescriptor r10, StringBuilder r11) {
        renderMemberModifiers(r10, r11);
    }

    private final void renderAdditionalModifiers(FunctionDescriptor r10, StringBuilder r11) {
        boolean r12 = false;
        if (r10.isOperator() == false) goto L17;
        Collection<? extends FunctionDescriptor> r13 = r10.getOverriddenDescriptors();
        Intrinsics.checkNotNullExpressionValue(r13, "functionDescriptor.overriddenDescriptors");
        if (r13.isEmpty() == false) goto L7;
    L6:
        boolean r14 = true;
    L13:
        if (r14 == false) goto L15;
    L16:
        boolean r15 = true;
    L19:
        if (r10.isInfix() == false) goto L33;
        Collection<? extends FunctionDescriptor> r16 = r10.getOverriddenDescriptors();
        Intrinsics.checkNotNullExpressionValue(r16, "functionDescriptor.overriddenDescriptors");
        if (r16.isEmpty() == false) goto L23;
    L22:
        boolean r17 = true;
    L29:
        if (r17 == false) goto L31;
    L32:
        r12 = true;
        goto L33
    L31:
        if (getAlwaysRenderModifiers() == false) goto L33;
    L23:
        Iterator<T> r18 = r16.iterator();
    L25:
        if (r18.hasNext() == false) goto L22;
        if (((FunctionDescriptor) r18.next()).isInfix() == false) goto L25;
        r17 = false;
    L33:
        renderModifier(r11, r10.isTailrec(), "tailrec");
        renderSuspendModifier(r10, r11);
        renderModifier(r11, r10.isInline(), "inline");
        renderModifier(r11, r12, "infix");
        renderModifier(r11, r15, "operator");
        return;
    L15:
        if (getAlwaysRenderModifiers() == false) goto L17;
    L7:
        Iterator<T> r19 = r13.iterator();
    L9:
        if (r19.hasNext() == false) goto L6;
        if (((FunctionDescriptor) r19.next()).isOperator() == false) goto L9;
        r14 = false;
    L17:
        r15 = false;
        goto L19
    }

    private final List<String> renderAndSortAnnotationArguments(AnnotationDescriptor r10) {
        Map<Name, ConstantValue<?>> r11 = r10.getAllValueArguments();
        List r12 = null;
        if (getRenderDefaultAnnotationArguments() == false) goto L5;
        ClassDescriptor r13 = DescriptorUtilsKt.getAnnotationClass(r10);
    L7:
        if (r13 == null) goto L23;
        ClassConstructorDescriptor r14 = r13.mo1317getUnsubstitutedPrimaryConstructor();
        if (r14 == null) goto L23;
        List<ValueParameterDescriptor> r15 = r14.getValueParameters();
        if (r15 == null) goto L23;
        ArrayList r16 = new ArrayList();
        Iterator<T> r17 = r15.iterator();
    L14:
        if (r17.hasNext() == false) goto L18;
        Object r18 = r17.next();
        if (((ValueParameterDescriptor) r18).declaresDefaultValue() == false) goto L14;
        r16.add(r18);
        goto L14
    L18:
        ArrayList r19 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r16, 10));
        Iterator r20 = r16.iterator();
    L20:
        if (r20.hasNext() == false) goto L22;
        r19.add(((ValueParameterDescriptor) r20.next()).getName());
        goto L20
    L22:
        r12 = r19;
    L23:
        if (r12 != null) goto L25;
        r12 = CollectionsKt.emptyList();
    L25:
        ArrayList r21 = new ArrayList();
        Iterator r22 = r12.iterator();
    L27:
        if (r22.hasNext() == false) goto L31;
        Object r23 = r22.next();
        Name r24 = (Name) r23;
        Intrinsics.checkNotNullExpressionValue(r24, "it");
        if ((!r11.containsKey(r24)) == false) goto L27;
        r21.add(r23);
        goto L27
    L31:
        ArrayList r25 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r21, 10));
        Iterator r26 = r21.iterator();
    L33:
        if (r26.hasNext() == false) goto L35;
        r25.add(((Name) r26.next()).asString() + " = ...");
        goto L33
    L35:
        Set<Map.Entry<Name, ConstantValue<?>>> r27 = r11.entrySet();
        ArrayList r28 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r27, 10));
        Iterator<T> r29 = r27.iterator();
    L37:
        if (r29.hasNext() == false) goto L44;
        Map.Entry r30 = (Map.Entry) r29.next();
        Name r31 = (Name) r30.getKey();
        ConstantValue<?> r32 = (ConstantValue) r30.getValue();
        StringBuilder r33 = new StringBuilder();
        r33.append(r31.asString());
        r33.append(" = ");
        if (r12.contains(r31) == true) goto L41;
        String r34 = renderConstant(r32);
    L42:
        r33.append(r34);
        r28.add(r33.toString());
        goto L37
    L41:
        r34 = "...";
        goto L42
    L44:
        return CollectionsKt.sorted(CollectionsKt.plus(r25, r28));
    L5:
        r13 = null;
        goto L7
    }

    private final void renderAnnotations(StringBuilder r10, Annotated r11, AnnotationUseSiteTarget r12) {
        if (getModifiers().contains(DescriptorRendererModifier.ANNOTATIONS) == true) goto L6;
        return;
    L6:
        if ((r11 instanceof KotlinType) == false) goto L8;
        Set<FqName> r13 = getExcludedTypeAnnotationClasses();
    L9:
        Function1<AnnotationDescriptor, Boolean> r14 = getAnnotationFilter();
        Iterator<AnnotationDescriptor> r15 = r11.getAnnotations().iterator();
    L11:
        if (r15.hasNext() == false) goto L23;
        AnnotationDescriptor r16 = r15.next();
        if (CollectionsKt.contains(r13, r16.getFqName()) == true) goto L11;
        if (isParameterName(r16) == true) goto L11;
        if (r14 == null) goto L19;
        if (r14.invoke(r16).booleanValue() == false) goto L11;
    L19:
        r10.append(renderAnnotation(r16, r12));
        if (getEachAnnotationOnNewLine() == true) goto L21;
        r10.append(" ");
        goto L11
    L21:
        r10.append('\n');
        Intrinsics.checkNotNullExpressionValue(r10, "append('\\n')");
        goto L11
    L23:
        return;
    L8:
        r13 = getExcludedAnnotationClasses();
        goto L9
    }

    static /* synthetic */ void renderAnnotations$default(DescriptorRendererImpl r10, StringBuilder r11, Annotated r12, AnnotationUseSiteTarget r13, int r14, Object r15) {
        if ((r14 & 2) == 0) goto L5;
        r13 = null;
    L5:
        r10.renderAnnotations(r11, r12, r13);
    }

    private final void renderCapturedTypeParametersIfRequired(ClassifierDescriptorWithTypeParameters r10, StringBuilder r11) {
        List<TypeParameterDescriptor> r12 = r10.getDeclaredTypeParameters();
        Intrinsics.checkNotNullExpressionValue(r12, "classifier.declaredTypeParameters");
        List<TypeParameterDescriptor> r13 = r10.getTypeConstructor().getParameters();
        Intrinsics.checkNotNullExpressionValue(r13, "classifier.typeConstructor.parameters");
        if (getVerbose() == true) goto L5;
        return;
    L5:
        if (r10.isInner() == true) goto L7;
        return;
    L7:
        if (r13.size() <= r12.size()) goto L12;
        r11.append(" /*captured type parameters: ");
        renderTypeParameterList(r11, r13.subList(r12.size(), r13.size()));
        r11.append("*/");
        return;
    }

    private final void renderClass(ClassDescriptor r11, StringBuilder r12) {
        if (r11.getKind() != ClassKind.ENUM_ENTRY) goto L5;
        boolean r10 = true;
    L7:
        if (getStartFromName() == true) goto L52;
        renderAnnotations$default(this, r12, r11, null, 2, null);
        List<ReceiverParameterDescriptor> r13 = r11.getContextReceivers();
        Intrinsics.checkNotNullExpressionValue(r13, "klass.contextReceivers");
        renderContextReceivers(r13, r12);
        if (r10 == true) goto L12;
        DescriptorVisibility r14 = r11.getVisibility();
        Intrinsics.checkNotNullExpressionValue(r14, "klass.visibility");
        renderVisibility(r14, r12);
    L12:
        if (r11.getKind() != ClassKind.INTERFACE) goto L16;
        if (r11.getModality() != Modality.ABSTRACT) goto L16;
    L20:
        renderMemberModifiers(r11, r12);
        if (getModifiers().contains(DescriptorRendererModifier.INNER) == true) goto L23;
    L25:
        boolean r15 = false;
    L26:
        renderModifier(r12, r15, "inner");
        if (getModifiers().contains(DescriptorRendererModifier.DATA) == true) goto L29;
    L31:
        boolean r16 = false;
    L32:
        renderModifier(r12, r16, "data");
        if (getModifiers().contains(DescriptorRendererModifier.INLINE) == true) goto L35;
    L37:
        boolean r17 = false;
    L38:
        renderModifier(r12, r17, "inline");
        if (getModifiers().contains(DescriptorRendererModifier.VALUE) == true) goto L41;
    L43:
        boolean r18 = false;
    L44:
        renderModifier(r12, r18, EventBody.KEY_VALUE);
        if (getModifiers().contains(DescriptorRendererModifier.FUN) == true) goto L47;
    L49:
        boolean r19 = false;
    L50:
        renderModifier(r12, r19, "fun");
        renderClassKindPrefix(r11, r12);
        goto L52
    L47:
        if (r11.isFun() == false) goto L49;
        r19 = true;
        goto L50
    L41:
        if (r11.isValue() == false) goto L43;
        r18 = true;
        goto L44
    L35:
        if (r11.isInline() == false) goto L37;
        r17 = true;
        goto L38
    L29:
        if (r11.isData() == false) goto L31;
        r16 = true;
        goto L32
    L23:
        if (r11.isInner() == false) goto L25;
        r15 = true;
    L16:
        if (r11.getKind().isSingleton() == true) goto L18;
    L19:
        Modality r20 = r11.getModality();
        Intrinsics.checkNotNullExpressionValue(r20, "klass.modality");
        renderModality(r20, r12, implicitModalityWithoutExtensions(r11));
        goto L20
    L18:
        if (r11.getModality() == Modality.FINAL) goto L20;
    L52:
        if (DescriptorUtils.isCompanionObject(r11) == false) goto L54;
        renderCompanionObjectName(r11, r12);
    L58:
        if (r10 == false) goto L60;
        return;
    L60:
        List<TypeParameterDescriptor> r21 = r11.getDeclaredTypeParameters();
        Intrinsics.checkNotNullExpressionValue(r21, "klass.declaredTypeParameters");
        renderTypeParameters(r21, r12, false);
        renderCapturedTypeParametersIfRequired(r11, r12);
        if (r11.getKind().isSingleton() == false) goto L63;
    L67:
        renderSuperTypes(r11, r12);
        renderWhereSuffix(r21, r12);
        return;
    L63:
        if (getClassWithPrimaryConstructor() == false) goto L67;
        ClassConstructorDescriptor r22 = r11.mo1317getUnsubstitutedPrimaryConstructor();
        if (r22 == null) goto L67;
        r12.append(" ");
        renderAnnotations$default(this, r12, r22, null, 2, null);
        DescriptorVisibility r23 = r22.getVisibility();
        Intrinsics.checkNotNullExpressionValue(r23, "primaryConstructor.visibility");
        renderVisibility(r23, r12);
        r12.append(renderKeyword("constructor"));
        List<ValueParameterDescriptor> r24 = r22.getValueParameters();
        Intrinsics.checkNotNullExpressionValue(r24, "primaryConstructor.valueParameters");
        renderValueParameters(r24, r22.hasSynthesizedParameterNames(), r12);
        goto L67
    L54:
        if (getStartFromName() == true) goto L56;
        renderSpaceIfNeeded(r12);
    L56:
        renderName(r11, r12, true);
        goto L58
    L5:
        r10 = false;
        goto L7
    }

    private final void renderClassKindPrefix(ClassDescriptor r10, StringBuilder r11) {
        r11.append(renderKeyword(DescriptorRenderer.Companion.getClassifierKindPrefix(r10)));
    }

    private final void renderCompanionObjectName(DeclarationDescriptor r10, StringBuilder r11) {
        if (getRenderCompanionObjectName() == false) goto L11;
        if (getStartFromName() == false) goto L7;
        r11.append("companion object");
    L7:
        renderSpaceIfNeeded(r11);
        DeclarationDescriptor r12 = r10.getContainingDeclaration();
        if (r12 == null) goto L11;
        r11.append("of ");
        Name r13 = r12.getName();
        Intrinsics.checkNotNullExpressionValue(r13, "containingDeclaration.name");
        r11.append(renderName(r13, false));
    L11:
        if (getVerbose() == true) goto L15;
        if (Intrinsics.areEqual(r10.getName(), SpecialNames.DEFAULT_NAME_FOR_COMPANION_OBJECT) == false) goto L15;
        return;
    L15:
        if (getStartFromName() == true) goto L17;
        renderSpaceIfNeeded(r11);
    L17:
        Name r14 = r10.getName();
        Intrinsics.checkNotNullExpressionValue(r14, "descriptor.name");
        r11.append(renderName(r14, true));
    }

    private final String renderConstant(ConstantValue<?> r10) {
        if ((r10 instanceof ArrayValue) == false) goto L6;
        return CollectionsKt.joinToString$default(((ArrayValue) r10).getValue(), ", ", "{", "}", 0, null, new C04211(this), 24, null);
    L6:
        if ((r10 instanceof AnnotationValue) == false) goto L9;
        return StringsKt.removePrefix(DescriptorRenderer.renderAnnotation$default(this, ((AnnotationValue) r10).getValue(), null, 2, null), "@");
    L9:
        if ((r10 instanceof KClassValue) == false) goto L22;
        KClassValue.Value r11 = ((KClassValue) r10).getValue();
        if ((r11 instanceof KClassValue.Value.LocalClass) == false) goto L14;
        return ((KClassValue.Value.LocalClass) r11).getType() + "::class";
    L14:
        if ((r11 instanceof KClassValue.Value.NormalClass) == false) goto L20;
        KClassValue.Value.NormalClass r12 = (KClassValue.Value.NormalClass) r11;
        String r13 = r12.getClassId().asSingleFqName().asString();
        Intrinsics.checkNotNullExpressionValue(r13, "classValue.classId.asSingleFqName().asString()");
        int r14 = r12.getArrayDimensions();
        int r15 = 0;
    L16:
        if (r15 >= r14) goto L27;
        r13 = "kotlin.Array<" + r13 + Typography.greater;
        r15 = r15 + 1;
        goto L16
    L27:
        return r13 + "::class";
    L20:
        throw new NoWhenBranchMatchedException();
    L22:
        return r10.toString();
    }

    private final void renderConstructor(ConstructorDescriptor r18, StringBuilder r19) {
        renderAnnotations$default(this, r19, r18, null, 2, null);
        if (this.options.getRenderDefaultVisibility() == false) goto L5;
    L6:
        DescriptorVisibility r10 = r18.getVisibility();
        Intrinsics.checkNotNullExpressionValue(r10, "constructor.visibility");
        if (renderVisibility(r10, r19) == false) goto L9;
        boolean r11 = true;
    L10:
        renderMemberKind(r18, r19);
        if (getRenderConstructorKeyword() == false) goto L13;
    L17:
        boolean r12 = true;
    L18:
        if (r12 == false) goto L20;
        r19.append(renderKeyword("constructor"));
    L20:
        ClassifierDescriptorWithTypeParameters r13 = r18.getContainingDeclaration();
        Intrinsics.checkNotNullExpressionValue(r13, "constructor.containingDeclaration");
        if (getSecondaryConstructorsAsPrimary() == false) goto L25;
        if (r12 == false) goto L24;
        r19.append(" ");
    L24:
        renderName(r13, r19, true);
        List<TypeParameterDescriptor> r14 = r18.getTypeParameters();
        Intrinsics.checkNotNullExpressionValue(r14, "constructor.typeParameters");
        renderTypeParameters(r14, r19, false);
    L25:
        List<ValueParameterDescriptor> r15 = r18.getValueParameters();
        Intrinsics.checkNotNullExpressionValue(r15, "constructor.valueParameters");
        renderValueParameters(r15, r18.hasSynthesizedParameterNames(), r19);
        if (getRenderConstructorDelegation() == false) goto L48;
        if (r18.isPrimary() == true) goto L48;
        if ((r13 instanceof ClassDescriptor) == false) goto L48;
        ClassConstructorDescriptor r16 = ((ClassDescriptor) r13).mo1317getUnsubstitutedPrimaryConstructor();
        if (r16 == null) goto L48;
        List<ValueParameterDescriptor> r17 = r16.getValueParameters();
        Intrinsics.checkNotNullExpressionValue(r17, "primaryConstructor.valueParameters");
        ArrayList r20 = new ArrayList();
        Iterator<T> r21 = r17.iterator();
    L35:
        if (r21.hasNext() == false) goto L45;
        Object r22 = r21.next();
        ValueParameterDescriptor r23 = (ValueParameterDescriptor) r22;
        if (r23.declaresDefaultValue() == false) goto L39;
    L41:
        boolean r24 = false;
    L42:
        if (r24 == false) goto L35;
        r20.add(r22);
        goto L35
    L39:
        if (r23.getVarargElementType() != null) goto L41;
        r24 = true;
        goto L42
    L45:
        if ((!r20.isEmpty()) == false) goto L48;
        r19.append(" : ");
        r19.append(renderKeyword("this"));
        r19.append(CollectionsKt.joinToString$default(r20, ", ", "(", ")", 0, null, C04221.INSTANCE, 24, null));
    L48:
        if (getSecondaryConstructorsAsPrimary() == false) goto L56;
        List<TypeParameterDescriptor> r25 = r18.getTypeParameters();
        Intrinsics.checkNotNullExpressionValue(r25, "constructor.typeParameters");
        renderWhereSuffix(r25, r19);
        return;
    L56:
        return;
    L13:
        if (r18.isPrimary() == false) goto L17;
        if (r11 == true) goto L17;
        r12 = false;
    L9:
        r11 = false;
        goto L10
    L5:
        if (r18.getConstructedClass().getModality() == Modality.SEALED) goto L9;
        goto L6
    }

    private final void renderContextReceivers(List<? extends ReceiverParameterDescriptor> r10, StringBuilder r11) {
        if ((!r10.isEmpty()) == false) goto L12;
        r11.append("context(");
        Iterator<? extends ReceiverParameterDescriptor> r12 = r10.iterator();
        int r13 = 0;
    L6:
        if (r12.hasNext() == false) goto L16;
        int r14 = r13 + 1;
        ReceiverParameterDescriptor r15 = r12.next();
        renderAnnotations(r11, r15, AnnotationUseSiteTarget.RECEIVER);
        KotlinType r16 = r15.getType();
        Intrinsics.checkNotNullExpressionValue(r16, "contextReceiver.type");
        r11.append(renderForReceiver(r16));
        if (r13 != CollectionsKt.getLastIndex(r10)) goto L10;
        String r17 = ") ";
    L11:
        r11.append(r17);
        r13 = r14;
        goto L6
    L10:
        r17 = ", ";
        goto L11
    L16:
        return;
    }

    private final void renderDefaultType(StringBuilder r10, KotlinType r11) {
        renderAnnotations$default(this, r10, r11, null, 2, null);
        SimpleType r12 = null;
        if ((r11 instanceof DefinitelyNotNullType) == false) goto L5;
        DefinitelyNotNullType r13 = (DefinitelyNotNullType) r11;
    L6:
        if (r13 == null) goto L9;
        r12 = r13.getOriginal();
    L9:
        if (KotlinTypeKt.isError(r11) == false) goto L23;
        if (TypeUtilsKt.isUnresolvedType(r11) == false) goto L16;
        if (getPresentableUnresolvedTypes() == false) goto L16;
    L14:
        String r14 = ((ErrorType) r11).getDebugMessage();
    L21:
        r10.append(r14);
        String r15 = renderTypeArguments(r11.getArguments());
    L26:
        r10.append(r15);
    L32:
        if (r11.isMarkedNullable() == false) goto L35;
        r10.append("?");
    L35:
        if (SpecialTypesKt.isDefinitelyNotNullType(r11) == false) goto L38;
        r10.append(" & Any");
        return;
    L38:
        return;
    L16:
        if ((r11 instanceof ErrorType) == true) goto L18;
    L20:
        r14 = r11.getConstructor().toString();
        goto L21
    L18:
        if (getInformativeErrorType() == true) goto L20;
    L23:
        if ((r11 instanceof StubTypeForBuilderInference) == false) goto L28;
        NewTypeVariableConstructor r16 = ((StubTypeForBuilderInference) r11).getOriginalTypeVariable();
    L25:
        r15 = r16.toString();
        goto L26
    L28:
        if ((r12 instanceof StubTypeForBuilderInference) == false) goto L30;
        r16 = ((StubTypeForBuilderInference) r12).getOriginalTypeVariable();
        goto L25
    L30:
        renderTypeConstructorAndArguments$default(this, r10, r11, null, 2, null);
        goto L32
    L5:
        r13 = null;
        goto L6
    }

    private final String renderError(String r10) {
        int r11 = WhenMappings.$EnumSwitchMapping$0[getTextFormat().ordinal()];
        if (r11 != 1) goto L5;
        return r10;
    L5:
        if (r11 != 2) goto L8;
        return "<font color=red><b>" + r10 + "</b></font>";
    L8:
        throw new NoWhenBranchMatchedException();
    }

    private final String renderForReceiver(KotlinType r10) {
        String r11 = renderType(r10);
        if (shouldRenderAsPrettyFunctionType(r10) == true) goto L5;
        return r11;
    L5:
        if (TypeUtils.isNullableType(r10) == false) goto L7;
        return r11;
    L7:
        return '(' + r11 + ')';
    }

    private final String renderFqName(List<Name> r10) {
        return escape(RenderingUtilsKt.renderFqName(r10));
    }

    private final void renderFunction(FunctionDescriptor r10, StringBuilder r11) {
        if (getStartFromName() == false) goto L5;
    L22:
        renderName(r10, r11, true);
        List<ValueParameterDescriptor> r12 = r10.getValueParameters();
        Intrinsics.checkNotNullExpressionValue(r12, "function.valueParameters");
        renderValueParameters(r12, r10.hasSynthesizedParameterNames(), r11);
        renderReceiverAfterName(r10, r11);
        KotlinType r13 = r10.getReturnType();
        if (getWithoutReturnType() == false) goto L25;
    L34:
        List<TypeParameterDescriptor> r14 = r10.getTypeParameters();
        Intrinsics.checkNotNullExpressionValue(r14, "function.typeParameters");
        renderWhereSuffix(r14, r11);
        return;
    L25:
        if (getUnitReturnType() == true) goto L29;
        if (r13 == null) goto L29;
        if (KotlinBuiltIns.isUnit(r13) == true) goto L34;
    L29:
        r11.append(": ");
        if (r13 != null) goto L32;
        String r15 = "[NULL]";
    L33:
        r11.append(r15);
        goto L34
    L32:
        r15 = renderType(r13);
        goto L33
    L5:
        if (getStartFromDeclarationKeyword() == true) goto L21;
        renderAnnotations$default(this, r11, r10, null, 2, null);
        List<ReceiverParameterDescriptor> r16 = r10.getContextReceiverParameters();
        Intrinsics.checkNotNullExpressionValue(r16, "function.contextReceiverParameters");
        renderContextReceivers(r16, r11);
        DescriptorVisibility r17 = r10.getVisibility();
        Intrinsics.checkNotNullExpressionValue(r17, "function.visibility");
        renderVisibility(r17, r11);
        renderModalityForCallable(r10, r11);
        if (getIncludeAdditionalModifiers() == false) goto L9;
        renderMemberModifiers(r10, r11);
    L9:
        renderOverride(r10, r11);
        if (getIncludeAdditionalModifiers() == false) goto L12;
        renderAdditionalModifiers(r10, r11);
    L13:
        renderMemberKind(r10, r11);
        if (getVerbose() == false) goto L21;
        if (r10.isHiddenToOvercomeSignatureClash() == false) goto L19;
        r11.append("/*isHiddenToOvercomeSignatureClash*/ ");
    L19:
        if (r10.isHiddenForResolutionEverywhereBesideSupercalls() == false) goto L21;
        r11.append("/*isHiddenForResolutionEverywhereBesideSupercalls*/ ");
        goto L21
    L12:
        renderSuspendModifier(r10, r11);
    L21:
        r11.append(renderKeyword("fun"));
        r11.append(" ");
        List<TypeParameterDescriptor> r18 = r10.getTypeParameters();
        Intrinsics.checkNotNullExpressionValue(r18, "function.typeParameters");
        renderTypeParameters(r18, r11, true);
        renderReceiver(r10, r11);
        goto L22
    }

    private final void renderFunctionType(StringBuilder r12, KotlinType r13) {
        int r10 = r12.length();
        renderAnnotations$default(getFunctionTypeAnnotationsRenderer(), r12, r13, null, 2, null);
        if (r12.length() == r10) goto L5;
        boolean r11 = true;
    L6:
        KotlinType r14 = FunctionTypesKt.getReceiverTypeFromFunctionType(r13);
        List<KotlinType> r15 = FunctionTypesKt.getContextReceiverTypesFromFunctionType(r13);
        if ((!r15.isEmpty()) == false) goto L13;
        r12.append("context(");
        Iterator<KotlinType> r16 = r15.subList(0, CollectionsKt.getLastIndex(r15)).iterator();
    L10:
        if (r16.hasNext() == false) goto L12;
        renderNormalizedType(r12, r16.next());
        r12.append(", ");
        goto L10
    L12:
        renderNormalizedType(r12, (KotlinType) CollectionsKt.last(r15));
        r12.append(") ");
    L13:
        boolean r17 = FunctionTypesKt.isSuspendFunctionType(r13);
        boolean r18 = r13.isMarkedNullable();
        if (r18 == true) goto L19;
        if (r11 == false) goto L18;
        if (r14 != null) goto L19;
    L18:
        boolean r19 = false;
    L21:
        if (r19 == false) goto L29;
        if (r17 == false) goto L24;
        r12.insert(r10, '(');
        goto L29
    L24:
        if (r11 == false) goto L28;
        CharsKt.isWhitespace(StringsKt.last(r12));
        if (r12.charAt(StringsKt.getLastIndex(r12) - 1) == ')') goto L28;
        r12.insert(StringsKt.getLastIndex(r12), "()");
    L28:
        r12.append("(");
    L29:
        renderModifier(r12, r17, "suspend");
        if (r14 != null) goto L32;
    L45:
        r12.append("(");
        if (FunctionTypesKt.isBuiltinExtensionFunctionalType(r13) == true) goto L48;
    L50:
        Iterator<TypeProjection> r20 = FunctionTypesKt.getValueParameterTypesFromFunctionType(r13).iterator();
        int r21 = 0;
    L52:
        if (r20.hasNext() == false) goto L63;
        int r22 = r21 + 1;
        TypeProjection r23 = r20.next();
        if (r21 <= 0) goto L57;
        r12.append(", ");
    L57:
        if (getParameterNamesInFunctionalTypes() == false) goto L59;
        KotlinType r24 = r23.getType();
        Intrinsics.checkNotNullExpressionValue(r24, "typeProjection.type");
        Name r25 = FunctionTypesKt.extractParameterNameFromFunctionTypeArgument(r24);
    L60:
        if (r25 == null) goto L62;
        r12.append(renderName(r25, false));
        r12.append(": ");
    L62:
        r12.append(renderTypeProjection(r23));
        r21 = r22;
        goto L52
    L59:
        r25 = null;
    L63:
        r12.append(") ");
        r12.append(arrow());
        r12.append(" ");
        renderNormalizedType(r12, FunctionTypesKt.getReturnTypeFromFunctionType(r13));
        if (r19 == false) goto L66;
        r12.append(")");
    L66:
        if (r18 == false) goto L73;
        r12.append("?");
        return;
    L73:
        return;
    L48:
        if (r13.getArguments().size() > 1) goto L50;
        r12.append("???");
        goto L63
    L32:
        if (shouldRenderAsPrettyFunctionType(r14) == false) goto L36;
        if (r14.isMarkedNullable() == true) goto L36;
    L37:
        boolean r26 = true;
    L39:
        if (r26 == false) goto L41;
        r12.append("(");
    L41:
        renderNormalizedType(r12, r14);
        if (r26 == false) goto L44;
        r12.append(")");
    L44:
        r12.append(".");
    L36:
        if (hasModifiersOrAnnotations(r14) == true) goto L37;
        r26 = false;
    L19:
        r19 = true;
        goto L21
    L5:
        r11 = false;
        goto L6
    }

    private final void renderInitializer(VariableDescriptor r10, StringBuilder r11) {
        if (getIncludePropertyConstant() == false) goto L8;
        ConstantValue<?> r12 = r10.mo1319getCompileTimeInitializer();
        if (r12 == null) goto L9;
        r11.append(" = ");
        r11.append(escape(renderConstant(r12)));
        return;
    L9:
        return;
    }

    private final String renderKeyword(String r10) {
        int r11 = WhenMappings.$EnumSwitchMapping$0[getTextFormat().ordinal()];
        if (r11 != 1) goto L5;
        return r10;
    L5:
        if (r11 != 2) goto L11;
        if (getBoldOnlyForNamesInHtml() == false) goto L13;
        return r10;
    L13:
        return "<b>" + r10 + "</b>";
    L11:
        throw new NoWhenBranchMatchedException();
    }

    private final void renderMemberKind(CallableMemberDescriptor r10, StringBuilder r11) {
        if (getModifiers().contains(DescriptorRendererModifier.MEMBER_KIND) == true) goto L6;
        return;
    L6:
        if (getVerbose() == true) goto L8;
        return;
    L8:
        if (r10.getKind() == CallableMemberDescriptor.Kind.DECLARATION) goto L12;
        r11.append("/*");
        r11.append(CapitalizeDecapitalizeKt.toLowerCaseAsciiOnly(r10.getKind().name()));
        r11.append("*/ ");
        return;
    }

    private final void renderMemberModifiers(MemberDescriptor r10, StringBuilder r11) {
        renderModifier(r11, r10.isExternal(), "external");
        boolean r12 = true;
        if (getModifiers().contains(DescriptorRendererModifier.EXPECT) == true) goto L5;
    L7:
        boolean r13 = false;
    L8:
        renderModifier(r11, r13, "expect");
        if (getModifiers().contains(DescriptorRendererModifier.ACTUAL) == true) goto L11;
    L13:
        r12 = false;
    L14:
        renderModifier(r11, r12, "actual");
        return;
    L11:
        if (r10.isActual() == false) goto L13;
    L5:
        if (r10.isExpect() == false) goto L7;
        r13 = true;
        goto L8
    }

    private final void renderModality(Modality r10, StringBuilder r11, Modality r12) {
        if (getRenderDefaultModality() == true) goto L6;
        if (r10 != r12) goto L6;
        return;
    L6:
        renderModifier(r11, getModifiers().contains(DescriptorRendererModifier.MODALITY), CapitalizeDecapitalizeKt.toLowerCaseAsciiOnly(r10.name()));
    }

    private final void renderModalityForCallable(CallableMemberDescriptor r10, StringBuilder r11) {
        if (DescriptorUtils.isTopLevelDeclaration(r10) == false) goto L7;
        if (r10.getModality() != Modality.FINAL) goto L7;
        return;
    L7:
        if (getOverrideRenderingPolicy() == OverrideRenderingPolicy.RENDER_OVERRIDE) goto L9;
    L13:
        Modality r12 = r10.getModality();
        Intrinsics.checkNotNullExpressionValue(r12, "callable.modality");
        renderModality(r12, r11, implicitModalityWithoutExtensions(r10));
        return;
    L9:
        if (r10.getModality() != Modality.OPEN) goto L13;
        if (overridesSomething(r10) == false) goto L13;
    }

    private final void renderModifier(StringBuilder r10, boolean r11, String r12) {
        if (r11 == false) goto L5;
        r10.append(renderKeyword(r12));
        r10.append(" ");
        return;
    }

    private final void renderName(DeclarationDescriptor r10, StringBuilder r11, boolean r12) {
        Name r13 = r10.getName();
        Intrinsics.checkNotNullExpressionValue(r13, "descriptor.name");
        r11.append(renderName(r13, r12));
    }

    private final void renderNormalizedType(StringBuilder r10, KotlinType r11) {
        UnwrappedType r12 = r11.unwrap();
        if ((r12 instanceof AbbreviatedType) == false) goto L5;
        AbbreviatedType r13 = (AbbreviatedType) r12;
    L6:
        if (r13 != null) goto L8;
        renderNormalizedTypeAsIs(r10, r11);
        return;
    L8:
        if (getRenderTypeExpansions() == false) goto L10;
        renderNormalizedTypeAsIs(r10, r13.getExpandedType());
        return;
    L10:
        renderNormalizedTypeAsIs(r10, r13.getAbbreviation());
        if (getRenderUnabbreviatedType() == false) goto L17;
        renderAbbreviatedTypeExpansion(r10, r13);
        return;
    L17:
        return;
    L5:
        r13 = null;
        goto L6
    }

    private final void renderNormalizedTypeAsIs(StringBuilder r10, KotlinType r11) {
        if ((r11 instanceof WrappedType) == true) goto L5;
    L10:
        UnwrappedType r12 = r11.unwrap();
        if ((r12 instanceof FlexibleType) == false) goto L14;
        r10.append(((FlexibleType) r12).render(this, this));
        return;
    L14:
        if ((r12 instanceof SimpleType) == false) goto L18;
        renderSimpleType(r10, (SimpleType) r12);
        return;
    L18:
        return;
    L5:
        if (getDebugMode() == false) goto L10;
        if (((WrappedType) r11).isComputed() == true) goto L10;
        r10.append("<Not computed yet>");
    }

    private final void renderOverride(CallableMemberDescriptor r10, StringBuilder r11) {
        if (getModifiers().contains(DescriptorRendererModifier.OVERRIDE) == true) goto L6;
        return;
    L6:
        if (overridesSomething(r10) == true) goto L8;
        return;
    L8:
        if (getOverrideRenderingPolicy() == OverrideRenderingPolicy.RENDER_OPEN) goto L14;
        renderModifier(r11, true, "override");
        if (getVerbose() == false) goto L15;
        r11.append("/*");
        r11.append(r10.getOverriddenDescriptors().size());
        r11.append("*/ ");
        return;
    L15:
        return;
    }

    private final void renderPackageFragment(PackageFragmentDescriptor r10, StringBuilder r11) {
        renderPackageHeader(r10.getFqName(), "package-fragment", r11);
        if (getDebugMode() == false) goto L6;
        r11.append(" in ");
        renderName(r10.getContainingDeclaration(), r11, false);
        return;
    }

    private final void renderPackageHeader(FqName r10, String r11, StringBuilder r12) {
        r12.append(renderKeyword(r11));
        FqNameUnsafe r13 = r10.toUnsafe();
        Intrinsics.checkNotNullExpressionValue(r13, "fqName.toUnsafe()");
        String r14 = renderFqName(r13);
        if (r14.length() <= 0) goto L5;
        boolean r15 = true;
    L6:
        if (r15 == false) goto L9;
        r12.append(" ");
        r12.append(r14);
        return;
    L9:
        return;
    L5:
        r15 = false;
        goto L6
    }

    private final void renderPackageView(PackageViewDescriptor r10, StringBuilder r11) {
        renderPackageHeader(r10.getFqName(), "package", r11);
        if (getDebugMode() == false) goto L6;
        r11.append(" in context of ");
        renderName(r10.getModule(), r11, false);
        return;
    }

    private final void renderPossiblyInnerType(StringBuilder r10, PossiblyInnerType r11) {
        PossiblyInnerType r12 = r11.getOuterType();
        if (r12 == null) goto L5;
        renderPossiblyInnerType(r10, r12);
        r10.append('.');
        Name r13 = r11.getClassifierDescriptor().getName();
        Intrinsics.checkNotNullExpressionValue(r13, "possiblyInnerType.classifierDescriptor.name");
        String r14 = renderName(r13, false);
    L6:
        r10.append(r14);
        r10.append(renderTypeArguments(r11.getArguments()));
        return;
    L5:
        TypeConstructor r15 = r11.getClassifierDescriptor().getTypeConstructor();
        Intrinsics.checkNotNullExpressionValue(r15, "possiblyInnerType.classi…escriptor.typeConstructor");
        r14 = renderTypeConstructor(r15);
        goto L6
    }

    private final void renderProperty(PropertyDescriptor r11, StringBuilder r12) {
        if (getStartFromName() == false) goto L5;
    L19:
        renderName(r11, r12, true);
        r12.append(": ");
        KotlinType r10 = r11.getType();
        Intrinsics.checkNotNullExpressionValue(r10, "property.type");
        r12.append(renderType(r10));
        renderReceiverAfterName(r11, r12);
        renderInitializer(r11, r12);
        List<TypeParameterDescriptor> r13 = r11.getTypeParameters();
        Intrinsics.checkNotNullExpressionValue(r13, "property.typeParameters");
        renderWhereSuffix(r13, r12);
        return;
    L5:
        if (getStartFromDeclarationKeyword() == true) goto L18;
        renderPropertyAnnotations(r11, r12);
        List<ReceiverParameterDescriptor> r14 = r11.getContextReceiverParameters();
        Intrinsics.checkNotNullExpressionValue(r14, "property.contextReceiverParameters");
        renderContextReceivers(r14, r12);
        DescriptorVisibility r15 = r11.getVisibility();
        Intrinsics.checkNotNullExpressionValue(r15, "property.visibility");
        renderVisibility(r15, r12);
        boolean r16 = false;
        if (getModifiers().contains(DescriptorRendererModifier.CONST) == true) goto L9;
    L11:
        boolean r17 = false;
    L12:
        renderModifier(r12, r17, "const");
        renderMemberModifiers(r11, r12);
        renderModalityForCallable(r11, r12);
        renderOverride(r11, r12);
        if (getModifiers().contains(DescriptorRendererModifier.LATEINIT) == true) goto L15;
    L17:
        renderModifier(r12, r16, "lateinit");
        renderMemberKind(r11, r12);
        goto L18
    L15:
        if (r11.isLateInit() == false) goto L17;
        r16 = true;
        goto L17
    L9:
        if (r11.isConst() == false) goto L11;
        r17 = true;
    L18:
        renderValVarPrefix$default(this, r11, r12, false, 4, null);
        List<TypeParameterDescriptor> r18 = r11.getTypeParameters();
        Intrinsics.checkNotNullExpressionValue(r18, "property.typeParameters");
        renderTypeParameters(r18, r12, true);
        renderReceiver(r11, r12);
        goto L19
    }

    private final void renderPropertyAnnotations(PropertyDescriptor r10, StringBuilder r11) {
        if (getModifiers().contains(DescriptorRendererModifier.ANNOTATIONS) == true) goto L5;
        return;
    L5:
        renderAnnotations$default(this, r11, r10, null, 2, null);
        FieldDescriptor r12 = r10.getBackingField();
        if (r12 == null) goto L8;
        renderAnnotations(r11, r12, AnnotationUseSiteTarget.FIELD);
    L8:
        FieldDescriptor r13 = r10.getDelegateField();
        if (r13 == null) goto L12;
        renderAnnotations(r11, r13, AnnotationUseSiteTarget.PROPERTY_DELEGATE_FIELD);
    L12:
        if (getPropertyAccessorRenderingPolicy() != PropertyAccessorRenderingPolicy.NONE) goto L20;
        PropertyGetterDescriptor r14 = r10.getGetter();
        if (r14 == null) goto L16;
        renderAnnotations(r11, r14, AnnotationUseSiteTarget.PROPERTY_GETTER);
    L16:
        PropertySetterDescriptor r15 = r10.getSetter();
        if (r15 == null) goto L21;
        renderAnnotations(r11, r15, AnnotationUseSiteTarget.PROPERTY_SETTER);
        List<ValueParameterDescriptor> r16 = r15.getValueParameters();
        Intrinsics.checkNotNullExpressionValue(r16, "setter.valueParameters");
        ValueParameterDescriptor r17 = (ValueParameterDescriptor) CollectionsKt.single(r16);
        Intrinsics.checkNotNullExpressionValue(r17, "it");
        renderAnnotations(r11, r17, AnnotationUseSiteTarget.SETTER_PARAMETER);
        return;
    L21:
        return;
    }

    private final void renderReceiver(CallableDescriptor r10, StringBuilder r11) {
        ReceiverParameterDescriptor r12 = r10.getExtensionReceiverParameter();
        if (r12 == null) goto L6;
        renderAnnotations(r11, r12, AnnotationUseSiteTarget.RECEIVER);
        KotlinType r13 = r12.getType();
        Intrinsics.checkNotNullExpressionValue(r13, "receiver.type");
        r11.append(renderForReceiver(r13));
        r11.append(".");
        return;
    }

    private final void renderReceiverAfterName(CallableDescriptor r10, StringBuilder r11) {
        if (getReceiverAfterName() == true) goto L5;
        return;
    L5:
        ReceiverParameterDescriptor r12 = r10.getExtensionReceiverParameter();
        if (r12 == null) goto L9;
        r11.append(" on ");
        KotlinType r13 = r12.getType();
        Intrinsics.checkNotNullExpressionValue(r13, "receiver.type");
        r11.append(renderType(r13));
        return;
    }

    private final void renderSimpleType(StringBuilder r10, SimpleType r11) {
        if (Intrinsics.areEqual(r11, TypeUtils.CANNOT_INFER_FUNCTION_PARAM_TYPE) == false) goto L5;
    L23:
        r10.append("???");
        return;
    L5:
        if (TypeUtils.isDontCarePlaceholder(r11) == true) goto L23;
        if (ErrorUtils.isUninferredTypeVariable(r11) == false) goto L15;
        if (getUninferredTypeParameterAsName() == false) goto L12;
        TypeConstructor r12 = r11.getConstructor();
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type org.jetbrains.kotlin.types.error.ErrorTypeConstructor");
        r10.append(renderError(((ErrorTypeConstructor) r12).getParam(0)));
        return;
    L12:
        r10.append("???");
        return;
    L15:
        if (KotlinTypeKt.isError(r11) == false) goto L19;
        renderDefaultType(r10, r11);
        return;
    L19:
        if (shouldRenderAsPrettyFunctionType(r11) == false) goto L21;
        renderFunctionType(r10, r11);
        return;
    L21:
        renderDefaultType(r10, r11);
    }

    private final void renderSpaceIfNeeded(StringBuilder r10) {
        int r11 = r10.length();
        if (r11 != 0) goto L5;
    L6:
        r10.append(' ');
        return;
    L5:
        if (r10.charAt(r11 - 1) != ' ') goto L6;
    }

    private final void renderSuperTypes(ClassDescriptor r11, StringBuilder r12) {
        if (getWithoutSuperTypes() == false) goto L6;
        return;
    L6:
        if (KotlinBuiltIns.isNothing(r11.getDefaultType()) == false) goto L8;
        return;
    L8:
        Collection<KotlinType> r10 = r11.getTypeConstructor().mo1324getSupertypes();
        Intrinsics.checkNotNullExpressionValue(r10, "klass.typeConstructor.supertypes");
        if (r10.isEmpty() == false) goto L11;
        return;
    L11:
        if (r10.size() == 1) goto L13;
    L15:
        renderSpaceIfNeeded(r12);
        r12.append(": ");
        CollectionsKt.joinTo$default(r10, r12, ", ", null, null, 0, null, new C04231(this), 60, null);
        return;
    L13:
        if (KotlinBuiltIns.isAnyOrNullableAny(r10.iterator().next()) == false) goto L15;
    }

    private final void renderSuspendModifier(FunctionDescriptor r10, StringBuilder r11) {
        renderModifier(r11, r10.isSuspend(), "suspend");
    }

    private final void renderTypeAlias(TypeAliasDescriptor r10, StringBuilder r11) {
        renderAnnotations$default(this, r11, r10, null, 2, null);
        DescriptorVisibility r12 = r10.getVisibility();
        Intrinsics.checkNotNullExpressionValue(r12, "typeAlias.visibility");
        renderVisibility(r12, r11);
        renderMemberModifiers(r10, r11);
        r11.append(renderKeyword("typealias"));
        r11.append(" ");
        renderName(r10, r11, true);
        List<TypeParameterDescriptor> r13 = r10.getDeclaredTypeParameters();
        Intrinsics.checkNotNullExpressionValue(r13, "typeAlias.declaredTypeParameters");
        renderTypeParameters(r13, r11, false);
        renderCapturedTypeParametersIfRequired(r10, r11);
        r11.append(" = ");
        r11.append(renderType(r10.getUnderlyingType()));
    }

    private final void renderTypeConstructorAndArguments(StringBuilder r10, KotlinType r11, TypeConstructor r12) {
        PossiblyInnerType r13 = TypeParameterUtilsKt.buildPossiblyInnerType(r11);
        if (r13 != null) goto L6;
        r10.append(renderTypeConstructor(r12));
        r10.append(renderTypeArguments(r11.getArguments()));
        return;
    L6:
        renderPossiblyInnerType(r10, r13);
    }

    static /* synthetic */ void renderTypeConstructorAndArguments$default(DescriptorRendererImpl r10, StringBuilder r11, KotlinType r12, TypeConstructor r13, int r14, Object r15) {
        if ((r14 & 2) == 0) goto L5;
        r13 = r12.getConstructor();
    L5:
        r10.renderTypeConstructorAndArguments(r11, r12, r13);
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
        String r10 = r11.getVariance().getLabel();
        boolean r14 = true;
        if (r10.length() <= 0) goto L10;
        boolean r15 = true;
    L11:
        renderModifier(r12, r15, r10);
        renderAnnotations$default(this, r12, r11, null, 2, null);
        renderName(r11, r12, r13);
        int r16 = r11.getUpperBounds().size();
        if (r16 <= 1) goto L14;
        if (r13 == true) goto L14;
    L15:
        KotlinType r17 = r11.getUpperBounds().iterator().next();
        if (KotlinBuiltIns.isDefaultBound(r17) == true) goto L29;
        r12.append(" : ");
        Intrinsics.checkNotNullExpressionValue(r17, "upperBound");
        r12.append(renderType(r17));
    L29:
        if (r13 == false) goto L37;
        r12.append(gt());
        return;
    L37:
        return;
    L14:
        if (r16 == 1) goto L15;
        if (r13 == false) goto L29;
        Iterator<KotlinType> r18 = r11.getUpperBounds().iterator();
    L21:
        if (r18.hasNext() == false) goto L29;
        KotlinType r19 = r18.next();
        if (KotlinBuiltIns.isDefaultBound(r19) == true) goto L21;
        if (r14 == false) goto L27;
        r12.append(" : ");
    L28:
        Intrinsics.checkNotNullExpressionValue(r19, "upperBound");
        r12.append(renderType(r19));
        r14 = false;
        goto L21
    L27:
        r12.append(" & ");
        goto L28
    L10:
        r15 = false;
        goto L11
    }

    private final void renderTypeParameterList(StringBuilder r10, List<? extends TypeParameterDescriptor> r11) {
        Iterator<? extends TypeParameterDescriptor> r12 = r11.iterator();
    L4:
        if (r12.hasNext() == false) goto L8;
        renderTypeParameter(r12.next(), r10, false);
        if (r12.hasNext() == false) goto L4;
        r10.append(", ");
        goto L4
    }

    private final void renderTypeParameters(List<? extends TypeParameterDescriptor> r10, StringBuilder r11, boolean r12) {
        if (getWithoutTypeParameters() == false) goto L6;
        return;
    L6:
        if ((!r10.isEmpty()) == false) goto L11;
        r11.append(lt());
        renderTypeParameterList(r11, r10);
        r11.append(gt());
        if (r12 == false) goto L12;
        r11.append(" ");
        return;
    L12:
        return;
    }

    private final void renderValVarPrefix(VariableDescriptor r10, StringBuilder r11, boolean r12) {
        if (r12 == true) goto L6;
        if ((r10 instanceof ValueParameterDescriptor) == false) goto L6;
        return;
    L6:
        if (r10.isVar() == false) goto L8;
        String r13 = "var";
    L9:
        r11.append(renderKeyword(r13));
        r11.append(" ");
        return;
    L8:
        r13 = "val";
        goto L9
    }

    static /* synthetic */ void renderValVarPrefix$default(DescriptorRendererImpl r10, VariableDescriptor r11, StringBuilder r12, boolean r13, int r14, Object r15) {
        if ((r14 & 4) == 0) goto L5;
        r13 = false;
    L5:
        r10.renderValVarPrefix(r11, r12, r13);
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
        boolean r14 = true;
        if (getRenderPrimaryConstructorParametersAsProperties() == false) goto L20;
        CallableDescriptor r15 = r10.getContainingDeclaration();
        if ((r15 instanceof ClassConstructorDescriptor) == false) goto L12;
        ClassConstructorDescriptor r16 = (ClassConstructorDescriptor) r15;
    L13:
        if (r16 != null) goto L15;
    L17:
        boolean r17 = false;
    L18:
        if (r17 == false) goto L20;
        boolean r18 = true;
    L21:
        if (r18 == false) goto L23;
        renderModifier(r12, getActualPropertiesInPrimaryConstructor(), "actual");
    L23:
        renderVariable(r10, r11, r12, r13, r18);
        if (getDefaultParameterValueRenderer() != null) goto L26;
    L31:
        r14 = false;
    L32:
        if (r14 == false) goto L35;
        StringBuilder r19 = new StringBuilder();
        r19.append(" = ");
        Function1<ValueParameterDescriptor, String> r20 = getDefaultParameterValueRenderer();
        Intrinsics.checkNotNull(r20);
        r19.append(r20.invoke(r10));
        r12.append(r19.toString());
        return;
    L35:
        return;
    L26:
        if (getDebugMode() == false) goto L28;
        boolean r110 = r10.declaresDefaultValue();
    L29:
        if (r110 == false) goto L31;
    L28:
        r110 = DescriptorUtilsKt.declaresOrInheritsDefaultValue(r10);
        goto L29
    L15:
        if (r16.isPrimary() != true) goto L17;
        r17 = true;
        goto L18
    L12:
        r16 = null;
    L20:
        r18 = false;
        goto L21
    }

    private final void renderValueParameters(Collection<? extends ValueParameterDescriptor> r10, boolean r11, StringBuilder r12) {
        boolean r13 = shouldRenderParameterNames(r11);
        int r14 = r10.size();
        getValueParametersHandler().appendBeforeValueParameters(r14, r12);
        Iterator<? extends ValueParameterDescriptor> r15 = r10.iterator();
        int r16 = 0;
    L4:
        if (r15.hasNext() == false) goto L6;
        ValueParameterDescriptor r17 = r15.next();
        getValueParametersHandler().appendBeforeValueParameter(r17, r16, r14, r12);
        renderValueParameter(r17, r13, r12, false);
        getValueParametersHandler().appendAfterValueParameter(r17, r16, r14, r12);
        r16 = r16 + 1;
        goto L4
    L6:
        getValueParametersHandler().appendAfterValueParameters(r14, r12);
    }

    private final void renderVariable(VariableDescriptor r10, boolean r11, StringBuilder r12, boolean r13, boolean r14) {
        KotlinType r15 = r10.getType();
        Intrinsics.checkNotNullExpressionValue(r15, "variable.type");
        KotlinType r16 = null;
        if ((r10 instanceof ValueParameterDescriptor) == false) goto L5;
        ValueParameterDescriptor r17 = (ValueParameterDescriptor) r10;
    L6:
        if (r17 == null) goto L8;
        r16 = r17.getVarargElementType();
    L8:
        if (r16 != null) goto L10;
        KotlinType r18 = r15;
    L11:
        if (r16 == null) goto L13;
        boolean r19 = true;
    L14:
        renderModifier(r12, r19, "vararg");
        if (r14 == true) goto L19;
        if (r13 == true) goto L18;
    L20:
        if (r11 == false) goto L22;
        renderName(r10, r12, r13);
        r12.append(": ");
    L22:
        r12.append(renderType(r18));
        renderInitializer(r10, r12);
        if (getVerbose() == false) goto L27;
        if (r16 == null) goto L28;
        r12.append(" /*");
        r12.append(renderType(r15));
        r12.append("*/");
        return;
    L28:
        return;
    L27:
        return;
    L18:
        if (getStartFromName() == true) goto L20;
    L19:
        renderValVarPrefix(r10, r12, r14);
        goto L20
    L13:
        r19 = false;
        goto L14
    L10:
        r18 = r16;
        goto L11
    L5:
        r17 = null;
        goto L6
    }

    private final boolean renderVisibility(DescriptorVisibility r10, StringBuilder r11) {
        if (getModifiers().contains(DescriptorRendererModifier.VISIBILITY) == true) goto L6;
        return false;
    L6:
        if (getNormalizedVisibilities() == false) goto L9;
        r10 = r10.normalize();
    L9:
        if (getRenderDefaultVisibility() == false) goto L11;
    L13:
        r11.append(renderKeyword(r10.getInternalDisplayName()));
        r11.append(" ");
        return true;
    L11:
        if (Intrinsics.areEqual(r10, DescriptorVisibilities.DEFAULT_VISIBILITY) == false) goto L13;
        return false;
    }

    private final void renderWhereSuffix(List<? extends TypeParameterDescriptor> r12, StringBuilder r13) {
        if (getWithoutTypeParameters() == false) goto L5;
        return;
    L5:
        ArrayList r10 = new ArrayList(0);
        Iterator<? extends TypeParameterDescriptor> r14 = r12.iterator();
    L7:
        if (r14.hasNext() == false) goto L13;
        TypeParameterDescriptor r11 = r14.next();
        List<KotlinType> r15 = r11.getUpperBounds();
        Intrinsics.checkNotNullExpressionValue(r15, "typeParameter.upperBounds");
        Iterator r16 = CollectionsKt.drop(r15, 1).iterator();
    L10:
        if (r16.hasNext() == false) goto L7;
        KotlinType r17 = (KotlinType) r16.next();
        StringBuilder r18 = new StringBuilder();
        Name r19 = r11.getName();
        Intrinsics.checkNotNullExpressionValue(r19, "typeParameter.name");
        r18.append(renderName(r19, false));
        r18.append(" : ");
        Intrinsics.checkNotNullExpressionValue(r17, "it");
        r18.append(renderType(r17));
        r10.add(r18.toString());
        goto L10
    L13:
        if ((!r10.isEmpty()) == false) goto L18;
        r13.append(" ");
        r13.append(renderKeyword("where"));
        r13.append(" ");
        CollectionsKt.joinTo$default(r10, r13, ", ", null, null, 0, null, null, 124, null);
        return;
    }

    private final String replacePrefixes(String r10, String r11, String r12, String r13, String r14) {
        if (StringsKt.startsWith$default(r10, r11, false, 2, null) == true) goto L5;
    L13:
        return null;
    L5:
        if (StringsKt.startsWith$default(r12, r13, false, 2, null) == false) goto L13;
        String r15 = r10.substring(r11.length());
        Intrinsics.checkNotNullExpressionValue(r15, "this as java.lang.String).substring(startIndex)");
        String r16 = r12.substring(r13.length());
        Intrinsics.checkNotNullExpressionValue(r16, "this as java.lang.String).substring(startIndex)");
        String r17 = r14 + r15;
        if (Intrinsics.areEqual(r15, r16) == false) goto L10;
        return r17;
    L10:
        if (differsOnlyInNullability(r15, r16) == false) goto L13;
        return r17 + '!';
    }

    private final boolean shouldRenderAsPrettyFunctionType(KotlinType r10) {
        if (FunctionTypesKt.isBuiltinFunctionalType(r10) == false) goto L21;
        List<TypeProjection> r11 = r10.getArguments();
        if ((r11 instanceof Collection) == true) goto L7;
    L9:
        Iterator<T> r12 = r11.iterator();
    L11:
        if (r12.hasNext() == false) goto L8;
        if (((TypeProjection) r12.next()).isStarProjection() == false) goto L11;
        boolean r13 = false;
    L15:
        if (r13 == true) goto L17;
        return false;
    L17:
        return true;
    L8:
        r13 = true;
        goto L15
    L7:
        if (r11.isEmpty() == false) goto L9;
    L21:
        return false;
    }

    private final boolean shouldRenderParameterNames(boolean r10) {
        ParameterNameRenderingPolicy r11 = getParameterNameRenderingPolicy();
        int r12 = WhenMappings.$EnumSwitchMapping$1[r11.ordinal()];
        if (r12 == 1) goto L13;
        if (r12 != 2) goto L7;
        if (r10 == false) goto L13;
        return false;
    L7:
        if (r12 != 3) goto L10;
        return false;
    L10:
        throw new NoWhenBranchMatchedException();
    L13:
        return true;
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

    public boolean getIncludeAnnotationArguments() {
        return this.options.getIncludeAnnotationArguments();
    }

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

    public final DescriptorRendererOptionsImpl getOptions() {
        return this.options;
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

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer
    public String render(DeclarationDescriptor r10) {
        Intrinsics.checkNotNullParameter(r10, "declarationDescriptor");
        StringBuilder r11 = new StringBuilder();
        r10.accept(new RenderDeclarationDescriptorVisitor(this), r11);
        if (getWithDefinedIn() == false) goto L5;
        appendDefinedIn(r11, r10);
    L5:
        String r12 = r11.toString();
        Intrinsics.checkNotNullExpressionValue(r12, "StringBuilder().apply(builderAction).toString()");
        return r12;
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer
    public String renderAnnotation(AnnotationDescriptor r12, AnnotationUseSiteTarget r13) {
        Intrinsics.checkNotNullParameter(r12, "annotation");
        StringBuilder r10 = new StringBuilder();
        r10.append('@');
        if (r13 == null) goto L5;
        r10.append(r13.getRenderName() + ':');
    L5:
        KotlinType r14 = r12.getType();
        r10.append(renderType(r14));
        if (getIncludeAnnotationArguments() == false) goto L13;
        List<String> r11 = renderAndSortAnnotationArguments(r12);
        if (getIncludeEmptyAnnotationArguments() == false) goto L10;
    L11:
        CollectionsKt.joinTo$default(r11, r10, ", ", "(", ")", 0, null, null, 112, null);
        goto L13
    L10:
        if ((!r11.isEmpty()) == true) goto L11;
    L13:
        if (getVerbose() == true) goto L15;
    L19:
        String r15 = r10.toString();
        Intrinsics.checkNotNullExpressionValue(r15, "StringBuilder().apply(builderAction).toString()");
        return r15;
    L15:
        if (KotlinTypeKt.isError(r14) == false) goto L17;
    L18:
        r10.append(" /* annotation class not found */");
        goto L19
    L17:
        if ((r14.getConstructor().mo1323getDeclarationDescriptor() instanceof NotFoundClasses.MockClassDescriptor) == false) goto L19;
        goto L18
    }

    public String renderClassifierName(ClassifierDescriptor r10) {
        Intrinsics.checkNotNullParameter(r10, "klass");
        if (ErrorUtils.isError(r10) == false) goto L6;
        return r10.getTypeConstructor().toString();
    L6:
        return getClassifierNamePolicy().renderClassifier(r10, this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer
    public String renderFlexibleType(String r16, String r17, KotlinBuiltIns r18) {
        Intrinsics.checkNotNullParameter(r16, "lowerRendered");
        Intrinsics.checkNotNullParameter(r17, "upperRendered");
        Intrinsics.checkNotNullParameter(r18, "builtIns");
        if (differsOnlyInNullability(r16, r17) == true) goto L5;
        ClassifierNamePolicy r10 = getClassifierNamePolicy();
        ClassDescriptor r11 = r18.getCollection();
        Intrinsics.checkNotNullExpressionValue(r11, "builtIns.collection");
        String r13 = StringsKt.substringBefore$default(r10.renderClassifier(r11, this), "Collection", null, 2, null);
        String r12 = replacePrefixes(r16, r13 + "Mutable", r17, r13, r13 + "(Mutable)");
        if (r12 == null) goto L13;
        return r12;
    L13:
        String r14 = replacePrefixes(r16, r13 + "MutableMap.MutableEntry", r17, r13 + "Map.Entry", r13 + "(Mutable)Map.(Mutable)Entry");
        if (r14 == null) goto L16;
        return r14;
    L16:
        ClassifierNamePolicy r15 = getClassifierNamePolicy();
        ClassDescriptor r19 = r18.getArray();
        Intrinsics.checkNotNullExpressionValue(r19, "builtIns.array");
        String r20 = StringsKt.substringBefore$default(r15.renderClassifier(r19, this), "Array", null, 2, null);
        String r21 = replacePrefixes(r16, r20 + escape("Array<"), r17, r20 + escape("Array<out "), r20 + escape("Array<(out) "));
        if (r21 == null) goto L19;
        return r21;
    L19:
        StringBuilder r22 = new StringBuilder();
        r22.append('(');
        r22.append(r16);
        r22.append("..");
        r22.append(r17);
        r22.append(')');
    L8:
        return r22.toString();
    L5:
        if (StringsKt.startsWith$default(r17, "(", false, 2, null) == false) goto L9;
        r22 = new StringBuilder();
        r22.append('(');
        r22.append(r16);
        r22.append(")!");
        goto L8
    L9:
        r22 = new StringBuilder();
        r22.append(r16);
        r22.append('!');
        goto L8
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer
    public String renderFqName(FqNameUnsafe r10) {
        Intrinsics.checkNotNullParameter(r10, "fqName");
        List<Name> r11 = r10.pathSegments();
        Intrinsics.checkNotNullExpressionValue(r11, "fqName.pathSegments()");
        return renderFqName(r11);
    }

    public String renderMessage(String r10) {
        Intrinsics.checkNotNullParameter(r10, "message");
        int r11 = WhenMappings.$EnumSwitchMapping$0[getTextFormat().ordinal()];
        if (r11 != 1) goto L5;
        return r10;
    L5:
        if (r11 != 2) goto L8;
        return "<i>" + r10 + "</i>";
    L8:
        throw new NoWhenBranchMatchedException();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer
    public String renderName(Name r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        String r12 = escape(RenderingUtilsKt.render(r10));
        if (getBoldOnlyForNamesInHtml() == true) goto L5;
        return r12;
    L5:
        if (getTextFormat() != RenderingFormat.HTML) goto L10;
        if (r11 == true) goto L8;
        return r12;
    L8:
        return "<b>" + r12 + "</b>";
    L10:
        return r12;
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer
    public String renderType(KotlinType r10) {
        Intrinsics.checkNotNullParameter(r10, WsConstants.KEY_CONNECTION_TYPE);
        StringBuilder r11 = new StringBuilder();
        renderNormalizedType(r11, getTypeNormalizer().invoke(r10));
        String r12 = r11.toString();
        Intrinsics.checkNotNullExpressionValue(r12, "StringBuilder().apply(builderAction).toString()");
        return r12;
    }

    public String renderTypeArguments(List<? extends TypeProjection> r10) {
        Intrinsics.checkNotNullParameter(r10, "typeArguments");
        if (r10.isEmpty() == false) goto L5;
        return "";
    L5:
        StringBuilder r11 = new StringBuilder();
        r11.append(lt());
        appendTypeProjections(r11, r10);
        r11.append(gt());
        String r12 = r11.toString();
        Intrinsics.checkNotNullExpressionValue(r12, "StringBuilder().apply(builderAction).toString()");
        return r12;
    }

    public String renderTypeConstructor(TypeConstructor r10) {
        Intrinsics.checkNotNullParameter(r10, "typeConstructor");
        ClassifierDescriptor r11 = r10.mo1323getDeclarationDescriptor();
        boolean r12 = true;
        if ((r11 instanceof TypeParameterDescriptor) == false) goto L5;
        boolean r13 = true;
    L6:
        if (r13 == true) goto L9;
        r12 = r11 instanceof TypeAliasDescriptor;
    L9:
        if (r12 == true) goto L19;
        if (r11 != null) goto L18;
        if ((r10 instanceof IntersectionTypeConstructor) == false) goto L16;
        return ((IntersectionTypeConstructor) r10).makeDebugNameForIntersectionType(C04241.INSTANCE);
    L16:
        return r10.toString();
    L18:
        throw new IllegalStateException(("Unexpected classifier: " + r11.getClass()).toString());
    L19:
        return renderClassifierName(r11);
    L5:
        r13 = r11 instanceof ClassDescriptor;
        goto L6
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer
    public String renderTypeProjection(TypeProjection r10) {
        Intrinsics.checkNotNullParameter(r10, "typeProjection");
        StringBuilder r11 = new StringBuilder();
        appendTypeProjections(r11, CollectionsKt.listOf(r10));
        String r12 = r11.toString();
        Intrinsics.checkNotNullExpressionValue(r12, "StringBuilder().apply(builderAction).toString()");
        return r12;
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setAnnotationArgumentsRenderingPolicy(AnnotationArgumentsRenderingPolicy r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.options.setAnnotationArgumentsRenderingPolicy(r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setClassifierNamePolicy(ClassifierNamePolicy r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.options.setClassifierNamePolicy(r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setDebugMode(boolean r10) {
        this.options.setDebugMode(r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setExcludedTypeAnnotationClasses(Set<FqName> r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.options.setExcludedTypeAnnotationClasses(r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setModifiers(Set<? extends DescriptorRendererModifier> r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.options.setModifiers(r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setParameterNameRenderingPolicy(ParameterNameRenderingPolicy r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.options.setParameterNameRenderingPolicy(r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setReceiverAfterName(boolean r10) {
        this.options.setReceiverAfterName(r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setRenderCompanionObjectName(boolean r10) {
        this.options.setRenderCompanionObjectName(r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setStartFromName(boolean r10) {
        this.options.setStartFromName(r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setTextFormat(RenderingFormat r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.options.setTextFormat(r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setVerbose(boolean r10) {
        this.options.setVerbose(r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setWithDefinedIn(boolean r10) {
        this.options.setWithDefinedIn(r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setWithoutSuperTypes(boolean r10) {
        this.options.setWithoutSuperTypes(r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setWithoutTypeParameters(boolean r10) {
        this.options.setWithoutTypeParameters(r10);
    }
}
