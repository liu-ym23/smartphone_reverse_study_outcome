package com.bytedance.android.live.liveinteract.voicechat.subtitle;

import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.plantform.utils.u0;
import com.bytedance.android.livesdk.chatroom.model.interact.LinkmicSubtitleType;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class t {
    public static final s a = null;

    static {
        a = new s();
    }

    public static void j() {
        s r0 = a;
        Map<String, Boolean> r1 = r0.d;
        Boolean r2 = Boolean.FALSE;
        r1.put("ksong", r2);
        r0.d.put("clean_screen", r2);
        r0.d.put("record", r2);
        r0.d.put("key_board", r2);
        r0.c.put("ksong", 0L);
        r0.c.put("clean_screen", 0L);
        r0.c.put("record", 0L);
        r0.c.put("key_board", 0L);
    }

    public static long a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "requestPage");
        Long r3 = a.c.get(r2);
        if (r3 != null) goto L7;
        return 0;
    L7:
        return r3.longValue();
    }

    public static String b(Integer r1) {
        int r0 = LinkmicSubtitleType.Enlarged.ordinal();
        if (r1 != null) goto L6;
    L8:
        return "normal";
    L6:
        if (r1.intValue() != r0) goto L8;
        return "enlarge";
    }

    public static void c(boolean r4) {
        LinkedHashMap r0 = new LinkedHashMap();
        TalkRoomLogUtils.B0(r0, null, null, 6);
        if (r4 == false) goto L5;
        String r5 = "on";
    L6:
        r0.put("action_type", r5);
        j0.l().sendLog("livesdk_anchor_rt_caption_privilege_setting", r0, new Object[]{IRoom.class});
        return;
    L5:
        r5 = "off";
        goto L6
    }

    public static void d(String r4) {
        Intrinsics.checkNotNullParameter(r4, "requestPage");
        LinkedHashMap r0 = new LinkedHashMap();
        TalkRoomLogUtils.B0(r0, null, null, 6);
        i(r0);
        r0.put("request_page", r4);
        r0.put("play_mode", u0.b());
        j0.l().sendLog("livesdk_audience_voiceroom_caption_close", r0, new Object[]{IRoom.class});
    }

    public static void f(String r6) {
        Intrinsics.checkNotNullParameter(r6, "requestPage");
        LinkedHashMap r1 = new LinkedHashMap();
        TalkRoomLogUtils.B0(r1, null, null, 6);
        Intrinsics.checkNotNullParameter(r6, "requestPage");
        Long r0 = a.c.get(r6);
        long r2 = 0;
        if (r0 == null) goto L5;
        long r4 = r0.longValue();
    L7:
        if (r4 == 0) goto L10;
        r2 = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - r4);
    L10:
        r1.put("duration", String.valueOf(r2));
        r1.put("request_page", r6);
        i(r1);
        j0.l().sendLog("livesdk_anchor_caption_pause_duration", r1, new Object[]{IRoom.class});
        return;
    L5:
        r4 = 0;
        goto L7
    }

    public static void i(Map r2) {
        Intrinsics.checkNotNullParameter(r2, "logMap");
        com.bytedance.android.livesdk.chatroom.o r0 = com.bytedance.android.live.liveinteract.api.utils.m.i();
        if (r0 != null) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(r0.isAnchor(), Boolean.TRUE) == false) goto L7;
        String r1 = "anchor";
    L14:
        r2.put("user_type", r1);
        return;
    L7:
        Integer r3 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r3 != null) goto L11;
    L13:
        r1 = "audience";
        goto L14
    L11:
        if (r3.intValue() != 2) goto L13;
        r1 = "guest";
        goto L14
    }

    public static void g(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "requestPage");
        Intrinsics.checkNotNullParameter(r4, "btnType");
        LinkedHashMap r0 = new LinkedHashMap();
        TalkRoomLogUtils.B0(r0, null, null, 6);
        i(r0);
        r0.put("request_page", r3);
        r0.put("btn_type", r4);
        r0.put("play_mode", u0.b());
        j0.l().sendLog("livesdk_caption_setting_menu_click", r0, new Object[]{IRoom.class});
    }

    public static void h(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "subtitleType");
        if (LinkmicSubtitleBusinessContext.Companion.d() == true) goto L5;
        return;
    L5:
        LinkedHashMap r0 = new LinkedHashMap();
        TalkRoomLogUtils.B0(r0, null, null, 6);
        i(r0);
        if (r3 == null) goto L8;
        r0.put("enlarge_show_type", r3);
    L8:
        r0.put("caption_type", r4);
        j0.l().sendLog("livesdk_audience_voiceroom_caption_use", r0, new Object[]{IRoom.class});
    }

    public static void e(String r6, String r7, String r8) {
        Intrinsics.checkNotNullParameter(r8, "subtitleType");
        LinkedHashMap r0 = new LinkedHashMap();
        TalkRoomLogUtils.B0(r0, null, null, 6);
        i(r0);
        if (r6 == null) goto L5;
        r0.put("request_page", r6);
    L5:
        s r9 = a;
        r9.getClass();
        r0.put("duration", String.valueOf(TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - r9.b)));
        if (r7 == null) goto L8;
        r0.put("enlarge_show_type", r7);
    L8:
        r0.put("caption_type", r8);
        r0.put("play_mode", u0.b());
        if (r9.b == 0) goto L12;
        j0.l().sendLog("livesdk_audience_voiceroom_caption_layout_use_duration", r0, new Object[]{IRoom.class});
        return;
    }
}
