package com.bytedance.android.live.liveinteract.videotalk.ui.theme;

import am2.x;
import android.os.SystemClock;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.plantform.utils.u0;
import com.bytedance.android.live.liveinteract.utils.w;
import com.bytedance.android.live.ui.p;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.interact.model.d0;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import java.util.LinkedHashMap;
import java.util.Map;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class VideoLiveThemeReporter implements p {
    public static final Lazy f = null;
    public static final a g = null;
    public long a;
    public IVoiceLiveTheme b;
    public final Map<String, String> c;
    public boolean d;
    public final int e;

    public static final class a {
        public a() {
        }

        public static void a(IVoiceLiveTheme r12, boolean r13, int r14) {
            if (r12 != null) goto L4;
            return;
        L4:
            Room r0 = m.i().getCurrentRoom();
            IRoom r1 = null;
            if (r0 == null) goto L7;
            Long r2 = Long.valueOf(r0.getId());
        L8:
            LinkedHashMap r3 = new LinkedHashMap();
            r3.put("anchor_id", k.n(IMiddlewareUserService.class).user().n().toString());
            String r4 = r12.getImageUri();
            String r5 = "";
            if (r4 != null) goto L11;
            r4 = "";
        L11:
            r3.put("pic_uri", r4);
            r3.put("template_id", String.valueOf(r12.getId()));
            if (r13 == false) goto L14;
            String r15 = "0";
        L15:
            r3.put("is_default", r15);
            if (r2 != null) goto L18;
            r3.put("event_page", "live_take_page");
        L19:
            r3.put("play_mode", w.a());
            int r16 = r12.getFormatType();
            if (r16 == 1) goto L24;
            if (r16 != 2) goto L25;
            r5 = "dynamic";
        L25:
            r3.put("pic_type", r5);
            int r17 = r12.getBgType();
            if (r17 == 3) goto L29;
            if (r17 == 4) goto L29;
            Object r18 = "voice_live";
        L30:
            r3.put("live_type", r18);
            if (r14 == 1) goto L50;
            if (r14 == 2) goto L44;
            if (r14 == 3) goto L43;
            if (r14 != 4) goto L36;
            r3.put("live_type", "video_live");
            r3.put("function_type", "ktv");
        L51:
            r3.put("function_type2", TalkRoomLogUtils.h);
            r3.put("template_id", String.valueOf(r12.getId()));
            if (r2 != null) goto L54;
            j0.l().sendLog("livesdk_anchor_theme_select", r3, new Object[0]);
            return;
        L54:
            r3.put("room_id", String.valueOf(r2.longValue()));
            j0.l().sendLog("livesdk_anchor_theme_select", r3, new Object[]{IRoom.class});
            return;
        L36:
            if (r14 != 5) goto L38;
            r3.put("live_type", "voice_live");
            r3.put("function_type", "live");
            goto L51
        L38:
            if (r14 != 100) goto L51;
            r3.put("live_type", "voice_live");
            r3.put("function_type", "chorus");
            goto L51
        L43:
            r3.put("live_type", "video_live");
            TalkRoomLogUtils.B0(r3, null, null, 6);
            goto L51
        L44:
            r3.put("live_type", "voice_live");
            r3.put("function_type", "radio");
            com.bytedance.live.datacontext.m r19 = m.i().getRoom();
            if (r19 == null) goto L48;
            r1 = (IRoom) r19.getValue();
        L48:
            if (d0.h(r1) == false) goto L51;
            r3.put("function_type", "party");
            goto L51
        L50:
            r3.put("live_type", "voice_live");
            r3.put("function_type", "ktv");
        L29:
            r18 = "video_live";
            goto L30
        L24:
            r5 = "static";
            goto L25
        L18:
            r3.put("event_page", "live_take_detail");
            goto L19
        L14:
            r15 = "1";
            goto L15
        L7:
            r2 = null;
            goto L8
        }
    }

    static {
        g = new a();
        f = LazyKt.lazy(VideoLiveThemeReporter$Companion$reporter$2.INSTANCE);
    }

    public VideoLiveThemeReporter() {
        this.d = false;
        this.e = 3;
        this.c = new LinkedHashMap();
    }

    public final void a(IVoiceLiveTheme r15) {
        ((LinkedHashMap) this.c).clear();
        Map<String, String> r0 = this.c;
        String r2 = "dynamic";
        int r8 = 0;
        Long r10 = null;
        if (this.d == false) goto L20;
        LinkedHashMap r1 = new LinkedHashMap();
        if (r15 == null) goto L8;
        String r13 = r15.getImageUri();
        if (r13 == null) goto L8;
    L9:
        r1.put("pic_uri", r13);
        if (r15 == null) goto L12;
        r10 = Long.valueOf(r15.getId());
    L12:
        r1.put("template_id", String.valueOf(r10));
        b(r1, this.e);
        if (r15 == null) goto L15;
        r8 = r15.getFormatType();
    L15:
        if (r8 == 1) goto L18;
        if (r8 == 2) goto L19;
        r2 = "";
    L19:
        r1.put("pic_type", r2);
        r1.put("play_mode", u0.b());
    L36:
        r0.putAll(r1);
        return;
    L18:
        r2 = "static";
    L8:
        r13 = "";
        goto L9
    L20:
        r1 = new LinkedHashMap();
        if (r15 == null) goto L24;
        String r14 = r15.getImageUri();
        if (r14 == null) goto L24;
    L25:
        r1.put("pic_uri", r14);
        if (r15 == null) goto L28;
        r10 = Long.valueOf(r15.getId());
    L28:
        r1.put("template_id", String.valueOf(r10));
        b(r1, this.e);
        if (r15 == null) goto L31;
        r8 = r15.getFormatType();
    L31:
        if (r8 == 1) goto L34;
        if (r8 == 2) goto L35;
        r2 = "";
    L35:
        r1.put("pic_type", r2);
        r1.put("play_mode", u0.b());
        goto L36
    L34:
        r2 = "static";
    L24:
        r14 = "";
        goto L25
    }

    public final void onThemeChanged(IVoiceLiveTheme r7) {
        boolean r0 = false;
        if (r7 != null) goto L5;
    L25:
        if (r7 == null) goto L28;
        r7.setChoosing(false);
        return;
    L28:
        return;
    L5:
        if (r7.getChoosing() == true) goto L25;
        if (r7.getBgType() == 3) goto L11;
        return;
    L11:
        if (Intrinsics.areEqual(this.b, r7) == false) goto L14;
        return;
    L14:
        if (this.d == true) goto L16;
        TalkRoomLogUtils.i0(r7, this.e);
    L20:
        long r3 = 0;
        if (this.a <= 0) goto L23;
        r3 = SystemClock.elapsedRealtime() - this.a;
    L23:
        c(r3, r7, true);
        this.a = SystemClock.elapsedRealtime();
        this.b = r7;
        a(r7);
        return;
    L16:
        a r1 = g;
        if (this.b == null) goto L19;
        r0 = true;
    L19:
        int r4 = r7.getBgType();
        r1.getClass();
        a.a(r7, r0, r4);
        goto L20
    }

    public final void onThemeEnd(IVoiceLiveTheme r7) {
        if (Intrinsics.areEqual(this.b, r7) == false) goto L6;
        return;
    L6:
        if (this.a <= 0) goto L8;
        long r0 = SystemClock.elapsedRealtime() - this.a;
    L9:
        c(r0, r7, false);
        this.b = null;
        this.a = 0;
        ((LinkedHashMap) this.c).clear();
        return;
    L8:
        r0 = 0;
        goto L9
    }

    public final void onThemeStart(IVoiceLiveTheme r4) {
        if (r4 != null) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(this.b, r4) == false) goto L8;
        return;
    L8:
        if (r4.getBgType() == 3) goto L11;
        return;
    L11:
        if (this.d == true) goto L13;
        TalkRoomLogUtils.i0(r4, this.e);
    L18:
        this.a = SystemClock.elapsedRealtime();
        this.b = r4;
        a(r4);
        return;
    L13:
        a r0 = g;
        if (this.b == null) goto L16;
        boolean r1 = true;
    L17:
        int r2 = r4.getBgType();
        r0.getClass();
        a.a(r4, r1, r2);
        goto L18
    L16:
        r1 = false;
        goto L17
    }

    public final void b(Map<String, String> r8, int r9) {
        if (r9 == 1) goto L25;
        IRoom r5 = null;
        if (r9 != 2) goto L7;
        r8.put("live_type", "voice_live");
        r8.put("function_type", "radio");
        com.bytedance.live.datacontext.m r10 = m.i().getRoom();
        if (r10 == null) goto L23;
        r5 = (IRoom) r10.getValue();
    L23:
        if (d0.h(r5) == false) goto L26;
        r8.put("function_type", "party");
    L26:
        r8.put("function_type2", TalkRoomLogUtils.h);
        return;
    L7:
        if (r9 != 3) goto L9;
        r8.put("live_type", "video_live");
        TalkRoomLogUtils.B0(r8, null, null, 6);
        goto L26
    L9:
        if (r9 != 4) goto L11;
        r8.put("live_type", "video_live");
        r8.put("function_type", "ktv");
        goto L26
    L11:
        if (r9 != 5) goto L13;
        r8.put("live_type", "voice_live");
        r8.put("function_type", "live");
        goto L26
    L13:
        if (r9 != 100) goto L26;
        r8.put("live_type", "voice_live");
        r8.put("function_type", "chorus");
        goto L26
    L25:
        r8.put("live_type", "voice_live");
        r8.put("function_type", "ktv");
        goto L26
    }

    public final void c(long r9, IVoiceLiveTheme r11, boolean r12) {
        if (this.d == false) goto L9;
        if (r9 == 0) goto L27;
        this.c.put("duration", "" + r9);
        j0.l().sendLog("livesdk_anchor_theme_select_duration", MapsKt.toMap(this.c), new Object[]{IRoom.class, x.class});
        return;
    L27:
        return;
    L9:
        if (r9 == 0) goto L28;
        Map<String, String> r0 = this.c;
        if (r12 == true) goto L18;
        if (r11 != null) goto L16;
    L19:
        String r13 = "leave";
    L20:
        r0.put("end_type", r13);
        this.c.put("duration", "" + r9);
        Map<String, String> r10 = this.c;
        if (r11 == null) goto L23;
        Long r14 = Long.valueOf(r11.getId());
    L24:
        r10.put("template_id", String.valueOf(r14));
        j0.l().sendLog("livesdk_live_theme_duration", MapsKt.toMap(this.c), new Object[]{IRoom.class, x.class});
        return;
    L23:
        r14 = null;
        goto L24
    L16:
        if (r11.getChangeByAnchor() != true) goto L19;
        r11.setChangeByAnchor(false);
    L18:
        r13 = "anchor";
        goto L20
    }
}
