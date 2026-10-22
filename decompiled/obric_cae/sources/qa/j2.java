package qa;

/* JADX INFO: loaded from: classes.dex */
public final class j2 extends f2 {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f10624t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f10625u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f10626v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f10627w;

    public j2() {
        this.f10624t = 0;
        this.f10625u = 0;
        this.f10626v = Integer.MAX_VALUE;
        this.f10627w = Integer.MAX_VALUE;
    }

    @Override // qa.f2
    public final f2 a() {
        j2 r8 = new j2(this.f10409r, this.f10410s);
        r8.b(this);
        r8.f10624t = this.f10624t;
        r8.f10625u = this.f10625u;
        r8.f10626v = this.f10626v;
        r8.f10627w = this.f10627w;
        return r8;
    }

    @Override // qa.f2
    public final /* synthetic */ Object clone() {
        return a();
    }

    @Override // qa.f2
    public final String toString() {
        return "AmapCellWcdma{lac=" + this.f10624t + ", cid=" + this.f10625u + ", psc=" + this.f10626v + ", uarfcn=" + this.f10627w + ", mcc='" + this.f10402a + "', mnc='" + this.f10403b + "', signalStrength=" + this.f10404m + ", asuLevel=" + this.f10405n + ", lastUpdateSystemMills=" + this.f10406o + ", lastUpdateUtcMills=" + this.f10407p + ", age=" + this.f10408q + ", main=" + this.f10409r + ", newApi=" + this.f10410s + '}';
    }

    public j2(boolean r8, boolean r10) {
        super(r8, r10);
        this.f10624t = 0;
        this.f10625u = 0;
        this.f10626v = Integer.MAX_VALUE;
        this.f10627w = Integer.MAX_VALUE;
    }
}
