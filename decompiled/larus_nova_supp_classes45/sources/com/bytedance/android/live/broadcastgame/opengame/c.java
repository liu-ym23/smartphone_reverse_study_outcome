package com.bytedance.android.live.broadcastgame.opengame;

import android.content.DialogInterface;
import com.bytedance.android.live.broadcastgame.opengame.message.f0;
import kotlin.reflect.KProperty1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c implements DialogInterface.OnClickListener {
    public final /* synthetic */ AudiencePluginManager a;
    public final /* synthetic */ f0 b;

    public c(AudiencePluginManager r1, f0 r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r7, int r8) {
        r7.dismiss();
        KProperty1 r9 = AudiencePluginManager$askSwitchGameIfNeed$3$1.INSTANCE;
        com.bytedance.android.live.broadcastgame.opengame.service.e r0 = com.bytedance.android.live.broadcastgame.opengame.service.e.b;
        AudiencePluginManager.f r11 = this.a.m;
        if (r11 == null) goto L5;
        Long r1 = Long.valueOf(r11.b);
    L6:
        AudiencePluginManager.f r12 = this.a.m;
        if (r12 == null) goto L9;
        String r2 = r12.e;
    L10:
        r0.c(r1, r2, Long.valueOf(this.b.f), this.b.i, true);
        return;
    L9:
        r2 = null;
        goto L10
    L5:
        r1 = null;
        goto L6
    }
}
