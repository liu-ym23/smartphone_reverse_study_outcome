package u6;

import android.net.TrafficStats;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.bytedance.common.utility.Logger;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static long f12488f = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u6.a f12489a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicInteger f12490b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f12491c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f12492d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f12493e;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f12494a = null;

        static {
            f12494a = new c(u6.a.C0171a.f12481a);
        }
    }

    public class b extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f12495a;

        public b(c r8, Looper r10) {
            this.f12495a = r8;
            super(r10);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message r8) {
        L7:
            th = move-exception;
            th.printStackTrace();
            return;
        L3:
            if (r8.what != 1) goto L12;
            this.f12495a.a();     // Catch: Throwable -> L7
            sendEmptyMessageDelayed(1, 1000);     // Catch: Throwable -> L7
            return;
        }
    }

    public c(u6.a r8) {
        this.f12492d = false;
        this.f12489a = r8;
        this.f12490b = new AtomicInteger();     // Catch: Throwable -> L5
        HandlerThread r10 = i8.a.a();     // Catch: Throwable -> L5
        r10.start();     // Catch: Throwable -> L5
        this.f12491c = new b(this, r10.getLooper());     // Catch: Throwable -> L5
        return;
    L5:
        this.f12492d = true;
    }

    public final void a() {
        long r8 = TrafficStats.getTotalRxBytes();     // Catch: Throwable -> L13
        long r10 = f12488f;     // Catch: Throwable -> L13
        long r11 = r8 - r10;     // Catch: Throwable -> L13
        if (r10 < 0) goto L11;
        monitor-enter(this);     // Catch: Throwable -> L13
        long r12 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L8
        this.f12489a.a(r11, r12 - this.f12493e);     // Catch: Throwable -> L8
        this.f12493e = r12;     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L11:
        f12488f = r8;     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        th.printStackTrace();
    }

    public final void b() {
        if (this.f12492d == false) goto L6;
        return;
    L6:
        if (this.f12490b.getAndIncrement() == 0) goto L8;
        return;
    L8:
        if (Logger.debug() == false) goto L10;
        Logger.d("ConnectionClassManager", "startSampling");     // Catch: Throwable -> L12
    L10:
        this.f12491c.sendEmptyMessage(1);     // Catch: Throwable -> L12
        this.f12493e = SystemClock.elapsedRealtime();     // Catch: Throwable -> L12
        return;
    }

    public final void c() {
        if (this.f12492d == false) goto L6;
        return;
    L6:
        if (this.f12490b.decrementAndGet() == 0) goto L8;
        return;
    L8:
        if (Logger.debug() == false) goto L10;
        Logger.d("ConnectionClassManager", "stopSampling");     // Catch: Throwable -> L12
    L10:
        this.f12491c.removeMessages(1);     // Catch: Throwable -> L12
        a();     // Catch: Throwable -> L12
        f12488f = -1;     // Catch: Throwable -> L12
        return;
    }
}
