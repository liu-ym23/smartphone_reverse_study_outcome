package m2;

import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.connectionclass.ConnectionQuality;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private c f11004a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile boolean f11005b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private AtomicReference<ConnectionQuality> f11006c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private AtomicReference<ConnectionQuality> f11007d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ArrayList<b> f11008e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f11009f;

    /* JADX INFO: renamed from: m2.a$a, reason: collision with other inner class name */
    private static class C0239a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f11010a = null;

        static {
            f11010a = new a();
        }
    }

    public interface b {
        void l(ConnectionQuality r10);
    }

    protected a() {
        this.f11004a = new c(0.05d);
        this.f11005b = false;
        this.f11006c = new AtomicReference(ConnectionQuality.UNKNOWN);
        this.f11008e = new ArrayList();
    }

    public static a c() {
        return C0239a.f11010a;
    }

    private ConnectionQuality d(double r10) {
        if (r10 >= 0.0d) goto L7;
        return ConnectionQuality.UNKNOWN;
    L7:
        if (r10 >= 28.0d) goto L11;
        return ConnectionQuality.POOR;
    L11:
        if (r10 >= 112.0d) goto L15;
        return ConnectionQuality.MODERATE;
    L15:
        if (r10 >= 560.0d) goto L19;
        return ConnectionQuality.GOOD;
    L19:
        return ConnectionQuality.EXCELLENT;
    }

    private void e() {
        int r10 = this.f11008e.size();     // Catch: Throwable -> L6
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L12;
        this.f11008e.get(r11).l(this.f11006c.get());     // Catch: Throwable -> L6
        r11 = r11 + 1;
        goto L3
    L12:
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
    }

    private boolean g() {
        if (this.f11004a != null) goto L29;
        return false;
    L29:
        ConnectionQuality r10 = this.f11006c.get();     // Catch: Throwable -> L26
        double r11 = 560.0d;
        double r12 = 112.0d;
        if (ConnectionQuality.POOR != r10) goto L9;
        r12 = 0.0d;
        r11 = 28.0d;
    L17:
        double r13 = this.f11004a.b();     // Catch: Throwable -> L26
        if (r13 <= r11) goto L24;
        if (r13 <= (r11 * 1.25d)) goto L28;
        return true;
    L28:
        return false;
    L24:
        if (r13 >= (r12 * 0.8d)) goto L28;
    L25:
        return true;
    L9:
        if (ConnectionQuality.MODERATE != r10) goto L12;
        r11 = 112.0d;
        r12 = 28.0d;
        goto L17
    L12:
        if (ConnectionQuality.GOOD == r10) goto L17;
        if (ConnectionQuality.EXCELLENT != r10) goto L25;
        r11 = 3.4028234663852886E38d;
        r12 = 560.0d;
    L26:
        th = move-exception;
        th.printStackTrace();
        goto L28
    }

    public synchronized void a(long r10, long r11) {
        monitor-enter(this);
        double r12 = ((r10 * 1.0d) / r11) * 8.0d;
        if (r11 != 0) goto L6;
    L28:
        monitor-exit(this);
        return;
    L6:
        if (r12 < 3.0d) goto L28;
        if (Logger.debug() == false) goto L11;
        Logger.d("ConnectionClassManager", "bytes = " + r10 + " timeInMs = " + r11 + " bandwidth = " + r12);     // Catch: Throwable -> L30
    L11:
        this.f11004a.a(r12);     // Catch: Throwable -> L30
        if (this.f11005b == false) goto L24;
        this.f11009f++;     // Catch: Throwable -> L30
        if (b() == this.f11007d.get()) goto L17;
        this.f11005b = false;     // Catch: Throwable -> L30
        this.f11009f = 1;     // Catch: Throwable -> L30
    L17:
        if (this.f11009f >= 5.0d) goto L19;
    L21:
        monitor-exit(this);
        return;
    L19:
        if (g() == false) goto L21;
        this.f11005b = false;     // Catch: Throwable -> L30
        this.f11009f = 1;     // Catch: Throwable -> L30
        this.f11006c.set(this.f11007d.get());     // Catch: Throwable -> L30
        e();     // Catch: Throwable -> L30
        goto L21
    L24:
        if (this.f11006c.get() == b()) goto L26;
        this.f11005b = true;     // Catch: Throwable -> L30
        this.f11007d = new AtomicReference(b());     // Catch: Throwable -> L30
    L26:
        monitor-exit(this);
    }

    public synchronized ConnectionQuality b() {
        monitor-enter(this);
        c r10 = this.f11004a;     // Catch: Throwable -> L15
        if (r10 != null) goto L18;
        ConnectionQuality r11 = ConnectionQuality.UNKNOWN;     // Catch: Throwable -> L15
        monitor-exit(this);
        return r11;
    L18:
        ConnectionQuality r12 = d(r10.b());     // Catch: Throwable -> L11
        monitor-exit(this);
        return r12;
    L11:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L15
        return ConnectionQuality.UNKNOWN;
    L15:
        th = move-exception;
        throw th;
    }

    public ConnectionQuality f(b r10) {
        if (r10 == null) goto L5;
        this.f11008e.add(r10);
    L5:
        return this.f11006c.get();
    }
}
