package com.bytedance.android.live.broadcastgame.common.utils;

import android.content.DialogInterface;
import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameMonitorService;
import com.bytedance.android.live.broadcastgame.api.interactgame.n;
import com.bytedance.android.live.broadcastgame.api.model.r;
import com.bytedance.android.live.broadcastgame.api.model.u;
import jc1.k;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a implements DialogInterface.OnClickListener {
    public final /* synthetic */ Function0 a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ u d;

    public a(Function0 r1, String r2, String r3, u r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r7, int r8) {
        r7.dismiss();
        this.a.invoke();
        int r9 = n.a;
        String r11 = this.b;
        String r12 = this.c;
        u r0 = this.d;
        String r1 = r0.name;
        r r2 = r0.c();
        if (r2 == null) goto L6;
        String r3 = String.valueOf(r2.p());
        if (r3 == null) goto L6;
    L7:
        n.b(r11, r12, r1, r3, "cancel");
        ((IInteractGameMonitorService) k.n(IInteractGameMonitorService.class)).logInteractGamePreCheck(1, this.d, IInteractGameMonitorService.FAILURE_CODE_SWITCH_GAME_CHECK, this.c, this.b);
        return;
    L6:
        r3 = "";
        goto L7
    }
}
