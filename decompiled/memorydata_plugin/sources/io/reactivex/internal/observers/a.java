package io.reactivex.internal.observers;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.t;

/* JADX INFO: loaded from: classes6.dex */
public abstract class a<T, R> implements io.reactivex.internal.a.b<R>, t<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final t<? super R> f16719a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected io.reactivex.disposables.b f16720b;
    protected io.reactivex.internal.a.b<T> c;
    protected boolean d;
    protected int e;

    public a(t<? super R> r3) {
        this.f16719a = (t) ZeusTransformUtils.wrapperContextForParams(r3, t.class, "com.obric.memorydata.plugin");
    }

    public final int a(int r3) {
        io.reactivex.internal.a.b<T> r0 = this.c;
        if (r0 != null) goto L5;
        return 0;
    L5:
        if ((r3 & 4) != 0) goto L12;
        int r4 = r0.requestFusion(r3);
        if (r4 == 0) goto L9;
        this.e = r4;
    L9:
        return r4;
    L12:
        return 0;
    }

    public final void a(Throwable r2) {
        io.reactivex.exceptions.a.a(r2);
        this.f16720b.dispose();
        onError(r2);
    }

    public boolean a() {
        return true;
    }

    public void b() {
    }

    @Override // io.reactivex.internal.a.f
    public void clear() {
        this.c.clear();
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        this.f16720b.dispose();
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this.f16720b.isDisposed();
    }

    @Override // io.reactivex.internal.a.f
    public boolean isEmpty() {
        return this.c.isEmpty();
    }

    @Override // io.reactivex.internal.a.f
    public final boolean offer(R r1) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // io.reactivex.t
    public void onComplete() {
        if (this.d == false) goto L5;
        return;
    L5:
        this.d = true;
        this.f16719a.onComplete();
    }

    @Override // io.reactivex.t
    public void onError(Throwable r2) {
        if (this.d == false) goto L6;
        io.reactivex.d.a.a(r2);
        return;
    L6:
        this.d = true;
        this.f16719a.onError(r2);
    }

    @Override // io.reactivex.t
    public final void onSubscribe(io.reactivex.disposables.b r3) {
        io.reactivex.disposables.b r4 = (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
        if (DisposableHelper.validate(this.f16720b, r4) == false) goto L11;
        this.f16720b = r4;
        if (ZeusTransformUtils.instanceOf(r4, io.reactivex.internal.a.b.class) == false) goto L8;
        this.c = (io.reactivex.internal.a.b) ZeusTransformUtils.preCheckCast(r4, io.reactivex.internal.a.b.class, "com.obric.memorydata.plugin");
    L8:
        if (a() == false) goto L12;
        this.f16719a.onSubscribe(this);
        b();
        return;
    L12:
        return;
    }
}
