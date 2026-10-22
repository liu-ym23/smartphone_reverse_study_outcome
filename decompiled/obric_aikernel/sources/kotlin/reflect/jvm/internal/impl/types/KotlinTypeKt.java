package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorType;

/* JADX INFO: loaded from: classes3.dex */
public final class KotlinTypeKt {
    public static final boolean isError(KotlinType r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        UnwrappedType r11 = r10.unwrap();
        if ((r11 instanceof ErrorType) == false) goto L5;
    L10:
        return true;
    L5:
        if ((r11 instanceof FlexibleType) == true) goto L7;
    L9:
        return false;
    L7:
        if ((((FlexibleType) r11).getDelegate() instanceof ErrorType) == false) goto L9;
        goto L9
    }

    public static final boolean isNullable(KotlinType r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return TypeUtils.isNullableType(r10);
    }
}
