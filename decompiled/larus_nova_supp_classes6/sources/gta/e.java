package gta;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.common.applog.k0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class e {
    public static volatile e l;
    public boolean a;
    public volatile boolean b;
    public boolean c;
    public long d;
    public g e;
    public c f;
    public final gta.b g;
    public final List<g> h;
    public boolean i;
    public final a j;
    public final b k;

    public class a implements Runnable {
        public final /* synthetic */ e a;

        @Override // java.lang.Runnable
        public final void run() {
            e r0 = this.a;     // Catch: Throwable -> L10
            g r1 = r0.e;     // Catch: Throwable -> L10
            if (r1 != null) goto L5;
            return;
        L5:
            if (r0.i == false) goto L7;
            r0.g.b(r1);     // Catch: Throwable -> L10
        L8:
            e r2 = this.a;     // Catch: Throwable -> L10
            r2.e = null;     // Catch: Throwable -> L10
            r2.g.a();     // Catch: Throwable -> L10
            return;
        L7:
            ((ArrayList) r0.h).add(r1);     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L17;
            throw th;
        }

        public a(e r1) {
            this.a = r1;
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ e a;

        public final void a() {
            this.a.i = true;
            Iterator r0 = new ArrayList(this.a.h).iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            g r1 = (g) r0.next();
            this.a.g.b(r1);
            goto L4
        L6:
            ((ArrayList) this.a.h).clear();
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(e r1) {
            this.a = r1;
        }
    }

    public final Handler b() {
        if (this.f != null) goto L14;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.f != null) goto L8;
        this.f = new c(this, k0.d().getLooper());     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L14:
        return this.f;
    }

    public e(Context r4) {
        this.a = false;
        this.b = false;
        this.c = true;
        this.d = System.currentTimeMillis();
        this.h = new ArrayList();
        this.i = false;
        this.j = new a(this);
        this.k = new b(this);
        r4.getApplicationContext();
        this.g = new gta.b(r4);
    }

    public static e c(Context r2) {
        if (l != null) goto L15;
        monitor-enter(e.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (l != null) goto L9;
        l = new e(r2.getApplicationContext());     // Catch: Throwable -> L11
    L9:
        monitor-exit(e.class);     // Catch: Throwable -> L11
    L15:
        return l;
    }

    public static void a(e r2, String r3) {
        Handler r4 = r2.b();
        r4.removeMessages(1);
        r4.sendMessageDelayed(Message.obtain(r4, 1, r3), 5000);
    }
}
