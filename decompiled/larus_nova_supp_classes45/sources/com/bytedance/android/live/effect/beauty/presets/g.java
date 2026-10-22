package com.bytedance.android.live.effect.beauty.presets;

import android.content.Context;
import android.view.View;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.effect.api.d0;
import com.bytedance.android.live.effect.utils.LivePresetsLogger;
import com.bytedance.android.livesdk.chatroom.ui.c9;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class g implements View.OnClickListener {
    public final /* synthetic */ LiveBeautyPresetsFragment a;

    public g(LiveBeautyPresetsFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        LiveBeautyPresetsFragment r5 = this.a;
        BeautifyPreset r0 = r5.p;
        if (r0 == null) goto L13;
        Map<Long, String> r6 = r5.T90().h(r0);
        if ((!r6.isEmpty()) == false) goto L13;
        if (r6.values().contains("livedigitavatar") == false) goto L10;
        f2.b(2131916360, 0);
        return;
    L10:
        if (r6.values().contains(d0.c) == false) goto L24;
        f2.b(2131916432, 0);
        return;
    L24:
        return;
    L13:
        LiveBeautyPresetsFragment r7 = this.a;
        Context r1 = r7.getContext();
        c9.b r2 = new c9.b();
        r2.a = r1;
        r2.b = 2;
        r2.p = false;
        String r3 = s1.B(2131916374);
        k r8 = new k(r7);
        r2.l = r3;
        r2.m = r8;
        String r9 = s1.B(2131916411);
        l r11 = new l(r7);
        r2.j = r9;
        r2.k = r11;
        r2.f = s1.B(2131916375);
        r2.e = s1.B(2131916376);
        c9 r12 = new c9(r2.a, r2);
        if (DialogLancet.shouldBlockDialogShow(r12) == false) goto L21;
        DialogLancet.handleBlockedDialogShow(r12);
    L18:
        Long r13 = LivePresetsLogger.a;
        LivePresetsLogger.b("presets", LivePresetsLogger.BtnType.RESET);
        return;
    L21:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L20
    L17:
        DialogLancet.beforeDialogShow(r12);
        r12.show();
        DialogLancet.afterDialogShow(r12);
        goto L18
    }
}
