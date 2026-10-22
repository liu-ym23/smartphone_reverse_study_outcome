package com.bytedance.android.live.broadcastgame.opengame.service;

import am2.x;
import android.text.TextUtils;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.revlink.api.ILinkService;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.log.e0;
import com.bytedance.android.livesdk.log.filter.n0;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import java.util.LinkedHashMap;
import java.util.Map;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e {
    public static String a;
    public static final e b = null;

    public static final class a {
        public static final /* synthetic */ int a = 0;

        static {
        }
    }

    public e() {
    }

    static {
        b = new e();
        a = "";
    }

    public static void a(Map r4, Long r5, String r6, String r7) {
        int r0 = a.a;
        n0 r1 = u.l().c(x.class);
        if ((r1 instanceof n0) == false) goto L18;
        n0 r2 = r1;
        if (((com.bytedance.android.livesdk.log.filter.a) r2).b.containsKey("enter_from") == false) goto L8;
        String r3 = (String) ((com.bytedance.android.livesdk.log.filter.a) r2).b.get("enter_from");
    L8:
        if (((com.bytedance.android.livesdk.log.filter.a) r2).b.containsKey("source") == false) goto L10;
        String r8 = (String) ((com.bytedance.android.livesdk.log.filter.a) r2).b.get("source");
    L10:
        Map r9 = ((com.bytedance.android.livesdk.log.filter.a) r2).b;
        Map r11 = e0.a;
        if (tb1.c.a == true) goto L13;
    L17:
        String r12 = (String) r9.get("enter_from_merge");
    L19:
        r4.put("enter_from_merge", String.valueOf(r12));
        r4.put("user_id", k.n(IUserService.class).user().n());
        if (r5 == null) goto L22;
        r4.put("game_id", String.valueOf(r5.longValue()));
    L22:
        if (r6 == null) goto L24;
        r4.put("game_name", r6);
    L24:
        if (r7 == null) goto L27;
        r4.put("game_category", r7);
        return;
    L27:
        return;
    L13:
        if (r9.containsKey("enter_from_ad_type") == false) goto L17;
        if (TextUtils.isEmpty((CharSequence) r9.get("enter_from_ad_type")) == true) goto L17;
        r12 = (String) r9.get("enter_from_ad_type");
        goto L19
    L18:
        r12 = "";
        goto L19
    }

    public static void d(Long r1, String r2, String r3, String r4) {
        LinkedHashMap r0 = new LinkedHashMap();
        a(r0, r1, r2, r4);
        if (r3 != null) goto L5;
        r3 = "";
    L5:
        r0.put("game_app_id", r3);
        u.l().sendLog("livesdk_audience_interaction_click", r0, new Object[]{Room.class, x.class});
    }

    public static void e(Long r1, String r2, String r3, String r4) {
        LinkedHashMap r0 = new LinkedHashMap();
        a(r0, r1, r2, r4);
        if (r3 != null) goto L5;
        r3 = "";
    L5:
        r0.put("game_app_id", r3);
        u.l().sendLog("livesdk_audience_interaction_show", r0, new Object[]{Room.class, x.class});
    }

    public static /* synthetic */ void b(e r2, Map r3, Long r4, String r5, int r6) {
        if ((r6 & 2) == 0) goto L6;
        r4 = null;
    L6:
        if ((r6 & 4) == 0) goto L8;
        r5 = null;
    L8:
        r2.getClass();
        a(r3, r4, r5, null);
    }

    public final void c(Long r3, String r4, Long r5, String r6, boolean r7) {
        LinkedHashMap r0 = new LinkedHashMap();
        if (r7 == false) goto L5;
        String r8 = "cancel";
    L6:
        r0.put("action", r8);
        r0.put("toast_game_id", String.valueOf(r3));
        r0.put("toast_game_name", String.valueOf(r4));
        b(this, r0, r5, r6, 8);
        u.l().sendLog("livesdk_live_program_audience_change_click", r0, new Object[]{Room.class});
        return;
    L5:
        r8 = "click";
        goto L6
    }

    public static void f(Long r2, String r3, String r4, String r5, Boolean r6, String r7) {
        Intrinsics.checkNotNullParameter(r4, "clickPosition");
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("click_position", r4);
        if (r6 == null) goto L10;
        r6.booleanValue();
        if (r6.booleanValue() == false) goto L7;
        String r8 = "anchor";
    L8:
        r0.put("user_type", r8);
        goto L10
    L7:
        r8 = "user";
    L10:
        if (Intrinsics.areEqual(k.n(IInteractService.class).getCurrentSwitchSceneSource(), "accepted_tool_invited") == false) goto L12;
        String r9 = "invited";
    L13:
        r0.put("game_anchor_type", r9);
        if (r7 == null) goto L16;
        r0.put("game_app_id", r7);
    L16:
        boolean r11 = com.bytedance.android.live.revenue.core.util.h.a;
        kc0.e r12 = com.bytedance.android.live.revenue.core.util.h.d(ILinkService.class).getRevLinkControlService();
        if (r12 == null) goto L21;
        Map<String, String> r13 = r12.h();
        if (r13 == null) goto L21;
        r0.putAll(r13);
    L21:
        a(r0, r2, r3, r5);
        u.l().sendLog("livesdk_game_open_page_more_click_button", r0, new Object[]{x.class, Room.class});
        return;
    L12:
        r9 = "self_start";
        goto L13
    }
}
