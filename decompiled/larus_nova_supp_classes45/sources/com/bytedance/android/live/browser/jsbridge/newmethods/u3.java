package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.base.GetAssetsPathResultModel;
import com.bytedance.android.live.gift.IGiftService;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "getAssetsPath")
public final class u3 extends w20.d1<w20.k9, GetAssetsPathResultModel> {
    public u3() {
    }

    public final void invoke(Object r11, CallContext r12) {
        w20.k9 r13 = (w20.k9) r11;
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r12, "context");
        ((IGiftService) jc1.k.n(IGiftService.class)).initGiftResourceManager(com.bytedance.android.live.core.utils.s1.getContext());     // Catch: Exception -> L33
    L34:
        JsonObject r14 = new JsonObject();     // Catch: Exception -> L30
        List<Long> r15 = r13.a();     // Catch: Exception -> L30
        if (r15 == null) goto L28;
        IGiftService r0 = (IGiftService) jc1.k.f(IGiftService.class);     // Catch: Exception -> L30
        if (r0 == null) goto L26;
        IAssetsManager r1 = r0.getAssetsManager();     // Catch: Exception -> L30
        if (r1 == null) goto L26;
        Iterator<T> r16 = r15.iterator();     // Catch: Exception -> L30
    L12:
        if (r16.hasNext() == false) goto L27;
        long r2 = ((Number) r16.next()).longValue();     // Catch: Exception -> L30
        JsonObject r3 = new JsonObject();     // Catch: Exception -> L30
        String r4 = r1.H0(r2);     // Catch: Exception -> L30
        if (r4 != null) goto L16;
        r4 = "";
    L16:
        Code r5 = Code.Downloaded;     // Catch: Exception -> L30
        if (r4.length() != 0) goto L19;
        boolean r6 = true;
    L20:
        if (r6 == false) goto L25;
        if (r1.G1(r2) == null) goto L24;
        r5 = Code.NotReady;     // Catch: Exception -> L30
        goto L25
    L24:
        r5 = Code.None;     // Catch: Exception -> L30
    L25:
        r3.addProperty("path", "file://" + r4);     // Catch: Exception -> L30
        r3.addProperty("code", Short.valueOf(r5.getValue()));     // Catch: Exception -> L30
        r14.add(String.valueOf(r2), r3);     // Catch: Exception -> L30
        goto L12
    L19:
        r6 = false;
    L27:
        GetAssetsPathResultModel r17 = new GetAssetsPathResultModel();     // Catch: Exception -> L30
        GetAssetsPathResultModel.a r7 = new GetAssetsPathResultModel.a();     // Catch: Exception -> L30
        r7.a(r14);     // Catch: Exception -> L30
        Unit r18 = Unit.INSTANCE;     // Catch: Exception -> L30
        r17.b(r7);     // Catch: Exception -> L30
        r17.a(GetAssetsPathResultModel.Code.Success);     // Catch: Exception -> L30
        finishWithResult(r17);     // Catch: Exception -> L30
        return;
    L26:
        finishWithFailure(new IllegalStateException("assetManager is null"));     // Catch: Exception -> L30
        goto L27
    L28:
        finishWithFailure(new IllegalArgumentException("asset ids is empty"));     // Catch: Exception -> L30
        return;
    L30:
        e = move-exception;
        finishWithFailure(e);
    }
}
