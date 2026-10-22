package com.bytedance.android.livesdk.chatroom.utils;

import com.bytedance.android.livesdkapi.depend.model.live.Room;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class p {
    public static long a;
    public static final a b = null;

    public static final class a {
        public a() {
        }

        public static void a(String r9) {
            Intrinsics.checkNotNullParameter(r9, "clearType");
            if (wt2.a.e(Boolean.FALSE) == false) goto L5;
            return;
        L5:
            HashMap r0 = new HashMap();
            r0.put("clear_type", r9);
            long r1 = System.currentTimeMillis() - p.a;
            if (r1 > 0) goto L8;
            r1 = 10;
        L8:
            String r10 = String.valueOf(r1);
            if (r10 != null) goto L11;
            return;
        L11:
            int r2 = StringsKt.indexOf$default(r10, '.', 0, false, 6, null);
            if (r2 >= 0) goto L14;
        L16:
            r0.put("duration", r10);
            r0.put("simple_mode_duration", "0");
            r0.put("pure_mode_duration", "0");
            com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_live_duration_under_screen_clear", r0, new Object[]{new am2.x(), Room.class});
            return;
        L14:
            if (r2 > r10.length()) goto L16;
            r10 = r10.substring(0, r2);
            goto L16
        }
    }

    static {
        b = new a();
        com.bytedance.android.live.core.utils.s1.f(8.0f);
        com.bytedance.android.live.core.utils.s1.f(4.0f);
        a = System.currentTimeMillis();
    }
}
