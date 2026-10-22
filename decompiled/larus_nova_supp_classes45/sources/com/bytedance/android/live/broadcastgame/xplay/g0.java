package com.bytedance.android.live.broadcastgame.xplay;

import com.bytedance.android.live.broadcast.api.gamepromote.GamePromoteDataContext;
import com.bytedance.android.live.broadcastgame.api.AnchorGameContext;
import com.bytedance.android.live.broadcastgame.api.interactgame.GameDataReportHelper;
import com.bytedance.android.live.link.ILinkServiceExternal;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class g0 implements com.bytedance.android.scope.o, d {
    public final Map<String, String> a;
    public String b;
    public long c;
    public final com.bytedance.android.live.broadcastgame.api.xplay.p d;

    public final void onStart() {
    }

    public final void onStop() {
    }

    public final Map<String, String> a() {
        if (((ILinkServiceExternal) jc1.k.n(ILinkServiceExternal.class)).getPkServiceExternal().getPkState() != 1) goto L5;
        boolean r0 = true;
    L7:
        if (((ILinkServiceExternal) jc1.k.n(ILinkServiceExternal.class)).getPkServiceExternal().getPkState() != 2) goto L9;
        boolean r3 = true;
    L10:
        AnchorGameContext.Companion.getClass();
        AnchorGameContext r5 = AnchorGameContext.a.a();
        if (r5 == null) goto L16;
        com.bytedance.live.datacontext.n<String> r6 = r5.getClickIconSource();
        if (r6 == null) goto L16;
        String r7 = (String) r6.getValue();
        if (r7 == null) goto L16;
    L17:
        com.bytedance.android.live.broadcastgame.api.xplay.p r8 = this.d;
        com.bytedance.android.live.broadcastgame.api.xplay.j r9 = r8.k;
        if (r9 == null) goto L22;
        String r11 = r9.a;
        if (r11 == null) goto L22;
        r7 = r11;
    L22:
        Pair[] r12 = new Pair[14];
        r12[0] = TuplesKt.to("game_name", r8.h.c);
        r12[1] = TuplesKt.to("game_id", String.valueOf(this.d.h.d));
        r12[2] = TuplesKt.to("game_app_id", this.d.h.b);
        r12[3] = TuplesKt.to("game_type", String.valueOf(this.d.h.a));
        r12[4] = TuplesKt.to("status", "first_start");
        if (r0 == false) goto L25;
        Object r1 = GamePromoteDataContext.GAME_TYPE_MOBILE;
    L26:
        r12[5] = TuplesKt.to("is_pk", r1);
        if (r3 == false) goto L29;
        Object r2 = GamePromoteDataContext.GAME_TYPE_MOBILE;
    L30:
        r12[6] = TuplesKt.to("is_linked", r2);
        r12[7] = TuplesKt.to("source_type", "normal");
        if (this.d.d == false) goto L33;
        String r4 = "anchor";
    L34:
        r12[8] = TuplesKt.to("user_type", r4);
        r12[9] = TuplesKt.to("if_started_by_anchor", GamePromoteDataContext.GAME_TYPE_MOBILE);
        r12[10] = TuplesKt.to("if_in_collection", "0");
        r12[11] = TuplesKt.to("click_position", "all_used");
        r12[12] = TuplesKt.to("ad_status", "off");
        int r13 = GameDataReportHelper.a;
        r12[13] = TuplesKt.to("game_category", GameDataReportHelper.c(this.d.h.g));
        Map<String, String> r14 = MapsKt.mutableMapOf(r12);
        AnchorGameContext r15 = AnchorGameContext.a.a();
        if (r15 == null) goto L41;
        com.bytedance.live.datacontext.n<String> r16 = r15.getGuideActivityName();
        if (r16 == null) goto L41;
        String r17 = (String) r16.getValue();
        if (r17 == null) goto L41;
        r14.put("activity_name", r17);
    L41:
        AnchorGameContext r18 = AnchorGameContext.a.a();
        if (r18 == null) goto L48;
        com.bytedance.live.datacontext.m<String> r19 = r18.getSearchWord();
        if (r19 == null) goto L48;
        String r21 = (String) r19.getValue();
        if (r21 == null) goto L48;
        r14.put("search_word", r21);
    L48:
        if (r7 == null) goto L50;
        r14.put("source", r7);
    L50:
        com.bytedance.android.live.broadcastgame.api.xplay.j r22 = this.d.k;
        if (r22 == null) goto L55;
        String r23 = r22.b;
        if (r23 == null) goto L55;
        r14.put("oe_source", r23);
    L55:
        return r14;
    L33:
        r4 = "user";
        goto L34
    L29:
        r2 = "0";
        goto L30
    L25:
        r1 = "0";
    L16:
        r7 = jc1.k.n(IInteractService.class).getCurrentSwitchSceneSource();
        goto L17
    L9:
        r3 = false;
        goto L10
    L5:
        r0 = false;
        goto L7
    }

    public g0(com.bytedance.android.live.broadcastgame.api.xplay.p r4) {
        Intrinsics.checkNotNullParameter(r4, "newEnv");
        this.d = r4;
        this.a = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("game_app_id", r4.h.b), TuplesKt.to("game_name", r4.h.c)});
        this.b = "";
    }

    public final void c(String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, "changeType");
        Intrinsics.checkNotNullParameter(r4, "fromStatus");
        Intrinsics.checkNotNullParameter(r5, "toStatus");
        Map<String, String> r0 = this.a;
        r0.put("change_type", r3);
        r0.put("from_status", r4);
        r0.put("to_status", r5);
        Map<String, String> r6 = this.a;
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_live_game_head_change", r6, new Object[]{Room.class});
    }
}
