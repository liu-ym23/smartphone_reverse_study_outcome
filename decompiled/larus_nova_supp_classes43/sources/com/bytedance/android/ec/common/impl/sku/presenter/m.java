package com.bytedance.android.ec.common.impl.sku.presenter;

import android.content.Context;
import com.bytedance.android.ec.core.vmsdk.VmSdkSetting;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class m<V> implements Callable {
    public final /* synthetic */ String a;
    public final /* synthetic */ Context b;

    public m(String r1, Context r10) {
        this.a = r1;
        this.b = r10;
    }

    @Override // java.util.concurrent.Callable
    public final void call() {
        JSONObject r0 = jg.g.f(UriProtector.getQueryParameter(UriProtector.parse(this.a), com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO));
        if (r0 == null) goto L5;
        String r1 = r0.optString(com.bytedance.android.ec.core.event.a.KEY_PRODUCT_SOURCE_PAGE);
    L7:
        if (Intrinsics.areEqual(r1, com.bytedance.android.ec.core.event.a.VALUE_PRODUCT_FLOW_PAGE) == false) goto L12;
        int r10 = ECSdk.a;
        com.bytedance.android.ec.core.monitor.o r11 = (com.bytedance.android.ec.core.monitor.o) ECSdk.a(com.bytedance.android.ec.core.monitor.o.class);
        if (r11 == null) goto L13;
        r11.a(this.b, "inflow_feed_place_order", this.a, null, VmSdkSetting.a().i());
        return;
    L13:
        return;
    L12:
        return;
    L5:
        r1 = null;
        goto L7
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        call();
        return Unit.INSTANCE;
    }
}
