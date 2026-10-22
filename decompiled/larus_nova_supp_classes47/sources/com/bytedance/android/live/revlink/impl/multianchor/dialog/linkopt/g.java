package com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt;

import com.bytedance.android.live.link.constants.UserListInviteType;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revlink.impl.global.LinkFakeGlobalService;
import com.bytedance.android.live.revlink.impl.pk.vm.linkout.PkCustomizePlayDataContext;
import com.bytedance.android.livesdk.link.model.IBattleConfigSetting;
import com.bytedance.android.livesdk.link.model.api.IBaseBattleSetting;
import com.bytedance.android.livesdk.link.model.c9;
import com.bytedance.android.livesdk.link.model.d4;
import com.bytedance.android.livesdk.link.model.u2;
import com.bytedance.android.livesdk.link.model.v2;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g implements com.bytedance.android.live.revlink.link.biz.service.k {
    public final com.bytedance.android.live.revlink.impl.global.c a;

    @Override // com.bytedance.android.live.revlink.link.biz.service.k
    public final com.bytedance.android.live.revlink.impl.global.c getLinkInstanceService() {
        return this.a;
    }

    public g(LinkFakeGlobalService r2) {
        Intrinsics.checkNotNullParameter(r2, "linkInstanceService");
        this.a = r2;
    }

    public static void a(g r9, IRoom r10, boolean r12, String r13, boolean r14, boolean r15, int r16) {
        if ((r16 & 4) == 0) goto L5;
        r13 = "routine_pk";
    L5:
        int r1 = 0;
        if ((r16 & 8) == 0) goto L9;
        r14 = false;
    L9:
        if ((r16 & 32) == 0) goto L11;
        r15 = false;
    L11:
        r9.getClass();
        Intrinsics.checkNotNullParameter(r13, "inviteMode");
        LinkedHashMap r17 = new LinkedHashMap();
        if (r10 == null) goto L96;
        r17.put("channel_id", String.valueOf(com.bytedance.android.live.revlink.link.biz.service.i.m(r9).c()));
        com.bytedance.android.live.revlink.impl.service.internal.a r18 = com.bytedance.android.live.revlink.link.biz.service.i.p(r9);
        if (r18 == null) goto L16;
        int r19 = r18.getCurrentMode();
    L18:
        if (com.bytedance.android.live.utils.c.a(r19, 4) == false) goto L20;
        char r110 = 1;
    L22:
        if (r110 != 1) goto L24;
        r17.put("anchor_cnt", "2");
        r17.put("pk_id", String.valueOf(com.bytedance.android.live.revlink.link.biz.service.i.T(r9).i()));
        r17.put("anchor_connect_status", "2");
    L31:
        String r111 = DataType.TRUE;
        if (r14 == false) goto L34;
        Object r112 = DataType.TRUE;
    L35:
        r17.put("is_oncemore", r112);
        r17.put("source", com.bytedance.android.live.revlink.link.biz.service.i.n(r9).a);
        r17.put("battle_mode", com.bytedance.android.live.revlink.link.biz.service.i.Z(r9).d());
        r17.put("invite_mode", r13);
        if (r12 == false) goto L38;
        Object r113 = DataType.TRUE;
    L39:
        r17.put("is_success", r113);
        int r114 = UserListInviteType.a;
        r17.put("invitee_list", UserListInviteType.a(com.bytedance.android.live.revlink.link.biz.service.i.m(r9).f(), null));
        com.bytedance.android.live.revlink.impl.control.d r115 = com.bytedance.android.live.revlink.link.biz.service.i.e(r9);
        if (r115 == null) goto L44;
        String r116 = r115.getRequestId();
        if (r116 == null) goto L44;
        r17.put("request_id", r116);
    L44:
        PkCustomizePlayDataContext r117 = com.bytedance.android.live.revlink.link.biz.service.i.W(r9).f();
        if (r117 == null) goto L49;
        u2 r118 = r117.getBattleSelfData();
        if (r118 == null) goto L49;
        r1 = r118.getPkValueType();
    L49:
        String r119 = "";
        if (r1 > 0) goto L52;
    L71:
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r120 = com.bytedance.android.live.revlink.link.biz.service.i.S(r9);
        if (r120 == null) goto L93;
        IBaseBattleSetting r121 = r120.getBattleSettings();
        if (r121 == null) goto L93;
        IBattleConfigSetting r122 = r121.getBattleConfigSetting();
        if (r122 == null) goto L93;
        d4 r123 = r122.getCustomConfig();
        if (r123 == null) goto L93;
        List r124 = r123.getScoreElements();
        if (r124 == null) goto L92;
        Intrinsics.checkNotNullParameter(r124, "$this$toLogStr");
        if (r124.isEmpty() == false) goto L84;
        String r125 = "";
    L89:
        if (r125 == null) goto L92;
        r119 = r125;
        goto L92
    L84:
        List r126 = r124;
        ArrayList r127 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r126, 10));
        Iterator r128 = r126.iterator();
    L86:
        if (r128.hasNext() == false) goto L88;
        r127.add(Double.valueOf(((c9) r128.next()).getValueKind()));
        goto L86
    L88:
        r125 = CollectionsKt.joinToString$default(CollectionsKt.sorted(r127), ",", null, null, 0, null, null, 62, null);
    L92:
        r17.put("custom_value_kinds", r119);
    L93:
        r17.put("room_status", com.bytedance.android.live.revlink.link.biz.service.i.Z(r9).s());
        com.bytedance.android.live.revlink.link.biz.service.i.Z(r9).r(r17);
        mz0.n r20 = new mz0.n();
        Map<String, String> r129 = r20.a;
        Intrinsics.checkNotNullParameter(r129, "map");
        Intrinsics.checkNotNullParameter(r17, "map");
        r129.putAll(r17);
        mz0.m r130 = new mz0.m();
        r130.b(LogCommon.ROOM);
        ((ArrayList) r20.b).addAll(r130.a);
        cy0.e.a.getClass();
        cy0.j r131 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r132 = com.bytedance.android.scope.m.b(r131).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r132);
        ((mz0.i) ((f80.a) r132)).w3("livesdk_connection_play_start", r20.a, r20.b);
        return;
    L52:
        if (r1 >= 100) goto L71;
        r17.put("customize_pk_type", String.valueOf(r1));
        PkCustomizePlayDataContext r133 = com.bytedance.android.live.revlink.link.biz.service.i.W(r9).f();
        if (r133 == null) goto L67;
        u2 r134 = r133.getBattleSelfData();
        if (r134 == null) goto L67;
        r17.put("pk_time", String.valueOf(r134.getPkCustomDuration()));
        r17.put("giftvalue_exchange_rate", String.valueOf(r134.getPkGiftValueLevel()));
        r17.put("giftuv_exchange_rate", String.valueOf(r134.getPkUVLevel()));
        r17.put("ticket_exchange_rate", String.valueOf(r134.getPkTicketLevel()));
        r17.put("like_exchange_rate", String.valueOf(r134.getPkLikeLevel()));
        PkCustomizePlayDataContext r135 = com.bytedance.android.live.revlink.link.biz.service.i.W(r9).f();
        if (r135 == null) goto L65;
        IBattleConfigSetting r136 = r135.getBattleConfigSetting();
        if (r136 == null) goto L65;
        v2 r137 = r136.getSelfSettingRate();
        if (r137 == null) goto L65;
        String r138 = String.valueOf(r137.getPkVIPRate());
        if (r138 == null) goto L65;
    L66:
        r17.put("membership_exchange_rate", r138);
    L65:
        r138 = "";
    L67:
        if (r15 == true) goto L70;
        r111 = DataType.FALSE;
    L70:
        r17.put("is_customized_setting", r111);
        goto L71
    L38:
        r113 = DataType.FALSE;
        goto L39
    L34:
        r112 = DataType.FALSE;
        goto L35
    L24:
        Intrinsics.checkNotNullParameter(r9, "$this$multiAnchorService");
        com.bytedance.android.live.revlink.impl.multianchor.service.d r139 = com.bytedance.android.live.revlink.link.biz.service.i.getContext(r9).R8();
        if (r139 == null) goto L29;
        i11.b r140 = r139.getLinkUserCenter();
        if (r140 == null) goto L29;
        Integer r141 = Integer.valueOf(r140.c());
    L30:
        r17.put("anchor_connect_status", String.valueOf(r141));
    L29:
        r141 = null;
        goto L30
    L20:
        r110 = 7;
        goto L22
    L16:
        r19 = 0;
        goto L18
    }
}
