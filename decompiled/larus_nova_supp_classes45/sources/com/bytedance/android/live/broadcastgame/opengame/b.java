package com.bytedance.android.live.broadcastgame.opengame;

import android.content.DialogInterface;
import com.bytedance.android.live.broadcastgame.opengame.message.f0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b implements DialogInterface.OnClickListener {
    public final /* synthetic */ AudiencePluginManager a;
    public final /* synthetic */ f0 b;
    public final /* synthetic */ AudiencePluginManager$askSwitchGameIfNeed$1 c;

    public b(AudiencePluginManager r1, f0 r2, AudiencePluginManager$askSwitchGameIfNeed$1 r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r8, int r9) {
        int r11 = q.a;
        q.f("AudiencePluginManager", new Object[]{"audience confirmed, switch game"});
        r8.dismiss();
        com.bytedance.android.live.broadcastgame.opengame.service.e r1 = com.bytedance.android.live.broadcastgame.opengame.service.e.b;
        AudiencePluginManager.f r12 = this.a.m;
        if (r12 == null) goto L5;
        Long r2 = Long.valueOf(r12.b);
    L6:
        AudiencePluginManager.f r13 = this.a.m;
        if (r13 == null) goto L9;
        String r3 = r13.e;
    L10:
        r1.c(r2, r3, Long.valueOf(this.b.f), this.b.i, false);
        this.c.m164invoke();
        return;
    L9:
        r3 = null;
        goto L10
    L5:
        r2 = null;
        goto L6
    }
}
