package io.reactivex.internal.operators.maybe;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.b.f;
import io.reactivex.internal.disposables.CancellableDisposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.k;
import io.reactivex.l;
import io.reactivex.m;
import io.reactivex.n;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class MaybeCreate<T> extends k<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final n<T> f16820a;

    static final class Emitter<T> extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b, l<T> {
        private static final long serialVersionUID = -2467358622224974244L;
        final m<? super T> downstream;

        Emitter(m<? super T> r3) {
            this.downstream = (m) ZeusTransformUtils.wrapperContextForParams(r3, m.class, "com.obric.memorydata.plugin");
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed((io.reactivex.disposables.b) ZeusTransformUtils.preCheckCast(get(), io.reactivex.disposables.b.class, "com.obric.memorydata.plugin"));
        }

        public void onComplete() {
            if (get() == DisposableHelper.DISPOSED) goto L13;
            io.reactivex.disposables.b r0 = (io.reactivex.disposables.b) ZeusTransformUtils.preCheckCast(getAndSet(DisposableHelper.DISPOSED), io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
            if (r0 == DisposableHelper.DISPOSED) goto L16;
            this.downstream.onComplete();     // Catch: Throwable -> L9
            if (r0 == null) goto L17;
            r0.dispose();
            return;
        L17:
            return;
        L9:
            th = move-exception;
            if (r0 == null) goto L12;
            r0.dispose();
        L12:
            throw th;
        L16:
            return;
        }

        public void onError(Throwable r1) {
            if (tryOnError(r1) == true) goto L6;
            io.reactivex.d.a.a(r1);
            return;
        }

        @Override // io.reactivex.l
        public void onSuccess(T r4) {
            if (get() == DisposableHelper.DISPOSED) goto L15;
            io.reactivex.disposables.b r0 = (io.reactivex.disposables.b) ZeusTransformUtils.preCheckCast(getAndSet(DisposableHelper.DISPOSED), io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
            if (r0 == DisposableHelper.DISPOSED) goto L18;
            if (r4 != null) goto L8;
            this.downstream.onError(new NullPointerException("onSuccess called with null. Null values are generally not allowed in 2.x operators and sources."));     // Catch: Throwable -> L11
        L9:
            if (r0 == null) goto L19;
            r0.dispose();
            return;
        L19:
            return;
        L8:
            this.downstream.onSuccess(r4);     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            if (r0 == null) goto L14;
            r0.dispose();
        L14:
            throw th;
        L18:
            return;
        }

        public void setCancellable(f r3) {
            setDisposable(new CancellableDisposable((f) ZeusTransformUtils.wrapperContextForParams(r3, f.class, "com.obric.memorydata.plugin")));
        }

        public void setDisposable(io.reactivex.disposables.b r3) {
            DisposableHelper.set(this, (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin"));
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public String toString() {
            return String.format("%s{%s}", new Object[]{getClass().getSimpleName(), super.toString()});
        }

        public boolean tryOnError(Throwable r4) {
            if (r4 != null) goto L5;
            r4 = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        L5:
            if (get() == DisposableHelper.DISPOSED) goto L17;
            io.reactivex.disposables.b r0 = (io.reactivex.disposables.b) ZeusTransformUtils.preCheckCast(getAndSet(DisposableHelper.DISPOSED), io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
            if (r0 == DisposableHelper.DISPOSED) goto L22;
            this.downstream.onError(r4);     // Catch: Throwable -> L13
            if (r0 == null) goto L21;
            r0.dispose();
            return true;
        L21:
            return true;
        L13:
            th = move-exception;
            if (r0 == null) goto L16;
            r0.dispose();
        L16:
            throw th;
        L22:
            return false;
        L17:
            return false;
        }
    }

    @Override // io.reactivex.k
    public void b(m<? super T> r3) {
        m r4 = (m) ZeusTransformUtils.wrapperContextForParams(r3, m.class, "com.obric.memorydata.plugin");
        Emitter r0 = new Emitter(r4);
        r4.onSubscribe(r0);
        this.f16820a.a(r0);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        r0.onError(th);
    }
}
