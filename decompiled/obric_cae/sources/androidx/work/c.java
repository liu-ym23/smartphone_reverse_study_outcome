package androidx.work;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ExecutorService f2796a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ExecutorService f2797b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final x f2798c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final k f2799d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b9.a f2800e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f2801f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f2802g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f2803h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f2804i;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f2805a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f2806b;

        public a() {
            this.f2806b = 4;
        }
    }

    public interface b {
        c a();
    }

    public c(a r8) {
        this.f2796a = a(false);
        this.f2797b = a(true);
        String r10 = y.f2966a;
        this.f2798c = new x();
        this.f2799d = new k();
        this.f2800e = new b9.a(1);
        this.f2802g = r8.f2806b;
        this.f2803h = Integer.MAX_VALUE;
        this.f2804i = 20;
        this.f2801f = r8.f2805a;
    }

    public static ExecutorService a(boolean r8) {
        return Executors.newFixedThreadPool(Math.max(2, Math.min(Runtime.getRuntime().availableProcessors() - 1, 4)), new androidx.work.b(r8));
    }
}
