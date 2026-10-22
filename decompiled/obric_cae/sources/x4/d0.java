package x4;

import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public final class d0 implements Handler.Callback {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final a f13391u = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j0 f13392a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d5.l f13393b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Handler f13394m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final y4.b f13395n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public s f13396o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final AtomicBoolean f13397p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public t0 f13398q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public x4.c f13399r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f13400s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public z4.c f13401t;

    public static class a extends k5.l<d> {
        @Override // k5.l
        public final d a(Object[] r8) {
            return new d((Context) r8[0]);
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d0 f13402a;

        public b(d0 r8) {
            this.f13402a = r8;
        }

        @Override // java.lang.Runnable
        public final void run() {
            d5.l r8 = this.f13402a.f13393b;
            i0 r10 = r8.d();
            String r11 = r10.f13443a;
            String r12 = r10.f13444b;
            String r13 = r10.f13447o;
            k5.b r14 = r8.f6816n;
            if (r14 == null) goto L6;
            r14.onIdLoaded(r11, r12, r13);
        L6:
            if (TextUtils.isEmpty(r10.f13443a) == false) goto L8;
            return;
        L8:
            if (TextUtils.isEmpty(r10.f13444b) == true) goto L16;
            z4.c r15 = r8.f6815m;
            if (r15 == null) goto L15;
            r15.a(new a5.b(r10));
            return;
        L15:
            return;
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f13403a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d0 f13404b;

        public class a implements d.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ c f13405a;

            public a(c r8) {
                this.f13405a = r8;
            }

            @Override // x4.d0.d.a
            public final void a() {
                c r8 = this.f13405a;
                Handler r10 = r8.f13404b.f13394m;
                i r11 = r8.f13403a;
                boolean r12 = r10.hasMessages(1235, r11);
                d0 r13 = r8.f13404b;
                if (r12 == false) goto L5;
                r13.f13394m.removeMessages(1235, r11);
                r13.f13394m.obtainMessage(1235, r11).sendToTarget();
                int r14 = r.f13543a;
            L5:
                r11.f13438g = null;
                d0.f13391u.b(new Object[]{r13.f13392a.f13465c}).a(this);
                Objects.toString(r11);
                toString();
                int r15 = r.f13543a;
            }
        }

        public c(d0 r8, i r10) {
            this.f13404b = r8;
            this.f13403a = r10;
        }

        @Override // java.lang.Runnable
        public final void run() {
            j0 r8 = this.f13404b.f13392a;
            if (r8.f13483u == false) goto L30;
            i r10 = this.f13403a;
            d.a r11 = r10.f13438g;
            if (r11 == null) goto L7;
            r10.f13438g = null;
            d0.f13391u.b(new Object[]{r8.f13465c}).a(r11);
            int r12 = r.f13543a;
        L7:
            i.a r13 = this.f13403a.j();
            d0.a(this.f13404b, r13, this.f13403a);
            i r14 = this.f13403a;
            if (r14.f13437f == false) goto L12;
            int r15 = r.f13543a;
            return;
        L12:
            if (r13.f13439a == true) goto L29;
            r14.e();
            if (r13.f13440b != 1) goto L29;
            a r16 = new a(this);
            this.f13403a.f13438g = r16;
            d r17 = d0.f13391u.b(new Object[]{this.f13404b.f13392a.f13465c});
            monitor-enter(r17);
            r17.f13406a.add(new WeakReference(r16));     // Catch: Throwable -> L26
            if (r17.f13407b.compareAndSet(false, true) == false) goto L24;
            g0 r18 = new g0(r17);     // Catch: Throwable -> L26
            IntentFilter r19 = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");     // Catch: Throwable -> L26
            r17.f13408c.registerReceiver(r18, r19);     // Catch: Exception -> L22 Throwable -> L26
        L22:
            e = move-exception;
            e.printStackTrace();     // Catch: Throwable -> L26
        L24:
            monitor-exit(r17);
        L26:
            th = move-exception;
            throw th;
        L29:
            Handler r20 = this.f13404b.f13394m;
            r20.sendMessageDelayed(r20.obtainMessage(1235, this.f13403a), r13.f13441c);
            return;
        L30:
            i.a r21 = this.f13403a.j();
            d0.a(this.f13404b, r21, this.f13403a);
            i r22 = this.f13403a;
            if (r22.f13437f == true) goto L33;
            Handler r23 = this.f13404b.f13394m;
            r23.sendMessageDelayed(r23.obtainMessage(1235, r22), r21.f13441c);
            return;
        L33:
            int r24 = r.f13543a;
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Set<WeakReference<a>> f13406a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AtomicBoolean f13407b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Context f13408c;

        public interface a {
            void a();
        }

        public d(Context r8) {
            this.f13406a = Collections.synchronizedSet(new HashSet());
            this.f13407b = new AtomicBoolean(false);
            this.f13408c = r8;
        }

        public final synchronized void a(a r8) {
            monitor-enter(this);
            Iterator<WeakReference<a>> r10 = this.f13406a.iterator();     // Catch: Throwable -> L14
        L5:
            if (r10.hasNext() == false) goto L12;
            WeakReference<a> r11 = r10.next();     // Catch: Throwable -> L14
            if (r11 == null) goto L8;
            if (r11.get() != r8) goto L5;
            r10.remove();     // Catch: Throwable -> L14
            goto L12
        L8:
            r10.remove();     // Catch: Throwable -> L14
        L12:
            monitor-exit(this);
            return;
        L14:
            th = move-exception;
            throw th;
        }
    }

    static {
        f13391u = new a();
    }

    public d0(s r8, j0 r10, d5.l r11) {
        y4.a r12 = h.f13429a;
        this.f13397p = new AtomicBoolean(false);
        new AtomicBoolean(false);
        this.f13392a = r10;
        this.f13393b = r11;
        this.f13395n = r12;
        this.f13394m = new Handler(t.d(r10.a()), this);
        this.f13396o = r8;
    }

    public static void a(d0 r8, i.a r10, i r11) {
        r8.getClass();
        if (r11 != null) goto L5;
    L7:
        if (r11 != null) goto L9;
        return;
    L9:
        if (r10.f13440b != 4) goto L13;
    L10:
        r11.i(r10.f13442d);
        r11.h(r10.f13439a);
        r11.a();
        return;
    L13:
        return;
    L5:
        if (r10.f13439a == false) goto L7;
        goto L7
    }

    public final void b(x4.c r8) {
        int r10 = r.f13543a;
        this.f13397p.set(true);
        x4.c r11 = this.f13399r;
        if (r11 == null) goto L5;
        r11.f13437f = true;
        this.f13394m.removeMessages(1235, r11);
    L5:
        this.f13399r = r8;
        f(r8, false);
    }

    public final boolean c(s r8) {
        if (this.f13396o.equals(r8) == false) goto L6;
        return false;
    L6:
        this.f13396o = r8;
        d5.l r10 = this.f13393b;
        r10.f6806d = r8;
        r10.f6812j = r10.a(r10.f6807e, r8);
        j5.j.a(r10.f6807e, r8, r10.f6808f);
        LinkedHashMap r11 = r10.f6803a;
        monitor-enter(r11);
        r10.f6803a.put(d5.w.class, new d5.w(r10.f6808f, r8));     // Catch: Throwable -> L15
        r10.f6803a.put(d5.n.class, new d5.n(r8, r10.f6808f));     // Catch: Throwable -> L15
        r10.f6803a.put(d5.g.class, new d5.g(r10.f6808f));     // Catch: Throwable -> L15
        r10.f6803a.put(d5.f.class, new d5.f(r10.f6808f));     // Catch: Throwable -> L15
        monitor-exit(r11);     // Catch: Throwable -> L15
        SharedPreferences r12 = r8.a(r10.f6808f);
        if (r12 == null) goto L20;
        r12.edit().putLong("register_time", 0).apply();
        return true;
    L20:
        return true;
    L15:
        th = move-exception;
        throw th;
    }

    public final void d(s r8, boolean r10) {
        j0 r11 = this.f13392a;
        t.g(new b(this), String.valueOf(r11.f13463a));
        d5.l r12 = this.f13393b;
        if (r12.f() == false) goto L20;
        t0 r13 = new t0(r8, r11, this.f13395n, r12);
        z4.c r14 = this.f13401t;
        if (r14 == null) goto L8;
        r14.a(new a5.a(r12.f6811i));
    L8:
        if (r10 == false) goto L10;
    L18:
        r13.f13435d = 0;
    L19:
        h.a().getClass();
        e(r13);
        this.f13398q = r13;
        return;
    L10:
        if (k5.a.a(r12.f6807e, r12.f6808f).getLong("dr_install_vc", 0) == r12.f6811i.optLong("version_code", 0)) goto L12;
        boolean r15 = true;
    L13:
        if (r15 == true) goto L18;
        Context r16 = r12.f6807e;
        j0 r17 = r12.f6808f;
        if ((!TextUtils.equals(k5.a.a(r16, r17).getString("dr_channel", null), r17.f13469g)) == true) goto L18;
        Context r18 = r12.f6807e;
        j0 r19 = r12.f6808f;
        if ((!TextUtils.equals(k5.a.a(r18, r19).getString("dr_aid", null), String.valueOf(r19.f13463a))) == false) goto L19;
    L12:
        r15 = false;
        goto L13
    L20:
        Handler r20 = this.f13394m;
        r20.removeMessages(1234);
        r20.sendMessageDelayed(r20.obtainMessage(1234, Boolean.valueOf(r10)), 1000);
    }

    public final void e(i r8) {
        String r10 = String.valueOf(this.f13392a.f13463a);
        t.g(new c(this, r8), r10);
    }

    public final void f(i r8, boolean r10) {
        Handler r11 = this.f13394m;
        if (r11 == null) goto L11;
        r11.removeMessages(1235, r8);
        r8.f13435d = 0;
        Message r12 = r11.obtainMessage(1235, r8);
        if (r10 == true) goto L7;
    L9:
        r11.sendMessage(r12);
        return;
    L7:
        if (Looper.myLooper() != r11.getLooper()) goto L9;
        handleMessage(r12);
        return;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message r8) {
        int r10 = r8.what;
        if (r10 != 1234) goto L5;
        d(this.f13396o, ((Boolean) r8.obj).booleanValue());
    L19:
        return false;
    L5:
        if (r10 != 1235) goto L19;
        i r11 = (i) r8.obj;
        if (this.f13392a.f13488z == true) goto L10;
    L12:
        boolean r12 = false;
    L13:
        if (r12 == true) goto L19;
        if (r11.f13437f == true) goto L19;
        e(r11);
        goto L19
    L10:
        if (((y4.a) this.f13395n).f13989b == true) goto L12;
        int r13 = r.f13543a;
        Handler r14 = this.f13394m;
        Message r15 = r14.obtainMessage(1235, r11);
        r11.getClass();
        r14.sendMessageDelayed(r15, 60000);
        r12 = true;
        goto L13
    }
}
