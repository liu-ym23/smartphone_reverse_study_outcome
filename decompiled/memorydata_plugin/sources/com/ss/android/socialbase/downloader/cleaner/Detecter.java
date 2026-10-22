package com.ss.android.socialbase.downloader.cleaner;

import android.os.Handler;
import android.os.Looper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/* JADX INFO: loaded from: classes6.dex */
public class Detecter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile a f15334a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile DetecterState f15335b;
    private volatile Handler c;
    private volatile Semaphore d;
    private ExecutorService e;
    private volatile boolean f;
    private int g;
    private int h;

    private static final enum DetecterState extends Enum<DetecterState> {
        private static final /* synthetic */ DetecterState[] $VALUES = null;
        public static final DetecterState DETECTER_INIT = null;
        public static final DetecterState DETECTER_SMOOTH = null;
        public static final DetecterState DETECTER_STUCK = null;

        static {
            DetecterState r0 = new DetecterState("DETECTER_INIT", 0);
            DETECTER_INIT = r0;
            DetecterState r1 = new DetecterState("DETECTER_STUCK", 1);
            DETECTER_STUCK = r1;
            DetecterState r3 = new DetecterState("DETECTER_SMOOTH", 2);
            DETECTER_SMOOTH = r3;
            $VALUES = new DetecterState[]{r0, r1, r3};
        }

        private DetecterState(String r1, int r2) {
            super(r1, r2);
        }

        public static DetecterState valueOf(String r2) {
            return (DetecterState) ZeusTransformUtils.preCheckCast(Enum.valueOf(DetecterState.class, r2), DetecterState.class, "com.obric.memorydata.plugin");
        }

        public static DetecterState[] values() {
            return (DetecterState[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), DetecterState[].class, "com.obric.memorydata.plugin");
        }
    }

    interface a {
        void a();

        void b();
    }

    public Detecter(a r3) {
        a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin");
        this.f15335b = DetecterState.DETECTER_INIT;
        this.c = new Handler(Looper.getMainLooper());
        this.d = new Semaphore(0);
        this.e = Executors.newCachedThreadPool();
        this.f = false;
        this.g = 0;
        this.h = 0;
        this.f15334a = r4;
    }

    static /* synthetic */ Semaphore a(Detecter r0) {
        return r0.d;
    }

    private void a(long r7) {
        if (r7 < 200) goto L12;
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L7;
        com.ss.android.socialbase.downloader.e.a.a("Detecter", "tryUpdateState", ">200ms enter real stuck");
    L7:
        this.g = 0;
        if (c() == false) goto L10;
        return;
    L10:
        this.h = 0;
        a(DetecterState.DETECTER_STUCK);
        return;
    L12:
        if (r7 >= 50) goto L14;
        this.h = 0;
        if (d() == false) goto L25;
        return;
    L25:
        int r8 = this.g;
        if (r8 != 15) goto L29;
        a(DetecterState.DETECTER_SMOOTH);
        r8 = this.g;
    L28:
        this.g = r8 + 1;
        return;
    L29:
        if (r8 < 15) goto L28;
        return;
    L14:
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L16;
        com.ss.android.socialbase.downloader.e.a.a("Detecter", "tryUpdateState", "50ms<=duration<=200ms enter maybe stuck");
    L16:
        this.g = 0;
        if (c() == false) goto L19;
        return;
    L19:
        int r9 = this.h + 1;
        this.h = r9;
        if (r9 >= 3) goto L10;
    }

    private void a(long r2, long r4) {
        long r5 = r4 - r2;
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L5;
        com.ss.android.socialbase.downloader.e.a.a("Detecter", "CheckStuck", "ping main thread duration=" + r5);
    L5:
        a(r5);
    }

    static /* synthetic */ void a(Detecter r0, long r1, long r3) {
        r0.a(r1, r3);
    }

    static /* synthetic */ boolean a(Detecter r0, boolean r1) {
        r0.f = r1;
        return r1;
    }

    static /* synthetic */ Handler b(Detecter r0) {
        return r0.c;
    }

    static /* synthetic */ boolean c(Detecter r0) {
        return r0.f;
    }

    static /* synthetic */ a d(Detecter r0) {
        return r0.f15334a;
    }

    public void a() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.f15335b != DetecterState.DETECTER_INIT) goto L9;
        this.f15335b = DetecterState.DETECTER_SMOOTH;     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L11
        this.e.execute(new AnonymousClass1(this));
        return;
    L9:
        monitor-exit(this);     // Catch: Throwable -> L11
    }

    void a(final DetecterState r3) {
        this.f15335b = r3;
        this.e.execute(new AnonymousClass2(this, r3));
    }

    public void b() {
        this.f = true;
        this.f15334a = null;
        this.d.release();
    }

    boolean c() {
        if (DetecterState.DETECTER_STUCK != this.f15335b) goto L5;
        return true;
    L5:
        return false;
    }

    boolean d() {
        if (DetecterState.DETECTER_SMOOTH != this.f15335b) goto L5;
        return true;
    L5:
        return false;
    }
}
