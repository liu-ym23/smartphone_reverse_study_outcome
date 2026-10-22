package com.bytedance.android.live.liveinteract.plantform.commonwindow;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e implements Runnable {
    public final /* synthetic */ CommonDynamicIslandLayoutManager a;

    public e(CommonDynamicIslandLayoutManager r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ALogger.i(this.a.a, "3d兼容-第一次布局Natvie更新完毕，打断3d礼物播放");     // Catch: Throwable -> L6
        nh0.f r0 = new nh0.f("dynamicIslandLayoutCompleted", null, null, null, null, null, false, 224);     // Catch: Throwable -> L6
        DataCenter r1 = this.a.m;     // Catch: Throwable -> L6
        if (r1 == null) goto L9;
        r1.put("data_multi_lick_dynamic_event_change", r0);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
