package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.base.model.UrlModel;
import com.bytedance.android.livesdkapi.business.ILiveDouPlusService;
import com.bytedance.common.utility.Logger;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import w20.je;
import w20.ke;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "sendThirdTrack")
public final class zb extends w20.d6<je, ke> {
    public zb() {
    }

    public final void invoke(Object r5, CallContext r6) {
        je r7 = (je) r5;
        Intrinsics.checkNotNullParameter(r7, "params");
        Intrinsics.checkNotNullParameter(r6, "context");
        String r8 = r7.a();
        if (r8 != null) goto L5;
    L8:
        boolean r9 = true;
    L9:
        if (r9 == true) goto L22;
        ILiveDouPlusService r11 = jc1.k.n(ILiveDouPlusService.class);     // Catch: Exception -> L17
        String r0 = r7.c();     // Catch: Exception -> L17
        UrlModel r1 = new UrlModel();     // Catch: Exception -> L17
        r1.setUrlList(r7.d());     // Catch: Exception -> L17
        Unit r2 = Unit.INSTANCE;     // Catch: Exception -> L17
        String r3 = r7.a();     // Catch: Exception -> L17
        if (r3 == null) goto L14;
        long r4 = CastLongProtector.parseLong(r3);     // Catch: Exception -> L17
    L15:
        r11.sendThirdTrack(r0, r1, Long.valueOf(r4), r7.b());     // Catch: Exception -> L17
        return;
    L14:
        r4 = 0;
    L17:
        e = move-exception;
        Logger.e("SendThirdTrackMethod", String.valueOf(e.getMessage()));
        return;
    L22:
        return;
    L5:
        if (r8.length() == 0) goto L8;
        r9 = false;
        goto L9
    }
}
