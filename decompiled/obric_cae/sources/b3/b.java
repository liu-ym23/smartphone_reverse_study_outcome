package b3;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile ExecutorService f3033a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c8.d f3034b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f3035c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CopyOnWriteArraySet<c> f3036d;

    public class a implements c8.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f3037a;

        public a(b r8) {
            this.f3037a = r8;
        }

        @Override // c8.g
        public final c8.e A() {
            return c8.e.f3420m;
        }

        @Override // java.lang.Runnable
        public final void run() {
            b r8 = this.f3037a;
            Iterator<c> r10 = r8.f3036d.iterator();
        L4:
            if (r10.hasNext() == false) goto L6;
            r10.next().a(System.currentTimeMillis());
            goto L4
        L6:
            r8.d(this);
        }
    }

    /* JADX INFO: renamed from: b3.b$b, reason: collision with other inner class name */
    public static final class C0032b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f3038a = null;

        static {
            f3038a = new b();
        }
    }

    public interface c {
        void a(long r8);
    }

    public b() {
        this.f3035c = new a(this);
        this.f3036d = new CopyOnWriteArraySet();
        new CopyOnWriteArraySet();
        Object r8 = c8.d.f3410e;
        this.f3034b = c8.d.a.f3417a;
    }

    public static c8.f e(Runnable r8, String r10) {
        String r11 = "AsyncEventManager-".concat(r10);
        c8.e r12 = c8.e.f3418a;
        return new c8.f(r8, r11);
    }

    public final void a(c r8) {
        if (r8 == null) goto L17;
        CopyOnWriteArraySet<c> r10 = this.f3036d;
        if (r10.contains(r8) == true) goto L18;
        r10.add(r8);     // Catch: Throwable -> L14
        c8.d r11 = this.f3034b;     // Catch: Throwable -> L14
        a r12 = this.f3035c;
        if (r11 == null) goto L12;
        if (r12 == null) goto L12;
        r11.g(r12);     // Catch: Throwable -> L14
    L12:
        d(r12);     // Catch: Throwable -> L14
        return;
    L18:
        return;
    L19:
        return;
    }

    public final boolean b() {
        c8.d r8 = this.f3034b;
        if (r8 == null) goto L11;
        long r10 = Thread.currentThread().getId();
        c8.e r11 = c8.e.f3420m;
        Long r12 = (Long) r8.f3416d.get(r11);
        if (r12 == null) goto L7;
        long r13 = r12.longValue();
    L9:
        if (r10 != r13) goto L11;
        return true;
    L7:
        r13 = -1;
    L11:
        return false;
    }

    public final void c(Runnable r8) {
        c8.d r10 = this.f3034b;
        if (r10 == null) goto L7;
        if (r8 == null) goto L8;
        r10.e(e(r8, "post"));
        return;
    L8:
        return;
    }

    public final void d(c8.g r8) {
        c8.d r10 = this.f3034b;
        if (r10 == null) goto L7;
        if (r8 == null) goto L8;
        r10.f(r8, 30000);
        return;
    L8:
        return;
    }
}
