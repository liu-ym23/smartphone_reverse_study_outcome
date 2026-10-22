package com.bytedance.android.live.profit.redpacket;

import com.bytedance.android.live.profile.monitor.DataType;
import io.reactivex.functions.Consumer;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g0<T> implements Consumer {
    public static final g0 a = null;

    static {
        a = new g0();
    }

    public g0() {
    }

    public final void accept(Object r6) {
        n0 r7 = (n0) r6;
        if (r7 == null) goto L6;
        String r0 = o.b(r7.q, r7.getType());
        o.d(CollectionsKt.listOf(r7.d).toString(), CollectionsKt.listOf(r0).toString(), DataType.TRUE, CollectionsKt.listOf(o.f(r7.s, r7.l)).toString());
        return;
    }
}
