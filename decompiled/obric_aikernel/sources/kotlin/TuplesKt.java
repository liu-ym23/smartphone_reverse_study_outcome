package kotlin;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@JvmName(name = "TuplesKt")
public final class TuplesKt {
    public static final <A, B> Pair<A, B> to(A r10, B r11) {
        return new Pair(r10, r11);
    }

    public static final <T> List<T> toList(Pair<? extends T, ? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return CollectionsKt.listOf(new Object[]{r10.getFirst(), r10.getSecond()});
    }

    public static final <T> List<T> toList(Triple<? extends T, ? extends T, ? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return CollectionsKt.listOf(new Object[]{r10.getFirst(), r10.getSecond(), r10.getThird()});
    }
}
