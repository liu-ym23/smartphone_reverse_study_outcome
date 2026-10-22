package com.bytedance.android.livesdk.chatroom.ui.framework.widget;

import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.chatroom.model.ShareReportResult;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c1<T> implements Consumer {
    public final /* synthetic */ ShareCompositeWidget a;

    public c1(ShareCompositeWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        Response r4 = (Response) r3;
        if (r4 == null) goto L6;
        ShareCompositeWidget r0 = this.a;
        ShareReportResult r5 = (ShareReportResult) ((BaseResponse) r4).data;
        int r1 = ShareCompositeWidget.h;
        r0.zq(r5);
        return;
    }
}
