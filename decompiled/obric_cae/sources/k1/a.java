package k1;

import androidx.work.m;
import r1.t;

/* JADX INFO: loaded from: classes.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ t f8909a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b f8910b;

    public a(b r8, t r10) {
        this.f8910b = r8;
        this.f8909a = r10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        m r8 = m.d();
        String r10 = b.f8911d;
        StringBuilder r11 = new StringBuilder("Scheduling work ");
        t r12 = this.f8909a;
        r11.append(r12.f11339a);
        r8.a(r10, r11.toString());
        this.f8910b.f8912a.a(new t[]{r12});
    }
}
