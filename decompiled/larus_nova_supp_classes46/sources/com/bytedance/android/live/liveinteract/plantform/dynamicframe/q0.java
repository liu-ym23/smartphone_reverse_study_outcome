package com.bytedance.android.live.liveinteract.plantform.dynamicframe;

import com.bytedance.android.live.liveinteract.utils.MultiLinkLoadWidgetUtils;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.google.gson.JsonObject;
import io.reactivex.functions.Action;
import kotlin.Lazy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class q0 implements Action {
    public final /* synthetic */ ih0.c a;
    public final /* synthetic */ e0 b;
    public final /* synthetic */ Long c;

    public q0(ih0.c r1, e0 r2, Long r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void run() {
        e0.c(this.b, this.a, this.c);
        JsonObject r0 = new JsonObject();
        r0.addProperty("lifecycle", "start");
        r0.addProperty("source", PbRequest.SwitchType.ROOM);
        this.b.i(r0);
        Lazy r1 = MultiLinkLoadWidgetUtils.a;
        MultiLinkLoadWidgetUtils.p(this.b.b, "MultiLinkMainHybridCardManager#obtainMainHybridComponent", "[tag:MultiLinkHybridCardReuseManager]逻辑容器发送logicWidgetLifecycle start, 使用缓存");
        this.a.sendJsEvent("logicWidgetLifecycle", r0);
        e0.a(this.b);
    }
}
