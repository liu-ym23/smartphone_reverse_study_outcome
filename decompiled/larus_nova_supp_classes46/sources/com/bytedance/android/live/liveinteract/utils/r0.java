package com.bytedance.android.live.liveinteract.utils;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.revenue.adventure.AdventureContext;
import com.bytedance.android.live.liveinteract.revenue.battle.GuestBattleContext;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.android.livesdk.utils.u6;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.model.PlayModeLynxPanelConfig;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class r0 {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(Context r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "requestPage");
        AdventureContext.Companion.getClass();
        int r1 = 0;
        if (AdventureContext.a.a() == false) goto L6;
        f2.b(2131917300, 0);
        return;
    L6:
        u6 r0 = new u6("sslocal://webcast_lynxview?gravity=bottom&type=popup&width_percent=100&height_percent=60&url=");
        Long r4 = null;
        String r2 = ((PlayModeLynxPanelConfig) vm2.d.C5.getValue(null, vm2.d.a[338(0x152, float:4.74E-43)])).guestBattleOpenPanelUrl;
        if (r2 != null) goto L9;
        r2 = "https://lf-webcast-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/webcast/mono/lynx/social_play_mode_douyin/pages/guest_battle_open_panel/template.js";
    L9:
        r0.b("url", r2);
        u6 r3 = r0.d("url");
        r3.b("business_type", "guest_battle_panel");
        com.bytedance.live.datacontext.j r5 = com.bytedance.android.live.liveinteract.api.utils.m.d().getVideoTalkRoomSubScene();
        if (r5 == null) goto L18;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r6 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r5.getValue();
        if (r6 == null) goto L18;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r7 = r6.t();
        if (r7 == null) goto L18;
        if (r7.a != 8) goto L18;
        boolean r8 = true;
    L19:
        if (r8 == false) goto L21;
        int r9 = 7;
    L22:
        r3.b("seat_count", String.valueOf(r9));
        com.bytedance.live.datacontext.j r12 = com.bytedance.android.live.liveinteract.api.utils.m.d().getVideoTalkRoomSubScene();
        if (r12 == null) goto L31;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r13 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r12.getValue();
        if (r13 == null) goto L31;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r14 = r13.t();
        if (r14 == null) goto L31;
        if (r14.a != 8) goto L31;
        boolean r15 = true;
    L32:
        com.bytedance.live.datacontext.m r16 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        String r17 = "";
        if (r16 == null) goto L40;
        IRoom r18 = (IRoom) r16.getValue();
        if (r18 == null) goto L40;
        IBaseUser r19 = r18.getOwner();
        if (r19 == null) goto L40;
        Intrinsics.checkNotNullParameter(r19, "$this$secUidExt");
        String r20 = r19.getCastSecUid();
        if (r20 == null) goto L40;
    L41:
        r3.b("sec_owner_id", r20);
        String r21 = "0";
        if (r15 == false) goto L44;
        String r22 = "1";
    L45:
        r3.b("is_1v6layout", r22);
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r23 = ((IInteractService) jc1.k.n(IInteractService.class)).getLinkUserInfoCenter();
        if (r23 == null) goto L48;
        int r24 = r23.b();
    L49:
        r3.b("linked_users", String.valueOf(r24 + 1));
        r3.b("last_loser_num", String.valueOf(((Number) b6.i0.getValue()).intValue()));
        r3.b("last_anchor_involved", String.valueOf(((Boolean) b6.K.getValue()).booleanValue()));
        r3.b("last_battle_duration", String.valueOf(((Number) b6.M.getValue()).intValue()));
        GuestBattleContext.a r25 = GuestBattleContext.Companion;
        GuestBattleContext r26 = r25.getContext();
        if (r26 == null) goto L53;
        String r27 = String.valueOf(r26.getSelectScoreType());
        if (r27 == null) goto L53;
    L54:
        r3.b("last_score_type", r27);
        LocalTestManager.a(new Class[]{wy.a.class});
        r3.b("enable_debug", "false");
        if (r25.d() == false) goto L64;
        GuestBattleContext r28 = r25.getContext();
        if (r28 == null) goto L63;
        com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.chatroom.model.interact.a0> r29 = r28.getBattleInfo();
        if (r29 == null) goto L63;
        com.bytedance.android.livesdk.chatroom.model.interact.a0 r30 = (com.bytedance.android.livesdk.chatroom.model.interact.a0) r29.getValue();
        if (r30 == null) goto L63;
        r1 = r30.getBattleStatus();
    L63:
        String r31 = String.valueOf(r1);
    L65:
        r3.b("battle_state", r31);
        com.bytedance.live.datacontext.m r32 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r32 == null) goto L68;
        IRoom r33 = (IRoom) r32.getValue();
    L69:
        LinkedHashMap r34 = new LinkedHashMap();
        if (r33 == null) goto L72;
        r4 = Long.valueOf(r33.getId());
    L72:
        r34.put("room_id", String.valueOf(r4));
        if (r33 == null) goto L78;
        String r35 = r33.getOwnerUserIdString();
        if (r35 == null) goto L78;
        r17 = r35;
    L78:
        r34.put("anchor_id", r17);
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r36 = ((IInteractService) jc1.k.n(IInteractService.class)).getLinkUserInfoCenter();
        if (r36 == null) goto L84;
        String r37 = String.valueOf(r36.b());
        if (r37 == null) goto L84;
        r21 = r37;
    L84:
        r34.put("user_cnt", r21);
        r34.put("function_type", ((IInteractService) jc1.k.n(IInteractService.class)).getCurrentFunctionType());
        if (r33 != null) goto L87;
    L89:
        String r38 = "video_live";
    L90:
        r34.put("live_type", r38);
        Iterator r39 = r34.entrySet().iterator();
    L92:
        if (r39.hasNext() == false) goto L95;
        Map.Entry r40 = (Map.Entry) r39.next();
        r3.b((String) r40.getKey(), (String) r40.getValue());
        goto L92
    L95:
        if (TextUtils.isEmpty(r11) == true) goto L97;
        r3.b("request_page", r11);
    L97:
        jc1.k.n(IBaseLiveActionHandler.class).handle(r10, r0.c());
        return;
    L87:
        if (r33.isLiveTypeAudio() != true) goto L89;
        r38 = "voice_live";
        goto L90
    L68:
        r33 = null;
        goto L69
    L64:
        r31 = "0";
    L53:
        r27 = "0";
        goto L54
    L48:
        r24 = 0;
        goto L49
    L44:
        r22 = "0";
    L40:
        r20 = "";
    L31:
        r15 = false;
        goto L32
    L21:
        r9 = 9;
    L18:
        r8 = false;
        goto L19
    }
}
