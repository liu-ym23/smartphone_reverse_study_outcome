package com.bytedance.android.livesdk.chatroom.utils;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.widget.LiveVerticalViewPager;
import com.bytedance.android.livesdk.y8;
import java.util.Map;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class r1 {
    public static final /* synthetic */ int a = 0;

    static {
    }

    @JvmStatic
    public static final void a(LiveVerticalViewPager r2, String r3, long r4) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (y8.a.booleanValue() == true) goto L6;
        return;
    L6:
        if (r2.getOffscreenPageLimit() > 0) goto L19;
        r2.setOffscreenPageLimit(1);
        ALogger.i("LiveViewPagerCacheHelper", "enableCache trigger: " + r3);
        if (r4 <= 0) goto L20;
        Map r0 = com.bytedance.android.livesdk.chatroom.helper.n.a;
        if (r4 >= 0) goto L12;
        return;
    L12:
        if (com.bytedance.android.livesdk.chatroom.helper.n.c.booleanValue() == false) goto L22;
        if (r3 == null) goto L23;
        com.bytedance.android.livesdk.chatroom.helper.n.b.put(Long.valueOf(r4), r3);
        return;
    L23:
        return;
    L22:
        return;
    L20:
        return;
    }
}
