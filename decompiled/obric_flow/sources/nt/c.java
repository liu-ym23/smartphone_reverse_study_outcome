package nt;

import android.os.Handler;
import android.os.Message;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.TimeUnit;
import mt.w;
import mt.y;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f20309a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f20310b;

    public c(Handler r5) {
        this.f20309a = r5;
    }

    @Override // mt.y
    public final Disposable b(Runnable r5, long r10, TimeUnit r11) {
        if (r11 == null) goto L13;
        if (this.f20310b == true) goto L6;
        Handler r12 = this.f20309a;
        w r13 = new w(r12, r5);
        Message r14 = Message.obtain(r12, r13);
        r14.obj = this;
        this.f20309a.sendMessageDelayed(r14, r11.toMillis(r10));
        if (this.f20310b == false) goto L11;
        this.f20309a.removeCallbacks(r13);
        return EmptyDisposable.INSTANCE;
    L11:
        return r13;
    L6:
        return EmptyDisposable.INSTANCE;
    L13:
        throw new NullPointerException("unit == null");
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        this.f20310b = true;
        this.f20309a.removeCallbacksAndMessages(this);
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        return this.f20310b;
    }
}
