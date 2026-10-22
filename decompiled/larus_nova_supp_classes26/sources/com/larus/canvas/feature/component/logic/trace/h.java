package com.larus.canvas.feature.component.logic.trace;

import android.text.TextUtils;
import androidx.collection.LruCache;
import com.larus.platform.service.o;
import com.larus.utils.logger.FLogger;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class h {
    public static final h a = null;
    public static final LruCache<String, com.larus.ugc.perf.impl.g> b = null;

    public h() {
    }

    static {
        a = new h();
        b = new LruCache(5);
    }

    public static com.larus.ugc.perf.impl.g b(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return null;
    L5:
        if (r2 != null) goto L7;
        return null;
    L7:
        return (com.larus.ugc.perf.impl.g) b.get(r2);
    }

    public static void c(com.larus.ugc.perf.impl.g r5) {
        h r0 = a;
        String r1 = r5.a;
        JSONObject r6 = r5.c();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "eventName");
        Intrinsics.checkNotNullParameter(r6, "dataJson");
        o.a.reportEvent(r1, r6);     // Catch: Exception -> L5
        com.larus.platform.service.g.a.monitorEventForSlardar(r1, r6, new JSONObject(), null);     // Catch: Exception -> L5
        FLogger.a.i("CanvasPerfMonitor", r1 + ":\t " + r6);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        FLogger.a.e("CanvasPerfMonitor", "reportEvent error", e);
    }

    public static void a(String r2, boolean r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "localId");
        com.larus.ugc.perf.impl.g r6 = b(r2);
        if (r6 != null) goto L5;
        return;
    L5:
        r6.e(TuplesKt.to("duration", Long.valueOf(r6.a())));
        r6.e(TuplesKt.to("success", Integer.valueOf(r3 ? 1 : 0)));
        if (r5 != null) goto L8;
        r5 = "";
    L8:
        r6.e(TuplesKt.to("log_id", r5));
        r6.e(TuplesKt.to("scene", "end"));
        if (r4 == null) goto L11;
        r6.e(TuplesKt.to("error_code", r4));
    L11:
        c(r6);
    }
}
