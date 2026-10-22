package gb;

import he.j;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends j implements ge.a<Double> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ double f7794a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ double f7795b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ double f7796m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final /* synthetic */ double f7797n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final /* synthetic */ double f7798o;

    public c(double r8, double r10, double r11, double r12, double r13) {
        this.f7794a = r8;
        this.f7795b = r10;
        this.f7796m = r11;
        this.f7797n = r12;
        this.f7798o = r13;
        super(0);
    }

    @Override // ge.a
    public final Double f() {
        double r8 = this.f7795b;
        double r10 = this.f7796m;
        double r11 = Math.exp(r8 * r10) * this.f7794a;
        return Double.valueOf((Math.exp(this.f7798o * r10) * this.f7797n) + r11);
    }
}
