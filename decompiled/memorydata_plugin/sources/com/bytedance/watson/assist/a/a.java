package com.bytedance.watson.assist.a;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static a f3357a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f3358b;
    public boolean c;
    public boolean d;
    public boolean e;
    public boolean f;
    private int g;
    private int h;
    private C0169a i;

    /* JADX INFO: renamed from: com.bytedance.watson.assist.a.a$a, reason: collision with other inner class name */
    public static class C0169a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f3359a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f3360b;
        private float c;
        private float d;
        private float e;
        private float f;

        public C0169a() {
            this.f3359a = "unknown";
            this.f3360b = "default";
            this.c = 0.0f;
            this.d = 0.0f;
            this.e = 0.0f;
            this.f = 0.0f;
        }

        public float a() {
            return this.c;
        }

        public float b() {
            return this.f;
        }

        public String toString() {
            return "CpuAbnormalConfig{cpuHardWare='" + this.f3359a + "', scene='" + this.f3360b + "', cpuSpeed=" + this.c + ", smallCpuCoreTimePercent=" + this.d + ", middleCpuCoreTimePercent=" + this.e + ", BigCpuCoreTimePercent=" + this.f + '}';
        }
    }

    static {
        f3357a = new a();
    }

    public a() {
        this.f3358b = false;
        this.c = false;
        this.d = false;
        this.e = false;
        this.f = false;
        this.g = 37;
        this.h = 30;
        this.i = new C0169a();
    }

    public C0169a a() {
        return this.i;
    }

    public int b() {
        return this.g;
    }

    public int c() {
        return this.h;
    }

    public boolean d() {
        return this.f3358b;
    }

    public boolean e() {
        return this.c;
    }

    public boolean f() {
        return this.d;
    }

    public boolean g() {
        return this.e;
    }

    public boolean h() {
        return this.f;
    }

    public String toString() {
        return "AssistConfig{enableProcessCpuUsageStat=" + this.f3358b + ", enableThreadCpuUsageStat=" + this.c + ", enableSystemCpuUsageStat=" + this.d + ", enableProcessTimeFreqPercent=" + this.e + ", enableSystemCpuTimeFreqPercent=" + this.f + ", cpuSampleBatteryTemp=" + this.g + ", cpuSampleBatteryLevel=" + this.h + ", cpuAbnormalConfig=" + this.i + '}';
    }
}
