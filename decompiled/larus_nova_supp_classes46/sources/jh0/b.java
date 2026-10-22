package jh0;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.revenue.adventure.linkcore.g;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b {
    public static c a;

    public static void a() {
        ALogger.i("DynamicBizExtController", "onDynamicWidgetDestroy");
        c r0 = a;
        if (r0 != null) goto L5;
    L13:
        a = null;
        com.bytedance.android.live.liveinteract.revenue.adventure.linkcore.a r1 = g.a;
        g.d("onDynamicWidgetDestroy");
        return;
    L5:
        if (gh0.a.d() == true) goto L13;
        ALogger.i("DynamicBizLogHelper", "onDynamicWidgetDestroy");
        hd0.c.f().e(r0.c);
        if ((!r0.a.isEmpty()) == false) goto L12;
        r0.a(null);
        if (hd0.c.f().h() == false) goto L12;
        r0.c(null);
    L12:
        ((LinkedHashMap) r0.a).clear();
        goto L13
    }

    static {
    }
}
