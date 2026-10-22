package com.bytedance.android.live.liveinteract.plantform.dynamicframe;

import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.google.gson.JsonObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class y extends b7.a {
    public final /* synthetic */ MultiLinkFeedHybridCardManager a;

    public y(MultiLinkFeedHybridCardManager r1) {
        this.a = r1;
    }

    public final void onLoadSuccess(View r3) {
        super.onLoadSuccess(r3);
        ALogger.i("MultiLinkFeedHybridCardManager", "feed main HybridCard load success");
        JsonObject r4 = new JsonObject();
        r4.addProperty("lifecycle", "start");
        r4.addProperty("source", PbRequest.SwitchType.FEED);
        this.a.f(r4);
        ih0.c r0 = this.a.a;
        if (r0 == null) goto L5;
        r0.sendJsEvent("logicWidgetLifecycle", r4);
    L5:
        this.a.j();
    }

    public final boolean onFallback(int r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "errorMessage");
        ALogger.e("MultiLinkFeedHybridCardManager", "feed main HybridCard onFallback errorMessage=" + r4);
        return super.onFallback(r3, r4);
    }

    public final void onInnerFallback(int r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "errorMessage");
        super.onInnerFallback(r2, r3);
        ALogger.e("MultiLinkFeedHybridCardManager", "feed main HybridCard onInnerFallback errorMessage=" + r3);
    }

    public final void onContainerError(View r2, int r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "errorMessage");
        super.onContainerError(r2, r3, r4);
        ALogger.e("MultiLinkFeedHybridCardManager", "feed main HybridCard onContainerError errorMessage=" + r4);
    }

    public final void onLoadFail(View r1, String r2, String r3) {
        super.onLoadFail(r1, r2, r3);
        ALogger.e("MultiLinkFeedHybridCardManager", "feed main HybridCard load fail reason=" + r3);
        this.a.a = null;
    }
}
