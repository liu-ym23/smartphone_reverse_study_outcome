package kt1;

import com.bytedance.android.livesdk.config.v2;
import com.bytedance.android.livesdk.diagnose.DiagnoseEngine;
import io.reactivex.disposables.Disposable;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class h {
    public static boolean a;
    public static Disposable b;
    public static v2 c;
    public static volatile h d;

    public h() {
    }

    public static void b() {
        a = true;
        Disposable r0 = b;
        if (r0 == null) goto L5;
        r0.dispose();
        b = null;
    L5:
        ((ConcurrentHashMap) DiagnoseEngine.d().e).clear();
        c r1 = c.b();
        r1.a = false;
        LinkedList<JSONObject> r2 = r1.d;
        monitor-enter(r2);
        r1.d.clear();     // Catch: Throwable -> L38
        monitor-exit(r2);     // Catch: Throwable -> L38
        LinkedList<JSONObject> r3 = r1.e;
        monitor-enter(r3);
        r1.e.clear();     // Catch: Throwable -> L35
        monitor-exit(r3);     // Catch: Throwable -> L35
        LinkedList<JSONObject> r4 = r1.f;
        monitor-enter(r4);
        r1.f.clear();     // Catch: Throwable -> L32
        monitor-exit(r4);     // Catch: Throwable -> L32
        LinkedList<JSONObject> r5 = r1.g;
        monitor-enter(r5);
        r1.g.clear();     // Catch: Throwable -> L29
        monitor-exit(r5);     // Catch: Throwable -> L29
        LinkedList<JSONObject> r6 = r1.h;
        monitor-enter(r6);
        r1.h.clear();     // Catch: Throwable -> L26
        monitor-exit(r6);     // Catch: Throwable -> L26
        return;
    L26:
        th = move-exception;
        throw th;
    L29:
        th = move-exception;
        throw th;
    L32:
        th = move-exception;
        throw th;
    L35:
        th = move-exception;
        throw th;
    L38:
        th = move-exception;
        throw th;
    }

    public static h a() {
        if (d != null) goto L15;
        monitor-enter(h.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (d != null) goto L9;
        d = new h();     // Catch: Throwable -> L11
    L9:
        monitor-exit(h.class);     // Catch: Throwable -> L11
    L15:
        return d;
    }
}
