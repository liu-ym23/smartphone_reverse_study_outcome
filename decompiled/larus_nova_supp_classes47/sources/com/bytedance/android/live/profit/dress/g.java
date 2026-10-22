package com.bytedance.android.live.profit.dress;

import io.reactivex.Single;
import io.reactivex.functions.Function;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g<T, R> implements Function {
    public static final g a = null;

    static {
        a = new g();
    }

    public g() {
    }

    public final Object apply(Object r2) {
        Intrinsics.checkNotNullParameter(r2, "keva");
        if ((r2 instanceof Unit) == false) goto L6;
        int r3 = com.bytedance.revenue.platform.api.core.rx.q.a;
        return Single.just(CollectionsKt.emptyList());
    L6:
        if ((r2 instanceof iz0.a) == true) goto L8;
        r2 = null;
    L8:
        iz0.a r4 = (iz0.a) r2;
        if (r4 == null) goto L14;
        Single<Map<String, ?>> r5 = r4.getAll();
        if (r5 == null) goto L14;
        Single r6 = r5.map(f.a);
        if (r6 == null) goto L14;
        return r6;
    L14:
        int r7 = com.bytedance.revenue.platform.api.core.rx.q.a;
        return Single.just(CollectionsKt.emptyList());
    }
}
