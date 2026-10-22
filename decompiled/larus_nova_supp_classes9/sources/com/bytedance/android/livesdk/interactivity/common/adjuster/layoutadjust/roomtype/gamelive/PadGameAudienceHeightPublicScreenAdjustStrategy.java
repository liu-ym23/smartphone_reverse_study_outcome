package com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.roomtype.gamelive;

import as0.a;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.platformplayer.LivePlatformPlayerManager;
import com.bytedance.android.livesdk.chatroom.InteractionWidgetsPosContext;
import com.bytedance.android.livesdk.config.us0;
import com.bytedance.android.livesdk.config.wy;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.b;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.d;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.e;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.PublicScreenABHelper;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.y;
import com.bytedance.android.livesdk.interactivity.api.settings.config.i;
import com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.adapter.LiveRoomEnvStateHolder;
import com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.c;
import com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.j;
import com.bytedance.android.livesdk.interactivity.common.adjuster.logical.CommentLpHelper;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerExtraRenderController;
import com.bytedance.live.datacontext.m;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import r52.n0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class PadGameAudienceHeightPublicScreenAdjustStrategy implements c {
    public static final int c = 0;
    public static final int d = 0;
    public static final Lazy e = null;
    public static final Lazy f = null;
    public static final c52.c g = null;
    public static final PadGameAudienceHeightPublicScreenAdjustStrategy h = null;

    public PadGameAudienceHeightPublicScreenAdjustStrategy() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.f
    public final String d() {
        return "PadGameAudienceHeightPublicScreenAdjustStrategy";
    }

    static {
        h = new PadGameAudienceHeightPublicScreenAdjustStrategy();
        c = s1.j(2131168673);
        d = s1.j(2131168680);
        e = LazyKt.lazy(PadGameAudienceHeightPublicScreenAdjustStrategy$giftPositionHeight$2.INSTANCE);
        f = LazyKt.lazy(PadGameAudienceHeightPublicScreenAdjustStrategy$giftPaddingBottom$2.INSTANCE);
        g = c52.c.f;
    }

    @Override // com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.c
    public final d a(int r11, int r13, e r14, Room r15, LiveRoomEnvStateHolder r16) {
        Intrinsics.checkNotNullParameter(r14, "uiContext");
        Intrinsics.checkNotNullParameter(r15, "room");
        Intrinsics.checkNotNullParameter(r16, "roomStatus");
        Integer r0 = null;
        boolean r2 = true;
        if (PublicScreenABHelper.f().enable == false) goto L23;
        d r17 = CommentLpHelper.d(r14, r13, r16, r15);
        if (r17 == null) goto L23;
        a r18 = LivePlatformPlayerManager.b();
        if (r18 == null) goto L21;
        ILivePlayerClient r19 = r18.player();
        if (r19 == null) goto L21;
        ILivePlayerExtraRenderController r110 = r19.extraRenderController();
        if (r110 == null) goto L21;
        Integer r111 = Integer.valueOf(r110.mainFrameDescViewHeight());
        if (r111.intValue() != 0) goto L16;
        r2 = false;
    L16:
        if (r2 == false) goto L18;
        r0 = r111;
    L18:
        if (r0 == null) goto L21;
        return new d(r17.a - r0.intValue(), 0, 14);
    L21:
        return r17;
    L23:
        if (r14.WN() < b.a) goto L25;
        int r112 = r14.pT();
        if (r112 == 0) goto L33;
        int r113 = ((int) (((((double) ((r112 - r14.WN()) - ((Number) e.getValue()).intValue())) - (((double) c) * 0.5d)) - ((double) d)) - ((double) ((Number) f.getValue()).intValue()))) - r13;
        int r114 = y.a();
        a r4 = LivePlatformPlayerManager.b();
        if (r4 == null) goto L43;
        ILivePlayerClient r5 = r4.player();
        if (r5 == null) goto L43;
        if (r5.extraRenderController().isEnable() == false) goto L41;
    L42:
        boolean r6 = true;
    L45:
        if (((Boolean) us0.a.getValue()).booleanValue() == true) goto L47;
    L63:
        boolean r115 = false;
    L64:
        a r116 = LivePlatformPlayerManager.b();
        if (r116 == null) goto L71;
        ILivePlayerClient r117 = r116.player();
        if (r117 == null) goto L71;
        ILivePlayerExtraRenderController r118 = r117.extraRenderController();
        if (r118 == null) goto L71;
        int r119 = r118.mainFrameDescViewHeight();
    L72:
        int r120 = Math.max(r113 - r119, r114);
        long r121 = r15.getRoomId();
        if (r115 == false) goto L82;
        if (((i) n0.a.getValue()).fixGiftTrayPos == false) goto L82;
        InteractionWidgetsPosContext r122 = InteractionWidgetsPosContext.a.c(InteractionWidgetsPosContext.Companion, null, r121, 1);
        if (r122 == null) goto L82;
        m r123 = r122.getGameGiftTrayPos();
        if (r123 == null) goto L82;
        int r124 = i72.a.a;
        r123.setValue(new ok1.a(r120 - s1.j(2131168728), 2));
    L82:
        return new d(r120, 0, 14);
    L71:
        r119 = 0;
        goto L72
    L47:
        if (i72.a.a(r14) == false) goto L63;
        if (r6 == true) goto L63;
        if (((Boolean) wy.a.getValue()).booleanValue() == false) goto L55;
        IInteractService r7 = k.f(IInteractService.class);
        if (r7 == null) goto L55;
        if (r7.getCurrentScene() == 1) goto L63;
    L55:
        long r8 = r15.getRoomId();
        r113 = ((r14.pT() - r14.WN()) - s1.j(2131168726)) - r13;
        if (j.b() == true) goto L62;
        InteractionWidgetsPosContext r125 = InteractionWidgetsPosContext.a.c(InteractionWidgetsPosContext.Companion, null, r8, 1);
        if (r125 == null) goto L62;
        m r126 = r125.getGameGiftTrayPos();
        if (r126 == null) goto L62;
        r126.setValue(new ok1.a(r113 - s1.j(2131168728), 2));
    L62:
        r115 = true;
        goto L64
    L41:
        if (r5.gameExtraRenderController().isEnable() == true) goto L42;
    L43:
        r6 = false;
        goto L45
    L33:
        return new d(0, 0, 15);
    L25:
        if (j.a(r16, r14) == false) goto L27;
        int r127 = j.c(r13, r14, r16, g);
    L29:
        return new d(r127, 0, 14);
    L27:
        r127 = (int) (s1.w() * 0.28f);
        goto L29
    }
}
