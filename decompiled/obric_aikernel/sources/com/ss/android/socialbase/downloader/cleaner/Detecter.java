package com.ss.android.socialbase.downloader.cleaner;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/* JADX INFO: loaded from: classes2.dex */
public class Detecter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile c f7851a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile DetecterState f7852b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile Handler f7853c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile Semaphore f7854d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ExecutorService f7855e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile boolean f7856f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f7857g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f7858h;

    private static final enum DetecterState extends Enum<DetecterState> {
        private static final /* synthetic */ DetecterState[] $VALUES = null;
        public static final DetecterState DETECTER_INIT = null;
        public static final DetecterState DETECTER_SMOOTH = null;
        public static final DetecterState DETECTER_STUCK = null;

        static {
            DetecterState r10 = new DetecterState("DETECTER_INIT", 0);
            DETECTER_INIT = r10;
            DetecterState r11 = new DetecterState("DETECTER_STUCK", 1);
            DETECTER_STUCK = r11;
            DetecterState r12 = new DetecterState("DETECTER_SMOOTH", 2);
            DETECTER_SMOOTH = r12;
            $VALUES = new DetecterState[]{r10, r11, r12};
        }

        private DetecterState(String r10, int r11) {
            super(r10, r11);
        }

        public static DetecterState valueOf(String r10) {
            return (DetecterState) Enum.valueOf(DetecterState.class, r10);
        }

        public static DetecterState[] values() {
            return (DetecterState[]) $VALUES.clone();
        }
    }

    class a implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Detecter f7859c;

        /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.cleaner.Detecter$a$a, reason: collision with other inner class name */
        class RunnableC0139a implements Runnable {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ a f7860c;

            RunnableC0139a(a r10) {
                this.f7860c = r10;
            }

            @Override // java.lang.Runnable
            public void run() {
                Detecter.a(this.f7860c.f7859c).release();
            }
        }

        a(Detecter r10) {
            this.f7859c = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
        L2:
            Detecter.b(this.f7859c).post(new RunnableC0139a(this));
            long r10 = System.currentTimeMillis();
            Detecter.a(this.f7859c).acquire();     // Catch: InterruptedException -> L5
        L8:
            if (Detecter.c(this.f7859c) == true) goto L9;
            long r11 = System.currentTimeMillis();
            Detecter.e(this.f7859c, r10, r11);
            Thread.sleep(500);     // Catch: InterruptedException -> L14
            goto L2
        L9:
            Detecter.d(this.f7859c, false);
            return;
        L5:
            e = move-exception;
            e.printStackTrace();
            goto L8
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ DetecterState f7861c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ Detecter f7862g;

        b(Detecter r10, DetecterState r11) {
            this.f7862g = r10;
            this.f7861c = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            DetecterState r10 = DetecterState.DETECTER_STUCK;     // Catch: Exception -> L20
            DetecterState r11 = this.f7861c;     // Catch: Exception -> L20
            if (r10 != r11) goto L12;
            if (lb.a.a() == false) goto L9;
            lb.a.b("Detecter", "transToNewState", "transToNewState to stuck");     // Catch: Exception -> L20
        L9:
            if (Detecter.f(this.f7862g) == null) goto L24;
            Detecter.f(this.f7862g).b();     // Catch: Exception -> L20
            return;
        L24:
            return;
        L12:
            if (DetecterState.DETECTER_SMOOTH == r11) goto L14;
            return;
        L14:
            if (lb.a.a() == false) goto L17;
            lb.a.b("Detecter", "transToNewState", "transToNewState to smooth");     // Catch: Exception -> L20
        L17:
            if (Detecter.f(this.f7862g) == null) goto L27;
            Detecter.f(this.f7862g).a();     // Catch: Exception -> L20
            return;
        L27:
            return;
        L20:
            e = move-exception;
            e.printStackTrace();
        }
    }

    interface c {
        void a();

        void b();
    }

    public Detecter(c r10) {
        this.f7852b = DetecterState.DETECTER_INIT;
        this.f7853c = new Handler(Looper.getMainLooper());
        this.f7854d = new Semaphore(0);
        this.f7855e = Executors.newCachedThreadPool();
        this.f7856f = false;
        this.f7857g = 0;
        this.f7858h = 0;
        this.f7851a = r10;
    }

    static /* synthetic */ Semaphore a(Detecter r10) {
        return r10.f7854d;
    }

    static /* synthetic */ Handler b(Detecter r10) {
        return r10.f7853c;
    }

    static /* synthetic */ boolean c(Detecter r10) {
        return r10.f7856f;
    }

    static /* synthetic */ boolean d(Detecter r10, boolean r11) {
        r10.f7856f = r11;
        return r11;
    }

    static /* synthetic */ void e(Detecter r10, long r11, long r12) {
        r10.g(r11, r12);
    }

    static /* synthetic */ c f(Detecter r10) {
        return r10.f7851a;
    }

    private void g(long r10, long r11) {
        long r12 = r11 - r10;
        if (lb.a.a() == false) goto L5;
        lb.a.b("Detecter", "CheckStuck", "ping main thread duration=" + r12);
    L5:
        m(r12);
    }

    private void m(long r10) {
        if (r10 < 200) goto L12;
        if (lb.a.a() == false) goto L7;
        lb.a.b("Detecter", "tryUpdateState", ">200ms enter real stuck");
    L7:
        this.f7857g = 0;
        if (i() == false) goto L10;
        return;
    L10:
        this.f7858h = 0;
        l(DetecterState.DETECTER_STUCK);
        return;
    L12:
        if (r10 >= 50) goto L14;
        this.f7858h = 0;
        if (h() == false) goto L25;
        return;
    L25:
        int r11 = this.f7857g;
        if (r11 != 15) goto L29;
        l(DetecterState.DETECTER_SMOOTH);
        r11 = this.f7857g;
    L28:
        this.f7857g = r11 + 1;
        return;
    L29:
        if (r11 < 15) goto L28;
        return;
    L14:
        if (lb.a.a() == false) goto L16;
        lb.a.b("Detecter", "tryUpdateState", "50ms<=duration<=200ms enter maybe stuck");
    L16:
        this.f7857g = 0;
        if (i() == false) goto L19;
        return;
    L19:
        int r12 = this.f7858h + 1;
        this.f7858h = r12;
        if (r12 >= 3) goto L10;
    }

    boolean h() {
        if (DetecterState.DETECTER_SMOOTH != this.f7852b) goto L5;
        return true;
    L5:
        return false;
    }

    boolean i() {
        if (DetecterState.DETECTER_STUCK != this.f7852b) goto L5;
        return true;
    L5:
        return false;
    }

    public void j() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.f7852b != DetecterState.DETECTER_INIT) goto L9;
        this.f7852b = DetecterState.DETECTER_SMOOTH;     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L11
        this.f7855e.execute(new a(this));
        return;
    L9:
        monitor-exit(this);     // Catch: Throwable -> L11
    }

    public void k() {
        this.f7856f = true;
        this.f7851a = null;
        this.f7854d.release();
    }

    void l(DetecterState r10) {
        this.f7852b = r10;
        this.f7855e.execute(new b(this, r10));
    }
}
