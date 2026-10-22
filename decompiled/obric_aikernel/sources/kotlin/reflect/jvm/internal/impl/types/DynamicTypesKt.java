package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class DynamicTypesKt {
    public static final boolean isDynamic(KotlinType r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.unwrap() instanceof DynamicType;
    }
}
