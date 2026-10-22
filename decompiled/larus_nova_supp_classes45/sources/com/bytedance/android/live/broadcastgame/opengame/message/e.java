package com.bytedance.android.live.broadcastgame.opengame.message;

import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livehostapi.business.depend.ICaptchaCallback;
import com.bytedance.common.utility.Logger;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e implements ICaptchaCallback {
    public final /* synthetic */ AnchorGameMessageChannel a;
    public final /* synthetic */ f0 b;
    public final /* synthetic */ Function3 c;

    public final void onSuccess() {
        Logger.d("showCaptcha", "showCaptcha, onSuccess");
        this.a.c(this.b, this.c);
    }

    public final void onFailure(int r9) {
        Logger.d("showCaptcha", "showCaptcha, onFailure");
        AnchorGameMessageChannel r11 = this.a;
        Function3 r0 = this.c;
        Boolean r1 = Boolean.FALSE;
        r11.getClass();
        UtilityKotlinExtentionsKt.s(0, false, false, new AnchorGameMessageChannel$onLaunchFail$1(r0, null, r1), 7);
    }

    public e(AnchorGameMessageChannel r1, f0 r2, Function3 r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
