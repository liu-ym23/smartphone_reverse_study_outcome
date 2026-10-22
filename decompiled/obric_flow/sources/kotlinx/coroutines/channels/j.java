package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.JobCancellationException;
import kotlinx.coroutines.r1;

/* JADX INFO: loaded from: classes3.dex */
public abstract class j extends kotlinx.coroutines.a implements i {
    public final f d;

    public j(CoroutineContext r5, f r10) {
        super(r5, true);
        this.d = r10;
    }

    @Override // kotlinx.coroutines.channels.w
    public final Object a(ContinuationImpl r5) {
        f r10 = this.d;
        r10.getClass();
        Object r11 = f.G(r10, r5);
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return r11;
    }

    @Override // kotlinx.coroutines.r1, kotlinx.coroutines.Job, kotlinx.coroutines.channels.w
    public final void cancel(CancellationException r5) {
        if (isCancelled() == false) goto L5;
        return;
    L5:
        if (r5 != null) goto L7;
        r5 = new JobCancellationException(z(), null, this);
    L7:
        x(r5);
    }

    @Override // kotlinx.coroutines.channels.x
    public final void f(Function1 r5) {
        this.d.f(r5);
    }

    @Override // kotlinx.coroutines.channels.x
    public final Object g(Object r5) {
        return this.d.g(r5);
    }

    @Override // kotlinx.coroutines.channels.w
    public final com.bytedance.ies.web.jsbridge2.p h() {
        return this.d.h();
    }

    @Override // kotlinx.coroutines.channels.w
    public final com.bytedance.ies.web.jsbridge2.p i() {
        return this.d.i();
    }

    @Override // kotlinx.coroutines.channels.w
    public final k iterator() {
        f r5 = this.d;
        r5.getClass();
        return new e(r5);
    }

    @Override // kotlinx.coroutines.channels.w
    public final Object j() {
        return this.d.j();
    }

    @Override // kotlinx.coroutines.channels.w
    public final Object l(Continuation r5) {
        return this.d.l(r5);
    }

    @Override // kotlinx.coroutines.channels.x
    public final boolean o(Throwable r5) {
        return this.d.n(false, r5);
    }

    @Override // kotlinx.coroutines.channels.x
    public final Object r(Object r5, Continuation r10) {
        return this.d.r(r5, r10);
    }

    @Override // kotlinx.coroutines.r1
    public final void x(CancellationException r5) {
        CancellationException r10 = r1.Y(this, r5);
        this.d.n(true, r10);
        w(r10);
    }

    @Override // kotlinx.coroutines.r1, kotlinx.coroutines.Job
    public final /* synthetic */ void cancel() {
        x(new JobCancellationException(z(), null, this));
    }

    @Override // kotlinx.coroutines.r1, kotlinx.coroutines.Job
    public final /* synthetic */ boolean cancel(Throwable r5) {
        x(new JobCancellationException(z(), null, this));
        return true;
    }
}
