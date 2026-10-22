package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.NotNullTypeParameter;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancementKt;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class NotNullTypeParameterImpl extends DelegatingSimpleType implements NotNullTypeParameter {
    private final SimpleType delegate;

    public NotNullTypeParameterImpl(SimpleType r5) {
        Intrinsics.checkNotNullParameter(r5, "delegate");
        this.delegate = r5;
    }

    private final SimpleType prepareReplacement(SimpleType r5) {
        SimpleType r10 = r5.makeNullableAsSpecified(false);
        if (TypeUtilsKt.isTypeParameter(r5) == true) goto L6;
        return r10;
    L6:
        return new NotNullTypeParameterImpl(r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType
    public SimpleType getDelegate() {
        return this.delegate;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType, kotlin.reflect.jvm.internal.impl.types.KotlinType
    public boolean isMarkedNullable() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.CustomTypeParameter
    public boolean isTypeParameter() {
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public /* bridge */ /* synthetic */ UnwrappedType makeNullableAsSpecified(boolean r5) {
        return makeNullableAsSpecified(r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.SimpleType, kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public /* bridge */ /* synthetic */ SimpleType replaceAttributes(TypeAttributes r5) {
        return replaceAttributes(r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType
    public /* bridge */ /* synthetic */ DelegatingSimpleType replaceDelegate(SimpleType r5) {
        return replaceDelegate(r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.CustomTypeParameter
    public KotlinType substitutionResult(KotlinType r5) {
        Intrinsics.checkNotNullParameter(r5, "replacement");
        UnwrappedType r10 = r5.unwrap();
        if (TypeUtilsKt.isTypeParameter(r10) == true) goto L8;
        if (TypeUtils.isNullableType(r10) == true) goto L8;
        return r10;
    L8:
        if ((r10 instanceof SimpleType) == false) goto L11;
        return prepareReplacement((SimpleType) r10);
    L11:
        if ((r10 instanceof FlexibleType) == false) goto L15;
        FlexibleType r11 = (FlexibleType) r10;
        return TypeWithEnhancementKt.wrapEnhancement(KotlinTypeFactory.flexibleType(prepareReplacement(r11.getLowerBound()), prepareReplacement(r11.getUpperBound())), TypeWithEnhancementKt.getEnhancement(r10));
    L15:
        throw new IllegalStateException(("Incorrect type: " + r10).toString());
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.SimpleType, kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public SimpleType makeNullableAsSpecified(boolean r5) {
        if (r5 == true) goto L4;
        return this;
    L4:
        return getDelegate().makeNullableAsSpecified(true);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public /* bridge */ /* synthetic */ UnwrappedType replaceAttributes(TypeAttributes r5) {
        return replaceAttributes(r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType
    public NotNullTypeParameterImpl replaceDelegate(SimpleType r5) {
        Intrinsics.checkNotNullParameter(r5, "delegate");
        return new NotNullTypeParameterImpl(r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.SimpleType, kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public NotNullTypeParameterImpl replaceAttributes(TypeAttributes r5) {
        Intrinsics.checkNotNullParameter(r5, "newAttributes");
        return new NotNullTypeParameterImpl(getDelegate().replaceAttributes(r5));
    }
}
