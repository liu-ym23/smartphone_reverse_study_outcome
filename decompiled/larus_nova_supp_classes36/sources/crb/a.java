package crb;

import android.os.SystemClock;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.Statistics;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    public static boolean a;
    public static final ConcurrentHashMap<Integer, Long> b = null;

    static {
        a = true;
        b = new ConcurrentHashMap();
    }

    public static void a(int r6, boolean r7) {
        Log.d("AtSelectMonitor", "recordPageEnd hashCode: " + r6 + ", isSuccess: " + r7);
        Long r8 = b.remove(Integer.valueOf(r6));
        if (r8 == null) goto L12;
        long r2 = SystemClock.uptimeMillis() - r8.longValue();
        JSONObject r9 = new JSONObject();     // Catch: Exception -> L7
        r9.put("time_cost", r2);     // Catch: Exception -> L7
        r9.put("is_success", r7);     // Catch: Exception -> L7
        r9.put("scene", "chat");     // Catch: Exception -> L7
        r9.put("is_remote", false);     // Catch: Exception -> L7
        r9.put("is_cold_boot", a);     // Catch: Exception -> L7
        Statistics.sendEvent("lark_mention_first_render_perf", r9);     // Catch: Exception -> L7
        a = false;     // Catch: Exception -> L7
        Log.e("AtSelectMonitor", "reportMentionFirstRenderPref success");     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        Log.e("AtSelectMonitor", "reportMentionFirstRenderPref fail: ", e);
        return;
    }

    public static void b(int r2, long r3) {
        Log.d("AtSelectMonitor", "recordPageStart hashCode: " + r2 + ", startTime: " + r3);
        b.put(Integer.valueOf(r2), Long.valueOf(r3));
    }
}
