package com.bytedance.android.live.liveinteract.animation.universalwidget;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class m<T> implements Consumer {
    public final /* synthetic */ MultiLinkUniversalAnimWidget a;

    public m(MultiLinkUniversalAnimWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r5) {
        Boolean r6 = (Boolean) r5;
        ALogger.i("MultiLinkEffect.Widget", "CloudGameCleanModeChanged.cleanMode:" + r6);
        if (r6.booleanValue() == false) goto L5;
        MultiLinkUniversalAnimWidget.yq(this.a, null, false, 3);
        this.a.Eq("game_clean_mode");
    L5:
        MultiLinkUniversalAnimWidget.xq(this.a, r6.booleanValue());
    }
}
