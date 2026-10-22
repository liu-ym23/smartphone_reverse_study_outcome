package s3;

import android.os.Debug;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.work.WorkRequest;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.IOOMCallback;
import com.bytedance.crash.Npth;
import com.bytedance.crash.resource.vmmonitor.VmMonitorConfig;
import com.bytedance.memory.model.MemoryWidgetConfig;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f12721a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile boolean f12722b;

    class a implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ b f12723c;

        a(b r10) {
            this.f12723c = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.a(this.f12723c);     // Catch: Exception -> L4
            return;
        L4:
            e = move-exception;
            e.printStackTrace();
        }
    }

    /* JADX INFO: renamed from: s3.b$b, reason: collision with other inner class name */
    class C0290b implements IOOMCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f12724a;

        C0290b(b r10) {
            this.f12724a = r10;
        }

        @Override // com.bytedance.crash.IOOMCallback
        public void onCrash(@NonNull CrashType r10, @Nullable Throwable r11, @Nullable Thread r12, long r13) {
            p3.c.c("onCrash callback", new Object[0]);
            if (r11 != null) goto L5;
            return;
        L5:
            if ((r11 instanceof OutOfMemoryError) == false) goto L7;
            return;
        L7:
            if (q3.c.m().d() == false) goto L12;
            b.b(this.f12724a);
            return;
        }
    }

    class c implements Runnable {
        c(b r10) {
        }

        @Override // java.lang.Runnable
        public void run() {
            File r10 = q3.b.e().f();     // Catch: Throwable -> L10
            if (r10 != null) goto L5;
            return;
        L5:
            if (r10.exists() == true) goto L7;
            return;
        L7:
            if (r10.isDirectory() == false) goto L17;
            q3.a.d().c(r10);     // Catch: Throwable -> L10
            return;
        L17:
            return;
        L10:
            th = move-exception;
            th.printStackTrace();
        }
    }

    private static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final b f12725a = null;

        static {
            f12725a = new b(null);
        }

        static /* synthetic */ b a() {
            return f12725a;
        }
    }

    private b() {
    }

    /* synthetic */ b(a r10) {
        this();
    }

    static /* synthetic */ void a(b r10) {
        r10.c();
    }

    static /* synthetic */ void b(b r10) {
        r10.d();
    }

    private void c() {
        if (r3.a.d("npth_hprof_close_expired") == false) goto L5;
        return;
    L5:
        p3.b.f12318a.a(new c(this), "checkFileExpired");
    }

    private void d() {
    L27:
        th = move-exception;
        th.printStackTrace();
        return;
    L3:
        if ((System.currentTimeMillis() - this.f12721a) >= VmMonitorConfig.SLEEP_TIME_BEFORE_RECOVER) goto L5;
        return;
    L5:
        this.f12721a = System.currentTimeMillis();     // Catch: Throwable -> L27
        r3.a.f("npth_dump_begin");     // Catch: Throwable -> L27
        MemoryWidgetConfig.a r10 = o3.a.j().k().getDumpAndShrinkConfig();     // Catch: Throwable -> L27
        File r11 = q3.b.e().f();     // Catch: Throwable -> L27
        if (r10 != null) goto L9;
    L21:
        File r12 = new File(r11, "npth.jpg");     // Catch: Throwable -> L27
        if (r12.exists() == false) goto L24;
        r12.delete();     // Catch: Throwable -> L27
    L24:
        String r13 = r12.getAbsolutePath();     // Catch: Throwable -> L27
    L20:
        Debug.dumpHprofData(r13);     // Catch: Throwable -> L27
    L25:
        r3.a.f("npth_dump_end");     // Catch: Throwable -> L27
        p3.c.c("onCrash dump finish:" + r12.getAbsolutePath(), new Object[0]);     // Catch: Throwable -> L27
        return;
    L9:
        if (r3.a.a("close_native_dump_and_shrink") == true) goto L21;
        r12 = new File(r11, "npth_mini.jpg");     // Catch: Throwable -> L27
        if (r12.exists() == false) goto L14;
        r12.delete();     // Catch: Throwable -> L27
    L14:
        if (r10.a(r12) == true) goto L25;
        r12 = new File(r11, "npth.jpg");     // Catch: Throwable -> L27
        if (r12.exists() == false) goto L19;
        r12.delete();     // Catch: Throwable -> L27
    L19:
        r13 = r12.getAbsolutePath();     // Catch: Throwable -> L27
        goto L20
    }

    public static b e() {
        return d.a();
    }

    private void g() {
        Npth.registerHprofCallback(new C0290b(this));
    }

    public void f() {
    L6:
        th = move-exception;
        th.printStackTrace();
        return;
    L3:
        if (this.f12722b == true) goto L11;
        this.f12722b = true;     // Catch: Throwable -> L6
        g();     // Catch: Throwable -> L6
        q0.b.f().j(new a(this), WorkRequest.MIN_BACKOFF_MILLIS);     // Catch: Throwable -> L6
        p3.c.c("registerCrashCallBack", new Object[0]);     // Catch: Throwable -> L6
        return;
    }
}
