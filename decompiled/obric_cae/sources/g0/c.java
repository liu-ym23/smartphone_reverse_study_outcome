package g0;

import android.os.Handler;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t2.b f7501a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f7502b;

    public c(a0.e.a r8, Handler r10) {
        this.f7501a = r8;
        this.f7502b = r10;
    }

    public final void a(k.a r8) {
        int r10 = r8.f7525b;
        if (r10 != 0) goto L5;
        boolean r11 = true;
    L6:
        Handler r12 = this.f7502b;
        t2.b r13 = this.f7501a;
        if (r11 == false) goto L9;
        r12.post(new a(r13, r8.f7524a));
        return;
    L9:
        r12.post(new b(r13, r10));
        return;
    L5:
        r11 = false;
        goto L6
    }
}
