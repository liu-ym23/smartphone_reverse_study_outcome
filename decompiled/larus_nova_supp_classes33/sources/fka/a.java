package fka;

import android.util.Log;
import com.obric.matrix.proto.Response;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(int r4, Response r5) {
        Intrinsics.checkNotNullParameter(r5, "response");
        JSONObject r1 = new JSONObject();     // Catch: Exception -> L5
        r1.put("status", "status_receiver_result");     // Catch: Exception -> L5
        r1.put("cmd", r4);     // Catch: Exception -> L5
        r1.put("way", 1);     // Catch: Exception -> L5
        r1.put("package_name", "");     // Catch: Exception -> L5
        r1.put("error_code", r5.statusCode.intValue());     // Catch: Exception -> L5
        r1.put("error_message", r5.errorMsg);     // Catch: Exception -> L5
        JSONObject r6 = new JSONObject();     // Catch: Exception -> L5
        int r7 = b.a;     // Catch: Exception -> L5
        b.a("event_send_cmd_result", r1, r6, new JSONObject());     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        gka.b.a("ReportMonitorHelper", "report exception " + Log.getStackTraceString(e));
    }
}
