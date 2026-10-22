package com.bytedance.android.live.broadcastgame.openplatform.behavior;

import android.view.View;
import com.bytedance.android.live.broadcast.api.IBroadcastService;
import io.reactivex.functions.Consumer;
import nz.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ View a;

    public e(View r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        Long r5 = (Long) r4;
        IBroadcastService r6 = (IBroadcastService) va1.b.a.a.a(IBroadcastService.class);
        if (r6 == null) goto L8;
        h r7 = r6.getBroadcastBubbleManager();
        if (r7 == null) goto L9;
        r7.b(this.a.getContext(), this.a, String.valueOf(6));
        return;
    L9:
        return;
    }
}
