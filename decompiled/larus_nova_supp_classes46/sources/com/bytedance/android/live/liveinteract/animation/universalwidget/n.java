package com.bytedance.android.live.liveinteract.animation.universalwidget;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class n<T> implements Consumer {
    public final /* synthetic */ MultiLinkUniversalAnimWidget a;

    public n(MultiLinkUniversalAnimWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        Integer r4 = (Integer) r3;
        ALogger.i("MultiLinkEffect.Widget", "TeamFightChanged.mode:" + r4);
        if (r4 != null) goto L6;
    L8:
        if (r4 != null) goto L11;
        return;
    L11:
        if (r4.intValue() != 1) goto L14;
        MultiLinkUniversalAnimWidget r5 = this.a;
        int r0 = MultiLinkUniversalAnimWidget.x;
        r5.Cq();
        return;
    L14:
        return;
    L6:
        if (r4.intValue() != 4) goto L8;
        MultiLinkUniversalAnimWidget r1 = this.a;
        int r2 = MultiLinkUniversalAnimWidget.x;
        r1.Cq();
        goto L8
    }
}
