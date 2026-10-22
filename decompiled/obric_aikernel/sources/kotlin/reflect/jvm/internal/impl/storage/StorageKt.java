package kotlin.reflect.jvm.internal.impl.storage;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes3.dex */
public final class StorageKt {
    public static final <T> T getValue(NotNullLazyValue<? extends T> r10, Object r11, KProperty<?> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r12, "p");
        return r10.invoke();
    }

    public static final <T> T getValue(NullableLazyValue<? extends T> r10, Object r11, KProperty<?> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r12, "p");
        return r10.invoke();
    }
}
