package com.bytedance.android.livesdk.chatroom.ui.framework.widget.player;

import com.bytedance.android.live.broadcast.api.IBroadcastService;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a<T> implements Consumer {
    public final /* synthetic */ AnchorPlayerCompositeWidget a;

    public a(AnchorPlayerCompositeWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        Long r4 = (Long) r3;
        IBroadcastService r5 = (IBroadcastService) va1.b.a.a.a(IBroadcastService.class);
        if (r5 == null) goto L10;
        com.bytedance.android.livesdk.chatroom.ui.framework.c r0 = this.a.a;
        if (r0 == null) goto L7;
        LiveMode r1 = r0.getLiveMode();
    L8:
        r5.resetHeap(r1, this.a.getContext());
        return;
    L7:
        r1 = null;
        goto L8
    }
}
