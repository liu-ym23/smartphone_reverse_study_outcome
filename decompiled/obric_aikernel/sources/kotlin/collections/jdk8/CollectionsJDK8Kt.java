package kotlin.collections.jdk8;

import java.util.Map;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes2.dex */
@JvmName(name = "CollectionsJDK8Kt")
public final class CollectionsJDK8Kt {
    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final <K, V> V getOrDefault(Map<? extends K, ? extends V> r10, K r11, V r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.getOrDefault(r11, r12);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final <K, V> boolean remove(Map<? extends K, ? extends V> r10, K r11, V r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return TypeIntrinsics.asMutableMap(r10).remove(r11, r12);
    }
}
