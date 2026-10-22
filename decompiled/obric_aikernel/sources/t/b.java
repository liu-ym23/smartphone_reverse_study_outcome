package t;

import android.os.Build;
import android.view.FrameMetrics;
import androidx.work.WorkRequest;
import com.ttnet.org.chromium.base.TimeUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b extends t.a {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static boolean f12810j = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final ArrayList<com.bytedance.apm.trace.fps.c> f12811g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private HashMap<String, e> f12812h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private d f12813i;

    class a implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f12814c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ boolean f12815g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ b f12816h;

        a(b r10, long r11, boolean r12) {
            this.f12816h = r10;
            this.f12814c = r11;
            this.f12815g = r12;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.i(this.f12816h).a(this.f12814c, this.f12815g);
            int r10 = 0;
        L4:
            if (r10 >= b.j(this.f12816h).size()) goto L6;
            ((com.bytedance.apm.trace.fps.c) b.j(this.f12816h).get(r10)).u(this.f12814c, this.f12815g);
            r10 = r10 + 1;
            goto L4
        }
    }

    /* JADX INFO: renamed from: t.b$b, reason: collision with other inner class name */
    class RunnableC0292b implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.bytedance.apm.trace.fps.c f12817c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ b f12818g;

        RunnableC0292b(b r10, com.bytedance.apm.trace.fps.c r11) {
            this.f12818g = r10;
            this.f12817c = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.j(this.f12818g).add(this.f12817c);
        }
    }

    class c implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.bytedance.apm.trace.fps.c f12819c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ b f12820g;

        c(b r10, com.bytedance.apm.trace.fps.c r11) {
            this.f12820g = r10;
            this.f12819c = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.j(this.f12820g).remove(this.f12819c);
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f12821a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f12822b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f12823c;

        public d() {
            this.f12821a = 0;
            this.f12822b = 0;
            this.f12823c = 0;
        }

        public void a(long r10, boolean r11) {
            if (r11 == false) goto L4;
            this.f12821a++;
        L4:
            this.f12822b++;
            this.f12823c += r10;
        }
    }

    private class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f12824a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f12825b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f12826c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f12827d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int[] f12828e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f12829f;

        e(b r10, String r11) {
            this.f12826c = 0;
            this.f12824a = r11;
            int r12 = com.bytedance.apm.util.g.e() - 1;
            this.f12829f = r12;
            this.f12828e = new int[(r12 - 0) + 1];
        }

        void a(long r10) {
            float r11 = com.bytedance.apm.util.g.c();
            this.f12825b += r10;
            int r12 = Math.min(Math.max((int) (r10 / r11), 0), this.f12829f);
            int[] r13 = this.f12828e;
            r13[r12] = r13[r12] + 1;
            this.f12827d += r12;
            this.f12826c++;
        }

        void b() {
            float r10 = com.bytedance.apm.util.g.c();     // Catch: Throwable -> L13
            JSONObject r11 = new JSONObject();     // Catch: Throwable -> L13
            int r12 = 0;
        L5:
            if (r12 > this.f12829f) goto L10;
            if (this.f12828e[r12] <= 0) goto L9;
            r11.put(String.valueOf(r12), this.f12828e[r12]);     // Catch: Throwable -> L13
        L9:
            r12 = r12 + 1;     // Catch: Throwable -> L13
            goto L5
        L10:
            com.bytedance.apm.trace.fps.a.c().b(null, this.f12824a, (float) (((double) (((this.f12826c * 100) * com.bytedance.apm.util.g.e()) / (this.f12826c + this.f12827d))) / 100.0d));     // Catch: Throwable -> L13
            JSONObject r13 = new JSONObject();     // Catch: Throwable -> L13
            r13.put("scene", this.f12824a);     // Catch: Throwable -> L13
            JSONObject r14 = new JSONObject();     // Catch: Throwable -> L13
            r14.put("total_scroll_time", this.f12825b);     // Catch: Throwable -> L13
            r14.put("drop_time_rate", 1.0f - ((this.f12826c * 1.0f) / ((int) (this.f12825b / r10))));     // Catch: Throwable -> L13
            r14.put("refresh_rate", this.f12829f + 1);     // Catch: Throwable -> L13
            x.a.p().e(new y.e("fps_drop", this.f12824a, r11, r13, r14));     // Catch: Throwable -> L13
        L11:
            this.f12826c = 0;
            this.f12827d = 0;
            this.f12825b = 0;
        }

        public String toString() {
            return "visibleScene=" + this.f12824a + ", sumFrame=" + this.f12826c + ", sumDroppedFrames=" + this.f12827d + ", sumFrameCost=" + this.f12825b + ", dropLevel=" + Arrays.toString(this.f12828e);
        }
    }

    static {
    }

    public b() {
        this.f12811g = new ArrayList();
        this.f12812h = new HashMap();
        this.f12813i = new d();
        t.e.B().U(true);
        com.bytedance.apm.trace.fps.b.K(true);
    }

    static /* synthetic */ d i(b r10) {
        return r10.f12813i;
    }

    static /* synthetic */ ArrayList j(b r10) {
        return r10.f12811g;
    }

    private void m(String r10, long r11) {
        if (f12810j == true) goto L5;
        return;
    L5:
        if (r11 <= 0) goto L16;
        e r12 = this.f12812h.get(r10);
        if (r12 != null) goto L10;
        r12 = new e(this, r10);
        this.f12812h.put(r10, r12);
    L10:
        r12.a(r11);
        if (r12.f12825b < WorkRequest.MIN_BACKOFF_MILLIS) goto L15;
        this.f12812h.remove(r10);
        r12.b();
        return;
    L15:
        return;
    }

    public static void o(boolean r10) {
        f12810j = r10;
    }

    @Override // com.bytedance.apm.block.a
    public void e(String r10, long r11, long r12) {
        super.e(r10, r11, r12);
        if (Build.VERSION.SDK_INT >= 24) goto L5;
        return;
    L5:
        long r13 = r12 - r11;
        m(r10, r13);
        int r14 = 0;
    L7:
        if (r14 >= this.f12811g.size()) goto L9;
        this.f12811g.get(r14).v(r13);
        r14 = r14 + 1;
        goto L7
    }

    @Override // com.bytedance.apm.block.a
    public void g(String r10, long r11, int r12) {
        if (Build.VERSION.SDK_INT < 24) goto L8;
        m(r10, r11);
        int r13 = 0;
    L6:
        if (r13 >= this.f12811g.size()) goto L10;
        this.f12811g.get(r13).v(r11);
        r13 = r13 + 1;
        goto L6
    L10:
        return;
    }

    @Override // com.bytedance.apm.block.a
    public void h(String r10, FrameMetrics r11, int r12) {
        if (Build.VERSION.SDK_INT < 24) goto L8;
        int r13 = 0;
        long r14 = (((((r11.getMetric(0) + r11.getMetric(1)) + r11.getMetric(2)) + r11.getMetric(3)) + r11.getMetric(4)) + r11.getMetric(5)) / TimeUtils.NANOSECONDS_PER_MILLISECOND;
        m(r10, r14);
    L6:
        if (r13 >= this.f12811g.size()) goto L10;
        this.f12811g.get(r13).v(r14);
        r13 = r13 + 1;
        goto L6
    L10:
        return;
    }

    public void k(com.bytedance.apm.trace.fps.c r10) {
        t.e.B().f12854o.b(new RunnableC0292b(this, r10));
    }

    public void l(long r10, boolean r11) {
        t.e.B().f12854o.b(new a(this, r10, r11));
    }

    public void n(com.bytedance.apm.trace.fps.c r10) {
        t.e.B().f12854o.b(new c(this, r10));
    }
}
