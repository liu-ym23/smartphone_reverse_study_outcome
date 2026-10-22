package d41;

import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f {
    public Disposable a;
    public final g b;

    public static final class a implements Runnable {
        public final /* synthetic */ f a;

        public a(f r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L14;
            throw th;
        L14:
            return;
        L3:
            if (this.a.b.c() == false) goto L10;
            this.a.b.b();     // Catch: Throwable -> L7
            return;
        }
    }

    public final void a() {
        Disposable r0 = this.a;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.a = null;
    }

    public final void b() {
        if (this.b.c() == true) goto L5;
        return;
    L5:
        a r0 = new a(this);
        Disposable r1 = this.a;
        if (r1 == null) goto L8;
        r1.dispose();
    L8:
        d51.c r2 = d51.c.A0;
        r2.getClass();
        this.a = Observable.timer(((Number) d51.c.k.getValue(r2, d51.c.a[9])).longValue(), TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(this, r0));
    }

    public f(g r2) {
        Intrinsics.checkNotNullParameter(r2, "machine");
        this.b = r2;
    }
}
