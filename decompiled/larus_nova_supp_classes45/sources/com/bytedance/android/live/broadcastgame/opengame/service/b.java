package com.bytedance.android.live.broadcastgame.opengame.service;

import am2.x;
import android.view.View;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import java.util.LinkedHashMap;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b implements View.OnClickListener {
    public final /* synthetic */ AudienceMiniGameIntroCardService a;
    public final /* synthetic */ com.bytedance.android.live.broadcastgame.api.openplatform.a b;

    public b(AudienceMiniGameIntroCardService r1, com.bytedance.android.live.broadcastgame.api.openplatform.a r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r7) {
        xs2.b.a().post(new com.bytedance.android.live.broadcastgame.api.openplatform.f("from_mini_card"));
        AudienceMiniGameIntroCardService.a(this.a, false, false, 3);
        TrackMiniGameCardService r8 = (TrackMiniGameCardService) this.a.f.o(TrackMiniGameCardService.class);
        com.bytedance.android.live.broadcastgame.api.openplatform.a r1 = this.b;
        if (r1 == null) goto L5;
        String r2 = r1.c;
    L7:
        if (r2 != null) goto L9;
    L12:
        boolean r3 = true;
    L13:
        com.bytedance.android.livesdk.log.g r4 = u.l();
        LinkedHashMap r5 = new LinkedHashMap();
        r5.putAll(r8.b());
        r8.a(r5);
        if (r3 == false) goto L16;
        String r9 = "type1";
    L17:
        r5.put("ad_show_type", r9);
        Unit r11 = Unit.INSTANCE;
        r4.sendLog("livesdk_audience_ad_click", r5, new Object[]{Room.class, x.class});
        return;
    L16:
        r9 = "type2";
        goto L17
    L9:
        if (r2.length() == 0) goto L12;
        r3 = false;
        goto L13
    L5:
        r2 = null;
        goto L7
    }
}
