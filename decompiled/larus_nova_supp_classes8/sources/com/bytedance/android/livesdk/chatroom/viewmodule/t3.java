package com.bytedance.android.livesdk.chatroom.viewmodule;

import com.bytedance.android.livehostapi.business.depend.ICaptchaCallback;
import com.bytedance.android.livesdk.message.model.dn;
import com.bytedance.common.utility.Logger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class t3 implements ICaptchaCallback {
    public final /* synthetic */ VerifyCodeWidget a;
    public final /* synthetic */ dn b;

    public final void onSuccess() {
        Logger.d("VerifyCodeWidget", "showCaptchaV2, onSuccess");
        VerifyCodeWidget.xq(this.a, this.b.E(), true);
    }

    public final void onFailure(int r3) {
        Logger.d("VerifyCodeWidget", "showCaptchaV2, onFailure");
        VerifyCodeWidget.xq(this.a, this.b.E(), false);
    }

    public t3(VerifyCodeWidget r1, dn r2) {
        this.a = r1;
        this.b = r2;
    }
}
