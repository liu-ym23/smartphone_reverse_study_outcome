package com.obric.cae.libs.softap;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements CaeSoftApManager.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5469a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CaeSoftApManager f5470b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ CaeSoftApStatusResultCallback f5471c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f5472d;

    public /* synthetic */ a(CaeSoftApManager r8, CaeSoftApStatusResultCallback r10, String r11, int r12) {
        this.f5469a = r12;
        this.f5470b = r8;
        this.f5471c = r10;
        this.f5472d = r11;
    }

    @Override // com.obric.cae.libs.softap.CaeSoftApManager.b
    public final void a(int r8) {
        int r10 = this.f5469a;
        CaeSoftApManager r11 = this.f5470b;
        String r12 = this.f5472d;
        CaeSoftApStatusResultCallback r13 = this.f5471c;
        switch(r10) {
            case 0: goto L5;
            default: goto L7;
        };
    L5:
        CaeSoftApManager.o(r11, r13, r12, r8);
        return;
    L7:
        CaeSoftApManager.c(r11, r13, r12, r8);
    }
}
