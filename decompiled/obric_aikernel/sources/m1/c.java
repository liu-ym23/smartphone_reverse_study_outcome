package m1;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.work.WorkRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import o1.p;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final List<String> f10963n = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f10964a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile boolean f10965b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f10966c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f10967d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private m1.d f10968e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Handler f10969f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final m1.b f10970g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final List<m1.d> f10971h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f10972i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private volatile m1.a f10973j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final com.bytedance.applog.c f10974k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Runnable f10975l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final Runnable f10976m;

    class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f10977a;

        a(c r10, Looper r11) {
            this.f10977a = r10;
            super(r11);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r10) {
            super.handleMessage(r10);
            boolean r11 = true;
            if (r10.what == 1) goto L6;
            return;
        L6:
            if (c.a(this.f10977a) == null) goto L19;
            Object r12 = r10.obj;
            if ((r12 instanceof String) == false) goto L19;
            String r13 = (String) r12;
            boolean r14 = p.g(r13, c.a(this.f10977a).g());
            if (c.c(this.f10977a) == true) goto L12;
        L14:
            r11 = false;
        L15:
            if (r14 == false) goto L19;
            if (r11 == false) goto L19;
            c.a(this.f10977a).n(System.currentTimeMillis());
            c.o(this.f10977a).i(c.a(this.f10977a));
            c.p(this.f10977a, r13);
            c.q(this.f10977a);
            return;
        L12:
            if (c.m(this.f10977a) == false) goto L14;
        L19:
            c.o(this.f10977a).b();
            c.q(this.f10977a);
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ c f10978c;

        b(c r10) {
            this.f10978c = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            f1.g r10 = c.s(this.f10978c).P();
            List<String> r11 = c.r();
            StringBuilder r12 = new StringBuilder();
            r12.append("[Task] closeCurrentSession currentSession is null : ");
            if (c.a(this.f10978c) != null) goto L5;
            boolean r13 = true;
        L6:
            r12.append(r13);
            r10.o(r11, r12.toString(), new Object[0]);
            if (c.a(this.f10978c) != null) goto L9;
            c.s(this.f10978c).P().g(c.r(), "[Task] closeCurrentSession found that currentSession is null", new Object[0]);
            return;
        L9:
            if (c.t(this.f10978c) == false) goto L11;
            c.s(this.f10978c).P().o(c.r(), "[Task] is fired : so save session to Db", new Object[0]);
            c.o(this.f10978c).g(c.a(this.f10978c));
        L12:
            c.b(this.f10978c, null);
            c.o(this.f10978c).b();
            return;
        L11:
            c.s(this.f10978c).P().o(c.r(), "[Task] is not fired : so save session in pendingSessions", new Object[0]);
            c.v(this.f10978c).add(c.a(this.f10978c));
            goto L12
        L5:
            r13 = false;
            goto L6
        }
    }

    /* JADX INFO: renamed from: m1.c$c, reason: collision with other inner class name */
    class RunnableC0238c implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ c f10979c;

        RunnableC0238c(c r10) {
            this.f10979c = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.u(this.f10979c, true);
            c.s(this.f10979c).P().o(c.r(), "[Task] fire pending Sessions", new Object[0]);
            Iterator r10 = new ArrayList(c.v(this.f10979c)).iterator();
        L4:
            if (r10.hasNext() == false) goto L6;
            m1.d r11 = (m1.d) r10.next();
            c.o(this.f10979c).g(r11);
            goto L4
        L6:
            c.v(this.f10979c).clear();
        }
    }

    class d implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f10980c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ c f10981g;

        d(c r10, long r11) {
            this.f10981g = r10;
            this.f10980c = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.m(this.f10981g) == true) goto L15;
            c.s(this.f10981g).P().o(c.r(), "[Task] onTaskResume", new Object[0]);
            c.n(this.f10981g, true);
            if (c.c(this.f10981g) == false) goto L16;
            c.e(this.f10981g, true);
            if (c.a(this.f10981g) != null) goto L11;
            c.s(this.f10981g).P().o(c.r(), "[Task] pure bg launch , so create a new task session", new Object[0]);
            c r10 = this.f10981g;
            m1.d r11 = new m1.d(this.f10980c, c.s(r10).T());
        L9:
            c.b(r10, r11);
            c.o(this.f10981g).b();
        L10:
            c r12 = this.f10981g;
            c.p(r12, c.a(r12).g());
            return;
        L11:
            long r13 = this.f10980c - c.a(this.f10981g).f();
            if (r13 > 15000) goto L14;
            c.s(this.f10981g).P().o(c.r(), "[Task] task time diff " + r13 + " , is less than 15000 so , merge in previous session", new Object[0]);
            m1.e.d().h(c.g(this.f10981g));
            c.a(this.f10981g).a(r13);
            c.a(this.f10981g).n(this.f10980c);
            c.o(this.f10981g).i(c.a(this.f10981g));
            goto L10
        L14:
            c.s(this.f10981g).P().o(c.r(), "[Task] task time diff " + r13 + " , is bigger than 15000 so close current session and create new session", new Object[0]);
            m1.e.d().h(c.g(this.f10981g));
            c.g(this.f10981g).run();
            r10 = this.f10981g;
            r11 = new m1.d(this.f10980c, c.s(r10).T());
            goto L9
        L16:
            return;
        }
    }

    class e implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f10982c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ c f10983g;

        e(c r10, long r11) {
            this.f10983g = r10;
            this.f10982c = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.m(this.f10983g) == false) goto L11;
            c.s(this.f10983g).P().o(c.r(), "[Task] onTaskPause", new Object[0]);
            c.n(this.f10983g, false);
            if (c.c(this.f10983g) == true) goto L7;
            return;
        L7:
            if (c.a(this.f10983g) == null) goto L9;
            c.s(this.f10983g).P().o(c.r(), "[Task] wait 15000 to close current session", new Object[0]);
            c.a(this.f10983g).n(this.f10982c);
            m1.e.d().i(c.g(this.f10983g), 15000);
            c.o(this.f10983g).i(c.a(this.f10983g));
            c.h(this.f10983g);
            return;
        L9:
            c.s(this.f10983g).P().g(c.r(), "[Task] onTaskPause when bg, but no session available", new Object[0]);
            return;
        }
    }

    class f implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f10984c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f10985g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ c f10986h;

        f(c r10, long r11, String r12) {
            this.f10986h = r10;
            this.f10984c = r11;
            this.f10985g = r12;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.s(this.f10986h).P().o(c.r(), "[Task] onExitBg", new Object[0]);
            if (c.c(this.f10986h) == false) goto L18;
            c.f(this.f10986h, false);
            m1.e.d().h(c.i(this.f10986h));
            m1.e.d().h(c.g(this.f10986h));
            c.h(this.f10986h);
            c.o(this.f10986h).b();
            if (c.d(this.f10986h) == true) goto L7;
        L16:
            c.l(this.f10986h);
            return;
        L7:
            if ((this.f10984c - c.j(this.f10986h)) > WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS) goto L10;
            c.s(this.f10986h).P().o(c.r(), "[Task] time diff is less than 30000 , so clear current session", new Object[0]);
            c.v(this.f10986h).clear();
            c.b(this.f10986h, null);
            goto L16
        L10:
            if (c.a(this.f10986h) == null) goto L15;
            c.s(this.f10986h).P().o(c.r(), "[Task] close current session", new Object[0]);
            if (c.m(this.f10986h) == false) goto L14;
            c.a(this.f10986h).l(this.f10985g);
            c.a(this.f10986h).n(this.f10984c);
        L14:
            c.o(this.f10986h).g(c.a(this.f10986h));
            c.b(this.f10986h, null);
        L15:
            c.i(this.f10986h).run();
            goto L16
        }
    }

    class g implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f10987c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f10988g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ c f10989h;

        g(c r10, long r11, String r12) {
            this.f10989h = r10;
            this.f10987c = r11;
            this.f10988g = r12;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.s(this.f10989h).P().o(c.r(), "[Task] onEnterBg", new Object[0]);
            if (c.c(this.f10989h) == true) goto L11;
            c.l(this.f10989h);
            m1.e.d().i(c.i(this.f10989h), 30010);
            c.k(this.f10989h, this.f10987c);
            c.f(this.f10989h, true);
            if (c.m(this.f10989h) == false) goto L12;
            c.e(this.f10989h, true);
            if (c.a(this.f10989h) == null) goto L9;
            c.s(this.f10989h).P().g(c.r(), "[Task] enter bg , bug there is already a bg task is running", new Object[0]);
        L9:
            c.s(this.f10989h).P().o(c.r(), "[Task] task is running , so create a new task session", new Object[0]);
            c r10 = this.f10989h;
            c.b(r10, new m1.d(this.f10987c, c.s(r10).T()));
            c.a(this.f10989h).m(this.f10988g);
            c r11 = this.f10989h;
            c.p(r11, c.a(r11).g());
            return;
        L12:
            return;
        }
    }

    static {
        f10963n = Collections.singletonList("TaskPresenter");
    }

    public c(com.bytedance.applog.c r10, l1.b r11, g1.c r12) {
        this.f10964a = false;
        this.f10965b = false;
        this.f10966c = true;
        this.f10967d = System.currentTimeMillis();
        this.f10971h = new ArrayList();
        this.f10972i = false;
        this.f10975l = new b(this);
        this.f10976m = new RunnableC0238c(this);
        this.f10974k = r10;
        this.f10970g = new m1.b(r10, r11, r12);
    }

    private void E(String r10) {
        Handler r11 = z();
        r11.removeMessages(1);
        r11.sendMessageDelayed(Message.obtain(r11, 1, r10), 5000);
    }

    private void F() {
        m1.a r10 = this.f10973j;
        if (r10 == null) goto L11;
        boolean r11 = r10.a();
        if (this.f10965b == r11) goto L12;
        this.f10974k.P().t(f10963n, "[Task] tryCorrectTaskState newIsTaskRunning : " + r11, new Object[0]);
        if (r11 == false) goto L9;
        D();
        return;
    L9:
        C();
        return;
    L12:
        return;
    }

    static /* synthetic */ m1.d a(c r10) {
        return r10.f10968e;
    }

    static /* synthetic */ m1.d b(c r10, m1.d r11) {
        r10.f10968e = r11;
        return r11;
    }

    static /* synthetic */ boolean c(c r10) {
        return r10.f10966c;
    }

    static /* synthetic */ boolean d(c r10) {
        return r10.f10964a;
    }

    static /* synthetic */ boolean e(c r10, boolean r11) {
        r10.f10964a = r11;
        return r11;
    }

    static /* synthetic */ boolean f(c r10, boolean r11) {
        r10.f10966c = r11;
        return r11;
    }

    static /* synthetic */ Runnable g(c r10) {
        return r10.f10975l;
    }

    static /* synthetic */ void h(c r10) {
        r10.w();
    }

    static /* synthetic */ Runnable i(c r10) {
        return r10.f10976m;
    }

    static /* synthetic */ long j(c r10) {
        return r10.f10967d;
    }

    static /* synthetic */ long k(c r10, long r11) {
        r10.f10967d = r11;
        return r11;
    }

    static /* synthetic */ void l(c r10) {
        r10.x();
    }

    static /* synthetic */ boolean m(c r10) {
        return r10.f10965b;
    }

    static /* synthetic */ boolean n(c r10, boolean r11) {
        r10.f10965b = r11;
        return r11;
    }

    static /* synthetic */ m1.b o(c r10) {
        return r10.f10970g;
    }

    static /* synthetic */ void p(c r10, String r11) {
        r10.E(r11);
    }

    static /* synthetic */ void q(c r10) {
        r10.F();
    }

    static /* synthetic */ List r() {
        return f10963n;
    }

    static /* synthetic */ com.bytedance.applog.c s(c r10) {
        return r10.f10974k;
    }

    static /* synthetic */ boolean t(c r10) {
        return r10.f10972i;
    }

    static /* synthetic */ boolean u(c r10, boolean r11) {
        r10.f10972i = r11;
        return r11;
    }

    static /* synthetic */ List v(c r10) {
        return r10.f10971h;
    }

    private void w() {
        z().removeMessages(1);
    }

    private void x() {
        this.f10964a = false;
        this.f10971h.clear();
        this.f10972i = false;
    }

    private Handler y() {
        return new a(this, m1.e.d().getLooper());
    }

    private Handler z() {
        if (this.f10969f != null) goto L14;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.f10969f != null) goto L8;
        this.f10969f = y();     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L14:
        return this.f10969f;
    }

    public void A(long r10, String r11) {
        m1.e.d().a(new g(this, r10, r11));
    }

    public void B(long r10, String r11) {
        m1.e.d().a(new f(this, r10, r11));
    }

    public void C() {
        long r10 = System.currentTimeMillis();
        m1.e.d().a(new e(this, r10));
    }

    public void D() {
        long r10 = System.currentTimeMillis();
        m1.e.d().a(new d(this, r10));
    }
}
