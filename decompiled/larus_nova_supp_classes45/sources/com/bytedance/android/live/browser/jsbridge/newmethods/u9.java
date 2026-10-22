package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.livehostapi.platform.depend.IPopTuringVerifyCallback;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class u9 implements IPopTuringVerifyCallback {
    public final /* synthetic */ t9 a;

    public u9(t9 r1) {
        this.a = r1;
    }

    public final void onFail(int r2, JSONObject r3) {
        if (r2 != (-1)) goto L6;
        this.a.finishWithFailure();
        return;
    L6:
        JSONObject r4 = new JSONObject();
        r4.put("code", r2);
        r4.put("success", false);
        this.a.finishWithResult(r4);
    }

    public final void onSuccess(int r2, JSONObject r3) {
        JSONObject r4 = new JSONObject();
        r4.put("code", r2);
        r4.put("success", true);
        this.a.finishWithResult(r4);
    }
}
