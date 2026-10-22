package com.lynx.animax;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class f implements hm.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9613a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ UIAnimaX f9614b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f9615c;

    public /* synthetic */ f(UIAnimaX r5, String r10, int r11) {
        this.f9613a = r11;
        this.f9614b = r5;
        this.f9615c = r10;
    }

    @Override // hm.a
    public final void a(AnimaXPlayer r5) {
        switch(this.f9613a) {
            case 0: goto L8;
            case 1: goto L6;
            default: goto L4;
        };
    L4:
        UIAnimaX r10 = this.f9614b;
        r10.getClass();
        String r11 = this.f9615c;
        r5.setSrc(r11);
        r10.i(r11);
        r10.c(r11);
        return;
    L6:
        UIAnimaX r12 = this.f9614b;
        r12.getClass();
        r5.setJson(this.f9615c);
        r12.i("json");
        r12.c("json");
        return;
    L8:
        UIAnimaX r13 = this.f9614b;
        r13.getClass();
        String r14 = this.f9615c;
        r5.setSrc(r14);
        r13.i(r14);
        r13.c(r14);
    }
}
