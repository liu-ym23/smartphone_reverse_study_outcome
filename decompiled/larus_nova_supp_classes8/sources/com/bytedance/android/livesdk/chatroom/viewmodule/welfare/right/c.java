package com.bytedance.android.livesdk.chatroom.viewmodule.welfare.right;

import com.bytedance.android.live.network.response.Response;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ WelfareAudienceWelfareServiceWidget a;

    public c(WelfareAudienceWelfareServiceWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        Response r4 = (Response) r3;
        DataCenter r5 = ((Widget) this.a).dataCenter;
        if (r5 == null) goto L6;
        r5.put("data_live_welfare_donation_click_count", 0L);
        return;
    }
}
