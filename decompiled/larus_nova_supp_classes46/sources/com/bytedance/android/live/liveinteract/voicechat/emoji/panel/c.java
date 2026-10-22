package com.bytedance.android.live.liveinteract.voicechat.emoji.panel;

import android.view.View;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryType;
import com.bytedance.android.live.effect.base.sharedpref.IEffectPluginPropertyService;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c extends g {
    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g
    public final int d() {
        return 2131251737;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g
    public final boolean l() {
        m90.a r0 = jc1.k.n(IEffectPluginPropertyService.class).getLIVE_BEAUTY_STICKER_TAB_DOT_SHOW();
        if (r0 == null) goto L7;
        Boolean r1 = (Boolean) r0.b(LiveEffectContextFactoryType.LINK);
        if (r1 == null) goto L7;
        return r1.booleanValue();
    L7:
        return false;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g
    public final String j() {
        return s1.B(2131919247);
    }

    public c(q0 r2) {
        Intrinsics.checkNotNullParameter(r2, "action");
        super(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g
    public final void k(View r5) {
        Intrinsics.checkNotNullParameter(r5, "v");
        m90.a r6 = jc1.k.n(IEffectPluginPropertyService.class).getLIVE_BEAUTY_STICKER_TAB_DOT_SHOW();
        if (r6 == null) goto L5;
        r6.a(LiveEffectContextFactoryType.LINK, Boolean.FALSE);
    L5:
        this.e.y0();
        HashMap r7 = new HashMap();
        int r0 = ((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene();
        TalkRoomLogUtils.B0(r7, Integer.valueOf(r0), null, 4);
        TalkRoomLogUtils.Q0(r7);
        TalkRoomLogUtils.I0(r7, r0);
        r7.put("click_source", "emoji_panel");
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_guest_connection_user_beauty_click", r7, new Object[]{IRoom.class, am2.x.class});
    }
}
