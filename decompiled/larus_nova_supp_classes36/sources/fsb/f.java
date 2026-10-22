package fsb;

import android.text.TextUtils;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.log.Log;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class f {
    public static f e;
    public static final f f = null;
    public static com.ss.android.lark.monitor.c g;
    public static c h;
    public final String a;
    public long b;
    public ct3.b c;
    public fsb.a d;

    public static class a {
        public final View a;
        public final d b;
        public final e c;

        public static void a(a r2) {
            if (r2.a.getViewTreeObserver().isAlive() == false) goto L5;
            r2.a.getViewTreeObserver().removeOnPreDrawListener(r2.c);
        L5:
            r2.a.removeOnAttachStateChangeListener(r2.b);
        }

        public a(String r3, RecyclerView r4) {
            this.a = r4;
            d r0 = new d(this);
            this.b = r0;
            e r1 = new e(this, r3);
            this.c = r1;
            r4.getViewTreeObserver().addOnPreDrawListener(r1);
            r4.addOnAttachStateChangeListener(r0);
        }
    }

    static {
        f = new f("");
        g = null;
    }

    public static synchronized void a() {
        monitor-enter(f.class);
        f r1 = e;     // Catch: Throwable -> L12
        if (r1 == null) goto L7;
        r1.c = null;     // Catch: Throwable -> L12
        r1.d = null;     // Catch: Throwable -> L12
    L7:
        e = null;     // Catch: Throwable -> L12
        if (h == null) goto L10;
        CoreThreadPool.getNonblockingHandler().removeCallbacks(h);     // Catch: Throwable -> L12
        h = null;     // Catch: Throwable -> L12
    L10:
        monitor-exit(f.class);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public static synchronized f b() {
        monitor-enter(f.class);
        f r1 = e;     // Catch: Throwable -> L11
        if (r1 != null) goto L9;
        f r2 = f;     // Catch: Throwable -> L11
        monitor-exit(f.class);
        return r2;
    L9:
        monitor-exit(f.class);
        return r1;
    L11:
        th = move-exception;
        throw th;
    }

    public final void d() {
        ct3.b r0 = this.c;
        if (r0 == null) goto L7;
        ct3.f r1 = r0.a;
        if (r1 == null) goto L7;
        r1.c.clear();
        r0.a = null;
    L7:
        a();
    }

    public final void e() {
        Log.i("PageLoadMonitor", "pageComplete: " + this.a);
        ct3.b r0 = this.c;
        if (r0 == null) goto L5;
        r0.a(2, 10000);
    L5:
        fsb.a r1 = this.d;
        if (r1 == null) goto L9;
        r1.d = ((int) (System.nanoTime() - r1.b)) / 1000000;
    L9:
        if (((System.nanoTime() - this.b) / 1000000) < 10000) goto L11;
    L16:
        a();
        return;
    L11:
        if (g == null) goto L16;
        fsb.a r2 = this.d;
        if (r2 == null) goto L16;
        Log.i("PageLoadMonitor", "local ee_lark_android_page_load: " + r2.a());
        goto L16
    }

    public final void g() {
        fsb.a r0 = this.d;
        if (r0 == null) goto L6;
        r0.getClass();
        r0.c = ((int) (System.nanoTime() - r0.b)) / 1000000;
        return;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [fsb.c] */
    public final void j() {
        if (TextUtils.isEmpty(this.a) == false) goto L5;
        return;
    L5:
        h = new c(this);
        CoreThreadPool.getNonblockingHandler().postDelayed(h, 6000);
        this.b = System.nanoTime();
        ct3.b r0 = new ct3.b(this.a);
        this.c = r0;
        r0.b();
        fsb.a r1 = new fsb.a();
        this.d = r1;
        String r2 = this.a;
        r1.b = System.nanoTime();
        r1.a = r2;
    }

    public f(String r3) {
        this.b = -1;
        this.c = null;
        this.d = null;
        this.a = r3;
    }

    public static synchronized f c(String r4) {
        monitor-enter(f.class);
        Log.i("PageLoadMonitor", "obtain: ".concat(r4));     // Catch: Throwable -> L12
        f r0 = e;     // Catch: Throwable -> L12
        if (r0 != null) goto L7;
    L8:
        a();     // Catch: Throwable -> L12
        e = new f(r4);     // Catch: Throwable -> L12
    L9:
        f r5 = e;     // Catch: Throwable -> L12
        monitor-exit(f.class);
        return r5;
    L7:
        if (r4.equals(r0.a) == true) goto L9;
    L12:
        th = move-exception;
        throw th;
    }

    public final void f(RecyclerView r4) {
        if (r4 != null) goto L6;
        Log.w("PageLoadMonitor", "Trying to monitor a null view", new Exception());
        return;
    L6:
        Log.i("PageLoadMonitor", "pageComplete: " + this.a + " view:" + r4);
        if (TextUtils.isEmpty(this.a) == false) goto L9;
        return;
    L9:
        new a(this.a, r4);
    }

    public final void h(String r9) {
        ct3.b r0 = this.c;
        if (r0 == null) goto L7;
        ct3.f r1 = r0.a;
        if (r1 == null) goto L7;
        r1.a("", r9);
    L7:
        fsb.a r2 = this.d;
        if (r2 == null) goto L26;
        Iterator<fsb.a.C0267a> r3 = r2.e.iterator();
    L11:
        if (r3.hasNext() == false) goto L15;
        fsb.a.C0267a r4 = r3.next();
        if (r4.a.equals(r9) == false) goto L11;
    L17:
        if (r4 != null) goto L19;
        Log.d("PageLoadMonitor", "Trying to end a span which not started: " + r2.a + "/" + r9);
        return;
    L19:
        r4.c = ((int) (System.nanoTime() - r4.b)) / 1000000;
        if (r4.d.equals(ThreadMethodProxy.currentThread().getName()) == true) goto L28;
        Log.d("PageLoadMonitor", "Trying to end a span in different thread against pageSpanStart: " + ThreadMethodProxy.currentThread().getName() + "/" + r4.d);
        return;
    L28:
        return;
    L15:
        r4 = null;
        goto L17
    }

    public final void i(String r5) {
        ct3.b r0 = this.c;
        if (r0 == null) goto L7;
        ct3.f r1 = r0.a;
        if (r1 == null) goto L7;
        r1.d("", r5);
    L7:
        fsb.a r2 = this.d;
        if (r2 == null) goto L20;
        Iterator<fsb.a.C0267a> r3 = r2.e.iterator();
    L11:
        if (r3.hasNext() == false) goto L15;
        if (r3.next().a.equals(r5) == false) goto L11;
        return;
    L15:
        fsb.a.C0267a r4 = new fsb.a.C0267a();
        r4.a = r5;
        r4.b = System.nanoTime();
        r4.d = ThreadMethodProxy.currentThread().getName();
        r2.e.offer(r4);
        return;
    }
}
