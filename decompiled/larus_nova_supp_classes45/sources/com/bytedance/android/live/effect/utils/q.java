package com.bytedance.android.live.effect.utils;

import com.bytedance.android.live.broadcast.api.gamepromote.GamePromoteDataContext;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.base.EffectDataFetchType;
import com.bytedance.android.live.effect.sticker.presenter.x;
import com.bytedance.android.live.effect.sticker.ui.aigc.AigcTaskPanelClickType;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.android.livesdkapi.depend.model.StickerType;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.effectmanager.common.utils.JsonExtKt;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class q {
    public static final List<String> a = null;

    static {
        a = CollectionsKt.listOf(new String[]{"search_sug", "search_sug_rec", "search_rec"});
    }

    public static void a(String r3, HashMap r4) {
        List<String> r0 = LiveEffectContext.h;
        x r1 = LiveEffectContext.a.a(LiveEffectContextFactoryDelegate$Type.DEFAULT).b().q();
        Long r5 = StringsKt.toLongOrNull(r3);
        if (r5 == null) goto L5;
        long r2 = r5.longValue();
    L6:
        Map<String, x.a> r6 = r1.a;
        LinkedHashMap r7 = (LinkedHashMap) r6;
        x.a r8 = (x.a) r7.get(String.valueOf(r2));
        if (r8 == null) goto L17;
        int r9 = ln1.a.a.a;
        JSONObject r11 = ln1.a.a.b(r8.a());
        if (r11 == null) goto L11;
        Map r12 = JsonExtKt.toMap(r11);
    L12:
        if (r12 == null) goto L19;
        Iterator r13 = r12.entrySet().iterator();
    L15:
        if (r13.hasNext() == false) goto L20;
        Map.Entry r14 = (Map.Entry) r13.next();
        r4.put(r14.getKey(), r14.getValue().toString());
        goto L15
    L20:
        return;
    L19:
        return;
    L11:
        r12 = null;
        goto L12
    L17:
        return;
    L5:
        r2 = 0;
        goto L6
    }

    public static void f(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "keyword");
        Intrinsics.checkNotNullParameter(r4, "page");
        e("livesdk_live_sticker_trending_words_click", MapsKt.hashMapOf(new Pair[]{TuplesKt.to("live_type", "video_live"), TuplesKt.to("word_name", r3)}), r4);
    }

    public static void i(com.bytedance.android.live.effect.base.f r11, String r12) {
        String r1 = "0";
        Intrinsics.checkNotNullParameter("0", "status");
        Intrinsics.checkNotNullParameter(r11, "traceInfo");
        Intrinsics.checkNotNullParameter(r12, "page");
        HashMap r0 = new HashMap();
        r0.put("status_code", "0");
        r0.put("panel", r11.b);
        EffectDataFetchType r2 = r11.d;
        if (r2 == null) goto L5;
        Integer r3 = Integer.valueOf(r2.getCode());
    L6:
        r0.put("fetch_type", String.valueOf(r3));
        if (r11.e == false) goto L9;
        Object r4 = GamePromoteDataContext.GAME_TYPE_MOBILE;
    L10:
        r0.put("is_first_show", r4);
        r0.put("panel_info_cache_status", String.valueOf(r11.f.getCode()));
        r0.put("effect_list_cache_status", String.valueOf(r11.g.getCode()));
        r0.put("total_duration", String.valueOf(r11.m - r11.h));
        r0.put("fetch_panel_info_duration", String.valueOf(r11.j - r11.i));
        r0.put("fetch_effect_list_duration", String.valueOf(r11.l - r11.k));
        r0.put("live_handle_duration", String.valueOf(((r11.m - r11.h) - (r11.j - r11.i)) - (r11.l - r11.k)));
        if (r11.a == false) goto L13;
        r1 = GamePromoteDataContext.GAME_TYPE_MOBILE;
    L13:
        r0.put("is_new_sticker_dialog", r1);
        e("ttlive_sticker_panel_show", r0, r12);
        return;
    L9:
        r4 = "0";
        goto L10
    L5:
        r3 = null;
        goto L6
    }

    public static void d(Sticker r4, String r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "eventType");
        Intrinsics.checkNotNullParameter(r6, "isLive");
        HashMap r0 = new HashMap();
        IUserService r1 = jc1.k.f(IUserService.class);
        String r2 = "";
        if (r1 == null) goto L8;
        com.bytedance.android.livesdk.user.f r3 = r1.user();
        if (r3 == null) goto L8;
        String r7 = r3.n();
        if (r7 == null) goto L8;
    L9:
        r0.put("anchor_id", r7);
        r0.put("is_live", r6);
        r0.put("event_type", r5);
        if (r4 == null) goto L13;
        String r8 = r4.getEffectId();
        if (r8 == null) goto L13;
    L14:
        r0.put("effect_id", r8);
        if (r4 == null) goto L20;
        String r9 = r4.getName();
        if (r9 == null) goto L20;
        r2 = r9;
    L20:
        r0.put("effect_name", r2);
        u.l().sendLog("livesdk_effect_panel_hint", r0, new Object[]{Room.class});
        return;
    L13:
        r8 = "";
    L8:
        r7 = "";
        goto L9
    }

    public static void e(String r3, HashMap r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, "eventName");
        Intrinsics.checkNotNullParameter(r4, "logMap");
        Intrinsics.checkNotNullParameter(r5, "eventPage");
        r4.put("event_page", r5);
        if (Intrinsics.areEqual(r5, "live_take_page") == false) goto L5;
        r4.put("anchor_id", jc1.k.n(IUserService.class).user().n());
        r4.put("room_id", "");
        u.l().sendLog(r3, r4, new Object[0]);
        return;
    L5:
        u.l().sendLog(r3, r4, new Object[]{Room.class});
    }

    public static void c(Sticker r3, String r4, AigcTaskPanelClickType r5, String r6) {
        Intrinsics.checkNotNullParameter(r3, "sticker");
        Intrinsics.checkNotNullParameter(r4, "keyword");
        Intrinsics.checkNotNullParameter(r5, "clickType");
        Intrinsics.checkNotNullParameter(r6, "eventPage");
        HashMap r0 = new HashMap();
        r0.put("sticker_id", String.valueOf(r3.getId()));
        r0.put("key_word", r4);
        r0.put("click_type", r5.getTypeName());
        e("livesdk_live_ai_sticker_generation_click", r0, r6);
    }

    public static void b(boolean r3, Sticker r4, String r5, LiveEffectContextFactoryDelegate$Type r6, String r7) {
        Intrinsics.checkNotNullParameter(r4, "sticker");
        Intrinsics.checkNotNullParameter(r5, "tab");
        Intrinsics.checkNotNullParameter(r6, "type");
        Intrinsics.checkNotNullParameter(r7, "page");
        HashMap r1 = new HashMap();
        r1.put("impr_position", String.valueOf(m90.b.i.c(r6).intValue()));
        r1.put("tab", r5);
        r1.put("sticker_id", String.valueOf(r4.getId()));
        if (r3 == false) goto L5;
        String r8 = GamePromoteDataContext.GAME_TYPE_MOBILE;
    L6:
        r1.put("isSuccess", r8);
        a(String.valueOf(r4.getId()), r1);
        e("livesdk_live_take_sticker_mock", r1, r7);
        a(String.valueOf(r4.getId()), r1);
        return;
    L5:
        r8 = "0";
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void g(Sticker r4, String r5, LiveEffectContextFactoryDelegate$Type r6, String r7, boolean r8, String r9) {
        Intrinsics.checkNotNullParameter(r4, "sticker");
        Intrinsics.checkNotNullParameter(r5, "tab");
        Intrinsics.checkNotNullParameter(r6, "type");
        Intrinsics.checkNotNullParameter(r7, "page");
        Intrinsics.checkNotNullParameter(r9, "subTab");
        HashMap r1 = new HashMap();
        r1.put("impr_position", String.valueOf(m90.b.i.c(r6).intValue()));
        r1.put("tab", r5);
        String r11 = "0";
        r1.put("status", "0");
        if (r8 == false) goto L5;
        Object[] r12 = GamePromoteDataContext.GAME_TYPE_MOBILE;
    L6:
        r1.put("is_mock_window", r12);
        r1.put("sticker_id", String.valueOf(r4.getId()));
        r1.put("is_video_sticker", String.valueOf(r4.isVideoUsedSticker() ? 1 : 0));
        int r13 = r4.getSearchResultType();
        String r0 = r4.getSearchId();
        if (r13 < 0) goto L11;
        List<String> r2 = a;
        if (r13 >= r2.size()) goto L11;
        r1.put("search_result", ListProtector.get(r2, r13));
    L11:
        if (r0 != null) goto L13;
    L16:
        boolean r14 = true;
    L17:
        if (r14 == true) goto L19;
        r1.put("search_id", r0);
    L19:
        com.bytedance.android.live.effect.sticker.k.k.getClass();
        if (com.bytedance.android.live.effect.sticker.k.a.a() == false) goto L25;
        r1.put("connect_type", com.bytedance.android.live.effect.sticker.k.a.b());
        int r15 = com.bytedance.ies.bullet.kit.resourceloader.loader.b.a;
        if (com.bytedance.ies.bullet.kit.resourceloader.loader.b.d(r4.getTopTips()) == false) goto L24;
        r11 = GamePromoteDataContext.GAME_TYPE_MOBILE;
    L24:
        r1.put("is_info_public", r11);
    L25:
        a(String.valueOf(r4.getId()), r1);
        r1.put("sticker_type", r4.getStickerType().getTypeName());
        r1.put("sub_tab_name", r9);
        e("live_take_sticker_select", r1, r7);
        return;
    L13:
        if (r0.length() == 0) goto L16;
        r14 = false;
        goto L17
    L5:
        r12 = "0";
        goto L6
    }

    public static void h(String r3, boolean r4, int r5, String r6, LiveEffectContextFactoryDelegate$Type r7, String r8, String r9, StickerType r11, String r12) {
        Intrinsics.checkNotNullParameter(r3, "stickerId");
        Intrinsics.checkNotNullParameter(r6, "tab");
        Intrinsics.checkNotNullParameter(r7, "type");
        Intrinsics.checkNotNullParameter(r8, "page");
        Intrinsics.checkNotNullParameter(r11, "stickerType");
        Intrinsics.checkNotNullParameter(r12, "subTab");
        HashMap r1 = new HashMap();
        r1.put("impr_position", String.valueOf(r5));
        Integer r13 = m90.b.m.c(r7);
        r1.put("tab", r6);
        if (r13 != null) goto L6;
    L7:
        if (r13 != null) goto L10;
    L17:
        r1.put("sticker_id", r3);
        r1.put("is_video_sticker", String.valueOf(r4 ? 1 : 0));
        com.bytedance.android.live.effect.sticker.k.k.getClass();
        if (com.bytedance.android.live.effect.sticker.k.a.a() == false) goto L24;
        r1.put("connect_type", com.bytedance.android.live.effect.sticker.k.a.b());
        if (com.bytedance.ies.bullet.kit.resourceloader.loader.b.d(r9) == false) goto L22;
        String r14 = GamePromoteDataContext.GAME_TYPE_MOBILE;
    L23:
        r1.put("is_info_public", r14);
        goto L24
    L22:
        r14 = "0";
    L24:
        a(r3, r1);
        r1.put("sticker_type", r11.getTypeName());
        r1.put("sub_tab_name", r12);
        e("live_sticker_show", r1, r8);
        return;
    L10:
        if (r13.intValue() != (-1)) goto L17;
    L11:
        Integer r15 = m90.b.q.c(r7);
        if (r15.intValue() < 0) goto L16;
        int r16 = r15.intValue();
        List<String> r0 = a;
        if (r16 >= r0.size()) goto L16;
        r1.put("search_result", ListProtector.get(r0, r15.intValue()));
    L16:
        r1.put("search_id", m90.b.r.c(r7));
        goto L17
    L6:
        if (r13.intValue() == (-2)) goto L11;
        goto L7
    }
}
