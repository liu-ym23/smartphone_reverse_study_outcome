package qa;

/* JADX INFO: loaded from: classes.dex */
public final class h2 extends f2 {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f10498t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f10499u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f10500v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f10501w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f10502x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f10503y;

    public h2() {
        this.f10498t = 0;
        this.f10499u = 0;
        this.f10500v = Integer.MAX_VALUE;
        this.f10501w = Integer.MAX_VALUE;
        this.f10502x = Integer.MAX_VALUE;
        this.f10503y = Integer.MAX_VALUE;
    }

    @Override // qa.f2
    public final f2 a() {
        h2 r8 = new h2(this.f10409r, this.f10410s);
        r8.b(this);
        r8.f10498t = this.f10498t;
        r8.f10499u = this.f10499u;
        r8.f10500v = this.f10500v;
        r8.f10501w = this.f10501w;
        r8.f10502x = this.f10502x;
        r8.f10503y = this.f10503y;
        return r8;
    }

    @Override // qa.f2
    public final /* synthetic */ Object clone() {
        return a();
    }

    @Override // qa.f2
    public final String toString() {
        return "AmapCellGsm{lac=" + this.f10498t + ", cid=" + this.f10499u + ", psc=" + this.f10500v + ", arfcn=" + this.f10501w + ", bsic=" + this.f10502x + ", timingAdvance=" + this.f10503y + ", mcc='" + this.f10402a + "', mnc='" + this.f10403b + "', signalStrength=" + this.f10404m + ", asuLevel=" + this.f10405n + ", lastUpdateSystemMills=" + this.f10406o + ", lastUpdateUtcMills=" + this.f10407p + ", age=" + this.f10408q + ", main=" + this.f10409r + ", newApi=" + this.f10410s + '}';
    }

    public h2(boolean r8, boolean r10) {
        super(r8, r10);
        this.f10498t = 0;
        this.f10499u = 0;
        this.f10500v = Integer.MAX_VALUE;
        this.f10501w = Integer.MAX_VALUE;
        this.f10502x = Integer.MAX_VALUE;
        this.f10503y = Integer.MAX_VALUE;
    }
}
