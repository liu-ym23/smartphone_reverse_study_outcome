package com.bytedance.android.livesdk.gift.platform.core.ui.configuration;

import com.bytedance.android.live.browser.jsbridge.base.RevenueRequestStickerEffectStatusResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.google.gson.JsonObject;
import kotlin.jvm.internal.Intrinsics;
import w20.o5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f extends o5<JsonObject, RevenueRequestStickerEffectStatusResultModel> {
    public final void onTerminate() {
    }

    public f() {
    }

    public final void invoke(Object r5, CallContext r6) {
        Intrinsics.checkNotNullParameter((JsonObject) r5, "params");
        Intrinsics.checkNotNullParameter(r6, "context");
        final GiftEffectCloseRequestMethod$invoke$1 r7 = new GiftEffectCloseRequestMethod$invoke$1(this);
        final GiftEffectCloseRequestMethod$invoke$2 r8 = new GiftEffectCloseRequestMethod$invoke$2(this);
        i12.e r0 = i12.o.b();
        if (r0 == null) goto L5;
        Object r1 = com.bytedance.android.scope.m.e.d(r0, d.class);
    L6:
        d r2 = (d) r1;
        if (r2 == null) goto L10;
        d.a(r2, new GiftEffectCloseRequestMethod$invoke$3(r7), new GiftEffectCloseRequestMethod$invoke$4(r8), null, 4);
        return;
    L10:
        return;
    L5:
        r1 = null;
        goto L6
    }
}
