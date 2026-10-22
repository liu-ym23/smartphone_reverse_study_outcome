package com.bytedance.android.live.liveinteract.plantform.dynamicframe;

import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.liveinteract.utils.MultiLinkLoadWidgetUtils;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.google.gson.JsonObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a0 extends b7.a {
    public final /* synthetic */ MultiLinkFeedHybridCardManager a;

    public a0(MultiLinkFeedHybridCardManager r1) {
        this.a = r1;
    }

    public final void onLoadSuccess(View r3) {
        JsonObject r4 = new JsonObject();
        r4.addProperty("lifecycle", "start");
        r4.addProperty("source", PbRequest.SwitchType.FEED);
        if (MultiLinkLoadWidgetUtils.k() == false) goto L5;
        this.a.getClass();
        r4.add("client_settings_info", MultiLinkFeedHybridCardManager.a());
    L5:
        this.a.f(r4);
        ih0.c r0 = this.a.b;
        if (r0 == null) goto L8;
        r0.sendJsEvent("renderWidgetLifecycle", r4);
    L8:
        ih0.c r5 = this.a.b;
        if (r5 == null) goto L13;
        View r6 = r5.S0();
        if (r6 == null) goto L13;
        UtilityKotlinExtentionsKt.w(r6);
    L13:
        this.a.k();
    }

    public final void onLoadFail(View r2, String r3, String r4) {
        super.onLoadFail(r2, r3, r4);
        ALogger.e("MultiLinkFeedHybridCardManager", "渲染容器加载失败! url=" + r3 + ", reason=" + r4);
        this.a.b = null;
    }
}
