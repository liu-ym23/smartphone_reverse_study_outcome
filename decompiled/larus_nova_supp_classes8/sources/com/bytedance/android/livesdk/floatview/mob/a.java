package com.bytedance.android.livesdk.floatview.mob;

import am2.x;
import com.bytedance.android.live.core.utils.m2;
import com.bytedance.android.livesdk.log.g;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(boolean r4) {
        HashMap r0 = new HashMap();
        r0.put("click_result", m2.b(r4));
        u.l().sendLog("livesdk_mini_window_popup_autoset_click", r0, new Object[]{Room.class, x.class});
    }

    public static void b(HashMap r4) {
        HashMap r0 = new HashMap();
        r0.putAll(r4);
        u.l().sendLog("livesdk_mini_window_popup_click", r0, new Object[]{Room.class, x.class});
    }

    public static void c(String r4) {
        Intrinsics.checkNotNullParameter(r4, "state");
        Intrinsics.checkNotNullParameter("live_detail", "eventPage");
        g r0 = u.l();
        HashMap r2 = new HashMap();
        r2.put("click_result", r4);
        Unit r5 = Unit.INSTANCE;
        x r3 = new x();
        r3.b = "live_detail";
        r0.sendLog("livesdk_part_mini_window_set_click", r2, new Object[]{r3, Room.class});
    }
}
