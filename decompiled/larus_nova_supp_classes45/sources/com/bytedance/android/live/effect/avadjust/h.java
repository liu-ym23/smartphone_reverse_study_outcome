package com.bytedance.android.live.effect.avadjust;

import android.content.Context;
import android.view.View;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.effect.utils.LivePresetsLogger;
import com.bytedance.android.livesdk.chatroom.ui.c9;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class h implements View.OnClickListener {
    public final /* synthetic */ LiveColorAdjustFragment a;

    public h(LiveColorAdjustFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        LiveColorAdjustFragment r5 = this.a;
        int r0 = LiveColorAdjustFragment.r;
        Context r1 = r5.getContext();
        c9.b r2 = new c9.b();
        r2.a = r1;
        r2.b = 2;
        r2.p = false;
        String r3 = s1.B(2131916374);
        i r6 = new i(r5);
        r2.l = r3;
        r2.m = r6;
        String r7 = s1.B(2131916411);
        j r8 = j.a;
        r2.j = r7;
        r2.k = r8;
        r2.f = s1.B(2131916375);
        r2.e = s1.B(2131916376);
        c9 r9 = new c9(r2.a, r2);
        if (DialogLancet.shouldBlockDialogShow(r9) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(r9);
    L7:
        Long r11 = LivePresetsLogger.a;
        LivePresetsLogger.b("adjust", LivePresetsLogger.BtnType.RESET);
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L6:
        DialogLancet.beforeDialogShow(r9);
        r9.show();
        DialogLancet.afterDialogShow(r9);
        goto L7
    }
}
