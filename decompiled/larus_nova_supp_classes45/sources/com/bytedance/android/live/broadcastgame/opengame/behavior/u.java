package com.bytedance.android.live.broadcastgame.opengame.behavior;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class u<T> implements Consumer {
    public final /* synthetic */ MiniGameToolbarBehavior a;

    public u(MiniGameToolbarBehavior r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        Throwable r4 = (Throwable) r3;
        StringBuilder r0 = new StringBuilder("runConfigIconAnim fail error:");
        r0.append(r4.getMessage());
        r0.append(' ');
        Throwable r5 = r4.getCause();
        if (r5 == null) goto L5;
        String r6 = r5.getMessage();
    L6:
        r0.append(r6);
        ALogger.d("MiniGameToolbarAnim", r0.toString());
        this.a.a();
        return;
    L5:
        r6 = null;
        goto L6
    }
}
