package qa;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public abstract class f2 implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f10402a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f10403b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f10404m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f10405n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f10406o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f10407p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f10408q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f10409r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f10410s;

    public f2() {
        this.f10402a = "";
        this.f10403b = "";
        this.f10404m = 99;
        this.f10405n = Integer.MAX_VALUE;
        this.f10406o = 0;
        this.f10407p = 0;
        this.f10408q = 0;
        this.f10410s = true;
    }

    public abstract f2 a();

    public final void b(f2 r8) {
        this.f10402a = r8.f10402a;
        this.f10403b = r8.f10403b;
        this.f10404m = r8.f10404m;
        this.f10405n = r8.f10405n;
        this.f10406o = r8.f10406o;
        this.f10407p = r8.f10407p;
        this.f10408q = r8.f10408q;
        this.f10409r = r8.f10409r;
        this.f10410s = r8.f10410s;
    }

    public /* synthetic */ Object clone() {
        return a();
    }

    public String toString() {
        return "AmapCell{mcc=" + this.f10402a + ", mnc=" + this.f10403b + ", signalStrength=" + this.f10404m + ", asulevel=" + this.f10405n + ", lastUpdateSystemMills=" + this.f10406o + ", lastUpdateUtcMills=" + this.f10407p + ", age=" + this.f10408q + ", main=" + this.f10409r + ", newapi=" + this.f10410s + '}';
    }

    public f2(boolean r8, boolean r10) {
        this.f10402a = "";
        this.f10403b = "";
        this.f10404m = 99;
        this.f10405n = Integer.MAX_VALUE;
        this.f10406o = 0;
        this.f10407p = 0;
        this.f10408q = 0;
        this.f10409r = r8;
        this.f10410s = r10;
    }
}
