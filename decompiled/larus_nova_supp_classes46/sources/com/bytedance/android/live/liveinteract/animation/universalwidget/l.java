package com.bytedance.android.live.liveinteract.animation.universalwidget;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class l<T> implements Consumer {
    public final /* synthetic */ MultiLinkUniversalAnimWidget a;

    public l(MultiLinkUniversalAnimWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r5) {
        Integer r6 = (Integer) r5;
        boolean r0 = false;
        if (r6 != null) goto L6;
    L7:
        ALogger.i("MultiLinkEffect.Widget", "CleanModeChanged.cleanMode:" + r6);
        MultiLinkUniversalAnimWidget.yq(this.a, null, false, 3);
        this.a.Eq("clean_mode");
    L8:
        MultiLinkUniversalAnimWidget r1 = this.a;
        if (r6 != null) goto L12;
    L13:
        r0 = true;
    L14:
        MultiLinkUniversalAnimWidget.xq(r1, r0);
        return;
    L12:
        if (r6.intValue() == 0) goto L14;
    L6:
        if (r6.intValue() == 0) goto L8;
        goto L7
    }
}
