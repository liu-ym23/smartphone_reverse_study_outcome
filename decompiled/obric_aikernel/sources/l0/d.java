package l0;

import android.app.usage.NetworkStats;
import android.app.usage.NetworkStatsManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.WorkerThread;
import com.bytedance.apm6.util.log.Logger;
import kotlin.time.DurationKt;

/* JADX INFO: loaded from: classes.dex */
public class d implements l0.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f10773a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile long[] f10774b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile long[] f10775c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile long f10776d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile long f10777e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile long f10778f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private volatile long f10779g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private volatile long f10780h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private volatile long f10781i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private volatile long f10782j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private volatile long f10783k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private volatile long f10784l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private volatile boolean f10785m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private NetworkStatsManager f10786n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f10787o;

    class a implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ d f10788c;

        a(d r10) {
            this.f10788c = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.k(this.f10788c);
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f10789c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ d f10790g;

        b(d r10, boolean r11) {
            this.f10790g = r10;
            this.f10789c = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.l(this.f10790g);
            d.m(this.f10790g, !this.f10789c);
        }
    }

    public d() {
        this.f10773a = false;
        this.f10776d = 0;
        this.f10777e = 0;
        this.f10778f = 0;
        this.f10779g = 0;
        this.f10780h = 0;
        this.f10781i = 0;
        this.f10782j = 0;
        this.f10783k = 0;
        this.f10784l = -1;
        this.f10785m = true;
        this.f10787o = -1;
    }

    static /* synthetic */ void k(d r10) {
        r10.r();
    }

    static /* synthetic */ void l(d r10) {
        r10.s();
    }

    static /* synthetic */ boolean m(d r10, boolean r11) {
        r10.f10785m = r11;
        return r11;
    }

    private int n(@NonNull Context r10) {
        if (this.f10787o != (-1)) goto L12;
        PackageManager r11 = r10.getApplicationContext().getPackageManager();
        PackageInfo r12 = r11.getPackageInfo(r10.getApplicationContext().getPackageName(), 128);     // Catch: PackageManager.NameNotFoundException -> L9
        if (r12 == null) goto L12;
        this.f10787o = r12.applicationInfo.uid;     // Catch: PackageManager.NameNotFoundException -> L9
    L9:
        e = move-exception;
        e.printStackTrace();
    L12:
        return this.f10787o;
    }

    @RequiresApi(api = 23)
    private long[] p(long r17, long r19, int r21) {
        Context r10 = com.bytedance.apm.d.g();
        if (this.f10786n != null) goto L6;
        this.f10786n = (NetworkStatsManager) r10.getApplicationContext().getSystemService("netstats");
    L6:
        if (this.f10786n == null) goto L8;
        NetworkStats r11 = null;
        NetworkStats.Bucket r12 = new NetworkStats.Bucket();
        long r13 = 0;
        r11 = this.f10786n.querySummary(r21, null, r17, r19);     // Catch: Exception -> L12
    L14:
        long r14 = 0;
        long r15 = 0;
        long r16 = 0;
    L15:
        if (r11 == null) goto L21;
        if (r11.hasNextBucket() == false) goto L21;
        r11.getNextBucket(r12);
        if (n(r10) != r12.getUid()) goto L15;
        r13 = r13 + r12.getRxBytes();
        r14 = r14 + r12.getTxBytes();
        r15 = r15 + r12.getRxPackets();
        r16 = r16 + r12.getTxPackets();
    L21:
        if (r11 == null) goto L24;
        r11.close();
    L24:
        return new long[]{r13 + r14, r15 + r16};
    L12:
        e = move-exception;
        e.printStackTrace();
        goto L14
    L8:
        return new long[]{0, 0};
    }

    @RequiresApi(api = 23)
    @WorkerThread
    private void r() {
        if (this.f10773a == false) goto L5;
        return;
    L5:
        this.f10773a = true;
        this.f10774b = p(0, DurationKt.MAX_MILLIS, 1);
        this.f10775c = p(0, DurationKt.MAX_MILLIS, 0);
        this.f10784l = SystemClock.elapsedRealtime();
        if (com.bytedance.apm.d.D() == false) goto L9;
        Logger.d("NewTrafficStatisticsImp", "initTrafficData: mTotalWifiBytes:" + this.f10774b[0] + " mTotalWifiPackets:" + this.f10774b[1] + " mTotalMobileBytes:" + this.f10775c[0] + " mTotalMobilePackets:" + this.f10775c[1]);
        return;
    }

    @RequiresApi(api = 23)
    private void s() {
        long r10 = SystemClock.elapsedRealtime();
        if ((r10 - this.f10784l) >= 1000) goto L5;
        return;
    L5:
        if (this.f10784l == (-1)) goto L21;
        long[] r11 = p(0, DurationKt.MAX_MILLIS, 1);
        long[] r12 = p(0, DurationKt.MAX_MILLIS, 0);
        long r13 = r12[0] - this.f10775c[0];
        long r14 = r12[1] - this.f10775c[1];
        this.f10775c = r12;
        long r15 = r11[0] - this.f10774b[0];
        long r16 = r11[1] - this.f10774b[1];
        this.f10774b = r11;
        if (com.bytedance.apm.d.D() == false) goto L10;
        String r17 = "NewTrafficStatisticsImp";
        Logger.d(r17, "mTotalWifiBytes:" + this.f10774b[0] + " mTotalWifiPackets:" + this.f10774b[1] + " mTotalMobileBytes:" + this.f10775c[0] + " mTotalMobilePackets:" + this.f10775c[1]);
    L12:
        if (this.f10785m == false) goto L14;
        this.f10779g += r13;
        this.f10783k += r14;
        this.f10778f += r15;
        this.f10782j += r16;
    L16:
        if (com.bytedance.apm.d.D() == false) goto L18;
        Logger.d(r17, "periodWifiBytes" + r15 + " periodMobileBytes:" + r13 + " mMobileBackBytes:" + this.f10777e + " mWifiBackBytes:" + this.f10776d);
    L18:
        this.f10784l = r10;
        return;
    L14:
        this.f10777e += r13;
        this.f10781i += r14;
        this.f10776d += r15;
        this.f10780h += r16;
        goto L16
    L10:
        r17 = "NewTrafficStatisticsImp";
        goto L12
    }

    @Override // l0.b
    @RequiresApi(api = 23)
    public long a() {
        s();
        return this.f10777e + this.f10776d;
    }

    @Override // l0.b
    @RequiresApi(api = 23)
    public long b() {
        s();
        return this.f10777e;
    }

    @Override // l0.b
    @RequiresApi(api = 23)
    public long c() {
        return o() + q();
    }

    @Override // l0.b
    @RequiresApi(api = 23)
    public void d(boolean r10) {
        q0.b.f().d(new b(this, r10));
    }

    @Override // l0.b
    @RequiresApi(api = 23)
    public long e() {
        s();
        return this.f10781i + this.f10780h;
    }

    @Override // l0.b
    @RequiresApi(api = 23)
    public long f() {
        s();
        return this.f10778f;
    }

    @Override // l0.b
    @RequiresApi(api = 23)
    public long g() {
        s();
        return this.f10779g;
    }

    @Override // l0.b
    @RequiresApi(api = 23)
    public long h() {
        s();
        return this.f10779g + this.f10778f;
    }

    @Override // l0.b
    @RequiresApi(api = 23)
    public long i() {
        s();
        return this.f10776d;
    }

    @Override // l0.b
    @RequiresApi(api = 23)
    public void init() {
        if (q0.b.f().g() == false) goto L5;
        r();
        return;
    L5:
        q0.b.f().i(new a(this));
    }

    @Override // l0.b
    @RequiresApi(api = 23)
    public long j() {
        s();
        return this.f10783k + this.f10782j;
    }

    @RequiresApi(api = 23)
    public long o() {
        s();
        return this.f10777e + this.f10779g;
    }

    @RequiresApi(api = 23)
    public long q() {
        s();
        return this.f10776d + this.f10778f;
    }
}
