package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedType;
import kotlin.reflect.jvm.internal.impl.types.checker.NewTypeVariableConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.NullabilityChecker;
import kotlin.reflect.jvm.internal.impl.types.model.DefinitelyNotNullTypeMarker;

/* JADX INFO: loaded from: classes3.dex */
public final class DefinitelyNotNullType extends DelegatingSimpleType implements CustomTypeParameter, DefinitelyNotNullTypeMarker {
    public static final Companion Companion = null;
    private final SimpleType original;
    private final boolean useCorrectedNullabilityForTypeParameters;

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        private final boolean canHaveUndefinedNullability(UnwrappedType r5) {
            if ((r5.getConstructor() instanceof NewTypeVariableConstructor) == false) goto L5;
        L12:
            return true;
        L5:
            if ((r5.getConstructor().mo1402getDeclarationDescriptor() instanceof TypeParameterDescriptor) == true) goto L12;
            if ((r5 instanceof NewCapturedType) == true) goto L12;
            if ((r5 instanceof StubTypeForBuilderInference) == true) goto L12;
            return false;
        }

        public static /* synthetic */ DefinitelyNotNullType makeDefinitelyNotNull$default(Companion r5, UnwrappedType r10, boolean r11, boolean r12, int r13, Object r14) {
            if ((r13 & 2) == 0) goto L6;
            r11 = false;
        L6:
            if ((r13 & 4) == 0) goto L9;
            r12 = false;
        L9:
            return r5.makeDefinitelyNotNull(r10, r11, r12);
        }

        private final boolean makesSenseToBeDefinitelyNotNull(UnwrappedType r5, boolean r10) {
            if (canHaveUndefinedNullability(r5) == true) goto L7;
            return false;
        L7:
            if ((r5 instanceof StubTypeForBuilderInference) == true) goto L9;
            ClassifierDescriptor r11 = r5.getConstructor().mo1402getDeclarationDescriptor();
            if ((r11 instanceof TypeParameterDescriptorImpl) == false) goto L13;
            TypeParameterDescriptorImpl r12 = (TypeParameterDescriptorImpl) r11;
        L15:
            if (r12 != null) goto L17;
        L19:
            if (r10 == false) goto L25;
            if ((r5.getConstructor().mo1402getDeclarationDescriptor() instanceof TypeParameterDescriptor) == false) goto L25;
            return TypeUtils.isNullableType(r5);
        L25:
            return !NullabilityChecker.INSTANCE.isSubtypeOfAny(r5);
        L17:
            if (r12.isInitialized() == true) goto L19;
            return true;
        L13:
            r12 = null;
            goto L15
        L9:
            return TypeUtils.isNullableType(r5);
        }

        @JvmOverloads
        public final DefinitelyNotNullType makeDefinitelyNotNull(UnwrappedType r5, boolean r10, boolean r11) {
            Intrinsics.checkNotNullParameter(r5, "type");
            if ((r5 instanceof DefinitelyNotNullType) == true) goto L16;
            DefaultConstructorMarker r12 = null;
            if (r11 == true) goto L12;
            if (makesSenseToBeDefinitelyNotNull(r5, r10) == true) goto L12;
            return null;
        L12:
            if ((r5 instanceof FlexibleType) == false) goto L15;
            FlexibleType r13 = (FlexibleType) r5;
            Intrinsics.areEqual(r13.getLowerBound().getConstructor(), r13.getUpperBound().getConstructor());
        L15:
            return new DefinitelyNotNullType(FlexibleTypesKt.lowerIfFlexible(r5).makeNullableAsSpecified(false), r10, r12);
        L16:
            return (DefinitelyNotNullType) r5;
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public /* synthetic */ DefinitelyNotNullType(SimpleType r5, boolean r10, DefaultConstructorMarker r11) {
        this(r5, r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType
    public SimpleType getDelegate() {
        return this.original;
    }

    public final SimpleType getOriginal() {
        return this.original;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType, kotlin.reflect.jvm.internal.impl.types.KotlinType
    public boolean isMarkedNullable() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.CustomTypeParameter
    public boolean isTypeParameter() {
        if ((getDelegate().getConstructor() instanceof NewTypeVariableConstructor) == false) goto L5;
    L8:
        return true;
    L5:
        if ((getDelegate().getConstructor().mo1402getDeclarationDescriptor() instanceof TypeParameterDescriptor) == true) goto L8;
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public /* bridge */ /* synthetic */ UnwrappedType makeNullableAsSpecified(boolean r5) {
        return makeNullableAsSpecified(r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public /* bridge */ /* synthetic */ UnwrappedType replaceAttributes(TypeAttributes r5) {
        return replaceAttributes(r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType
    public /* bridge */ /* synthetic */ DelegatingSimpleType replaceDelegate(SimpleType r5) {
        return replaceDelegate(r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.CustomTypeParameter
    public KotlinType substitutionResult(KotlinType r5) {
        Intrinsics.checkNotNullParameter(r5, "replacement");
        return SpecialTypesKt.makeDefinitelyNotNullOrNotNull(r5.unwrap(), this.useCorrectedNullabilityForTypeParameters);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.SimpleType
    public String toString() {
        return getDelegate() + " & Any";
    }

    private DefinitelyNotNullType(SimpleType r5, boolean r10) {
        this.original = r5;
        this.useCorrectedNullabilityForTypeParameters = r10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.SimpleType, kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public SimpleType makeNullableAsSpecified(boolean r5) {
        if (r5 == true) goto L4;
        return this;
    L4:
        return getDelegate().makeNullableAsSpecified(r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.SimpleType, kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public SimpleType replaceAttributes(TypeAttributes r5) {
        Intrinsics.checkNotNullParameter(r5, "newAttributes");
        return new DefinitelyNotNullType(getDelegate().replaceAttributes(r5), this.useCorrectedNullabilityForTypeParameters);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType
    public DefinitelyNotNullType replaceDelegate(SimpleType r5) {
        Intrinsics.checkNotNullParameter(r5, "delegate");
        return new DefinitelyNotNullType(r5, this.useCorrectedNullabilityForTypeParameters);
    }
}
