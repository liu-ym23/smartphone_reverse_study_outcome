package zr9;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class f {
    public int a;
    public int b;
    public int c;
    public float d;

    public final String toString() {
        return "ThermalStatus{status=" + this.a + ", batteryStatus=" + this.b + ", oemStatus=-1, aospStatus=" + this.c + ", batteryTemp=" + this.d + ", borderTemp=-99.0}";
    }

    public f() {
        this.a = -1;
        this.b = -1;
        this.c = -1;
        this.d = -99.0f;
    }
}
