package y50;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class b {
    public static final /* synthetic */ int a = 0;

    public static final class a {
        public static void a(JSONObject r2, String r3, float r4) {
            Intrinsics.checkNotNullParameter(r2, "json");
            Intrinsics.checkNotNullParameter(r3, "key");
            r2.put(r3, r4);     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            jy0.b.b("BaseMonitor", "", th);
        }

        public static void b(JSONObject r1, String r2, int r3) {
            Intrinsics.checkNotNullParameter(r1, "json");
            Intrinsics.checkNotNullParameter(r2, "key");
            r1.put(r2, r3);     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            jy0.b.b("BaseMonitor", "", th);
        }

        public static void c(JSONObject r1, String r2, long r3) {
            Intrinsics.checkNotNullParameter(r1, "json");
            Intrinsics.checkNotNullParameter(r2, "key");
            r1.put(r2, r3);     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            jy0.b.b("BaseMonitor", "", th);
        }

        public static void d(JSONObject r1, String r2, String r3) {
            Intrinsics.checkNotNullParameter(r1, "json");
            Intrinsics.checkNotNullParameter(r2, "key");
            r1.put(r2, r3);     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            jy0.b.b("BaseMonitor", "", th);
        }

        public static void e(JSONObject r1, String r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r1, "json");
            Intrinsics.checkNotNullParameter(r2, "key");
            r1.put(r2, r3);     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            jy0.b.b("BaseMonitor", "", th);
        }
    }

    static {
    }

    public b() {
    }
}
