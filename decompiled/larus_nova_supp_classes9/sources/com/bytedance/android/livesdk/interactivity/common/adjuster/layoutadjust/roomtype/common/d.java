package com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.roomtype.common;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.platformplayer.LivePlatformPlayerManager;
import com.bytedance.android.livesdk.chatroom.InteractionWidgetsPosContext;
import com.bytedance.android.livesdk.config.us0;
import com.bytedance.android.livesdk.config.wy;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.PublicScreenABHelper;
import com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.adapter.LiveRoomEnvStateHolder;
import com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.j;
import com.bytedance.android.livesdk.interactivity.common.adjuster.logical.CommentLpHelper;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerExtraRenderController;
import com.bytedance.live.datacontext.m;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d implements com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.c {
    public static final float c = 0.0f;
    public static final c52.d d = null;
    public static final d e = null;

    public d() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.f
    public final String d() {
        return "PadCommonAudienceHeightAdjust";
    }

    static {
        e = new d();
        c = s1.e(64.0f);
        d = c52.d.f;
    }

    @Override // com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.c
    public final com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.d a(int r6, int r7, com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.e r8, Room r9, LiveRoomEnvStateHolder r10) {
        Intrinsics.checkNotNullParameter(r8, "uiContext");
        Intrinsics.checkNotNullParameter(r9, "room");
        Intrinsics.checkNotNullParameter(r10, "roomStatus");
        if (r10.isAnchor() == false) goto L5;
    L9:
        int r11 = (int) (s1.w() * 0.28f);
        as0.a r1 = LivePlatformPlayerManager.b();
        if (r1 == null) goto L22;
        ILivePlayerClient r2 = r1.player();
        if (r2 == null) goto L22;
        if (r2.gameExtraRenderController().isEnable() == false) goto L16;
    L19:
        boolean r3 = true;
    L20:
        if (r3 != true) goto L22;
        boolean r4 = true;
    L24:
        if (((Boolean) us0.a.getValue()).booleanValue() == true) goto L26;
    L50:
        if (j.a(r10, r8) == false) goto L52;
        int r13 = j.c(r7, r8, r10, d);
    L54:
        return new com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.d(r13, (int) c, 12);
    L52:
        r13 = (int) (s1.w() * 0.28f);
        goto L54
    L26:
        if (i72.a.a(r8) == false) goto L50;
        if (r4 == true) goto L50;
        if (((Boolean) wy.a.getValue()).booleanValue() == false) goto L34;
        IInteractService r5 = k.f(IInteractService.class);
        if (r5 == null) goto L34;
        if (r5.getCurrentScene() == 1) goto L50;
    L34:
        long r14 = r9.getRoomId();
        int r0 = ((r8.pT() - r8.WN()) - s1.j(2131168726)) - r7;
        InteractionWidgetsPosContext r15 = InteractionWidgetsPosContext.a.c(InteractionWidgetsPosContext.Companion, null, r14, 1);
        if (r15 == null) goto L39;
        m r16 = r15.getGameGiftTrayPos();
        if (r16 == null) goto L39;
        r16.setValue(new ok1.a(r0 - s1.j(2131168728), 2));
    L39:
        as0.a r17 = LivePlatformPlayerManager.b();
        if (r17 == null) goto L46;
        ILivePlayerClient r18 = r17.player();
        if (r18 == null) goto L46;
        ILivePlayerExtraRenderController r19 = r18.extraRenderController();
        if (r19 == null) goto L46;
        int r20 = r19.mainFrameDescViewHeight();
    L48:
        return new com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.d(Math.max(r0 - r20, r11), 0, 14);
    L46:
        r20 = 0;
        goto L48
    L16:
        if (r2.extraRenderController().isEnable() == true) goto L19;
        r3 = false;
    L22:
        r4 = false;
        goto L24
    L5:
        if (PublicScreenABHelper.f().enable == false) goto L9;
        com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.d r21 = CommentLpHelper.d(r8, r7, r10, r9);
        if (r21 == null) goto L50;
        return r21;
    }
}
