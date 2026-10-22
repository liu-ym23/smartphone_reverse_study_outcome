package j1;

import android.annotation.SuppressLint;
import android.util.Log;
import java.util.concurrent.CancellationException;

/* JADX INFO: loaded from: classes.dex */
public final class h0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f8483a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ i0 f8484b;

    public h0(i0 r8, String r10) {
        this.f8484b = r8;
        this.f8483a = r10;
    }

    @Override // java.lang.Runnable
    @SuppressLint({"SyntheticAccessor"})
    public final void run() {
        String r8 = this.f8483a;
        i0 r10 = this.f8484b;
        androidx.work.l.a r11 = r10.A.get();     // Catch: Throwable -> L8 Throwable -> L10 CancellationException -> L12
        if (r11 != null) goto L6;
        androidx.work.m.d().b(i0.C, r10.f8490o.f11341c + " returned a null result. Treating it as a failure.");     // Catch: Throwable -> L8 Throwable -> L10 CancellationException -> L12
    L22:
    L24:
    L16:
        r10.d();
        return;
    L6:
        androidx.work.m.d().a(i0.C, r10.f8490o.f11341c + " returned a " + r11 + ".");     // Catch: Throwable -> L8 Throwable -> L10 CancellationException -> L12
        r10.f8493r = r11;     // Catch: Throwable -> L8 Throwable -> L10 CancellationException -> L12
    L8:
        th = move-exception;
        r10.d();
        throw th;
    L12:
        e = move-exception;
        androidx.work.m r12 = androidx.work.m.d();     // Catch: Throwable -> L8
        String r13 = i0.C;     // Catch: Throwable -> L8
        String r14 = r8 + " was cancelled";     // Catch: Throwable -> L8
        if (((androidx.work.m.a) r12).f2930c > 4) goto L16;
        Log.i(r13, r14, e);     // Catch: Throwable -> L8
    L10:
        e = move-exception;
        androidx.work.m.d().c(i0.C, r8 + " failed because it threw an exception/error", e);     // Catch: Throwable -> L8
        goto L16
    }
}
