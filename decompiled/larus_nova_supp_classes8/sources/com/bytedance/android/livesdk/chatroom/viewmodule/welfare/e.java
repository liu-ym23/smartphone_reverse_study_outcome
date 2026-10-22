package com.bytedance.android.livesdk.chatroom.viewmodule.welfare;

import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.p2;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ WelfareAnchorServiceWidget a;
    public final /* synthetic */ long b;

    public e(WelfareAnchorServiceWidget r1, long r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r3) {
        if (((BaseResponse) ((Response) r3)).statusCode != 0) goto L8;
        WelfareAnchorServiceWidget r4 = this.a;
        r4.c = this.b;
        p2 r5 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.utils.n.a(((Widget) r4).dataCenter);
        r5.m = true;
        DataCenter r0 = ((Widget) this.a).dataCenter;
        if (r0 == null) goto L7;
        r0.put("data_live_mini_app_commerce_status", r5);
    L7:
        this.a.yq(r5);
        return;
    L8:
        f2.b(2131920661, 0);
    }
}
