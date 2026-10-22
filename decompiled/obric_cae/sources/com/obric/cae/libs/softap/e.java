package com.obric.cae.libs.softap;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class e implements CaeSoftApManager.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5485a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CaeSoftApManager f5486b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ CaeSoftApRequestCallback f5487c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f5488d;

    public /* synthetic */ e(CaeSoftApManager r8, CaeSoftApRequestCallback r10, String r11, int r12) {
        this.f5485a = r12;
        this.f5486b = r8;
        this.f5487c = r10;
        this.f5488d = r11;
    }

    @Override // com.obric.cae.libs.softap.CaeSoftApManager.b
    public final void a(int r8) {
        int r10 = this.f5485a;
        CaeSoftApManager r11 = this.f5486b;
        String r12 = this.f5488d;
        CaeSoftApRequestCallback r13 = this.f5487c;
        switch(r10) {
            case 0: goto L5;
            default: goto L7;
        };
    L5:
        CaeSoftApManager.n(r11, r13, r12, r8);
        return;
    L7:
        CaeSoftApManager.q(r11, r13, r12, r8);
    }
}
