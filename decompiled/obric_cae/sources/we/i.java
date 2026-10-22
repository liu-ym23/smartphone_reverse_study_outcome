package we;

import com.obric.cae.BWDL.BwdlDrop.BwdlDropUtils;
import java.lang.ref.Reference;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public final class i {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ThreadPoolExecutor f13194g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f13195a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f13196b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f13197c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayDeque f13198d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final qd.a f13199e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f13200f;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f13201a;

        public a(i r8) {
            this.f13201a = r8;
        }

        @Override // java.lang.Runnable
        public final void run() {
        L2:
            i r8 = this.f13201a;
            long r10 = System.nanoTime();
            monitor-enter(r8);
            Iterator r11 = r8.f13198d.iterator();     // Catch: Throwable -> L46
            ze.d r12 = null;
            long r13 = Long.MIN_VALUE;
            int r14 = 0;
            int r15 = 0;
        L6:
            if (r11.hasNext() == false) goto L13;
            ze.d r16 = (ze.d) r11.next();     // Catch: Throwable -> L46
            if (r8.a(r16, r10) > 0) goto L9;
            r14 = r14 + 1;     // Catch: Throwable -> L46
            long r17 = r10 - r16.f14386o;     // Catch: Throwable -> L46
            if (r17 <= r13) goto L6;
            r12 = r16;
            r13 = r17;
            goto L6
        L9:
            r15 = r15 + 1;     // Catch: Throwable -> L46
            goto L6
        L13:
            long r18 = r8.f13196b;     // Catch: Throwable -> L46
            if (r13 < r18) goto L16;
        L28:
            r8.f13198d.remove(r12);     // Catch: Throwable -> L46
            monitor-exit(r8);     // Catch: Throwable -> L46
            xe.c.g(r12.f14376e);
            r18 = 0;
        L32:
            if (r18 == (-1)) goto L33;
            if (r18 <= 0) goto L2;
            long r19 = r18 / BwdlDropUtils.DROP_SHOW_MEGABYTES;
            long r20 = r18 - (BwdlDropUtils.DROP_SHOW_MEGABYTES * r19);
            i r21 = this.f13201a;
            monitor-enter(r21);
            this.f13201a.wait(r19, (int) r20);     // Catch: Throwable -> L40 InterruptedException -> L49
        L40:
            th = move-exception;
            throw th;
        L42:
            monitor-exit(r21);     // Catch: Throwable -> L40
            goto L2
        L33:
            return;
        L16:
            if (r14 > r8.f13195a) goto L28;
            if (r14 <= 0) goto L22;
            r18 = r18 - r13;     // Catch: Throwable -> L46
            monitor-exit(r8);     // Catch: Throwable -> L46
            goto L32
        L22:
            if (r15 <= 0) goto L25;
            monitor-exit(r8);     // Catch: Throwable -> L46
            goto L32
        L25:
            r8.f13200f = false;     // Catch: Throwable -> L46
            monitor-exit(r8);     // Catch: Throwable -> L46
            r18 = -1;
        L46:
            th = move-exception;
            throw th;
        }
    }

    static {
        TimeUnit r8 = TimeUnit.SECONDS;
        SynchronousQueue r10 = new SynchronousQueue();
        byte[] r11 = xe.c.f13880a;
        f13194g = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, r8, r10, new xe.d("OkHttp ConnectionPool", true));
    }

    public i() {
        this(5, 5, TimeUnit.MINUTES);
    }

    public final int a(ze.d r8, long r10) {
        ArrayList r11 = r8.f14385n;
        int r12 = 0;
    L4:
        if (r12 >= r11.size()) goto L13;
        Reference r13 = (Reference) r11.get(r12);
        if (r13.get() != null) goto L7;
        df.f.f7097a.m(((ze.g.a) r13).f14415a, "A connection to " + r8.f14374c.f13158a.f13103a + " was leaked. Did you forget to close a response body?");
        r11.remove(r12);
        r8.f14382k = true;
        if (r11.isEmpty() == false) goto L4;
        r8.f14386o = r10 - this.f13196b;
        return 0;
    L7:
        r12 = r12 + 1;
        goto L4
    L13:
        return r11.size();
    }

    public i(int r8, long r10, TimeUnit r11) {
        this.f13197c = new a(this);
        this.f13198d = new ArrayDeque();
        this.f13199e = new qd.a(5);
        this.f13195a = r8;
        this.f13196b = r11.toNanos(r10);
        if (r10 <= 0) goto L6;
        return;
    L6:
        throw new IllegalArgumentException(android.aimedia.a.d("keepAliveDuration <= 0: ", r10));
    }
}
