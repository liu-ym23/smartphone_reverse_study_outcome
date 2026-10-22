package com.bytedance.android.livesdk.feed;

import com.bytedance.android.livesdk.utils.e5;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class v0 {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(String r3, String r4, String r5, int r6) {
        Intrinsics.checkNotNullParameter(r3, "drawerPage");
        Intrinsics.checkNotNullParameter(r4, "enterFromMerge");
        Intrinsics.checkNotNullParameter("drawer_over", "enterMethod");
        Intrinsics.checkNotNullParameter(r5, "actionType");
        HashMap r0 = new HashMap();
        r0.put("action_type", r5);
        r0.put("drawer_page", r3);
        r0.put("enter_from_merge", r4);
        r0.put("enter_method", "drawer_over");
        if (e5.n() == false) goto L5;
        String r7 = "landscape";
    L6:
        r0.put("screen_direction", r7);
        r0.put("drawer_tab", r4);
        if (r6 != 11) goto L9;
        r0.put("EVENT_ORIGIN_FEATURE", "TEMAI");
    L9:
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_drawer_tab", r0, new Object[0]);
        return;
    L5:
        r7 = "portrait";
        goto L6
    }
}
