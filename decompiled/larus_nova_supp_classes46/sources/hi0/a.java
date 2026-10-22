package hi0;

import android.content.Context;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.live.liveinteract.interactivesong.impl.InteractiveSongContext;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.revenue.battle.GuestBattleContext;
import com.bytedance.android.live.liveinteract.revenue.fight.TeamFightContext;
import com.bytedance.android.live.liveinteract.revenue.linkroomfight.core.LinkRoomFightContext;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.livesdk.chatroom.model.interact.a0;
import com.bytedance.android.livesdk.chatroom.viewmodel.e;
import com.bytedance.android.livesdk.chatroom.y0;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.j;
import ih0.b;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import li0.c;
import vm2.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    public static final a a = null;

    public a() {
    }

    static {
        a = new a();
    }

    public final void b(Context r9, DataCenter r10, ILinkPlayerInfoBridge r11, IRoom r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r11, "userInfo");
        Intrinsics.checkNotNullParameter(r12, PbRequest.SwitchType.ROOM);
        IBaseUser r4 = r11.getUser();
        Intrinsics.checkNotNull(r4);
        c(this, r9, r10, r4, r12, r13, 32);
    }

    public static void a(Context r10, DataCenter r11, IBaseUser r12, IRoom r13, boolean r14, Map r15) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r12, "user");
        Intrinsics.checkNotNullParameter(r13, PbRequest.SwitchType.ROOM);
        Intrinsics.checkNotNullParameter(r15, "pkParams");
        String r0 = (String) d.l5.getValue(null, d.a[321(0x141, float:4.5E-43)]);
        LinkedHashMap r1 = new LinkedHashMap();
        boolean r3 = Intrinsics.areEqual(r12.getIdString(), r13.getOwnerUserIdString());
        if (r15.isEmpty() == true) goto L5;
        r1.putAll(r15);
    L5:
        r1.put("anchor_id", r13.getOwnerUserIdString());
        IBaseUser r16 = r13.getOwner();
        String r5 = "";
        if (r16 == null) goto L9;
        Intrinsics.checkNotNullParameter(r16, "$this$secUidExt");
        String r17 = r16.getCastSecUid();
        if (r17 == null) goto L9;
    L10:
        r1.put("sec_anchor_id", r17);
        r1.put("linker_user_id", r12.getIdString());
        r1.put("linker_nickname", r12.getNickName());
        Intrinsics.checkNotNullParameter(r12, "$this$secUidExt");
        String r18 = r12.getCastSecUid();
        if (r18 == null) goto L14;
        r5 = r18;
    L14:
        r1.put("sec_linker_user_id", r5);
        if (r13.isLiveTypeAudio() == false) goto L17;
        String r19 = "voice_live";
    L18:
        r1.put("live_type", r19);
        TalkRoomLogUtils.B0(r1, Integer.valueOf(je0.d.f()), null, 4);
        j r110 = m.d().getVideoTalkRoomSubScene();
        boolean r111 = false;
        if (r110 == null) goto L32;
        e r112 = (e) r110.getValue();
        if (r112 == null) goto L32;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r113 = r112.t();
        if (r113 == null) goto L32;
        List r114 = r113.b;
        if (r114 == null) goto L32;
        if (r114.contains(1) == true) goto L30;
        r114 = null;
    L30:
        if (r114 == null) goto L32;
        boolean r115 = true;
    L33:
        String r6 = "0";
        if (r115 == false) goto L36;
        Object r116 = "1";
    L37:
        r1.put("video_friend_room", r116);
        IInteractService r117 = (IInteractService) k.f(IInteractService.class);
        if (r117 == null) goto L44;
        b r118 = r117.dynamicService(r11);
        if (r118 == null) goto L44;
        if (r118.jl("star_wish") != true) goto L44;
        r1.put("linker_battle_mode", "4");
        r1.put("user_cnt", String.valueOf(je0.d.S()));
    L102:
        if (TeamFightContext.Companion.h() == false) goto L104;
    L105:
        r1.put("win_crown_icon", c.c());
        r1.put("loser_crown_icon", c.a());
        com.bytedance.android.live.liveinteract.revenue.linkroomfight.core.b r119 = LinkRoomFightContext.Companion.a();
        if (r119 == null) goto L113;
        com.bytedance.android.live.liveinteract.multiscene.a r120 = r119.L1();
        if (r120 == null) goto L113;
        String r121 = r120.getDressId();
        if (r121 == null) goto L113;
        r6 = r121;
    L113:
        r1.put("dress_id", r6);
    L114:
        r1.put("seat_fit_status", "off");
        j r122 = m.d().getVideoTalkRoomSubScene();
        if (r122 == null) goto L125;
        e r123 = (e) r122.getValue();
        if (r123 == null) goto L125;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r124 = r123.t();
        if (r124 == null) goto L125;
        List r125 = r124.b;
        if (r125 == null) goto L125;
        if (r125.contains(4) == false) goto L125;
        r1.put("seat_fit_status", "on");
    L125:
        r1.put("function_type2", TalkRoomLogUtils.h);
        zi0.d.h(r1);
        ii0.a.c(r1, true);
        if (InteractiveSongContext.Companion.f() == false) goto L128;
        r1.put("is_order_sing_open", "1");
    L128:
        k.n(IBaseLiveActionHandler.class).handle(r10, y0.b(r0, r1));
        return;
    L104:
        if (LinkRoomFightContext.Companion.c() == false) goto L114;
    L44:
        GuestBattleContext.a r126 = GuestBattleContext.Companion;
        if (r126.e() == false) goto L52;
        r1.put("linker_battle_mode", "1");
        r1.put("user_cnt", String.valueOf(je0.d.S()));
        a0 r127 = r126.a();
        if (r127 == null) goto L50;
        String r128 = String.valueOf(r127.getBattleId());
        if (r128 == null) goto L50;
    L51:
        r1.put("battle_id", r128);
    L50:
        r128 = "0";
        goto L51
    L52:
        TeamFightContext.a r129 = TeamFightContext.Companion;
        if (r129.f() == false) goto L55;
    L56:
        if (r3 == true) goto L58;
    L81:
        r1.put("linker_battle_mode", "2");
        r1.put("user_cnt", String.valueOf(je0.d.S()));
        com.bytedance.android.live.liveinteract.multiscene.a r130 = r129.b();
        if (r130 == null) goto L85;
        String r131 = r130.getTeamFightIdStr();
        if (r131 == null) goto L85;
    L86:
        r1.put("teamfight_id", r131);
        com.bytedance.android.live.liveinteract.multiscene.a r132 = r129.b();
        if (r132 == null) goto L90;
        String r133 = String.valueOf(r132.getTeamBattleType());
        if (r133 == null) goto L90;
    L91:
        r1.put("team_battle_type", r133);
        TeamFightContext r134 = r129.getContext();
        if (r134 == null) goto L99;
        com.bytedance.live.datacontext.m<Integer> r135 = r134.getFightStatus();
        if (r135 == null) goto L99;
        Integer r136 = (Integer) r135.getValue();
        if (r136 == null) goto L99;
        String r137 = String.valueOf(r136.intValue());
        if (r137 == null) goto L99;
    L100:
        r1.put("team_fight_status", r137);
    L99:
        r137 = String.valueOf(0);
    L90:
        r133 = "0";
    L85:
        r131 = "0";
        goto L86
    L58:
        if (li0.d.g(null) == true) goto L81;
    L61:
        if (je0.d.f() != 16) goto L102;
        xi0.a r138 = ((IInteractService) k.n(IInteractService.class)).linkRoomFightService();
        if (r138 != null) goto L65;
    L67:
        if (r111 == true) goto L69;
        r1.put("linker_battle_mode", "3");
    L69:
        r1.put("user_cnt", String.valueOf(je0.d.S()));
        com.bytedance.android.live.liveinteract.revenue.linkroomfight.core.b r139 = LinkRoomFightContext.Companion.a();
        if (r139 == null) goto L75;
        com.bytedance.android.live.liveinteract.multiscene.a r140 = r139.L1();
        if (r140 == null) goto L75;
        String r141 = r140.getTeamFightIdStr();
        if (r141 == null) goto L75;
    L76:
        r1.put("teamfight_id", r141);
        if (r14 == false) goto L79;
        Object r142 = "1";
    L80:
        r1.put("hide_support_guest", r142);
        goto L102
    L79:
        r142 = "0";
    L75:
        r141 = "0";
        goto L76
    L65:
        if (r138.A4() != true) goto L67;
        r111 = true;
        goto L67
    L55:
        if (r129.e() == false) goto L61;
    L36:
        r116 = "0";
    L32:
        r115 = false;
        goto L33
    L17:
        r19 = "video_live";
    L9:
        r17 = "";
        goto L10
    }

    public static /* synthetic */ void c(a r6, Context r7, DataCenter r8, IBaseUser r9, IRoom r10, boolean r11, int r12) {
        if ((r12 & 16) == 0) goto L5;
        boolean r4 = false;
    L7:
        if ((r12 & 32) == 0) goto L9;
        HashMap r13 = new HashMap();
    L10:
        r6.getClass();
        a(r7, r8, r9, r10, r4, r13);
        return;
    L9:
        r13 = null;
        goto L10
    L5:
        r4 = r11;
        goto L7
    }
}
