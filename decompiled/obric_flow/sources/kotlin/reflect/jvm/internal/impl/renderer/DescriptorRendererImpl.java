package kotlin.reflect.jvm.internal.impl.renderer;

import ai.j0;
import androidx.room.jarjarred.org.antlr.runtime.a;
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
import kotlin.jvm.internal.SourceDebugExtension;
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
import kotlin.reflect.jvm.internal.impl.types.error.ErrorType;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.reflect.jvm.internal.impl.util.capitalizeDecapitalize.CapitalizeDecapitalizeKt;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nDescriptorRendererImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DescriptorRendererImpl.kt\norg/jetbrains/kotlin/renderer/DescriptorRendererImpl\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1205:1\n2624#2,3:1206\n766#2:1209\n857#2,2:1210\n1549#2:1212\n1620#2,3:1213\n766#2:1216\n857#2,2:1217\n1549#2:1219\n1620#2,3:1220\n1549#2:1223\n1620#2,3:1224\n2624#2,3:1228\n2624#2,3:1231\n766#2:1234\n857#2,2:1235\n1620#2,3:1237\n1#3:1227\n*S KotlinDebug\n*F\n+ 1 DescriptorRendererImpl.kt\norg/jetbrains/kotlin/renderer/DescriptorRendererImpl\n*L\n183#1:1206,3\n483#1:1209\n483#1:1210,2\n484#1:1212\n484#1:1213,3\n486#1:1216\n486#1:1217,2\n486#1:1219\n486#1:1220,3\n488#1:1223\n488#1:1224,3\n587#1:1228,3\n589#1:1231,3\n805#1:1234\n805#1:1235,2\n828#1:1237,3\n*E\n"})
public final class DescriptorRendererImpl extends DescriptorRenderer implements DescriptorRendererOptions {
    private final Lazy functionTypeAnnotationsRenderer$delegate;
    private final DescriptorRendererOptionsImpl options;

    public final class RenderDeclarationDescriptorVisitor implements DeclarationDescriptorVisitor<Unit, StringBuilder> {
        final /* synthetic */ DescriptorRendererImpl this$0;

        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

            static {
                int[] r5 = new int[PropertyAccessorRenderingPolicy.values().length];
                r5[PropertyAccessorRenderingPolicy.PRETTY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
            L11:
                r5[PropertyAccessorRenderingPolicy.DEBUG.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
            L15:
                r5[PropertyAccessorRenderingPolicy.NONE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
            L6:
                $EnumSwitchMapping$0 = r5;
            }
        }

        public RenderDeclarationDescriptorVisitor(DescriptorRendererImpl r5) {
            this.this$0 = r5;
        }

        private final void visitPropertyAccessorDescriptor(PropertyAccessorDescriptor r5, StringBuilder r10, String r11) {
            int r12 = WhenMappings.$EnumSwitchMapping$0[this.this$0.getPropertyAccessorRenderingPolicy().ordinal()];
            if (r12 != 1) goto L5;
            DescriptorRendererImpl.access$renderAccessorModifiers(this.this$0, r5, r10);
            r10.append(r11 + " for ");
            DescriptorRendererImpl.access$renderProperty(this.this$0, r5.getCorrespondingProperty(), r10);
            return;
        L5:
            if (r12 != 2) goto L11;
            visitFunctionDescriptor2(r5, r10);
            return;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ Unit visitClassDescriptor(ClassDescriptor r5, StringBuilder r10) {
            visitClassDescriptor2(r5, r10);
            return Unit.INSTANCE;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ Unit visitConstructorDescriptor(ConstructorDescriptor r5, StringBuilder r10) {
            visitConstructorDescriptor2(r5, r10);
            return Unit.INSTANCE;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ Unit visitFunctionDescriptor(FunctionDescriptor r5, StringBuilder r10) {
            visitFunctionDescriptor2(r5, r10);
            return Unit.INSTANCE;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ Unit visitModuleDeclaration(ModuleDescriptor r5, StringBuilder r10) {
            visitModuleDeclaration2(r5, r10);
            return Unit.INSTANCE;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ Unit visitPackageFragmentDescriptor(PackageFragmentDescriptor r5, StringBuilder r10) {
            visitPackageFragmentDescriptor2(r5, r10);
            return Unit.INSTANCE;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ Unit visitPackageViewDescriptor(PackageViewDescriptor r5, StringBuilder r10) {
            visitPackageViewDescriptor2(r5, r10);
            return Unit.INSTANCE;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ Unit visitPropertyDescriptor(PropertyDescriptor r5, StringBuilder r10) {
            visitPropertyDescriptor2(r5, r10);
            return Unit.INSTANCE;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ Unit visitPropertyGetterDescriptor(PropertyGetterDescriptor r5, StringBuilder r10) {
            visitPropertyGetterDescriptor2(r5, r10);
            return Unit.INSTANCE;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ Unit visitPropertySetterDescriptor(PropertySetterDescriptor r5, StringBuilder r10) {
            visitPropertySetterDescriptor2(r5, r10);
            return Unit.INSTANCE;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ Unit visitReceiverParameterDescriptor(ReceiverParameterDescriptor r5, StringBuilder r10) {
            visitReceiverParameterDescriptor2(r5, r10);
            return Unit.INSTANCE;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ Unit visitTypeAliasDescriptor(TypeAliasDescriptor r5, StringBuilder r10) {
            visitTypeAliasDescriptor2(r5, r10);
            return Unit.INSTANCE;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ Unit visitTypeParameterDescriptor(TypeParameterDescriptor r5, StringBuilder r10) {
            visitTypeParameterDescriptor2(r5, r10);
            return Unit.INSTANCE;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ Unit visitValueParameterDescriptor(ValueParameterDescriptor r5, StringBuilder r10) {
            visitValueParameterDescriptor2(r5, r10);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: visitClassDescriptor, reason: avoid collision after fix types in other method */
        public void visitClassDescriptor2(ClassDescriptor r5, StringBuilder r10) {
            Intrinsics.checkNotNullParameter(r5, "descriptor");
            Intrinsics.checkNotNullParameter(r10, "builder");
            DescriptorRendererImpl.access$renderClass(this.this$0, r5, r10);
        }

        /* JADX INFO: renamed from: visitConstructorDescriptor, reason: avoid collision after fix types in other method */
        public void visitConstructorDescriptor2(ConstructorDescriptor r5, StringBuilder r10) {
            Intrinsics.checkNotNullParameter(r5, "constructorDescriptor");
            Intrinsics.checkNotNullParameter(r10, "builder");
            DescriptorRendererImpl.access$renderConstructor(this.this$0, r5, r10);
        }

        /* JADX INFO: renamed from: visitFunctionDescriptor, reason: avoid collision after fix types in other method */
        public void visitFunctionDescriptor2(FunctionDescriptor r5, StringBuilder r10) {
            Intrinsics.checkNotNullParameter(r5, "descriptor");
            Intrinsics.checkNotNullParameter(r10, "builder");
            DescriptorRendererImpl.access$renderFunction(this.this$0, r5, r10);
        }

        /* JADX INFO: renamed from: visitModuleDeclaration, reason: avoid collision after fix types in other method */
        public void visitModuleDeclaration2(ModuleDescriptor r5, StringBuilder r10) {
            Intrinsics.checkNotNullParameter(r5, "descriptor");
            Intrinsics.checkNotNullParameter(r10, "builder");
            DescriptorRendererImpl.access$renderName(this.this$0, r5, r10, true);
        }

        /* JADX INFO: renamed from: visitPackageFragmentDescriptor, reason: avoid collision after fix types in other method */
        public void visitPackageFragmentDescriptor2(PackageFragmentDescriptor r5, StringBuilder r10) {
            Intrinsics.checkNotNullParameter(r5, "descriptor");
            Intrinsics.checkNotNullParameter(r10, "builder");
            DescriptorRendererImpl.access$renderPackageFragment(this.this$0, r5, r10);
        }

        /* JADX INFO: renamed from: visitPackageViewDescriptor, reason: avoid collision after fix types in other method */
        public void visitPackageViewDescriptor2(PackageViewDescriptor r5, StringBuilder r10) {
            Intrinsics.checkNotNullParameter(r5, "descriptor");
            Intrinsics.checkNotNullParameter(r10, "builder");
            DescriptorRendererImpl.access$renderPackageView(this.this$0, r5, r10);
        }

        /* JADX INFO: renamed from: visitPropertyDescriptor, reason: avoid collision after fix types in other method */
        public void visitPropertyDescriptor2(PropertyDescriptor r5, StringBuilder r10) {
            Intrinsics.checkNotNullParameter(r5, "descriptor");
            Intrinsics.checkNotNullParameter(r10, "builder");
            DescriptorRendererImpl.access$renderProperty(this.this$0, r5, r10);
        }

        /* JADX INFO: renamed from: visitPropertyGetterDescriptor, reason: avoid collision after fix types in other method */
        public void visitPropertyGetterDescriptor2(PropertyGetterDescriptor r5, StringBuilder r10) {
            Intrinsics.checkNotNullParameter(r5, "descriptor");
            Intrinsics.checkNotNullParameter(r10, "builder");
            visitPropertyAccessorDescriptor(r5, r10, "getter");
        }

        /* JADX INFO: renamed from: visitPropertySetterDescriptor, reason: avoid collision after fix types in other method */
        public void visitPropertySetterDescriptor2(PropertySetterDescriptor r5, StringBuilder r10) {
            Intrinsics.checkNotNullParameter(r5, "descriptor");
            Intrinsics.checkNotNullParameter(r10, "builder");
            visitPropertyAccessorDescriptor(r5, r10, "setter");
        }

        /* JADX INFO: renamed from: visitReceiverParameterDescriptor, reason: avoid collision after fix types in other method */
        public void visitReceiverParameterDescriptor2(ReceiverParameterDescriptor r5, StringBuilder r10) {
            Intrinsics.checkNotNullParameter(r5, "descriptor");
            Intrinsics.checkNotNullParameter(r10, "builder");
            r10.append(r5.getName());
        }

        /* JADX INFO: renamed from: visitTypeAliasDescriptor, reason: avoid collision after fix types in other method */
        public void visitTypeAliasDescriptor2(TypeAliasDescriptor r5, StringBuilder r10) {
            Intrinsics.checkNotNullParameter(r5, "descriptor");
            Intrinsics.checkNotNullParameter(r10, "builder");
            DescriptorRendererImpl.access$renderTypeAlias(this.this$0, r5, r10);
        }

        /* JADX INFO: renamed from: visitTypeParameterDescriptor, reason: avoid collision after fix types in other method */
        public void visitTypeParameterDescriptor2(TypeParameterDescriptor r5, StringBuilder r10) {
            Intrinsics.checkNotNullParameter(r5, "descriptor");
            Intrinsics.checkNotNullParameter(r10, "builder");
            DescriptorRendererImpl.access$renderTypeParameter(this.this$0, r5, r10, true);
        }

        /* JADX INFO: renamed from: visitValueParameterDescriptor, reason: avoid collision after fix types in other method */
        public void visitValueParameterDescriptor2(ValueParameterDescriptor r5, StringBuilder r10) {
            Intrinsics.checkNotNullParameter(r5, "descriptor");
            Intrinsics.checkNotNullParameter(r10, "builder");
            DescriptorRendererImpl.access$renderValueParameter(this.this$0, r5, true, r10, true);
        }
    }

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1 = null;

        static {
            int[] r5 = new int[RenderingFormat.values().length];
            r5[RenderingFormat.PLAIN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L17:
            r5[RenderingFormat.HTML.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L6:
            $EnumSwitchMapping$0 = r5;
            int[] r10 = new int[ParameterNameRenderingPolicy.values().length];
            r10[ParameterNameRenderingPolicy.ALL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L25:
            r10[ParameterNameRenderingPolicy.ONLY_NON_SYNTHESIZED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L21:
            r10[ParameterNameRenderingPolicy.NONE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L10:
            $EnumSwitchMapping$1 = r10;
        }
    }

    public DescriptorRendererImpl(DescriptorRendererOptionsImpl r5) {
        Intrinsics.checkNotNullParameter(r5, "options");
        this.options = r5;
        r5.isLocked();
        this.functionTypeAnnotationsRenderer$delegate = LazyKt.lazy(new DescriptorRendererImpl$functionTypeAnnotationsRenderer$2(this));
    }

    public static final /* synthetic */ void access$renderAccessorModifiers(DescriptorRendererImpl r5, PropertyAccessorDescriptor r10, StringBuilder r11) {
        r5.renderAccessorModifiers(r10, r11);
    }

    public static final /* synthetic */ void access$renderClass(DescriptorRendererImpl r5, ClassDescriptor r10, StringBuilder r11) {
        r5.renderClass(r10, r11);
    }

    public static final /* synthetic */ String access$renderConstant(DescriptorRendererImpl r5, ConstantValue r10) {
        return r5.renderConstant(r10);
    }

    public static final /* synthetic */ void access$renderConstructor(DescriptorRendererImpl r5, ConstructorDescriptor r10, StringBuilder r11) {
        r5.renderConstructor(r10, r11);
    }

    public static final /* synthetic */ void access$renderFunction(DescriptorRendererImpl r5, FunctionDescriptor r10, StringBuilder r11) {
        r5.renderFunction(r10, r11);
    }

    public static final /* synthetic */ void access$renderName(DescriptorRendererImpl r5, DeclarationDescriptor r10, StringBuilder r11, boolean r12) {
        r5.renderName(r10, r11, r12);
    }

    public static final /* synthetic */ void access$renderPackageFragment(DescriptorRendererImpl r5, PackageFragmentDescriptor r10, StringBuilder r11) {
        r5.renderPackageFragment(r10, r11);
    }

    public static final /* synthetic */ void access$renderPackageView(DescriptorRendererImpl r5, PackageViewDescriptor r10, StringBuilder r11) {
        r5.renderPackageView(r10, r11);
    }

    public static final /* synthetic */ void access$renderProperty(DescriptorRendererImpl r5, PropertyDescriptor r10, StringBuilder r11) {
        r5.renderProperty(r10, r11);
    }

    public static final /* synthetic */ void access$renderTypeAlias(DescriptorRendererImpl r5, TypeAliasDescriptor r10, StringBuilder r11) {
        r5.renderTypeAlias(r10, r11);
    }

    public static final /* synthetic */ void access$renderTypeParameter(DescriptorRendererImpl r5, TypeParameterDescriptor r10, StringBuilder r11, boolean r12) {
        r5.renderTypeParameter(r10, r11, r12);
    }

    public static final /* synthetic */ void access$renderValueParameter(DescriptorRendererImpl r5, ValueParameterDescriptor r10, boolean r11, StringBuilder r12, boolean r13) {
        r5.renderValueParameter(r10, r11, r12, r13);
    }

    private final void appendDefinedIn(StringBuilder r5, DeclarationDescriptor r10) {
        if ((r10 instanceof PackageFragmentDescriptor) == false) goto L5;
        return;
    L5:
        if ((r10 instanceof PackageViewDescriptor) == true) goto L32;
        DeclarationDescriptor r11 = r10.getContainingDeclaration();
        if (r11 != null) goto L10;
        return;
    L10:
        if ((r11 instanceof ModuleDescriptor) == true) goto L27;
        r5.append(" ");
        r5.append(renderMessage("defined in"));
        r5.append(" ");
        FqNameUnsafe r12 = DescriptorUtils.getFqName(r11);
        if (r12.isRoot() == false) goto L14;
        String r13 = "root package";
    L15:
        r5.append(r13);
        if (getWithSourceFileForTopLevel() == true) goto L18;
        return;
    L18:
        if ((r11 instanceof PackageFragmentDescriptor) == true) goto L20;
        return;
    L20:
        if ((r10 instanceof DeclarationDescriptorWithSource) == false) goto L30;
        String r14 = ((DeclarationDescriptorWithSource) r10).getSource().getContainingFile().getName();
        if (r14 == null) goto L31;
        r5.append(" ");
        r5.append(renderMessage("in file"));
        r5.append(" ");
        r5.append(r14);
        return;
    L31:
        return;
    L30:
        return;
    L14:
        r13 = renderFqName(r12);
        goto L15
    L27:
        return;
    }

    private final void appendTypeProjections(StringBuilder r10, List<? extends TypeProjection> r11) {
        CollectionsKt.p(r11, r10, ", ", null, null, new AnonymousClass1(this), 60);
    }

    private final String arrow() {
        RenderingFormat r5 = getTextFormat();
        int r10 = WhenMappings.$EnumSwitchMapping$0[r5.ordinal()];
        if (r10 == 1) goto L10;
        if (r10 != 2) goto L8;
        return "&rarr;";
    L8:
        throw new NoWhenBranchMatchedException();
    L10:
        return escape("->");
    }

    private final String escape(String r5) {
        return getTextFormat().escape(r5);
    }

    private final DescriptorRendererImpl getFunctionTypeAnnotationsRenderer() {
        return (DescriptorRendererImpl) this.functionTypeAnnotationsRenderer$delegate.getValue();
    }

    private final String gt() {
        return escape(">");
    }

    private final boolean hasModifiersOrAnnotations(KotlinType r5) {
        if (FunctionTypesKt.isSuspendFunctionType(r5) == false) goto L5;
    L8:
        return true;
    L5:
        if (r5.getAnnotations().isEmpty() == false) goto L8;
        return false;
    }

    private final Modality implicitModalityWithoutExtensions(MemberDescriptor r5) {
        if ((r5 instanceof ClassDescriptor) == true) goto L5;
        DeclarationDescriptor r10 = r5.getContainingDeclaration();
        if ((r10 instanceof ClassDescriptor) == false) goto L12;
        ClassDescriptor r11 = (ClassDescriptor) r10;
    L13:
        if (r11 != null) goto L17;
        return Modality.FINAL;
    L17:
        if ((r5 instanceof CallableMemberDescriptor) == false) goto L19;
        CallableMemberDescriptor r12 = (CallableMemberDescriptor) r5;
        if (r12.getOverriddenDescriptors().isEmpty() == true) goto L27;
        if (r11.getModality() == Modality.FINAL) goto L27;
        return Modality.OPEN;
    L27:
        if (r11.getKind() != ClassKind.INTERFACE) goto L35;
        if (Intrinsics.areEqual(r12.getVisibility(), DescriptorVisibilities.PRIVATE) == true) goto L35;
        Modality r13 = r12.getModality();
        Modality r14 = Modality.ABSTRACT;
        if (r13 != r14) goto L37;
        return r14;
    L37:
        return Modality.OPEN;
    L35:
        return Modality.FINAL;
    L19:
        return Modality.FINAL;
    L12:
        r11 = null;
        goto L13
    L5:
        if (((ClassDescriptor) r5).getKind() != ClassKind.INTERFACE) goto L8;
        return Modality.ABSTRACT;
    L8:
        return Modality.FINAL;
    }

    private final boolean isParameterName(AnnotationDescriptor r5) {
        return Intrinsics.areEqual(r5.getFqName(), StandardNames.FqNames.parameterName);
    }

    private final String lt() {
        return escape("<");
    }

    private final boolean overridesSomething(CallableMemberDescriptor r5) {
        return !r5.getOverriddenDescriptors().isEmpty();
    }

    private final void renderAbbreviatedTypeExpansion(StringBuilder r5, AbbreviatedType r10) {
        RenderingFormat r11 = getTextFormat();
        RenderingFormat r12 = RenderingFormat.HTML;
        if (r11 != r12) goto L5;
        r5.append("<font color=\"808080\"><i>");
    L5:
        r5.append(" /* = ");
        renderNormalizedTypeAsIs(r5, r10.getExpandedType());
        r5.append(" */");
        if (getTextFormat() != r12) goto L9;
        r5.append("</i></font>");
        return;
    }

    private final void renderAccessorModifiers(PropertyAccessorDescriptor r5, StringBuilder r10) {
        renderMemberModifiers(r5, r10);
    }

    private final void renderAdditionalModifiers(FunctionDescriptor r10, StringBuilder r11) {
        boolean r5 = false;
        if (r10.isOperator() == false) goto L15;
        Collection<? extends FunctionDescriptor> r12 = r10.getOverriddenDescriptors();
        if (r12.isEmpty() == true) goto L14;
        Iterator<T> r13 = r12.iterator();
    L9:
        if (r13.hasNext() == false) goto L14;
        if (((FunctionDescriptor) r13.next()).isOperator() == false) goto L9;
        if (getAlwaysRenderModifiers() == false) goto L15;
    L14:
        boolean r14 = true;
    L17:
        if (r10.isInfix() == false) goto L29;
        Collection<? extends FunctionDescriptor> r15 = r10.getOverriddenDescriptors();
        if (r15.isEmpty() == true) goto L28;
        Iterator<T> r16 = r15.iterator();
    L23:
        if (r16.hasNext() == false) goto L28;
        if (((FunctionDescriptor) r16.next()).isInfix() == false) goto L23;
        if (getAlwaysRenderModifiers() == false) goto L29;
    L28:
        r5 = true;
    L29:
        renderModifier(r11, r10.isTailrec(), "tailrec");
        renderSuspendModifier(r10, r11);
        renderModifier(r11, r10.isInline(), "inline");
        renderModifier(r11, r5, "infix");
        renderModifier(r11, r14, "operator");
        return;
    L15:
        r14 = false;
        goto L17
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    private final List<String> renderAndSortAnnotationArguments(AnnotationDescriptor r10) {
        Map<Name, ConstantValue<?>> r5 = r10.getAllValueArguments();
        List r11 = 0;
        r11 = 0;
        r11 = 0;
        if (getRenderDefaultAnnotationArguments() == false) goto L5;
        ClassDescriptor r12 = DescriptorUtilsKt.getAnnotationClass(r10);
    L6:
        if (r12 == null) goto L21;
        ClassConstructorDescriptor r13 = r12.mo1396getUnsubstitutedPrimaryConstructor();
        if (r13 == null) goto L21;
        List<ValueParameterDescriptor> r14 = r13.getValueParameters();
        if (r14 == null) goto L21;
        ArrayList r15 = new ArrayList();
        Iterator<T> r16 = r14.iterator();
    L13:
        if (r16.hasNext() == false) goto L17;
        Object r17 = r16.next();
        if (((ValueParameterDescriptor) r17).declaresDefaultValue() == false) goto L13;
        r15.add(r17);
        goto L13
    L17:
        r11 = new ArrayList(CollectionsKt.h(r15));
        Iterator r18 = r15.iterator();
    L19:
        if (r18.hasNext() == false) goto L21;
        r11.add(((ValueParameterDescriptor) r18.next()).getName());
    L21:
        if (r11 != 0) goto L23;
        r11 = CollectionsKt.emptyList();
    L23:
        ArrayList r19 = new ArrayList();
        Iterator r20 = r11.iterator();
    L25:
        if (r20.hasNext() == false) goto L29;
        Object r21 = r20.next();
        if (r5.containsKey((Name) r21) == true) goto L25;
        r19.add(r21);
        goto L25
    L29:
        ArrayList r22 = new ArrayList(CollectionsKt.h(r19));
        Iterator r23 = r19.iterator();
    L31:
        if (r23.hasNext() == false) goto L33;
        r22.add(((Name) r23.next()).asString() + " = ...");
        goto L31
    L33:
        Set<Map.Entry<Name, ConstantValue<?>>> r24 = r5.entrySet();
        ArrayList r25 = new ArrayList(CollectionsKt.h(r24));
        Iterator<T> r26 = r24.iterator();
    L35:
        if (r26.hasNext() == false) goto L42;
        Map.Entry r27 = (Map.Entry) r26.next();
        Name r28 = (Name) r27.getKey();
        ConstantValue<?> r29 = (ConstantValue) r27.getValue();
        StringBuilder r30 = new StringBuilder();
        r30.append(r28.asString());
        r30.append(" = ");
        if (r11.contains(r28) == true) goto L39;
        String r31 = renderConstant(r29);
    L40:
        r30.append(r31);
        r25.add(r30.toString());
        goto L35
    L39:
        r31 = "...";
        goto L40
    L42:
        return CollectionsKt.sorted(CollectionsKt.plus(r22, r25));
    L5:
        r12 = null;
        goto L6
    }

    private final void renderAnnotations(StringBuilder r10, Annotated r11, AnnotationUseSiteTarget r12) {
        if (getModifiers().contains(DescriptorRendererModifier.ANNOTATIONS) == true) goto L6;
        return;
    L6:
        if ((r11 instanceof KotlinType) == false) goto L8;
        Set<FqName> r5 = getExcludedTypeAnnotationClasses();
    L9:
        Function1<AnnotationDescriptor, Boolean> r13 = getAnnotationFilter();
        Iterator<AnnotationDescriptor> r14 = r11.getAnnotations().iterator();
    L11:
        if (r14.hasNext() == false) goto L23;
        AnnotationDescriptor r15 = r14.next();
        if (CollectionsKt.contains(r5, r15.getFqName()) == true) goto L11;
        if (isParameterName(r15) == true) goto L11;
        if (r13 == null) goto L19;
        if (r13.invoke(r15).booleanValue() == false) goto L11;
    L19:
        r10.append(renderAnnotation(r15, r12));
        if (getEachAnnotationOnNewLine() == true) goto L21;
        r10.append(" ");
        goto L11
    L21:
        r10.append('\n');
        goto L11
    L23:
        return;
    L8:
        r5 = getExcludedAnnotationClasses();
        goto L9
    }

    public static /* synthetic */ void renderAnnotations$default(DescriptorRendererImpl r5, StringBuilder r10, Annotated r11, AnnotationUseSiteTarget r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L5;
        r12 = null;
    L5:
        r5.renderAnnotations(r10, r11, r12);
    }

    private final void renderCapturedTypeParametersIfRequired(ClassifierDescriptorWithTypeParameters r5, StringBuilder r10) {
        List<TypeParameterDescriptor> r11 = r5.getDeclaredTypeParameters();
        List<TypeParameterDescriptor> r12 = r5.getTypeConstructor().getParameters();
        if (getVerbose() == true) goto L5;
        return;
    L5:
        if (r5.isInner() == true) goto L7;
        return;
    L7:
        if (r12.size() <= r11.size()) goto L12;
        r10.append(" /*captured type parameters: ");
        renderTypeParameterList(r10, r12.subList(r11.size(), r12.size()));
        r10.append("*/");
        return;
    }

    private final void renderClass(ClassDescriptor r11, StringBuilder r12) {
        if (r11.getKind() != ClassKind.ENUM_ENTRY) goto L5;
        boolean r5 = true;
    L7:
        if (getStartFromName() == true) goto L52;
        renderAnnotations$default(this, r12, r11, null, 2, null);
        renderContextReceivers(r11.getContextReceivers(), r12);
        if (r5 == true) goto L12;
        renderVisibility(r11.getVisibility(), r12);
    L12:
        if (r11.getKind() != ClassKind.INTERFACE) goto L16;
        if (r11.getModality() != Modality.ABSTRACT) goto L16;
    L20:
        renderMemberModifiers(r11, r12);
        if (getModifiers().contains(DescriptorRendererModifier.INNER) == true) goto L23;
    L25:
        boolean r10 = false;
    L26:
        renderModifier(r12, r10, "inner");
        if (getModifiers().contains(DescriptorRendererModifier.DATA) == true) goto L29;
    L31:
        boolean r13 = false;
    L32:
        renderModifier(r12, r13, "data");
        if (getModifiers().contains(DescriptorRendererModifier.INLINE) == true) goto L35;
    L37:
        boolean r14 = false;
    L38:
        renderModifier(r12, r14, "inline");
        if (getModifiers().contains(DescriptorRendererModifier.VALUE) == true) goto L41;
    L43:
        boolean r15 = false;
    L44:
        renderModifier(r12, r15, "value");
        if (getModifiers().contains(DescriptorRendererModifier.FUN) == true) goto L47;
    L49:
        boolean r16 = false;
    L50:
        renderModifier(r12, r16, "fun");
        renderClassKindPrefix(r11, r12);
        goto L52
    L47:
        if (r11.isFun() == false) goto L49;
        r16 = true;
        goto L50
    L41:
        if (r11.isValue() == false) goto L43;
        r15 = true;
        goto L44
    L35:
        if (r11.isInline() == false) goto L37;
        r14 = true;
        goto L38
    L29:
        if (r11.isData() == false) goto L31;
        r13 = true;
        goto L32
    L23:
        if (r11.isInner() == false) goto L25;
        r10 = true;
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
        if (r5 == false) goto L60;
        return;
    L60:
        List<TypeParameterDescriptor> r17 = r11.getDeclaredTypeParameters();
        renderTypeParameters(r17, r12, false);
        renderCapturedTypeParametersIfRequired(r11, r12);
        if (r11.getKind().isSingleton() == false) goto L63;
    L67:
        renderSuperTypes(r11, r12);
        renderWhereSuffix(r17, r12);
        return;
    L63:
        if (getClassWithPrimaryConstructor() == false) goto L67;
        ClassConstructorDescriptor r18 = r11.mo1396getUnsubstitutedPrimaryConstructor();
        if (r18 == null) goto L67;
        r12.append(" ");
        renderAnnotations$default(this, r12, r18, null, 2, null);
        renderVisibility(r18.getVisibility(), r12);
        r12.append(renderKeyword("constructor"));
        renderValueParameters(r18.getValueParameters(), r18.hasSynthesizedParameterNames(), r12);
        goto L67
    L54:
        if (getStartFromName() == true) goto L56;
        renderSpaceIfNeeded(r12);
    L56:
        renderName(r11, r12, true);
        goto L58
    L5:
        r5 = false;
        goto L7
    }

    private final void renderClassKindPrefix(ClassDescriptor r5, StringBuilder r10) {
        r10.append(renderKeyword(DescriptorRenderer.Companion.getClassifierKindPrefix(r5)));
    }

    private final void renderCompanionObjectName(DeclarationDescriptor r5, StringBuilder r10) {
        if (getRenderCompanionObjectName() == false) goto L11;
        if (getStartFromName() == false) goto L7;
        r10.append("companion object");
    L7:
        renderSpaceIfNeeded(r10);
        DeclarationDescriptor r11 = r5.getContainingDeclaration();
        if (r11 == null) goto L11;
        r10.append("of ");
        r10.append(renderName(r11.getName(), false));
    L11:
        if (getVerbose() == true) goto L15;
        if (Intrinsics.areEqual(r5.getName(), SpecialNames.DEFAULT_NAME_FOR_COMPANION_OBJECT) == false) goto L15;
        return;
    L15:
        if (getStartFromName() == true) goto L17;
        renderSpaceIfNeeded(r10);
    L17:
        r10.append(renderName(r5.getName(), true));
    }

    private final String renderConstant(ConstantValue<?> r10) {
        if ((r10 instanceof ArrayValue) == false) goto L6;
        return CollectionsKt.q(((ArrayValue) r10).getValue(), ", ", "{", "}", 0, null, new C02311(this), 24);
    L6:
        if ((r10 instanceof AnnotationValue) == false) goto L9;
        return StringsKt.A(DescriptorRenderer.renderAnnotation$default(this, ((AnnotationValue) r10).getValue(), null, 2, null), "@");
    L9:
        if ((r10 instanceof KClassValue) == false) goto L22;
        KClassValue.Value r11 = ((KClassValue) r10).getValue();
        if ((r11 instanceof KClassValue.Value.LocalClass) == false) goto L14;
        return ((KClassValue.Value.LocalClass) r11).getType() + "::class";
    L14:
        if ((r11 instanceof KClassValue.Value.NormalClass) == false) goto L20;
        KClassValue.Value.NormalClass r12 = (KClassValue.Value.NormalClass) r11;
        String r13 = r12.getClassId().asSingleFqName().asString();
        int r14 = r12.getArrayDimensions();
        int r5 = 0;
    L16:
        if (r5 >= r14) goto L27;
        r13 = a.p("kotlin.Array<", Typography.greater, r13);
        r5 = r5 + 1;
        goto L16
    L27:
        return j0.j(r13, "::class");
    L20:
        throw new NoWhenBranchMatchedException();
    L22:
        return r10.toString();
    }

    private final void renderConstructor(ConstructorDescriptor r10, StringBuilder r11) {
        renderAnnotations$default(this, r11, r10, null, 2, null);
        if (this.options.getRenderDefaultVisibility() == true) goto L7;
        if (r10.getConstructedClass().getModality() != Modality.SEALED) goto L7;
    L9:
        boolean r5 = false;
    L10:
        renderMemberKind(r10, r11);
        if (getRenderConstructorKeyword() == false) goto L13;
    L17:
        boolean r12 = true;
    L18:
        if (r12 == false) goto L20;
        r11.append(renderKeyword("constructor"));
    L20:
        ClassifierDescriptorWithTypeParameters r13 = r10.getContainingDeclaration();
        if (getSecondaryConstructorsAsPrimary() == false) goto L25;
        if (r12 == false) goto L24;
        r11.append(" ");
    L24:
        renderName(r13, r11, true);
        renderTypeParameters(r10.getTypeParameters(), r11, false);
    L25:
        renderValueParameters(r10.getValueParameters(), r10.hasSynthesizedParameterNames(), r11);
        if (getRenderConstructorDelegation() == false) goto L45;
        if (r10.isPrimary() == true) goto L45;
        if ((r13 instanceof ClassDescriptor) == false) goto L45;
        ClassConstructorDescriptor r14 = ((ClassDescriptor) r13).mo1396getUnsubstitutedPrimaryConstructor();
        if (r14 == null) goto L45;
        List<ValueParameterDescriptor> r15 = r14.getValueParameters();
        ArrayList r16 = new ArrayList();
        Iterator<T> r17 = r15.iterator();
    L35:
        if (r17.hasNext() == false) goto L42;
        Object r18 = r17.next();
        ValueParameterDescriptor r19 = (ValueParameterDescriptor) r18;
        if (r19.declaresDefaultValue() == true) goto L35;
        if (r19.getVarargElementType() != null) goto L35;
        r16.add(r18);
        goto L35
    L42:
        if (r16.isEmpty() == true) goto L45;
        r11.append(" : ");
        r11.append(renderKeyword("this"));
        r11.append(CollectionsKt.q(r16, ", ", "(", ")", 0, null, C02321.INSTANCE, 24));
    L45:
        if (getSecondaryConstructorsAsPrimary() == false) goto L55;
        renderWhereSuffix(r10.getTypeParameters(), r11);
        return;
    L55:
        return;
    L13:
        if (r10.isPrimary() == false) goto L17;
        if (r5 == true) goto L17;
        r12 = false;
    L7:
        if (renderVisibility(r10.getVisibility(), r11) == false) goto L9;
        r5 = true;
        goto L10
    }

    private final void renderContextReceivers(List<? extends ReceiverParameterDescriptor> r10, StringBuilder r11) {
        if (r10.isEmpty() == true) goto L12;
        r11.append("context(");
        Iterator<? extends ReceiverParameterDescriptor> r5 = r10.iterator();
        int r12 = 0;
    L6:
        if (r5.hasNext() == false) goto L16;
        int r13 = r12 + 1;
        ReceiverParameterDescriptor r14 = r5.next();
        renderAnnotations(r11, r14, AnnotationUseSiteTarget.RECEIVER);
        r11.append(renderForReceiver(r14.getType()));
        if (r12 != CollectionsKt.getLastIndex(r10)) goto L10;
        r11.append(") ");
    L11:
        r12 = r13;
        goto L6
    L10:
        r11.append(", ");
        goto L11
    L16:
        return;
    }

    private final void renderDefaultType(StringBuilder r10, KotlinType r11) {
        renderAnnotations$default(this, r10, r11, null, 2, null);
        SimpleType r5 = null;
        if ((r11 instanceof DefinitelyNotNullType) == false) goto L5;
        DefinitelyNotNullType r12 = (DefinitelyNotNullType) r11;
    L6:
        if (r12 == null) goto L9;
        r5 = r12.getOriginal();
    L9:
        if (KotlinTypeKt.isError(r11) == false) goto L23;
        if (TypeUtilsKt.isUnresolvedType(r11) == false) goto L16;
        if (getPresentableUnresolvedTypes() == false) goto L16;
        r10.append(renderError(ErrorUtils.INSTANCE.unresolvedTypeAsItIs(r11)));
    L30:
        if (r11.isMarkedNullable() == false) goto L33;
        r10.append("?");
    L33:
        if (SpecialTypesKt.isDefinitelyNotNullType(r11) == false) goto L36;
        r10.append(" & Any");
        return;
    L36:
        return;
    L16:
        if ((r11 instanceof ErrorType) == true) goto L18;
    L20:
        r10.append(r11.getConstructor().toString());
    L21:
        r10.append(renderTypeArguments(r11.getArguments()));
        goto L30
    L18:
        if (getInformativeErrorType() == true) goto L20;
        r10.append(((ErrorType) r11).getDebugMessage());
        goto L21
    L23:
        if ((r11 instanceof StubTypeForBuilderInference) == false) goto L26;
        r10.append(((StubTypeForBuilderInference) r11).getOriginalTypeVariable().toString());
        goto L30
    L26:
        if ((r5 instanceof StubTypeForBuilderInference) == false) goto L28;
        r10.append(((StubTypeForBuilderInference) r5).getOriginalTypeVariable().toString());
        goto L30
    L28:
        renderTypeConstructorAndArguments$default(this, r10, r11, null, 2, null);
        goto L30
    L5:
        r12 = null;
        goto L6
    }

    private final String renderError(String r5) {
        RenderingFormat r10 = getTextFormat();
        int r11 = WhenMappings.$EnumSwitchMapping$0[r10.ordinal()];
        if (r11 != 1) goto L5;
        return r5;
    L5:
        if (r11 != 2) goto L8;
        return j0.k("<font color=red><b>", r5, "</b></font>");
    L8:
        throw new NoWhenBranchMatchedException();
    }

    private final String renderForReceiver(KotlinType r5) {
        String r10 = renderType(r5);
        if (shouldRenderAsPrettyFunctionType(r5) == false) goto L7;
        if (TypeUtils.isNullableType(r5) == true) goto L7;
    L9:
        return a.p("(", ')', r10);
    L7:
        if ((r5 instanceof DefinitelyNotNullType) == true) goto L9;
        return r10;
    }

    private final void renderFunction(FunctionDescriptor r10, StringBuilder r11) {
        if (getStartFromName() == false) goto L5;
    L22:
        renderName(r10, r11, true);
        renderValueParameters(r10.getValueParameters(), r10.hasSynthesizedParameterNames(), r11);
        renderReceiverAfterName(r10, r11);
        KotlinType r5 = r10.getReturnType();
        if (getWithoutReturnType() == false) goto L25;
    L34:
        renderWhereSuffix(r10.getTypeParameters(), r11);
        return;
    L25:
        if (getUnitReturnType() == true) goto L29;
        if (r5 == null) goto L29;
        if (KotlinBuiltIns.isUnit(r5) == true) goto L34;
    L29:
        r11.append(": ");
        if (r5 != null) goto L32;
        String r12 = "[NULL]";
    L33:
        r11.append(r12);
        goto L34
    L32:
        r12 = renderType(r5);
        goto L33
    L5:
        if (getStartFromDeclarationKeyword() == true) goto L21;
        renderAnnotations$default(this, r11, r10, null, 2, null);
        renderContextReceivers(r10.getContextReceiverParameters(), r11);
        renderVisibility(r10.getVisibility(), r11);
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
        renderTypeParameters(r10.getTypeParameters(), r11, true);
        renderReceiver(r10, r11);
        goto L22
    }

    private final void renderFunctionType(StringBuilder r12, KotlinType r13) {
        int r5 = r12.length();
        renderAnnotations$default(getFunctionTypeAnnotationsRenderer(), r12, r13, null, 2, null);
        if (r12.length() == r5) goto L5;
        boolean r10 = true;
    L6:
        KotlinType r11 = FunctionTypesKt.getReceiverTypeFromFunctionType(r13);
        List<KotlinType> r14 = FunctionTypesKt.getContextReceiverTypesFromFunctionType(r13);
        if (r14.isEmpty() == true) goto L13;
        r12.append("context(");
        Iterator<KotlinType> r15 = r14.subList(0, CollectionsKt.getLastIndex(r14)).iterator();
    L10:
        if (r15.hasNext() == false) goto L12;
        renderNormalizedType(r12, r15.next());
        r12.append(", ");
        goto L10
    L12:
        renderNormalizedType(r12, (KotlinType) CollectionsKt.last(r14));
        r12.append(") ");
    L13:
        boolean r16 = FunctionTypesKt.isSuspendFunctionType(r13);
        boolean r17 = r13.isMarkedNullable();
        if (r17 == true) goto L19;
        if (r10 == false) goto L18;
        if (r11 != null) goto L19;
    L18:
        boolean r18 = false;
    L21:
        if (r18 == false) goto L29;
        if (r16 == false) goto L24;
        r12.insert(r5, '(');
        goto L29
    L24:
        if (r10 == false) goto L28;
        CharsKt.a(StringsKt.last(r12));
        if (r12.charAt(StringsKt.getLastIndex(r12) - 1) == ')') goto L28;
        r12.insert(StringsKt.getLastIndex(r12), "()");
    L28:
        r12.append("(");
    L29:
        renderModifier(r12, r16, "suspend");
        if (r11 != null) goto L32;
    L48:
        r12.append("(");
        if (FunctionTypesKt.isBuiltinExtensionFunctionalType(r13) == true) goto L51;
    L53:
        Iterator<TypeProjection> r19 = FunctionTypesKt.getValueParameterTypesFromFunctionType(r13).iterator();
        int r20 = 0;
    L55:
        if (r19.hasNext() == false) goto L66;
        int r21 = r20 + 1;
        TypeProjection r22 = r19.next();
        if (r20 <= 0) goto L60;
        r12.append(", ");
    L60:
        if (getParameterNamesInFunctionalTypes() == false) goto L62;
        Name r23 = FunctionTypesKt.extractParameterNameFromFunctionTypeArgument(r22.getType());
    L63:
        if (r23 == null) goto L65;
        r12.append(renderName(r23, false));
        r12.append(": ");
    L65:
        r12.append(renderTypeProjection(r22));
        r20 = r21;
        goto L55
    L62:
        r23 = null;
    L66:
        r12.append(") ");
        r12.append(arrow());
        r12.append(" ");
        renderNormalizedType(r12, FunctionTypesKt.getReturnTypeFromFunctionType(r13));
        if (r18 == false) goto L69;
        r12.append(")");
    L69:
        if (r17 == false) goto L76;
        r12.append("?");
        return;
    L76:
        return;
    L51:
        if (r13.getArguments().size() > 1) goto L53;
        r12.append("???");
        goto L66
    L32:
        if (shouldRenderAsPrettyFunctionType(r11) == false) goto L36;
        if (r11.isMarkedNullable() == true) goto L36;
    L41:
        boolean r24 = true;
    L42:
        if (r24 == false) goto L44;
        r12.append("(");
    L44:
        renderNormalizedType(r12, r11);
        if (r24 == false) goto L47;
        r12.append(")");
    L47:
        r12.append(".");
    L36:
        if (hasModifiersOrAnnotations(r11) == true) goto L41;
        if ((r11 instanceof DefinitelyNotNullType) == true) goto L41;
        r24 = false;
    L19:
        r18 = true;
        goto L21
    L5:
        r10 = false;
        goto L6
    }

    private final void renderInitializer(VariableDescriptor r5, StringBuilder r10) {
        if (getIncludePropertyConstant() == false) goto L8;
        ConstantValue<?> r11 = r5.mo1398getCompileTimeInitializer();
        if (r11 == null) goto L9;
        r10.append(" = ");
        r10.append(escape(renderConstant(r11)));
        return;
    L9:
        return;
    }

    private final String renderKeyword(String r5) {
        RenderingFormat r10 = getTextFormat();
        int r11 = WhenMappings.$EnumSwitchMapping$0[r10.ordinal()];
        if (r11 != 1) goto L5;
        return r5;
    L5:
        if (r11 != 2) goto L11;
        if (getBoldOnlyForNamesInHtml() == false) goto L13;
        return r5;
    L13:
        return j0.k("<b>", r5, "</b>");
    L11:
        throw new NoWhenBranchMatchedException();
    }

    private final void renderMemberKind(CallableMemberDescriptor r5, StringBuilder r10) {
        if (getModifiers().contains(DescriptorRendererModifier.MEMBER_KIND) == true) goto L6;
        return;
    L6:
        if (getVerbose() == true) goto L8;
        return;
    L8:
        if (r5.getKind() == CallableMemberDescriptor.Kind.DECLARATION) goto L12;
        r10.append("/*");
        r10.append(CapitalizeDecapitalizeKt.toLowerCaseAsciiOnly(r5.getKind().name()));
        r10.append("*/ ");
        return;
    }

    private final void renderMemberModifiers(MemberDescriptor r5, StringBuilder r10) {
        renderModifier(r10, r5.isExternal(), "external");
        boolean r11 = false;
        if (getModifiers().contains(DescriptorRendererModifier.EXPECT) == true) goto L5;
    L7:
        boolean r12 = false;
    L8:
        renderModifier(r10, r12, "expect");
        if (getModifiers().contains(DescriptorRendererModifier.ACTUAL) == true) goto L11;
    L13:
        renderModifier(r10, r11, "actual");
        return;
    L11:
        if (r5.isActual() == false) goto L13;
        r11 = true;
        goto L13
    L5:
        if (r5.isExpect() == false) goto L7;
        r12 = true;
        goto L8
    }

    private final void renderModality(Modality r5, StringBuilder r10, Modality r11) {
        if (getRenderDefaultModality() == true) goto L6;
        if (r5 != r11) goto L6;
        return;
    L6:
        renderModifier(r10, getModifiers().contains(DescriptorRendererModifier.MODALITY), CapitalizeDecapitalizeKt.toLowerCaseAsciiOnly(r5.name()));
    }

    private final void renderModalityForCallable(CallableMemberDescriptor r5, StringBuilder r10) {
        if (DescriptorUtils.isTopLevelDeclaration(r5) == false) goto L7;
        if (r5.getModality() != Modality.FINAL) goto L7;
        return;
    L7:
        if (getOverrideRenderingPolicy() == OverrideRenderingPolicy.RENDER_OVERRIDE) goto L9;
    L13:
        renderModality(r5.getModality(), r10, implicitModalityWithoutExtensions(r5));
        return;
    L9:
        if (r5.getModality() != Modality.OPEN) goto L13;
        if (overridesSomething(r5) == false) goto L13;
    }

    private final void renderModifier(StringBuilder r5, boolean r10, String r11) {
        if (r10 == false) goto L5;
        r5.append(renderKeyword(r11));
        r5.append(" ");
        return;
    }

    private final void renderNormalizedType(StringBuilder r5, KotlinType r10) {
        UnwrappedType r11 = r10.unwrap();
        if ((r11 instanceof AbbreviatedType) == false) goto L5;
        AbbreviatedType r12 = (AbbreviatedType) r11;
    L6:
        if (r12 != null) goto L8;
        renderNormalizedTypeAsIs(r5, r10);
        return;
    L8:
        if (getRenderTypeExpansions() == false) goto L10;
        renderNormalizedTypeAsIs(r5, r12.getExpandedType());
        return;
    L10:
        renderNormalizedTypeAsIs(r5, r12.getAbbreviation());
        if (getRenderUnabbreviatedType() == false) goto L17;
        renderAbbreviatedTypeExpansion(r5, r12);
        return;
    L17:
        return;
    L5:
        r12 = null;
        goto L6
    }

    private final void renderNormalizedTypeAsIs(StringBuilder r5, KotlinType r10) {
        if ((r10 instanceof WrappedType) == true) goto L5;
    L10:
        UnwrappedType r11 = r10.unwrap();
        if ((r11 instanceof FlexibleType) == false) goto L14;
        r5.append(((FlexibleType) r11).render(this, this));
        return;
    L14:
        if ((r11 instanceof SimpleType) == false) goto L18;
        renderSimpleType(r5, (SimpleType) r11);
        return;
    L18:
        return;
    L5:
        if (getDebugMode() == false) goto L10;
        if (((WrappedType) r10).isComputed() == true) goto L10;
        r5.append("<Not computed yet>");
    }

    private final void renderOverride(CallableMemberDescriptor r5, StringBuilder r10) {
        if (getModifiers().contains(DescriptorRendererModifier.OVERRIDE) == true) goto L6;
        return;
    L6:
        if (overridesSomething(r5) == true) goto L8;
        return;
    L8:
        if (getOverrideRenderingPolicy() == OverrideRenderingPolicy.RENDER_OPEN) goto L14;
        renderModifier(r10, true, "override");
        if (getVerbose() == false) goto L15;
        r10.append("/*");
        r10.append(r5.getOverriddenDescriptors().size());
        r10.append("*/ ");
        return;
    L15:
        return;
    }

    private final void renderPackageFragment(PackageFragmentDescriptor r5, StringBuilder r10) {
        renderPackageHeader(r5.getFqName(), "package-fragment", r10);
        if (getDebugMode() == false) goto L6;
        r10.append(" in ");
        renderName(r5.getContainingDeclaration(), r10, false);
        return;
    }

    private final void renderPackageHeader(FqName r5, String r10, StringBuilder r11) {
        r11.append(renderKeyword(r10));
        String r12 = renderFqName(r5.toUnsafe());
        if (r12.length() <= 0) goto L6;
        r11.append(" ");
        r11.append(r12);
        return;
    }

    private final void renderPackageView(PackageViewDescriptor r5, StringBuilder r10) {
        renderPackageHeader(r5.getFqName(), "package", r10);
        if (getDebugMode() == false) goto L6;
        r10.append(" in context of ");
        renderName(r5.getModule(), r10, false);
        return;
    }

    private final void renderPossiblyInnerType(StringBuilder r5, PossiblyInnerType r10) {
        PossiblyInnerType r11 = r10.getOuterType();
        if (r11 == null) goto L5;
        renderPossiblyInnerType(r5, r11);
        r5.append('.');
        r5.append(renderName(r10.getClassifierDescriptor().getName(), false));
    L6:
        r5.append(renderTypeArguments(r10.getArguments()));
        return;
    L5:
        r5.append(renderTypeConstructor(r10.getClassifierDescriptor().getTypeConstructor()));
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
        boolean r5 = false;
        if (getModifiers().contains(DescriptorRendererModifier.CONST) == true) goto L9;
    L11:
        boolean r12 = false;
    L12:
        renderModifier(r11, r12, "const");
        renderMemberModifiers(r10, r11);
        renderModalityForCallable(r10, r11);
        renderOverride(r10, r11);
        if (getModifiers().contains(DescriptorRendererModifier.LATEINIT) == true) goto L15;
    L17:
        renderModifier(r11, r5, "lateinit");
        renderMemberKind(r10, r11);
        goto L18
    L15:
        if (r10.isLateInit() == false) goto L17;
        r5 = true;
        goto L17
    L9:
        if (r10.isConst() == false) goto L11;
        r12 = true;
    L18:
        renderValVarPrefix$default(this, r10, r11, false, 4, null);
        renderTypeParameters(r10.getTypeParameters(), r11, true);
        renderReceiver(r10, r11);
        goto L19
    }

    private final void renderPropertyAnnotations(PropertyDescriptor r10, StringBuilder r11) {
        if (getModifiers().contains(DescriptorRendererModifier.ANNOTATIONS) == true) goto L5;
        return;
    L5:
        renderAnnotations$default(this, r11, r10, null, 2, null);
        FieldDescriptor r5 = r10.getBackingField();
        if (r5 == null) goto L8;
        renderAnnotations(r11, r5, AnnotationUseSiteTarget.FIELD);
    L8:
        FieldDescriptor r12 = r10.getDelegateField();
        if (r12 == null) goto L12;
        renderAnnotations(r11, r12, AnnotationUseSiteTarget.PROPERTY_DELEGATE_FIELD);
    L12:
        if (getPropertyAccessorRenderingPolicy() != PropertyAccessorRenderingPolicy.NONE) goto L20;
        PropertyGetterDescriptor r13 = r10.getGetter();
        if (r13 == null) goto L16;
        renderAnnotations(r11, r13, AnnotationUseSiteTarget.PROPERTY_GETTER);
    L16:
        PropertySetterDescriptor r14 = r10.getSetter();
        if (r14 == null) goto L21;
        renderAnnotations(r11, r14, AnnotationUseSiteTarget.PROPERTY_SETTER);
        renderAnnotations(r11, (ValueParameterDescriptor) CollectionsKt.single(r14.getValueParameters()), AnnotationUseSiteTarget.SETTER_PARAMETER);
        return;
    L21:
        return;
    }

    private final void renderReceiver(CallableDescriptor r5, StringBuilder r10) {
        ReceiverParameterDescriptor r11 = r5.getExtensionReceiverParameter();
        if (r11 == null) goto L6;
        renderAnnotations(r10, r11, AnnotationUseSiteTarget.RECEIVER);
        r10.append(renderForReceiver(r11.getType()));
        r10.append(".");
        return;
    }

    private final void renderReceiverAfterName(CallableDescriptor r5, StringBuilder r10) {
        if (getReceiverAfterName() == true) goto L5;
        return;
    L5:
        ReceiverParameterDescriptor r11 = r5.getExtensionReceiverParameter();
        if (r11 == null) goto L9;
        r10.append(" on ");
        r10.append(renderType(r11.getType()));
        return;
    }

    private final void renderSimpleType(StringBuilder r5, SimpleType r10) {
        if (Intrinsics.areEqual(r10, TypeUtils.CANNOT_INFER_FUNCTION_PARAM_TYPE) == false) goto L5;
    L23:
        r5.append("???");
        return;
    L5:
        if (TypeUtils.isDontCarePlaceholder(r10) == true) goto L23;
        if (ErrorUtils.isUninferredTypeVariable(r10) == false) goto L15;
        if (getUninferredTypeParameterAsName() == false) goto L12;
        TypeConstructor r11 = r10.getConstructor();
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type org.jetbrains.kotlin.types.error.ErrorTypeConstructor");
        r5.append(renderError(((ErrorTypeConstructor) r11).getParam(0)));
        return;
    L12:
        r5.append("???");
        return;
    L15:
        if (KotlinTypeKt.isError(r10) == false) goto L19;
        renderDefaultType(r5, r10);
        return;
    L19:
        if (shouldRenderAsPrettyFunctionType(r10) == false) goto L21;
        renderFunctionType(r5, r10);
        return;
    L21:
        renderDefaultType(r5, r10);
    }

    private final void renderSpaceIfNeeded(StringBuilder r5) {
        int r10 = r5.length();
        if (r10 != 0) goto L5;
    L6:
        r5.append(' ');
        return;
    L5:
        if (r5.charAt(r10 - 1) != ' ') goto L6;
    }

    private final void renderSuperTypes(ClassDescriptor r10, StringBuilder r11) {
        if (getWithoutSuperTypes() == false) goto L6;
        return;
    L6:
        if (KotlinBuiltIns.isNothing(r10.getDefaultType()) == false) goto L8;
        return;
    L8:
        Collection<KotlinType> r12 = r10.getTypeConstructor().mo1403getSupertypes();
        if (r12.isEmpty() == false) goto L11;
        return;
    L11:
        if (r12.size() == 1) goto L13;
    L15:
        renderSpaceIfNeeded(r11);
        r11.append(": ");
        CollectionsKt.p(r12, r11, ", ", null, null, new C02331(this), 60);
        return;
    L13:
        if (KotlinBuiltIns.isAnyOrNullableAny(r12.iterator().next()) == false) goto L15;
    }

    private final void renderSuspendModifier(FunctionDescriptor r5, StringBuilder r10) {
        renderModifier(r10, r5.isSuspend(), "suspend");
    }

    private final void renderTypeAlias(TypeAliasDescriptor r10, StringBuilder r11) {
        renderAnnotations$default(this, r11, r10, null, 2, null);
        renderVisibility(r10.getVisibility(), r11);
        renderMemberModifiers(r10, r11);
        r11.append(renderKeyword("typealias"));
        r11.append(" ");
        renderName(r10, r11, true);
        renderTypeParameters(r10.getDeclaredTypeParameters(), r11, false);
        renderCapturedTypeParametersIfRequired(r10, r11);
        r11.append(" = ");
        r11.append(renderType(r10.getUnderlyingType()));
    }

    private final void renderTypeConstructorAndArguments(StringBuilder r5, KotlinType r10, TypeConstructor r11) {
        PossiblyInnerType r12 = TypeParameterUtilsKt.buildPossiblyInnerType(r10);
        if (r12 != null) goto L6;
        r5.append(renderTypeConstructor(r11));
        r5.append(renderTypeArguments(r10.getArguments()));
        return;
    L6:
        renderPossiblyInnerType(r5, r12);
    }

    public static /* synthetic */ void renderTypeConstructorAndArguments$default(DescriptorRendererImpl r5, StringBuilder r10, KotlinType r11, TypeConstructor r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L5;
        r12 = r11.getConstructor();
    L5:
        r5.renderTypeConstructorAndArguments(r10, r11, r12);
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
        String r5 = r11.getVariance().getLabel();
        boolean r10 = true;
        if (r5.length() <= 0) goto L10;
        boolean r14 = true;
    L11:
        renderModifier(r12, r14, r5);
        renderAnnotations$default(this, r12, r11, null, 2, null);
        renderName(r11, r12, r13);
        int r15 = r11.getUpperBounds().size();
        if (r15 <= 1) goto L14;
        if (r13 == true) goto L14;
    L15:
        KotlinType r16 = r11.getUpperBounds().iterator().next();
        if (KotlinBuiltIns.isDefaultBound(r16) == true) goto L29;
        r12.append(" : ");
        r12.append(renderType(r16));
    L29:
        if (r13 == false) goto L37;
        r12.append(gt());
        return;
    L37:
        return;
    L14:
        if (r15 == 1) goto L15;
        if (r13 == false) goto L29;
        Iterator<KotlinType> r17 = r11.getUpperBounds().iterator();
    L21:
        if (r17.hasNext() == false) goto L29;
        KotlinType r18 = r17.next();
        if (KotlinBuiltIns.isDefaultBound(r18) == true) goto L21;
        if (r10 == false) goto L27;
        r12.append(" : ");
    L28:
        r12.append(renderType(r18));
        r10 = false;
        goto L21
    L27:
        r12.append(" & ");
        goto L28
    L10:
        r14 = false;
        goto L11
    }

    private final void renderTypeParameterList(StringBuilder r5, List<? extends TypeParameterDescriptor> r10) {
        Iterator<? extends TypeParameterDescriptor> r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        renderTypeParameter(r11.next(), r5, false);
        if (r11.hasNext() == false) goto L4;
        r5.append(", ");
        goto L4
    }

    private final void renderTypeParameters(List<? extends TypeParameterDescriptor> r5, StringBuilder r10, boolean r11) {
        if (getWithoutTypeParameters() == false) goto L6;
        return;
    L6:
        if (r5.isEmpty() == true) goto L11;
        r10.append(lt());
        renderTypeParameterList(r10, r5);
        r10.append(gt());
        if (r11 == false) goto L12;
        r10.append(" ");
        return;
    L12:
        return;
    }

    private final void renderValVarPrefix(VariableDescriptor r5, StringBuilder r10, boolean r11) {
        if (r11 == true) goto L6;
        if ((r5 instanceof ValueParameterDescriptor) == false) goto L6;
        return;
    L6:
        if (r5.isVar() == false) goto L8;
        String r12 = "var";
    L9:
        r10.append(renderKeyword(r12));
        r10.append(" ");
        return;
    L8:
        r12 = "val";
        goto L9
    }

    public static /* synthetic */ void renderValVarPrefix$default(DescriptorRendererImpl r5, VariableDescriptor r10, StringBuilder r11, boolean r12, int r13, Object r14) {
        if ((r13 & 4) == 0) goto L5;
        r12 = false;
    L5:
        r5.renderValVarPrefix(r10, r11, r12);
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
        boolean r5 = false;
        if (getRenderPrimaryConstructorParametersAsProperties() == false) goto L17;
        CallableDescriptor r14 = r10.getContainingDeclaration();
        if ((r14 instanceof ClassConstructorDescriptor) == false) goto L12;
        ClassConstructorDescriptor r15 = (ClassConstructorDescriptor) r14;
    L13:
        if (r15 == null) goto L17;
        if (r15.isPrimary() != true) goto L17;
        boolean r16 = true;
    L18:
        if (r16 == false) goto L20;
        renderModifier(r12, getActualPropertiesInPrimaryConstructor(), "actual");
    L20:
        renderVariable(r10, r11, r12, r13, r16);
        if (getDefaultParameterValueRenderer() != null) goto L23;
    L28:
        if (r5 == false) goto L31;
        StringBuilder r17 = new StringBuilder(" = ");
        Function1<ValueParameterDescriptor, String> r18 = getDefaultParameterValueRenderer();
        Intrinsics.checkNotNull(r18);
        r17.append(r18.invoke(r10));
        r12.append(r17.toString());
        return;
    L31:
        return;
    L23:
        if (getDebugMode() == false) goto L25;
        boolean r19 = r10.declaresDefaultValue();
    L26:
        if (r19 == false) goto L28;
        r5 = true;
        goto L28
    L25:
        r19 = DescriptorUtilsKt.declaresOrInheritsDefaultValue(r10);
        goto L26
    L12:
        r15 = null;
    L17:
        r16 = false;
        goto L18
    }

    private final void renderValueParameters(Collection<? extends ValueParameterDescriptor> r10, boolean r11, StringBuilder r12) {
        boolean r13 = shouldRenderParameterNames(r11);
        int r5 = r10.size();
        getValueParametersHandler().appendBeforeValueParameters(r5, r12);
        Iterator<? extends ValueParameterDescriptor> r14 = r10.iterator();
        int r15 = 0;
    L4:
        if (r14.hasNext() == false) goto L6;
        ValueParameterDescriptor r16 = r14.next();
        getValueParametersHandler().appendBeforeValueParameter(r16, r15, r5, r12);
        renderValueParameter(r16, r13, r12, false);
        getValueParametersHandler().appendAfterValueParameter(r16, r15, r5, r12);
        r15 = r15 + 1;
        goto L4
    L6:
        getValueParametersHandler().appendAfterValueParameters(r5, r12);
    }

    private final void renderVariable(VariableDescriptor r10, boolean r11, StringBuilder r12, boolean r13, boolean r14) {
        KotlinType r5 = r10.getType();
        KotlinType r15 = null;
        if ((r10 instanceof ValueParameterDescriptor) == false) goto L5;
        ValueParameterDescriptor r16 = (ValueParameterDescriptor) r10;
    L6:
        if (r16 == null) goto L8;
        r15 = r16.getVarargElementType();
    L8:
        if (r15 != null) goto L10;
        KotlinType r17 = r5;
    L11:
        if (r15 == null) goto L13;
        boolean r18 = true;
    L14:
        renderModifier(r12, r18, "vararg");
        if (r14 == true) goto L19;
        if (r13 == true) goto L18;
    L20:
        if (r11 == false) goto L22;
        renderName(r10, r12, r13);
        r12.append(": ");
    L22:
        r12.append(renderType(r17));
        renderInitializer(r10, r12);
        if (getVerbose() == false) goto L27;
        if (r15 == null) goto L28;
        r12.append(" /*");
        r12.append(renderType(r5));
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
        r18 = false;
        goto L14
    L10:
        r17 = r15;
        goto L11
    L5:
        r16 = null;
        goto L6
    }

    private final boolean renderVisibility(DescriptorVisibility r5, StringBuilder r10) {
        if (getModifiers().contains(DescriptorRendererModifier.VISIBILITY) == true) goto L6;
        return false;
    L6:
        if (getNormalizedVisibilities() == false) goto L9;
        r5 = r5.normalize();
    L9:
        if (getRenderDefaultVisibility() == false) goto L11;
    L13:
        r10.append(renderKeyword(r5.getInternalDisplayName()));
        r10.append(" ");
        return true;
    L11:
        if (Intrinsics.areEqual(r5, DescriptorVisibilities.DEFAULT_VISIBILITY) == false) goto L13;
        return false;
    }

    private final void renderWhereSuffix(List<? extends TypeParameterDescriptor> r10, StringBuilder r11) {
        if (getWithoutTypeParameters() == false) goto L5;
        return;
    L5:
        ArrayList r5 = new ArrayList(0);
        Iterator<? extends TypeParameterDescriptor> r12 = r10.iterator();
    L7:
        if (r12.hasNext() == false) goto L13;
        TypeParameterDescriptor r13 = r12.next();
        Iterator r14 = CollectionsKt.i(r13.getUpperBounds(), 1).iterator();
    L10:
        if (r14.hasNext() == false) goto L7;
        r5.add(renderName(r13.getName(), false) + " : " + renderType((KotlinType) r14.next()));
        goto L10
    L13:
        if (r5.isEmpty() == true) goto L18;
        r11.append(" ");
        r11.append(renderKeyword("where"));
        r11.append(" ");
        CollectionsKt.p(r5, r11, ", ", null, null, null, 124);
        return;
    }

    private final boolean shouldRenderAsPrettyFunctionType(KotlinType r5) {
        if (FunctionTypesKt.isBuiltinFunctionalType(r5) == false) goto L16;
        List<TypeProjection> r10 = r5.getArguments();
        if (r10 != null) goto L7;
    L9:
        Iterator<T> r11 = r10.iterator();
    L11:
        if (r11.hasNext() == false) goto L15;
        if (((TypeProjection) r11.next()).isStarProjection() == false) goto L11;
    L15:
        return true;
    L7:
        if (r10.isEmpty() == false) goto L9;
    L16:
        return false;
    }

    private final boolean shouldRenderParameterNames(boolean r5) {
        ParameterNameRenderingPolicy r10 = getParameterNameRenderingPolicy();
        int r11 = WhenMappings.$EnumSwitchMapping$1[r10.ordinal()];
        if (r11 != 1) goto L5;
        return true;
    L5:
        if (r11 != 2) goto L7;
        if (r5 == true) goto L13;
        return true;
    L13:
        return false;
    L7:
        if (r11 == 3) goto L13;
        throw new NoWhenBranchMatchedException();
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
    public String render(DeclarationDescriptor r5) {
        Intrinsics.checkNotNullParameter(r5, "declarationDescriptor");
        StringBuilder r10 = new StringBuilder();
        r5.accept(new RenderDeclarationDescriptorVisitor(this), r10);
        if (getWithDefinedIn() == false) goto L6;
        appendDefinedIn(r10, r5);
    L6:
        return r10.toString();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer
    public String renderAnnotation(AnnotationDescriptor r10, AnnotationUseSiteTarget r11) {
        Intrinsics.checkNotNullParameter(r10, "annotation");
        StringBuilder r5 = new StringBuilder();
        r5.append('@');
        if (r11 == null) goto L5;
        r5.append(r11.getRenderName() + ':');
    L5:
        KotlinType r12 = r10.getType();
        r5.append(renderType(r12));
        if (getIncludeAnnotationArguments() == false) goto L13;
        List<String> r13 = renderAndSortAnnotationArguments(r10);
        if (getIncludeEmptyAnnotationArguments() == false) goto L10;
    L11:
        CollectionsKt.p(r13, r5, ", ", "(", ")", null, 112);
        goto L13
    L10:
        if (r13.isEmpty() == false) goto L11;
    L13:
        if (getVerbose() == false) goto L20;
        if (KotlinTypeKt.isError(r12) == false) goto L17;
    L18:
        r5.append(" /* annotation class not found */");
        goto L20
    L17:
        if ((r12.getConstructor().mo1402getDeclarationDescriptor() instanceof NotFoundClasses.MockClassDescriptor) == true) goto L18;
    L20:
        return r5.toString();
    }

    public String renderClassifierName(ClassifierDescriptor r5) {
        Intrinsics.checkNotNullParameter(r5, "klass");
        if (ErrorUtils.isError(r5) == false) goto L6;
        return r5.getTypeConstructor().toString();
    L6:
        return getClassifierNamePolicy().renderClassifier(r5, this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer
    public String renderFlexibleType(String r10, String r11, KotlinBuiltIns r12) {
        Intrinsics.checkNotNullParameter(r10, "lowerRendered");
        Intrinsics.checkNotNullParameter(r11, "upperRendered");
        Intrinsics.checkNotNullParameter(r12, "builtIns");
        if (RenderingUtilsKt.typeStringsDifferOnlyInNullability(r10, r11) == true) goto L5;
        String r5 = StringsKt.X(getClassifierNamePolicy().renderClassifier(r12.getCollection(), this), "Collection");
        String r13 = RenderingUtilsKt.replacePrefixesInTypeRepresentations(r10, j0.j(r5, "Mutable"), r11, r5, j0.j(r5, "(Mutable)"));
        if (r13 == null) goto L13;
        return r13;
    L13:
        String r14 = RenderingUtilsKt.replacePrefixesInTypeRepresentations(r10, j0.j(r5, "MutableMap.MutableEntry"), r11, j0.j(r5, "Map.Entry"), j0.j(r5, "(Mutable)Map.(Mutable)Entry"));
        if (r14 == null) goto L16;
        return r14;
    L16:
        String r15 = StringsKt.X(getClassifierNamePolicy().renderClassifier(r12.getArray(), this), "Array");
        StringBuilder r16 = j0.u(r15);
        r16.append(escape("Array<"));
        String r17 = r16.toString();
        StringBuilder r18 = j0.u(r15);
        r18.append(escape("Array<out "));
        String r19 = r18.toString();
        StringBuilder r20 = j0.u(r15);
        r20.append(escape("Array<(out) "));
        String r21 = RenderingUtilsKt.replacePrefixesInTypeRepresentations(r10, r17, r11, r19, r20.toString());
        if (r21 == null) goto L20;
        return r21;
    L20:
        return "(" + r10 + ".." + r11 + ')';
    L5:
        if (StringsKt.P(r11, "(") == false) goto L9;
        return j0.k("(", r10, ")!");
    L9:
        return r10 + '!';
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer
    public String renderFqName(FqNameUnsafe r5) {
        Intrinsics.checkNotNullParameter(r5, "fqName");
        return renderFqName(r5.pathSegments());
    }

    public String renderMessage(String r5) {
        Intrinsics.checkNotNullParameter(r5, "message");
        RenderingFormat r10 = getTextFormat();
        int r11 = WhenMappings.$EnumSwitchMapping$0[r10.ordinal()];
        if (r11 != 1) goto L5;
        return r5;
    L5:
        if (r11 != 2) goto L8;
        return j0.k("<i>", r5, "</i>");
    L8:
        throw new NoWhenBranchMatchedException();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer
    public String renderName(Name r5, boolean r10) {
        Intrinsics.checkNotNullParameter(r5, "name");
        String r11 = escape(RenderingUtilsKt.render(r5));
        if (getBoldOnlyForNamesInHtml() == true) goto L5;
        return r11;
    L5:
        if (getTextFormat() != RenderingFormat.HTML) goto L10;
        if (r10 == true) goto L8;
        return r11;
    L8:
        return j0.k("<b>", r11, "</b>");
    L10:
        return r11;
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer
    public String renderType(KotlinType r5) {
        Intrinsics.checkNotNullParameter(r5, "type");
        StringBuilder r10 = new StringBuilder();
        renderNormalizedType(r10, getTypeNormalizer().invoke(r5));
        return r10.toString();
    }

    public String renderTypeArguments(List<? extends TypeProjection> r5) {
        Intrinsics.checkNotNullParameter(r5, "typeArguments");
        if (r5.isEmpty() == false) goto L5;
        return "";
    L5:
        StringBuilder r10 = new StringBuilder();
        r10.append(lt());
        appendTypeProjections(r10, r5);
        r10.append(gt());
        return r10.toString();
    }

    public String renderTypeConstructor(TypeConstructor r5) {
        Intrinsics.checkNotNullParameter(r5, "typeConstructor");
        ClassifierDescriptor r10 = r5.mo1402getDeclarationDescriptor();
        boolean r11 = true;
        if ((r10 instanceof TypeParameterDescriptor) == false) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == true) goto L9;
        r11 = r10 instanceof TypeAliasDescriptor;
    L9:
        if (r11 == true) goto L19;
        if (r10 != null) goto L18;
        if ((r5 instanceof IntersectionTypeConstructor) == false) goto L16;
        return ((IntersectionTypeConstructor) r5).makeDebugNameForIntersectionType(C02341.INSTANCE);
    L16:
        return r5.toString();
    L18:
        throw new IllegalStateException(("Unexpected classifier: " + r10.getClass()).toString());
    L19:
        return renderClassifierName(r10);
    L5:
        r12 = r10 instanceof ClassDescriptor;
        goto L6
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer
    public String renderTypeProjection(TypeProjection r5) {
        Intrinsics.checkNotNullParameter(r5, "typeProjection");
        StringBuilder r10 = new StringBuilder();
        appendTypeProjections(r10, CollectionsKt.listOf(r5));
        return r10.toString();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setAnnotationArgumentsRenderingPolicy(AnnotationArgumentsRenderingPolicy r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.options.setAnnotationArgumentsRenderingPolicy(r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setClassifierNamePolicy(ClassifierNamePolicy r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.options.setClassifierNamePolicy(r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setDebugMode(boolean r5) {
        this.options.setDebugMode(r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setExcludedTypeAnnotationClasses(Set<FqName> r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.options.setExcludedTypeAnnotationClasses(r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setModifiers(Set<? extends DescriptorRendererModifier> r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.options.setModifiers(r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setParameterNameRenderingPolicy(ParameterNameRenderingPolicy r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.options.setParameterNameRenderingPolicy(r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setReceiverAfterName(boolean r5) {
        this.options.setReceiverAfterName(r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setRenderCompanionObjectName(boolean r5) {
        this.options.setRenderCompanionObjectName(r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setStartFromName(boolean r5) {
        this.options.setStartFromName(r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setTextFormat(RenderingFormat r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.options.setTextFormat(r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setVerbose(boolean r5) {
        this.options.setVerbose(r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setWithDefinedIn(boolean r5) {
        this.options.setWithDefinedIn(r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setWithoutSuperTypes(boolean r5) {
        this.options.setWithoutSuperTypes(r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setWithoutTypeParameters(boolean r5) {
        this.options.setWithoutTypeParameters(r5);
    }

    private final String renderFqName(List<Name> r5) {
        return escape(RenderingUtilsKt.renderFqName(r5));
    }

    private final void renderName(DeclarationDescriptor r5, StringBuilder r10, boolean r11) {
        r10.append(renderName(r5.getName(), r11));
    }
}
