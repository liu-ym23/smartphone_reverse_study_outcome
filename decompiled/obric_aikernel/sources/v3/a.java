package v3;

import androidx.annotation.NonNull;
import com.bytedance.memory.model.MemoryWidgetConfig;
import com.bytedance.monitor.util.thread.AsyncTaskType;
import z3.c;
import z3.d;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static volatile a f13172h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile boolean f13173a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile boolean f13174b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile boolean f13175c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private p3.a f13176d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private c f13177e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private MemoryWidgetConfig f13178f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private d f13179g;

    /* JADX INFO: renamed from: v3.a$a, reason: collision with other inner class name */
    class C0303a implements d {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ a f13180c;

        C0303a(a r10) {
            this.f13180c = r10;
        }

        @Override // z3.d
        public AsyncTaskType J() {
            return AsyncTaskType.IO;
        }

        @Override // z3.d
        public String P() {
            return "mDumpHeapTask-MC";
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.a(this.f13180c) == true) goto L9;
            a r10 = this.f13180c;
            if (a.c(r10, a.b(r10)) == false) goto L10;
            a.d(this.f13180c, true);
            a.e(this.f13180c).d();
            p3.c.c("begin dumpHeap", new Object[0]);
            return;
        L10:
            return;
        }
    }

    static {
    }

    private a() {
        this.f13173a = false;
        this.f13174b = false;
        this.f13175c = false;
        this.f13179g = new C0303a(this);
        this.f13177e = z3.b.a();
    }

    static /* synthetic */ boolean a(a r10) {
        return r10.g();
    }

    static /* synthetic */ MemoryWidgetConfig b(a r10) {
        return r10.f13178f;
    }

    static /* synthetic */ boolean c(a r10, MemoryWidgetConfig r11) {
        return r10.f(r11);
    }

    static /* synthetic */ boolean d(a r10, boolean r11) {
        r10.f13175c = r11;
        return r11;
    }

    static /* synthetic */ p3.a e(a r10) {
        return r10.f13176d;
    }

    private boolean f(@NonNull MemoryWidgetConfig r10) {
        if (p3.d.c() < r10.getMemoryRate()) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean g() {
        boolean r10 = this.f13176d.c();
        if (r10 == true) goto L5;
    L7:
        if (r10 == true) goto L15;
        if (this.f13175c == true) goto L15;
        if (this.f13174b == true) goto L15;
        if (this.f13176d.b() == true) goto L15;
        return false;
    L15:
        return true;
    L5:
        if (this.f13177e == null) goto L7;
        p3.c.c("canAnalyse, so cancel check", new Object[0]);
        this.f13177e.f(this.f13179g);
        this.f13173a = true;
        goto L7
    }

    public static a i() {
        if (f13172h != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f13172h != null) goto L9;
        f13172h = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f13172h;
    }

    public void h() {
        p3.c.c("finish dumpHeap", new Object[0]);
        this.f13175c = false;
        if (o3.a.j().k().isCombineDumpAndUpload() == false) goto L6;
        u3.a.b().g("oomDump");
        com.bytedance.memory.upload.a.k();
        return;
    }

    public void j(boolean r10) {
        this.f13173a = r10;
    }

    public void k(@NonNull MemoryWidgetConfig r10, @NonNull p3.a r11) {
        if (this.f13173a == false) goto L6;
        p3.c.c("startCheck canAnalyse", new Object[0]);
        return;
    L6:
        this.f13174b = false;
        this.f13178f = r10;
        if (this.f13177e == null) goto L14;
        p3.c.c("enter startCheck", new Object[0]);
        this.f13176d = r11;
        if (r11.a() == false) goto L11;
        int r12 = 1;
    L12:
        long r13 = r12 * 1000;
        this.f13177e.g(this.f13179g, r13, r13);
        return;
    L11:
        r12 = 30;
        goto L12
    }

    public void l() {
        p3.c.c("stopCheck", new Object[0]);
        this.f13174b = true;
        c r10 = this.f13177e;
        if (r10 != null) goto L5;
        return;
    L5:
        r10.f(this.f13179g);
    }
}
