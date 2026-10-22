package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import android.content.Context;
import com.bytedance.android.live.base.model.user.IUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService;
import com.bytedance.android.live.broadcastgame.api.toolbar.GameExitBehavior;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.live.core.utils.AnchorMainPostOptUtils;
import com.bytedance.android.livesdk.TTLiveSDKContext;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.utils.VSMediaUIConfigHelper;
import com.bytedance.android.livesdk.chatroom.utils.VrUtils;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.PortraitToolbarMoreBehavior;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.ToolbarGroupPurchaseAudienceBehavior;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.ToolbarGroupPurchaseWidgetBehavior;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.ToolbarLiteCommerceBehavior;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.ToolbarManageBehavior;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.ToolbarTransformWidgetBehavior;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.ToolbarVrModeBehavior;
import com.bytedance.android.livesdk.chatroom.viewmodule.welfare.ToolbarAudienceWelfareBehavior;
import com.bytedance.android.livesdk.config.ab1;
import com.bytedance.android.livesdk.config.bf1;
import com.bytedance.android.livesdk.config.e81;
import com.bytedance.android.livesdk.config.ea0;
import com.bytedance.android.livesdk.config.ez;
import com.bytedance.android.livesdk.config.h21;
import com.bytedance.android.livesdk.config.m50;
import com.bytedance.android.livesdk.config.nj1;
import com.bytedance.android.livesdk.config.ns0;
import com.bytedance.android.livesdk.config.og0;
import com.bytedance.android.livesdk.config.qi0;
import com.bytedance.android.livesdk.config.uj;
import com.bytedance.android.livesdk.config.vl0;
import com.bytedance.android.livesdk.config.x91;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.ChatChannelUtils;
import com.bytedance.android.livesdk.m6;
import com.bytedance.android.livesdk.message.model.TempStateAreaReachMessage;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.utils.n5;
import com.bytedance.android.livesdk.utils.r6;
import com.bytedance.android.livesdkapi.business.ILiveDouPlusService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomAuthStatus;
import com.bytedance.android.livesdkapi.model.ReportConfig;
import com.bytedance.android.livesdkapi.service.IHostCommerceServiceLive;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e3 implements com.bytedance.android.live.room.u {

    public static final class a implements com.bytedance.android.livesdk.service.k.b<com.bytedance.android.live.room.u> {
        public a() {
        }

        public final com.bytedance.android.livesdk.service.k.b.a<com.bytedance.android.live.room.u> setup(com.bytedance.android.livesdk.service.k.b.a<com.bytedance.android.live.room.u> r2) {
            r2.a = new e3();
            r2.b = true;
            return r2;
        }
    }

    public final /* synthetic */ void f() {
    }

    public e3() {
    }

    public static void g(List r2) {
        int r0 = r6.a;
        int r1 = ((Number) LiveInfraSettingKeys.LIVE_TOOLBAR_ORDER_STYLE.getValue()).intValue();
        if (r1 != 1) goto L5;
        h(r2, ToolbarButton.GIFT);
        i(r2, ToolbarButton.MORE);
        if (1 > (r2.size() - 1)) goto L13;
        Collections.reverse(r2.subList(1, r2.size() - 1));
        return;
    L13:
        return;
    L5:
        if (r1 != 2) goto L14;
        h(r2, ToolbarButton.MORE);
        i(r2, ToolbarButton.GIFT);
        return;
    }

    public static boolean k(DataCenter r3) {
        if (r3 != null) goto L5;
        return false;
    L5:
        if (TTLiveSDKContext.getHostService().h().isLogin() == false) goto L24;
        Room r4 = (Room) r3.get("data_room");
        if (r4 != null) goto L10;
        return false;
    L10:
        if (r4.getOwner() != null) goto L12;
        return false;
    L12:
        if (r4.getOwner().getSecret() != 1) goto L14;
        return false;
    L14:
        if (r4.getRoomAuthStatus() != null) goto L16;
    L17:
        return true;
    L16:
        if (r4.getRoomAuthStatus().isEnableDouPlus() == true) goto L17;
        return false;
    L24:
        return false;
    }

    public static void h(List r1, ToolbarButton r2) {
        if (r1.remove(r2) == false) goto L6;
        ListProtector.add(r1, 0, r2);
        return;
    }

    public static void i(List r1, ToolbarButton r2) {
        if (r1.remove(r2) == false) goto L6;
        ListProtector.add(r1, r1.size(), r2);
        return;
    }

    public static boolean j(Room r4, DataCenter r5) {
        if (r4 == null) goto L25;
        if (r5 == null) goto L29;
        Boolean r1 = Boolean.FALSE;
        if (((Boolean) r5.get("cmd_commerce_ad_show", r1)).booleanValue() == false) goto L10;
        return true;
    L10:
        if (r4.isHasCommerceGoods() == false) goto L12;
    L17:
        boolean r6 = true;
    L18:
        if (r6 == true) goto L20;
        return false;
    L20:
        if (((Boolean) r5.get("DATA_COMMERCE_COMPAT_AUDIENCE_BTN_ATTACH", r1)).booleanValue() == true) goto L22;
        return false;
    L22:
        if (((Integer) e81.e.getValue()).intValue() != 0) goto L28;
        return true;
    L28:
        return false;
    L12:
        if (r4.getBaseOwner() != null) goto L14;
    L16:
        r6 = false;
        goto L18
    L14:
        if (r4.getBaseOwner().isWithCommercePermission() == false) goto L16;
    L29:
        return false;
    L25:
        return false;
    }

    public final void a(DataCenter r4, List r5) {
        ArrayList r6 = (ArrayList) r5;
        r6.add(ToolbarButton.CAST_REFRESH);
        r6.add(ToolbarButton.CAST_FEED_BACK);
        r6.add(ToolbarButton.CHAT_CHANNEL_LANDSCAPE);
        r6.add(ToolbarButton.ROOM_CHANNEL_LANDSCAPE);
        r6.add(ToolbarButton.SWITCH_VIDEO_QUALITY);
        if (com.bytedance.android.livesdk.utils.landscape.d.c(r4) == true) goto L5;
        r6.add(ToolbarButton.BLOCK);
    L5:
        r6.add(ToolbarButton.RECORD_LANDSCAPE);
        r6.add(ToolbarButton.RECORD_COMBINE);
        Room r1 = (Room) r4.get("data_room");
        if (com.bytedance.android.livesdk.utils.landscape.d.c(r4) == true) goto L12;
        if (r1 == null) goto L12;
        if (r1.isMediaRoom() == false) goto L12;
        r6.add(ToolbarButton.BLOCK_MEDIA);
    L12:
        if (dm2.b.a.a() == false) goto L27;
        if (VrUtils.c(r4) == true) goto L19;
        int r2 = com.bytedance.android.livesdk.chatroom.utils.z1.a;
        if (((Boolean) m6.a.getValue()).booleanValue() == false) goto L19;
        r6.add(ToolbarButton.PAD_AND_PC_PLAY_LANDSCAPE);
    L22:
        if (com.bytedance.android.live.room.utils.b.a(r1) == false) goto L39;
        ToolbarButton r3 = ToolbarButton.SHARE;
        if (r6.contains(r3) == true) goto L39;
        r6.add(r3);
    L39:
        ArrayList r7 = new ArrayList();
        e(r4, r7);
        if (r7.size() <= 0) goto L42;
        r6.add(ToolbarButton.MORE);
    L44:
        if (com.bytedance.android.livesdk.utils.landscape.d.c(r4) == true) goto L52;
        IRoom r8 = (IRoom) r4.get("data_room", null);
        if (r8 == null) goto L48;
        boolean r9 = r8.isMediaRoom();
    L49:
        if (r9 == true) goto L53;
        r6.add(ToolbarButton.SWITCH_SCREEN_ORIENTATION);
        return;
    L53:
        return;
    L48:
        r9 = false;
        goto L49
    L52:
        return;
    L42:
        r6.add(ToolbarButton.AUDIENCE_RECORD);
    L19:
        if (VrUtils.c(r4) == true) goto L22;
        r6.add(ToolbarButton.GAME_CAST_SCREEN);
        goto L22
    L27:
        if (com.bytedance.android.live.room.utils.b.a(r1) == false) goto L32;
        ToolbarButton r10 = ToolbarButton.SHARE;
        if (r6.contains(r10) == true) goto L32;
        r6.add(r10);
    L32:
        if (VrUtils.c(r4) == true) goto L37;
        int r11 = com.bytedance.android.livesdk.chatroom.utils.z1.a;
        if (((Boolean) m6.a.getValue()).booleanValue() == false) goto L37;
        r6.add(ToolbarButton.PAD_AND_PC_PLAY_LANDSCAPE);
    L37:
        if (VrUtils.c(r4) == true) goto L39;
        r6.add(ToolbarButton.GAME_CAST_SCREEN);
        goto L39
    }

    public final void b(DataCenter r13, List<ToolbarButton> r14) {
        r14.clear();
        boolean r0 = ((Boolean) r13.get("data_is_anchor", Boolean.FALSE)).booleanValue();
        boolean r1 = ((Boolean) r13.get("data_is_portrait", Boolean.TRUE)).booleanValue();
        LiveMode r2 = (LiveMode) r13.get("data_live_mode");
        Room r3 = (Room) r13.get("data_room");
        if (r0 == false) goto L44;
        r14.add(ToolbarButton.LIVE_IM_ENTRANCE);
        if (r1 == true) goto L7;
        r14.add(ToolbarButton.BARRAGE);
    L7:
        if (r1 == false) goto L10;
        r14.add(ToolbarButton.COMMERCE);
        r14.add(ToolbarButton.LITTLE_GAME);
    L10:
        if (r2 != LiveMode.VIDEO) goto L20;
        r14.add(ToolbarButton.PK);
        if (qi0.a.getValue().booleanValue() == false) goto L15;
        r14.add(ToolbarButton.MULTI_SCENE_GAME_PLAY);
    L15:
        if (com.bytedance.android.livesdk.config.o3.a.getValue().booleanValue() == false) goto L17;
        r14.add(ToolbarButton.INTERACTION);
        r14.add(ToolbarButton.TEAM_FIGHT);
    L17:
        r14.add(ToolbarButton.AUDIO_TOGGLE);
        if (((Boolean) j40.n2.a.getValue()).booleanValue() == false) goto L20;
        r14.add(ToolbarButton.INTERACT_GAME);
    L20:
        if (r1 == true) goto L22;
    L24:
        if (r1 == false) goto L29;
        int r15 = ToolbarGroupPurchaseWidgetBehavior.l;
        if (ToolbarGroupPurchaseWidgetBehavior.a.a(r2) == false) goto L29;
        r14.add(ToolbarButton.GROUP_PURCHASE);
    L29:
        if (r2 != LiveMode.AUDIO) goto L37;
        if (vl0.a.getValue().booleanValue() == false) goto L33;
        r14.add(ToolbarButton.INTERACTION_SCENE);
        r14.add(ToolbarButton.TEAM_FIGHT);
        r14.add(ToolbarButton.INTERACTION);
    L33:
        r14.add(ToolbarButton.INTERACTION_ROOM);
        r14.add(ToolbarButton.AUDIO_TOGGLE);
        if (((Boolean) j40.n2.a.getValue()).booleanValue() == false) goto L37;
        r14.add(ToolbarButton.INTERACT_GAME);
    L37:
        if (r3.isScreenshot() == true) goto L41;
        if (r3.isThirdParty() == true) goto L41;
    L43:
        r14.add(ToolbarButton.MORE);
        r14.add(ToolbarButton.GIFT);
        r14.add(ToolbarButton.TICKET_SALE_ANCHOR);
        return;
    L41:
        if (ns0.a.getValue().booleanValue() == false) goto L43;
        r14.add(ToolbarButton.GAME_QUIZ);
        goto L43
    L22:
        if (com.bytedance.android.livesdk.chatroom.utils.k0.e(r2) == false) goto L24;
        r14.add(ToolbarButton.TRANSFORM_WIDGET);
        goto L24
    L44:
        if (r1 == false) goto L49;
        if (u40.a.a() == false) goto L49;
        r14.add(ToolbarButton.ROOM_CHANNEL);
    L49:
        if (VrUtils.c(r13) == false) goto L51;
        r14.add(ToolbarButton.VR_MODE);
    L51:
        if (r3 != null) goto L53;
    L55:
        if (r3 != null) goto L57;
    L61:
        boolean r4 = false;
        if (r3 == null) goto L65;
        if (r1 == false) goto L65;
        ListProtector.add(r14, 0, ToolbarButton.MULTI_CAMERA_LINKED_ROOM);
    L65:
        int r5 = com.bytedance.android.livesdk.config.setting.z.a;
        if (nj1.a.getValue().f() == false) goto L71;
        if (r3 == null) goto L71;
        if (r3.isMergeVSRoom() == false) goto L71;
        r14.add(ToolbarButton.VS_ACTIVITY_ONE);
    L71:
        SettingKey<Boolean> r6 = h21.a;
        if (((Boolean) r6.getValue()).booleanValue() == false) goto L74;
        r14.add(ToolbarButton.SHARE);
    L74:
        ToolbarButton r7 = ToolbarButton.LITTLE_GAME;
        r14.add(r7);
        r14.add(ToolbarButton.GAME_GUESS);
        ToolbarButton r8 = ToolbarButton.GAME_PROMOTE_AUDIENCE;
        r14.add(r8);
        if (r1 == true) goto L114;
        if (m50.a.getValue().a() == true) goto L79;
    L83:
        if (r3 == null) goto L87;
        if (r3.isMergeVSRoom() == false) goto L87;
    L88:
        r14.clear();
        r14.add(ToolbarButton.MULTI_CAMERA_LINKED_ROOM);
        r14.add(ToolbarButton.SWITCH_VIDEO_QUALITY);
        r14.add(ToolbarButton.LANDSCAPE_MULTI_TAB);
        r14.add(ToolbarButton.VS_SELECT_EPISODE.setPureText(true));
        r14.add(ToolbarButton.VS_MESSAGE_BOARD);
        r14.add(ToolbarButton.VS_ACTIVITY_ONE);
        r14.add(ToolbarButton.COMMERCE_LIVE_AD);
        r14.add(r8);
        r14.add(ToolbarButton.WELFARE);
        if (j(r3, r13) == true) goto L91;
        r14.add(ToolbarButton.FAST_GIFT);
    L91:
        r14.add(ToolbarButton.GIFT);
        return;
    L87:
        if (VSMediaUIConfigHelper.b(r13) == true) goto L88;
        r14.add(ToolbarButton.MULTI_CAMERA_LINKED_ROOM.setPureText(true));
        LiveMode r9 = LiveMode.THIRD_PARTY;
        if (r2 != r9) goto L96;
        r14.add(ToolbarButton.INTERACTION);
    L96:
        r14.add(ToolbarButton.LIVE_IM_ENTRANCE);
        if (r14.remove(r8) == false) goto L100;
        r14.add(r8);
    L100:
        if (r14.remove(r7) == false) goto L102;
        r14.add(r7);
    L102:
        r14.add(ToolbarButton.COMMERCE_LIVE_AD);
        r14.add(ToolbarButton.COMMERCE);
        r14.add(ToolbarButton.WELFARE);
        r14.add(ToolbarButton.EASTER_EGG);
        if (j(r3, r13) == true) goto L109;
        r14.add(ToolbarButton.FAST_GIFT);
        boolean r16 = com.bytedance.android.live.incentive.exchange.j.a();
        if (r3.isMediaRoom() == true) goto L109;
        if (r16 == false) goto L109;
        r14.add(ToolbarButton.CASH_EXCHANGE);
        r14.add(ToolbarButton.COUPON_EXCHANGE);
    L109:
        if (r2 == LiveMode.SCREEN_RECORD) goto L111;
        if (r2 == r9) goto L111;
    L112:
        r14.add(ToolbarButton.GIFT);
        return;
    L111:
        r14.add(ToolbarButton.AIRDROP_GIFT);
        goto L112
    L79:
        if (r3.isMediaRoom() == true) goto L83;
        if (r3.isMergeVSRoom() == true) goto L83;
        r14.add(ToolbarButton.SWITCH_VIDEO_QUALITY);
        goto L83
    L114:
        if (r3.isMediaRoom() == true) goto L116;
    L133:
        ToolbarButton r10 = ToolbarButton.MORE;
        r14.add(r10);
        boolean r11 = tb1.c.a;
        if (r11 == false) goto L139;
        if (r3.isMergeVSRoom() == false) goto L139;
        ListProtector.add(r14, 0, ToolbarButton.QUICK_SCREEN_SHOT);
    L139:
        if (r14.contains(r10) == false) goto L141;
    L143:
        LiveMode r12 = LiveMode.AUDIO;
        if (r2 != r12) goto L147;
        r14.add(ToolbarButton.INTERACTION_AUDIENCE);
    L152:
        r14.add(ToolbarButton.LIVE_IM_ENTRANCE);
        if (r2 == LiveMode.VIDEO) goto L155;
        if (r2 == r12) goto L155;
    L157:
        if (yt2.b.a().booleanValue() == false) goto L159;
        r14.add(ToolbarButton.WELFARE);
    L159:
        int r17 = qu2.a.a;
        r14.add(ToolbarButton.TICKET_SALE);
        if (r14.remove(r8) == false) goto L163;
        r14.add(r8);
    L163:
        if (r14.remove(r7) == false) goto L165;
        r14.add(r7);
    L165:
        if (r11 == false) goto L167;
        r14.add(ToolbarButton.OPEN_PLATFORM_LYNX_GAME);
        r14.add(ToolbarButton.OPEN_PLATFORM_GAME);
        r14.add(ToolbarButton.OPEN_PLATFORM_MINI_APP);
        r14.add(ToolbarButton.OPEN_PLATFORM_MINI_GAME);
    L167:
        r14.add(ToolbarButton.COMMERCE);
        r14.add(ToolbarButton.COMMERCE_LIVE_AD);
        r14.add(ToolbarButton.GROUP_PURCHASE_AUDIENCE);
        r14.add(ToolbarButton.EASTER_EGG);
        if (r3.isScreenshot() == true) goto L172;
        if (r3.isThirdParty() == true) goto L172;
    L175:
        if (j(r3, r13) == true) goto L181;
        r14.add(ToolbarButton.FAST_GIFT);
        boolean r18 = com.bytedance.android.live.incentive.exchange.j.a();
        if (r3.isMediaRoom() == true) goto L181;
        if (r18 == false) goto L181;
        r14.add(ToolbarButton.CASH_EXCHANGE);
        r14.add(ToolbarButton.COUPON_EXCHANGE);
    L181:
        if (r2 != LiveMode.THIRD_PARTY) goto L183;
    L184:
        r14.add(ToolbarButton.AIRDROP_GIFT);
    L185:
        r14.add(ToolbarButton.GIFT);
        if (r11 == false) goto L189;
        r14.add(ToolbarButton.SWITCH_SCREEN_ORIENTATION);
    L189:
        if (((Integer) LiveInfraSettingKeys.BOTTOM_RIGHT_OVAL_FOLLOW_STYLE.getValue()).intValue() != 2) goto L191;
        r4 = true;
    L191:
        if (r4 == true) goto L193;
        h(r14, r10);
    L198:
        if (u40.a.a() == false) goto L200;
        h(r14, ToolbarButton.ROOM_CHANNEL);
    L200:
        g(r14);
        return;
    L193:
        if (((Boolean) r6.getValue()).booleanValue() == false) goto L195;
        i(r14, ToolbarButton.SHARE);
    L195:
        i(r14, r10);
        goto L198
    L183:
        if (r2 != LiveMode.SCREEN_RECORD) goto L185;
    L172:
        if (ns0.a.getValue().booleanValue() == false) goto L175;
        r14.add(ToolbarButton.GAME_QUIZ);
    L155:
        r14.add(ToolbarButton.AUDIO_TOGGLE);
        goto L157
    L147:
        if (r2 != LiveMode.VIDEO) goto L150;
        r14.add(ToolbarButton.INTERACTION);
        goto L152
    L150:
        if (r2 != LiveMode.THIRD_PARTY) goto L152;
        r14.add(ToolbarButton.INTERACTION);
        goto L152
    L141:
        if (com.bytedance.android.livesdk.chatroom.record.u.f(false, r3) == false) goto L143;
        r14.add(r10);
        goto L143
    L116:
        if (VSMediaUIConfigHelper.b(r13) == true) goto L133;
        r14.add(ToolbarButton.LIVE_IM_ENTRANCE);
        ToolbarButton r19 = ToolbarButton.MORE;
        r14.add(r19);
        if (yt2.b.a().booleanValue() == false) goto L120;
        r14.add(ToolbarButton.WELFARE);
    L120:
        int r20 = qu2.a.a;
        r14.add(ToolbarButton.TICKET_SALE);
        r14.add(ToolbarButton.COMMERCE);
        r14.add(ToolbarButton.OPEN_PLATFORM_MINI_APP);
        r14.add(ToolbarButton.COMMERCE_LIVE_AD);
        r14.add(ToolbarButton.GROUP_PURCHASE_AUDIENCE);
        r14.add(ToolbarButton.FAST_GIFT);
        r14.add(ToolbarButton.GIFT);
        if (((Integer) LiveInfraSettingKeys.BOTTOM_RIGHT_OVAL_FOLLOW_STYLE.getValue()).intValue() != 2) goto L123;
        r4 = true;
    L123:
        if (r4 == true) goto L125;
        h(r14, r19);
    L130:
        if (u40.a.a() == false) goto L132;
        h(r14, ToolbarButton.ROOM_CHANNEL);
    L132:
        g(r14);
        return;
    L125:
        if (((Boolean) r6.getValue()).booleanValue() == false) goto L127;
        i(r14, ToolbarButton.SHARE);
    L127:
        i(r14, r19);
        goto L130
    L57:
        if (r3.isMergeVSRoom() == false) goto L61;
        if (PadConfigUtils.c() == false) goto L61;
        r14.add(ToolbarButton.LANDSCAPE_MULTI_TAB);
        goto L61
    L53:
        if (r3.isMergeVSRoom() == false) goto L55;
        r14.add(ToolbarButton.VS_MESSAGE_BOARD);
        goto L55
    }

    public final void c(List<ExtendedToolbarButton> r3, boolean r4) {
        if (ea0.a.getValue().booleanValue() == false) goto L10;
        if (r4 == true) goto L6;
        return;
    L6:
        if (((Integer) e81.e.getValue()).intValue() != 2) goto L8;
        ExtendedToolbarButton r5 = ToolbarButton.INTERACTION_MORE.extended();
        r5.a = TempStateAreaReachMessage.ELEM_TYPE.INTERACTION_MORE.getType();
        ((ArrayList) r3).add(r5);
    L8:
        ExtendedToolbarButton r6 = ToolbarButton.KTV_GROUP.extended();
        r6.a = TempStateAreaReachMessage.ELEM_TYPE.KTV_GROUP.getType();
        ((ArrayList) r3).add(r6);
        return;
    }

    public final List<Runnable> d(final DataCenter r17, final Context r18) {
        ArrayList r10 = new ArrayList();
        final boolean r5 = ((Boolean) r17.get("data_is_anchor", Boolean.FALSE)).booleanValue();
        final boolean r7 = jc1.k.f(ILiveDouPlusService.class).isNeedDouPlusEntry();
        s22.f r11 = null;
        final Room r6 = (Room) r17.get("data_room", null);
        ab1 r0 = x91.a.getValue();
        final c0 r12 = y3.m(r17);
        if (r5 == false) goto L6;
        ToolbarButton r1 = ToolbarButton.BROADCAST_EFFECT;
        r12.k(r1, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.utils.b.a(r1));
    L6:
        if (k60.b.a() == false) goto L23;
        if (r6 == null) goto L12;
        if (u40.a.b() == true) goto L12;
        r10.add(new y2(r12, r18, r17));
    L12:
        if (com.bytedance.android.livesdk.config.setting.s.b() == true) goto L15;
        r10.add(new z2(this, r12, r18));
    L15:
        Iterator r2 = r10.iterator();
    L17:
        if (r2.hasNext() == false) goto L31;
        Runnable r3 = (Runnable) r2.next();
        if (k60.b.c() == true) goto L20;
        com.bytedance.android.live.core.utils.i0.i(c50.b.b(r17), r3);
        goto L17
    L20:
        com.bytedance.android.live.core.utils.i0.f(r3);
    L31:
        if (r5 == true) goto L33;
    L35:
        boolean r4 = false;
    L36:
        if (r4 == true) goto L38;
        r12.k(ToolbarButton.CLOSE_ROOM, new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.r2());
    L38:
        final LiveMode r8 = (LiveMode) r17.get("data_live_mode");
        if (com.bytedance.android.livesdk.config.setting.s.b() == false) goto L41;
    L46:
        int r9 = qu2.a.a;
        if (com.bytedance.android.livesdk.config.setting.s.b() == true) goto L52;
        if (jc1.k.f(lu2.f.class) == null) goto L52;
        r12.k(ToolbarButton.TICKET_SALE, jc1.k.f(lu2.f.class).toolbarBehaviorProvider().a(r18, r17));
    L52:
        if (tb1.c.c == false) goto L60;
        IHostCommerceServiceLive r13 = TTLiveSDKContext.getHostService().c();
        if (r13 != null) goto L56;
        boolean r14 = false;
    L57:
        if (r14 == true) goto L60;
        r12.k(ToolbarButton.COMMERCE, new ToolbarLiteCommerceBehavior());
        goto L60
    L56:
        r14 = r13.enableFullLiveCommerce();
    L60:
        if (yt2.b.a().booleanValue() == false) goto L66;
        if (r5 == true) goto L66;
        if (com.bytedance.android.livesdk.config.setting.s.b() == true) goto L66;
        r12.p(ToolbarButton.WELFARE.extended(), new ToolbarAudienceWelfareBehavior());
    L66:
        if (((Boolean) j40.n2.a.getValue()).booleanValue() == false) goto L68;
        AnchorMainPostOptUtils.b("InteractGameBehavior", new c3(r18, r17, r12));
    L68:
        r12.p(ToolbarButton.GAME_EXIT.extended(), new GameExitBehavior(r17));
        r12.k(ToolbarButton.DOUYIN_CLOSE, new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.x2());
        r12.k(ToolbarButton.DOUYIN_OFFICIAL_EFFECT, new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.y2());
        r12.k(ToolbarButton.MANAGE_UNFOLD, new ToolbarManageBehavior(false));
        ((Boolean) r17.get("data_is_portrait", Boolean.TRUE)).booleanValue();
        RoomContext r15 = RoomContext.getShared(r17);
        final g3 r16 = y3.f(r17);
        if (k60.b.a() == false) goto L75;
        Runnable r19 = new a3(r5, r16);
        r10.add(r19);
        if (k60.b.c() == false) goto L73;
        com.bytedance.android.live.core.utils.i0.f(r19);
    L81:
        if (((Boolean) com.bytedance.android.live.core.setting.x3.a.getValue()).booleanValue() == false) goto L91;
        if (r5 == false) goto L91;
        if (r6 == null) goto L91;
        if (r6.getExtra() == null) goto L91;
        if (r6.isPrivatePlay() != true) goto L91;
        if (r6.getExtra().isGroupLiveScene() != true) goto L91;
        r12.k(ToolbarButton.COMMENT, new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.s2());
    L91:
        new b3(this, r17, r16, r18, r5, r6, r7, r8).run();
        if (VrUtils.c(r17) == true) goto L94;
    L98:
        s22.e r20 = ChatChannelUtils.b(r15);
        if (r20 == null) goto L101;
        r11 = r20.getToolbarManager();
    L101:
        if (r11 != null) goto L103;
    L105:
        return r10;
    L103:
        if (r11.a() == false) goto L105;
        r11.c();
        goto L105
    L94:
        if (VrUtils.z(r17) == false) goto L98;
        if (u40.a.b() == true) goto L98;
        r12.k(ToolbarButton.VR_MODE, new ToolbarVrModeBehavior(r17));
        goto L98
    L73:
        com.bytedance.android.live.core.utils.i0.i(c50.b.b(r17), r19);
        goto L81
    L75:
        if (jc1.k.f(IInteractGameService.class) == null) goto L81;
        if (r5 == true) goto L81;
        c0.b r21 = (c0.b) jc1.k.f(IInteractGameService.class).createOpenToolbarEntBehavior();
        if (r21 == null) goto L81;
        r16.p(ToolbarButton.OPEN_PLATFORM_LYNX_GAME.extended(), r21);
        goto L81
    L41:
        if (com.bytedance.android.livesdk.chatroom.utils.k0.e(r8) == false) goto L43;
        r12.k(ToolbarButton.TRANSFORM_WIDGET, new ToolbarTransformWidgetBehavior(r18, false, r17));
    L43:
        int r22 = ToolbarGroupPurchaseWidgetBehavior.l;
        if (ToolbarGroupPurchaseWidgetBehavior.a.a(r8) == false) goto L46;
        r12.p(ToolbarButton.GROUP_PURCHASE.extended(), new ToolbarGroupPurchaseWidgetBehavior(false));
        goto L46
    L33:
        if (((Boolean) g81.a.a.getValue()).booleanValue() == false) goto L35;
        r4 = true;
        goto L36
    L23:
        if (r6 == null) goto L28;
        if (u40.a.b() == true) goto L28;
        r12.k(ToolbarButton.MORE, new PortraitToolbarMoreBehavior(r18, r17));
    L28:
        if (com.bytedance.android.livesdk.config.setting.s.b() == true) goto L31;
        r12.k(ToolbarButton.GROUP_PURCHASE_AUDIENCE, new ToolbarGroupPurchaseAudienceBehavior(r18));
        goto L31
    }

    public final void e(DataCenter r11, List<ToolbarButton> r12) {
        r12.clear();
        Room r1 = (Room) r11.get("data_room");
        Boolean r2 = Boolean.FALSE;
        boolean r6 = true;
        if (((Boolean) r11.get("data_is_anchor", r2)).booleanValue() == false) goto L99;
        LiveMode r3 = (LiveMode) r11.get("data_live_mode");
        Room r0 = (Room) r11.get("data_room");
        EnumSet r4 = EnumSet.noneOf(ToolbarButton.class);
        LiveMode r5 = LiveMode.AUDIO;
        if (r3 != r5) goto L7;
        r4.add(ToolbarButton.CLEAR_SCREEN);
    L7:
        r4.add(ToolbarButton.DECORATION);
        r4.add(ToolbarButton.MANAGE);
        if (r3 == r5) goto L19;
        if (r3 == null) goto L14;
        if (r3.isUsingCamera() == false) goto L14;
        r4.add(ToolbarButton.BEAUTY);
        r4.add(ToolbarButton.FILTER);
        r4.add(ToolbarButton.STICKER_NEW);
        r4.add(ToolbarButton.GESTURE_MAGIC);
        r4.add(ToolbarButton.REVERSE_CAMERA);
        r4.add(ToolbarButton.REVERSE_MIRROR);
    L14:
        if (r3 != LiveMode.THIRD_PARTY) goto L17;
        r4.add(ToolbarButton.PUSH_URL);
    L17:
        if (r3 != LiveMode.SCREEN_RECORD) goto L19;
        r4.add(ToolbarButton.MESSAGE_PUSH);
    L19:
        boolean r7 = ((Boolean) r11.get("data_is_portrait")).booleanValue();
        LiveMode r8 = LiveMode.VIDEO;
        if (r3 != r8) goto L22;
    L23:
        if (r7 == false) goto L25;
        boolean r9 = true;
    L26:
        if (r3 != r5) goto L28;
        boolean r10 = true;
    L29:
        if (r9 == true) goto L31;
        if (r10 == true) goto L31;
    L32:
        ReportConfig r13 = bf1.a.getValue();
        if (r13 != null) goto L35;
    L38:
        boolean r14 = true;
    L39:
        if (r14 == false) goto L42;
        r4.add(ToolbarButton.REPORT);
    L42:
        if (com.bytedance.android.livesdk.utils.j.c() == false) goto L44;
        r4.add(ToolbarButton.ANCHOR_BACKTRACK);
    L44:
        if (r0 == null) goto L48;
        if (r0.isDouPlusPromotion == false) goto L48;
    L49:
        boolean r15 = true;
    L51:
        if (r15 == false) goto L54;
        r4.add(ToolbarButton.DOU_PLUS_PROMOTE);
    L54:
        if (n5.a(r11) == false) goto L57;
        r4.add(ToolbarButton.REN_QI_BAO);
    L57:
        if (com.bytedance.android.livesdk.config.q0.a.getValue().booleanValue() == false) goto L59;
        r4.add(ToolbarButton.BROADCAST_TASK);
    L59:
        uj r16 = uj.a;
        if (r16.getValue() != null) goto L62;
    L64:
        boolean r17 = false;
    L65:
        if (r17 == false) goto L67;
        r4.add(ToolbarButton.HASH_TAG);
    L67:
        com.bytedance.android.livesdk.user.f r18 = (com.bytedance.android.livesdk.user.f) r11.get("data_user_center", null);
        if (r18 == null) goto L83;
        IUser r19 = r18.b();
        if ((r19 instanceof User) == false) goto L83;
        RoomAuthStatus r20 = r0.getRoomAuthStatus();
        int r21 = au2.a.a;
        if (r20 != null) goto L74;
        boolean r22 = false;
    L75:
        if (r22 == false) goto L83;
        if (r19.getPoiInfo() == null) goto L83;
        if (r19.getPoiInfo().isPoiPermission() == false) goto L83;
        if (r19.getSecret() == 1) goto L83;
        boolean r110 = true;
    L84:
        if (r110 == false) goto L87;
        if (r3 != r8) goto L87;
        r4.add(ToolbarButton.POI);
    L87:
        r4.add(ToolbarButton.BROADCAST_PAUSE);
        if (com.bytedance.android.livesdk.utils.m3.a(r3) == false) goto L90;
    L91:
        r4.add(ToolbarButton.BROADCAST_RESTART);
    L93:
        if (r3 != LiveMode.SCREEN_RECORD) goto L95;
        r4.add(ToolbarButton.QUESTION_AND_ANSWER);
    L95:
        if (r3 == r8) goto L97;
    L159:
        if (r1 != null) goto L161;
    L171:
        r6 = false;
    L172:
        if (r6 == true) goto L175;
        r4.add(ToolbarButton.SHARE);
    L175:
        if (((Boolean) r52.c0.a.getValue()).booleanValue() == false) goto L180;
        if (r1 == null) goto L180;
        if (r1.isMediaRoom() == true) goto L180;
        r4.add(ToolbarButton.BARRAGE_SETTING);
    L180:
        r4.add(ToolbarButton.VS_INTERACTIVE);
        r12.addAll(r4);
        return;
    L161:
        if (r1.getOwner() == null) goto L171;
        if (r1.getOwner().getSecret() == 1) goto L172;
        if (r1.getRoomAuthStatus() == null) goto L171;
        if (r1.getRoomAuthStatus().getShowShare() != 2) goto L171;
    L97:
        if (tb1.c.a == false) goto L159;
        r4.add(ToolbarButton.ADVANCE_ANNOUNCEMENT);
        goto L159
    L90:
        if (com.bytedance.android.livesdk.utils.m3.b(r3) == false) goto L93;
    L74:
        r22 = r20.getEnablePoi();
    L83:
        r110 = false;
        goto L84
    L62:
        if (r16.getValue().showChallenge == false) goto L64;
        r17 = true;
    L48:
        if (com.bytedance.android.livesdk.utils.c1.a(r11).hasDouPlusEntry == true) goto L49;
        r15 = false;
        goto L51
    L35:
        if (r13.enableMore == true) goto L38;
        r14 = false;
    L31:
        r4.add(ToolbarButton.RECORD);
        r4.add(ToolbarButton.RECORD_COMBINE);
        goto L32
    L28:
        r10 = false;
    L25:
        r9 = false;
        goto L26
    L22:
        if (r3 != LiveMode.THIRD_PARTY) goto L25;
    L99:
        Room r23 = (Room) r11.get("data_room");
        LiveMode r24 = (LiveMode) r11.get("data_live_mode");
        r4 = EnumSet.noneOf(ToolbarButton.class);
        boolean r25 = ((Boolean) r11.get("data_is_portrait", r2)).booleanValue();
        boolean r26 = jc1.k.f(ILiveDouPlusService.class).isNeedDouPlusEntry();
        if (r25 == false) goto L102;
        int r27 = com.bytedance.android.livesdk.config.setting.t.a;
    L102:
        if (r25 == false) goto L104;
        ToolbarButton r28 = ToolbarButton.GIFT_EFFECT;
        r4.add(r28);
        r4.add(r28);
        r4.add(ToolbarButton.CLEAR_SCREEN);
        r4.add(ToolbarButton.GAME_PROMOTE_AUDIENCE_MORE);
        if (com.bytedance.android.livesdk.chatroom.record.u.f(false, r23) == false) goto L120;
        r4.add(ToolbarButton.RECORD);
        r4.add(ToolbarButton.RECORD_COMBINE);
    L120:
        if (com.bytedance.android.livesdk.chatroom.record.u.e(false, r23) == false) goto L123;
        r4.add(ToolbarButton.AUDIENCE_RECORD);
    L123:
        if (k(r11) == false) goto L127;
        if (r26 == false) goto L127;
        r4.add(ToolbarButton.DOU_PLUS_PROMOTE_AUDIENCE);
    L127:
        if (n5.b(r11) == false) goto L132;
        if (TTLiveSDKContext.getHostService().h().isLogin() == false) goto L132;
        r4.add(ToolbarButton.REN_QI_BAO);
    L132:
        if (yx1.a.b(r23) == false) goto L134;
        r4.add(ToolbarButton.PREDICTOR_GUESS);
    L134:
        ReportConfig r111 = bf1.a.getValue();
        if (r111 != null) goto L137;
    L140:
        boolean r112 = true;
    L141:
        if (r112 == false) goto L144;
        r4.add(ToolbarButton.REPORT);
    L144:
        if (ez.a.getValue().booleanValue() == false) goto L152;
        if (r23 == null) goto L152;
        if (r23.getMRoomAuthStatus() == null) goto L152;
        if (r23.getMRoomAuthStatus().getEnableGift() == false) goto L152;
        r4.add(ToolbarButton.PLAY_SETTING);
    L152:
        if (((Integer) e81.e.getValue()).intValue() == 2) goto L154;
    L156:
        r4.add(ToolbarButton.AUDIENCE_RESOLUTION);
        r4.add(ToolbarButton.IN_ROOM_RESOLUTION);
        r4.add(ToolbarButton.MESSAGE_BOX);
        int r113 = com.bytedance.android.livesdk.config.setting.t.a;
        if (com.bytedance.android.livesdk.model.b.c() == false) goto L159;
        r4.add(ToolbarButton.LIKE_FEEDBACK);
        goto L159
    L154:
        if (ea0.a.getValue().booleanValue() == true) goto L156;
        r4.add(ToolbarButton.INTERACTION_MORE);
        goto L156
    L137:
        if (r111.enableMore == true) goto L140;
        r112 = false;
        goto L141
    L104:
        if (com.bytedance.android.livesdk.chatroom.record.u.e(false, r23) == false) goto L109;
        if (kh1.a.a.e(r25, r23) == true) goto L109;
        r4.add(ToolbarButton.AUDIENCE_RECORD);
    L109:
        if (yx1.a.b(r23) == false) goto L112;
        r4.add(ToolbarButton.PREDICTOR_GUESS);
    L112:
        if (og0.a.getValue().booleanValue() == false) goto L159;
        if (VrUtils.t(r11, false) == true) goto L159;
        r4.add(ToolbarButton.LIVE_PICTURE_TYPE);
        goto L159
    }
}
