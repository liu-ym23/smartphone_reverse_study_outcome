package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext;

/* JADX INFO: loaded from: classes3.dex */
public interface TypeSystemCommonBackendContext extends TypeSystemContext {

    public static final class DefaultImpls {
        public static KotlinTypeMarker makeNullable(TypeSystemCommonBackendContext r10, KotlinTypeMarker r11) {
            Intrinsics.checkNotNullParameter(r11, "$receiver");
            SimpleTypeMarker r12 = r10.asSimpleType(r11);
            if (r12 == null) goto L8;
            SimpleTypeMarker r13 = r10.withNullability(r12, true);
            if (r13 != null) goto L7;
            return r11;
        L7:
            return r13;
        L8:
            return r11;
        }
    }

    FqNameUnsafe getClassFqNameUnsafe(TypeConstructorMarker r10);

    PrimitiveType getPrimitiveArrayType(TypeConstructorMarker r10);

    PrimitiveType getPrimitiveType(TypeConstructorMarker r10);

    KotlinTypeMarker getRepresentativeUpperBound(TypeParameterMarker r10);

    KotlinTypeMarker getUnsubstitutedUnderlyingType(KotlinTypeMarker r10);

    boolean hasAnnotation(KotlinTypeMarker r10, FqName r11);

    boolean isInlineClass(TypeConstructorMarker r10);

    boolean isUnderKotlinPackage(TypeConstructorMarker r10);

    KotlinTypeMarker makeNullable(KotlinTypeMarker r10);
}
