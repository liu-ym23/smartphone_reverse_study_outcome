package i84;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.bdinstall.e0;
import com.bytedance.bdinstall.i;
import com.bytedance.bdinstall.n0;
import com.bytedance.bdinstall.o0;
import com.bytedance.bdinstall.t0;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class w implements e0 {
    public final long a;
    public t0 b;
    public final Handler c;
    public final o0 d;

    public class a implements Runnable {
        public final /* synthetic */ n0 a;
        public final /* synthetic */ w b;

        @Override // java.lang.Runnable
        public final void run() {
            t0 r0 = this.b.b;     // Catch: Throwable -> L7
            if (r0 == null) goto L5;
            r0.a(this.a);     // Catch: Throwable -> L7
            w.b(this.b);     // Catch: Throwable -> L7
        L5:
            this.b.b = null;     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L11;
            return;
        L11:
            throw th;
        }

        public a(w r1, n0 r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public static void b(w r2) {
        o0 r0 = r2.d;
        if (r0 != null) goto L5;
    L8:
        i.b.k.c(r2);
        return;
    L5:
        if (r0.O == true) goto L8;
        String r1 = String.valueOf(r0.a);
        j74.a r3 = i.a;
        com.bytedance.bdinstall.k.k(r1).k.c(r2);
    }

    public final void a(n0 r3) {
        this.c.post(new a(this, r3));
    }

    public w(long r3, t0 r5, o0 r6) {
        this.c = new Handler(Looper.getMainLooper());
        this.a = r3;
        this.b = r5;
        this.d = r6;
    }
}
