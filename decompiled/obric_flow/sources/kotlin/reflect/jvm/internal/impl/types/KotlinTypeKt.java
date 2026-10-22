package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorType;

/* JADX INFO: loaded from: classes3.dex */
public final class KotlinTypeKt {
    public static final boolean isError(KotlinType r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        UnwrappedType r10 = r5.unwrap();
        if ((r10 instanceof ErrorType) == false) goto L5;
    L10:
        return true;
    L5:
        if ((r10 instanceof FlexibleType) == true) goto L7;
    L9:
        return false;
    L7:
        if ((((FlexibleType) r10).getDelegate() instanceof ErrorType) == false) goto L9;
        goto L9
    }

    public static final boolean isNullable(KotlinType r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return TypeUtils.isNullableType(r5);
    }
}
