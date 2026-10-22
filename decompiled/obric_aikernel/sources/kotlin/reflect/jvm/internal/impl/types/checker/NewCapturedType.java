package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorScopeKind;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus;
import kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker;

/* JADX INFO: loaded from: classes3.dex */
public final class NewCapturedType extends SimpleType implements CapturedTypeMarker {
    private final TypeAttributes attributes;
    private final CaptureStatus captureStatus;
    private final NewCapturedTypeConstructor constructor;
    private final boolean isMarkedNullable;
    private final boolean isProjectionNotNull;
    private final UnwrappedType lowerType;

    public NewCapturedType(CaptureStatus r11, UnwrappedType r12, TypeProjection r13, TypeParameterDescriptor r14) {
        Intrinsics.checkNotNullParameter(r11, "captureStatus");
        Intrinsics.checkNotNullParameter(r13, "projection");
        Intrinsics.checkNotNullParameter(r14, "typeParameter");
        this(r11, new NewCapturedTypeConstructor(r13, null, null, r14, 6, null), r12, null, false, false, 56, null);
    }

    public NewCapturedType(CaptureStatus r10, NewCapturedTypeConstructor r11, UnwrappedType r12, TypeAttributes r13, boolean r14, boolean r15) {
        Intrinsics.checkNotNullParameter(r10, "captureStatus");
        Intrinsics.checkNotNullParameter(r11, "constructor");
        Intrinsics.checkNotNullParameter(r13, "attributes");
        this.captureStatus = r10;
        this.constructor = r11;
        this.lowerType = r12;
        this.attributes = r13;
        this.isMarkedNullable = r14;
        this.isProjectionNotNull = r15;
    }

    public /* synthetic */ NewCapturedType(CaptureStatus r10, NewCapturedTypeConstructor r11, UnwrappedType r12, TypeAttributes r13, boolean r14, boolean r15, int r16, DefaultConstructorMarker r17) {
        if ((r16 & 8) == 0) goto L5;
        r13 = TypeAttributes.Companion.getEmpty();
    L5:
        TypeAttributes r18 = r13;
        if ((r16 & 16) == 0) goto L8;
        boolean r19 = false;
    L10:
        if ((r16 & 32) == 0) goto L12;
        boolean r20 = false;
    L13:
        this(r10, r11, r12, r18, r19, r20);
        return;
    L12:
        r20 = r15;
        goto L13
    L8:
        r19 = r14;
        goto L10
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    public List<TypeProjection> getArguments() {
        return CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    public TypeAttributes getAttributes() {
        return this.attributes;
    }

    public final CaptureStatus getCaptureStatus() {
        return this.captureStatus;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    public /* bridge */ /* synthetic */ TypeConstructor getConstructor() {
        return getConstructor();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    public NewCapturedTypeConstructor getConstructor() {
        return this.constructor;
    }

    public final UnwrappedType getLowerType() {
        return this.lowerType;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    public MemberScope getMemberScope() {
        return ErrorUtils.createErrorScope(ErrorScopeKind.CAPTURED_TYPE_SCOPE, true, new String[0]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    public boolean isMarkedNullable() {
        return this.isMarkedNullable;
    }

    public final boolean isProjectionNotNull() {
        return this.isProjectionNotNull;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.SimpleType, kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public /* bridge */ /* synthetic */ SimpleType makeNullableAsSpecified(boolean r10) {
        return makeNullableAsSpecified(r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public /* bridge */ /* synthetic */ UnwrappedType makeNullableAsSpecified(boolean r10) {
        return makeNullableAsSpecified(r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.SimpleType, kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public NewCapturedType makeNullableAsSpecified(boolean r11) {
        return new NewCapturedType(this.captureStatus, getConstructor(), this.lowerType, getAttributes(), r11, false, 32, null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    public /* bridge */ /* synthetic */ KotlinType refine(KotlinTypeRefiner r10) {
        return refine(r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType, kotlin.reflect.jvm.internal.impl.types.KotlinType
    public /* bridge */ /* synthetic */ UnwrappedType refine(KotlinTypeRefiner r10) {
        return refine(r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType, kotlin.reflect.jvm.internal.impl.types.KotlinType
    public NewCapturedType refine(KotlinTypeRefiner r11) {
        Intrinsics.checkNotNullParameter(r11, "kotlinTypeRefiner");
        CaptureStatus r10 = this.captureStatus;
        NewCapturedTypeConstructor r12 = getConstructor().refine(r11);
        UnwrappedType r13 = this.lowerType;
        if (r13 == null) goto L5;
        UnwrappedType r14 = r11.refineType(r13).unwrap();
    L7:
        return new NewCapturedType(r10, r12, r14, getAttributes(), isMarkedNullable(), false, 32, null);
    L5:
        r14 = null;
        goto L7
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.SimpleType, kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public SimpleType replaceAttributes(TypeAttributes r10) {
        Intrinsics.checkNotNullParameter(r10, "newAttributes");
        return new NewCapturedType(this.captureStatus, getConstructor(), this.lowerType, r10, isMarkedNullable(), this.isProjectionNotNull);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public /* bridge */ /* synthetic */ UnwrappedType replaceAttributes(TypeAttributes r10) {
        return replaceAttributes(r10);
    }
}
