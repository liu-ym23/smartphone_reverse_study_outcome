package qa;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class t2 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ u2 f11113a;

    public t2(u2 r8) {
        this.f11113a = r8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        u2 r8 = this.f11113a;     // Catch: Throwable -> L12
        if (r8.f11142f == null) goto L17;
        g3 r10 = r8.f11140d;     // Catch: Throwable -> L12
        if (r10 == null) goto L18;
        boolean r11 = r10.f10469o;     // Catch: Throwable -> L12
        ArrayList<n2> r12 = r10.f10457c;     // Catch: Throwable -> L12
        if (r11 == false) goto L10;
        r10.d(true);     // Catch: Throwable -> L12
    L10:
        e2.e(r12);     // Catch: Throwable -> L12
        return;
    L18:
        return;
    L17:
        return;
    L12:
        th = move-exception;
        t3.g("cl", "upwr", th);
    }
}
