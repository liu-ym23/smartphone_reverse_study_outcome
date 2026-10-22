package com.bytedance.android.livesdk.jsbridge.methods;

import com.bytedance.android.livesdkapi.service.ILiveService;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b0 implements ILiveService.JsbHandleCallback {
    public final /* synthetic */ c0 a;

    public b0(c0 r1) {
        this.a = r1;
    }

    public final void onHandleResult(boolean r1, JSONObject r2) {
        if (r1 == false) goto L4;
        this.a.finishWithResult(r2);
        return;
    L4:
        this.a.finishWithFailure();
    }
}
