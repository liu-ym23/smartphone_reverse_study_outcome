package com.bytedance.android.live.liveinteract.plantform.dynamicframe;

import android.net.Uri;
import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.liveinteract.utils.MultiLinkLoadWidgetUtils;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.livesdk.config.MultiLinkRevenueEnterRoomOptConfigV2;
import com.bytedance.android.livesdk.config.tp;
import com.google.gson.JsonObject;
import kotlin.Lazy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class x0 extends b7.a {
    public int a;
    public final /* synthetic */ e0 b;
    public final /* synthetic */ long c;
    public final /* synthetic */ Uri d;

    public final void onLoadSuccess(View r7) {
        Lazy r8 = MultiLinkLoadWidgetUtils.a;
        MultiLinkLoadWidgetUtils.p(this.b.b, "MultiLinkMainHybridCardManager#obtainRenderHybridComponent#onLoadSuccess", "[tag:MultiLinkRenderWidgetReuseManager]未使用缓存, renderWidget: " + this.b.e);
        ALogger.i("MultiLinkMainHybridCardManager", "render HybridCard load success use:" + (System.currentTimeMillis() - this.c));
        int r9 = com.bytedance.android.live.liveinteract.utils.w0.a;
        if (((MultiLinkRevenueEnterRoomOptConfigV2) tp.a.getValue()).getStartEventOpt() == false) goto L6;
        this.b.getClass();
        if (e0.j() == false) goto L6;
    L13:
        ih0.c r10 = this.b.e;
        if (r10 == null) goto L18;
        View r11 = r10.S0();
        if (r11 == null) goto L18;
        UtilityKotlinExtentionsKt.w(r11);
    L18:
        this.b.s();
        return;
    L6:
        JsonObject r12 = new JsonObject();
        r12.addProperty("lifecycle", "start");
        r12.addProperty("source", PbRequest.SwitchType.ROOM);
        if (MultiLinkLoadWidgetUtils.k() == false) goto L9;
        this.b.getClass();
        r12.add("client_settings_info", e0.d());
    L9:
        this.b.i(r12);
        int r0 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.u.b;
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.u.d(this.d.toString(), "render", "root", System.currentTimeMillis() - this.c);
        ih0.c r1 = this.b.e;
        if (r1 == null) goto L12;
        r1.sendJsEvent("renderWidgetLifecycle", r12);
    L12:
        MultiLinkLoadWidgetUtils.p(this.b.b, "MultiLinkMainHybridCardManager#obtainRenderHybridComponent#onLoadSuccess", "[tag:MultiLinkRenderWidgetReuseManager]渲染容器发送renderWidgetLifecycle start, 未使用缓存, renderWidget: " + this.b.e);
        goto L13
    }

    public x0(e0 r1, long r2, Uri r4) {
        this.b = r1;
        this.c = r2;
        this.d = r4;
    }

    public final void onLoadFail(View r7, String r8, String r9) {
        super.onLoadFail(r7, r8, r9);
        Lazy r10 = MultiLinkLoadWidgetUtils.a;
        MultiLinkLoadWidgetUtils.m(this.b.b, "MultiLinkMainHybridCardManager#obtainRenderHybridComponent#onLoadFail", "[tag:MultiLinkRenderWidgetReuseManager]渲染容器加载失败! url=" + r8 + ", reason=" + r9);
        int r11 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.u.b;
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.u.b(this.d.toString(), "render", "root", System.currentTimeMillis() - this.c, r9);
        if (this.a >= vm2.h.i().reloadCount()) goto L5;
        this.a++;
        e0 r12 = this.b;
        r12.l(r12.e(null));
        return;
    L5:
        this.b.e = null;
    }
}
