package a1;

import com.bytedance.applog.monitor.MonitorKey;
import com.bytedance.applog.monitor.MonitorState;
import com.bytedance.common.utility.NetworkUtils;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static final long[] f8g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final c f9a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f10b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    volatile boolean f11c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f12d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f13e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected long f14f;

    static {
        f8g = new long[]{180000, 180000, 360000, 360000, 540000, 540000, 720000, 720000};
    }

    public a(c r10) {
        this.f9a = r10;
    }

    public a(c r10, long r11) {
        this(r10);
        this.f12d = r11;
    }

    private long b() {
        long r10 = j();
        if (i() == false) goto L8;
        if (NetworkUtils.h(this.f9a.w()) == true) goto L8;
        d().P().c("checkWorkTime, " + f() + ", network not available", new Object[0]);
        this.f9a.s().R().j(MonitorKey.pack, MonitorState.f_no_network, 1);
    L14:
        return this.f12d + r10;
    L8:
        if (this.f11c == false) goto L10;
        this.f12d = 0;
        this.f11c = false;
        r10 = 0;
        goto L14
    L10:
        int r11 = this.f10b;
        if (r11 <= 0) goto L14;
        r10 = e(r11 - 1);
        goto L14
    }

    private long e(int r10) {
        long[] r11 = g();
        return r11[r10 % r11.length];
    }

    private synchronized long l(int r10) {
        monitor-enter(this);
        boolean r11 = c(r10);     // Catch: Throwable -> L13
        this.f12d = System.currentTimeMillis();     // Catch: Throwable -> L11
        if (r11 == false) goto L8;
        this.f10b = 0;     // Catch: Throwable -> L11
    L9:
        d().P().i(f() + " worked:" + r11, new Object[0]);     // Catch: Throwable -> L11
    L16:
        long r12 = b();     // Catch: Throwable -> L11
        monitor-exit(this);
        return r12;
    L8:
        this.f10b++;     // Catch: Throwable -> L11
        goto L9
    L11:
        th = move-exception;
        throw th;
    L13:
        th = move-exception;
        d().P().j("work failed", th, new Object[0]);     // Catch: Throwable -> L19
        this.f12d = System.currentTimeMillis();     // Catch: Throwable -> L11
        this.f10b++;     // Catch: Throwable -> L11
        d().P().i(f() + " worked:false", new Object[0]);     // Catch: Throwable -> L11
        goto L16
    L19:
        th = move-exception;
        this.f12d = System.currentTimeMillis();     // Catch: Throwable -> L11
        this.f10b++;     // Catch: Throwable -> L11
        d().P().i(f() + " worked:false", new Object[0]);     // Catch: Throwable -> L11
        throw th;     // Catch: Throwable -> L11
    }

    final long a(int r10) {
        long r11 = b();
        if (r11 <= System.currentTimeMillis()) goto L5;
        return r11;
    L5:
        return l(r10);
    }

    protected abstract boolean c(int r10);

    protected com.bytedance.applog.c d() {
        return this.f9a.s();
    }

    protected abstract String f();

    protected abstract long[] g();

    boolean h() {
        if (d().X() == true) goto L5;
    L8:
        return true;
    L5:
        if (this.f13e == true) goto L8;
        return false;
    }

    protected abstract boolean i();

    protected abstract long j();

    /* JADX WARN: Multi-variable type inference failed */
    <T extends a> T k() {
        this.f11c = true;
        return this;
    }
}
