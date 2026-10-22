package io.reactivex.observers;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.d;
import io.reactivex.t;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public abstract class a<T> implements io.reactivex.disposables.b, t<T> {
    final AtomicReference<io.reactivex.disposables.b> c;

    public a() {
        this.c = new AtomicReference();
    }

    public void a() {
    }

    @Override // io.reactivex.disposables.b
    public final void dispose() {
        DisposableHelper.dispose(this.c);
    }

    @Override // io.reactivex.disposables.b
    public final boolean isDisposed() {
        if (this.c.get() != DisposableHelper.DISPOSED) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // io.reactivex.t
    public final void onSubscribe(io.reactivex.disposables.b r3) {
        io.reactivex.disposables.b r4 = (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
        if (d.a(this.c, r4, getClass()) == false) goto L6;
        a();
        return;
    }
}
