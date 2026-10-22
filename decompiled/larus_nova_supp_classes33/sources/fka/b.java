package fka;

import android.util.Log;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(String r2, JSONObject r3, JSONObject r4, JSONObject r5) {
        Intrinsics.checkNotNullParameter(r2, "eventName");
        Intrinsics.checkNotNullParameter(r3, "category");
        Intrinsics.checkNotNullParameter(r4, "metric");
        Intrinsics.checkNotNullParameter(r5, "logExtr");
        bka.a r6 = bka.a.a;     // Catch: Exception -> L5
        gka.b.a("SdkMonitorManager", "on event device_id = null");     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        gka.b.a("SdkMonitorManager", "event report exception " + Log.getStackTraceString(e));
    }
}
