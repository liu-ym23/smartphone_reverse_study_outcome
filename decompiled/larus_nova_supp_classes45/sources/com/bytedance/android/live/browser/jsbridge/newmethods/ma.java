package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.base.RegisterSendGiftEventResultModel;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "registerSendGiftEvent")
public final class ma extends w20.g5<JsonObject, RegisterSendGiftEventResultModel> {
    public final List<ca0.s> a;
    public final GiftContext b;

    public final void onTerminate() {
        GiftContext r0 = this.b;
        if (r0 != null) goto L5;
        return;
    L5:
        ((Set) r0.getGiftSendResultListeners().getValue()).removeAll(this.a);
        ((ArrayList) this.a).clear();
    }

    public ma() {
        this.a = new ArrayList();
        this.b = com.bytedance.android.livesdk.gift.util.b.b();
    }

    public final void invoke(Object r2, CallContext r3) {
        Intrinsics.checkNotNullParameter((JsonObject) r2, "params");
        Intrinsics.checkNotNullParameter(r3, "context");
        if (this.b != null) goto L5;
        finishWithFailure(new Throwable("gift context is null"));
        return;
    L5:
        la r4 = new la(r3);
        ((ArrayList) this.a).add(r4);
        ((Set) this.b.getGiftSendResultListeners().getValue()).add(r4);
        finishWithSuccess();
    }
}
