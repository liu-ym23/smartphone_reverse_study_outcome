package io.reactivex.internal.operators.completable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.c;
import io.reactivex.disposables.b;
import io.reactivex.e;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class CompletableAndThenCompletable extends io.reactivex.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final e f16723a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final e f16724b;

    static final class SourceObserver extends AtomicReference<b> implements c, b {
        private static final long serialVersionUID = -4101678820158072998L;
        final c actualObserver;
        final e next;

        SourceObserver(c r3, e r4) {
            c r5 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
            e r6 = (e) ZeusTransformUtils.wrapperContextForParams(r4, e.class, "com.obric.memorydata.plugin");
            this.actualObserver = r5;
            this.next = r6;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed((b) ZeusTransformUtils.preCheckCast(get(), b.class, "com.obric.memorydata.plugin"));
        }

        @Override // io.reactivex.c
        public void onComplete() {
            this.next.a(new a(this, this.actualObserver));
        }

        @Override // io.reactivex.c
        public void onError(Throwable r1) {
            this.actualObserver.onError(r1);
        }

        @Override // io.reactivex.c
        public void onSubscribe(b r3) {
            if (DisposableHelper.setOnce(this, (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin")) == false) goto L6;
            this.actualObserver.onSubscribe(this);
            return;
        }
    }

    static final class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final AtomicReference<b> f16725a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final c f16726b;

        a(AtomicReference<b> r3, c r4) {
            c r5 = (c) ZeusTransformUtils.wrapperContextForParams(r4, c.class, "com.obric.memorydata.plugin");
            this.f16725a = r3;
            this.f16726b = r5;
        }

        @Override // io.reactivex.c
        public void onComplete() {
            this.f16726b.onComplete();
        }

        @Override // io.reactivex.c
        public void onError(Throwable r1) {
            this.f16726b.onError(r1);
        }

        @Override // io.reactivex.c
        public void onSubscribe(b r3) {
            b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin");
            DisposableHelper.replace(this.f16725a, r4);
        }
    }

    @Override // io.reactivex.a
    public void b(c r3) {
        c r4 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
        this.f16723a.a(new SourceObserver(r4, this.f16724b));
    }
}
