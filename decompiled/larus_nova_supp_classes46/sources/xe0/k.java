package xe0;

import am2.x;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class k {
    public static final boolean a = false;

    public k() {
    }

    static {
        a = jc1.k.n(IKtvService.class).isUserSelectMusic(jc1.k.n(IMiddlewareUserService.class).user().n());
    }

    public static void e() {
        HashMap r0 = new HashMap();
        if (a == false) goto L5;
        String r1 = "1";
    L6:
        r0.put("is_song_order", r1);
        Integer r2 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r2 != null) goto L10;
    L12:
        if (r2 != null) goto L15;
    L17:
        String r3 = PbRequest.SwitchType.OTHER;
    L18:
        r0.put("link_status", r3);
        j0.l().sendLog("livesdk_audience_apply_reserve_cancel", r0, new Object[]{IRoom.class, x.class});
        return;
    L15:
        if (r2.intValue() != 1) goto L17;
        r3 = "apply";
        goto L18
    L10:
        if (r2.intValue() != 2) goto L12;
        r3 = "link";
        goto L18
    L5:
        r1 = "0";
        goto L6
    }

    public static void a(boolean r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "clickButton");
        HashMap r0 = new HashMap();
        if (r3 == false) goto L5;
        String r5 = "1";
    L6:
        r0.put("is_auto_confirm", r5);
        r0.put("trigger_scene", "connection");
        r0.put("click_button", r4);
        j0.l().sendLog("livesdk_mini_window_popup_click", r0, new Object[]{IRoom.class, x.class});
        return;
    L5:
        r5 = "0";
        goto L6
    }

    public static void b(int r3, int r4, String r5, HashMap r6) {
        Intrinsics.checkNotNullParameter(r5, "functionType");
        HashMap r0 = new HashMap();
        if (a == false) goto L5;
        String r1 = "1";
    L6:
        r0.put("is_song_order", r1);
        r0.put("trigger_scene", "connection");
        r0.put("windows_type", "in");
        r0.put("initial_page", "content");
        if (vm2.d.v0() == false) goto L9;
        r0.put("function_type", r5);
        r0.put("function_type2", r5);
    L10:
        r0.putAll(r6);
        j0.l().sendLog("livesdk_mini_window_close", r0, new Object[]{IRoom.class, x.class});
        return;
    L9:
        TalkRoomLogUtils.A0(r0, Integer.valueOf(r3), Integer.valueOf(r4));
        goto L10
    L5:
        r1 = "0";
        goto L6
    }

    public static void d(int r5, int r6, String r7, HashMap r8) {
        Intrinsics.checkNotNullParameter(r7, "functionType");
        HashMap r0 = new HashMap();
        if (a == false) goto L5;
        String r1 = "1";
    L6:
        r0.put("is_song_order", r1);
        Integer r2 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r2 != null) goto L10;
    L12:
        if (r2 != null) goto L15;
    L17:
        String r3 = PbRequest.SwitchType.OTHER;
    L18:
        r0.put("link_status", r3);
        r0.put("trigger_scene", "connection");
        r0.put("windows_type", "in");
        r0.put("initial_page", "content");
        if (vm2.d.v0() == false) goto L21;
        r0.put("function_type", r7);
        r0.put("function_type2", r7);
    L22:
        r0.putAll(r8);
        j0.l().sendLog("livesdk_mini_window_live_play", r0, new Object[]{IRoom.class, x.class});
        return;
    L21:
        TalkRoomLogUtils.A0(r0, Integer.valueOf(r5), Integer.valueOf(r6));
        goto L22
    L15:
        if (r2.intValue() != 1) goto L17;
        r3 = "apply";
        goto L18
    L10:
        if (r2.intValue() != 2) goto L12;
        r3 = "link";
        goto L18
    L5:
        r1 = "0";
        goto L6
    }

    public static void c(int r3, int r4, String r5, long r6, HashMap r8) {
        Intrinsics.checkNotNullParameter(r5, "functionType");
        HashMap r0 = new HashMap();
        if (a == false) goto L5;
        String r1 = "1";
    L6:
        r0.put("is_song_order", r1);
        r0.put("trigger_scene", "connection");
        r0.put("windows_type", "in");
        r0.put("initial_page", "content");
        r0.put("duration", String.valueOf(r6));
        if (vm2.d.v0() == false) goto L9;
        r0.put("function_type", r5);
        r0.put("function_type2", r5);
    L10:
        r0.putAll(r8);
        j0.l().sendLog("livesdk_mini_window_live_duration", r0, new Object[]{IRoom.class, x.class});
        return;
    L9:
        TalkRoomLogUtils.A0(r0, Integer.valueOf(r3), Integer.valueOf(r4));
        goto L10
    L5:
        r1 = "0";
        goto L6
    }

    public static void f(int r3, int r4, String r5, String r6, HashMap r7) {
        Intrinsics.checkNotNullParameter(r5, "functionType");
        Intrinsics.checkNotNullParameter(r6, "returnMethod");
        HashMap r0 = new HashMap();
        if (a == false) goto L5;
        String r1 = "1";
    L6:
        r0.put("is_song_order", r1);
        r0.put("return_method", r6);
        r0.put("trigger_scene", "connection");
        r0.put("windows_type", "in");
        r0.put("initial_page", "content");
        if (vm2.d.v0() == false) goto L9;
        r0.put("function_type", r5);
        r0.put("function_type2", r5);
    L10:
        r0.putAll(r7);
        j0.l().sendLog("livesdk_mini_window_return_full", r0, new Object[]{IRoom.class, x.class});
        return;
    L9:
        TalkRoomLogUtils.A0(r0, Integer.valueOf(r3), Integer.valueOf(r4));
        goto L10
    L5:
        r1 = "0";
        goto L6
    }
}
