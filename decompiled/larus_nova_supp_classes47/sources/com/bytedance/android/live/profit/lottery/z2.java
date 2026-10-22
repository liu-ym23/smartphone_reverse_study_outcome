package com.bytedance.android.live.profit.lottery;

import android.view.View;
import com.bytedance.android.live.saas.middleware.store.FileUtils;
import com.bytedance.android.livesdk.config.yo0;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdk.revenue.toolbar.RevToolbarButton;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class z2 extends zr2.k implements com.bytedance.android.scope.o {
    public final LotteryContext b;
    public final com.bytedance.android.livesdk.revenue.service.toolbar.e c;
    public final yz0.k d;

    public final void R9(View r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
    }

    public final void p4(View r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
    }

    public final void onStart() {
        this.c.tg(this.d.getDataCenter()).e(RevToolbarButton.Lottery, this);
    }

    public final void onStop() {
        this.c.tg(this.d.getDataCenter()).c(RevToolbarButton.Lottery, this);
    }

    public final boolean showRedDot() {
        if (((Boolean) yo0.a.getValue()).booleanValue() == false) goto L6;
        return false;
    L6:
        if (w2.e().enabled == 1) goto L8;
        return false;
    L8:
        if (w2.e().redDotEnabled == 1) goto L10;
        return false;
    L10:
        if (((Boolean) g1.b.getValue(null, g1.a[0])).booleanValue() == true) goto L15;
        return true;
    L15:
        return false;
    }

    public final void onClick(View r7) {
        Intrinsics.checkNotNullParameter(r7, "view");
        g1.b.setValue(null, g1.a[0], Boolean.TRUE);
        this.c.tg(this.d.getDataCenter()).a(RevToolbarButton.InteractGame, zr2.g.a);
        mz0.n r8 = new mz0.n();
        Map<String, String> r0 = r8.a;
        Intrinsics.checkNotNullParameter(r0, "map");
        String r2 = this.d.getLiveMode().getSceneName();
        if (r2 == null) goto L16;
        int r3 = r2.hashCode();
        if (r3 == 93166550) goto L14;
        if (r3 != 112202875) goto L16;
        if (r2.equals(FileUtils.VIDEO) == false) goto L16;
        String r4 = "video_live";
    L17:
        Intrinsics.checkNotNullParameter("live_type", "key");
        Intrinsics.checkNotNullParameter(r4, "value");
        r0.put("live_type", r4);
        String r5 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class).getFunctionTypeForLog();
        Intrinsics.checkNotNullParameter("function_type2", "key");
        Intrinsics.checkNotNullParameter(r5, "value");
        r0.put("function_type2", r5);
        Map<String, String> r1 = r8.a;
        Intrinsics.checkNotNullParameter(r1, "map");
        Map<? extends String, ? extends String> r6 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.broadcast.a.class).getOpenPlatformGameCommonLogMap();
        if (r6 == null) goto L20;
        Intrinsics.checkNotNullParameter(r6, "map");
        r1.putAll(r6);
    L20:
        mz0.m r9 = new mz0.m();
        r9.b(LogCommon.ROOM);
        com.bytedance.android.livesdk.revenue.log.i r10 = vh6.c.b(kr2.a.class).ud();
        Intrinsics.checkNotNullParameter(r10, "pageSourceLog");
        Intrinsics.checkNotNullParameter("live_take_detail", "page");
        r10.c("live_take_detail");
        List<Object> r12 = r9.a;
        ArrayList r13 = (ArrayList) r12;
        r13.add(r10.a);
        List<Object> r14 = r8.b;
        ArrayList r15 = (ArrayList) r14;
        r15.addAll(r9.a);
        cy0.e.a.getClass();
        cy0.j r16 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r17 = com.bytedance.android.scope.m.b(r16).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r17);
        ((mz0.i) ((f80.a) r17)).w3("livesdk_anchor_lottery_click", r8.a, r8.b);
        this.b.getOnToolbarButtonClick().post(Unit.INSTANCE);
        return;
    L14:
        if (r2.equals("audio") == false) goto L16;
        r4 = "voice_live";
    L16:
        r4 = "";
        goto L17
    }

    public z2(LotteryContext r2, com.bytedance.android.livesdk.revenue.service.toolbar.e r3, yz0.k r4) {
        Intrinsics.checkNotNullParameter(r2, "lotteryContext");
        Intrinsics.checkNotNullParameter(r3, "toolbarManagerProvider");
        Intrinsics.checkNotNullParameter(r4, "roomDataService");
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
