package q3;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Debug;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.bytedance.apm.d;
import com.bytedance.apm.util.f;
import com.bytedance.crash.Npth;
import com.bytedance.memory.heap.HeapDump;
import com.bytedance.memory.model.MemoryWidgetConfig;
import java.io.File;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import p3.e;
import p3.h;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final File f12463d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile c f12464e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static q3.b f12465f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f12466a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f12467b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private SharedPreferences f12468c;

    class a implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f12469c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ c f12470g;

        a(c r10, int r11) {
            this.f12470g = r10;
            this.f12469c = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.a(this.f12470g, this.f12469c);
        }
    }

    class b extends TimerTask {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ c f12471c;

        b(c r10) {
            this.f12471c = r10;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            c r10 = this.f12471c;
            r10.q(c.b(r10));
            p3.c.c("setOOMDumpCost " + c.b(this.f12471c), new Object[0]);
            c.c(this.f12471c);
        }
    }

    static {
    }

    private c() {
        this.f12466a = System.currentTimeMillis();
        this.f12467b = 1;
        o3.a.j().i();
    }

    static /* synthetic */ void a(c r10, int r11) {
        r10.j(r11);
    }

    static /* synthetic */ int b(c r10) {
        return r10.f12467b;
    }

    static /* synthetic */ int c(c r10) {
        int r11 = r10.f12467b;
        r10.f12467b = r11 + 1;
        return r11;
    }

    private File f(File r10) {
        String r11 = d.k().optString("update_version_code");
        com.bytedance.memory.heap.a.j().y(r11);
        File r12 = new File(r10.getParent(), r11 + "_shrink.zip");
        HashMap<String, Object> r13 = new HashMap();
        r13.put("before_hprof_compress_size", Long.valueOf(r10.length()));
        u3.a.b().c("compressSaveFile_begin", r13);
        h.c(r10, r12);
        if (r10.exists() == false) goto L5;
        r10.delete();
    L5:
        HashMap<String, Object> r14 = new HashMap();
        r14.put("after_hprof_compress_size", Long.valueOf(r12.length()));
        u3.a.b().c("compressSaveFile_end", r14);
        com.bytedance.memory.heap.a.j().x(true);
        com.bytedance.memory.heap.a.j().w(r12.getAbsolutePath());
        com.bytedance.memory.heap.a.j().v(4);
        return r12;
    }

    @WorkerThread
    private void g(int r20) {
        r3.a.e("dumpAndSave");
        long r10 = System.nanoTime();
        File r11 = f12465f.l();
        File r12 = f12463d;
        if (r11 != r12) goto L6;
        r3.a.e("dumpAndSave_error_noHeapInfoFile");
        return;
    L6:
        File r13 = r11.getParentFile();
        if (r13.exists() == true) goto L9;
        r13.mkdirs();
    L9:
        long r14 = System.currentTimeMillis();
        r3.a.f("dump_begin");
        MemoryWidgetConfig.a r15 = o3.a.j().k().getDumpAndShrinkConfig();
        u3.a.b().f("dump_begin");
        if (r15 != null) goto L12;
    L18:
        u3.a.b().f("origin_dump");
        File r16 = o(r11, r20);
        com.bytedance.memory.heap.a.j().x(false);
    L19:
        r3.a.f("dump_end");
        HashMap<String, Object> r17 = new HashMap();
        r17.put("oom_dump_cost", Integer.valueOf(this.f12467b));
        u3.a.b().c("dump_end", r17);
        r3.a.g("dump_time", System.currentTimeMillis() - r14);
        if (r16 != r12) goto L22;
        return;
    L22:
        long r18 = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - r10);
        r3.a.e("dumpAndSave_saveHeapDump");
        p(r16, r18);
        com.bytedance.memory.heap.a.j().C(System.currentTimeMillis());
        return;
    L12:
        if (r3.a.a("close_native_dump_and_shrink") == true) goto L18;
        File r19 = new File(q3.b.e().i(), ".mini.hprof");
        r3.a.e("tailor_dump_begin");
        u3.a.b().f("tailor_dump_begin");
        Timer r110 = new Timer("MemoryWidgetHeartbeat", true);
        this.f12467b = 1;
        r110.schedule(new b(this), 1000, 1000);
        if (r15.a(r19) == false) goto L16;
        r16 = f(r19);
        u3.a.b().f("tailor_dump_end");
        r3.a.e("tailor_dump_end");
    L17:
        r110.cancel();
        e();
        goto L19
    L16:
        r3.a.e("tailor_exception");
        u3.a.b().f("tailor_exception");
        r16 = o(r11, r20);
        com.bytedance.memory.heap.a.j().x(false);
        goto L17
    }

    private void j(int r10) {
    L6:
        e = move-exception;
        e.printStackTrace();
        return;
    L3:
        if (d() == false) goto L11;
        g(r10);     // Catch: Exception -> L6
        v3.a.i().h();     // Catch: Exception -> L6
        return;
    }

    private long k() {
        if (TextUtils.isEmpty(o3.a.j().l()) == true) goto L7;
        return l(new File(o3.a.j().l()));
    L7:
        if ("mounted".equals(Environment.getExternalStorageState()) == true) goto L9;
        return 0;
    L9:
        return l(f.a(d.g()));
    L14:
        return 0;
    }

    public static long l(File r10) {
        StatFs r11 = new StatFs(r10.getPath());     // Catch: Throwable -> L9
        if (Build.VERSION.SDK_INT < 18) goto L8;
        return r11.getAvailableBytes();
    L8:
        return ((long) r11.getBlockCount()) * r11.getBlockSize();
    L9:
        return 0;
    }

    public static c m() {
        if (f12464e != null) goto L15;
        monitor-enter(c.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f12464e != null) goto L9;
        f12464e = new c();     // Catch: Throwable -> L11
        f12465f = q3.b.e();     // Catch: Throwable -> L11
    L9:
        monitor-exit(c.class);     // Catch: Throwable -> L11
    L15:
        return f12464e;
    }

    @Nullable
    private File o(File r10, int r11) {
        r3.a.e("apm_dump_begin");
        if (r11 != 2) goto L5;
        p3.c.c("Native dump", new Object[0]);     // Catch: Exception -> L8
        Npth.dumpHprof(r10.getAbsolutePath());     // Catch: Exception -> L8
        p3.c.c("Native dump exist ? " + new File(r10.getAbsolutePath()).exists(), new Object[0]);     // Catch: Exception -> L8
    L6:
        com.bytedance.memory.heap.a.j().y(d.k().optString("update_version_code"));     // Catch: Exception -> L8
        return r10;
    L5:
        Debug.dumpHprofData(r10.getAbsolutePath());     // Catch: Exception -> L8
        r3.a.e("apm_dump_end");     // Catch: Exception -> L8
    L8:
        r3.a.e("realDump_error");
        return f12463d;
    }

    @NonNull
    private HeapDump p(@NonNull File r10, long r11) {
        HeapDump r12 = HeapDump.newBuilder().g(r10).e(0).c(this.f12466a).h(r10.length()).d(e.f12324a).f(r11).a();
        p3.c.c(r12.toString(), new Object[0]);
        com.bytedance.memory.heap.a.j().s(r12);
        return r12;
    }

    public boolean d() {
        long r10 = k();     // Catch: Exception -> L12
        long r11 = com.bytedance.apm.util.b.j();     // Catch: Exception -> L12
        if (r10 > 0) goto L5;
    L10:
        r3.a.e("StorageNotEnough");     // Catch: Exception -> L12
        return false;
    L5:
        if (r11 <= 0) goto L10;
        if (r10 <= (r11 * 0.2f)) goto L10;
        return true;
    L12:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    public void e() {
        if (this.f12468c != null) goto L5;
        this.f12468c = o3.a.j().i().getSharedPreferences("oom_dump_cost", 0);
    L5:
        this.f12468c.edit().remove(q3.b.e().j()).commit();
    }

    public void h(long r10) {
        int r11 = 2;
        if (o3.a.j().k().getRunStrategy() == 2) goto L6;
        r11 = 1;
    L6:
        i(r10, r11);
    }

    public void i(long r10, int r11) {
        this.f12466a = r10;
        com.bytedance.memory.heap.a.j().m();
        if (o3.a.j().k().getRunStrategy() != 2) goto L5;
        p3.b.f12318a.a(new a(this, r11), "HeapDumper-dumpHeap");
        return;
    L5:
        j(r11);
    }

    public int n() {
        if (this.f12468c != null) goto L6;
        this.f12468c = o3.a.j().i().getSharedPreferences("oom_dump_cost", 0);
    L6:
        return this.f12468c.getInt(q3.b.e().j(), 0);
    }

    public void q(int r10) {
        if (this.f12468c != null) goto L5;
        this.f12468c = o3.a.j().i().getSharedPreferences("oom_dump_cost", 0);
    L5:
        this.f12468c.edit().putInt(q3.b.e().j(), r10).commit();
    }
}
