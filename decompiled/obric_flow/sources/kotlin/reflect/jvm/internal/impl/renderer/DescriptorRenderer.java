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
                int[] r5 = new int[ClassKind.values().length];
                r5[ClassKind.CLASS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
            L19:
                r5[ClassKind.INTERFACE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
            L27:
                r5[ClassKind.ENUM_CLASS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
            L21:
                r5[ClassKind.OBJECT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
            L23:
                r5[ClassKind.ANNOTATION_CLASS.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
            L17:
                r5[ClassKind.ENUM_ENTRY.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
            L9:
                $EnumSwitchMapping$0 = r5;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        public final String getClassifierKindPrefix(ClassifierDescriptorWithTypeParameters r5) {
            Intrinsics.checkNotNullParameter(r5, "classifier");
            if ((r5 instanceof TypeAliasDescriptor) == false) goto L6;
            return "typealias";
        L6:
            if ((r5 instanceof ClassDescriptor) == false) goto L22;
            ClassDescriptor r10 = (ClassDescriptor) r5;
            if (r10.isCompanionObject() == false) goto L11;
            return "companion object";
        L11:
            switch(WhenMappings.$EnumSwitchMapping$0[r10.getKind().ordinal()]) {
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
            throw new AssertionError("Unexpected classifier: " + r5);
        }

        public final DescriptorRenderer withOptions(Function1<? super DescriptorRendererOptions, Unit> r5) {
            Intrinsics.checkNotNullParameter(r5, "changeOptions");
            DescriptorRendererOptionsImpl r10 = new DescriptorRendererOptionsImpl();
            r5.invoke(r10);
            r10.lock();
            return new DescriptorRendererImpl(r10);
        }

        private Companion() {
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
            public void appendAfterValueParameter(ValueParameterDescriptor r5, int r10, int r11, StringBuilder r12) {
                Intrinsics.checkNotNullParameter(r5, "parameter");
                Intrinsics.checkNotNullParameter(r12, "builder");
                if (r10 == (r11 - 1)) goto L6;
                r12.append(", ");
                return;
            }

            @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer.ValueParametersHandler
            public void appendAfterValueParameters(int r5, StringBuilder r10) {
                Intrinsics.checkNotNullParameter(r10, "builder");
                r10.append(")");
            }

            @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer.ValueParametersHandler
            public void appendBeforeValueParameter(ValueParameterDescriptor r5, int r10, int r11, StringBuilder r12) {
                Intrinsics.checkNotNullParameter(r5, "parameter");
                Intrinsics.checkNotNullParameter(r12, "builder");
            }

            @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer.ValueParametersHandler
            public void appendBeforeValueParameters(int r5, StringBuilder r10) {
                Intrinsics.checkNotNullParameter(r10, "builder");
                r10.append("(");
            }
        }

        void appendAfterValueParameter(ValueParameterDescriptor r5, int r10, int r11, StringBuilder r12);

        void appendAfterValueParameters(int r5, StringBuilder r10);

        void appendBeforeValueParameter(ValueParameterDescriptor r5, int r10, int r11, StringBuilder r12);

        void appendBeforeValueParameters(int r5, StringBuilder r10);
    }

    static {
        Companion r5 = new Companion(null);
        Companion = r5;
        COMPACT_WITH_MODIFIERS = r5.withOptions(DescriptorRenderer$Companion$COMPACT_WITH_MODIFIERS$1.INSTANCE);
        COMPACT = r5.withOptions(DescriptorRenderer$Companion$COMPACT$1.INSTANCE);
        COMPACT_WITHOUT_SUPERTYPES = r5.withOptions(DescriptorRenderer$Companion$COMPACT_WITHOUT_SUPERTYPES$1.INSTANCE);
        COMPACT_WITH_SHORT_TYPES = r5.withOptions(DescriptorRenderer$Companion$COMPACT_WITH_SHORT_TYPES$1.INSTANCE);
        ONLY_NAMES_WITH_SHORT_TYPES = r5.withOptions(DescriptorRenderer$Companion$ONLY_NAMES_WITH_SHORT_TYPES$1.INSTANCE);
        FQ_NAMES_IN_TYPES = r5.withOptions(DescriptorRenderer$Companion$FQ_NAMES_IN_TYPES$1.INSTANCE);
        FQ_NAMES_IN_TYPES_WITH_ANNOTATIONS = r5.withOptions(DescriptorRenderer$Companion$FQ_NAMES_IN_TYPES_WITH_ANNOTATIONS$1.INSTANCE);
        SHORT_NAMES_IN_TYPES = r5.withOptions(DescriptorRenderer$Companion$SHORT_NAMES_IN_TYPES$1.INSTANCE);
        DEBUG_TEXT = r5.withOptions(DescriptorRenderer$Companion$DEBUG_TEXT$1.INSTANCE);
        HTML = r5.withOptions(DescriptorRenderer$Companion$HTML$1.INSTANCE);
    }

    public DescriptorRenderer() {
    }

    public static /* synthetic */ String renderAnnotation$default(DescriptorRenderer r5, AnnotationDescriptor r10, AnnotationUseSiteTarget r11, int r12, Object r13) {
        if (r13 != null) goto L9;
        if ((r12 & 2) == 0) goto L7;
        r11 = null;
    L7:
        return r5.renderAnnotation(r10, r11);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: renderAnnotation");
    }

    public abstract String render(DeclarationDescriptor r5);

    public abstract String renderAnnotation(AnnotationDescriptor r5, AnnotationUseSiteTarget r10);

    public abstract String renderFlexibleType(String r5, String r10, KotlinBuiltIns r11);

    public abstract String renderFqName(FqNameUnsafe r5);

    public abstract String renderName(Name r5, boolean r10);

    public abstract String renderType(KotlinType r5);

    public abstract String renderTypeProjection(TypeProjection r5);

    public final DescriptorRenderer withOptions(Function1<? super DescriptorRendererOptions, Unit> r5) {
        Intrinsics.checkNotNullParameter(r5, "changeOptions");
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type org.jetbrains.kotlin.renderer.DescriptorRendererImpl");
        DescriptorRendererOptionsImpl r10 = ((DescriptorRendererImpl) this).getOptions().copy();
        r5.invoke(r10);
        r10.lock();
        return new DescriptorRendererImpl(r10);
    }
}
