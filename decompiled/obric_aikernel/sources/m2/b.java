package m2;

import android.net.TrafficStats;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.bytedance.common.utility.Logger;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static long f11011g = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final m2.a f11012a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private AtomicInteger f11013b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private HandlerC0240b f11014c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private HandlerThread f11015d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f11016e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f11017f;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f11018a = null;

        static {
            f11018a = new b(m2.a.c());
        }
    }

    /* JADX INFO: renamed from: m2.b$b, reason: collision with other inner class name */
    private class HandlerC0240b extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f11019a;

        public HandlerC0240b(b r10, Looper r11) {
            this.f11019a = r10;
            super(r11);
        }

        public void a() {
            sendEmptyMessage(1);
        }

        public void b() {
            removeMessages(1);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r10) {
        L7:
            th = move-exception;
            th.printStackTrace();
            return;
        L3:
            if (r10.what != 1) goto L12;
            this.f11019a.b();     // Catch: Throwable -> L7
            sendEmptyMessageDelayed(1, 1000);     // Catch: Throwable -> L7
            return;
        }
    }

    static {
    }

    protected b(m2.a r10) {
        this.f11016e = false;
        this.f11012a = r10;
        this.f11013b = new AtomicInteger();     // Catch: Throwable -> L5
        HandlerThread r11 = f3.a.a("ParseThread");     // Catch: Throwable -> L5
        this.f11015d = r11;     // Catch: Throwable -> L5
        r11.start();     // Catch: Throwable -> L5
        this.f11014c = new HandlerC0240b(this, this.f11015d.getLooper());     // Catch: Throwable -> L5
        return;
    L5:
        this.f11016e = true;
    }

    public static b c() {
        return a.f11018a;
    }

    protected void a() {
        b();
        f11011g = -1;
    }

    protected void b() {
        long r10 = TrafficStats.getTotalRxBytes();     // Catch: Throwable -> L13
        long r11 = f11011g;     // Catch: Throwable -> L13
        long r12 = r10 - r11;     // Catch: Throwable -> L13
        if (r11 < 0) goto L11;
        monitor-enter(this);     // Catch: Throwable -> L13
        long r13 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L8
        this.f11012a.a(r12, r13 - this.f11017f);     // Catch: Throwable -> L8
        this.f11017f = r13;     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L11:
        f11011g = r10;     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        th.printStackTrace();
    }

    public void d() {
        if (this.f11016e == false) goto L6;
        return;
    L6:
        if (this.f11013b.getAndIncrement() == 0) goto L8;
        return;
    L8:
        if (Logger.debug() == false) goto L10;
        Logger.d("ConnectionClassManager", "startSampling");     // Catch: Throwable -> L12
    L10:
        this.f11014c.a();     // Catch: Throwable -> L12
        this.f11017f = SystemClock.elapsedRealtime();     // Catch: Throwable -> L12
        return;
    }

    public void e() {
        if (this.f11016e == false) goto L6;
        return;
    L6:
        if (this.f11013b.decrementAndGet() == 0) goto L8;
        return;
    L8:
        if (Logger.debug() == false) goto L10;
        Logger.d("ConnectionClassManager", "stopSampling");     // Catch: Throwable -> L12
    L10:
        this.f11014c.b();     // Catch: Throwable -> L12
        a();     // Catch: Throwable -> L12
        return;
    }
}
