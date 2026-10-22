package com.bytedance.android.live.liveinteract.interactivesong.logger;

import am2.x;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.hamlet.HamletAvatarContext;
import com.bytedance.android.live.liveinteract.interactivesong.impl.InteractiveSongContext;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.plantform.utils.s0;
import com.bytedance.android.live.liveinteract.plantform.utils.u0;
import com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService;
import com.bytedance.android.live.liveinteract.voicechat.d;
import com.bytedance.android.live.liveinteract.voicechat.util.k;
import com.bytedance.android.livesdk.chatroom.u;
import com.bytedance.android.livesdk.chatroom.viewmodel.f;
import com.bytedance.android.livesdk.chatroom.viewmodel.i;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import gd0.g;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import qf0.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class InteractiveSongLoggerKt {
    public static final k a() {
        IVoiceChatGuestService.Companion.getClass();
        IVoiceChatGuestService r0 = IVoiceChatGuestService.a.a();
        if (r0 == null) goto L6;
        k r1 = r0.getLogger();
        if (r1 == null) goto L6;
        return r1;
    L6:
        d.s0.getClass();
        d r2 = d.a.a();
        if (r2 != null) goto L12;
        return null;
    L12:
        return r2.getLogger();
    }

    public static final void b(Map<String, String> r21) {
        Intrinsics.checkNotNullParameter(r21, "paramsMap");
        InteractiveSongContext.a r1 = InteractiveSongContext.Companion;
        InteractiveSongContext r2 = r1.getContext();
        if (r2 == null) goto L8;
        m<List<Long>> r3 = r2.getCurrentGiftIdList();
        if (r3 == null) goto L8;
        List r4 = (List) r3.getValue();
        if (r4 == null) goto L8;
    L9:
        InteractiveSongContext r5 = r1.getContext();
        if (r5 == null) goto L15;
        m<List<Long>> r6 = r5.getCurrentGiftNumList();
        if (r6 == null) goto L15;
        Iterable r7 = (List) r6.getValue();
        if (r7 == null) goto L15;
    L16:
        r21.put("request_song_gift_id", CollectionsKt.joinToString$default(r4, ",", "[", "]", 0, null, null, 56, null));
        r21.put("request_song_gift_money", CollectionsKt.joinToString$default(r7, ",", "[", "]", 0, null, null, 56, null));
        r21.put("request_song_gift_cnt", String.valueOf(r4.size()));
        if (s0.g(null) == false) goto L47;
        InteractiveSongContext r8 = r1.getContext();
        if (r8 == null) goto L24;
        m<List<Long>> r9 = r8.getCurrentTestGiftIdList();
        if (r9 == null) goto L24;
        List r10 = (List) r9.getValue();
        if (r10 == null) goto L24;
    L25:
        InteractiveSongContext r11 = r1.getContext();
        if (r11 == null) goto L31;
        m<List<Long>> r12 = r11.getCurrentTestGiftNumList();
        if (r12 == null) goto L31;
        Collection r13 = (List) r12.getValue();
        if (r13 == null) goto L31;
    L33:
        if ((!r10.isEmpty()) == true) goto L35;
    L37:
        InteractiveSongContext r14 = r1.getContext();
        if (r14 == null) goto L44;
        m<Boolean> r15 = r14.getShowGiftInfo();
        if (r15 == null) goto L44;
        if (((Boolean) r15.getValue()).booleanValue() != true) goto L44;
        String r16 = "1";
    L45:
        r21.put("is_rule_show", r16);
        return;
    L44:
        r16 = "0";
        goto L45
    L35:
        if ((!r13.isEmpty()) == false) goto L37;
        r21.put("test_song_gift_id", CollectionsKt.joinToString$default(r10, ",", "[", "]", 0, null, null, 56, null));
        r21.put("test_song_gift_money", CollectionsKt.joinToString$default(r13, ",", "[", "]", 0, null, null, 56, null));
        r21.put("test_song_gift_cnt", String.valueOf(r10.size()));
    L31:
        r13 = new ArrayList();
    L24:
        r10 = new ArrayList();
        goto L25
    L47:
        return;
    L15:
        r7 = new ArrayList();
    L8:
        r4 = new ArrayList();
        goto L9
    }

    public static final void d(long r3) {
        if (a() == null) goto L9;
        long r4 = r3 / ((long) 1000);
        HashMap r0 = new HashMap();
        r0.put("live_type", "voice_live");
        String r1 = ((IInteractService) jc1.k.n(IInteractService.class)).getFunctionType2();
        if (r1 == null) goto L7;
        r0.put("function_type2", r1);
    L7:
        r0.put("duration", String.valueOf(r4));
        j0.l().sendLog("livesdk_audience_mv_watch_duration", r0, new Object[]{IRoom.class, x.class});
        return;
    }

    public static final void k(boolean r4) {
        LinkedHashMap r0 = new LinkedHashMap();
        if (r4 == false) goto L5;
        String r5 = "1";
    L6:
        r0.put("is_ai_lyric_recognition", r5);
        b(r0);
        if (b.c() == false) goto L9;
        TalkRoomLogUtils.O(null, 19, r0, false, 19);
        return;
    L9:
        k r6 = a();
        if (r6 == null) goto L14;
        k.u(r6, 19, r0, false, 19);
        return;
    L14:
        return;
    L5:
        r5 = "2";
        goto L6
    }

    public static final void c(String r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r4, "mvId");
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("mv_id", r4);
        if (r5 == false) goto L5;
        String r6 = "1";
    L6:
        r0.put("is_privileged_mv", r6);
        k r7 = a();
        if (r7 == null) goto L10;
        j0.l().sendLog("livesdk_audience_mv_show", r7.a(r0, true), new Object[]{IRoom.class, x.class});
        return;
    L10:
        return;
    L5:
        r6 = "0";
        goto L6
    }

    public static final void h(boolean r6, Integer r7) {
        LinkedHashMap r2 = new LinkedHashMap();
        if (r6 == false) goto L5;
        String r8 = "1";
    L6:
        r2.put("is_ai_lyric_recognition", r8);
        if (r7 != null) goto L10;
    L12:
        if (r7 != null) goto L15;
    L17:
        String r9 = "";
    L18:
        r2.put("sing_stage_effect_type", r9);
        b(r2);
        if (b.c() == false) goto L21;
        TalkRoomLogUtils.N(null, 19, r2, 0, 19);
        return;
    L21:
        k r0 = a();
        if (r0 == null) goto L26;
        k.t(r0, 19, r2, 0, 19);
        return;
    L26:
        return;
    L15:
        if (r7.intValue() != 1) goto L17;
        r9 = "official_mv";
        goto L18
    L10:
        if (r7.intValue() != 2) goto L12;
        r9 = "ai_stage_effect";
        goto L18
    L5:
        r8 = "2";
        goto L6
    }

    public static final void e(String r2, int r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "mvTab");
        Intrinsics.checkNotNullParameter(r4, "itemId");
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("mv_tab", r2);
        r0.put("is_mv", String.valueOf(r3));
        r0.put("item_id", r4);
        k r5 = a();
        if (r5 == null) goto L6;
        j0 r6 = j0.l();
        int r7 = k.g;
        r6.sendLog("livesdk_anchor_ksong_mv_page_show", r5.a(r0, false), new Object[]{IRoom.class, x.class});
        return;
    }

    public static final void i(String r5, String r6, boolean r7, boolean r8, String r9) {
        Intrinsics.checkNotNullParameter(r5, "source");
        Intrinsics.checkNotNullParameter(r6, "userType");
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put("source", r5);
        r1.put("open_user_type", r6);
        String r10 = "1";
        if (r7 == false) goto L5;
        Object r11 = "1";
    L6:
        r1.put("mv_autoplay", r11);
        InteractiveSongContext.a r12 = InteractiveSongContext.Companion;
        InteractiveSongContext r0 = r12.getContext();
        if (r0 == null) goto L13;
        m<Boolean> r2 = r0.isSeatEnlarge();
        if (r2 == null) goto L13;
        if (((Boolean) r2.getValue()).booleanValue() != true) goto L13;
        Object r3 = "1";
    L14:
        r1.put("is_seat_enlarge", r3);
        if (r8 == false) goto L17;
        String r13 = "1";
    L18:
        r1.put("is_ai_lyric_recognition", r13);
        if (r9 != null) goto L21;
        r9 = "classic";
    L21:
        r1.put("play_layout", r9);
        HamletAvatarContext.a r14 = HamletAvatarContext.Companion;
        HamletAvatarContext r15 = r14.getContext();
        if (r15 == null) goto L29;
        n<Long> r16 = r15.getCurrentSelectAvatarID();
        if (r16 == null) goto L29;
        Long r17 = (Long) r16.getValue();
        if (r17 == null) goto L29;
        String r18 = String.valueOf(r17.longValue());
        if (r18 == null) goto L29;
    L30:
        r1.put("avatar_id", r18);
        HamletAvatarContext r19 = r14.getContext();
        if (r19 == null) goto L39;
        j<g> r20 = r19.getHamletAvatarService();
        if (r20 == null) goto L39;
        g r21 = (g) r20.getValue();
        if (r21 == null) goto L39;
        if (r21.I6() != true) goto L39;
    L40:
        r1.put("is_multiplayer", r10);
        InteractiveSongContext r22 = r12.getContext();
        if (r22 == null) goto L47;
        m<Boolean> r23 = r22.isAIMVStage();
        if (r23 == null) goto L47;
        if (((Boolean) r23.getValue()).booleanValue() != true) goto L47;
        String r24 = "ai_stage_effect";
    L48:
        r1.put("sing_stage_effect_type", r24);
        b(r1);
        if (b.c() == false) goto L51;
        TalkRoomLogUtils.K(19, r1, 3);
        return;
    L51:
        k r25 = a();
        if (r25 == null) goto L56;
        k.l(r25, 19, r1, 3);
        return;
    L56:
        return;
    L47:
        r24 = "official_mv";
    L39:
        r10 = "0";
    L29:
        r18 = "0";
        goto L30
    L17:
        r13 = "2";
    L13:
        r3 = "0";
        goto L14
    L5:
        r11 = "0";
        goto L6
    }

    public static final void j(String r10, boolean r11, Integer r12, String r13, Boolean r14) {
        LinkedHashMap r8 = new LinkedHashMap();
        InteractiveSongContext r0 = InteractiveSongContext.Companion.getContext();
        String r2 = "0";
        if (r0 == null) goto L9;
        m<Boolean> r1 = r0.isSeatEnlarge();
        if (r1 == null) goto L9;
        if (((Boolean) r1.getValue()).booleanValue() != true) goto L9;
        Object r3 = "1";
    L10:
        r8.put("is_seat_enlarge", r3);
        String r4 = "";
        if (r10 != null) goto L13;
        r10 = "";
    L13:
        r8.put("open_user_type", r10);
        if (r11 == false) goto L16;
        String r15 = "1";
    L17:
        r8.put("is_ai_lyric_recognition", r15);
        if (r13 != null) goto L20;
        r13 = "classic";
    L20:
        r8.put("play_layout", r13);
        HamletAvatarContext.a r16 = HamletAvatarContext.Companion;
        HamletAvatarContext r17 = r16.getContext();
        if (r17 != null) goto L23;
    L25:
        Object r18 = "0";
    L26:
        r8.put("is_multiplayer", r18);
        HamletAvatarContext r19 = r16.getContext();
        if (r19 == null) goto L33;
        n<Long> r110 = r19.getCurrentSelectAvatarID();
        if (r110 == null) goto L33;
        Long r111 = (Long) r110.getValue();
        if (r111 == null) goto L33;
        r8.put("avatar_id", String.valueOf(r111.longValue()));
    L33:
        if (r12 != null) goto L36;
    L38:
        if (r12 != null) goto L41;
    L43:
        r8.put("sing_stage_effect_type", r4);
        if (Intrinsics.areEqual(r14, Boolean.TRUE) == false) goto L46;
        r2 = "1";
    L46:
        r8.put("mv_autoplay", r2);
        b(r8);
        u r112 = com.bytedance.android.live.liveinteract.api.utils.m.d();
        if (r112 == null) goto L55;
        j r113 = r112.s();
        if (r113 == null) goto L55;
        f r114 = (f) r113.getValue();
        if (r114 == null) goto L55;
        i r115 = r114.g();
        if (r115 == null) goto L55;
        Integer r116 = Integer.valueOf(r115.b);
    L56:
        String r5 = u0.j(r116);
        if (b.c() == false) goto L59;
        TalkRoomLogUtils.L(19, null, null, null, null, null, r8, 251);
        return;
    L59:
        k r6 = a();
        if (r6 == null) goto L64;
        k.m(r6, r5, 19, null, null, null, null, null, r8, 249);
        return;
    L64:
        return;
    L55:
        r116 = null;
        goto L56
    L41:
        if (r12.intValue() != 1) goto L43;
        r4 = "official_mv";
        goto L43
    L36:
        if (r12.intValue() != 2) goto L38;
        r4 = "ai_stage_effect";
        goto L43
    L23:
        if (r17.isMultiAvatarModeForReport() != true) goto L25;
        r18 = "1";
        goto L26
    L16:
        r15 = "2";
    L9:
        r3 = "0";
        goto L10
    }

    public static final void g(String r2, String r3, boolean r4, String r5, String r6, int r7) {
        Intrinsics.checkNotNullParameter(r2, "mvTab");
        Intrinsics.checkNotNullParameter(r3, "mvId");
        Intrinsics.checkNotNullParameter(r5, "itemId");
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("mv_tab", r2);
        r0.put("item_id", r5);
        r0.put("mv_id", r3);
        if (r4 == false) goto L5;
        String r8 = "1";
    L6:
        r0.put("is_privileged_mv", r8);
        r0.put("sing_stage_effect_type", r6);
        r0.put("is_default_mv", String.valueOf(r7));
        k r9 = a();
        if (r9 == null) goto L10;
        j0 r10 = j0.l();
        int r11 = k.g;
        r10.sendLog("livesdk_anchor_ksong_mv_play", r9.a(r0, false), new Object[]{IRoom.class, x.class});
        return;
    L10:
        return;
    L5:
        r8 = "0";
        goto L6
    }

    public static final void f(String r3, String r4, boolean r5, String r6, String r7, long r8, Integer r10, String r11) {
        Intrinsics.checkNotNullParameter(r3, "mvTab");
        Intrinsics.checkNotNullParameter(r4, "mvId");
        Intrinsics.checkNotNullParameter(r6, "itemId");
        Intrinsics.checkNotNullParameter(r7, "endType");
        final LinkedHashMap r0 = new LinkedHashMap();
        r0.put("mv_tab", r3);
        r0.put("duration", String.valueOf(r8 / ((long) 1000)));
        r0.put("end_type", r7);
        r0.put("item_id", r6);
        r0.put("mv_id", r4);
        if (r5 == false) goto L5;
        String r9 = "1";
    L6:
        r0.put("is_privileged_mv", r9);
        if (r10 == null) goto L9;
        r0.put("is_default_mv", String.valueOf(r10.intValue()));
        Unit r12 = Unit.INSTANCE;
    L10:
        r0.put("sing_stage_effect_type", r11);
        Unit r13 = Unit.INSTANCE;
        k r14 = a();
        if (r14 == null) goto L14;
        j0 r15 = j0.l();
        int r16 = k.g;
        r15.sendLog("livesdk_anchor_ksong_mv_play_duration", r14.a(r0, false), new Object[]{IRoom.class, x.class});
        return;
    L14:
        return;
    L9:
        new InteractiveSongLoggerKt$reportMvPlatDuration$2(r0);
        goto L10
    L5:
        r9 = "0";
        goto L6
    }
}
