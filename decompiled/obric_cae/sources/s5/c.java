package s5;

import com.bytedance.common.utility.Logger;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class c implements Runnable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f12034b = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final b f12035m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final AtomicInteger f12036n = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f12037a;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f12038a;

        public a(c r8) {
            this.f12038a = r8;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Logger.d("ThreadPlus", "thread count: " + c.f12036n.incrementAndGet());
            this.f12038a.run();     // Catch: Exception -> L5
        L7:
            Logger.d("ThreadPlus", "thread count: " + c.f12036n.decrementAndGet());
            return;
        L5:
            e = move-exception;
            Logger.w("ThreadPlus", "Thread crashed!", e);
            goto L7
        }
    }

    static {
        b r8 = s5.a.f12023a;
        f12034b = r8;
        f12035m = r8;
        f12036n = new AtomicInteger();
    }

    public c(int r8) {
        this.f12037a = false;
    }

    public final void a() {
        if (Logger.debug() == false) goto L5;
        Runnable r8 = new a(this);
    L7:
        if (this.f12037a == false) goto L9;
        b r10 = f12035m;
    L10:
        r10.submit(r8);
        return;
    L9:
        r10 = f12034b;
        goto L10
    L5:
        r8 = this;
        goto L7
    }

    @Override // java.lang.Runnable
    public void run() {
        throw null;
    }
}
