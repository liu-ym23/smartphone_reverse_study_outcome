package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.base.SelectGiftDynamicCardResultModel;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ClickLynxSeriesCard;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class pb extends w20.s5<w20.vd, SelectGiftDynamicCardResultModel> {
    public final com.bytedance.android.scope.j a;

    public pb(com.bytedance.android.scope.j r1) {
        this.a = r1;
    }

    public final void invoke(Object r4, CallContext r5) {
        w20.vd r6 = (w20.vd) r4;
        Intrinsics.checkNotNullParameter(r6, "params");
        Intrinsics.checkNotNullParameter(r5, "context");
        JsonObject r7 = r6.a();
        if (r7 == null) goto L7;
        JsonElement r8 = r7.get("giftId");
        if (r8 == null) goto L7;
        long r9 = r8.getAsLong();
    L9:
        if (r9 > 0) goto L12;
        finishWithFailure(new Throwable("giftId is " + r9));
        return;
    L12:
        if (this.a == null) goto L18;
        uz1.a r0 = com.bytedance.android.livesdk.gift.platform.core.utils.b0.a();
        if (r0 == null) goto L19;
        r0.a(new ClickLynxSeriesCard(r9));
        return;
    L19:
        return;
    L18:
        return;
    L7:
        r9 = -1;
        goto L9
    }
}
