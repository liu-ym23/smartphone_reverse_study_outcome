package kotlin;

import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes2.dex */
public final class LazyKt extends LazyKt__LazyKt {
    private LazyKt() {
    }

    public static /* bridge */ /* synthetic */ <T> Lazy<T> lazy(LazyThreadSafetyMode r10, Function0<? extends T> r11) {
        return LazyKt__LazyJVMKt.lazy(r10, r11);
    }

    public static /* bridge */ /* synthetic */ <T> Lazy<T> lazy(Function0<? extends T> r10) {
        return LazyKt__LazyJVMKt.lazy(r10);
    }

    public static /* bridge */ /* synthetic */ <T> Lazy<T> lazyOf(T r10) {
        return LazyKt__LazyKt.lazyOf(r10);
    }
}
