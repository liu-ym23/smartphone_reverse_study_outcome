package com.bytedance.android.live.broadcastgame.opengame.control.out_report;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ ReportSubmitControl a;

    public c(ReportSubmitControl r1) {
        this.a = r1;
    }

    public final void accept(Object r1) {
        Throwable r2 = (Throwable) r1;
        com.bytedance.android.live.broadcastgame.opengame.control.report.c r3 = this.a.b;
        if (r3 == null) goto L6;
        r3.B0();
        return;
    }
}
