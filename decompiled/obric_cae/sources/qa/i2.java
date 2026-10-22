package qa;

/* JADX INFO: loaded from: classes.dex */
public final class i2 extends f2 {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f10520t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f10521u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f10522v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f10523w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f10524x;

    public i2() {
        this.f10520t = 0;
        this.f10521u = 0;
        this.f10522v = Integer.MAX_VALUE;
        this.f10523w = Integer.MAX_VALUE;
        this.f10524x = Integer.MAX_VALUE;
    }

    @Override // qa.f2
    public final f2 a() {
        i2 r8 = new i2(this.f10409r);
        r8.b(this);
        r8.f10520t = this.f10520t;
        r8.f10521u = this.f10521u;
        r8.f10522v = this.f10522v;
        r8.f10523w = this.f10523w;
        r8.f10524x = this.f10524x;
        return r8;
    }

    @Override // qa.f2
    public final /* synthetic */ Object clone() {
        return a();
    }

    @Override // qa.f2
    public final String toString() {
        return "AmapCellLte{tac=" + this.f10520t + ", ci=" + this.f10521u + ", pci=" + this.f10522v + ", earfcn=" + this.f10523w + ", timingAdvance=" + this.f10524x + ", mcc='" + this.f10402a + "', mnc='" + this.f10403b + "', signalStrength=" + this.f10404m + ", asuLevel=" + this.f10405n + ", lastUpdateSystemMills=" + this.f10406o + ", lastUpdateUtcMills=" + this.f10407p + ", age=" + this.f10408q + ", main=" + this.f10409r + ", newApi=" + this.f10410s + '}';
    }

    public i2(boolean r8) {
        super(r8, true);
        this.f10520t = 0;
        this.f10521u = 0;
        this.f10522v = Integer.MAX_VALUE;
        this.f10523w = Integer.MAX_VALUE;
        this.f10524x = Integer.MAX_VALUE;
    }
}
