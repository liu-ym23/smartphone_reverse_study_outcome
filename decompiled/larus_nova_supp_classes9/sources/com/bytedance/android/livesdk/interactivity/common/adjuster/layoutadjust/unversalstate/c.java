package com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.unversalstate;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.revenue.battle.b0;
import com.bytedance.android.live.liveinteract.utils.MultiLinkLoadWidgetUtils;
import com.bytedance.android.livesdk.chatroom.InteractionWidgetsPosContext;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.y;
import com.bytedance.android.livesdk.config.xu;
import com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.adapter.LiveRoomEnvStateHolder;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c implements com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.g {
    public static final int c = 0;
    public static final int d = 0;
    public static final int e = 0;
    public static final int f = 0;
    public static final int g = 0;
    public static final int h = 0;
    public static final c i = null;

    public c() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.f
    public final String d() {
        return "EqualTalkAdjust";
    }

    static {
        i = new c();
        c = s1.f(118.0f);
        InteractionWidgetsPosContext.Companion.getClass();
        d = InteractionWidgetsPosContext.access$getTOOLBAR_HEIGHT$cp();
        e = s1.f(28.0f);
        f = s1.f(110.0f);
        g = s1.f(88.0f);
        h = s1.f(12.0f);
    }

    @Override // com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.g
    public final boolean c(LiveRoomEnvStateHolder r2) {
        Intrinsics.checkNotNullParameter(r2, "roomStatus");
        return r2.I();
    }

    @Override // com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.g
    public final com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.d a(int r9, int r10, com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.e r11, Room r13, LiveRoomEnvStateHolder r14) {
        Intrinsics.checkNotNullParameter(r11, "uiContext");
        Intrinsics.checkNotNullParameter(r13, "room");
        Intrinsics.checkNotNullParameter(r14, "roomStatus");
        int r15 = r11.pT();
        r14.g();
        s1.e(46.0f);
        int r16 = y.b(r13.getRoomId());
        if (r14.g0() == false) goto L5;
        r16 = r16 + h;
    L5:
        int r17 = r15 - r16;
        int r18 = d;
        int r19 = e;
        int r20 = (r17 - r18) - r19;
        DataCenter r110 = r14.G;
        if (MultiLinkLoadWidgetUtils.h() == false) goto L10;
        IInteractService r0 = k.f(IInteractService.class);
        if (r0 == null) goto L13;
        Integer r1 = Integer.valueOf(r0.getUiLayout(r110));
    L15:
        if (r1 != null) goto L18;
    L22:
        int r2 = r20;
    L23:
        IInteractService r3 = k.f(IInteractService.class);
        if (r3 == null) goto L26;
        b0 r4 = r3.guestBattleContext();
    L28:
        if (r4 != null) goto L30;
    L34:
        int r5 = r2;
    L35:
        long r6 = r13.getRoomId();
        if (MultiLinkLoadWidgetUtils.h() == false) goto L38;
        int r111 = k.n(IInteractService.class).getUiLayout(r110);
    L39:
        RoomContext r112 = RoomContext.a.c(RoomContext.Companion, null, r6, 1);
        int r7 = 0;
        if (r112 == null) goto L48;
        m r113 = r112.getRoom();
        if (r113 == null) goto L48;
        Room r114 = (Room) r113.getValue();
        if (r114 == null) goto L48;
        if (r114.isLiveTypeAudio() != true) goto L48;
        boolean r115 = true;
    L49:
        if (r115 == false) goto L53;
        InteractionWidgetsPosContext r8 = InteractionWidgetsPosContext.a.c(InteractionWidgetsPosContext.Companion, null, r6, 1);
        if (r8 == null) goto L56;
        m r21 = r8.getAudioGiftTrayPos();
    L57:
        if (r115 == true) goto L69;
        if (r111 != 43) goto L69;
        if (r21 == null) goto L83;
        InteractionWidgetsPosContext r116 = InteractionWidgetsPosContext.a.c(InteractionWidgetsPosContext.Companion, null, r6, 1);
        if (r116 == null) goto L67;
        m r117 = r116.getVideoTalkTop2V4V4GiftHeightTrayPos();
        if (r117 == null) goto L67;
        Integer r118 = (Integer) r117.getValue();
        if (r118 == null) goto L67;
        r7 = r118.intValue();
    L67:
        r21.setValue(new ok1.a((r20 + r18) + r7, 1));
    L83:
        return new com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.d(r5, r18, 12);
    L69:
        if (r20 < c) goto L76;
        if (r21 == null) goto L83;
        if (((Boolean) xu.a.getValue()).booleanValue() == false) goto L74;
        int r119 = g;
    L75:
        r21.setValue(new ok1.a((r20 + r18) - r119, 2));
        goto L83
    L74:
        r119 = f;
        goto L75
    L76:
        int r120 = com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.b.b;
        if (r20 <= r120) goto L80;
        if (r21 == null) goto L83;
        r21.setValue(new ok1.a((r20 + r18) + r19, 1));
        goto L83
    L80:
        if (r21 == null) goto L83;
        r21.setValue(new ok1.a((r120 + r18) + r19, 1));
    L56:
        r21 = null;
        goto L57
    L53:
        InteractionWidgetsPosContext r23 = InteractionWidgetsPosContext.a.c(InteractionWidgetsPosContext.Companion, null, r6, 1);
        if (r23 == null) goto L56;
        r21 = r23.getEqualVideoTalkGiftTrayPos();
    L48:
        r115 = false;
        goto L49
    L38:
        r111 = k.n(IInteractService.class).getCurrentUiLayout();
        goto L39
    L30:
        if (r4.isChestUiShown() != true) goto L34;
        r2 = r2 - s1.f(39.0f);
        r5 = com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.b.b;
        if (r2 >= r5) goto L34;
    L26:
        r4 = null;
        goto L28
    L18:
        if (r1.intValue() != 43) goto L22;
        r2 = com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.b.b;
        if (r20 >= r2) goto L22;
    L13:
        r1 = null;
        goto L15
    L10:
        IInteractService r24 = k.f(IInteractService.class);
        if (r24 == null) goto L13;
        r1 = Integer.valueOf(r24.getCurrentUiLayout());
        goto L15
    }
}
