package com.bytedance.android.livesdk.coupon.jsb;

import com.bytedance.android.livesdkapi.hybridapi.BaseJsBridgeMethodFactory;
import com.bytedance.android.livesdkapi.hybridapi.IJsBridgeManager;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.web.jsbridge2.g;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a extends BaseJsBridgeMethodFactory {
    public final /* synthetic */ DataCenter a;
    public final /* synthetic */ f b;

    public final Map<String, g<?, ?>> provideStatelessMethods(IJsBridgeManager r3) {
        Intrinsics.checkNotNullParameter(r3, "manager");
        LinkedHashMap r4 = new LinkedHashMap();
        r4.put("exchangeCoupon", new d(this.a));
        r4.put("doExpandCoupon", new c(this.b));
        r4.put("getExpandCouponInfo", new e(this.b));
        return r4;
    }

    public a(DataCenter r1, bt1.b.C0010b r2) {
        this.a = r1;
        this.b = r2;
    }
}
