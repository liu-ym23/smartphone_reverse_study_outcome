package com.bytedance.android.livesdk.coupon;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.android.livesdkapi.TTLiveService;
import com.bytedance.android.livesdkapi.service.ILiveService;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.mt.protector.impl.UriProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class h implements dt1.a {
    public final /* synthetic */ b a;
    public final /* synthetic */ Runnable b;
    public final /* synthetic */ UgCouponWidget c;

    @Override // dt1.a
    public final void onClose() {
        UgCouponWidget.xq(this.c, this.a, "close");
    }

    @Override // dt1.a
    public final void onRefuse() {
        this.b.run();
        UgCouponWidget.xq(this.c, this.a, "quit");
    }

    @Override // dt1.a
    public final void a(b.C0114b r3) {
        ILiveService r0 = TTLiveService.getLiveService();
        if (r0 != null) goto L5;
        return;
    L5:
        String r4 = r3.schema;
        if (TextUtils.isEmpty(r4) == false) goto L8;
        return;
    L8:
        Context r1 = ((Widget) this.c).context;
        if (r1 != null) goto L11;
        return;
    L11:
        r0.handleSchema(r1, UriProtector.parse(r4));
        UgCouponWidget.xq(this.c, this.a, "receive");
    }

    public h(UgCouponWidget r1, b r2, Runnable r3) {
        this.c = r1;
        this.a = r2;
        this.b = r3;
    }
}
