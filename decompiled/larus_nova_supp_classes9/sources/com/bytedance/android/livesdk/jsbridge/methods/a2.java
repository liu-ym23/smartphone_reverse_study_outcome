package com.bytedance.android.livesdk.jsbridge.methods;

import com.bytedance.ies.web.jsbridge2.CallContext;
import io.reactivex.functions.Consumer;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a2<T> implements Consumer {
    public final /* synthetic */ c2 a;
    public final /* synthetic */ CallContext b;

    public a2(c2 r1, CallContext r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r6) {
        c2 r0 = this.a;
        int r7 = ((Integer) r6).intValue();
        CallContext r1 = this.b;
        r0.getClass();
        if (r7 != 0) goto L5;
        JSONObject r8 = new JSONObject();
        r8.put("code", 0);
        r1.b("H5_lottieAnimationStatus", r8);
        r0.finishWithSuccess();
        return;
    L5:
        if (r7 != 1) goto L7;
        JSONObject r9 = new JSONObject();
        r9.put("code", 1);
        r1.b("H5_lottieAnimationStatus", r9);
        return;
    L7:
        if (r7 != 2) goto L15;
        JSONObject r10 = new JSONObject();
        r10.put("code", 2);
        r1.b("H5_lottieAnimationStatus", r10);
        r0.finishWithSuccess();
        return;
    }
}
