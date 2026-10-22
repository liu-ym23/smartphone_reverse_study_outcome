package com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.roomtype.gamelive;

import c52.a;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.gift.IGiftServiceExternal;
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
import com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.adapter.LiveRoomEnvStateHolder;
import com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.c;
import com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.j;
import com.bytedance.android.livesdk.interactivity.common.adjuster.logical.CommentLpHelper;
import com.bytedance.android.livesdkapi.depend.model.live.IExtension;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.model.PlayerExtraRenderInfo;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerExtraRenderController;
import com.bytedance.live.datacontext.m;
import java.util.concurrent.ConcurrentHashMap;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GameAudienceHeightPublicScreenAdjustStrategy implements c {
    public final Lazy c;
    public final a d;

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.f
    public final String d() {
        return "GameAudienceHeightPublicScreenAdjustStrategy";
    }

    public GameAudienceHeightPublicScreenAdjustStrategy() {
        this.c = LazyKt.lazy(GameAudienceHeightPublicScreenAdjustStrategy$ugcHeightOptimize$2.INSTANCE);
        this.d = a.g;
    }

    public final com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.c f(int r8, e r9, LiveRoomEnvStateHolder r10) {
        if (j.a(r10, r9) == false) goto L5;
        int r11 = j.c(r8, r9, r10, this.d);
        String r13 = "default";
    L6:
        int r2 = r11;
        int r1 = r2 + com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.a.a;
        int r4 = j.d();
        return new com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.c(r1, r2, 0, r4, r13, 4);
    L5:
        r13 = r10.A;
        r11 = y.a() + r10.z;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.c
    public final d a(int r23, int r24, e r25, Room r26, LiveRoomEnvStateHolder r27) {
        Intrinsics.checkNotNullParameter(r25, "uiContext");
        Intrinsics.checkNotNullParameter(r26, "room");
        Intrinsics.checkNotNullParameter(r27, "roomStatus");
        IExtension r5 = r26.getExtension();
        boolean r7 = true;
        if (r5 != null) goto L5;
    L7:
        boolean r6 = false;
    L8:
        Integer r9 = null;
        if (PublicScreenABHelper.f().enable == false) goto L29;
        d r8 = CommentLpHelper.d(r25, r24, r27, r26);
        if (r8 == null) goto L29;
        ConcurrentHashMap r1 = LivePlatformPlayerManager.a;
        as0.a r2 = LivePlatformPlayerManager.e(r26.getRoomId(), r26.hasMicRoomField());
        if (r2 == null) goto L27;
        ILivePlayerClient r3 = r2.player();
        if (r3 == null) goto L27;
        ILivePlayerExtraRenderController r4 = r3.extraRenderController();
        if (r4 == null) goto L27;
        Integer r10 = Integer.valueOf(r4.mainFrameDescViewHeight());
        if (r10.intValue() != 0) goto L22;
        r7 = false;
    L22:
        if (r7 == false) goto L24;
        r9 = r10;
    L24:
        if (r9 == null) goto L27;
        return new d(r8.a - r9.intValue(), 0, 14);
    L27:
        return r8;
    L29:
        if (r26.isCompoundScene() == false) goto L51;
        if (((Boolean) this.c.getValue()).booleanValue() == false) goto L33;
        if (r6 == false) goto L36;
        ILivePlayerClient r11 = LivePlatformPlayerManager.f();
        if (r11 == null) goto L46;
        ILivePlayerExtraRenderController r13 = r11.extraRenderController();
        if (r13 == null) goto L46;
        PlayerExtraRenderInfo r14 = r13.renderInfo();
        if (r14 == null) goto L46;
        if (r14.getExtraAreaIsGame() != true) goto L46;
        boolean r15 = true;
    L47:
        if (r15 == false) goto L51;
        return f(r24, r25, r27);
    L46:
        r15 = false;
        goto L47
    L36:
        return f(r24, r25, r27);
    L33:
        return f(r24, r25, r27);
    L51:
        if (r25.g1() == true) goto L55;
        return f(r24, r25, r27);
    L55:
        if (r25.WN() < b.a) goto L57;
        int r16 = r25.pT();
        if (r16 == 0) goto L61;
        ca0.a r17 = k.n(IGiftServiceExternal.class).getGiftTrayHeightInfo();
        int r18 = ((int) (((((double) ((r16 - r25.WN()) - r17.c)) - (((double) r17.a) * 0.5d)) - ((double) r17.b)) - ((double) r17.d))) - r24;
        int r19 = y.a();
        if (((Boolean) us0.a.getValue()).booleanValue() == true) goto L65;
    L80:
        boolean r110 = false;
    L81:
        int r20 = Math.max(r18, r19);
        if (((Boolean) this.c.getValue()).booleanValue() == true) goto L84;
    L99:
        int r111 = r20;
        int r21 = 0;
    L100:
        int r112 = (((r16 - r25.WN()) - r24) - r21) - com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.a.b;
        long r28 = r26.getRoomId();
        if (r110 == true) goto L103;
    L109:
        if (r110 == false) goto L111;
        int r113 = 0;
    L113:
        return new com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.c(r112, r111, 0, r113, null, 20);
    L111:
        r113 = j.d();
        goto L113
    L103:
        if (j.b() == false) goto L109;
        InteractionWidgetsPosContext r29 = InteractionWidgetsPosContext.a.c(InteractionWidgetsPosContext.Companion, null, r28, 1);
        if (r29 == null) goto L109;
        m r30 = r29.getGameGiftTrayPos();
        if (r30 == null) goto L109;
        int r31 = i72.a.a;
        r30.setValue(new ok1.a(r111 - s1.j(2131168727), 2));
        goto L109
    L84:
        if (r26.isCompoundScene() == false) goto L99;
        if (r6 == false) goto L99;
        ILivePlayerClient r33 = LivePlatformPlayerManager.f();
        if (r33 == null) goto L99;
        ILivePlayerExtraRenderController r34 = r33.extraRenderController();
        if (r34 == null) goto L99;
        Integer r35 = Integer.valueOf(r34.mainFrameDescViewHeight());
        if (r35.intValue() == 0) goto L93;
        boolean r114 = true;
    L94:
        if (r114 == true) goto L97;
        r35 = null;
    L97:
        if (r35 == null) goto L99;
        r21 = r35.intValue();
        r111 = r20 - r21;
        goto L100
    L93:
        r114 = false;
        goto L94
    L65:
        if (i72.a.a(r25) == false) goto L80;
        if (((Boolean) wy.a.getValue()).booleanValue() == false) goto L72;
        IInteractService r115 = k.f(IInteractService.class);
        if (r115 == null) goto L72;
        if (r115.getCurrentScene() == 1) goto L80;
    L72:
        long r116 = r26.getRoomId();
        r18 = ((r25.pT() - r25.WN()) - s1.j(2131168725)) - r24;
        if (j.b() == true) goto L79;
        InteractionWidgetsPosContext r117 = InteractionWidgetsPosContext.a.c(InteractionWidgetsPosContext.Companion, null, r116, 1);
        if (r117 == null) goto L79;
        m r118 = r117.getGameGiftTrayPos();
        if (r118 == null) goto L79;
        r118.setValue(new ok1.a(r18 - s1.j(2131168727), 2));
    L79:
        r110 = true;
        goto L81
    L61:
        return new d(0, 0, 15);
    L57:
        return f(r24, r25, r27);
    L5:
        if (r5.getLayout() != 1) goto L7;
        r6 = true;
        goto L8
    }
}
