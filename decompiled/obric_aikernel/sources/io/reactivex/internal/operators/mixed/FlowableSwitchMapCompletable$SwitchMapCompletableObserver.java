package io.reactivex.internal.operators.mixed;

import io.reactivex.disposables.b;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import xb.g;

/* JADX INFO: loaded from: classes2.dex */
final class FlowableSwitchMapCompletable$SwitchMapCompletableObserver<T> implements g<T>, b {

    static final class SwitchMapInnerObserver extends AtomicReference<b> implements xb.b {
        private static final long serialVersionUID = -8003404460084760287L;
        final FlowableSwitchMapCompletable$SwitchMapCompletableObserver<?> parent;

        SwitchMapInnerObserver(FlowableSwitchMapCompletable$SwitchMapCompletableObserver<?> r10) {
        }

        void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // xb.b
        public void onComplete() {
            throw null;
        }

        @Override // xb.b
        public void onError(Throwable r10) {
            throw null;
        }

        @Override // xb.b
        public void onSubscribe(b r10) {
            DisposableHelper.setOnce(this, r10);
        }
    }
}
