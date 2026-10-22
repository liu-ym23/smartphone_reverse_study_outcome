package kotlin;

import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes2.dex */
class LazyKt__LazyKt extends LazyKt__LazyJVMKt {
    public LazyKt__LazyKt() {
    }

    @InlineOnly
    private static final <T> T getValue(Lazy<? extends T> r10, Object r11, KProperty<?> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r12, "property");
        return r10.getValue();
    }

    public static <T> Lazy<T> lazyOf(T r10) {
        return new InitializedLazyImpl(r10);
    }
}
