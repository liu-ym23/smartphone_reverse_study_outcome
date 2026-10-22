package com.bytedance.android.live.liveinteract.floatwindow.applywindow;

import com.bytedance.android.livehostapi.foundation.depend.IHostAppMonitorListener;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class d extends IHostAppMonitorListener.Stub {
    public boolean a;

    public d() {
    }

    public final void appEnterBackground(boolean r1, boolean r2) {
        super.appEnterBackground(r1, r2);
        this.a = r1;
    }
}
