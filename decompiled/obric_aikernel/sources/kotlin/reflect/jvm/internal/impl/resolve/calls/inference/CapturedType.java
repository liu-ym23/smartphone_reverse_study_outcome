package kotlin.reflect.jvm.internal.impl.resolve.calls.inference;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorScopeKind;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker;

/* JADX INFO: loaded from: classes3.dex */
public final class CapturedType extends SimpleType implements CapturedTypeMarker {
    private final TypeAttributes attributes;
    private final CapturedTypeConstructor constructor;
    private final boolean isMarkedNullable;
    private final TypeProjection typeProjection;

    public CapturedType(TypeProjection r10, CapturedTypeConstructor r11, boolean r12, TypeAttributes r13) {
        Intrinsics.checkNotNullParameter(r10, "typeProjection");
        Intrinsics.checkNotNullParameter(r11, "constructor");
        Intrinsics.checkNotNullParameter(r13, "attributes");
        this.typeProjection = r10;
        this.constructor = r11;
        this.isMarkedNullable = r12;
        this.attributes = r13;
    }

    public /* synthetic */ CapturedType(TypeProjection r10, CapturedTypeConstructor r11, boolean r12, TypeAttributes r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 2) == 0) goto L6;
        r11 = new CapturedTypeConstructorImpl(r10);
    L6:
        if ((r14 & 4) == 0) goto L9;
        r12 = false;
    L9:
        if ((r14 & 8) == 0) goto L11;
        r13 = TypeAttributes.Companion.getEmpty();
    L11:
        this(r10, r11, r12, r13);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    public List<TypeProjection> getArguments() {
        return CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    public TypeAttributes getAttributes() {
        return this.attributes;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    public CapturedTypeConstructor getConstructor() {
        return this.constructor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    public /* bridge */ /* synthetic */ TypeConstructor getConstructor() {
        return getConstructor();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    public MemberScope getMemberScope() {
        return ErrorUtils.createErrorScope(ErrorScopeKind.CAPTURED_TYPE_SCOPE, true, new String[0]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    public boolean isMarkedNullable() {
        return this.isMarkedNullable;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.SimpleType, kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public CapturedType makeNullableAsSpecified(boolean r10) {
        if (r10 != isMarkedNullable()) goto L6;
        return this;
    L6:
        return new CapturedType(this.typeProjection, getConstructor(), r10, getAttributes());
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.SimpleType, kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public /* bridge */ /* synthetic */ SimpleType makeNullableAsSpecified(boolean r10) {
        return makeNullableAsSpecified(r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public /* bridge */ /* synthetic */ UnwrappedType makeNullableAsSpecified(boolean r10) {
        return makeNullableAsSpecified(r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType, kotlin.reflect.jvm.internal.impl.types.KotlinType
    public CapturedType refine(KotlinTypeRefiner r10) {
        Intrinsics.checkNotNullParameter(r10, "kotlinTypeRefiner");
        TypeProjection r11 = this.typeProjection.refine(r10);
        Intrinsics.checkNotNullExpressionValue(r11, "typeProjection.refine(kotlinTypeRefiner)");
        return new CapturedType(r11, getConstructor(), isMarkedNullable(), getAttributes());
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    public /* bridge */ /* synthetic */ KotlinType refine(KotlinTypeRefiner r10) {
        return refine(r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType, kotlin.reflect.jvm.internal.impl.types.KotlinType
    public /* bridge */ /* synthetic */ UnwrappedType refine(KotlinTypeRefiner r10) {
        return refine(r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.SimpleType, kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public SimpleType replaceAttributes(TypeAttributes r10) {
        Intrinsics.checkNotNullParameter(r10, "newAttributes");
        return new CapturedType(this.typeProjection, getConstructor(), isMarkedNullable(), r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public /* bridge */ /* synthetic */ UnwrappedType replaceAttributes(TypeAttributes r10) {
        return replaceAttributes(r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.SimpleType
    public String toString() {
        StringBuilder r10 = new StringBuilder();
        r10.append("Captured(");
        r10.append(this.typeProjection);
        r10.append(')');
        if (isMarkedNullable() == false) goto L5;
        String r11 = "?";
    L6:
        r10.append(r11);
        return r10.toString();
    L5:
        r11 = "";
        goto L6
    }
}
