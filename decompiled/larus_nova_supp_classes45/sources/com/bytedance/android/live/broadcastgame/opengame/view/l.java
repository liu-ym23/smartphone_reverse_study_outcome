package com.bytedance.android.live.broadcastgame.opengame.view;

import android.content.DialogInterface;
import com.bytedance.android.live.broadcastgame.api.AnchorGameContext;
import com.bytedance.android.live.broadcastgame.api.InteractGameContext;
import com.bytedance.android.live.broadcastgame.xplay.q1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class l implements DialogInterface.OnDismissListener {
    public final /* synthetic */ i a;
    public final /* synthetic */ e b;

    public l(i r1, com.bytedance.android.live.broadcastgame.opengame.s.b.a r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r4) {
        i r5 = this.a;
        com.bytedance.android.live.broadcastgame.api.model.r r0 = r5.g.c();
        if (r0 == null) goto L5;
        String r1 = r0.b();
    L7:
        if (r1 != null) goto L9;
    L11:
        boolean r2 = false;
    L12:
        if (r2 == false) goto L15;
    L31:
        e r6 = this.b;
        if (r6 == null) goto L35;
        r6.onDismiss();
        return;
    L35:
        return;
    L15:
        if (r5.c == false) goto L17;
        AnchorGameContext.Companion.getClass();
        AnchorGameContext r3 = AnchorGameContext.a.a();
        if (r3 == null) goto L30;
        com.bytedance.live.datacontext.k<Integer> r7 = r3.getInitGameTestFloatBall();
        if (r7 == null) goto L30;
        r7.post(1);
    L30:
        r5.a.dispose();
        goto L31
    L17:
        if (q1.g(r5.g.c()) == false) goto L19;
        com.bytedance.android.live.broadcastgame.api.xplay.n.b.e("dismiss");
    L20:
        com.bytedance.android.livesdk.log.b0.o().getClass();
        com.bytedance.android.live.core.log.g.a("InteractivePlayStartIntroLynxDialog", "用户手动dismiss dialog");
        AnchorGameContext.Companion.getClass();
        AnchorGameContext r8 = AnchorGameContext.a.a();
        if (r8 == null) goto L30;
        com.bytedance.live.datacontext.k<Boolean> r9 = r8.getOpenGameTestFloatBall();
        if (r9 == null) goto L30;
        r9.post(Boolean.FALSE);
        goto L30
    L19:
        r5.h.b("dismiss");
        goto L20
    L9:
        if (InteractGameContext.Companion.h(r1) == false) goto L11;
        r2 = true;
        goto L12
    L5:
        r1 = null;
        goto L7
    }
}
