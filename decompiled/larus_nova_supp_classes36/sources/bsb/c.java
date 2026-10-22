package bsb;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c {
    public int a;
    public boolean b;
    public int c;
    public boolean d;
    public int e;
    public boolean f;
    public int g;
    public volatile boolean h;
    public int i;
    public float j;
    public final int k;
    public int l;

    public final String toString() {
        return "DevicePerfInfo{downgradeLevel=" + this.a + ", isOverTemperature=" + this.b + ", overTemperatureLevel=" + this.c + ", isOverCpu=" + this.d + ", overCpuLevel=" + this.e + ", isOverMemory=" + this.f + ", overMemoryLevel=" + this.g + ", isLowDevice=" + this.h + ", lowDeviceLevel=" + this.i + ", curTemperature=" + this.j + ", totalJavaMemoryMB=" + this.k + ", last10SecondsCpuUsage=" + this.l + '}';
    }

    public c() {
        this.k = (int) (Runtime.getRuntime().maxMemory() / 1048576);
        this.l = 0;
    }
}
