package com.bytedance.android.live.broadcastgame.opengame.service;

import android.view.View;
import com.bytedance.android.live.broadcastgame.api.AudienceGameContext;
import com.bytedance.live.datacontext.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ AudienceMiniGameIntroCardService a;

    public a(AudienceMiniGameIntroCardService r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r9) {
        AudienceGameContext.Companion.getClass();
        AudienceGameContext r11 = AudienceGameContext.a.a();
        if (r11 == null) goto L7;
        n<com.bytedance.android.live.broadcastgame.api.openplatform.a> r12 = r11.getGameIntroCardInfo();
        if (r12 == null) goto L7;
        com.bytedance.android.live.broadcastgame.api.openplatform.a r13 = (com.bytedance.android.live.broadcastgame.api.openplatform.a) r12.getValue();
    L8:
        com.bytedance.android.live.broadcastgame.api.openplatform.a r0 = r13;
        if (r0 == null) goto L11;
        int r1 = r0.k;
    L12:
        int r4 = r1 + 1;
        if (r0 == null) goto L19;
        AudienceGameContext r2 = AudienceGameContext.a.a();
        if (r2 == null) goto L19;
        n<com.bytedance.android.live.broadcastgame.api.openplatform.a> r7 = r2.getGameIntroCardInfo();
        if (r7 == null) goto L19;
        r7.setValue(com.bytedance.android.live.broadcastgame.api.openplatform.a.a(r0, null, null, null, r4, 3071));
    L19:
        AudienceMiniGameIntroCardService.a(this.a, true, false, 2);
        return;
    L11:
        r1 = 0;
    L7:
        r13 = null;
        goto L8
    }
}
