package com.bytedance.android.live.room.api.record;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ LiveRecordMonitorServiceWidget a;

    public d(LiveRecordMonitorServiceWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        String r0 = this.a.a;
        ALogger.e(r0, "publish error", (Throwable) r3);
    }
}
