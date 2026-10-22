package com.bytedance.android.live.profit.dress;

import io.reactivex.functions.Function;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f<T, R> implements Function {
    public static final f a = null;

    static {
        a = new f();
    }

    public f() {
    }

    public final Object apply(Object r2) {
        Map r3 = (Map) r2;
        Intrinsics.checkNotNullParameter(r3, "list");
        return SequencesKt.toList(SequencesKt.filterNotNull(SequencesKt.map(MapsKt.asSequence(r3), DressKevaUtils$load$2$1$1.INSTANCE)));
    }
}
