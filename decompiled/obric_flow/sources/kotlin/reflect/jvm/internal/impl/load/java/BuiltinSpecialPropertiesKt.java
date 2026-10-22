package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* JADX INFO: loaded from: classes3.dex */
public final class BuiltinSpecialPropertiesKt {
    public static final /* synthetic */ FqName access$child(FqName r5, String r10) {
        return child(r5, r10);
    }

    public static final /* synthetic */ FqName access$childSafe(FqNameUnsafe r5, String r10) {
        return childSafe(r5, r10);
    }

    private static final FqName child(FqName r5, String r10) {
        return r5.child(Name.identifier(r10));
    }

    private static final FqName childSafe(FqNameUnsafe r5, String r10) {
        return r5.child(Name.identifier(r10)).toSafe();
    }
}
