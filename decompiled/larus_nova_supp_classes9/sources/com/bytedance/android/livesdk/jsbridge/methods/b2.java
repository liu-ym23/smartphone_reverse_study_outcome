package com.bytedance.android.livesdk.jsbridge.methods;

import com.bytedance.ies.web.jsbridge2.CallContext;
import io.reactivex.functions.Consumer;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b2<T> implements Consumer {
    public final /* synthetic */ c2 a;
    public final /* synthetic */ CallContext b;

    public b2(c2 r1, CallContext r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r3) {
        Throwable r4 = (Throwable) r3;
        JSONObject r5 = new JSONObject();
        r5.put("code", 0);
        this.b.b("H5_lottieAnimationStatus", r5);
        this.a.finishWithSuccess();
    }
}
