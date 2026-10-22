package io.reactivex.internal.schedulers;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.TimeUnit;
import mt.y;
import mt.z;

/* JADX INFO: loaded from: classes3.dex */
public final class s extends z {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final s f18160b = null;

    static {
        f18160b = new s();
    }

    @Override // mt.z
    public final y a() {
        return new r();
    }

    @Override // mt.z
    public final Disposable c(Runnable r5) {
        r5.run();
        return EmptyDisposable.INSTANCE;
    }

    @Override // mt.z
    public final Disposable d(Runnable r5, long r10, TimeUnit r11) {
        r11.sleep(r10);     // Catch: InterruptedException -> L4
        r5.run();     // Catch: InterruptedException -> L4
    L7:
        return EmptyDisposable.INSTANCE;
    L4:
        e = move-exception;
        Thread.currentThread().interrupt();
        wn.f.k(e);
        goto L7
    }
}
