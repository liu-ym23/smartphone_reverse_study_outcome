package kotlin.reflect.jvm.internal.impl.renderer;

import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
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

/* JADX INFO: loaded from: classes3.dex */
public abstract class DescriptorRenderer {

    @JvmField
    public static final DescriptorRenderer COMPACT = null;

    @JvmField
    public static final DescriptorRenderer COMPACT_WITHOUT_SUPERTYPES = null;

    @JvmField
    public static final DescriptorRenderer COMPACT_WITH_MODIFIERS = null;

    @JvmField
    public static final DescriptorRenderer COMPACT_WITH_SHORT_TYPES = null;
    public static final Companion Companion = null;

    @JvmField
    public static final DescriptorRenderer DEBUG_TEXT = null;

    @JvmField
    public static final DescriptorRenderer FQ_NAMES_IN_TYPES = null;

    @JvmField
    public static final DescriptorRenderer FQ_NAMES_IN_TYPES_WITH_ANNOTATIONS = null;

    @JvmField
    public static final DescriptorRenderer HTML = null;

    @JvmField
    public static final DescriptorRenderer ONLY_NAMES_WITH_SHORT_TYPES = null;

    @JvmField
    public static final DescriptorRenderer SHORT_NAMES_IN_TYPES = null;

    public static final class Companion {

        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

            static {
                int[] r10 = new int[ClassKind.values().length];
                r10[ClassKind.CLASS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
            L19:
                r10[ClassKind.INTERFACE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
            L27:
                r10[ClassKind.ENUM_CLASS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
            L21:
                r10[ClassKind.OBJECT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
            L23:
                r10[ClassKind.ANNOTATION_CLASS.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
            L17:
                r10[ClassKind.ENUM_ENTRY.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
            L9:
                $EnumSwitchMapping$0 = r10;
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }

        public final String getClassifierKindPrefix(ClassifierDescriptorWithTypeParameters r10) {
            Intrinsics.checkNotNullParameter(r10, "classifier");
            if ((r10 instanceof TypeAliasDescriptor) == false) goto L6;
            return "typealias";
        L6:
            if ((r10 instanceof ClassDescriptor) == false) goto L22;
            ClassDescriptor r11 = (ClassDescriptor) r10;
            if (r11.isCompanionObject() == false) goto L11;
            return "companion object";
        L11:
            switch(WhenMappings.$EnumSwitchMapping$0[r11.getKind().ordinal()]) {
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
            throw new AssertionError("Unexpected classifier: " + r10);
        }

        public final DescriptorRenderer withOptions(Function1<? super DescriptorRendererOptions, Unit> r10) {
            Intrinsics.checkNotNullParameter(r10, "changeOptions");
            DescriptorRendererOptionsImpl r11 = new DescriptorRendererOptionsImpl();
            r10.invoke(r11);
            r11.lock();
            return new DescriptorRendererImpl(r11);
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
            public void appendAfterValueParameter(ValueParameterDescriptor r10, int r11, int r12, StringBuilder r13) {
                Intrinsics.checkNotNullParameter(r10, "parameter");
                Intrinsics.checkNotNullParameter(r13, "builder");
                if (r11 == (r12 - 1)) goto L6;
                r13.append(", ");
                return;
            }

            @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer.ValueParametersHandler
            public void appendAfterValueParameters(int r10, StringBuilder r11) {
                Intrinsics.checkNotNullParameter(r11, "builder");
                r11.append(")");
            }

            @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer.ValueParametersHandler
            public void appendBeforeValueParameter(ValueParameterDescriptor r10, int r11, int r12, StringBuilder r13) {
                Intrinsics.checkNotNullParameter(r10, "parameter");
                Intrinsics.checkNotNullParameter(r13, "builder");
            }

            @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer.ValueParametersHandler
            public void appendBeforeValueParameters(int r10, StringBuilder r11) {
                Intrinsics.checkNotNullParameter(r11, "builder");
                r11.append("(");
            }
        }

        void appendAfterValueParameter(ValueParameterDescriptor r10, int r11, int r12, StringBuilder r13);

        void appendAfterValueParameters(int r10, StringBuilder r11);

        void appendBeforeValueParameter(ValueParameterDescriptor r10, int r11, int r12, StringBuilder r13);

        void appendBeforeValueParameters(int r10, StringBuilder r11);
    }

    static {
        Companion r10 = new Companion(null);
        Companion = r10;
        COMPACT_WITH_MODIFIERS = r10.withOptions(DescriptorRenderer$Companion$COMPACT_WITH_MODIFIERS$1.INSTANCE);
        COMPACT = r10.withOptions(DescriptorRenderer$Companion$COMPACT$1.INSTANCE);
        COMPACT_WITHOUT_SUPERTYPES = r10.withOptions(DescriptorRenderer$Companion$COMPACT_WITHOUT_SUPERTYPES$1.INSTANCE);
        COMPACT_WITH_SHORT_TYPES = r10.withOptions(DescriptorRenderer$Companion$COMPACT_WITH_SHORT_TYPES$1.INSTANCE);
        ONLY_NAMES_WITH_SHORT_TYPES = r10.withOptions(DescriptorRenderer$Companion$ONLY_NAMES_WITH_SHORT_TYPES$1.INSTANCE);
        FQ_NAMES_IN_TYPES = r10.withOptions(DescriptorRenderer$Companion$FQ_NAMES_IN_TYPES$1.INSTANCE);
        FQ_NAMES_IN_TYPES_WITH_ANNOTATIONS = r10.withOptions(DescriptorRenderer$Companion$FQ_NAMES_IN_TYPES_WITH_ANNOTATIONS$1.INSTANCE);
        SHORT_NAMES_IN_TYPES = r10.withOptions(DescriptorRenderer$Companion$SHORT_NAMES_IN_TYPES$1.INSTANCE);
        DEBUG_TEXT = r10.withOptions(DescriptorRenderer$Companion$DEBUG_TEXT$1.INSTANCE);
        HTML = r10.withOptions(DescriptorRenderer$Companion$HTML$1.INSTANCE);
    }

    public DescriptorRenderer() {
    }

    public static /* synthetic */ String renderAnnotation$default(DescriptorRenderer r10, AnnotationDescriptor r11, AnnotationUseSiteTarget r12, int r13, Object r14) {
        if (r14 != null) goto L9;
        if ((r13 & 2) == 0) goto L7;
        r12 = null;
    L7:
        return r10.renderAnnotation(r11, r12);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: renderAnnotation");
    }

    public abstract String render(DeclarationDescriptor r10);

    public abstract String renderAnnotation(AnnotationDescriptor r10, AnnotationUseSiteTarget r11);

    public abstract String renderFlexibleType(String r10, String r11, KotlinBuiltIns r12);

    public abstract String renderFqName(FqNameUnsafe r10);

    public abstract String renderName(Name r10, boolean r11);

    public abstract String renderType(KotlinType r10);

    public abstract String renderTypeProjection(TypeProjection r10);

    public final DescriptorRenderer withOptions(Function1<? super DescriptorRendererOptions, Unit> r10) {
        Intrinsics.checkNotNullParameter(r10, "changeOptions");
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type org.jetbrains.kotlin.renderer.DescriptorRendererImpl");
        DescriptorRendererOptionsImpl r11 = ((DescriptorRendererImpl) this).getOptions().copy();
        r10.invoke(r11);
        r11.lock();
        return new DescriptorRendererImpl(r11);
    }
}
