package com.larus.bmhome.chat.layout.holder.menu.item;

import com.larus.audio.AudioServiceDelegate;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.platform.api.IFlowThemeConfigProvider;
import com.larus.platform.api.ThemeColorKey;
import com.larus.platform.api.ThemeConfigScene;
import com.larus.platform.model.apptheme.AdaptThemeFeatureKey;
import com.larus.platform.service.z2;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class d1 {
    public static com.larus.bmhome.view.screenmenu.l0 a(Message r1, com.larus.bmhome.chat.api.q0.a r2) {
        Intrinsics.checkNotNullParameter(r1, "data");
        if (r2 == null) goto L7;
        com.larus.bmhome.chat.component.cvs.y r3 = r2.u0();
        if (r3 == null) goto L7;
        BotModel r4 = r3.j0();
    L9:
        return b(r1, ve8.c.c(r4));
    L7:
        r4 = null;
        goto L9
    }

    public static com.larus.bmhome.view.screenmenu.l0 b(Message r44, boolean r45) {
        if (z2.a.m3() == true) goto L5;
        return null;
    L5:
        boolean r18 = AudioServiceDelegate.a.P().isRecording();
        if (com.larus.bmhome.chat.bean.d.G0(r44) == false) goto L8;
    L16:
        boolean r0 = false;
    L17:
        if (r0 == false) goto L19;
    L22:
        if (r45 == false) goto L34;
        boolean r12 = com.larus.bmhome.chat.model.a0.b(r44);
        if (r12 == false) goto L26;
        int r1 = 2130971897;
        int r2 = 2131242317;
    L27:
        int r3 = v19.c.b(r1, null, r2);
        IFlowThemeConfigProvider r5 = (IFlowThemeConfigProvider) ServiceManager.get().getService(IFlowThemeConfigProvider.class);
        if (r5 == null) goto L30;
        Integer r19 = r5.f(null, ThemeColorKey.MESSAGE_ANSWER_ACTION_COLOR, ThemeConfigScene.CHAT, AdaptThemeFeatureKey.MESSAGE_LONG_PRESS_TTS_BUTTON, null);
    L32:
        return new com.larus.bmhome.view.screenmenu.l0(2131907410, 2131907410, null, null, null, Integer.valueOf(v19.c.b(2130972079, null, 2131103136)), null, null, null, r12, false, null, Integer.valueOf(r3), null, false, r18, r19, null, "play", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -725540, 127);
    L30:
        r19 = null;
        goto L32
    L26:
        r1 = 2130971774;
        r2 = 2131241599;
        goto L27
    L34:
        return null;
    L19:
        if (com.larus.bmhome.chat.bean.d.z0(r44) == true) goto L22;
        if (m99.a.f(r44) == true) goto L22;
        return null;
    L8:
        if (com.larus.bmhome.chat.bean.d.k(r44) == false) goto L10;
    L15:
        r0 = true;
        goto L17
    L10:
        if (com.larus.bmhome.chat.bean.d.N(r44) == true) goto L15;
        if (com.larus.bmhome.chat.bean.d.x0(r44) == true) goto L15;
        if (dp8.a.b(r44) == false) goto L16;
        goto L15
    }
}
