package mt;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public abstract class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f20181a = 0;

    static {
        f20181a = TimeUnit.MINUTES.toNanos(Long.getLong("rx2.scheduler.drift-tolerance", 15).longValue());
    }

    public abstract y a();

    public final long b(TimeUnit r5) {
        return r5.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    public Disposable c(Runnable r5) {
        return d(r5, 0, TimeUnit.NANOSECONDS);
    }

    public Disposable d(Runnable r5, long r10, TimeUnit r11) {
        y r12 = a();
        v r13 = new v(r5, r12);
        r12.b(r13, r10, r11);
        return r13;
    }

    public Disposable e(Runnable r10, long r11, long r12, TimeUnit r13) {
        y r5 = a();
        w r14 = new w(r10, r5);
        Disposable r15 = r5.c(r14, r11, r12, r13);
        if (r15 != EmptyDisposable.INSTANCE) goto L5;
        return r15;
    L5:
        return r14;
    }
}
