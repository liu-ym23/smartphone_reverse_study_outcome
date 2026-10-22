package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.checker.StrictEqualityTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;

/* JADX INFO: loaded from: classes3.dex */
public abstract class KotlinType implements Annotated, KotlinTypeMarker {
    private int cachedHashCode;

    public /* synthetic */ KotlinType(DefaultConstructorMarker r5) {
        this();
    }

    private final int computeHashCode() {
        if (KotlinTypeKt.isError(this) == true) goto L5;
        int r5 = getConstructor().hashCode() * 31;
        int r10 = (getArguments().hashCode() + r5) * 31;
        return (isMarkedNullable() ? 1 : 0) + r10;
    L5:
        return super.hashCode();
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof KotlinType) == true) goto L8;
        return false;
    L8:
        KotlinType r10 = (KotlinType) r5;
        if (isMarkedNullable() != r10.isMarkedNullable()) goto L14;
        if (StrictEqualityTypeChecker.INSTANCE.strictEqualTypes(unwrap(), r10.unwrap()) == false) goto L14;
        return true;
    L14:
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
    public Annotations getAnnotations() {
        return AnnotationsTypeAttributeKt.getAnnotations(getAttributes());
    }

    public abstract List<TypeProjection> getArguments();

    public abstract TypeAttributes getAttributes();

    public abstract TypeConstructor getConstructor();

    public abstract MemberScope getMemberScope();

    public final int hashCode() {
        int r5 = this.cachedHashCode;
        if (r5 == 0) goto L5;
        return r5;
    L5:
        int r10 = computeHashCode();
        this.cachedHashCode = r10;
        return r10;
    }

    public abstract boolean isMarkedNullable();

    public abstract KotlinType refine(KotlinTypeRefiner r5);

    public abstract UnwrappedType unwrap();

    private KotlinType() {
    }
}
