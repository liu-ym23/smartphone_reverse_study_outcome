package com.bytedance.android.live.liveinteract.revenue.fight.dynamic;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.message.o2;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.revenue.fight.TeamFightContext;
import com.bytedance.android.live.liveinteract.revenue.fight.dynamic.oldteamfight.DynamicTeamFightViewManager;
import com.bytedance.android.live.liveinteract.revenue.fight.view.TeamFightPKProgressLayout;
import com.bytedance.android.live.liveinteract.utils.MultiSceneEnterRoomStatisticsUtils;
import com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService;
import com.bytedance.android.livesdk.chatroom.u;
import com.bytedance.android.livesdk.chatroom.viewmodel.LivePlayModeLogContext;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c implements ih0.g {
    public final /* synthetic */ DynamicTeamFightWidget a;

    public c(DynamicTeamFightWidget r1) {
        this.a = r1;
    }

    @Override // ih0.g
    public final void a(JsonObject r17) {
        ALogger.i("DynamicTeamFightWidget", "registBizStateChange, cacheBizData=" + r17);
        if (r17 == null) goto L198;
        String r2 = r17.get("key").getAsString();
        JsonElement r1 = r17.get("data");
        if (r2.equals("state") == false) goto L199;
        if (r1 == null) goto L200;
        JsonObject r3 = r1.getAsJsonObject();
        int r4 = r3.get("update_type").getAsInt();
        int r5 = r3.get("enter_from").getAsInt();
        JsonElement r6 = r3.get("cur_teamfight_info");
        if (r3.has("lynx_report_audience_room_watch") == false) goto L10;
        boolean r7 = r3.get("lynx_report_audience_room_watch").getAsBoolean();
    L11:
        com.bytedance.android.live.liveinteract.multiscene.a r8 = (com.bytedance.android.live.liveinteract.multiscene.a) GsonProtectorUtils.fromJson(GsonHelper.getLynxWorkaround(), r6, com.bytedance.android.live.liveinteract.multiscene.a.class);
        if (r8 == null) goto L14;
        int r9 = r8.getFightStatus();
    L15:
        DynamicTeamFightWidget r10 = this.a;
        TeamFightContext r11 = r10.a;
        if (r11 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("teamFightContext");
    L19:
        if (r10.wq(((Number) r11.getFightStatus().getValue()).intValue()) == false) goto L21;
    L29:
        DynamicTeamFightWidget r12 = this.a;
        r12.e = r8;
        TeamFightContext r13 = r12.a;
        if (r13 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("teamFightContext");
    L32:
        r13.getFightStatus().setValue(Integer.valueOf(r9));
        ALogger.i("DynamicTeamFightWidget", "registBizStateChange, mCurrentTeamFightInfo=" + this.a.e);
        if (r8 == null) goto L201;
        TeamFightContext r14 = this.a.a;
        if (r14 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("teamFightContext");
    L37:
        r14.getTeamFightInfo().setValue(r8);
        TeamFightContext r15 = TeamFightContext.Companion.getContext();
        if (r15 == null) goto L45;
        com.bytedance.live.datacontext.m<String> r16 = r15.getDressId();
        if (r16 == null) goto L45;
        String r18 = r8.getDressId();
        if (r18 != null) goto L44;
        r18 = "";
    L44:
        r16.setValue(r18);
    L45:
        int r19 = m.a;
        if (r4 != 0) goto L139;
        this.a.getClass();
        if (r9 == 0) goto L52;
        if (r9 == 4) goto L52;
        boolean r110 = false;
    L53:
        if (r110 == false) goto L59;
        com.bytedance.live.datacontext.j r111 = com.bytedance.android.live.liveinteract.api.utils.m.e(this.a).J();
        if (r111 == null) goto L64;
        LivePlayModeLogContext r112 = (LivePlayModeLogContext) r111.getValue();
        if (r112 == null) goto L64;
        r112.removePlayMode(7);
    L64:
        int r113 = r3.get("pre_status").getAsInt();
        JsonElement r20 = r3.get("finish_content");
        ALogger.i("DynamicTeamFightWidget", "registBizStateChange, finishContent=" + r20);
        DynamicTeamFightWidget r114 = this.a;
        if (r20 == null) goto L67;
        o2 r21 = (o2) GsonProtectorUtils.fromJson(GsonHelper.getLynxWorkaround(), r20, o2.class);
    L68:
        r114.h = r21;
        ALogger.i("DynamicTeamFightWidget", "registBizStateChange, currentFinishContent=" + this.a.h);
        DynamicTeamFightWidget r22 = this.a;
        r22.getClass();
        ALogger.i("DynamicTeamFightWidget", "registBizStateChange, preStatus=" + r113 + "；status=" + r9);
        if (r22.isAnchor() == false) goto L104;
        if (r113 == 0) goto L74;
        if (r113 == 4) goto L74;
        boolean r23 = false;
    L75:
        if (r23 == false) goto L96;
        if (r22.wq(r9) == false) goto L96;
        r22.i = System.currentTimeMillis();
        li0.b r24 = li0.b.b;
        com.bytedance.live.datacontext.m r25 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r25 == null) goto L94;
        IRoom r26 = (IRoom) r25.getValue();
        if (r26 == null) goto L94;
        if (r26.isLiveTypeAudio() != true) goto L94;
        IVoiceChatGuestService.Companion.getClass();
        IVoiceChatGuestService r27 = IVoiceChatGuestService.a.a();
        if (r27 == null) goto L88;
        com.bytedance.android.live.liveinteract.voicechat.util.k r28 = r27.getLogger();
        if (r28 == null) goto L88;
    L92:
        if (r28 == null) goto L139;
        com.bytedance.android.live.liveinteract.voicechat.util.k.l(r28, 7, null, 11);
    L88:
        com.bytedance.android.live.liveinteract.voicechat.d.s0.getClass();
        com.bytedance.android.live.liveinteract.voicechat.d r29 = com.bytedance.android.live.liveinteract.voicechat.d.a.a();
        if (r29 == null) goto L91;
        r28 = r29.getLogger();
        goto L92
    L91:
        r28 = null;
    L94:
        TalkRoomLogUtils.K(7, null, 11);
    L96:
        if (r22.wq(r113) == false) goto L139;
        if (r9 == 0) goto L101;
        if (r9 == 4) goto L101;
        boolean r30 = false;
    L102:
        if (r30 == false) goto L139;
        li0.b r31 = li0.b.b;
        r22.isAnchor();
        li0.b.e(r22.h);
    L101:
        r30 = true;
    L74:
        r23 = true;
        goto L75
    L104:
        if (r113 == 0) goto L108;
        if (r113 == 4) goto L108;
        boolean r32 = false;
    L109:
        if (r32 == false) goto L130;
        if (r22.wq(r9) == false) goto L130;
        r22.i = System.currentTimeMillis();
        li0.b r33 = li0.b.b;
        System.currentTimeMillis();
        LinkedHashMap r34 = new LinkedHashMap();
        r34.put("seat_fit_status", "off");
        li0.b.k(r34);
        com.bytedance.live.datacontext.m r35 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r35 == null) goto L128;
        IRoom r36 = (IRoom) r35.getValue();
        if (r36 == null) goto L128;
        if (r36.isLiveTypeAudio() != true) goto L128;
        IVoiceChatGuestService.Companion.getClass();
        IVoiceChatGuestService r37 = IVoiceChatGuestService.a.a();
        if (r37 == null) goto L122;
        com.bytedance.android.live.liveinteract.voicechat.util.k r38 = r37.getLogger();
        if (r38 == null) goto L122;
    L126:
        if (r38 == null) goto L139;
        com.bytedance.android.live.liveinteract.voicechat.util.k.u(r38, 7, r34, r7, 3);
    L122:
        com.bytedance.android.live.liveinteract.voicechat.d.s0.getClass();
        com.bytedance.android.live.liveinteract.voicechat.d r39 = com.bytedance.android.live.liveinteract.voicechat.d.a.a();
        if (r39 == null) goto L125;
        r38 = r39.getLogger();
        goto L126
    L125:
        r38 = null;
    L128:
        TalkRoomLogUtils.O(null, 7, r34, r7, 3);
    L130:
        if (r22.wq(r113) == false) goto L139;
        if (r9 == 0) goto L135;
        if (r9 == 4) goto L135;
        boolean r40 = false;
    L136:
        if (r40 == false) goto L139;
        li0.b.b.f();
    L135:
        r40 = true;
    L108:
        r32 = true;
        goto L109
    L67:
        r21 = null;
        goto L68
    L59:
        com.bytedance.live.datacontext.j r115 = com.bytedance.android.live.liveinteract.api.utils.m.e(this.a).J();
        if (r115 == null) goto L64;
        LivePlayModeLogContext r116 = (LivePlayModeLogContext) r115.getValue();
        if (r116 == null) goto L64;
        r116.addPlayMode(7);
    L52:
        r110 = true;
    L139:
        if (li0.d.g(r8) == false) goto L141;
        return;
    L141:
        if (r4 != 0) goto L179;
        int r41 = r3.get("pre_status").getAsInt();
        this.a.g = new com.bytedance.android.live.liveinteract.revenue.fight.dynamic.oldteamfight.e(r8, r5, r41, r9);
        DynamicTeamFightWidget r42 = this.a;
        com.bytedance.android.live.liveinteract.revenue.fight.dynamic.oldteamfight.d r43 = r42.f;
        if (r43 == null) goto L146;
        com.bytedance.android.live.liveinteract.revenue.fight.dynamic.oldteamfight.e r44 = r42.g;
        Intrinsics.checkNotNull(r44);
        r43.b(r44);
    L146:
        if (this.a.isAnchor() == false) goto L202;
        if (r9 == 0) goto L149;
        if (r9 == 4) goto L149;
        return;
    L149:
        o2 r45 = this.a.h;
        if (r45 != null) goto L152;
    L153:
        o2 r46 = this.a.h;
        if (r46 != null) goto L156;
        return;
    L156:
        if (r46.getFinishReason() != 3) goto L205;
    L157:
        u r47 = com.bytedance.android.live.liveinteract.api.utils.m.g(this.a.getRoomContext());
        int r48 = 12;
        if (r47 == null) goto L166;
        com.bytedance.live.datacontext.j r49 = r47.getVideoTalkRoomSubScene();
        if (r49 == null) goto L166;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r50 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r49.getValue();
        if (r50 == null) goto L166;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r51 = r50.b();
        if (r51 == null) goto L166;
        int r52 = r51.a;
    L167:
        if (r52 != 0) goto L170;
        r52 = 12;
    L170:
        if (r52 == 8) goto L172;
    L174:
        r48 = r52;
    L175:
        ALogger.e("DynamicTeamFightWidget", "switchSceneToPreviousState " + r48 + " reason=onFinishTeamFight ");
        rj0.k.m2.getClass();
        rj0.k r53 = rj0.k.a.a();
        if (r53 == null) goto L206;
        rj0.k.b.e(r53, r48, null, "onFinishTeamFight", 2);
        return;
    L206:
        return;
    L172:
        if (je0.d.S() <= 7) goto L174;
        ALogger.e("DynamicTeamFightWidget", "targetScene reset to equal since too much online users");
    L166:
        r52 = 12;
        goto L167
    L205:
        return;
    L152:
        if (r45.getFinishReason() == 5) goto L157;
    L202:
        return;
    L179:
        if (r4 == 1) goto L181;
        return;
    L181:
        if (this.a.Rh() == false) goto L184;
        ALogger.i("DynamicTeamFightWidget", "UpdateType_Score, isFightPunishing return");
        return;
    L184:
        com.bytedance.android.live.liveinteract.revenue.fight.dynamic.oldteamfight.e r54 = this.a.g;
        if (r54 == null) goto L187;
        Intrinsics.checkNotNullParameter(r8, "<set-?>");
        r54.a = r8;
    L187:
        DynamicTeamFightWidget r55 = this.a;
        com.bytedance.android.live.liveinteract.revenue.fight.dynamic.oldteamfight.e r56 = r55.g;
        if (r56 == null) goto L190;
        r56.b = r5;
    L190:
        if (r56 == null) goto L192;
        r56.d = r9;
    L192:
        com.bytedance.android.live.liveinteract.revenue.fight.dynamic.oldteamfight.d r57 = r55.f;
        if (r57 == null) goto L209;
        Intrinsics.checkNotNullParameter(r8, "teamFightInfo");
        DynamicTeamFightViewManager r58 = r57.a;
        if (r58 == null) goto L210;
        Intrinsics.checkNotNullParameter(r8, "teamFightInfo");
        TeamFightPKProgressLayout r59 = r58.e;
        int r60 = TeamFightPKProgressLayout.F;
        r59.j(r8, false);
        return;
    L210:
        return;
    L209:
        return;
    L201:
        return;
    L21:
        if (this.a.wq(r9) == false) goto L29;
        int r61 = MultiSceneEnterRoomStatisticsUtils.u;
        DynamicTeamFightWidget r62 = this.a;
        DataCenter r117 = ((Widget) r62).dataCenter;
        IRoom r63 = r62.getRoom();
        if (r63 == null) goto L25;
        Long r65 = Long.valueOf(r63.getId());
    L26:
        MultiSceneEnterRoomStatisticsUtils r66 = MultiSceneEnterRoomStatisticsUtils.a.a(r117, Long.valueOf(r65.longValue()));
        if (r66 == null) goto L29;
        r66.j(null);
        goto L29
    L25:
        r65 = null;
        goto L26
    L14:
        r9 = 0;
        goto L15
    L10:
        r7 = false;
        goto L11
    L200:
        return;
    L199:
        return;
    }
}
