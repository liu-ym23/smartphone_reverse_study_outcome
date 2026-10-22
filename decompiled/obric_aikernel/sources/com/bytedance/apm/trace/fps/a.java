package com.bytedance.apm.trace.fps;

import com.bytedance.apm.d;
import com.bytedance.apm.util.g;
import com.bytedance.apm6.perf.base.CommonDataAssembly;
import com.bytedance.crash.anr.AnrManager;
import e0.e;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a implements q0.b.e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f1021c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final HashMap<String, b> f1022g;

    /* JADX INFO: renamed from: com.bytedance.apm.trace.fps.a$a, reason: collision with other inner class name */
    class RunnableC0038a implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f1023c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ Map f1024g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ float f1025h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ a f1026i;

        RunnableC0038a(a r10, String r11, Map r12, float r13) {
            this.f1026i = r10;
            this.f1023c = r11;
            this.f1024g = r12;
            this.f1025h = r13;
        }

        @Override // java.lang.Runnable
        public void run() {
            b r10 = (b) a.a(this.f1026i).get(this.f1023c);
            if (r10 != null) goto L5;
            b r11 = new b(this.f1024g, this.f1023c, this.f1025h);
            a.a(this.f1026i).put(this.f1023c, r11);
            return;
        L5:
            r10.a(this.f1025h);
        }
    }

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Map<String, String> f1027a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f1028b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private long f1029c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f1030d;

        b(Map<String, String> r10, String r11, float r12) {
            this.f1027a = r10;
            this.f1028b = r12;
            this.f1029c = System.currentTimeMillis();
            this.f1030d = 1;
        }

        void a(float r10) {
            this.f1028b += r10;
            this.f1030d++;
        }

        float b() {
            int r10 = this.f1030d;
            if (r10 > 0) goto L5;
            return -1.0f;
        L5:
            return this.f1028b / r10;
        }

        boolean c(long r10) {
            if ((r10 - this.f1029c) <= AnrManager.ANR_MIN_INTERVAL) goto L5;
            return true;
        L5:
            return false;
        }
    }

    private static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final a f1031a = null;

        static {
            f1031a = new a(null);
        }

        static /* synthetic */ a a() {
            return f1031a;
        }
    }

    private a() {
        this.f1022g = new HashMap();
        this.f1021c = true;
        q0.b.f().c(this);
    }

    /* synthetic */ a(RunnableC0038a r10) {
        this();
    }

    static /* synthetic */ HashMap a(a r10) {
        return r10.f1022g;
    }

    public static a c() {
        return c.a();
    }

    public void b(Map<String, String> r10, String r11, float r12) {
        q0.b.f().i(new RunnableC0038a(this, r11, r10, r12));
    }

    @Override // q0.b.e
    public void onTimeEvent(long r13) {
        if (this.f1022g.isEmpty() == true) goto L34;
        Iterator<Map.Entry<String, b>> r10 = this.f1022g.entrySet().iterator();
        int r11 = g.e();
    L6:
        if (r10.hasNext() == false) goto L47;
        Map.Entry<String, b> r12 = r10.next();
        String r14 = r12.getKey();
        b r15 = r12.getValue();
        if (r15.c(r13) == false) goto L6;
        r10.remove();
        float r16 = r15.b();
        boolean r17 = false;
        if (d.D() == false) goto L13;
        e.d(e0.b.f8549c, new String[]{"aggregate fps: " + r14 + " , value: " + r16});
    L13:
        if (r16 <= 0.0f) goto L6;
        float r18 = r11;
        if (r16 <= r18) goto L36;
        r16 = r18;
    L36:
        JSONObject r19 = new JSONObject();     // Catch: Exception -> L35
        r19.put("fps", r16);     // Catch: Exception -> L35
        JSONObject r20 = new JSONObject();     // Catch: Exception -> L35
        r20.put("scene", r14);     // Catch: Exception -> L35
        y.e r21 = new y.e("fps", r14, r19, r20, null);     // Catch: Exception -> L35
        CommonDataAssembly.wrapFilters(r21, true);     // Catch: Exception -> L35
        JSONObject r22 = r21.f13620f;     // Catch: Exception -> L35
        r22.put("refresh_rate", r11);     // Catch: Exception -> L35
        if (this.f1021c == false) goto L24;
        this.f1021c = false;     // Catch: Exception -> L35
        r22.put("device_max_refresh_rate", g.b());     // Catch: Exception -> L35
        if (g.h() == true) goto L23;
        r17 = true;
    L23:
        r22.put("refresh_rate_restricted", r17);     // Catch: Exception -> L35
    L24:
        Map<String, String> r23 = r15.f1027a;     // Catch: Exception -> L35
        if (r23 != null) goto L27;
    L32:
        x.a.p().e(r21);     // Catch: Exception -> L35
        goto L6
    L27:
        if (r23.isEmpty() == true) goto L32;
        Iterator<Map.Entry<String, String>> r24 = r15.f1027a.entrySet().iterator();     // Catch: Exception -> L35
    L30:
        if (r24.hasNext() == false) goto L32;
        Map.Entry<String, String> r25 = r24.next();     // Catch: Exception -> L35
        r21.f13620f.put(r25.getKey(), r25.getValue());     // Catch: Exception -> L35
        goto L30
    L47:
        return;
    }
}
