package i9;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.ArrayMap;
import android.view.Choreographer;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
class a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ThreadLocal<a> f9396g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ArrayMap<b, Long> f9397a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final ArrayList<b> f9398b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final C0183a f9399c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private c f9400d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    long f9401e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f9402f;

    /* JADX INFO: renamed from: i9.a$a, reason: collision with other inner class name */
    class C0183a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f9403a;

        C0183a(a r10) {
            this.f9403a = r10;
        }

        void a() {
            a r10 = this.f9403a;
            r10.f9401e = SystemClock.uptimeMillis();
            a r11 = this.f9403a;
            r11.c(r11.f9401e);
            if (this.f9403a.f9398b.size() <= 0) goto L6;
            this.f9403a.e().a();
            return;
        }
    }

    interface b {
        boolean doAnimationFrame(long r10);
    }

    static abstract class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final C0183a f9404a;

        c(C0183a r10) {
            this.f9404a = r10;
        }

        abstract void a();
    }

    private static class d extends c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Runnable f9405b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Handler f9406c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        long f9407d;

        /* JADX INFO: renamed from: i9.a$d$a, reason: collision with other inner class name */
        class RunnableC0184a implements Runnable {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ d f9408c;

            RunnableC0184a(d r10) {
                this.f9408c = r10;
            }

            @Override // java.lang.Runnable
            public void run() {
                d r10 = this.f9408c;
                r10.f9407d = SystemClock.uptimeMillis();
                this.f9408c.f9404a.a();
            }
        }

        d(C0183a r10) {
            super(r10);
            this.f9407d = -1;
            this.f9405b = new RunnableC0184a(this);
            this.f9406c = new Handler(Looper.myLooper());
        }

        @Override // i9.a.c
        void a() {
            long r10 = Math.max(10 - (SystemClock.uptimeMillis() - this.f9407d), 0);
            this.f9406c.postDelayed(this.f9405b, r10);
        }
    }

    private static class e extends c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Choreographer f9409b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Choreographer.FrameCallback f9410c;

        /* JADX INFO: renamed from: i9.a$e$a, reason: collision with other inner class name */
        class ChoreographerFrameCallbackC0185a implements Choreographer.FrameCallback {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ e f9411c;

            ChoreographerFrameCallbackC0185a(e r10) {
                this.f9411c = r10;
            }

            @Override // android.view.Choreographer.FrameCallback
            public void doFrame(long r10) {
                this.f9411c.f9404a.a();
            }
        }

        e(C0183a r10) {
            super(r10);
            this.f9409b = Choreographer.getInstance();
            this.f9410c = new ChoreographerFrameCallbackC0185a(this);
        }

        @Override // i9.a.c
        void a() {
            this.f9409b.postFrameCallback(this.f9410c);
        }
    }

    static {
        f9396g = new ThreadLocal();
    }

    a() {
        this.f9397a = new ArrayMap();
        this.f9398b = new ArrayList();
        this.f9399c = new C0183a(this);
        this.f9401e = 0;
        this.f9402f = false;
    }

    private void b() {
        if (this.f9402f == false) goto L15;
        int r10 = this.f9398b.size() - 1;
    L5:
        if (r10 < 0) goto L10;
        if (this.f9398b.get(r10) != null) goto L9;
        this.f9398b.remove(r10);
    L9:
        r10 = r10 - 1;
        goto L5
    L10:
        this.f9402f = false;
        return;
    }

    public static a d() {
        ThreadLocal<a> r10 = f9396g;
        if (r10.get() != null) goto L6;
        r10.set(new a());
    L6:
        return r10.get();
    }

    private boolean f(b r10, long r11) {
        Long r12 = this.f9397a.get(r10);
        if (r12 != null) goto L6;
        return true;
    L6:
        if (r12.longValue() >= r11) goto L9;
        this.f9397a.remove(r10);
        return true;
    L9:
        return false;
    }

    public void a(b r10, long r11) {
        if (this.f9398b.size() != 0) goto L6;
        e().a();
    L6:
        if (this.f9398b.contains(r10) == true) goto L9;
        this.f9398b.add(r10);
    L9:
        if (r11 <= 0) goto L12;
        this.f9397a.put(r10, Long.valueOf(SystemClock.uptimeMillis() + r11));
        return;
    }

    void c(long r10) {
        long r11 = SystemClock.uptimeMillis();
        int r12 = 0;
    L4:
        if (r12 >= this.f9398b.size()) goto L12;
        b r13 = this.f9398b.get(r12);
        if (r13 == null) goto L11;
        if (f(r13, r11) == false) goto L11;
        r13.doAnimationFrame(r10);
    L11:
        r12 = r12 + 1;
        goto L4
    L12:
        b();
    }

    c e() {
        if (this.f9400d != null) goto L10;
        if (Build.VERSION.SDK_INT < 16) goto L7;
        c r10 = new e(this.f9399c);
    L8:
        this.f9400d = r10;
        goto L10
    L7:
        r10 = new d(this.f9399c);
    L10:
        return this.f9400d;
    }

    public void g(b r10) {
        this.f9397a.remove(r10);
        int r11 = this.f9398b.indexOf(r10);
        if (r11 < 0) goto L6;
        this.f9398b.set(r11, null);
        this.f9402f = true;
        return;
    }
}
