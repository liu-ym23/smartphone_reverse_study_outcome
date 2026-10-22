package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class DynamicTypesKt {
    public static final boolean isDynamic(KotlinType r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return r5.unwrap() instanceof DynamicType;
    }
}
