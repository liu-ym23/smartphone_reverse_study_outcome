package io.reactivex.internal.operators.completable;

import java.util.concurrent.atomic.AtomicBoolean;
import xb.b;

/* JADX INFO: loaded from: classes2.dex */
public final class CompletableCache extends xb.a implements b {

    final class InnerCompletableCache extends AtomicBoolean implements io.reactivex.disposables.b {
        private static final long serialVersionUID = 8943152917179642732L;
        final b downstream;
        final /* synthetic */ CompletableCache this$0;

        InnerCompletableCache(CompletableCache r10, b r11) {
            this.downstream = r11;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (compareAndSet(false, true) == true) goto L6;
            return;
        L6:
            throw null;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return get();
        }
    }
}
