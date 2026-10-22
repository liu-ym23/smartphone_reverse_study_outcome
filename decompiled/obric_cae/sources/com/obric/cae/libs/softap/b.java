package com.obric.cae.libs.softap;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5473a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CaeSoftApManager f5474b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ String f5475m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final /* synthetic */ ICaeSoftApManager f5476n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final /* synthetic */ CaeSoftApManager.e f5477o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final /* synthetic */ Object f5478p;

    public /* synthetic */ b(CaeSoftApManager r8, String r10, ICaeSoftApManager r11, CaeSoftApManager.e r12, Object r13, int r14) {
        this.f5473a = r14;
        this.f5474b = r8;
        this.f5475m = r10;
        this.f5476n = r11;
        this.f5477o = r12;
        this.f5478p = r13;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r8 = this.f5473a;
        CaeSoftApManager.e r10 = this.f5477o;
        ICaeSoftApManager r11 = this.f5476n;
        String r12 = this.f5475m;
        CaeSoftApManager r13 = this.f5474b;
        Object r14 = this.f5478p;
        switch(r8) {
            case 0: goto L5;
            default: goto L7;
        };
    L5:
        CaeSoftApManager.l(r13, r12, r11, r10, (CaeSoftApStatusResultCallback) r14);
        return;
    L7:
        CaeSoftApManager.j(r13, r12, r11, r10, (CaeSoftApRequestCallback) r14);
    }
}
