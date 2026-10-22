package s1;

import androidx.work.impl.WorkDatabase;
import j1.i0;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes.dex */
public abstract class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j1.m f11971a;

    public e() {
        this.f11971a = new j1.m();
    }

    public static void a(j1.b0 r8, String r10) {
        WorkDatabase r11 = r8.f8453c;
        r1.u r12 = r11.f();
        r1.b r13 = r11.a();
        LinkedList r14 = new LinkedList();
        r14.add(r10);
    L4:
        if (r14.isEmpty() == true) goto L11;
        String r15 = (String) r14.remove();
        androidx.work.u.a r16 = r12.f(r15);
        if (r16 == androidx.work.u.a.f2954m) goto L10;
        if (r16 == androidx.work.u.a.f2955n) goto L10;
        r12.n(androidx.work.u.a.f2957p, r15);
    L10:
        r14.addAll(r13.a(r15));
        goto L4
    L11:
        j1.p r17 = r8.f8456f;
        Object r18 = r17.f8535v;
        monitor-enter(r18);
        androidx.work.m.d().a(j1.p.f8523w, "Processor cancelling " + r10);     // Catch: Throwable -> L30
        r17.f8533t.add(r10);     // Catch: Throwable -> L30
        i0 r19 = (i0) r17.f8529p.remove(r10);     // Catch: Throwable -> L30
        if (r19 == null) goto L16;
        boolean r20 = true;
    L17:
        if (r19 != null) goto L19;
        r19 = (i0) r17.f8530q.remove(r10);     // Catch: Throwable -> L30
    L19:
        if (r19 == null) goto L21;
        r17.f8531r.remove(r10);     // Catch: Throwable -> L30
    L21:
        monitor-exit(r18);     // Catch: Throwable -> L30
        j1.p.b(r19, r10);
        if (r20 == false) goto L25;
        r17.h();
    L25:
        Iterator<j1.r> r21 = r8.f8455e.iterator();
    L27:
        if (r21.hasNext() == false) goto L29;
        r21.next().b(r10);
        goto L27
    L29:
        return;
    L16:
        r20 = false;
    L30:
        th = move-exception;
        throw th;
    }

    public abstract void b();

    @Override // java.lang.Runnable
    public final void run() {
        j1.m r8 = this.f11971a;
        b();     // Catch: Throwable -> L5
        r8.a(androidx.work.p.f2939a);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        r8.a(new androidx.work.p.a.C0026a(th));
    }
}
