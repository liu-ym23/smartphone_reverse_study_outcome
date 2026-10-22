package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;

/* JADX INFO: loaded from: classes3.dex */
public final class e2 implements p2, g, kotlinx.coroutines.flow.internal.r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d2 f18843a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Job f18844b;

    public e2(d2 r5, Job r10) {
        this.f18843a = r5;
        this.f18844b = r10;
    }

    @Override // kotlinx.coroutines.flow.internal.r
    public final g b(CoroutineContext r5, int r10, BufferOverflow r11) {
        if (r10 < 0) goto L7;
        if (r10 >= 2) goto L7;
    L9:
        if (r11 == BufferOverflow.DROP_OLDEST) goto L19;
    L11:
        if (r10 == 0) goto L15;
        if (r10 == (-3)) goto L15;
    L18:
        return new kotlinx.coroutines.flow.internal.g(this, r5, r10, r11);
    L15:
        if (r11 != BufferOverflow.SUSPEND) goto L18;
        return this;
    L19:
        return this;
    L7:
        if (r10 != (-2)) goto L11;
        goto L11
    }

    @Override // kotlinx.coroutines.flow.g
    public final Object collect(h r5, Continuation r10) {
        return ((q2) this.f18843a).collect(r5, r10);
    }

    @Override // kotlinx.coroutines.flow.p2
    public final Object getValue() {
        return ((q2) this.f18843a).getValue();
    }
}
