package k5;

import android.os.Handler;
import android.os.Looper;
import x4.a0;
import x4.i0;
import x4.j0;

/* JADX INFO: loaded from: classes.dex */
public final class o implements a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f8954a;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ o f8955a;

        public a(o r8, i0 r10) {
            this.f8955a = r8;
        }

        @Override // java.lang.Runnable
        public final void run() {
            o r8 = this.f8955a;
            r8.getClass();
            r8.getClass();
        }
    }

    public o(j0 r8) {
        this.f8954a = new Handler(Looper.getMainLooper());
    }

    @Override // x4.a0
    public final void a(i0 r8) {
        this.f8954a.post(new a(this, r8));
    }
}
