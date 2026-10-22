package com.obric.cae.location.cell;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5624a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f5625b;

    public /* synthetic */ f(Object r8, int r10) {
        this.f5624a = r10;
        this.f5625b = r8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r8 = this.f5624a;
        Object r10 = this.f5625b;
        switch(r8) {
            case 0: goto L5;
            default: goto L7;
        };
    L5:
        WwanSensorService.b((WwanSensorService) r10);
        return;
    L7:
        CellPoiService.b((CellPoiService) r10);
    }
}
