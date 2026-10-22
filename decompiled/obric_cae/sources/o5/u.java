package o5;

import com.obric.cae.userAware.UserAwareService;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class u implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9719a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f9720b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Object f9721m;

    public /* synthetic */ u(Object r8, int r10, boolean r11) {
        this.f9719a = r10;
        this.f9721m = r8;
        this.f9720b = r11;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r8 = this.f9719a;
        boolean r10 = this.f9720b;
        Object r11 = this.f9721m;
        switch(r8) {
            case 0: goto L5;
            default: goto L7;
        };
    L5:
        w.a(((v) r11).f9722a, r10);
        return;
    L7:
        UserAwareService.b((UserAwareService) r11, r10);
    }
}
