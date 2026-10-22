package kotlinx.coroutines.sync;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.i2;
import kotlinx.coroutines.internal.s;
import kotlinx.coroutines.j;
import kotlinx.coroutines.l;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements j, i2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f19008a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f19009b;

    public b(d r5, l r10) {
        this.f19009b = r5;
        this.f19008a = r10;
    }

    @Override // kotlinx.coroutines.i2
    public final void a(s r5, int r10) {
        this.f19008a.a(r5, r10);
    }

    @Override // kotlinx.coroutines.j
    public final g8.g c(Object r5, Function3 r10) {
        d r11 = this.f19009b;
        kotlinx.coroutines.channels.c r12 = new kotlinx.coroutines.channels.c(1, r11, this);
        l r13 = this.f19008a;
        g8.g r14 = r13.H((Unit) r5, r12);
        if (r14 == null) goto L5;
        d.g.set(r11, null);
    L5:
        return r14;
    }

    @Override // kotlinx.coroutines.j
    public final boolean cancel(Throwable r5) {
        return this.f19008a.cancel(r5);
    }

    @Override // kotlinx.coroutines.j
    public final void e(Object r5, Function1 r10) {
        l r11 = this.f19008a;
        r11.e((Unit) r5, null);
    }

    @Override // kotlin.coroutines.Continuation
    public final CoroutineContext getContext() {
        return this.f19008a.e;
    }

    @Override // kotlinx.coroutines.j
    public final boolean isActive() {
        return this.f19008a.isActive();
    }

    @Override // kotlinx.coroutines.j
    public final void k(Object r5, Function3 r10) {
        AtomicReferenceFieldUpdater r11 = d.g;
        d r12 = this.f19009b;
        r11.set(r12, null);
        com.bytedance.ai.model.widgets.d r13 = new com.bytedance.ai.model.widgets.d(10, r12, this);
        l r14 = this.f19008a;
        r14.e((Unit) r5, r13);
    }

    @Override // kotlin.coroutines.Continuation
    public final void resumeWith(Object r5) {
        this.f19008a.resumeWith(r5);
    }

    @Override // kotlinx.coroutines.j
    public final void s(Object r5) {
        this.f19008a.s(r5);
    }
}
