package kotlin.reflect.jvm.internal.impl.renderer;

import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUseSiteTarget;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public abstract class DescriptorRenderer {
    public static final DescriptorRenderer COMPACT = null;
    public static final DescriptorRenderer COMPACT_WITHOUT_SUPERTYPES = null;
    public static final DescriptorRenderer COMPACT_WITH_MODIFIERS = null;
    public static final DescriptorRenderer COMPACT_WITH_SHORT_TYPES = null;
    public static final Companion Companion = null;
    public static final DescriptorRenderer DEBUG_TEXT = null;
    public static final DescriptorRenderer FQ_NAMES_IN_TYPES = null;
    public static final DescriptorRenderer FQ_NAMES_IN_TYPES_WITH_ANNOTATIONS = null;
    public static final DescriptorRenderer HTML = null;
    public static final DescriptorRenderer ONLY_NAMES_WITH_SHORT_TYPES = null;
    public static final DescriptorRenderer SHORT_NAMES_IN_TYPES = null;
    public static final DescriptorRenderer WITHOUT_MODIFIERS = null;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final String getClassifierKindPrefix(ClassifierDescriptorWithTypeParameters r4) {
            Intrinsics.checkNotNullParameter(r4, "classifier");
            if ((r4 instanceof TypeAliasDescriptor) == false) goto L6;
            return "typealias";
        L6:
            if ((r4 instanceof ClassDescriptor) == false) goto L22;
            ClassDescriptor r5 = (ClassDescriptor) r4;
            if (r5.isCompanionObject() == false) goto L11;
            return "companion object";
        L11:
            switch(WhenMappings.$EnumSwitchMapping$0[r5.getKind().ordinal()]) {
                case 1: goto L19;
                case 2: goto L18;
                case 3: goto L17;
                case 4: goto L16;
                case 5: goto L15;
                case 6: goto L14;
                default: goto L13;
            };
        L14:
            return "enum entry";
        L15:
            return "annotation class";
        L16:
            return "object";
        L17:
            return "enum class";
        L18:
            return "interface";
        L19:
            return "class";
        L13:
            throw new NoWhenBranchMatchedException();
        L22:
            throw new AssertionError("Unexpected classifier: " + r4);
        }

        public final DescriptorRenderer withOptions(Function1<? super DescriptorRendererOptions, Unit> r2) {
            Intrinsics.checkNotNullParameter(r2, "changeOptions");
            DescriptorRendererOptionsImpl r0 = new DescriptorRendererOptionsImpl();
            r2.invoke(r0);
            r0.lock();
            return new DescriptorRendererImpl(r0);
        }
    }

    public interface ValueParametersHandler {

        public static final class DEFAULT implements ValueParametersHandler {
            public static final DEFAULT INSTANCE = null;

            static {
                INSTANCE = new DEFAULT();
            }

            private DEFAULT() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer.ValueParametersHandler
            public void appendBeforeValueParameter(ValueParameterDescriptor r1, int r2, int r3, StringBuilder r4) {
                Intrinsics.checkNotNullParameter(r1, "parameter");
                Intrinsics.checkNotNullParameter(r4, "builder");
            }

            @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer.ValueParametersHandler
            public void appendAfterValueParameters(int r1, StringBuilder r2) {
                Intrinsics.checkNotNullParameter(r2, "builder");
                r2.append(")");
            }

            @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer.ValueParametersHandler
            public void appendBeforeValueParameters(int r1, StringBuilder r2) {
                Intrinsics.checkNotNullParameter(r2, "builder");
                r2.append("(");
            }

            @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer.ValueParametersHandler
            public void appendAfterValueParameter(ValueParameterDescriptor r2, int r3, int r4, StringBuilder r5) {
                Intrinsics.checkNotNullParameter(r2, "parameter");
                Intrinsics.checkNotNullParameter(r5, "builder");
                if (r3 == (r4 - 1)) goto L6;
                r5.append(", ");
                return;
            }
        }

        void appendAfterValueParameter(ValueParameterDescriptor r1, int r2, int r3, StringBuilder r4);

        void appendAfterValueParameters(int r1, StringBuilder r2);

        void appendBeforeValueParameter(ValueParameterDescriptor r1, int r2, int r3, StringBuilder r4);

        void appendBeforeValueParameters(int r1, StringBuilder r2);
    }

    public DescriptorRenderer() {
    }

    public static /* synthetic */ Unit accessor$DescriptorRenderer$lambda0(DescriptorRendererOptions r0) {
        return WITHOUT_MODIFIERS$lambda$0(r0);
    }

    public static /* synthetic */ Unit accessor$DescriptorRenderer$lambda1(DescriptorRendererOptions r0) {
        return COMPACT_WITH_MODIFIERS$lambda$1(r0);
    }

    public static /* synthetic */ Unit accessor$DescriptorRenderer$lambda10(DescriptorRendererOptions r0) {
        return HTML$lambda$10(r0);
    }

    public static /* synthetic */ Unit accessor$DescriptorRenderer$lambda2(DescriptorRendererOptions r0) {
        return COMPACT$lambda$2(r0);
    }

    public static /* synthetic */ Unit accessor$DescriptorRenderer$lambda3(DescriptorRendererOptions r0) {
        return COMPACT_WITHOUT_SUPERTYPES$lambda$3(r0);
    }

    public static /* synthetic */ Unit accessor$DescriptorRenderer$lambda4(DescriptorRendererOptions r0) {
        return COMPACT_WITH_SHORT_TYPES$lambda$4(r0);
    }

    public static /* synthetic */ Unit accessor$DescriptorRenderer$lambda5(DescriptorRendererOptions r0) {
        return ONLY_NAMES_WITH_SHORT_TYPES$lambda$5(r0);
    }

    public static /* synthetic */ Unit accessor$DescriptorRenderer$lambda6(DescriptorRendererOptions r0) {
        return FQ_NAMES_IN_TYPES$lambda$6(r0);
    }

    public static /* synthetic */ Unit accessor$DescriptorRenderer$lambda7(DescriptorRendererOptions r0) {
        return FQ_NAMES_IN_TYPES_WITH_ANNOTATIONS$lambda$7(r0);
    }

    public static /* synthetic */ Unit accessor$DescriptorRenderer$lambda8(DescriptorRendererOptions r0) {
        return SHORT_NAMES_IN_TYPES$lambda$8(r0);
    }

    public static /* synthetic */ Unit accessor$DescriptorRenderer$lambda9(DescriptorRendererOptions r0) {
        return DEBUG_TEXT$lambda$9(r0);
    }

    public abstract String render(DeclarationDescriptor r1);

    public abstract String renderAnnotation(AnnotationDescriptor r1, AnnotationUseSiteTarget r2);

    public abstract String renderFlexibleType(String r1, String r2, KotlinBuiltIns r3);

    public abstract String renderFqName(FqNameUnsafe r1);

    public abstract String renderName(Name r1, boolean r2);

    public abstract String renderType(KotlinType r1);

    public abstract String renderTypeProjection(TypeProjection r1);

    static {
        Companion r0 = new Companion(null);
        Companion = r0;
        WITHOUT_MODIFIERS = r0.withOptions(DescriptorRenderer$$Lambda$0.INSTANCE);
        COMPACT_WITH_MODIFIERS = r0.withOptions(DescriptorRenderer$$Lambda$1.INSTANCE);
        COMPACT = r0.withOptions(DescriptorRenderer$$Lambda$2.INSTANCE);
        COMPACT_WITHOUT_SUPERTYPES = r0.withOptions(DescriptorRenderer$$Lambda$3.INSTANCE);
        COMPACT_WITH_SHORT_TYPES = r0.withOptions(DescriptorRenderer$$Lambda$4.INSTANCE);
        ONLY_NAMES_WITH_SHORT_TYPES = r0.withOptions(DescriptorRenderer$$Lambda$5.INSTANCE);
        FQ_NAMES_IN_TYPES = r0.withOptions(DescriptorRenderer$$Lambda$6.INSTANCE);
        FQ_NAMES_IN_TYPES_WITH_ANNOTATIONS = r0.withOptions(DescriptorRenderer$$Lambda$7.INSTANCE);
        SHORT_NAMES_IN_TYPES = r0.withOptions(DescriptorRenderer$$Lambda$8.INSTANCE);
        DEBUG_TEXT = r0.withOptions(DescriptorRenderer$$Lambda$9.INSTANCE);
        HTML = r0.withOptions(DescriptorRenderer$$Lambda$10.INSTANCE);
    }

    private static final Unit COMPACT$lambda$2(DescriptorRendererOptions r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$withOptions");
        r1.setWithDefinedIn(false);
        r1.setModifiers(SetsKt.emptySet());
        return Unit.INSTANCE;
    }

    private static final Unit COMPACT_WITHOUT_SUPERTYPES$lambda$3(DescriptorRendererOptions r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$withOptions");
        r1.setWithDefinedIn(false);
        r1.setModifiers(SetsKt.emptySet());
        r1.setWithoutSuperTypes(true);
        return Unit.INSTANCE;
    }

    private static final Unit COMPACT_WITH_MODIFIERS$lambda$1(DescriptorRendererOptions r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$withOptions");
        r1.setWithDefinedIn(false);
        return Unit.INSTANCE;
    }

    private static final Unit COMPACT_WITH_SHORT_TYPES$lambda$4(DescriptorRendererOptions r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$withOptions");
        r1.setModifiers(SetsKt.emptySet());
        r1.setClassifierNamePolicy(ClassifierNamePolicy.SHORT.INSTANCE);
        r1.setParameterNameRenderingPolicy(ParameterNameRenderingPolicy.ONLY_NON_SYNTHESIZED);
        return Unit.INSTANCE;
    }

    private static final Unit DEBUG_TEXT$lambda$9(DescriptorRendererOptions r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$withOptions");
        r1.setDebugMode(true);
        r1.setClassifierNamePolicy(ClassifierNamePolicy.FULLY_QUALIFIED.INSTANCE);
        r1.setModifiers(DescriptorRendererModifier.ALL);
        return Unit.INSTANCE;
    }

    private static final Unit FQ_NAMES_IN_TYPES$lambda$6(DescriptorRendererOptions r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$withOptions");
        r1.setModifiers(DescriptorRendererModifier.ALL_EXCEPT_ANNOTATIONS);
        return Unit.INSTANCE;
    }

    private static final Unit FQ_NAMES_IN_TYPES_WITH_ANNOTATIONS$lambda$7(DescriptorRendererOptions r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$withOptions");
        r1.setModifiers(DescriptorRendererModifier.ALL);
        return Unit.INSTANCE;
    }

    private static final Unit HTML$lambda$10(DescriptorRendererOptions r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$withOptions");
        r1.setTextFormat(RenderingFormat.HTML);
        r1.setModifiers(DescriptorRendererModifier.ALL);
        return Unit.INSTANCE;
    }

    private static final Unit ONLY_NAMES_WITH_SHORT_TYPES$lambda$5(DescriptorRendererOptions r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$withOptions");
        r2.setWithDefinedIn(false);
        r2.setModifiers(SetsKt.emptySet());
        r2.setClassifierNamePolicy(ClassifierNamePolicy.SHORT.INSTANCE);
        r2.setWithoutTypeParameters(true);
        r2.setParameterNameRenderingPolicy(ParameterNameRenderingPolicy.NONE);
        r2.setReceiverAfterName(true);
        r2.setRenderCompanionObjectName(true);
        r2.setWithoutSuperTypes(true);
        r2.setStartFromName(true);
        return Unit.INSTANCE;
    }

    private static final Unit SHORT_NAMES_IN_TYPES$lambda$8(DescriptorRendererOptions r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$withOptions");
        r1.setClassifierNamePolicy(ClassifierNamePolicy.SHORT.INSTANCE);
        r1.setParameterNameRenderingPolicy(ParameterNameRenderingPolicy.ONLY_NON_SYNTHESIZED);
        return Unit.INSTANCE;
    }

    private static final Unit WITHOUT_MODIFIERS$lambda$0(DescriptorRendererOptions r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$withOptions");
        r1.setModifiers(SetsKt.emptySet());
        return Unit.INSTANCE;
    }

    public final DescriptorRenderer withOptions(Function1<? super DescriptorRendererOptions, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "changeOptions");
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type org.jetbrains.kotlin.renderer.DescriptorRendererImpl");
        DescriptorRendererOptionsImpl r0 = ((DescriptorRendererImpl) this).getOptions().copy();
        r2.invoke(r0);
        r0.lock();
        return new DescriptorRendererImpl(r0);
    }

    public static /* synthetic */ String renderAnnotation$default(DescriptorRenderer r0, AnnotationDescriptor r1, AnnotationUseSiteTarget r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 2) == 0) goto L7;
        r2 = null;
    L7:
        return r0.renderAnnotation(r1, r2);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: renderAnnotation");
    }
}
