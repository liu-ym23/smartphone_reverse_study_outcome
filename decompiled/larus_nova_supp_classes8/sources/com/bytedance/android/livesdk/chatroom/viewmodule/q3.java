package com.bytedance.android.livesdk.chatroom.viewmodule;

import com.bytedance.android.livehostapi.business.depend.ICaptchaCallback;
import com.bytedance.android.livesdk.message.model.cn;
import com.bytedance.android.livesdk.message.model.mj;
import com.bytedance.common.utility.Logger;
import com.bytedance.ies.sdk.widgets.Widget;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class q3 implements ICaptchaCallback {
    public final /* synthetic */ VerifyCodeWidget a;
    public final /* synthetic */ cn b;

    public final void onSuccess() {
        Logger.d("VerifyCodeWidget", "showCaptcha, onSuccess");
        VerifyCodeWidget.yq(this.a, this.b, 1);
        VerifyCodeWidget.wq(this.a, 0);
        if (rx1.m.e(((Widget) this.a).context) == false) goto L5;
        xs2.b.a().post(new mj(false, null, 30));
    L5:
        this.a.c = true;
    }

    public final void onFailure(int r4) {
        Logger.d("VerifyCodeWidget", "showCaptcha, onFailure");
        VerifyCodeWidget.yq(this.a, this.b, 0);
        VerifyCodeWidget.wq(this.a, r4);
    }

    public q3(VerifyCodeWidget r1, cn r2, hu2.c r3) {
        this.a = r1;
        this.b = r2;
    }
}
