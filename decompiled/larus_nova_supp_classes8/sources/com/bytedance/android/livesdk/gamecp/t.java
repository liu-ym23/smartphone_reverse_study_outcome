package com.bytedance.android.livesdk.gamecp;

import android.view.Window;
import com.bytedance.android.live.base.BaseServices;
import com.bytedance.android.livehostapi.platform.IHostMonitor;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class t implements bw.k {
    public t() {
    }

    public final void B1() {
    }

    public final void K1() {
    }

    public final void S() {
    }

    public final void T1(String r1) {
    }

    public final void clear() {
    }

    public final void h2() {
    }

    public final void l1(String r1) {
    }

    public final void n2(Window r1) {
    }

    public final void C0(String r3, JSONObject r4) {
        IHostMonitor r0 = (IHostMonitor) BaseServices.as(IHostMonitor.class);
        if (r0 == null) goto L6;
        r0.monitorStatusRate(r3, 1, r4);
        return;
    }

    public final void monitorEvent(String r2, JSONObject r3, JSONObject r4, JSONObject r5) {
        IHostMonitor r0 = (IHostMonitor) BaseServices.as(IHostMonitor.class);
        if (r0 == null) goto L6;
        r0.monitorEvent(r2, r3, r4, r5);
        return;
    }
}
