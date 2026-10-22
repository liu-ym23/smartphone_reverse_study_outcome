package nb;

import com.ss.android.socialbase.downloader.network.NetworkQuality;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d f11330a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile boolean f11331b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AtomicReference<NetworkQuality> f11332c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private AtomicReference<NetworkQuality> f11333d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final List<j.c> f11334e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f11335f;

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f11336a = null;

        static {
            int[] r10 = new int[NetworkQuality.values().length];
            f11336a = r10;
            r10[NetworkQuality.POOR.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            f11336a[NetworkQuality.MODERATE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            f11336a[NetworkQuality.GOOD.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            f11336a[NetworkQuality.EXCELLENT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final k f11337a = null;

        static {
            f11337a = new k(null);
        }
    }

    private k() {
        this.f11330a = new d(0.05d);
        this.f11331b = false;
        this.f11332c = new AtomicReference(NetworkQuality.UNKNOWN);
        this.f11334e = new CopyOnWriteArrayList();
    }

    /* synthetic */ k(a r10) {
        this();
    }

    public static k c() {
        return b.f11337a;
    }

    private NetworkQuality d(double r10) {
        if (r10 >= 0.0d) goto L7;
        return NetworkQuality.UNKNOWN;
    L7:
        if (r10 >= 150.0d) goto L11;
        return NetworkQuality.POOR;
    L11:
        if (r10 >= 550.0d) goto L15;
        return NetworkQuality.MODERATE;
    L15:
        if (r10 >= 2000.0d) goto L19;
        return NetworkQuality.GOOD;
    L19:
        return NetworkQuality.EXCELLENT;
    }

    private void e() {
        int r10 = this.f11334e.size();     // Catch: Throwable -> L6
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L12;
        this.f11334e.get(r11).a(this.f11332c.get());     // Catch: Throwable -> L6
        r11 = r11 + 1;
        goto L3
    L12:
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
    }

    private boolean f() {
        if (this.f11330a != null) goto L29;
        return false;
    L29:
        int r10 = a.f11336a[this.f11332c.get().ordinal()];     // Catch: Throwable -> L26
        double r11 = 2000.0d;
        double r12 = 550.0d;
        if (r10 != 1) goto L8;
        r12 = 0.0d;
        r11 = 150.0d;
    L17:
        double r13 = this.f11330a.b();     // Catch: Throwable -> L26
        if (r13 <= r11) goto L24;
        if (r13 <= (r11 * 1.25d)) goto L28;
        return true;
    L28:
        return false;
    L24:
        if (r13 >= (r12 * 0.8d)) goto L28;
        return true;
    L8:
        if (r10 != 2) goto L10;
        r11 = 550.0d;
        r12 = 150.0d;
        goto L17
    L10:
        if (r10 == 3) goto L17;
        if (r10 == 4) goto L14;
        return true;
    L14:
        r11 = 3.4028234663852886E38d;
        r12 = 2000.0d;
    L26:
        th = move-exception;
        th.printStackTrace();
        goto L28
    }

    public synchronized void a(long r10, long r11) {
        monitor-enter(this);
        double r12 = ((r10 * 1.0d) / r11) * 8.0d;
        if (r11 != 0) goto L6;
    L25:
        monitor-exit(this);
        return;
    L6:
        if (r12 < 3.0d) goto L25;
        this.f11330a.a(r12);     // Catch: Throwable -> L27
        NetworkQuality r13 = b();     // Catch: Throwable -> L27
        if (this.f11331b == false) goto L21;
        this.f11335f++;     // Catch: Throwable -> L27
        if (r13 == this.f11333d.get()) goto L14;
        this.f11331b = false;     // Catch: Throwable -> L27
        this.f11335f = 1;     // Catch: Throwable -> L27
    L14:
        if (this.f11335f >= 5.0d) goto L16;
    L18:
        monitor-exit(this);
        return;
    L16:
        if (f() == false) goto L18;
        this.f11331b = false;     // Catch: Throwable -> L27
        this.f11335f = 1;     // Catch: Throwable -> L27
        this.f11332c.set(this.f11333d.get());     // Catch: Throwable -> L27
        e();     // Catch: Throwable -> L27
        goto L18
    L21:
        if (this.f11332c.get() == r13) goto L23;
        this.f11331b = true;     // Catch: Throwable -> L27
        this.f11333d = new AtomicReference(r13);     // Catch: Throwable -> L27
    L23:
        monitor-exit(this);
    }

    public synchronized NetworkQuality b() {
        monitor-enter(this);
        d r10 = this.f11330a;     // Catch: Throwable -> L15
        if (r10 != null) goto L18;
        NetworkQuality r11 = NetworkQuality.UNKNOWN;     // Catch: Throwable -> L15
        monitor-exit(this);
        return r11;
    L18:
        NetworkQuality r12 = d(r10.b());     // Catch: Throwable -> L11
        monitor-exit(this);
        return r12;
    L11:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L15
        return NetworkQuality.UNKNOWN;
    L15:
        th = move-exception;
        throw th;
    }
}
