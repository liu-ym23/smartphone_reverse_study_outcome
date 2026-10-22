package kotlin.reflect.jvm.internal.impl.types;

import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext;

/* JADX INFO: loaded from: classes3.dex */
public interface TypeSystemCommonBackendContext extends TypeSystemContext {
    FqNameUnsafe getClassFqNameUnsafe(TypeConstructorMarker r5);

    PrimitiveType getPrimitiveArrayType(TypeConstructorMarker r5);

    PrimitiveType getPrimitiveType(TypeConstructorMarker r5);

    KotlinTypeMarker getRepresentativeUpperBound(TypeParameterMarker r5);

    KotlinTypeMarker getUnsubstitutedUnderlyingType(KotlinTypeMarker r5);

    boolean hasAnnotation(KotlinTypeMarker r5, FqName r10);

    boolean isInlineClass(TypeConstructorMarker r5);

    boolean isUnderKotlinPackage(TypeConstructorMarker r5);

    KotlinTypeMarker makeNullable(KotlinTypeMarker r5);
}
