package h72;

import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.revenue.battle.b0;
import com.bytedance.android.live.liveinteract.utils.MultiLinkLoadWidgetUtils;
import com.bytedance.android.livesdk.chatroom.InteractionWidgetsPosContext;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.utils.o3;
import com.bytedance.android.livesdk.chatroom.viewmodel.f;
import com.bytedance.android.livesdk.chatroom.viewmodel.i;
import com.bytedance.android.livesdk.chatroom.y;
import com.bytedance.android.livesdk.config.fl0;
import com.bytedance.android.livesdk.config.g40;
import com.bytedance.android.livesdk.config.gf;
import com.bytedance.android.livesdk.config.gl0;
import com.bytedance.android.livesdk.config.hx;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.d;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.e;
import com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.adapter.LiveRoomEnvStateHolder;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a implements com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.c {
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public final float h;
    public final int i;

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.f
    public final String d() {
        return "AudioHeightPublicScreenOptimizeStrategy";
    }

    public a() {
        this.c = UtilityKotlinExtentionsKt.i(168);
        this.d = UtilityKotlinExtentionsKt.i(138);
        this.e = UtilityKotlinExtentionsKt.i(21);
        this.f = UtilityKotlinExtentionsKt.i(230);
        this.g = UtilityKotlinExtentionsKt.i(90);
        this.h = 0.19f;
        this.i = s1.j(2131169060);
        s1.f(32.0f);
    }

    public final int f(int r5, int r6, Integer r7, long r8) {
        int r9 = r6 - r5;
        InteractionWidgetsPosContext.a r10 = InteractionWidgetsPosContext.Companion;
        r10.getClass();
        int r11 = (r9 - InteractionWidgetsPosContext.access$getTOOLBAR_HEIGHT$cp()) - InteractionWidgetsPosContext.access$getENTER_ANIMATION_HEIGHT$cp();
        if (r11 < this.c) goto L10;
        InteractionWidgetsPosContext r13 = InteractionWidgetsPosContext.a.c(r10, null, r8, 1);
        if (r13 == null) goto L32;
        m r14 = r13.getAudioGiftTrayPos();
        if (r14 == null) goto L32;
        r14.setValue(new ok1.a((InteractionWidgetsPosContext.access$getTOOLBAR_HEIGHT$cp() + r11) - InteractionWidgetsPosContext.access$getGIFT_TRAY_HEIGHT$cp(), 2));
    L32:
        return r11;
    L10:
        if (r11 <= this.d) goto L16;
        InteractionWidgetsPosContext r15 = InteractionWidgetsPosContext.a.c(r10, null, r8, 1);
        if (r15 == null) goto L32;
        m r16 = r15.getAudioGiftTrayPos();
        if (r16 == null) goto L32;
        r16.setValue(new ok1.a((InteractionWidgetsPosContext.access$getTOOLBAR_HEIGHT$cp() + r11) + InteractionWidgetsPosContext.access$getENTER_ANIMATION_HEIGHT$cp(), 1));
        goto L32
    L16:
        if (r7 != null) goto L19;
    L27:
        r11 = this.d;
        InteractionWidgetsPosContext r17 = InteractionWidgetsPosContext.a.c(r10, null, r8, 1);
        if (r17 == null) goto L32;
        m r18 = r17.getAudioGiftTrayPos();
        if (r18 == null) goto L32;
        r18.setValue(new ok1.a((InteractionWidgetsPosContext.access$getTOOLBAR_HEIGHT$cp() + r11) + InteractionWidgetsPosContext.access$getENTER_ANIMATION_HEIGHT$cp(), 1));
        goto L32
    L19:
        if (r7.intValue() != 61) goto L27;
        if (((Boolean) g40.a.getValue()).booleanValue() == false) goto L27;
        InteractionWidgetsPosContext r19 = InteractionWidgetsPosContext.a.c(r10, null, r8, 1);
        if (r19 == null) goto L32;
        m r20 = r19.getAudioGiftTrayPos();
        if (r20 == null) goto L32;
        r20.setValue(new ok1.a((InteractionWidgetsPosContext.access$getTOOLBAR_HEIGHT$cp() + r11) - InteractionWidgetsPosContext.access$getGIFT_TRAY_HEIGHT$cp(), 2));
        goto L32
    }

    @Override // com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.c
    public final d a(int r11, int r13, e r14, Room r15, LiveRoomEnvStateHolder r16) {
        Intrinsics.checkNotNullParameter(r14, "uiContext");
        Intrinsics.checkNotNullParameter(r15, "room");
        Intrinsics.checkNotNullParameter(r16, "roomStatus");
        if (PadConfigUtils.a() == false) goto L5;
        int r17 = (int) com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.roomtype.common.d.c;
    L6:
        int r3 = r17;
        RoomContext r18 = com.bytedance.live.datacontext.d.e(RoomContext.class, RoomContext.class);
        boolean r19 = false;
        if (r18 == null) goto L15;
        j r110 = r18.getVoiceTalkRoomSubScene();
        if (r110 == null) goto L15;
        f r111 = (f) r110.getValue();
        if (r111 == null) goto L15;
        i r112 = r111.t();
        if (r112 == null) goto L15;
        int r113 = r112.a;
    L16:
        DataCenter r0 = r16.G;
        Integer r2 = null;
        if (e92.m.g(r0) == true) goto L32;
        MiddlewareRoomContext r1 = o3.c(r0);
        if (r1 == null) goto L23;
        n r4 = r1.isRoomVisible();
        if (r4 == null) goto L23;
        Boolean r5 = (Boolean) r4.getValue();
    L25:
        if (Intrinsics.areEqual(r5, Boolean.FALSE) == false) goto L32;
        if (MultiLinkLoadWidgetUtils.h() == false) goto L32;
        IInteractService r114 = k.f(IInteractService.class);
        if (r114 == null) goto L31;
        r113 = r114.getScene(r0);
        goto L32
    L31:
        r113 = 0;
    L23:
        r5 = null;
    L32:
        boolean r6 = true;
        if (r113 == 0) goto L152;
        if (r113 != 5) goto L37;
        RoomContext r115 = com.bytedance.live.datacontext.d.e(RoomContext.class, RoomContext.class);
        if (r115 == null) goto L74;
        j r116 = r115.getVoiceTalkRoomSubScene();
        if (r116 == null) goto L74;
        f r117 = (f) r116.getValue();
        if (r117 == null) goto L74;
        i r118 = r117.t();
        if (r118 == null) goto L74;
        if (r118.b != 29) goto L74;
        int r119 = (this.i - this.e) - k.n(IInteractService.class).getAudioTalkRadioBottomOffset(r15);
        InteractionWidgetsPosContext r120 = InteractionWidgetsPosContext.a.c(InteractionWidgetsPosContext.Companion, null, r15.getRoomId(), 1);
        if (r120 == null) goto L136;
        m r121 = r120.getAudioGiftTrayPos();
        if (r121 == null) goto L136;
        r121.setValue(new ok1.a((InteractionWidgetsPosContext.access$getTOOLBAR_HEIGHT$cp() + r119) + InteractionWidgetsPosContext.access$getENTER_ANIMATION_HEIGHT$cp(), 1));
    L136:
        if (r119 > this.i) goto L138;
    L150:
        r16.q0(r119);
    L57:
        int r7 = r119;
    L173:
        if (r19 == false) goto L176;
        return new com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.c(r7 + com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.a.a, r7, r3, 0, null, 24);
    L176:
        return new d(r7, r3, 12);
    L138:
        if (((Boolean) fl0.a.getValue()).booleanValue() == false) goto L150;
        RoomContext r122 = com.bytedance.live.datacontext.d.e(RoomContext.class, RoomContext.class);
        if (r122 == null) goto L150;
        j r123 = r122.getVoiceTalkRoomSubScene();
        if (r123 == null) goto L150;
        f r124 = (f) r123.getValue();
        if (r124 == null) goto L150;
        i r125 = r124.t();
        if (r125 == null) goto L150;
        if (r125.b != 30) goto L150;
        r119 = this.i;
    L74:
        if (((Boolean) gl0.a.getValue()).booleanValue() == false) goto L85;
        RoomContext r126 = com.bytedance.live.datacontext.d.e(RoomContext.class, RoomContext.class);
        if (r126 == null) goto L85;
        j r127 = r126.getVoiceTalkRoomSubScene();
        if (r127 == null) goto L85;
        f r128 = (f) r127.getValue();
        if (r128 == null) goto L85;
        i r129 = r128.t();
        if (r129 == null) goto L85;
        if (r129.b != 28) goto L85;
    L89:
        IInteractService r130 = k.f(IInteractService.class);
        if (r130 == null) goto L92;
        boolean r131 = r130.currentIsCPositionUser();
    L93:
        if (r131 == false) goto L95;
        int r132 = r14.pT();
        int r8 = this.c;
    L96:
        int r133 = r132 - r8;
    L98:
        int r9 = r133;
        if (((Boolean) gf.a.getValue()).booleanValue() == false) goto L134;
        int r134 = r14.pT();
        long r135 = r15.getRoomId();
        InteractionWidgetsPosContext.a r10 = InteractionWidgetsPosContext.Companion;
        r10.getClass();
        r119 = ((r134 - r9) - InteractionWidgetsPosContext.access$getTOOLBAR_HEIGHT$cp()) - InteractionWidgetsPosContext.access$getENTER_ANIMATION_HEIGHT$cp();
        int r20 = this.c;
        if (r119 >= r20) goto L103;
        r119 = r20;
    L103:
        IInteractService r21 = k.f(IInteractService.class);
        if (r21 == null) goto L106;
        b0 r23 = r21.guestBattleContext();
    L107:
        if (r23 != null) goto L109;
    L111:
        boolean r24 = false;
    L112:
        if (r24 == true) goto L114;
    L115:
        RoomContext r25 = com.bytedance.live.datacontext.d.e(RoomContext.class, RoomContext.class);
        if (r25 == null) goto L126;
        j r26 = r25.getVoiceTalkRoomSubScene();
        if (r26 == null) goto L126;
        f r27 = (f) r26.getValue();
        if (r27 == null) goto L126;
        i r28 = r27.t();
        if (r28 == null) goto L126;
        if (r28.b != 66) goto L126;
        boolean r29 = true;
    L127:
        if (r29 == false) goto L129;
    L128:
        r119 = this.d;
    L129:
        InteractionWidgetsPosContext r136 = InteractionWidgetsPosContext.a.c(r10, null, r135, 1);
        if (r136 == null) goto L136;
        m r137 = r136.getAudioGiftTrayPos();
        if (r137 == null) goto L136;
        r137.setValue(new ok1.a((InteractionWidgetsPosContext.access$getTOOLBAR_HEIGHT$cp() + r119) - InteractionWidgetsPosContext.access$getGIFT_TRAY_HEIGHT$cp(), 2));
    L126:
        r29 = false;
        goto L127
    L114:
        if (r119 < this.d) goto L128;
    L109:
        if (r23.isChestUiShown() != true) goto L111;
        r24 = true;
        goto L112
    L106:
        r23 = null;
        goto L107
    L134:
        r119 = f(r9, r14.pT(), null, r15.getRoomId());
        goto L136
    L95:
        int r138 = r14.pT() - this.i;
        InteractionWidgetsPosContext.Companion.getClass();
        r132 = r138 - InteractionWidgetsPosContext.access$getTOOLBAR_HEIGHT$cp();
        r8 = InteractionWidgetsPosContext.access$getENTER_ANIMATION_HEIGHT$cp();
        goto L96
    L92:
        r131 = false;
    L85:
        IInteractService r139 = k.f(IInteractService.class);
        if (r139 != null) goto L88;
    L97:
        r133 = k.n(IInteractService.class).getAudioTalkSeatBottomPos(r15);
        goto L98
    L88:
        if (r139.isInCustomizeStreamLayout() != true) goto L97;
    L37:
        if (r113 != 9) goto L39;
        RoomContext r140 = com.bytedance.live.datacontext.d.e(RoomContext.class, RoomContext.class);
        if (r140 == null) goto L49;
        j r141 = r140.getVoiceTalkRoomSubScene();
        if (r141 == null) goto L49;
        f r142 = (f) r141.getValue();
        if (r142 == null) goto L49;
        i r143 = r142.t();
        if (r143 == null) goto L49;
        r2 = Integer.valueOf(r143.b);
    L49:
        Integer r30 = r2;
        if (r30 != null) goto L53;
    L55:
        r6 = false;
    L56:
        r119 = f(y.a(r6, r15.getRoomId()), r14.pT(), r30, r15.getRoomId());
        goto L57
    L53:
        if (r30.intValue() != 61) goto L55;
    L39:
        return new d(0, 0, 15);
    L152:
        if (((Boolean) hx.a.getValue()).booleanValue() == false) goto L158;
        if (FoldScreenUtils.f() == false) goto L158;
        if (FoldScreenUtils.a() != 0) goto L158;
    L159:
        int r144 = (int) (r14.pT() * this.h);
        if (PadConfigUtils.a() == true) goto L167;
        r144 = Math.min(this.f, Math.max(this.g, r144));
    L167:
        InteractionWidgetsPosContext r145 = InteractionWidgetsPosContext.a.c(InteractionWidgetsPosContext.Companion, null, r15.getRoomId(), 1);
        if (r145 == null) goto L172;
        m r146 = r145.getAudioGiftTrayPos();
        if (r146 == null) goto L172;
        r146.setValue(new ok1.a((InteractionWidgetsPosContext.access$getTOOLBAR_HEIGHT$cp() + r144) + InteractionWidgetsPosContext.access$getENTER_ANIMATION_HEIGHT$cp(), 1));
    L172:
        r7 = r144;
        r19 = true;
    L158:
        if (PadConfigUtils.a() == true) goto L159;
        int r147 = r14.pT();
        int r148 = k.n(IInteractService.class).getAudioTalkRadioPublicScreenTopMargin();
        if (r148 <= 0) goto L165;
        InteractionWidgetsPosContext.Companion.getClass();
        int r149 = ((r147 - r148) - InteractionWidgetsPosContext.access$getTOOLBAR_HEIGHT$cp()) - InteractionWidgetsPosContext.access$getENTER_ANIMATION_HEIGHT$cp();
        int r150 = InteractionWidgetsPosContext.access$getGIFT_TRAY_HEIGHT$cp();
    L166:
        r144 = r149 - r150;
        goto L167
    L165:
        r149 = this.i;
        r150 = k.n(IInteractService.class).getAudioTalkRadioBottomOffset(r15);
    L15:
        r113 = 0;
        goto L16
    L5:
        InteractionWidgetsPosContext.Companion.getClass();
        r17 = InteractionWidgetsPosContext.access$getTOOLBAR_HEIGHT$cp();
        goto L6
    }
}
