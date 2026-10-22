package g0;

import android.os.Handler;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final class o<T> implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Callable<T> f7536a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i0.a<T> f7537b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Handler f7538m;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i0.a f7539a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f7540b;

        public a(i0.a r8, Object r10) {
            this.f7539a = r8;
            this.f7540b = r10;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public final void run() {
            this.f7539a.accept(this.f7540b);
        }
    }

    public o(Handler r8, i r10, j r11) {
        this.f7536a = r10;
        this.f7537b = r11;
        this.f7538m = r8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        T r8 = this.f7536a.call();     // Catch: Exception -> L4
    L5:
        a r10 = new a(this.f7537b, r8);
        this.f7538m.post(r10);
        return;
    L4:
        r8 = null;
        goto L5
    }
}
