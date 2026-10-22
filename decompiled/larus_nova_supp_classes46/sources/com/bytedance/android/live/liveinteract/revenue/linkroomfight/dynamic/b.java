package com.bytedance.android.live.liveinteract.revenue.linkroomfight.dynamic;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.message.o2;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.liveinteract.multiscene.k;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.revenue.fight.dynamic.m;
import com.bytedance.android.live.liveinteract.revenue.linkroomfight.core.LinkRoomFightContext;
import com.bytedance.android.live.liveinteract.utils.MultiSceneEnterRoomStatisticsUtils;
import com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService;
import com.bytedance.android.livesdk.chatroom.model.interact.m1;
import com.bytedance.android.livesdk.chatroom.viewmodel.LivePlayModeLogContext;
import com.bytedance.android.livesdk.link.model.bridge.g2;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.j;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b implements ih0.g {
    public final /* synthetic */ DynamicLinkRoomFightWidget a;

    public b(DynamicLinkRoomFightWidget r1) {
        this.a = r1;
    }

    @Override // ih0.g
    public final void a(JsonObject r14) {
        ALogger.i(this.a.a, "registBizStateChange, cacheBizData=" + r14);
        if (r14 == null) goto L165;
        String r0 = r14.get("key").getAsString();
        JsonElement r15 = r14.get("data");
        if (r0.equals("state") == false) goto L166;
        if (r15 == null) goto L167;
        JsonObject r16 = r15.getAsJsonObject();
        int r1 = r16.get("update_type").getAsInt();
        r16.get("enter_from").getAsInt();
        boolean r3 = false;
        if (r16.has("lynx_report_audience_room_watch") == false) goto L10;
        boolean r2 = r16.get("lynx_report_audience_room_watch").getAsBoolean();
    L11:
        com.bytedance.android.live.liveinteract.multiscene.a r4 = (com.bytedance.android.live.liveinteract.multiscene.a) GsonProtectorUtils.fromJson(GsonHelper.getLynxWorkaround(), r16.get("cur_teamfight_info"), com.bytedance.android.live.liveinteract.multiscene.a.class);
        if (r4 == null) goto L14;
        int r5 = r4.getFightStatus();
    L15:
        this.a.b = r4;
        if (r5 != 0) goto L18;
        com.bytedance.android.live.liveinteract.revenue.linkroomfight.core.c.b r7 = com.bytedance.android.live.liveinteract.revenue.linkroomfight.core.c.b.C0093c.c;
    L29:
        LinkRoomFightContext r8 = this.a.e;
        if (r8 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("linkRoomFightContext");
    L32:
        com.bytedance.android.live.liveinteract.multiscene.f r10 = null;
        if (((com.bytedance.android.live.liveinteract.revenue.linkroomfight.core.c.b) r8.getFightState().getValue()).a() == false) goto L35;
    L43:
        ALogger.i(this.a.a, "registBizStateChange, mCurrentTeamFightInfo=" + this.a.b);
        LinkRoomFightContext r9 = this.a.e;
        if (r9 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("linkRoomFightContext");
    L46:
        r9.getFightState().setValue(r7);
        if (r4 == null) goto L168;
        LinkRoomFightContext r11 = this.a.e;
        if (r11 != null) goto L51;
        Intrinsics.throwUninitializedPropertyAccessException("linkRoomFightContext");
    L51:
        r11.getFightInfo().setValue(r4);
        int r12 = m.a;
        if (r1 == 0) goto L54;
        return;
    L54:
        if (this.a.wq(r5) == false) goto L60;
        j r6 = com.bytedance.android.live.liveinteract.api.utils.m.e(this.a).J();
        if (r6 == null) goto L72;
        LivePlayModeLogContext r13 = (LivePlayModeLogContext) r6.getValue();
        if (r13 == null) goto L72;
        r13.addPlayMode(16);
    L72:
        int r17 = r16.get("pre_status").getAsInt();
        JsonElement r18 = r16.get("finish_content");
        ALogger.i(this.a.a, "registBizStateChange, finishContent=" + r18);
        DynamicLinkRoomFightWidget r19 = this.a;
        if (r18 == null) goto L75;
        o2 r110 = (o2) GsonProtectorUtils.fromJson(GsonHelper.getLynxWorkaround(), r18, o2.class);
    L76:
        r19.c = r110;
        DynamicLinkRoomFightWidget r111 = this.a;
        r111.getClass();
        if (gh0.a.d() == true) goto L132;
        if (r17 == 0) goto L82;
        if (r17 == 4) goto L82;
        boolean r20 = false;
    L83:
        if (r20 == false) goto L123;
        if (r111.wq(r5) == false) goto L123;
        g2 r112 = zi0.d.b;
        Intrinsics.checkNotNullParameter(r4, "fightInfo");
        LinkedHashMap r113 = new LinkedHashMap();
        zi0.d.h(r113);
        r113.put("seat_fit_status", "off");
        com.bytedance.android.live.liveinteract.multiscene.g r21 = r4.getRoomBattleContent();
        String r22 = "0";
        if (r21 == null) goto L94;
        com.bytedance.android.live.liveinteract.multiscene.c r23 = r21.getRoomBattleMode();
        if (r23 == null) goto L94;
        m1 r24 = r23.getRoomBattleThemeParam();
        if (r24 == null) goto L94;
        String r25 = String.valueOf(r24.getThemeId());
        if (r25 == null) goto L94;
    L95:
        r113.put("theme", r25);
        com.bytedance.android.live.liveinteract.multiscene.j r26 = li0.d.a(r4);
        if (r26 == null) goto L98;
        r22 = k.b(r26);
    L98:
        r113.put("to_anchor_id", r22);
        com.bytedance.live.datacontext.m r27 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r27 == null) goto L114;
        IRoom r28 = (IRoom) r27.getValue();
        if (r28 == null) goto L114;
        if (r28.isLiveTypeAudio() != true) goto L114;
        IVoiceChatGuestService.Companion.getClass();
        IVoiceChatGuestService r29 = IVoiceChatGuestService.a.a();
        if (r29 == null) goto L108;
        com.bytedance.android.live.liveinteract.voicechat.util.k r30 = r29.getLogger();
        if (r30 == null) goto L108;
    L112:
        if (r30 == null) goto L116;
        com.bytedance.android.live.liveinteract.voicechat.util.k.u(r30, 16, r113, r2, 3);
    L116:
        if (hd0.c.f().h() == false) goto L170;
        com.bytedance.android.live.liveinteract.multiscene.j r114 = li0.d.i(r4);
        if (r114 == null) goto L120;
        r10 = k.a(r114, je0.d.b0());
    L120:
        if (r10 == null) goto L171;
        zi0.d.e("processing", r4);
        return;
    L171:
        return;
    L170:
        return;
    L108:
        com.bytedance.android.live.liveinteract.voicechat.d.s0.getClass();
        com.bytedance.android.live.liveinteract.voicechat.d r31 = com.bytedance.android.live.liveinteract.voicechat.d.a.a();
        if (r31 == null) goto L111;
        r30 = r31.getLogger();
        goto L112
    L111:
        r30 = null;
    L114:
        TalkRoomLogUtils.O(null, 16, r113, r2, 3);
    L94:
        r25 = "0";
    L123:
        if (r111.wq(r17) == false) goto L173;
        if (r5 == 0) goto L126;
        if (r5 == 4) goto L126;
    L127:
        if (r3 == true) goto L129;
        return;
    L129:
        if (hd0.c.f().h() == false) goto L131;
        zi0.d.f(r4);
    L131:
        zi0.d.g(r4);
        return;
    L126:
        r3 = true;
        goto L127
    L173:
        return;
    L82:
        r20 = true;
        goto L83
    L132:
        if (r17 == 0) goto L136;
        if (r17 == 4) goto L136;
        boolean r32 = false;
    L137:
        if (r32 == false) goto L158;
        if (r111.wq(r5) == false) goto L158;
        g2 r115 = zi0.d.b;
        com.bytedance.live.datacontext.m r116 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r116 == null) goto L156;
        IRoom r117 = (IRoom) r116.getValue();
        if (r117 == null) goto L156;
        if (r117.isLiveTypeAudio() != true) goto L156;
        IVoiceChatGuestService.Companion.getClass();
        IVoiceChatGuestService r118 = IVoiceChatGuestService.a.a();
        if (r118 == null) goto L150;
        com.bytedance.android.live.liveinteract.voicechat.util.k r119 = r118.getLogger();
        if (r119 == null) goto L150;
    L154:
        if (r119 == null) goto L176;
        com.bytedance.android.live.liveinteract.voicechat.util.k.l(r119, 16, null, 11);
        return;
    L176:
        return;
    L150:
        com.bytedance.android.live.liveinteract.voicechat.d.s0.getClass();
        com.bytedance.android.live.liveinteract.voicechat.d r120 = com.bytedance.android.live.liveinteract.voicechat.d.a.a();
        if (r120 == null) goto L153;
        r119 = r120.getLogger();
        goto L154
    L153:
        r119 = null;
    L156:
        TalkRoomLogUtils.K(16, null, 11);
        return;
    L158:
        if (r111.wq(r17) == false) goto L179;
        if (r5 == 0) goto L161;
        if (r5 == 4) goto L161;
    L162:
        if (r3 == false) goto L180;
        g2 r33 = zi0.d.b;
        zi0.d.c(r111.c);
        return;
    L180:
        return;
    L161:
        r3 = true;
        goto L162
    L179:
        return;
    L136:
        r32 = true;
        goto L137
    L75:
        r110 = null;
        goto L76
    L60:
        this.a.getClass();
        if (r5 == 0) goto L65;
        if (r5 == 4) goto L65;
        boolean r34 = false;
    L66:
        if (r34 == false) goto L72;
        j r35 = com.bytedance.android.live.liveinteract.api.utils.m.e(this.a).J();
        if (r35 == null) goto L72;
        LivePlayModeLogContext r36 = (LivePlayModeLogContext) r35.getValue();
        if (r36 == null) goto L72;
        r36.removePlayMode(16);
    L65:
        r34 = true;
        goto L66
    L168:
        return;
    L35:
        if (r7.a() == false) goto L43;
        int r37 = MultiSceneEnterRoomStatisticsUtils.u;
        DataCenter r38 = ((Widget) this.a).dataCenter;
        IRoom r121 = a0.n(r38);
        if (r121 == null) goto L39;
        Long r122 = Long.valueOf(r121.getId());
    L40:
        MultiSceneEnterRoomStatisticsUtils r39 = MultiSceneEnterRoomStatisticsUtils.a.a(r38, Long.valueOf(r122.longValue()));
        if (r39 == null) goto L43;
        r39.j(null);
        goto L43
    L39:
        r122 = null;
        goto L40
    L18:
        if (r5 == 2) goto L27;
        if (r5 == 3) goto L26;
        if (r5 != 4) goto L22;
        r7 = new com.bytedance.android.live.liveinteract.revenue.linkroomfight.core.c.b.C0092b(r4);
        goto L29
    L22:
        if (r5 == 5) goto L24;
        r7 = com.bytedance.android.live.liveinteract.revenue.linkroomfight.core.c.b.C0093c.c;
        goto L29
    L24:
        r7 = new com.bytedance.android.live.liveinteract.revenue.linkroomfight.core.c.b.d(r4);
        goto L29
    L26:
        r7 = new com.bytedance.android.live.liveinteract.revenue.linkroomfight.core.c.b.e(r4);
        goto L29
    L27:
        r7 = new com.bytedance.android.live.liveinteract.revenue.linkroomfight.core.c.b.a(r4);
        goto L29
    L14:
        r5 = 0;
        goto L15
    L10:
        r2 = false;
        goto L11
    L167:
        return;
    L166:
        return;
    }
}
