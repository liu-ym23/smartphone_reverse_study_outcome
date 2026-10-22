package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.utils;

import am2.x;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.platformplayer.LivePlatformPlayerManager;
import com.bytedance.android.live.room.api.share.model.LiveShareType;
import com.bytedance.android.livehostapi.business.depend.share.ShareParams;
import com.bytedance.android.livesdk.config.lt0;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.live.LiveRoomMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class p {
    static {
    }

    @JvmStatic
    public static final void a(ShareParams.Builder r6, LiveShareType r7, Room r8, DataCenter r9) {
        Intrinsics.checkNotNullParameter(r6, "builder");
        Intrinsics.checkNotNullParameter(r7, "shareType");
        Map r0 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.helper.b.a(r8);
        if (LivePlatformPlayerManager.f() == null) goto L19;
        int r1 = com.bytedance.android.livesdk.config.setting.p.a;
        Integer r2 = lt0.a.getValue();
        if (r2 != null) goto L8;
    L9:
        boolean r3 = true;
    L11:
        if (r3 == false) goto L19;
        if (Intrinsics.areEqual("1", (String) r0.get("ShareStory")) == false) goto L19;
        r6.setLivePlayerClient(LivePlatformPlayerManager.f());
        if (r7 != LiveShareType.SHARE_DIRECT) goto L17;
        r6.setShareEnterMethod("more");
        goto L19
    L17:
        r6.setShareEnterMethod("click_share_button");
        goto L19
    L8:
        if (r2.intValue() != 0) goto L9;
        r3 = false;
    L19:
        if (com.bytedance.android.livesdk.config.setting.p.a() == false) goto L29;
        if (Intrinsics.areEqual("1", (String) r0.get("ShareStory")) == false) goto L29;
        if (r9 == null) goto L29;
        if (z.m(r9, true) != true) goto L29;
        if (hd0.c.f().h() == true) goto L29;
        r6.setNeedShareToDiary(true);
    L29:
        if (jc1.k.n(IInteractService.class).getCurrentScene() > 0) goto L33;
        if (r8 != null) goto L32;
    L34:
        r6.setEnterMethod(String.valueOf(u.l().c(x.class).getMap().get("enter_method")));
        r6.setShareEnterFrom(String.valueOf(u.l().c(x.class).getMap().get("enter_from_merge")));
        r6.setActionType(String.valueOf(u.l().c(x.class).getMap().get("action_type")));
        return;
    L32:
        if (r8.getLiveRoomMode() != LiveRoomMode.Audio.getValue()) goto L34;
    L33:
        r6.setEnableScreenShot(false);
        goto L34
    }
}
