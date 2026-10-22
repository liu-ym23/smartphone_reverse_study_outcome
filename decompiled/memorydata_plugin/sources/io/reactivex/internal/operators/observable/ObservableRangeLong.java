package io.reactivex.internal.operators.observable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.Observable;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import io.reactivex.t;

/* JADX INFO: loaded from: classes6.dex */
public final class ObservableRangeLong extends Observable<Long> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f16972a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f16973b;

    static final class RangeDisposable extends BasicIntQueueDisposable<Long> {
        private static final long serialVersionUID = 396518478098735504L;
        final t<? super Long> downstream;
        final long end;
        boolean fused;
        long index;

        RangeDisposable(t<? super Long> r3, long r4, long r6) {
            this.downstream = (t) ZeusTransformUtils.wrapperContextForParams(r3, t.class, "com.obric.memorydata.plugin");
            this.index = r4;
            this.end = r6;
        }

        @Override // io.reactivex.internal.a.f
        public void clear() {
            this.index = this.end;
            lazySet(1);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            set(1);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            if (get() == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // io.reactivex.internal.a.f
        public boolean isEmpty() {
            if (this.index != this.end) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // io.reactivex.internal.a.f
        public Long poll() {
            long r0 = this.index;
            if (r0 == this.end) goto L6;
            this.index = 1 + r0;
            return Long.valueOf(r0);
        L6:
            lazySet(1);
            return null;
        }

        @Override // io.reactivex.internal.a.f
        public /* bridge */ /* synthetic */ Object poll() {
            return poll();
        }

        @Override // io.reactivex.internal.a.c
        public int requestFusion(int r2) {
            if ((r2 & 1) == 0) goto L6;
            this.fused = true;
            return 1;
        L6:
            return 0;
        }

        void run() {
            if (this.fused == false) goto L5;
            return;
        L5:
            t<? super Long> r0 = this.downstream;
            long r1 = this.end;
            long r3 = this.index;
        L7:
            if (r3 == r1) goto L12;
            if (get() != 0) goto L12;
            r0.onNext(Long.valueOf(r3));
            r3 = r3 + 1;
        L12:
            if (get() != 0) goto L17;
            lazySet(1);
            r0.onComplete();
            return;
        }
    }

    @Override // io.reactivex.Observable
    public void a(t<? super Long> r8) {
        t r9 = (t) ZeusTransformUtils.wrapperContextForParams(r8, t.class, "com.obric.memorydata.plugin");
        long r2 = this.f16972a;
        RangeDisposable r6 = new RangeDisposable(r9, r2, r2 + this.f16973b);
        r9.onSubscribe(r6);
        r6.run();
    }
}
