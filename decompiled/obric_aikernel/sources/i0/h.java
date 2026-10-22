package i0;

import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.apm6.hub.config.internal.SlardarSettingsConstants;
import com.bytedance.crash.resource.vmmonitor.VmMonitorConfig;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class h extends i0.a {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final int f9352m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static boolean f9353n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static int f9354o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static boolean f9355p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static boolean f9356q;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f9357l;

    static class a implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f9358c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ int[] f9359g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f9360h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ int f9361i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ ThreadGroup f9362j;

        a(boolean r10, int[] r11, String r12, int r13, ThreadGroup r14) {
            this.f9358c = r10;
            this.f9359g = r11;
            this.f9360h = r12;
            this.f9361i = r13;
            this.f9362j = r14;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f9358c == false) goto L5;
        L26:
            JSONObject r10 = h.q(this.f9360h, this.f9361i, this.f9359g[0], null);     // Catch: Exception -> L25
            if (r10 == null) goto L34;
            x.a.p().e(new y.e("thread", null, null, r10));     // Catch: Exception -> L25
            return;
        L34:
            return;
        L35:
            return;
        L5:
            if (this.f9359g[0] < h.o()) goto L26;
            if (h.p() == false) goto L26;
            int[] r11 = this.f9359g;
            Thread[] r12 = new Thread[r11[0] + (r11[0] / 2)];
            r11[0] = this.f9362j.enumerate(r12);
            StringBuilder r13 = new StringBuilder();
            int r14 = 0;
        L10:
            int[] r15 = this.f9359g;
            if (r14 >= r15[0]) goto L28;
            String r16 = r12[r14].getName();
            if (TextUtils.isEmpty(r16) == true) goto L15;
            r13.append(r16);
            r13.append(",");
        L15:
            r14 = r14 + 1;
            goto L10
        L28:
            JSONObject r17 = h.q(this.f9360h, this.f9361i, r15[0], r13.toString());     // Catch: Throwable -> L24
            if (r17 == null) goto L32;
            x.a.p().e(new y.e("thread", null, null, r17));     // Catch: Throwable -> L24
            return;
        L32:
            return;
        }
    }

    static {
        f9352m = Runtime.getRuntime().availableProcessors();
        f9353n = false;
        f9354o = 300;
        f9355p = false;
        f9356q = false;
    }

    public h() {
        this.f9357l = 600000;
        this.f9290j = "thread";
    }

    static /* synthetic */ int o() {
        return f9354o;
    }

    static /* synthetic */ boolean p() {
        return f9353n;
    }

    static /* synthetic */ JSONObject q(String r10, int r11, int r12, String r13) {
        return r(r10, r11, r12, r13);
    }

    private static JSONObject r(String r10, int r11, int r12, String r13) {
        JSONObject r14 = new JSONObject();
        if (r11 > 0) goto L16;
    L5:
        r14.put("java_thread_count", r12);     // Catch: JSONException -> L13
        if (TextUtils.isEmpty(r10) == true) goto L9;
        r14.put("scene", r10);     // Catch: JSONException -> L13
    L9:
        if (TextUtils.isEmpty(r13) == true) goto L11;
        r14.put("thread_detail", r13);     // Catch: JSONException -> L13
    L11:
        r14.put("is_main_process", com.bytedance.apm.d.I());     // Catch: JSONException -> L13
        r14.put("cpu_count", f9352m);     // Catch: JSONException -> L13
        r14.put("process_name", com.bytedance.apm.d.h());     // Catch: JSONException -> L13
    L15:
        return r14;
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L15
    L16:
        r14.put("total_thread_count", r11);     // Catch: JSONException -> L13
        goto L5
    }

    private void s() {
        t(null, false);
    }

    public static int t(String r11, boolean r12) {
        int r10 = new File("/proc/self/task/").list().length;     // Catch: Throwable -> L5
    L6:
        if (r10 != 0) goto L8;
        return 0;
    L8:
        ThreadGroup r13 = Looper.getMainLooper().getThread().getThreadGroup();
    L10:
        if (r13.getParent() == null) goto L12;
        r13 = r13.getParent();
        goto L10
    L12:
        int[] r14 = {r13.activeCount()};
        q0.b.f().i(new a(r12, r14, r11, r10, r13));
        return (r10 << 16) + r14[0];
    L5:
        r10 = 0;
        goto L6
    }

    @Override // i0.a
    protected void c(JSONObject r10) {
        super.c(r10);
        boolean r11 = false;
        if (r10.optInt(SlardarSettingsConstants.PERF_KEY_ENABLE_THREAD_COLLECT, 0) != 1) goto L5;
        boolean r12 = true;
    L6:
        f9355p = r12;
        if (r10.optInt(SlardarSettingsConstants.PERF_KEY_ENABLE_UPLOAD, 0) != 1) goto L9;
        r11 = true;
    L9:
        f9356q = r11;
        f9354o = r10.optInt("thread_count_threshold", 300);
        this.f9357l = r10.optLong(SlardarSettingsConstants.PERF_KEY_COLLECT_INTERVAL, 10) * VmMonitorConfig.SLEEP_TIME_BEFORE_RECOVER;
        return;
    L5:
        r12 = false;
        goto L6
    }

    @Override // i0.a
    protected boolean f() {
        return true;
    }

    @Override // i0.a
    protected void i() {
        super.i();
        if (f9355p == true) goto L5;
        return;
    L5:
        if (f9356q == true) goto L7;
        return;
    L7:
        if ((System.currentTimeMillis() - com.bytedance.apm.d.s()) <= 1200000) goto L12;
        s();
        return;
    }

    @Override // i0.a
    protected long n() {
        return this.f9357l;
    }

    @Override // i0.a, u4.a
    public void onReady() {
        super.onReady();
        f9353n = true;
    }
}
