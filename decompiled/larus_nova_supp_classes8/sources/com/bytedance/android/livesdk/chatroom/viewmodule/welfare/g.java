package com.bytedance.android.livesdk.chatroom.viewmodule.welfare;

import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class g<T> implements Consumer {
    public final /* synthetic */ WelfareAnchorServiceWidget a;
    public final /* synthetic */ long b;

    public g(WelfareAnchorServiceWidget r1, long r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r3) {
        if (((BaseResponse) ((Response) r3)).statusCode != 0) goto L5;
        WelfareAnchorServiceWidget r4 = this.a;
        r4.c = this.b;
        return;
    L5:
        f2.b(2131920661, 0);
    }
}
