package com.bytedance.android.live.liveinteract.videotalk.selfdiscipline;

import android.text.TextUtils;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.plantform.utils.i0;
import com.bytedance.android.live.liveinteract.plantform.utils.u0;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.LinkedHashMap;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b {
    public static final a a = null;

    static {
        a = new a();
    }

    public static void c() {
        a.f = System.currentTimeMillis();
        LinkedHashMap r0 = new LinkedHashMap();
        TalkRoomLogUtils.J0(r0);
        TalkRoomLogUtils.B0(r0, null, null, 6);
        TalkRoomLogUtils.V0(r0);
        r0.put("play_mode", "self_discipline");
        r0.put("enter_from_merge", a.a());
        r0.put("enter_method", a.b());
        j0.l().sendLog("livesdk_audience_playmode_room_link", r0, new Object[]{IRoom.class});
    }

    public static void d() {
        LinkedHashMap r0 = new LinkedHashMap();
        TalkRoomLogUtils.J0(r0);
        TalkRoomLogUtils.B0(r0, null, null, 6);
        TalkRoomLogUtils.V0(r0);
        r0.put("play_mode", "self_discipline");
        a r1 = a;
        r1.getClass();
        r0.put("duration", String.valueOf(TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - r1.f)));
        r0.put("enter_from_merge", a.a());
        r0.put("enter_method", a.b());
        j0.l().sendLog("livesdk_audience_playmode_room_link_duration", r0, new Object[]{IRoom.class});
    }

    public static void e() {
        a.d = System.currentTimeMillis();
        LinkedHashMap r0 = new LinkedHashMap();
        TalkRoomLogUtils.J0(r0);
        TalkRoomLogUtils.B0(r0, null, null, 6);
        TalkRoomLogUtils.V0(r0);
        r0.put("play_mode", "self_discipline");
        r0.put("enter_from_merge", a.a());
        r0.put("enter_method", a.b());
        i0 r1 = TalkRoomLogUtils.a;
        TalkRoomLogUtils.c1(r0);
        zi0.d.b(r0, false);
        j0.l().sendLog("livesdk_audience_playmode_room_watch", r0, new Object[]{IRoom.class});
    }

    public static void b(String r6) {
        Intrinsics.checkNotNullParameter(r6, "target");
        LinkedHashMap r0 = new LinkedHashMap();
        TalkRoomLogUtils.J0(r0);
        TalkRoomLogUtils.B0(r0, null, null, 6);
        TalkRoomLogUtils.V0(r0);
        r0.put("discipline_theme", r6);
        a r7 = a;
        r7.getClass();
        r0.put("room_info", a.c());
        r0.put("duration", String.valueOf(TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - r7.c)));
        r0.put("play_mode", u0.b());
        r0.put("enter_from_merge", a.a());
        r0.put("enter_method", a.b());
        r0.put("open_source", r7.b);
        LinkedHashMap r8 = (LinkedHashMap) TalkRoomLogUtils.g;
        if (TextUtils.isEmpty((CharSequence) r8.get(17)) == true) goto L8;
        String r9 = (String) r8.get(17);
        if (r9 != null) goto L7;
        r9 = "";
    L7:
        r0.put("source", r9);
    L8:
        zi0.d.b(r0, false);
        j0.l().sendLog("livesdk_anchor_playmode_over", r0, new Object[]{IRoom.class});
    }

    public static void a(String r4, long r5) {
        Intrinsics.checkNotNullParameter(r4, "target");
        a r0 = a;
        r0.c = System.currentTimeMillis();
        LinkedHashMap r1 = new LinkedHashMap();
        TalkRoomLogUtils.J0(r1);
        TalkRoomLogUtils.B0(r1, null, null, 6);
        TalkRoomLogUtils.V0(r1);
        r1.put("discipline_theme", r4);
        r1.put("discipline_time_target", String.valueOf(r5 / ((long) 60)));
        r1.put("room_info", a.c());
        r1.put("play_mode", u0.b());
        r1.put("source", r0.a);
        r1.put("enter_from_merge", a.a());
        r1.put("enter_method", a.b());
        TalkRoomLogUtils.g.put(17, r0.a);
        zi0.d.b(r1, false);
        j0.l().sendLog("livesdk_anchor_playmode_open_success", r1, new Object[]{IRoom.class});
    }
}
