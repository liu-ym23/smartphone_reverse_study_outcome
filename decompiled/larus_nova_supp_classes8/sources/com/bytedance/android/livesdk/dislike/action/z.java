package com.bytedance.android.livesdk.dislike.action;

import android.content.Context;
import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.platformplayer.LivePlatformPlayerManager;
import com.bytedance.android.live.room.api.ILiveShareService;
import com.bytedance.android.live.room.api.share.model.LiveShareType;
import com.bytedance.android.livehostapi.business.depend.share.ShareParams;
import com.bytedance.android.livesdk.dislike.ActionsManager;
import com.bytedance.android.livesdkapi.depend.model.live.LiveRoomMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class z extends OptionAction {
    public final ActionsManager e;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.dislike.action.OptionAction
    public final cz.c f() {
        return cz.c.m.c;
    }

    public z(ActionsManager r2) {
        Intrinsics.checkNotNullParameter(r2, "actionManager");
        super(r2);
        this.e = r2;
    }

    @Override // com.bytedance.android.livesdk.dislike.action.OptionAction
    public final void a(View r31) {
        Intrinsics.checkNotNullParameter(r31, "v");
        if (LivePlatformPlayerManager.f() != null) goto L5;
        ALogger.e("ShareLiveToDailyAction", "LivePlatformPlayerManager currentClient is null");
    L16:
        Context r1 = r31.getContext();
        com.bytedance.android.livesdk.log.g r2 = com.bytedance.android.livesdk.log.u.l();
        LinkedHashMap r5 = new LinkedHashMap();
        r5.put("share_to_story_type", "live_room");
        r5.put("enter_method", "live_room_inner_long_press");
        r5.put("enter_from", this.e.e);
        Unit r4 = Unit.INSTANCE;
        jc1.k.n(ILiveShareService.class).cacheMob(r1, r5);
        r2.h("click_share_to_diary", r5, new Object[0]);
        return;
    L5:
        Room r3 = this.e.d;
        if (r3 == null) goto L16;
        Map r6 = com.bytedance.android.livesdk.log.u.l().c(am2.x.class).getMap();
        ILiveShareService r7 = jc1.k.n(ILiveShareService.class);
        ShareParams.Builder r8 = ShareParams.buildUponRoom(r3).setPlatform("share_to_story").setLivePlayerClient(LivePlatformPlayerManager.f()).setShareEnterFrom((String) r6.get("enter_from_merge")).setEnterMethod((String) r6.get("enter_method")).setShareEnterMethod("inner_long_press");
        if (jc1.k.n(IInteractService.class).getCurrentScene() > 0) goto L14;
        Room r9 = this.e.d;
        if (r9 != null) goto L13;
    L15:
        Unit r10 = Unit.INSTANCE;
        ShareParams r12 = r8.build();
        r7.share(new i81.a(null, ContextUtil.contextToActivity(r31.getContext()), null, r12, null, null, null, null, null, null, null, Boolean.FALSE, null, null, null, null, false), "ShareLiveToDailyAction", LiveShareType.SHARE_DIRECT, new a0());
        goto L16
    L13:
        if (r9.getLiveRoomMode() != LiveRoomMode.Audio.getValue()) goto L15;
    L14:
        r8.setEnableScreenShot(false);
        goto L15
    }
}
