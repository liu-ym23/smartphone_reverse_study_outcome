package o1;

import androidx.core.app.NotificationCompat;
import com.bytedance.crash.constants.Constants;
import java.lang.reflect.Constructor;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final List<String> f11384a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<String, i> f11385b = null;

    static {
        f11384a = Collections.singletonList("EncryptUtils");
        f11385b = new ConcurrentHashMap();
    }

    private static i a(String r10) {
        if (k.b("com.bytedance.applog.et_verify.EventVerify") == true) goto L5;
        return null;
    L5:
        com.bytedance.applog.c r11 = com.bytedance.applog.b.a(r10);
        if (r11 != null) goto L19;
        return null;
    L19:
        Constructor<?> r12 = Class.forName("com.bytedance.applog.et_verify.EventVerify").getConstructor(new Class[]{com.bytedance.applog.c.class});     // Catch: Throwable -> L14 Exception -> L17
        r12.setAccessible(true);     // Catch: Throwable -> L14 Exception -> L17
        i r13 = (i) r12.newInstance(new Object[]{r11});     // Catch: Throwable -> L14 Exception -> L17
        if (r13 != null) goto L12;
        f1.n.B().g(f11384a, "can't find event verify, should compile with ET", new Object[0]);
    L21:
        return r13;
    L12:
        f1.n.B().o(f11384a, "found event sender: {}", new Object[]{r13});
        goto L21
    L17:
        f1.n.B().g(f11384a, "can't find event verify, should compile with ET", new Object[0]);
        return null;
    L14:
        th = move-exception;
        f1.n.B().g(f11384a, "can't find event verify, should compile with ET", new Object[0]);
        throw th;
    }

    public static String b(l1.a r10) {
        if ((r10 instanceof l1.c) == false) goto L7;
        return NotificationCompat.CATEGORY_EVENT;
    L7:
        if ((r10 instanceof l1.e) == false) goto L11;
        return "event_v3";
    L11:
        if ((r10 instanceof l1.d) == false) goto L15;
        return "log_data";
    L15:
        if ((r10 instanceof l1.f) == false) goto L19;
        return Constants.LAUNCH_TAG;
    L19:
        if ((r10 instanceof l1.i) == false) goto L22;
        return "terminate";
    L22:
        return null;
    }

    private static void c(String r10) {
        Map<String, i> r11 = f11385b;
        if (r11.containsKey(r10) == true) goto L8;
        i r12 = a(r10);
        if (r12 == null) goto L9;
        r11.put(r10, r12);
        return;
    L9:
        return;
    }

    public static boolean d(String r10) {
        Map<String, i> r11 = f11385b;
        if (r11.containsKey(r10) == true) goto L5;
        return false;
    L5:
        return r11.get(r10).isEnable();
    }

    public static void e(String r10, String r11, JSONArray r12) {
        c(r10);
        Map<String, i> r13 = f11385b;
        if (r13.containsKey(r10) == false) goto L6;
        r13.get(r10).a(r11, r12);
        return;
    }
}
