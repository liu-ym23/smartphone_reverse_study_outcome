package com.bytedance.android.livesdk.chatroom.viewmodule.welfare;

import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.p2;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class m<T> implements Consumer {
    public final /* synthetic */ WelfareAnchorServiceWidget a;

    public m(WelfareAnchorServiceWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        if (((BaseResponse) ((Response) r4)).statusCode != 0) goto L8;
        WelfareAnchorServiceWidget r5 = this.a;
        r5.c = 0;
        p2 r6 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.utils.n.a(((Widget) r5).dataCenter);
        r6.m = false;
        DataCenter r1 = ((Widget) this.a).dataCenter;
        if (r1 == null) goto L7;
        r1.put("data_live_mini_app_commerce_status", r6);
    L7:
        f2.b(2131922065, 0);
        return;
    L8:
        f2.b(2131920661, 0);
    }
}
