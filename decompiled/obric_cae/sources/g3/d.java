package g3;

import android.app.Activity;
import c2.k;

/* JADX INFO: loaded from: classes.dex */
public final class d implements u8.c {
    @Override // u8.c
    public final void a() {
    }

    @Override // u8.c
    public final void b() {
    }

    @Override // u8.c
    public final void c(Activity r8) {
    }

    @Override // u8.c
    public final void d(Activity r8) {
        float r10 = r8.getWindowManager().getDefaultDisplay().getRefreshRate();
        if (Math.abs(r10 - 60.0f) >= 5.1f) goto L6;
    L9:
        boolean r11 = k.f3297a;
        return;
    L6:
        if (Math.abs(r10 - 90.0f) < 5.1f) goto L9;
        Math.abs(r10 - 120.0f);
        goto L9
    }

    @Override // u8.c
    public final void e(Activity r8) {
    }

    @Override // u8.c
    public final void f() {
    }

    @Override // u8.c
    public final void g() {
    }
}
