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

    public NewCapturedTypeConstructor(TypeProjection r5, Function0<? extends List<? extends UnwrappedType>> r10, NewCapturedTypeConstructor r11, TypeParameterDescriptor r12) {
        Intrinsics.checkNotNullParameter(r5, "projection");
        this.projection = r5;
        this.supertypesComputation = r10;
        this.original = r11;
        this.typeParameter = r12;
        this._supertypes$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new NewCapturedTypeConstructor$_supertypes$2(this));
    }

    public static final /* synthetic */ Function0 access$getSupertypesComputation$p(NewCapturedTypeConstructor r5) {
        return r5.supertypesComputation;
    }

    private final List<UnwrappedType> get_supertypes() {
        return (List) this._supertypes$delegate.getValue();
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L5;
        return true;
    L5:
        if (r5 == null) goto L7;
        Class<?> r10 = r5.getClass();
    L9:
        if (Intrinsics.areEqual(NewCapturedTypeConstructor.class, r10) == true) goto L11;
        return false;
    L11:
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type org.jetbrains.kotlin.types.checker.NewCapturedTypeConstructor");
        NewCapturedTypeConstructor r11 = (NewCapturedTypeConstructor) r5;
        NewCapturedTypeConstructor r12 = this.original;
        if (r12 == null) goto L15;
        NewCapturedTypeConstructor this = r12;
    L15:
        NewCapturedTypeConstructor r13 = r11.original;
        if (r13 == null) goto L19;
        r11 = r13;
    L19:
        if (this != r11) goto L22;
        return true;
    L22:
        return false;
    L7:
        r10 = null;
        goto L9
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public KotlinBuiltIns getBuiltIns() {
        return TypeUtilsKt.getBuiltIns(getProjection().getType());
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    /* JADX INFO: renamed from: getDeclarationDescriptor */
    public ClassifierDescriptor mo1402getDeclarationDescriptor() {
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
    public /* bridge */ /* synthetic */ Collection mo1403getSupertypes() {
        return mo1403getSupertypes();
    }

    public int hashCode() {
        NewCapturedTypeConstructor r5 = this.original;
        if (r5 == null) goto L6;
        return r5.hashCode();
    L6:
        return super.hashCode();
    }

    public final void initializeSupertypes(final List<? extends UnwrappedType> r5) {
        Intrinsics.checkNotNullParameter(r5, "supertypes");
        this.supertypesComputation = new AnonymousClass2(r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public boolean isDenotable() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public /* bridge */ /* synthetic */ TypeConstructor refine(KotlinTypeRefiner r5) {
        return refine(r5);
    }

    public String toString() {
        return "CapturedType(" + getProjection() + ')';
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    /* JADX INFO: renamed from: getSupertypes */
    public List<UnwrappedType> mo1403getSupertypes() {
        List<UnwrappedType> r5 = get_supertypes();
        if (r5 == null) goto L5;
        return r5;
    L5:
        return CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public NewCapturedTypeConstructor refine(final KotlinTypeRefiner r5) {
        Intrinsics.checkNotNullParameter(r5, "kotlinTypeRefiner");
        TypeProjection r10 = getProjection().refine(r5);
        if (this.supertypesComputation == null) goto L5;
        Function0<List<? extends UnwrappedType>> r11 = new NewCapturedTypeConstructor$refine$1$1(this, r5);
    L6:
        NewCapturedTypeConstructor r12 = this.original;
        if (r12 != null) goto L10;
        r12 = this;
    L10:
        return new NewCapturedTypeConstructor(r10, r11, r12, this.typeParameter);
    L5:
        r11 = null;
        goto L6
    }

    public /* synthetic */ NewCapturedTypeConstructor(TypeProjection r5, Function0 r10, NewCapturedTypeConstructor r11, TypeParameterDescriptor r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r10 = null;
    L6:
        if ((r13 & 4) == 0) goto L9;
        r11 = null;
    L9:
        if ((r13 & 8) == 0) goto L11;
        r12 = null;
    L11:
        this(r5, r10, r11, r12);
    }

    public /* synthetic */ NewCapturedTypeConstructor(TypeProjection r5, List r10, NewCapturedTypeConstructor r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 4) == 0) goto L5;
        r11 = null;
    L5:
        this(r5, r10, r11);
    }

    public NewCapturedTypeConstructor(TypeProjection r10, final List<? extends UnwrappedType> r11, NewCapturedTypeConstructor r12) {
        Intrinsics.checkNotNullParameter(r10, "projection");
        Intrinsics.checkNotNullParameter(r11, "supertypes");
        TypeParameterDescriptor r5 = null;
        this(r10, new AnonymousClass1(r11), r12, r5, 8, null);
    }
}
