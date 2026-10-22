package com.bytedance.android.live.revlink.impl.jsb;

import com.bytedance.android.live.browser.jsbridge.base.BattleLaunchResultModel;
import com.bytedance.android.live.browser.jsbridge.base.BattleLaunchType;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.PkBaseDataContext;
import com.bytedance.android.live.revlink.impl.mergepk.pkdouble.PkDoubleAnchorDataContext;
import com.bytedance.android.livesdk.link.model.IBattleConfigSetting;
import com.bytedance.android.livesdk.link.model.ILinkMicBattleInviteMessage;
import com.bytedance.android.livesdk.link.model.aa;
import com.bytedance.android.livesdk.link.model.h9;
import com.bytedance.android.livesdk.link.model.m3;
import com.bytedance.android.livesdk.link.model.w2;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.lang.reflect.Type;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.TypesJVMKt;
import w20.o7;
import w20.p7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b extends wy0.b<p7, BattleLaunchResultModel> {
    public final Type a;
    public final com.bytedance.android.live.revlink.impl.global.c b;

    @Override // wy0.b
    public final Type k() {
        return this.a;
    }

    public b(com.bytedance.android.live.revlink.impl.global.c r1) {
        this.b = r1;
        this.a = TypesJVMKt.getJavaType(Reflection.typeOf(p7.class));
    }

    @Override // wy0.b
    public final void l(vh7.j r12, CallContext r13) {
        p7 r14 = (p7) r12;
        Intrinsics.checkNotNullParameter(r14, "param");
        Intrinsics.checkNotNullParameter(r13, "callContext");
        int r15 = r14.getEventName();
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.a r1 = null;
        com.bytedance.android.live.revlink.impl.multianchor.service.a r2 = null;
        if (r15 != BattleLaunchType.Invite.getType()) goto L5;
    L86:
        com.bytedance.android.live.revlink.impl.global.c r16 = this.b;
        if (r16 == null) goto L89;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.f r17 = r16.getPKBaseUtils();
    L90:
        if (r17 == null) goto L102;
        com.bytedance.android.live.revlink.impl.global.c r18 = r17.a;
        if (r18 == null) goto L94;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r19 = r18.Ig();
    L95:
        if (r19 == null) goto L97;
        r1 = r19.getPkAnchorLauncher();
    L97:
        if (r1 == null) goto L103;
        o7 r110 = new o7();
        r110.a = Integer.valueOf(r14.getEventName());
        r110.b = r14.getExtra();
        r1.m(r110, new a(this));
        return;
    L103:
        return;
    L94:
        r19 = null;
        goto L95
    L102:
        return;
    L89:
        r17 = null;
        goto L90
    L5:
        if (r15 == BattleLaunchType.Reply.getType()) goto L86;
        if (r15 == BattleLaunchType.BizInvite.getType()) goto L86;
        if (r15 == BattleLaunchType.BizEnd.getType()) goto L86;
        if (r15 == BattleLaunchType.Open.getType()) goto L86;
        if (r15 != BattleLaunchType.SwitchAndOpen.getType()) goto L100;
        JsonObject r111 = r14.getExtra();
        String r0 = "";
        if (r111 == null) goto L19;
        String r112 = r111.toString();
        if (r112 == null) goto L19;
    L20:
        jy0.b.c("BattleLaunchMethod", r112, null, 4);
        JsonObject r113 = r14.getExtra();
        if (r113 != null) goto L23;
    L76:
        jy0.b.c("BattleLaunchMethod", String.valueOf(r14.getExtra().has("battle_config_setting_str")), null, 4);
    L77:
        com.bytedance.android.live.revlink.impl.mergepk.pkdouble.g r114 = null;
    L78:
        if (r114 == null) goto L104;
        com.bytedance.android.live.revlink.impl.global.c r115 = this.b;
        if (r115 == null) goto L83;
        r2 = r115.u5();
    L83:
        if (r2 == null) goto L85;
        r2.na(r114);
    L85:
        BattleLaunchResultModel r116 = new BattleLaunchResultModel();
        r116.a(BattleLaunchResultModel.Code.Success);
        finishWithResult(r116);
        return;
    L104:
        return;
    L23:
        if (r113.has("battle_config_setting_str") != true) goto L76;
        JsonObject r117 = r14.getExtra();
        if (r117 == null) goto L28;
        JsonElement r118 = r117.get("battle_config_setting_str");
    L29:
        if (r118 == null) goto L32;
        String r119 = r118.toString();
        if (r119 == null) goto L32;
    L33:
        jy0.b.c("BattleLaunchMethod", r119, null, 4);
        if (r118 == null) goto L77;
        IBattleConfigSetting r9 = (IBattleConfigSetting) GsonProtectorUtils.fromJson(l97.a.a, r118.getAsString(), TypesJVMKt.getJavaType(Reflection.typeOf(IBattleConfigSetting.class)));
        if (r9 == null) goto L42;
        String r120 = r9.toString();
        if (r120 == null) goto L42;
        r0 = r120;
    L42:
        jy0.b.c("BattleLaunchMethod", r0, null, 4);
        if (r9 == null) goto L45;
        m3 r121 = r9.getBreakthroughConfig();
    L46:
        if (r121 != null) goto L75;
        if (r9 != null) goto L49;
    L51:
        if (r9 == null) goto L53;
        aa r122 = r9.getVoteData();
    L54:
        if (r122 != null) goto L56;
        if (r9 == null) goto L67;
        h9 r123 = r9.getSpecifyGiftConfig();
    L68:
        if (r123 == null) goto L70;
        r114 = new com.bytedance.android.live.revlink.impl.mergepk.pkdouble.g(null, 0, null, false, r9, 122879);
        goto L78
    L70:
        int r6 = ILinkMicBattleInviteMessage.BattleInviteType.BattleInviteType_Unknown.ordinal();
        if (r9 == null) goto L73;
        w2 r7 = r9.getShellConfig();
    L74:
        r114 = new com.bytedance.android.live.revlink.impl.mergepk.pkdouble.g(null, r6, r7, false, r9, 122607);
        goto L78
    L73:
        r7 = null;
        goto L74
    L67:
        r123 = null;
        goto L68
    L56:
        if (r9 == null) goto L60;
        aa r124 = r9.getVoteData();
        if (r124 == null) goto L60;
        long r8 = r124.getDurationTime();
    L61:
        if (r9 == null) goto L63;
        aa r125 = r9.getVoteData();
    L64:
        r114 = new com.bytedance.android.live.revlink.impl.mergepk.pkdouble.g(new PkDoubleAnchorDataContext.d(r8, r125, 4), ILinkMicBattleInviteMessage.BattleInviteType.BattleInviteType_Unknown.ordinal(), null, false, r9, 122855);
        goto L78
    L63:
        r125 = null;
    L60:
        r8 = 0;
        goto L61
    L53:
        r122 = null;
        goto L54
    L49:
        if (r9.getModType() != PkBaseDataContext.PKModType.BreakThrough.ordinal()) goto L51;
    L75:
        r114 = new com.bytedance.android.live.revlink.impl.mergepk.pkdouble.g(null, ILinkMicBattleInviteMessage.BattleInviteType.BattleInviteType_Unknown.ordinal(), null, true, r9, 118767);
        goto L78
    L45:
        r121 = null;
    L32:
        r119 = "";
        goto L33
    L28:
        r118 = null;
    L19:
        r112 = "";
        goto L20
    }
}
