package com.bytedance.android.live.liveinteract.plantform.commonwindow.wm;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.revenuebase.MultiRevenueDataContext;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class i implements Runnable {
    public final /* synthetic */ BaseMultiLinkWindowManager a;
    public final /* synthetic */ tf0.j b;
    public final /* synthetic */ String c;

    public i(BaseMultiLinkWindowManager r1, tf0.j r2) {
        this.a = r1;
        this.b = r2;
        this.c = "";
    }

    public final void a() {
        BaseMultiLinkWindowManager r0 = this.a;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r1 = r0.d;
        if (r1 == null) goto L5;
        r1.U3((com.bytedance.android.live.liveinteract.plantform.commonwindow.m) this.b, r0.d0(), this.a.c0());
    L5:
        ALogger.e("BaseMultiLinkWindowManager", "updateLinkWindowLayoutConfig for stageLocation, from=" + this.c);
        if (Intrinsics.areEqual(this.c, "stageLocationChange") == false) goto L15;
        MultiRevenueDataContext.Companion.getClass();
        com.bytedance.android.live.liveinteract.revenuebase.d r2 = MultiRevenueDataContext.a.f();
        if (r2 == null) goto L15;
        if (r2.s5() != true) goto L15;
        boolean r3 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.a;
        if (com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.a(Integer.valueOf(this.b.getUiLayout()), 2) == true) goto L15;
        DataCenter r4 = this.a.C;
        this.a.getClass();
        r4.put("data_multi_lick_dynamic_event_change", new nh0.f("seat", null, null, null, null, null, false, 246));
    L15:
        if ((!Intrinsics.areEqual(this.c, "stageLocationChange")) == false) goto L18;
        this.a.C.put("cmd_audio_chat_stage_position_update", Boolean.TRUE);
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
