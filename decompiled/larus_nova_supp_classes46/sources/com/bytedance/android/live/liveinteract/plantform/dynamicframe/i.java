package com.bytedance.android.live.liveinteract.plantform.dynamicframe;

import android.net.Uri;
import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.utils.MultiSceneEnterRoomStatisticsUtils;
import com.bytedance.android.livesdk.chatroom.utils.o3;
import com.bytedance.android.livesdk.config.MultiLinkRevenueEnterRoomOptConfig;
import com.bytedance.android.livesdk.config.sp;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class i extends b7.a {
    public ih0.c a;
    public int b;
    public long c;
    public final DataCenter d;
    public final Uri e;
    public final boolean f;
    public final Function0<Unit> g;

    public final void onRelease() {
        super.onRelease();
        ALogger.i("MultiLinkDynamicWidget", "main HybridCard onRelease, url:" + this.e);
        int r0 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.u.b;
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.u.e(this.e.toString(), "main", "root", System.currentTimeMillis() - this.c);
    }

    public final void onLoadSuccess(View r5) {
        super.onLoadSuccess(r5);
        ALogger.i("MultiLinkDynamicWidget", "main HybridCard load success");
        int r6 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.u.b;
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.u.d(this.e.toString(), "main", "root", System.currentTimeMillis() - this.c);
        if (this.f == true) goto L14;
        int r7 = MultiSceneEnterRoomStatisticsUtils.u;
        DataCenter r8 = this.d;
        com.bytedance.live.datacontext.m r0 = o3.j(r8).getRoom();
        if (r0 == null) goto L9;
        IRoom r1 = (IRoom) r0.getValue();
        if (r1 == null) goto L9;
        long r2 = r1.getRoomId();
    L10:
        MultiSceneEnterRoomStatisticsUtils r9 = MultiSceneEnterRoomStatisticsUtils.a.a(r8, Long.valueOf(r2));
        if (r9 == null) goto L15;
        r9.recordSubElementShow("lynx_container_load", System.currentTimeMillis());
        return;
    L15:
        return;
    L9:
        r2 = 0;
        goto L10
    }

    public final boolean onFallback(int r10, String r11) {
        Intrinsics.checkNotNullParameter(r11, "errorMessage");
        ALogger.e("MultiLinkDynamicWidget", "main HybridCard onFallback errorMessage=" + r11);
        int r0 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.u.b;
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.u.a("card_error", this.e.toString(), "main", "root", r10, r11, System.currentTimeMillis() - this.c);
        return super.onFallback(r10, r11);
    }

    public final void onInnerFallback(int r10, String r11) {
        Intrinsics.checkNotNullParameter(r11, "errorMessage");
        super.onInnerFallback(r10, r11);
        ALogger.e("MultiLinkDynamicWidget", "main HybridCard onInnerFallback errorMessage=" + r11);
        int r0 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.u.b;
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.u.a("card_inner_error", this.e.toString(), "main", "root", r10, r11, System.currentTimeMillis() - this.c);
    }

    public final void onContainerError(View r9, int r10, String r11) {
        Intrinsics.checkNotNullParameter(r11, "errorMessage");
        super.onContainerError(r9, r10, r11);
        ALogger.e("MultiLinkDynamicWidget", "main HybridCard onContainerError errorMessage=" + r11);
        int r12 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.u.b;
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.u.a("container_error", this.e.toString(), "main", "root", r10, r11, System.currentTimeMillis() - this.c);
    }

    public final void onLoadFail(View r7, String r8, String r9) {
        super.onLoadFail(r7, r8, r9);
        ALogger.e("MultiLinkDynamicWidget", "main HybridCard load fail reason=" + r9);
        Function0<Unit> r10 = this.g;
        if (r10 == null) goto L5;
        Unit r11 = (Unit) r10.invoke();
    L5:
        int r12 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.u.b;
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.u.b(this.e.toString(), "main", "root", System.currentTimeMillis() - this.c, r9);
        if (this.b >= ((MultiLinkRevenueEnterRoomOptConfig) sp.a.getValue()).reloadCount()) goto L11;
        this.b++;
        ih0.c r13 = this.a;
        if (r13 == null) goto L12;
        ih0.c.a.a(r13, null, null, 7);
        return;
    L12:
        return;
    }

    public i(DataCenter r2, Uri r3, boolean r4, Function0<Unit> r5) {
        Intrinsics.checkNotNullParameter(r3, "uri");
        this.d = r2;
        this.e = r3;
        this.f = r4;
        this.g = r5;
    }
}
