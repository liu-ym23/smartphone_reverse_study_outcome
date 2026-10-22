package kotlin.reflect.jvm.internal.impl.types.error;

import java.util.Arrays;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* JADX INFO: loaded from: classes3.dex */
public final class ErrorType extends SimpleType {
    private final List<TypeProjection> arguments;
    private final TypeConstructor constructor;
    private final String debugMessage;
    private final String[] formatParams;
    private final boolean isMarkedNullable;
    private final ErrorTypeKind kind;
    private final MemberScope memberScope;

    public /* synthetic */ ErrorType(TypeConstructor r10, MemberScope r11, ErrorTypeKind r12, List r13, boolean r14, String[] r15, int r16, DefaultConstructorMarker r17) {
        if ((r16 & 8) == 0) goto L5;
        r13 = CollectionsKt.emptyList();
    L5:
        List r5 = r13;
        if ((r16 & 16) == 0) goto L8;
        r14 = false;
    L8:
        this(r10, r11, r12, r5, r14, r15);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    public List<TypeProjection> getArguments() {
        return this.arguments;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    public TypeAttributes getAttributes() {
        return TypeAttributes.Companion.getEmpty();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    public TypeConstructor getConstructor() {
        return this.constructor;
    }

    public final String getDebugMessage() {
        return this.debugMessage;
    }

    public final ErrorTypeKind getKind() {
        return this.kind;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    public MemberScope getMemberScope() {
        return this.memberScope;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    public boolean isMarkedNullable() {
        return this.isMarkedNullable;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public /* bridge */ /* synthetic */ UnwrappedType makeNullableAsSpecified(boolean r5) {
        return makeNullableAsSpecified(r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType, kotlin.reflect.jvm.internal.impl.types.KotlinType
    public ErrorType refine(KotlinTypeRefiner r5) {
        Intrinsics.checkNotNullParameter(r5, "kotlinTypeRefiner");
        return this;
    }

    public final ErrorType replaceArguments(List<? extends TypeProjection> r10) {
        Intrinsics.checkNotNullParameter(r10, "newArguments");
        TypeConstructor r5 = getConstructor();
        MemberScope r11 = getMemberScope();
        ErrorTypeKind r12 = this.kind;
        boolean r13 = isMarkedNullable();
        String[] r14 = this.formatParams;
        return new ErrorType(r5, r11, r12, r10, r13, (String[]) Arrays.copyOf(r14, r14.length));
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.SimpleType, kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public SimpleType replaceAttributes(TypeAttributes r5) {
        Intrinsics.checkNotNullParameter(r5, "newAttributes");
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.SimpleType, kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public SimpleType makeNullableAsSpecified(boolean r10) {
        TypeConstructor r5 = getConstructor();
        MemberScope r11 = getMemberScope();
        ErrorTypeKind r12 = this.kind;
        List<TypeProjection> r13 = getArguments();
        String[] r14 = this.formatParams;
        return new ErrorType(r5, r11, r12, r13, r10, (String[]) Arrays.copyOf(r14, r14.length));
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    public /* bridge */ /* synthetic */ KotlinType refine(KotlinTypeRefiner r5) {
        return refine(r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public /* bridge */ /* synthetic */ UnwrappedType replaceAttributes(TypeAttributes r5) {
        return replaceAttributes(r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public ErrorType(TypeConstructor r5, MemberScope r10, ErrorTypeKind r11, List<? extends TypeProjection> r12, boolean r13, String... r14) {
        Intrinsics.checkNotNullParameter(r5, "constructor");
        Intrinsics.checkNotNullParameter(r10, "memberScope");
        Intrinsics.checkNotNullParameter(r11, "kind");
        Intrinsics.checkNotNullParameter(r12, "arguments");
        Intrinsics.checkNotNullParameter(r14, "formatParams");
        this.constructor = r5;
        this.memberScope = r10;
        this.kind = r11;
        this.arguments = r12;
        this.isMarkedNullable = r13;
        this.formatParams = r14;
        StringCompanionObject r15 = StringCompanionObject.INSTANCE;
        String r16 = r11.getDebugMessage();
        Object[] r17 = Arrays.copyOf(r14, r14.length);
        this.debugMessage = String.format(r16, Arrays.copyOf(r17, r17.length));
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType, kotlin.reflect.jvm.internal.impl.types.KotlinType
    public /* bridge */ /* synthetic */ UnwrappedType refine(KotlinTypeRefiner r5) {
        return refine(r5);
    }
}
