package o3;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.crash.Npth;
import com.bytedance.memory.model.MemoryWidgetConfig;
import com.bytedance.memory.upload.MemoryUploadService;
import org.json.JSONObject;
import p3.d;
import p3.e;
import p3.g;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static volatile a f11488i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f11489a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private MemoryWidgetConfig f11490b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f11491c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile boolean f11492d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private p3.a f11493e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile boolean f11494f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private volatile boolean f11495g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f11496h;

    /* JADX INFO: renamed from: o3.a$a, reason: collision with other inner class name */
    class C0256a implements p3.a {
        C0256a(a r10) {
        }

        @Override // p3.a
        public boolean a() {
            return a.j().h();
        }

        @Override // p3.a
        public boolean b() {
            if (a.j().h() == false) goto L5;
        L7:
            return false;
        L5:
            if (com.bytedance.memory.heap.a.j().p() == false) goto L7;
            return true;
        }

        @Override // p3.a
        public boolean c() {
            return q3.b.e().m();
        }

        @Override // p3.a
        public void d() {
            q3.c.m().h(System.currentTimeMillis());
        }
    }

    class b extends BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f11497a;

        b(a r10) {
            this.f11497a = r10;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r10, Intent r11) {
            p3.c.c("ResultReceiver onReceive", new Object[0]);
            a.a(this.f11497a, false);
            if (r11.hasExtra("Key_Result_Client_Memory") == false) goto L17;
            String r12 = r11.getStringExtra("Key_Result_Client_Memory");
        L12:
            e = move-exception;
            p3.c.c("deleteCache catch", new Object[0]);
            e.printStackTrace();
            return;
        L6:
            if (TextUtils.isEmpty(r12) == false) goto L8;
        L10:
            p3.c.c("deleteCache", new Object[0]);     // Catch: Exception -> L12
            com.bytedance.memory.heap.a.j().d();     // Catch: Exception -> L12
            return;
        L8:
            if (TextUtils.isEmpty(new JSONObject(r12).optString("memory_object")) == true) goto L10;
            p3.c.c("can upload", new Object[0]);     // Catch: Exception -> L12
            r3.a.e("client_analyze_end");     // Catch: Exception -> L12
            r3.a.g("client_analyze_time", System.currentTimeMillis() - a.b(this.f11497a));     // Catch: Exception -> L12
            com.bytedance.memory.upload.a.l(r12);     // Catch: Exception -> L12
            goto L10
        }
    }

    class c implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f11498c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ a f11499g;

        c(a r10, boolean r11) {
            this.f11499g = r10;
            this.f11498c = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.c(this.f11499g).getRunStrategy() == 2) goto L5;
        L7:
            this.f11499g.f(false);
            a.e(this.f11499g, false);
            if (this.f11498c == false) goto L11;
            MemoryUploadService.b().c();
            return;
        L11:
            return;
        L5:
            if (q3.c.m().d() == false) goto L7;
            v3.a.i().k(a.c(this.f11499g), a.d(this.f11499g));
            goto L7
        }
    }

    private a() {
        this.f11491c = 0;
        this.f11493e = new C0256a(this);
    }

    static /* synthetic */ boolean a(a r10, boolean r11) {
        r10.f11492d = r11;
        return r11;
    }

    static /* synthetic */ long b(a r10) {
        return r10.f11491c;
    }

    static /* synthetic */ MemoryWidgetConfig c(a r10) {
        return r10.f11490b;
    }

    static /* synthetic */ p3.a d(a r10) {
        return r10.f11493e;
    }

    static /* synthetic */ boolean e(a r10, boolean r11) {
        r10.f11495g = r11;
        return r11;
    }

    private void g() {
        com.bytedance.memory.heap.a.j().a();
        if (this.f11490b.clientAnalyse() == false) goto L14;
        p3.c.c("client analyze mode", new Object[0]);
        if (this.f11492d == false) goto L7;
        return;
    L7:
        if (q3.b.e().m() == false) goto L18;
        d.f(this.f11489a, Class.forName("com.bytedance.apm.momory.analyzer.AnalyzerService"), true);     // Catch: Throwable -> L11
        Intent r10 = new Intent(this.f11489a, Class.forName("com.bytedance.apm.momory.analyzer.AnalyzerService"));     // Catch: Throwable -> L11
        r10.putExtra("hprofFilePath", q3.b.e().g().getAbsolutePath());     // Catch: Throwable -> L11
        r10.putExtra("debug", this.f11490b.isDebug());     // Catch: Throwable -> L11
        this.f11489a.startService(r10);     // Catch: Throwable -> L11
        this.f11491c = System.currentTimeMillis();     // Catch: Throwable -> L11
        p3.c.c("start Service success", new Object[0]);     // Catch: Throwable -> L11
        r3.a.e("client_analyze_begin");     // Catch: Throwable -> L11
        this.f11492d = true;     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        p3.c.c("start Service failed", new Object[0]);
        this.f11490b.setClientAnalyse(false);
        th.printStackTrace();
        return;
    L18:
        return;
    L14:
        p3.c.c("upload mode", new Object[0]);
        com.bytedance.memory.upload.a.j();
    }

    public static a j() {
        if (f11488i != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f11488i != null) goto L9;
        f11488i = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f11488i;
    }

    private void n(@NonNull Context r10, @Nullable v3.b r11) {
        b r12 = new b(this);
    L9:
        th = move-exception;
        p3.c.c("sendBroadcast catch", new Object[0]);
        th.printStackTrace();
        return;
    L5:
        if (Build.VERSION.SDK_INT <= 33) goto L7;
        r10.getApplicationContext().registerReceiver(r12, new IntentFilter("Action_Result_Memory_Client_Analyzer"), 2);     // Catch: Throwable -> L9
    L12:
        return;
    L7:
        r10.getApplicationContext().registerReceiver(r12, new IntentFilter("Action_Result_Memory_Client_Analyzer"));     // Catch: Throwable -> L9
        goto L12
    }

    public void f(boolean r10) {
        g();
    }

    public boolean h() {
        MemoryWidgetConfig r10 = this.f11490b;     // Catch: Exception -> L10
        if (r10 != null) goto L6;
        return false;
    L6:
        if (r10.isDebug() == false) goto L16;
        if (d.d(this.f11489a) == true) goto L18;
        return false;
    L18:
        return true;
    L16:
        return false;
    L10:
        e = move-exception;
        p3.c.c(Log.getStackTraceString(e), new Object[0]);
        return false;
    }

    @NonNull
    public Context i() {
        g.a(this.f11489a, "You must call init() first before using !!!");
        return this.f11489a;
    }

    @NonNull
    public MemoryWidgetConfig k() {
        g.a(this.f11490b, MemoryWidgetConfig.class.getSimpleName() + " mustn't be null");
        return this.f11490b;
    }

    public String l() {
        return this.f11496h;
    }

    @MainThread
    public void m(@NonNull Context r10, @NonNull MemoryWidgetConfig r11, @Nullable v3.b r12) {
        if (this.f11494f == false) goto L5;
        return;
    L5:
        g.a(r10, Context.class.getSimpleName() + " mustn't be null");
        g.a(r11, MemoryWidgetConfig.class.getSimpleName() + " mustn't be null");
        this.f11489a = r10;
        this.f11490b = r11;
        e.f12324a = r11.isDebug();
        if (r11.clientAnalyse() == false) goto L8;
        n(r10, r12);
    L8:
        Npth.registerOOMCallback(new s3.a());
        this.f11494f = true;
    }

    public void o(Context r10) {
        this.f11489a = r10;
    }

    public void p(String r10) {
        this.f11496h = r10;
    }

    public void q(boolean r10) {
        if (this.f11495g == false) goto L5;
        return;
    L5:
        p3.c.c("MemoryApi start", new Object[0]);
        this.f11495g = true;
        g.b(this.f11494f, "You must call init() first before using !!!");
        p3.b.f12318a.a(new c(this, r10), "MemoryApi-start");
    }
}
