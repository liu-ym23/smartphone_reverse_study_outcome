package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* JADX INFO: loaded from: classes3.dex */
public final class BuiltinSpecialPropertiesKt {
    public static final /* synthetic */ FqName access$child(FqName r10, String r11) {
        return child(r10, r11);
    }

    public static final /* synthetic */ FqName access$childSafe(FqNameUnsafe r10, String r11) {
        return childSafe(r10, r11);
    }

    private static final FqName child(FqName r10, String r11) {
        FqName r12 = r10.child(Name.identifier(r11));
        Intrinsics.checkNotNullExpressionValue(r12, "child(Name.identifier(name))");
        return r12;
    }

    private static final FqName childSafe(FqNameUnsafe r10, String r11) {
        FqName r12 = r10.child(Name.identifier(r11)).toSafe();
        Intrinsics.checkNotNullExpressionValue(r12, "child(Name.identifier(name)).toSafe()");
        return r12;
    }
}
