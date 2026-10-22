package ia;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes2.dex */
public final class f {
    public static final s6.b f = null;
    public static final sj.e g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f17560a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentLinkedQueue f17561b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentLinkedQueue f17562c;
    public volatile Handler d;
    public final Object e;

    static {
        f = new s6.b(10);
        g = new sj.e();
    }

    public f(String r5) {
        this.f17561b = new ConcurrentLinkedQueue();
        this.f17562c = new ConcurrentLinkedQueue();
        this.e = new Object();
        this.f17560a = new d(0, r5, this);
    }

    public final void a(Runnable r5) {
        if (this.f17561b.isEmpty() == true) goto L5;
    L6:
        ConcurrentLinkedQueue r10 = this.f17561b;
        s6.b r11 = f;
        Iterator r12 = r10.iterator();
    L8:
        if (r12.hasNext() == false) goto L19;
        Object r13 = r12.next();
        r11.getClass();
        e r14 = (e) r13;
        if (r14 == null) goto L16;
        Message r15 = r14.f17558a;
        if (r15 == null) goto L16;
        if (r5.equals(r15.getCallback()) == false) goto L16;
        boolean r16 = true;
    L17:
        if (r16 == false) goto L8;
        r12.remove();
    L16:
        r16 = false;
        goto L17
    L19:
        ConcurrentLinkedQueue r17 = this.f17562c;
        sj.e r18 = g;
        Iterator r19 = r17.iterator();
    L21:
        if (r19.hasNext() == false) goto L31;
        Object r20 = r19.next();
        r18.getClass();
        Message r21 = (Message) r20;
        if (r21 != null) goto L25;
    L27:
        boolean r22 = false;
    L28:
        if (r22 == false) goto L21;
        r19.remove();
        goto L21
    L25:
        if (r5.equals(r21.getCallback()) == false) goto L27;
        r22 = true;
    L31:
        if (this.d == null) goto L44;
        this.d.removeCallbacks(r5);
        return;
    L44:
        return;
    L5:
        if (this.f17562c.isEmpty() == true) goto L31;
        goto L6
    }

    public final boolean b(Message r5, long r10) {
        if (r10 >= 0) goto L5;
        r10 = 0;
    L5:
        long r11 = SystemClock.uptimeMillis() + r10;
        if (this.d != null) goto L21;
        Object r12 = this.e;
        monitor-enter(r12);
    L14:
        th = move-exception;
        throw th;
    L10:
        if (this.d != null) goto L16;
        ConcurrentLinkedQueue r13 = this.f17561b;     // Catch: Throwable -> L14
        e r14 = new e();     // Catch: Throwable -> L14
        r14.f17558a = r5;     // Catch: Throwable -> L14
        r14.f17559b = r11;     // Catch: Throwable -> L14
        r13.add(r14);     // Catch: Throwable -> L14
        monitor-exit(r12);     // Catch: Throwable -> L14
        return true;
    L16:
        monitor-exit(r12);     // Catch: Throwable -> L14
    L21:
        return this.d.sendMessageAtTime(r5, r11);
    }
}
