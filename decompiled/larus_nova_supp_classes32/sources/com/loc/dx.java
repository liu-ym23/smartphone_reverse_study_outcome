package com.loc;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class dx extends dv {
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;

    public dx() {
        this.j = 0;
        this.k = 0;
        this.l = Integer.MAX_VALUE;
        this.m = Integer.MAX_VALUE;
        this.n = Integer.MAX_VALUE;
        this.o = Integer.MAX_VALUE;
    }

    public dx(boolean r1, boolean r2) {
        super(r1, r2);
        this.j = 0;
        this.k = 0;
        this.l = Integer.MAX_VALUE;
        this.m = Integer.MAX_VALUE;
        this.n = Integer.MAX_VALUE;
        this.o = Integer.MAX_VALUE;
    }

    @Override // com.loc.dv
    public final dv a() {
        dx r0 = new dx(this.h, this.i);
        r0.a(this);
        r0.j = this.j;
        r0.k = this.k;
        r0.l = this.l;
        r0.m = this.m;
        r0.n = this.n;
        r0.o = this.o;
        return r0;
    }

    @Override // com.loc.dv
    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        return a();
    }

    @Override // com.loc.dv
    public final String toString() {
        return "AmapCellGsm{lac=" + this.j + ", cid=" + this.k + ", psc=" + this.l + ", arfcn=" + this.m + ", bsic=" + this.n + ", timingAdvance=" + this.o + ", mcc='" + this.a + "', mnc='" + this.b + "', signalStrength=" + this.c + ", asuLevel=" + this.d + ", lastUpdateSystemMills=" + this.e + ", lastUpdateUtcMills=" + this.f + ", age=" + this.g + ", main=" + this.h + ", newApi=" + this.i + '}';
    }
}
