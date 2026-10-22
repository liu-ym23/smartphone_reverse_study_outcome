package com.loc;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class dw extends dv {
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;

    public dw() {
        this.j = 0;
        this.k = 0;
        this.l = 0;
    }

    public dw(boolean r1, boolean r2) {
        super(r1, r2);
        this.j = 0;
        this.k = 0;
        this.l = 0;
    }

    @Override // com.loc.dv
    public final dv a() {
        dw r0 = new dw(this.h, this.i);
        r0.a(this);
        r0.j = this.j;
        r0.k = this.k;
        r0.l = this.l;
        r0.m = this.m;
        r0.n = this.n;
        return r0;
    }

    @Override // com.loc.dv
    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        return a();
    }

    @Override // com.loc.dv
    public final String toString() {
        return "AmapCellCdma{sid=" + this.j + ", nid=" + this.k + ", bid=" + this.l + ", latitude=" + this.m + ", longitude=" + this.n + ", mcc='" + this.a + "', mnc='" + this.b + "', signalStrength=" + this.c + ", asuLevel=" + this.d + ", lastUpdateSystemMills=" + this.e + ", lastUpdateUtcMills=" + this.f + ", age=" + this.g + ", main=" + this.h + ", newApi=" + this.i + '}';
    }
}
