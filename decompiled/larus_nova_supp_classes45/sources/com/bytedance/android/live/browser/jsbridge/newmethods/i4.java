package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.web.jsbridge2.CallContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class i4 extends e<j4, GetDiscussionsResultModel> {
    public final DataCenter a;

    public i4(DataCenter r2) {
        Intrinsics.checkNotNullParameter(r2, "mDataCenter");
        this.a = r2;
    }

    public final void invoke(Object r2, CallContext r3) {
        Intrinsics.checkNotNullParameter((j4) r2, "params");
        Intrinsics.checkNotNullParameter(r3, "context");
        if (this.a.get("data_vs_room_topic_info_str") == null) goto L5;
        GetDiscussionsResultModel r4 = new GetDiscussionsResultModel();
        r4.a(GetDiscussionsResultModel.Code.Success);
        r4.b((String) this.a.get("data_vs_room_topic_info_str"));
        finishWithResult(r4);
        return;
    L5:
        finishWithFailure();
    }
}
