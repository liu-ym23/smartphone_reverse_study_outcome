package n1;

import com.bytedance.crash.anr.AnrManager;
import com.bytedance.crash.resource.vmmonitor.VmMonitorConfig;
import java.lang.reflect.Array;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    protected static final long[][] f11168k = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f11169a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private g1.b f11170b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f11171c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f11172d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f11173e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f11174f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f11175g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long[][] f11176h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private h1.b f11177i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f11178j;

    static {
        f11168k = new long[][]{new long[]{VmMonitorConfig.SLEEP_TIME_BEFORE_RECOVER, 0, 12}, new long[]{AnrManager.ANR_MIN_INTERVAL, 5, 1}, new long[]{240000, 5, 1}, new long[]{480000, 4, 1}, new long[]{960000, 2, 1}};
    }

    public b(String r10, g1.b r11, h1.b r12) {
        this.f11178j = true;
        this.f11170b = r11;
        this.f11169a = r10;
        this.f11177i = r12;
        e();
    }

    private void a() {
        long r10 = System.currentTimeMillis();
        this.f11171c++;
        this.f11172d = 1;
        this.f11173e = 0;
        this.f11174f = r10;
        this.f11175g = r10;
        this.f11170b.z().edit().putLong(this.f11169a + "downgrade_time", r10).putInt(this.f11169a + "downgrade_index", this.f11171c).apply();
    }

    private boolean b() {
        if (this.f11178j == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f11170b.q().M() == false) goto L7;
        return true;
    }

    private void h() {
        long r10 = System.currentTimeMillis();
        this.f11171c--;
        this.f11172d = 1;
        this.f11173e = 1;
        this.f11174f = r10;
        this.f11175g = r10;
        this.f11170b.z().edit().putLong(this.f11169a + "downgrade_time", r10).putInt(this.f11169a + "downgrade_index", this.f11171c).apply();
    }

    public void c() {
        if (b() == true) goto L6;
        return;
    L6:
        if (this.f11171c >= (this.f11176h.length - 1)) goto L8;
        a();
        return;
    L8:
        this.f11173e = 0;
    }

    public void d() {
        if (b() == true) goto L5;
        return;
    L5:
        long r10 = System.currentTimeMillis();
        int r11 = this.f11173e;
        long r12 = r11;
        long[][] r13 = this.f11176h;
        int r14 = this.f11171c;
        if (r12 < r13[r14][1]) goto L8;
    L11:
        if (r14 <= 0) goto L15;
        h();
        return;
    L15:
        return;
    L8:
        if ((r10 - this.f11175g) > 1800000) goto L11;
        this.f11173e = r11 + 1;
    }

    protected void e() {
        this.f11171c = 0;
        if ((System.currentTimeMillis() - this.f11170b.z().getLong(this.f11169a + "downgrade_time", 0)) >= 10800000) goto L5;
        this.f11171c = this.f11170b.z().getInt(this.f11169a + "downgrade_index", 0);
    L6:
        long[][] r10 = f11168k;
        this.f11176h = (long[][]) Array.newInstance(long.class, new int[]{r10.length, r10[0].length});
        int r11 = 0;
    L7:
        long[][] r12 = f11168k;
        if (r11 >= r12.length) goto L10;
        System.arraycopy(r12[r11], 0, this.f11176h[r11], 0, r12[r11].length);
        r11 = r11 + 1;
        goto L7
    L10:
        h1.b r13 = this.f11177i;
        if (r13 == null) goto L28;
        int r14 = r13.f();
        if (r14 != 0) goto L16;
        this.f11176h[0][2] = 2147483647L;
    L18:
        long r15 = this.f11177i.c();
        if (r15 <= 0) goto L33;
        int r16 = 1;
    L21:
        long[][] r17 = this.f11176h;
        if (r16 >= r17.length) goto L34;
        if (r16 != 1) goto L26;
        r17[r16][0] = 2 * r15;
    L27:
        r16 = r16 + 1;
        goto L21
    L26:
        r17[r16][0] = r17[r16 - 1][0] * 2;
        goto L27
    L34:
        return;
    L33:
        return;
    L16:
        if ((-1) == r14) goto L18;
        this.f11176h[0][2] = 60;
        goto L18
    L28:
        return;
    L5:
        this.f11170b.z().edit().remove(this.f11169a + "downgrade_time").remove(this.f11169a + "downgrade_index").apply();
        goto L6
    }

    public boolean f() {
        if (b() == true) goto L5;
        return true;
    L5:
        long r10 = System.currentTimeMillis();
        long r11 = r10 - this.f11174f;
        long[][] r12 = this.f11176h;
        int r13 = this.f11171c;
        if (r11 < r12[r13][0]) goto L8;
        this.f11172d = 1;
        this.f11174f = r10;
    L11:
        return true;
    L8:
        int r14 = this.f11172d;
        if (r14 >= r12[r13][2]) goto L12;
        this.f11172d = r14 + 1;
        goto L11
    L12:
        return false;
    }

    public void g(int r10) {
        this.f11176h[0][2] = r10;
    }
}
