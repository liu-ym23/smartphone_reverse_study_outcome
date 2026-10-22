package com.bytedance.android.livesdk.focus;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ int a;

    public c(int r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        Long r4 = (Long) r3;
        ALogger.d("FocusWidget", "set exposure: " + this.a);
        if (((Boolean) qc1.a.a.getValue()).booleanValue() == false) goto L6;
        NewBroadcastMonitor.a r5 = NewBroadcastMonitor.c("ttlive_anchor_set_exposure", null, null, 14);
        r5.l(0);
        r5.i("status_msg", "LiveFocusWidget set exposure");
        r5.m("exposure value: " + this.a);
        r5.a().report();
        return;
    }
}
