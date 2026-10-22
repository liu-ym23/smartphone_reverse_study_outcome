package qa;

/* JADX INFO: loaded from: classes.dex */
public final class g2 extends f2 {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f10446t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f10447u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f10448v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f10449w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f10450x;

    public g2() {
        this.f10446t = 0;
        this.f10447u = 0;
        this.f10448v = 0;
    }

    @Override // qa.f2
    public final f2 a() {
        g2 r8 = new g2(this.f10409r, this.f10410s);
        r8.b(this);
        r8.f10446t = this.f10446t;
        r8.f10447u = this.f10447u;
        r8.f10448v = this.f10448v;
        r8.f10449w = this.f10449w;
        r8.f10450x = this.f10450x;
        return r8;
    }

    @Override // qa.f2
    public final /* synthetic */ Object clone() {
        return a();
    }

    @Override // qa.f2
    public final String toString() {
        return "AmapCellCdma{sid=" + this.f10446t + ", nid=" + this.f10447u + ", bid=" + this.f10448v + ", latitude=" + this.f10449w + ", longitude=" + this.f10450x + ", mcc='" + this.f10402a + "', mnc='" + this.f10403b + "', signalStrength=" + this.f10404m + ", asuLevel=" + this.f10405n + ", lastUpdateSystemMills=" + this.f10406o + ", lastUpdateUtcMills=" + this.f10407p + ", age=" + this.f10408q + ", main=" + this.f10409r + ", newApi=" + this.f10410s + '}';
    }

    public g2(boolean r8, boolean r10) {
        super(r8, r10);
        this.f10446t = 0;
        this.f10447u = 0;
        this.f10448v = 0;
    }
}
