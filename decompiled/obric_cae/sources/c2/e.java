package c2;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicLong f3258a = null;

    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f3259a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f3260b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ String f3261m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ String f3262n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final /* synthetic */ String f3263o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final /* synthetic */ int f3264p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final /* synthetic */ JSONObject f3265q;

        public a(long r8, long r10, String r11, String r12, String r13, int r14, JSONObject r15) {
            this.f3259a = r8;
            this.f3260b = r10;
            this.f3261m = r11;
            this.f3262n = r12;
            this.f3263o = r13;
            this.f3264p = r14;
            this.f3265q = r15;
        }

        @Override // java.lang.Runnable
        public final void run() {
            n2.b.a.f9429a.d(new o2.a("api_all", this.f3259a, this.f3260b, this.f3261m, this.f3262n, this.f3263o, this.f3264p, l6.a.E(this.f3265q)));
        }
    }

    public static class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f3266a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f3267b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ String f3268m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ String f3269n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final /* synthetic */ String f3270o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final /* synthetic */ int f3271p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final /* synthetic */ JSONObject f3272q;

        public b(long r8, long r10, String r11, String r12, String r13, int r14, JSONObject r15) {
            this.f3266a = r8;
            this.f3267b = r10;
            this.f3268m = r11;
            this.f3269n = r12;
            this.f3270o = r13;
            this.f3271p = r14;
            this.f3272q = r15;
        }

        @Override // java.lang.Runnable
        public final void run() {
            JSONObject r12 = new o2.a("api_all", this.f3266a, this.f3267b, this.f3268m, this.f3269n, this.f3270o, this.f3271p, this.f3272q).c();
            if (r12 == null) goto L6;
            e.f("monitorSLA", r12.toString());
            return;
        }
    }

    public static class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f3273a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ JSONObject f3274b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ JSONObject f3275m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ JSONObject f3276n;

        public c(String r8, JSONObject r10, JSONObject r11, JSONObject r12) {
            this.f3273a = r8;
            this.f3274b = r10;
            this.f3275m = r11;
            this.f3276n = r12;
        }

        @Override // java.lang.Runnable
        public final void run() {
            JSONObject r8 = new o2.c(this.f3273a, 0, null, this.f3274b, this.f3275m, this.f3276n).c();
            if (r8 == null) goto L6;
            e.f("monitorEvent", r8.toString());
            return;
        }
    }

    static {
        f3258a = new AtomicLong(0);
    }

    public e() {
    }

    public static void a(JSONObject r8) {
        if (r8 != null) goto L7;
        return;
    L7:
        JSONObject r10 = new JSONObject();     // Catch: Exception -> L6
        r10.put("_debug_uuid", k.b() + "_" + f3258a.getAndAdd(1));     // Catch: Exception -> L6
        r8.put("_debug_self", r10);     // Catch: Exception -> L6
        return;
    }

    public static void b(String r8, JSONObject r10) {
        boolean r11 = h3.a.f7903a;
        JSONObject r12 = e(r10);
        a(r12);
        b3.b.C0032b.f3038a.c(new g(r8, r12));
        if (k.f3298b == false) goto L6;
        JSONObject r13 = l6.a.E(r12);
        b3.d.a().b(new h(r13, r8));
        return;
    }

    public static void c(String r8, JSONObject r10, JSONObject r11, JSONObject r12) {
        boolean r13 = h3.a.f7903a;
        JSONObject r14 = e(r12);
        a(r14);
        h3.a.b(new j3.a(r8, 0, null, l6.a.E(r10), l6.a.E(r11), r14));
        if (k.f3298b == false) goto L6;
        JSONObject r15 = l6.a.E(r10);
        JSONObject r16 = l6.a.E(r11);
        JSONObject r17 = l6.a.E(r14);
        b3.d.a().b(new c(r8, r15, r16, r17));
        return;
    }

    public static void d(long r13, long r15, String r17, String r18, String r19, int r20, JSONObject r21) {
        JSONObject r10 = e(r21);
        b3.b.C0032b.f3038a.c(new a(r13, r15, r17, r18, r19, r20, r10));
        if (k.f3298b == false) goto L6;
        b3.d.a().b(new b(r13, r15, r17, r18, r19, r20, r10));
        return;
    }

    public static JSONObject e(JSONObject r8) {
        if (r8 != null) goto L6;
        r8 = new JSONObject();     // Catch: Exception -> L9
    L8:
        return r8;
    L6:
        if (r8.isNull("timestamp") == false) goto L8;
        r8.put("timestamp", System.currentTimeMillis());     // Catch: Exception -> L9
        goto L8
    }

    public static void f(String r8, String r10) {
        monitor-enter(e.class);     // Catch: Throwable -> L9
        k.a();     // Catch: Throwable -> L6
        long r11 = Thread.currentThread().getId();     // Catch: Throwable -> L6
        long r12 = System.currentTimeMillis();     // Catch: Throwable -> L6
        Date r13 = new Date(System.currentTimeMillis());     // Catch: Throwable -> L6
        String r14 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(r13);     // Catch: Throwable -> L6
        StringBuffer r15 = new StringBuffer();     // Catch: Throwable -> L6
        r15.append(r8);     // Catch: Throwable -> L6
        r15.append("#");     // Catch: Throwable -> L6
        r15.append(r11);     // Catch: Throwable -> L6
        r15.append("#");     // Catch: Throwable -> L6
        r15.append(r12);     // Catch: Throwable -> L6
        r15.append("#");     // Catch: Throwable -> L6
        r15.append(r14);     // Catch: Throwable -> L6
        r15.append("\n");     // Catch: Throwable -> L6
        r15.append(r10);     // Catch: Throwable -> L6
        r15.append("\n");     // Catch: Throwable -> L6
        r15.toString().getBytes("UTF-8");     // Catch: Throwable -> L6
        throw null;     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;     // Catch: Throwable -> L9
    }
}
