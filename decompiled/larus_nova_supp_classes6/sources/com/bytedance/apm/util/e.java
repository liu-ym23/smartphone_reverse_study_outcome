package com.bytedance.apm.util;

import android.app.ActivityManager;
import android.os.Build;
import android.os.Debug;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import com.bytedance.apm.internal.h;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import java.io.BufferedReader;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class e {
    public final boolean a;
    public boolean b;
    public boolean c;
    public String d;
    public int e;
    public int f;
    public long g;
    public boolean h;
    public long i;
    public long j;
    public String k;
    public boolean l;
    public long m;
    public long n;
    public double o;
    public long p;
    public long q;
    public double r;
    public long s;
    public long t;
    public double u;
    public boolean v;
    public boolean w;

    public final void h() {
        this.l = true;
        StatFs r1 = new StatFs(Environment.getRootDirectory().getAbsolutePath());
        if (this.l == false) goto L5;
        this.n = r1.getAvailableBytes();
        this.m = r1.getBlockSizeLong() * r1.getBlockCountLong();
    L6:
        this.o = e(this.n, this.m);
        StatFs r2 = new StatFs(com.bytedance.apm.d.getContext().getFilesDir().getAbsolutePath());     // Catch: Throwable -> L25
        if (this.l == false) goto L10;
        this.q = r2.getAvailableBytes();     // Catch: Throwable -> L25
        this.p = r2.getBlockSizeLong() * r2.getBlockCountLong();     // Catch: Throwable -> L25
    L11:
        this.r = e(this.q, this.p);     // Catch: Throwable -> L25
        goto L27
    L10:
        this.q = ((long) r2.getBlockSize()) * ((long) r2.getAvailableBlocks());     // Catch: Throwable -> L25
        this.p = ((long) r2.getBlockSize()) * ((long) r2.getBlockCount());     // Catch: Throwable -> L25
    L27:
        String r0 = Environment.getExternalStorageState();     // Catch: Exception -> L14
    L15:
        boolean r3 = TextUtils.equals(r0, "mounted");
        this.v = r3;
        if (r3 == false) goto L22;
        StatFs r4 = new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath());     // Catch: Throwable -> L26
        if (this.l == false) goto L20;
        this.t = r4.getAvailableBytes();     // Catch: Throwable -> L26
        this.s = r4.getBlockSizeLong() * r4.getBlockCountLong();     // Catch: Throwable -> L26
    L21:
        this.u = e(this.t, this.s);     // Catch: Throwable -> L26
        goto L23
    L20:
        this.t = ((long) r4.getBlockSize()) * ((long) r4.getAvailableBlocks());     // Catch: Throwable -> L26
        this.s = ((long) r4.getBlockSize()) * ((long) r4.getBlockCount());     // Catch: Throwable -> L26
        goto L21
    L22:
        this.s = 0;     // Catch: Throwable -> L26
    L23:
        this.w = Environment.isExternalStorageRemovable();
        return;
    L14:
        r0 = null;
        goto L15
    L5:
        this.n = ((long) r1.getBlockSize()) * ((long) r1.getAvailableBlocks());
        this.m = ((long) r1.getBlockSize()) * ((long) r1.getBlockCount());
        goto L6
    }

    public e() {
        if (u.a() == false) goto L5;
        Throwable r0 = new Throwable("Don't use DeviceInfoUtil on main thread.");
        bt3.b.d.a.e(new d(r0));
    L5:
        boolean r1 = com.bytedance.apm.d.s;
        this.a = r1;
        if (r1 == false) goto L13;
        f();     // Catch: Throwable -> L10
        g();     // Catch: Throwable -> L10
        h();     // Catch: Throwable -> L10
        return;
    L14:
        return;
    }

    public final void f() {
        String r0 = com.bytedance.apm.d.getContext().getApplicationInfo().nativeLibraryDir;
        boolean r2 = true;
        if (TextUtils.isEmpty(r0) == false) goto L5;
    L7:
        StringBuilder r1 = new StringBuilder();
        if (Build.SUPPORTED_ABIS.length <= 0) goto L16;
        int r3 = 0;
    L10:
        String[] r4 = Build.SUPPORTED_ABIS;
        if (r3 >= r4.length) goto L17;
        r1.append(r4[r3]);
        if (r3 == (r4.length - 1)) goto L15;
        r1.append(", ");
    L15:
        r3 = r3 + 1;
    L17:
        String r5 = r1.toString();
        if (r5 != null) goto L20;
    L22:
        h r6 = h.a.a;
        BufferedReader r7 = null;
        String r8 = null;
        BufferedReader r9 = null;
        String r10 = r6.a.getString("sp_cpu_model", null);
        int r11 = r6.a.getInt("sp_cpu_core_num", -1);
        if (TextUtils.isEmpty(r10) == true) goto L86;
        this.d = r10;
        this.e = r11;
        return;
    L86:
        BufferedReader r12 = new BufferedReader(new PolarisFileReaderWrapper("/proc/cpuinfo"));     // Catch: Throwable -> L44 Exception -> L48
        int r13 = 0;
    L84:
        String r14 = r12.readLine();     // Catch: Throwable -> L41 Exception -> L43
        if (r14 == null) goto L82;
        String[] r15 = r14.split(":");     // Catch: Throwable -> L41 Exception -> L43
        if (r15.length != 2) goto L84;
        if (r15[0].startsWith("Hardware") == true) goto L34;
        if (r15[0].startsWith("processor") == false) goto L84;
        r13 = r13 + 1;
        goto L84
    L34:
        r8 = r15[1].trim();     // Catch: Throwable -> L41 Exception -> L43
        goto L84
    L82:
        r12.close();     // Catch: Exception -> L40
    L54:
        this.d = r8;
        this.e = r13;
        if (TextUtils.isEmpty(r8) == false) goto L71;
        String r16 = Build.BRAND;     // Catch: Throwable -> L66
        if (TextUtils.isEmpty(r16) == false) goto L60;
    L61:
        String r17 = Build.MANUFACTURER;     // Catch: Throwable -> L66
        if (TextUtils.isEmpty(r17) == true) goto L67;
        if (r17.toLowerCase().startsWith("hua") == false) goto L67;
    L68:
        if (r2 == false) goto L71;
        this.d = Build.HARDWARE;
        goto L71
    L60:
        if (r16.toLowerCase().startsWith("hua") == true) goto L68;
    L67:
        r2 = false;
    L71:
        if (TextUtils.isEmpty(this.d) == false) goto L73;
        this.d = "unknown";
    L73:
        r6.a.edit().putString("sp_cpu_model", this.d).apply();
        r6.a.edit().putInt("sp_cpu_core_num", this.e).apply();
        return;
    L43:
        String r18 = r8;
        r9 = r12;
        String r19 = r18;
    L49:
        if (r9 != null) goto L78;
    L53:
        r8 = r19;
        goto L54
    L78:
        r9.close();     // Catch: Exception -> L52
    L41:
        th = th;
        r7 = r12;
    L45:
        if (r7 != null) goto L80;
    L47:
        throw th;
    L80:
        r7.close();     // Catch: Exception -> L75
        goto L47
    L48:
        r19 = null;
        r13 = 0;
    L44:
        th = th;
        goto L45
    L20:
        if (r5.contains("64") == false) goto L22;
        this.c = true;
        goto L22
    L16:
        r1 = new StringBuilder(Build.CPU_ABI);
        goto L17
    L5:
        if (r0.endsWith("arm64") == false) goto L7;
        this.b = true;
        goto L7
    }

    public final void g() {
        ActivityManager r0 = (ActivityManager) com.bytedance.apm.d.getContext().getSystemService("activity");
        ActivityManager.MemoryInfo r1 = new ActivityManager.MemoryInfo();
        r0.getMemoryInfo(r1);
        int r2 = Build.VERSION.SDK_INT;
        this.f = (int) (r1.totalMem / 536870912);
        if (r2 < 24) goto L5;
        this.k = "jemalloc";
        return;
    L5:
        h r3 = h.a.a;
        String r4 = r3.a.getString("sp_malloc_impl", null);
        if (r4 != null) goto L8;
        r4 = "unknown";
        r3.a.edit().putString("sp_malloc_impl", "unknown").apply();
    L8:
        this.k = r4;
    }

    public final void c(JSONObject r11) throws JSONException {
        if (this.a == false) goto L11;
        this.g = Debug.getNativeHeapAllocatedSize() / 1048576;
        Runtime r0 = Runtime.getRuntime();
        long r4 = r0.maxMemory();
        long r6 = r0.freeMemory();
        long r1 = r0.totalMemory();
        this.i = r4 / 1048576;
        long r2 = r1 - r6;
        this.j = r2 / 1048576;
        if (r2 <= (r4 * 0.95f)) goto L8;
        boolean r3 = true;
    L9:
        this.h = r3;
        r11.put("apm_native_heap_size", this.g);
        r11.put("apm_java_heap_leak", this.h);
        r11.put("apm_java_heap_used", this.j);
        r11.put("apm_java_heap_max", this.i);
        return;
    L8:
        r3 = false;
        goto L9
    }

    public final void d(JSONObject r9) throws JSONException {
        if (this.a == true) goto L6;
        return;
    L6:
        if (this.m == 0) goto L9;
        r9.put("apm_sys_avail_size", this.n / 1048576);
        r9.put("apm_sys_avail_ratio", this.o);
    L9:
        if (this.p == 0) goto L12;
        r9.put("apm_data_avail_size", this.q / 1073741824);
        r9.put("apm_data_avail_ratio", this.r);
    L12:
        if (this.s == 0) goto L15;
        r9.put("apm_sd_avail_size", this.t / 1073741824);
        r9.put("apm_sd_avail_ratio", this.u);
    L15:
        if (this.v == false) goto L18;
        r9.put("apm_external_removable", this.w);
        return;
    }

    public static double e(long r3, long r5) {
        if (r5 != 0) goto L7;
        return 0.0d;
    L7:
        return Math.round((r3 / r5) * 100.0d) / 100.0d;
    }

    public final void a(JSONObject r3, boolean r4) {
        if (this.a == true) goto L19;
        if (r4 == true) goto L19;
        return;
    L19:
        e r5 = a.a;     // Catch: JSONException -> L18
        if (r5.a == false) goto L13;
        r3.put("apm_is_app_64", r5.b);     // Catch: JSONException -> L18
        r3.put("apm_is_device_64", r5.c);     // Catch: JSONException -> L18
        r3.put("apm_cpu_model", r5.d);     // Catch: JSONException -> L18
        int r0 = r5.e;     // Catch: JSONException -> L18
        if (r0 <= 0) goto L13;
        r3.put("apm_cpu_core_num", r0);     // Catch: JSONException -> L18
    L13:
        if (r5.a == false) goto L16;
        r3.put("apm_physical_mem", r5.f);     // Catch: JSONException -> L18
        r3.put("apm_malloc_impl", r5.k);     // Catch: JSONException -> L18
    L16:
        r5.d(r3);     // Catch: JSONException -> L18
        return;
    }

    public final void b(JSONObject r2, boolean r3) {
        if (this.a == true) goto L9;
        if (r3 == true) goto L9;
        return;
    L9:
        a.a.c(r2);     // Catch: JSONException -> L8
        return;
    }
}
