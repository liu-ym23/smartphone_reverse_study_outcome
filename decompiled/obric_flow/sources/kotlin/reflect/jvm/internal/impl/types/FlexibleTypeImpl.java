package kotlin.reflect.jvm.internal.impl.types;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nflexibleTypes.kt\nKotlin\n*S Kotlin\n*F\n+ 1 flexibleTypes.kt\norg/jetbrains/kotlin/types/FlexibleTypeImpl\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,185:1\n1#2:186\n*E\n"})
public final class FlexibleTypeImpl extends FlexibleType implements CustomTypeParameter {
    public static final Companion Companion = null;

    @JvmField
    public static boolean RUN_SLOW_ASSERTIONS;
    private boolean assertionsDone;

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public FlexibleTypeImpl(SimpleType r5, SimpleType r10) {
        Intrinsics.checkNotNullParameter(r5, "lowerBound");
        Intrinsics.checkNotNullParameter(r10, "upperBound");
        super(r5, r10);
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
        if ((getLowerBound().getConstructor().mo1402getDeclarationDescriptor() instanceof TypeParameterDescriptor) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(getLowerBound().getConstructor(), getUpperBound().getConstructor()) == false) goto L7;
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public UnwrappedType makeNullableAsSpecified(boolean r5) {
        return KotlinTypeFactory.flexibleType(getLowerBound().makeNullableAsSpecified(r5), getUpperBound().makeNullableAsSpecified(r5));
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    public /* bridge */ /* synthetic */ KotlinType refine(KotlinTypeRefiner r5) {
        return refine(r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.FlexibleType
    public String render(DescriptorRenderer r5, DescriptorRendererOptions r10) {
        Intrinsics.checkNotNullParameter(r5, "renderer");
        Intrinsics.checkNotNullParameter(r10, "options");
        if (r10.getDebugMode() == false) goto L7;
        return "(" + r5.renderType(getLowerBound()) + ".." + r5.renderType(getUpperBound()) + ')';
    L7:
        return r5.renderFlexibleType(r5.renderType(getLowerBound()), r5.renderType(getUpperBound()), TypeUtilsKt.getBuiltIns(this));
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public UnwrappedType replaceAttributes(TypeAttributes r5) {
        Intrinsics.checkNotNullParameter(r5, "newAttributes");
        return KotlinTypeFactory.flexibleType(getLowerBound().replaceAttributes(r5), getUpperBound().replaceAttributes(r5));
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.CustomTypeParameter
    public KotlinType substitutionResult(KotlinType r5) {
        Intrinsics.checkNotNullParameter(r5, "replacement");
        UnwrappedType r10 = r5.unwrap();
        if ((r10 instanceof FlexibleType) == false) goto L6;
        UnwrappedType r11 = r10;
    L9:
        return TypeWithEnhancementKt.inheritEnhancement(r11, r10);
    L6:
        if ((r10 instanceof SimpleType) == false) goto L11;
        SimpleType r12 = (SimpleType) r10;
        r11 = KotlinTypeFactory.flexibleType(r12, r12.makeNullableAsSpecified(true));
        goto L9
    L11:
        throw new NoWhenBranchMatchedException();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.FlexibleType
    public String toString() {
        return "(" + getLowerBound() + ".." + getUpperBound() + ')';
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType, kotlin.reflect.jvm.internal.impl.types.KotlinType
    public /* bridge */ /* synthetic */ UnwrappedType refine(KotlinTypeRefiner r5) {
        return refine(r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType, kotlin.reflect.jvm.internal.impl.types.KotlinType
    public FlexibleType refine(KotlinTypeRefiner r5) {
        Intrinsics.checkNotNullParameter(r5, "kotlinTypeRefiner");
        KotlinType r10 = r5.refineType(getLowerBound());
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        KotlinType r11 = r5.refineType(getUpperBound());
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        return new FlexibleTypeImpl((SimpleType) r10, (SimpleType) r11);
    }
}
