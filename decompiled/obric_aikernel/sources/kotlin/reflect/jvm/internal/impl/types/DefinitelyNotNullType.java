package kotlin.reflect.jvm.internal.impl.types;

import com.bytedance.common.wschannel.WsConstants;
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
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }

        private final boolean canHaveUndefinedNullability(UnwrappedType r10) {
            if ((r10.getConstructor() instanceof NewTypeVariableConstructor) == false) goto L5;
        L12:
            return true;
        L5:
            if ((r10.getConstructor().mo1323getDeclarationDescriptor() instanceof TypeParameterDescriptor) == true) goto L12;
            if ((r10 instanceof NewCapturedType) == true) goto L12;
            if ((r10 instanceof StubTypeForBuilderInference) == true) goto L12;
            return false;
        }

        public static /* synthetic */ DefinitelyNotNullType makeDefinitelyNotNull$default(Companion r10, UnwrappedType r11, boolean r12, int r13, Object r14) {
            if ((r13 & 2) == 0) goto L6;
            r12 = false;
        L6:
            return r10.makeDefinitelyNotNull(r11, r12);
        }

        private final boolean makesSenseToBeDefinitelyNotNull(UnwrappedType r10, boolean r11) {
            boolean r12 = false;
            if (canHaveUndefinedNullability(r10) == true) goto L6;
            return false;
        L6:
            if ((r10 instanceof StubTypeForBuilderInference) == true) goto L8;
            ClassifierDescriptor r13 = r10.getConstructor().mo1323getDeclarationDescriptor();
            if ((r13 instanceof TypeParameterDescriptorImpl) == false) goto L12;
            TypeParameterDescriptorImpl r14 = (TypeParameterDescriptorImpl) r13;
        L14:
            if (r14 != null) goto L16;
        L18:
            if (r12 == false) goto L20;
            return true;
        L20:
            if (r11 == false) goto L26;
            if ((r10.getConstructor().mo1323getDeclarationDescriptor() instanceof TypeParameterDescriptor) == false) goto L26;
            return TypeUtils.isNullableType(r10);
        L26:
            return !NullabilityChecker.INSTANCE.isSubtypeOfAny(r10);
        L16:
            if (r14.isInitialized() == true) goto L18;
            r12 = true;
            goto L18
        L12:
            r14 = null;
            goto L14
        L8:
            return TypeUtils.isNullableType(r10);
        }

        public final DefinitelyNotNullType makeDefinitelyNotNull(UnwrappedType r10, boolean r11) {
            Intrinsics.checkNotNullParameter(r10, WsConstants.KEY_CONNECTION_TYPE);
            DefaultConstructorMarker r12 = null;
            if ((r10 instanceof DefinitelyNotNullType) == false) goto L6;
            return (DefinitelyNotNullType) r10;
        L6:
            if (makesSenseToBeDefinitelyNotNull(r10, r11) == true) goto L8;
            return null;
        L8:
            if ((r10 instanceof FlexibleType) == false) goto L11;
            FlexibleType r13 = (FlexibleType) r10;
            Intrinsics.areEqual(r13.getLowerBound().getConstructor(), r13.getUpperBound().getConstructor());
        L11:
            return new DefinitelyNotNullType(FlexibleTypesKt.lowerIfFlexible(r10).makeNullableAsSpecified(false), r11, r12);
        }
    }

    static {
        Companion = new Companion(null);
    }

    private DefinitelyNotNullType(SimpleType r10, boolean r11) {
        this.original = r10;
        this.useCorrectedNullabilityForTypeParameters = r11;
    }

    public /* synthetic */ DefinitelyNotNullType(SimpleType r10, boolean r11, DefaultConstructorMarker r12) {
        this(r10, r11);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType
    protected SimpleType getDelegate() {
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
        if ((getDelegate().getConstructor().mo1323getDeclarationDescriptor() instanceof TypeParameterDescriptor) == true) goto L8;
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.SimpleType, kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public SimpleType makeNullableAsSpecified(boolean r10) {
        if (r10 == true) goto L4;
        return this;
    L4:
        return getDelegate().makeNullableAsSpecified(r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public /* bridge */ /* synthetic */ UnwrappedType makeNullableAsSpecified(boolean r10) {
        return makeNullableAsSpecified(r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.SimpleType, kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public SimpleType replaceAttributes(TypeAttributes r10) {
        Intrinsics.checkNotNullParameter(r10, "newAttributes");
        return new DefinitelyNotNullType(getDelegate().replaceAttributes(r10), this.useCorrectedNullabilityForTypeParameters);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public /* bridge */ /* synthetic */ UnwrappedType replaceAttributes(TypeAttributes r10) {
        return replaceAttributes(r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType
    public DefinitelyNotNullType replaceDelegate(SimpleType r10) {
        Intrinsics.checkNotNullParameter(r10, "delegate");
        return new DefinitelyNotNullType(r10, this.useCorrectedNullabilityForTypeParameters);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType
    public /* bridge */ /* synthetic */ DelegatingSimpleType replaceDelegate(SimpleType r10) {
        return replaceDelegate(r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.CustomTypeParameter
    public KotlinType substitutionResult(KotlinType r10) {
        Intrinsics.checkNotNullParameter(r10, "replacement");
        return SpecialTypesKt.makeDefinitelyNotNullOrNotNull(r10.unwrap(), this.useCorrectedNullabilityForTypeParameters);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.SimpleType
    public String toString() {
        return getDelegate() + " & Any";
    }
}
