package kotlin;

import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KMutableProperty0;
import kotlin.reflect.KMutableProperty1;
import kotlin.reflect.KProperty;
import kotlin.reflect.KProperty0;
import kotlin.reflect.KProperty1;

/* JADX INFO: loaded from: classes2.dex */
public final class PropertyReferenceDelegatesKt {
    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final <V> V getValue(KProperty0<? extends V> r10, Object r11, KProperty<?> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r12, "property");
        return r10.get();
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final <T, V> V getValue(KProperty1<T, ? extends V> r10, T r11, KProperty<?> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r12, "property");
        return r10.get(r11);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final <V> void setValue(KMutableProperty0<V> r10, Object r11, KProperty<?> r12, V r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r12, "property");
        r10.set(r13);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final <T, V> void setValue(KMutableProperty1<T, V> r10, T r11, KProperty<?> r12, V r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r12, "property");
        r10.set(r11, r13);
    }
}
