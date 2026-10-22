package kotlin.collections;

import java.util.Map;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes2.dex */
@JvmName(name = "MapAccessorsKt")
public final class MapAccessorsKt {
    @InlineOnly
    private static final <V, V1 extends V> V1 getValue(Map<? super String, ? extends V> r10, Object r11, KProperty<?> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r12, "property");
        return (V1) MapsKt__MapWithDefaultKt.getOrImplicitDefaultNullable(r10, r12.getName());
    }

    @InlineOnly
    @JvmName(name = "getVar")
    private static final <V, V1 extends V> V1 getVar(Map<? super String, ? extends V> r10, Object r11, KProperty<?> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r12, "property");
        return (V1) MapsKt__MapWithDefaultKt.getOrImplicitDefaultNullable(r10, r12.getName());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @InlineOnly
    private static final <V> void setValue(Map<? super String, ? super V> r10, Object r11, KProperty<?> r12, V r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r12, "property");
        r10.put(r12.getName(), r13);
    }
}
