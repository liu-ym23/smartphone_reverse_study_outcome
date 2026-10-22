package g5;

/* JADX INFO: loaded from: classes.dex */
public final class l implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f7666a;

    public l(k r8) {
        this.f7666a = r8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        k r8 = this.f7666a;
        if (k5.a.a(r8.f7658d, r8.f7664j).getBoolean("_install_started_v2", false) == false) goto L13;
        n r10 = r8.f7662h;
        if (r10 == null) goto L7;
        String r11 = r10.f7669a;
    L8:
        z4.c r12 = r8.f7663i;
        if (r12 == null) goto L11;
        r12.a(new androidx.lifecycle.s(new androidx.core.app.p(r11, r8.f7657c)));
    L11:
        r8.f7660f = null;
        return;
    L7:
        r11 = null;
        goto L8
    }
}
