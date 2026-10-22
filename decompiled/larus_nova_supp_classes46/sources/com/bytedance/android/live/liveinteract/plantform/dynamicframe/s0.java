package com.bytedance.android.live.liveinteract.plantform.dynamicframe;

import android.net.Uri;
import android.view.View;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.utils.MultiLinkLoadWidgetUtils;
import com.bytedance.android.live.liveinteract.utils.MultiSceneEnterRoomStatisticsUtils;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.google.gson.JsonObject;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class s0 extends b7.a {
    public int a;
    public final /* synthetic */ e0 b;
    public final /* synthetic */ Ref.ObjectRef c;
    public final /* synthetic */ long d;
    public final /* synthetic */ Long e;

    public final void onRelease() {
        super.onRelease();
        Lazy r0 = MultiLinkLoadWidgetUtils.a;
        MultiLinkLoadWidgetUtils.m(this.b.b, "MultiLinkMainHybridCardManager#obtainMainHybridComponent", "[tag:MultiLinkHybridCardReuseManager]逻辑主容器onRelease, url:" + ((Uri) this.c.element));
        int r1 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.u.b;
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.u.e(((Uri) this.c.element).toString(), "main", "root", System.currentTimeMillis() - this.d);
    }

    public final void onLoadSuccess(View r6) {
        super.onLoadSuccess(r6);
        Lazy r7 = MultiLinkLoadWidgetUtils.a;
        MultiLinkLoadWidgetUtils.p(this.b.b, "MultiLinkMainHybridCardManager#obtainMainHybridComponent", "[tag:MultiLinkHybridCardReuseManager]加载逻辑主容器成功");
        int r8 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.u.b;
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.u.d(((Uri) this.c.element).toString(), "main", "root", System.currentTimeMillis() - this.d);
        int r9 = MultiSceneEnterRoomStatisticsUtils.u;
        DataCenter r10 = this.b.b;
        Long r1 = this.e;
        if (r1 == null) goto L5;
        long r2 = r1.longValue();
    L6:
        MultiSceneEnterRoomStatisticsUtils r11 = MultiSceneEnterRoomStatisticsUtils.a.a(r10, Long.valueOf(r2));
        if (r11 == null) goto L9;
        r11.recordSubElementShow("lynx_container_load", System.currentTimeMillis());
    L9:
        JsonObject r12 = new JsonObject();
        r12.addProperty("lifecycle", "start");
        r12.addProperty("source", PbRequest.SwitchType.ROOM);
        this.b.i(r12);
        MultiLinkLoadWidgetUtils.p(this.b.b, "MultiLinkMainHybridCardManager#obtainMainHybridComponent", "[tag:MultiLinkHybridCardReuseManager]逻辑容器发送logicWidgetLifecycle start");
        ih0.c r0 = this.b.d;
        if (r0 == null) goto L12;
        r0.sendJsEvent("logicWidgetLifecycle", r12);
    L12:
        int r13 = ((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene();
        if (r13 != 8) goto L15;
    L20:
        boolean r14 = true;
    L21:
        if (r14 == true) goto L23;
    L25:
        e0.a(this.b);
        return;
    L23:
        if (MultiLinkLoadWidgetUtils.g() == true) goto L25;
        this.b.r(true);
        goto L25
    L15:
        if (r13 == 5) goto L20;
        if (r13 == 12) goto L20;
        r14 = false;
        goto L21
    L5:
        r2 = 0;
        goto L6
    }

    public final boolean onFallback(int r10, String r11) {
        Intrinsics.checkNotNullParameter(r11, "errorMessage");
        Lazy r0 = MultiLinkLoadWidgetUtils.a;
        MultiLinkLoadWidgetUtils.m(this.b.b, "MultiLinkMainHybridCardManager#obtainMainHybridComponent", "[tag:MultiLinkHybridCardReuseManager]加载逻辑主容器失败, onFallback errorMessage=" + r11);
        int r1 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.u.b;
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.u.a("card_error", ((Uri) this.c.element).toString(), "main", "root", r10, r11, System.currentTimeMillis() - this.d);
        return super.onFallback(r10, r11);
    }

    public final void onInnerFallback(int r10, String r11) {
        Intrinsics.checkNotNullParameter(r11, "errorMessage");
        super.onInnerFallback(r10, r11);
        Lazy r0 = MultiLinkLoadWidgetUtils.a;
        MultiLinkLoadWidgetUtils.m(this.b.b, "MultiLinkMainHybridCardManager#obtainMainHybridComponent", "[tag:MultiLinkHybridCardReuseManager]加载逻辑主容器失败, onInnerFallback errorMessage=" + r11);
        int r1 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.u.b;
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.u.a("card_inner_error", ((Uri) this.c.element).toString(), "main", "root", r10, r11, System.currentTimeMillis() - this.d);
    }

    public final void onContainerError(View r9, int r10, String r11) {
        Intrinsics.checkNotNullParameter(r11, "errorMessage");
        super.onContainerError(r9, r10, r11);
        Lazy r12 = MultiLinkLoadWidgetUtils.a;
        MultiLinkLoadWidgetUtils.m(this.b.b, "MultiLinkMainHybridCardManager#obtainMainHybridComponent", "[tag:MultiLinkHybridCardReuseManager]加载逻辑主容器失败, onContainerError errorMessage=" + r11);
        int r13 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.u.b;
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.u.a("container_error", ((Uri) this.c.element).toString(), "main", "root", r10, r11, System.currentTimeMillis() - this.d);
    }

    public final void onLoadFail(View r7, String r8, String r9) {
        super.onLoadFail(r7, r8, r9);
        Lazy r10 = MultiLinkLoadWidgetUtils.a;
        MultiLinkLoadWidgetUtils.m(this.b.b, "MultiLinkMainHybridCardManager#obtainMainHybridComponent", "[tag:MultiLinkHybridCardReuseManager]加载逻辑主容器失败, onLoadFail, reason=" + r9);
        int r11 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.u.b;
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.u.b(((Uri) this.c.element).toString(), "main", "root", System.currentTimeMillis() - this.d, r9);
        if (this.a >= vm2.h.i().reloadCount()) goto L5;
        this.a++;
        e0 r12 = this.b;
        e0.k(r12.d, r12.e(this.e));
        return;
    L5:
        this.b.d = null;
    }

    public s0(e0 r1, Ref.ObjectRef r2, long r3, Long r5) {
        this.b = r1;
        this.c = r2;
        this.d = r3;
        this.e = r5;
    }
}
