package com.bytedance.android.ec.core.hybrid.utils;

import java.util.concurrent.Callable;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class o<V> implements Callable {
    public final /* synthetic */ String a;
    public final /* synthetic */ long b;

    public o(String r1, long r10) {
        this.a = r1;
        this.b = r10;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        JSONObject r1 = new JSONObject();     // Catch: Throwable -> L5
        r1.put("api_path", "/order/buyRender");     // Catch: Throwable -> L5
        r1.put(com.bytedance.android.ec.core.event.a.KEY_PAGE_NAME, "product_buynow_" + this.a);     // Catch: Throwable -> L5
        r1.put("time_interval", this.b);     // Catch: Throwable -> L5
        r1.put(com.bytedance.android.ec.core.event.a.KEY_FE_FLAG, "stand_for");     // Catch: Throwable -> L5
        com.bytedance.android.ec.sdk.helper.g.a.logV3("ecommerce_tect_stat", r1);     // Catch: Throwable -> L5
        return r1;
    L5:
        th = move-exception;
        th.printStackTrace();
        return Unit.INSTANCE;
    }
}
