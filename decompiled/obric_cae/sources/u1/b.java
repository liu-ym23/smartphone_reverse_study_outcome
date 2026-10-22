package u1;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import s1.p;

/* JADX INFO: loaded from: classes.dex */
public final class b implements u1.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p f12420a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f12421b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f12422c;

    public class a implements Executor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f12423a;

        public a(b r8) {
            this.f12423a = r8;
        }

        @Override // java.util.concurrent.Executor
        public final void execute(Runnable r8) {
            this.f12423a.f12421b.post(r8);
        }
    }

    public b(ExecutorService r8) {
        this.f12421b = new Handler(Looper.getMainLooper());
        this.f12422c = new a(this);
        this.f12420a = new p(r8);
    }

    public final a b() {
        return this.f12422c;
    }

    public final p c() {
        return this.f12420a;
    }
}
