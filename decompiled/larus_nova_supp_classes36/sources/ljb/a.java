package ljb;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.watermark.userscope.WatermarkModuleV3;
import com.ss.android.lark.watermark.userscope.c;
import e0c.k;
import java.util.HashMap;
import p4c.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    public static volatile c a;

    public a() {
    }

    public static c a() {
        if (a != null) goto L19;
        monitor-enter(a.class);
    L15:
        th = move-exception;
        throw th;
    L7:
        if (a != null) goto L13;
        Log.i("watermarkV3", "scs.watermark.user_state_and_optimize is: true");     // Catch: Throwable -> L15
        d r3 = (d) ApiUtils.getApi(d.class);     // Catch: Throwable -> L15
        if (r3 == null) goto L12;
        HashMap r5 = new HashMap();     // Catch: Throwable -> L15
        r5.put("event", "use_refactored");     // Catch: Throwable -> L15
        r3.monitorEventV2("scs_watermark_refactor", r5, null, null, 0);     // Catch: Throwable -> L15
    L12:
        int r1 = WatermarkModuleV3.g;     // Catch: Throwable -> L15
        ((c) k.a(LarkContext.getApplication(), c.class)).v7();     // Catch: Throwable -> L15
        a = (c) k.a(LarkContext.getApplication(), c.class);     // Catch: Throwable -> L15
    L13:
        monitor-exit(a.class);     // Catch: Throwable -> L15
    L19:
        return a;
    }
}
