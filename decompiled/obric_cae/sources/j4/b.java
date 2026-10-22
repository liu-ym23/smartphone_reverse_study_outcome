package j4;

import android.util.Pair;
import i4.h;
import i4.j;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f8587a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap f8588b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f8589a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f8590b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public j f8591c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public EnumC0098b f8592d;

        public a() {
            this.f8589a = 0;
            this.f8590b = -1;
            this.f8591c = j.f8240b;
            this.f8592d = EnumC0098b.f8593a;
        }

        public final JSONObject a() {
            JSONObject r8 = new JSONObject();
            r8.put("event", "sdk_event_latency");     // Catch: Throwable -> L5
            JSONObject r10 = new JSONObject();     // Catch: Throwable -> L5
            r10.put("stage", 2);     // Catch: Throwable -> L5
            r10.put("event_priority", this.f8590b);     // Catch: Throwable -> L5
            r10.put("event_type", this.f8591c.f8246a);     // Catch: Throwable -> L5
            r10.put("interval_scope", this.f8592d.toString());     // Catch: Throwable -> L5
            r10.put("event_count", this.f8589a);     // Catch: Throwable -> L5
            r8.put("params", r10);     // Catch: Throwable -> L5
            r8.put("local_time_ms", System.currentTimeMillis());     // Catch: Throwable -> L5
            r8.put("event_id", h.f8232b.incrementAndGet());     // Catch: Throwable -> L5
            r8.put("datetime", h.a());     // Catch: Throwable -> L5
        L4:
            return r8;
        }
    }

    /* JADX INFO: renamed from: j4.b$b, reason: collision with other inner class name */
    public static final enum EnumC0098b extends Enum<EnumC0098b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final EnumC0098b f8593a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final EnumC0098b f8594b = null;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final EnumC0098b f8595m = null;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final EnumC0098b f8596n = null;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final EnumC0098b f8597o = null;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public static final EnumC0098b f8598p = null;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public static final EnumC0098b f8599q = null;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public static final EnumC0098b f8600r = null;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public static final EnumC0098b f8601s = null;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public static final EnumC0098b f8602t = null;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public static final /* synthetic */ EnumC0098b[] f8603u = null;

        static {
            EnumC0098b r8 = new EnumC0098b("l_0_60", 0);
            f8593a = r8;
            EnumC0098b r10 = new EnumC0098b("l_0_1", 1);
            f8594b = r10;
            EnumC0098b r11 = new EnumC0098b("l_1_10", 2);
            f8595m = r11;
            EnumC0098b r12 = new EnumC0098b("l_10_20", 3);
            f8596n = r12;
            EnumC0098b r13 = new EnumC0098b("l_20_30", 4);
            f8597o = r13;
            EnumC0098b r14 = new EnumC0098b("l_30_40", 5);
            f8598p = r14;
            EnumC0098b r15 = new EnumC0098b("l_40_50", 6);
            f8599q = r15;
            EnumC0098b r16 = new EnumC0098b("l_50_60", 7);
            f8600r = r16;
            EnumC0098b r17 = new EnumC0098b("l_60_120", 8);
            f8601s = r17;
            EnumC0098b r18 = new EnumC0098b("l_120_", 9);
            f8602t = r18;
            f8603u = new EnumC0098b[]{r8, r10, r11, r12, r13, r14, r15, r16, r17, r18};
        }

        public EnumC0098b(String r8, int r10) {
            super(r8, r10);
        }

        public static EnumC0098b valueOf(String r8) {
            return (EnumC0098b) Enum.valueOf(EnumC0098b.class, r8);
        }

        public static EnumC0098b[] values() {
            return (EnumC0098b[]) f8603u.clone();
        }
    }

    public b() {
        this.f8587a = true;
        this.f8588b = new ConcurrentHashMap();
    }

    public final Pair<Map<String, JSONObject>, Long> a(long r8) {
        if (this.f8587a == false) goto L23;
        if (this.f8588b.isEmpty() == true) goto L23;
        HashMap r10 = new HashMap();
        ConcurrentHashMap r11 = this.f8588b;
        monitor-enter(r11);
        Iterator r12 = this.f8588b.keySet().iterator();     // Catch: Throwable -> L19
    L11:
        if (r12.hasNext() == false) goto L16;
        String r13 = (String) r12.next();     // Catch: Throwable -> L19
        a r14 = (a) this.f8588b.remove(r13);     // Catch: Throwable -> L19
        if (r14 == null) goto L11;
        r10.put(r13, r14.a());     // Catch: Throwable -> L19
        r8 = r8 - 231;     // Catch: Throwable -> L19
        if (r8 > 0) goto L11;
    L16:
        monitor-exit(r11);     // Catch: Throwable -> L19
        return new Pair(r10, Long.valueOf(r8));
    L19:
        th = move-exception;
        throw th;
    L23:
        return new Pair(null, Long.valueOf(r8));
    }
}
