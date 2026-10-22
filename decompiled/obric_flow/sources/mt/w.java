package mt;

import android.os.Handler;
import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: classes3.dex */
public final class w implements Disposable, Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f20175a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Runnable f20176b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f20177c;
    public final Object d;

    public w(Handler r5, Runnable r10) {
        this.f20175a = 1;
        this.d = r5;
        this.f20176b = r10;
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        switch(this.f20175a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        ((Handler) this.d).removeCallbacks(this);
        this.f20177c = true;
        return;
    L6:
        this.f20177c = true;
        ((y) this.d).dispose();
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        switch(this.f20175a) {
            case 0: goto L7;
            default: goto L5;
        };
    L5:
        return this.f20177c;
    L7:
        return this.f20177c;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch(this.f20175a) {
            case 0: goto L10;
            default: goto L19;
        };
    L19:
        this.f20176b.run();     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        wn.f.k(th);
        return;
    L10:
        if (this.f20177c == false) goto L17;
        return;
    L17:
        this.f20176b.run();     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        ((y) this.d).dispose();
        throw io.reactivex.internal.util.d.d(th);
    }

    public w(Runnable r5, y r10) {
        this.f20175a = 0;
        this.f20176b = r5;
        this.d = r10;
    }
}
