package com.bytedance.android.live.broadcastgame.opengame.behavior;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.network.response.ExtraResponse;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class t<T> implements Consumer {
    public final /* synthetic */ MiniGameToolbarBehavior a;

    public t(MiniGameToolbarBehavior r1) {
        this.a = r1;
    }

    public final void accept(Object r11) {
        ExtraResponse r12 = (ExtraResponse) r11;
        com.bytedance.android.live.broadcastgame.opengame.network.k r0 = ((com.bytedance.android.live.broadcastgame.opengame.network.m) r12.data).entranceVision;
        Integer r1 = null;
        if (r0 == null) goto L5;
        String r4 = r0.visionIcon;
    L6:
        if (r4 != null) goto L8;
    L11:
        boolean r2 = true;
    L13:
        if (r2 == false) goto L15;
        ALogger.d("MiniGameToolbarAnim", "runConfigIconAnim success but url is empty");
        this.a.a();
        return;
    L15:
        ALogger.d("MiniGameToolbarAnim", "runConfigIconAnim success and url is " + r4);
        MiniGameToolbarBehavior r3 = this.a;
        HSImageView r5 = r3.d;
        com.bytedance.android.live.broadcastgame.opengame.network.k r6 = ((com.bytedance.android.live.broadcastgame.opengame.network.m) r12.data).entranceVision;
        if (r6 == null) goto L18;
        Boolean r7 = Boolean.valueOf(r6.isAnimationLoopPlay);
    L19:
        com.bytedance.android.live.broadcastgame.opengame.network.k r13 = ((com.bytedance.android.live.broadcastgame.opengame.network.m) r12.data).entranceVision;
        if (r13 == null) goto L22;
        r1 = Integer.valueOf(r13.animationInterval);
    L22:
        r3.b(r5, r4, true, r7, r1, MiniGameToolbarBehavior$runConfigIconAnim$1$1.INSTANCE);
        return;
    L18:
        r7 = null;
        goto L19
    L8:
        if (r4.length() == 0) goto L11;
        r2 = false;
        goto L13
    L5:
        r4 = null;
        goto L6
    }
}
