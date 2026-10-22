package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.broadcast.api.IBroadcastService;
import com.bytedance.android.live.broadcastgame.api.model.ReloadPanelType;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.config.ft0;
import com.bytedance.android.livesdk.config.k81;
import com.bytedance.android.livesdk.widget.BroadcastKtvEffectMusicWidget;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class md implements zg1.q {
    public final /* synthetic */ nd a;
    public final /* synthetic */ Effect b;

    public md(nd r1, Effect r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onResult(boolean r14, String r15) {
        Intrinsics.checkNotNullParameter(r15, "failMsg");
        if (r14 == false) goto L18;
        id r16 = this.a.a;
        int r17 = id.a;
        r16.finishWithSuccess();
        if (((k81) ft0.a.getValue()).b() == true) goto L7;
        return;
    L7:
        if (Intrinsics.areEqual(this.a.b, com.bytedance.android.live.effect.api.d0.d) == false) goto L38;
        nd r18 = this.a;
        id r19 = r18.a;
        long r4 = r18.e;
        boolean r110 = r18.c;
        Effect r12 = this.b;
        r19.getClass();
        RoomContext r111 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r111 == null) goto L13;
        com.bytedance.live.datacontext.n r112 = r111.getDownLoadingInteractEffectId();
        if (r112 == null) goto L13;
        r112.setValue(null);
    L13:
        xs2.b.a().post(new com.bytedance.android.live.broadcastgame.api.model.f0(String.valueOf(r4), ReloadPanelType.FROM_CAHCE, r110, false, 8));
        if (r110 == false) goto L16;
        dp1.d.a(r12.getEffectId());
        return;
    L16:
        xs2.b.a().post(new BroadcastKtvEffectMusicWidget.a(String.valueOf(r4)));
        return;
    L38:
        return;
    L18:
        if (((k81) ft0.a.getValue()).b() == true) goto L20;
    L35:
        id r113 = this.a.a;
        int r114 = id.a;
        r113.finishWithFailure();
        return;
    L20:
        if (Intrinsics.areEqual(this.a.b, com.bytedance.android.live.effect.api.d0.d) == false) goto L35;
        IBroadcastService r115 = (IBroadcastService) jc1.k.f(IBroadcastService.class);
        if (r115 == null) goto L24;
        r115.removeInteractToolsMobInfo(String.valueOf(this.a.e));
    L24:
        RoomContext r116 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r116 == null) goto L30;
        com.bytedance.live.datacontext.n r117 = r116.getDownLoadingInteractEffectId();
        if (r117 == null) goto L30;
        r117.setValue(null);
    L30:
        if (r15.length() <= 0) goto L32;
        boolean r118 = true;
    L33:
        if (r118 == false) goto L35;
        com.bytedance.android.live.core.utils.f2.c(r15, 0);
        goto L35
    L32:
        r118 = false;
        goto L33
    }
}
