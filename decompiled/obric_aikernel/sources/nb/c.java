package nb;

import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.ss.android.socialbase.downloader.utils.LruCache;
import java.net.InetAddress;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile c f11310e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LruCache<String, d> f11311a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Handler f11312b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Handler f11313c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Looper f11314d;

    class a implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f11315c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ InterfaceC0251c f11316g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ long f11317h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ c f11318i;

        a(c r10, String r11, InterfaceC0251c r12, long r13) {
            this.f11318i = r10;
            this.f11315c = r11;
            this.f11316g = r12;
            this.f11317h = r13;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.a(this.f11318i, this.f11315c, this.f11316g, this.f11317h);
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ InterfaceC0251c f11319c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f11320g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ d f11321h;

        b(c r10, InterfaceC0251c r11, String r12, d r13) {
            this.f11319c = r11;
            this.f11320g = r12;
            this.f11321h = r13;
        }

        @Override // java.lang.Runnable
        public void run() {
            InterfaceC0251c r10 = this.f11319c;
            if (r10 == null) goto L10;
            String r11 = this.f11320g;
            d r12 = this.f11321h;
            if (r12 != null) goto L7;
            List<InetAddress> r13 = null;
        L8:
            r10.e(r11, r13);
            return;
        L7:
            r13 = r12.f11322a;
            goto L8
        }
    }

    /* JADX INFO: renamed from: nb.c$c, reason: collision with other inner class name */
    public interface InterfaceC0251c {
        void e(String r10, List<InetAddress> r11);
    }

    private static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        List<InetAddress> f11322a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f11323b;

        private d() {
        }

        /* synthetic */ d(a r10) {
            this();
        }
    }

    private c() {
        this.f11311a = new LruCache(4, 16, false);
        HandlerThread r10 = new HandlerThread("Network-Handler");
        r10.start();
        Looper r11 = r10.getLooper();
        this.f11314d = r11;
        this.f11312b = new Handler(r11);
        this.f11313c = new Handler(sb.c.b());
    }

    static /* synthetic */ void a(c r10, String r11, InterfaceC0251c r12, long r13) {
        r10.c(r11, r12, r13);
    }

    public static c b() {
        if (f11310e != null) goto L15;
        monitor-enter(c.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f11310e != null) goto L9;
        f11310e = new c();     // Catch: Throwable -> L11
    L9:
        monitor-exit(c.class);     // Catch: Throwable -> L11
    L15:
        return f11310e;
    }

    private void c(String r10, InterfaceC0251c r11, long r12) {
        String r13 = Uri.parse(r10).getHost();     // Catch: Throwable -> L42
        LruCache<String, d> r14 = this.f11311a;     // Catch: Throwable -> L42
        monitor-enter(r14);     // Catch: Throwable -> L42
        d r15 = this.f11311a.get(r13);     // Catch: Throwable -> L39
        monitor-exit(r14);     // Catch: Throwable -> L39
        if (r15 != null) goto L8;
    L12:
        b r16 = new b(this, r11, r10, r15);     // Catch: Throwable -> L42
        this.f11313c.postDelayed(r16, r12);     // Catch: Throwable -> L42
        List<InetAddress> r17 = null;
        if (rb.a.j().o("use_host_dns", 1) != 1) goto L20;
        f r18 = com.ss.android.socialbase.downloader.downloader.a.r();     // Catch: Throwable -> L42
        if (r18 == null) goto L20;
        r17 = r18.a(r13);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L42
    L20:
        if (r17 == null) goto L45;
        if (r17.isEmpty() == true) goto L45;
    L28:
        if (r17 != null) goto L30;
    L33:
        if (r15 == null) goto L35;
        r17 = r15.f11322a;     // Catch: Throwable -> L42
    L35:
        this.f11313c.removeCallbacks(r16);     // Catch: Throwable -> L42
        if (r11 == null) goto L53;
        r11.e(r10, r17);     // Catch: Throwable -> L42
        return;
    L53:
        return;
    L30:
        if (r17.isEmpty() == true) goto L33;
        e(r13, r17);     // Catch: Throwable -> L42
    L45:
        r17 = com.ss.android.socialbase.downloader.downloader.a.m().a(r13);     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L42
        goto L28
    L8:
        if ((System.currentTimeMillis() - r15.f11323b) >= ((rb.a.j().o("dns_expire_min", 10) * 60) * 1000)) goto L12;
        if (r11 == null) goto L52;
        r11.e(r10, r15.f11322a);     // Catch: Throwable -> L42
        return;
    L52:
        return;
    L39:
        th = move-exception;
        throw th;     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        th.printStackTrace();
    }

    private void e(String r10, List<InetAddress> r11) {
        LruCache<String, d> r12 = this.f11311a;
        monitor-enter(r12);
        d r13 = this.f11311a.get(r10);     // Catch: Throwable -> L10
        if (r13 != null) goto L7;
        r13 = new d(null);     // Catch: Throwable -> L10
        this.f11311a.put(r10, r13);     // Catch: Throwable -> L10
    L7:
        r13.f11322a = r11;     // Catch: Throwable -> L10
        r13.f11323b = System.currentTimeMillis();     // Catch: Throwable -> L10
        monitor-exit(r12);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public void d(String r10, InterfaceC0251c r11, long r12) {
        this.f11312b.post(new a(this, r10, r11, r12));
    }
}
