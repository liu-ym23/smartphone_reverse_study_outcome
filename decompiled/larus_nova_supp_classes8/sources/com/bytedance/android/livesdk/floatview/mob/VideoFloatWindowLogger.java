package com.bytedance.android.livesdk.floatview.mob;

import am2.r;
import am2.x;
import android.os.SystemClock;
import com.bytedance.android.live.core.utils.h1;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.android.livesdk.floatview.p;
import com.bytedance.android.livesdk.log.g;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.utils.i4;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.floatview.FloatWindowRevisitParam;
import gd0.v;
import java.util.HashMap;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class VideoFloatWindowLogger {
    public static final Lazy a = null;

    public static final class a {
        public static VideoFloatWindowLogger a() {
            return (VideoFloatWindowLogger) VideoFloatWindowLogger.a.getValue();
        }
    }

    public VideoFloatWindowLogger() {
    }

    static {
        a = LazyKt.lazy(VideoFloatWindowLogger$Companion$instance$2.INSTANCE);
    }

    public static boolean a() {
        if (k.n(IInteractService.class).getVideoTalkService().u(false, k.n(IUserService.class).user().n()) == false) goto L5;
    L6:
        return true;
    L5:
        if (k.n(IInteractService.class).getAudioTalkService().B(k.n(IUserService.class).user().n()) == true) goto L6;
        return false;
    }

    public static void d() {
        Intrinsics.checkNotNullParameter("live_detail", "eventPage");
        g r0 = u.l();
        x r3 = new x();
        r3.a = "live_view";
        r3.b = "live_detail";
        r3.f = "click";
        r0.sendLog("mini_window_setting_open", null, new Object[]{r3, Room.class});
    }

    public static void f() {
        g r0 = u.l();
        HashMap r1 = new HashMap();
        boolean r2 = p.a;
        if (p.d(jc1.a.b()) == false) goto L5;
    L8:
        r1.put("switch_type", "mini_window");
    L9:
        i4.a(r1);
        i4.b(r1);
        int r3 = k.n(IInteractService.class).getLinkMode();
        if (v.a(r3, 8) == true) goto L14;
        if (v.a(r3, 32) == true) goto L14;
    L17:
        String r4 = "1";
        if (a() == false) goto L25;
        if (k.n(IInteractService.class).enableCaptureAudioOnBackground(true) == false) goto L22;
        Object r5 = "1";
    L23:
        r1.put("is_voice", r5);
        goto L25
    L22:
        r5 = "0";
    L25:
        if (p.e() == false) goto L32;
        if (p.f() == true) goto L30;
        r4 = "0";
    L30:
        r1.put("is_valid", r4);
    L36:
        r1.put("network_type", u.k());
        Room r6 = k.n(IRoomService.class).getCurrentRoom();
        if (r6 == null) goto L39;
        r1.putAll(h1.a(r6));
    L39:
        Unit r7 = Unit.INSTANCE;
        x r8 = new x();
        r8.a = "live_view";
        r8.b = "live_detail";
        r8.f = "click";
        r0.sendLog("live_exit_backgroud", r1, new Object[]{r8, new r("out", "", "", true), Room.class});
        return;
    L32:
        if (p.d(jc1.a.b()) == true) goto L35;
        r4 = "0";
    L35:
        r1.put("is_valid", r4);
    L14:
        if (a() == false) goto L16;
        r1.put("user_type", "connection_user");
        goto L17
    L16:
        r1.put("user_type", "live_user");
        goto L17
    L5:
        if (p.e() == true) goto L8;
        r1.put("switch_type", "normal");
        goto L9
    }

    public static void b(String r3) {
        Intrinsics.checkNotNullParameter(r3, LiveEndPageData.TAG_NAME);
        g r0 = u.l();
        HashMap r1 = new HashMap();
        r1.put("business_name", r3);
        Unit r4 = Unit.INSTANCE;
        r0.sendLog("livesdk_float_window_new_business_source", r1, new Object[0]);
    }

    public static void c(String r4) {
        Intrinsics.checkNotNullParameter(r4, "clickButton");
        g r0 = u.l();
        HashMap r1 = new HashMap();
        r1.put("click_button", r4);
        Unit r5 = Unit.INSTANCE;
        x r2 = new x();
        r2.a = "live_view";
        r2.b = "live_detail";
        r2.f = "click";
        r0.sendLog("mini_window_guide_click", r1, new Object[]{r2, Room.class});
    }

    public static void e(boolean r4) {
        g r0 = u.l();
        HashMap r1 = new HashMap();
        if (r4 == false) goto L5;
        String r5 = "inner_to_outside";
    L6:
        r1.put("mini_window_switch_mode", r5);
        Unit r6 = Unit.INSTANCE;
        r0.sendLog("livesdk_mini_window_inner_outside_switch", r1, new Object[]{new x(), Room.class});
        return;
    L5:
        r5 = "outside_to_inner";
        goto L6
    }

    public static void g(String r13) {
        HashMap r0 = new HashMap();
        if (r13 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        if (r3 == true) goto L11;
        r0.put("business_line", r13);
    L11:
        RoomContext.a r14 = RoomContext.Companion;
        RoomContext r7 = RoomContext.a.c(r14, null, 0, 3);
        if (r7 == null) goto L18;
        long r8 = r7.getRevisitTimestamp();
        FloatWindowRevisitParam r9 = r7.getFloatWindowRevisitParam();
        if (r8 <= 0) goto L16;
        r0.put("duration", String.valueOf(SystemClock.elapsedRealtime() - r8));
    L16:
        if (r9 == null) goto L18;
        r0.put("return_windows_type", r9.getRevisitWindowsType());
        r0.put("initial_page", r9.getInitialPage());
        r0.put("is_mini_auto_play", r9.isMiniWindowAutoPlay());
        r0.put("trigger_scene", r9.getTriggerScene());
        r0.put("duration", String.valueOf(SystemClock.elapsedRealtime() - r9.getRevisitTimestamp()));
    L18:
        u.l().sendLog("livesdk_mini_window_return_duration", r0, new Object[]{new x(), Room.class});
        RoomContext r1 = RoomContext.a.c(r14, null, 0, 3);
        if (r1 == null) goto L21;
        r1.setFloatWindowRevisitParam(null);
    L21:
        RoomContext r15 = RoomContext.a.c(r14, null, 0, 3);
        if (r15 == null) goto L25;
        r15.setRevisitTimestamp(0);
        return;
    L25:
        return;
    L5:
        if (r13.length() == 0) goto L8;
        r3 = false;
        goto L9
    }
}
