package we;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f13226a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f13227b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public ThreadPoolExecutor f13228c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayDeque f13229d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ArrayDeque f13230e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ArrayDeque f13231f;

    public m() {
        this.f13226a = 64;
        this.f13227b = 5;
        this.f13229d = new ArrayDeque();
        this.f13230e = new ArrayDeque();
        this.f13231f = new ArrayDeque();
    }

    public final void a(ArrayDeque r8, Object r10) {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (r8.remove(r10) == false) goto L9;
        monitor-exit(this);     // Catch: Throwable -> L10
        c();
        return;
    L9:
        throw new AssertionError("Call wasn't in-flight!");     // Catch: Throwable -> L10
    }

    public final void b(x.b r8) {
        a(this.f13230e, r8);
    }

    public final void c() {
        ArrayList r8 = new ArrayList();
        monitor-enter(this);
        Iterator r10 = this.f13229d.iterator();     // Catch: Throwable -> L45
    L5:
        int r11 = 0;
        if (r10.hasNext() == false) goto L23;
        x.b r12 = (x.b) r10.next();     // Catch: Throwable -> L45
        if (this.f13230e.size() >= this.f13226a) goto L23;
        Iterator r13 = this.f13230e.iterator();     // Catch: Throwable -> L45
    L12:
        if (r13.hasNext() == false) goto L20;
        x r14 = ((x.b) r13.next()).f13336m;     // Catch: Throwable -> L45
        if (r14.f13332p == true) goto L12;
        if (r14.f13331o.f13337a.f13244d.equals(r12.f13336m.f13331o.f13337a.f13244d) == false) goto L12;
        r11 = r11 + 1;     // Catch: Throwable -> L45
        goto L12
    L20:
        if (r11 >= this.f13227b) goto L5;
        r10.remove();     // Catch: Throwable -> L45
        r8.add(r12);     // Catch: Throwable -> L45
        this.f13230e.add(r12);     // Catch: Throwable -> L45
    L23:
        monitor-enter(this);     // Catch: Throwable -> L45
        int r15 = this.f13230e.size() + this.f13231f.size();
        monitor-exit(this);     // Catch: Throwable -> L45
        monitor-exit(this);     // Catch: Throwable -> L45
        int r16 = r8.size();
        int r17 = 0;
    L29:
        if (r17 >= r16) goto L41;
        x.b r18 = (x.b) r8.get(r17);
        monitor-enter(this);
        if (this.f13228c != null) goto L35;
        TimeUnit r19 = TimeUnit.SECONDS;     // Catch: Throwable -> L38
        SynchronousQueue r110 = new SynchronousQueue();     // Catch: Throwable -> L38
        byte[] r111 = xe.c.f13880a;     // Catch: Throwable -> L38
        this.f13228c = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, r19, r110, new xe.d("OkHttp Dispatcher", false));     // Catch: Throwable -> L38
    L35:
        ThreadPoolExecutor r20 = this.f13228c;     // Catch: Throwable -> L38
        monitor-exit(this);
        r18.b(r20);
        r17 = r17 + 1;
    L38:
        th = move-exception;
        throw th;
    L41:
        return;
    L42:
        th = move-exception;
        throw th;     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        throw th;
    }
}
