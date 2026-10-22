package com.larksuite.framework.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class AndroidThrottle<T> {
    public final Handler a;
    public final long b;
    public final byte[] c;
    public final d<T> d;
    public final e<T> e;
    public final int f;
    public long g;
    public final AtomicBoolean h;
    public volatile f i;

    public @interface DelayStrategy {
        public static final int DYNAMIC_INTERVAL_DELAY = 4;
        public static final int FIX_INTERVAL_DELAY = 1;
        public static final int MIN_INTERVAL_DELAY = 2;
    }

    public static class a<T> {
        public Handler a;
        public long b;
        public int c;
        public d<T> d;
        public e<T> e;

        public final AndroidThrottle<T> a() {
            return new AndroidThrottle(this);
        }

        public a() {
            this.a = new Handler(Looper.getMainLooper());
            this.b = 500;
            this.c = 1;
            this.d = new c();
        }
    }

    public static class b implements e<Runnable> {
        public b() {
        }

        @Override // com.larksuite.framework.utils.AndroidThrottle.e
        public final void a(Collection<Runnable> r2) {
            Iterator<Runnable> r3 = r2.iterator();
        L4:
            if (r3.hasNext() == false) goto L6;
            r3.next().run();
            goto L4
        }
    }

    public static class c<T> implements d<T> {
        public T a;

        @Override // com.larksuite.framework.utils.AndroidThrottle.d
        public final synchronized void clear() {
            monitor-enter(this);
            this.a = null;     // Catch: Throwable -> L7
            monitor-exit(this);
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.larksuite.framework.utils.AndroidThrottle.d
        public final Collection a() {
            ArrayList r0 = new ArrayList();
            T r1 = this.a;
            if (r1 == null) goto L5;
            r0.add(r1);
        L5:
            return r0;
        }

        @Override // com.larksuite.framework.utils.AndroidThrottle.d
        public final int size() {
            if (this.a == null) goto L5;
            return 1;
        L5:
            return 0;
        }

        public c() {
        }

        @Override // com.larksuite.framework.utils.AndroidThrottle.d
        public final void put(T r1) {
            this.a = r1;
        }
    }

    public interface d<T> {
        Collection<T> a();

        void clear();

        void put(T r1);

        int size();
    }

    public interface e<T> {
        void a(Collection<T> r1);
    }

    public static class f implements Runnable {
        public final WeakReference<AndroidThrottle> a;

        public final void a() {
            AndroidThrottle r0 = this.a.get();
            if (r0 != null) goto L5;
            return;
        L5:
            r0.h.set(false);
            r0.g = SystemClock.elapsedRealtime();
            byte[] r1 = r0.c;
            monitor-enter(r1);
            Collection<T> r2 = r0.d.a();     // Catch: Throwable -> L14
            monitor-exit(r1);     // Catch: Throwable -> L14
            if (r2 != null) goto L11;
            return;
        L11:
            if (r2.isEmpty() == true) goto L20;
            r0.e.a(r2);
            return;
        L20:
            return;
        L14:
            th = move-exception;
            throw th;
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

        public f(AndroidThrottle r2) {
            this.a = new WeakReference(r2);
        }
    }

    public final void b() {
        if (this.i == null) goto L5;
        this.a.removeCallbacks(this.i);
    L5:
        byte[] r0 = this.c;
        monitor-enter(r0);
        this.d.clear();     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public AndroidThrottle(a r4) {
        this.c = new byte[0];
        this.g = 0;
        this.h = new AtomicBoolean(false);
        this.i = new f(this);
        Handler r0 = r4.a;
        this.a = r0;
        this.b = r4.b;
        this.f = r4.c;
        d<T> r1 = r4.d;
        this.d = r1;
        e<T> r5 = r4.e;
        this.e = r5;
        a(r0, "handler");
        a(r1, "taskBuffer");
        a(r5, "taskExecutor");
    }

    public final void c(MessageInfo r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        byte[] r0 = this.c;
        monitor-enter(r0);
        this.d.put(r3);     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        if (this.h.get() == false) goto L11;
        this.a.removeCallbacks(this.i);
    L11:
        this.h.set(true);
        this.a.post(this.i);
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public final void d(T r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        e(Collections.singletonList(r1));
    }

    public final void e(Collection<T> r9) {
        if (r9 != null) goto L4;
        return;
    L4:
        if (r9.isEmpty() == true) goto L48;
        byte[] r0 = this.c;
        monitor-enter(r0);
        Iterator<T> r10 = r9.iterator();     // Catch: Throwable -> L40
    L10:
        if (r10.hasNext() == false) goto L12;
        this.d.put(r10.next());     // Catch: Throwable -> L40
        goto L10
    L12:
        int r11 = this.d.size();     // Catch: Throwable -> L40
        monitor-exit(r0);     // Catch: Throwable -> L40
        if (this.h.compareAndSet(false, true) == false) goto L47;
        Handler r1 = this.a;
        f r2 = this.i;
        int r3 = this.f;
        if (r3 != 1) goto L19;
        long r4 = this.b;
    L38:
        r1.postDelayed(r2, r4);
        return;
    L19:
        if (r3 != 2) goto L21;
        long r5 = SystemClock.elapsedRealtime() - this.g;
        long r6 = this.b;
        if (r5 >= r6) goto L36;
        r4 = r6 - r5;
    L36:
        r4 = 0;
        goto L38
    L21:
        if (r3 != 4) goto L36;
        float r12 = (float) ((((double) r11) * 1.0d) / ((SystemClock.elapsedRealtime() - this.g) / 1000.0d));
        if (r12 <= 10.0f) goto L27;
        double r7 = this.b;
        double r8 = 0.3d;
    L29:
        r4 = (long) (r7 * r8);
        goto L38
    L27:
        if (r12 <= 20.0f) goto L31;
        r7 = this.b;
        r8 = 0.6d;
        goto L29
    L31:
        if (r12 <= 40.0f) goto L36;
        r4 = this.b;
        goto L38
    L47:
        return;
    L40:
        th = move-exception;
        throw th;
    }

    public static void a(Object r1, String r2) {
        if (r1 == null) goto L5;
        return;
    L5:
        throw new IllegalStateException(r2.concat(" cannot empty"));
    }
}
