package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.base.CheckAnchorEffectInUsedResultModel;
import com.bytedance.android.livesdkapi.eventbus.CheckAnchorStickerStatusEvent;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "checkAnchorEffectInUsed")
public final class u1 extends w20.r<w20.a8, CheckAnchorEffectInUsedResultModel> {
    public u1() {
    }

    public final void invoke(Object r4, CallContext r5) {
        w20.a8 r6 = (w20.a8) r4;
        Intrinsics.checkNotNullParameter(r6, "params");
        Intrinsics.checkNotNullParameter(r5, "context");
        String r7 = r6.b();
        if (Intrinsics.areEqual(r7, com.bytedance.android.live.effect.api.d0.e) == false) goto L5;
    L8:
        String r8 = com.bytedance.android.live.effect.api.d0.c;
    L9:
        String r0 = "";
        if (r8 != null) goto L12;
        r8 = "";
    L12:
        xs2.b r1 = xs2.b.a();
        String r9 = r6.a();
        if (r9 == null) goto L16;
        r0 = r9;
    L16:
        r1.post(new CheckAnchorStickerStatusEvent(r0, r8, new t1(this)));
        return;
    L5:
        if (Intrinsics.areEqual(r7, com.bytedance.android.live.effect.api.d0.f) == true) goto L8;
        r8 = r6.b();
        goto L9
    }
}
