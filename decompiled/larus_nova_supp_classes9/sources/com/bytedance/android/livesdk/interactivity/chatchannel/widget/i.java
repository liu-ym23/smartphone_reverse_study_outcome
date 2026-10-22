package com.bytedance.android.livesdk.interactivity.chatchannel.widget;

import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.functions.Action;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class i implements Action {
    public final /* synthetic */ ChatChannelInviteButtonWidget a;
    public final /* synthetic */ Observer b;

    public i(ChatChannelInviteButtonWidget r1, k r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void run() {
        DataCenter r0 = ((Widget) this.a).dataCenter;
        if (r0 == null) goto L6;
        r0.removeObserver(this.b);
        return;
    }
}
