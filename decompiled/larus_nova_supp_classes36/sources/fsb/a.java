package fsb;

import com.ss.android.lark.inv.export.router.InvRouter;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    public String a;
    public long b;
    public int c;
    public int d;
    public final ConcurrentLinkedQueue<C0267a> e;

    /* JADX INFO: renamed from: fsb.a$a, reason: collision with other inner class name */
    public static final class C0267a {
        public String a;
        public long b;
        public int c;
        public String d;

        public C0267a() {
            this.a = InvRouter.UNKNOWN;
            this.b = -1;
            this.c = -1;
        }
    }

    public final synchronized JSONObject a() {
        monitor-enter(this);
        JSONObject r0 = new JSONObject();     // Catch: Throwable -> L16
        r0.put("page_name", this.a);     // Catch: Exception -> L12 Throwable -> L16
        r0.put("page_show", this.c);     // Catch: Exception -> L12 Throwable -> L16
        r0.put("page_complete", this.d);     // Catch: Exception -> L12 Throwable -> L16
        JSONArray r1 = new JSONArray();     // Catch: Exception -> L12 Throwable -> L16
    L6:
        if (this.e.isEmpty() == true) goto L10;
        C0267a r2 = this.e.remove();     // Catch: Exception -> L12 Throwable -> L16
        if (r2.c == (-1)) goto L6;
        JSONObject r3 = new JSONObject();     // Catch: Exception -> L12 Throwable -> L16
        r3.put("span_name", r2.a);     // Catch: Exception -> L12 Throwable -> L16
        r3.put("span_time", r2.c);     // Catch: Exception -> L12 Throwable -> L16
        r3.put("span_thread", r2.d);     // Catch: Exception -> L12 Throwable -> L16
        r1.put(r3);     // Catch: Exception -> L12 Throwable -> L16
        goto L6
    L10:
        r0.put("span", r1.toString());     // Catch: Exception -> L12 Throwable -> L16
    L14:
        monitor-exit(this);
        return r0;
    L12:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;
    }

    public a() {
        this.a = InvRouter.UNKNOWN;
        this.b = -1;
        this.c = -1;
        this.d = -1;
        this.e = new ConcurrentLinkedQueue();
    }
}
