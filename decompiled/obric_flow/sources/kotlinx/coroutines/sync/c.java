package kotlinx.coroutines.sync;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.internal.s;
import kotlinx.coroutines.t0;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements kotlinx.coroutines.selects.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final kotlinx.coroutines.selects.h f19010a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f19011b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ d f19012c;

    public c(d r5, kotlinx.coroutines.selects.h r10, Object r11) {
        this.f19012c = r5;
        this.f19010a = r10;
        this.f19011b = r11;
    }

    @Override // kotlinx.coroutines.i2
    public final void a(s r5, int r10) {
        this.f19010a.a(r5, r10);
    }

    @Override // kotlinx.coroutines.selects.g
    public final void c(Object r5) {
        AtomicReferenceFieldUpdater r10 = d.g;
        Object r11 = this.f19011b;
        r10.set(this.f19012c, r11);
        this.f19010a.c(r5);
    }

    @Override // kotlinx.coroutines.selects.g
    public final void d(t0 r5) {
        this.f19010a.d(r5);
    }

    @Override // kotlinx.coroutines.selects.g
    public final boolean e(Object r5, Object r10) {
        boolean r11 = this.f19010a.e(r5, r10);
        if (r11 == false) goto L5;
        AtomicReferenceFieldUpdater r12 = d.g;
        Object r13 = this.f19011b;
        r12.set(this.f19012c, r13);
    L5:
        return r11;
    }

    @Override // kotlinx.coroutines.selects.g
    public final CoroutineContext getContext() {
        return this.f19010a.getContext();
    }
}
