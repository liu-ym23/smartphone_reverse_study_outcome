package com.bytedance.android.live.recharge;

import com.bytedance.android.livesdkapi.depend.model.IQueryPrePayCashierData;
import io.reactivex.functions.Consumer;
import java.util.Map;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class n0<T> implements Consumer {
    public final /* synthetic */ p0 a;

    public n0(p0 r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Map r0 = (Map) this.a.a.r.a;
        Map r3 = ((IQueryPrePayCashierData) r2).getRenderData();
        if (r3 != null) goto L5;
        r3 = MapsKt.emptyMap();
    L5:
        r0.putAll(r3);
    }
}
