package com.bytedance.android.live.broadcastgame.xplay;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import io.reactivex.functions.Consumer;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class y0<T> implements Consumer {
    public final /* synthetic */ XplayPanelService a;

    public y0(XplayPanelService r1) {
        this.a = r1;
    }

    public final void accept(Object r6) {
        IBaseUser r7 = (IBaseUser) r6;
        Map<String, String> r8 = this.a.p.a;
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_live_game_anchor_function_icon_click", r8, new Object[]{Room.class});
        this.a.j(null);
        Map<String, String> r9 = this.a.p.a;
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_live_game_anchor_function_page_show", r9, new Object[]{Room.class});
    }
}
