package zr9;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class g {
    public static final g d = null;
    public int a;
    public boolean b;
    public boolean c;

    static {
        d = new g();
    }

    public final String toString() {
        return "ThermalStatusConfig{statusSource=" + this.a + ", enableStatusSourceBattery=" + this.b + ", enableStatusSourceAosp=" + this.c + ", enableStatusSourceOem=false, NO_CHANGE_NOTIFY_DELTA_TIME=300000}";
    }

    public g() {
        this.a = 0;
        this.b = true;
        this.c = true;
    }
}
