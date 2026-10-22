package kotlin.reflect.jvm.internal.impl.types;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class FlexibleTypeImpl extends FlexibleType implements CustomTypeParameter {
    public static final Companion Companion = null;

    @JvmField
    public static boolean RUN_SLOW_ASSERTIONS;
    private boolean assertionsDone;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public FlexibleTypeImpl(SimpleType r10, SimpleType r11) {
        Intrinsics.checkNotNullParameter(r10, "lowerBound");
        Intrinsics.checkNotNullParameter(r11, "upperBound");
        super(r10, r11);
    }

    private final void runAssertions() {
        if (RUN_SLOW_ASSERTIONS == true) goto L5;
        return;
    L5:
        if (this.assertionsDone == true) goto L10;
        this.assertionsDone = true;
        FlexibleTypesKt.isFlexible(getLowerBound());
        FlexibleTypesKt.isFlexible(getUpperBound());
        Intrinsics.areEqual(getLowerBound(), getUpperBound());
        KotlinTypeChecker.DEFAULT.isSubtypeOf(getLowerBound(), getUpperBound());
        return;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.FlexibleType
    public SimpleType getDelegate() {
        runAssertions();
        return getLowerBound();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.CustomTypeParameter
    public boolean isTypeParameter() {
        if ((getLowerBound().getConstructor().mo1323getDeclarationDescriptor() instanceof TypeParameterDescriptor) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(getLowerBound().getConstructor(), getUpperBound().getConstructor()) == false) goto L7;
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public UnwrappedType makeNullableAsSpecified(boolean r10) {
        return KotlinTypeFactory.flexibleType(getLowerBound().makeNullableAsSpecified(r10), getUpperBound().makeNullableAsSpecified(r10));
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType, kotlin.reflect.jvm.internal.impl.types.KotlinType
    public FlexibleType refine(KotlinTypeRefiner r10) {
        Intrinsics.checkNotNullParameter(r10, "kotlinTypeRefiner");
        KotlinType r11 = r10.refineType(getLowerBound());
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        KotlinType r12 = r10.refineType(getUpperBound());
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        return new FlexibleTypeImpl((SimpleType) r11, (SimpleType) r12);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    public /* bridge */ /* synthetic */ KotlinType refine(KotlinTypeRefiner r10) {
        return refine(r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType, kotlin.reflect.jvm.internal.impl.types.KotlinType
    public /* bridge */ /* synthetic */ UnwrappedType refine(KotlinTypeRefiner r10) {
        return refine(r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.FlexibleType
    public String render(DescriptorRenderer r10, DescriptorRendererOptions r11) {
        Intrinsics.checkNotNullParameter(r10, "renderer");
        Intrinsics.checkNotNullParameter(r11, "options");
        if (r11.getDebugMode() == false) goto L7;
        return '(' + r10.renderType(getLowerBound()) + ".." + r10.renderType(getUpperBound()) + ')';
    L7:
        return r10.renderFlexibleType(r10.renderType(getLowerBound()), r10.renderType(getUpperBound()), TypeUtilsKt.getBuiltIns(this));
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public UnwrappedType replaceAttributes(TypeAttributes r10) {
        Intrinsics.checkNotNullParameter(r10, "newAttributes");
        return KotlinTypeFactory.flexibleType(getLowerBound().replaceAttributes(r10), getUpperBound().replaceAttributes(r10));
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.CustomTypeParameter
    public KotlinType substitutionResult(KotlinType r10) {
        Intrinsics.checkNotNullParameter(r10, "replacement");
        UnwrappedType r11 = r10.unwrap();
        if ((r11 instanceof FlexibleType) == false) goto L6;
        UnwrappedType r12 = r11;
    L9:
        return TypeWithEnhancementKt.inheritEnhancement(r12, r11);
    L6:
        if ((r11 instanceof SimpleType) == false) goto L11;
        SimpleType r13 = (SimpleType) r11;
        r12 = KotlinTypeFactory.flexibleType(r13, r13.makeNullableAsSpecified(true));
        goto L9
    L11:
        throw new NoWhenBranchMatchedException();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.FlexibleType
    public String toString() {
        return '(' + getLowerBound() + ".." + getUpperBound() + ')';
    }
}
