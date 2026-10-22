package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService;
import com.bytedance.android.live.browser.jsbridge.base.LiveGameCommonInvokeResultModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.openplatform.api.minigame.IOpenPlatformMgAnchorService;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "live.gameCommonInvoke")
public final class b6 extends w20.p2<w20.pa, LiveGameCommonInvokeResultModel> {
    public static final /* synthetic */ int a = 0;

    public static final class a {
    }

    static {
    }

    public b6() {
    }

    public final void invoke(Object r3, CallContext r4) {
        w20.pa r5 = (w20.pa) r3;
        Intrinsics.checkNotNullParameter(r5, "params");
        Intrinsics.checkNotNullParameter(r4, "context");
        ALogger.i("LiveGameCommonInvokeMethod", "param " + r5);
        String r6 = r5.a();
        boolean r0 = false;
        boolean r1 = true;
        if (r6 != null) goto L5;
    L8:
        boolean r7 = true;
    L9:
        if (r7 == false) goto L21;
        JsonObject r8 = r5.b();
        if (r8 == null) goto L13;
        String r9 = r8.getAsString();
    L14:
        if (r9 != null) goto L16;
    L19:
        boolean r11 = true;
    L20:
        if (r11 == false) goto L21;
    L22:
        if (r0 == true) goto L24;
        finishWithFailure(new Throwable("params invalid"));
        return;
    L24:
        JsonObject r12 = r5.b();
        Intrinsics.checkNotNull(r12);
        JsonElement r13 = r12.get("from");
        if (r13 == null) goto L29;
        String r14 = r13.getAsString();
        if (r14 == null) goto L29;
        r1 = Intrinsics.areEqual(r14, "mg");
    L29:
        if (r1 == false) goto L33;
        IOpenPlatformMgAnchorService r15 = jc1.k.f(IOpenPlatformMgAnchorService.class);
        if (r15 == null) goto L38;
        String r2 = r5.a();
        Intrinsics.checkNotNull(r2);
        JsonObject r16 = r5.b();
        Intrinsics.checkNotNull(r16);
        r15.handleCommonJSBInvoke(r2, r16, new LiveGameCommonInvokeMethod$invoke$1(this));
        return;
    L38:
        return;
    L33:
        IInteractGameService r17 = (IInteractGameService) jc1.k.f(IInteractGameService.class);
        if (r17 == null) goto L40;
        String r18 = r5.a();
        Intrinsics.checkNotNull(r18);
        JsonObject r19 = r5.b();
        Intrinsics.checkNotNull(r19);
        r17.handleAnchorPanelJSBInvoke(r18, r19, new LiveGameCommonInvokeMethod$invoke$2(this));
        return;
    L40:
        return;
    L16:
        if (r9.length() == 0) goto L19;
        r11 = false;
        goto L20
    L13:
        r9 = null;
    L21:
        r0 = true;
        goto L22
    L5:
        if (r6.length() == 0) goto L8;
        r7 = false;
        goto L9
    }
}
