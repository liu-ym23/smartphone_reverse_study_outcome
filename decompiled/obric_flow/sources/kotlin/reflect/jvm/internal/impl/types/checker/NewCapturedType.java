package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
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
@SourceDebugExtension({"SMAP\nNewCapturedType.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NewCapturedType.kt\norg/jetbrains/kotlin/types/checker/NewCapturedType\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,290:1\n1#2:291\n*E\n"})
public final class NewCapturedType extends SimpleType implements CapturedTypeMarker {
    private final TypeAttributes attributes;
    private final CaptureStatus captureStatus;
    private final NewCapturedTypeConstructor constructor;
    private final boolean isMarkedNullable;
    private final boolean isProjectionNotNull;
    private final UnwrappedType lowerType;

    public /* synthetic */ NewCapturedType(CaptureStatus r10, NewCapturedTypeConstructor r11, UnwrappedType r12, TypeAttributes r13, boolean r14, boolean r15, int r16, DefaultConstructorMarker r17) {
        if ((r16 & 8) == 0) goto L5;
        r13 = TypeAttributes.Companion.getEmpty();
    L5:
        TypeAttributes r5 = r13;
        if ((r16 & 16) == 0) goto L8;
        boolean r18 = false;
    L10:
        if ((r16 & 32) == 0) goto L12;
        boolean r19 = false;
    L13:
        this(r10, r11, r12, r5, r18, r19);
        return;
    L12:
        r19 = r15;
        goto L13
    L8:
        r18 = r14;
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
    public /* bridge */ /* synthetic */ SimpleType makeNullableAsSpecified(boolean r5) {
        return makeNullableAsSpecified(r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    public /* bridge */ /* synthetic */ KotlinType refine(KotlinTypeRefiner r5) {
        return refine(r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public /* bridge */ /* synthetic */ UnwrappedType replaceAttributes(TypeAttributes r5) {
        return replaceAttributes(r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    public NewCapturedTypeConstructor getConstructor() {
        return this.constructor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public /* bridge */ /* synthetic */ UnwrappedType makeNullableAsSpecified(boolean r5) {
        return makeNullableAsSpecified(r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType, kotlin.reflect.jvm.internal.impl.types.KotlinType
    public /* bridge */ /* synthetic */ UnwrappedType refine(KotlinTypeRefiner r5) {
        return refine(r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.SimpleType, kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public SimpleType replaceAttributes(TypeAttributes r10) {
        Intrinsics.checkNotNullParameter(r10, "newAttributes");
        return new NewCapturedType(this.captureStatus, getConstructor(), this.lowerType, r10, isMarkedNullable(), this.isProjectionNotNull);
    }

    public NewCapturedType(CaptureStatus r5, NewCapturedTypeConstructor r10, UnwrappedType r11, TypeAttributes r12, boolean r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r5, "captureStatus");
        Intrinsics.checkNotNullParameter(r10, "constructor");
        Intrinsics.checkNotNullParameter(r12, "attributes");
        this.captureStatus = r5;
        this.constructor = r10;
        this.lowerType = r11;
        this.attributes = r12;
        this.isMarkedNullable = r13;
        this.isProjectionNotNull = r14;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.SimpleType, kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public NewCapturedType makeNullableAsSpecified(boolean r11) {
        boolean r10 = false;
        return new NewCapturedType(this.captureStatus, getConstructor(), this.lowerType, getAttributes(), r11, r10, 32, null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType, kotlin.reflect.jvm.internal.impl.types.KotlinType
    public NewCapturedType refine(KotlinTypeRefiner r11) {
        Intrinsics.checkNotNullParameter(r11, "kotlinTypeRefiner");
        CaptureStatus r5 = this.captureStatus;
        NewCapturedTypeConstructor r10 = getConstructor().refine(r11);
        UnwrappedType r12 = this.lowerType;
        if (r12 == null) goto L6;
        UnwrappedType r13 = r11.refineType(r12).unwrap();
    L5:
        UnwrappedType r14 = r13;
        return new NewCapturedType(r5, r10, r14, getAttributes(), isMarkedNullable(), false, 32, null);
    L6:
        r13 = null;
        goto L5
    }

    public NewCapturedType(CaptureStatus r11, UnwrappedType r12, TypeProjection r13, TypeParameterDescriptor r14) {
        Intrinsics.checkNotNullParameter(r11, "captureStatus");
        Intrinsics.checkNotNullParameter(r13, "projection");
        Intrinsics.checkNotNullParameter(r14, "typeParameter");
        Function0 r5 = null;
        NewCapturedTypeConstructor r10 = null;
        TypeAttributes r15 = null;
        boolean r16 = false;
        boolean r17 = false;
        this(r11, new NewCapturedTypeConstructor(r13, r5, r10, r14, 6, null), r12, r15, r16, r17, 56, null);
    }
}
