package com.bytedance.android.live.liveinteract.animation.universalwidget;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class k<T> implements Consumer {
    public final /* synthetic */ MultiLinkUniversalAnimWidget a;

    public k(MultiLinkUniversalAnimWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        ALogger.i("MultiLinkEffect.Widget", "CPositionModeChanged.mode:" + ((Boolean) r3));
        MultiLinkUniversalAnimWidget r4 = this.a;
        int r0 = MultiLinkUniversalAnimWidget.x;
        r4.Cq();
    }
}
