package ww9;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import tx9.u0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a {
    public static long a;
    public static final /* synthetic */ int b = 0;

    static {
    }

    public a() {
    }

    public static void a(String r11, JSONObject r12) {
        Intrinsics.checkNotNullParameter(r12, "extParams");
        u0.h(false, null, null, null, null, null, r11, null, null, r12, 1854);
    }

    public static void b(String r12, String r13, JSONObject r14) {
        Intrinsics.checkNotNullParameter(r14, "extraParams");
        u0.h(true, null, null, null, null, null, r12, r13, null, r14, 1854);
    }

    public static void c(String r2, Long r3, JSONObject r4) {
        Intrinsics.checkNotNullParameter(r4, "commonParams");
        r4.put("leave_reason", r2);     // Catch: Exception -> L8
        if (r3 == null) goto L6;
        r4.put("duration", r3.longValue());     // Catch: Exception -> L8
    L6:
        TrackParams r5 = new TrackParams().merge(r4);     // Catch: Exception -> L8
        by7.a r6 = new by7.a("output_preview_exit");     // Catch: Exception -> L8
        r6.a.merge(r5);     // Catch: Exception -> L8
        r6.b();     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        FLogger.a.e("SlidesDetailTracer", "error in SlidesDetailTracer reportOutputPreviewExit: " + e.getLocalizedMessage());
    }
}
