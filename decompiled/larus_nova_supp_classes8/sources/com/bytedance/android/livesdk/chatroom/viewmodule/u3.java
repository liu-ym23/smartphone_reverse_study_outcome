package com.bytedance.android.livesdk.chatroom.viewmodule;

import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.common.utility.Logger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class u3<T> implements Consumer {
    public static final u3 a = null;

    static {
        a = new u3();
    }

    public u3() {
    }

    public final void accept(Object r2) {
        Long r3 = (Long) r2;
        TTLiveSDK.hostService().verify().dismissCaptcha();
        Logger.d("VerifyCodeWidget", "showCaptchaV2, dismissCaptcha");
    }
}
