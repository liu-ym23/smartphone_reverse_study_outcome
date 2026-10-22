package com.bytedance.android.live.profit.lottery;

import com.bytedance.android.live.network.response.ExtraResponse;
import io.reactivex.functions.Function;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class z<T, R> implements Function {
    public static final z a = null;

    static {
        a = new z();
    }

    public z() {
    }

    public final Object apply(Object r2) {
        ExtraResponse r3 = (ExtraResponse) r2;
        Intrinsics.checkNotNullParameter(r3, "it");
        com.bytedance.android.live.profit.lottery.model.c r4 = (com.bytedance.android.live.profit.lottery.model.c) r3.data;
        if (r4 == null) goto L9;
        List<com.bytedance.android.live.profit.lottery.model.b> r5 = r4.a();
        if (r5 == null) goto L9;
        if (r5.isEmpty() == true) goto L9;
        boolean r6 = true;
    L11:
        return Boolean.valueOf(r6);
    L9:
        r6 = false;
        goto L11
    }
}
