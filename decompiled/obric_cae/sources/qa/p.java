package qa;

import android.os.Looper;
import java.util.Vector;

/* JADX INFO: loaded from: classes.dex */
public final class p extends m1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ s4 f10881b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ boolean f10882m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final /* synthetic */ q f10883n;

    public p(q r8, s4 r10, boolean r11) {
        this.f10883n = r8;
        this.f10881b = r10;
        this.f10882m = r11;
    }

    @Override // qa.m1
    public final void a() {
        Looper r8 = Looper.getMainLooper();     // Catch: Throwable -> L25
        monitor-enter(r8);     // Catch: Throwable -> L25
        s4 r10 = this.f10881b;     // Catch: Throwable -> L22
        Vector<s4> r11 = n.f10841b;     // Catch: Throwable -> L22
        Looper r12 = Looper.getMainLooper();     // Catch: Throwable -> L28
        monitor-enter(r12);     // Catch: Throwable -> L28
        if (r10 != null) goto L32;
    L8:
        monitor-exit(r12);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L28
        goto L17
    L32:
        Vector<s4> r13 = n.f10841b;     // Catch: Throwable -> L14
        if (r13.contains(r10) == true) goto L8;
        r13.add(r10);     // Catch: Throwable -> L14
    L17:
        monitor-exit(r8);     // Catch: Throwable -> L22
    L19:
        if (this.f10882m == false) goto L36;
        s.a(this.f10883n.f10947d);     // Catch: Throwable -> L25
        return;
    L36:
        return;
    L22:
        th = move-exception;
        throw th;     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        th.printStackTrace();
    }
}
