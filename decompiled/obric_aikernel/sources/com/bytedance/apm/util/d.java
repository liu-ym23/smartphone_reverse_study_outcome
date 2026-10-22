package com.bytedance.apm.util;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.os.Build;
import android.os.Debug;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import com.bytedance.apm6.perf.base.Constants;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.crash.dumper.ProcInfo;
import java.io.BufferedReader;
import java.io.FileReader;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f1106a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f1107b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f1108c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f1109d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f1110e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f1111f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f1112g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f1113h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f1114i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f1115j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f1116k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f1117l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private long f1118m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private long f1119n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private double f1120o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private long f1121p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private long f1122q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private double f1123r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private long f1124s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private long f1125t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private double f1126u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f1127v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f1128w;

    class a implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Throwable f1129c;

        a(d r10, Throwable r11) {
            this.f1129c = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.bytedance.apm.k.e().b(this.f1129c, CommonConsts.APM_INNER_ERROR);
        }
    }

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final d f1130a = null;

        static {
            f1130a = new d(null);
        }
    }

    private d() {
        i();
        this.f1106a = com.bytedance.apm.d.E();
        p();
    }

    /* synthetic */ d(a r10) {
        this();
    }

    private void i() {
        if (w.a() == false) goto L6;
        Throwable r10 = new Throwable("Don't use DeviceInfoUtil on main thread.");
        q0.b.f().i(new a(this, r10));
        return;
    }

    private double j(long r10, long r11) {
        if (r11 != 0) goto L7;
        return 0.0d;
    L7:
        return Math.round((r10 / r11) * 100.0d) / 100.0d;
    }

    public static d k() {
        return b.f1130a;
    }

    private String l() {
        return "unknown";
    }

    private long m(long r10) {
        return r10 / ProcInfo.GB;
    }

    private void n() {
        String r10 = com.bytedance.apm.d.g().getApplicationInfo().nativeLibraryDir;
        if (TextUtils.isEmpty(r10) == false) goto L5;
    L7:
        StringBuilder r11 = new StringBuilder();
        if (Build.VERSION.SDK_INT >= 21) goto L10;
    L18:
        r11 = new StringBuilder(Build.CPU_ABI);
    L19:
        String r12 = r11.toString();
        if (r12 != null) goto L22;
    L24:
        o();
        return;
    L22:
        if (r12.contains("64") == false) goto L24;
        this.f1108c = true;
        goto L24
    L10:
        if (Build.SUPPORTED_ABIS.length <= 0) goto L18;
        int r13 = 0;
    L12:
        String[] r14 = Build.SUPPORTED_ABIS;
        if (r13 >= r14.length) goto L19;
        r11.append(r14[r13]);
        if (r13 == (r14.length - 1)) goto L17;
        r11.append(", ");
    L17:
        r13 = r13 + 1;
        goto L12
    L5:
        if (r10.endsWith("arm64") == false) goto L7;
        this.f1107b = true;
        goto L7
    }

    private void o() {
        com.bytedance.apm.internal.b r10 = com.bytedance.apm.internal.b.a();
        String r11 = r10.d("sp_cpu_model");
        int r12 = r10.b("sp_cpu_core_num");
        if (TextUtils.isEmpty(r11) == true) goto L6;
        this.f1109d = r11;
        this.f1110e = r12;
        return;
    L6:
        s();
        if (TextUtils.isEmpty(this.f1109d) == false) goto L9;
        this.f1109d = "unknown";
    L9:
        r10.g("sp_cpu_model", this.f1109d);
        r10.e("sp_cpu_core_num", this.f1110e);
    }

    private void p() {
        if (this.f1106a == true) goto L8;
        return;
    L8:
        n();     // Catch: Throwable -> L7
        q();     // Catch: Throwable -> L7
        r();     // Catch: Throwable -> L7
        return;
    }

    private void q() {
        ActivityManager r10 = (ActivityManager) com.bytedance.apm.d.g().getSystemService("activity");
        ActivityManager.MemoryInfo r11 = new ActivityManager.MemoryInfo();
        r10.getMemoryInfo(r11);
        int r12 = Build.VERSION.SDK_INT;
        if (r12 >= 16) goto L5;
        int r13 = -1;
    L6:
        this.f1111f = r13;
        if (r12 >= 21) goto L11;
        String r14 = "dlmalloc";
    L9:
        this.f1116k = r14;
        return;
    L11:
        if (r12 < 24) goto L13;
        r14 = "jemalloc";
        goto L9
    L13:
        r14 = com.bytedance.apm.internal.b.a().d("sp_malloc_impl");
        if (r14 != null) goto L9;
        r14 = l();
        com.bytedance.apm.internal.b.a().g("sp_malloc_impl", r14);
        goto L9
    L5:
        r13 = (int) (r11.totalMem / 536870912);
        goto L6
    }

    @SuppressLint({"NewApi"})
    private void r() {
        if (Build.VERSION.SDK_INT < 18) goto L5;
        boolean r10 = true;
    L6:
        this.f1117l = r10;
        StatFs r11 = new StatFs(Environment.getRootDirectory().getAbsolutePath());
        if (this.f1117l == false) goto L9;
        this.f1119n = r11.getAvailableBytes();
        long r12 = r11.getBlockSizeLong();
        long r13 = r11.getBlockCountLong();
    L10:
        this.f1118m = r12 * r13;
        this.f1120o = j(this.f1119n, this.f1118m);
        StatFs r14 = new StatFs(com.bytedance.apm.d.g().getFilesDir().getAbsolutePath());     // Catch: Throwable -> L28
        if (this.f1117l == false) goto L14;
        this.f1122q = r14.getAvailableBytes();     // Catch: Throwable -> L28
        this.f1121p = r14.getBlockSizeLong() * r14.getBlockCountLong();     // Catch: Throwable -> L28
    L15:
        this.f1123r = j(this.f1122q, this.f1121p);     // Catch: Throwable -> L28
        goto L16
    L14:
        this.f1122q = ((long) r14.getBlockSize()) * ((long) r14.getAvailableBlocks());     // Catch: Throwable -> L28
        this.f1121p = ((long) r14.getBlockSize()) * ((long) r14.getBlockCount());     // Catch: Throwable -> L28
    L16:
        String r15 = null;
        r15 = Environment.getExternalStorageState();     // Catch: Exception -> L29
    L18:
        boolean r16 = TextUtils.equals(r15, "mounted");
        this.f1127v = r16;
        if (r16 == false) goto L25;
        StatFs r17 = new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath());     // Catch: Throwable -> L30
        if (this.f1117l == false) goto L23;
        this.f1125t = r17.getAvailableBytes();     // Catch: Throwable -> L30
        this.f1124s = r17.getBlockSizeLong() * r17.getBlockCountLong();     // Catch: Throwable -> L30
    L24:
        this.f1126u = j(this.f1125t, this.f1124s);     // Catch: Throwable -> L30
        goto L26
    L23:
        this.f1125t = ((long) r17.getBlockSize()) * ((long) r17.getAvailableBlocks());     // Catch: Throwable -> L30
        this.f1124s = ((long) r17.getBlockSize()) * ((long) r17.getBlockCount());     // Catch: Throwable -> L30
        goto L24
    L25:
        this.f1124s = 0;     // Catch: Throwable -> L30
    L26:
        this.f1128w = Environment.isExternalStorageRemovable();
        return;
    L9:
        this.f1119n = ((long) r11.getBlockSize()) * ((long) r11.getAvailableBlocks());
        r12 = r11.getBlockSize();
        r13 = r11.getBlockCount();
        goto L10
    L5:
        r10 = false;
        goto L6
    }

    private void s() {
        BufferedReader r10 = null;
        String r11 = null;
        BufferedReader r12 = null;
        BufferedReader r13 = new BufferedReader(new FileReader("/proc/cpuinfo"));     // Catch: Throwable -> L21 Exception -> L25
        int r14 = 0;
    L46:
        String r15 = r13.readLine();     // Catch: Throwable -> L18 Exception -> L20
        if (r15 == null) goto L40;
        String[] r16 = r15.split(":");     // Catch: Throwable -> L18 Exception -> L20
        if (r16.length != 2) goto L46;
        if (r16[0].startsWith("Hardware") == true) goto L12;
        if (r16[0].startsWith("processor") == false) goto L46;
        r14 = r14 + 1;
        goto L46
    L12:
        r11 = r16[1].trim();     // Catch: Throwable -> L18 Exception -> L20
        goto L46
    L40:
        r13.close();     // Catch: Exception -> L35
    L29:
        this.f1109d = r11;
        this.f1110e = r14;
        if (TextUtils.isEmpty(r11) == true) goto L32;
        return;
    L32:
        if (s.u() == false) goto L59;
        this.f1109d = Build.HARDWARE;
        return;
    L59:
        return;
    L20:
        String r17 = r11;
        r12 = r13;
    L26:
        if (r12 != null) goto L42;
    L28:
        r11 = r17;
        goto L29
    L42:
        r12.close();     // Catch: Exception -> L37
    L18:
        th = th;
        r10 = r13;
    L22:
        if (r10 != null) goto L38;
    L24:
        throw th;
    L38:
        r10.close();     // Catch: Exception -> L36
        goto L24
    L25:
        r14 = 0;
        r17 = null;
    L21:
        th = th;
        goto L22
    }

    private void t() {
        this.f1112g = Debug.getNativeHeapAllocatedSize() / 1048576;
        Runtime r10 = Runtime.getRuntime();
        long r11 = r10.maxMemory();
        long r12 = r10.freeMemory();
        long r13 = r10.totalMemory();
        this.f1114i = r11 / 1048576;
        long r14 = r13 - r12;
        this.f1115j = r14 / 1048576;
        if (r14 <= (r11 * 0.95f)) goto L5;
        boolean r15 = true;
    L6:
        this.f1113h = r15;
        return;
    L5:
        r15 = false;
        goto L6
    }

    public void a(JSONObject r10) {
        b(r10, false);
    }

    public void b(JSONObject r10, boolean r11) {
        if (this.f1106a == true) goto L9;
        if (r11 == true) goto L9;
        return;
    L9:
        k().d(r10);     // Catch: JSONException -> L8
        k().c(r10);     // Catch: JSONException -> L8
        k().h(r10);     // Catch: JSONException -> L8
        return;
    }

    public void c(JSONObject r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (this.f1106a == false) goto L9;
        r10.put(Constants.PERF_KEY_PHYSICAL_MEM, this.f1111f);
        r10.put(Constants.PERF_KEY_MALLOC_IMPL, this.f1116k);
        return;
    }

    public void d(JSONObject r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (this.f1106a == false) goto L12;
        r10.put("apm_is_app_64", this.f1107b);
        r10.put("apm_is_device_64", this.f1108c);
        r10.put("apm_cpu_model", this.f1109d);
        int r11 = this.f1110e;
        if (r11 <= 0) goto L11;
        r10.put("apm_cpu_core_num", r11);
        return;
    L11:
        return;
    }

    public void e(JSONObject r10) {
        f(r10, false);
    }

    public void f(JSONObject r10, boolean r11) {
        if (this.f1106a == true) goto L9;
        if (r11 == true) goto L9;
        return;
    L9:
        k().g(r10);     // Catch: JSONException -> L8
        return;
    }

    public void g(JSONObject r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (this.f1106a == false) goto L9;
        t();
        r10.put(Constants.PERF_KEY_HAS_NATIVE_HEAP_SIZE, this.f1112g);
        r10.put(Constants.PERF_KEY_HAS_JAVA_HEAP_LEAK, this.f1113h);
        r10.put(Constants.PERF_KEY_JAVA_HEAP_USED, this.f1115j);
        r10.put(Constants.PERF_KEY_JAVA_HEAP_MAX, this.f1114i);
        return;
    }

    public void h(JSONObject r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (this.f1106a == true) goto L7;
        return;
    L7:
        if (this.f1118m == 0) goto L10;
        r10.put("apm_sys_avail_size", this.f1119n / 1048576);
        r10.put("apm_sys_avail_ratio", this.f1120o);
    L10:
        if (this.f1121p == 0) goto L13;
        r10.put("apm_data_avail_size", m(this.f1122q));
        r10.put("apm_data_avail_ratio", this.f1123r);
    L13:
        if (this.f1124s == 0) goto L16;
        r10.put("apm_sd_avail_size", m(this.f1125t));
        r10.put("apm_sd_avail_ratio", this.f1126u);
    L16:
        if (this.f1127v == false) goto L20;
        r10.put("apm_external_removable", this.f1128w);
        return;
    }
}
