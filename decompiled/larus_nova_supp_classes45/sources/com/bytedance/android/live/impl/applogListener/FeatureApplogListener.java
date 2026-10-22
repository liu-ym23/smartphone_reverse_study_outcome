package com.bytedance.android.live.impl.applogListener;

import android.text.TextUtils;
import com.bytedance.android.live.broadcast.api.gamepromote.GamePromoteDataContext;
import com.bytedance.android.live.impl.service.FeatureManager;
import com.bytedance.android.livehostapi.platform.IMiddlewareHostAction;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class FeatureApplogListener implements IMiddlewareHostAction.ILiveAppLogListener {
    public static final Lazy a = null;
    public static final FeatureApplogListener b = null;

    public FeatureApplogListener() {
    }

    static {
        b = new FeatureApplogListener();
        a = LazyKt.lazy(FeatureApplogListener$eventSet$2.INSTANCE);
    }

    public final void handleAppLogEvent(String r11, JSONObject r12) {
        if (r11 != null) goto L5;
        return;
    L5:
        if (((Set) a.getValue()).contains(r11) == true) goto L7;
        return;
    L7:
        int r6 = 0;
        Object r8 = null;
        Object r9 = "";
        switch(r11.hashCode()) {
            case -1916895392: goto L91;
            case -1812666796: goto L77;
            case -1617968008: goto L68;
            case -1499742021: goto L65;
            case -1477426632: goto L58;
            case -917606481: goto L55;
            case -911017139: goto L42;
            case 282427540: goto L33;
            case 1522908064: goto L30;
            case 1550932427: goto L16;
            case 1633729914: goto L11;
            default: goto L118;
        };
    L118:
        return;
    L11:
        if (r11.equals("feed_aweme_shrink_result") == false) goto L94;
        if (r12 == null) goto L14;
        r6 = r12.optInt("delete_all_count");
    L14:
        FeatureManager r13 = FeatureManager.u;
        z90.a.C0301a.a(r13, "total_shrink_count", Integer.valueOf(r6));
        z90.a.C0301a.a(r13, "total_common_shrink_count", Integer.valueOf(r6));
        return;
    L94:
        return;
    L16:
        if (r11.equals("enter_homepage_tab") == false) goto L96;
        if (r12 == null) goto L21;
        String r14 = r12.optString("tab_id");
        if (r14 == null) goto L21;
    L23:
        if (TextUtils.equals(r14, "homepage_hot") == false) goto L28;
        FeatureManager r15 = FeatureManager.u;
        if (r12 == null) goto L27;
        r8 = r12.optString("enter_from");
    L27:
        r15.c("homepage_hot_refer_page", r8);
        return;
    L28:
        FeatureManager.u.c("enter_other_homepage_tab_time", Long.valueOf(System.currentTimeMillis()));
        return;
    L21:
        r14 = null;
        goto L23
    L96:
        return;
    L30:
        if (r11.equals("livesdk_product_entrance_click") == false) goto L99;
        FeatureManager.u.c("livesdk_product_entrance_click", r12);
        return;
    L99:
        return;
    L33:
        if (r11.equals("video_play_end") == false) goto L101;
        FeatureManager r0 = FeatureManager.u;
        if (r12 == null) goto L40;
        Object r16 = r12.opt("group_id");
        if (r16 == null) goto L40;
        r9 = r16;
    L40:
        r0.c(r11, r9);
        return;
    L101:
        return;
    L42:
        if (r11.equals("play_session_events") == false) goto L103;
        if (r12 == null) goto L46;
        r8 = r12.opt("video_play_end");
    L46:
        if (TextUtils.equals(String.valueOf(r8), GamePromoteDataContext.GAME_TYPE_MOBILE) == false) goto L104;
        FeatureManager r17 = FeatureManager.u;
        if (r12 == null) goto L53;
        Object r18 = r12.opt("group_id");
        if (r18 == null) goto L53;
        r9 = r18;
    L53:
        r17.c("video_play_end", r9);
        return;
    L104:
        return;
    L103:
        return;
    L55:
        if (r11.equals("livesdk_redpackage_click") == false) goto L106;
        FeatureManager.u.c("livesdk_redpackage_click", r12);
        return;
    L106:
        return;
    L58:
        if (r11.equals("homepage_tab_stay_time") == false) goto L108;
        if (r12 == null) goto L62;
        r8 = r12.opt("tab_id");
    L62:
        if (Intrinsics.areEqual(r8, "homepage_tablive") == false) goto L109;
        FeatureManager r19 = FeatureManager.u;
        r19.g("tablive_guide_id");
        r19.g("tablive_guide_anchor_id");
        return;
    L109:
        return;
    L108:
        return;
    L65:
        if (r11.equals("livesdk_short_task_banner_click") == false) goto L111;
        FeatureManager.u.c("livesdk_short_task_banner_click", r12);
        return;
    L111:
        return;
    L68:
        if (r11.equals("video_play") == false) goto L113;
        FeatureManager r110 = FeatureManager.u;
        if (r12 == null) goto L75;
        Object r111 = r12.opt("enter_from");
        if (r111 == null) goto L75;
        r9 = r111;
    L75:
        z90.a.C0301a.a(r110, "video_play_enter_from", r9);
        z90.a.C0301a.a(r110, "video_play_time", Long.valueOf(System.currentTimeMillis()));
        return;
    L113:
        return;
    L77:
        if (r11.equals("ttliveplayer_live_player_play_start") == false) goto L115;
        FeatureManager r112 = FeatureManager.u;
        if (r12 == null) goto L82;
        String r1 = r12.optString("use_scene");
        if (r1 == null) goto L82;
    L83:
        z90.a.C0301a.a(r112, "use_scene", r1);
        if (r12 == null) goto L89;
        String r113 = r12.optString("create_scene");
        if (r113 == null) goto L89;
        r9 = r113;
    L89:
        z90.a.C0301a.a(r112, "create_scene", r9);
        return;
    L82:
        r1 = "";
        goto L83
    L115:
        return;
    L91:
        if (r11.equals("refresh_homepage_hot") == false) goto L117;
        FeatureManager r114 = FeatureManager.u;
        r114.c("refresh_aweme_list", 1);
        r114.c("max_visited_aweme_item_index", 0);
        r114.g("total_shrink_count");
        r114.g("total_common_shrink_count");
        return;
    }
}
