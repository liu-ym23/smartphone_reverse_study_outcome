package bi8;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class d {
    public static final d a = null;
    public static final Lazy b = null;
    public static final Lazy c = null;
    public static final Lazy d = null;
    public static volatile boolean e;

    public static final class a {
        public long a;
        public int b;
        public String c;
        public long d;
        public int e;
        public boolean f;

        public a() {
            this.c = "";
        }
    }

    public d() {
    }

    static {
        a = new d();
        b = LazyKt.lazy(new bi8.a());
        c = LazyKt.lazy(new b());
        d = LazyKt.lazy(new c());
    }

    public static final void a(String r6) {
        d r0 = a;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (e == false) goto L9;
        monitor-exit(r0);
        return;
    L9:
        e = true;     // Catch: Throwable -> L13
        com.larus.platform.service.g r1 = com.larus.platform.service.g.a;     // Catch: Throwable -> L16
        JSONObject r3 = new JSONObject();     // Catch: Throwable -> L16
        r3.put("event_name", "get_message_list");     // Catch: Throwable -> L16
        r3.put("event_type", "high_request_frequency");     // Catch: Throwable -> L16
        r3.put("extra", r6);     // Catch: Throwable -> L16
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L16
        r1.monitorEventForSlardar("chat_message_list_monitor", r3, null, null);     // Catch: Throwable -> L16
    L11:
        monitor-exit(r0);
    }
}
