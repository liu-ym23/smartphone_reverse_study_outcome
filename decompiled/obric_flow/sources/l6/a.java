package l6;

import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicInteger f19541a = null;

    static {
        f19541a = new AtomicInteger(0);
    }

    public static void a(String r5, JSONObject r10) {
        JSONObject r11 = r10.optJSONObject("DATA_DOCTOR");
        if (r11 != null) goto L15;
        r11 = new JSONObject();
    L15:
    L9:
        e = move-exception;
        e.printStackTrace();
        return;
    L7:
        if (r11.optInt("DATA_ID", -1) != (-1)) goto L11;
        r11.put("DATA_ID", f19541a.incrementAndGet());     // Catch: Exception -> L9
    L11:
        r11.put("DATA_PROCESS", xq.b.m());     // Catch: Exception -> L9
        r11.put("DATA_TYPE", r5);     // Catch: Exception -> L9
        r11.put("DATA_SAMPLE", false);     // Catch: Exception -> L9
        throw null;     // Catch: Exception -> L9
    }
}
