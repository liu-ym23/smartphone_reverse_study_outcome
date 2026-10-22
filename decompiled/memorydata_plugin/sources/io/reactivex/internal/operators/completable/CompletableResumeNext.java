package io.reactivex.internal.operators.completable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.a;
import io.reactivex.b.h;
import io.reactivex.c;
import io.reactivex.disposables.b;
import io.reactivex.e;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class CompletableResumeNext extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final e f16744a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h<? super Throwable, ? extends e> f16745b;

    static final class ResumeNextObserver extends AtomicReference<b> implements c, b {
        private static final long serialVersionUID = 5018523762564524046L;
        final c downstream;
        final h<? super Throwable, ? extends e> errorMapper;
        boolean once;

        ResumeNextObserver(c r3, h<? super Throwable, ? extends e> r4) {
            c r5 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
            h<? super Throwable, ? extends e> r6 = (h) ZeusTransformUtils.wrapperContextForParams(r4, h.class, "com.obric.memorydata.plugin");
            this.downstream = r5;
            this.errorMapper = r6;
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
            this.downstream.onComplete();
        }

        @Override // io.reactivex.c
        public void onError(Throwable r6) {
            if (this.once == false) goto L6;
            this.downstream.onError(r6);
            return;
        L6:
            this.once = true;
            ((e) ZeusTransformUtils.preCheckCast(io.reactivex.internal.functions.a.a(this.errorMapper.apply(r6), "The errorMapper returned a null CompletableSource"), e.class, "com.obric.memorydata.plugin")).a(this);
            return;
        L10:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            this.downstream.onError(new CompositeException(new Throwable[]{r6, th}));
        }

        @Override // io.reactivex.c
        public void onSubscribe(b r3) {
            DisposableHelper.replace(this, (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin"));
        }
    }

    @Override // io.reactivex.a
    public void b(c r3) {
        c r4 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
        ResumeNextObserver r0 = new ResumeNextObserver(r4, this.f16745b);
        r4.onSubscribe(r0);
        this.f16744a.a(r0);
    }
}
