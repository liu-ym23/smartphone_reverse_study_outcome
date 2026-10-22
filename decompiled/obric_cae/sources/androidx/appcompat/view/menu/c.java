package androidx.appcompat.view.menu;

import android.view.MenuItem;

/* JADX INFO: loaded from: classes.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b.d f796a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MenuItem f797b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ f f798m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final /* synthetic */ b.c f799n;

    public c(b.c r8, b.d r10, h r11, f r12) {
        this.f799n = r8;
        this.f796a = r10;
        this.f797b = r11;
        this.f798m = r12;
    }

    @Override // java.lang.Runnable
    public final void run() {
        b.d r8 = this.f796a;
        if (r8 == null) goto L5;
        b.c r10 = this.f799n;
        r10.f792a.K = true;
        r8.f794b.d(false);
        r10.f792a.K = false;
    L5:
        MenuItem r11 = this.f797b;
        if (r11.isEnabled() == true) goto L8;
        return;
    L8:
        if (r11.hasSubMenu() == false) goto L12;
        this.f798m.s(r11, null, 4);
        return;
    }
}
