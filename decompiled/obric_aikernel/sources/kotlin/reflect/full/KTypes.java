package kotlin.reflect.full;

import kotlin.SinceKotlin;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KType;
import kotlin.reflect.jvm.internal.KTypeImpl;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* JADX INFO: loaded from: classes3.dex */
@JvmName(name = "KTypes")
public final class KTypes {
    @SinceKotlin(version = "1.1")
    public static final boolean isSubtypeOf(KType r10, KType r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "other");
        return TypeUtilsKt.isSubtypeOf(((KTypeImpl) r10).getType(), ((KTypeImpl) r11).getType());
    }

    @SinceKotlin(version = "1.1")
    public static final boolean isSupertypeOf(KType r10, KType r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "other");
        return isSubtypeOf(r11, r10);
    }

    @SinceKotlin(version = "1.1")
    public static final KType withNullability(KType r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return ((KTypeImpl) r10).makeNullableAsSpecified$kotlin_reflection(r11);
    }
}
