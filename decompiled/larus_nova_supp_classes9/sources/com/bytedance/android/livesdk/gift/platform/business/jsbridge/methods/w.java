package com.bytedance.android.livesdk.gift.platform.business.jsbridge.methods;

import com.bytedance.android.live.network.response.ExtraResponse;
import io.reactivex.functions.Consumer;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class w<T> implements Consumer {
    public final /* synthetic */ y a;

    public w(y r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        ExtraResponse r4 = (ExtraResponse) r3;
        JSONObject r5 = new JSONObject();
        r5.put("code", 1);
        this.a.finishWithResult(r5);
    }
}
