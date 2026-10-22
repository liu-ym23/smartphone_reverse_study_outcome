package com.bytedance.android.live.room.discovery;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;
import zg1.b1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class q<T> implements Consumer {
    public final /* synthetic */ AnchorPerfMonitorWidget a;

    public q(AnchorPerfMonitorWidget r1) {
        this.a = r1;
    }

    public final void accept(b1 r3) {
        StringBuilder r0 = new StringBuilder("LiveAnchorAccessibilityOnEvent.get:");
        if (r3 == null) goto L5;
        Boolean r1 = Boolean.FALSE;
    L6:
        r0.append(r1);
        ALogger.d("AnchorVolumnOptiTAG", r0.toString());
        if (r3 == null) goto L9;
        this.a.N = false;
    L10:
        AnchorPerfMonitorWidget.xq(this.a);
        return;
    L9:
        AnchorPerfMonitorWidget r4 = this.a;
        r4.N = true;
        r4.L = false;
        goto L10
    L5:
        r1 = null;
        goto L6
    }

    public final /* bridge */ /* synthetic */ void accept(Object r1) {
        accept((b1) r1);
    }
}
