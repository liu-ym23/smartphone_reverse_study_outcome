package r1;

import com.bytedance.common.utility.Logger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class c implements Runnable {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static ExecutorService f12585g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static ExecutorService f12586h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected static final AtomicInteger f12587i = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f12588c;

    class a implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ c f12589c;

        a(c r10) {
            this.f12589c = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            Logger.d("ThreadPlus", "thread count: " + c.f12587i.incrementAndGet());
            this.f12589c.run();     // Catch: Exception -> L5
        L7:
            Logger.d("ThreadPlus", "thread count: " + c.f12587i.decrementAndGet());
            return;
        L5:
            e = move-exception;
            Logger.w("ThreadPlus", "Thread crashed!", e);
            goto L7
        }
    }

    static {
        f12585g = r1.a.a();
        f12586h = r1.a.a();
        f12587i = new AtomicInteger();
    }

    public c(String r10) {
        this(false);
    }

    public c(boolean r10) {
        this.f12588c = r10;
    }

    public static void b(Runnable r10) {
        if (r10 == null) goto L5;
        f12585g.submit(r10);
        return;
    }

    public void a() {
        if (Logger.debug() == false) goto L5;
        Runnable r10 = new a(this);
    L7:
        if (this.f12588c == false) goto L9;
        ExecutorService r11 = f12586h;
    L10:
        r11.submit(r10);
        return;
    L9:
        r11 = f12585g;
        goto L10
    L5:
        r10 = this;
        goto L7
    }

    @Override // java.lang.Runnable
    public void run() {
        throw null;
    }
}
