package com.bytedance.android.live.broadcastgame.opengame.control.report;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ ReportSubmitControl a;

    public f(ReportSubmitControl r1) {
        this.a = r1;
    }

    public final void accept(Object r1) {
        Throwable r2 = (Throwable) r1;
        c r3 = this.a.b;
        if (r3 == null) goto L6;
        r3.B0();
        return;
    }
}
