package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.annie.bridge.method.abs.GetDownloadGiftAssetsResultModel;
import com.bytedance.android.live.gift.IGiftService;
import com.bytedance.ies.web.jsbridge2.CallContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class k4 extends e7.h<e7.h0, GetDownloadGiftAssetsResultModel> {

    public static final class a {
    }

    static {
    }

    public k4() {
    }

    public final void invoke(Object r7, CallContext r8) {
        e7.h0 r9 = (e7.h0) r7;
        Intrinsics.checkNotNullParameter(r9, "params");
        Intrinsics.checkNotNullParameter(r8, "context");
        ((IGiftService) jc1.k.n(IGiftService.class)).initGiftResourceManager(com.bytedance.android.live.core.utils.s1.getContext());     // Catch: Exception -> L19
        Integer r11 = r9.b();
        if (r11 != null) goto L8;
    L10:
        int r5 = 1007;
    L11:
        IGiftService r0 = (IGiftService) jc1.k.n(IGiftService.class);
        String r12 = r9.c();
        if (r12 != null) goto L14;
        r12 = "JSB";
    L14:
        String r1 = r12;
        Integer r13 = r9.a();
        if (r13 == null) goto L17;
        long r14 = r13.intValue();
    L18:
        r0.downloadAssets(r1, r14, new l4(this), r5);
        return;
    L17:
        r14 = 0;
        goto L18
    L8:
        if (r11.intValue() != 0) goto L10;
        r5 = 1008;
    L19:
        e = move-exception;
        finishWithFailure(e);
    }
}
