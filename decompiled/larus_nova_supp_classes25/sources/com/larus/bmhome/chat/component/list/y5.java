package com.larus.bmhome.chat.component.list;

import android.os.SystemClock;
import android.view.View;
import com.larus.basic.experience.downgrade.api.DowngradeSource;
import com.larus.bmhome.chat.adapter.MessageAdapter;
import com.larus.bmhome.chat.auth.PluginManagerDelegate;
import com.larus.im.bean.bot.BotModel;
import com.larus.platform.service.z2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import s1a.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class y5 implements com.larus.bmhome.chat.component.cvs.y.a<BotModel> {
    public final /* synthetic */ ChatListComponent a;

    public y5(ChatListComponent r1) {
        this.a = r1;
    }

    public final void c(Object r5) {
        final BotModel r6 = (BotModel) r5;
        Intrinsics.checkNotNullParameter(r6, "new");
        if (z2.a.multiBotsStatusUIFixConfig().isEnabled() == false) goto L13;
        ChatListComponent r0 = this.a;
        int r1 = ChatListComponent.W3;
        com.larus.bmhome.chat.component.cvs.y r2 = r0.u0();
        if (r2 == null) goto L9;
        wc9.e r3 = r2.h();
        if (r3 == null) goto L9;
        Integer r4 = r3.v;
    L11:
        if (nq9.h.a(r4, r6.getBotType()) == false) goto L13;
        this.a.C90();
    L9:
        r4 = null;
    L13:
        View r7 = a.c(this.a).getView();
        if (r7 == null) goto L16;
        final ChatListComponent r8 = this.a;
        r7.post(new x5(r8, r6));
    L16:
        com.larus.bmhome.social.userchat.model.g0 r9 = this.a.D3;
        r9.getClass();
        String r10 = r6.getBotId();
        r9.c = r10;
        r9.c(r9.d, r10);
        MessageAdapter r11 = this.a.O;
        if (r11 == null) goto L26;
        Integer r12 = r6.getBotType();
        if (r12 != null) goto L22;
    L24:
        boolean r13 = false;
    L25:
        r11.K2(r13);
        goto L26
    L22:
        if (r12.intValue() != 1) goto L24;
        r13 = true;
    L26:
        PluginManagerDelegate r14 = PluginManagerDelegate.a;
        String r15 = r6.getBotId();
        if (r15 != null) goto L29;
        r15 = "";
    L29:
        PluginManagerDelegate.r(r15, false, DowngradeSource.COLD_LAUNCH, new w5());
        com.larus.bmhome.chat.component.regen.a r16 = (com.larus.bmhome.chat.component.regen.a) this.a.a3.getValue();
        if (r16 == null) goto L32;
        r16.qb(true);
    L32:
        c r17 = this.a.U;
        if (r17 != null) goto L35;
        return;
    L35:
        if (r17.g == true) goto L40;
        r17.g = true;
        r17.h = RangesKt.coerceAtLeast(SystemClock.elapsedRealtime() - r17.i, 0);
        return;
    }
}
