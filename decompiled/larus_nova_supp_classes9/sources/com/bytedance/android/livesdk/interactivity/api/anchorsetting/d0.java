package com.bytedance.android.livesdk.interactivity.api.anchorsetting;

import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d0<T> implements Consumer {
    public final /* synthetic */ int a;

    public d0(int r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        if (((BaseResponse) ((Response) r2)).statusCode != 0) goto L6;
        com.bytedance.android.livesdk.sharedpref.e r3 = com.bytedance.android.livesdk.sharedpref.b.W0;
        Integer r0 = Integer.valueOf(this.a);
        r3.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r3, r0);
        return;
    }
}
