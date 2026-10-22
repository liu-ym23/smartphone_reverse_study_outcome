package g5;

import com.bytedance.apm6.consumer.slardar.send.downgrade.DowngradeInfo;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static a f8961i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f8962a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f8963b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f8964c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f8965d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f8966e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f8967f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f8968g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private C0173a f8969h;

    /* JADX INFO: renamed from: g5.a$a, reason: collision with other inner class name */
    public static class C0173a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f8970a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f8971b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private float f8972c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private float f8973d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private float f8974e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private float f8975f;

        public C0173a() {
            this.f8970a = "unknown";
            this.f8971b = DowngradeInfo.SubInfo.FIELD_DEFAULT_RATE;
            this.f8972c = 0.0f;
            this.f8973d = 0.0f;
            this.f8974e = 0.0f;
            this.f8975f = 0.0f;
        }

        public float a() {
            return this.f8975f;
        }

        public float b() {
            return this.f8972c;
        }

        public String toString() {
            return "CpuAbnormalConfig{cpuHardWare='" + this.f8970a + "', scene='" + this.f8971b + "', cpuSpeed=" + this.f8972c + ", smallCpuCoreTimePercent=" + this.f8973d + ", middleCpuCoreTimePercent=" + this.f8974e + ", BigCpuCoreTimePercent=" + this.f8975f + '}';
        }
    }

    static {
        f8961i = new a();
    }

    public a() {
        this.f8962a = false;
        this.f8963b = false;
        this.f8964c = false;
        this.f8965d = false;
        this.f8966e = false;
        this.f8967f = 37;
        this.f8968g = 30;
        this.f8969h = new C0173a();
    }

    public C0173a a() {
        return this.f8969h;
    }

    public int b() {
        return this.f8968g;
    }

    public int c() {
        return this.f8967f;
    }

    public boolean d() {
        return this.f8962a;
    }

    public boolean e() {
        return this.f8965d;
    }

    public boolean f() {
        return this.f8966e;
    }

    public boolean g() {
        return this.f8964c;
    }

    public boolean h() {
        return this.f8963b;
    }

    public String toString() {
        return "AssistConfig{enableProcessCpuUsageStat=" + this.f8962a + ", enableThreadCpuUsageStat=" + this.f8963b + ", enableSystemCpuUsageStat=" + this.f8964c + ", enableProcessTimeFreqPercent=" + this.f8965d + ", enableSystemCpuTimeFreqPercent=" + this.f8966e + ", cpuSampleBatteryTemp=" + this.f8967f + ", cpuSampleBatteryLevel=" + this.f8968g + ", cpuAbnormalConfig=" + this.f8969h + '}';
    }
}
