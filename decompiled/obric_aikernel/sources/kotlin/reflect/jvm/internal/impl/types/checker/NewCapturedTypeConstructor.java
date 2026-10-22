package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class NewCapturedTypeConstructor implements CapturedTypeConstructor {
    private final Lazy _supertypes$delegate;
    private final NewCapturedTypeConstructor original;
    private final TypeProjection projection;
    private Function0<? extends List<? extends UnwrappedType>> supertypesComputation;
    private final TypeParameterDescriptor typeParameter;

    public NewCapturedTypeConstructor(TypeProjection r10, final List<? extends UnwrappedType> r11, NewCapturedTypeConstructor r12) {
        Intrinsics.checkNotNullParameter(r10, "projection");
        Intrinsics.checkNotNullParameter(r11, "supertypes");
        this(r10, new AnonymousClass1(r11), r12, null, 8, null);
    }

    public /* synthetic */ NewCapturedTypeConstructor(TypeProjection r10, List r11, NewCapturedTypeConstructor r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 4) == 0) goto L5;
        r12 = null;
    L5:
        this(r10, r11, r12);
    }

    public NewCapturedTypeConstructor(TypeProjection r10, Function0<? extends List<? extends UnwrappedType>> r11, NewCapturedTypeConstructor r12, TypeParameterDescriptor r13) {
        Intrinsics.checkNotNullParameter(r10, "projection");
        this.projection = r10;
        this.supertypesComputation = r11;
        this.original = r12;
        this.typeParameter = r13;
        this._supertypes$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new NewCapturedTypeConstructor$_supertypes$2(this));
    }

    public /* synthetic */ NewCapturedTypeConstructor(TypeProjection r10, Function0 r11, NewCapturedTypeConstructor r12, TypeParameterDescriptor r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r14 & 4) == 0) goto L9;
        r12 = null;
    L9:
        if ((r14 & 8) == 0) goto L11;
        r13 = null;
    L11:
        this(r10, r11, r12, r13);
    }

    public static final /* synthetic */ Function0 access$getSupertypesComputation$p(NewCapturedTypeConstructor r10) {
        return r10.supertypesComputation;
    }

    private final List<UnwrappedType> get_supertypes() {
        return (List) this._supertypes$delegate.getValue();
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if (r10 == null) goto L8;
        Class<?> r11 = r10.getClass();
    L10:
        if (Intrinsics.areEqual(NewCapturedTypeConstructor.class, r11) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type org.jetbrains.kotlin.types.checker.NewCapturedTypeConstructor");
        NewCapturedTypeConstructor r12 = (NewCapturedTypeConstructor) r10;
        NewCapturedTypeConstructor r13 = this.original;
        if (r13 == null) goto L16;
        NewCapturedTypeConstructor this = r13;
    L16:
        NewCapturedTypeConstructor r14 = r12.original;
        if (r14 == null) goto L20;
        r12 = r14;
    L20:
        if (this != r12) goto L23;
        return true;
    L23:
        return false;
    L8:
        r11 = null;
        goto L10
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public KotlinBuiltIns getBuiltIns() {
        KotlinType r10 = getProjection().getType();
        Intrinsics.checkNotNullExpressionValue(r10, "projection.type");
        return TypeUtilsKt.getBuiltIns(r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    /* JADX INFO: renamed from: getDeclarationDescriptor */
    public ClassifierDescriptor mo1323getDeclarationDescriptor() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public List<TypeParameterDescriptor> getParameters() {
        return CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructor
    public TypeProjection getProjection() {
        return this.projection;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    /* JADX INFO: renamed from: getSupertypes */
    public /* bridge */ /* synthetic */ Collection mo1324getSupertypes() {
        return mo1324getSupertypes();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    /* JADX INFO: renamed from: getSupertypes */
    public List<UnwrappedType> mo1324getSupertypes() {
        List<UnwrappedType> r10 = get_supertypes();
        if (r10 == null) goto L5;
        return r10;
    L5:
        return CollectionsKt.emptyList();
    }

    public int hashCode() {
        NewCapturedTypeConstructor r10 = this.original;
        if (r10 == null) goto L6;
        return r10.hashCode();
    L6:
        return super.hashCode();
    }

    public final void initializeSupertypes(final List<? extends UnwrappedType> r10) {
        Intrinsics.checkNotNullParameter(r10, "supertypes");
        this.supertypesComputation = new AnonymousClass2(r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public boolean isDenotable() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public /* bridge */ /* synthetic */ TypeConstructor refine(KotlinTypeRefiner r10) {
        return refine(r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public NewCapturedTypeConstructor refine(final KotlinTypeRefiner r10) {
        Intrinsics.checkNotNullParameter(r10, "kotlinTypeRefiner");
        TypeProjection r11 = getProjection().refine(r10);
        Intrinsics.checkNotNullExpressionValue(r11, "projection.refine(kotlinTypeRefiner)");
        if (this.supertypesComputation == null) goto L5;
        Function0<List<? extends UnwrappedType>> r12 = new NewCapturedTypeConstructor$refine$1$1(this, r10);
    L6:
        NewCapturedTypeConstructor r13 = this.original;
        if (r13 != null) goto L10;
        r13 = this;
    L10:
        return new NewCapturedTypeConstructor(r11, r12, r13, this.typeParameter);
    L5:
        r12 = null;
        goto L6
    }

    public String toString() {
        return "CapturedType(" + getProjection() + ')';
    }
}
