package io.reactivex.internal.operators.completable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.a;
import io.reactivex.b.f;
import io.reactivex.c;
import io.reactivex.d;
import io.reactivex.disposables.b;
import io.reactivex.internal.disposables.CancellableDisposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class CompletableCreate extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final d f16733a;

    static final class Emitter extends AtomicReference<b> implements io.reactivex.b, b {
        private static final long serialVersionUID = -2467358622224974244L;
        final c downstream;

        Emitter(c r3) {
            this.downstream = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed((b) ZeusTransformUtils.preCheckCast(get(), b.class, "com.obric.memorydata.plugin"));
        }

        public void onComplete() {
            if (get() == DisposableHelper.DISPOSED) goto L13;
            b r0 = (b) ZeusTransformUtils.preCheckCast(getAndSet(DisposableHelper.DISPOSED), b.class, "com.obric.memorydata.plugin");
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

        public void setCancellable(f r3) {
            setDisposable(new CancellableDisposable((f) ZeusTransformUtils.wrapperContextForParams(r3, f.class, "com.obric.memorydata.plugin")));
        }

        public void setDisposable(b r3) {
            DisposableHelper.set(this, (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin"));
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
            b r0 = (b) ZeusTransformUtils.preCheckCast(getAndSet(DisposableHelper.DISPOSED), b.class, "com.obric.memorydata.plugin");
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

    @Override // io.reactivex.a
    public void b(c r3) {
        c r4 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
        Emitter r0 = new Emitter(r4);
        r4.onSubscribe(r0);
        this.f16733a.a(r0);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        r0.onError(th);
    }
}
