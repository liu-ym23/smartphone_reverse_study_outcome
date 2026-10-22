package c7;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f3397a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ g f3398b;

    public f(g r8, Context r10) {
        this.f3398b = r8;
        this.f3397a = r10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        g r8 = this.f3398b;
        r8.f3400b = new a(new e(this.f3397a));
    }
}
