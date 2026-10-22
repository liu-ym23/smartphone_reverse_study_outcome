package qb;

import android.util.SparseArray;
import com.bytedance.apm6.util.constant.CommonConsts;

/* JADX INFO: loaded from: classes2.dex */
public class b implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SparseArray f12490a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile int f12491b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile int f12492c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile boolean f12493d;

    class a implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.ss.android.socialbase.downloader.model.d f12494c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ b f12495g;

        a(b r10, com.ss.android.socialbase.downloader.model.d r11) {
            this.f12495g = r10;
            this.f12494c = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.c(this.f12495g, this.f12494c);
        }
    }

    /* JADX INFO: renamed from: qb.b$b, reason: collision with other inner class name */
    class RunnableC0284b implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.ss.android.socialbase.downloader.model.d f12496c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ b f12497g;

        RunnableC0284b(b r10, com.ss.android.socialbase.downloader.model.d r11) {
            this.f12497g = r10;
            this.f12496c = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.d(this.f12497g, this.f12496c);
        }
    }

    public b() {
        this.f12490a = new SparseArray();
        this.f12491b = 0;
        this.f12492c = 0;
    }

    static /* synthetic */ void c(b r10, com.ss.android.socialbase.downloader.model.d r11) {
        r10.i(r11);
    }

    static /* synthetic */ void d(b r10, com.ss.android.socialbase.downloader.model.d r11) {
        r10.g(r11);
    }

    private void e(com.ss.android.socialbase.downloader.model.d r10) {
        if (lb.a.a() == false) goto L6;
        lb.a.g("globalThrottle", r10.x(), "addTaskAndThrottleSpeedReset", "add to map!");
    L6:
        if (r10.K() <= this.f12492c) goto L9;
        return;
    L9:
        if (this.f12493d == false) goto L11;
        r10.y().setDynamicThrottleEnable(true);
        jb.f.u(com.ss.android.socialbase.downloader.downloader.a.h()).p(r10.x(), true);
    L11:
        SparseArray r11 = this.f12490a;
        monitor-enter(r11);
        this.f12490a.put(r10.x(), r10);     // Catch: Throwable -> L20
        if (this.f12491b > 0) goto L17;
        monitor-exit(r11);     // Catch: Throwable -> L20
        return;
    L17:
        j();     // Catch: Throwable -> L20
        monitor-exit(r11);     // Catch: Throwable -> L20
        return;
    L20:
        th = move-exception;
        throw th;
    }

    private void f(com.ss.android.socialbase.downloader.model.d r10) {
        SparseArray r11 = this.f12490a;
        monitor-enter(r11);
        this.f12490a.remove(r10.x());     // Catch: Throwable -> L17
        if (lb.a.a() == false) goto L8;
        lb.a.g("globalThrottle", r10.x(), "deleteTaskAndThrottleSpeedReset", "taskCount=" + this.f12490a.size() + ",mThrottleSpeed=" + this.f12491b);     // Catch: Throwable -> L17
    L8:
        if (this.f12491b != 0) goto L10;
    L15:
        monitor-exit(r11);     // Catch: Throwable -> L17
        return;
    L10:
        if (this.f12493d == true) goto L15;
        j();     // Catch: Throwable -> L17
        monitor-exit(r11);     // Catch: Throwable -> L17
        return;
    L17:
        th = move-exception;
        throw th;
    }

    private void g(com.ss.android.socialbase.downloader.model.d r10) {
        if (lb.a.a() == false) goto L5;
        lb.a.g("globalThrottle", r10.x(), "endInternal", "task end!");
    L5:
        f(r10);
    }

    private int h() {
        int r10 = 0;
        if (this.f12490a.size() != 0) goto L5;
        return 0;
    L5:
        int r11 = 0;
    L7:
        if (r10 >= this.f12490a.size()) goto L14;
        if (((com.ss.android.socialbase.downloader.model.d) this.f12490a.valueAt(r10)).K() > this.f12492c) goto L12;
        r11 = r11 + 1;
    L12:
        r10 = r10 + 1;
        goto L7
    L14:
        if (lb.a.a() == false) goto L16;
        lb.a.b("globalThrottle", "getThrottleTaskSize", "throttle task size=" + r11);
    L16:
        return r11;
    }

    private void i(com.ss.android.socialbase.downloader.model.d r10) {
        e(r10);
    }

    private void j() {
        int r10 = h();
        int r11 = 0;
        if (this.f12491b <= 0) goto L7;
        if (r10 <= 0) goto L7;
        int r12 = this.f12491b / r10;
    L11:
        if (lb.a.a() == false) goto L14;
        lb.a.b("globalThrottle", "throttleSpeedReset", "mThrottleSpeed=" + this.f12491b + ",taskCount=" + r10);
    L14:
        if (r11 >= this.f12490a.size()) goto L27;
        com.ss.android.socialbase.downloader.model.d r13 = (com.ss.android.socialbase.downloader.model.d) this.f12490a.valueAt(r11);
        if (r13.K() > this.f12492c) goto L26;
        int r14 = 51200;
        if (r12 == 0) goto L21;
        if (r12 >= 51200) goto L21;
    L23:
        if (lb.a.a() == false) goto L25;
        lb.a.b("globalThrottle", "throttleSpeedReset", "TTNet api set speed=" + r14);
    L25:
        long r15 = r14;
        r13.y().setThrottleNetSpeed(r15);
        jb.f.u(com.ss.android.socialbase.downloader.downloader.a.h()).q(r13.x(), r15);
    L21:
        r14 = r12;
    L26:
        r11 = r11 + 1;
        goto L14
    L27:
        return;
    L7:
        if (this.f12491b != 0) goto L9;
        r12 = 0;
        goto L11
    L9:
        r12 = 2097152;
        goto L11
    }

    @Override // qb.m
    public void a(com.ss.android.socialbase.downloader.model.d r10) {
        if (rb.a.d().optInt("global_throttle_enable", 0) > 0) goto L6;
        return;
    L6:
        if (lb.a.a() == false) goto L9;
        lb.a.g("globalThrottle", r10.x(), CommonConsts.APM_INNER_EVENT_COST_START, "start throttle!");
    L9:
        if (com.ss.android.socialbase.downloader.utils.g.O() == false) goto L11;
        com.ss.android.socialbase.downloader.downloader.a.F().submit(new a(this, r10));
        return;
    L11:
        i(r10);
    }

    @Override // qb.m
    public void b(com.ss.android.socialbase.downloader.model.d r10) {
        if (rb.a.d().optInt("global_throttle_enable", 0) > 0) goto L5;
        return;
    L5:
        com.ss.android.socialbase.downloader.downloader.a.F().submit(new RunnableC0284b(this, r10));
    }
}
