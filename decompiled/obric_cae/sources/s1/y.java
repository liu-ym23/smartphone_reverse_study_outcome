package s1;

import android.annotation.SuppressLint;
import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public final class y implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t1.c<Void> f12011a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final r1.t f12012b;

    static {
        androidx.work.m.f("WorkForegroundRunnable");
    }

    @SuppressLint({"LambdaLast"})
    public y(Context r8, r1.t r10, androidx.work.l r11, androidx.work.i r12, u1.a r13) {
        this.f12011a = new t1.c();
        this.f12012b = r10;
    }

    @Override // java.lang.Runnable
    @SuppressLint({"UnsafeExperimentalUsageError"})
    public final void run() {
        boolean r8 = this.f12012b.f11355q;
        this.f12011a.j(null);
    }
}
