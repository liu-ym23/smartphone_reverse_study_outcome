package mt;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public abstract class y implements Disposable {
    public Disposable a(Runnable r5) {
        return b(r5, 0, TimeUnit.NANOSECONDS);
    }

    public abstract Disposable b(Runnable r5, long r10, TimeUnit r11);

    public final Disposable c(Runnable r17, long r18, long r20, TimeUnit r22) {
        SequentialDisposable r5 = new SequentialDisposable();
        SequentialDisposable r14 = new SequentialDisposable(r5);
        long r12 = r22.toNanos(r20);
        long r10 = TimeUnit.NANOSECONDS.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        Disposable r11 = b(new x(this, r22.toNanos(r18) + r10, r17, r10, r14, r12), r18, r22);
        if (r11 != EmptyDisposable.INSTANCE) goto L5;
        return r11;
    L5:
        r5.replace(r11);
        return r14;
    }
}
