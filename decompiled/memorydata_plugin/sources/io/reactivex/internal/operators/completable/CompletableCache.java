package io.reactivex.internal.operators.completable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.a;
import io.reactivex.c;
import io.reactivex.disposables.b;
import io.reactivex.e;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class CompletableCache extends a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final InnerCompletableCache[] f16727a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final InnerCompletableCache[] f16728b = null;
    final e c;
    final AtomicReference<InnerCompletableCache[]> d;
    final AtomicBoolean e;
    Throwable f;

    final class InnerCompletableCache extends AtomicBoolean implements b {
        private static final long serialVersionUID = 8943152917179642732L;
        final c downstream;
        final /* synthetic */ CompletableCache this$0;

        InnerCompletableCache(CompletableCache r3, c r4) {
            c r5 = (c) ZeusTransformUtils.wrapperContextForParams(r4, c.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            this.downstream = r5;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (compareAndSet(false, true) == false) goto L6;
            this.this$0.b(this);
            return;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return get();
        }
    }

    static {
        f16727a = new InnerCompletableCache[0];
        f16728b = new InnerCompletableCache[0];
    }

    boolean a(InnerCompletableCache r5) {
    L2:
        InnerCompletableCache[] r0 = (InnerCompletableCache[]) ZeusTransformUtils.preCheckCast(this.d.get(), InnerCompletableCache[].class, "com.obric.memorydata.plugin");
        if (r0 == f16728b) goto L4;
        int r1 = r0.length;
        InnerCompletableCache[] r3 = new InnerCompletableCache[r1 + 1];
        System.arraycopy(r0, 0, r3, 0, r1);
        r3[r1] = r5;
        if (this.d.compareAndSet(r0, r3) == false) goto L2;
        return true;
    L4:
        return false;
    }

    @Override // io.reactivex.a
    public void b(c r3) {
        c r4 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
        InnerCompletableCache r0 = new InnerCompletableCache(this, r4);
        r4.onSubscribe(r0);
        if (a(r0) == true) goto L5;
        Throwable r2 = this.f;
        if (r2 == null) goto L13;
        r4.onError(r2);
        return;
    L13:
        r4.onComplete();
        return;
    L5:
        if (r0.isDisposed() == false) goto L8;
        b(r0);
    L8:
        if (this.e.compareAndSet(false, true) == false) goto L15;
        this.c.a(this);
        return;
    }

    void b(InnerCompletableCache r7) {
    L2:
        InnerCompletableCache[] r0 = (InnerCompletableCache[]) ZeusTransformUtils.preCheckCast(this.d.get(), InnerCompletableCache[].class, "com.obric.memorydata.plugin");
        int r1 = r0.length;
        if (r1 == 0) goto L4;
        int r2 = -1;
        int r4 = 0;
    L6:
        if (r4 >= r1) goto L11;
        if (r0[r4] == r7) goto L9;
        r4 = r4 + 1;
        goto L6
    L9:
        r2 = r4;
    L11:
        if (r2 < 0) goto L12;
        if (r1 != 1) goto L16;
        InnerCompletableCache[] r3 = f16727a;
    L18:
        if (this.d.compareAndSet(r0, r3) == false) goto L2;
        return;
    L16:
        InnerCompletableCache[] r5 = new InnerCompletableCache[r1 - 1];
        System.arraycopy(r0, 0, r5, 0, r2);
        System.arraycopy(r0, r2 + 1, r5, r2, (r1 - r2) - 1);
        r3 = r5;
        goto L18
    L12:
        return;
    }

    @Override // io.reactivex.c
    public void onComplete() {
        InnerCompletableCache[] r4 = (InnerCompletableCache[]) ZeusTransformUtils.preCheckCast(this.d.getAndSet(f16728b), InnerCompletableCache[].class, "com.obric.memorydata.plugin");
        int r0 = r4.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        InnerCompletableCache r2 = r4[r1];
        if (r2.get() == true) goto L7;
        r2.downstream.onComplete();
    L7:
        r1 = r1 + 1;
        goto L3
    }

    @Override // io.reactivex.c
    public void onError(Throwable r5) {
        this.f = r5;
        InnerCompletableCache[] r4 = (InnerCompletableCache[]) ZeusTransformUtils.preCheckCast(this.d.getAndSet(f16728b), InnerCompletableCache[].class, "com.obric.memorydata.plugin");
        int r0 = r4.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        InnerCompletableCache r2 = r4[r1];
        if (r2.get() == true) goto L7;
        r2.downstream.onError(r5);
    L7:
        r1 = r1 + 1;
        goto L3
    }

    @Override // io.reactivex.c
    public void onSubscribe(b r2) {
        b r1 = (b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.memorydata.plugin");
    }
}
