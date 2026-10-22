package s1;

import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public final class b0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UUID f11952a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ androidx.work.e f11953b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ t1.c f11954m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final /* synthetic */ c0 f11955n;

    public b0(c0 r8, UUID r10, androidx.work.e r11, t1.c r12) {
        this.f11955n = r8;
        this.f11952a = r10;
        this.f11953b = r11;
        this.f11954m = r12;
    }

    @Override // java.lang.Runnable
    public final void run() {
        t1.c r8 = this.f11954m;
        UUID r10 = this.f11952a;
        String r11 = r10.toString();
        androidx.work.m r12 = androidx.work.m.d();
        String r13 = c0.f11958c;
        StringBuilder r14 = new StringBuilder("Updating progress for ");
        r14.append(r10);
        r14.append(" (");
        androidx.work.e r15 = this.f11953b;
        r14.append(r15);
        r14.append(")");
        r12.a(r13, r14.toString());
        c0 r16 = this.f11955n;
        r16.f11959a.beginTransaction();
        r1.t r17 = r16.f11959a.f().g(r11);     // Catch: Throwable -> L12
        if (r17 == null) goto L11;
        if (r17.f11340b != androidx.work.u.a.f2953b) goto L8;
        r16.f11959a.e().a(new r1.p(r11, r15));     // Catch: Throwable -> L12
    L9:
        r8.j(null);     // Catch: Throwable -> L12
        r16.f11959a.setTransactionSuccessful();     // Catch: Throwable -> L12
    L14:
        r16.f11959a.endTransaction();
        return;
    L8:
        androidx.work.m.d().g(r13, "Ignoring setProgressAsync(...). WorkSpec (" + r11 + ") is not in a RUNNING state.");     // Catch: Throwable -> L12
        goto L9
    L11:
        throw new IllegalStateException("Calls to setProgressAsync() must complete before a ListenableWorker signals completion of work by returning an instance of Result.");     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        androidx.work.m.d().c(c0.f11958c, "Error updating Worker progress", th);     // Catch: Throwable -> L16
        r8.k(th);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        r16.f11959a.endTransaction();
        throw th;
    }
}
