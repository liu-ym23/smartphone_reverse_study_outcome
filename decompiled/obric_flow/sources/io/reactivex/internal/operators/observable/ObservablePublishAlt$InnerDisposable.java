package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
final class ObservablePublishAlt$InnerDisposable<T> extends AtomicReference<ObservablePublishAlt$PublishConnection<T>> implements Disposable {
    private static final long serialVersionUID = 7463222674719692880L;
    final mt.u downstream;

    public ObservablePublishAlt$InnerDisposable(mt.u r5, ObservablePublishAlt$PublishConnection<T> r10) {
        this.downstream = r5;
        lazySet(r10);
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        ObservablePublishAlt$PublishConnection<T> r5 = getAndSet(null);
        if (r5 == null) goto L6;
        r5.remove(this);
        return;
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        if (get() != null) goto L5;
        return true;
    L5:
        return false;
    }
}
