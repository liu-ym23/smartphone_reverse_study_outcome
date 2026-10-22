package com.bytedance.android.live.openplatform.impl.minigameanchor.cloudgame;

import android.graphics.Rect;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a<T> implements Consumer {
    public final /* synthetic */ LiveMgXplayRtcContextService a;

    public a(LiveMgXplayRtcContextService r1) {
        this.a = r1;
    }

    public final void accept(Object r1) {
        Rect r2 = (Rect) r1;
        ei6.a r3 = this.a.b;
        if (r3 == null) goto L8;
        vi6.a r4 = r3.v();
        if (r4 == null) goto L9;
        r4.f();
        return;
    L9:
        return;
    }
}
