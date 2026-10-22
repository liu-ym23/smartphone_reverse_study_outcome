package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.UnsignedTypes;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class ConstUtilKt {
    public static final boolean canBeUsedForConstVal(KotlinType r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (KotlinBuiltIns.isPrimitiveType(r10) == true) goto L7;
        if (UnsignedTypes.isUnsignedType(r10) == true) goto L7;
    L9:
        if (KotlinBuiltIns.isString(r10) == true) goto L12;
        return false;
    L12:
        return true;
    L7:
        if (TypeUtils.isNullableType(r10) == false) goto L12;
        goto L12
    }
}
