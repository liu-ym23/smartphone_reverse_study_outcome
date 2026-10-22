package g0;

import android.graphics.Typeface;

/* JADX INFO: loaded from: classes.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ t2.b f7497a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Typeface f7498b;

    public a(t2.b r8, Typeface r10) {
        this.f7497a = r8;
        this.f7498b = r10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        z.f.e r8 = ((a0.e.a) this.f7497a).H;
        if (r8 == null) goto L6;
        r8.d(this.f7498b);
        return;
    }
}
