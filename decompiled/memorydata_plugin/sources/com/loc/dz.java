package com.loc;

import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
public final class dz extends dv implements Serializable {
    public int j;
    public int k;
    public int l;
    public int m;

    public dz() {
        this.j = 0;
        this.k = 0;
        this.l = Integer.MAX_VALUE;
        this.m = Integer.MAX_VALUE;
    }

    public dz(boolean r1, boolean r2) {
        super(r1, r2);
        this.j = 0;
        this.k = 0;
        this.l = Integer.MAX_VALUE;
        this.m = Integer.MAX_VALUE;
    }

    @Override // com.loc.dv
    public final dv a() {
        dz r0 = new dz(this.h, this.i);
        r0.a(this);
        r0.j = this.j;
        r0.k = this.k;
        r0.l = this.l;
        r0.m = this.m;
        return r0;
    }

    @Override // com.loc.dv
    public final /* synthetic */ Object clone() {
        return a();
    }

    @Override // com.loc.dv
    public final String toString() {
        return "AmapCellWcdma{lac=" + this.j + ", cid=" + this.k + ", psc=" + this.l + ", uarfcn=" + this.m + ", mcc='" + this.f5472a + "', mnc='" + this.f5473b + "', signalStrength=" + this.c + ", asuLevel=" + this.d + ", lastUpdateSystemMills=" + this.e + ", lastUpdateUtcMills=" + this.f + ", age=" + this.g + ", main=" + this.h + ", newApi=" + this.i + '}';
    }
}
